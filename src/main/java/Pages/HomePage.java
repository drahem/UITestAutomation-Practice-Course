package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By makeAppointmentBtn = By.id("btn-make-appointment");

    public void clickMakeAppointmentBtn(){
        driver.findElement(makeAppointmentBtn).click();
    }

}
