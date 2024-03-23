package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while (startIndex < endIndex){
            int total = numbers[startIndex] +  numbers[endIndex];
            if(total == target){
                return new int[]{startIndex+1,endIndex+1};
            } else if (total < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(output));
    }
}
