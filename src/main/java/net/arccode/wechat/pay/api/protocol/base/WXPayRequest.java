package net.arccode.wechat.pay.api.protocol.base;

import java.util.Map;

/**
 * 请求接口
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public interface WXPayRequest<T extends WXPayResponse> {

    // TODO 添加基础字段

    /**
     * 使用何种http verb, 目前支持: GET和POST
     *
     * @return
     */
    String getHttpVerb();

    /**
     * 获取API请求地址
     *
     * @return API URL
     */
    public String getApiURL();

    /**
     * 获取所有的Key-Value形式的文本请求参数集合. 其中:
     * <ul>
     * <li>Key: 请求参数名</li>
     * <li>Value: 请求参数值</li>
     * </ul>
     *
     * @return 应用(业务)参数集合
     */
    public Map<String, String> getApplicationParams();


    /**
     * 得到当前API的响应结果类型
     *
     * @return
     */
    public Class<T> getResponseClass();

}
