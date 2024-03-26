package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args) {

        //starting a session
        WebDriver driver = new ChromeDriver();

        //visiting playtech.ee
        driver.get("https://www.playtech.ee");
    }
}