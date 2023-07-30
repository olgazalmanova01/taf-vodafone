package by.itacademy.zalmanova.olga.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private String baseURL = "https://www.vodafone.co.uk";
    private String closePopUpBtnLocator = "//button[@id = 'onetrust-accept-btn-handler']";
    private String dropdownBtnLocator = "//button[@type='button' and @aria-label='Your account options']";
    private String loginBtnLocator = "//a[@href='https://myaccount.vodafone.co.uk/account/summary']";
    private String emailInputLocator = "//input[@placeholder='Usually your email address']";
    private String continueBtnLocator = "//button[@type='submit']";
    private String passwordInputLocator = "//input[@placeholder='Enter your password']";
    private String errorMessageLocator = "//div[@id='idm-error']";
    public String expectedErrorMessage = "We didn't recognise your username or password\n" +
            "Please check and try again. Remember, your password is case sensitive.";

    public LoginPage(ChromeDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void selectDropdownBtn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(dropdownBtnLocator))).perform();
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginBtnLocator)));
        driver.findElement(By.xpath(loginBtnLocator)).click();
    }

    public void closePopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closePopUpBtnLocator)));
            driver.findElement(By.xpath(closePopUpBtnLocator)).click();
        } catch (TimeoutException e) {
        }
    }

    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailInputLocator)));
        WebElement inputEmail = driver.findElement(By.xpath(emailInputLocator));
        inputEmail.sendKeys(email);
    }

    public void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordInputLocator)));
        WebElement inputPassword = driver.findElement(By.xpath(passwordInputLocator));
        inputPassword.sendKeys(password);
    }

    public void clickContinueBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continueBtnLocator)));
        driver.findElement(By.xpath(continueBtnLocator)).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorMessageLocator)));
        String actualErrorMessage = driver.findElement(By.xpath(errorMessageLocator)).getText();
        return actualErrorMessage;
    }
}
