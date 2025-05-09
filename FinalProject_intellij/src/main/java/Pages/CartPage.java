package Pages;

import Utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPage {
    WebDriver driver ;
    SoftAssert softAssert = new SoftAssert();
    private final By clickOnCart = By.xpath("//a[@href=\"/view_cart\"]");
    private final By Click_here = By.xpath("//p[@class=\"text-center\"]/a[@href=\"/products\"]/u[@data--h-bstatus=\"0OBSERVED\"]");
    private final By Try = By.linkText("Cart is empty! Click here to buy products.\n" + "\n");
    private final By Checkout =By.xpath("//div[@class=\"col-sm-6\"]/a[@data--h-bstatus=\"0OBSERVED\"]");
    private final By placeOreder = By.xpath("//a[@href=\"/payment\"]");
    private final By NameOnCard = By.name("name=\"name_on_card\"");
    private final By CardNumber = By.name("name=\"card_number\"");
    private final By CVC = By.name("name=\"cvc\"");
    private final By Month = By.name("name=\"expiry_month\"");
    private final By Year = By.name("name=\"expiry_year\"");
    private final By ConfirmOrder = By.id("id=\"submit\"");
    private final By DownloadInvoice = By.xpath("//a[@href=\"/download_invoice/400\"]");
    private final By Continue = By.xpath("//div[@class=\"pull-right\"]/a[@href=\"/\"");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public void navigate(){
        driver.get("https://automationexercise.com/");
    }
    public void FuncToClickOnCart(){
           driver.findElement(clickOnCart).click();
    }
    public void CheckCarisEmpty(){
        driver.findElement(Click_here).click();
    }
    public void Click_ON_Checkout(){
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
    //Assertions
    public void ValidAlert(String message){
        softAssert.assertEquals(BrowserActions.getAlertText(driver),message);
        BrowserActions.acceptAlert(driver);
        softAssert.assertAll();
    }
}
