package com.appmodule.super_admin_pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Super_Admin_HomePage extends Generic_class{

	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/a")
	public static WebElement adminmenu;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[4]/a")
	public static WebElement school;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[5]/a")
	public static WebElement cron;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[6]/a")
	public static WebElement subjectlevelmapping;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[7]/a")
	public static WebElement assignclasstoschol;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[8]/a")
	public static WebElement classes;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[9]/a")
	public static WebElement Group;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[10]/a")
	public static WebElement Boards;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[11]/a")
	public static WebElement SchoolGroups;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[12]/a")
	public static WebElement Holidays;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[13]/a")
	public static WebElement Categories;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[14]/a")
	public static WebElement CategoryTypes;
	 
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[15]/a")
	public static WebElement ManageAcademicYear;
	
	@FindBy(xpath="//ul[@id='css3menu1']/li[3]/ul/li[16]/a")
	public static WebElement Textbook;
	
	public Super_Admin_HomePage mouseoveronadmin() throws Exception{
		fn_MouseOver(DriverObj, adminmenu);
		Thread.sleep(3000);
		Super_Admin_HomePage superadminhomepage=PageFactory.initElements(DriverObj, Super_Admin_HomePage.class);
		return superadminhomepage;
	}
	public Manage_School_PageClass clickonschool() throws Exception{
		fn_mouseOverClick(DriverObj, adminmenu, school);
		Thread.sleep(2000);
		Manage_School_PageClass creaeschoolpageobj=	PageFactory.initElements(DriverObj, Manage_School_PageClass.class);
		return creaeschoolpageobj;
	}
	public Cron_pageclass clickoncron() throws Exception{
		fn_mouseOverClick(DriverObj, adminmenu, cron);
		Thread.sleep(2000);
		Cron_pageclass cronpageobj=PageFactory.initElements(DriverObj, Cron_pageclass.class);
		return cronpageobj;
	}
	public Subject_level_Mapping_PageClass clickonsubjectlevelmapping() throws Exception{
		fn_mouseOverClick(DriverObj, adminmenu, subjectlevelmapping);
		Thread.sleep(2000);
		Subject_level_Mapping_PageClass subjectlevelmappingobj=PageFactory.initElements(DriverObj, Subject_level_Mapping_PageClass.class);
		return subjectlevelmappingobj;
	}
	public AssignClasstoSchool_PageClass clickonassignclasstoschool() throws Exception{
		fn_mouseOverClick(DriverObj, adminmenu, assignclasstoschol);
		Thread.sleep(2000);
	AssignClasstoSchool_PageClass	assignclasstoschoolpageobj=	PageFactory.initElements(DriverObj, AssignClasstoSchool_PageClass.class);
	return assignclasstoschoolpageobj;
		}
	
	
}
