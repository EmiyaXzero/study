package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shanghang
 * @title: UpdateBoard
 * @projectName study
 * @description: 529. 扫雷游戏
 * @date 2020/8/20-18:01
 */
public class UpdateBoard {
    int[] dx = new int[]{-1,0,1};
    int[] dy = new int[]{-1,0,1};

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * 先将E周围没有M的转换成B，然后B再感染周围的E
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        }
        //首先统计周围没有地雷的
        Deque<int[]> point = new ArrayDeque<>();
        for (int i = 0 ;i< board.length;i++){
            for (int j = 0;j<board.length;j++){
                int all = getAround(board,i+1,j)+getAround(board,i-1,j)+getAround(board,i,j+1)+getAround(board,i,j-1)+getAround(board,i+1,j+1)+getAround(board,i-1,j-1)+getAround(board,i-1,j+1)+getAround(board,i+1,j-1);
                if(all == 0 && board[i][j] == 'E'){
                    point.add(new int[]{i,j});
                }else if(board[i][j] == 'B') {
                    for (int x = 0;x<3;x++){
                        for (int z = 0;z<3;z++){
                            int newI = i+dx[x],newJ = j+dy[z];
                            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && board[newI][newJ] == 'E'){
                                point.add(new int[]{newI,newJ});
                            }
                        }
                    }
                }
            }
        }
        while (!point.isEmpty()){
            int[] tempPoint = point.poll();
            int i = tempPoint[0],j = tempPoint[1];
            int all = getAround(board,i+1,j)+getAround(board,i-1,j)+getAround(board,i,j+1)+getAround(board,i,j-1)+getAround(board,i+1,j+1)+getAround(board,i-1,j-1)+getAround(board,i-1,j+1)+getAround(board,i+1,j-1);
            if(all == 0 && board[i][j] == 'E'){
                board[i][j] = 'B';
                for (int x = 0;x<3;x++){
                    for (int z = 0;z<3;z++){

                        int newI = i+dx[x],newJ = j+dy[z];
                        if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && board[newI][newJ] == 'E'){
                            point.add(new int[]{newI,newJ});
                        }
                    }
                }
            }else if(board[i][j] == 'E'){
                board[i][j] = (char) ('0'+all);
            }
        }
        return board;
    }
    public int getAround(char[][] board,int i ,int j){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length){
            if(board[i][j] == 'M' || board[i][j] == 'X'){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new UpdateBoard().updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}},new int[]{3,0});
    }


    public char[][] updateBoard2(char[][] board , int[] click){
        int x = click[0] ,y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else {
            bfs(board,x,y);
        }
        return board;
    }

    private void bfs(char[][] board, int x, int y) {
        Deque<int[]> point = new ArrayDeque<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        point.offer(new int[]{x,y});
        vis[x][y] = true;
        while (!point.isEmpty()){
            int[] pos = point.poll();
            int cnt = 0, curX=pos[0],curY=pos[1];
            for (int i = 0 ;i<8;i++){
                int tx = curX + dirX[i];
                int ty = curY + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if(cnt>0){
                board[curX][curY] = (char) ('0'+cnt);
            }else{
                board[curX][curY] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = curX + dirX[i];
                    int ty = curY + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    point.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }


}
