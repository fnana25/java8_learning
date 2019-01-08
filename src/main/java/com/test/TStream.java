package com.test;

import com.google.common.collect.Lists;
import jdk.nashorn.internal.objects.annotations.Function;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream
 *
 * @author fengna
 * @date 2019/1/8
 */
public class TStream {

    public static void main(String[] args) {

        System.out.println("====================example 1==========================");
        List<String> list = Lists.newArrayList("bcd", "cde", "def", "abc");
        List<String> result = list.stream()
                .filter(e -> e.length() >= 3)
                .map(e -> e.charAt(0))
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println("===================example 2======flatMap=====================");
        Stream.of(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8))
                .flatMap(List::stream)
                .forEach(t -> System.out.print(t + ","));
        System.out.println();

        System.out.println("====================example 3======flatMap====================");
        IntStream.of(1, 2, 3, 4)
                .flatMap(i -> IntStream.of(i, 2 * i, 3 * i))
                .forEach(t -> System.out.print(t + ","));
        System.out.println();

    }
}
