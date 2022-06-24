package Pages;

import org.apache.catalina.filters.WebdavFixFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    //logback-->slf4j|log4j-->slf4j
    private static final Logger logger= LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    public <T> void click(T element){
       // WebElement element=driver.findElement(By.id("kw"));
        if(element.getClass().getName().contains("By")){
            driver.findElement((By) element).click();
        }else{
            ((WebElement) element).click();
        }
    }
    public <T> void sendKeys(T element,String value){
        if(element.getClass().getName().contains("By")) {
            driver.findElement((By) element).sendKeys(value);
        } else {
            ((WebElement) element).sendKeys(value);
        }
    }
    public <T> void clear (T element) {
        if(element.getClass().getName().contains("By")) {
            driver.findElement((By) element).clear();
        } else {
            ((WebElement) element).clear();
        }
    }
}
