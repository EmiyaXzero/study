package com.my;

import java.util.*;

/**
 * @author shang
 * @title: Intersection
 * @projectName study
 * @description: TODO
 * @date 2020/1/13-14:40
 */
public class Intersection {
    /**
     * 时间复杂度 mlogm+nlogm
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Int = new HashSet<>();
        int len1 = nums1.length,len2 = nums2.length;
        if(len1>len2){
            //确保nums1为最小的
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        //给nums2排个序,排序占了时间
        Arrays.sort(nums2);
        int[] result = new int[len1];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(nums1Int.contains(tempInt)){
                continue;
            }else {
                nums1Int.add(tempInt);
                int start = 0 ,end = len2-1;
                while (start <= end){
                    int mid = start + (end-start)/2;
                    if(nums2[mid] == tempInt){
                        result[k] = tempInt;
                        k++;
                        break;
                    }else if(nums2[mid] > tempInt){
                        end = mid-1;
                    }else {
                        start = mid+1;
                    }
                }
            }
        }
        return Arrays.copyOf(result,k);
    }

    /**
     * 两个HashSet m+n
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        int len1 = nums1.length,len2 = nums2.length;
        int[] result = new int[Math.min(len1,len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(set1.contains(tempInt)){
                continue;
            }else {
                set1.add(tempInt);
            }
        }
        for (int i = 0; i < len2; i++) {
            if(set1.contains(nums2[i]) && !set2.contains(nums2[i])){
                set2.add(nums2[i]);
                result[k] = nums2[i];
                k++;
            }else {
                continue;
            }
        }
        return Arrays.copyOf(result,k);
    }

    public static void main(String[] args) {
        intersection3(new int[]{4,4,9,5},new int[]{9,4,9,8,4});
    }

    /**
     * 两个数组的交集 II，两个重复出现一次就加一次
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer, Integer>();

        int len1 = nums1.length,len2 = nums2.length;
        int[] result = new int[Math.min(len1,len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(map1.containsKey(tempInt)){
                int count = map1.get(tempInt);
                map1.put(tempInt,count+1);
                continue;
            }else {
                map1.put(tempInt,1);
            }
        }
        for (int i = 0; i < len2; i++) {
            int tempNum = nums2[i];
            if(map1.containsKey(tempNum)){
                //当map1中存在这个值的时候，需要判断map2中是否存在
                if(!map2.containsKey(tempNum)){
                    map2.put(tempNum,1);
                    result[k] = tempNum;
                    k++;
                }else if(map2.get(tempNum)<map1.get(tempNum)){
                    //存在的时候
                    map2.put(tempNum,map2.get(tempNum)+1);
                    result[k] = tempNum;
                    k++;
                }
            }else {
                continue;
            }
        }
        return Arrays.copyOf(result,k);
    }

}
