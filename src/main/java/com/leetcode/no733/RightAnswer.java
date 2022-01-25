package com.leetcode.no733;

/**
 * @Author MaggieCN
 * @Date 2021/11/5
 * @Description
 */
public class RightAnswer {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if(originColor == newColor) return image;
        dfsFloodFill(image, sr, sc, newColor, originColor);
        return image;
    }
    public void dfsFloodFill(int[][] image, int sr, int sc, int newColor, int originColor){
        if(sr<0 || sc< 0 || sr >=image.length || sc >= image[0].length) return;
        if(image[sr][sc]!= originColor) return;
        image[sr][sc] = newColor;
        dfsFloodFill(image, sr+1, sc, newColor, originColor);
        dfsFloodFill(image, sr-1, sc, newColor, originColor);
        dfsFloodFill(image, sr, sc+1, newColor, originColor);
        dfsFloodFill(image, sr, sc-1, newColor, originColor);
    }
}
