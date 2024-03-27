package com.practice.problem.solving.twopointers;

public class NextGreaterElement {

    public int nextGreaterElement(int n) {

        // Step 1: Convert number to array
        char[] digits = String.valueOf(n).toCharArray();

        // Step 2: Find the first decreasing digit
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i+1]){
            i--;
        }

        // Step 3: If no such digit is found return -1.
        if(i == -1){
            return -1;
        }

        // Step 4: Find the smallest digit greater than the Found Digit
        int j = digits.length - 1;
        while (j > i && digits[j] <= digits[i]){
            j--;
        }

        // Step 5: Swap the characters between i and j.
        swap(digits, i, j);

        // Step 6: Revers the digits after i.
        reverseDigits(digits, i +1);

        // Step 7: Convert the modified array into a number
        long result = Long.parseLong(String.valueOf(digits));

        // Step 8: Return -1 if the number is greater the max value
        if(result > Integer.MAX_VALUE){
            return -1;
        }

        return (int) result;
    }

    private void reverseDigits(char[] digits, int i) {
        int end = digits.length - 1;
        while (i < end){
            swap(digits, i, end);
            i++;
            end--;
        }
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int output = nextGreaterElement.nextGreaterElement(21);
        System.out.println(output);
    }
}
