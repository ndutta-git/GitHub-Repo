package com.appmodule.share_PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Announement_PageClass extends Generic_class{

	@FindBy(xpath="//h3[text()='My Announcements']")
	public static WebElement announcementtxtlogo;
}
