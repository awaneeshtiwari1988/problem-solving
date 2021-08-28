package com.practice.problem.solving.array;

import java.util.*;
import java.util.stream.Collectors;

public class FindSingleOccurrence {

    public int findOnce(int[] arr, int n){
        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
        return map.keySet().stream().filter(k -> map.get(k) == 1).findAny().orElse(-1);
    }
}
