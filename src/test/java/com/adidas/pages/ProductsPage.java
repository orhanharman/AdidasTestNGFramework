package com.adidas.pages;

import com.adidas.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

@FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;

@FindBy(linkText = "Add to cart")
    public WebElement addToCart;

    //this method will return the price of the product, the price right before adding to cart
    public int productAdder(String category, String product){

        //click on any category, laptops, phones, monitors etc
        driver.findElement(By.linkText(category)).click();

        //click on any product
        driver.findElement(By.linkText(product)).click();

        //We could not create FindBy method for category and product above because,
        //FindBy method only works with constants

        String[] arrayAmount = priceText.getText().split(" ");
        //this will change the string to integer
        int expectedListPrice = Integer.parseInt(arrayAmount[0].substring(1));

        addToCart.click();

        //sometimes, web page gives no such alert exception, so we should wait the alert dynamically
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //after accepting the alert, we should go to home page
        //home is coming from BasePage
        home.click();

        return expectedListPrice;
    }

}
