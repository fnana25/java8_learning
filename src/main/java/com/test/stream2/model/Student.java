package com.test.stream2.model;

import lombok.Builder;
import lombok.Data;

/**
 * Student
 *
 * @author fengna
 * @date 19/4/1 20:33
 */
@Data
@Builder
public class Student {

    private String  name;

    private int score;
}
