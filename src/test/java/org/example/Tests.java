package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class Tests {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        // Maximize the browser window so that full navbar is shown and links not hidden
        driver.manage().window().maximize();
    }

    @Test
    public void testMainTaskENG() {
        // Navigate to the URL
        driver.get("https://www.playtech.ee");


        // Locate the "who we are" tab and click on it
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[@href='/who-we-are']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        // Verify if the page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Global presence");


        // Write the result to a file
        try {
            File file = new File("result.txt");
            FileWriter writer = new FileWriter(file);
            if (isGlobalPresenceShown) {
                writer.write("Global presence is shown: " + isGlobalPresenceShown);
            }
            else {
                writer.write("Global presence is shown: false");
            }
            writer.close();
            System.out.println("Result written to result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assert is global presense shown at the end so that we will overwrite the previous value, not show wrong value in file
        assertTrue(isGlobalPresenceShown);
    }

    @Test
    public void testMainTaskET() throws InterruptedException {
        // Navigate to the URL
        driver.get("https://www.playtech.ee");

        // Locate the "language selector" and click on it
        WebElement languageSelector = driver.findElement(By.xpath("//div[contains(@class,'language-select')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(languageSelector, 1, 1).click().perform();

        //locate a tag with estonian href /et
        WebElement estonian = driver.findElement(By.xpath("//a[@href='/et']"));
        actions.moveToElement(estonian, 1, 1).click().perform(); //click on estonian

        // Locate the "Who we are" tab and click on it
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[@href='/meist']"));
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        // Verify if the page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Meie asukohad");


        // Write the result to a file
        try {
            File file = new File("result.txt");
            FileWriter writer = new FileWriter(file);
            if (isGlobalPresenceShown) {
                writer.write("Global presence is shown: " + isGlobalPresenceShown);
            }
            else {
                writer.write("Global presence is shown: false");
            }
            writer.close();
            System.out.println("Result written to result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assert is global presense shown at the end so that we will overwrite the previous value, not show wrong value in file
        assertTrue(isGlobalPresenceShown);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
