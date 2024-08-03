package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    private final WebDriverWait wait;
    protected By loginUserName = By.xpath("//input[@id='loginusername']");
    protected By loginPassWord = By.id("loginpassword");
    protected By loginButton = By.xpath("//button[normalize-space()='Log in']");
    protected By logoutButton = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void enterUserName(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUserName)).sendKeys(email);
    }

    public void enterPassWord(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPassWord)).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
//        return new HomePage(driver);
    }
    public boolean logged(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
    }

}
