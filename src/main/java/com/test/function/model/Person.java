package com.test.function.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 *
 * @author fengna
 * @date 2019/3/26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int age;

    private String userName;

}
