package com.practice.problem.solving.twopointers;

import javax.lang.model.util.Elements;

public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        // Step 1: Convert to array of characters
        char[] inputArray = s.toLowerCase().toCharArray();

        // Step 2: Initialize two pointers
        int startIndex = 0;
        int endIndex = inputArray.length - 1;

        while (startIndex < endIndex) {
            while (startIndex < endIndex && "aeiouAEIOU".indexOf(inputArray[startIndex]) == -1) {
                startIndex++;
            }

            while (startIndex < endIndex && "aeiouAEIOU".indexOf(inputArray[endIndex]) == -1) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                swap(inputArray, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }
        }

        return String.valueOf(inputArray);
    }

    private void swap(char[] inputArray, int startIndex, int endIndex) {
        char temp = inputArray[startIndex];
        inputArray[startIndex] = inputArray[endIndex];
        inputArray[endIndex] = temp;
    }

    public static void main(String[] args) {
        ReverseVowelsOfString solution = new ReverseVowelsOfString();
        System.out.println(solution.reverseVowels("hello")); // Output: "holle"
        System.out.println(solution.reverseVowels("leetcode")); // Output: "leotcede"
    }
}
