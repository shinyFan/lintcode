package com.yuantu.faceUtils;

import java.io.*;

/**
 * Created by JINZONGFAN on 2019/4/16 14:45
 */

public class Test {
    public static void main(String[] args) throws IOException {
        copyphoto();
    }

    private static void copyphoto() throws IOException {
        File file = new File("D:\\资料\\图片库\\merch.jpg");
        int i = 2000;
        String targetPath = "";
        while (i < 3000) {
            InputStream fis = new FileInputStream(file);//图片所在位置
            System.out.println("复制到第" + i + "张！");
            targetPath = "D:\\资料\\图片分组\\3\\merch" + i + ".jpg";
            OutputStream fos = new FileOutputStream(targetPath);//想要把图片copy到某处的位置
            byte[] buf = new byte[(int) file.length()];//避免空间浪费
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.close();
            fis.close();
            i++;
        }

    }
}
