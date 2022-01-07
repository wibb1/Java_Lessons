package com.campbell;
// Create a suitably named package containing a class called Series

public class Series {
    public Series() {
    }
// with the following static methods:
    // nSum(int n) returns the sum of all numbers from 0 to n. The first 10 numbers are:
    // 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55.

    public static long nSum(int n) {
        if (n < 0) return -1;
        return (n * (n + 1)) / 2;
    }

    //
    // factorial(int n) returns the product of all numbers from 1 to n
    //      i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
    // The first 10 factorials are:
    // 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800.
    public static int factorial(int n) {
        if (n < 0) return -1;
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }
    //
    // fibonacci(n) returns the nth Fibonacci number. These are defined as:
    // f(0) = 0
    // f(1) = 1
    // f(n) = f(n-1) + f(n-2)
    // (so f(2) is also 1. The first 10 fibonacci numbers are:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.

    public static long fibonacci(int n) {
        if (n < 0) return -1;
        else if (n == 0) return 0;
        else if (n <= 2) return 1;
        else {
            int oldResult = 1;
            int newResult = 1;
            int tempResult;
            for (int i = 3; i < n; i++) {
                tempResult = newResult;
                newResult += oldResult;
                oldResult = tempResult;
            }
            return newResult + oldResult;
        }
    }
    // When you have tested your functions, delete the Main class and
    // produce a jar file.
    //
    // Create a new project and add your Series library, then test the
    // three methods in the main() method of your new project.


}
