package Pages;

import Utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ProductPage {
    WebDriver driver ;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait ;
    private final By clickOnProducts = By.xpath("//a[@href=\"/products\"]");
    private final By ClickOnViewProduct = By.xpath("//a[@href=\"/product_details/2\"]");
    private final By AddProduct = By.xpath("//button[@type=\"button\"]");
//    private final By SumbitProduct = By.id("id=\"button-review\"");
    By signupLoginButton = By.linkText("Signup / Login");
    private final By emailLoginField = By.xpath("//input[@data-qa='login-email']");
    private final By passwordLoginField = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By ContinueShopping = By.xpath("//button[@data-dismiss=\"modal\"]");
    private final By ViewCART =  By.xpath("//p[@class=\"text-center\"]/a[@href=\"/view_cart\"]");
    private final By Checkout =By.xpath("//div[@class=\"row\"]/div[@class=\"col-sm-6\"]/a[@class=\"btn btn-default check_out\"]");
    private final By placeOreder = By.xpath("//a[@href=\"/payment\"]");
    private final By NameOnCard = By.name("name_on_card");
    private final By CardNumber = By.name("card_number");
    private final By CVC = By.name("cvc");
    private final By Month = By.name("expiry_month");
    private final By Year = By.name("expiry_year");
    private final By ConfirmOrder = By.id("submit");
    private final By DownloadInvoice = By.xpath("//a[@href=\"/download_invoice/400\"]");
    private final By Continue = By.xpath("//div[@class=\"pull-right\"]/a[@href=\"/\"]");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigate(){
        driver.get("https://automationexercise.com/");
    }
    public void setClickOnProducts(){
        driver.findElement(clickOnProducts).click();
    }
    public void SendProductToCart(){
        driver.findElement(ClickOnViewProduct).click();
        driver.findElement(AddProduct).click();
    }
    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }
    public void enterEmailInLogin(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void enterPasswordInLogin(String password){
        driver.findElement(passwordLoginField ).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void AcceptContinueShopping(){
        driver.findElement(ContinueShopping).click();
    }
    public void ClickOnViewCart(){
        driver.findElement(ViewCART).click();
    }
    public void ClickToCheckOut(){
        driver.findElement(Checkout).click();
    }
    public void FuncClickOnPlaceOrder(){
        driver.findElement(placeOreder).click();
    }
    public void StringNameOnCard(String Name){
        driver.findElement(NameOnCard).sendKeys(Name);
    }
    public void StringWriteCardNumber(String Number){
        driver.findElement(CardNumber).sendKeys(Number);
    }
    public void StringWriteCVC(String Number){
        driver.findElement(CVC).sendKeys(Number);
    }
    public void StringWriteMonth(String Number){
        driver.findElement(Month).sendKeys(Number);
    }
    public void StringWriteYear(String Number){
        driver.findElement(Year).sendKeys(Number);
    }
    public void ClickConfirmOrder(){
        driver.findElement(ConfirmOrder).click();
    }
    public void ClickContinue(){
        driver.findElement(Continue).click();
    }
//    public void SumbitProduct(){
//        driver.findElement(SumbitProduct).click();
//    }
    public void scrollDown()
    {
    //to perform Scroll on application using Selenium
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,500)", "");
    }


    //Assertions
    public void ValidAlert(String message){
        softAssert.assertEquals(BrowserActions.getAlertText(driver),message);
        BrowserActions.acceptAlert(driver);
        softAssert.assertAll();
    }



}
