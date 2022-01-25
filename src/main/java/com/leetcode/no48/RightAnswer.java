package com.leetcode.no48;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/9
 * @description:
 * https://leetcode-cn.com/problems/rotate-image/solution/li-kou-48xiao-bai-du-neng-kan-dong-de-fang-fa-zhu-/
 */
public class RightAnswer {
    public void rotate(int[][] matrix) {
        int add = 0;
        int temp = 0;
        int pos1 = 0;
        int pos2 = matrix[0].length - 1;
        while (pos1 < pos2){
            add = 0;
            while (add < pos2 - pos1){
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 -add];
                matrix[pos2][pos2 -add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;
        }
    }
}
