package com.appmodule.login;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.webapp.datautility.AppDataSource;


public class One_User_Login_Test_CSV extends AppDataSource {
		
	@SuppressWarnings("resource")
	@DataProvider(name = "objNewUserData", parallel = true)
	public Iterator<Object []> userTestData() throws InterruptedException, IOException {
		
		List<Object []> csvUserIDPwd = new ArrayList<>();
        String[] csvUserData= null;
        String csvDataFile=scoUploadFilePath+"scousers.csv";
        BufferedReader csvBR = null;
        String csvLine = "";
        String cvsDataSplitBy = ",";
        //this loop is pseudo code
        csvBR = new BufferedReader(new FileReader(csvDataFile));
        while ((csvLine = csvBR.readLine()) != null) {
            // use comma as separator
        	csvUserData= csvLine.split(cvsDataSplitBy);
        	csvUserIDPwd.add(csvUserData);
        }
        return csvUserIDPwd.iterator();
	}
	
	
	
	@BeforeTest
	public static void openBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", browserDriverPath);
		scoWebDriv = new ChromeDriver();
		scoWebDriv.manage().window().maximize();
		//scoWebDriv.get(scoWebURL);
		
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
	
	@Test (dataProvider = "objNewUserData", invocationCount = 1, dependsOnMethods={"TCSEL_L02"}, description="Login with csv users")
	public void TCSEL_L03(String csvUserName, String csvUserPaswd) throws IOException, Exception{
		
		//CSVReader readUsers = new CSVReader(new FileReader(csvUserData));
		//String [] csvCellData;
		//while ((csvCellData = readUsers.readNext()) != null){
			//
			//String csvUserName = csvCellData[0];
			//String csvUserPaswd = csvCellData[1];
			//String csvSchoolName = csvCellData[2];
			//
		System.out.println("User Name: "+csvUserName+" and Password: " +csvUserPaswd);
			// input school user id and password
			/*scoWebDriv.findElement(By.id("LoginForm_username")).clear();
			scoWebDriv.findElement(By.id("LoginForm_username")).sendKeys(csvUserName);
			//System.out.println("User ID: " +scoGitSchoolAdminUserID);
			scoWebDriv.findElement(By.id("LoginForm_password")).clear();
			scoWebDriv.findElement(By.id("LoginForm_password")).sendKeys(csvUserPaswd);
			//System.out.println("Password: " +scoGitSchoolAdminPsswd);
			Thread.sleep(2000);
			scoWebDriv.findElement(By.cssSelector("button[type='submit']")).click();
			//System.out.println("PASS TCSEL_L03: User id and password accepted");
			Thread.sleep(5000);
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
				Thread.sleep(3000);
				if(scoWebDriv.findElement(By.className("breadcrumbs")).isDisplayed()|scoWebDriv.getTitle().equalsIgnoreCase("smartclassonline - Agreement User")){
					System.out.println("LOGIN SUCCESS." +csvUserName);
					Thread.sleep(1000);
					WebDriverWait accMenuWait = new WebDriverWait(scoWebDriv, 2);
					accMenuWait.until(ExpectedConditions.presenceOfElementLocated(By.className("caret")));
					scoWebDriv.findElement(By.className("caret")).click();
					Thread.sleep(2000);
					WebDriverWait logoutWait = new WebDriverWait(scoWebDriv, 1);
					logoutWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/index.php/site/logout']")));
					scoWebDriv.findElement(By.cssSelector("a[href='/index.php/site/logout']")).click();
				}
			} catch (NoSuchElementException e){
				//System.out.println("LOGIN FAILED.");
			}*/
			
			Thread.sleep(1000);
		//}
		
	}

	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(3000);
		scoWebDriv.close();
		scoWebDriv.quit();
	}
	

}
