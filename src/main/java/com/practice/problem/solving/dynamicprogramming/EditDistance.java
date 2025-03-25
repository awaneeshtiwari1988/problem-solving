package com.practice.problem.solving.dynamicprogramming;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int rows = word1.length();
        int columns = word2.length();

        int[][] dp = new int[rows+1][columns+1];
        // Base case:
        for(int i =0; i<= rows; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= columns; j++){
            dp[0][j] = j;
        }

        // Fill DP Array
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1] + 1,Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        return dp[rows][columns];
    }
}
