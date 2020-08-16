package com.my;

/**
 * @author shanghang
 * @title: CountBinarySubstrings
 * @projectName study
 * @description: 696. 计数二进制子串
 * @date 2020/8/10-20:34
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int pre=0 ,cur=1 ,result = 0;
        for (int i = 1 ;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cur++;
            }else{
                pre = cur;
                cur = 1;
            }
            if(pre >= cur){
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        A: for (int i = 0; i <10 ; i++) {
            for (int j = 0; j<3;j++){
                System.out.println(j);
                if(j == 2){
                    break A;
                }
            }
        }
    }
}
