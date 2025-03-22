package com.practice.problem.solving.strings;

public class LongestPalindromeString {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i =0; i < s.length();i++){
            int len1 = getPalindromeLength(s, i, i);
            int len2 = getPalindromeLength(s, i, i+1);

            int maxLength = Math.max(len1,len2);

            if(maxLength > (end - start)){
                start = i - (maxLength - 1)/2;
                end = i + maxLength/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int getPalindromeLength(String inputString, int left, int right){
        while(left >= 0 && right < inputString.length() && inputString.charAt(left) == inputString.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();
        System.out.println(longestPalindromeString.longestPalindrome(s));
    }
}
