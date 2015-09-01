package com.appodule.manageuser.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.GenericMetod.Generic_Methods;


public class User_report_page extends Generic_Methods {

@FindBy(id="role")
public static WebElement roledropdownbox;

@FindBy(id="class")
public static WebElement selectclassdropdownbox;

@FindBy(id="section")
public static WebElement selectsectiondropdownbox;

@FindBy(name="yt0")
public WebElement applybutton;

@FindBy(name="DataTables_Table_0_length")
public static WebElement showdropdownbox;

@FindBy(id="statusfill")
public static WebElement statusdropdownbox;


@FindBy(xpath="//button[text()='Add Teacher']")
public static WebElement addteacher;

@FindBy(xpath="//button[text()='Add Student']")
public static WebElement addstudent;

@FindBy(xpath="/h3[text()='Users Report']")
public static WebElement userreportheadertext;

@FindBy(xpath="//input[@type='search']")
public static WebElement searchbox;


@FindBy(id="DataTables_Table_0_next")
public static WebElement tabelnextbutton;

@FindBy(id="DataTables_Table_0_previous")
public static WebElement tabelpreviousbutton;





public static WebElement clickonaddteacher() throws InterruptedException{
	@SuppressWarnings({ "unused" })
	User_report_page  page=PageFactory.initElements(driver, User_report_page.class);
    fn_clickonlement(addteacher);
    return clickonaddteacher();
}
public User_report_page(WebDriver driver) {
    Generic_Methods.driver = driver;
}
}
