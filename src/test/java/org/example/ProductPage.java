package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class ProductPage extends BasePage {
    private By addToCartButton = By.xpath(Locator_Constants.ADD_TO_CART);
    private By productPrice = By.cssSelector("body.bx-background-image.bx-theme-:nth-child(2) div.wrapper1.sticky-box:nth-child(8) div.bx-catalog-element.bx-red:nth-child(1) div.container-fluid:nth-child(1) div.row:nth-child(1) div.product.center.detailProduct div.product-data-box div.product-price-box div.product-curr-price-box.en_text > span:nth-child(1)");
    private By addingToCartMessage = By.className("product_add_name en_text");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
       click(addToCartButton);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public boolean isAdded(){
        try {
            return findElement(addingToCartMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
