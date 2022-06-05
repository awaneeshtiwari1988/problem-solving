package com.practice.problem.solving.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public int[] rotateArrayBySizeOfRotation(int[] inputArray, int sizeOfRotation) {
        for (int i = 0; i < sizeOfRotation; i++) {
            inputArray = rotateArray(inputArray);
        }
        return inputArray;
    }

    public int[] rotateArray(int[] inputArray) {
        int temp = inputArray[0];
        System.arraycopy(inputArray, 1, inputArray, 0, inputArray.length - 1);
        inputArray[inputArray.length - 1] = temp;
        return inputArray;
    }

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

        List<Integer> lst = new ArrayList<>();
        lst.add(0, inputArray[i]);
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] inputArray = {-1, -100, 3, 99};
        System.out.println(Arrays.toString(rotateArray.rotateArray(inputArray,2)));

        int[] inputArray1 = {1, 10, 20, 0, 59, 86, 32, 11, 9, 40};
        System.out.println(Arrays.toString(rotateArray.rotateArray(inputArray1,-3)));
    }

}
