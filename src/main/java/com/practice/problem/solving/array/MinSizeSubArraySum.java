package com.practice.problem.solving.array;

public class MinSizeSubArraySum {

    private int finMinSubArray(int[] input, int target){
        int sum = 0;
        int lengthOfMinArray = Integer.MAX_VALUE;
        int startIndex = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];

            while(sum >= target){
                lengthOfMinArray = Math.min(lengthOfMinArray, i - startIndex +1);
                sum -= input[startIndex];
                startIndex++;
            }
        }

        return lengthOfMinArray == Integer.MAX_VALUE ? 0 : lengthOfMinArray;
    }

    public static void main(String[] args) {
        MinSizeSubArraySum minSizeSubArraySum = new MinSizeSubArraySum();
        int[] inputArray = { 2, 1, 5, 2, 3, 2 };
        System.out.println(minSizeSubArraySum.finMinSubArray(inputArray, 7));
    }
}
