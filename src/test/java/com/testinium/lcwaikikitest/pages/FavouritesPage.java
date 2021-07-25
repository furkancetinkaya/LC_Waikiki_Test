package com.testinium.lcwaikikitest.pages;

import com.testinium.lcwaikikitest.operations.Operations;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class FavouritesPage extends BasePage {
    public FavouritesPage(WebDriver driver, Operations operations) {
        super(driver, operations);
    }

    @Override
    public void validate_page_loaded() {
        String expected = "https://www.lcwaikiki.com/tr-TR/TR/favorilistem";
        Assert.assertEquals("Validating Favourites Page url", expected, driver.getCurrentUrl());
    }

    public void validate_n_elements_inside_list(String key, int n){
        int actual = Integer.parseInt(operations.get_inner_text(key));
        logger.info("" + actual + "element found on " + key);
        Assert.assertEquals("Comparing number of elements inside list", n, actual);
    }
}
