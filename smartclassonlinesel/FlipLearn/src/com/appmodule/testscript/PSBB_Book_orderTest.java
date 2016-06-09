package com.appmodule.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appmodule.Generic_method.Generic_class;

public class PSBB_Book_orderTest extends Generic_class {

	public static void main(String [] args) throws InvalidFormatException, IOException, InterruptedException{
		openPSBBMURL();
		Fill_form();
		
		DriverObj.close();
		DriverObj.quit();
	}

	@SuppressWarnings("static-access")
	public static void openPSBBMURL() throws IOException, InvalidFormatException{
		TestDataPath="C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/TestData/LoginData/PSBB_shcool_data.xlsx";
		TestDataSheetName="Sheet1";
		System.setProperty("webdriver.chrome.driver", "C:/Users/ykuld_000/Desktop/robotium/Flash/Driver/chromedriver.exe");
		DriverObj=new ChromeDriver();
		DriverObj.get("http://apptesting.fliplearn.com/psbbMbooks");
		DriverObj.manage().window().maximize();
		DriverObj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    fn_FetchExcelData(1);
	     DriverObj.findElement(By.xpath("//h1[contains(text(), 'PSBB Millennium Group of Schools')]"));
	     fn_GetPageLoadTime(NavigationObj.DriverObj.findElement(By.xpath("//h1[contains(text(), 'PSBB Millennium Group of Schools')]")));
	     
	}
	
	public static void Fill_form() throws IOException, InterruptedException{
		FileInputStream file = new FileInputStream(new File("C:/Users/ykuld_000/Desktop/smartclassonlinesel/FlipLearn/TestData/LoginData/PSBB_shcool_data.xlsx"));
       XSSFWorkbook workbook = new XSSFWorkbook(file);
               XSSFSheet sheet = workbook.getSheetAt(0);
         Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            /*Row row = */ rowIterator.next();
		WebElement mySelectElm = DriverObj.findElement(By.id("TmsSchools_school_name")); 
		Select mySelect= new Select(mySelectElm);
		mySelect.selectByValue("8");
		WebElement classselect=DriverObj.findElement(By.id("SchoolClass_class_name"));
		
			Select classselect1= new Select(classselect);
			classselect1.selectByValue("1");
		   WebElement booklist=DriverObj.findElement(By.xpath("//div[@class='booklist col-md-12']"));
		   DriverObj.findElement(By.xpath("//div[@class='booklist col-md-12']/div/div/div/div/span/button")).click();
			WebElement S_First_name=DriverObj.findElement(By.id("TempRegistration_firstname"));
			fn_Inputexcel(S_First_name, "First_name");
			WebElement S_last_name=DriverObj.findElement(By.id("TempRegistration_lastname"));
			fn_Inputexcel(S_last_name, "S_last_name");
			WebElement P_firsst_name=DriverObj.findElement(By.id("TempRegistration_parent_first_name"));
			fn_Inputexcel(P_firsst_name, "P_first_name");
			WebElement P_last_name=DriverObj.findElement(By.id("TempRegistration_parent_last_name"));
			fn_Inputexcel(P_last_name, "P_last_name");
			WebElement Email=DriverObj.findElement(By.id("TempRegistration_email"));
			fn_Inputexcel(Email, "Email");
			WebElement Mobile_no=DriverObj.findElement(By.id("TempRegistration_phone"));
			fn_Inputexcel(Mobile_no, "Mobile_no");
			WebElement Door_flat=DriverObj.findElement(By.id("TempRegistration_door_flat_no"));
			fn_Inputexcel(Door_flat, "Door_flat");
			WebElement Block_apartment=DriverObj.findElement(By.id("TempRegistration_block_apartment_name"));
			fn_Inputexcel(Block_apartment, "Block_Apartment_name");
			WebElement Street_name=DriverObj.findElement(By.id("TempRegistration_street_road"));
			fn_Inputexcel(Street_name, "Street_name");
			WebElement locality=DriverObj.findElement(By.id("TempRegistration_locality"));
			fn_Inputexcel(locality, "Locality");
			WebElement Postal_code=DriverObj.findElement(By.id("TempRegistration_zipcode"));
			fn_Inputexcel(Postal_code, "Postal_code");
			DriverObj.findElement(By.xpath("//div[@class='col-md-12 text-left']/p")).click();
			Thread.sleep(5000);
			DriverObj.findElement(By.xpath("//div[@class='col-md-12 text-left']/p/label")).click();
			Thread.sleep(5000);
			DriverObj.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(5000);
			DriverObj.findElement(By.xpath("//div[@class='modal-dialog']/div/div[3]/button")).click();
			Thread.sleep(10000);
			pay_tm_page();
			
			
		//}
	//	}
		
		
	}
	}
    	      
	public static void pay_tm_page(){
		DriverObj.findElement(By.id("cn1")).sendKeys("5242540301740660");
		WebElement date_exp=DriverObj.findElement(By.id("ccExpMonth"));
		Select date_exp1= new Select(date_exp);
		date_exp1.selectByValue("08");
		WebElement date_exp_year=DriverObj.findElement(By.id("ccExpYear"));
		Select date_exp_year1= new Select(date_exp_year);
		date_exp_year1.selectByValue("2020");
		DriverObj.findElement(By.id("dcCvvBox")).sendKeys("498");
		DriverObj.findElement(By.id("dcSubmit")).click();
	}
}
