package com.appmodule.super_admin_pageclass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Manage_School_PageClass extends Generic_class{

	@FindBy(xpath="//h3[text()='Manage School']")
	public static WebElement manageschoolheaderlogo;
	
	@FindBy(id="add_grade")
	public static WebElement newbuttonupper;
	
	@FindBy(id="add_grade")
	public static WebElement newbuttonbottom;
	
	@FindBy(className="icomoon-icon-pencil")
	public static WebElement editiconinschool;
	
	@FindBy(className="table table-bordered table-striped table")
	public static WebElement listedschooltabel;
	
	public Manage_School_PageClass verifyvisible() throws InvalidFormatException, IOException{
		verifyVisible(manageschoolheaderlogo, "Manage School");
		Manage_School_PageClass manageschoolpageclassobj=PageFactory.initElements(DriverObj, Manage_School_PageClass.class);
		return manageschoolpageclassobj;
	}
	public Create_School_PageClass clickonnewbutton() throws Exception{
		fn_SimpleClick(newbuttonupper);
		Thread.sleep(2000);
		Create_School_PageClass createschoolpageobj=PageFactory.initElements(DriverObj, Create_School_PageClass.class);
		return createschoolpageobj;
	}
	public Create_School_PageClass clickonnewbuttonbottom() throws Exception{
		fn_SimpleClick(newbuttonbottom);
		Thread.sleep(2000);
		Create_School_PageClass createschoolpageobj=PageFactory.initElements(DriverObj, Create_School_PageClass.class);
		return createschoolpageobj;
	}
	public UpdateSchoolinformation_PageClass clickonschoolediticon() throws Exception{
		fn_SimpleClick(editiconinschool);
		Thread.sleep(2000);
		UpdateSchoolinformation_PageClass updatepageobj=PageFactory.initElements(DriverObj, UpdateSchoolinformation_PageClass.class);
		return updatepageobj;
	}
}
