package com.appmodule.testscript;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;

public class Teacher_Login_Script extends Generic_class{

	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
	
@SuppressWarnings("static-access")
@BeforeTest
@Parameters("Browser")
public static void Login_validation() throws Exception{
		TestDataPath="TestData/LoginData/url_excel.xlsx";
		TestDataSheetName="URL";
		Login_Role="Teacher";
		ResultSheetPath="FlipLearn/Results/Result.xlsx";
		ResultFolder="E:/Git-Repository/scoselenium/smartclassonlinesel/FlipLearn/Results";
		HomePage_PagecClass	loginobj=fn_OpenApp("CH", "http://www.fliplearn.com/");
	     fn_FetchExcelData(1);
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     verifyUrl("HomePage_School_URL",1);
	     Loginpage_Pageclass loginpageobj=loginobj.clickonloginbutton();
	     fn_GetPageLoadTime(NavigationObj.Fliplearnlogo);
	     loginpageobj.teacher_valid_login();
	     IndexHomePage_PageClass indexhomepageobj=PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
	     fn_GetPageLoadTime(indexhomepageobj.walllogo_onmain);
	    verifyUrl("IndexHomePage_Url",1);
	}
@AfterTest
public static void closebrowser(){
		DriverObj.close();
		//DriverObj.quit();
	}
@SuppressWarnings("static-access")
@Test(priority=1)
public static void click_on_Wall() throws Exception, IOException{
	NavigationObj.clickonwalllink();
	verifyUrl("WallPage_Url", 1);
	fn_GetPageLoadTime(IndexHomePage_PageClass.walllogo_onmain);
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
public static void Clcik_on_Event() throws IOException, Exception{
	NavigationObj.clickonevent();
	fn_GetPageLoadTime(NavigationObj.Events);
	verifyUrl("EventPage_Url", 1);
}
@SuppressWarnings("static-access")
@Test(priority=5)
public static void Click_on_Announcement() throws IOException, Exception{
	NavigationObj.clickonannouncement();
	fn_GetPageLoadTime(NavigationObj.Announcements);
	verifyUrl("TeacherAnnouncementPage_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=6)
public static void Click_on_Student() throws Exception, IOException{
	NavigationObj.clickonstudent();
	fn_GetPageLoadTime(NavigationObj.Students);
	verifyUrl("StudentPage_URL", 1);
}
@SuppressWarnings("static-access")
@Test
public static void Click_on_Teacher() throws IOException, Exception{
	NavigationObj.clickonTeacher();
	fn_GetPageLoadTime(NavigationObj.Teachers);
	Thread.sleep(2000);
	verifyUrl("TeacherPage_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=7)
public static void Click_on_AttendanceMarks() throws Exception{
	NavigationObj.Clickonattendancemarks();
	fn_GetPageLoadTime(NavigationObj.mark_Attendance);
	verifyUrl("AttendanceMarks_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=8)
public static void Click_on_AttendanceReport() throws Exception{
     NavigationObj.ClickonAttendance_Report();
     fn_GetPageLoadTime(NavigationObj.attendance_report);
	verifyUrl("AttendanceReport_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=9)
public static void Click_on_PerformAssignment() throws Exception, IOException{
	NavigationObj.ClickonPerformAssignment();
	fn_GetPageLoadTime(NavigationObj.assignment_logo);
	verifyUrl("PerformAssignmentPage_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=10)
public static void Click_on_MarksReview() throws Exception{
	NavigationObj.Clickonmarksreview();
	fn_GetPageLoadTime(NavigationObj.marks_review);
	verifyUrl("MarksReviewPage_URL",1);
}
@SuppressWarnings("static-access")
@Test(priority=11)
public static void Click_on_MarksreviewreportClasswise() throws Exception{
	NavigationObj.Clickonmarksreviewreportclasswise();
	fn_GetPageLoadTime(NavigationObj.marks_review_reportclasswise);
	verifyUrl("MarksReportClassWise_URL", 1);
}
@SuppressWarnings("static-access")
@Test(priority=12)
public static void Click_on_HealthStatus() throws Exception, IOException{
	NavigationObj.ClickonHealthstatus();
	fn_GetPageLoadTime(NavigationObj.health_status);
	verifyUrl("HealthSatatusPage_URL", 1);
}


}
