package com.practice.problem.solving.array;

import java.util.Arrays;

public class ProductArraysExceptSelf {

    public static int[] productArraysExceptSelf(int[] inputArray){
        // Create prefix Array
        int[] prefixProduct = new int[inputArray.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < inputArray.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1]*inputArray[i-1];
        }

        int[] suffixProduct = new int[inputArray.length];
        suffixProduct[inputArray.length - 1] = 1;
        for (int i = inputArray.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * inputArray[i+1];
        }

        int[] answer = new int[inputArray.length];
        for (int i = 0;  i < inputArray.length; i++) {
            answer[i] = prefixProduct[i] * suffixProduct[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4};
        int[] answer = productArraysExceptSelf(inputArray);
        System.out.println(Arrays.toString(answer));
    }
}
