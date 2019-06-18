package com.jzf.utils;

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private static int n=60;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        try {
            while (true) {
                System.out.println("time"+n--);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {

        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();
    }
}
