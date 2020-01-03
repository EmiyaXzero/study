package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author shanghang
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length<=0){
            return new ArrayList<>();
        }
        int x = matrix.length;
        int y = matrix[0].length;
        List<Integer> result = new ArrayList<>(x*y);
        int k=0,i=0,j=0,round=0;
        //0向右，1向下，2向左，3向上
        int flag = 0;
        while(k<x*y) {
            switch (flag){
                case 0:
                    //向右
                    result.add(matrix[i][j]);
                    j++;
                    k++;
                    if(j==y-round){
                        //向下
                        flag=1;
                        j=y-1-round;
                        i++;
                    }
                    break;
                case 1:
                    //向下
                    result.add(matrix[i][j]);
                    i++;
                    k++;
                    if(i==x-round){
                        //向左
                        flag=2;
                        i=x-1-round;
                        j--;
                    }
                    break;
                case 2:
                    //向左
                    result.add(matrix[i][j]);
                    j--;
                    k++;
                    if(j<round){
                        //向上
                        flag=3;
                        j=round;
                        i--;
                        round++;
                    }
                    break;
                case 3:
                    //向上
                    result.add(matrix[i][j]);
                    i--;
                    k++;
                    if(i<round){
                        //向右
                        flag=0;
                        i=round;
                        j++;
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
