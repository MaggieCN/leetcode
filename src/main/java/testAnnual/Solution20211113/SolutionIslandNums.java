package testAnnual.Solution20211113;

/**
 * @Author MaggieCN
 * @Date 2021/11/13
 * @Description
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *  从等于“0” 开始dfs 上下左右
 *  如果有的话，赋值为”2"
 *  剪枝条件
 *  边界、1、
 *
 */
public class SolutionIslandNums {
    public int islandNums(char[][] grid){
        int count = 0;
        int row = grid.length-1;
        int col = grid[0].length-1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i , j, row, col);
                    count ++;
                }

            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, int row, int col){
        if(i < 0 || j < 0 || i>= row || j>=col) return;
        if(grid[i][j]!='1') return;
        grid[i][j] = '2';
        dfs(grid,i +1, j, row, col);
        dfs(grid,i -1, j, row, col);
        dfs(grid,i , j+1, row, col);
        dfs(grid,i , j-1, row, col);
    }
}
