package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(how = How.ID, using = "userName")
    public WebElement userNameBox;
    @FindBy(how = How.ID, using = "txtPassword")
    public WebElement passwordBox;
    public WebElement signinButton;
    @FindBy(how = How.CLASS_NAME , using = "loading-brick")
    public WebElement loadingIndicator;
    By dragButton = new By.ByClassName("cpt-drop-btn");
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String username,String password){
        String url="https://www.trip.com/account/signin?curr=USD&language=EN&locale=en_us&backurl=https%3A%2F%2Fwww.trip.com%2Fflights%2F";
       /* if (environment.equals("Bastion") ) {
            url = "https://www.trip.com/account/signin?curr=USD&language=EN&locale=en_us&backurl=https%3A%2F%2Fwww.trip.com%2Fflights%2F";
        }else {
            url = "https://www.fat1.qa.nt.tripcorp.com/account/signin?curr=USD&language=EN&locale=en_us&backurl=https%3A%2F%2Fwww.fat1.qa.nt.tripcorp.com%2Fflights";
        }*/
        driver.get(url);
        driver.manage().deleteAllCookies();
        sendKeys(userNameBox, username);
        sendKeys(passwordBox, password);
        //if visiable dragButton:
        if (isPresent(dragButton)) {
            dragAndDrop(dragButton, 263, 0);
        }
        waitClickable(signinButton);
        clickAndWaitInvisible(signinButton, loadingIndicator);
    }
    //跳转界面
    public HomePage search() {
        click(searchBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }
}

