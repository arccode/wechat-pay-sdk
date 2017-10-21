package net.arccode.wechat.pay.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据结构属性注解
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface ApiField {

    /**
     * 属性映射名称
     */
    public String value() default "";
}
