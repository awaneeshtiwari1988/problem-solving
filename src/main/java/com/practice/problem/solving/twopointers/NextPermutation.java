package com.practice.problem.solving.twopointers;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int size = nums.length;

        // Step 1: Find the pivot element:
        int i = size - 2;
        while (i >=0 && nums[i] >= nums[i+1]){
            i--;
        }

        // Step 2: Find the element to swap:
        if(i >= 0){
            int j = size - 1;
            while (j >=0 && nums[j] <= nums[i]){
                j--;
            }

            // Step 3: Swap the element
            swap(nums, i, j);
        }

        // Step 4: Reverse the elements
        reverse(nums, i+1, size - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
