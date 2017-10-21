package net.arccode.wechat.pay.api.common.log;

import net.arccode.wechat.pay.api.common.constant.WXPayConstants;
import net.arccode.wechat.pay.api.protocol.base.WXPayResponse;
import net.arccode.wechat.pay.api.common.util.ACHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日志记录
 * <p/>
 * 通讯错误格式：time^_^api^_^app^_^ip^_^os^_^sdk^_^returnCode
 * 业务错误格式：time^_^response
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class ACLogger {

    /**
     * 通用错误日志
     */
    private static final Logger CLOG = LoggerFactory.getLogger("sdk.comm.err");

    /**
     * 业务错误日志
     */
    private static final Logger BLOG = LoggerFactory.getLogger("sdk.biz.err");

    private static String osName = System.getProperties().getProperty("os.name");
    private static String ip = null;
    private static boolean needEnableLogger = true;

    public static void setNeedEnableLogger(boolean needEnableLogger) {
        ACLogger.needEnableLogger = needEnableLogger;
    }

    public static String getIp() {
        if (ip == null) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ip;
    }

    public static void setIp(String ip) {
        ACLogger.ip = ip;
    }

    /**
     * 通讯错误日志
     */
    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, byte[] content) {
        if (!needEnableLogger) {
            return;
        }
        String contentString = null;
        try {
            contentString = new String(content, "UTF-8");
            logCommError(e, conn, appKey, method, contentString);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 通讯错误日志
     */
    public static void logCommError(Exception e, String url, String appKey, String method, byte[] content) {
        if (!needEnableLogger) {
            return;
        }
        String contentString = null;
        try {
            contentString = new String(content, "UTF-8");
            logCommError(e, url, appKey, method, contentString);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 通讯错误日志
     */
    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, Map<String, String> params) {
        if (!needEnableLogger) {
            return;
        }
        _logCommError(e, conn, null, appKey, method, params);
    }

    public static void logCommError(Exception e, String url, String appKey, String method, Map<String, String> params) {
        if (!needEnableLogger) {
            return;
        }
        _logCommError(e, null, url, appKey, method, params);
    }

    /**
     * 通讯错误日志
     */
    private static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, String content) {
        Map<String, String> params = parseParam(content);
        _logCommError(e, conn, null, appKey, method, params);
    }

    /**
     * 通讯错误日志
     */
    private static void logCommError(Exception e, String url, String appKey, String method, String content) {
        Map<String, String> params = parseParam(content);
        _logCommError(e, null, url, appKey, method, params);
    }

    /**
     * 通讯错误日志
     */
    private static void _logCommError(Exception e, HttpURLConnection conn, String url, String appKey, String method, Map<String, String> params) {
        DateFormat df = new SimpleDateFormat(WXPayConstants.DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(WXPayConstants.DATE_TIMEZONE));
        String sdkName = WXPayConstants.SDK_VERSION;
        String urlStr = null;
        String rspCode = "";
        if (conn != null) {
            try {
                urlStr = conn.getURL().toString();
                rspCode = "HTTP_ERROR_" + conn.getResponseCode();
            } catch (IOException ioe) {
            }
        } else {
            urlStr = url;
            rspCode = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(df.format(new Date()));// 时间
        sb.append("^_^");
        sb.append(method);// API
        sb.append("^_^");
        sb.append(appKey);// APP
        sb.append("^_^");
        sb.append(getIp());// IP地址
        sb.append("^_^");
        sb.append(osName);// 操作系统
        sb.append("^_^");
        sb.append(sdkName);// SDK名字
        sb.append("^_^");
        sb.append(urlStr);// 请求URL
        sb.append("^_^");
        sb.append(rspCode);
        sb.append("^_^");
        sb.append((e.getMessage() + "").replaceAll("\r\n", " "));
        CLOG.error(sb.toString());
    }

    private static Map<String, String> parseParam(String contentString) {
        Map<String, String> params = new HashMap<String, String>();
        if (contentString == null || contentString.trim().equals("")) {
            return params;
        }
        String[] paramsArray = contentString.split("\\&");
        if (paramsArray != null) {
            for (String param : paramsArray) {
                String[] keyValue = param.split("=");
                if (keyValue != null && keyValue.length == 2) {
                    params.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return params;
    }

    /**
     * 业务/系统错误日志
     */
    public static void logBizError(String rsp) {
        if (!needEnableLogger) {
            return;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(WXPayConstants.DATE_TIMEZONE));
        StringBuilder sb = new StringBuilder();
        sb.append(df.format(new Date()));
        sb.append("^_^");
        sb.append(rsp);
        BLOG.error(sb.toString());
    }

    /**
     * 发生特别错误时记录完整错误现场
     */
    public static void logErrorScene(Map<String, Object> rt, WXPayResponse tResp, String appSecret) {
        if (!needEnableLogger) {
            return;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(WXPayConstants.DATE_TIMEZONE));
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorScene");
        sb.append("^_^");
        sb.append(rt.get("url"));
        sb.append("^_^");
        sb.append(tResp.getReturnCode());
        sb.append("^_^");
        sb.append(tResp.getReturnMsg());
        sb.append("^_^");
        sb.append(getIp());
        sb.append("^_^");
        sb.append(osName);
        sb.append("^_^");
        sb.append(df.format(new Date()));
        sb.append("^_^");
        sb.append("ProtocolMustParams:");
        appendLog((ACHashMap) rt.get("protocolMustParams"), sb);
        sb.append("^_^");
        sb.append("ProtocolOptParams:");
        appendLog((ACHashMap) rt.get("protocolOptParams"), sb);
        sb.append("^_^");
        sb.append("ApplicationParams:");
        appendLog((ACHashMap) rt.get("params"), sb);
        sb.append("^_^");
        sb.append("Body:");
        sb.append((String) rt.get("resp"));
        BLOG.error(sb.toString());
    }

    private static void appendLog(ACHashMap map, StringBuilder sb) {
        boolean first = true;
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            if (!first) {
                sb.append("&");
            } else {
                first = false;
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
    }
}
