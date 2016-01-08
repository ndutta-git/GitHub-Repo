package com.appmodule.share_PageClass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmodule.Generic_method.Generic_class;

public class Share_PageClass extends Generic_class{

	@FindBy(xpath="//ul[@id='css3menu1']//a[text()='Share']")
	public static WebElement sharemenu;
	
	@FindBy(xpath="//a[@href='/index.php/wallPosts']")
	public static WebElement walllink;
	
	@FindBy(xpath="//a[@href='/index.php/messages']")
	public static WebElement messagelink;
	
	@FindBy(xpath="//a[@href='/index.php/pictureGallery']")
	public static WebElement gallerylink;
	
	@FindBy(xpath="//a[@href='/index.php/events/index']")
	public static WebElement eventlink;
	
	@FindBy(xpath="//a[text()='Announcements']")
	public static WebElement announcements;
	
	@FindBy(xpath="//a[@href='/index.php/user/directory']")
	public static WebElement studentlink;
	
	@FindBy(xpath="//a[@href='/index.php/user/Tdirectory']")
	public static WebElement teacherlink;
	
	
	public  Wall_PageClass clickonwall() throws InterruptedException, IOException, InvalidFormatException{
		Main_Manu_Item=fn_GetText(sharemenu);
		fn_MouseOver(DriverObj, sharemenu);
		Thread.sleep(2000);
		Main_SubMainu_Item=fn_GetText(walllink);
		fn_SimpleClick(walllink);
		Thread.sleep(2000);
		Wall_PageClass wallpageobj=PageFactory.initElements(DriverObj, Wall_PageClass.class);
		return wallpageobj;
	}
    public Message_Pageclass clickonmessage() throws InterruptedException, IOException, InvalidFormatException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj,sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(messagelink);
    	fn_SimpleClick(messagelink);
    	Thread.sleep(2000);
    	Message_Pageclass messageobj=PageFactory.initElements(DriverObj, Message_Pageclass.class);
    	return messageobj;
    }
    public Gallery_PageClass clickongallery() throws InterruptedException, IOException, InvalidFormatException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj, sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(gallerylink);
    	fn_SimpleClick(gallerylink);
    	Thread.sleep(1000);
    	Gallery_PageClass gallerypageobj=PageFactory.initElements(DriverObj, Gallery_PageClass.class);
    	return gallerypageobj;
    }
    public Events_PageClass clickonevent() throws InterruptedException, InvalidFormatException, IOException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj, sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(eventlink);
    	fn_SimpleClick(eventlink);
    	Thread.sleep(2000);
    	Events_PageClass eventpageobj=PageFactory.initElements(DriverObj, Events_PageClass.class);
    	return eventpageobj;
    	
    }
    public Announement_PageClass clickonannouncement() throws InterruptedException, InvalidFormatException, IOException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj, sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(announcements);
    	fn_SimpleClick(announcements);
    	Thread.sleep(2000);
    	Announement_PageClass announcementpageobj=PageFactory.initElements(DriverObj, Announement_PageClass.class);
    	return announcementpageobj;
    }
    public Student_PageClass clickonstudent() throws InterruptedException, InvalidFormatException, IOException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj, sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(studentlink);
    	fn_SimpleClick(studentlink);
    	Thread.sleep(2000);
     	Student_PageClass studentpageobj=PageFactory.initElements(DriverObj, Student_PageClass.class);
     	return studentpageobj;
    }
    public Teacher_PageClass clickonteacher() throws InterruptedException, InvalidFormatException, IOException{
    	Main_Manu_Item=fn_GetText(sharemenu);
    	fn_MouseOver(DriverObj, sharemenu);
    	Thread.sleep(2000);
    	Main_SubMainu_Item=fn_GetText(teacherlink);
    	fn_SimpleClick(teacherlink);
    	Thread.sleep(2000);
    	Teacher_PageClass teacherpageobj=PageFactory.initElements(DriverObj, Teacher_PageClass.class);
    	return teacherpageobj;
    }
}
