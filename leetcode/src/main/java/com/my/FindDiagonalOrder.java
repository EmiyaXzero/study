package com.my;

import java.util.*;

/**
 *  对角线遍历
 *  分左上角和右下角
 * @author shang
 */
public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        if(matrix.length == 1){
            return matrix[0];
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int[] result = new int[x*y];
        if(matrix[0].length == 1){
            for (int i = 0; i < x; i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }

        int k = 0;
        int r=1;
        boolean is2Right = true;
        int min = Math.min(x,y);
        for (int key = 0; key<=(x+y)-1;key++){
            boolean isLeft = key < min;
            //斜向一共有2n-1
            int xi, yi;
            if(is2Right){
                if (isLeft) {
                    //在左上角，xi,yi一端为0
                    yi = 0;
                    xi = key - yi;
                } else {
                    //在右下角，xi,yi一段为x-1
                    if(key<x){
                        xi = key;
                    }else {
                        xi = x-1;
                    }
                    yi = key-xi;
                }
                for (int i = 0; i < r; i++) {
                    result[k] = matrix[xi][yi];
                    k++;
                    xi--;
                    yi++;
                }
                is2Right = false;
            }else{
                if (isLeft) {
                    //在左上角，xi,yi一端为0
                    xi = 0;
                    yi = key-xi;
                } else {
                    //在右下角，xi,yi一段为x-1
                    if(key<y){
                        yi = key;
                    }else {
                        yi = y-1;
                    }
                    xi = key - yi;
                }
                for (int i = 0; i < r; i++) {
                    result[k] = matrix[xi][yi];
                    k++;
                    xi++;
                    yi--;
                }
                is2Right = true;
            }
            //存在两种情况
            if(x==y){
                // 1，2，3，2，1
                if(key<x-1){
                    r++;
                }else {
                    r--;
                }
            }else{
                // 1，2，2，1   区间是在0-y-1 ++   (x+y)-1-y --
                if(key<min-1){
                    r++;
                }else if(key>=(y+x)-min-1){
                    r--;
                }
            }

        }
        return result;
    }

    /**
     * 对角线遍历 II
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> result = new ArrayList<>();
        //stacks保存每个i+j对应的栈，每个i+j的栈都是最后一个元素先入栈，第一个元素最后进栈
        Map<Integer, Deque<Integer>> stacks = new HashMap<>();
        int maxKey = Integer.MIN_VALUE;
        for (int i = 0;i< nums.size() ;i++){
            for (int j = 0;j<nums.get(i).size();j++){
                maxKey = Math.max(i+j,maxKey);
                if (stacks.containsKey(i+j)){
                    stacks.get(i+j).addLast(nums.get(i).get(j));
                }else {
                    Deque<Integer> deque = new ArrayDeque<>();
                    deque.addLast(nums.get(i).get(j));
                    stacks.put(i+j,deque);
                }
            }
        }
        //确保从头到尾
        for(int i=0;i<=maxKey ;i++){
            Deque<Integer> deque = stacks.get(i);
            while (!deque.isEmpty()){
                result.add(deque.pollLast());
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
       List<List<Integer>> all = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        all.add(a1);
        a1 = new ArrayList<>();
        a1.add(4);
        all.add(a1);
        a1 = new ArrayList<>();
        a1.add(7);
        a1.add(8);
        a1.add(9);
        all.add(a1);
        findDiagonalOrder.findDiagonalOrder(all);
    }
}
