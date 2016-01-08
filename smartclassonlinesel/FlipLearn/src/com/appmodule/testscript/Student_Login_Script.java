package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.Learn_Pageclass.Learn_PageClass;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.perform_pageclass.Attendance_PageClass;
import com.appmodule.perform_pageclass.Dashboard_PageClass;
import com.appmodule.perform_pageclass.Marks_PageClass;
import com.appmodule.share_PageClass.Announement_PageClass;
import com.appmodule.share_PageClass.Events_PageClass;
import com.appmodule.share_PageClass.Gallery_PageClass;
import com.appmodule.share_PageClass.Message_Pageclass;
import com.appmodule.share_PageClass.Share_PageClass;
import com.appmodule.share_PageClass.Wall_PageClass;

public class Student_Login_Script extends Generic_class{
	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
@SuppressWarnings("static-access")
@Parameters("Browser")	
@BeforeTest
public static void Login_validation() throws Exception{
	TestDataPath="TestData/LoginData/url_excel.xlsx";
	TestDataSheetName="URL";
	Login_Role="Student";
	ResultSheetPath="FlipLearn/Results/Result.xlsx";
	ResultFolder="E:/Git-Repository/scoselenium/smartclassonlinesel/FlipLearn/Results";
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

@SuppressWarnings("unused")
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
@SuppressWarnings({ "static-access", "unused" })
@Test(priority=6)
public static void click_attendance() throws InvalidFormatException, IOException{
         Attendance_PageClass attendencepageobj=NavigationObj.clickonattendance();
         fn_GetPageLoadTime(NavigationObj.attendance_report);
         verifyUrl("AttendancePage_Url", 1);
}
@SuppressWarnings({ "static-access", "unused" })
@Test(priority=7)
public static void click_marks() throws InvalidFormatException, IOException{
     Marks_PageClass markspageobj=NavigationObj.clickonmarks();
     fn_GetPageLoadTime(NavigationObj.student_marks);
   verifyUrl("MarksPage_URL",1);
}
@SuppressWarnings({ "static-access", "unused" })
@Test(priority=8)
public static void click_dashboard() throws InvalidFormatException, IOException{
	Dashboard_PageClass dashboardpageobj=NavigationObj.clickondashboard();
	fn_GetPageLoadTime(NavigationObj.Smartclass_Dashboard);
     verifyUrl("DashboardPage_URL",1);
}
@SuppressWarnings("static-access")
@Test(priority=9)
public static void click_myclassroom_Art_Sub() throws Exception{
	Learn_PageClass learnpageobj=PageFactory.initElements(DriverObj, Learn_PageClass.class);
	learnpageobj.clickonArt();
	fn_GetPageLoadTime(NavigationObj.Art_txt_logo);
	verifyUrl("MyclassroomPage_URL",1);
}
@SuppressWarnings("static-access")
@Test(priority=10)
public static void click_smartclass_english() throws Exception{
	Learn_PageClass learnpageobj=PageFactory.initElements(DriverObj, Learn_PageClass.class);
	learnpageobj.clickonenglish();
	fn_GetPageLoadTime(NavigationObj.english_txt_logo);
	verifyUrl("SmartclassSub_URL",1);
}
@SuppressWarnings("static-access")
@Test(priority=11)
public static void Click_Mathguru() throws Exception{
	Learn_PageClass learnpageobj=PageFactory.initElements(DriverObj, Learn_PageClass.class);
	learnpageobj.clickonmathguru();
	fn_GetPageLoadTime(NavigationObj.Mathguru_txt_logo);
	Thread.sleep(2000);
	verifyUrl("MathGuruPage_URL",1);
}
}
