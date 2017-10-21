package net.arccode.wechat.pay.api.common.parser.xml;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.common.parser.Converter;
import net.arccode.wechat.pay.api.common.parser.WXPayParser;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

/**
 * xml对象解析器
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class ObjectXmlParser<T extends WXPayResponse> implements WXPayParser<T> {

    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String resp) throws WXPayApiException {
        Converter converter = new XmlConverter();

        return converter.toResponse(resp, clazz);
    }

    @Override
    public Class<T> getResponseClass() {
        return clazz;
    }
}
