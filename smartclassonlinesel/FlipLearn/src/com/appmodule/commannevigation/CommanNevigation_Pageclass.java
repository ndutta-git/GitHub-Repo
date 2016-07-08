package com.appmodule.commannevigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.userinformation_pageclass.Change_Password_Pageclass;
import com.appmodule.userinformation_pageclass.Change_loginID_PageClass;
import com.appmodule.userinformation_pageclass.Edit_User_profile_Pageclass;
import com.appmodule.userinformation_pageclass.Manage_Background_PageClass;

public class CommanNevigation_Pageclass extends Generic_class {


/***********************************************All_Page_Header_logo***********************************************************************/
	@FindBy(xpath="//img[@src='/themes/bootstrap_new/vr3/images/sco/logo_white.png']")
	public static WebElement  Fliplearnlogo;
	
	@FindBy(xpath="//a[text()='Messages']")
	public static WebElement MessageLogo;
	
	@FindBy(xpath="//h3[text()='Galleries']")
	public static WebElement Gallery;
	
	@FindBy(xpath="//h3[text()='Events']")
	public static WebElement Events;
	
	@FindBy(xpath="//a[text()='Announcements']")
	public static WebElement Announcements;
	
	@FindBy(xpath="//h3[text()='Students']")
	public static WebElement Students;
	
	@FindBy(xpath="//h3[text()='Teachers']")
	public static WebElement Teachers;
	
	@FindBy(xpath="//h3[text()='Mark Attendance']")
	public static WebElement mark_Attendance;
	
	@FindBy(xpath="//h3[contains(text(), 'Report Book')]")
	public static WebElement Parent_marks_link;
	
	@FindBy(xpath="//h3[contains(text(), 'Attendance Report')]")
	public static WebElement attendance_report;
	
	@FindBy(xpath="//h3[contains(text(), 'Report Book')]")
	public static WebElement student_marks;
	
	@FindBy(xpath="//h3[text()='Users Report']")
	public static WebElement Users_Report;
	
	@FindBy(xpath="//h3[text()='Roll No Setup']")
	public static WebElement Roll_No_Setup;
	
	@FindBy(xpath="//a[@href='/index.php/user/BulkSection']")
	public static WebElement Bulk_Section_Setup;
	
	@FindBy(xpath="//h3[text()='Manage Competencies']")
	public static WebElement Manage_Competencies;
	
	@FindBy(xpath="//h3[text()='Manage Grades']")
	public static WebElement Manage_Grades;
	
	@FindBy(xpath="//h3[text()='Manage Evaluations']")
	public static WebElement Manage_Evaluations;
	
	@FindBy(xpath="//h3[text()='Manage Bulk CCE Reports']")
	public static WebElement Manage_Bulk_CCE_Reports;
	
	@FindBy(xpath="//h3[text()='School Info']")
	public static WebElement School_Info;
	
	@FindBy(xpath="//h3[text()='Create Admin User']")
	public static WebElement Create_Admin_User;
	
	@FindBy(xpath="//h3[text()='Create Principal User']")
	public static WebElement Create_Principal_User;
	
	@FindBy(xpath="//h3[text()='Bulk Importer']")
	public static WebElement Bulk_Importer;
	
	@FindBy(xpath="//h3[text()='Teacher bulk Importer']")
	public static WebElement Teacher_bulk_Importer;
	
	@FindBy(xpath="//h3[text()='School Preferences']")
	public static WebElement School_Preferences;
	
	@FindBy(xpath="//h3[contains(text(), 'Manage School Classes')]")
	public static WebElement Manage_School_Classes;
	
	@FindBy(xpath="//h3[text()='Holidays']")
	public static WebElement Holidays;
	
	@FindBy(xpath="//h3[text()='Text Books']")
	public static WebElement Text_Books;
	
	@FindBy(xpath="//h3[text()='Attendance Reports']")
	public static WebElement Attendance_Reports;
	
	@FindBy(xpath="//h3[text()='Manage Abused Lists']")
	public static WebElement Manage_Abused_Lists;
	
	@FindBy(xpath="//h3[text()='Manage Access Logs']")
	public static WebElement Manage_Access_Logs;
	
	@FindBy(xpath="//h3[text()='My Account']")
	public static WebElement My_Account;
	
	@FindBy(xpath="//div[@class='breadcrumbs breadcrumb msgBreadcrumb']")
	public static WebElement Smartclass_Dashboard;
	
	@FindBy(xpath="//div/div/h3/span")
	public static WebElement Homework_logo;;
	
	@FindBy(xpath="//h3[text()='Add Review']")
	public static WebElement marks_review;
	
