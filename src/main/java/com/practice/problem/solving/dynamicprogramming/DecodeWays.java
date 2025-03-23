package com.practice.problem.solving.dynamicprogramming;

public class DecodeWays {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int length = s.length();
        int[] decodeWays = new int[length - 1];

        // Base case:
        decodeWays[0] = 1;

        // First character not equal to 0
        decodeWays[1] = s.charAt(0) != 0 ? 1 : 0;

        for(int i = 2; i <= length; i++){
            // Single character check
            if(s.charAt(i-1) != '0'){
                decodeWays[i] += decodeWays[i-1];
            }

            // Two digit
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26){
                decodeWays[i] += decodeWays[i-2];
            }
        }

        return decodeWays[length];
    }
}
