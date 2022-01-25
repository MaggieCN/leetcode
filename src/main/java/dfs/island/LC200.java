package dfs.island;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/21
 * @description:
 */
public class LC200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row=grid.length;
        int col=grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i<0 || j<0) return;
        if(grid[i][j]!='1') return;
        grid[i][j] = '2';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    public static void main(String[] args) {
        char[][] islandChar = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        LC200 lc200 = new LC200();
        lc200.numIslands(islandChar);
    }
}
