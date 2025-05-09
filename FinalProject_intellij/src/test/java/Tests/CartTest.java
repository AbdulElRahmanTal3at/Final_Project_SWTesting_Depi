package Tests;

import Base.TestBase;
import Pages.CartPage;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

public class CartTest extends TestBase {
    CartPage cartPage ;
    @Test
    public void OpenCart()
    {
      cartPage = new CartPage(driver);
      cartPage.navigate();
      cartPage.FuncToClickOnCart();
    }
    @Test
    public void EmptyCartGoToProducts(){
        cartPage=new CartPage(driver);
        cartPage.navigate();
        cartPage.FuncToClickOnCart();
        cartPage.CheckCarisEmpty();
    }
    @Test
    public void Payment(){
        cartPage = new CartPage(driver);
        cartPage.navigate();
        cartPage.FuncToClickOnCart();
        cartPage.Click_ON_Checkout();
        cartPage.FuncClickOnPlaceOrder();
        cartPage.StringNameOnCard("Abdulrahman");
        cartPage.StringWriteCardNumber("2222222");
        cartPage.StringWriteCVC("311");
        cartPage.StringWriteMonth("4");
        cartPage.StringWriteYear("2030");
        cartPage.ClickConfirmOrder();
        cartPage.ClickContinue();
    }

}
