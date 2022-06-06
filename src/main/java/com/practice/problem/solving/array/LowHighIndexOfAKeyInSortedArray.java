package com.practice.problem.solving.array;

import java.util.Arrays;

public class LowHighIndexOfAKeyInSortedArray {

    public static int getLowIndex(int[] inputArray, int target){
        int low = 0;
        int high = inputArray.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(inputArray[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(low < inputArray.length && inputArray[low] == target){
            return low;
        }

        return -1;
    }

    public static int getHighIndex(int[] inputArray, int target){
        int low = 0;
        int high = inputArray.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(inputArray[mid] <= target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(high == -1){
            return high;
        }

        if(high < inputArray.length && inputArray[high] == target){
            return high;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        System.out.println("Original List: " + Arrays.toString(nums) + "\n");

        int target = 5;
        int low = getLowIndex(nums, target);
        int high = getHighIndex(nums, target);
        System.out.println("Low Index of " + target + ": " + low);
        System.out.println("High Index of " + target + ": " + high);

        System.out.println();
    }
}
