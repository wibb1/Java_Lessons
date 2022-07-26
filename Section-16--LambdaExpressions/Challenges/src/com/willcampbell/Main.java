package com.willcampbell;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Challenge #1
        Runnable runnable1 = () -> {
            String string = "Let's split this up into an array";
            List<String> parts = Arrays.asList(string.split(" "));
            parts.forEach(System.out::println);
        };
//        Challenge #2
        Function<String, String> secondStringFunction = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
//        Challenge #3
        System.out.println(secondStringFunction.apply("1234567890"));

//        Challenge #5
        System.out.println(everySecondCharacter(secondStringFunction, "1234567890"));

//        Challenge #6
        Supplier<String> iLoveJava = () -> "I love Java!";

//        Challenge #7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

//      Challenge #8
//      1. - when can we use a Lambda to implement an interface?
//        An interface needs to be a functional interface and have only one method that must be implemented by the lambda
//      2. - can we use a lambda function to implement the Callable interface?
//        Yes it only has one method that must be implemented - call()
//      3. - is Comparator interface functional
////      Comparator is functional because only compare() must be implemented

//      Challenge #9&10&11
        List<String> topNames2015 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob");
        topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1))
                .sorted().forEach(System.out::println);
        System.out.println("====================================");

//    Challenge #12
        System.out.println(
                topNames2015
                        .stream()
                        .map(s -> s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1))
                        .filter(s -> s.startsWith("A"))
                        .count()
        );
        System.out.println("====================================");

//        Challenge #13, 14 & 15 - need to add a terminal operator to his coe as below to print the values in the peek call

        List<String> newList = topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println("====================================");

    }

    //        Challenge #4
    private static String everySecondCharacter(Function<String, String> func, String s) {
        return func.apply(s);
    }
}
