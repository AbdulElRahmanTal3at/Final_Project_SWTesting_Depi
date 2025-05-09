package Pages;

import Utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By signupLoginButton = By.linkText("Signup / Login");
    By productsButton = By.xpath("//a[@href='/products']");
    By logoutButton = By.linkText("Logout");
    By homePageVisibleElement = By.xpath("//div[@class='carousel-inner']");
    private final By Go_to_Cart = By.xpath("//a[@data--h-bstatus=\"0OBSERVED\"]/img[@data--h-bstatus=\"5PROCESSED\"]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public void clickProducts() {
        driver.findElement(productsButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
   public void navigate(){
        driver.get("https://automationexercise.com/");
   }
   public void ClickOnCart(){
        driver.findElement(Go_to_Cart).click();
   }
   public void acceptAlert(){BrowserActions.acceptAlert(driver);
   }


}
