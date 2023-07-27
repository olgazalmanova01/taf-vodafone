package by.itacademy.zalmanova.olga.ui;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    ChromeDriver driver;
    HomePage homePage;
    HomeStep homeStep;
    LoginPage loginPage;
    LoginStep loginStep;
    Util util;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        homePage = new HomePage(driver, wait);
        homeStep = new HomeStep(driver, wait);
        loginPage = new LoginPage(driver, wait);
        loginStep = new LoginStep(driver, wait);
        util = new Util();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
