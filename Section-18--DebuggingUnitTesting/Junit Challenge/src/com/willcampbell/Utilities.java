package com.willcampbell;

public class Utilities {
    // Returns char array containing every nth char - when sourceArray.length < n, returns sourceArray


    public Utilities() {
    }

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / 2;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // Removes pairs of the same character that are next to each other,
    // by removing one occurrence of the character.
    // examples
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF"  -- the to B's are not next to each other, so they are not removed
    public String removePairs(String source) {
        // If length < 2 no pairs
        if (source == null || source.length() < 2) return source;
        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        sb.append(string[0]);
        for (int i = 1; i < string.length; i++) {
            if (string[i-1] != string[i]) {
                sb.append(string[i]);
            }
        }
        return sb.toString();
    }

    // perform a conversion based on some internal business rule.
    public int converter(int a, int b) {
        return a / b + a * 30 - 2;
    }

    public String nullIfOddLength(String source) {
        if (source == null || source.length() % 2 != 0) return null;
        return source;
    }
}
