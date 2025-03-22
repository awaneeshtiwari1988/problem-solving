package com.practice.problem.solving.searching;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = getMax(nums);
        int right = getSum(nums);

        while (left < right){
            int middle = left + (right - left)/2;
            if(canSplit(nums,k,middle)){
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private int getMax(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        for(int num : nums){
            maxValue = Math.max(maxValue, num);
        }

        return maxValue;
    }

    private int getSum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        return sum;
    }

    private boolean canSplit(int[] nums, int numberOfSubArrays, int maxSum){
        int subArrayCount = 1;
        int currentSum = 0;

        for (int num : nums) {
            if(num > maxSum){
                return false;
            }

            currentSum += num;

            if(currentSum > maxSum){
                subArrayCount++;
                currentSum = num;
            }

            if(subArrayCount > numberOfSubArrays){
                return false;
            }
        }

        return true;
    }

}
