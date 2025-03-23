package com.practice.problem.solving.array;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int column = grid[0].length;

        // First Row
        for(int i = 1; i < column; i++){
            grid[0][i] += grid[0][i-1];
        }

        // First column
        for(int i = 1; i < rows; i++){
            grid[i][0] += grid[i-1][0];
        }

        // Use Dynamic Programming
        for(int i =1; i < rows; i++){
            for (int j = 1; j < column; j++) {
                grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }


        return grid[rows-1][column-1];
    }
}
