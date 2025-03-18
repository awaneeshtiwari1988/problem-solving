package com.practice.problem.solving.twopointers;

public class TwoPointersIIndexed {

    public int[] findNumbers(int[] nums, int targetNum){
        if(nums == null){
            return new int[0];
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int sum =0;

        while(leftIndex < rightIndex){
            sum = nums[leftIndex] + nums[rightIndex];

            if(sum < targetNum){
                leftIndex++;
            } else if(sum > targetNum){
                rightIndex--;
            } else {
                int[] result = {leftIndex+1,rightIndex+1};
                return result;
            }
        }

        return new int[0];
    }

}
