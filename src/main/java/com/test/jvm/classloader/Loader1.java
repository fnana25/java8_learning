package com.test.jvm.classloader;

/**
 * Child.str1 没有导致对子类的主动使用
 * Child.str2 加载子类时首先加载父类
 * -XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
 * -XX:+<option> 表示开启option选项
 * -XX:-<option> 表示关闭option选项
 * -XX:<option>=<value> 表示option选项的值设置为value
 * @author fengna
 * @date 2019/4/15
 */
public class Loader1 {

    public static void main(String[] args) {
        System.out.println(Child.str1);
    }
}

class Parent{

    public static String str1 = "parent";

    static {
        System.out.println("parent ....");
    }

}

class Child extends Parent{

    public static String str2 = "child";

    static {
        System.out.println("child ....");
    }
}