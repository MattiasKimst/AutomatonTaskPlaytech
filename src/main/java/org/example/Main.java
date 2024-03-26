package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Main {
    public static void main(String[] args) {


        //starting a session
        WebDriver driver = new ChromeDriver();

        //visiting playtech.ee
        driver.get("https://www.playtech.ee");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Locate the element using coordinates
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[contains(text(),'Who we are')]"));
        Actions actions = new Actions(driver);
        // Move to the element and click at the given coordinates
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        //verify if page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Global presence");
        //log it
        System.out.println("global presence shown: " +isGlobalPresenceShown);

        // Close browser
        driver.quit();

    }


    }
