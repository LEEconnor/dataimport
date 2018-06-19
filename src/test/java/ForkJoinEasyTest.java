package com.test.dataimport;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用ForkJoinPool执行从1加到1000
 *
 * @author lixinjian
 * @date 2018年6月19日10:57:313
 */
@AllArgsConstructor
public class ForkJoinEasyTest extends RecursiveTask {

    //    开始处理的位置
    private int start;
    //     结束处理的位置
    private int end;
    //     最大可处理任务
    private final int maxTask = 20;
    //    待处理的任务
    private int[] nums = null;

    @Override
    protected Object compute() {

        System.out.println(" ---  分裂任务 --- ");
        int sum = 0;

        // 使用forkJoin第一步： 判断任务是否可以处理
        if (maxTask > (end - start)) {
            for (int i = start; i <= end; i++) {
                sum += nums[i];
            }
            System.out.println(" start :  " + start + " end :   " + end + "结果是：：：：：" + sum + "  执行线程   线程名字 ： --- !!! " + Thread.currentThread().getName() + "  !!! ----- ");
        } else {


            System.out.println("拆分线程的线程名字为 ： --- !!! " + Thread.currentThread().getName() + "  !!! ----- ");

            // 拆分任务
            int middle = (start + end) / 2;
            ForkJoinEasyTest leftNums = new ForkJoinEasyTest(start, middle, nums);
            ForkJoinEasyTest rightNums = new ForkJoinEasyTest(middle + 1, end, nums);
//            invokeAll(leftNums,rightNums);
            leftNums.fork();
            rightNums.fork();
            sum = (Integer) leftNums.join() + (Integer) rightNums.join();
            System.out.println("  合并  --------- !   第 " + start + "到第 " + end + "！ --------------  结果为 ; " + sum);
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = new int[1000];
        for (int i = 1; i <= 1000; i++) {
            nums[i - 1] = i;
        }

        int sumResult = 0;
        for (int i :
                nums) {
            sumResult += i;
        }
        System.out.println("for循环算出来的值为： " + sumResult);

        ForkJoinEasyTest forkJoinEasyTest = new ForkJoinEasyTest(0, nums.length - 1, nums);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
            System.out.println("ForkJoin 算出的结果为 ： " + forkJoinPool.submit(forkJoinEasyTest).get());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 关闭线程池
//        forkJoinPool.shutdown();
    }
}
