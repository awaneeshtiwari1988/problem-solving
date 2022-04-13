package com.practice.problem.solving.strings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString {

    class Combination{
        int i;
        char j;

        public Combination(int i, char j) {
            this.i = i;
            this.j = j;
        }
    }

    class CombinationComparator implements Comparator<Combination> {
        @Override
        public int compare(Combination o1, Combination o2) {
            return o2.i - o1.i;
        }
    }

    public String solution(int A, int B, int C) {
        PriorityQueue<Combination> priorityQueue = new PriorityQueue<>(new CombinationComparator());
        StringBuilder stringBuilder = new StringBuilder();

        if(A != 0){
            priorityQueue.offer(new Combination(A, 'a'));
        }

        if(B != 0){
            priorityQueue.offer(new Combination(B, 'b'));
        }

        if(C != 0){
            priorityQueue.offer(new Combination(C, 'c'));
        }

        while(!priorityQueue.isEmpty()){
            Combination combination = priorityQueue.poll();
            int n = stringBuilder.length();
            if(n > 1 && stringBuilder.charAt(n-1) == stringBuilder.charAt(n -2)
                    && stringBuilder.charAt(n-1) == combination.j){
                if(priorityQueue.isEmpty()){
                    break;
                } else {
                    Combination nextComb = priorityQueue.poll();
                    stringBuilder.append(nextComb.j);
                    nextComb.i--;
                    if(nextComb.i != 0){
                        priorityQueue.offer(nextComb);
                    }
                }
            } else {
                stringBuilder.append(combination.j);
                combination.i--;
            }

            if(combination.i != 0){
                priorityQueue.offer(combination);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.solution(7, 1, 0));
    }
}
