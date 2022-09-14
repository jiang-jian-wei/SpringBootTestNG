package com.app.demo.testsuite.base;

import https.MyBigDataTester;

/**
 * 用于方法具体执行
 */

public class MyBaseTest extends MyAbstractTestBase{

    public void test(String dir,String testCaseDataFileName,int retryTimes){
        MyBigDataTester myBigDataTester = new MyBigDataTester();

        try {
            myBigDataTester.runTest(dir+testCaseDataFileName);
        }catch (Exception e){
            if (retryTimes<1){
                throw new RuntimeException(e);
            }
            --retryTimes;
            System.out.println(testCaseDataFileName+":用例重试中...");
            test(dir,testCaseDataFileName,retryTimes);
        }
    }
}
