package com.jzf.utils;

import java.io.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo=new ThreadDemo("1");
        demo.start();
        while (true){
            int x=(int)(Math.random()*100);
            if(x>=90){
                demo.setTime(60);
            }
            Thread.sleep(100);
        }
    }

}
