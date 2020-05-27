package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5405. 形成两个异或相等数组的三元组数目
 * @Date: 2020/5/10 10:43
 **/
public class CountTriplets {
    public int countTriplets(int[] arr) {
        if(arr.length <= 1){
            return 0;
        }
        int result = 0;
        int i = 0,j=1,k=1;
        int a = arr[i];
        int b = arr[j];
        boolean isAFirst = true;
        while (i>=0 && i<j && j<=k && k<arr.length){
//            if(i+1<=j-1 &&isAFirst){
//                a ^=arr[j];
//                isAFirst = false;
//            }
            if(j+1<=k){
                b ^=arr[k];
            }
            if(a == b){
                result++;
            }
            k++;
            if(k == arr.length){
                j++;
                if(j==arr.length){
                    i++;
                    a = arr[i];
                    if(i == arr.length-1){
                        break;
                    }
                    j=i+1;
                }
                if(i+1<=j-1){
                    a ^=arr[j-1];
                }
                b = arr[j];
                k=j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountTriplets countTriplets = new CountTriplets();
        System.out.println(countTriplets.countTriplets(new int[]{2, 3, 1, 6, 7}));
    }
}
