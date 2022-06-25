package com.uiauto;

import Pages.LoginPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.Set;
//<!--preserve-order="true"&&@Test(priority = 2)方法的执行的顺序-->
public class FlightWithLoginTest extends BaseTest{
    Set<Cookie> allCookies = new HashSet<Cookie>();
    @Test(priority = 0)
    public void login() throws InterruptedException{
            LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
            loginpage.login(username, password);
            //获取cookie
            allCookies = driver.manage().getCookies();
            //添加cookie
            for(Cookie cookie: allCookies) {
                if(cookie.getName() != null && cookie.getValue() != null && cookie.getPath() != null) {
                driver.manage().addCookie(cookie);
                }
            }
            //页面刷新
            driver.navigate().refresh();
            String currentUrl=driver.getCurrentUrl();
           //添加selenium的断言
            Assert.assertEquals("https://www.ctrip.com/",currentUrl);
        }
    }

