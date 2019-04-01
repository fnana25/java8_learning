package com.test.stream;

import com.test.stream.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stream 分组和分区
 *
 * @author fengna
 * @date 2019/3/29
 */
public class Stream13 {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                Student.builder().name("a").age(20).score(80).build(),
                Student.builder().name("b").age(21).score(92).build(),
                Student.builder().name("c").age(22).score(90).build(),
                Student.builder().name("a").age(25).score(88).build(),
                Student.builder().name("c").age(23).score(92).build()
        );
        Map<String,List<Student>> map1 = list.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String,Long> map2 = list.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        Map<String,Double> map3 = list.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        Map<Boolean,List<Student>> map4 = list.stream().collect(Collectors.partitioningBy(o -> o.getScore() > 90));

        map1.forEach((k,v) -> v.forEach(o -> System.out.println("k:" + k + "  === v:" + o)));
        map2.forEach((k,v) -> System.out.println("k : " + k + "  ====== v : " + v));
        map3.forEach((k,v) -> System.out.println("k : " + k + "  ====== v : " + v));
        map4.forEach((k,v) -> v.forEach(o -> System.out.println("k:" + k + "  === v:" + o)));
    }
}
