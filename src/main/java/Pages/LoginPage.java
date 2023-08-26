package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.genericMethods;

public class LoginPage extends genericMethods {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By userName = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginBtn = By.id("btn-login");

    public void doLogin(String user, String pass){

        enterText(driver.findElement(userName), user);
        enterText(driver.findElement(password), pass);
        clickElement(driver.findElement(loginBtn));
    }

    public void setUserName(String user){
        enterText(driver.findElement(userName), user);
    }

    public void setPassword(String pass){
        enterText(driver.findElement(password), pass);    }

    public void clickLoginBtn(){
        clickElement(driver.findElement(loginBtn));
    }
}
