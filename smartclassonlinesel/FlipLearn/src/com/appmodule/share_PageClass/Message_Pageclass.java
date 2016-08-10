package com.appmodule.share_PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.Generic_method.Log;

public class Message_Pageclass extends Generic_class{
	
	public static String message_subject="New message using selenium webdriver"; 
	public static  String message_discription="New message using selenium webdriver"; 
	public static String Filename="4-Nature-Wallpapers-2014-1.jpg";
	
	
	@FindBy(xpath="//h3[text()='Messages']")
	public static WebElement messageheaderlogo;
	
	@FindBy(xpath="//a[contains(text(),'New Message')]")
	public static WebElement new_message_button;
	
	@FindBy(id="send_msg")
	public static WebElement send_button;
	
	@FindBy(xpath="//a[@class='discard btn']")
	public static WebElement discard_button;
	
	
	@FindBy(xpath="//div[@class='form-row row-fluid']/div/div/a")
	public static WebElement select_recipients_button;
	
	@FindBy(xpath="//input[@id='Messages_msg_subject']")
	public static WebElement subject_input;
	
	@FindBy(id="Messages_msg_body_ifr")
	public static WebElement message_discription_iframe;
	
	@FindBy(css="input[type=file]")
	public static WebElement Upload_button;
	
	@FindBy(id="uniform-Messages_send_email")
	public static WebElement Send_email_checkbox;
	
	@FindBy(id="Messages_send_sms")
	public static WebElement send_sms_checkbox;
	
	@FindBy(id="Messages_smstxt")
	public static WebElement SMS_description_textbox;
	
	@FindBy(xpath="//*[@id='tinymce']/p")
	public static WebElement message_description_textbox;
	
	@FindBy(xpath="//iframe[@src='/index.php/AddressBook/index']")
	public static WebElement select_recipient_iframe;
	
	@FindBy(xpath="//div[@id='searched_content']/span")
	public static WebElement recipient_button;
	
	@FindBy(xpath="//div[@id='searched_content']/span")
	public static WebElement recipient_class;
	
	@FindBy(xpath="//a[@class='btn right address_btn btn']")
	public static WebElement done_button;
	
	@FindBy(xpath="//a[@class='fancybox-item fancybox-close']")
	public static WebElement close_button;
	
	
	@FindBy(xpath="//div[@class='content']/div[3]/a")
	public static WebElement sent_button;
	
	@FindBy(xpath="//div[@id='menutour']//li/a[text()='Share']")
	public static WebElement share_menu;
	
	@FindBy(xpath="//a[@href='/index.php/messages']/span")
	public static WebElement Message_Text;
	
	@FindBy(xpath="//a[@href='/index.php/messages']")
	public static WebElement message_link;
	
/**
 * @throws Exception *****************************************************************************************************************/ 
	
    public static void createMessage() throws Exception{
    	try{
    		fn_SimpleClick(new_message_button);
    		WebDriverWait wait= new WebDriverWait(DriverObj, 30);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='span3']/h3")));
    		fn_SimpleClick(select_recipients_button);
    		Thread.sleep(2000);
    		DriverObj.switchTo().frame(select_recipient_iframe);
    		WebDriverWait wait1= new WebDriverWait(DriverObj, 30);
    		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='span11']")));
    		fn_SimpleClick(recipient_class);
    		fn_SimpleClick(done_button);
    		DriverObj.switchTo().defaultContent();
    		fn_Input(subject_input, message_subject);
    		JavascriptExecutor jse=(JavascriptExecutor)DriverObj;
    		jse.executeScript("window.scrollBy(0,250)", "", "");
    		fn_SimpleClick(Upload_button);
    		Thread.sleep(2000);
    		fn_Upload_HandleAutoIT(Filename, "CH");
    		Log.info("Attached file is successfully uploaded");
    		fn_SimpleClick(send_button);
    		Thread.sleep(2000);
    		try{   
 			   DriverObj.switchTo().alert().accept();
 			  }catch(Exception e){ 
 			   System.out.println("unexpected alert not present");   
 			  }
    	}catch(Exception e){
    		e.printStackTrace();
    	     fn_TakeSnapshot();
    	}
    }
}
