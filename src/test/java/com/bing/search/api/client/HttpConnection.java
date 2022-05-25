package com.bing.search.api.client;

import com.bing.search.utils.UtilLogger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HttpConnection {

    private CloseableHttpClient httpClient;
    private HttpResponse response;

    private int statusCode;

    public HttpConnection() {
        httpClient = HttpClientBuilder.create().build();
    }

    public void sendGet(String url) {
        try {
            response = httpClient.execute(new HttpGet(url));
            UtilLogger.logger.info("GET " + url);
        } catch (IOException e) {
            UtilLogger.logger.warn(e.getMessage());
        }
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        UtilLogger.logger.info("Status code: " + statusCode);
        return statusCode;
    }

    public Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            UtilLogger.logger.warn(e.getMessage());
        }
        return document;
    }
}

