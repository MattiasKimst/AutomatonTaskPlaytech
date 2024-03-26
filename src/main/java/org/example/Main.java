package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) {


        //starting a session
        WebDriver driver = new ChromeDriver();

        //visiting playtech.ee
        driver.get("https://www.playtech.ee");

        // Maximize the browser window
        driver.manage().window().maximize();

        // locate <a> element that contains text "Who we are" and click on it
        driver.findElement(By.xpath("//a[contains(text(),'Who we are')]")).click();

    }


    }
