package edu.npu.ReadDataFromExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class ReadDataFromExcel {

	public WebDriver driver;
	public String baseUrl1;
	public String baseUrl2;
	String username;
	String password;

	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void main() throws Exception {

		try {

//			Extra code to read data from excel.xls file
			/*File f = new File(
					"C:\\Users\\Ruchir\\Documents\\EclipseProjects\\Rest\\ReadDataFromExcel\\data.xls");
			jxl.Workbook wb = jxl.Workbook.getWorkbook(f);
			
			String username = wb.getSheet(0).getCell(0, 1).getContents();
			String password = wb.getSheet(0).getCell(1, 1).getContents();*/
			
//			Code to read data from excel.xlsx file
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Ruchir\\Documents\\EclipseProjects\\Rest\\ReadDataFromExcel\\data.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            
            username = sheet.getRow(1).getCell(0).getStringCellValue();
            password = sheet.getRow(1).getCell(1).getStringCellValue();
			
			driver = new FirefoxDriver();
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("lst-ib")).clear();
			driver.findElement(By.id("lst-ib")).sendKeys("NPU");
			driver.findElement(By.name("btnG")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Northwestern Polytechnic University")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Student Log-In")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys(username);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[2]/fieldset/form/p[2]/input")).click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			// go back to NPU Home page
			driver.navigate().back();
			Thread.sleep(2000);
			// close all
			Thread.sleep(2);
			driver.quit();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub

	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}
	}

}
