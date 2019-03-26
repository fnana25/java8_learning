package com.test.function.model;

import lombok.Builder;
import lombok.Data;

/**
 * Person
 *
 * @author fengna
 * @date 2019/3/26
 */
@Data
@Builder
public class Person {

    private String userName;

    private int age;

}
