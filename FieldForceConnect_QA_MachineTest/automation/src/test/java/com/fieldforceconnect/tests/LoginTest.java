package com.fieldforceconnect.tests;
import com.fieldforceconnect.base.BaseTest; import com.fieldforceconnect.pages.LoginPage; import org.openqa.selenium.By; import org.testng.Assert; import org.testng.annotations.*;
public class LoginTest extends BaseTest {
 @DataProvider(name="loginData") public Object[][] loginData(){return new Object[][]{{"VALID","YOUR_SIGNUP_EMAIL","YOUR_PASSWORD",true},{"INVALID","invalid@example.com","WrongPassword@123",false}};}
 @Test(dataProvider="loginData") public void loginJourney(String type,String email,String password,boolean expectedSuccess){new LoginPage(driver).login(email,password);String body=driver.findElement(By.tagName("body")).getText().toLowerCase();if(expectedSuccess)Assert.assertFalse(body.contains("invalid email"),"Valid login should not show invalid-credentials message");else Assert.assertTrue(body.contains("invalid")||body.contains("incorrect")||body.contains("password"),"Invalid login should show an authentication error");}
}
