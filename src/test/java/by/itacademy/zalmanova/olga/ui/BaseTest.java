package by.itacademy.zalmanova.olga.ui;
import by.itacademy.zalmanova.olga.ui.pages.LoginPage;
import by.itacademy.zalmanova.olga.ui.steps.LoginStep;
import by.itacademy.zalmanova.olga.ui.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    ChromeDriver driver;
    LoginPage loginPage;
    LoginStep loginStep;
    Util util;



    @BeforeEach
    public void warmUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        util = new Util();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        loginPage = new LoginPage(driver, wait);
        loginStep = new LoginStep(driver, wait);
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
