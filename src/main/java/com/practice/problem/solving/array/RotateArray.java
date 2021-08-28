package com.practice.problem.solving.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {

        public int[] rotateArrayBySizeOfRotation(int[] inputArray, int sizeOfRotation){
            for (int i = 0; i < sizeOfRotation; i++) {
                inputArray = rotateArray(inputArray);
            }
            return inputArray;
        }

        public int[] rotateArray(int[] inputArray){
            int temp = inputArray[0];
            System.arraycopy(inputArray, 1, inputArray, 0, inputArray.length - 1);
            inputArray[inputArray.length - 1] = temp;
            return inputArray;
        }
}
