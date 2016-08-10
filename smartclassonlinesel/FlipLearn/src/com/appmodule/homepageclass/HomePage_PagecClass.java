package com.appmodule.homepageclass;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class HomePage_PagecClass extends Generic_class{
	

		@FindBy(className="lgpnl")
		public static WebElement login;
		
		@FindBy(xpath="//div[@id='logo_nav']/a/img")
		public static WebElement Fliplearn_logo;
		
		
		public static Loginpage_Pageclass clickonloginbutton() throws IOException, InvalidFormatException{
			//Main_Manu_Item=fn_GetText(login);
			fn_SimpleClick(login);
            Loginpage_Pageclass	loginpage=	PageFactory.initElements(DriverObj, Loginpage_Pageclass.class);
            return loginpage;
		}
		
		
	

}
