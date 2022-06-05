package com.practice.problem.solving.array;

public class EquillibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {
        if(n == 1){
            return 0;
        }

        long[] prefixFromFront = new long[n];
        long[] prefixFromBack = new long[n];

        for(int i=0; i < n; i++){
            if(i == 0){
                prefixFromFront[i] = arr[i];
            } else {
                prefixFromFront[i] = prefixFromFront[i-1] + arr[i];
            }
        }

        for(int i = n-1; i > 0; i--){
            if(i <= n-2){
                prefixFromBack[i] = prefixFromBack[i+1] + arr[i];
            } else {
                prefixFromBack[i] = arr[i];
            }
        }

        for(int i = 0; i < n; i++){
            if(prefixFromFront[i] == prefixFromBack[i]){
                return i;
            }
        }

        return -1;
    }
}
