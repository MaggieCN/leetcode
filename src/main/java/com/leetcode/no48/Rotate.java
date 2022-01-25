package com.leetcode.no48;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/9
 * @description:
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int post1 = 0;
        int post2 = matrix[0].length-1;
        while(post1<post2){
            int add = 0;
            while(add< post2 - post1){
                int temp = matrix[post1][post1+add];
                matrix[post1][post1+add] = matrix[post2-add][post1];
                matrix[post2-add][post1] = matrix[post2][post2-add];
                matrix[post2][post2-add] = matrix[post1+add][post2];
                matrix[post1+add][post2] = temp;
                add++;
            }
            post1++;
            post2--;
        }
    }
}
