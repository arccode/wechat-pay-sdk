package net.arccode.wechat.pay.api.protocol.unified_order;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.util.ACHashMap;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;

import java.util.Map;

/**
 * 统一下单入参, 适用于公众号支付(JSAPI)/扫码支付(NATIVE)/APP支付(APP)
 * <p/>
 * 详见: https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class UnifiedOrderRequest implements WXPayRequest<UnifiedOrderResponse> {

    /**==================== 协议可选参数 ====================**/

    /**
     * 货币类型, 可空, 默认为CNY
     */
    private String feeType;

    /**
     * 指定支付方式, 可空
     */
    private String limitPay;


    /**==================== 协议应用参数 ====================**/

    /**
     * 通知地址, 不可空
     */
    private String notifyUrl;

    /**
     * 交易类型, 不可空
     */
    private String tradeType;

    /**
     * 设备号, 可空
     */
    private String deviceInfo;

    /**
     * 商品描述, 不可空
     */
    private String body;

    /**
     * 商品详情, 可空
     */
    private String detail;

    /**
     * 附加数据, 可空
     */
    private String attach;

    /**
     * 商户订单号, 不可空
     */
    private String outTradeNo;

    /**
     * 总金额(分), 不可空
     */
    private Integer totalFee;

    /**
     * 终端IP, 不可空
     */
    private String spBillCreateIp;

    /**
     * 交易起始时间, 可空
     */
    private String timeStart;

    /**
     * 交易结束时间, 可空
     */
    private String timeExpire;

    /**
     * 商品标记, 可空
     */
    private String goodsTag;

    /**
     * 商品ID, 可空
     */
    private String productId;

    /**
     * 用户标识, 不可空
     */
    private String openId;

    /**
     * 随机字符串, 不可空
     */
    private String nonceStr;


    public UnifiedOrderRequest() {
    }

    public UnifiedOrderRequest(String body, String outTradeNo, Integer totalFee, String
            spBillCreateIp,
                               String notifyUrl, String tradeType, String nonceStr) {
        this.body = body;
        this.outTradeNo = outTradeNo;
        this.totalFee = totalFee;
        this.spBillCreateIp = spBillCreateIp;
        this.notifyUrl = notifyUrl;
        this.tradeType = tradeType;
        this.nonceStr = nonceStr;
    }

    @Override
    public String getHttpVerb() {
        return WXPayConstants.HTTP_POST;
    }

    @Override
    public String getApiURL() {
        return WXPayConstants.UNIFIED_ORDER_API;
    }

    @Override
    public Map<String, String> getApplicationParams() {
        ACHashMap txtParams = new ACHashMap();
        txtParams.put("device_info", this.deviceInfo);
        txtParams.put("body", this.body);
        txtParams.put("detail", this.detail);
        txtParams.put("attach", this.attach);
        txtParams.put("out_trade_no", this.outTradeNo);
        txtParams.put("total_fee", this.totalFee);
        txtParams.put("spbill_create_ip", this.spBillCreateIp);
        txtParams.put("time_start", this.timeStart);
        txtParams.put("time_expire", this.timeExpire);
        txtParams.put("goods_tag", this.goodsTag);
        txtParams.put("product_id", this.productId);
        txtParams.put("openid", this.openId);
        txtParams.put("notify_url", this.notifyUrl);
        txtParams.put("trade_type", this.tradeType);
        txtParams.put("nonce_str", this.nonceStr);

        return txtParams;
    }

    @Override
    public Class<UnifiedOrderResponse> getResponseClass() {
        return UnifiedOrderResponse.class;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpBillCreateIp() {
        return spBillCreateIp;
    }

    public void setSpBillCreateIp(String spBillCreateIp) {
        this.spBillCreateIp = spBillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
