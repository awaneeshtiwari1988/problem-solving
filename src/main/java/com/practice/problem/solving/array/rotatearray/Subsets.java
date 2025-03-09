package com.practice.problem.solving.array.rotatearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> allSubsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        backtrack(result, new ArrayList<>(),nums,0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int startIndex) {
        result.add(new ArrayList<>(tempList));

        for (int i = startIndex; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {1,2,3};
        System.out.println(allSubsets(inputArray));
    }

}
