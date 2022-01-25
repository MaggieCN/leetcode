package com.leetcode.no463;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/24
 * @description:
 * 一种是：到达边界+1
 * 一种是：遍历到水的时候 +1
 * 走到已走过的 +0
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        islandPerimeter.islandPerimeter(grid);
    }
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) result = dfs(grid, i, j, result);
            }
        }
        return result;
    }
    private int dfs(int[][] grid,
                    int row,
                    int col,
                    int result){
        if(row >=grid.length || col >=grid[0].length || row<0 || col<0){
            result++;
            return result;
        }
        if(grid[row][col]==0){
            result++;
            return result;
        }
        if(grid[row][col]==2){
            return result;
        }
        grid[row][col] = 2;
        return dfs(grid, row+1, col, result) +  dfs(grid, row-1, col, result) +
                dfs(grid, row, col+1, result) + dfs(grid, row, col-1, result) ;
    }
}
