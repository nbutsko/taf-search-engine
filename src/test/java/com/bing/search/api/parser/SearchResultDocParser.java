package com.bing.search.api.parser;

import com.bing.search.domain.SearchResult;
import com.bing.search.utils.UtilLogger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SearchResultDocParser {

    private Document document;

    public SearchResultDocParser(Document document) {
        this.document = document;
    }

    private Elements getListOfSearchElements() {
        String searchResultCardSelector = "ol#b_results>li.b_algo";
        return document.select(searchResultCardSelector);
    }

    private List<SearchResult> getListOfSearchResults(Elements elements) {
        String titleSelector = "h1";
        String urlSelector = "cite";
        List<SearchResult> results = new ArrayList<>();
        for (Element element : elements) {
            String title = element.getElementsByTag(titleSelector).text();
            String url = element.getElementsByTag(urlSelector).text();
            results.add(new SearchResult(title, url));
        }
        return results;
    }

    private void logElement(String searchValue) {
        for (Element element : getListOfSearchElements()) {
            if (element.wholeText().contains(searchValue)){
                UtilLogger.logger.info(element);
                break;
            }
        }
    }

    public boolean isSearchResultsContainsTitle(String title) {
        for (SearchResult searchResult : getListOfSearchResults(getListOfSearchElements())) {
            if (searchResult.getTitle().contains(title)) {
                logElement(title);
                return true;
            }
        }
        return false;
    }

    public boolean isSearchResultsContainsUrl(String url) {
        for (SearchResult searchResult : getListOfSearchResults(getListOfSearchElements())) {
            if (searchResult.getUrl().contains(url)) {
                logElement(url);
                return true;
            }
        }
        return false;
    }
}
