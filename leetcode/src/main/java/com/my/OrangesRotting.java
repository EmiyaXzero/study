package com.my;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/5/1 10:14
 **/
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] di = new int[]{-1,0,1};
        int[] dj = new int[]{-1,0,1};
        int all1 = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0 ;i<grid.length;i++){
            for (int j = 0 ;j<grid[0].length;j++){
                switch (grid[i][j]){
                    case 0:
                        used[i][j] = true;
                        break;
                    case 1:
                        //判断周围存不存在橘子,这里有个坑
                        all1++;
                        boolean has2 = false;
                        for (int x =0 ;x<3;x++){
                            for (int y = 0;y<3;y++){
                                if(Math.abs(di[x]) == Math.abs(dj[y])){
                                    continue;
                                }
                                int curX = i+di[x];
                                int curY = j+dj[y];
                                if (curX>=0 && curX <grid.length && curY>=0 && curY<grid[0].length){
                                    if(grid[curX][curY] == 1 || grid[curX][curY] == 2){
                                        has2 = true;
                                    }
                                }
                            }
                        }
                        if (!has2){
                            return -1;
                        }
                        break;
                    case 2:
                        used[i][j] = true;
                        deque.add(new int[]{i,j});
                        break;
                    default:
                        break;
                }
            }
        }
        if(all1 == 0){
            return 0;
        }
        if(deque.isEmpty()){
            //不存在烂橘子
            return -1;
        }
        int count = 0;
        int new2 = 0;
        while (!deque.isEmpty()){
            //感染的新的一波塞进来
            Deque<int[]> newDeque = new ArrayDeque<>();
            while (!deque.isEmpty()){
                int[] curIdx = deque.removeFirst();
                for (int x =0 ;x<3;x++){
                    for (int y = 0;y<3;y++){
                        if(Math.abs(di[x]) == Math.abs(dj[y])){
                            continue;
                        }
                        int curX = curIdx[0]+di[x];
                        int curY = curIdx[1]+dj[y];
                        if (curX>=0 && curX <grid.length && curY>=0 && curY<grid[0].length){
                            if (!used[curX][curY] && grid[curX][curY] == 1){
                                used[curX][curY] = true;
                                newDeque.add(new int[]{curX,curY});
                                new2++;
                                if(new2 == all1){
                                    return ++count;
                                }
                            }
                        }
                    }
                }
            }
            count++;
            deque = newDeque;
        }
        return -1   ;
    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        orangesRotting.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}});
    }


}
