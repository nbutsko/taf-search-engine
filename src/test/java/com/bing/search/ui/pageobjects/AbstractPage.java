package com.bing.search.ui.pageobjects;

import com.bing.search.ui.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    public final static String BASE_URL = "https://www.bing.com";

    protected WebDriver driver;

    public AbstractPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
}
