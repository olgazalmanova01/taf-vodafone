package by.itacademy.zalmanova.olga.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private String baseURL = "https://www.vodafone.co.uk";
    private String closePopUpBtnLocator = "//button[@id = 'onetrust-accept-btn-handler']";
    private String dropdownBtnLocator = "[aria-label = 'Your account options']";
    private String loginBtnLocator = "[aria-label='Login to My Vodafone']";


    public HomePage(ChromeDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void clickDropdownBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(dropdownBtnLocator)));
        driver.findElement(By.name(dropdownBtnLocator)).click();
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(loginBtnLocator)));
        driver.findElement(By.name(loginBtnLocator)).click();
    }

    public void closePopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closePopUpBtnLocator)));
            driver.findElement(By.xpath(closePopUpBtnLocator)).click();
        } catch (TimeoutException e) {
        }
    }
}