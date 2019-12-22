package com.my;

/**
 * 正则表达式匹配
 * @author shanghang
 */
public class IsMatch {
    public static boolean isMatch(String s, String p) {
        if (null == s|| null==p || s.length()<=0 || p.length()<=0) {
            return false;
        }
        if(p.length()<s.length() && p.charAt(p.length()-1)!='*'){
            return false;
        }
        int i=0,j=0;
        int startP = 0;
        //如果p是*得取前一个值
        char tempStr = 0;
        boolean sEnd = false;
        while (i<=s.length()&&j<p.length()){
            //确保i,j都遍历完
            if(i > s.length() -1 &&(p.charAt(j) =='*'||p.charAt(j-1)=='*')){
                //TODO 左移判断有问题
                //只有当s到最后一位且p当前值是*需要继续右移
                sEnd = true;
                i = s.length() -1;
            }else if(i>s.length()-1){
                break;
            }
            if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.'){
                //s当前值等于p当前值或者p是.匹配任意字符
                i++;
                j++;
            }else if(s.charAt(i) !=p.charAt(j) && p.charAt(j)!='*'){
                if(j+1 == p.length()){
                    return false;
                }else if(p.charAt(j+1)=='*'){
                    j++;
                }else{
                    return false;
                }
            }else{
                //p当前值是*
                if(j>0){
                    if(p.charAt(j-1)!='*'){
                        tempStr = p.charAt(j-1);
                    }
                    if(s.charAt(i) == tempStr || tempStr =='.'){
                        i++;
                    }else{
                        //*不匹配就p右移
                        j++;
                    }
                }else{
                    //第一个位就是*
                    return false;
                }
                //左边结束了，得判断*右边是否与左边最后一个一致
                if(sEnd){
                    j++;
                }
            }
        }
        if(j<p.length() || (i<s.length() && !sEnd)){
            //需要确保s,p都到最后
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a",
                "ab*"));
    }


    public static boolean isMatch2(String text, String pattern) {
        if (pattern.isEmpty()) {return text.isEmpty();};
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}
