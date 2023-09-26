package com.practice.problem.solving.array.rotatearray;

/**
 * We’re given a sorted integer array, nums and an integer value, target.
 * The array is rotated by some arbitrary number. Search the target in this array. If the target does not exist then
 * return -1.
 *
 * Algorithm is : Follow binary search.
 */
public class SearchRotatedArray {

    private int getNumInRotatedArray(int[] inputArray, int target){
        int left = 0;
        int right = inputArray.length - 1;

        if(left > right){
            return -1;
        }

        while (left <= right){
            int middle = left + (right - left)/2;

            if(target == inputArray[middle]){
                return middle;
            }

            if(inputArray[left] <= inputArray[middle]){
                if(inputArray[left] <= target && target < inputArray[middle]){
                    right = middle -1;
                } else {
                    left = middle + 1;
                }
            } else {
                if(inputArray[middle] < target && target <= inputArray[right]){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        int[] inputArray = {1,0,1,1,1};
        System.out.println(searchRotatedArray.getNumInRotatedArray(inputArray,0));
    }
}
