package com.test.function;

import com.test.function.model.Student;

import java.util.function.Supplier;

/**
 * Supplier use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class SupplierUse {

    public static void main(String[] args) {

        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getAge());

    }
}
