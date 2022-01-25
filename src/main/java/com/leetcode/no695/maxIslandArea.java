package com.leetcode.no695;

/**
 * @Author MaggieCN
 * @Date 2021/10/27
 * @Description 这样写也是对的
 */
public class maxIslandArea {
    private int area = 0;
    private int tmp = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    area = Math.max(area, tmp);
                    tmp = 0;
                }
            }
        }
        return area;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i >=grid.length || j>=grid[0].length || i<0 || j<0 ) return;
        if(grid[i][j] != 1) return;
        grid[i][j] = 2;
        tmp++;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
