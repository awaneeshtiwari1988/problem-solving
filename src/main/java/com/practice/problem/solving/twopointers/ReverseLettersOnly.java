package com.practice.problem.solving.twopointers;

public class ReverseLettersOnly {

    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] characters = s.toCharArray();
        while (left < right){
            if(!Character.isAlphabetic(characters[left])){
                left++;
            } else if (!Character.isAlphabetic(characters[right])){
                right--;
            } else {
                char ch = characters[left];
                characters[left] = characters[right];
                characters[right] = ch;
                left++;
                right--;
            }
        }

        return String.valueOf(characters);
    }

    public static void main(String[] args) {
        ReverseLettersOnly reverseLettersOnly = new ReverseLettersOnly();
        String val = reverseLettersOnly.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(val);
    }
}
