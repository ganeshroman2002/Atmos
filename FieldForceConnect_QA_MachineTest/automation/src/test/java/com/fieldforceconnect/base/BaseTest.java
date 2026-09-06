package com.fieldforceconnect.base;

import java.io.InputStream; import java.util.Properties;
import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod; import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
 protected WebDriver driver; protected Properties config=new Properties();
 @BeforeMethod public void setUp() throws Exception { try(InputStream in=getClass().getClassLoader().getResourceAsStream("config.properties")){if(in==null)throw new IllegalStateException("config.properties not found");config.load(in);} WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); driver.manage().window().maximize(); driver.get(config.getProperty("baseUrl")); }
 @AfterMethod public void tearDown(){if(driver!=null)driver.quit();}
}
