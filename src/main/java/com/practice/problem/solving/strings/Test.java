package com.practice.problem.solving.strings;

public class Test {
    public static int sumDigits(int input) {
        int output = 0;
        while(input > 0 || output > 9){
            if(input == 0){
                input = output;
                output = 0;
            } else {
                output = output + input % 10;
                input = input/10;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Test.sumDigits(1));
        System.out.println(Test.sumDigits(49));
        System.out.println(Test.sumDigits(439230));
    }
}
