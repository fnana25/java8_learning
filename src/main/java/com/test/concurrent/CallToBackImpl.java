package com.test.concurrent;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/1/29 14:57
 */
public class CallToBackImpl implements Animal.CallToBack {

    private Animal animal;

    public CallToBackImpl(Animal animal){
        this.animal = animal;
    };

    @Override
    public void win() {
        animal.stop();
    }
}
