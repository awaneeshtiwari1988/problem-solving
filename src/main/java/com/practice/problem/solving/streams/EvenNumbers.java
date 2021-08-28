package com.practice.problem.solving.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

    public List<Integer> getEventNumberList(List<Integer> integerList){
        return integerList.stream().filter(k -> k % 2 ==0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> lstInteger = Arrays.asList(10,15,8,49,25,98,32);
        EvenNumbers evenNumbers = new EvenNumbers();
        evenNumbers.getEventNumberList(lstInteger).forEach(System.out::println);
    }
}
