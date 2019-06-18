package com.jzf;

public class DjsTimerr {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo=new ThreadDemo("1");
        threadDemo.start();
        while (true){
            System.out.println("1");
            //Thread.sleep(1000);
        }

    }

}
