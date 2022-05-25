package com.bing.search.ui.pageobjects;

import com.bing.search.utils.UtilLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(css = "input.sb_form_q")
    private WebElement inputSearch;

    @FindBy(css = "label.search")
    private WebElement buttonSearch;

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public SearchResultsPage inputSearchQueryAndClickButtonSearch(String searchQuery) {
        inputSearch.sendKeys(searchQuery);
        buttonSearch.click();
        UtilLogger.logger.info("Search Go clicked");
        return new SearchResultsPage();
    }
}
