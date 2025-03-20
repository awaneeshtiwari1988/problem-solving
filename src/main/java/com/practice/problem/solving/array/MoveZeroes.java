package com.practice.problem.solving.array;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroesToEnd(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int leftIndex = 0;

        for(int rightIndex = 0; rightIndex < nums.length; rightIndex++){
            if(nums[rightIndex] != 0){
                int numRight = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = numRight;
                leftIndex++;
            }
        }
    }

    public void moveZeroesToLeft(int[] nums) {
        int countOfZeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfZeroes++;
            }
        }

        int[] zeroAtStartArray = new int[nums.length];

        int k = 0;
        while (countOfZeroes > 0) {
            zeroAtStartArray[k] = 0;
            k++;
            countOfZeroes--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                zeroAtStartArray[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = zeroAtStartArray[i];
        }
    }

    public void moveZeroesToLeftBigOOfn(int[] nums){
        if(nums.length == 0){
            return;
        }

        int writeIndex = nums.length -1;
        int readIndex = nums.length - 1;

        while(readIndex >= 0){
            if(nums[readIndex] != 0){
                nums[writeIndex] = nums[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        while(writeIndex >= 0){
            nums[writeIndex] = 0;
            writeIndex--;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = { 1, 0, 2, 3, 0};
        moveZeroes.moveZeroesToLeft(nums);
        System.out.println(Arrays.toString(nums));

        int[] input = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        moveZeroes.moveZeroesToLeftBigOOfn(input);
        System.out.println(Arrays.toString(input));

        int[] numsMoveToEnd = {0,1,0,3,12};
        moveZeroes.moveZeroesToEnd(numsMoveToEnd);
        System.out.println(Arrays.toString(numsMoveToEnd));
    }
}
