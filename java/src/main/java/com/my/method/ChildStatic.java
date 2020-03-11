package com.my.method;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author shang
 * @title: ChildStatic
 * @projectName study
 * @description: TODO
 * @date 2020/3/11-21:41
 */
@Slf4j
public class ChildStatic extends ParentStatic {

    public static final int a = 1 ;

    static {
        log.error("初始化子类的静态方法块");
    }

    public static HashMap map = new HashMap(){
        {log.error("初始化子类静态常量");}
    };



    public ChildStatic(){
        log.error("子类的构造方法调用");
    }

    public static  void doTest(){
        log.error("子类的静态方法调用");
    }

    public static void main(String[] args){
        try{
           int a = 1/0;
        }catch (Exception e){
            log.error(e.getMessage());
            return;
        }finally {
            log.error("我是finally");
        }
    }
}
