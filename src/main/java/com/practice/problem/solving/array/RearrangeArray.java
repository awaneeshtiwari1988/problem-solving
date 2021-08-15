package com.practice.problem.solving.array;

public class RearrangeArray {

    public static void main(String[] args) {
        RearrangeArray rearrangeArray = new RearrangeArray();
        long[] arr = {4,0,2,1,3};
        rearrangeArray.arrange(arr,5);
        for (long l : arr) {
            System.out.print(l + " ");
        }

        System.out.print("");
    }

    public void arrange(long[] arr, int n){
        long temp;
        long[] tempArr = new long[n];
        for (int i = 0; i < n; i++) {
            temp = arr[i];
            tempArr[i] = arr[(int) temp];
        }

        if (n >= 0) System.arraycopy(tempArr, 0, arr, 0, n);
    }
}
