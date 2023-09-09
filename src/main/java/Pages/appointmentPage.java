package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.genericMethods;

import java.util.Objects;

public class appointmentPage extends genericMethods{

    WebDriver driver;
    public appointmentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By facilityMenu = By.id("combo_facility");
    private By readMissionCheckBox = By.id("chk_hospotal_readmission");

    private By mediCareProgram = By.id("radio_program_medicare");
    private By mediCaidProgram = By.id("radio_program_medicaid");
    private By noneProgram = By.id("radio_program_none");

    public void selectFacility(String facilityName){

        clickElement(driver.findElement(facilityMenu));
        clickElement(driver.findElement(By.xpath("//option[text()='"+facilityName+"']")));
    }

    public void checkReadMission(String check){
        if (Objects.equals(check, "true")){
        clickElement(driver.findElement(readMissionCheckBox));
        }
    }

    public void selectHealthCareProgram(String program){
        clickElement(driver.findElement(By.xpath("//input[@id='radio_program_"+program+"']")));
    }

    private By dateBtn = By.className("input-group-addon");
    public void setVisitDate(String day){
        clickElement(driver.findElement(dateBtn));
        clickElement(driver.findElement(By.xpath("//td[@class = 'day' and text()='"+day+"']")));
    }

    private By dateText = By.id("txt_visit_date");
    public void setDate(String date){
        enterText(driver.findElement(dateText), date);
    }

    private By comment = By.id("txt_comment");
    public void setComment(String text){
        enterText(driver.findElement(comment), text);
    }

    private By makeAppointmentBtn = By.id("btn-book-appointment");
    public void clickBookAppointmentBtn(){
        clickElement(driver.findElement(makeAppointmentBtn));

    }
}
