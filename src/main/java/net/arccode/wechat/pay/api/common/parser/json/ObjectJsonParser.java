package net.arccode.wechat.pay.api.common.parser.json;


import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.common.parser.Converter;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;
import net.arccode.wechat.pay.api.common.parser.WXPayParser;

/**
 * json对象解析器
 *
 * @author http://arccode.net
 * @since 2015-11-06
 */
public class ObjectJsonParser<T extends WXPayResponse> implements WXPayParser<T> {

    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String resp) throws WXPayApiException {
        Converter converter = new JsonConverter();
        return converter.toResponse(resp, clazz);
    }

    @Override
    public Class<T> getResponseClass() {
        return clazz;
    }
}
