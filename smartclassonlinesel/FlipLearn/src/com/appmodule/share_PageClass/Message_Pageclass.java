package com.appmodule.share_PageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.appmodule.Generic_method.Generic_class;

public class Message_Pageclass extends Generic_class{

	@FindBy(xpath="//h3[text()='Messages']")
	public static WebElement messageheaderlogo;
	
	@FindBy(css="a[href='/index.php/messages']")
	public static WebElement Message_link;
	
	@FindBy(css="select[id^='AYID']")
	public static WebElement Year_selector;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-block']")
	public static WebElement New_message_button;

	@FindBy(css="button[title='Refresh inbox']")
	public static WebElement refresh_button;
	
	@FindBy(css="button[name='delete']")
	public static WebElement Delete_button;
	
	@FindBy(css="a[href='/index.php/messages/index?f=today']")
	public static WebElement TodayMessagedisplay_button;
	
	@FindBy(xpath="//*[contains(text(), 'All')]")
	public static WebElement AllMessagedisplay_button;
	
	@FindBy(xpath="//*[contains(text(), 'Sent')]")
	public static WebElement SentMessagedisplay_button;
	
/**********************************************Create_message_Page*****************************************/
	
	@FindBy(css="button[id^='send_msg']")
	public static WebElement Send_Button;
	
	@FindBy(xpath="//a[@class='discard btn']")
	public static WebElement discard_button;
	
	@FindBy(xpath="//a[@class='fancyboxAB btn btn-primary right']")
	public static WebElement select_recipient_button;
	
	@FindBy(id="Messages_msg_subject")
	public static WebElement Message_subject_textbox;
	
	@FindBy(className="qq-upload-button")
	public static WebElement fileUpload_buttton;
	
	@FindBy(id="Messages_send_email")
	public static WebElement send_email_checkbox;
	
	@FindBy(id="tinymce")
	public static WebElement messageDiscripitionTextbox;
/***************************************************Teacher_Messge_AddressBook********************************/

	
	@FindBy(id="my-groups")
	public static WebElement My_GroupSelectbox;
	
	@FindBy(id="address_book_search")
	public static WebElement AddresbookSearchBox;
	
	@FindBy(xpath="//form[@id='address-book-form']/div[2]/div/div/div/h4/a")
	public static WebElement AddAll_Button;
	
	@FindBy(xpath="//form[@id='address-book-form']/div[3]/div/div/div/h4/a")
	public static WebElement ClearAll_button;
	
	
	
/******************************************Methods_on_Element*************************************************/	
	
	
	public static void verifyMessageLogo(){
		Assert.assertNotNull(messageheaderlogo);
		
	}
	
	public static void clickOn_Message(){
		fn_SimpleClick(Message_link);
	}
	
	public static void Select_Year(String Value){
		fn_SimpleClick(Year_selector);
		Select select=	new Select(Year_selector);
		select.selectByValue(Value);
	}
	
	public static void ClickOnMessageCreate(){
		fn_SimpleClick(New_message_button);
	}
	
	public static void ClickOnRefresh_button(){
		fn_SimpleClick(refresh_button);
	}
	
	public static void ClickOnDeleteButton(){
		fn_SimpleClick(Delete_button);
	}
	
	public static void ClickOnToday(){
		fn_SimpleClick(TodayMessagedisplay_button);
	}
	
	public static void ClickOnAll(){
		fn_SimpleClick(AllMessagedisplay_button);
	}
	
	public static void ClickOnSentButton(){
		fn_SimpleClick(SentMessagedisplay_button);
	}
	
	public static void ClickOnSendButton(){
		fn_SimpleClick(Send_Button);
	}
	
	public static void ClickOnDiscardButton(){
		fn_SimpleClick(discard_button);
	}
	
	public static void SelectRecipientButton(){
		fn_SimpleClick(select_recipient_button);
	}
	
	public static void FillSubjectTextBox(String MessageSubject){
		Message_subject_textbox.sendKeys(MessageSubject);
	}
	
	public static void ClickOnFileUploadButton(){
		fn_SimpleClick(fileUpload_buttton);
	}
	
	public static void ClickOnSendEmailCheckBox(){
		fn_SimpleClick(send_email_checkbox);
	}
	
	public static void SendtextInDiscriptionTextBox(String MessageDiscription){
		DriverObj.switchTo().frame(DriverObj.findElement(By.id("Messages_msg_body_ifr")));
		messageDiscripitionTextbox.sendKeys(MessageDiscription);
	}
	
	public static void TL_SelectMyGroup(String MyGroupRecipient){
		DriverObj.switchTo().frame(DriverObj.findElement(By.id("fancybox-frame1460719823305")));
		Select select= new Select(My_GroupSelectbox);
		select.selectByValue(MyGroupRecipient);
	}
	
	public static void TL_SearchTextBox(String Searchvalue){
		DriverObj.switchTo().frame(DriverObj.findElement(By.id("fancybox-frame1460719823305")));
		AddresbookSearchBox.sendKeys(Searchvalue);
	}
	
	public static void TL_SelectContact(String SelectContact){
		WebElement Contactlist=DriverObj.findElement(By.xpath("//div[@id='searched_content']"));
		List<WebElement> contactlist=Contactlist.findElements(By.xpath("//div[@id='searched_content']/span"));
		int contactSize=contactlist.size();
		for(int i=0;i<=contactSize;i++){
			String ContactText=contactlist.get(i).getText();
			Assert.assertEquals(ContactText, SelectContact);
			contactlist.get(i).click();
		}
	}
	
	public static void ClickOnAddAllButton(){
		fn_SimpleClick(AddAll_Button);
	}
	
	public static void ClickOnClearAllButton(){
		fn_SimpleClick(ClearAll_button);
	}
}
