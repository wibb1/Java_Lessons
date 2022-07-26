package com.willcampbell;

import java.util.*;
import java.util.logging.StreamHandler;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "B6", "G53", "G49", "g64",
                "G60", "G50", "I26", "I17", "I29", "O71"
        );

        List<String> gNumbers = new ArrayList<>();
//
//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase(Locale.ROOT).startsWith("G")) {
//                gNumbers.add(number);
//                System.out.println(number);
//            };
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted().forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("====================================");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee john = new Employee("John Doe", 30);
        Employee jill = new Employee("Jill Hill", 40);
        Employee jack = new Employee("Jack Hill", 30);
        Employee paul = new Employee("Paul Candle", 20);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jill);
        hr.addEmployee(jack);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(paul);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream().flatMap(department -> department.getEmployees().stream()).forEach(System.out::println);

        List<String> sortedGNumbers = someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G"))
                .sorted().collect(Collectors.toList());

        sortedGNumbers.forEach(System.out::println);

        List<String> sortedGNumbers2 = someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G"))
                .sorted().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        sortedGNumbers2.forEach(System.out::println);

        Map<Integer, List<Employee>> groupedByAge = departments.stream().flatMap(department -> department.getEmployees()
                .stream()).collect(Collectors.groupingBy(Employee::getAge));

        System.out.println(groupedByAge);

        departments.stream().flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2).ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count();
        // count doesn't print because it is not within the print statement.  The cout() is required because it ends the
        // statement and only then is it executed thus printing the values from the filter
    }
}
