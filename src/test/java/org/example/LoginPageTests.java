package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://rouge.am/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asenqzut@gmail.com", "Qwerty11$");
        boolean isLoggedIn = driver.getCurrentUrl().contains("login=yes");
        Assert.assertTrue(isLoggedIn, Assertion_Messages.LOGIN_SUCCESSFUL);
    }

    @Test
    public void testFailedLogin() {
        driver.get("https://rouge.am/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUsername", "wrongPassword");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed, Assertion_Messages.LOGIN_FAILURE_MESSAGE_DISPLAYED);
    }
}
