package com.bing.search.ui.pageobjects;

import com.bing.search.utils.UtilLogger;
import com.bing.search.domain.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "ol#b_results>li.b_algo")
    List<WebElement> searchResultCards;

    public List<SearchResult> getListOfSearchResults() {
        String titleSelector = "h2";
        String urlSelector = "cite";
        List<SearchResult> results = new ArrayList<>();
        for (WebElement searchResultCard : searchResultCards) {
            String title = searchResultCard.findElement(By.cssSelector(titleSelector)).getText();
            String url = searchResultCard.findElement(By.cssSelector(urlSelector)).getText();
            results.add(new SearchResult(title, url));
        }
        UtilLogger.logger.info("Search Results Page loaded");
        return results;
    }

    public boolean isSearchResultsContainsTitle(String title) {
        for (SearchResult searchResult : getListOfSearchResults()) {
            if (searchResult.getTitle().contains(title)){
                UtilLogger.logger.info(searchResult.toString());
                return true;
            }
        }
        return false;
    }

    public boolean isSearchResultsContainsUrl(String url) {
        for (SearchResult searchResult : getListOfSearchResults()) {
            if (searchResult.getUrl().contains(url)){
                UtilLogger.logger.info(searchResult.toString());
                return true;
            }
        }
        return false;
    }
}
