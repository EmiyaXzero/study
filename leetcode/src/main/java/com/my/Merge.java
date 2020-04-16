package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/13 23:48
 **/
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
       int[] temp = new int[m+n];
       int i = m-n-1;
       int j = n-1;
       int k = m+n-1;
       while (i>=0 && j>=0){
           if(B[j]>=A[i]){
               temp[k] = B[j];
               j--;
               k--;
           }else {
               temp[k] = A[i];
               i--;
               k--;
           }
       }
        while(i>=0){
            temp[k] = A[i];
            k--;
            i--;
        }
       while (j>=0){
           temp[k] = B[j];
           k--;
           j--;
       }
       for (int b = 0 ;b<temp.length;b++){
           A[b] = temp[b];
       }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[][]{{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}});
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=0){
            return intervals;
        }
        /**
         * 冒泡排序，将数组从小到大
         */
       for (int i = 0 ;i<intervals.length-1;i++){
           for (int j = i+1;j<intervals.length;j++){
               if(intervals[i][1]>intervals[j][1] ||intervals[i][1]>intervals[j][1] && intervals[i][0] >intervals[j][0] ){
                   int[] temp = intervals[i];
                   intervals[i] = intervals[j];
                   intervals[j] = temp;
               }
           }
       }
       List<int[]> result = new ArrayList<>();
       result.add(intervals[0]);
       for (int i = 1 ;i<intervals.length;i++){
           if(intervals[i][0] <= result.get(result.size()-1)[1]){
               result.get(result.size()-1)[1] = intervals[i][1];
               if(intervals[i][0] <= result.get(result.size()-1)[0]){
                   result.get(result.size()-1)[0] = intervals[i][0];
               }
           }else {
               result.add(intervals[i]);
           }
       }
       //再反过来，防止[[2,3],[4,5],[6,7],[8,9],[1,10]]
        for (int i = result.size()-1;i>0;i--){

            if(result.get(i)[0] <=result.get(i-1)[0] && result.get(i)[1] >= result.get(i-1)[1]){
                result.remove(i-1);
            }else if(result.get(i)[0] <=result.get(i-1)[1]){
                result.get(i)[0] = result.get(i-1)[0];
                result.remove(i-1);
            }
        }
       return (int[][]) result.toArray(new int[result.size()][2]);

    }

    /**
     * 简易排序，合并
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        //根据左边进行升序排列
        Arrays.sort(intervals,Comparator.comparingInt(value -> value[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1;i<intervals.length;i++){
            //因为是按照左边升序排列，所以肯定左边intervals[i][0]比intervals[i-1][0]大
            if(intervals[i][0]> result.get(result.size()-1)[1]){
                result.add(intervals[i]);
            }else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],intervals[i][1]);
            }
        }
        return (int[][])result.toArray(new int[result.size()][2]);
    }
}
