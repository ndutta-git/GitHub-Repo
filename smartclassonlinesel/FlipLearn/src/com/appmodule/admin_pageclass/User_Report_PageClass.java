package com.appmodule.admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.appmodule.Generic_method.Generic_class;

public class User_Report_PageClass extends Generic_class{

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

	@FindBy(xpath="//h3[text()='Users Report']")
	public static WebElement userreportheadertext;

	@FindBy(xpath="//input[@type='search']")
	public static WebElement searchbox;


	@FindBy(id="DataTables_Table_0_next")
	public static WebElement tabelnextbutton;

	@FindBy(id="DataTables_Table_0_previous")
	public static WebElement tabelpreviousbutton;
	/*****************************************CommonToall_Role_user************************************************************/
	@FindBy(id="downloadid")
	public static WebElement downloadstudentlistbutton;

	@FindBy(id="test")
	public static WebElement changepasswordbutton;

	@FindBy(name="reset")
	public static WebElement resetpasswordbutton;

	@FindBy(id="active_1748910")
	public static WebElement disabelbutton;

	@FindBy(name="active_inactive")
	public static WebElement enabelbutton;

	@FindBy(css="a[class='btn btn-small']")
	public static WebElement aditbutton;


	public static Add_Teacher_PageClass clickonaddteacher() throws InterruptedException {
		fn_SimpleClick(addteacher);
		Add_Teacher_PageClass  addteacherobj=PageFactory.initElements(DriverObj, Add_Teacher_PageClass.class);
	    return addteacherobj;
	}
	public static Add_Student_PageClass clickOnStudent(){
		fn_SimpleClick(addstudent);
		Add_Student_PageClass addstudentobj=PageFactory.initElements(DriverObj, Add_Student_PageClass.class);
		return addstudentobj;
		
	}
}
