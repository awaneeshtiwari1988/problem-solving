package com.practice.problem.solving.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public  int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        for(int i =0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 0;
            }
        }
        System.out.println("Non-negative: "+ Arrays.toString(nums));

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        System.out.println("Set : "+set.toString());

        for(int i = 1; i < nums.length; i++){
            System.out.println("Current Element getting checked " + i);
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    public int findMissingPositive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int correctPos = nums[i] - 1;
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {-3, -1, -4, -2, -5};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));

        nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive.findMissingPositive(nums));
    }
}
