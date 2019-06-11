package com.jzf.code;

import java.util.concurrent.*;

/**
 * 这是一个简单的Join/Fork计算过程，将1—1001数字相加
 */
public class TestForkJoinPool {

    private static final Integer MAX = 500;

    static class MyForkJoinTask extends RecursiveTask<Integer> {
        // 子任务开始计算的值
        private Integer startValue;

        // 子任务结束计算的值
        private Integer endValue;

        public MyForkJoinTask(Integer startValue , Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        // 子任务开始计算的值
        private Integer localMax;

        // 子任务结束计算的值
        private Integer grobalMax;

        //private ConcurrentLinkedQueue linkedQueue=new ConcurrentLinkedQueue();



        @Override
        protected Integer compute() {
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
            // 可以正式进行累加计算了
            Integer target = 1555;

            if(endValue - startValue < MAX) {
                System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
                for(int index = this.startValue ; index <= this.endValue  ; index++) {
                    System.out.println("业务逻辑");
                    if(target==index){
                        return index;
                    }
                }
                return 0;
            }
            // 否则再进行任务拆分，拆分成两个任务
            else {
                MyForkJoinTask subTask1 = new MyForkJoinTask(startValue, (startValue + endValue) / 2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((startValue + endValue) / 2 + 1 , endValue);
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }



    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " +startTime);
        // 这是Fork/Join框架的线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture =  pool.submit(new MyForkJoinTask(1,3000));
        try {
            Integer result = taskFuture.get();
            System.out.println("result = " + result);
            long endTime = System.currentTimeMillis();
            System.out.println("endTime = " +endTime);
            long spendTime1=(endTime-startTime);
            System.out.println("spendTime = " +spendTime1);

            System.out.println("========================");
            TestForkJoinPool test=new TestForkJoinPool();
            Integer single = test.findSingle();
            System.out.println("result = " + single);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }

    public Integer findSingle(){
        int target=15555;
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " +startTime);
        for(int index = 1 ; index <= 30000  ; index++) {
            System.out.println("业务逻辑");
            if(target==index){
                long endTime = System.currentTimeMillis();
                System.out.println("endTime = " +endTime);
                System.out.println("spendTime = " +(endTime-startTime));
                return index;
            }
        }

        return target;
    }
}