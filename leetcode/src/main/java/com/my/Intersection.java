package com.my;

import java.util.*;

/**
 * @author shang
 * @title: Intersection
 * @projectName study
 * @description: TODO
 * @date 2020/1/13-14:40
 */
public class Intersection {
    /**
     * 时间复杂度 mlogm+nlogm
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Int = new HashSet<>();
        int len1 = nums1.length,len2 = nums2.length;
        if(len1>len2){
            //确保nums1为最小的
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        //给nums2排个序,排序占了时间
        Arrays.sort(nums2);
        int[] result = new int[len1];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(nums1Int.contains(tempInt)){
                continue;
            }else {
                nums1Int.add(tempInt);
                int start = 0 ,end = len2-1;
                while (start <= end){
                    int mid = start + (end-start)/2;
                    if(nums2[mid] == tempInt){
                        result[k] = tempInt;
                        k++;
                        break;
                    }else if(nums2[mid] > tempInt){
                        end = mid-1;
                    }else {
                        start = mid+1;
                    }
                }
            }
        }
        return Arrays.copyOf(result,k);
    }

    /**
     * 两个HashSet m+n
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        int len1 = nums1.length,len2 = nums2.length;
        int[] result = new int[Math.min(len1,len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(set1.contains(tempInt)){
                continue;
            }else {
                set1.add(tempInt);
            }
        }
        for (int i = 0; i < len2; i++) {
            if(set1.contains(nums2[i]) && !set2.contains(nums2[i])){
                set2.add(nums2[i]);
                result[k] = nums2[i];
                k++;
            }else {
                continue;
            }
        }
        return Arrays.copyOf(result,k);
    }

    public static void main(String[] args) {
        intersection3(new int[]{4,4,9,5},new int[]{9,4,9,8,4});
    }

    /**
     * 两个数组的交集 II，两个重复出现一次就加一次
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer, Integer>();

        int len1 = nums1.length,len2 = nums2.length;
        int[] result = new int[Math.min(len1,len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            int tempInt = nums1[i];
            if(map1.containsKey(tempInt)){
                int count = map1.get(tempInt);
                map1.put(tempInt,count+1);
                continue;
            }else {
                map1.put(tempInt,1);
            }
        }
        for (int i = 0; i < len2; i++) {
            int tempNum = nums2[i];
            if(map1.containsKey(tempNum)){
                //当map1中存在这个值的时候，需要判断map2中是否存在
                if(!map2.containsKey(tempNum)){
                    map2.put(tempNum,1);
                    result[k] = tempNum;
                    k++;
                }else if(map2.get(tempNum)<map1.get(tempNum)){
                    //存在的时候
                    map2.put(tempNum,map2.get(tempNum)+1);
                    result[k] = tempNum;
                    k++;
                }
            }else {
                continue;
            }
        }
        return Arrays.copyOf(result,k);
    }

    /**
     * x =x1+t(x2-x1)
     * y =y1+t(y2-y1)
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0];
        int y1 = start1[1];
        int x2 = end1[0];
        int y2 = end1[1];
        int x3 = start2[0];
        int y3 = start2[1];
        int x4 = end2[0];
        int y4 = end2[1];
        boolean hasAnswer = false;

        double[] ans = new double[2];
        /**
         * x2-x1/y2-y1 = x4-x3/y4-y3 （斜率相等） 因为存在分母=0 所以转换成乘法
         */
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            //判断x3,y3是否在直线(x1,y1)(x2,y2) x3=x1+t(x2-x1)  y3=y1+t(y2-y1)  t=(y3-y1)/(y2-y1) = (x3-x1)/(x2-x1)
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                //判断x3,y3是否在x1,y1,x2,y2里面
                if (inside(x1, y1, x2, y2, x3, y3)) {
                    hasAnswer = update(ans, (double)x3, (double)y3, hasAnswer);
                }
                if (inside(x1, y1, x2, y2, x4, y4)) {
                    hasAnswer = update(ans, (double)x4, (double)y4, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x1, y1)) {
                    hasAnswer = update(ans, (double)x1, (double)y1, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x2, y2)) {
                    hasAnswer = update(ans, (double)x2, (double)y2, hasAnswer);
                }
            }
        } else {
            //x1+t1(x2-x1) = x3+t2(x4-x1) y1+t1(y2-y1) = y3+t2(y4-y3);
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
                hasAnswer = true;
            }
        }
        if(hasAnswer) {
            return ans;
        }
        return new double[0];
    }

    // 判断 (xk, yk) 是否在「线段」(x1, y1)~(x2, y2) 上
    private boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        return (x1 == x2 || (Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2))) && (y1 == y2 || (Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2)));
    }

    private boolean update(double[] ans, double xk, double yk, boolean hasAnswer) {
        if (!hasAnswer || xk < ans[0] || (xk == ans[0] && yk < ans[1])){
            ans[0] = xk;
            ans[1] = yk;
            return true;
        }
        return hasAnswer;
    }
}
