package com.test.reflect.dynamic;

import java.lang.reflect.Proxy;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class Test {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        DynamicSubject handler = new DynamicSubject(realSubject);
        ISubject subject = (ISubject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().  getInterfaces(),handler);
        subject.request();
    }
}
