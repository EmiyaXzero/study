package com.my;

/**
 *  对角线遍历
 *  分左上角和右下角
 * @author shang
 */
public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        if(matrix.length == 1){
            return matrix[0];
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int[] result = new int[x*y];
        if(matrix[0].length == 1){
            for (int i = 0; i < x; i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }

        int k = 0;
        int r=1;
        boolean is2Right = true;
        int min = Math.min(x,y);
        for (int key = 0; key<=(x+y)-1;key++){
            boolean isLeft = key < min;
            //斜向一共有2n-1
            int xi, yi;
            if(is2Right){
                if (isLeft) {
                    //在左上角，xi,yi一端为0
                    yi = 0;
                    xi = key - yi;
                } else {
                    //在右下角，xi,yi一段为x-1
                    if(key<x){
                        xi = key;
                    }else {
                        xi = x-1;
                    }
                    yi = key-xi;
                }
                for (int i = 0; i < r; i++) {
                    result[k] = matrix[xi][yi];
                    k++;
                    xi--;
                    yi++;
                }
                is2Right = false;
            }else{
                if (isLeft) {
                    //在左上角，xi,yi一端为0
                    xi = 0;
                    yi = key-xi;
                } else {
                    //在右下角，xi,yi一段为x-1
                    if(key<y){
                        yi = key;
                    }else {
                        yi = y-1;
                    }
                    xi = key - yi;
                }
                for (int i = 0; i < r; i++) {
                    result[k] = matrix[xi][yi];
                    k++;
                    xi++;
                    yi--;
                }
                is2Right = true;
            }
            //存在两种情况
            if(x==y){
                // 1，2，3，2，1
                if(key<x-1){
                    r++;
                }else {
                    r--;
                }
            }else{
                // 1，2，2，1   区间是在0-y-1 ++   (x+y)-1-y --
                if(key<min-1){
                    r++;
                }else if(key>=(y+x)-min-1){
                    r--;
                }
            }

        }
        return result;
    }
    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}});
    }
}
