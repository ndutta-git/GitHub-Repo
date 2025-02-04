package com.appmodule.share_PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Events_PageClass extends Generic_class{
	
	public static String Event_Title ="Event created by selenium webdriver script at "+fn_GetTimeStamp();
	public static String Upload_file_name ="4-Nature-Wallpapers-2014-1.jpg";

	@FindBy(xpath="//h3[text()='Events']")
	public static WebElement eventtxtlogo;
	
	@FindBy(id="new_event")
	public static WebElement Addevent;
	
	@FindBy(id="Events_title")
	public static WebElement Event_title;
	
	@FindBy(xpath="//div[@class='form-row row-fluid']/div/div/a")
	public static WebElement select_recipient;
	
	@FindBy(xpath="//iframe[@src='/index.php/AddressBook/index']")
	public static WebElement select_recipient_frame;
	

	
	@FindBy(xpath="//div[@id='searched_content']/span")
	public static WebElement recipient_class;
	
	@FindBy(xpath="//a[@class='btn right address_btn btn']")
	public static WebElement done_button;
	
	@FindBy(id="Events_is_all_day")
	public static WebElement All_day_checkbox;
	
	@FindBy(css="a.maximize")
	public static WebElement Addvanced_setting;
	
	@FindBy(css="input[type=file]")
	public static WebElement upload_button;
	
	@FindBy(css="button[type=submit]")
	public static WebElement create_button;
	
	public static void createEvent() throws Exception{
		try{
		fn_SimpleClick(Addevent);
		fn_Input(Event_title, Event_Title);
		fn_SimpleClick(select_recipient);
		Thread.sleep(2000);
		DriverObj.switchTo().frame(select_recipient_frame);
		fn_SimpleClick(recipient_class);
		fn_SimpleClick(done_button);
		DriverObj.switchTo().defaultContent();
		fn_SimpleClick(All_day_checkbox);
		fn_SimpleClick(Addvanced_setting);
		fn_SimpleClick(upload_button);
		Thread.sleep(2000);
		fn_Upload_HandleAutoIT(Upload_file_name, "CH");
		Thread.sleep(2000);
		fn_SimpleClick(create_button);
		try{   
			   DriverObj.switchTo().alert().accept();
			  }catch(Exception e){ 
			   System.out.println("unexpected alert not present");   
			  }
		}catch(Exception e){
			e.printStackTrace();
			fn_takeScreenShotOnFailure();
		}
	}
}
