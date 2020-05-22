package com.jzf.utils;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        //获取账号的手机号
        String username = "13083687245";
        //获取手机号后四位
        username= username.substring(username.length()-4);
        System.out.println(username);
    }

}
