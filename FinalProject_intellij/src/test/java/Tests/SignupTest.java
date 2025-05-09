package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SignupLoginPage;

public class SignupTest extends TestBase {
    HomePage homePage;
    SignupLoginPage signupLoginPage;
    @Test
    public void testUserSignupSuccessfully() {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();

        homePage.clickSignupLogin();
        signupLoginPage.enterYourName("OlaAlaa");
        signupLoginPage.enterYourEmail("olaaalaa@gmail");
        signupLoginPage.clickOnSignupButton();
        signupLoginPage.fillAccountInformation(
                "123456",
                "1", "January", "1990",
                "Test", "User", "Test Company",
                "Test Address 1", "Test Address 2", "United States",
                "Test State", "Test City", "12345", "1234567890"
        );

        Assert.assertTrue(signupLoginPage.isAccountCreated(), "Account creation failed!");
    }
    @Test
    public void signupWithUsingEmail() {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();

        homePage.clickSignupLogin();
        signupLoginPage.enterYourName("Ola2 Alaa");
        signupLoginPage.enterYourEmail("olaalaa@gmail");
        signupLoginPage.clickOnSignupButton();
        signupLoginPage.InvalidSignupErrorMessage();
    }
    @Test
    public void signupWithInvalidUserName(){
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLogin();
        signupLoginPage.enterYourName("123456");
        signupLoginPage.enterYourEmail("alaaola@gmail");
        signupLoginPage.clickOnSignupButton();
        signupLoginPage.InvalidSignupErrorMessage();


    }



}

