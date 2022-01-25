package com.leetcode.no59;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/10
 * @description:
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;
        int target = n*n;
        while(num <=target){
            for (int i = l; i <=r ; i++) {
                res[t][i] = num++;
            }
            t++;
            for (int i = t; i <=b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >=l; i--) {
                res[b][i] = num++;
            }
            b--;
            for (int i = b; i >=t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] res = generateMatrix.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
