package org.example;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.appointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import util.testBase;

import java.time.Duration;

public class testLogin extends testBase {

    @Test
    public void login(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        HomePage hp = new HomePage(driver);
        hp.clickMakeAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName("John Doe");
        lp.setPassword("ThisIsNotAPassword");
        lp.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        appointmentPage ap = new appointmentPage(driver);

        ap.selectFacility("Seoul CURA Healthcare Center");
        ap.checkReadMission();
        ap.selectHealthCareProgram("none");
        ap.setVisitDate("30");


    }
}
