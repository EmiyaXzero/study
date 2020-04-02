package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/2 17:38
 **/
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0;i<board.length;i++){
            for (int j = 0 ;j<board[0].length;j++){
                temp[i][j] = board[i][j];
            }
        }
        for (int i = 0;i<board.length;i++){
            for (int j = 0 ;j<board[0].length;j++){
                board[i][j] = getValue(temp,i,j);
            }
        }
    }

    public int getValue(int[][] temp,int i ,int j){
        //获取周围活细胞
        int count = 0;
        for (int first = (i-1)<0?0:i-1 ; first<=(i+1>(temp.length-1)?temp.length-1:i+1);first++){
            for (int second = (j-1)<0?0:j-1 ; second<=(j+1>(temp[0].length-1)?temp[0].length-1:j+1);second++){
                if(first == i && second == j){
                    continue;
                }
                if(temp[first][second]==1){
                    count++;
                }
            }
        }

        switch (temp[i][j]){
            case 1:
                if(count<2 || count>3){
                    return 0;
                }else if(count == 2 || count ==3) {
                    return 1;
                }
                break;
            case 0:
                switch (count){
                    case 3:
                        return 1;
                    default:
                        return 0;
                }
            default:
                break;
        }
        return 0;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
