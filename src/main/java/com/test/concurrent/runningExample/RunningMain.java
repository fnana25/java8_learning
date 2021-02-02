package com.test.concurrent.runningExample;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/1/29 15:07
 */
public class RunningMain {

    public static void main(String[] args) {
        Rabbit animal1 = new Rabbit();
        Tortoise animal2 = new Tortoise();

        CallToBackImpl callToBack1 = new CallToBackImpl(animal1);
        animal2.callToBack = callToBack1;
        CallToBackImpl callToBack2 = new CallToBackImpl(animal2);
        animal1.callToBack = callToBack2;
        animal1.start();
        animal2.start();
    }
}
