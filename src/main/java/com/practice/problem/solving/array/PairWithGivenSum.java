package com.practice.problem.solving.array;

import java.util.Arrays;
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

    boolean findSumOfTwoOptimal(int[] A, int val) {
        Arrays.sort(A);

        int right = A.length - 1;
        int left = 0;
        while(left < right){
            int sum = A[left] + A[right];

            if(sum == val){
                return true;
            }

            if(sum < val){
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PairWithGivenSum pairWithGivenSum = new PairWithGivenSum();
        int[] input = {2, 1, 8, 4, 7, 3};
        System.out.println(pairWithGivenSum.findSumOfTwo(input,11));
        System.out.println(pairWithGivenSum.findSumOfTwoOptimal(input,11));
    }
}
