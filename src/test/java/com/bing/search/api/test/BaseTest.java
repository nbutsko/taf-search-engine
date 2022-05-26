package com.bing.search.api.test;

import com.bing.search.api.client.HttpConnection;
import com.bing.search.api.parser.SearchResultDocParser;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseTest {

    public HttpConnection connection;

    @Before
    public void getConnection(){
        connection = new HttpConnection();
    }

    @Test
    public void testGetRequest(){
        String url = "https://www.bing.com/search?q=Минск";
        String title = "Минск - Википедия";
        String expectedUrl = "https://ru.wikipedia.org/wiki/Минск";

        connection.sendGet(url);
        Assert.assertEquals(200, connection.getStatusCode());

        /*SearchResultDocParser parser = new SearchResultDocParser(connection.getDocument(url));
        Assert.assertTrue(parser.isSearchResultsContainsTitle(title));
        Assert.assertTrue(parser.isSearchResultsContainsUrl(expectedUrl));*/
    }
}
