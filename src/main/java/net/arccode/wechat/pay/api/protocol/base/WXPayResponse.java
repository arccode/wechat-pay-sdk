package net.arccode.wechat.pay.api.protocol.base;

import net.arccode.wechat.pay.api.common.annotation.ApiField;

import java.io.Serializable;
import java.util.Map;

/**
 * API基础响应信息
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public abstract class WXPayResponse implements Serializable {
    private static final long serialVersionUID = 819761681742723087L;

    /**
     * 返回状态码
     */
    @ApiField("return_code")
    private String returnCode;

    /**
     * 返回信息
     */
    @ApiField("return_msg")
    private String returnMsg;

    /**
     * 响应字符串
     */
    private String body;

    /**
     * API请求参数
     */
    private Map<String, String> params;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isSuccess() {
        return "SUCCESS".equalsIgnoreCase(this.returnCode);
    }
}
