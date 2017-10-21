package net.arccode.wechat.pay.api.common.parser.xml;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.common.parser.Converter;
import net.arccode.wechat.pay.api.common.util.Converters;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;
import net.arccode.wechat.pay.api.common.parser.Reader;
import net.arccode.wechat.pay.api.common.util.XmlUtils;
import org.w3c.dom.Element;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * xml格式转换
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class XmlConverter implements Converter {

    @Override
    public <T extends WXPayResponse> T toResponse(String resp, Class<T> clazz) throws WXPayApiException {

        Element root = XmlUtils.getRootElementFromString(resp);
        return getModelFromXML(root, clazz);
    }

    private <T> T getModelFromXML(final Element element, Class<T> clazz) throws WXPayApiException {
        if (element == null)
            return null;

        return Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                Element childE = XmlUtils.getChildElement(element, (String) name);
                return childE != null;
            }

            public Object getPrimitiveObject(Object name) {
                return XmlUtils.getElementValue(element, (String) name);
            }

            public Object getObject(Object name, Class<?> type) throws WXPayApiException {
                Element childE = XmlUtils.getChildElement(element, (String) name);
                if (childE != null) {
                    return getModelFromXML(childE, type);
                } else {
                    return null;
                }
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
                    throws WXPayApiException {
                List<Object> list = null;
                Element listE = XmlUtils.getChildElement(element, (String) listName);

                if (listE != null) {
                    list = new ArrayList<Object>();
                    List<Element> itemEs = XmlUtils.getChildElements(listE, (String) itemName);
                    for (Element itemE : itemEs) {
                        Object obj = null;
                        String value = XmlUtils.getElementValue(itemE);

                        if (String.class.isAssignableFrom(subType)) {
                            obj = value;
                        } else if (Long.class.isAssignableFrom(subType)) {
                            obj = Long.valueOf(value);
                        } else if (Integer.class.isAssignableFrom(subType)) {
                            obj = Integer.valueOf(value);
                        } else if (Boolean.class.isAssignableFrom(subType)) {
                            obj = Boolean.valueOf(value);
                        } else if (Date.class.isAssignableFrom(subType)) {
                            DateFormat format = new SimpleDateFormat(
                                    WXPayConstants.DATE_TIME_FORMAT);
                            try {
                                obj = format.parse(value);
                            } catch (ParseException e) {
                                throw new WXPayApiException(e);
                            }
                        } else {
                            obj = getModelFromXML(itemE, subType);
                        }
                        if (obj != null)
                            list.add(obj);
                    }
                }
                return list;
            }
        });
    }
}
