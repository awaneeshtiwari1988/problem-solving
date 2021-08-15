package com.practice.problem.solving.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {

        public static void main (String[] args) throws IOException {
            //code
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfTestCases = Integer.parseInt(bufferedReader.readLine().trim());
            int sizeOfArray = 0;
            int sizeOfRotation = 0;
            int[] inputArray;

            while(numberOfTestCases > 0){
                String firstInputLine = bufferedReader.readLine().trim();
                String[] firstLineArray = firstInputLine.split(" ");
                sizeOfArray = Integer.parseInt(firstLineArray[0]);
                sizeOfRotation = Integer.parseInt(firstLineArray[1]);
                inputArray = new int[sizeOfArray];

                String[] inputArrayLine = bufferedReader.readLine().trim().split(" ");

                for(int i =0; i < sizeOfArray;i++){
                    inputArray[i] = Integer.parseInt(inputArrayLine[i]);
                }

                rotateArray(inputArray, sizeOfRotation);

                numberOfTestCases--;
            }
        }

        public static void rotateArray(int[] inputArray, int sizeOfRotation){
            // Create two temporary arrays one with the size of rotation and the array with remaining elements
            int[] tempArray_1 = new int[sizeOfRotation];
            int numberOfElementsInTempArray_2 = inputArray.length - sizeOfRotation;
            int[] tempArray_2 = new int[inputArray.length];

            // Populate elements in both the arrays
            if (sizeOfRotation >= 0)
                System.arraycopy(inputArray, 0, tempArray_1, 0, sizeOfRotation);

            if (numberOfElementsInTempArray_2 >= 0)
                System.arraycopy(inputArray, sizeOfRotation, tempArray_2, 0, numberOfElementsInTempArray_2);

            // Combine the elements of the 1st subarray with second after the elements of the second subarray
            for(int i = numberOfElementsInTempArray_2, j = 0; j < sizeOfRotation;j++){
                tempArray_2[i] = tempArray_1[j];
                i++;
            }

            // Output the rotated Array
            for (int j : tempArray_2) {
                System.out.print(j + " ");
            }

            System.out.println("");
        }
}
