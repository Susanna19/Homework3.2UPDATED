package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class LoginPage extends BasePage {
    private By errorMessageLocator = By.className("errortext");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        WebElement webElement = driver.findElement(By.className(Locator_Constants.BUTTON_LOG));
        webElement.click();
        driver.findElement(By.name(Locator_Constants.USERNAME_FIELD)).click();
        driver.findElement(By.name(Locator_Constants.USERNAME_FIELD)).sendKeys(username);
       driver.findElement(By.name(Locator_Constants.PASSWORD_FIELD)).click();
       driver.findElement(By.name(Locator_Constants.PASSWORD_FIELD)).sendKeys(password);
       driver.findElement(By.xpath(Locator_Constants.LOGIN_BUTTON)).click();
    }


    public boolean isErrorMessageDisplayed() {
        try {
            return findElement(errorMessageLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
