package com.fieldforceconnect.pages;
import java.time.Duration; import org.openqa.selenium.*; import org.openqa.selenium.support.ui.*;
public class UiActions {
 private final WebDriver driver; private final WebDriverWait wait;
 public UiActions(WebDriver d){driver=d;wait=new WebDriverWait(d,Duration.ofSeconds(15));}
 public WebElement firstVisible(By... locators){for(By by:locators){try{WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(by));if(e.isDisplayed())return e;}catch(TimeoutException ignored){}}throw new NoSuchElementException("None of supplied locators matched.");}
 public void click(By... locators){firstVisible(locators).click();}
 public void type(String value,By... locators){WebElement e=firstVisible(locators);e.clear();e.sendKeys(value);}
 public String bodyText(){return driver.findElement(By.tagName("body")).getText();}
}
