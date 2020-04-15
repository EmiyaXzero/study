package com.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/15 22:48
 **/
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0 ;i<n;i++){
            for (int j = 0 ;j<m;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = n+m;
                }
                if(i>0){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i-1][j]+1);
                }
                if(j>0){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][j-1]+1);
                }
            }
        }
        for (int i = n-1;i>=0;i--){
            for (int j = m-1;j>=0;j--){
                if(i<n-1){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i+1][j]);
                }
                if(j<m-1){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][j+1]);
                }
            }
        }
        return matrix;
    }

    /**
     * BFS广度优先搜索，将所有的0先入队然后找到0周围的1
     * @param matrix
     */
    public int[][] updateMatrix2(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0 ;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    //将0的坐标移到队列中
                    queue.add(new int[]{i,j});
                }else{
                    //将没入队的标记为-1，防止重复入队
                    matrix[i][j] = -1;
                }
            }
        }
        //0周围四个点
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i =0 ;i<4;i++){
               int newX = dx[i]+x;
               int newY = dy[i]+y;
               //matrix[newX][newY] == -1的判断防止已经+1的值又被+1
               if(newX>=0 && newX<n && newY>=0 && newY<m && matrix[newX][newY] == -1){
                   matrix[newX][newY] = matrix[x][y]+1;
                   //将+1的位置记录下来，下次的时候将+1的周围置为+1+1
                   queue.offer(new int[]{newX,newY});
               }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        updateMatrix.updateMatrix(new int[][]{{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}});
    }
}
