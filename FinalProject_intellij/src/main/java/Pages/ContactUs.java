package Pages;

import Utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class ContactUs {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    private final By Name = By.name("name");
    private final By Email = By.name("email");
    private final By Subject = By.name("subject");
    private final By Sumbit = By.name("submit");
    private final By ContactUs = By.xpath("//a[@href=\"/contact_us\"]");
    private final By Message = By.name("message");
    public  ContactUs(WebDriver driver){
        this.driver= driver ;
    }
    public void navigate(){
        driver.get("https://automationexercise.com/");
    }
    public void ClickOnContactUs(){
        driver.findElement(ContactUs).click();
    }
    public void FillName(String name){
        driver.findElement(Name).sendKeys(name);
    }
    public void FillEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void FillSubject(String subject){
        driver.findElement(Subject).sendKeys(subject);
    }
    public void FillMessage(String message){
        driver.findElement(Message).sendKeys(message);
    }
    public void Sumbit(){
        driver.findElement(Sumbit).click();
    }
    public void ValidAlert(String message){
        softAssert.assertEquals(BrowserActions.getAlertText(driver),message);
        BrowserActions.acceptAlert(driver);
        softAssert.assertAll();
    }
}
