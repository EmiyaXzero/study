package com.my;

/**
 * 分割平衡字符串
 *
 * @author shang
 */
public class BalancedStringSplit {
    /**
     * 循环从左到右保持一个平衡变量，当它得到一个L增加1，否则减少1。
     * 当平衡变量为0时，我们将答案增加1。
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        if(s.length() == 1){
            return 1;
        }
        int result = 0;
        int balance = 0;
        for (int i = 0 ;i<s.length();i++){
            if(s.charAt(i) == 'L'){
                balance++;
            }else {
                balance--;
            }
            if(balance == 0){
                result ++;
            }
        }
        return result;
    }
}
