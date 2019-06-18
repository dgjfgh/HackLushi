package com.skyline.wxjumphack.lushi;

import java.io.IOException;

/**
 * Created by majianghua on 2019/6/17.
 */
public class AdbUtil {
    private static final String ADB_PATH = "D:\\Android\\sdk\\platform-tools\\adb";

    public static void move(int xStart, int yStart, int xEnd, int yEnd, long time) {
        try {
            String adbCommand = ADB_PATH + String.format(" shell input touchscreen swipe %d %d %d %d %d", xStart, yStart, xEnd, yEnd, time);
            System.out.println(adbCommand);
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickLong(int x, int y,int time) {
        if (time<500){
            return;
        }
        try {
            String adbCommand = ADB_PATH + String.format(" shell input touchscreen swipe %d %d %d %d %d", x, y, x, y, time);
            System.out.println(adbCommand);
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void click(int x, int y) {
        try {
            String adbCommand = ADB_PATH + String.format(" shell input tap %d %d", x, y);
            System.out.println(adbCommand);
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //KEYCODE_HOME 按键Home 3
    //KEYCODE_MENU 菜单键 82
    //KEYCODE_BACK 返回键 4
    public static void keyEvent(int keycode) {
        try {
            String adbCommand = ADB_PATH + String.format(" shell input keyevent %d", keycode);
            System.out.println(adbCommand);
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shotCut(String outFilePath){
        try {
            Process process = Runtime.getRuntime().exec(ADB_PATH + " shell /system/bin/screencap -p /sdcard/screenshot.png");
            process.waitFor();
            process = Runtime.getRuntime().exec(ADB_PATH + " pull /sdcard/screenshot.png " + outFilePath);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        clickLong(500,500,800);
//        move(200,500,200,800,1000);
//        shotCut("C:\\Users\\pc\\Desktop\\aa.png");
    }

}