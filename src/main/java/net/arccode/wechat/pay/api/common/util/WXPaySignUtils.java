package net.arccode.wechat.pay.api.common.util;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;

import java.security.MessageDigest;
import java.util.*;

/**
 * 签名工具
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class WXPaySignUtils {

    /**
     * 签名排序并连接成字符串
     *
     * @param requestParametersHolder
     * @return
     */
    public static String getSignatureContent(RequestParametersHolder requestParametersHolder) {
        Map<String, String> sortedParams = new TreeMap<String, String>();
        ACHashMap appParams = requestParametersHolder.getApplicationParams();
        if (appParams != null && appParams.size() > 0) {
            sortedParams.putAll(appParams);
        }

        ACHashMap protocolMustParams = requestParametersHolder.getProtocalMustParams();
        if (protocolMustParams != null && protocolMustParams.size() > 0) {
            sortedParams.putAll(protocolMustParams);
        }

        ACHashMap protocolOptParams = requestParametersHolder.getProtocalOptParams();
        if (protocolOptParams != null && protocolOptParams.size() > 0) {
            sortedParams.putAll(protocolOptParams);
        }

        return getSignContent(sortedParams);
    }

    /**
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (StringUtils.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }

        return content.toString();
    }

    /**
     * 返回md5签名后的值
     *
     * @param signContent
     * @param key
     * @return
     */
    public static String md5Sign(String signContent, String key, String charset) throws WXPayApiException {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest((signContent + "&key=" + key).getBytes(charset));
            return hex(digest);
        } catch (Exception e) {
            throw new WXPayApiException(e);
        }
    }

    // MD5 digest
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String hex(byte[] input) {
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < input.length; j++) {
            buf.append(DIGITS[(input[j] >> 4) & 0x0f]);
            buf.append(DIGITS[input[j] & 0x0f]);
        }
        return buf.toString();
    }

}