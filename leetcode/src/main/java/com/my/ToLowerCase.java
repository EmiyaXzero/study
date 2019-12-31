package com.my;

/**
 * 转换成小写字母
 * @author shang
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i) <='Z'){
                char temp = (char) (str.charAt(i)-('A'-'a'));
                sb.append(temp);
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
