package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class NumberOfSubSequencesSatisfyingGivenCond {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long mod = 1000000007L;
        int startIndex = 0;
        int rightIndex = nums.length- 1;
        long result = 0;
        while (startIndex <= rightIndex) {
            if(nums[startIndex] + nums[rightIndex] <= target){
                result = (result + pow(2, rightIndex - startIndex, mod)) % mod;
                startIndex++;
            } else {
                rightIndex--;
            }
        }

        return (int) result;
    }

    private long pow(long base, int exponent, long mod) {
        if(exponent == 0){
            return 1;
        }
        long result = 1;
        while(exponent > 0){
            if(exponent % 2 != 0){
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exponent /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSubSequencesSatisfyingGivenCond numberOfSubSequencesSatisfyingGivenCond = new NumberOfSubSequencesSatisfyingGivenCond();
        int output = numberOfSubSequencesSatisfyingGivenCond.numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14}, 22);
        System.out.println(output);
    }
}
