package com.yuantu.faceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JINZONGFAN on 2019/4/16 15:30
 */
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private volatile boolean cancelled;

    public void cancel() {
        cancelled = true;
    }

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("线程" + threadName + "执行");
        long startMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            String path = "D:\\资料\\图片分组\\" + threadName;
            byte[] bytes1 = FileUtil.readFileByBytes("D:\\资料\\face1.jpg");
            String image1 = Base64Util.encode(bytes1);
            List<Map<String, Object>> images = new ArrayList<>();
            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");

            Map<String, Object> map2 = new HashMap<>();

            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            images.add(0, map1);
            images.add(map2);

            File file = new File(path);
            byte[] bytes2;
            int i = 0;
            if (file.exists()) {
                File[] files = file.listFiles();
                if (null == files || files.length == 0) {
                    System.out.println("文件夹是空的!");
                } else {
                    for (File file2 : files) {
                        while (!cancelled) {
                            System.out.println("文件:" + i++);
                            //比较
                            bytes2 = FileUtil.readFileByBytes(file2.getPath());
                            String image2 = Base64Util.encode(bytes2);
                            map2.put("image", image2);
                            images.remove(1);
                            images.add(map2);
                            String param = GsonUtils.toJson(images);
                            String result = HttpUtil.post(url, accessToken, "application/json", param);
                            JsonResult faceResult = GsonUtils.fromJson(result, JsonResult.class);
                            System.out.println("相识度：" + faceResult.getResult().getScore());
                            if (faceResult.getResult().getScore() > 80) {
                                long endMili = System.currentTimeMillis();
                                System.out.println("结束 s" + endMili);
                                System.out.println("总耗时为：" + (endMili - startMili) + "毫秒");
                                cancel();
                            }
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo("1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("2");
        T2.start();

        ThreadDemo T3 = new ThreadDemo("3");
        T3.start();
    }
}
