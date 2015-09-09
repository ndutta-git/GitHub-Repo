package com.appmodule.testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;

public class Login_Script extends Generic_class{
@Test
public static void Loginvalidation() throws IOException, InvalidFormatException{
HomePage_PagecClass	loginobj=fn_OpenApp("FF", "http://www.smartclassonline.com");
Loginpage_Pageclass loginpageobj=loginobj.clickonloginbutton();
loginpageobj.Valid_Login();
Generic_class.verifyVisible(loginpageobj.username,"username");
Generic_class.verifyVisible(loginpageobj.password, "password");
Generic_class.verifyVisible(loginpageobj.loginbutton, "loginbutton");
}
@AfterTest
public static void closebrowser(){
	DriverObj.close();
	DriverObj.quit();
}
}
