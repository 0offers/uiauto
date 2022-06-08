package com.uiauto;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.Set;

public class FlightWithLogin extends BaseTest{
    Set<Cookie> allCookies = new HashSet<Cookie>();
    @Test
    public void login() throws InterruptedException{
            String username = "uiautotest@ctrip.com";
            String password = "12345678";
            FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
            loginpage.loginToFlights(username, password)
            Thread.sleep(100);
            allCookies = driver.manage().getCookies();
        }

    }
    //FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
    //loginpage.setEmail("your-username");
}
