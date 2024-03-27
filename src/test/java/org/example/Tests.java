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
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testMainTask() {
        // Navigate to the URL
        driver.get("https://www.playtech.ee");

        // Locate the "Who we are" tab and click on it
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[contains(text(),'Who we are')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(whoWeAreTab, 1, 1).click().perform();

        // Verify if the page contains "Global presence"
        boolean isGlobalPresenceShown = driver.getPageSource().contains("Global presence");
        assertTrue(isGlobalPresenceShown);

        // Write the result to a file
        try {
            File file = new File("result.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Global presence is shown: " + isGlobalPresenceShown);
            writer.close();
            System.out.println("Result written to result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
