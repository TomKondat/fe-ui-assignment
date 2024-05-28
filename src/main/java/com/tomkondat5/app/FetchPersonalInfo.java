package com.tomkondat5.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FetchPersonalInfo {

    public static void printPersonalInfo(WebDriver driver) {
        String myName = driver
                .findElement(By.cssSelector("h1.text-heading-xlarge.inline.t-24.v-align-middle.break-words")).getText();
        String myTitle = driver.findElement(By.cssSelector("div.text-body-medium.break-words")).getText();
        String myLocation = driver.findElement(By.cssSelector("span.text-body-small.inline.t-black--light.break-words"))
                .getText();
        System.out.println("My name: " + myName + "\nMy title: " + myTitle + "\nMy location: " + myLocation + "\n");
    }
}
