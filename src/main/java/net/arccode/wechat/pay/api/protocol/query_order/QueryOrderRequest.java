package net.arccode.wechat.pay.api.protocol.query_order;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.util.ACHashMap;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;

import java.util.Map;

/**
 * 查询订单详情
 * <p/>
 * <p/>
 * 详见: https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_2&index=4
 *
 * @author http://arccode.net
 * @since 2018-04-22
 */
public class QueryOrderRequest implements WXPayRequest<QueryOrderResponse> {

    /**==================== 协议应用参数 ====================**/

    /**
     * 微信订单号
     * 必选: 否, 但需要与商户订单号二选一
     * String(32)	1009660380201506130728806387	微信的订单号，优先使用
     */
    private String transactionId;
    /**
     * 商户订单号
     * 必选: 否, 但需要与微信订单号二选一
     * String(32)	20150806125346	商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    private String outTradeNo;

    /**
     * 随机字符串	必填: 是
     * <p/>
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS	String(32)	随机字符串，不长于32位
     */
    private String nonceStr;

    public QueryOrderRequest() {
    }

    public QueryOrderRequest(String transactionId, String outTradeNo, String nonceStr) {
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.nonceStr = nonceStr;
    }

    @Override
    public String getHttpVerb() {
        return WXPayConstants.HTTP_POST;
    }

    @Override
    public String getApiURL() {
        return WXPayConstants.QUERY_ORDER;
    }

    @Override
    public Map<String, String> getApplicationParams() {
        ACHashMap txtParams = new ACHashMap();
        txtParams.put("transaction_id", this.transactionId);
        txtParams.put("out_trade_no", this.outTradeNo);
        txtParams.put("nonce_str", this.nonceStr);
        return txtParams;
    }

    @Override
    public Class<QueryOrderResponse> getResponseClass() {
        return QueryOrderResponse.class;
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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
