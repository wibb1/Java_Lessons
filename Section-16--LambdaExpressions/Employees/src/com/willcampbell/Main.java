package com.willcampbell;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Employee jack = new Employee("Jack Hill", 12);
        Employee jill = new Employee("Jill Hill", 12);
        Employee john = new Employee("John Paul", 15);
        Employee tim = new Employee("Tim Buchalka", 200);
        Employee red = new Employee("Red Riding-hood", 18);
        Employee charming = new Employee("Prince Charming", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(jill);
        employees.add(john);
        employees.add(tim);
        employees.add(red);
        employees.add(charming);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> employee.getName().substring(0, employee.getName().indexOf(' '));


        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase(Locale.ROOT);
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("============================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + " " + employee.getAge());
            }
        }
    }
}
