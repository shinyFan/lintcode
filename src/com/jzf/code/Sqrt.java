package com.jzf.code;

public class Sqrt {
    
    public int sqrt(int x) {
        // write your code here
        int result=1;
        if(x<1){
            return 0;
        }
        if(x==Integer.MAX_VALUE){
            return 46340;
        }
        while (result*result<x+1){
            result<<=1;
        }
        //平方根在result和result/2之间；
        int lo=result>>1;
        int hi=result;
        int mid=lo+((hi-lo)>>1);
        while (lo+1<hi){
            if(mid*mid<x){
                lo=mid;
            }else{
                hi=mid-1;
            }
            mid=lo+((hi-lo)>>1);
        }
        return mid;
    }
}
