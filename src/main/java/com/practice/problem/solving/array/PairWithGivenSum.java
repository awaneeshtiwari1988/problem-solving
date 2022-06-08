package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {

     boolean findSumOfTwo(int[] A, int val) {
        int complementSum = 0;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            complementSum = val - A[i];

            if(map.containsKey(A[i]) || map.containsKey(complementSum)){
                return true;
            } else {
                map.put(complementSum, complementSum);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PairWithGivenSum pairWithGivenSum = new PairWithGivenSum();
        int[] input = {2, 1, 8, 4, 7, 3};
        System.out.println(pairWithGivenSum.findSumOfTwo(input,11));
    }
}
