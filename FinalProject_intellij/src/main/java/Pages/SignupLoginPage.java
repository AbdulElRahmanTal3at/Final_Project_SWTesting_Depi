package Pages;

import Utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignupLoginPage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    // Signup section
   private final By nameField = By.name("name");
    private final By emailSignupField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");

    // Signup full form
    private final By titleMrRadioButton = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final  By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final  By firstNameField = By.id("first_name");
    private final  By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final  By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    // Confirmation
    private final By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    // Login Section
    private final By emailLoginField = By.xpath("//input[@data-qa='login-email']");
    private final By passwordLoginField = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
//    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By errorMessage= By.xpath("//p[contains(text(),'Your email or password is incorrect')]");


    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterYourName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterYourEmail(String email){
        driver.findElement(emailSignupField).sendKeys(email);
    }
    public void clickOnSignupButton(){
        driver.findElement(signupButton).click();
    }

    public void fillAccountInformation(String password, String day, String month, String year,
                                       String firstName, String lastName, String company,
                                       String address1, String address2, String country,
                                       String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(titleMrRadioButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(dayDropdown).sendKeys(day);
        driver.findElement(monthDropdown).sendKeys(month);
        driver.findElement(yearDropdown).sendKeys(year);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(offersCheckbox).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
        driver.findElement(createAccountButton).click();
    }

    public boolean isAccountCreated() {
        return driver.findElement(accountCreatedMessage).isDisplayed();
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

    public void validateErrorMessageInSignin(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        Assert.assertTrue(driver.findElement(errorMessage).getText().contains("Your Your email or password is incorrect!") );
    }
    public void InvalidSignupErrorMessage(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        Assert.assertTrue(driver.findElement(errorMessage).getText().contains("Email Address already exist!") );
    }
    public void ValidAlert(String message){
        softAssert.assertEquals(BrowserActions.getAlertText(driver),message);
        BrowserActions.acceptAlert(driver);
        softAssert.assertAll();
    }
}
