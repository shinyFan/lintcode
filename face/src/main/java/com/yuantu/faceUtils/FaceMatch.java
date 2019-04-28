package com.yuantu.faceUtils;

import java.io.File;
import java.util.*;

/**
 * 人脸对比
 */
public class FaceMatch {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String match() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {

            byte[] bytes1 = FileUtil.readFileByBytes("D:\\资料\\face1.jpg");
            byte[] bytes2 = FileUtil.readFileByBytes("D:\\资料\\face2.jpg");
            String image1 = Base64Util.encode(bytes1);
            String image2 = Base64Util.encode(bytes2);

            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");

            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");

            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JsonResult faceResult = GsonUtils.fromJson(result, JsonResult.class);
            System.out.println(faceResult);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String match2() {
        long startMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            String path = "D:\\资料\\图片库";
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
                    return null;
                } else {
                    for (File file2 : files) {
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
                            return null;
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceMatch.match2();
    }
}