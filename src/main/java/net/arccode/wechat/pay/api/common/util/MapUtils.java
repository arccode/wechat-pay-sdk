package net.arccode.wechat.pay.api.common.util;

import net.arccode.wechat.pay.api.common.exception.WXPayApiException;
import org.w3c.dom.Element;

import java.util.Map;

/**
 * map 相关工具
 *
 * @author http://arccode.net
 * @since 2015-11-05
 */
public class MapUtils {

    /**
     * map转xml element
     *
     * @param map
     * @return
     */
    public static String map2XmlString(Map<String, String> map) throws WXPayApiException {
        Element root = XmlUtils.createRootElement("xml");
        for (String key : map.keySet()) {
            XmlUtils.appendCDATAElement(root, key, map.get(key));
        }

        return XmlUtils.nodeToString(root);
    }
}
