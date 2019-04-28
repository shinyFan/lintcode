package com.yuantu.faceUtils;

/**
 * Created by JINZONGFAN on 2019/4/16 13:34
 */

import java.util.*;

/**
 * 人脸检测与属性分析
 */
public class FaceDetect {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static JsonResult detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            //图片转base64工具类
            ImageToBase64 imageUtil = new ImageToBase64();
            Map<String, Object> map = new HashMap<String, Object>();
            //图片信息
            String imagePath = "D:\\资料\\face2.jpg";
            map.put("image", ImageToBase64.ImageToBase64(imagePath));
            //图片类型
            map.put("image_type", "BASE64");
            // map.put("face_field", "faceshape,facetype");
            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JsonResult faceResult = GsonUtils.fromJson(result, JsonResult.class);
            System.out.println(faceResult);
            return faceResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect.detect();
    }
}