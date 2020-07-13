package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:350. 两个数组的交集 II
 * @Date: 2020/7/13 22:35
 **/
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0,j=0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                while (j<nums2.length && nums2[j]<nums1[i]){
                    j++;
                }
                if(j>=nums2.length){
                    break;
                }
                if(nums1[i] == nums2[j]){
                    result.add(nums1[i]);
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
        }
        int[] res = new int[result.size()];
        for (int z =0;z<res.length;z++){
            res[z] = result.get(z);
        }
        return res;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        intersect.intersect(new int[]{1,2} ,new int[]{1,1});
    }
}
