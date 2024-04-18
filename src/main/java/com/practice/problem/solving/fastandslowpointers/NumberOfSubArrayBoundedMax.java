package com.practice.problem.solving.fastandslowpointers;

public class NumberOfSubArrayBoundedMax {

    public int numSubArrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int windowSize = 0;
        int leftPtr = 0;

        for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            if (nums[rightPtr] >= left && nums[rightPtr] <= right) {
                windowSize = rightPtr - leftPtr + 1;
                count += windowSize;
            } else if (nums[rightPtr] < left) {
                count += windowSize;
            } else {
                windowSize = 0;
                leftPtr = rightPtr + 1;
            }
        }

        return count;
    }
}
