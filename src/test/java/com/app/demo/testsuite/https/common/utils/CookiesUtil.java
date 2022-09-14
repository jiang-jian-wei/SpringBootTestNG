package com.app.demo.testsuite.https.common.utils;

import com.app.demo.testsuite.base.MyBaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

public class CookiesUtil extends MyBaseTest {
    public static WebDriver driver;
    public static String Cookie = "";
    public static int reTryTimes = 1;

    public static String getCookie(String login) throws InterruptedException{
        try {
            switch (login){
                case "platformA":
                    System.out.println("step1");
                    System.out.println("envName:"+envNamePlatformA);
                    System.out.println("loginUsr:"+loginUsrPlatformA);
                    System.out.println("loginPwd"+loginPwdPlatformA);
                    System.out.println("loginUrl"+loginUrlPlatformA);
                    initCookie(envNamePlatformA,loginUsrPlatformA,loginPwdPlatformA,loginUrlPlatformA);
                    break;
                case "platformB":
                    System.out.println("step1");
                    System.out.println("envName:"+envNamePlatformB);
                    System.out.println("loginUsr:"+loginUsrPlatformB);
                    System.out.println("loginPwd"+loginPwdPlatformB);
                    System.out.println("loginUrl"+loginUrlPlatformB);
                    initCookie(envNamePlatformB,loginUsrPlatformB,loginPwdPlatformB,loginUrlPlatformB);
                    break;
            }

        }catch (RuntimeException e3){
            if(reTryTimes<1){
                throw e3;
            }
            System.out.println("---getCookie方法重试中---");
            --reTryTimes;
            Cookie = "";
            getCookie(login);
        }
        System.out.println("Catch cookie is: " + Cookie);
        return Cookie;
    }

    private static void initCookie(String app,String usr,String pwd,String login) throws InterruptedException {
        try {
            init(login);
            Thread.sleep(3000L);
            System.out.println("begin to login..\n");
            login(app,usr,pwd);
            Thread.sleep(3000L);
            System.out.println("begin to catch cookie...\n");
            catchCookie();
        }finally {
            driver.quit();
            System.out.println("----浏览器已关闭----");
        }
        }

    private static void init(String url){
        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver",getChromeDriverAddress());

        driver = new ChromeDriver(options);

        System.out.println("-----------++++++++"+driver);
        System.out.println("-----------++++++++url="+url);
        driver.get(url);
    }

    private static void catchCookie(){
        Set cookies = driver.manage().getCookies();
        Cookie cookie;
        for(Iterator iterator = cookies.iterator();iterator.hasNext();
        Cookie = Cookie + cookie.getName() + "=" + cookie.getValue() +";"){
            cookie = (Cookie) iterator.next();
        }

        Cookie = Cookie.substring(0,Cookie.length() - 1);
        System.out.println("Cookie is :" + Cookie + "\n");
    }


    public static void login(String className,String usr,String pwd) {
        try {
            String e = "com.app.demo.testsuite.https.common.login.Login_";
            String methodName = "login_";
            methodName = methodName + className;
            className = e + className;
            Class testClass = Class.forName(className);
            Method method = testClass.getMethod(methodName,new Class[]{String.class,String.class} );
            method.invoke(methodName,new Object[]{usr,pwd});
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    /**
     * 根据当前操作系统设置chromedriver路径
     */
    public static String getChromeDriverAddress(){
        String osName = System.getProperty("os.name");
        String chromeDriverAddress = "";

        if(Pattern.matches("Windows.*",osName)){
            chromeDriverAddress = "C:\\ChromeDriver\\chromedriver.exe";
        } else if (Pattern.matches("Linux.*",osName)){
            chromeDriverAddress = "";
        }else if (Pattern.matches("Mac.*",osName)){
            chromeDriverAddress = "";
        }
        return chromeDriverAddress;
    }
}
