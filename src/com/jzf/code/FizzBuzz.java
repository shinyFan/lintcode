package com.jzf.code;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> list = fizzBuzz.fizzBuzz(15);
        System.out.println(list);
    }
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        String flag="";
        for (int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                flag = "fizz buzz";
                list.add(flag);
                continue;
            }
            if(i%3==0){
                flag = "fizz";
                list.add(flag);
                continue;
            }
            if(i%3==5){
                flag = "buzz";
                list.add(flag);
                continue;
            }
            list.add(i+"");
        }
        return list;

    }
}
