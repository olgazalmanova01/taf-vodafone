package by.itacademy.zalmanova.olga.ui.steps;

import by.itacademy.zalmanova.olga.ui.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStep {

    LoginPage loginPage;

    public LoginStep(ChromeDriver driver, WebDriverWait wait) {
        loginPage = new LoginPage(driver, wait);
    }

    public void fillFormAndSubmitWithInvalidData(String email, String password) {

        loginPage.openBaseURL();
        loginPage.closePopUp();
        loginPage.selectDropdownBtn();
        loginPage.clickLoginBtn();
        loginPage.fillEmail(email);
        loginPage.clickContinueBtn();
        loginPage.fillPassword(password);
        loginPage.clickContinueBtn();
        loginPage.getErrorMessage();
    }
}
