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
        //如果p是*得取前一个值
        char tempStr = 0;
        boolean sEnd = false;
        while (i<=s.length()&&j<p.length()){
            //确保i,j都遍历完
            if(i > s.length() -1 ){
                //TODO 左移判断有问题
                //只有当s到最后一位且p当前值是*或者p下一位是*需要继续右移
                if(j+1 == p.length() && p.charAt(j) !='*'){
                    i = s.length() -1;
                    //aaa,a*a判断错误
                    if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.'){
                        return true;
                    }else{
                        return false;
                    }
                }else if(p.charAt(j) =='*'||p.charAt(j+1)=='*'){
                    sEnd = true;
                    i = s.length() -1;
                }else{
                    return false;
                }
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
        System.out.println(isMatch2("aaa",
                "a*aaa"));
    }

    /**
     * 递归处理，首先判断s[i] 是否等于p[j],保存下来firstMatch，如果p[j]+1 = * ,
     * 则有两种情况不需要当前的p[j]因为*可以指代0所以直接判断s,存在两种情况当*为0的时候直接与p.substring(2)是否符合校验，
     * 不为0的时候则需要校验firstMatch && s.substring(1)和p是否符合条件的结果 ，两种条件一种满足就行
     * 如果p[j+1] !='*'，则直接校验下一位s.substring(1) && s.substring(1)
     *
     * 递归结束条件p遍历完，当s为空的时候说明右边存在*导致遍历完，
     * 所以firstMatch && isMatch2(s.substring(1),p会为false，并且进入isMatch2(s,p.substring(2)就是进入了*为0的情况
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        if(p.isEmpty()){
            //正则的遍历完了
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() &&(s.charAt(0) == p.charAt(0) || p.charAt(0)=='.');
        //当下一位是*
        if(p.length()>=2 && p.charAt(1)=='*'){
            //当下一位为*则判断s+1与p是否一致或者s与p后两位之后的值是否一致应为*可以是0
            return (firstMatch && isMatch2(s.substring(1),p)) || isMatch2(s,p.substring(2));
        }else{
            //继续判断下一位
            return firstMatch && isMatch2(s.substring(1),p.substring(1));
        }

    }

        public static boolean isMatch6(String text, String pattern) {
            if (pattern.isEmpty()) {
                return text.isEmpty();
            }
            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch6(text.substring(1), pattern)));
            } else {
                return first_match && isMatch6(text.substring(1), pattern.substring(1));
            }
        }



}
