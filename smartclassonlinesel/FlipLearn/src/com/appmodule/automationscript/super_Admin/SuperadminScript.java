package com.appmodule.automationscript.super_Admin;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.super_admin_pageclass.Create_School_PageClass;
import com.appmodule.super_admin_pageclass.Manage_School_PageClass;
import com.appmodule.super_admin_pageclass.Super_Admin_HomePage;

public class SuperadminScript extends Generic_class{

	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM =new HashMap();
	
	@SuppressWarnings("static-access")
	@BeforeTest
	
	public static void loginapp() throws Exception{
	HomePage_PagecClass	loginpageobj=fn_OpenApp("FF", "http://www.fliplearn.com");
	Loginpage_Pageclass loginpageobj1=loginpageobj.clickonloginbutton();
	loginpageobj1.admin_valid_login();
	}
	
	@SuppressWarnings("static-access")
	@AfterTest
	public static void closedapp() throws Exception{
		NavigationObj.fn_logout();
		DriverObj.close();
		DriverObj.quit();
	}
	@SuppressWarnings("static-access")
	@Test
	public static void clickonschoollink() throws Exception{
	Super_Admin_HomePage superadminhomepageobj=	PageFactory.initElements(DriverObj, Super_Admin_HomePage.class);
	superadminhomepageobj.mouseoveronadmin();
	Thread.sleep(2000);
Manage_School_PageClass manageschoolpageobj=superadminhomepageobj.clickonschool();
Generic_class.verifyVisible(manageschoolpageobj.manageschoolheaderlogo, "manageschoolheaderlogo");
	}
	@SuppressWarnings("static-access")
	@Test
	public static void cliockonnewbutton() throws Exception{
		Manage_School_PageClass manageschoolpagobj=	PageFactory.initElements(DriverObj, Manage_School_PageClass.class);
	Create_School_PageClass createschoolpageobj=manageschoolpagobj.clickonnewbutton();
	Generic_class.verifyVisible(createschoolpageobj.createschoolheaderlogo, "createschoolheaderlogo");
	createschoolpageobj.sendtextinschooltextbox();
	}
}
