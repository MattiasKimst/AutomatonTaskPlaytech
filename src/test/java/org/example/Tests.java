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
    public void testWhoWeAreTabGlobalPresenceENG() {
        // Navigate to the URL
        driver.get("https://www.playtech.ee");


        // Locate the "who we are" tab and click on it
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[@href='/who-we-are']"));

        Actions actions = new Actions(driver);

        //click on located who we are tab
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        // Verify if the page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Global presence");


        // Write the result to a file
        try {
            File file = new File("resultENG.txt");
            FileWriter writer = new FileWriter(file);
            if (isGlobalPresenceShown) {
                writer.write("Global presence is shown on ENG page: " + isGlobalPresenceShown);
            }
            else {
                writer.write("Global presence is shown on ENG page: false");
            }
            writer.close();
            System.out.println("Result written to resultENG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assert is global presence shown at the end so that we will overwrite the previous value if not shown, and not show wrong value in file
        assertTrue(isGlobalPresenceShown);
    }

    @Test
    public void testWhoWeAreTabGlobalPresenceET() throws InterruptedException {
        // Navigate to the URL
        driver.get("https://www.playtech.ee");

        Actions actions = new Actions(driver);

        // Locate the "language selector" and click on it
        WebElement languageSelector = driver.findElement(By.xpath("//div[contains(@class,'language-select')]"));
        // click on language selector
        actions.moveToElement(languageSelector, 1, 1).click().perform();

        //locate a tag with estonian href /et
        WebElement estonian = driver.findElement(By.xpath("//a[@href='/et']"));
        // click on estonian
        actions.moveToElement(estonian, 1, 1).click().perform();

        // Locate the meist tab and click on it
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[@href='/meist']"));
        //click on meist tab
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        // Verify if the page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Meie asukohad");


        // Write the result to a file
        try {
            File file = new File("resultET.txt");
            FileWriter writer = new FileWriter(file);
            if (isGlobalPresenceShown) {
                writer.write("Global presence is shown on ET page: " + isGlobalPresenceShown);
            }
            else {
                writer.write("Global presence is shown on ET page: false");
            }
            writer.close();
            System.out.println("Result written to resultET.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assert is global presence shown at the end so that we will overwrite the previous value if not shown, and not show wrong value in file
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
