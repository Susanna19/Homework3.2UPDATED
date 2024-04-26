package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(Locator_Constants.SEARCH_FIELD);
    private By searchButton = By.className(Locator_Constants.SEARCH_BUTTON);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String query) {
        type(searchInput, query);
        click(searchButton);
    }



}
