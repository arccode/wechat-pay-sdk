package net.arccode.wechat.pay.api.protocol.unified_order;

import net.arccode.wechat.pay.api.common.annotation.ApiField;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 扫码支付下单响应参数
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class UnifiedOrderResponse extends WXPayResponse {
    private static final long serialVersionUID = -116106125361949648L;

    /**==================== 以下字段在return_code为SUCCESS的时候有返回 ====================**/

    /**
     * 公众号ID
     */
    @ApiField("appid")
    private String appId;

    /**
     * 商户号
     */
    @ApiField("mch_id")
    private String mchId;

    /**
     * 设备号
     */
    @ApiField("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     */
    @ApiField("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @ApiField("sign")
    private String sign;

    /**
     * 业务结果
     */
    @ApiField("result_code")
    private String resultCode;

    /**
     * 错误代码
     */
    @ApiField("err_code")
    private String errCode;

    /**
     * 错误代码描述
     */
    @ApiField("err_code_des")
    private String errCodeDes;

    /**==================== 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ====================**/

    /**
     * 交易类型
     */
    @ApiField("trade_type")
    private String tradeType;

    /**
     * 预支付交易会话标识
     */
    @ApiField("prepay_id")
    private String prepayId;

    /**
     * 二维码链接
     */
    @ApiField("code_url")
    private String codeUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
