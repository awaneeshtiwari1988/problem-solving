package com.practice.problem.solving.algodaily;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String generatedString = fizzBuzz.processInputNumber(15);
        System.out.println(generatedString);
    }

    private String processInputNumber(int inputNumber){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= inputNumber ; i++) {
            stringBuilder.append(getApplicableString(i));
        }

        return stringBuilder.toString();
    }

    private String getApplicableString(int number){
        if(number % 3 == 0 && number % 5 == 0){
            return "fizzbuzz";
        } else if (number % 3 == 0){
            return "fizz";
        } else if (number % 5 == 0){
            return "buzz";
        }
        return String.valueOf(number);
    }
}
