package com.testinium.lcwaikikitest;

import com.testinium.lcwaikikitest.operations.PageNames;
import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.TimeUnit;


public class StepImplementation extends BaseImplementation {
    public StepImplementation(){
        logger = LogManager.getLogger(StepImplementation.class);
    }

    @Step("Navigate to <url>.")
    public void go_to_url(String url){
        driver.get(url);
        logger.info("Navigated to "+url);
    }

    //-----------------------------

    @Step("On <pageName>, move the cursor on <elementKey>.")
    public void on_page_move_the_cursor_on_element(PageNames pageName, String elementKey){
        logger.info("on_page_move_the_cursor_on_element is invoked");
        switch (pageName){
            case HomePage:
                homePage.navigate_mouse_over_element(elementKey);
                break;
            case ManShirtsListPage:
                manShirtsListPage.navigate_mouse_over_element(elementKey);
                break;
            default:
                logger.error("This case should not be visited!");
        }
        logger.info("Mouse is located on " + elementKey + " on page " + pageName);
    }

    @Step("On <pageName>, click on <elementKey>.")
    public void on_page_click_on_element(PageNames pageName, String elementKey){
        logger.info("on_page_click_on_element is invoked");
        switch (pageName){
            case HomePage:
                homePage.click_element(elementKey);
                break;
            case ManShirtsListPage:
                manShirtsListPage.click_element(elementKey);
                break;
            case FavouritesPage:
                favouritesPage.click_element(elementKey);
                break;
            default:
                logger.error("This case should not be visited!");
        }
        logger.info("Element " + elementKey + " is clicked on page " + pageName);
    }

    @Step("Wait for <number> seconds.")
    public void wait(int seconds) throws  InterruptedException {
        logger.info("Waiting for " + seconds + " seconds");
        TimeUnit.SECONDS.sleep(seconds);
    }

    @Step("Validate page <pageName> is loaded successfully.")
    public void validate_page_loaded(PageNames pageName){
        logger.info("validate_page_loaded is invoked");
        switch (pageName){
            case HomePage:
                homePage.validate_page_loaded();
                break;
            case ManShirtsListPage:
                manShirtsListPage.validate_page_loaded();
                break;
            case FavouritesPage:
                favouritesPage.validate_page_loaded();
            default:
                logger.error("This case should not be visited!");
                break;
        }
        logger.info("Page " + pageName + " is opened");
    }

    @Step("On <pageName>, compare inner text of <elementKey> with <expectedText>.")
    public void compare_inner_text(PageNames pageName, String elementKey, String expectedText){
        switch (pageName){
            case HomePage:
                homePage.compare_element_inner_text(elementKey, expectedText);
                break;
            case ManShirtsListPage:
                manShirtsListPage.compare_element_inner_text(elementKey, expectedText);
                break;
            case FavouritesPage:
                favouritesPage.compare_element_inner_text(elementKey, expectedText);
            default:
                logger.error("This case should not be visited!");
                break;
        }
    }

    @Step("On <pageName>, add <n>th product to the favourites.")
    public void add_nth_element_to_favourites(PageNames pageName, int n){
        switch (pageName){
            case HomePage:
            case FavouritesPage:
                logger.error("Operation not implemented for this page!");
                break;
            case ManShirtsListPage:
                manShirtsListPage.add_nth_item_to_favourites(n);
                break;
            default:
                logger.error("This case should not be visited!");
        }
    }

    @Step("Close Alert Text.")
    public void close_alert_text(){
        homePage.close_alert_text("basePage_alert_text_ok_button");
    }

    @Step("On <pageName>, validate <n> element in list <elementKey>.")
    public void validate_num_elements_in_favourites_page(PageNames pageName, int n, String key){
        switch (pageName){
            case HomePage:
            case ManShirtsListPage:
                logger.error("Operation not implemented for this page!");
                break;
            case FavouritesPage:
                favouritesPage.validate_n_elements_inside_list(key, n);
            default:
                logger.error("This case should not be visited!");
        }
    }

    @Step("Check if the text <text> is displayed.")
    public void check_if_text_displayed(String text){
        homePage.check_if_text_displayed(text);
    }
}