package com.appodule.manageuser.pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Studentrole_pageclass {
	@FindBy(id="downloadid")
	public static WebElement downloadstudentlistbutton;
	
	@FindBy(id="test")
	public static WebElement changepasswordbutton;
	
	@FindBy(name="reset")
	public static WebElement resetpasswordbutton;
	
	@FindBy(id="active_1748910")
	public static WebElement disabelbutton;
	
	@FindBy(name="active_inactive")
	public static WebElement enabelbutton;
	
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

}
