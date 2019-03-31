package com.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * flatMap
 *
 * @author fengna
 * @date 2019/3/28
 */
public class Stream5 {

    public static void main(String[] args) {

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2),Arrays.asList(1,23,4),Arrays.asList(11,2,34,89));
        stream.flatMap(list -> list.stream()).map(i -> i * 2).forEach(System.out::println);
    }
}
