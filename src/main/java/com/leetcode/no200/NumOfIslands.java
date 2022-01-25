package com.leetcode.no200;

/**
 * @Author MaggieCN
 * @Date 2021/10/26
 * @Description
 */
public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(ifNotIslands(grid, i, j))
                    count++;
            }
        }
        return count;
    }
    public boolean ifNotIslands(char[][] grid, int i, int j){
        if(grid[i][j] == '0') {return false;}

        Boolean res = ifNotIslands(grid, i-1, j) || ifNotIslands(grid, i+1, j) ||
            ifNotIslands(grid, i, j-1) || ifNotIslands(grid, i, j+1);
        return res;
    }
}
