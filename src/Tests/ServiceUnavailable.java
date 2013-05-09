package com.example.test;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
public class Login {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
      public void setUp() throws Exception {
	  //driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	  driver = new FirefoxDriver();
    baseUrl = "https://my.roboforex.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

// capture from selenium IDE
  
  driver.get(baseUrl + "/ru/");
//Warning: verifyTextPresent may require manual changes
try {
 assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Сервис временно недоступен[\\s\\S]*$"));
} catch (Error e) {
 verificationErrors.append(e.toString());
}
//Warning: verifyTextPresent may require manual changes
try {
 assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Сервис временно недоступен[\\s\\S]*$"));
} catch (Error e) {
 verificationErrors.append(e.toString());
}
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("Сервис временно недоступен".equals(driver.findElement(By.cssSelector("h1")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

try {
 assertTrue(isElementPresent(By.cssSelector("h1")));
} catch (Error e) {
 verificationErrors.append(e.toString());
}
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (isElementPresent(By.cssSelector("h1"))) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//Warning: verifyTextPresent may require manual changes
try {
 assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Сервис временно недоступен, приносим наши извинения\\. Пожалуйста, зайдите позднее\\.[\\s\\S]*$"));
} catch (Error e) {
 verificationErrors.append(e.toString());
}
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("Сервис временно недоступен, приносим наши извинения. Пожалуйста, зайдите позднее.".equals(driver.findElement(By.cssSelector("#left > div > div")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (isElementPresent(By.cssSelector("#left > div > div"))) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=fbMainContainer | ]]
driver.findElement(By.id("fbInspectButton")).click();
//ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (isElementPresent(By.id("w-sub"))) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=fbMainContainer | ]]
driver.findElement(By.id("fbInspectButton")).click();
//ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
try {
 assertTrue(isElementPresent(By.id("footer")));
} catch (Error e) {
 verificationErrors.append(e.toString());
}
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("Телефон: 8-800-555-02-34\n E-mail: info@roboforex.ru \n © RoboForex, 2009-2013.\nВсе права защищены.".equals(driver.findElement(By.id("footer")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//Warning: verifyTextPresent may require manual changes
try {
 assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Сервис временно недоступен Сервис временно недоступен, приносим наши извинения\\. Пожалуйста, зайдите позднее\\.[\\s\\S]*$"));
} catch (Error e) {
 verificationErrors.append(e.toString());
}

  
}