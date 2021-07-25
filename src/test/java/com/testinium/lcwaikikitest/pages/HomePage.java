package com.testinium.lcwaikikitest.pages;

import com.testinium.lcwaikikitest.operations.Operations;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, Operations operations) {
        super(driver, operations);
        logger = LogManager.getLogger(HomePage.class);
    }

    @Override
    public void validate_page_loaded() {
        String expectedTitle = "LCW Online Alışveriş Sitesi | Önümde Hayat Üstümde LC Waikiki - LC Waikiki";
        Assert.assertEquals("Titles are being compared", expectedTitle, driver.getTitle());
    }
}
