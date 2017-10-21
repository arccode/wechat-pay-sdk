package net.arccode.wechat.pay.api.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 描述: 图片工具类
 *
 * @author http://arccode.net
 * @since 2015-05-28
 */
public class ImageUtils {

    /**
     * <pre>
     * Base64编码的字符解码为图片
     *
     * </pre>
     *
     * @param imageString
     * @return
     */
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return image;
    }

    /**
     * <pre>
     * Base64编码的字符解码为字节数组流
     *
     * </pre>
     *
     * @param imageString
     * @return
     */
    public static ByteArrayInputStream decodeToStream(String imageString) {

        ByteArrayInputStream bis = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            bis = new ByteArrayInputStream(imageByte);
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bis;
    }

    /**
     * <pre>
     * 图片文件转化为Base64编码字符串
     *
     * </pre>
     *
     * @param image
     * @param type
     * @return
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageString.replaceAll("\\n", "");
    }
}
