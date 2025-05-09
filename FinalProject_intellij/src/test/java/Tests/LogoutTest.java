package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SignupLoginPage;
public class LogoutTest extends TestBase {
    SignupLoginPage signupLoginPage;
    HomePage homePage;
    @Test
    public void testLogoutSuccessfully() {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();
        signupLoginPage.enterEmailInLogin("olaalaa@gmail");
        signupLoginPage.enterPasswordInLogin("123456");
        signupLoginPage.clickOnLoginButton();
        homePage.clickLogout();
}

}
