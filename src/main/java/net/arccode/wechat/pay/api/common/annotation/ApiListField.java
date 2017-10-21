package net.arccode.wechat.pay.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据结构列表属性注解
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface ApiListField {

    /**
     * JSON列表属性映射名称
     *
     * @return
     */
    public String value() default "";
}
