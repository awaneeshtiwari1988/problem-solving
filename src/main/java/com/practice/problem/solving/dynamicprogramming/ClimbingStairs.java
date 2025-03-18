package com.practice.problem.solving.dynamicprogramming;

public class ClimbingStairs {

    public static int distinctWaysToClimbStairs(int numberOfStairs){
        if(numberOfStairs <= 1){
            return 1;
        }

        int[] result = new int[numberOfStairs + 1];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i <= numberOfStairs; i++){
            result[i] = result[i-1] + result[i-2];
        }

        return result[numberOfStairs];
    }

    public static void main(String[] args) {
        System.out.println(distinctWaysToClimbStairs(5));
    }
}
