package com.appmodule.admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Add_Teacher_PageClass extends Generic_class{

	@FindBy(id="myModalLabel")
	public static WebElement addteacherheaderlogo;
	
	@FindBy(id="User_first_name")
	public static WebElement addteacherfirstname;
	
	@FindBy(id="User_middle_name")
	public static WebElement addteachermiddlename;
	
	@FindBy(id="User_last_name")
	public static WebElement addteacherlastname;
	
	@FindBy(id="UserProfile_email_id")
	public static WebElement addteacheremailID;
	
	@FindBy(id="UserProfile_mobile_number")
	public static WebElement addteachermobilenumber;
	
	@FindBy(css="button[class='btn btn-default']")
	public static WebElement addteacherclosebutton;
	
	@FindBy(id="saveForm")
	public static WebElement addteachersavebutton;
	
	@FindBy(css="button[class='close']")
	public static WebElement addteacherXclosebutton;
}
