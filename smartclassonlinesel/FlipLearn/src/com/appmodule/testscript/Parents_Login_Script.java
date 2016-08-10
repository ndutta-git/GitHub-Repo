package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.Generic_method.Log;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.share_PageClass.Message_Pageclass;
import com.appmodule.share_PageClass.Wall_PageClass;

@SuppressWarnings("unused")
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
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Parent_login");
		HomePage_PagecClass	loginobj=fn_OpenApp("CH", "http://www.fliplearn.com");
		Log.info("Application open");
	     fn_FetchExcelData(1);
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     verifyUrl("HomePage_School_URL",1);
	     Log.info("Homepage open");
	     Loginpage_Pageclass loginpageobj=loginobj.clickonloginbutton();
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     loginpageobj.parents_valid_login();
	     IndexHomePage_PageClass indexpageobj= PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	     fn_GetPageLoadTime(indexpageobj.walllogo_onmain);
	    verifyUrl("IndexHomePage_Url",1);
	    Log.info("User Successfully login");
	}
@AfterTest
public static void closebrowser(){
		DriverObj.close();
		//DriverObj.quit();
	}



@Test(priority=1)
public static void click_on_wall() throws IOException, Exception{
      IndexHomePage_PageClass.clickOnWall();
      fn_GetPageLoadTime(Wall_PageClass.wall_logo);
       verifyUrl("WallPage_Url", 1);
       Log.info("Wall page open");
}
@SuppressWarnings("static-access")
@Test(priority=2)
public static void click_on_message() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnMessage();
	fn_GetPageLoadTime(NavigationObj.MessageLogo);
	verifyUrl("MessagePage_Url",1);
	Log.info("Message page is open");
}
@SuppressWarnings("static-access")
@Test(priority=3)
public static void click_on_Gallery() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnGallery();
	fn_GetPageLoadTime(NavigationObj.Gallery);
	verifyUrl("GalleryPage_Url", 1);
	Log.info("Gallery page is open");
}
@SuppressWarnings("static-access")
@Test(priority=4)
public static void click_on_Events() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnEvent();
	fn_GetPageLoadTime(NavigationObj.Events);
	verifyUrl("EventPage_Url", 1);
	Log.info("Event page is open");
}
@SuppressWarnings("static-access")
@Test(priority=5)
public static void click_on_Announcement() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnAnnouncement();
	fn_GetPageLoadTime(NavigationObj.Announcements);
	verifyUrl("AnnouncementPage_Url", 1);
	Log.info("Announcement page is open");
}
@SuppressWarnings("static-access")
@Test(priority=6)
public static void click_on_Teacher() throws IOException, Exception{
	IndexHomePage_PageClass.clickOnTeacher();
	fn_GetPageLoadTime(NavigationObj.Teachers);
	verifyUrl("TeacherPage_URL", 1);
	Log.info("Teacher directory open");
}
@SuppressWarnings("static-access")
@Test(priority=7)
public static void click_on_Atteandance() throws Exception, IOException{
	IndexHomePage_PageClass.clickOnAttendance();
	fn_GetPageLoadTime(NavigationObj.attendance_report);
	verifyUrl("AttendancePage_Url", 1);
	Log.info("Attendance page is open");
}
@SuppressWarnings("static-access")
@Test(priority=8)
public static void click_on_marks() throws Exception, IOException{
	IndexHomePage_PageClass.clickOnMarks();
	fn_GetPageLoadTime(NavigationObj.Parent_marks_link);
	verifyUrl("MarksPage_URL", 1);
	Log.info("Merks page is open");
}



}
