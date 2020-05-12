package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shang
 * @title: MaximalSquare
 * @projectName study
 * @description: 221. 最大正方形
 * @date 2020/5/8-13:33
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        Deque<int[]> integers = new ArrayDeque<>();
        int len1 = matrix.length;
        if(len1 <= 0){
            return 0;
        }
        int len2 = matrix[0].length;
        for (int i = 0 ; i<len1;i++){
            for (int j = 0 ; j<len2;j++){
                if(matrix[i][j] == '1'){
                    integers.add(new int[]{i,j});
                }
            }
        }
        if(integers.size() == 0){
            return 0;
        }
        if(integers.size() == len1*len2){
            return Math.min(len1,len2)*Math.min(len1,len2);
        }
        int max = 1;
        while (!integers.isEmpty()){
            int[] curIdx = integers.removeFirst();
            //判断有几圈
            int size = 1;
            jule:for (int i = 1;i<Math.min(len1-curIdx[0],len2-curIdx[1]);i++){
                if(matrix[i+curIdx[0]][i+curIdx[1]] =='0'){
                    break;
                }
                for (int j = curIdx[0];j<=Math.min(len1-1,curIdx[0]+i);j++){
                    if(matrix[j][i+curIdx[1]] == '0'){
                        break jule;
                    }
                }
                for (int j = curIdx[1];j<=Math.min(len2-1,curIdx[1]+i);j++){
                    if(matrix[i+curIdx[0]][j] =='0'){
                        break jule;
                    }
                }
                size++;
                max = Math.max(size,max);
            }
        }

        return max*max;
    }

    /**
     * 一次遍历
     * @param matrix
     * @return
     */
    public int maximalSquareByOneCe(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    public int maximalSquareByDp(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0 ;i<matrix.length;i++){
            for (int j = 0 ;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    if(i==0 || j==0){
                        //当为边界的时候最大也只能为1
                        dp[i][j] = 1;
                    }else {
                        //因为是上左左上，所以不用考虑越界
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(new char[][]{{'1','0','1','1','1','1','0','0','1','1'},{'0','1','0','1','0','0','0','1','0','1'}});
    }
}
