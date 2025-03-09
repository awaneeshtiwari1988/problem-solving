package com.practice.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    private static void backtrack(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            tempList.add(nums[i]);
            used[i] = true;

            backtrack(nums, tempList, result,used);

            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {1,2,3};
        System.out.println(permute(inputArray));
    }
}
