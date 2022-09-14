package com.app.demo.testsuite.https.testcase.app_a.app_a_adminlab;

import com.app.demo.testsuite.base.MyBaseTest;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.testng.annotations.Test;


public class ModuleBTest extends MyBaseTest {
    @Test(groups = "platformB")
    public void moduleBTest(){
        test(casePathAppTest,"/a.json",1);
    }
}
