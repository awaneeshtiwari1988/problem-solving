package com.practice.problem.solving.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrows {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int minArrows = 1;
        int arrowPosition = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if(points[i][0] > arrowPosition){
                minArrows++;
                arrowPosition = points[i][1];
            }
        }

        return minArrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        MinimumArrows minimumArrows = new MinimumArrows();
        System.out.println(minimumArrows.findMinArrowShots(points));

        points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        System.out.println(minimumArrows.findMinArrowShots(points));
    }
}
