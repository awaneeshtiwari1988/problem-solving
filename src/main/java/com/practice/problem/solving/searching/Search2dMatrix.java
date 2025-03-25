package com.practice.problem.solving.searching;

public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        for (int[] nums : matrix) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right){
                int middle = left + (right - left)/2;
                if(nums[middle] == target){
                    return true;
                } else if(nums[middle] < target){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20},{23,30,34,60}};
        Search2dMatrix search2dMatrix = new Search2dMatrix();
        System.out.println(search2dMatrix.searchMatrix(matrix, 13));
    }
}
