package com.tomkondat5.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchConnections {

    public static void printConnections(WebDriver driver) {
        List<WebElement> connections = driver.findElements(By.cssSelector(".mn-connection-card__details"));

        System.out.println("Connections: ");

        for (WebElement connection : connections) {
            String name = connection.findElement(By.cssSelector(".mn-connection-card__name")).getText();
            String title = connection.findElement(By.cssSelector(".mn-connection-card__occupation")).getText();
            String lastConnected = connection.findElement(By.cssSelector(".time-badge")).getText();
            System.out.println(name + "\n" + title + "\n" + lastConnected + "\n");
        }
    }
}
