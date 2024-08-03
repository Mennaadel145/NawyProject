package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    private final WebDriverWait wait;
    public By loginButton = By.id("login2");
    public By logOutButton = By.id("logout2");
    public By signUpButton = By.xpath("//a[@id='signin2']");
    public By nextButton = By.id("next2");
    public By element = By.linkText("Apple monitor 24");
    public HomePage(WebDriver driver) {
        this.driver =driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }
    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        return new LoginPage(driver);
    }
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton)).click();
    }
    public RegistrationPage clickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton)).click();
        return new RegistrationPage(driver);
    }


    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton)).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void goToNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public OrderPage clickOnTheItem () {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return new OrderPage(driver);
    }

}
