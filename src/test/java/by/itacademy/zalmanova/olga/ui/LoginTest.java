package by.itacademy.zalmanova.olga.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithInvalidData() {
        loginStep.fillFormAndSubmitWithInvalidData(util.generateEmail(), util.generatePassword());
        Assertions.assertEquals(loginPage.expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Test
    public void testLoginWithEmailAndEmptyPassword() {
        loginStep.fillFormAndSubmitWithInvalidData(util.generateEmail(), "");
        Assertions.assertEquals(loginPage.expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Test
    public void testLoginWithPasswordAndEmptyEmail() {
        loginStep.fillFormAndSubmitWithInvalidData("", util.generatePassword());
        Assertions.assertEquals(loginPage.expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Test
    public void testLoginWithEmptyData() {
        loginStep.fillFormAndSubmitWithInvalidData("", "");
        Assertions.assertEquals(loginPage.expectedErrorMessage, loginPage.getErrorMessage());

    }
}
