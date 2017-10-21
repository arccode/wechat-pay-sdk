package net.arccode.wechat.pay.api.common.util;

import java.util.Random;

/**
 * <pre>
 * sdk 使用的工具
 * </pre>
 *
 * @author http://arccode.net
 * @since 2015-09-18
 */
public class SDKUtils {

    /**
     * 构造订单号
     * @return
     */
    public static String genOrderNo() {

        return "O" + DateUtils.convertDate2String("yyMMddHHmmssSSS") + RandomUtils.randomNInt(8);
    }

    /**
     * 构造结算号
     * @return
     */
    public static String genSettleNo() {

        return "S" + DateUtils.convertDate2String("yyMMddHHmmssSSS") + RandomUtils.randomNInt(8);
    }

    /**
     * 构造付款流水号
     * @return
     */
    public static String genOutTradeNo() {

        return "T" + DateUtils.convertDate2String("yyMMddHHmmssSSS") + RandomUtils.randomNInt(8);
    }

    /**
     * 构造退款流水号
     * @return
     */
    public static String genOutRefundNo() {

        return "R" + DateUtils.convertDate2String("yyMMddHHmmssSSS") + RandomUtils.randomNInt(8);
    }

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String genRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
