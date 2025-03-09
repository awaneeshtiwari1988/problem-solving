package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findNumbers(int[] inputArray, int target) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < inputArray.length; i++) {
            int val = target - inputArray[i];
            if (numMap.containsKey(inputArray[i])) {
                result[0] = numMap.get(val);
                result[1] = i;
            } else {
                numMap.put(val, i);
            }
        }

        return result;
    }
}
