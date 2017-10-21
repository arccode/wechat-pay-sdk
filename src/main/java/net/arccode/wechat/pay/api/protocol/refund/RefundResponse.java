package net.arccode.wechat.pay.api.protocol.refund;

import net.arccode.wechat.pay.api.common.annotation.ApiField;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 微信支付退款响应参数
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class RefundResponse extends WXPayResponse {
    private static final long serialVersionUID = 6252751420895289657L;

    /**==================== 以下字段在return_code为SUCCESS的时候有返回 ====================**/

    /**
     * 业务结果
     * 必填: 是	String(16)	SUCCESS
     * SUCCESS/FAIL
     * SUCCESS退款申请接收成功，结果通过退款查询接口查询
     * FAIL 提交业务失败
     */
    @ApiField("result_code")
    private String resultCode;
    /**
     * 错误代码
     * 必填: 否	String(32)	SYSTEMERROR	列表详见第6节
     */
    @ApiField("err_code")
    private String errCode;
    /**
     * 错误代码描述
     * 必填: 否	String(128)	系统超时	结果信息描述
     */
    @ApiField("err_code_des")
    private String errCodeDes;
    /**
     * 公众账号ID
     * 必填: 是	String(32)	wx8888888888888888	微信分配的公众账号ID
     */
    @ApiField("appid")
    private String appId;
    /**
     * 商户号
     * 必填: 是	String(32)	1900000109	微信支付分配的商户号
     */
    @ApiField("mch_id")
    private String mchId;
    /**
     * 设备号
     * 必填: 否	String(32)	013467007045764	微信支付分配的终端设备号，与下单一致
     */
    @ApiField("device_info")
    private String deviceInfo;
    /**
     * 随机字符串
     * 必填: 是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位
     */
    @ApiField("nonce_str")
    private String nonceStr;
    /**
     * 签名
     * 必填: 是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	签名，详见签名算法
     */
    @ApiField("sign")
    private String sign;
    /**
     * 微信订单号
     * 必填: 是	String(28)	1217752501201407033233368018	微信订单号
     */
    @ApiField("transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     * 必填: 是	String(32)	1217752501201407033233368018	商户系统内部的订单号
     */
    @ApiField("out_trade_no")
    private String outTradeNo;
    /**
     * 商户退款单号
     * 必填: 是	String(32)	1217752501201407033233368018	商户退款单号
     */
    @ApiField("out_refund_no")
    private String outRefundNo;
    /**
     * 微信退款单号
     * 必填: 是	String(28)	1217752501201407033233368018	微信退款单号
     */
    @ApiField("refund_id")
    private String refundId;
    /**
     * 退款渠道
     * 必填: 否	String(16)	ORIGINAL—原路退款, BALANCE—退回到余额
     */
    @ApiField("refund_channel")
    private String refundChannel;

    /**
     * 退款金额
     * 必填: 是	Int	100	退款总金额,单位为分,可以做部分退款
     */
    @ApiField("refund_fee")
    private String refundFee;
    /**
     * 订单总金额
     * 必填: 是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
     */
    @ApiField("total_fee")
    private String totalFee;
    /**
     * 订单金额货币种类
     * 必填: 否	String(8)	CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @ApiField("fee_type")
    private String feeType;
    /**
     * 现金支付金额
     * 必填: 是	Int	100	现金支付金额，单位为分，只能为整数，详见支付金额
     */
    @ApiField("cash_fee")
    private String cashFee;
    /**
     * 现金退款金额
     * 必填: 否	Int	100	现金退款金额，单位为分，只能为整数，详见支付金额
     */
    @ApiField("cash_refund_fee")
    private String cashRefundFee;
    /**
     * 代金券或立减优惠退款金额
     * 必填: 否	Int	100	代金券或立减优惠退款金额=订单金额-现金退款金额，注意：立减优惠金额不会退回
     */
    @ApiField("coupon_refund_fee")
    private String couponRefundFee;
    /**
     * 代金券或立减优惠使用数量
     * 必填: 否	Int	1	代金券或立减优惠使用数量
     */
    @ApiField("coupon_refund_count")
    private String couponRefundCount;
    /**
     * 代金券或立减优惠ID
     * 否	String(20)	10000 	代金券或立减优惠ID
     */
    @ApiField("coupon_refund_id")
    private String couponRefundId;

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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
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

    public String getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(String cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

    public String getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(String couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }

    public String getCouponRefundCount() {
        return couponRefundCount;
    }

    public void setCouponRefundCount(String couponRefundCount) {
        this.couponRefundCount = couponRefundCount;
    }

    public String getCouponRefundId() {
        return couponRefundId;
    }

    public void setCouponRefundId(String couponRefundId) {
        this.couponRefundId = couponRefundId;
    }
}
