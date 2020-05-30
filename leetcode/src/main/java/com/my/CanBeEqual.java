package com.my;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5408. 通过翻转子数组使两个数组相等
 * @Date: 2020/5/30 22:34
 **/
public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        if(Arrays.equals(target,arr)){
            return true;
        }else {
            return false;
        }
    }
}
