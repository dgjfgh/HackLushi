package com.skyline.wxjumphack.lushi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chenliang on 2017/12/31.
 */
public class PosFinder {


    public static int[] findByRGBColor(BufferedImage image, int R_TARGET, int G_TARGET, int B_TARGET) {
        if (image == null) {
            return null;
        }
        int width = image.getWidth();
        int height = image.getHeight();

        int[] ret = {0, 0};
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = image.getRGB(i, j);
                int r = (pixel & 0xff0000) >> 16;
                int g = (pixel & 0xff00) >> 8;
                int b = (pixel & 0xff);
                if (match(r, g, b, R_TARGET, G_TARGET, B_TARGET, 16)) {
                    maxX = Integer.max(maxX, i);
                    minX = Integer.min(minX, i);
                    maxY = Integer.max(maxY, j);
                    minY = Integer.min(minY, j);
                }
            }
        }
        ret[0] = (maxX + minX) / 2;
        ret[1] = (maxY + minY) / 2;
        System.out.println(maxX + ", " + minX);
        System.out.println("pos, x: " + ret[0] + ", y: " + ret[1]);
        return ret;
    }

    public static boolean match(int r, int g, int b, int rt, int gt, int bt, int t) {
        return r > rt - t &&
                r < rt + t &&
                g > gt - t &&
                g < gt + t &&
                b > bt - t &&
                b < bt + t;
    }

    public static void main(String... strings) throws IOException {
        PosFinder t = new PosFinder();
        File srcDir = new File("C:\\Users\\pc\\Desktop\\新建文件夹1");
        System.out.println(srcDir);
        long cost = 0;
        for (File file : srcDir.listFiles()) {
            if (!file.getName().endsWith(".png")) {
                continue;
            }
            System.out.println(file);
            BufferedImage img = ImgLoader.load(file.getAbsolutePath());
            int[] pos = t.findByRGBColor(img, 255, 0, 0);
        }
        System.out.println("avg time cost: " + (cost / srcDir.listFiles().length / 1_000_000));

    }
}
