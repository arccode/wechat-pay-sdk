package net.arccode.wechat.pay.api.common.parser;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * 动态格式转换器
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public interface Converter {

    /**
     * 响应字符串转响应对象类型
     *
     * @param resp
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends WXPayResponse> T toResponse(String resp, Class<T> clazz) throws WXPayApiException;

}
