package org.example;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLogin {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        option.addArguments("incognito");
        driver = new ChromeDriver(option);
    }


    @Test
    public void login(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        HomePage hp = new HomePage(driver);
        hp.clickMakeAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName("John Doe");
        lp.setPassword("ThisIsNotAPassword");
        lp.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");


    }
}
