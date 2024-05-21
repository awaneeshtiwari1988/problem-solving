package com.practice.problem.solving.array;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] isVisited = new boolean[m][n];
        int numberOfIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    dfs(grid,isVisited,i,j,m,n);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int i , int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || isVisited[i][j]){
            return;
        }

        isVisited[i][j] = true;

        dfs(grid, isVisited, i-1, j, m, n);
        dfs(grid, isVisited, i+1,j,m,n);
        dfs(grid, isVisited, i,j-1,m,n);
        dfs(grid, isVisited, i,j+1,m,n);
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
