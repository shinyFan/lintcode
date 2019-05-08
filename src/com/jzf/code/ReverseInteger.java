package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/5/8 10:06
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        int reverseNum = reverseInteger.reverseInteger(123);
        System.out.println(reverseNum);
    }

    public int reverseInteger(int number) {
        // write your code here
        int reverseNumber=0;
        while(number>0){
            reverseNumber*=10;
            //个位
            int a=number%10;
            number/=10;
            reverseNumber+=a;

        }
        return reverseNumber;
    }
}
