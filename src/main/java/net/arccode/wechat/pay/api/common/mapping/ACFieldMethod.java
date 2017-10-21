package net.arccode.wechat.pay.api.common.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class ACFieldMethod {

    /**
     * 属性
     */
    private Field field;

    /**
     * 方法
     */
    private Method method;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
