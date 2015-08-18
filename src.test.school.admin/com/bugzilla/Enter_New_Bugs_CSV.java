package com.bugzilla;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;


public class Enter_New_Bugs_CSV {
	
	public static WebDriver scoWebDriv;
	
	// Directory path to browse files
	public static String scoUploadFilePath = "E:\\selenium.workingdir\\smartclassonline.testng\\test.upload.files\\";
	
	public static String scoWebURL = "http://bugzilla.smartclassonline.com/";
	
	//Login id CSV file path. Change the file name
	String csvUserData=scoUploadFilePath+"bugsource.csv";
	
	@BeforeTest
	public static void openBrowser() throws Exception{
		
		scoWebDriv = new FirefoxDriver();
		scoWebDriv.manage().window().maximize();
			
	}
	
	@Test (description="Launch SCO web home and login page")
	public void TCSEL_L01() throws Exception {
		//Launch SCO web home page
		scoWebDriv.get(scoWebURL);
		Thread.sleep(3000);
				
		//Go to login page
		scoWebDriv.findElement(By.id("login_link_top")).click();
		Thread.sleep(1000);
		scoWebDriv.findElement(By.id("Bugzilla_login_top")).clear();
		scoWebDriv.findElement(By.id("Bugzilla_login_top")).sendKeys("nilutpal.dutta@smartclassonline.com");
		//System.out.println("User ID: " +scoGitSchoolAdminUserID);
		scoWebDriv.findElement(By.id("Bugzilla_password_top")).clear();
		scoWebDriv.findElement(By.id("Bugzilla_password_top")).sendKeys("Bond@007");
		Thread.sleep(1000);
		scoWebDriv.findElement(By.id("log_in_top")).click();
		Thread.sleep(3000);
	}
	
	@SuppressWarnings("resource")
	@Test (dependsOnMethods={"TCSEL_L01"}, description="Enter new bugs")
	public void TCSEL_L02() throws IOException, Exception{
		//scoWebDriv.get(scoWebURL);
		//Thread.sleep(2000);
		CSVReader readUsers = new CSVReader(new FileReader(csvUserData));
		String [] csvCellData;
		while ((csvCellData = readUsers.readNext()) != null){
			//
			String csvbugid = csvCellData[0];
			String csvbugsummary = csvCellData[1];
			String csvbugdesc = csvCellData[2];
			//String csvbugpriority = csvCellData[3];
			//String csvbugstatus = csvCellData[4];
			//
			// input school user id and password
			scoWebDriv.findElement(By.linkText("New")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.linkText("Smart Phone Apps")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.linkText("SCO IOS APP")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("v20_component")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.cssSelector("#version > option[value='V-1.0.0.1']")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("v4_bug_severity")).click();
			Thread.sleep(2000);
			//scoWebDriv.findElement(By.id("expert_fields_controller")).click();
			if(!scoWebDriv.findElement(By.id("priority")).isDisplayed()){
				WebDriverWait accMenuWait = new WebDriverWait(scoWebDriv, 2);
				accMenuWait.until(ExpectedConditions.presenceOfElementLocated(By.id("expert_fields_controller")));
				scoWebDriv.findElement(By.id("expert_fields_controller")).click();
				Thread.sleep(1000);
				WebDriverWait accMenuWait1 = new WebDriverWait(scoWebDriv, 2);
				accMenuWait1.until(ExpectedConditions.presenceOfElementLocated(By.id("priority")));
				scoWebDriv.findElement(By.id("v3_priority")).click();
				Thread.sleep(1000);
			}
			else{
				scoWebDriv.findElement(By.id("v3_priority")).click();
			}
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("v7_rep_platform")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("v7_op_sys")).click();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("assigned_to")).clear();
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("assigned_to")).sendKeys("nilutpal.dutta@smartclassonline.com");
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("short_desc")).sendKeys(csvbugid+": "+csvbugsummary);
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("comment")).sendKeys(csvbugdesc);
			Thread.sleep(2000);
			scoWebDriv.findElement(By.id("commit")).click();
			Thread.sleep(3000);
		}
		
	}

	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(3000);
		//scoWebDriv.close();
		//scoWebDriv.quit();
	}
	

}
