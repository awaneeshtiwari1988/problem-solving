package com.practice.problem.solving.stack;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                output[i] = i - index;
            }

            stack.push(i);
        }

        return output;
    }
}
