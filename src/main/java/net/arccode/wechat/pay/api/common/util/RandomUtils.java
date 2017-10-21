package net.arccode.wechat.pay.api.common.util;


import java.security.SecureRandom;
import java.util.Random;

/**
 * 描述: 随机数工具类
 *
 * @author http://arccode.net
 * @since 2015-05-25
 */
public class RandomUtils {

    private static Random random;

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String randomNInt(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 返回8位随机整数
     * @return
     */
    public static int randomInt() {
        if (random == null) {
            random = new Random();
        }
        int ret = random.nextInt(99999999) + 1;
        return ret;
    }

    /**
     * 返回随机长整数
     * @return
     */
    public static long randomLong() {
        if (random == null) {
            random = new Random();
        }
        long ret = random.nextLong() + 1;
        return ret;
    }

    public static String randomKey() {
        byte[] keyBytes = new byte[16];
        new SecureRandom().nextBytes(keyBytes);
        return new String(hex(keyBytes));
    }

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f'};
    private static String hex(byte[] input) {
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < input.length; j++) {
            buf.append(DIGITS[(input[j] >> 4) & 0x0f]);
            buf.append(DIGITS[input[j] & 0x0f]);
        }
        return buf.toString();
    }

}
