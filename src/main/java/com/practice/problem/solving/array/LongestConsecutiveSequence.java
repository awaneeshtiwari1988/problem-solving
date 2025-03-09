package com.practice.problem.solving.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutiveSequence(int[] inputArray){
        Set<Integer> set = new HashSet<>();
        for(int num : inputArray){
            set.add(num);
        }

        int maxLength = Integer.MIN_VALUE;
        for(int num : set){
            if(!set.contains(num - 1)) {
                int currentVal = num;
                int count = 1;

                while (set.contains(currentVal+1)) {
                    count++;
                    currentVal = currentVal + 1;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
