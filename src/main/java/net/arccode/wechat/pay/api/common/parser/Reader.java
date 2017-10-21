package net.arccode.wechat.pay.api.common.parser;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;

import java.util.List;

/**
 * 
 * 
 * @author http://arccode.net
 * @since 2015-11-05
 */
public interface Reader {

    /**
     * 判断返回结果是否包含指定的属性。
     *
     * @param name 属性名称
     * @return true/false
     */
    public boolean hasReturnField(Object name);

    /**
     * 读取单个基本对象。
     *
     * @param name 映射名称
     * @return 基本对象值
     */
    public Object getPrimitiveObject(Object name);

    /**
     * 读取单个自定义对象。
     *
     * @param name 映射名称
     * @param type 映射类型
     * @return 映射类型的实例
     * @throws WXPayApiException
     */
    public Object getObject(Object name, Class<?> type) throws WXPayApiException;

    /**
     * 读取多个对象的值。
     *
     * @param listName 列表名称
     * @param itemName 映射名称
     * @param subType 嵌套映射类型
     * @return 嵌套映射类型实例列表
     * @throws WXPayApiException
     */
    public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
            throws WXPayApiException;

}
