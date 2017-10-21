package net.arccode.wechat.pay.api.service;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;
import net.arccode.wechat.pay.api.protocol.base.WXPayRequest;

/**
 * 接口调用入口
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public interface IWXPayClient {

    /**
     * 执行api调用
     *
     * @param request
     * @param <T>
     * @return
     */
    public <T extends WXPayResponse> T execute(WXPayRequest<T> request) throws WXPayApiException;

    /**
     * 解析微信支付异步通知数据
     *
     * @param notifyData
     * @param <T> clazz
     * @return
     */
    <T extends  WXPayResponse> T parseNotify(String notifyData, Class<T> clazz) throws WXPayApiException;
}
