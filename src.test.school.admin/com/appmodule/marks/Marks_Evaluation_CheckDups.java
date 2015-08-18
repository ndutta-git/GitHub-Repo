package com.appmodule.marks;

import java.util.Set;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webapp.datautility.AppDataSource;

public class Marks_Evaluation_CheckDups extends AppDataSource {
	@BeforeTest
	public static void openBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium.workingdir\\environment.req\\browser.driver.java\\chromedriver.exe");
		scoWebDriv = new ChromeDriver();
		scoWebDriv.manage().window().maximize();
		scoWebDriv.get(scoWebURL);
		Thread.sleep(1000);
		
	}
	
	@Test (description="Login as school admin user")
	public void TCSEL_M01() throws Exception{
		scoWebDriv.findElement(By.className("lgpnl")).click();
		Thread.sleep(2000);
		scoWebDriv.findElement(By.id("LoginForm_username")).sendKeys(scoUserID);
		scoWebDriv.findElement(By.id("LoginForm_password")).sendKeys(scoUserPasswd);
		Thread.sleep(1000);
		scoWebDriv.findElement(By.cssSelector("button[type='submit']")).click();
		//Thread.sleep(1000);
	}
	
	@Test (dependsOnMethods={"TCSEL_M01"}, description="Open evaluation page")
	public void TCSEL_M02() throws Exception {
		// set focus to current window
		Set<String> winfocus = scoWebDriv.getWindowHandles();
		winfocus.iterator();
		System.out.println("Opening evaluation page");
		WebElement hoveradmin = scoWebDriv.findElement(By.linkText("Admin"));	//locating main admin menu item
		Actions accessadmin = new Actions(scoWebDriv);	// initiate mouse action
		accessadmin.moveToElement(hoveradmin).build().perform();	//hover admin menu
		WebDriverWait driverwait1 = new WebDriverWait(scoWebDriv, 9);
		driverwait1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Marks")));
		WebElement hovermarks = scoWebDriv.findElement(By.linkText("Marks"));	//locating marks sub menu item
		Actions accessmarks = new Actions(scoWebDriv);	// initiate mouse action
		accessmarks.moveToElement(hovermarks).build().perform();	//hover marks menu
		WebDriverWait driverwait2 = new WebDriverWait(scoWebDriv, 9);
		driverwait2.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Evaluation")));
		scoWebDriv.findElement(By.linkText("Evaluation")).click();	//locate and click marks menu item
		//System.out.println("Evaluation page link clicked");
		System.out.println("PASS TC:: Evaluation page opened.");
		Thread.sleep(1000);	
	}
	
	@Test (dependsOnMethods={"TCSEL_M02"}, description="Verify evaluation page on opening")
	public void TCSEL_M03() throws Exception {
		AssertJUnit.assertEquals(scoWebDriv.getTitle(), verifyevaluationpage);
		System.out.println("PASS TC :: " +verifyevaluationpage+ " page verified.");
		Thread.sleep(2000);	
	}
	
	@Test (dependsOnMethods={"TCSEL_M03"}, description="Check add duplicate evaluation error")
	public void TCSEL_M05() throws Exception {
		/*// set focus to current window
		Set<String> winfocus = scoWebDriv.getWindowHandles();
		winfocus.iterator();*/
		scoWebDriv.findElement(By.id("add_eval")).click();
		System.out.println("Ready to add new evaluation.");
		Thread.sleep(1000);
		scoWebDriv.findElement(By.id("evaluation_title")).sendKeys("EVL IV and V");
		scoWebDriv.findElement(By.id("evaluation_description")).sendKeys("EVL IV and V Description");
		Thread.sleep(1000);
		scoWebDriv.findElement(By.cssSelector("button[id='saveForm']")).click();
		String dupevaluation =  scoWebDriv.findElement(By.id("errorMessage")).getText();
		System.out.println("Duplicate evaluation error found as "+dupevaluation);
		AssertJUnit.assertTrue(dupevaluation.contains(adddupevaluationerror));
		System.out.println("PASS TC:: Duplicate evaluation name not allowed.");
		Thread.sleep(3000);
		scoWebDriv.findElement(By.className("close closeME")).click();
	}
	

}
