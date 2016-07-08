package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.share_PageClass.Wall_PageClass;

public class Parents_Login_Script extends Generic_class{

	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
	
@SuppressWarnings("static-access")
@BeforeTest
public static void Login_validation() throws Exception{
		TestDataPath="TestData/LoginData/url_excel.xlsx";
		TestDataSheetName="URL";
		Login_Role="Parent";
		ResultSheetPath="FlipLearn/Results/Result.xlsx";
		ResultFolder="C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/Results";
		//Logger logger=Logger.getLogger(Log4JLogger.class.getName());
		//PropertyConfigurator.configure("Log4j.properties");
		HomePage_PagecClass	loginobj=fn_OpenApp("CH", "http://www.fliplearn.com");
		//logger.info("Fliplearn Opened");
	     fn_FetchExcelData(1);
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     verifyUrl("HomePage_School_URL",1);
	     Loginpage_Pageclass loginpageobj=loginobj.clickonloginbutton();
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     loginpageobj.parents_valid_login();
	     IndexHomePage_PageClass indexpageobj= PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	     fn_GetPageLoadTime(indexpageobj.walllogo_onmain);
	    verifyUrl("IndexHomePage_Url",1);
	}
@AfterTest
public static void closebrowser(){
		DriverObj.close();
		//DriverObj.quit();
	}



@Test(priority=1)
public static void click_on_wall() throws IOException, Exception{
      IndexHomePage_PageClass.Clickonwalllink();
      fn_GetPageLoadTime(Wall_PageClass.wall_logo);
       verifyUrl("WallPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=2)
public static void click_on_message() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnMessage();
	fn_GetPageLoadTime(NavigationObj.MessageLogo);
	verifyUrl("MessagePage_Url",1);
}
@SuppressWarnings("static-access")
@Test(priority=3)
public static void click_on_Gallery() throws IOException, Exception{
	IndexHomePage_PageClass.Clickongallerylink();
	fn_GetPageLoadTime(NavigationObj.Gallery);
	verifyUrl("GalleryPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=4)
public static void click_on_Events() throws IOException, Exception{
	IndexHomePage_PageClass.Clickonevent();
	fn_GetPageLoadTime(NavigationObj.Events);
	verifyUrl("EventPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=5)
public static void click_on_Announcement() throws IOException, Exception{
	IndexHomePage_PageClass.Clickonannouncement();
	fn_GetPageLoadTime(NavigationObj.Announcements);
	verifyUrl("AnnouncementPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=6)
public static void click_on_Teacher() throws IOException, Exception{
	IndexHomePage_PageClass.ClickonTeacher();
	fn_GetPageLoadTime(NavigationObj.Teachers);
	verifyUrl("TeacherPage_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=7)
public static void click_on_Atteandance() throws Exception, IOException{
	IndexHomePage_PageClass.mouseoverclickonattendance();
	fn_GetPageLoadTime(NavigationObj.attendance_report);
	verifyUrl("AttendancePage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=8)
public static void click_on_marks() throws Exception, IOException{
	IndexHomePage_PageClass.mouseoverclickonmarks();
	fn_GetPageLoadTime(NavigationObj.Parent_marks_link);
	verifyUrl("MarksPage_URL", 1);
}



}
