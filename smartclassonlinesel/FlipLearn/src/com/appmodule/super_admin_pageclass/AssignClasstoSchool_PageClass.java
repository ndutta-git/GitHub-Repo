package com.appmodule.super_admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class AssignClasstoSchool_PageClass extends Generic_class{

	@FindBy(xpath="//h3[text()='Assign School Classes']")
	public static WebElement assignschoolclass_headerlogo;
	
	@FindBy(id="SchoolClass_school_id")
	public static WebElement school_dropdownlink;
	
	@FindBy(name="Save")
	public static WebElement save_BT;
	
	
	
}
