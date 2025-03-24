package com.practice.problem.solving.dynamicprogramming;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        int lengthOfString = s.length();
        int lengthOfPattern = p.length();
        boolean[][] patternMatched = new boolean[lengthOfString+1][lengthOfPattern+1];

        // Base Case
        patternMatched[0][0] = true;
        for (int i = 1; i <= lengthOfPattern; i++) {
            if(p.charAt(i-1) == '*'){
                patternMatched[0][i] = patternMatched[0][i-1];
            }
        }

        // Fill table
        for (int i = 1; i <= lengthOfString ; i++) {
            for (int j = 1; j <= lengthOfPattern; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    patternMatched[i][j] = patternMatched[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    patternMatched[i][j] = patternMatched[i-1][j] || patternMatched[i][j-1];
                }
            }
        }

        return patternMatched[lengthOfString][lengthOfPattern];
    }

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.println(wildCardMatching.isMatch("aa","a"));
    }
}
