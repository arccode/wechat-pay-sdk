package net.arccode.wechat.pay.api.common.exception;

import java.io.Serializable;

/**
 * API调用异常基类
 *
 * @author http://arccode.net
 * @since 2015-11-02
 */
public class WXPayApiException extends Exception {
    private static final long serialVersionUID = -7457798164814346771L;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误消息
     */
    private String errMsg;

    public WXPayApiException() {
        super();
    }

    public WXPayApiException(String message) {
        super(message);
    }

    public WXPayApiException(Throwable cause) {
        super(cause);
    }

    public WXPayApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WXPayApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