	@FindBy(xpath="//h3[text()='Class-Wise Report ']")
	public static WebElement marks_review_reportclasswise;
	
	@FindBy(xpath="//h3[text()='Health Status']")
	public static WebElement health_status;
	

/***********************************************************************************************************************************/
	@FindBy(id="usertour")
	public static WebElement openuserprofile_link;
	
	@FindBy(xpath="//a[text()='Edit profile']")
	public static WebElement usereditprofile_link;
	
	@FindBy(xpath="//a[text()='Change password']")
	public static WebElement userchangepassword_link;
	
	@FindBy(xpath="//a[text()='Change Login ID']")
	public static WebElement userchangeloginid_link;
	
	@FindBy(xpath="//a[text()='Manage background']")
	public static WebElement usermanagebackground_link;
	
	@FindBy(xpath="//a[text()='Feedback']")
	public static WebElement userfeedback_link;
	
	@FindBy(xpath="//a[text()='Help']")
	public static WebElement help_link;
	
	@FindBy(xpath="//a[text()='Logout']")
	public static WebElement logout_link;
	
/*****************************************************Home_Page_Header_Menu_Element**********************************************************/
	
	@FindBy(xpath="//div[@id='menutour']/ul/li/a")
	public static WebElement home_menu;
	
	@FindBy(xpath="//div[@id='menutour']//li/a[text()='Share']")
	public static WebElement share_menu;
	
	@FindBy(xpath="//div[@id='menutour']//li/a[text()='Perform']")
	public static WebElement perform_menu;
	
	@FindBy(xpath="//div[@id='menutour']//li/a[text()='Admin']")
	public static WebElement admin_menu;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[2]/a[text()='Learn']")
	public static WebElement learn_menu;
	
	
	
	/***************************************************perform_Menu
	 * @throws Exception *************************************************************/
	
	public static void MouseOnPerform() throws Exception{
		try{
			fn_MouseOver(DriverObj, perform_menu);
		}catch(Exception e){
			Thread.sleep(2000);
			
		}
	}
/**************************************************learn_Menu_Element************************************************************/
	
    @FindBy(xpath="//div[@id='menutour']/ul/li[2]/a")
    public static WebElement learnmenu_link;
    
    @FindBy(xpath="//ul/li[@class='topmenu']/a")
    public static WebElement myclassroom;
    
    @FindBy(xpath="//li[@class='topmenu']/a[text()='Smartclass']")
    public static WebElement smartclass;
    
/*******************************************************************************************************************/   
	public static void fn_logout() throws Exception{
		try{
		fn_SimpleClick(openuserprofile_link);
		Thread.sleep(2000);
		fn_SimpleClick(logout_link);
		DriverObj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}catch(Exception e){
		
		}
	}
	public static Edit_User_profile_Pageclass fn_clickusereditprofilelink(){
		try{
		fn_SimpleClick(usereditprofile_link);
		}catch(Exception e){
			
		}
		Edit_User_profile_Pageclass edituserpageobj=PageFactory.initElements(DriverObj, Edit_User_profile_Pageclass.class);
		return edituserpageobj;
	}
	public static Change_Password_Pageclass fn_clickuserchangepasswordlink(){
		fn_SimpleClick(userchangepassword_link);
		Change_Password_Pageclass changepasswordobj=PageFactory.initElements(DriverObj, Change_Password_Pageclass.class);
		return changepasswordobj;
	}
	public static Change_loginID_PageClass fn_clickuserchangeloginid(){
		fn_SimpleClick(userchangeloginid_link);
		Change_loginID_PageClass changeloginidpageobj=PageFactory.initElements(DriverObj, Change_loginID_PageClass.class);
		return changeloginidpageobj;
	}
	public static Manage_Background_PageClass fn_clickusermanagebackground(){
		fn_SimpleClick(usermanagebackground_link);
		Manage_Background_PageClass managebackgroundpageobj=PageFactory.initElements(DriverObj, Manage_Background_PageClass.class);
		return managebackgroundpageobj;
	}
   public static HomePage_PagecClass clickonhomelink(){
	    fn_SimpleClick(home_menu);
	    HomePage_PagecClass homepageobj=PageFactory.initElements(DriverObj, HomePage_PagecClass.class);
	    return homepageobj;
    }

 /************************************************Browse or drop file**********************************************************/
  
   @FindBy(xpath="//div[@class='qq-upload-button']/input")
   public static WebElement browse_button;
   
   public static void Click_Upload_File() throws Exception{
	   try{
		   fn_SimpleClick(browse_button);
	   }catch(Exception e){
		   Thread.sleep(2000);
		   fn_SimpleClick(browse_button);
	   }
   }
   
}
