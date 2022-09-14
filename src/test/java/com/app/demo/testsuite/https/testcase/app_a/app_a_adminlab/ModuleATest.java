package com.app.demo.testsuite.https.testcase.app_a.app_a_adminlab;

import com.app.demo.testsuite.base.MyBaseTest;
import org.testng.annotations.Test;

public class ModuleATest extends MyBaseTest {
    @Test(groups = "platformA")
    public void moduleATest(){
        test(casePathAppTest,"/before/beforeAppTest.json",1);
    }
}
