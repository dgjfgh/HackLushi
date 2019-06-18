package com.demo.lushi;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenliang on 2017/12/31.
 */
public class ImgLoader {

    public static BufferedImage load(String path) {
        BufferedImage image = null;
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(path));
            image = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return image;
    }
}
