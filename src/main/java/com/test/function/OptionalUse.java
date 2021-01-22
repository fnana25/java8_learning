package com.test.function;

import com.test.function.model.Company;
import com.test.function.model.Employee;
import com.test.function.model.Person;

import java.util.*;

/**
 * Optional use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class OptionalUse {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().name("na1").build(),
                Employee.builder().name("na2").build(),
                Employee.builder().name("na3").build()
        );
        Company company = Company.builder().name("com.na").employees(employeeList).build();

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        System.out.println(optionalCompany.map(Company::getEmployees).orElse(Collections.EMPTY_LIST));

        //orElse()，如果有值则返回该值，否则返回传递给它的参数值
        //orElseGet() 这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果
        //orElse()与orElseGet()不同之处：两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse() 方法仍然调用了createNewUser方法。与之相反，orElseGet() 方法则不创建 User 对象。
        Person user = new Person(23, "1234");
        Person result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println("orElse............." + result);
        Person result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
        System.out.println("orElseGet.............." + result2);
    }

    private static Person createNewUser() {
        System.out.println("createNewUser.................");
        return new Person(22, "12345");
    }
}
