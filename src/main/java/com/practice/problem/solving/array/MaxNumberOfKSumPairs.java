package com.practice.problem.solving.array;

import java.util.*;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> complementMap = new HashMap<>();
        int numberOfOperations = 0;
        for(int i =0; i < nums.length; i++){
            int complement = k - nums[i];
            if(complementMap.containsKey(nums[i]) && complementMap.get(nums[i]) > 0){
                complementMap.put(nums[i],complementMap.get(nums[i]) - 1);
                numberOfOperations++;
            } else {
                if(complement > 0){
                    complementMap.put(complement, complementMap.get(complement) == null ? 1
                            : complementMap.get(complement) + 1);
                }
            }
        }

        return numberOfOperations;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();
        int[] inputArray = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        System.out.println(maxNumberOfKSumPairs.maxOperations(inputArray,3));
    }
}
