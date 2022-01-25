package com.leetcode.no200;

/**
 * @Author MaggieCN
 * @Date 2021/10/26
 * @Description
 * 题目只要四周是水即可，上下左右都是0或者边界即可满足岛屿要求
 * 1. 主函数：对于1-陆地，开始遍历，遍历过的改为2（防止有循环无法跳出问题）.
 * 2. dfs: (1) 边界
 *        （2）！=‘1’ 标记过或者已经到水了
 *        然后再循环递归上下左右
 */
public class RightAnswer {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i >=grid.length || j>=grid[0].length || i<0 || j<0 ) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
