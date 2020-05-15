package com.my;

import java.util.HashMap;

/**
 * @author shang
 * @title: SubarraySum
 * @projectName study
 * @description: 560. 和为K的子数组
 * @date 2020/5/15-13:15
 */
public class SubarraySum {
    /**
     * 暴力法居然不超时
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0 ;i<nums.length;i++){
            int sum = nums[i];
            if(sum == k){
                result++;
            }
            for (int j = i+1 ; j<nums.length;j++){
                sum+=nums[j];
                if(sum == k){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 还是暴力法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumBy(int[] nums, int k) {
        int result = 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }
        for (int i = 0 ;i<sums.length;i++){
            int sum = sums[i];
            if(sum == k){
                result++;
            }
            for (int j = i+1 ;j<sums.length;j++){
                int tempSum = sums[j] - sum;
                if(tempSum == k){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 保存前缀值，如果存在nums[i...j] ==k 那么即nums[j] - nums[i] ==k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumByHashMap(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer,Integer> pres = new HashMap<>(nums.length+1);
        pres.put(0,1);
        for (int num : nums){
            pre+=num;
            //pre-k是当前前缀值-k找需要的前面的值
            if(pres.containsKey(pre-k)){
                count += pres.get(pre-k);
            }
            //存在累加后值一致，所以需要pres.getOrDefault(pre,0)+1
            pres.put(pre,pres.getOrDefault(pre,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        subarraySum.subarraySumBy(new int[]{1,1,1},2);
    }

}
