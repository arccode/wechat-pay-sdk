package net.arccode.wechat.pay.api.common.util;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 纯字符串字典结构
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class ACHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = 3881590349447518907L;

    public ACHashMap() {
        super();
    }

    public ACHashMap(Map<? extends String, ? extends String> map) {
        super(map);
    }

    public String put(String key, Object value) {
        String strValue;

        if (value == null) {
            strValue = null;
        } else if (value instanceof String) {
            strValue = (String) value;
        } else if (value instanceof Integer) {
            strValue = ((Integer) value).toString();
        } else if (value instanceof Long) {
            strValue = ((Long) value).toString();
        } else if (value instanceof Float) {
            strValue = ((Float) value).toString();
        } else if (value instanceof Double) {
            strValue = ((Double) value).toString();
        } else if (value instanceof Boolean) {
            strValue = ((Boolean) value).toString();
        } else if (value instanceof Date) {
            DateFormat format = new SimpleDateFormat(WXPayConstants.DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(WXPayConstants.DATE_TIMEZONE));
            strValue = format.format((Date) value);
        } else {
            strValue = value.toString();
        }

        return this.put(key, strValue);
    }

    public String put(String key, String value) {
        if (StringUtils.areNotEmpty(key, value)) {
            return super.put(key, value);
        } else {
            return null;
        }
    }
}
