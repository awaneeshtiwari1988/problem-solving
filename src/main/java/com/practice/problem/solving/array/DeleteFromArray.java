package com.practice.problem.solving.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteFromArray {

    public List<Integer> deleteFromArrayBeginningBuiltIn(int[] inputArray){
        List<Integer> output = new ArrayList<>();
        for(int ele : inputArray){
            output.add(ele);
        }

        output.remove(0);
        return output;
    }

    public int[] deleteFromBeginning(int[] inputArray){
        int[] output = new int[inputArray.length - 1];
        for(int i = 1; i < inputArray.length; i++){
            output[i-1] = inputArray[i];
        }

        return output;
    }

    public List<Integer> deleteFromAGivenPositionBuiltIn(int[] inputArray, int position){
        List<Integer> output = new ArrayList<>();
        for (int element : inputArray){
            output.add(element);
        }

        output.remove(position - 1);
        return output;
    }

    public int[] deleteFromAGivenPosition(int[] inputArray, int position){
        int[] output = new int[inputArray.length - 1];
        System.arraycopy(inputArray, 0, output, 0, position - 1);
        System.arraycopy(inputArray, position, output, position-1, inputArray.length - position);
        return output;
    }

    public List<Integer> deleteFromEndBuiltIn(int[] inputArray){
        List<Integer> output = new ArrayList<>();
        for(int ele : inputArray){
            output.add(ele);
        }

        output.remove(inputArray.length - 1);
        return output;
    }

    public int[] deleteFromEnd(int[] inputArray){
        int[] output = new int[inputArray.length - 1];
        System.arraycopy(inputArray, 0, output, 0, inputArray.length - 1);
        return output;
    }

    public List<Integer> deleteOccurrencesOfElement(int[] inputArray, int element){
        List<Integer>  output = new ArrayList<>();
        for(int ele : inputArray){
            output.add(ele);
        }

        output.remove(Integer.valueOf(element));
        return output;
    }

    public static void main(String[] args) {
        int[] inputArray = {10,20,30,40,50};
        DeleteFromArray deleteFromArray = new DeleteFromArray();
        System.out.println(deleteFromArray.deleteFromArrayBeginningBuiltIn(inputArray));
        System.out.println(Arrays.toString(deleteFromArray.deleteFromBeginning(inputArray)));
        System.out.println(deleteFromArray.deleteFromAGivenPositionBuiltIn(inputArray, 2));
        System.out.println(Arrays.toString(deleteFromArray.deleteFromAGivenPosition(inputArray, 2)));
        System.out.println(deleteFromArray.deleteFromEndBuiltIn(inputArray));
        System.out.println(Arrays.toString(deleteFromArray.deleteFromEnd(inputArray)));

        int[] input = {10, 20, 30, 30, 40, 50};
        System.out.println(deleteFromArray.deleteOccurrencesOfElement(input, 30));
    }
}
