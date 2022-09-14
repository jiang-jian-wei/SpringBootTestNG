package com.app.demo.testsuite.base;

import com.app.demo.testsuite.TestApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 *
 *从配置文件中获取变量
 * 部分变量存放到系统变量，以便动态获取
 *
 */
@Component
@Configuration
@SpringBootTest(classes = TestApplication.class)
public class MyAbstractTestBase extends AbstractTestNGSpringContextTests {
    protected static String testStringValue;
    protected static String lombokValve;
    protected static String casePathAppTest;


    // 不同平台环境账号信息
    protected static String envNamePlatformA;
    protected static String loginUsrPlatformA;
    protected static String loginPwdPlatformA;
    protected static String loginUrlPlatformA;

    protected static String envNamePlatformB;
    protected static String loginUsrPlatformB;
    protected static String loginPwdPlatformB;
    protected static String loginUrlPlatformB;


    @Value("${http.testString.value}")
    public void setTestStringValue(String testStringValue) {
        MyAbstractTestBase.testStringValue = testStringValue;
        System.setProperty("testStringValue",testStringValue);
    }

    @Value("${http.testString.lombokValve}")
    public void setLombokValve(String lombokValve) {
        MyAbstractTestBase.lombokValve = lombokValve;
        System.setProperty("testStringValue",lombokValve);

    }
    @Value("${apptest.casepath}")
    public void setCasePathAppTest(String casePathAppTest) {
        MyAbstractTestBase.casePathAppTest = casePathAppTest;
    }

    @Value("${http.envName.platformA}")
    public void setEnvNamePlatformA(String envNamePlatformA) {
        MyAbstractTestBase.envNamePlatformA = envNamePlatformA;
    }
    @Value("${http.loginUsr.platformA}")
    public void setLoginUsrPlatformA(String loginUsrPlatformA) {
        MyAbstractTestBase.loginUsrPlatformA = loginUsrPlatformA;
    }
    @Value("${http.loginPwd.platformA}")
    public void setLoginPwdPlatformA(String loginPwdPlatformA) {
        MyAbstractTestBase.loginPwdPlatformA = loginPwdPlatformA;
    }
    @Value("${http.loginUrl.platformA}")
    public void setLoginUrlPlatformA(String loginUrlPlatformA) {
        MyAbstractTestBase.loginUrlPlatformA = loginUrlPlatformA;
    }
    @Value("${http.envName.platformB}")
    public void setEnvNamePlatformB(String envNamePlatformB) {
        MyAbstractTestBase.envNamePlatformB = envNamePlatformB;
    }
    @Value("${http.loginUsr.platformB}")
    public void setLoginUsrPlatformB(String loginUsrPlatformB) {
        MyAbstractTestBase.loginUsrPlatformB = loginUsrPlatformB;
    }
    @Value("${http.loginPwd.platformB}")
    public void setLoginPwdPlatformB(String loginPwdPlatformB) {
        MyAbstractTestBase.loginPwdPlatformB = loginPwdPlatformB;
    }
    @Value("${http.loginUrl.platformB}")
    public void setLoginUrlPlatformB(String loginUrlPlatformB) {
        MyAbstractTestBase.loginUrlPlatformB = loginUrlPlatformB;
    }
}
