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
	
/******************************************Myclassroom_menu_option**********************************************************/
	
	@FindBy(xpath="//ul[@id='css3menu1']//li/a[text()='Arts']")
	public static WebElement Art_Subject;
	
	@FindBy(xpath="//li[@class='topmenu' and contains(a, 'Grade V')]")
	public static WebElement myclassroom_Vhindi;
	
	@FindBy(xpath="//li[@class='topmenu' and contains(a, 'Grade V A Hindi')]")
	public static WebElement Myclassroom_V_HindiSub;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Class XI']")
	public static WebElement Myclassroom_XI_EnglishSub;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Class XI A']")
	public static WebElement Myclassroom_XI_EnglishSub_sectionA;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Class XI A English']")
	public static WebElement Myclassroom_english_Sub_XI;
	
	
	
/*******************************************Smartclass_Menu_option*********************************************************/
	
	@FindBy(xpath="//li[@class='topmenu']/a[@href='/index.php/smartClass/study/11']")
	public static WebElement Smartclass_english;
	
	@FindBy(xpath="//ul[@id='css3menu1']//li/a[@href='/index.php/smartClass/study/11']")
	public static WebElement ParentSmartclass_English;
	
	
	
/**************************************************Mathguru_Menu_option
 * @throws Exception *****************************************************/
	
	public static void clickonArt() throws Exception{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(myclassroom);
		Sub_Manu_Item=fn_GetText(Art_Subject);
		try{
		fn_DoubleMouseOverClick(DriverObj, learn, myclassroom, Art_Subject);
		Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void clickonenglish() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(smartclass);
		Sub_Manu_Item=fn_GetText(Smartclass_english);
		try{
			fn_DoubleMouseOverClick(DriverObj, learn, smartclass, Smartclass_english);
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void clickonmathguru() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(mathguru);
		
		try{
			fn_mouseOverClick(DriverObj, learn, mathguru);;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void click_on_Vhindi() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(myclassroom);
		Sub_Manu_Item=fn_GetText(myclassroom_Vhindi);
		try{
			fn_MouseOver(DriverObj, learn);
			Thread.sleep(2000);
			fn_DoubleMouseOverClick(DriverObj, myclassroom, myclassroom_Vhindi, Myclassroom_V_HindiSub);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void click_on_Myclassroom_EnglishSub() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(myclassroom);
		Sub_Manu_Item=fn_GetText(Myclassroom_XI_EnglishSub);
	try{
			fn_MouseOver(DriverObj, learn);
			Thread.sleep(2000);
			fn_MouseOver(DriverObj, myclassroom);
			Thread.sleep(2000);
			fn_DoubleMouseOverClick(DriverObj, Myclassroom_XI_EnglishSub, Myclassroom_XI_EnglishSub_sectionA, Myclassroom_english_Sub_XI);
	}catch(Exception e){
		e.printStackTrace();
	}
	
		
	}
	public static void Click_on_MyclassroomArt() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(myclassroom);
		Sub_Manu_Item=fn_GetText(Art_Subject);
		try{
			fn_DoubleMouseOverClick(DriverObj, learn, myclassroom, Art_Subject);
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Click_on_parentsSmartclassEnglish() throws Exception, IOException{
		Main_Manu_Item=fn_GetText(learn);
		Main_SubMainu_Item=fn_GetText(smartclass);
		Sub_Manu_Item=fn_GetText(ParentSmartclass_English);
		
		try{
			fn_DoubleMouseOverClick(DriverObj, learn, smartclass, ParentSmartclass_English);
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
