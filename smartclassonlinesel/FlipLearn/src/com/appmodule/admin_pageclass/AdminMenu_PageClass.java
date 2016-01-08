package com.appmodule.admin_pageclass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.super_admin_pageclass.Manage_School_PageClass;

public class AdminMenu_PageClass extends Generic_class {

	@FindBy(xpath="//li[@class='topmenu']/a[text()='Admin']")
	public static WebElement Admin_Menu;
	
	@FindBy(xpath="//a[text()='Users']")
	public static WebElement User_SubMenu;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Manage User']")
	public static WebElement Manage_User;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Roll No Setup']")
	public static WebElement rollno_Setup;
	
	@FindBy(xpath="//a[text()='Bulk Section Setup']")
	public static WebElement Bulk_section_Setup;
	
	@FindBy(xpath="//a[text()='School']")
	public static WebElement School_Menu;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Manage School']")
	public static WebElement Manage_School;
	
	@FindBy(xpath="//a[text()='Add Admin']")
	public static WebElement add_admin;
	
	@FindBy(xpath="//a[text()='Add Principal']")
	public static WebElement add_principal;
	
	@FindBy(xpath="//a[text()='Add Students and Parents(Bulk)']")
	public static WebElement add_student_parents_bulk;
	
	@FindBy(xpath="//a[text()='School Preferences']")
	public static WebElement school_preferences;
	
	@FindBy(xpath="//a[text()='Classes']")
	public static WebElement classess;
	
	@FindBy(xpath="//a[text()='Holidays']")
	public static WebElement holidays;
	
	@FindBy(xpath="//a[text()='Text Books']")
	public static WebElement Text_book;
	
	@FindBy(xpath="//a[text()='Reports']")
	public static WebElement Reports_Menu;
	
	@FindBy(xpath="//a[text()='AttendanceReports']")
	public static WebElement attendanceReport;
	
	@FindBy(xpath="//a[text()='AttendanceReports']")
	public static WebElement Manage_Abused_Lists;
	
	@FindBy(xpath="//a[text()='AttendanceReports']")
	public static WebElement Access_Logs;
	
	
	@FindBy(xpath="//a[text()='Manage Abused Lists']")
	public static WebElement Manage_abused_lists;
	
	@FindBy(xpath="//a[text()='Access Logs']")
	public static WebElement access_logs;
	
	@FindBy(xpath="//a[text()='Access Logs']")
	public static WebElement Grades;
	
	@FindBy(xpath="//a[text()='Access Logs']")
	public static WebElement Evaluation;
	
	@FindBy(xpath="//a[text()='Access Logs']")
	public static WebElement Batch_Report;
	
	@FindBy(xpath="//a[text()='Marks']")
	public static WebElement Marks;
	
	@FindBy(xpath="//a[text()='Competency']")
	public static WebElement competency;
	
	@FindBy(xpath="//a[text()='Grades']")
	public static WebElement grades;
	
	@FindBy(xpath="//a[text()='Evaluation']")
	public static WebElement evaluation;
	
	@FindBy(xpath="//a[text()='Batch Report']")
	public static WebElement batch_Report;
	
	@FindBy(xpath="//a[text()='Add Teachers(bulk)']")
	public static WebElement Add_Teachers;
	
