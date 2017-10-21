package net.arccode.wechat.pay.api.common.parser.json;


import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.common.parser.Converter;
import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.common.parser.Reader;
import net.arccode.wechat.pay.api.common.util.Converters;
import net.arccode.wechat.pay.api.common.util.json.ExceptionErrorListener;
import net.arccode.wechat.pay.api.common.util.json.JSONReader;
import net.arccode.wechat.pay.api.common.util.json.JSONValidatingReader;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * json格式转换
 *
 * @author http://arccode.net
 * @since 2015-11-06
 */
public class JsonConverter implements Converter {


    @Override
    public <T extends WXPayResponse> T toResponse(String resp, Class<T> clazz) throws WXPayApiException {
        JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        Object rootObj = reader.read(resp);
        if (rootObj instanceof Map<?, ?>) {
            Map<?, ?> rootJson = (Map<?, ?>) rootObj;
            Collection<?> values = rootJson.values();
            for (Object rspObj : values) {
                if (rspObj instanceof Map<?, ?>) {
                    Map<?, ?> rspJson = (Map<?, ?>) rspObj;
                    return fromJson(rspJson, clazz);
                }
            }
        }
        return null;
    }

    /**
     * 把JSON格式的数据转换为对象
     *
     * @param <T>   泛型领域对象
     * @param json  JSON格式的数据
     * @param clazz 泛型领域类型
     * @return 领域对象
     * @throws WXPayApiException
     */
    public <T> T fromJson(final Map<?, ?> json, Class<T> clazz) throws WXPayApiException {
        return Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                return json.containsKey(name);
            }

            public Object getPrimitiveObject(Object name) {
                return json.get(name);
            }

            public Object getObject(Object name, Class<?> type) throws WXPayApiException {
                Object tmp = json.get(name);
                if (tmp instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) tmp;
                    return fromJson(map, type);
                } else {
                    return null;
                }
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
                    throws WXPayApiException {
                List<Object> listObjs = null;

                Object listTmp = json.get(listName);
                if (listTmp instanceof Map<?, ?>) {
                    Map<?, ?> jsonMap = (Map<?, ?>) listTmp;
                    Object itemTmp = jsonMap.get(itemName);
                    if (itemTmp == null && listName != null) {
                        String listNameStr = listName.toString();
                        itemTmp = jsonMap.get(listNameStr.substring(0, listNameStr.length() - 1));
                    }
                    if (itemTmp instanceof List<?>) {
                        listObjs = getListObjectsInner(subType, itemTmp);
                    }
                } else if (listTmp instanceof List<?>) {
                    listObjs = getListObjectsInner(subType, listTmp);
                }

                return listObjs;
            }

            private List<Object> getListObjectsInner(Class<?> subType, Object itemTmp)
                    throws WXPayApiException {
                List<Object> listObjs;
                listObjs = new ArrayList<Object>();
                List<?> tmpList = (List<?>) itemTmp;
                for (Object subTmp : tmpList) {
                    Object obj = null;
                    if (String.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Long.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Integer.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Boolean.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Date.class.isAssignableFrom(subType)) {
                        DateFormat format = new SimpleDateFormat(WXPayConstants.DATE_TIME_FORMAT);
                        try {
                            obj = format.parse(String.valueOf(subTmp));
                        } catch (ParseException e) {
                            throw new WXPayApiException(e);
                        }
                    } else if (subTmp instanceof Map<?, ?>) {// object
                        Map<?, ?> subMap = (Map<?, ?>) subTmp;
                        obj = fromJson(subMap, subType);
                    }

                    if (obj != null) {
                        listObjs.add(obj);
                    }
                }
                return listObjs;
            }

        });
    }
}
