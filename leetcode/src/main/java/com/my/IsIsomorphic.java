package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shang
 * @title: IsIsomorphic
 * @projectName study
 * @description: 同构字符串
 * @date 2020/1/30-11:28
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> mapS = new HashMap(16);
        Map<Character,Integer> mapT = new HashMap(16);
        for (int i = 0; i < s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(mapS.containsKey(tempS) && mapT.containsKey(tempT)){
                Integer intS = mapS.get(tempS);
                Integer intT = mapT.get(tempT);
                if(intS.equals(intT)){
                    intS+=i;
                    intT+=i;
                    mapS.put(tempS,intS);
                    mapT.put(tempT,intT);
                }else {
                    return false;
                }
            }else if(!mapS.containsKey(tempS) && !mapT.containsKey(tempT)){
                mapS.put(tempS,i);
                mapT.put(tempT,i);
            }else {
                return false;
            }
        }
        return true;

    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character,Character> mapS = new HashMap(16);
        for (int i = 0; i < s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(mapS.containsKey(tempS)){
                Character charS = mapS.get(tempS);
                if(!charS.equals(tempT)){
                    return false;
                }
            }else {
                //在新增之前需要看t是否已经存在过tempT的映射
                if(mapS.containsValue(tempT)){
                    return false;
                }
                mapS.put(tempS,tempT);
            }
        }
        return true;
    }
}
