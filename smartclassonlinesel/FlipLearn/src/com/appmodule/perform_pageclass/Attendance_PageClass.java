package com.appmodule.perform_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Attendance_PageClass extends Generic_class{

	@FindBy(xpath="//h3[contains(text(),'Attendance ')]")
	public static WebElement attendancetxtlogo;
}
