package com.jzf.thread;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by JINZONGFAN on 2019/4/19 14:38
 */
public class FindFaceThread {
    private static final Integer MAX = 1;

    private static final Vector<String> resultlist=new Vector<String>();





    public static class FindForkJoinTask extends RecursiveTask<Integer> {
        //分组数量
        private Integer urlNum;

        // 子任务开始计算的值
        private Integer startValue;

        // 子任务结束计算的值
        private Integer endValue;

        private  Map<String,String> valueMap=new HashMap();


        private List<String> URLList=new ArrayList<>();

        public Map<String, String> getValueMap() {
            return valueMap;
        }

        public void setValueMap(Map<String, String> valueMap) {
            this.valueMap = valueMap;
        }

        public List<String> getURLList() {
            return URLList;
        }

        public void setURLList(List<String> URLList) {
            this.URLList = URLList;
        }

        public Integer getUrlNum() {
            return urlNum;
        }

        public void setUrlNum(Integer urlNum) {
            this.urlNum = urlNum;
        }

        public Integer getStartValue() {
            return startValue;
        }

        public void setStartValue(Integer startValue) {
            this.startValue = startValue;
        }

        public Integer getEndValue() {
            return endValue;
        }

        public void setEndValue(Integer endValue) {
            this.endValue = endValue;
        }

        public FindForkJoinTask(Integer startValue, Integer endValue,Map valueMap,List URLList) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.valueMap=valueMap;
            this.URLList=URLList;
        }



        public FindForkJoinTask(Integer urlNum) {
            this.urlNum = urlNum;
        }

        @Override
        protected Integer compute() {
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
            // 可以正式进行累加计算了
            if(endValue - startValue <MAX) {
                //获得url
                String url=URLList.get(startValue);
                //发送数据
                try {
                    Thread.sleep(5000);
                    System.out.println("url:"+url+"valueMap:"+valueMap);

                } catch (Exception e) {
                }

            }
            // 否则再进行任务拆分，拆分成两个任务
            else {
                FindFaceThread.FindForkJoinTask subTask1 = new FindFaceThread.FindForkJoinTask(startValue, startValue + ((endValue-startValue) >> 1),valueMap,URLList);
                subTask1.fork();
                FindFaceThread.FindForkJoinTask subTask2 = new FindFaceThread.FindForkJoinTask(startValue + ((endValue-startValue) >> 1)+1  , endValue,valueMap,URLList);
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
            return 0;
        }
    }


    public static String findFace(List<String> url,Map<String,String> param){
        resultlist.removeAll(resultlist);
        ForkJoinPool pool = new ForkJoinPool();
        //获取分组数量
        int count = url.size();
        ForkJoinTask<Integer> taskFuture = pool.submit(new FindFaceThread.FindForkJoinTask(0, count-1,param,url));
        try {
            taskFuture.get();
            //Integer result = taskFuture.get();
            // System.out.println("result = " + result);
        } catch (Exception e) {

        }
        return null;
    }
}
