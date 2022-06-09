package Pages;

import org.apache.catalina.filters.WebdavFixFilter;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
}
