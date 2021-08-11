package com.test.concurrent.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：锁的条件对象
 * Condition对象与Lock对象是绑定的，Condition对象只能在当前Lock对象上操作。
 * 和Object类中的 wait 、notify和notifyAll 方法一样，当调用await()方法时，会释放掉当前的锁，被 signal()方法唤醒时会去竞争锁资源。
 * signal()方法必须在await()方法之后被调用，不然线程不会被唤醒。
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
            System.out.println("11111111111411");
            condition.await();
            System.out.println("11111111511111");
            System.out.println(Thread.currentThread().getName() + "线程被唤醒，执行任务结束。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConditionDemo());
        thread.start();
        System.out.println("1111111111111");
        Thread.sleep(2000);
        System.out.println("11111111111121");
        lock.lock();
        System.out.println("11111111111131");
        condition.signalAll();
        System.out.println("11111116111111");
        lock.unlock();
    }
}
