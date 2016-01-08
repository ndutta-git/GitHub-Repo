package com.appmodule.testscript;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.appmodule.Generic_method.Generic_class;
import com.appmodule.homepageclass.HomePage_PagecClass;
import com.appmodule.homepageclass.Loginpage_Pageclass;

public class ForgetPassword extends Generic_class{

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) throws Exception, IOException {
//		TestDataPath="TestData/ForgetID/ID.xlsx";
//		TestDataSheetName="ForgetID";
		// TODO Auto-generated method stub
		try{
			 
			HomePage_PagecClass homepageobj=fn_OpenApp("CH", "http://www.fliplearn.com");
			Loginpage_Pageclass loginpageobj=homepageobj.clickonloginbutton();
			Thread.sleep(1000);
			fn_FetchExcelData1("TestData/ForgetID/ID2.xlsx","ForgetID");
			  int j;
			     int size = AL.size();
			        for(j=0;j<size;j++)
			        {
			            System.out.println(AL.get(j));
			DriverObj.findElement(By.xpath("//a[@href='/site/forgotpassword']")).click();
			Thread.sleep(1000);
			DriverObj.findElement(By.xpath("//a[@class='accordion-toggle collapsed']")).click();
			WebElement username=DriverObj.findElement(By.id("uname"));
			//fn_Inputexcel(username, "ForgetID");
		   // System.out.println(itr.next());
		      username.sendKeys(AL.get(j));
		     
		    DriverObj.findElement(By.xpath("//button[@class='btn btn-info']")).click();
			Thread.sleep(1000);
			 DriverObj.findElement(By.id("usercontact")).click();
			DriverObj.findElement(By.id("submitForm")).click();
			Thread.sleep(2000);
			DriverObj.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
			ArrayList<String> tabs=new ArrayList<String>(DriverObj.getWindowHandles());
			DriverObj.switchTo().window(tabs.get(1));
			DriverObj.get("http://www.gmail.com");
				DriverObj.findElement(By.id("gmail-sign-in")).click();
				DriverObj.findElement(By.id("Email")).sendKeys("seleniumt34@gmail.com");
				DriverObj.findElement(By.id("next")).click();
				DriverObj.findElement(By.id("Passwd")).sendKeys("automation");
				DriverObj.findElement(By.id("signIn")).click();
				Thread.sleep(2000);
			WebElement tableelement=DriverObj.findElement(By.xpath("//div[@class='Cp']/div/table//tbody"));
		    java.util.List<WebElement> tableelement1=tableelement.findElements(By.xpath("//div[@class='Cp']/div/table//tbody/tr"));
	        int	tableelementsize=tableelement1.size();
	        int i;
	        if(tableelementsize>0){
	        	//DriverObj.navigate().refresh();
	        	for(i=0;i<tableelementsize;i++){
	        		DriverObj.findElement(By.xpath("//div[@class='Cp']/div/table//tbody/tr/td[6]")).click();
	        	}
	        
	        }else {
	        	 if(tableelementsize==0){
	 	        	DriverObj.navigate().refresh();
	 	        	for(i=0;i<tableelementsize;i++){
	 	        		DriverObj.findElement(By.xpath("//div[@class='Cp']/div/table//tbody/tr/td[6]")).click();
	 	        	}
	 	        }
			}
	        String otp=	DriverObj.findElement(By.xpath("//td/div/div/p")).getText();
            String[]  Parts=otp.split("- ");
            String part1=Parts[0];
            String part2=Parts[1];
            System.out.println(part1);
            System.out.println(part2);
			Thread.sleep(1000);
			DriverObj.findElement(By.xpath("//div[@id=':5']/div[2]/div/div/div[2]/div[3]/div")).click();
			DriverObj.findElement(By.xpath("//a[@class='gb_b gb_Ra gb_R gb_Na']")).click();
			Thread.sleep(1000);
			DriverObj.findElement(By.id("gb_71")).click();
			DriverObj.switchTo().window(tabs.get(1));
			DriverObj.manage().deleteAllCookies();
			DriverObj.close();
			Thread.sleep(1000);
			DriverObj.switchTo().window(tabs.get(0));
			DriverObj.findElement(By.id("current_params")).sendKeys(part2);
			DriverObj.findElement(By.id("submitForm")).click();
			DriverObj.findElement(By.id("new_pass")).sendKeys("123456");
		   DriverObj.findElement(By.id("confirm_new_pass")).sendKeys("123456");
		   Thread.sleep(1000);
		   DriverObj.findElement(By.xpath("//button[contains(text(), 'Update')]")).click();
		   DriverObj.findElement(By.xpath("//a[@href='/index.php/site/login']")).click();
		   Loginpage_Pageclass loginpageobj1=PageFactory.initElements(DriverObj, Loginpage_Pageclass.class);
		   //fn_Inputexcel(loginpageobj1.username, "ForgetID");
		   loginpageobj1.username.sendKeys(AL.get(j));
		   loginpageobj1.password.sendKeys("123456");
		   loginpageobj1.loginbutton.click();
		   NavigationObj.fn_logout();
		  // DriverObj.close();
		     }
		}catch(Exception e){
			e.printStackTrace();
			fn_TakeSnapshot();
		}
		
	}
	

}
