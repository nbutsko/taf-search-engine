package com.bing.search.ui.steps;

import com.bing.search.ui.driver.DriverSingleton;
import com.bing.search.ui.pageobjects.HomePage;
import com.bing.search.ui.pageobjects.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchStepsDef {
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @After
    public static void tearDown() {
        DriverSingleton.closeDriver();
    }

    @Given("I am on the Bing search page")
    public void iAmOnTheBingSearchPage() {
        homePage = new HomePage().openPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchQuery){
        searchResultsPage = homePage.inputSearchQueryAndClickButtonSearch(searchQuery);
    }

    @Then("Search result page contains title {string}")
    public void searchResultPageContainsTitle(String title) {
        Assert.assertTrue(searchResultsPage.isSearchResultsContainsTitle(title));
    }

    @And("Search result page contains url {string}")
    public void searchResultPageContainsUrl(String url) {
        Assert.assertTrue(searchResultsPage.isSearchResultsContainsUrl(url));
    }
}
