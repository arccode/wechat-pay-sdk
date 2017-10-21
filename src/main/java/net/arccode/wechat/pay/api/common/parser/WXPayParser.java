package net.arccode.wechat.pay.api.common.parser;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 响应解释器接口; 响应格式可以是JSON, XML等等.
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public interface WXPayParser<T extends WXPayResponse> {

    /**
     * 把响应字段解析为对应的协议对象
     *
     * @param resp
     * @return
     */
    public T parse(String resp) throws WXPayApiException;

    /**
     * 获取响应类类型
     *
     * @return
     */
    public Class<T> getResponseClass();

}
