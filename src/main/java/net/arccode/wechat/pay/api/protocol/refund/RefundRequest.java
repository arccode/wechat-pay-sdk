package net.arccode.wechat.pay.api.protocol.refund;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.util.ACHashMap;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;

import java.util.Map;

/**
 * 微信支付申请退款
 *
 * 详见: https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4&index=6
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class RefundRequest implements WXPayRequest<RefundResponse> {

    /**==================== 协议可选参数 ====================**/

    /**
     * 货币种类, 可空, 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String refundFeeType;

    /**==================== 协议应用参数 ====================**/

    /**
     * 设备号, 可空
     */
    private String deviceInfo;

    /**
     * 商户订单号, 不可空
     */
    private String outTradeNo;

    /**
     * 商户退款单号, 不可空
     */
    private String outRefundNo;

    /**
     * 总金额(分), 不可空
     */
    private Integer totalFee;

    /**
     * 退款金额(分), 不可空
     */
    private Integer refundFee;

    /**
     * 操作员, 不可空, 操作员帐号, 默认为商户号
     */
    private String opUserId;

    /**
     * 随机字符串, 不可空
     */
    private String nonceStr;

    public RefundRequest() {
    }

    public RefundRequest(String outTradeNo, String outRefundNo, Integer totalFee, Integer refundFee,
                         String opUserId, String nonceStr) {
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.totalFee = totalFee;
        this.refundFee = refundFee;
        this.opUserId = opUserId;
        this.nonceStr = nonceStr;
    }

    @Override
    public String getHttpVerb() {
        return WXPayConstants.HTTPS_POST_CA_REFUND;
    }

    @Override
    public String getApiURL() {
        return WXPayConstants.REFUND_API;
    }

    @Override
    public Map<String, String> getApplicationParams() {
        ACHashMap txtParams = new ACHashMap();
        txtParams.put("device_info", this.deviceInfo);
        txtParams.put("out_trade_no", this.outTradeNo);
        txtParams.put("out_refund_no", this.outRefundNo);
        txtParams.put("total_fee", this.totalFee);
        txtParams.put("refund_fee", this.refundFee);
        txtParams.put("op_user_id", this.opUserId);
        txtParams.put("nonce_str", this.nonceStr);

        return txtParams;
    }

    @Override
    public Class<RefundResponse> getResponseClass() {
        return RefundResponse.class;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
