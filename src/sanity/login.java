package sanity;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
///import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;

import ru.esteru.selenium.factory.WebDriverFactory;

public class login {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
  //driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
  driver = new ChromeDriver ();
    baseUrl = "https://my.roboforex.ru";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
	  goToMainPage();
	  login("tom@mail.md", "Secret12");
    verifyContent();
    logout();
    
    goToMainPage();
	  login("roboforex@mail.md", "Secret12");
    
    verifyLogOutPage();
    verifyLogoutPageMechanism();
   
  }
  

  
  private void goToMainPage() {
	// TODO Auto-generated method stub
	  driver.get(baseUrl + "/ru/login/");
}

private void login(String username, String password) {
	  // type | id=login-email | tom@mail.md
	  driver.findElement(By.id("login-email")).clear();
	  driver.findElement(By.id("login-email")).sendKeys(username);
	  driver.findElement(By.id("login-password")).clear();
	  driver.findElement(By.id("login-password")).sendKeys(password);
	   driver.findElement(By.id("login-submit")).clear(); 
	  }


private void verifyContent() {
	driver.findElement(By.cssSelector("button.fSubmit")).click();
	  // verifyElementPresent | id=t-user-info | 
	  try {
	    assertTrue(isElementPresent(By.id("t-user-info")));
	  } catch (Error e) {
	 verificationErrors.append(e.toString());
	  
	  }
	
}

private void logout() {
	driver.findElement(By.id("t-user-logout")).click();
	// verifyElementPresent | id=personal_office_award | 
	//try {
	 // assertTrue(isElementPresent(By.id("personal_office_award")));
	// } catch (Error e) {
	 // verificationErrors.append(e.toString());
//	}
	// click | link=Что-то на русском | 
	// driver.findElement(By.linkText("Что-то на русском")).click();

	
}

private void verifyLogOutPage() {
	// TODO Auto-generated method stub
	
}

private void verifyLogoutPageMechanism() {
	// TODO Auto-generated method stub
	
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

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
  /*private void logout() {
		driver.findElement(By.id("t-user-logout")).click();
		// verifyElementPresent | id=personal_office_award | 
		//try {
		 // assertTrue(isElementPresent(By.id("personal_office_award")));
		// } catch (Error e) {
		 // verificationErrors.append(e.toString());
//		}
		// click | link=Что-то на русском | 
		// driver.findElement(By.linkText("Что-то на русском")).click();

		
	}*/
}
