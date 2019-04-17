package com.yuantu.faceUtils;

import java.io.File;

/**
 * Created by JINZONGFAN on 2019/4/16 15:06
 */
public class FaceTest {
    public static void main(String[] args) {
        //获取所有的图片
        String path = "D:\\资料\\图片库";
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    System.out.println("文件:" + file2.getPath());
                    //比较
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
