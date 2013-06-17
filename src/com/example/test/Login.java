package com.example.test;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
//import org.openqa.selenium.support.ui.Select;
public class Login {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  protected DefaultSelenium selenium;
  
  

  @Before
      public void setUp() throws Exception {
	  //driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	  //driver = new FirefoxDriver();
    selenium = new DefaultSelenium ("localhost", 4444, "*chrome", baseUrl);
    baseUrl = "https://my.roboforex.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void testUntitled() throws Exception {
    goTo();
    login("tom@mail.md", "Secret12");

    //goToUserprofiule();
    verifyLogInPage();
    
    //changeSMF();
   logout();
    //verifyLogOutPage();
    
    
  }
  @Test
  private void verifyLogInPage() {
	try {
		  assertTrue(isElementPresent(By.cssSelector("th")));
		} catch (Error e) {
		  verificationErrors.append(e.toString());
		}
	// �������� ����� �������� �� ��������
	
}

private void logout() {
	driver.findElement(By.id("t-user-logout")).click();
}

private void login(String username, String password) {
	driver.findElement(By.id("login-email")).clear();
    driver.findElement(By.id("login-email")).sendKeys(username);
    driver.findElement(By.id("login-password")).clear();
    driver.findElement(By.id("login-password")).sendKeys(password);
    driver.findElement(By.cssSelector("button.fSubmit")).click();
}
private void goTo() {
	driver.get(baseUrl + "/en/login/");
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}