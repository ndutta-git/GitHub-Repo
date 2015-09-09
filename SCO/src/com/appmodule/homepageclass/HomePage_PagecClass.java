package com.appmodule.homepageclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class HomePage_PagecClass extends Generic_class{
	

		@FindBy(className="lgpnl")
		public static WebElement login;
		
		public Loginpage_Pageclass clickonloginbutton(){
			fn_SimpleClick(login);
Loginpage_Pageclass	loginpage=	PageFactory.initElements(DriverObj, Loginpage_Pageclass.class);
return loginpage;
		}
		
		
	

}
