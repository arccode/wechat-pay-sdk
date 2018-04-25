package net.arccode.wechat.pay.api.protocol.mch_pay;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.util.ACHashMap;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;

import java.util.Map;

/**
 * 商户支付API
 * <p/>
 * 详见: https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
 *
 * @author http://arccode.net
 * @since 2015-12-03
 */
public class MchPayRequest implements WXPayRequest<MchPayResponse> {

    /**==================== 协议可选参数 ====================**/


    /**==================== 协议应用参数 ====================**/

    /**
     * 设备号	必填: 否
     * <p/>
     * 013467007045764	String(32)	微信支付分配的终端设备号
     */
    private String deviceInfo;

    /**
     * 商户订单号	必填: 是
     * <p/>
     * 10000098201411111234567890	String	商户订单号，需保持唯一性
     */
    private String partnerTradeNo;

    /**
     * 用户openid	必填: 是
     * <p/>
     * oxTWIuGaIt6gTKsQRLau2M0yL16E	String	商户appid下，某用户的openid
     */
    private String openId;

    /**
     * 校验用户姓名选项	必填: 是
     * <p/>
     * String
     * <p/>
     * NO_CHECK：不校验真实姓名
     * FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
     * OPTION_CHECK：针对已实名认证的用户才校验真实姓名(未实名认证用户不校验，可以转账成功)
     */
    private String checkName;

    /**
     * 收款用户姓名 必填: 否
     * <p/>
     * 马花花	String	收款用户真实姓名。
     */
    private String reUserName;

    /**
     * 企业付款金额
     * 必填: 是
     * 企业付款金额，单位为分
     */
    private Integer amount;

    /**
     * 企业付款描述信息	必填: 是
     * <p/>
     * 理赔	String	企业付款操作说明信息.
     */
    private String desc;

    /**
     * Ip地址	必填: 是
     * <p/>
     * 192.168.0.1	String(32)	调用接口的机器Ip地址
     */
    private String spBillCreateIp;

    /**
     * 随机字符串	必填: 是
     * <p/>
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS	String(32)	随机字符串，不长于32位
     */
    private String nonceStr;

    public MchPayRequest() {
    }

    public MchPayRequest(String partnerTradeNo, String openId, String checkName, Integer amount,
                         String desc, String spBillCreateIp, String nonceStr) {
        this.partnerTradeNo = partnerTradeNo;
        this.openId = openId;
        this.checkName = checkName;
        this.amount = amount;
        this.desc = desc;
        this.spBillCreateIp = spBillCreateIp;
        this.nonceStr = nonceStr;
    }

    @Override
    public String getHttpVerb() {
        return WXPayConstants.HTTPS_POST_CA_MCH_PAY;
    }

    @Override
    public String getApiURL() {
        return WXPayConstants.MCH_PAY_API;
    }

    @Override
    public Map<String, String> getApplicationParams() {
        ACHashMap txtParams = new ACHashMap();
        txtParams.put("device_info", this.deviceInfo);
        txtParams.put("partner_trade_no", this.partnerTradeNo);
        txtParams.put("openid", this.openId);
        txtParams.put("check_name", this.checkName);
        txtParams.put("re_user_name", this.reUserName);
        txtParams.put("amount", this.amount);
        txtParams.put("desc", this.desc);
        txtParams.put("spbill_create_ip", this.spBillCreateIp);
        txtParams.put("nonce_str", this.nonceStr);

        return txtParams;
    }

    @Override
    public Class<MchPayResponse> getResponseClass() {
        return MchPayResponse.class;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getReUserName() {
        return reUserName;
    }

    public void setReUserName(String reUserName) {
        this.reUserName = reUserName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpBillCreateIp() {
        return spBillCreateIp;
    }

    public void setSpBillCreateIp(String spBillCreateIp) {
        this.spBillCreateIp = spBillCreateIp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
