package com.yuantu.exception;

/**
 * @author hanlimin
 * @Description: 序列号生成异常
 * @email hanlimin@yuantutech.com
 * @date 2018/7/17
 */
public class BeyondMaxSerialNumberException extends Exception {



    public BeyondMaxSerialNumberException() {
        super("序列号超出可表示范围");
    }
}
