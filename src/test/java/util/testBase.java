package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public class testBase {

    public WebDriver driver;

    public WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    @BeforeClass
    public void initializeSelenium(){
        driver = getDriver();
    }

    @AfterSuite
    public void stopDriver()
    {
      //  driver.quit();
    }


}
