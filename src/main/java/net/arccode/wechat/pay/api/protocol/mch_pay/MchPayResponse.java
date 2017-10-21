package net.arccode.wechat.pay.api.protocol.mch_pay;

import net.arccode.wechat.pay.api.common.annotation.ApiField;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 扫码支付下单响应参数
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class MchPayResponse extends WXPayResponse {
    private static final long serialVersionUID = -2681586546776415340L;

    /**==================== 以下字段在return_code为SUCCESS的时候有返回 ====================**/

    /**商户appid	 mch_appid
     * 必选: 是
     *
     * wx8888888888888888	String	微信分配的公众账号ID（企业号corpid即为此appId）
     */
    @ApiField("mch_appid")
    private String mchAppId;

    /**
     * 商户号	mchid
     * 必选: 是
     *
     * 1900000109	String(32)	微信支付分配的商户号
     */
    @ApiField("mchid")
    private String mchId;

    /**
     * 设备号	device_info
     * 必选: 否
     *
     * 013467007045764	String(32)	微信支付分配的终端设备号，
     */
    @ApiField("device_info")
    private String deviceInfo;

    /**
     * 随机字符串	nonce_str
     * 必选: 是
     *
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS	String(32)	随机字符串，不长于32位
     */
    @ApiField("nonce_str")
    private String nonceStr;

    /**
     * 业务结果	result_code
     * 必选: 是
     *
     * SUCCESS	String(16)	SUCCESS/FAIL
     */
    @ApiField("result_code")
    private String resultCode;

    /**
     * 错误代码	err_code
     * 必选: 否
     *
     * SYSTEMERROR	String(32)	错误码信息
     */
    @ApiField("err_code")
    private String errCode;

    /**
     * 错误代码描述	err_code_des
     * 必选: 否
     *
     * 系统错误	String(128)	结果信息描述
     */
    @ApiField("err_code_des")
    private String errCodeDes;


    /**==================== 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ====================**/

    /**
     * 商户订单号	partner_trade_no
     * 必选: 是
     *
     * 1217752501201407033233368018	String(32)	商户订单号，需保持唯一性
     */
    @ApiField("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信订单号	payment_no
     * 必选: 是
     *
     * 1007752501201407033233368018	String	企业付款成功，返回的微信订单号
     */
    @ApiField("payment_no")
    private String paymentNo;

    /**
     * 微信支付成功时间	payment_time
     * 必选: 是
     *
     * 2015-05-19 15：26：59	String	企业付款成功时间
     */
    @ApiField("payment_time")
    private String paymentTime;

    public String getMchAppId() {
        return mchAppId;
    }

    public void setMchAppId(String mchAppId) {
        this.mchAppId = mchAppId;
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

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
