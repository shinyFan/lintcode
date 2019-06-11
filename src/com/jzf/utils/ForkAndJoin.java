package com.jzf.utils;

import java.io.IOException;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoin {

    //获得执行ForkAndJoin任务的线程池
    private static final ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();



    public static void main(String args[]) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        ForkAndJoinRequest request = new ForkAndJoinRequest(0, 9);
        forkJoinPool.submit(request);
        request.get();
        List<Integer> resultList = request.getResultList();
        System.out.println(resultList);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println(endTime-startTime);



    }


}

//定义request继承RecursiveTask，并实现compute方法
class ForkAndJoinRequest extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private List<Integer> list;
    private static List<Integer> resultList=new ArrayList<>();

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    public ForkAndJoinRequest(int start, int end, List<Integer> list) {
        this.start = start;
        this.end = end;
        this.list = list;
    }

    public ForkAndJoinRequest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        String basePath="D:/rep/";
        int count = end - start;
        if (count <1) { //如果需要累加的数量小于等于25，则直接执行
            Test test=new Test();
            String path=basePath+start;
            try {
                Integer localMax = test.traverseFolder(path);
                resultList.add(localMax);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        } else { //否则fork出其他request
            int mid = (start + end) / 2;
            ForkAndJoinRequest request1 = new ForkAndJoinRequest(start, mid, list);
            request1.fork(); //调用fork方法将自身放入等待队列中等待执行
            ForkAndJoinRequest request2 = new ForkAndJoinRequest(mid + 1, end, list);
            request2.fork();

            //等待执行结果
            return request1.join() + request2.join();

        }
    }
}