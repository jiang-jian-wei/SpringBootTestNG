package com.app.demo.testsuite.https.common.login;

import com.app.demo.testsuite.https.common.utils.CookiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_PlatformB extends CookiesUtil {
    /**
     * 登录PlatformB
     */
    public static void login_PlatformB(String usr,String pwd){
        System.out.println("===========================开始登录================================");
        //切换iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe')]")));
        //设置等待时间 针对全局设置 webDriver 中执行的所有命令的超时时间都为10s
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 显示等待
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'邮箱帐号或手机号码')]")));
        driver.findElement(By.xpath("//input[contains(@placeholder,'邮箱帐号或手机号码')]")).sendKeys(usr);

        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@data-placeholder,'输入密码')]")));
        driver.findElement(By.xpath("//*[contains(@data-placeholder,'输入密码')]")).sendKeys(pwd);

        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("dologin")));
        driver.findElement(By.id("dologin")).click();
    }
}
