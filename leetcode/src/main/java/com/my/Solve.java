package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:130. 被围绕的区域
 * @Date: 2020/8/11 22:41
 **/
public class Solve {
    int row,col;
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        row = board.length;
        col = board[0].length;
        for (int i = 0 ;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for (int i = 0;i<col;i++){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for (int i = 0 ;i<row ;i++){
            for (int j = 0 ;j< col;j++){
                if(board[i][j] == '-'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=row || j>=col || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
