package com.practice.problem.solving.array;

import java.util.Arrays;

public class CountZeroes {

    public int countZeroes(int[] inputArray, int n){
        return (int) Arrays.stream(inputArray).filter(i -> i == 0).count();
    }
}
