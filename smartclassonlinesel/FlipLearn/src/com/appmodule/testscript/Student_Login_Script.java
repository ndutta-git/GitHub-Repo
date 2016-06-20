package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.perform_pageclass.Perform_PageClass;
import com.appmodule.share_PageClass.Announement_PageClass;
import com.appmodule.share_PageClass.Events_PageClass;
import com.appmodule.share_PageClass.Gallery_PageClass;
import com.appmodule.share_PageClass.Message_Pageclass;
import com.appmodule.share_PageClass.Share_PageClass;
import com.appmodule.share_PageClass.Wall_PageClass;

public class Student_Login_Script extends Generic_class{
	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
@SuppressWarnings({ "static-access", "unused" })
@Parameters("Browser")	
@BeforeTest
public static void Login_validation() throws Exception{
	TestDataPath="TestData/LoginData/url_excel.xlsx";
	TestDataSheetName="URL";
	Login_Role="Student";
	ResultSheetPath="FlipLearn/Results/Result.xlsx";
	ResultFolder="C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/Results";
	Logger logger=Logger.getLogger(Log4JLogger.class.getName());
	PropertyConfigurator.configure("Log4j.properties");
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

@SuppressWarnings({ "unused", "static-access" })
@Test(priority=1)
public static void click_walllink() throws InvalidFormatException, IOException, InterruptedException{
	Share_PageClass sharepageobj=PageFactory.initElements(DriverObj, Share_PageClass.class);
     Wall_PageClass wallpageobj=sharepageobj.clickonwall();
     fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
     verifyUrl("WallPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=2)
public static void click_message() throws Exception{
	Share_PageClass sharepageobj=PageFactory.initElements(DriverObj, Share_PageClass.class);
    @SuppressWarnings("unused")
	Message_Pageclass messagepageobj=sharepageobj.clickonmessage();
    fn_GetPageLoadTime(NavigationObj.MessageLogo);
    verifyUrl("MessagePage_Url", 1);
}

@SuppressWarnings({ "static-access", "unused" })
@Test(priority=3)
public static void click_gallery() throws Exception{
	Share_PageClass sharepageobj=PageFactory.initElements(DriverObj, Share_PageClass.class);
	Gallery_PageClass gallerypageobj=sharepageobj.clickongallery();
    fn_GetPageLoadTime(NavigationObj.Gallery);
    verifyUrl("GalleryPage_Url", 1);
}
@SuppressWarnings({ "unused", "static-access" })
@Test(priority=4)
public static void click_event() throws Exception{
	Share_PageClass sharepageobj=PageFactory.initElements(DriverObj, Share_PageClass.class);
	Events_PageClass eventpageobj=sharepageobj.clickonevent();
     fn_GetPageLoadTime(NavigationObj.Events);
     verifyUrl("EventPage_Url", 1);
}
@SuppressWarnings({ "unused", "static-access" })
@Test(priority=5)
public static void click_announcement() throws Exception{
	Share_PageClass sharepageobj=PageFactory.initElements(DriverObj, Share_PageClass.class);
	    Announement_PageClass announcementpageobj=sharepageobj.clickonannouncement();
	    fn_GetPageLoadTime(NavigationObj.Announcements);
	    verifyUrl("AnnouncementPage_Url", 1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=6)
public static void click_attendance() throws InvalidFormatException, IOException{
      Perform_PageClass.clickonattendance();
         fn_GetPageLoadTime(NavigationObj.attendance_report);
         verifyUrl("AttendancePage_Url", 1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=7)
public static void click_marks() throws InvalidFormatException, IOException{
     Perform_PageClass.clickonmarks();
     fn_GetPageLoadTime(NavigationObj.student_marks);
   verifyUrl("MarksPage_URL",1);
}
@SuppressWarnings({ "static-access" })
@Test(priority=8)
public static void click_dashboard() throws InvalidFormatException, IOException{
	Perform_PageClass.clickondashboard();
	fn_GetPageLoadTime(NavigationObj.Smartclass_Dashboard);
     verifyUrl("DashboardPage_URL",1);
}


}
