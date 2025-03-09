package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumSubArray {

    public static int maximumSumSubArray(int[] inputArray){
        if(inputArray == null || inputArray.length == 0){
            return 0;
        }

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : inputArray) {
            currentSum += num;
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static int lengthOfLongestSubArrayTargetSum(int[] inputArray, int targetSum){
        int prefixSum = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        for(int num =0; num < inputArray.length; num++){
            prefixSum += inputArray[num];

            if(prefixSum == targetSum){
                maxLength = num + 1;
            }

            if(prefixSumMap.containsKey(prefixSum - targetSum)){
                maxLength = Math.max(maxLength, num - prefixSumMap.get(prefixSum - targetSum));
            }

            if(!prefixSumMap.containsKey(prefixSum)){
                prefixSumMap.put(prefixSum, num);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        int[] inputArray = {-2,1,-3,4,-1,2,1,-5,4};
        int output = maximumSumSubArray(inputArray);
        System.out.println(output);

        int maxLength = lengthOfLongestSubArrayTargetSum(new int[]{-2, -1, 2, 1}, 1);
        System.out.println(maxLength);
    }
}
