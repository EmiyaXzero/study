package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:93. 复原IP地址
 * @Date: 2020/8/9 18:01
 **/
public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        segments = new int[4];
        doIt(s,0,0);
        return result;
    }

    private void doIt(String s, int segId, int segStart) {
        if(segId == 4){
            if(segStart == s.length()){
                StringBuffer sb = new StringBuffer();
                for (int i = 0;i<4;i++){
                    sb.append(segments[i]);
                    if(i != segId-1){
                        sb.append(".");
                    }
                }
                result.add(sb.toString());
            }
            return;
        }
        if(segStart == s.length()){
            return;
        }
        if(s.charAt(segStart) == '0'){
            segments[segId] = 0;
            doIt(s,segId+1,segStart+1);
        }

        int addr = 0;
        for (int segEnd = segStart;segEnd<s.length();segEnd++){
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if(addr>0 && addr<=255){
                segments[segId] = addr;
                doIt(s,segId+1,segEnd+1);
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("25525511135");
    }
}
