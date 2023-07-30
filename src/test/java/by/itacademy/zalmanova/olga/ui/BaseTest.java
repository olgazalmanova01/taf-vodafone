package by.itacademy.zalmanova.olga.ui;

import by.itacademy.zalmanova.olga.ui.pages.LoginPage;
import by.itacademy.zalmanova.olga.ui.steps.LoginStep;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    ChromeDriver driver;
    LoginPage loginPage;
    LoginStep loginStep;
    Util util;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        loginPage = new LoginPage(driver, wait);
        loginStep = new LoginStep(driver, wait);
        util = new Util();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
