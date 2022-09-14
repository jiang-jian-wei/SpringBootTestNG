package com.app.demo.testsuite.https.testcase.apptest;

import com.app.demo.testsuite.base.MyBaseTest;
import org.testng.annotations.Test;

public class DemoTest extends MyBaseTest {

    @Test
    public void caseOneTest(){
        System.out.println(testStringValue);
    }

    @Test
    public void caseTwoTest(){
        System.out.println("ddd");
    }

    @Test(groups = {"appTest_Module1"})
    public void caseThreeTest(){
        System.out.println(lombokValve);
        test("/testcasedata/apptest/before/","beforeAppTest.json",1);
    }

    @Test
    public void caseForeTest(){
        System.out.println(envNamePlatformA);
    }
}
