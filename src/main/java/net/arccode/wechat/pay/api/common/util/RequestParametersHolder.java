package net.arccode.wechat.pay.api.common.util;

/**
 * 请求参数分类
 * 
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class RequestParametersHolder {

    /**
     * 协议必选参数
     */
    private ACHashMap protocalMustParams;

    /**
     * 协议可选参数
     */
    private ACHashMap protocalOptParams;

    /**
     * 应用参数
     */
    private ACHashMap applicationParams;

    public ACHashMap getProtocalMustParams() {
        return protocalMustParams;
    }
    public void setProtocalMustParams(ACHashMap protocalMustParams) {
        this.protocalMustParams = protocalMustParams;
    }
    public ACHashMap getProtocalOptParams() {
        return protocalOptParams;
    }
    public void setProtocalOptParams(ACHashMap protocalOptParams) {
        this.protocalOptParams = protocalOptParams;
    }
    public ACHashMap getApplicationParams() {
        return applicationParams;
    }
    public void setApplicationParams(ACHashMap applicationParams) {
        this.applicationParams = applicationParams;
    }
}
