package edu.npu.NPUWebPageTest;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPageTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();             
    driver.get("http://www.google.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebPage() throws Exception {
    driver.get(baseUrl + "/?gws_rd=cr,ssl&ei=NvixVeuSEYXmmAXg26qQAw#q=northwestern+polytechnic+university");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("NPU");
    driver.findElement(By.name("btnG")).click();	 
    Thread.sleep(3000);
    driver.findElement(By.linkText("Northwestern Polytechnic University")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//a[contains(text(),'Academics')])[4]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//a[contains(text(),'Schedule of Classes')])[2]")).click(); 
    Thread.sleep(3000);
    driver.findElement(By.linkText("Home")).click();
    Thread.sleep(3000);
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
