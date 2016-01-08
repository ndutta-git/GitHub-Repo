package com.appmodule.perform_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Marks_PageClass extends Generic_class{

	@FindBy(xpath="//h3[contains(text(),'Report Book : ')]")
	public static WebElement markstxtlogo;
	
	@FindBy(xpath="//li[@class='topmenu']/a[text()='Marks']")
    public static WebElement Parents_Marks_link;	
	
	
	@SuppressWarnings("static-access")
	public static Marks_PageClass Click_on_Marks(){
		fn_mouseOverClick(DriverObj, NavigationObj.perform_menu, Parents_Marks_link);
		Marks_PageClass markspageobj=PageFactory.initElements(DriverObj, Marks_PageClass.class);
		return markspageobj;
	}
}
