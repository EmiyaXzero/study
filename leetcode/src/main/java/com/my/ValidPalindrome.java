package com.my;

/**
 * @author shang
 * @title: ValidPalindrome
 * @projectName study
 * @description: 680. 验证回文字符串 Ⅱ
 * @date 2020/5/19-11:38
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int p = 0 ,q = s.length()-1;
        while (p<q){
            if(s.charAt(p) != s.charAt(q)){
                if(isTrue(s.substring(p+1,q+1))||isTrue(s.substring(p,q))){
                    return true;
                }else {
                    return false;
                }
            }
            p++;
            q--;
        }
        return true;
    }

    boolean isTrue(String s){
        int p = 0 ,q = s.length()-1;
        while (p<q){
            if(s.charAt(p) != s.charAt(q)){
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
