package com.testinium.lcwaikikitest.pages.productlistpages;

import com.testinium.lcwaikikitest.operations.Operations;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ManShirtsListPage extends ProductListPage {
    public ManShirtsListPage(WebDriver driver, Operations operations) {
        super(driver, operations);
    }

    private static final String validationString = "https://www.lcwaikiki.com/tr-TR/TR/kategori/erkek/gomlek";

    @Override
    public void validate_page_loaded() {
        Assert.assertEquals("Page URL is checked", validationString, driver.getCurrentUrl());
    }
}
