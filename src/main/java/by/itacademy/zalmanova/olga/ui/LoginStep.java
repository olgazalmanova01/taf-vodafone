package by.itacademy.zalmanova.olga.ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStep {

    LoginPage loginPage;

    public LoginStep(ChromeDriver driver, WebDriverWait wait) {
        loginPage = new LoginPage(driver, wait);
    }

    public void fillFormAndSubmitWithInvalidData(String email, String password) {

        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickContinueBtn();
        loginPage.getErrorMessage();
    }
}
