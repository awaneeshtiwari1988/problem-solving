package com.practice.problem.solving.application.frequencymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FrequencyMapStack {

    private Map<Integer, Integer> frequencyMap = new HashMap<>();
    private Map<Integer, Stack<Integer>> frequencyStackMap = new HashMap<>();

    private static int maxFrequency;

    public void push(int element){
        int frequency = frequencyMap.getOrDefault(element, 0) + 1;
        frequencyMap.put(element,frequency);

        if(frequency > maxFrequency){
            maxFrequency = frequency;
        }

        frequencyStackMap.computeIfAbsent(frequency, st -> new Stack<>()).push(element);
    }

    public int pop(){
        int top = frequencyStackMap.get(maxFrequency).pop();
        frequencyMap.put(top, frequencyMap.get(top) - 1);
        if(frequencyStackMap.get(maxFrequency).isEmpty()){
            maxFrequency--;
        }

        return top;
    }

    public static void main(String[] args) {
        FrequencyMapStack frequencyMapStack = new FrequencyMapStack();
        frequencyMapStack.push(5);
        frequencyMapStack.push(7);
        frequencyMapStack.push(5);
        frequencyMapStack.push(7);
        frequencyMapStack.push(4);
        frequencyMapStack.push(5);
        System.out.println(frequencyMapStack.pop());
        System.out.println(frequencyMapStack.pop());
    }

}
