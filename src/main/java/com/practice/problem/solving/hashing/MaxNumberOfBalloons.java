package com.practice.problem.solving.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text){
        if(text == null || text.length() == 0){
            return 0;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        // Populate from string text
        for (Character ch : text.toCharArray()) {
            frequencyMap.put(String.valueOf(ch), frequencyMap.getOrDefault(String.valueOf(ch),0) + 1);
        }

        // Get the number of occurrences of each character
        int b = frequencyMap.getOrDefault("b", 0);
        int a = frequencyMap.getOrDefault("a", 0);
        int l = frequencyMap.getOrDefault("l", 0)/2;
        int o = frequencyMap.getOrDefault("o", 0)/2;
        int n = frequencyMap.getOrDefault("n", 0);

        return Math.min(b, Math.min(a,Math.min(l,Math.min(o,n))));
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
    }

}
