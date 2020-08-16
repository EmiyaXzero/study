package com.my;

import java.util.Arrays;

/**
 * @author shanghang
 * @title: FloodFill
 * @projectName study
 * @description: 733. 图像渲染
 * @date 2020/8/16-11:26
 */
public class FloodFill {
    boolean[][] used;
    int[][] result;
    int target;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length<=0 || image[0].length<=0){
            return result;
        }
        used = new boolean[image.length][image[0].length];
        result = image;
        target = image[sr][sc];
        dfs(sr,sc,newColor);
        return result;
    }

    private void dfs(int sr, int sc, int newColor) {
        if(sr<0 || sr>=result.length || sc<0 || sc>=result[0].length || result[sr][sc] != target){
            return;
        }
        if(used[sr][sc]){
            return;
        }
        used[sr][sc] = true;
        result[sr][sc] = newColor;
        dfs(sr-1,sc,newColor);
        dfs(sr+1,sc,newColor);
        dfs(sr,sc-1,newColor);
        dfs(sr,sc+1,newColor);
    }
}
