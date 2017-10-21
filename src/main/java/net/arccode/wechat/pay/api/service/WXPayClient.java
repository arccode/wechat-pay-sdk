package net.arccode.wechat.pay.api.service;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.common.log.ACLogger;
import net.arccode.wechat.pay.api.common.parser.xml.ObjectXmlParser;
import net.arccode.wechat.pay.api.common.util.*;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;
import net.arccode.wechat.pay.api.common.parser.WXPayParser;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;
import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class WXPayClient implements IWXPayClient {

    private static final Logger LOG = LoggerFactory.getLogger(WXPayClient.class);

    /**
     * 公众号appId
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 签名key
     */
    private String key;

    /**
     * 针对高级接口需要加载证书, 证书密码
     */
    private String certPwd;

    /**
     * 针对高级接口需要加载证书, 证书路径
     */
    private String certPath;

    /**
     * 签名类型
     */
    private String signType = WXPayConstants.SIGN_TYPE_MD5;

    /**
     * 响应格式
     */
    private String format = WXPayConstants.FORMAT_XML;

    /**
     * 签名字符集
     */
    private String charset = WXPayConstants.CHARSET_UTF8;

    /**
     * media type json
     */
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");

    /**
     * media type text
     */
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain;charset=utf-8");


    public WXPayClient(String appId, String mchId, String key) {
        this.appId = appId;
        this.mchId = mchId;
        this.key = key;
    }

    public WXPayClient(String appId, String mchId, String key, String certPwd, String certPath) {
        this.appId = appId;
        this.mchId = mchId;
        this.key = key;
        this.certPwd = certPwd;
        this.certPath = certPath;
    }

    @Override
    public <T extends WXPayResponse> T execute(WXPayRequest<T> request) throws WXPayApiException {

        WXPayParser<T> parser = null;
        if (WXPayConstants.FORMAT_XML.equals(this.format)) {
            parser = new ObjectXmlParser<T>(request.getResponseClass());
        }

        return _execute(request, parser);
    }

    @Override
    public <T extends WXPayResponse> T parseNotify(String notifyData, Class<T> clazz) throws WXPayApiException {
        WXPayParser<T> parser = new ObjectXmlParser<T>(clazz);

        T tResp = null;
        try {
            tResp = parser.parse(notifyData);
        } catch (WXPayApiException e) {
            ACLogger.logBizError(notifyData);
            throw new WXPayApiException(e);
        }

        tResp.setBody(notifyData);

        return tResp;
    }

    /**
     * 解析返回内容
     *
     * @param request
     * @param parser
     * @param <T>
     * @return
     */
    private <T extends WXPayResponse> T _execute(WXPayRequest<T> request, WXPayParser<T> parser) throws WXPayApiException {

        Map<String, Object> result = new HashMap<String, Object>();
        if (WXPayConstants.HTTP_POST.equalsIgnoreCase(request.getHttpVerb())) {
            result = doPost(request);
        } else if (WXPayConstants.HTTPS_POST_CA_MCH_PAY.equalsIgnoreCase(request.getHttpVerb())) {
            result = doHTTPSPostMchPay(request);
        } else if (WXPayConstants.HTTPS_POST_CA_REFUND.equalsIgnoreCase(request.getHttpVerb())) {
            result = doHTTPSPostRefund(request);
        }

        T tResp = null;

        // TODO 针对部分接口进行签名校验

        try {
            tResp = parser.parse((String)result.get("resp"));
        } catch (WXPayApiException e) {
            ACLogger.logBizError((String) result.get("resp"));
            throw new WXPayApiException(e);
        }
        tResp.setBody((String)result.get("resp"));
        tResp.setParams((Map)result.get("params"));

        if (!tResp.isSuccess()) {
            ACLogger.logErrorScene(result, tResp, "");
        }


        return tResp;
    }

    /**
     * post 请求
     *
     * @param request
     * @param <T>
     * @return
     */
    private <T extends WXPayResponse> Map<String, Object> doPost(WXPayRequest<T> request) throws WXPayApiException {

        Map<String, Object> result = new HashMap<String, Object>();
        RequestParametersHolder requestParametersHolder = new RequestParametersHolder();

        // 应用参数
        ACHashMap appParams = new ACHashMap(request.getApplicationParams());
        requestParametersHolder.setApplicationParams(appParams);

        // 协议必选参数
        ACHashMap protocolMustParams = new ACHashMap();
        protocolMustParams.put(WXPayConstants.APP_ID, this.appId);
        protocolMustParams.put(WXPayConstants.MCH_ID, this.mchId);
        requestParametersHolder.setProtocalMustParams(protocolMustParams);

        // 协议可选参数
        ACHashMap protocolOptParams = new ACHashMap();
        requestParametersHolder.setProtocalOptParams(protocolOptParams);

        // 签名
        if (WXPayConstants.SIGN_TYPE_MD5.equals(this.signType)) {
            String signContent = WXPaySignUtils.getSignatureContent(requestParametersHolder);
            protocolMustParams.put(WXPayConstants.SIGN, WXPaySignUtils.md5Sign(signContent, key, charset).toUpperCase());
        }

        // 将应用参数 协议必选参数 协议可选参数合并, 转换为xml string
        ACHashMap requestParamsMap = new ACHashMap();
        requestParamsMap.putAll(appParams);
        requestParamsMap.putAll(protocolMustParams);
        requestParamsMap.putAll(protocolOptParams);

        String requestBoyStr = MapUtils.map2XmlString(requestParamsMap);

        // 发送http post
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_TEXT, requestBoyStr);
        Request httpRequest = new Request.Builder()
                .url(request.getApiURL())
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = HttpUtils.execute(httpRequest);
        } catch (IOException e) {
            throw new WXPayApiException(e);
        }

        if (response != null && response.isSuccessful()) {
            try {
                String resp = response.body().string();
                result.put("resp", resp);
            } catch (IOException e) {
                throw new WXPayApiException(e);
            }
        }

        result.put("params", requestParamsMap);
        result.put("protocolMustParams", protocolMustParams);
        result.put("protocolOptParams", protocolOptParams);
        result.put("url", request.getApiURL());

        return result;
    }


    /**
     * HTTPS POST 请求,带证书; 目前用于企业付款
     *
     * @param request
     * @param <T>
     * @return
     */
    private <T extends WXPayResponse> Map<String, Object> doHTTPSPostMchPay(WXPayRequest<T> request) throws WXPayApiException {

        Map<String, Object> result = new HashMap<String, Object>();
        RequestParametersHolder requestParametersHolder = new RequestParametersHolder();

        // 应用参数
        ACHashMap appParams = new ACHashMap(request.getApplicationParams());
        requestParametersHolder.setApplicationParams(appParams);

        // 协议必选参数
        ACHashMap protocolMustParams = new ACHashMap();
        protocolMustParams.put(WXPayConstants.MCH_PAY_APPID, this.appId);
        protocolMustParams.put(WXPayConstants.MCH_PAY_ID, this.mchId);
        protocolMustParams.put(WXPayConstants.NONCE_STR, SDKUtils.genRandomStringByLength(32));
        requestParametersHolder.setProtocalMustParams(protocolMustParams);

        // 协议可选参数
        ACHashMap protocolOptParams = new ACHashMap();
        requestParametersHolder.setProtocalOptParams(protocolOptParams);

        // 签名
        if (WXPayConstants.SIGN_TYPE_MD5.equals(this.signType)) {
            String signContent = WXPaySignUtils.getSignatureContent(requestParametersHolder);
            protocolMustParams.put(WXPayConstants.SIGN, WXPaySignUtils.md5Sign(signContent, key, charset));
        }

        // 将应用参数 协议必选参数 协议可选参数合并, 转换为xml string
        ACHashMap requestParamsMap = new ACHashMap();
        requestParamsMap.putAll(appParams);
        requestParamsMap.putAll(protocolMustParams);
        requestParamsMap.putAll(protocolOptParams);

        String requestBoyStr = MapUtils.map2XmlString(requestParamsMap);

        String response = null;
        try {
            response = HttpUtils.executeAttachCA(request.getApiURL(), requestBoyStr, this.certPwd, this.certPath);
        } catch (Exception e) {
            throw new WXPayApiException(e);
        }

        String resp = response;
        result.put("resp", resp);

        result.put("params", requestParamsMap);
        result.put("protocolMustParams", protocolMustParams);
        result.put("protocolOptParams", protocolOptParams);
        result.put("url", request.getApiURL());

        return result;
    }

    /**
     * HTTPS POST 请求,带证书; 目前用于客户退款
     *
     * @param request
     * @param <T>
     * @return
     */
    private <T extends WXPayResponse> Map<String, Object> doHTTPSPostRefund(WXPayRequest<T> request) throws WXPayApiException {

        Map<String, Object> result = new HashMap<String, Object>();
        RequestParametersHolder requestParametersHolder = new RequestParametersHolder();

        // 应用参数
        ACHashMap appParams = new ACHashMap(request.getApplicationParams());
        requestParametersHolder.setApplicationParams(appParams);

        // 协议必选参数
        ACHashMap protocolMustParams = new ACHashMap();
        protocolMustParams.put(WXPayConstants.APP_ID, this.appId);
        protocolMustParams.put(WXPayConstants.MCH_ID, this.mchId);
        protocolMustParams.put(WXPayConstants.NONCE_STR, SDKUtils.genRandomStringByLength(32));
        requestParametersHolder.setProtocalMustParams(protocolMustParams);

        // 协议可选参数
        ACHashMap protocolOptParams = new ACHashMap();
        requestParametersHolder.setProtocalOptParams(protocolOptParams);

        // 签名
        if (WXPayConstants.SIGN_TYPE_MD5.equals(this.signType)) {
            String signContent = WXPaySignUtils.getSignatureContent(requestParametersHolder);
            protocolMustParams.put(WXPayConstants.SIGN, WXPaySignUtils.md5Sign(signContent, key, charset));
        }

        // 将应用参数 协议必选参数 协议可选参数合并, 转换为xml string
        ACHashMap requestParamsMap = new ACHashMap();
        requestParamsMap.putAll(appParams);
        requestParamsMap.putAll(protocolMustParams);
        requestParamsMap.putAll(protocolOptParams);

        String requestBoyStr = MapUtils.map2XmlString(requestParamsMap);

        String response = null;
        try {
            response = HttpUtils.executeAttachCA(request.getApiURL(), requestBoyStr, this.certPwd, this.certPath);
        } catch (Exception e) {
            throw new WXPayApiException(e);
        }

        String resp = response;
        result.put("resp", resp);

        result.put("params", requestParamsMap);
        result.put("protocolMustParams", protocolMustParams);
        result.put("protocolOptParams", protocolOptParams);
        result.put("url", request.getApiURL());

        return result;
    }

    public String getAppId() {
        return appId;
    }

    public String getKey() {
        return key;
    }
}
