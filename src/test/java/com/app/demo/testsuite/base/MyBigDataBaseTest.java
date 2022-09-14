package com.app.demo.testsuite.base;


import com.app.demo.testsuite.https.common.utils.CookiesUtil;
import https.MyBigDataTester;
import https.MyHttpTester;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;

/**
 * 用来存放测试类执行之前以及之后的处理
 */
public class MyBigDataBaseTest extends MyBaseTest{
    //测试用例所在的目录
    protected static String caseRootAppTest;

    /**
     * 用于执行测试类之前执行
     */
    private void testBefore(String dir,String testCaseDataFileName){
        try {
            MyBigDataTester bigDataTester = new MyBigDataTester();
            bigDataTester.runTest(dir+testCaseDataFileName);
        }catch (Exception e){
            Assert.assertNull(e);
        }
    }

    /**
     * 用于执行测试类之后执行
     */
    private void testAfter(String dir,String testCaseDataFileName){
        try {
            MyBigDataTester bigDataTester = new MyBigDataTester();
            bigDataTester.runTest(dir+testCaseDataFileName);
        }catch (Exception e){
            Assert.assertNull(e);
        }
    }

    /**
     *
     * @param login 登录到对应平台的标识
     */
    protected static void setCookie(String login) throws InterruptedException {
        MyHttpTester.setCookie(CookiesUtil.getCookie(login));
        //todo
    }

    @BeforeGroups(groups = {"appTest_Module1"})
    public void beforeAppTestGroup() throws InterruptedException {
        System.out.println("在测试组appTest_Module1之前");
        caseRootAppTest = "testcasedata/"+casePathAppTest;
        testBefore(caseRootAppTest,"/before/beforeAppTest.json");

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.126.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @BeforeGroups(groups = {"appTest_Module2"})
    public void beforeAppTestGroup2() throws InterruptedException {
        MyHttpTester.setCookie("");
        // 或者需要登录页面 使用 (this.)setCookie()
        caseRootAppTest = "testcasedata/"+casePathAppTest;
        testBefore(caseRootAppTest,"/before/beforeAppTest.json");

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.126.com");
        Thread.sleep(5000);
        driver.quit();
        System.out.println("=======appTest运行前加载配置文件！===========");
    }

    @BeforeGroups(groups = "platformA")
    public void beforePlatformA() throws InterruptedException {
        casePathAppTest = "testcasedata/" + casePathAppTest;
        CookiesUtil.getCookie("platformA");
    }

    @BeforeGroups(groups = "platformB")
    public void beforePlatformB() throws InterruptedException {
//        caseRootAppTest = "testcasedata/"+casePathAppTest;
        casePathAppTest = "testcasedata/" + casePathAppTest;
        CookiesUtil.getCookie("platformB");
    }
}
