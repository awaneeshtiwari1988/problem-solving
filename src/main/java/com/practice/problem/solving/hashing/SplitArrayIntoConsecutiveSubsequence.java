package com.practice.problem.solving.hashing;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequence {

    public boolean isPossible(int[] nums){
        if(nums == null || nums.length < 3){
            return false;
        }

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> subSequenceMap = new HashMap<>();

        // Populate Frequency Map
        for (int num:nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate and check whether the subsequence can be created
        for(int num : nums){
            if(frequencyMap.get(num) == 0){
                continue;
            }

            if(subSequenceMap.getOrDefault(num-1,0) > 0){
                subSequenceMap.put(num-1, subSequenceMap.get(num-1)-1);
                subSequenceMap.put(num, subSequenceMap.getOrDefault(num,0)+1);

            } else if (frequencyMap.getOrDefault(num+1, 0)>0 && frequencyMap.getOrDefault(num+2, 0)>0){
                frequencyMap.put(num+1, frequencyMap.get(num+1)-1);
                frequencyMap.put(num+2, frequencyMap.get(num+2)-1);
                subSequenceMap.put(num+2, subSequenceMap.getOrDefault(num+2,0)+1);
            } else {
                return false;
            }
            frequencyMap.put(num, frequencyMap.get(num)-1);
        }

        return true;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5};
        SplitArrayIntoConsecutiveSubsequence splitArrayIntoConsecutiveSubsequence = new SplitArrayIntoConsecutiveSubsequence();
        System.out.println(splitArrayIntoConsecutiveSubsequence.isPossible(nums));
    }
}
