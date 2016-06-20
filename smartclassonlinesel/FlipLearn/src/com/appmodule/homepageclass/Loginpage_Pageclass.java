package com.appmodule.homepageclass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Loginpage_Pageclass extends Generic_class{
	@FindBy(id="LoginForm_username")
	public static WebElement username;
	

	
	@FindBy(id="LoginForm_password")
	public static WebElement password;
	
	@FindBy(name="yt0")
	public static WebElement loginbutton;
	
		
	
	
	public  IndexHomePage_PageClass Student_Valid_Login() throws IOException, InterruptedException, Exception{
		TestDataPath="TestData/LoginData/Student_login_Data.xlsx";
		TestDataSheetName="logindata";
		 fn_FetchExcelData(1);
		 Username= (String) testData_HM.get("UserName_Ed");
	     Login_Role= (String) testData_HM.get("User_Role_ED");
	    fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		Main_Manu_Item=fn_GetText(loginbutton);
		fn_SimpleClick(loginbutton);
		Thread.sleep(2000);
		IndexHomePage_PageClass indexhomepage=	(IndexHomePage_PageClass) PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		return indexhomepage;
		
	}
	public IndexHomePage_PageClass teacher_valid_login() throws IOException, InterruptedException, InvalidFormatException{
		TestDataPath="TestData/LoginData/teacher_login_Data.xlsx";
		TestDataSheetName="logindata";
		fn_FetchExcelData(1);
		 Username= (String) testData_HM.get("UserName_Ed");
		 Login_Role= (String) testData_HM.get("User_Role_ED");
		fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		fn_GetText(loginbutton);
		fn_SimpleClick(loginbutton);
		Thread.sleep(2000);
		IndexHomePage_PageClass indexhomepage=	(IndexHomePage_PageClass) PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		 return indexhomepage;
	}
	public IndexHomePage_PageClass admin_valid_login() throws IOException, InterruptedException, InvalidFormatException{
		TestDataPath="TestData/LoginData/admin_login_Data.xlsx";
		TestDataSheetName="Admin_login_Data";
		fn_FetchExcelData(1);
		 Username= (String) testData_HM.get("UserName_Ed");
		 Login_Role= (String) testData_HM.get("User_Role_ED");
		fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		fn_GetText(loginbutton);
		fn_SimpleClick(loginbutton);
		Thread.sleep(2000);
		IndexHomePage_PageClass indexhomepage=	(IndexHomePage_PageClass) PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		 return indexhomepage;
	}
	public IndexHomePage_PageClass parents_valid_login() throws IOException, InterruptedException, InvalidFormatException{
		TestDataPath="TestData/LoginData/parents_login_Data.xlsx";
		TestDataSheetName="logindata";
		fn_FetchExcelData(1);
		 Username= (String) testData_HM.get("UserName_Ed");
		 Login_Role= (String) testData_HM.get("User_Role_ED");
		fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		fn_GetText(loginbutton);
		fn_SimpleClick(loginbutton);
		Thread.sleep(2000);
		IndexHomePage_PageClass indexhomepage=	(IndexHomePage_PageClass) PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		 return indexhomepage;
	}
	public static IndexHomePage_PageClass Principal_login() throws IOException, InvalidFormatException, InterruptedException{
		TestDataPath="TestData/LoginData/admin_login_Data.xlsx";
	    TestDataSheetName="Principal_login_Data";
	    fn_FetchExcelData(1);
		 Username= (String) testData_HM.get("UserName_Ed");
		 Login_Role= (String) testData_HM.get("User_Role_ED");
		fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		fn_GetText(loginbutton);
		fn_SimpleClick(loginbutton);
		Thread.sleep(2000);
		IndexHomePage_PageClass indexhomepage=	(IndexHomePage_PageClass) PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		 return indexhomepage;
	}
}
