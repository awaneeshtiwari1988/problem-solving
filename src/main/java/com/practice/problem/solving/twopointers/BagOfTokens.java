package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0;
        int right = tokens.length - 1;
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;

        while (left <= right) {
            if(power >= tokens[left]){
                score++;
                power -= tokens[left];
                left++;
                maxScore = Math.max(maxScore,score);
            } else if(score > 0){
                score--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
