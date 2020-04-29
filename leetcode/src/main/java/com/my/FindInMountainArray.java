package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: FindInMountainArray
 * @projectName study
 * @description: 山脉数组中查找目标值
 * @date 2020/4/29-9:07
 */
public class FindInMountainArray {

    /**
     * 在 0 < i < A.length - 1 条件下，存在 i 使得
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     * [1,2,3,4,5,3,1]
     * @param target  目标值
     * @param mountainArr  山脉数组
     * @return
     */


    public int findInMountainArray(int target, MountainArray mountainArr) {
        //获取山脉数组长度
        int length = mountainArr.length();
        int left = 0 , right = length - 1;
        int theTop = 0;
        //先二分法找到山顶
        while (left<=right){
            int mid = left +(right-left)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid-1) && mountainArr.get(mid)>mountainArr.get(mid+1)){
                theTop = mid;
                break;
            }
            if(mountainArr.get(mid)>mountainArr.get(mid-1) && mountainArr.get(mid)<mountainArr.get(mid+1)){
                left = mid;
            }else {
                right = mid;
            }
        }

        if(mountainArr.get(theTop)<target){
            return -1;
        }
        //分两次二分找到target
        left = 0 ;
        right = theTop;
        //只需要找到最小的，因此先找左边
        while (left<=right){
            int mid = left +(right-left)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        left = theTop ;
        right = length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }


    public int findInMountainArray(int target, List<Integer> mountainArr) {
        //获取山脉数组长度
        int length = mountainArr.size();
        int left = 0 , right = length - 1;
        int theTop = 0;
        //先二分法找到山顶
        while (left<right){
            int mid = left +(right-left)/2;
            //防止越界
            if(mountainArr.get(mid)>mountainArr.get(mid-1) && mountainArr.get(mid)>mountainArr.get(mid+1)){
                theTop = mid;
                break;
            }
            if(mountainArr.get(mid)>mountainArr.get(mid-1) && mountainArr.get(mid)<mountainArr.get(mid+1)){
                left = mid;
            }else {
                right = mid;
            }
        }

        if(mountainArr.get(theTop)<target){
            return -1;
        }
        //分两次二分找到target
        left = 0 ;
        right = theTop;
        //只需要找到最小的，因此先找左边
        while (left<right){
            int mid = left +(right-left)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        left = theTop ;
        right = length-1;
        //山的右边是左边比右边大，坑
        while (left<=right){
            int mid = left +(right-left)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        findInMountainArray.findInMountainArray(0,new ArrayList<Integer>(){{add(3);add(5);add(3);add(2);add(0);}});
    }
}
