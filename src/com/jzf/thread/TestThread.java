package com.jzf.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestThread {
    public static void main(String[] args) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");


        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();
        T1.start();
    }
}

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        List<String> urlList=new ArrayList();
        int i=0;
        while(i++<4){
            urlList.add(threadName+"url"+i);
        }
        Map<String,String> valueMap=new HashMap();
        valueMap.put("value",threadName);

        FindFaceThread.findFace(urlList,valueMap);
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
