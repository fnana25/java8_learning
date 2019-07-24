package com.test.reflect;

import java.lang.reflect.Method;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/22
 */
public class InvokeTest {

    public int add(int a, int b) {
        return a + b;
    }

    public String echo(String message) {
        return "hello" + message;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = InvokeTest.class;
        Object invokeTest = clazz.newInstance();
        Method method = clazz.getMethod("add",new Class[]{int.class,int.class});
        Object result = method.invoke(invokeTest,new Object[]{1,2});
        System.out.println(result);

        Method method1 = clazz.getMethod("echo",new Class[]{String.class});
        Object result1 = method1.invoke(invokeTest,new Object[]{"test"});
        System.out.println(result1);
    }
}
