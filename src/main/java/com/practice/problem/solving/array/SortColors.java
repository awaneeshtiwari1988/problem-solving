package com.practice.problem.solving.array;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums){
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int currentIndex = 0;
        while(currentIndex <= endIndex){
            int temp = 0;
            if(nums[currentIndex] == 0){
                temp = nums[startIndex];
                nums[startIndex++] = nums[currentIndex];
                nums[currentIndex++] = temp;
            } else if(nums[currentIndex] == 2) {
                temp = nums[currentIndex];
                nums[currentIndex] = nums[endIndex];
                nums[endIndex--] = temp;
            } else {
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
