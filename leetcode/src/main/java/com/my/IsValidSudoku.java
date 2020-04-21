package com.my;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shang
 * @title: IsValidSudoku
 * @projectName study
 * @description: 有效的数独
 * @date 2020/4/21-15:27
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] hengSet = new int[9][9];
        int[][] shuSet = new int[9][9];
        int[][][] around9 = new int[3][3][9];
        for (int i = 0 ;i<9;i++){
            for (int j = 0 ;j<9;j++){
                int temp = board[i][j] - '0' -1;
                if(board[i][j] == '.'){
                    continue;
                }
                //判断横
                if (hengSet[i][temp] != 0){
                    return false;
                }else{
                    hengSet[i][temp] = 1;
                }
                //判断竖
                if (shuSet[j][temp]!=0) {
                    return false;
                }else {
                    shuSet[j][temp] = 1;
                }
                //判断9宫格
                int tempI = i/3;
                int tempY = j/3;
                if(around9[tempI][tempY][temp] == 0){
                    around9[tempI][tempY][temp] = 1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
