package com.practice.problem.solving.strings;

import com.practice.problem.solving.twopointers.ValidPalindrome;

/**
 * Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
 */
public class ValidatePalindrome {

    public boolean isPalindromeUsingBuilder(String inputString){
        String inputStringWithAlphabetsOnly = getStringWithAlphabets(inputString);
        StringBuilder stringBuilder = new StringBuilder(inputStringWithAlphabetsOnly);
        return stringBuilder.reverse().toString().equalsIgnoreCase(inputStringWithAlphabetsOnly);
    }

    public boolean isPalindromeByTraversalOfString(String inputString){
        String inputStringWithAlphabetsOnly = getStringWithAlphabets(inputString);
        String reverseString = "";
        for (int i = inputStringWithAlphabetsOnly.length() - 1; i >=0 ; i--) {
            reverseString = reverseString.concat(String.valueOf(inputStringWithAlphabetsOnly.charAt(i)));
        }

        return reverseString.equalsIgnoreCase(inputStringWithAlphabetsOnly);
    }

    private String getStringWithAlphabets(String inputString) {
        String inputStringWithAlphabetsOnly = "";
        for (int i = 0; i < inputString.length(); i++) {
            if(Character.isLetter(inputString.charAt(i))){
                inputStringWithAlphabetsOnly = inputStringWithAlphabetsOnly.concat(String.valueOf(inputString.charAt(i)));
            }
        }
        return inputStringWithAlphabetsOnly;
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(s);
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeWithSpaceAndSpecialCharacters(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right){
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);

            if(!Character.isLetterOrDigit(leftCh)){
                left++;
            } else if (!Character.isLetterOrDigit(rightCh)){
                right--;
            } else {
                if(leftCh != rightCh){
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        System.out.println(validatePalindrome.isPalindrome("A man, a plan, a canal -- Panama"));
        System.out.println(validatePalindrome.isPalindromeWithSpaceAndSpecialCharacters("A man, a plan, a canal -- Panama"));
    }
}
