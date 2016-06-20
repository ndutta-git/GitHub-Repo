package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
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
import com.appmodule.perform_pageclass.Attendance_PageClass;
import com.appmodule.perform_pageclass.HomeWork_PageClass;
import com.appmodule.perform_pageclass.Perform_PageClass;
import com.appmodule.share_PageClass.Announement_PageClass;
import com.appmodule.share_PageClass.Events_PageClass;
import com.appmodule.share_PageClass.Gallery_PageClass;
import com.appmodule.share_PageClass.Message_Pageclass;
import com.appmodule.share_PageClass.Share_PageClass;
import com.appmodule.share_PageClass.Student_PageClass;
import com.appmodule.share_PageClass.Teacher_PageClass;
import com.appmodule.share_PageClass.Wall_PageClass;

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
		ResultFolder="C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/Results";
		Logger log = Logger.getLogger(Logger.class.getClass());
	    HomePage_PagecClass	loginpageobj=fn_OpenApp("CH", "http://www.fliplearn.com");
	    log.info("Fliplearn Opened");
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

    @SuppressWarnings({ "unused" })
	@Test(priority=1)
	public static void Click_on_Wall() throws IOException, Exception{
    	Wall_PageClass wallPage=Share_PageClass.clickonwall();
	fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
	verifyUrl("WallPage_Url", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=2)
    public static void Click_on_Message() throws IOException, Exception{
    	Message_Pageclass MessagePage= Share_PageClass.clickonmessage();
    	fn_GetPageLoadTime(NavigationObj.MessageLogo);
    	verifyUrl("MessagePage_Url", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=3)
    public static void Click_on_Gallery() throws IOException, Exception{
    	Gallery_PageClass GalleryPage=Share_PageClass.clickongallery();
    	fn_GetPageLoadTime(NavigationObj.Gallery);
    	verifyUrl("GalleryPage_Url", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=4)
    public static void Click_on_Events() throws IOException, Exception{
    	Events_PageClass EventPage=Share_PageClass.clickonevent();
    	fn_GetPageLoadTime(NavigationObj.Events);
    	verifyUrl("EventPage_Url", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=5)
    public static void Click_on_Announcement() throws IOException, Exception{
    	Announement_PageClass AnnouncementPage=Share_PageClass.clickonannouncement();
    	fn_GetPageLoadTime(NavigationObj.Announcements);
    	verifyUrl("Adminannouncement_URL", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=6)
    public static void Click_on_Student() throws IOException, Exception{
    	Student_PageClass StudentPage=Share_PageClass.clickonstudent();
    	fn_GetPageLoadTime(NavigationObj.Students);
    	verifyUrl("StudentPage_URL", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=7)
    public static void Click_on_Teacher() throws IOException, Exception{
    	Teacher_PageClass TeacherPage=Share_PageClass.clickonteacher();
    	fn_GetPageLoadTime(NavigationObj.Teachers);
    	verifyUrl("TeacherPage_URL", 1);
    }
    @SuppressWarnings({ "static-access", "unused" })
	@Test(priority=9)
    public static void Click_on_Attendance() throws InvalidFormatException, IOException{
    	Attendance_PageClass AttendancePage=Perform_PageClass.clickonattendance();
    	fn_GetPageLoadTime(NavigationObj.mark_Attendance);
    	verifyUrl("AdminAttendance_URL", 1);
    }
    
    @SuppressWarnings({ "unused", "static-access" })
	public static void Click_on_Homework() throws IOException, Exception{
    	HomeWork_PageClass HomeworkPage=Perform_PageClass.ClickOnHomework();
    	fn_GetPageLoadTime(NavigationObj.Homework_logo);
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
    
