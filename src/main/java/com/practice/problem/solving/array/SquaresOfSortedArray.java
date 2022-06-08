package com.practice.problem.solving.array;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums){
        int[] squares = new int[nums.length];
        int startIndex = 0;
        int endIndex = nums.length - 1;
        for(int i = nums.length - 1; i >=0; i--){
            int currentNum = 0;
            if(Math.abs(nums[startIndex]) < Math.abs(nums[endIndex])){
                currentNum = nums[endIndex];
                endIndex--;
            } else {
                currentNum = nums[startIndex];
                startIndex++;
            }

            squares[i] = currentNum*currentNum;
        }

        return squares;
    }

    public static void main(String[] args) {

    }
}
