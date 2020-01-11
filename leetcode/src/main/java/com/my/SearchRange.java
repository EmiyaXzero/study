package com.my;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/11 13:45
 **/
public class SearchRange {

    /**
     * 或者先二分查找找出left值，如果nums[mid] == target就hight=mid ,然后继续左找，找出左边
     * 然后右找nums[mid]>target right =mid
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len<=0|| nums[0]>target || nums[len-1]<target){
            return new int[]{-1,-1};
        }
        int[] result = new int[]{-1,-1};
        int left = 0 ,right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                //表示找到了，但是还需要找到区间
                int leftPoint = mid-1, RightPoint = mid+1;
                if( leftPoint==-1 && RightPoint == len){
                    result[0] = 0;
                    result[1] = len-1;
                    break;
                }else if(leftPoint==-1){
                    result[0] = 0;
                    while (RightPoint<len && nums[RightPoint] ==target){
                        RightPoint++;
                    }
                    result[1] = RightPoint-1;
                    break;
                }else if(RightPoint == len){
                    result[1] = len-1;
                    while (leftPoint>-1 && nums[leftPoint] == target){
                        leftPoint--;
                    }
                    result[0] = leftPoint+1;
                    break;
                }else {
                    for (int i =mid-1;i>=0;i--){
                        if(nums[i]<target){
                            result[0] = i+1;
                            break;
                        }
                    }
                    for (int i =mid+1;i<len;i++){
                        if(nums[i]>target){
                            result[1] = i-1;
                            break;
                        }
                    }
                    if(result[0] == -1){
                        result[0] = 0;
                    }
                    if(result[1] == -1){
                        result[1] = len-1;
                    }
                    break;
                }
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
