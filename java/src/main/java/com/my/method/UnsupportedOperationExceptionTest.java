package com.my.method;

/**
 * @Author: shanghang
 * @Project:study
 * @description:UnsupportedOperationException学习
 * @Date: 2020/5/4 22:16
 **/
public class UnsupportedOperationExceptionTest {
    class AForUnsupportedOperationException{
        /**
         * @throws UnsupportedOperationException {@inheritDoc}
         */
        public void doTest(){
            throw new UnsupportedOperationException();
        }
    }

    class B extends AForUnsupportedOperationException{
        @Override
        public void doTest(){
            System.out.println("BTest");
        }
    }

    class C extends AForUnsupportedOperationException{
    }

    public static void main(String[] args) {
        UnsupportedOperationExceptionTest unsupportedOperationExceptionTest = new UnsupportedOperationExceptionTest();
        B bTest = unsupportedOperationExceptionTest.new B();
        C cTest = unsupportedOperationExceptionTest.new C();
        bTest.doTest();
        cTest.doTest();
    }

}
