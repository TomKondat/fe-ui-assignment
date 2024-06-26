package com.tomkondat5.app;

import java.time.Duration;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) {

        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();

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
            key.sendKeys(dotenv.get("SELENIUM_EMAIL"));

            // Go to password
            WebElement password = driver.findElement(By.name("session_password"));
            password.sendKeys(dotenv.get("SELENIUM_PASSWORD"));

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

            // Get personal info and print it
            JSONObject personalInfo = FetchPersonalInfo.getPersonalInfo(driver);

            // Click on 'connections' button
            WebElement connectionsSpan = driver.findElement(By.xpath("//span[text()=' connections']"));
            connectionsSpan.click();

            // Get all connections info
            JSONArray connections = FetchConnections.getConnections(driver);

            personalInfo.put("connections", connections);

            CommonFunc.writeConnectionsToFile(personalInfo);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
