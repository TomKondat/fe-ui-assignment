package com.tomkondat5.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/home");

        // Wait for the page to load and make sure I have time for captcha
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        try {

            // Click on 'sign in' button
            WebElement signInButton = driver
                    .findElement(By.xpath("//a[@data-tracking-control-name='guest_homepage-basic_nav-header-signin']"));
            signInButton.click();

            // Go to username
            WebElement key = driver.findElement(By.name("session_key"));
            key.sendKeys("");

            // Go to password
            WebElement password = driver.findElement(By.name("session_password"));
            password.sendKeys("");

            // Click on 'login' button
            WebElement loginButton = driver
                    .findElement(By.xpath("//button[@data-litms-control-urn=\"login-submit\"]"));
            loginButton.click();

            // Click on 'me' button
            WebElement meButton = driver.findElement(By.id("ember16"));
            meButton.click();

            // Click on 'view profile' button
            WebElement profileButton = driver.findElement(By.className("artdeco-entity-lockup__title"));
            profileButton.click();

            // Get my info and print it
            FetchPersonalInfo.printPersonalInfo(driver);

            // Click on 'connections' button
            WebElement connectionsSpan = driver.findElement(By.xpath("//span[text()=' connections']"));
            connectionsSpan.click();

            // Get all connections info and print it
            FetchConnections.printConnections(driver);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
