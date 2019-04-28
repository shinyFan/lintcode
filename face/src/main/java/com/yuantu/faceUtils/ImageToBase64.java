package com.yuantu.faceUtils;


import com.yuantu.request.UserRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by JINZONGFAN on 2019/4/16 13:57
 */
@Resource
@Component
public class ImageToBase64 {
    private static String strNetImageToBase64;

    @Value("${image.base.path}")
    private String IMAGE_BASE_PATH;

    @Value("${image.group.max}")
    private Integer IMAGE_GROUP_MAX;

    public static void main(String[] args) {
        //第一个:把网络图片装换成Base64
        //String netImagePath = "https://jinzongfan.oss-cn-hangzhou.aliyuncs.com/face1.jpg?Expires=1555398594&OSSAccessKeyId=TMP.AQHl0-oVkIiZ5o9ovnF5c_q7z47yB2BPaWgEqZSxsxkFs0h3htSusAKGqqIRMC4CFQCCdhpnhlJwshJulUNpC7JwaSYm3QIVANXp0vu65JXN_uKzrS2pM2vhYdZS&Signature=uXLYryfWCbNof0K52tAKO4B%2Bo40%3D";
        //下面是网络图片转换Base64的方法
        //NetImageToBase64(netImagePath);
        //System.out.println("############################");
        //下面是本地图片转换Base64的方法
        String imagePath = "D:\\资料\\merch.jpg";
        ImageToBase64(imagePath);
        //getPicFormatBASE64(strNetImageToBase64,"D:\\资料\\face3.jpg");
    }

    /**
     * 网络图片转换Base64的方法
     *
     * @param netImagePath
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接 final
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = conn.getInputStream();
                        // 将内容读取内存中
                        int len = -1;
                        while ((len = is.read(by)) != -1) {
                            data.write(by, 0, len);
                        }
                        // 对字节数组Base64编码
                        BASE64Encoder encoder = new BASE64Encoder();
                        strNetImageToBase64 = encoder.encode(data.toByteArray());

                        // 关闭流
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strNetImageToBase64;
    }

    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath
     */
    public static String ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        strNetImageToBase64 = encoder.encode(Objects.requireNonNull(data));
        System.out.println(strNetImageToBase64);
        return strNetImageToBase64;
    }

    /**
     * 对图片BASE64 解码
     *
     */
    public static void getPicFormatBASE64(String str,String picPath) {
        try {
            byte[] result = new sun.misc.BASE64Decoder().decodeBuffer(str
                    .trim());
            RandomAccessFile inOut = new RandomAccessFile(picPath, "rw"); // r,rw,rws,rwd
            inOut.write(result);
            inOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对图片BASE64 解码
     *
     */
    public  String  getPicFormatBASE64(UserRequest user) {
        try {
            //base64字符串为前台传的字符串
            String str=user.getImage();
            //保存路径为： 图片服务器+分组（id/1000）+身份证号
            //获取分组并判断分组是否存在
            long  group= user.getId() / IMAGE_GROUP_MAX;
            String groupPath="/group_"+group;
            String picPath=IMAGE_BASE_PATH+groupPath;
            FileUtil.judeDirExists(picPath);

            picPath+="/"+user.getIdNo()+".jpg";
            groupPath+="/"+user.getIdNo()+".jpg";
            //判断文件是否存在 存在则删除
            FileUtil.judeFileExists(picPath);
            byte[] result = new sun.misc.BASE64Decoder().decodeBuffer(str
                    .trim());
            RandomAccessFile inOut = new RandomAccessFile(picPath, "rw"); // r,rw,rws,rwd
            inOut.write(result);
            inOut.close();
            return groupPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
