package simpals;

//import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;



public class creation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//
	  //

    baseUrl = "http://999.md/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test999() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'вход')])[3]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("pceolka8");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("463576");
    driver.findElement(By.cssSelector("button.topbar__authForm__button.topbar__authForm__o-button")).click();
    driver.findElement(By.linkText("подать объявление")).click();
    new Select(driver.findElement(By.cssSelector("dl.grid_5.suffix_1 > dd > select"))).selectByVisibleText("Недвижимость");
    new Select(driver.findElement(By.xpath("//section[@id='container']/div/section/div/dl[2]/dd/select"))).selectByVisibleText("Квартиры и комнаты");
    driver.findElement(By.cssSelector("dt > label > input[type=\"checkbox\"]")).click();
    driver.findElement(By.cssSelector("label.m-checked")).click();
    new Select(driver.findElement(By.name("1"))).selectByVisibleText("Сдаю помесячно");
    driver.findElement(By.name("2")).clear();
    driver.findElement(By.name("2")).sendKeys("120");
    new Select(driver.findElement(By.name("2_unit"))).selectByVisibleText("$");
    new Select(driver.findElement(By.name("2_unit"))).selectByVisibleText("€");
    new Select(driver.findElement(By.name("241"))).selectByVisibleText("1-комнатная квартира");
    driver.findElement(By.name("244")).clear();
    driver.findElement(By.name("244")).sendKeys("1");
    new Select(driver.findElement(By.name("9"))).selectByVisibleText("Рышкановка");
    driver.findElement(By.id("input_12")).clear();
    driver.findElement(By.id("input_12")).sendKeys("test_title");
    driver.findElement(By.id("input_13")).clear();
    driver.findElement(By.id("input_13")).sendKeys("qweqweqwjlksdfkjslkds");
    driver.findElement(By.id("agree")).click();
    driver.findElement(By.cssSelector("button.board__content__further__body.grid_4")).click();
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
}
