package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author shang
 * 方法一占用时间内存消耗小 23 ms	37.4 MB
 * 方法二占用内存时间开销小 6 ms	39.8 MB
 * 方法三  5 ms	37.2 MB
 */
public class TwoSum {
    /**
     * 方法一：暴力法  遍历每个元素 x，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
     * 时间复杂度O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)的时间。因此时间复杂度位O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFix1(int[] nums, int target) {
        for(int i=0 ;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     *LeetCode 官方给出的两遍哈希表
     * 时间复杂度O(n) 空间负责度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFix2(int[] nums,int target){
        //HashMap<值，下标>
        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        //第一遍将全部数字塞到map里面
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        //第二遍target-x，取出值在numsMap种取出判断是否存在
        for(int i =0 ;i<nums.length;i++){
            //并且不能等于自身
            if(null != numsMap.get(target-nums[i]) && (i)!=numsMap.get(target-nums[i])){
                return new int[]{i,numsMap.get(target-nums[i])};
            }
        }
        return new int[0];
    }

    /**
     * 官方提示的一次哈希表
     * 将target-x放到hashmap  ,在后面的时候在map取当前值是否存在就行，也不需要判断是否是本身
     * 时间复杂度O(n) 空间负责度O(n)
     */
    public int[] twoSumFix3(int[] nums,int target){
        //HashMap<差值，下标>
        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i =0 ;i<nums.length;i++){
            //官方提供的方法是用containsKey
            //containsKey --> return getNode(hash(key), key) != null;
            //get -->Node<K,V> e;
            //        return (e = getNode(hash(key), key)) == null ? null : e.value;
            if(null != numsMap.get(nums[i]) ){
                return new int[]{i,numsMap.get(nums[i])};
            }else {
                numsMap.put(target-nums[i],i);
            }
            //并且不能等于自身
            if(null != numsMap.get(target-nums[i]) && (i)!=numsMap.get(target-nums[i])){
                return new int[]{i,numsMap.get(target-nums[i])};
            }
        }
        return new int[0];
    }
}
