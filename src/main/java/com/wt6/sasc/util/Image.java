package com.wt6.sasc.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class Image {

    /**
     * base64 编码转换为 BufferedImage
     * @param base64
     * @return
     */
    public static BufferedImage base64ToBufferedImage(String base64) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes1 = decoder.decode(base64);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            return ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
