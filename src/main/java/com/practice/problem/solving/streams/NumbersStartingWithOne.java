package com.practice.problem.solving.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStartingWithOne {

    public List<Integer> getNumbersStartingWithOne(List<Integer> lstInteger){
        return lstInteger.stream().filter(k -> String.valueOf(k).startsWith("1")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        NumbersStartingWithOne numbersStartingWithOne = new NumbersStartingWithOne();
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        numbersStartingWithOne.getNumbersStartingWithOne(myList).forEach(System.out::println);
    }
}
