package com.my.method;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shanghang
 * @title: GenericStudy
 * @projectName study
 * @description: 泛型学习
 * @date 2020.11.15-16:41
 */
@Slf4j
public class GenericStudy {
    public class GenericA<T>{
        private T t ;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        new GenericStudy().doMap(map);
        log.error(map.get("aaa"));
    }

    public void withoutGeneric(){
        GenericA a = new GenericA();
        a.setT("test");
        String test = (String) a.getT();
        log.error(test);
    }

    public void doGeneric(){
        GenericA<String> a = new GenericA<>();
        a.setT("test");
        String test = a.getT();
        log.error(test);
    }

    public void doMap(Map map){
        map.put("aaa","bbbb");
    }

}
