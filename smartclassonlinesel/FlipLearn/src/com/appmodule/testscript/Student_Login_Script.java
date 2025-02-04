package com.appmodule.testscript;

import java.util.HashMap;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;

public class Student_Login_Script extends Generic_class{
	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
@SuppressWarnings({ "static-access", })
@Parameters("Browser")	
@BeforeTest
public static void Login_validation() throws Exception{
	TestDataPath="TestData/LoginData/url_excel.xlsx";
	TestDataSheetName="URL";
	Login_Role="Student";
	ResultSheetPath="FlipLearn/Results/Result.xlsx";
	ResultFolder="C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/Results";
	DOMConfigurator.configure("log4j.xml");
	HomePage_PagecClass	loginobj=fn_OpenApp("CH", "http://www.fliplearn.com");
     fn_FetchExcelData(1);
     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
     verifyUrl("HomePage_School_URL",1);
     Loginpage_Pageclass loginpageobj=loginobj.clickonloginbutton();
     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
     loginpageobj.Student_Valid_Login();
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
public static void click_walllink() throws Exception{
    IndexHomePage_PageClass.clickOnWall();
     fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
     verifyUrl("WallPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=2)
public static void click_message() throws Exception{
	IndexHomePage_PageClass.clickOnMessage();
    fn_GetPageLoadTime(NavigationObj.MessageLogo);
    verifyUrl("MessagePage_Url", 1);
}

@SuppressWarnings({ "static-access", })
@Test(priority=3)
public static void click_gallery() throws Exception{
	IndexHomePage_PageClass.clickOnGallery();
    fn_GetPageLoadTime(NavigationObj.Gallery);
    verifyUrl("GalleryPage_Url", 1);
}
@SuppressWarnings({  "static-access" })
@Test(priority=4)
public static void click_event() throws Exception{
	IndexHomePage_PageClass.clickOnEvent();
     fn_GetPageLoadTime(NavigationObj.Events);
     verifyUrl("EventPage_Url", 1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=5)
public static void click_announcement() throws Exception{
	IndexHomePage_PageClass.clickOnAnnouncement();
	    fn_GetPageLoadTime(NavigationObj.Announcements);
	    verifyUrl("AnnouncementPage_Url", 1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=6)
public static void click_attendance() throws Exception{
	IndexHomePage_PageClass attendance=PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	attendance.clickOnAttendance();
         fn_GetPageLoadTime(NavigationObj.attendance_report);
         verifyUrl("AttendancePage_Url", 1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=7)
public static void click_marks() throws Exception{
	IndexHomePage_PageClass Marks=PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	Marks.clickOnMarks();
     fn_GetPageLoadTime(NavigationObj.student_marks);
   verifyUrl("MarksPage_URL",1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=8)
public static void click_dashboard() throws Exception{
	IndexHomePage_PageClass Dashboard=PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	Dashboard.clickOnDashboard();
	fn_GetPageLoadTime(NavigationObj.Smartclass_Dashboard);
     verifyUrl("DashboardPage_URL",1);
}


}
