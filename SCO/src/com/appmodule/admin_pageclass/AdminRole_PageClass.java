package com.appmodule.admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminRole_PageClass {

	/**********************************************Update_Profile_Page***********************************************************/
	@FindBy(name="goBack")
	public static WebElement adminpagegobackbutton;
	
	@FindBy(id="User_first_name")
	public static WebElement adminpagefirstname;
	
	@FindBy(id="User_middle_name")
	public static WebElement adminpagemiddlename;
	
	@FindBy(id="User_last_name")
    public static WebElement adminpagelastname;
	
	@FindBy(id="UserProfile_gender")
	public static WebElement adminpagegenderdropdownbox;
	
	@FindBy(id="alt_UserProfile_date_of_birth")
	public static WebElement adminpagedateofbirthtextbox;
	
	@FindBy(id="UserProfile_nickname")
	public static WebElement adminpagenicknametextbox;
	
	@FindBy(id="UserProfile_email_id")
	public static WebElement emailtextbox;
	
	@FindBy(id="UserProfile_mobile_number")
	public static WebElement adminpagephonenumber;
	
	@FindBy(id="Address_address_line_1")
	public static WebElement adminpageaddressline1textbox;
	
	@FindBy(id="Address_address_line_2")
	public static WebElement adminpageaddressline2textbox;
	
	@FindBy(id="Address_country_id")
	public static WebElement adminpagecountrydropdownbox;
	
	@FindBy(id="Address_state_id")
	public static WebElement adminpagestatedropdownbox;
	
	@FindBy(id="Address_city_id")
	public static WebElement adminpagecitydropdownbox;
	
	@FindBy(id="UserProfile_profile_picture")
	public static WebElement adminpageprofilepicturebrowsebutton;
	
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
}
