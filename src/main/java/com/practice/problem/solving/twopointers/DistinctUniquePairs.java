package com.practice.problem.solving.twopointers;

public class DistinctUniquePairs {

    public static int distinctUniquePairs(int[] nums, int targetNum){
        if(nums == null){
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int sum = 0;
        int count = 0;

        while (leftIndex < rightIndex){
            sum = nums[leftIndex] + nums[rightIndex];

            if(sum < targetNum){
                leftIndex++;
            } else if (sum > targetNum) {
                rightIndex--;
            } else {
                count++;
                leftIndex++;
                rightIndex--;

                // Handle Duplicates
                while(leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]){
                    leftIndex++;
                }

                while(leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                    rightIndex--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        System.out.println(distinctUniquePairs(nums, 4));
    }
}
