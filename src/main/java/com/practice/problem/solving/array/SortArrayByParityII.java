package com.practice.problem.solving.array;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        if(nums.length == 0){
            return nums;
        }

        int[] outputArray = new int[nums.length];
        int[] evenElements = new int[nums.length/2];
        int[] oddElements = new int[nums.length/2];
        int j = 0, k = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                evenElements[j] = nums[i];
                j++;
            } else {
                oddElements[k] = nums[i];
                k++;
            }
        }

        int l = 0, m = 0;
        for(int i =0; i < nums.length; i++){
            if(i % 2 == 0){
                outputArray[i] = evenElements[l];
                l++;
            } else {
                outputArray[i] = oddElements[m];
                m++;
            }
        }

        return outputArray;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] nums = {4,2,5,7};
        System.out.println(sortArrayByParityII.sortArrayByParityII(nums));
    }
}
