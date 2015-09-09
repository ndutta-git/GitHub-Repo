package com.appmodule.admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_Student_PageClass {

	/**************************************************Student_Information*****************************************************/
	@FindBy(id="myModalLabel")
	public static WebElement addstudentheaderlogo;
	
	@FindBy(id="User_first_name")
	public static WebElement addstudentfirstname;
	
	@FindBy(id="User_middle_name")
	public static WebElement addstudentmiddlename;
	
	@FindBy(id="User_last_name")
	public static WebElement addstudentlastname;
	
	@FindBy(id="UserProfile_email_id")
	public static WebElement addstudentemailID;
	
	@FindBy(id="UserProfile_mobile_number")
	public static WebElement addstudentmobilenumber;
	
	@FindBy(id="UserProfile_roll_no")
	public static WebElement addstudentrollno;
	
	@FindBy(id="UserProfile_admission_number")
	public static WebElement addstudentadmissionnumber;
	
	@FindBy(id="modelProfile_group_id")
	public static WebElement addstudentclass;
	
	@FindBy(id="modelProfile_section_group_id")
	public static WebElement addstudentsection;
	
	@FindBy(css="button[class='btn btn-default']")
	public static WebElement addstudentclosebutton;
	
	@FindBy(id="saveForm")
	public static WebElement addstudentsavebutton;
/**************************************************Parent_Information*****************************************************/
	@FindBy(id="Parent_first_name")
	public static WebElement parentfirstname;
	
	@FindBy(id="Parent_middle_name")
	public static WebElement parentmiddlename;
	
	@FindBy(id="Parent_last_name")
	public static WebElement parentlastname;
	
	@FindBy(css="button[class='close']")
	public static WebElement parentXclosebutton;
	
	@FindBy(css="button[class='btn btn-default']")
	public static WebElement parentclosebutton;
	
	@FindBy(id="saveForm")
	public static WebElement parentsavebutton;
}


