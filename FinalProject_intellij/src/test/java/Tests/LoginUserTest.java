package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SignupLoginPage;

public class LoginUserTest extends TestBase {
    HomePage homePage;
    SignupLoginPage signupLoginPage;
    @Test
    public void LoginSuccessfully() {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();

        signupLoginPage.enterEmailInLogin("olaalaa@gmail");
        signupLoginPage.enterPasswordInLogin("123456");
        signupLoginPage.clickOnLoginButton();
//        signupLoginPage.ValidAlert("Change your password");

//        Assert.assertTrue(signupLoginPage.isLoggedIn(), "User login failed!");
    }
    @Test
    public void loginWithInvalidPassword () {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();
        signupLoginPage.enterEmailInLogin("olaalaa@gmail");
        signupLoginPage.enterPasswordInLogin("444123456");
        signupLoginPage.clickOnLoginButton();
        signupLoginPage.validateErrorMessageInSignin();
    }
    @Test
    public void loginWithInvalidEmail () {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();
        signupLoginPage.enterEmailInLogin("12345@Fs");
        signupLoginPage.enterPasswordInLogin("123456");
        signupLoginPage.clickOnLoginButton();
        signupLoginPage.validateErrorMessageInSignin();

    }
    @Test
    public void loginWithInvalidEmailAndPassword(){
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();
        signupLoginPage.enterEmailInLogin("Aolaalaa@gmail");
            signupLoginPage.enterPasswordInLogin("22123456");
        signupLoginPage.clickOnLoginButton();
        signupLoginPage.validateErrorMessageInSignin();
}
}