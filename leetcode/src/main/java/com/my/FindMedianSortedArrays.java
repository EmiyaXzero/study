package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 *寻找两个有序数组的中位数
 * 执行用时 :
 * 5 ms
 * , 在所有 java 提交中击败了
 * 28.52%
 * 的用户
 * 内存消耗 :
 * 46.9 MB
 * , 在所有 java 提交中击败了
 * 95.12%
 * 的用户
 * @author shang
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 1L;
        int count1 = nums1.length;
        int count2 = nums2.length;
        int allCount = count1 + count2;
        boolean isOdd = false;
        int mid = 1;
        int KEY_PRE = 2;
        //先判断和是奇数还是偶数
        if((count1+count2)%KEY_PRE == 1){
            isOdd = true;
        }
        //数组不能同时为空
        if(null == nums1 || nums1.length <1){
            if(isOdd){
                return nums2[allCount/2];
            }else {
                return (nums2[allCount/2-1]+nums2[allCount/2])/2.0;

            }
        }
        if(null == nums2 || nums2.length <1){
            if(isOdd){
                return nums1[allCount/2];
            }else {
                return (nums1[allCount/2-1]+nums1[allCount/2])/2.0;

            }
        }
        if(nums1[0]>nums2[0]){
            int[] tempNums = new int[0];
            tempNums = nums2;
            nums2 = nums1;
            nums1 = tempNums;
            count1 = nums1.length;
            count2 = nums2.length;
        }

        //两个数组是有序的,先判断nums1最后一位跟nums2第一位数的大小
        if(nums1[count1-1] <= nums2[0]){
            if(isOdd){
                mid *= allCount/2+1;
                if(mid <= count1){
                    return nums1[mid-1]*1.0;
                }else{
                    return nums2[mid-count1-1];
                }
            }else{
                //两位数都在数组1，两位数都在数组2，两位数在数组1，2
                mid = allCount/2;
                int rightMid = mid+1;
                if(mid <=count1 && rightMid <= count1){
                    return (nums1[mid-1]+nums1[rightMid-1])*1.0/2.0;
                }else if(mid >count1 && rightMid >count1){
                    return (nums2[mid-count1-1]+nums2[rightMid-count1-1])*1.0/2.0;
                }else if(mid == count1 && rightMid == count1+1 ){
                    return (nums1[mid-1]+nums2[0])*1.0/2.0;
                }
            }
        }else{
            //需要找到左边第一个比右边大的数，然后放到新的数组里面，从新的数组里面取到需要的中位数的值
            List<Integer> newCount = new ArrayList<>();
            mid *= allCount/2+1;
            int left = 0;
            int right = 0;
            boolean isRightEnd = false;
            boolean isLeftEnd = false;
            while (newCount.size()<mid){
                boolean isTrue = (nums1[left]<=nums2[right] || isRightEnd) && !isLeftEnd;
                if(isTrue){
                    newCount.add(nums1[left]);
                    left++;
                    if(left > count1 -1){
                        left = count1-1;
                        isLeftEnd = true;
                    }
                }else{
                    newCount.add(nums2[right]);
                    right++;
                    if(right > count2 -1){
                        right = count2-1;
                        isRightEnd = true;
                    }
                }
            }
            if(isOdd){
                return newCount.get(mid-1);
            }else{
                return (newCount.get(mid-2)+newCount.get(mid-1))/2.0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays2(new int[]{1,2}, new int[]{-1,3}));
    }

    /**
     * 二分法 将nums1 分成i,j两份，nums2分成m,n两份当i+m = j+n的时候，且max(i,m)值小于min(j,n)的时候
     * 就能取到中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count = len1+len2;
        boolean isJi = count%2==1;
        if(len1 == 0 && len2 == 0){
            return 0;
        }else if(len1 == 0){
            if(isJi){
                return nums2[count/2];
            }else {
                return (nums2[count/2]+nums2[count/2-1])*1.0/2;
            }
        }else if(len2 ==0 ){
            nums2 = nums1;
            if(isJi){
                return nums2[count/2];
            }else {
                return (nums2[count/2]+nums2[count/2-1])*1.0/2;
            }
        }
        if(len1 > len2){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }

        int start = 0;
        int end = len1;
        //左边个数
        int leftPart = 0;
        int rightPart = 0;
        int halfLen = (count+1)/2;
        while(start <= end){
            leftPart = (start+end)/2;
            rightPart = halfLen - leftPart;
            if(leftPart<end && nums2[rightPart-1]>nums1[leftPart]){
                start = leftPart+1;
            }else if(leftPart>start && nums1[leftPart-1]>nums2[rightPart]){
                end = leftPart-1;
            }else {
                int maxLeft = 0;
                if(leftPart == 0 ){
                    //第一个数组没有左边
                    maxLeft = nums2[rightPart-1];
                }else if(rightPart == 0){
                    //第二个数组没有左边
                    maxLeft = nums1[leftPart-1];
                }else {
                    maxLeft = Math.max(nums1[leftPart-1],nums2[rightPart-1]);
                }
                if(count%2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if(leftPart == len1){
                    minRight = nums2[rightPart];
                }else if(rightPart == len2 ){
                    minRight = nums1[leftPart];
                }else {
                    minRight = Math.min(nums1[leftPart],nums2[rightPart]);
                }
                return (minRight+maxLeft)*1.0/2;
            }
        }
        return 0.0;
    }


}
