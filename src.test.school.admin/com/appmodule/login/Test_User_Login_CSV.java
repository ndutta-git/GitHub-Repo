package com.appmodule.login;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;
import com.webapp.datautility.AppDataSource;


public class Test_User_Login_CSV extends AppDataSource {
	
	//Login id CSV file path
	String csvUserData=scoUploadFilePath+"scousers.csv";
	
	@BeforeTest
	public static void openBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", browserDriverPath);
		scoWebDriv = new ChromeDriver();
		scoWebDriv.manage().window().maximize();		
	}
	
	@Test (description="Launch SCO web home page")
	public void TCSEL_L01() throws Exception {
		scoWebDriv.get(scoWebURL);
		AssertJUnit.assertEquals(scoWebDriv.getTitle(), "smartclassonline - Home");
		System.out.println("PASS TC :: smartclassonline - Home page opened.");
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods={"TCSEL_L01"}, description="Go to login page")
	public void TCSEL_L02() throws Exception {
		scoWebDriv.findElement(By.className("lgpnl")).click();
		Thread.sleep(3000);
	}
	
	@SuppressWarnings("resource")
	@Test (dependsOnMethods={"TCSEL_L02"}, description="Login with csv users")
	public void TCSEL_L03() throws IOException, Exception{
		CSVReader readUsers = new CSVReader(new FileReader(csvUserData));
		String [] csvCellData;
		while ((csvCellData = readUsers.readNext()) != null){
			//
			String csvUserName = csvCellData[0];
			String csvUserPaswd = csvCellData[1];
			//
			// input school user id and password
			scoWebDriv.findElement(By.id("LoginForm_username")).clear();
			scoWebDriv.findElement(By.id("LoginForm_username")).sendKeys(csvUserName);
			//System.out.println("User ID: " +scoGitSchoolAdminUserID);
			scoWebDriv.findElement(By.id("LoginForm_password")).clear();
			scoWebDriv.findElement(By.id("LoginForm_password")).sendKeys(csvUserPaswd);
			//System.out.println("Password: " +scoGitSchoolAdminPsswd);
			Thread.sleep(2000);
			scoWebDriv.findElement(By.cssSelector("button[type='submit']")).click();
			//System.out.println("PASS TCSEL_L03: User id and password accepted");
			Thread.sleep(3000);
			//System.out.println("Verifying login");
			try{
				WebDriverWait schoolNameWait = new WebDriverWait(scoWebDriv, 5);
				schoolNameWait.until(ExpectedConditions.presenceOfElementLocated(By.className("breadcrumbs")));
				System.out.println("Login successful and user of school " +scoWebDriv.findElement(By.className("breadcrumbs")).getText());
				Thread.sleep(1000);
				WebDriverWait accMenuWait = new WebDriverWait(scoWebDriv, 2);
				accMenuWait.until(ExpectedConditions.presenceOfElementLocated(By.className("caret")));
				scoWebDriv.findElement(By.className("caret")).click();
				Thread.sleep(2000);
				WebDriverWait logoutWait = new WebDriverWait(scoWebDriv, 3);
				logoutWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/index.php/site/logout']")));
				scoWebDriv.findElement(By.cssSelector("a[href='/index.php/site/logout']")).click();
			} catch (NoSuchElementException e) {
				Thread.sleep(3000);
				Assert.fail("Login failed and got error message");
				scoWebDriv.findElement(By.className("lgpnl")).click();
			}
			Thread.sleep(1000);
		}
		
	}
	
	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(3000);
		scoWebDriv.close();
		scoWebDriv.quit();
	}
	

}
