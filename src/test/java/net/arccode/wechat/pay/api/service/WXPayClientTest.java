package net.arccode.wechat.pay.api.service;

import com.alibaba.fastjson.JSON;
import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.protocol.mch_pay.MchPayResponse;
import net.arccode.wechat.pay.api.protocol.pay_notify.PayNotifyResponse;
import net.arccode.wechat.pay.api.common.util.SDKUtils;
import net.arccode.wechat.pay.api.protocol.mch_pay.MchPayRequest;
import net.arccode.wechat.pay.api.protocol.query_order.QueryOrderRequest;
import net.arccode.wechat.pay.api.protocol.query_order.QueryOrderResponse;
import net.arccode.wechat.pay.api.protocol.refund.RefundRequest;
import net.arccode.wechat.pay.api.protocol.refund.RefundResponse;
import net.arccode.wechat.pay.api.protocol.unified_order.UnifiedOrderRequest;
import net.arccode.wechat.pay.api.protocol.unified_order.UnifiedOrderResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信客户端测试类
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class WXPayClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(WXPayClientTest.class);

    private WXPayClient wxPayClient;

    private WXPayClient wxPayVIPClient;

    private String asyncNotifyUrl = "http://domain:port/path";

    @Before
    public void before() {

        // 以下配置参数根据公司申请的微信支付帐号填写
        String appId = "";
        String mchId = "";
        String key = "";
        String certPwd = "";
        // 绝对路径, 用于退款和商户支付
        String certPath = "";

        wxPayClient = new WXPayClient(appId, mchId, key);
        wxPayVIPClient = new WXPayClient(appId, mchId, key, certPwd, certPath);
    }

    /**
     * 扫码支付下单
     */
    @Test
    public void scanPay() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);
        UnifiedOrderRequest request = new UnifiedOrderRequest("commodity-899", SDKUtils
                .genOutTradeNo(),
                1, "192.168.1.1", asyncNotifyUrl, "NATIVE", nonceStr);

        UnifiedOrderResponse response = wxPayClient.execute(request);

        LOG.info(JSON.toJSONString(response));

    }

    /**
     * 公众号支付下单
     */
    @Test
    public void jsApiPay() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);
        UnifiedOrderRequest request = new UnifiedOrderRequest("commodity-899", SDKUtils
                .genOutTradeNo(),
                1, "192.168.1.1", asyncNotifyUrl, "JSAPI", nonceStr);
        request.setOpenId("oKVmeuHht8J0Ni58CSNe474AHA3E");
        UnifiedOrderResponse response = wxPayClient.execute(request);

        LOG.info(JSON.toJSONString(response));

    }

    /**
     * APP支付下单
     */
    @Test
    public void appPay() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);
        UnifiedOrderRequest request = new UnifiedOrderRequest("commodity-899", SDKUtils
                .genOutTradeNo(),
                1, "192.168.1.1", asyncNotifyUrl, "APP", nonceStr);

        UnifiedOrderResponse response = wxPayClient.execute(request);

        LOG.info(JSON.toJSONString(response));

    }


    /**
     * 退款
     */
    @Test
    public void refund() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);
        RefundRequest request = new RefundRequest("T15121416014891124211768",
                SDKUtils.genOutRefundNo(), 1, 1, "112102020", nonceStr);

        RefundResponse response = wxPayVIPClient.execute(request);
        Assert.assertNotNull(response);

        LOG.info(JSON.toJSONString(response));

    }


    /**
     * 商户支付
     */
    @Test
    public void mchPay() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);

        String customerOpenId = "oKVmeuHht8J0Ni58CSNe474AHA3E";
        MchPayRequest mchPayRequest = new MchPayRequest(SDKUtils.genOutTradeNo(),
                customerOpenId, "NO_CHECK", 100, "xxxx年xx月结算", "192.168.1.1", nonceStr);

        MchPayResponse response = wxPayVIPClient.execute(mchPayRequest);
        Assert.assertNotNull(response);

        LOG.info(JSON.toJSONString(response));

    }

    /**
     * 查询订单详情
     */
    @Test
    public void queryOrder() throws WXPayApiException {

        String nonceStr = SDKUtils.genRandomStringByLength(32);
        QueryOrderRequest request = new QueryOrderRequest(null, "T18042215145391412971763",
                nonceStr);

        QueryOrderResponse response = wxPayClient.execute(request);

        LOG.info(JSON.toJSONString(response));

    }

    /**
     * 解析支付通知内容
     */
    @Test
    public void notifyTxtParse() throws WXPayApiException {
        String notifyTxt = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370eccdcd]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";


        PayNotifyResponse response = wxPayClient.parseNotify(notifyTxt, PayNotifyResponse.class);


        LOG.info(JSON.toJSONString(response));

    }


}
