package com.tomkondat5.app;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FetchConnections {

    public static JSONArray getConnections(WebDriver driver) {
        List<WebElement> connections = driver.findElements(By.cssSelector(".mn-connection-card__details"));

        JSONArray connectionsArray = new JSONArray();

        for (WebElement connection : connections) {
            String name = connection.findElement(By.cssSelector(".mn-connection-card__name")).getText();
            String title = connection.findElement(By.cssSelector(".mn-connection-card__occupation")).getText();
            String lastConnected = connection.findElement(By.cssSelector(".time-badge")).getText();

            JSONObject connectionJson = new JSONObject();
            connectionJson.put("name", name);
            connectionJson.put("title", title);
            connectionJson.put("lastConnected", lastConnected);

            connectionsArray.put(connectionJson);
        }
        return connectionsArray;
    }
}