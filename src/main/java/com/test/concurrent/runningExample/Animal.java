package com.test.concurrent.runningExample;

/**
 * 类描述：龟兔赛跑2000米
 *  *
 *  * 要求：
 *  * (1)兔子每 0.1 秒 5 米的速度，每跑20米休息1秒;
 *  * (2)乌龟每 0.1 秒跑 2 米，不休息；
 *  * (3)其中一个跑到终点后另一个不跑了！
 *
 * @author fengna
 * @since 2021/1/29 14:53
 */
public abstract class Animal extends Thread {

    public int length = 2000;

    public abstract void running() throws InterruptedException;

    @Override
    public void run() {
        super.run();
        while (length > 0){
            try {
                running();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static interface CallToBack{
        void win();
    }

    public CallToBack callToBack;
}
