package com.willcampbell;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

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

//        Challenge #8

    }

    //        Challenge #4
    private static String everySecondCharacter(Function<String, String> func, String s) {
        return func.apply(s);
    }
}
