package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class Shopping_Cart extends BasePage{

    public Shopping_Cart(WebDriver driver) {
        super(driver);
    }
    private By removeItemButton = By.xpath("//span[contains(text(),'Remove')]");
    private By checkoutButton = By.xpath("//body/div[7]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[4]/button[1]");
    private By adding = By.className("basket-item-amount-btn-plus");

    private By reducing = By.className("basket-item-amount-btn-minus");
    private By removeMessage = By.cssSelector("body.bx-background-image.bx-theme-:nth-child(2) div.wrapper1.sticky-box:nth-child(8) div.center:nth-child(2) div.bx-basket.bx-red.bx-step-opacity:nth-child(3) div.basket_loved:nth-child(2) div.bask_lov_can div.mb-3.basket-items-list-wrapper-height-fixed.basket-items-list-wrapper-light div.basket-items-list-container div.basket-items-list table.basket-items-list-table tr.basket-items-list-item-container.basket-items-list-item-container-expend td.basket-items-list-item-notification div.basket-items-list-item-notification-inner.basket-items-list-item-notification-removed div.basket-items-list-item-removed-container > div:nth-child(1)");




    public void removeItem() {
       click(removeItemButton);
    }

    public boolean isRemoved(){
        try {
            return findElement(removeMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

    public void addAmount() {
        click(adding);
    }

    public void reducingAMount(){
        click(reducing);
    }

}
