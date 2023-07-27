package by.itacademy.zalmanova.olga.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private ChromeDriver driver;
    private WebDriverWait wait;

    private String emailInputLocator = "//input[@placeholder='Usually your email address']";
    private String continueBtnLocator = "//button[@type='submit']";
    private String passwordInputLocator = "//input[@placeholder='Enter your password']";
    private String errorMessageLocator = "//div[@id='idm-error']";

    public LoginPage(ChromeDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
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
