/**
 * 
 */
/**
 * @author Nilutpal Dutta
 *
 */
package com.webapp.datautility;

import org.openqa.selenium.WebDriver;

public class AppDataSource {

	// Webdriver for SCO
	public static WebDriver scoWebDriv;
	
	//Web browser driver path
	public static String browserDriverPath = "C:\\Users\\kuldeepy\\Desktop\\sco\\sco\\driver\\chromedriver.exe";
	
	// URL access and login controller
	public static String scoWebURL = "http://www.smartclassonline.com/site/home";
	public static String scoWebLoginURL = "http://www.smartclassonline.com/site/login";
	public static String scoUserID = "rc.nilutpal";
	public static String scoUserPasswd = "123456";
			
	// Directory path to browse files
	public static String scoUploadFilePath = "E:\\selenium.workingdir\\smartclassonline.testng\\test.upload.files\\";
	
	// Directory path to save screenshots 
	public static String scoScreenshotPath = "E:\\selenium.workingdir\\smartclassonline.testng\\test.run.screenshots\\";
	
	// Access Marks module pages and verify
	public static String verifyevaluationpage = "smartclassonline - Admin Evaluation";
	public static String adddupevaluationerror = "Title must be unique.";
	
	// +++++ Add evaluation root and child +++++
	// Evaluation parent or level 0
	public static String addNewEvalRoot = "Test Eval 8";
	
	// Evaluation child 1 or level 1
	public static String addNewEvalChild1 = "Test Eval 8.1";
	public static String typeNewEvalChild1 = "Co-scholastic";
	public static String gradeNewEvalChild1 = "CGPA Class IV and V";
	public static String marksMin = "1";
	public static String marksMax = "10";
	public static String marksWeightage = "10";
	public static String marksBestOf = "30";
	public static String dateStart = "28-07-2015";
	public static String dateEnd = "30-07-2015";
		
	// Evaluation child 2 or level 2
	public static String addNewEvalChild2 = "Test Eval 8.1.1";
		
	// Evaluation child 3 or level 3
	public static String addNewEvalChild3 = "Test Eval 8.1.1.1";
		
	// Evaluation child 4 or level 4
	public static String addNewEvalChild4 = "Test Eval 8.1.1.1.1";
	
}
