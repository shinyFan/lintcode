package com.jzf.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.security.Identity;

public class MediaTimeUtil {

    static long time=0;

    public static void main(String[] args) throws EncoderException {
        MediaTimeUtil util=new MediaTimeUtil();
        util.traverseFolder2("D:\\spark\\Spark大型项目实战：电商用户行为分析大数据平台（史上第一套高端大数据项目实战课程）");
        double sum1 = (double)time;
        double sum2 =sum1/3600;
        System.out.println(sum2);
    }
    public void traverseFolder2(String path) throws EncoderException {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        if(file2.getName().endsWith("avi")){
                            Encoder encoder = new Encoder();
                            MultimediaInfo m = encoder.getInfo(file2);
                            long ls = m.getDuration()/1000;
                            time += ls;
                        }

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
