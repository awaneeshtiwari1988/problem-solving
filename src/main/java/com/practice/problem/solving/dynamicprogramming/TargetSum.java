package com.practice.problem.solving.dynamicprogramming;

import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int totalSum = Arrays.stream(nums).sum();
        if((totalSum + target) % 2 != 0 || target > totalSum || target < -totalSum){
            return 0;
        }

        int subsetSum = (totalSum + target)/2;

        // Initialize DP array
        int[] dp = new int[subsetSum+1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = subsetSum; j >= num; j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        TargetSum solver = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solver.findTargetSumWays(nums, target));  // Output: 5
    }
}
