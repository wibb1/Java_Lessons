package com.willcampbell;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John", 15);
        Employee tim = new Employee("Tim", 200);
        Employee jack = new Employee("Jack", 12);
        Employee jill = new Employee("Jill", 12);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(jill);
        employees.add(john);
        employees.add(tim);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}
