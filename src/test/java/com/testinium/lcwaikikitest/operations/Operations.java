package com.testinium.lcwaikikitest.operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Operations {
    private final WebDriver driver;
    private final JSONOperations jsonOperations;
    private final Logger logger = LogManager.getLogger(Operations.class);

    public Operations(WebDriver driver, List<String> pageDB){
        this.driver = driver;
        this.jsonOperations = new JSONOperations(pageDB);
    }

    private By get_by_from_locator_element(LocatorElement element) {
        switch (element.getBy()) {
            case ID:
                return By.id(element.getValue());
            case NAME:
                return By.name(element.getValue());
            case CSS_SELECTOR:
                return By.cssSelector(element.getValue());
            case XPATH:
                return By.xpath(element.getValue());
            case CLASS_NAME:
                return By.className(element.getValue());
            case TAG_NAME:
                return By.tagName(element.getValue());
            case LINK_TEXT:
                return By.linkText(element.getValue());
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(element.getValue());
            default:
                return null;
        }
    }

    public void mouse_hover_on_element(String key){
        logger.info("Operation: Mouse hover on element " + key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        WebElement element = driver.findElement(get_by_from_locator_element(locatorElement));
        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(element).build().perform();
    }

    public void click_on_element(String key){
        logger.info("Operation: Click on element " + key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        WebElement element = driver.findElement(get_by_from_locator_element(locatorElement));
        element.click();
    }

    public void compare_inner_text(String key, String expected){
        logger.info("Operation: Compare inner text of element " + key + " with " + expected);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        WebElement element = driver.findElement(get_by_from_locator_element(locatorElement));
        Assert.assertEquals("Comparing the texts", expected, element.getText());
    }

    public void click_inner_element_by_xpath(String baseKey, String relativeAddress){
        logger.info("Operation: Click inner element of base="+baseKey+" relative="+relativeAddress);
        LocatorElement locatorElement = jsonOperations.findElementByKey(baseKey);
        WebElement element = driver.findElement(By.xpath(locatorElement.getValue() + relativeAddress));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public boolean is_element_visible(String key){
        logger.info("Operation: Checking the existence of element="+key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        WebElement element = driver.findElement(get_by_from_locator_element(locatorElement));
        return element.isDisplayed();
    }

    public String get_inner_text(String key){
        logger.info("Operation: Reading the inner text of element="+key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        WebElement element = driver.findElement(get_by_from_locator_element(locatorElement));
        return element.getText();
    }

    public boolean is_text_displayed(String text){
        logger.info("Operation: Checking if text='"+text+"' is displayed");
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        return element.isDisplayed();
    }
}
