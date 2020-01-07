package com.my;

/**
 * 移除元素
 * @author shang
 */
public class RemoveElement {
    /**
     * 双指针left right,如果left == val 就left跟right交换位置，然后right--
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int result = nums.length;
        int left = 0,right = result-1;
        while (left<=right){
            if(nums[left] == val){
                result --;
                while (nums[right]==val&&left<right){
                    result--;
                    right--;
                }
                nums[left] = nums[right];
                nums[right] = val;
                right--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
    }
}
