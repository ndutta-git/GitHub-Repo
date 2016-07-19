package com.appmodule.perform_pageclass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Perform_PageClass extends Generic_class{
	
	@FindBy(xpath="//div[@id='menutour']//li/a[text()='Perform']")
	public static WebElement perform_menu;
	
	@FindBy(xpath="//a[text()='Attendance']")
	public static WebElement attendance_link;
	
	@FindBy(xpath="//a[@href='/index.php/attendance/mark']")
	public static WebElement activeattendance_link;
	
	@FindBy(xpath="//a[@href='/index.php/attendance/mark']")
	public static WebElement Attendance_Text;
	
	@FindBy(xpath="//a[@href='/index.php/assignment/index']")
	public static WebElement HomeWork_link;
	
	@FindBy(xpath="//a[@href='/index.php/assignment/index']/span")
	public static WebElement HomeWork_Text;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Marks']")
	public static WebElement Marks_link;
	
	@FindBy(xpath="//li[@class='first topmenu']//a[text()='Marks']")
	public static WebElement student_Marks_Link;
	
	@FindBy(xpath="//a[@href='/index.php/attendance/mark']")
	public static WebElement Attendancemarks;
	
	@FindBy(css="a[href='/index.php/Dashboard']")
	public static WebElement dashboard_link;
	
	@FindBy(css="a[href='/index.php/SelfAwareness/admin']")
	public static WebElement selefawareness_link;
	
	@FindBy(xpath="//a[@href='/index.php/attendance/reports']")
	public static WebElement Attendancereport;
	
	@FindBy(xpath="//a[@href='/index.php/assignment/index']")
	public static WebElement performassignment;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Marks']")
	public static WebElement performmarks;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Review']")
	public static WebElement marksreview;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Reports']")
	public static WebElement MarksReports;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Class wise']")
	public static WebElement Marks_report_classwise;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Health Status']")
	public static WebElement preformHealthStatus;
	
	
	  public static Perform_PageClass ClickOnPerform(){
	    	fn_MouseOver(DriverObj, perform_menu);
	    	Perform_PageClass commonobj=PageFactory.initElements(DriverObj, Perform_PageClass.class);
	        return commonobj;
	    }
	    public static Attendance_PageClass clickonattendance() throws InvalidFormatException, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(Attendance_Text);
	    	fn_mouseOverClick(DriverObj, perform_menu, attendance_link);
	    	Attendance_PageClass attendancepageobj=PageFactory.initElements(DriverObj, Attendance_PageClass.class);
	    	return attendancepageobj;
	    }
	   
		public static HomeWork_PageClass ClickOnHomework() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(HomeWork_Text);
	    	fn_mouseOverClick(DriverObj, perform_menu, HomeWork_link);
	    	HomeWork_PageClass HomeworkPageObj=PageFactory.initElements(DriverObj, HomeWork_PageClass.class);
	    	return HomeworkPageObj;
	    }
	    public static Marks_PageClass clickonmarks() throws InvalidFormatException, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(student_Marks_Link);
	    	fn_mouseOverClick(DriverObj, perform_menu,student_Marks_Link);
	    	Marks_PageClass markspageobj=PageFactory.initElements(DriverObj, Marks_PageClass.class);
	    	return markspageobj;
	    }
	    public static Dashboard_PageClass clickondashboard() throws InvalidFormatException, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(dashboard_link);
	    	fn_mouseOverClick(DriverObj, perform_menu, dashboard_link);
	    	Dashboard_PageClass dashboardpageobj=PageFactory.initElements(DriverObj, Dashboard_PageClass.class);
	    	return dashboardpageobj;
	    }
	    public static SelfAwareness_PageClass clickonselefawareness() throws InvalidFormatException, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(selefawareness_link);
	    	fn_mouseOverClick(DriverObj, perform_menu, selefawareness_link);
	    	SelfAwareness_PageClass selfawarenesspageobj=PageFactory.initElements(DriverObj, SelfAwareness_PageClass.class);
	    	return selfawarenesspageobj;
	    }
	    public static Attendance_PageClass Clickonattendancemarks() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(attendance_link);
	    	Sub_Manu_Item=fn_GetText(Attendancemarks);
	    	fn_DoubleMouseOverClick(DriverObj, perform_menu, attendance_link, Attendancemarks);
	    	Attendance_PageClass Attentancepageobj=PageFactory.initElements(DriverObj, Attendance_PageClass.class);
	    	return Attentancepageobj;
	    }
	    public static Attendance_PageClass ClickonAttendance_Report() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(activeattendance_link);
	    	Sub_Manu_Item=fn_GetText(Attendancereport);
	    	fn_DoubleMouseOverClick(DriverObj, perform_menu, activeattendance_link, Attendancereport);
	    	Attendance_PageClass attendancepageobj=PageFactory.initElements(DriverObj, Attendance_PageClass.class);
	    	return attendancepageobj;
	    }
	    public static HomeWork_PageClass ClickonPerformAssignment() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(performassignment);
	    	fn_mouseOverClick(DriverObj, perform_menu, performassignment);
	    	HomeWork_PageClass assignmentpageobj=PageFactory.initElements(DriverObj, HomeWork_PageClass.class);
	    	return assignmentpageobj;
	    }
	    public static Marks_PageClass Clickonmarksreview() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(performmarks);
	    	Sub_Manu_Item=fn_GetText(marksreview);
	    	fn_DoubleMouseOverClick(DriverObj, perform_menu, performmarks,marksreview);
	    	Marks_PageClass markspageobj=PageFactory.initElements(DriverObj, Marks_PageClass.class);
	    	return markspageobj;
	    }
	    @SuppressWarnings("static-access")
		public static Marks_PageClass Clickonmarksreviewreportclasswise() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(performmarks);
	    	Sub_Manu_Item=fn_GetText(Marks_report_classwise);
	    	NavigationObj.MouseOnPerform();
	    	Thread.sleep(2000);
	    	fn_DoubleMouseOverClick(DriverObj, performmarks, MarksReports, Marks_report_classwise);
	    	Marks_PageClass markspageobj=PageFactory.initElements(DriverObj, Marks_PageClass.class);
	    	return markspageobj;
	    }
	    public static HealthStatus_PageClass ClickonHealthstatus() throws Exception, IOException{
	    	Main_Manu_Item=fn_GetText(perform_menu);
	    	Main_SubMainu_Item=fn_GetText(preformHealthStatus);
	    	fn_mouseOverClick(DriverObj, perform_menu, preformHealthStatus);
	    	HealthStatus_PageClass healthstatuspageobj=PageFactory.initElements(DriverObj, HealthStatus_PageClass.class);
	    	return healthstatuspageobj;
	    }
}
