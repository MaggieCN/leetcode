package com.leetcode.no566;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/26
 * @Description list 存放原数组
 * key % c
 * r为商数-1
 * key%c 增加 r 同时小于满足，再继续放入新的数组
 * 每次循环加入【】【】
 */
public class MatrixReshape {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        List<Integer> list = new ArrayList<>();
        if(r*c != mat.length*mat[0].length){
            return mat;
        }
        int[][] res = new int[r][c];
        int z = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(z++, mat[i][j]);
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = mat[i*j][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 4;
        matrixReshape(mat, r, c);
    }

    //[[1,2]]
    //1
    //1
}
