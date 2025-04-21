package com.practice.problem.solving.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInArray {

    public List<Integer> insertAtBeginningBuiltIn(int[] inputArray, int element){
        List<Integer> output = new ArrayList<>();
        for (int ele: inputArray) {
            output.add(ele);
        }

        output.add(0, element);
        return output;
    }

    public int[] insertAtBeginning(int[] inputArray, int element){
        int[] output = new int[inputArray.length+1];
        for(int i = inputArray.length - 1; i >= 0; i--){
            output[i+1] = inputArray[i];
        }

        output[0] = element;
        return output;
    }

    public List<Integer> insertAtGivenPositionBuiltIn(int[] inputArray, int element, int position){
        List<Integer> output = new ArrayList<>();
        for (int ele: inputArray) {
            output.add(ele);
        }

        output.add(position-1, element);
        return output;
    }

    public int[] insertAtGivenPosition(int[] inputArray, int element, int position){
        int[] output = new int[inputArray.length + 1];
        System.arraycopy(inputArray, 0, output, 0, position - 1);
        output[position - 1] = element;
        System.arraycopy(inputArray, position - 1, output, position,inputArray.length - (position - 1));
        return output;
    }

    public static void main(String[] args) {
        InsertInArray insertInArray = new InsertInArray();
        int[] inputArray = {10,20,30,40};
        System.out.println(insertInArray.insertAtBeginningBuiltIn(inputArray, 50));

        int[] output = insertInArray.insertAtBeginning(inputArray,50);
        System.out.println(Arrays.toString(output));

        System.out.println(insertInArray.insertAtGivenPositionBuiltIn(inputArray, 50, 2));
        System.out.println(Arrays.toString(insertInArray.insertAtGivenPosition(inputArray, 50, 2)));
    }
}
