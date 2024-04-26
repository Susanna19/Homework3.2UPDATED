package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests extends BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SearchResultsPage searchPage;
    private ProductPage productPage;
   private Shopping_Cart shopping_cart;
   private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/susannavardanyan/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        searchPage = new SearchResultsPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        shopping_cart = new Shopping_Cart(driver);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void testLoginAndSearch() {
        driver.get("http://rouge.am");
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        homePage.performSearch("estee");
        assert searchPage.getNumberOfResults() > 0 : "No results found for 'estee'";
    }


    @Test
    public void loginSearchAddtoBasketRemoveItem(){
        driver.get("http://rouge.am");
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        homePage.performSearch("estee");
        productPage.addProductToCart();
        driver.findElement(By.className("basket")).click();
        shopping_cart.removeItem();
        Assert.assertTrue(shopping_cart.isRemoved(), Assertion_Messages.ITEM_REMOVED_SUCCESSFULLY);

    }

    @Test
    public void LoginGotoCartIncreaseCheckout(){
        driver.get("http://rouge.am");
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        driver.findElement(By.className("basket")).click();
        shopping_cart.addAmount();
        shopping_cart.proceedToCheckout();
        boolean isCheckoutPage = driver.getCurrentUrl().contains("order/make/");
        Assert.assertTrue(isCheckoutPage, Assertion_Messages.CHECKOUT_SUCCESSFUL);
    }


    @Test
    public void LoginSearchAddFavorite(){
        driver.get("http://rouge.am");
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        homePage.performSearch("estee");
        WebElement element1 = driver.findElement(By.cssSelector("body.bx-background-image.bx-theme-:nth-child(2) header.top_section:nth-child(6) div.box-shadow div.box_sho:nth-child(1) div.fix_hed.men_mob:nth-child(2) div.top_container.center div.right-container div.love a:nth-child(1) div.number:nth-child(2) > span.b_items_count"));
        String a = element1.getText();
        searchPage.addFavorite();
        String b= element1.getText();
        Assert.assertNotEquals(a, b);

    }

    /*
    When you run this test it shows that it fails but in reality the product is added to the basket
    but when i debug it and go step by step the test succesfully passes
    I think the problem might be that when the bot checks for the updated number on the cart the number is not changed yet and it needs time
     */
    @Test
    public void testLoginSearchAddProductToCart() {
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
    public void LoginthenBasketandReducingAmount() {
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
}