	public static User_Report_PageClass Click_on_ManageUser() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(User_SubMenu);
		Sub_Manu_Item=fn_GetText(Manage_User);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, User_SubMenu, Manage_User);
		User_Report_PageClass userreportpageobj=PageFactory.initElements(DriverObj, User_Report_PageClass.class);
		return userreportpageobj;
	}
	public static void Click_on_Rollnumbersetup() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(User_SubMenu);
		Sub_Manu_Item=fn_GetText(rollno_Setup);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, User_SubMenu, rollno_Setup);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_Bulksectionsetup() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(User_SubMenu);
		Sub_Manu_Item=fn_GetText(Bulk_section_Setup);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, User_SubMenu, Bulk_section_Setup);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_competency() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Marks);
		Sub_Manu_Item=fn_GetText(competency);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Marks, competency);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_Grades() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Marks);
		Sub_Manu_Item=fn_GetText(grades);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Marks, grades);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_Evaluation() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Marks);
		Sub_Manu_Item=fn_GetText(evaluation);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Marks, evaluation);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_Batchreport() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Marks);
		Sub_Manu_Item=fn_GetText(batch_Report);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Marks, batch_Report);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Manage_School_PageClass Click_on_Manageschool() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(Manage_School);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu, Manage_School);
		Thread.sleep(2000);
		Manage_School_PageClass manageschoolpageobj=PageFactory.initElements(DriverObj, Manage_School_PageClass.class);
		return manageschoolpageobj;
	}
	public static Add_Admin_PageClass Click_on_Add_Admin() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(add_admin);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu, add_admin);
		Thread.sleep(2000);
		Add_Admin_PageClass addadminpageobj=PageFactory.initElements(DriverObj, Add_Admin_PageClass.class);
		return addadminpageobj;
	}
	public static Add_Principal_PageClass Click_on_Add_principal() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(add_principal);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu, add_principal);
		Thread.sleep(2000);
		Add_Principal_PageClass principalpageobj=PageFactory.initElements(DriverObj, Add_Principal_PageClass.class);
		return principalpageobj;
	}
	public static Add_Student_Parent_Bulk_PageClass Click_on_Student_parentsBulk() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(add_student_parents_bulk);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu, add_student_parents_bulk);
		Thread.sleep(2000);
		Add_Student_Parent_Bulk_PageClass addstudentandparentbulk=PageFactory.initElements(DriverObj, Add_Student_Parent_Bulk_PageClass.class);
		return addstudentandparentbulk;
	}
	public static Add_Teacher_PageClass Click_on_Addteacher() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(Add_Teachers);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu,Add_Teachers);
		Thread.sleep(2000);
		Add_Teacher_PageClass addteacherpageobj=PageFactory.initElements(DriverObj, Add_Teacher_PageClass.class);
		return addteacherpageobj;
	}
	public static void Click_on_schoolprefrence() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(School_Menu);
		Sub_Manu_Item=fn_GetText(school_preferences);
		try{
			fn_DoubleMouseOverClick(DriverObj, Admin_Menu, School_Menu, school_preferences);
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Classes_PageClass Click_on_Classes() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(classess);
		fn_mouseOverClick(DriverObj, Admin_Menu, classess);
		Thread.sleep(2000);
		Classes_PageClass classespageobj=PageFactory.initElements(DriverObj, Classes_PageClass.class);
		return classespageobj;
	}
	public static Holidays_PageClass Click_on_Holidays() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(holidays);
		fn_mouseOverClick(DriverObj, Admin_Menu, holidays);
		Thread.sleep(2000);
		Holidays_PageClass holidayspageobj=PageFactory.initElements(DriverObj, Holidays_PageClass.class);
		return holidayspageobj;
	}
	public static TextBook_PageClass Click_on_TextBook() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Text_book);
		fn_mouseOverClick(DriverObj, Admin_Menu, Text_book);
		Thread.sleep(2000);
		TextBook_PageClass textbookpageobj=PageFactory.initElements(DriverObj, TextBook_PageClass.class);
		return textbookpageobj;
	}
	public static Attendance_Report_PageClass Click_on_Attendancereport() throws Exception{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Reports_Menu);
		Sub_Manu_Item=fn_GetText(attendanceReport);
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Reports_Menu, attendanceReport);
		Thread.sleep(2000);
		Attendance_Report_PageClass attendancepageobj=PageFactory.initElements(DriverObj, Attendance_Report_PageClass.class);
		return attendancepageobj;
	}
	public static void Click_on_Manageabusedlist() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(Reports_Menu);
		Sub_Manu_Item=fn_GetText(Manage_abused_lists);
		try{
		fn_DoubleMouseOverClick(DriverObj, Admin_Menu, Reports_Menu, Manage_abused_lists);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_SchoolAccount() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(Admin_Menu);
		Main_SubMainu_Item=fn_GetText(school_preferences);
		try{
			fn_mouseOverClick(DriverObj, Admin_Menu, school_preferences);
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
