package com.my;

/**
 * 旋转数组
 * @author shang
 */
public class Rotate {
    /**
     * 思路一：new 一个新数组，先遍历后几位塞进去，再遍历前面几位塞到新数组,最后要将新数组塞到旧数组= =
     * 思路二：不new一个新数组，保存后面几位然后后面的数组往后挪K位
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k<=0){
            return;
        }
        if(k>len){
            k = k-len;
        }
        //保存后几位
        int[] newNums = new int[k];
        int len2 = 0;
        for (int i=len-k; i<len;i++ ){
            newNums[len2] = nums[i];
            len2++;
        }
        for (int i = len-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0 ;i<k;i++){
            nums[i] = newNums[i];
        }
    }


    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
