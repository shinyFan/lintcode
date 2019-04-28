package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/4/28 16:11
 */
public class TrailingZeros {
    public long trailingZeros(long n) {


        long count = 0;
        for(long i=5;n/i>=1;i*=5){
            count += n/i;
        }
        return count;
    }

    long getFactorial(long n){
        if(n<=1){
            return 1;
        }else{
            return n*getFactorial(n-1);
        }

    }
}
