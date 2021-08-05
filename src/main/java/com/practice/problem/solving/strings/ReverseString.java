package com.practice.problem.solving.strings;

/**
 * Given a string, reverse all of its characters and return the resulting string.
 */
public class ReverseString {
    public String reverseStringByStringBuilder(String inputString){
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.reverse().toString();
    }

    public String reverseStringByTraversingChars(String inputString){
        String reverseString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reverseString = reverseString.concat(String.valueOf(inputString.charAt(i)));
        }

        return reverseString;
    }
}
