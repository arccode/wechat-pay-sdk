package net.arccode.wechat.pay.api.protocol.pay_notify;

import net.arccode.wechat.pay.api.common.annotation.ApiField;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 微信支付异步通知结果
 *
 * 文档详见: https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7
 *
 * @author http://arccode.net
 * @since 2015-11-11
 */
public class PayNotifyResponse extends WXPayResponse {
    private static final long serialVersionUID = 5980237292242838244L;

    /**==================== 以下字段在return_code为SUCCESS的时候有返回 ====================**/

    /**
     * 公众账号ID 不可空*
     */
    @ApiField("appid")
    private String appId;

    /**
     * 商户号 不可空*
     */
    @ApiField("mch_id")
    private String mchId;

    /**
     * 设备号 可空*
     */
    @ApiField("device_info")
    private String deviceInfo;

    /**
     * 随机字符串 不可空*
     */
    @ApiField("nonce_str")
    private String nonceStr;

    /**
     * 签名 不可空*
     */
    @ApiField("sign")
    private String sign;

    /**
     * 业务结果 不可空*
     */
    @ApiField("result_code")
    private String resultCode;

    /**
     * 错误代码 可空*
     */
    @ApiField("err_code")
    private String errCode;

    /**
     * 错误代码描述 可空*
     */
    @ApiField("err_code_des")
    private String errCodeDes;

    /**
     * 用户标识 不可空*
     */
    @ApiField("openid")
    private String openId;

    /**
     * 是否关注公众账号 可空*
     */
    @ApiField("is_subscrib")
    private String isSubscrib;
    /**
     * 交易类型 不可空*
     */
    @ApiField("trade_type")
    private String tradeType;

    /**
     * 付款银行 不可空*
     */
    @ApiField("bank_type")
    private String bankType;

    /**
     * 总金额 不可空*
     */
    @ApiField("total_fee")
    private Integer totalFee;
    /**
     * 货币种类 可空*
     */
    @ApiField("fee_type")
    private String feeType;

    /**
     * 现金支付金额 不可空*
     */
    @ApiField("cash_fee")
    private String cashFee;

    /**
     * 现金支付货币类型 可空*
     */
    @ApiField("cash_fee_type")
    private Integer cashFeeType;
    /**
     * 代金券或立减优惠金额 可空*
     */
    @ApiField("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券或立减优惠使用数量 可空*
     */
    @ApiField("coupon_count")
    private Integer couponCount;

    /**
     * 代金券或立减优惠ID 可空*
     */
    @ApiField("coupon_id_$n")
    private String couponIdN;

    /**
     * 单个代金券或立减优惠支付金额 可空*
     */
    @ApiField("coupon_fee_$n")
    private Integer couponFeeN;

    /**
     * 微信支付订单号 不可空*
     */
    @ApiField("transaction_id")
    private String transactionId;

    /**
     * 商户订单号 不可空*
     */
    @ApiField("out_trade_no")
    private String outTradeNo;

    /**
     * 商家数据包 可空*
     */
    @ApiField("attach")
    private String attach;

    /**
     * 支付完成时间 不可空*
     */
    @ApiField("time_end")
    private String timeEnd;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIsSubscrib() {
        return isSubscrib;
    }

    public void setIsSubscrib(String isSubscrib) {
        this.isSubscrib = isSubscrib;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public Integer getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(Integer cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public String getCouponIdN() {
        return couponIdN;
    }

    public void setCouponIdN(String couponIdN) {
        this.couponIdN = couponIdN;
    }

    public Integer getCouponFeeN() {
        return couponFeeN;
    }

    public void setCouponFeeN(Integer couponFeeN) {
        this.couponFeeN = couponFeeN;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public boolean isBizSuccess() {
        return "SUCCESS".equalsIgnoreCase(this.resultCode);
    }


}
