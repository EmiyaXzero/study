package com.my;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author shanghang
 */
public class ThreeSumClosest {
    /**
     * 先给nums排序，然后for循环nums,最后while l ,r l<r
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        //取绝对值abs
        int close = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i =0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length - 1;
            //居然多1ms
//            if(i>0 && nums[i] == nums[i-1]){
//                continue;
//            }
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int tempClose = sum-target;
                if(tempClose == 0 ){
                    return target;
                }
                if(Math.abs(tempClose) < close){
                    //-3 0 1 2
                    result = sum;
                    close = Math.abs(tempClose);
                }
                if(tempClose>0){
                    //说明当前差值太小了需要右边值左移
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                }else {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55}, 3));
    }
}
