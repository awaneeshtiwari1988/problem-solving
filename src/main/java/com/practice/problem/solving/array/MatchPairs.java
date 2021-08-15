package com.practice.problem.solving.array;

public class MatchPairs {

    public static void main(String[] args) {
        int n = 5;
        char[] nuts = {'@','%','$','#','^'};
        char[] bolts = {'%','@','#','$','^'};
        MatchPairs matchPairs = new MatchPairs();
        matchPairs.matchPairs(nuts,bolts,n);
    }

    public void matchPairs(char[] nuts, char[] bolts, int n){
        nuts = mergeSort(nuts,0,n-1);
        bolts = mergeSort(bolts,0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(nuts[i] + " ");
        }

        System.out.println("");

        for (int i = 0; i < n; i++) {
            System.out.print(bolts[i] + " ");
        }

        System.out.println("");
    }

    public char[] mergeSort(char[] inputArray, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex) /2;
            mergeSort(inputArray,startIndex,middleIndex);
            mergeSort(inputArray,middleIndex+1,endIndex);
            mergeProcedure(inputArray,startIndex,middleIndex,endIndex);
        }
        return inputArray;
    }

    public char[] mergeProcedure(char[] inputArray, int startIndex, int middleIndex, int endIndex){
        int leftArrayLength = middleIndex - startIndex +1;
        int rightArrayLength = endIndex - middleIndex;

        char[] left = new char[leftArrayLength];
        char[] right = new char[rightArrayLength];

        // Copy the array elements
        for (int i = 0; i < leftArrayLength; ++i) {
            left[i] = inputArray[startIndex+i];
        }

        for (int j = 0; j < rightArrayLength; j++) {
            right[j] = inputArray[middleIndex + j +1];
        }

        // Merge the two arrays
        int i =0, j =0, k = startIndex;
        while(i < leftArrayLength && j < rightArrayLength){
            if((int) left[i] <= (int) right[j]){
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        // Iterate and add remaining elements
        while(i < leftArrayLength){
            inputArray[k] = left[i];
            i++;
            k++;
        }

        while(j < rightArrayLength){
            inputArray[k] = right[j];
            j++;
            k++;
        }

        return inputArray;
    }
}
