package com.my;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * YYYY基于本周，如果本周跨年了就进下一年
     *         System.out.println(sf.format(date)); 2019-12-31
     *         System.out.println(sf2.format(date)); 2020-12-31
     * @param args
     */
    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf2 = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        System.out.println("yyyy-MM-dd："+sf.format(date));
        System.out.println("YYYY-MM-dd:"+sf2.format(date));
    }
}
