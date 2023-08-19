package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By userName = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginBtn = By.id("btn-login");

    public void doLogin(String user, String pass){
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void setUserName(String user){
        driver.findElement(userName).sendKeys(user);
    }

    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
}
