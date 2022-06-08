package com.practice.problem.solving.array;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high){
        if(high > low){

            int pivot = partition(nums, low, high);

            quickSort(nums, low, pivot-1);

            quickSort(nums, pivot+1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivotValue = nums[low];
        int i = low;
        int j = high;

        while (i < j){
            while(i <= high && nums[i] <= pivotValue){
                i++;
            }

            while(nums[j] > pivotValue){
                j--;
            }

            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[low] = nums[j];
        nums[j] = pivotValue;
        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {55, 23, 26, 2, 18, 78, 23, 8, 2, 3};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
