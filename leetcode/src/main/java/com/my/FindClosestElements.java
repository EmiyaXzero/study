package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/11 15:14
 **/
public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length;
        if(arr[0] >= x){
            //输入: [1,2,3,4,5], k=4, x=-1
            for (int i =0 ;i<k;i++){
                result.add(arr[i]);
            }
            return result;
        }
        if(arr[len-1] <= x){
            //输入: [1,2,3,4,5], k=4, x=6
            for (int i =len-k ;i<len;i++){
                result.add(arr[i]);
            }
            return result;
        }
        //输入: [1,1,3,7,8],  k=4, x=3
        int left = 0 ,right = len-1;
        int target = -1;
        while (left<right){
            //二分查找找到最接近x的值
            int mid = left+(right-left)/2;
            if(arr[mid] == x ||(arr[mid]<x && arr[mid+1]>x) || (arr[mid] >x && arr[mid-1]<x)){
                target = mid;
                break;
            }else if(arr[mid] <x){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        //得到target，
        int count ;
        int leftPoint ,rightPoint;
        if(arr[target] == x){
            leftPoint = target-1;
            rightPoint = target+1;
            count = 1;
            while (count<k){
                if(leftPoint <0){
                    count++;
                    rightPoint++;
                }else if(rightPoint > len-1){
                    count++;
                    leftPoint--;
                }else {
                    if(Math.abs(arr[leftPoint]-x)<=Math.abs(arr[rightPoint]-x)){
                        count++;
                        leftPoint--;
                    }else {
                        count++;
                        rightPoint++;
                    }
                }
            }
            for (int i=leftPoint+1 ;i<rightPoint;i++){
                result.add(arr[i]);
            }
        }else {
            count = 0;
            if(arr[target] > x){
                leftPoint = target-1;
                rightPoint = target;
            }else {
                leftPoint = target;
                rightPoint = target+1;
            }
            while (count<k){
                if(leftPoint <0){
                    count++;
                    rightPoint++;
                }else if(rightPoint > len-1){
                    count++;
                    leftPoint--;
                }else {
                    if(Math.abs(arr[leftPoint]-x)<=Math.abs(arr[rightPoint]-x)){
                        count++;
                        leftPoint--;
                    }else {
                        count++;
                        rightPoint++;
                    }
                }
            }
            for (int i=leftPoint+1 ;i<rightPoint;i++){
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        findClosestElements(new int[]{1,2,3,4,5},4,3);
    }
}
