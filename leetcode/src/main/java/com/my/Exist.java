package com.my;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author shanghang
 * @title: Exist
 * @projectName study
 * @description: 79. 单词搜索
 * @date 2020/9/13-14:03
 */
public class Exist {
    int maxI;
    int maxJ;

    class POJO{
        int x;
        int y;

        POJO(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "POJO{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            POJO pojo = (POJO) o;
            return x == pojo.x &&
                    y == pojo.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean exist(char[][] board, String word) {
        maxI = board.length;
        maxJ = board[0].length;
        Set<POJO> used = new HashSet<>();
         for (int i = 0;i<board.length;i++){
             for (int j = 0;j<board[i].length;j++){
                 if(board[i][j] == word.charAt(0)){
                     POJO temp = new POJO(i,j);
                     used.add(temp);
                     if(dfs(i,j,1,word,board,used)){
                         return true;
                     }
                     used.remove(temp);
                 }
             }
         }
         return false;
    }

    private boolean dfs(int x, int y, int idx,String word ,char[][] board ,Set<POJO> used) {
        if(idx == word.length()){
            return true;
        }
        for (int i = -1 ;i<=1;i++){
            for (int j = -1;j<=1;j++){

                if(Math.abs(i) == Math.abs(j) ){
                    continue;
                }
                int curX = x+i;
                int curY = y+j;
                POJO temp = new POJO(curX,curY);
                if(used.contains(temp)){
                    continue;
                }
                if( curX>=0 && curX<maxI && curY>=0 && curY<maxJ){
                    if(board[curX][curY] == word.charAt(idx)){
                        used.add(temp);
                        if(dfs(curX,curY,idx+1,word,board,used)){
                            return true;
                        }
                        used.remove(temp);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}
