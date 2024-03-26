package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class MinimizeMaximumPairSumArray {

    public int minPairSum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int maxSum = 0;
        Arrays.sort(nums);
        while (left <= right){
            maxSum = Math.max(maxSum, nums[left] + nums[right]);
            left++;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MinimizeMaximumPairSumArray minimizeMaximumPairSumArray = new MinimizeMaximumPairSumArray();
        int maxSum = minimizeMaximumPairSumArray.minPairSum(new int[]{3,5,4,2,4,6});
        System.out.println(maxSum);
    }
}
