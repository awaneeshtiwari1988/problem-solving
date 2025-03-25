package com.practice.problem.solving.dynamicprogramming;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        // Base row
        for (int i = 1; i < rows; i++) {
            grid[0][i] += grid[0][i-1];
        }

        // Base Columns
        for (int i = 1; i < columns; i++) {
            grid[i][0] += grid[i-1][0];
        }

        // Handle all other cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }

        return grid[rows-1][columns-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
