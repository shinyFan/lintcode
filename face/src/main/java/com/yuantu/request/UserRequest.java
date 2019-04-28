package com.yuantu.request;

import com.yuantu.entity.User;
import lombok.Data;
import lombok.ToString;

/**
 * Created by JINZONGFAN on 2019/4/17 9:10
 */
@Data
@ToString
public class UserRequest extends User {
    //卡号
    private String cardNo;

    //卡类型
    private String cardType;

    //base64编码后的图片数据
    private String image;

    //日志id
    private Long logId;

    //调用方法名称
    private String service;

    //传入图片 路径
    private String inputImage;

    //结果图片 路径
    private String resultImage;



}
