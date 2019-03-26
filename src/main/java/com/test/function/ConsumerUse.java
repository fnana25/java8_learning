package com.test.function;

import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * Consumer Use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class ConsumerUse {

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello :" + LocalDateTime.now());
    }
}
