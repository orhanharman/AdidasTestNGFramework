package com.adidas.base;

import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();  //this is enough to initialize the driver object
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
