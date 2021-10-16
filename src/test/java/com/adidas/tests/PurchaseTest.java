package com.adidas.tests;


import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends TestBase{

    ProductsPage productPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    int expectedPurchaseAmount = 0;

    @Test
    public void Test1(){
        extentLogger = report.createTest("Adding and Removing Products Test");

        extentLogger.info("Add items to cart and handle the alerts");
        String[][] purchaseInfo = new String[][]{   {"Laptops", "Sony vaio i5"}, {"Laptops", "Dell i7 8gb"},
                                                    {"Monitors", "Apple monitor 24"}, {"Phones", "Nexus 6"} };
        for (String[] strings : purchaseInfo) {
            expectedPurchaseAmount += productPage.productAdder(strings[0], strings[1], wait);
        }

        extentLogger.info("Remove unwanted products");
        String[] unwantedProductsInfo = {"Dell i7 8gb", "Apple monitor 24"};
        for (String s : unwantedProductsInfo) {
            expectedPurchaseAmount -= cartPage.productRemover(s, wait);
            //We have to cast it because cartPage object is created by polymorphic way
        }

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

        extentLogger.info("Click on place order button");
        cartPage.placeButton.click();

        extentLogger.info("Fill the form as Fake customer");
        cartPage.fillForm();

        extentLogger.info("Click on purchase button");
        cartPage.purchaseButton.click();

        String confirmation = cartPage.confirmation.getText();

        extentLogger.info("Verify the purchase amount");
        Assert.assertTrue(confirmation.contains(""+expectedPurchaseAmount));

    }

}
