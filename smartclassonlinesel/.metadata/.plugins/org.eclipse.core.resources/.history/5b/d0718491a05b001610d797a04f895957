package com.appmodule.testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.Generic_method.Log;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.IndexHomePage_PageClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.share_PageClass.Message_Pageclass;

public class Message_TestScript extends Generic_class {
	
	public static String Upload_file_Name="4-Nature-Wallpapers-2014-1.jpg";
	public static String Upload_file_Path="";
	
	static{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Message");
	}
	
	@BeforeTest
	public static void login() throws Exception{
		fn_OpenApp("CH", "http://www.fliplearn.com");
		Log.info("Application is open");
		HomePage_PagecClass.clickonloginbutton();
		Log.info("Login Page is open");
		Loginpage_Pageclass.login();
		Log.info("User Successfully login");
	}
	@Test(priority=1)
	public static void createMessage() throws Exception{
		IndexHomePage_PageClass.clickOnMessage();
		Log.info("Message Page is open");
	    Message_Pageclass.createMessage();
	    Log.info("Message successfully ceated");
	    DriverObj.navigate().refresh();
	}
	@Test(priority=2)
	public static void verifyMessage(){
		
	}
	@AfterTest
	public static void logout() throws Exception{
		IndexHomePage_PageClass.fn_logout();
		DriverObj.close();
		DriverObj.quit();
	}
}
