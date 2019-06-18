package com.demo.lushi;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by majianghua on 2019/6/18.
 */
public class TestSh {

    public static void main(String[] args) {
        performclick(69,103,137);
//        performclick(255,0,0);
//        performclick(0,255,0);
//        performclick(0,0,255);
    }

    private static void performclick(int r,int g,int b) {
        long start = System.currentTimeMillis();
        System.out.println("=====" + start);

        String path="C:\\Users\\pc\\Desktop\\performclick.png";
        AdbUtil.shotCut(path);
        System.out.println("=====截屏" + (System.currentTimeMillis() - start));
        File imgFile = new File(path);
        if (!imgFile.getName().endsWith(".png")) {
            return;
        }
        System.out.println(imgFile);
        BufferedImage img = ImgLoader.load(imgFile.getAbsolutePath());
        System.out.println("=====找区域" + (System.currentTimeMillis() - start));
        int[] pos = PosFinder.findByRGBColor(img, r, g, b);
        System.out.println("=====找区域" + (System.currentTimeMillis() - start));
        AdbUtil.click(pos[0], pos[1]);

        System.out.println("=====" + System.currentTimeMillis());
        System.out.println("=====点击" + (System.currentTimeMillis() - start));
    }

}