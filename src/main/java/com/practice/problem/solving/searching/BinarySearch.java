package com.practice.problem.solving.searching;

public class BinarySearch {

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;
        int startIndex = -1;
        int endIndex = -1;

        while(left <= right){
            int middle = left + (right - left)/2;

            if(target == nums[middle]){
                startIndex = middle;
                endIndex = startIndex;
                while(nums[endIndex] <= target){
                    endIndex++;
                }
                return new int[]{startIndex, endIndex};
            } else if (target < nums[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{-1,-1};
    }

    public static int binarySearch(int[] inputArray, int target){
        if(inputArray == null || inputArray.length ==0){
            return 0;
        }

        int left = 0;
        int right = inputArray.length - 1;

        while(left <= right){
            int middle = left + (right - left)/2;
            if(inputArray[middle] == target){
                return middle;
            } else if (inputArray[middle] < target){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        int[] input = new int[]{5,7,7,8,8,10};
        int[] output = searchRange(input,8);
        System.out.println(output);

        int index = binarySearch(new int[]{1, 3, 5, 6}, 7);
        System.out.println(index);
    }
}
