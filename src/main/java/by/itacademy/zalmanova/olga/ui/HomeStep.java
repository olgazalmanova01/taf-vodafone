package by.itacademy.zalmanova.olga.ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeStep {
    HomePage homePage;

    public HomeStep(ChromeDriver driver, WebDriverWait wait) {
        homePage = new HomePage(driver, wait);
    }

    public void openBaseUrlAndClickLoginBtn() {
        homePage.openBaseURL();
        homePage.closePopUp();
        homePage.clickDropdownBtn();
        homePage.clickLoginBtn();
    }
}

