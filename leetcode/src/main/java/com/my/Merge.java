package com.my;

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
        merge.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6} ,3);
    }

}
