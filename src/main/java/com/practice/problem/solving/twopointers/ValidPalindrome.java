package com.practice.problem.solving.twopointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        boolean isPalindrome = true;

        s = s.toLowerCase();
        while(startIndex < endIndex){
            char startingChar = s.charAt(startIndex);
            char endingChar = s.charAt(endIndex);

            if(!Character.isLetterOrDigit(startingChar)){
                startIndex++;
            }

            if(!Character.isLetterOrDigit(endingChar)){
                endIndex--;
            }

            if(Character.isLetterOrDigit(startingChar) && Character.isLetterOrDigit(endingChar)){
                if(startingChar != endingChar){
                    return false;
                }
            } else {
                continue;
            }

            startIndex++;
            endIndex--;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        String inputString = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean output = validPalindrome.isPalindrome(inputString);
        System.out.println(output);
    }
}
