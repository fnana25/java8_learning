package com.test.concurrent.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/1 16:53
 */
public class TestSingleThreadExceutor {

    public static void main(String[] args) {
        ExecutorService service = newSingleThreadExecutor();

        System.out.println(service);
        for (int i = 0; i < 5; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" - test executor");
                }
            });
        }
    }



}
