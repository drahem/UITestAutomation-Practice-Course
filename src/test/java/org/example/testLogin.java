package org.example;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.appointmentPage;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.testBase;

import java.io.File;
import java.net.URL;
import java.time.Duration;


public class testLogin extends testBase {

    @DataProvider(name = "testData")
    public Object [][] provider( ) throws Exception
    {
        String path = "./src\\test\\java\\resources\\testData.csv";
        ExtUtils ext = new CSVUtils(path, true);
        return ext.parseData();
    }

    @BeforeClass
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
    }


    @Test(dataProvider = "testData")
    public void testMakeAppointment(String facility, String readmission, String program, String date, String comment){
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        appointmentPage ap = new appointmentPage(driver);
        ap.selectFacility(facility);
        ap.checkReadMission(readmission);
        ap.selectHealthCareProgram(program);
        ap.setVisitDate(date);
        ap.setComment(comment);
        ap.clickBookAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
    }
}
