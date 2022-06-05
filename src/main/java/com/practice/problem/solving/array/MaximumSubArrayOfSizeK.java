package com.practice.problem.solving.array;

public class MaximumSubArrayOfSizeK {

    // Brute Force
    private int maximumSumOfSubArrayOfSizeKBrute(int[] inputArray, int k){
        int maxSum = 0;
        for(int i =0; i < inputArray.length - k; i++){
            int currentSum = 0;
            for (int j = i; j < i+k; j++) {
                currentSum = currentSum + inputArray[j];
            }

            maxSum = Math.max(maxSum,currentSum);
        }

        return maxSum;
    }

    // Sliding Window Pattern
    private int maximumSumOfSubArrayOfSizeKSlidingWindow(int[] inputArray, int k){
        int maxSum = 0;
        int currentSum = 0;
        int startIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum += inputArray[i];

            if(i >=  k -1){
                maxSum = Math.max(currentSum, maxSum);
                currentSum -= inputArray[startIndex];
                startIndex++;
            }
        }

        return  maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArrayOfSizeK maximumSubArrayOfSizeK = new MaximumSubArrayOfSizeK();
        int[] inputArray = {2, 1, 5, 1, 3, 2 };
        int size = 3;
        System.out.println(maximumSubArrayOfSizeK.maximumSumOfSubArrayOfSizeKBrute(inputArray,size));
        System.out.println(maximumSubArrayOfSizeK.maximumSumOfSubArrayOfSizeKSlidingWindow(inputArray,size));
    }
}
