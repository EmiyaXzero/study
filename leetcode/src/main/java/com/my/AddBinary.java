package com.my;

import java.util.HashMap;

/**
 * 拆成三个方法更慢了
 * @author shanghang
 */
public class AddBinary {
    private static  HashMap<Character,Integer> values = new HashMap<Character,Integer>(){
        {
            put('0',0);
            put('1',1);
        }
    };
    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int x = a.length();
        int y = b.length();
        int min = Math.min(x,y);
        boolean aMin = x<y;
        //是否近一
        String s = "";
        int isJin = 0;
        for (int i=0;i<min;i++){
            int result = values.get(a.charAt(x-i-1))+values.get(b.charAt(y-i-1))+isJin;
            isJin = setSb(result,sb,isJin);
        }
        if(aMin){
            //表示a遍历完了
            isJin = getIsJin(b, sb, y, min, isJin);
        }else {
            isJin = getIsJin(a, sb, x, min, isJin);
        }
        if(isJin == 1){
            sb.insert(0,"1");
        }
        return sb.toString();
    }

    private static int getIsJin(String a, StringBuffer sb, int x, int min, int isJin) {
        String s;
        for (int i = min; i<x; i++){
            int result = values.get(a.charAt(x-i-1))+isJin;
            isJin = setSb(result,sb,isJin);
        }
        return isJin;
    }

    public static int setSb(int result ,StringBuffer sb ,int isJin){
        String s = "";
        switch (result){
            case 0:
                s="0";
                isJin = 0;
                break;
            case 1:
                s="1";
                isJin = 0;
                break;
            case 2:
                s="0";
                isJin = 1;
                break;
            default:
                s="1";
                isJin = 1;
                break;
        }
        sb.insert(0,s);
        return isJin;
    }

    /**
     * 不用map快了2ms
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int x = a.length();
        int y = b.length();
        int min = Math.min(x,y);
        boolean aMin = x<y;
        //是否近一
        int isJin = 0;
        for (int i=0;i<min;i++){
            int result = (a.charAt(x-i-1)-'0')+(values.get(b.charAt(y-i-1))-'0')+isJin;
            String s = "";
            switch (result){
                case 0:
                    s="0";
                    isJin = 0;
                    break;
                case 1:
                    s="1";
                    isJin = 0;
                    break;
                case 2:
                    s="0";
                    isJin = 1;
                    break;
                default:
                    s="1";
                    isJin = 1;
                    break;
            }
            sb.insert(0,s);
        }
        if(aMin){
            //表示a遍历完了
            for (int i = min ;i<y;i++){
                int result = values.get(b.charAt(y-i-1))+isJin;
                String s = "";
                switch (result){
                    case 0:
                        s="0";
                        isJin = 0;
                        break;
                    case 1:
                        s="1";
                        isJin = 0;
                        break;
                    case 2:
                        s="0";
                        isJin = 1;
                        break;
                    default:
                        s="1";
                        isJin = 1;
                        break;
                }
                sb.insert(0,s);
            }
        }else {
            for (int i = min ;i<x;i++){
                int result = values.get(a.charAt(x-i-1))+isJin;
                String s = "";
                switch (result){
                    case 0:
                        s="0";
                        isJin = 0;
                        break;
                    case 1:
                        s="1";
                        isJin = 0;
                        break;
                    case 2:
                        s="0";
                        isJin = 1;
                        break;
                    default:
                        s="1";
                        isJin = 1;
                        break;
                }
                sb.insert(0,s);
            }
        }
        if(isJin == 1){
            sb.insert(0,"1");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("111", "1111"));
    }
}
