package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5402. 绝对差不超过限制的最长连续子数组,两个优先队列保存区间
 * @Date: 2020/5/3 11:01
 **/
public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        //优先队列,自然增长从小到大
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        //优先队列,自然增长从大到小
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int left = 0;
        int right = 0;
        int count = 0;
        while (left<nums.length && right<nums.length){
            minQueue.add(nums[right]);
            maxQueue.add(nums[right]);
            if(maxQueue.peek()-minQueue.peek()<=limit){
                count = Math.max(count,right-left+1);
                right++;
                continue;
            }
            //将int装箱，要不然队列就去删除idx == nums[left]的值了
            minQueue.remove((Integer) nums[left]);
            maxQueue.remove((Integer)nums[left]);
            left++;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        longestSubarray.longestSubarray(new int[]{8,2,4,7},4);
    }
}
