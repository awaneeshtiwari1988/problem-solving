package com.practice.problem.solving.array;

import java.util.Arrays;

public class UnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int[] cloneNums = nums.clone();
        int startIndex = cloneNums.length;
        Arrays.sort(cloneNums);
        int endIndex  = 0;
        for (int i = 0; i < cloneNums.length; i++) {
            if(cloneNums[i] != nums[i]){
                startIndex = Math.min(startIndex, i);
                endIndex = Math.max(endIndex, i);
            }
        }
        return (endIndex - startIndex >= 0 ? endIndex - startIndex +1 : 0);
    }

    public static void main(String[] args) {
        UnsortedSubArray unsortedSubArray = new UnsortedSubArray();
        int[] input = {2,6,4,8,10,9,15};
        System.out.println(unsortedSubArray.findUnsortedSubarray(input));
    }
}
