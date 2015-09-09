package com.appmodule.homepageclass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Loginpage_Pageclass extends Generic_class{
	@FindBy(id="LoginForm_username")
	public WebElement username;
	

	
	@FindBy(id="LoginForm_password")
	public WebElement password;
	
	@FindBy(name="yt0")
	public WebElement loginbutton;
	
	
		
	
	
	public IndexHomePage_PageClass Valid_Login() throws IOException{
		TestDataPath="TestData/LoginData/Test_login.xlsx";
		TestDataSheetName="logindata";
		fn_FetchExcelData(1);
		fn_Inputexcel(username, "UserName_Ed");
		fn_Inputexcel(password, "Password_Ed");
		fn_SimpleClick(loginbutton);
		IndexHomePage_PageClass indexhomepageobj=PageFactory.initElements(DriverObj, IndexHomePage_PageClass.class);
		return indexhomepageobj;
	}
}
