package com.test.function;

import com.test.function.model.Company;
import com.test.function.model.Employee;

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

    }
}
