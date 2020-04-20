package com.my;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shang
 * @title: NumIslands
 * @projectName study
 * @description: 岛屿数量
 * @date 2020/4/20-9:03
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if(grid.length<=0 || grid[0].length<=0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        //保存是否已经访问过
        int dp[][] = new int[grid.length][grid[0].length];
        int max = 0;
        //第一遍遍历依靠左上判断
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    if(i>0 && j>0){
                        if(grid[i-1][j] == '0' && grid[i][j-1] == '0'){
                            max++;
                            dp[i][j] = max;
                        }else{
                            //表示周围存在岛屿
                            if(grid[i-1][j] == '1' && grid[i][j-1] == '1'){
                                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
                            }else if(grid[i-1][j] == '1'){
                                dp[i][j] = dp[i-1][j];
                            }else {
                                dp[i][j] = dp[i][j-1];
                            }
                        }
                    }else if(i == 0 && j == 0){
                        max++;
                        dp[i][j] = max;
                    }else if(i == 0){
                        if(grid[i][j-1] == '0'){
                            max++;
                            dp[i][j] = max;
                        }else {
                            dp[i][j] = dp[i][j-1];
                        }
                    }else if(j == 0){
                        if(grid[i-1][j] == '0'){
                            max++;
                            dp[i][j] = max;
                        }else {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }
        for (int i = dp.length-1; i >=0 ; i--) {
            for (int j = dp[0].length-1 ;j>=0;j--){
                if(i == dp.length-1 && j == dp[0].length-1 || dp[i][j] == 0){
                    continue;
                }else if(i<dp.length-1 && j<dp[0].length-1){
                    //表示周围存在岛屿
                    if(grid[i+1][j] == '1' && grid[i][j+1] == '1'){
                        dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]);
                    }else if(grid[i+1][j] == '1'){
                        dp[i][j] = dp[i+1][j];
                    }else if(grid[i][j+1] == '1'){
                        dp[i][j] = dp[i][j+1];
                    }
                }else if(i == dp.length-1){
                    if(grid[i][j+1] == '1'){
                        dp[i][j] = dp[i][j+1];
                    }
                }else if(j == dp[0].length-1){
                    if(grid[i+1][j] == '1'){
                        dp[i][j] = dp[i+1][j];
                    }
                }
            }
        }
        //在从左到右循环一次
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j<grid[0].length;j++){
                if(dp[i][j] == 0){
                    continue;
                }
                if(i>0){
                    if(dp[i - 1][j]!=0){
                        dp[i][j] = Math.min(dp[i - 1][j],dp[i][j]);
                    }
                }
                if(j>0){
                    if(dp[i][j-1]!=0){
                        dp[i][j] = Math.min(dp[i][j-1],dp[i][j]);
                    }
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i < dp.length - 1) {
                    if(dp[i + 1][j]!=0){
                        dp[i][j] = Math.min(dp[i + 1][j],dp[i][j]);
                    }
                }
                if (j < dp[0].length - 1) {
                    if(dp[i][j+1]!=0){
                        dp[i][j] = Math.min(dp[i ][j+ 1],dp[i][j]);
                    }
                }
            }
        }
        //在从左到右循环一次
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j<grid[0].length;j++){
                if(dp[i][j] == 0){
                    continue;
                }
                if(i>0){
                    if(dp[i - 1][j]!=0){
                        dp[i][j] = Math.min(dp[i - 1][j],dp[i][j]);
                    }
                }
                if(j>0){
                    if(dp[i][j-1]!=0){
                        dp[i][j] = Math.min(dp[i][j-1],dp[i][j]);
                    }
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i < dp.length - 1) {
                    if(dp[i + 1][j]!=0){
                        dp[i][j] = Math.min(dp[i + 1][j],dp[i][j]);
                    }
                }
                if (j < dp[0].length - 1) {
                    if(dp[i][j+1]!=0){
                        dp[i][j] = Math.min(dp[i ][j+ 1],dp[i][j]);
                    }
                }
            }
        }
        for (int i = 0 ;i<dp.length;i++){
            for (int j = 0; j <dp[0].length ; j++) {
                if(dp[i][j] == 0 || set.contains(dp[i][j])){
                    continue;
                }else {
                    set.add(dp[i][j]);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{{'0','1','0','0','1','1','1','0','0','0','0','0','1','0','0','0','0','1','0','1'},{'1','0','1','0','0','1','1','0','0','1','0','1','0','1','0','1','1','0','0','0'},{'0','1','0','0','0','1','1','1','1','0','0','0','0','0','1','1','1','1','0','1'},{'1','1','0','0','0','1','1','0','0','0','1','1','1','0','0','1','0','1','1','0'},{'0','1','0','1','1','0','1','0','0','0','1','0','0','1','0','0','0','0','0','1'},{'1','0','0','1','0','1','0','0','0','1','1','0','1','0','0','1','0','0','0','0'},{'1','0','0','0','1','1','0','0','0','0','0','1','0','0','1','0','0','0','0','1'},{'1','0','0','0','1','0','1','1','1','0','1','0','1','1','1','1','0','0','0','1'},{'1','0','0','1','0','0','0','1','0','0','0','0','0','0','0','0','0','1','0','1'},{'0','0','0','1','0','1','1','1','1','1','1','1','1','1','0','0','0','0','1','0'},{'1','0','1','0','1','0','0','1','1','1','0','1','1','0','0','1','1','0','0','0'},{'0','1','0','0','1','0','0','0','0','0','0','1','1','1','1','0','0','0','1','0'},{'1','0','0','0','1','1','1','0','1','0','0','0','1','0','1','0','1','0','0','1'},{'0','0','0','0','1','0','1','1','0','1','0','1','0','1','1','1','1','0','0','0'},{'0','1','1','0','0','0','0','1','0','0','1','1','1','0','0','1','1','0','1','0'},{'1','0','1','1','1','1','1','1','0','1','1','0','1','0','0','1','0','0','0','1'},{'1','0','0','0','1','0','1','0','0','1','0','1','0','0','1','0','0','1','1','1'},{'0','0','1','0','0','0','0','1','0','0','1','1','0','1','1','1','0','0','0','0'},{'0','0','1','0','0','0','0','0','0','1','1','0','1','0','1','0','0','0','1','1'},{'1','0','0','0','1','0','1','1','1','0','0','1','0','1','0','1','1','0','0','0'}}));
    }
}
