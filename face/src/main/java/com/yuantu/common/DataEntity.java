package com.yuantu.common;

/**
 * 公有数据
 * Created by brj on 2017/7/28.
 */
public class DataEntity {

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";//日期时间格式

    public static final String INTERFACE_NAME = "name";//接口参数用户名
    public static final String INTERFACE_PASSWORD = "password";//接口参数密码
    public static final String INTERFACE_SERVICE = "service";//接口参数服务名称
    public static final String INTERFACE_TOKEN = "token";//接口参数令牌参数

    /**
     * 删除标记（0：正常，1：删除）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    /**
     * 所有设备类型
     */
    public static final Long DEVICE_TYPE_ID_ALL_MATERIAL = 0L;
    /**
     * 所有设备类型
     */
    public static final Long DEVICE_TYPE_ID_ALL_PRODUCT = 1L;

    /**
     * 主机设备类型
     */
    public static final Long DEVICE_TYPE_ID_PRODUCT = 1L;


    /**
     * 用户工具类获取当前User对象
     */
    public static final String SESSION_KEY = "user";

    /**
     * 根据userId获取权限
     */
    public static final String AUTHORITY_BY_USERID = "authority";

    /**
     * 邮件发送端
     */
    public static final String EMAIL_FROM = "junjiedaozhu@126.com";
    public static final String EMAIL_SUBJECT = "业务管理系统新密码";

    /**
     * 随机数的长度
     */
    public static final String RANDOM_LENGTH = "6";
    public static final String RANDOM_AllCHART = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String RANDOM_LENGTH_2 = "2";
    public static final String RANDOM_AllCHART_0 = "0123456789";
    public static final String RANDOM_AllCHART_a = "abcdefghijklmnopqrstuvwxyz";
    public static final String RANDOM_AllCHART_A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String PASSWORD_LENGTH = "6";//密码加密用的长度
}
