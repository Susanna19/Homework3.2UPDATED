package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {


    @Test
    public void testRemoveItem() {
        driver.get("https://rouge.am/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        Shopping_Cart cart = new Shopping_Cart(driver);
        driver.findElement(By.className("basket")).click();
        cart.removeItem();
        Assert.assertTrue(cart.isRemoved(), Assertion_Messages.ITEM_REMOVED_SUCCESSFULLY);
    }

    @Test
    public void addingAmount() {
        driver.get("https://rouge.am/");
        Shopping_Cart cart = new Shopping_Cart(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        driver.findElement(By.className("basket")).click();
        WebElement element = driver.findElement(By.className("basket-item-amount-filed"));
        String oldAmount = element.getAttribute("value");
        cart.addAmount();
        String newAmount = element.getAttribute("value");
        Assert.assertNotEquals(oldAmount, newAmount);
    }

    @Test
    public void reducingAmount() {
        driver.get("https://rouge.am/");
        Shopping_Cart cart = new Shopping_Cart(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        driver.findElement(By.className("basket")).click();
        WebElement element = driver.findElement(By.className("basket-item-amount-filed"));
        String oldAmount = element.getAttribute("value");
        cart.reducingAMount();
        String newAmount = element.getAttribute("value");
        if (oldAmount.equals("1")) {
            Assert.assertEquals(oldAmount, newAmount);
        } else {
            Assert.assertNotEquals(oldAmount, newAmount);
        }
    }

    @Test
    public void testProceedToCheckout() {
        driver.get("https://rouge.am/");
        Shopping_Cart cart = new Shopping_Cart(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        driver.findElement(By.className("basket")).click();
        cart.proceedToCheckout();
        boolean isCheckoutPage = driver.getCurrentUrl().contains("order/make/");
        Assert.assertTrue(isCheckoutPage, Assertion_Messages.CHECKOUT_SUCCESSFUL);
    }
}
