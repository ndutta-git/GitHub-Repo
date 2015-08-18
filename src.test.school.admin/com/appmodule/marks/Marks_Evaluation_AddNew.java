package com.appmodule.marks;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webapp.datautility.AppDataSource;

public class Marks_Evaluation_AddNew extends AppDataSource {
	@BeforeTest
	public static void openBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", browserDriverPath);
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
		scoWebDriv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	/*@Test (dependsOnMethods={"TCSEL_M03"}, description="Add new evaluation")
	public void TCSEL_M04() throws Exception {
		WebDriverWait addNewEvalBtn = new WebDriverWait(scoWebDriv, 5);
		addNewEvalBtn.until(ExpectedConditions.presenceOfElementLocated(By.id("add_eval")));
		scoWebDriv.findElement(By.id("add_eval")).click();
		System.out.println("Ready to add new evaluation.");
		Thread.sleep(1000);
		scoWebDriv.findElement(By.id("evaluation_title")).sendKeys(addNewEvalRoot);
		scoWebDriv.findElement(By.id("evaluation_description")).sendKeys(addNewEvalRoot+ " Description");
		Thread.sleep(1000);
		scoWebDriv.findElement(By.cssSelector("button[id='saveForm']")).click();
		Thread.sleep(3000);
		if(scoWebDriv.findElement(By.cssSelector("div[class='alert flash_msg alert-success']")) != null){
			System.out.println("New evaluation created.");
		}
		else{
			throw new SkipException("Exception Found");
		}
		System.out.println("PASS TC:: Add new evaluation test success.");
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods={"TCSEL_M04"}, description="Check created new evaluation tree")
	public void TCSEL_M05() throws Exception {
		/*WebDriverWait evalTreeWord = new WebDriverWait(scoWebDriv, 5);
		evalTreeWord.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Evaluation Tree")));*/
		/*Thread.sleep(2000);
		if(scoWebDriv.findElement(By.cssSelector("a[target='_self']")) != null){
			System.out.println("Evaluation tree created with root name " +addNewEvalRoot);
		}
		else{
			System.out.println("Evaluation tree with root " +addNewEvalRoot+ " not exists");
		}
		scoWebDriv.findElement(By.cssSelector("a[target='_self']")).click();
		Thread.sleep(2000);
		System.out.println("PASS TC:: New evaluation tree created and ready to add child.");
		Thread.sleep(1000);
	}*/
	
