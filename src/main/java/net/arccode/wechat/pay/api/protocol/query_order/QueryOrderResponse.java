package net.arccode.wechat.pay.api.protocol.query_order;

import net.arccode.wechat.pay.api.common.annotation.ApiField;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 查询清单详情响应参数
 *
 * @author http://arccode.net
 * @since 2018-04-22
 */
public class QueryOrderResponse extends WXPayResponse {

    private static final long serialVersionUID = 8009307874140691769L;


    /**==================== 以下字段在return_code为SUCCESS的时候有返回 ====================**/


    /**
     * 应用APPID
     * 必填: 是	String(32)	wxd678efh567hg6787	微信开放平台审核通过的应用APPID
     */
    @ApiField("appid")
    private String appId;
    /**
     * 商户号
     * 必填: 是	String(32)	1230000109	微信支付分配的商户号
     */
    @ApiField("mch_id")
    private String mchId;
    /**
     * 随机字符串
     * 必填: 是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
     */
    @ApiField("nonce_str")
    private String nonceStr;
    /**
     * 签名
     * 必填: 是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名生成算法
     */
    @ApiField("sign")
    private String sign;
    /**
     * 业务结果
     * 必填: 是	String(16)	SUCCESS	SUCCESS/FAIL
     */
    @ApiField("result_code")
    private String resultCode;
    /**
     * 错误代码
     * 必填: 否	String(32)	SYSTEMERROR	错误码
     */
    @ApiField("err_code")
    private String errCode;
    /**
     * 错误代码描述
     * 必填: 否	String(128)	系统错误	结果信息描述
     */
    @ApiField("err_code_des")
    private String errCodeDes;


    /**==================== 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ====================**/

    /**
     * 设备号
     * 否	String(32)	013467007045764	微信支付分配的终端设备号，
     */
    @ApiField("device_info")
    private String deviceInfo;
    /**
     * 用户标识
     * 是	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	用户在商户appid下的唯一标识
     */
    @ApiField("openid")
    private String openId;
    /**
     * 是否关注公众账号
     * 否	String(1)	Y	用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    @ApiField("is_subscribe")
    private String isSubscribe;
    /**
     * 交易类型
     * 是	String(16)	APP	调用接口提交的交易类型
     */
    @ApiField("trade_type")
    private String tradeType;
    /**
     * 交易状态
     * 是	String(32)	SUCCESS
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVOKED—已撤销（刷卡支付）
     * USERPAYING--用户支付中
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    @ApiField("trade_state")
    private String tradeState;

    /**
     * 付款银行
     * 是	String(16)	CMC	银行类型，采用字符串类型的银行标识
     */
    @ApiField("bank_type")
    private String bankType;
    /**
     * 总金额
     * 是	Int	100	订单总金额，单位为分
     */
    @ApiField("total_fee")
    private Integer totalFee;
    /**
     * 货币种类
     * 否	String(8)	CNY	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @ApiField("fee_type")
    private String feeType;
    /**
     * 现金支付金额
     * 是	Int	100	现金支付金额订单现金支付金额，详见支付金额
     */
    @ApiField("cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型
     * 否	String(16)	CNY	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @ApiField("cash_fee_type")
    private String cashFeeType;
    /**
     * 应结订单金额
     * 否	Int	100	当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @ApiField("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 代金券金额
     * 否	Int	100	“代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额
     */
    @ApiField("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量
     * 否	Int	1	代金券或立减优惠使用数量
     */
    @ApiField("coupon_count")
    private Integer couponCount;
    /**
     * 代金券ID
     * 否	String(20)	10000 	代金券或立减优惠ID, $n为下标，从0开始编号
     */
    @ApiField("coupon_id_$n")
    private String couponIdN;
    /**
     * 代金券类型
     * 否	String	CASH
     * CASH--充值代金券
     * NO_CASH---非充值优惠券
     * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
     */
    @ApiField("coupon_type_$n")
    private String couponTypeN;
    /**
     * 单个代金券支付金额
     * 否	Int	100	单个代金券或立减优惠支付金额, $n为下标，从0开始编号
     */
    @ApiField("coupon_fee_$n")
    private Integer couponFeeN;
    /**
     * 微信支付订单号
     * 是	String(32)	1009660380201506130728806387	微信支付订单号
     */
    @ApiField("transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     * 是	String(32)	20150806125346	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @ApiField("out_trade_no")
    private String outTradeNo;
    /**
     * 附加数据
     * 否	String(128)	深圳分店	附加数据，原样返回
     */
    @ApiField("attach")
    private String attach;
    /**
     * 支付完成时间
     * 是	String(14)	20141030133525
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @ApiField("time_end")
    private String timeEnd;
    /**
     * 交易状态描述
     * 是	String(256)	支付失败，请重新下单支付	对当前查询订单状态的描述和下一步操作的指引
     */
    @ApiField("trade_state_desc")
    private String tradeStateDesc;

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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
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

    public Integer getCashFee() {
        return cashFee;
    }

    public void setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
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

    public String getCouponTypeN() {
        return couponTypeN;
    }

    public void setCouponTypeN(String couponTypeN) {
        this.couponTypeN = couponTypeN;
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

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }
}
