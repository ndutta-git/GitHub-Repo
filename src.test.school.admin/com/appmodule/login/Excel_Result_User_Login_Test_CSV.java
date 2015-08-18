package com.appmodule.login;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;
import com.webapp.datautility.AppDataSource;



public class Excel_Result_User_Login_Test_CSV extends AppDataSource {
	
	//Login id CSV file path
	String csvUserData=scoUploadFilePath+"scousers2.csv";
	
	@BeforeTest (alwaysRun = true)
	public static void openBrowser() throws Exception{
		//resultWorkBook = new 
		//System.setProperty("webdriver.chrome.driver", browserDriverPath);
		scoWebDriv = new ChromeDriver();
		scoWebDriv.manage().window().maximize();
		
	}
	
	@Test (description="Launch SCO web home page")
	public void TCSEL_L01() throws Exception {
		scoWebDriv.get(scoWebURL);
		for (int homePageWaitSec = 0;; homePageWaitSec++){
			if(homePageWaitSec>=30) Assert.fail("timeout");
			try { if(IsElementPresent(By.id("register_trial2")))
				break; } catch (Exception e) {}
			Thread.sleep(2000);
		}
		AssertJUnit.assertEquals(scoWebDriv.getTitle(), "smartclassonline - Home");
		System.out.println("PASS TC :: smartclassonline - Home page opened.");
		Thread.sleep(3000);
	}
	
	private boolean IsElementPresent(By by) {
		try {
			scoWebDriv.findElement(by);
			return true;
		} catch (Exception e){
			return false;
		}
	}

	@Test (dependsOnMethods={"TCSEL_L01"}, description="Go to login page")
	public void TCSEL_L02() throws Exception {
		scoWebDriv.findElement(By.className("lgpnl")).click();
		Thread.sleep(3000);
	}
	
	
	@SuppressWarnings("resource")
	//@Test (dependsOnMethods={"TCSEL_L02"}, description="Login with csv users")
	@Test (description="Login with csv users")
	public void TCSEL_L03() throws IOException, Exception{
		//scoWebDriv.get(scoWebURL);
		//Thread.sleep(2000);
		CSVReader readUsers = new CSVReader(new FileReader(csvUserData));
		String [] csvCellData;
		while ((csvCellData = readUsers.readNext()) != null){
			//
			String csvUserName = csvCellData[0];
			String csvUserPaswd = csvCellData[1];
			//String csvSchoolName = csvCellData[2];
			//
			// input school user id and password
			scoWebDriv.findElement(By.id("LoginForm_username")).clear();
			scoWebDriv.findElement(By.id("LoginForm_username")).sendKeys(csvUserName);
			//System.out.println("User ID: " +scoGitSchoolAdminUserID);
			scoWebDriv.findElement(By.id("LoginForm_password")).clear();
			scoWebDriv.findElement(By.id("LoginForm_password")).sendKeys(csvUserPaswd);
			//System.out.println("Password: " +scoGitSchoolAdminPsswd);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.cssSelector("button[type='submit']")).click();
			//System.out.println("PASS TCSEL_L03: User id and password accepted");
			Thread.sleep(3000);
			//System.out.println("Verifying login");
			//
			// test 1
			try{
				Thread.sleep(3000);
				scoWebDriv.findElement(By.cssSelector("#dynamicMessage > div.errorMessage")).isDisplayed();
				System.out.println("LOGIN ERROR." +csvUserName);
				scoWebDriv.findElement(By.className("lgpnl")).click();
				Thread.sleep(2000);
			} catch (NoSuchElementException e){
				//System.out.println("OOPS... EXCEPTION...");
			}
			 			
			// test 2
			try{
				Thread.sleep(1000);
				if(scoWebDriv.findElement(By.className("breadcrumbs")).isDisplayed()|scoWebDriv.getTitle().equalsIgnoreCase("smartclassonline - Agreement User")){
					System.out.println("LOGIN SUCCESS." +csvUserName);
					Thread.sleep(1000);
					WebDriverWait accMenuWait = new WebDriverWait(scoWebDriv, 2);
					accMenuWait.until(ExpectedConditions.presenceOfElementLocated(By.className("caret")));
					scoWebDriv.findElement(By.className("caret")).click();
					Thread.sleep(1000);
					WebDriverWait logoutWait = new WebDriverWait(scoWebDriv, 2);
					logoutWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/index.php/site/logout']")));
					//scoWebDriv.findElement(By.cssSelector("a[href='/index.php/site/logout']")).click();
					try{
						scoWebDriv.findElement(By.cssSelector("a[href='/index.php/site/logout']")).click();
					} catch (NoSuchElementException e){
						scoWebDriv.get("http://www.smartclassonline.com/site/login");
						//System.out.println("OOPS... EXCEPTION...");
					}
				}
			} catch (NoSuchElementException e){
				//System.out.println("LOGIN FAILED.");
			}
			
			Thread.sleep(2000);
		}
		
	}

	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(3000);
		scoWebDriv.close();
		scoWebDriv.quit();
	}
	

}
