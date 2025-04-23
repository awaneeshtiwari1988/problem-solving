package com.practice.problem.solving.array.rotatearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We’re given an array of integers, nums. Rotate the array by n elements, where n is an integer:
 *
 * For positive values of n, perform a right rotation.
 * For negative values of n, perform a left rotation.
 *
 * Make changes to the original array.
 *
 * Algorithm to perform rotations:
 *
 * 1. Normalize the number of rotations
 *      a. If number of rotations is greater than the number of elements in the array then number of rotations equals
 *      the modular division from number of elements in the array, that is numberOfRotations = numberOfRotations % lengthOfArray.
 *      b. If number of rotations is negative then number of rotations is equal to the subtraction of absolute value of
 *      number of rotations with the array length, that is numberOfRotations = array.length - Math.abs(numberOfRotations)
 *
 * 2. Reverse the original array
 *      - reverse logic could be starting with both the end and keep on swapping and moving on towards the center.
 * 3. Reverse the elements from 0 to n - 1.
 * 4. Reverse the elements from n to length - 1.
 */
public class RotateArray {

    public int[] rotateArray(int[] inputArray, int n) {
        if (inputArray.length == 0) {
            return inputArray;
        }

        // Normalize Rotations
        n = normalizeRotations(inputArray, n);

        // Reverse the elements in the original array
        reverseArray(inputArray, 0, inputArray.length - 1);

        // Reverse the elements in the original array from 0 to n-1
        reverseArray(inputArray, 0, n - 1);

        // Reverse the elements from n to length - 1
        reverseArray(inputArray, n, inputArray.length - 1);

        return inputArray;
    }

    private int normalizeRotations(int[] inputArray, int n) {
        if (n >= inputArray.length) {
            n = n % inputArray.length;
        }

        if (n < 0) {
            n = inputArray.length - Math.abs(n);
        }
        return n;
    }

    private void reverseArray(int[] inputArray, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = inputArray[j];
            inputArray[j] = inputArray[i];
            inputArray[i] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] inputArray = {-1, -100, 3, 99};
        System.out.println(Arrays.toString(rotateArray.rotateArray(inputArray,2)));

        int[] inputArray1 = {1, 10, 20, 0, 59, 86, 32, 11, 9, 40};
        System.out.println(Arrays.toString(rotateArray.rotateArray(inputArray1,-3)));
    }

}
