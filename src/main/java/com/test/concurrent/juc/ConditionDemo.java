package com.test.concurrent.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/3 15:57
 */
public class ConditionDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "线程开始执行。。。");
        System.out.println(Thread.currentThread().getName() + "线程进入等待");
        try {
            lock.lock();
            condition.await();
            System.out.println(Thread.currentThread().getName() + "线程被唤醒，执行任务结束。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConditionDemo());
        thread.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }
}
