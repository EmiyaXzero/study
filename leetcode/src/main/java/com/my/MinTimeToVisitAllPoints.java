package com.my;

/**
 * 访问所有点的最小时间
 * @author shang
 */
public class MinTimeToVisitAllPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int i = 0 ;
        for (int k = 0; k<(points.length-1); k++){
            while(points[k][0] != points[k+1][0] || points[k][1]!=points[k+1][1]){
                int pointAx = points[k][0];
                int pointAy = points[k][1];
                int pointBx = points[k+1][0];
                int pointBy = points[k+1][1];
                if(pointAx == pointBx){
                    int temp = pointBy-pointAy;
                    pointAy+=temp;
                    points[k][1] = pointAy;
                    i+=Math.abs(temp);
                }else if(pointAy == pointBy){
                    int temp = pointBx-pointAx;
                    pointAx+=temp;
                    points[k][0] = pointAx;
                    i+=Math.abs(temp);
                }else{
                    //斜线
                    pointAx+=(pointBx-pointAx)>0?1:-1;
                    points[k][0] = pointAx;
                    pointAy+=(pointBy-pointAy)>0?1:-1;
                    points[k][1] = pointAy;
                    i++;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToVisitAllPoints(new int[][]{new int[]{1, 1}, new int[]{3, 4},new int []{-1,0}}));
    }

    /**
     * 切比雪夫距离。
     */

    public static int minTimeToVisitAllPoints2(int[][] points) {
        int i = 0 ;
        for (int k = 0; k<(points.length-1); k++){
            int pointAx = points[k][0];
            int pointAy = points[k][1];
            int pointBx = points[k+1][0];
            int pointBy = points[k+1][1];
            i+=Math.max(Math.abs(pointAx-pointBx),Math.abs(pointAy-pointBy));
        }
        return i;
    }
}
