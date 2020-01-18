package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数
 * @author shanghang
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        return isPalindrome(String.valueOf(x));
    }
    public static boolean isPalindrome(String s) {
        int k = 2;
        int count = s.length();
        for (int i = 0; i < count / k; i++) {
            if (s.charAt(i) != s.charAt(count - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不将int转成字符解法,将int的一半反转
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if(x<0){
            //负数不存在回文
            return false;
        }
        if(x>=0 && x<10){
            return true;
        }
        int length = (int)Math.log10(x)+1;
        int k = 2;
        int right = 0;
        //如果是偶数
        if(length%k == 0){
            int mid = length/2;
            int left = x/(int)Math.pow(10,mid);
            for (int i=0 ;i< mid;i++){
                right = right*10+ x%10;
                x/=10;
            }
            if(left == right){
                return true;
            }else {
                return false;
            }
        }else{
            //如果是奇数
            int mid = length/2;
            int left = x/(int)Math.pow(10,mid+1);
            for (int i=0 ;i< mid;i++){
                right = right*10+ x%10;
                x/=10;
            }
            if(left == right){
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(0 % 10);
        //isPalindrome2(1001);
    }


    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size()-1;
        while (start<end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
