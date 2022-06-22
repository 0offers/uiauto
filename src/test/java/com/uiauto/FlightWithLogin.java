package com.uiauto;

import Pages.LoginPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.Set;
//<!--preserve-order="true"&&@Test(priority = 2)方法的执行的顺序-->
public class FlightWithLogin extends BaseTest{
    Set<Cookie> allCookies = new HashSet<Cookie>();
    @Test(priority = 0)
    public void login() throws InterruptedException{
            //后面考虑将一些参数写入配置文件里面application.yaml
            String username = "dyangc@ctrip.com";
            String password = "12345678";
            LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
            loginpage.login(username, password);
            Thread.sleep(100);
            allCookies = driver.manage().getCookies();
            //添加cookie
            for(Cookie cookie: allCookies) {
                if(cookie.getName() != null && cookie.getValue() != null && cookie.getPath() != null) {
                driver.manage().addCookie(cookie);
                }
            }
            //添加selenium的断言
        }

    }
    //FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
    //loginpage.setEmail("your-username");
