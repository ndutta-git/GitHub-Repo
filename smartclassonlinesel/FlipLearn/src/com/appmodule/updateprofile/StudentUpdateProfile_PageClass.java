package com.appmodule.updateprofile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentUpdateProfile_PageClass {

	/**********************************************Update_Profile_Page***********************************************************/
	@FindBy(name="goBack")
	public static WebElement gobackbutton;
	
	@FindBy(id="User_first_name")
	public static WebElement firstname;
	
	@FindBy(id="User_middle_name")
	public static WebElement middlename;
	
	@FindBy(id="User_last_name")
    public static WebElement lastname;
	
	@FindBy(id="UserProfile_gender")
	public static WebElement genderdropdownbox;
	
	@FindBy(id="alt_UserProfile_date_of_birth")
	public static WebElement dateofbirthtextbox;
	
	@FindBy(id="UserProfile_nickname")
	public static WebElement nicknametextbox;
	
	@FindBy(id="UserProfile_email_id")
	public static WebElement emailtextbox;
	
	@FindBy(id="UserProfile_mobile_number")
	public static WebElement phonenumber;
	
	@FindBy(id="Address_address_line_1")
	public static WebElement addressline1textbox;
	
	@FindBy(id="Address_address_line_2")
	public static WebElement addressline2textbox;
	
	@FindBy(id="Address_country_id")
	public static WebElement countrydropdownbox;
	
	@FindBy(id="Address_state_id")
	public static WebElement statedropdownbox;
	
	@FindBy(id="Address_city_id")
	public static WebElement citydropdownbox;
	
	@FindBy(id="UserProfile_profile_picture")
	public static WebElement profilepicturebrowsebutton;

	@FindBy(id="User_1_first_name")
	public static WebElement parentsfirstname;
	
	@FindBy(id="User_1_middle_name")
	public static WebElement parentmiddlename;
	
	@FindBy(id="User_1_last_name")
	public static WebElement parentlastname;
	
	@FindBy(id="UserProfile_1_gender")
	public static WebElement parentgender;
	
	@FindBy(id="UserProfile_1_nickname")
	public static WebElement parentnickname;
	
	@FindBy(id="UserProfile_1_email_id")
	public static WebElement parentemailid;
	
	@FindBy(id="UserProfile_1_mobile_number")
	public static WebElement  parentmobileno;
	
	@FindBy(name="yt0")
	public static WebElement studentupdateprofilesavebutton;
	
	@FindBy(css="a[class='btn btn-primary']")
	public static WebElement studentupdateprofilecancelbutton;
	
	
/*******************************************************Change_Password_page**************************************************/
	@FindBy(id="myModalLabel")
	public static WebElement changepasswordpageheaderlogo;
	
	@FindBy(id="User_new_password")
	public static WebElement newpasswordtextbox;
	
	@FindBy(id="User_re_password")
	public static WebElement re_typenewpassword;
	
	@FindBy(css="button[class='btn btn-default']")
	public static WebElement closebutton;
	
	@FindBy(id="saveP")
	public static WebElement savebutton;
	
	@FindBy(xpath="(//button[@class='close'])[2]")
	public static WebElement Xclosebutton;
	
	/*******************************************ManageClass_Page**********************************************************/
	
	@FindBy(xpath="//h3[text()='Manage ']")
	public static WebElement managelogo;
	
	@FindBy(id="class")
	public static WebElement classdropdownbox;
	
	@FindBy(id="section")
	public static WebElement sectiondropdownbox;
	
}
