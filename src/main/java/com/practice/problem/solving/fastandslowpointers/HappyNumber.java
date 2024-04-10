package com.practice.problem.solving.fastandslowpointers;

public class HappyNumber {

    public boolean isHappy(int inputNumber) {
        int slowPointer = inputNumber;
        int fastPointer = getSumOfSquareDigits(inputNumber);

        while(fastPointer != 1 && slowPointer != fastPointer){
            slowPointer = getSumOfSquareDigits(slowPointer);
            fastPointer = getSumOfSquareDigits(getSumOfSquareDigits(fastPointer));
        }

        return fastPointer == 1;
    }

    public int getSumOfSquareDigits(int inputNumber){
        int totalSum = 0;

        while(inputNumber > 0){
            int digit = inputNumber % 10;
            inputNumber = inputNumber / 10;
            totalSum += (int) Math.pow(digit, 2);
        }
        return totalSum;
    }
}
