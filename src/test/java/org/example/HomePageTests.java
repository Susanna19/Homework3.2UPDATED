package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        driver.get("http://rouge.am");
        HomePage homePage = new HomePage(driver);
        homePage.performSearch("estee");
        SearchResultsPage searchResultPage = new SearchResultsPage(driver);
        boolean areResultsDisplayed = searchResultPage.areResultsDisplayed();
        Assert.assertTrue(areResultsDisplayed, Assertion_Messages.SEARCH_RESULTS_DISPLAYED);
    }

}
