package com.appmodule.perform_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Dashboard_PageClass extends Generic_class{

	@FindBy(xpath="//div[@class='span3']")
	public static WebElement dashboardtxtlogo;
}
