package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By addToCartButton = By.linkText("Add to cart");
    protected By image = By.xpath("//div[@class='item active']//img");

    protected By cart = By.linkText("cart");
    protected By orderName = By.id("name");
    protected By orderCountry = By.id("country");
    protected By orderCity =By.id("city");
    protected By orderCard =By.id("card");
    protected By orderMonth =By.id("month");
    protected By orderYear = By.id("year");
    protected By orderPurchase =  By.xpath("//button[normalize-space()='Purchase']");
    protected By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");


    public OrderPage(WebDriver driver){
        this.driver = driver;
        this.wait =new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }
    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        handleAlert();
    }
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }
    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }
    public void fillInData(String name , String country, String city ,String card ,String month , String year){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderName)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderCountry)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderCity)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderCard)).sendKeys(card);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderMonth)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderYear)).sendKeys(year);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPurchase)).click();
    }
    private void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
