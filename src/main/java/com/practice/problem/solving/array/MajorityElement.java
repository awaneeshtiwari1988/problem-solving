package com.practice.problem.solving.array;

import java.util.Arrays;

public class MajorityElement {

    public int getMajorityElement(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }

        // Perform sorting of input Array. - O(nlogn)
        Arrays.sort(nums);

        int candidate = nums[nums.length/2];
        int firstOccurrence = firstOccurrence(nums, candidate);
        int lastOccurrence = lastOccurrence(nums, candidate);
        int count = lastOccurrence - firstOccurrence + 1;

        return count > (nums.length)/2 ? candidate : -1;
    }

    private int lastOccurrence(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int currentIndex = -1;

        while(leftIndex <= rightIndex){
            int middleIndex = leftIndex + (rightIndex - leftIndex)/2;
            if(nums[middleIndex] < target){
                leftIndex = middleIndex + 1;
            } else if (nums[middleIndex] > target){
                rightIndex = middleIndex - 1;
            } else {
                currentIndex = middleIndex;
                leftIndex = middleIndex + 1;
            }
        }


        return currentIndex;
    }

    private int firstOccurrence(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int currentIndex = -1;

        while(leftIndex <= rightIndex){
            int middleIndex = leftIndex + (rightIndex - leftIndex)/2;
            if(nums[middleIndex] < target){
                leftIndex = middleIndex + 1;
            } else if (nums[middleIndex] > target){
                rightIndex = middleIndex - 1;
            } else {
                currentIndex = middleIndex;
                rightIndex = middleIndex - 1;
            }
        }

        return currentIndex;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        // Non Sorted - non guaranteed that majority element exists
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement.getMajorityElement(nums));
    }
}
