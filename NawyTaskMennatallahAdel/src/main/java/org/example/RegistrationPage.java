package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    protected WebDriver driver;
    private final WebDriverWait wait;
    protected By signUpUseName = By.id("sign-username");
    protected By signUpPassword = By.id("sign-password");
    protected By signUpButton = By.xpath("//button[normalize-space()='Sign up']");
    protected By signUpCloseButton = By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }
    public void register(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpUseName)).sendKeys("username");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPassword)).sendKeys("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton)).click();
    }
    public void handleRegisterAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public String getAlertMessage(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    public void closeRegisterForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpCloseButton)).click();
    }


}