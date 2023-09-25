package com.practice.problem.solving.algodaily;

import com.practice.problem.solving.strings.LongestSubstring;

public class LongestPalindromeSubstring {

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = returnPalindromeLength(s,i, i);
            int len2 = returnPalindromeLength(s, i , i+1);
            int len = Math.max(len1,len2);

            if(len > endIndex - startIndex){
                startIndex = i - (len - 1)/2;
                endIndex = i+ len/2;
            }
        }

        return s.substring(startIndex, endIndex+1).length();
    }

    private int returnPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public int longestPalindromSubstring(String s){
        int[] charCount = new int[128];
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        int len = 0;
        for (int count : charCount) {
            len += 2 * (count / 2);
        }
        return len < s.length() ? len + 1 : len;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        System.out.println(longestPalindromeSubstring.longestPalindrome("abccccdd"));
    }
}
