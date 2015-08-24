package edu.npu.EndToEndTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndTest {
	
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
	    driver.get(baseUrl);
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("NPU");
		driver.findElement(By.name("btnG")).click();
		driver.findElement(By.linkText("Northwestern Polytechnic University")).click();
		Thread.sleep(2000);
	    
	    driver.findElement(By.linkText("Admissions")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Application Guide")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Graduate")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Academics")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("School of Engineering")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Scholarships")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Campus")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Club Facilities")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Career Center")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("NPU News")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Student Association Blog")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("NPU Globe")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Apply Online")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Register Account")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
	    
	    driver.quit();
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
