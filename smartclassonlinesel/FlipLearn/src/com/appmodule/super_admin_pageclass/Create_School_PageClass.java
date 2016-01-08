package com.appmodule.super_admin_pageclass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;


public class Create_School_PageClass extends Generic_class{

	public void schooldata(){
	TestDataPath="TestData/LoginData/createschool.xlsx";
	TestDataSheetName="Create_School";
	}
	@FindBy(xpath="//h3[text()='Create School']")
	public static WebElement createschoolheaderlogo;
	
	@FindBy(id="School_school_name")
	public static WebElement schoolnametextbox;
	
	@FindBy(id="School_active")
	public static WebElement activecheckbox;
	
	@FindBy(id="School_short_name")
	public static WebElement schoolshortname;
	
	@FindBy(id="School_erp_code")
	public static WebElement erpcode;
	
	@FindBy(id="School_fax")
	public static WebElement fax;
	
	@FindBy(id="School_phone_number")
	public static WebElement phonenumber;
	
	@FindBy(id="School_email")
	public static WebElement email;
	
	@FindBy(id="School_web_url")
	public WebElement schoolwebsite;
	
	@FindBy(id="Address_address_line_1")
	public static WebElement addressline1;
	
	@FindBy(id="Address_address_line_2")
	public static WebElement addressline2;
	
	@FindBy(id="con_id")
	public static WebElement countrydropdownbox;
	
	@FindBy(id="state_id")
	public static WebElement statedropdownbox;
	
	@FindBy(id="Address_city_id")
	public static WebElement citydropdownbox;
/***************************************************School_Admin*******************************************************/
	@FindBy(id="User_1_first_name")
	public static WebElement schooladminfirstname;
	
	@FindBy(id="User_1_middle_name")
	public static WebElement middlename;
	
	@FindBy(id="User_1_last_name")
	public static WebElement lastname;
	
	@FindBy(id="UserProfile_1_mobile_number")
	public static WebElement adminmobileno;
	
	@FindBy(id="UserProfile_1_email_id")
	public static WebElement adminemailid;
/***********************************************Licence_Pack************************************************************/
	@FindBy(name="product[product_id]")
	public static WebElement licenecpackdropdownbox;
	
	
	@FindBy(id="start_date")
	public static WebElement licencestartdate;
	
	@FindBy(id="end_date")
	public static WebElement licenceenddate;
	
	@FindBy(name="yt0")
	public static WebElement createbutton;
/***********************************************Upload_SchoolLogo********************************************************/
	@FindBy(id="School_school_logo_id")
	public static WebElement logobrowsebutton;
	
	@FindBy(xpath="//div[@id='uniform-School_school_logo_id']/span")
	public static WebElement uploadlogonametextbox;
	
	public Create_School_PageClass sendtextinschooltextbox() throws IOException{
		schooldata();
		fn_FetchExcelData(1);
		fn_Inputexcel(schoolnametextbox, "SchoolName_ED");
		fn_Inputexcel(schoolshortname, "Shortname_ED");
		fn_Inputexcel(erpcode, "EepCode_ED");
		fn_Inputexcel(fax, "Fax_ED");
		fn_Inputexcel(phonenumber, "PhoneNumber_ED");
		fn_Inputexcel(email, "Eamil_ED");
		fn_Inputexcel(schoolwebsite, "SchoolWebsite_ED");
		fn_Inputexcel(addressline1, "Addressline1_ED");
		fn_Inputexcel(addressline2, "Addressliine2_ED");
		Create_School_PageClass createschoolpageobj=	PageFactory.initElements(DriverObj, Create_School_PageClass.class);
		return createschoolpageobj;
	}
	public Create_School_PageClass sendadmindataintextbox() throws IOException{
		schooldata();
		fn_FetchExcelData(1);
		fn_Inputexcel(schooladminfirstname, "AdminFirstname_ED");
		fn_Inputexcel(middlename, "AdminMiddlename_ED");
		fn_Inputexcel(lastname, "Adminlastname_ED");
		fn_Inputexcel(adminmobileno, "AdminMobilenumber_ED");
		fn_Inputexcel(adminemailid, "AdminEmail_ED");
		Create_School_PageClass createshoolpageobj=		PageFactory.initElements(DriverObj, Create_School_PageClass.class);
		return createshoolpageobj;
	}
}
