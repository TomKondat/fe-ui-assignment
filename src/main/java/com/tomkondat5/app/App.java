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
        driver.get("https://www.linkedin.com/");
        System.out.println(driver.getTitle());

        // Wait for browser to warm up
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Select elements
        WebElement key = driver.findElement(By.name("session_key"));
        key.sendKeys("123456");
        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("1234");
        WebElement loginButton = driver
                .findElement(By.xpath("//button[@data-tracking-control-name=\"homepage-basic_sign-in-submit-btn\"]"));

        // Interact
        loginButton.click();

        // Close browser
        // driver.quit();
    }
}
