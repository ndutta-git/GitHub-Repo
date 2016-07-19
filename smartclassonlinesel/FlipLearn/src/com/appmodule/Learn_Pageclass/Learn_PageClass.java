package com.appmodule.Learn_Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Learn_PageClass extends Generic_class{

	@FindBy(xpath="//ul[@id='css3menu1']//a[text()='Learn']")
	public static WebElement learn;
	
	@FindBy(xpath="//ul[@id='css3menu1']//a[text()='My Classroom']")
	public static WebElement myclassroom;
	

	@FindBy(xpath="//ul[@id='css3menu1']//a[text()='Smartclass']")
	public static WebElement smartclass;
	

	@FindBy(xpath="//ul[@id='css3menu1']//a[text()='Mathguru']")
	public static WebElement mathguru;
	
/*******************************************************************************************************************/
	public static void myclassroom(){
		try{
			fn_mouseOverClick(DriverObj, learn,myclassroom);
			Thread.sleep(2000);
			
		}catch(Exception e){
			
		}
	}
	
}
