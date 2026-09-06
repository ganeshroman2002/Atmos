package com.fieldforceconnect.pages;
import org.openqa.selenium.*;
public class LoginPage {
 private final UiActions ui; public LoginPage(WebDriver d){ui=new UiActions(d);}
 private final By[] email={By.name("username"),By.name("email"),By.id("email"),By.cssSelector("input[type='email']")};
 private final By[] password={By.name("password"),By.id("password"),By.cssSelector("input[type='password']")};
 private final By[] login={By.xpath("//button[normalize-space()='Login']"),By.xpath("//input[@type='submit']"),By.cssSelector("button[type='submit']")};
 public void login(String user,String pass){ui.type(user,email);ui.type(pass,password);ui.click(login);}
}
