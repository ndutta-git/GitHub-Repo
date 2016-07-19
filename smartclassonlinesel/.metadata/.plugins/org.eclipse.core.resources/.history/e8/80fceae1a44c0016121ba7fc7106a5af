package com.appmodule.Learn_Pageclass;

import java.io.IOException;

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
	public static void SL_ClickOnMathGuru() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(mathguru);
		fn_mouseOverClick(DriverObj, learn, mathguru);
		try{
			fn_mouseOverClick(DriverObj, learn, mathguru);;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void ClickonMyClassRoom(){
		fn_mouseOverClick(DriverObj, learn, myclassroom);
		try{
			Thread.sleep(2000);
			fn_mouseOverClick(DriverObj, learn, myclassroom);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void MouseOverOnSmartClass(){
		fn_mouseOverClick(DriverObj, learn, smartclass);
		try{
			Thread.sleep(2000);
			fn_mouseOverClick(DriverObj, learn, smartclass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
