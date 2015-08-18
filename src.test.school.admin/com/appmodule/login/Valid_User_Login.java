package com.appmodule.login;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.webapp.datautility.AppDataSource;


public class Valid_User_Login extends AppDataSource {
	
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
		scoWebDriv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File captureHomePage = ((TakesScreenshot)scoWebDriv).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captureHomePage, new File(scoScreenshotPath+"sco-home.jpg"));
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods={"TCSEL_L01"}, description="Go to login page")
	public void TCSEL_L02() throws Exception {
		scoWebDriv.findElement(By.className("lgpnl")).click();
		Thread.sleep(2000);
		//System.out.println("Page title: " +scoWebDriv.getTitle());
		WebDriverWait loadLoginTitle = new WebDriverWait(scoWebDriv, 5);
		loadLoginTitle.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicMessage")));
		if(scoWebDriv.findElement(By.id("dynamicMessage")).isDisplayed()){
			AssertJUnit.assertEquals(scoWebDriv.getTitle(), "smartclassonline - Login");
			System.out.println("PASS TC :: smartclassonline - Login page opened.");
		}
		else{
			System.out.println("FAIL TC :: smartclassonline - Error opening login page.");
		}
		scoWebDriv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File captureLoginPage = ((TakesScreenshot)scoWebDriv).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captureLoginPage, new File(scoScreenshotPath+"sco-login.jpg"));
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods={"TCSEL_L02"}, description="Login with school admin user")
	public void TCSEL_L03() throws IOException, Exception{
		// input school admin user id and password
		scoWebDriv.findElement(By.id("LoginForm_username")).clear();
		scoWebDriv.findElement(By.id("LoginForm_username")).sendKeys(scoUserID);
		//System.out.println("User ID: " +scoGitSchoolAdminUserID);
		scoWebDriv.findElement(By.id("LoginForm_password")).clear();
		scoWebDriv.findElement(By.id("LoginForm_password")).sendKeys(scoUserPasswd);
		//System.out.println("Password: " +scoGitSchoolAdminPsswd);
		Thread.sleep(2000);
		scoWebDriv.findElement(By.cssSelector("button[type='submit']")).click();
		//System.out.println("PASS TCSEL_L03: User id and password accepted");
		Thread.sleep(10000);
	}
	
	@Test(dependsOnMethods={"TCSEL_L03"}, description="Verify successful login")
	public void TCSEL_L04() throws Exception {
		//System.out.println("Verifying login");
		WebDriverWait pageLoadWait = new WebDriverWait(scoWebDriv, 5);
		pageLoadWait.until(ExpectedConditions.presenceOfElementLocated(By.className("breadcrumbs")));
		if(scoWebDriv.findElement(By.className("breadcrumbs")) != null)
		{
			System.out.println("PASS TC: Login successful and user of school " +scoWebDriv.findElement(By.className("breadcrumbs")).getText());
			
		}
		else{
			System.out.println("FAIL TC: Login failed.");
		}
		scoWebDriv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File capturePostLoginPage = ((TakesScreenshot)scoWebDriv).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(capturePostLoginPage, new File(scoScreenshotPath+"sco-user-home-page.jpg"));
		Thread.sleep(1000);		
	}
	
	@Test(dependsOnMethods={"TCSEL_L04"}, description="Verify user logout")
	public void TCSEL_L05() throws Exception {
		//System.out.println("Verifying login");
		WebDriverWait accMenuWait = new WebDriverWait(scoWebDriv, 2);
		accMenuWait.until(ExpectedConditions.presenceOfElementLocated(By.className("caret")));
		scoWebDriv.findElement(By.className("caret")).click();
		Thread.sleep(2000);
		WebDriverWait logoutWait = new WebDriverWait(scoWebDriv, 3);
		logoutWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/index.php/site/logout']")));
		scoWebDriv.findElement(By.cssSelector("a[href='/index.php/site/logout']")).click();
		System.out.println("PASS TC: User loggedout successfully.");
	}
	
	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(3000);
		scoWebDriv.close();
		scoWebDriv.quit();
	}
	

}
