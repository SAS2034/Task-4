package org.example;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest{
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    private Logger logger = LogManager.getLogger(LoginTest.class);

   private final String LOGIN = System.getProperty("login");
    private final String PASSWORD = System.getProperty("password");


    @BeforeAll
    public static void setup() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {

        driver = new ChromeDriver();

    }

    @AfterEach
    public void downDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    @Test

    public void PegaTest() {

// Перейти на http://vsfadev1:9080/prweb/PRServlet/app/default/oO9O9iMscyJc_fy6LnBDXO9xEtRpDxfL3At36r8Aw8k*/!STANDARD
        driver.get("http://vsfadev1:9080/prweb/PRServlet/app/default/oO9O9iMscyJc_fy6LnBDXO9xEtRpDxfL3At36r8Aw8k*/!STANDARD");

// Написать тест, который при помощи selenide выполнит вход в SFA-Pega
        login();
    }

    public void login() {
        WebElement email = driver.findElement(By.xpath("//input[@name=\"UserIdentifier\"]"));
        email.click();
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(LOGIN).perform();
        WebElement password = driver.findElement(By.xpath("//input[@name=\"Password\"]"));
        password.click();
        action.moveToElement(password).sendKeys(PASSWORD).perform();
        WebElement lButton = driver.findElement(By.xpath("//button[@id=\"sub\"]"));
        action.moveToElement(lButton).click().build().perform();
    }
}