package com.tomkondat5.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/login");
        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement key = driver.findElement(By.name("session_key"));
        key.sendKeys("");

        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("");

        WebElement loginButton = driver
                .findElement(By.xpath("//button[@data-litms-control-urn=\"login-submit\"]"));

        loginButton.click();

        WebElement meButton = driver.findElement(By.id("ember16"));
        meButton.click();

        WebElement profileButton = driver.findElement(By.className("artdeco-entity-lockup__title"));
        profileButton.click();

        WebElement connectionsSpan = driver.findElement(By.xpath("//span[text()=' connections']"));
        connectionsSpan.click();

        // Close browser
        // driver.quit();
    }
}
