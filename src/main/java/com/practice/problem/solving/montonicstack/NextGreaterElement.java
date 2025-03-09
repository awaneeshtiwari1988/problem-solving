package com.practice.problem.solving.montonicstack;

import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] inputArray){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[inputArray.length];
        for(int i = inputArray.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() < inputArray[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            }

            stack.push(inputArray[i]);
        }

        return result;
    }
}
