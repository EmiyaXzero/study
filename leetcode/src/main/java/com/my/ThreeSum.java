package com.my;

import java.util.*;

/**
 * 三数之和
 *
 * @author shanghang
 */
public class ThreeSum {
    /**
     * 暴力法
     * 喜闻乐见超时
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> tempList = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        tempList = sort(new int[]{nums[i], nums[j], nums[k]});
                        result.add(tempList);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 思路就是取你想要剩下来的值
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        ;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int request = 0 - nums[i];
            HashSet temp = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (temp.contains(nums[j])) {
                    result.add(sort(new int[]{nums[i], nums[j], request - nums[j]}));
                } else {
                    temp.add(request - nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 263 ms	48.8 MB  hashset太占时间了
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int count = nums.length;
        if (nums == null || count < 3) {
            return new ArrayList<>();
        }
        //先给nums排序
        Arrays.sort(nums);
        //最小三位数相加大于零直接退出
        if (nums[0] + nums[1] + nums[2] > 0) {
            return new ArrayList<>();
        };
        for (int i = 0; i < count - 1; i++) {
            //从小到大排列,如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = count - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else {
                    if (sum < 0) {
                        //说明在左边的值太小了需要右移
                        left++;
                    } else {
                        //反之同理
                        right--;
                    }
                }
            }

        }
        return result;
    }


    /**
     * @return
     */
    public static List<Integer> sort(int[] ints) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(ints);
        for (int tempI : ints) {
            result.add(tempI);
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