	@Test (dependsOnMethods={"TCSEL_M03"}, description="temp case to add childs/nodes")
	public void TCSEL_M05() throws Exception {
		WebDriverWait pageNoWait = new WebDriverWait(scoWebDriv, 5);
		pageNoWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("8")));
		scoWebDriv.findElement(By.linkText("8")).click();
		System.out.println("Page 8 opened.");
		Thread.sleep(2000);
		scoWebDriv.findElement(By.cssSelector("a[href='/index.php/evaluation/update/14509']")).click();
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods={"TCSEL_M05"}, description="Add child node/level 1")
	public void TCSEL_M06() throws Exception, InterruptedException {
		//System.out.println("Ready to add child");
		WebDriverWait addNewChildBtn1 = new WebDriverWait(scoWebDriv, 3);
		addNewChildBtn1.until(ExpectedConditions.presenceOfElementLocated(By.id("addNewEval")));
		scoWebDriv.findElement(By.id("addNewEval")).click();
		System.out.println("Adding child 1 (level 1)");
		Thread.sleep(2000);
		scoWebDriv.findElement(By.cssSelector("#child_evaluation_form > div.form-group > #evaluation_title")).sendKeys(addNewEvalChild1);
		Thread.sleep(1000);
		System.out.println("name visible");
		scoWebDriv.findElement(By.cssSelector("#child_evaluation_form > div.form-group > #evaluation_description")).sendKeys(addNewEvalChild1+ "description");
		Thread.sleep(1000);
		System.out.println("desc visible");
		if (typeNewEvalChild1 == "Co-scholastic")
		{
			System.out.println("I am in if condition");
			Select typeListChild1 = new Select(scoWebDriv.findElement(By.id("Evaluation_category_id")));
			typeListChild1.selectByVisibleText(typeNewEvalChild1);
			Thread.sleep(1000);
			WebDriverWait buttonCompetancy = new WebDriverWait(scoWebDriv, 5);
			buttonCompetancy.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Choose Competency")));
			scoWebDriv.findElement(By.linkText("Choose Competency")).click();
			System.out.println("Button clicked");
			//Thread.sleep(2000);
			WebDriverWait xpandCompetancyRoot = new WebDriverWait(scoWebDriv, 3);
			xpandCompetancyRoot.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/span")));
			scoWebDriv.findElement(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/span")).click();
			System.out.println("Root opened");
			//Thread.sleep(2000);
			WebDriverWait xpandCompetancyChild1 = new WebDriverWait(scoWebDriv, 3);
			xpandCompetancyChild1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/span")));
			scoWebDriv.findElement(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/span")).click();
			System.out.println("Level 1 opened");
			//Thread.sleep(2000);
			WebDriverWait xpandCompetancyChild2 = new WebDriverWait(scoWebDriv, 3);
			xpandCompetancyChild2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/ul/li/span")));
			scoWebDriv.findElement(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/ul/li/span")).click();
			System.out.println("Level 2 opened");
			//Thread.sleep(2000);
			WebDriverWait xpandCompetancyChild3 = new WebDriverWait(scoWebDriv, 3);
			xpandCompetancyChild3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/ul/li/ul/li/span")));
			scoWebDriv.findElement(By.xpath("//div[@id='igcompetencytreeDropDown']/ul/li[4]/ul/li/ul/li/ul/li/span")).click();
			System.out.println("Level 3 opened");
			//Thread.sleep(2000);
			WebDriverWait xpandCompetancyChild4 = new WebDriverWait(scoWebDriv, 5);
			xpandCompetancyChild4.until(ExpectedConditions.presenceOfElementLocated(By.linkText("CGPA L4")));
			scoWebDriv.findElement(By.linkText("CGPA L4")).click();
			System.out.println("Level 4 opened and selected");
			// Entering generic option value
			Thread.sleep(2000);
			Select gradeListChild1 = new Select(scoWebDriv.findElement(By.id("Evaluation_grade_id")));
			gradeListChild1.selectByVisibleText(gradeNewEvalChild1);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_min_marks")).sendKeys(marksMin);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_max_marks")).sendKeys(marksMax);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_weightage")).sendKeys(marksWeightage);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_best_of_rule")).sendKeys(marksBestOf);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_start_date_modal")).sendKeys(dateStart);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_end_date_modal")).sendKeys(dateEnd);
			Thread.sleep(3000);
			scoWebDriv.findElement(By.linkText("Close")).click();
			Thread.sleep(1000);
			System.out.println("PASSED If");
		}
		else
		{
			System.out.println("I am in else condition");
			Select typeListChild1 = new Select(scoWebDriv.findElement(By.id("Evaluation_category_id")));
			typeListChild1.selectByVisibleText(typeNewEvalChild1);
			Thread.sleep(2000);
			Select gradeListChild1 = new Select(scoWebDriv.findElement(By.id("Evaluation_grade_id")));
			gradeListChild1.selectByVisibleText(gradeNewEvalChild1);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_min_marks")).sendKeys(marksMin);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_max_marks")).sendKeys(marksMax);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_weightage")).sendKeys(marksWeightage);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_best_of_rule")).sendKeys(marksBestOf);
			Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_start_date_modal")).sendKeys(dateStart);
			Thread.sleep(1000);
			//scoWebDriv.findElement(By.className("modal-body")).click();
			//Thread.sleep(1000);
			scoWebDriv.findElement(By.id("evaluation_end_date_modal")).sendKeys(dateEnd);
			Thread.sleep(3000);
			//scoWebDriv.findElement(By.className("modal-body")).click();
			//Thread.sleep(1000);
			//scoWebDriv.findElement(By.linkText("Close")).click();
			//Thread.sleep(1000);
			System.out.println("PASSED Else");
		}
		Thread.sleep(3000);
	}
	
	
	@AfterTest
	public static void closeBrowser() throws Exception{
		Thread.sleep(2000);
		scoWebDriv.close();
		scoWebDriv.quit();
	}
	

}
