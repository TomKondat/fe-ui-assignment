package com.tomkondat5.app;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FetchPersonalInfo {

    public static JSONObject getPersonalInfo(WebDriver driver) {

        JSONObject personalInfo = new JSONObject();
        String myName = driver
                .findElement(By.cssSelector("h1.text-heading-xlarge.inline.t-24.v-align-middle.break-words")).getText();
        String myTitle = driver.findElement(By.cssSelector("div.text-body-medium.break-words")).getText();
        String myCity = driver.findElement(By.cssSelector("span.text-body-small.inline.t-black--light.break-words"))
                .getText();

        personalInfo.put("myName", myName);
        personalInfo.put("myTitle", myTitle);
        personalInfo.put("city", myCity);

        return personalInfo;
    }
}
