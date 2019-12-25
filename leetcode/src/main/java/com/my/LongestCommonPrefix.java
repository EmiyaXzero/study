package com.my;

import java.util.Map;

/**
 * 最长公共前缀
 * @author shanghang
 */
public class LongestCommonPrefix {
    /**
     * 2 ms	37.5 MB
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<=0){
            return "";
        }
        int min = strs[0].length();
        int k = 0;
        for (int i =1 ;i<strs.length ;i++){
            if("".equals(strs[i]) || strs[i].length()<=0){
                return "";
            }
            if(strs[i].length()<min){
                k = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int j =0 ; j < strs[k].length() ;j++){
            for (int i =0 ;i<strs.length ;i++){
                if(strs[k].charAt(j) != strs[i].charAt(j)){
                    return sb.toString();
                }
            }
            sb.append(strs[k].charAt(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ca", "a"}));
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
