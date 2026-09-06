package com.fieldforceconnect.tests;

import com.fieldforceconnect.base.BaseTest;
import com.fieldforceconnect.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class AddCustomerTest extends BaseTest {
    @DataProvider(name="customerData")
    public Object[][] customerData(){return new Object[][]{{"Test Customer","9876543210","testcustomer@example.com","Mumbai"}};}

    @Test(dataProvider="customerData")
    public void addCustomer(String name,String mobile,String email,String address){
        new LoginPage(driver).login(config.getProperty("email"),config.getProperty("password"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        By add=By.xpath("//*[self::button or self::a or @role='button'][contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add customer')]");
        wait.until(ExpectedConditions.elementToBeClickable(add)).click();
        typeAny(name,By.name("name"),By.id("name"),By.name("customerName"));
        typeAny(mobile,By.name("mobile"),By.name("mobileNo"),By.id("mobile"),By.id("mobileNo"),By.cssSelector("input[type='tel']"));
        typeAny(email,By.name("email"),By.id("email"),By.cssSelector("input[type='email']"));
        typeAny(address,By.name("address"),By.id("address"),By.cssSelector("textarea"));
        By save=By.xpath("//*[self::button or self::input or @role='button'][contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'save') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'submit')]");
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        String body=driver.findElement(By.tagName("body")).getText().toLowerCase();
        Assert.assertTrue(body.contains("success")||body.contains("added")||body.contains("created")||body.contains(name.toLowerCase()),"Add Customer should show success/created indication.");
    }
    private void typeAny(String value,By... locators){for(By by:locators){try{WebElement e=new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(by));e.clear();e.sendKeys(value);return;}catch(TimeoutException ignored){}}throw new NoSuchElementException("Customer field not found");}
}
