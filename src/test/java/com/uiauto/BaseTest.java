package com.uiauto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@AutoConfigureMockMvc
@SpringBootTest(classes=UiautoApplication.class)
@PropertySource(value="classpath:config.properties")
@Component
class BaseTest extends AbstractTestNGSpringContextTests {
    public static WebDriver driver;
    //public String url;
    @Autowired
    private MockMvc mockMvc;
    //@Autowired
    //private WebApplicationContext webApplicationContext;
    @Value("${driver.browser}")
    public String browser;
    @Value("${driver.path}")
    public String driverPath;
    @Value("${driver.version}")
    public String browserVersion;
    @BeforeTest
    public void cleanUp(){
        //https://blog.csdn.net/u010798073/article/details/115831800
        // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //清除报告的位置
        String reportPath="target/allure-results";
        File report=new File(reportPath);
        if(report.exists()) {
            try {
                FileUtils.deleteDirectory(report);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.mkdirs();
        if(driver!=null)
            driver.quit();
    }

    @BeforeMethod
    //@Parameters("browser")
    //public void setUp(@Optional("chrome")String browser){
    public void setUp(){
        //驱动器采用环境变量配置
        if(browser.equalsIgnoreCase("firefox")){
            //System.setProperty("webdriver.gecko.driver",driverPath);
            //指定浏览器的版本和64|32位
           // WebDriverManager.firefoxdriver().browserVersion(browserVersion).arch64().setup();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            //System.setProperty("webdriver.chrome.driver","C:\\selenium_driver\\chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
            //System.setProperty("webdriver.chrome.driver",driverPath);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            //System.setProperty("webdriver.ie.driver",driverPath);
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
//        driver.get(url);
//        driver.manage().window().maximize();//窗口最大化
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
