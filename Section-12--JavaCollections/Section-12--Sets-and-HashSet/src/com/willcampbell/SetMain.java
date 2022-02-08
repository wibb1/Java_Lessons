package com.willcampbell;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("\nThere are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes); // the unique values from both lists - unique outer join
        System.out.println("\nUnion contains " + union.size() + " elements.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes); // the values that appear in both lists - inner join
        System.out.println("\nIntersection contains " + intersection.size() + " elements.\n");
        for (int i : intersection) {
            System.out.println(i + " is the square of " + (int) Math.sqrt(i) + " and the cube of " + (int) Math.cbrt(i) + ".");
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        System.out.println("\nSentence spilt to array and added to Set using asList.");
        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String firstWords = "all nature is but art unknown to thee";
        System.out.println("\nnatureWords is \"" + firstWords + "\"");
        String[] natureWords = firstWords.split(" ");
        nature.addAll(Arrays.asList(natureWords));

        String secondWords = "to err is human to forgive is divine";
        System.out.println("divineWords is \"" + secondWords + "\"");
        String[] divineWords = secondWords.split(" ");
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("\nAsymmetric Difference - remove words that appear in both - is and to");
        System.out.print("\nnature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.print("\ndivine - nature: ");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff1);
        System.out.println();

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("\nSymmetric difference");
        System.out.print("\nnature - divine: ");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);
        System.out.println();
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        } else {
            System.out.println("divine is NOT a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a subset of nature");
        } else {
            System.out.println("intersectionTest is NOT a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a subset of divine");
        } else {
            System.out.println("intersectionTest is NOT a subset of divine");
        }
    }

    public static void printSet(Set<String> words) {
        System.out.print("\t");
        for (String s : words) {
            System.out.print(s + " ");
        }
    }
}
