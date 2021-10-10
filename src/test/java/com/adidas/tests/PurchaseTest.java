package com.adidas.tests;


import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import org.testng.annotations.Test;

public class PurchaseTest extends TestBase{

    //Creating objects via Polymorphic way
    BasePage productPage = new ProductsPage();
    BasePage cartPage = new CartPage();

    @Test
    public void Test1(){
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        productPage.cart.click();

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }



}
