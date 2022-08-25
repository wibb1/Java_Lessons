package com.willcampbell;

import java.util.Locale;

public class StringUtilities {
    private int charsAdded = 0;

    public void addChar(StringBuilder stringBuilder, char c) {
        stringBuilder.append(c); // not using the same string builder
        charsAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase(Locale.ROOT);
        return "Prefix_" + upper;
    }

    public String addSuffix(String str) {
        return str + "__Suffix";
    }
}
