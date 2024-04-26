package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {


    /*
   When you run this test it shows that it fails but in reality the product is added to the basket
   but when i debug it and go step by step the test succesfully passes
   I think the problem might be that when the bot checks for the updated number on the cart the number is not changed yet and it needs time
    */
    @Test
    public void testAddProductToCart() {
        driver.get("https://rouge.am/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        HomePage homePage = new HomePage(driver);
        homePage.performSearch("estee");
        ProductPage productPage = new ProductPage(driver);
        String oldAmount = driver.findElement(By.className("basket")).getText();
        productPage.addProductToCart();
        String newAmount = driver.findElement(By.className("basket")).getText();
        Assert.assertNotEquals(oldAmount, newAmount);

    }

    @Test
    public void testProductPrice() {
        driver.get("https://rouge.am/product/black-opium-red-edp-36/");
        ProductPage productPage = new ProductPage(driver);
        String price = productPage.getProductPrice();
        Assert.assertNotNull(price, Assertion_Messages.PRODUCT_PRICE_CORRECT);
        Assert.assertFalse(price.isEmpty(), Assertion_Messages.PRODUCT_PRICE_CORRECT);
    }
}
