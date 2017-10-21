package net.arccode.wechat.pay.api.common.constant;

/**
 * 微信常量
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class WXPayConstants {

    /**==================== 基础常量 ====================**/

    public static final String SDK_VERSION = "wx-sdk-0_0_1";

    public static final String APP_ID = "appid";
    public static final String MCH_ID = "mch_id";

    // 针对商户支付
    public static final String MCH_PAY_APPID = "mch_appid";
    public static final String MCH_PAY_ID = "mchid";

    public static final String NONCE_STR = "nonce_str";
    public static final String NOTIFY_URL = "notify_url";
    public static final String TRADE_TYPE = "trade_type";
    public static final String FEE_TYPE = "fee_type";
    public static final String LIMIT_PAY = "limit_pay";


    public static final String SIGN_TYPE = "sign_type";
    public static final String SIGN = "sign";
    public static final String CHARSET = "charset";
    public static final String CHARSET_UTF8 = "UTF-8";


    public static final String SIGN_TYPE_MD5 = "MD5";
    public static final String SIGN_TYPE_RSA = "RSA";

    /**
     * 响应格式 JSON
     */
    public static final String FORMAT_JSON      = "json";

    /**
     * 响应格式 XML
     */
    public static final String FORMAT_XML       = "xml";

    /**==================== 通用常量 ====================**/

    /**
     * 默认时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date默认时区
     */
    public static final String DATE_TIMEZONE    = "GMT+8";

    /**==================== 接口常量 ====================**/

    /**
     * 统一下单接口
     */
    public static final String UNIFIED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 退款
     */
    public static final String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    /**
     * 商户支付接口
     */
    public static final String MCH_PAY_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    /**==================== 商户常量 ====================**/



    /**
     *  http get
     */
    public static final String HTTP_GET = "GET";

    /**
     *  http post
     */
    public static final String HTTP_POST = "POST";

    /**
     *  https post 带证书, 服务于商户支付
     */
    public static final String HTTPS_POST_CA_MCH_PAY = "POST_CA_FOR_MCH_PAY";

    /**
     *  https post 带证书, 服务于客户退款
     */
    public static final String HTTPS_POST_CA_REFUND = "POST_CA_FOR_REFUND";


}
