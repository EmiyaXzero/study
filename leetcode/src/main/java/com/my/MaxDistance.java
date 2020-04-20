package com.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shang
 * @title: MaxDistance
 * @projectName study
 * @description: 地图分析
 * @date 2020/4/20-19:02
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        //将岛屿放到队列里面
        int max = -1;
        int[][] visted = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0 ;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                    //岛屿的步骤为0
                    grid[i][j] = 0;
                    //表示访问过
                    visted[i][j] = 1;
                }
            }
        }
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()){
            //出队
            int[] curIdx = queue.poll();
            int curX = curIdx[0];
            int curY = curIdx[1];
            //将当前节点置为已访问
            for (int i = 0 ;i<4;i++){
                int tempX = curX+dx[i];
                int tempY = curY+dy[i];

                if(tempX>=0 && tempX<=grid.length-1 && tempY>=0 && tempY<= grid[0].length-1 && visted[tempX][tempY] == 0){
                    //只有在矩阵中有效，同时四周没有遍历过，这个时候不用考虑周围是否为0，因为一开始将所有岛屿都置为访问过所以不会再访问到岛屿
                    visted[tempX][tempY] = 1;
                    grid[tempX][tempY] = grid[curX][curY]+1;
                    max = Math.max(max, grid[tempX][tempY]);
                    queue.add(new int[]{tempX,tempY});
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        maxDistance.maxDistance(new int[][]{{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}});
    }
}
