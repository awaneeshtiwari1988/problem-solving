package com.practice.problem.solving.array;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(maxProduct, maxProduct * nums[i]);
            minProduct = Math.min(minProduct, minProduct * nums[i]);
            result = Math.max(maxProduct, result);
        }

        return result;
    }
}
