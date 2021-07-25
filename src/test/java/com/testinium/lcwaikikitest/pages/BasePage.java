package com.testinium.lcwaikikitest.pages;

import com.testinium.lcwaikikitest.operations.Operations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {
    protected Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected Operations operations;

    // Constructor
    public BasePage(WebDriver driver, Operations operations){
        this.driver = driver;
        this.operations = operations;
    }

    // Methods
    public void navigate_mouse_over_element(String key){
        logger.info("navigate_mouse_over_element function is invoked for key="+key);
        operations.mouse_hover_on_element(key);
    }

    public void click_element(String key){
        logger.info("click_element function is invoked for key="+key);
        operations.click_on_element(key);
    }

    public void compare_element_inner_text(String key, String expected){
        operations.compare_inner_text(key, expected);
    }

    public void close_alert_text(String key){
        if (operations.is_element_visible(key)){
            operations.click_on_element(key);
        }
    }

    public void check_if_text_displayed(String text){
        Assert.assertTrue("Checking if given text is displayed", operations.is_text_displayed(text));
    }

    public abstract void validate_page_loaded();
}
