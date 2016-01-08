package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.admin_pageclass.AdminMenu_PageClass;
import com.appmodule.admin_pageclass.User_Report_PageClass;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;

public class Admin_Login_Script extends Generic_class{

	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM =new HashMap();
	
	@SuppressWarnings("static-access")
	@BeforeTest
	
	public static void loginapp() throws Exception{
		TestDataPath="TestData/LoginData/url_excel.xlsx";
		TestDataSheetName="URL";
		Login_Role="Admin";
		ResultSheetPath="FlipLearn/Results/Result.xlsx";
		ResultFolder="E:/Git-Repository/scoselenium/smartclassonlinesel/FlipLearn/Results";
	    HomePage_PagecClass	loginpageobj=fn_OpenApp("CH", "http://www.fliplearn.com");
	    fn_FetchExcelData(1);
	    fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	    verifyUrl("HomePage_School_URL",1);
	    Loginpage_Pageclass loginpageobj1=loginpageobj.clickonloginbutton();
	    fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	    verifyUrl("Login_Page_URL",1);
	    loginpageobj1.admin_valid_login();
	    fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
	    verifyUrl("IndexHomePage_Url",1);
	}
	
	@SuppressWarnings("static-access")
	@AfterTest
	public static void closedapp() throws Exception{
		NavigationObj.fn_logout();
		DriverObj.close();
		//DriverObj.quit();
	}

    @SuppressWarnings("static-access")
	@Test(priority=1)
	public static void Click_on_Wall() throws IOException, Exception{
	NavigationObj.clickonwalllink();
	fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
	verifyUrl("WallPage_Url", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=2)
    public static void Click_on_Message() throws IOException, Exception{
    	NavigationObj.clickonmessage();
    	fn_GetPageLoadTime(NavigationObj.MessageLogo);
    	verifyUrl("MessagePage_Url", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=3)
    public static void Click_on_Gallery() throws IOException, Exception{
    	NavigationObj.clickongallerylink();
    	fn_GetPageLoadTime(NavigationObj.Gallery);
    	verifyUrl("GalleryPage_Url", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=4)
    public static void Click_on_Events() throws IOException, Exception{
    	NavigationObj.clickonevent();
    	fn_GetPageLoadTime(NavigationObj.Events);
    	verifyUrl("EventPage_Url", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=5)
    public static void Click_on_Announcement() throws IOException, Exception{
    	NavigationObj.clickonannouncement();
    	fn_GetPageLoadTime(NavigationObj.Announcements);
    	verifyUrl("Adminannouncement_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=6)
    public static void Click_on_Student() throws IOException, Exception{
    	NavigationObj.clickonstudent();
    	fn_GetPageLoadTime(NavigationObj.Students);
    	verifyUrl("StudentPage_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=7)
    public static void Click_on_Teacher() throws IOException, Exception{
    	NavigationObj.clickonTeacher();
    	fn_GetPageLoadTime(NavigationObj.Teachers);
    	verifyUrl("TeacherPage_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=9)
    public static void Click_on_Attendance() throws InvalidFormatException, IOException{
    	NavigationObj.clickonattendance();
    	fn_GetPageLoadTime(NavigationObj.mark_Attendance);
    	verifyUrl("AdminAttendance_URL", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=10)
    public static void Click_on_ManageUser() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	User_Report_PageClass userreportpageobj=adminpageobj.Click_on_ManageUser();
    	fn_GetPageLoadTime(NavigationObj.Users_Report);
    	verifyUrl("Manage_UserPage_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=11)
    public static void Click_on_RollNumberSetup() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_Rollnumbersetup();
    	fn_GetPageLoadTime(NavigationObj.Roll_No_Setup);
    	verifyUrl("RollNo_SetupPage_URL", 1);
    }
    @SuppressWarnings("static-access")
    @Test(priority=12)
	public static void Click_on_BulkSection_SetUP() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_Bulksectionsetup();
    	fn_GetPageLoadTime(NavigationObj.Bulk_Section_Setup);
    	verifyUrl("BulkSection_SetUP_Page", 1);
    }
    @SuppressWarnings("static-access")
    @Test(priority=13)
	public static void Click_on_Competency() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_competency();
    	fn_GetPageLoadTime(NavigationObj.Manage_Competencies);
    	verifyUrl("Admin_Competencies_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=14)
    public static void Click_on_Grades() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_Grades();
    	fn_GetPageLoadTime(NavigationObj.Manage_Grades);
    	verifyUrl("Admin_Grades_Page_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=14)
    public static void Click_on_Evaluation() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_Evaluation();
    	fn_GetPageLoadTime(NavigationObj.Manage_Evaluations);
    	verifyUrl("Admin_Evaluation_URL", 1);
    }
    @SuppressWarnings("static-access")
	@Test(priority=15)
    public static void Click_on_BatchReport() throws Exception{
    	AdminMenu_PageClass adminpageobj=PageFactory.initElements(DriverObj, AdminMenu_PageClass.class);
    	adminpageobj.Click_on_Batchreport();
    	fn_GetPageLoadTime(NavigationObj.Manage_Bulk_CCE_Reports);
    	verifyUrl("Admin_Batchreport_URL", 1);
    }
}
    
