package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private By heart = By.xpath("//body/div[7]/div[3]/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/img[2]");
    private By resultItems = By.xpath("//body/div[7]/div[3]/div[2]/div[3]/div[1]/div[1]");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean areResultsDisplayed() {
        return !findAll(resultItems).isEmpty();
    }

    public void addFavorite(){
        click(heart);
    }

    public int getNumberOfResults() {
        return findAll(resultItems).size();
    }
}
