package com.my.method;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author shang
 * @title: ParentStatic
 * @projectName study
 * @description: TODO
 * @date 2020/3/11-21:36
 */
@Slf4j
public class ParentStatic {
    public static HashMap map = new HashMap(){
        {log.error("初始化父类静态常量");}
    };

    static {
        log.error("初始化父类的静态方法块");
    }

    public ParentStatic(){
        log.error("父类的构造方法调用");
    }
}
