package com.jzf.code;

public class SVNRepo {
    public static boolean isBadVersion(int k){
        //得到错误版本
        int badVersion=1;
        //判断
        if(badVersion>k){
            return true;
        }
        return false;
    }
}
