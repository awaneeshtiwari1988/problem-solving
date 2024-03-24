package com.practice.problem.solving.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length - 2; j++) {
                if(j > i+1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int startIndex = j+1;
                int endIndex = nums.length - 1;

                while (startIndex < endIndex){
                    long sum = (long)nums[i] + nums[j] + nums[startIndex] + nums[endIndex];
                    if(sum == target){
                        output.add(Arrays.asList(nums[i],nums[j],nums[startIndex],nums[endIndex]));
                        while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]){
                            startIndex++;
                        }

                        while (startIndex < endIndex && nums[endIndex] == nums[endIndex - 1]){
                            endIndex--;
                        }

                        startIndex++;
                        endIndex--;
                    } else if (sum < target){
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> output = fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        output.forEach(lst -> System.out.println(Arrays.toString(lst.toArray())));
    }
}
