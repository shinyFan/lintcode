package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/5/8 15:04
 */
public class RotateString {
    public static void main(String[] args) {
        char str[]={'a','b','c','c','b','a'};
        String s="abcdefg";
        str=s.toCharArray();
        RotateString rotateString=new RotateString();
        rotateString.rotateString(str,3);
        System.out.println(str);
    }

    public void rotateString(char[] str, int offset) {
        char []str2=new char[str.length];
        int length = str.length;
        if (length<=0){
            return;
        }
        if(offset>=length){
            offset=offset%length;
        }
        if(offset==0){
            return;
        }

        char temp=' ';

        int target=length-offset;
        int i=0;
        int old=target;

        while (i<offset){
            str2[i]=str[target+i];
            i++;
        }

        while(i<length){
            str2[i]=str[i-offset];
            i++;
        }
        i=0;
        while (i<length){
            str[i]=str2[i];
            i++;
        }
        System.out.println(str2);


        // write your code here
    }
}
