package com.leetcode.no695;

/**
 * @Author MaggieCN
 * @Date 2021/10/27
 * @Description
 */
public class RightAnswer {
    private int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }
    public int dfs(int[][] grid, int i, int j){
        if(i >=grid.length || j>=grid[0].length || i<0 || j<0 ) return 0;
        if(grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return 1 + dfs(grid,i-1,j) + dfs(grid,i+1,j) + dfs(grid,i,j-1) +dfs(grid,i,j+1);
    }
}
