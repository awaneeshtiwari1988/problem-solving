package com.practice.problem.solving.dynamicprogramming;

public class LongestPalindromeSequence {

    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[][] longestPalindrome = new int[s.length()][s.length()];
        // Single Characters are palindrome of length 1
        for(int i =0; i < s.length(); i++){
            longestPalindrome[i][i] = 1;
        }

        // Build the table in bottom up manner
        for(int i =2; i <= s.length(); i++){
            for (int j = 0; j < s.length() - i; j++) {
                int k = j + i - 1;
                if(s.charAt(j) == s.charAt(k)){
                    longestPalindrome[i][j] = 2 + longestPalindrome[j + 1][k - 1];
                } else {
                    longestPalindrome[i][j] = Math.max(longestPalindrome[j+1][k], longestPalindrome[j][k-1]);
                }
            }
        }

        return longestPalindrome[0][s.length()- 1];
    }
}
