package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTest  extends TestBase {
    ProductPage productPage ;

    @Test(priority = 0)
    public void OpenPageProducts(){
        productPage = new ProductPage(driver);
        productPage.navigate();
        productPage.setClickOnProducts();
    }
    @Test(priority = 1)
    public void AddProductToCart(){
        productPage = new ProductPage(driver);
        productPage.navigate();
        productPage.setClickOnProducts();
        productPage.scrollDown();
        productPage.SendProductToCart();
        productPage.AcceptContinueShopping();
        productPage.setClickOnProducts(); // Then Return to Cart Again
    }
    @Test
    public void ViewCartAfterBuy(){
        productPage = new ProductPage(driver);
        productPage.navigate();
        productPage.setClickOnProducts();
        productPage.scrollDown();
        productPage.SendProductToCart();
        productPage.ClickOnViewCart();
        productPage.AcceptContinueShopping();
    }
    @Test
    public void ProceedToCheckOut(){
        productPage = new ProductPage(driver);
        productPage.navigate();
        productPage.clickSignupLogin();
        productPage.enterEmailInLogin("olaalaa@gmail");
        productPage.enterPasswordInLogin("123456");
        productPage.clickOnLoginButton();
        productPage.setClickOnProducts();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        productPage.ValidAlert("Change your password");
        productPage.scrollDown();
        productPage.SendProductToCart();
        productPage.ClickOnViewCart();
        productPage.ClickToCheckOut();
        productPage.FuncClickOnPlaceOrder();
        productPage.StringNameOnCard("Abdulrahman");
        productPage.StringWriteCardNumber("2222222");
        productPage.StringWriteCVC("311");
        productPage.StringWriteMonth("4");
        productPage.StringWriteYear("2030");
        productPage.ClickConfirmOrder();
        productPage.ClickContinue();
    }

}
