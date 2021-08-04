package com.practice.problem.solving.strings;

public class ValidatePalindrome {

    public boolean isPalindromeUsingBuilder(String inputString){
        String inputStringWithAlphabetsOnly = getStringWithAplhabets(inputString);
        StringBuilder stringBuilder = new StringBuilder(inputStringWithAlphabetsOnly);
        return stringBuilder.reverse().toString().equalsIgnoreCase(inputStringWithAlphabetsOnly);
    }

    public boolean isPalindromeByTraversalOfString(String inputString){
        String inputStringWithAlphabetsOnly = getStringWithAplhabets(inputString);
        String reverseString = "";
        for (int i = inputStringWithAlphabetsOnly.length() - 1; i >=0 ; i--) {
            reverseString = reverseString.concat(String.valueOf(inputStringWithAlphabetsOnly.charAt(i)));
        }

        return reverseString.equalsIgnoreCase(inputStringWithAlphabetsOnly);
    }

    private String getStringWithAplhabets(String inputString) {
        String inputStringWithAlphabetsOnly = "";
        for (int i = 0; i < inputString.length(); i++) {
            if(Character.isLetter(inputString.charAt(i))){
                inputStringWithAlphabetsOnly = inputStringWithAlphabetsOnly.concat(String.valueOf(inputString.charAt(i)));
            }
        }
        return inputStringWithAlphabetsOnly;
    }
}
