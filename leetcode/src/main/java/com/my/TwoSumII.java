package com.my;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shanghang
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        int left = 1,right = len;
        while (left<right){
            if(left-2>=0 && numbers[left-1] == numbers[left-2]){
                left++;
            }
            if(right<len && numbers[right-1] == numbers[right]){
                right--;
            }
            int add =numbers[left-1]+numbers[right-1];
            if ( add == target){
                result[0] = left;
                result[1] = right;
                return result;
            }else {
                if(add <target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.iterator();
    }
}
