package com.appmodule.testscript;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;
import com.appmodule.share_PageClass.Share_PageClass;
import com.jacob.com.LibraryLoader;

public class Fileupload extends Generic_class{

	static String jvmBitVersion(){
		 return System.getProperty("sun.arch.data.model");
		}
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws Exception {
			
		String jacobDllVersionToUse;
			if (jvmBitVersion().contains("32")){
			jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
			}
			else {
			jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
			}

			File file = new File("lib", jacobDllVersionToUse);
			System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
	
		HomePage_PagecClass homepageobj =fn_OpenApp("CH", "http://www.fliplearn.com");
		Loginpage_Pageclass loginpageobj=homepageobj.clickonloginbutton();
		Thread.sleep(1000);
/*	fn_FetchExcelData1("TestData/LoginData/loginDATA.xlsx","Login_ID");
	//	int i;
		int loginid=AL.size();
		for(i=0;i<loginid;i++){
			System.out.println(AL.get(i));*/
			DriverObj.findElement(By.id("LoginForm_username")).clear();
		//DriverObj.findElement((By.id("LoginForm_username"))).sendKeys(AL.get(i));
		DriverObj.findElement((By.id("LoginForm_username"))).sendKeys("test.admin");
		DriverObj.findElement(By.id("LoginForm_password")).clear();
		DriverObj.findElement((By.id("LoginForm_password"))).sendKeys("1234567");
		DriverObj.findElement(By.name("yt0")).click();
		Thread.sleep(3000);
		Share_PageClass.clickonwall();
		Thread.sleep(3000);
		WebElement iframe=DriverObj.findElement(By.id("post_body_ifr"));
		DriverObj.switchTo().frame(iframe);
		DriverObj.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("Upload file Wall post");
		DriverObj.findElement(By.xpath("//input[@title='Post']")).click();
		
		
		
		
	}
	public static void MessageFileUpload() throws IOException, Exception{
		Share_PageClass.clickonmessage();
		Thread.sleep(3000);
		String Messagetext=fn_GetText(DriverObj.findElement(By.xpath("//form[@id='sentMsg-form']//div/h3")));
		Assert.assertEquals(Messagetext, "Messages");
		DriverObj.findElement(By.xpath("//a[contains(text(),'New Message')]")).click();
		DriverObj.findElement(By.xpath("//a[contains(text(),'Select Recipients')]")).click();
		Thread.sleep(3000);
		DriverObj.switchTo().frame(DriverObj.findElement(By.id("fancybox-frame1464923755147")));
		
	}
	
}
