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

    public static void main(String[] args) {
        int[] inputArray = {10,20,30,40,50};
        DeleteFromArray deleteFromArray = new DeleteFromArray();
        System.out.println(deleteFromArray.deleteFromArrayBeginningBuiltIn(inputArray));
        System.out.println(Arrays.toString(deleteFromArray.deleteFromBeginning(inputArray)));
    }
}
