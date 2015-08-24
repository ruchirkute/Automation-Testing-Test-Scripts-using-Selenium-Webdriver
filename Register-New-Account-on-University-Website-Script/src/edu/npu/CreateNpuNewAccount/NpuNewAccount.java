package edu.npu.CreateNpuNewAccount;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NpuNewAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNpuNewAccount() throws Exception {
    driver.get(baseUrl + "/search?q=npu+home+page&ie=utf-8&oe=utf-8");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Northwestern Polytechnic University")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//a[contains(text(),'Online Application')])[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Register Account")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("FirstName")).clear();
    driver.findElement(By.id("FirstName")).sendKeys("Ruchir");
    Thread.sleep(2000);
    driver.findElement(By.id("LastName")).clear();
    driver.findElement(By.id("LastName")).sendKeys("Kute");
    Thread.sleep(2000);
    driver.findElement(By.id("Email")).clear();
driver.findElement(By.id("Email")).sendKeys("abcde@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("123"); //Checking Password Validation of Minimum 6 characters
    Thread.sleep(2000);
    driver.findElement(By.id("ConfirmPassword")).clear();
    driver.findElement(By.id("ConfirmPassword")).sendKeys("123");
    Thread.sleep(2000);
    driver.findElement(By.id("recaptcha_response_field")).clear();
    driver.findElement(By.id("recaptcha_response_field")).sendKeys("229");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click(); //Clicking Save button keeping the Gender field blank
    Thread.sleep(2000);
    driver.findElement(By.id("Gender")).click();
    new Select(driver.findElement(By.id("Gender"))).selectByVisibleText("Male");
    driver.findElement(By.cssSelector("option[value=\"M\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("123456");
    Thread.sleep(2000);
    driver.findElement(By.id("ConfirmPassword")).clear();
    driver.findElement(By.id("ConfirmPassword")).sendKeys(""); //Confirm Password kept blank
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("ConfirmPassword")).clear();
    driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.sleep(2000);
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
