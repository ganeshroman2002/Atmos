package com.fieldforceconnect.tests;

import com.fieldforceconnect.base.BaseTest;
import com.fieldforceconnect.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class PunchInTest extends BaseTest {
    @Test
    public void punchInAndVerifyToast() {
        new LoginPage(driver).login(config.getProperty("email"), config.getProperty("password"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By punchIn = By.xpath("//*[self::button or self::a or @role='button'][contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'punch in')]");
        wait.until(ExpectedConditions.elementToBeClickable(punchIn)).click();
        By toast = By.cssSelector("[role='alert'], .toast, .Toastify__toast, .toast-message, .snackbar");
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(toast)).getText();
        Assert.assertFalse(message.trim().isEmpty(), "PunchIn toast/popup should contain a message");
    }
}
