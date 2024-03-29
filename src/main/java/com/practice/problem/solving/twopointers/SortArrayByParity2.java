package com.practice.problem.solving.twopointers;

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < nums.length && oddIndex < nums.length){
            if(nums[evenIndex] % 2 != 0 && nums[oddIndex] % 2 == 0){
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }

            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            if (nums[oddIndex] % 2 != 0) {
                oddIndex += 2;
            }
        }

        return nums;
    }
}
