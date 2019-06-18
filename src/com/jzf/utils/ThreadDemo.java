package com.jzf.utils;

import com.jzf.thread.FindFaceThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private  int time=60;

    public  int getTime() {
        return time;
    }

    public  void setTime(int time) {
        this.time = time;
    }

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        while (time-->0){
            System.out.println(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
