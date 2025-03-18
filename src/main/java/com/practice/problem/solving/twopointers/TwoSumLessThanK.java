package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static int maximumSumOfPairOfNumbersLessThanK(int[] inputArray, int targetSum){
        int maxSum = -1;
        if(inputArray == null || inputArray.length < 2){
            return maxSum;
        }

        int leftIndex = 0;
        int rightIndex = inputArray.length - 1;
        int sum = 0;

        Arrays.sort(inputArray);
        while(leftIndex < rightIndex){
            sum = inputArray[leftIndex] + inputArray[rightIndex];

            if(sum < targetSum){
                maxSum = Math.max(sum, maxSum);
                leftIndex++;
            } else if(sum >= targetSum){
                rightIndex--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 1, 1, 1};
        System.out.println(maximumSumOfPairOfNumbersLessThanK(inputArray, 3));
    }

}
