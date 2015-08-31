package com.appmodule.GenericMetod;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Generic_Methods {
	
	public static boolean NoSuchElementException = false;
	public static  WebDriver driver;
	public static String ff;
	public static String CH;
	public static WebElement element;
	
public static  void fn_launchbrowser(WebDriver driver,String browsername,String URL){
	
	if(browsername.equalsIgnoreCase("ff")){
         driver =new FirefoxDriver();
		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}else if(browsername.equalsIgnoreCase("CH")){
		System.setProperty("driver.chrome", "C:\\Users\\kuldeepy\\Desktop\\sco\\sco\\driver\\chromedriver");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}else if(browsername.equalsIgnoreCase("IE")){
		System.setProperty("driver.InternetExplorer", "C:\\Users\\kuldeepy\\Desktop\\sco\\sco\\driver\\IEDriverServer");
	driver=new InternetExplorerDriver();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	}
public static void fn_clickonlement(WebElement element) throws InterruptedException{
	try{
		element.click();
	}catch(Exception e){
		Thread.sleep(2000);
		element.click();
		
	}	
}
public static void fn_mouseoveronelementtoelementandclick(WebDriver driver,WebElement element) throws InterruptedException{
	
Actions action=	new Actions(driver);
action.moveToElement(element).build().perform();
action.moveToElement(element).moveToElement(element).click().build().perform();
if(NoSuchElementException==true)
try{
	Thread.sleep(3000);
	action.moveToElement(element).build();
	action.moveToElement(element).moveToElement(element).build().perform();
	}catch(Exception e){
     Thread.sleep(5000);
     action.moveToElement(element).build();
     Thread.sleep(3000);
 	action.moveToElement(element).moveToElement(element).perform();
	}
	}
public static void fn_mouseoverandclcik(WebDriver driver,WebElement element) throws InterruptedException{
Actions action=	new Actions(driver);
action.moveToElement(element).click().build().perform();
try{
	Thread.sleep(2000);
	action.moveToElement(element).click().build().perform();
}catch(Exception e){
	Thread.sleep(3000);
	action.moveToElement(element).click().build().perform();
}
}
public static void fn_sendkey(WebElement element,String senddata){
	element.sendKeys(senddata);
}
public static void fn_selectmethod(WebElement driver,WebElement element,String text,String value,int index) throws InterruptedException{
Select select=new Select(driver);
select.selectByVisibleText(text);
try{
	Thread.sleep(2000);
select.selectByValue(value);
}catch(Exception e){
	Thread.sleep(3000);
	select.selectByIndex(index);
	}
}
public static void fn_tekescreenshot() throws IOException{
	try{
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  DateFormat dateFormat = new SimpleDateFormat("HH_mm_ssa yyyy-MM-dd");
	  Calendar cal = Calendar.getInstance();
	  FileUtils.copyFile(scrFile, new File("C:\\Users\\kuldeepy\\Desktop\\sco\\sco\\screenshot\\"+dateFormat.format(cal.getTime())+".png"));   
	} catch (IOException e) {
          e.printStackTrace();
          }
   
}
 public static void fn_alertaccept() throws InterruptedException{
	Alert alert=driver.switchTo().alert();
	Thread.sleep(2000);
     alert.getText();
     alert.accept();
	}
 public static void fn_dismissalert() throws InterruptedException{
   Alert alert=driver.switchTo().alert();
   Thread.sleep(2000);
   alert.getText();
   alert.dismiss();
}

}








