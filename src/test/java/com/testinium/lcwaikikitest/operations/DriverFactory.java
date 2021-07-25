package com.testinium.lcwaikikitest.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;
    private final Browsers preferredBrowser;

    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String GECKO_PROPERTY  = "webdriver.gecko.driver";
    private static final String DRIVER_BASE_DIR = "src/test/resources/drivers/";
    private static final String CHROME_DRIVER_LOCATION_WIN = DRIVER_BASE_DIR + "chromedriver_win32.exe";
    private static final String CHROME_DRIVER_LOCATION_LINUX = DRIVER_BASE_DIR + "chromedriver_linux64";
    private static final String CHROME_DRIVER_LOCATION_MAC = DRIVER_BASE_DIR + "chromedriver_mac64";
    private static final String GECKO_DRIVER_LOCATION_WIN  = DRIVER_BASE_DIR + "geckodriver_win64.exe";
    private static final String GECKO_DRIVER_LOCATION_LINUX = DRIVER_BASE_DIR + "geckodriver_linux_64";
    private static final String GECKO_DRIVER_LOCATION_MAC = DRIVER_BASE_DIR + "geckodriver_mac";

    public enum Browsers {
        FIREFOX, CHROME
    }

    public DriverFactory(Browsers preferredBrowser){
        this.preferredBrowser = preferredBrowser;
        initializeWebDriver();
    }

    private void initializeWebDriver(){
        if (this.driver == null ){
            createWebDriver();
        }
    }

    private void createWebDriver(){
        String osName = System.getProperty("os.name").toLowerCase();

        if (this.preferredBrowser == Browsers.CHROME){
            if (osName.contains("win")){
                System.setProperty(CHROME_PROPERTY, CHROME_DRIVER_LOCATION_WIN);
            }else if (osName.contains("mac")){
                System.setProperty(CHROME_PROPERTY, CHROME_DRIVER_LOCATION_MAC);
            }else{
                System.setProperty(CHROME_PROPERTY, CHROME_DRIVER_LOCATION_LINUX);
            }
            this.driver = new ChromeDriver();
        } else if (this.preferredBrowser == Browsers.FIREFOX) {
            if (osName.contains("win")){
                System.setProperty(GECKO_PROPERTY, GECKO_DRIVER_LOCATION_WIN);
            }else if (osName.contains("mac")){
                System.setProperty(GECKO_PROPERTY, GECKO_DRIVER_LOCATION_MAC);
            }else{
                System.setProperty(GECKO_PROPERTY, GECKO_DRIVER_LOCATION_LINUX);
            }
            this.driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
