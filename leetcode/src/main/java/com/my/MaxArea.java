package com.my;

/**
 * 盛最多水的容器
 * @author shang
 */
public class MaxArea {

    /**
     * 暴力法太难了: 336 ms  39.3 MB
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0 ;i< height.length-1 ;i++){
            for (int j = i+1; j<height.length;j++){
                result = Math.max(Math.min(height[i],height[j])*(j-i),result);
                System.out.println(result+","+i+","+j);
            }
        }
        return result ;
    }

    /**
     * 274ms
     * @param height
     * @return
     */
    public static int maxArea2(int[] height){
        int result = 0;
        for (int i = 0 ;i <height.length -1 ;i++ ){
            int j = height.length - 1;
            while (i != j){
                result = Math.max(Math.min(height[i],height[j])*(j-i),result);
                j--;
            }
        }
        return result ;
    }

    /**
     * 双指针，指针最小的移向最大的
     * @param height
     */
    public static int maxArea3(int[] height){
        int result = 0;
        int i = 0 , j = height.length - 1;
        while (i != j){
            result = Math.max(Math.min(height[i],height[j])*(j-i),result);
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return result ;
    }


    public static void main(String[] args) {
        System.out.println(maxArea3(new int[]{1, 2,4,3}));
    }
}
