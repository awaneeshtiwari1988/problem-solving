package com.practice.problem.solving.array;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

     boolean findSumOfTwo(int[] A, int val) {
         Set<Integer> traversedElements = new HashSet<>();
         for (int j : A) {
             if (traversedElements.contains(val - j) ) {
                 return true;
             }

             traversedElements.add(j);
         }

        return false;
    }

    public static void main(String[] args) {
        PairWithGivenSum pairWithGivenSum = new PairWithGivenSum();
        int[] input = {2, 1, 8, 4, 7, 3};
        System.out.println(pairWithGivenSum.findSumOfTwo(input,11));
    }
}
