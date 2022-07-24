package com.willcampbell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John", 15);
        Employee tim = new Employee("Tim", 200);
        Employee jack = new Employee("Jack", 12);
        Employee jill = new Employee("Jill", 12);
        Employee red = new Employee("Red", 18);
        Employee charming = new Employee("Prince", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(jill);
        employees.add(john);
        employees.add(tim);
        employees.add(red);
        employees.add(charming);
        System.out.println("============================");
        printEmployeesByAge(employees, "Employees over 15", employee -> employee.getAge() > 15);
        System.out.println("============================");
        printEmployeesByAge(employees, "Employees under 15", employee -> employee.getAge() < 15);
        System.out.println("============================");
        printEmployeesByAge(employees, "Employees younger than 100", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 100;
            }
        });
        System.out.println("============================");

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));//false
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));//true

        System.out.println(greaterThan15.and(lessThan100).test(50)); // true
        System.out.println(greaterThan15.and(lessThan100).test(5)); // false

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10 ; i++) {
            System.out.println(randomSupplier.get());
        }
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
