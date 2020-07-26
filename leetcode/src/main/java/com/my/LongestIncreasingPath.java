package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:329. 矩阵中的最长递增路径
 * @Date: 2020/7/26 17:46
 **/
public class LongestIncreasingPath {
    /**
     * 四个方向的遍历
     */
    public int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int max = 0;
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<columns;j++){
                max = Math.max(dfs(matrix,i,j,memo),max);
            }
        }
        return max;
    }

    /**
     * 深度优先搜索
     * @param matrix
     * @param i
     * @param j
     * @param memo
     * @return
     */
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if(memo[i][j] !=0){
            return memo[i][j];
        }
        ++memo[i][j];
        for (int[] dir : dirs) {
            int newRow = i+dir[0],newColumns = j+dir[1];
            if(newRow>=0 && newRow < rows && newColumns >=0 && newColumns<columns && matrix[newRow][newColumns]>matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j],dfs(matrix,newRow,newColumns,memo)+1);
            }
        }
        return memo[i][j];
    }
}
