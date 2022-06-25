package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(how=How.XPATH,using="//input[@id='nloginname' and @class='r_input']")
    public WebElement userNameBox;
    @FindBy(how = How.XPATH, using ="//input[@type='password' and @id='npwd']")
    public WebElement passwordBox;
    @FindBy(how = How.XPATH, using ="//input[@type='checkbox' and @class='agreement-checkbox']")
    public WebElement protocolBox;
    By submit=new By.ById("nsubmit");
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public HomePage login(String username, String password){
        String url="https://passport.ctrip.com/user/login?BackUrl=https%3A%2F%2Fwww.ctrip.com%2F#ctm_ref=c_ph_login_buttom";
        driver.manage().deleteAllCookies();
        driver.get(url);
        sendKeys(userNameBox,username);
        sendKeys(passwordBox, password);
        click(protocolBox);
        click(submit);
        //跳转界面
        return PageFactory.initElements(driver, HomePage.class);
    }
}


