package com.my;

/**
 * @author shanghang
 * @title: UniquePathsWithObstacles
 * @projectName study
 * @description: 63. 不同路径 II
 * @date 2020/7/6-20:46
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0?1:0;
        for (int i = 0;i<m;i++){
            for (int j = 0 ;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    f[j] = 0;
                    continue;
                }
                if(j-1>=0 && obstacleGrid[i][j-1] == 0){
                    f[j]+=f[j-1];
                }
            }
        }
        return f[n-1];
    }
}
