package com.test.concurrent.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/3 17:50
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行结束，计数减一。");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("主线程执行结束。");
    }
}
