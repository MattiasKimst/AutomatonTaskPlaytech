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
    private Actions actions;

    @Before
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        // Maximize the browser window so that full navbar is shown and links not hidden
        driver.manage().window().maximize();
        //previously we had this actions class in both tests- we can already define it here
        actions = new Actions(driver);
    }

    @Test
    public void testWhoWeAreTabGlobalPresenceENG() {
        try { //use try-finally so that if we can't perform any operation in try block, global presence shown = false is still written to txt file
            // Navigate to the URL
            driver.get("https://www.playtech.ee");
            //locate and click on who we are
            clickElement("//a[@href='/who-we-are']");
        } finally {
            //verify that global presence is shown and write it to file resultENG.txt
            boolean isPresent = verifyPresence("Global presence", "resultENG.txt");
            //assert is global presence shown
            assertTrue(isPresent);
        }
    }

    @Test
    public void testWhoWeAreTabGlobalPresenceET() throws InterruptedException {

        try { //use try-finally so that if we can't perform any operation in try block, global presence shown = false is still written to txt file
            // Navigate to the URL
            driver.get("https://www.playtech.ee");
            // Locate the "language selector" and click on it
            clickElement("//div[contains(@class,'language-select')]");
            //locate and click on estonian
            clickElement("//a[@href='/et']");
            //click on meist
            clickElement("//a[@href='/meist']");
        } finally {
            //verify that meie asukohad is shown and write it to file resultET.txt
            boolean isPresent = verifyPresence("Meie asukohad", "resultET.txt");
            //assert is global presence shown
            assertTrue(isPresent);
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }


    private void clickElement(String xpath) {
        //locate the elemnent specified by xpath
        WebElement element = driver.findElement(By.xpath(xpath));
        //click on it
        actions.moveToElement(element, 1, 1).click().perform();
    }

    private boolean verifyPresence(String text, String fileName) {
        //make sure the page contains specified string
        boolean isTextPresent = driver.getPageSource().contains(text);
        //write the result to file
        writeToFile(fileName, text + " is shown on page: " + isTextPresent);
        return isTextPresent;
    }

    private void writeToFile(String fileName, String text) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
            System.out.println("Result written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
