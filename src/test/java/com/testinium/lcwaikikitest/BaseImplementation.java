package com.testinium.lcwaikikitest;

import com.testinium.lcwaikikitest.operations.DriverFactory;
import com.testinium.lcwaikikitest.operations.Operations;
import com.testinium.lcwaikikitest.pages.FavouritesPage;
import com.testinium.lcwaikikitest.pages.HomePage;
import com.testinium.lcwaikikitest.pages.productlistpages.ManShirtsListPage;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {

    protected static WebDriver driver;
    protected static Logger logger = LogManager.getLogger(BaseImplementation.class);
    protected static Operations operations;
    protected static HomePage homePage;
    protected static ManShirtsListPage manShirtsListPage;
    protected static FavouritesPage favouritesPage;

    @BeforeSpec
    public void setup_environment(){
        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browsers.CHROME);
        driver = driverFactory.getDriver();
        logger.info("WebDriver is created");
        driver.manage().window().maximize();
        logger.info("Browser window is maximized");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("ImplicitWait is set");
        List<String> pageDB = new ArrayList<>();
        pageDB.add("BasePage.json");
        //pageDB.add("HomePage.json");
        pageDB.add("ProductListPage.json");
        pageDB.add("FavouritesPage.json");
        logger.info("Page Database is created.");
        operations = new Operations(driver, pageDB);
        logger.info("Operations instance is created");
        homePage = new HomePage(driver, operations);
        manShirtsListPage = new ManShirtsListPage(driver, operations);
        favouritesPage = new FavouritesPage(driver, operations);
    }

    @AfterSpec
    public void cleanup_environment(){
        driver.manage().deleteAllCookies();
        logger.info("Cookies are deleted.");
        driver.close();
    }
}

