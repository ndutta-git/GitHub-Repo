package com.appmodule.Generic_method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;













import com.appmodule.commannevigation.CommanNevigation_Pageclass;
import com.appmodule.homepageclass.HomePage_PagecClass;


public class Generic_class {
	
	public  static String ArrValToWrite;
	public  static String ResultAr;
	public static  String TestDataPath;
	public static  String TestDataSheetName;
	protected static String ResultFolder;
	public static String Login_Role;
	public static String TestCaseName;
	public static String Username;
	public static String User_Role;
	public static String Main_Manu_Item;
	public static String Main_SubMainu_Item;
	public static String Page_Load_time;
	public static String Sub_Manu_Item;
	public static String ResultSheetPath;
	public static  WebDriver DriverObj;
	public static  CommanNevigation_Pageclass NavigationObj;
	@SuppressWarnings("rawtypes")
	public static HashMap testData_HM=new HashMap();
	public static ArrayList<String> AL=new ArrayList<String>();
	
	public  static WebDriver fn_LaunchBrowser(String BrowserName, String URL){
	
		if(BrowserName.equalsIgnoreCase("FF")==true){
			FirefoxProfile profile = new FirefoxProfile(); 
			profile.setPreference("browser.download.dir", "Files/Download"); 
			profile.setPreference("browser.download.folderList", 2);
			DriverObj= new FirefoxDriver(profile);
			
		}else if(BrowserName.equalsIgnoreCase("CH")==true){
			System.setProperty("webdriver.chrome.driver", "Browser_Drivers/chromedriver.exe");
			DriverObj= new ChromeDriver();	
		}else if(BrowserName.equalsIgnoreCase("IE")==true){
			System.setProperty("webdriver.ie.driver", "Browser_Drivers/IEDriverServer.exe");
			DriverObj= new InternetExplorerDriver();
		}else {
			Reporter.log("Your Browser name is incorrect");
		}
		fn_Url(DriverObj, URL );
		DriverObj.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		DriverObj.manage().window().maximize();
        return DriverObj;
		
	}
	public static HomePage_PagecClass fn_OpenApp(String BrowserName, String URL ){
		fn_LaunchBrowser(BrowserName, URL);
		HomePage_PagecClass LoginClassObj=PageFactory.initElements(DriverObj, HomePage_PagecClass.class);
		NavigationObj=PageFactory.initElements(DriverObj, CommanNevigation_Pageclass.class);
		return LoginClassObj;
	}
public static void fn_Url(WebDriver DriverObj, String URL ){
		DriverObj.get(URL);
	}
public static void fn_Input(WebElement inputbox,String inputvalue){
	inputbox.clear();
	inputbox.sendKeys(inputvalue);
	
}
public  static void fn_Inputexcel(WebElement ElementInput, String InputValue){
	String InputVal=(String) testData_HM.get(InputValue);
	System.out.println(InputVal);
	ElementInput.sendKeys(InputVal);
}
	
	
public static void fn_SimpleClick(WebElement ElementToClick ){
		
			try{
				ElementToClick.click();
			Thread.sleep(2000);
			}catch(Exception e){
			  DriverObj.navigate().refresh();
				ElementToClick.click();
			}
			try{
				DriverObj.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	
			}catch(Exception e){
				
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
public static void fn_Select(WebElement webelementname){
		boolean Status=webelementname.isSelected();
		if(Status==false){
			webelementname.click();
		}else{
			System.out.println("Allready Selected");
		}
	}
public static void fn_MouseOver(WebDriver DriverObj, WebElement webelementname){
		Actions Actobj=new Actions(DriverObj);
		Actobj.moveToElement(webelementname).build().perform();
	}
	
public static void fn_mouseOverClick(WebDriver DriverObj,WebElement Elementtomove, WebElement ElementToClick){
		
			 try{
				new Actions(DriverObj).moveToElement(Elementtomove).click(ElementToClick).build().perform();
			     
				}catch(Exception e){
					DriverObj.navigate().refresh();
					ElementToClick.click();
					
				}
				try{
					DriverObj.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					
				}catch(Exception e){
					
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
public static void fn_DoubleMouseOverClick(WebDriver DriverObj, WebElement FirstElementToMousrOver,WebElement SecondElementToClick,WebElement ElementToClick) throws Exception{
	
	try{
		new Actions(DriverObj).moveToElement(FirstElementToMousrOver).moveToElement(SecondElementToClick).click(ElementToClick).build().perform();
	}catch(Exception e){
		DriverObj.navigate().refresh();
		Thread.sleep(2000);
		new Actions(DriverObj).moveToElement(FirstElementToMousrOver).moveToElement(SecondElementToClick).click().build().perform();
	}
	try{
		DriverObj.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}catch(Exception e){
		
	}
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	
	@SuppressWarnings("unused")
	public  static void verifyVisible(WebElement WebObj,String ObjName) throws IOException, InvalidFormatException{
		try{
			
		
		boolean ActualStatus=false;
		try{
			 ActualStatus=WebObj.isDisplayed();
		}catch(Exception e){	
		}
		String PageName=DriverObj.getTitle();
		   String ExpectedValues="Visible";
		   if(ActualStatus==true){
		    	Reporter.log("Display Verification Passed. "+ObjName+ "is Displaying at "+PageName);
		    	   String ActualValues="Visible";
				   String[] ResultArr=fn_CreateArray(ActualValues,"Passed");
				  // fn_WriteResultToExcel(ResultArr);
		    }else{
		    	String msg="Display Verification Failed. "+ObjName+ "is not Displaying at "+PageName;
		    	String ActualValues="Not Visible";
				String[] ResultArr=fn_CreateArray(ActualValues,"Failed");
				//fn_WriteResultToExcel(ResultArr);
		    	Assert.assertTrue(false);
		    	
		    }
			}catch(Throwable t){
			t.getMessage();
		}
		}
	
	@SuppressWarnings("unused")
	public static void verifybutton(WebElement buttonobj,String objname){
		try{
			boolean Actualstatus=false;
			try{
			Actualstatus=buttonobj.isEnabled();
			}catch(Exception e){
				
			}
		String buttontxt=buttonobj.getText();
		String Expectedvalue="Enabled";
		if(Actualstatus==true){
			Reporter.log("Enabled verification passed. "+objname+ "is Enabled at "+buttontxt);
			String Actualvalue="Enabled";
	       String[] resultArr=fn_CreateArray( Actualvalue,"working");
	      // fn_WriteResultToExcel(resultArr);
		}else{
			String message="Enabled verification is failed. "+objname+ "is Enabled at "+buttontxt;
			String Actualvalue="Not Enabled";
	        String[] resultarr=fn_CreateArray(Actualvalue, "Failed");
	       // fn_WriteResultToExcel(resultarr);
	        Assert.assertTrue(false);
		}
		}catch(Throwable t){
			t.getMessage();
		}
	}
	public  static void fn_SelectWithText(WebElement FoundElement, String SelectionValue){
		List<WebElement> ListItemColl=FoundElement.findElements(By.xpath("//option"));
		for(int i=0; i<=ListItemColl.size()-1; i++){
			String  ItemText=ListItemColl.get(i).getText();
			if(ItemText.trim().equalsIgnoreCase(SelectionValue.trim())){
				new Select(FoundElement).selectByIndex(i);
				break;
			}
			}
	}
	 public static void fn_WriteResultToExcel(String[] Arr_ResultToWrite) throws IOException, InvalidFormatException{
 		
		   File ResultFileObj=new File(ResultSheetPath);
		   if(ResultFileObj.exists()==false || ResultSheetPath.contains(Login_Role)==false){
			   fn_CreateAndFormatExcel();
		   	}
		   fn_UpdateExcelResults(Arr_ResultToWrite);
	     }
	 public static String[] fn_CreateArray(String ActualText,String Status) throws IOException{
			String PageTitle="";
			try{
				PageTitle=DriverObj.getTitle();
			}catch(Exception e){	
			} 
			 if (Status=="Failed"){
				 String snapshotPath=fn_TakeSnapshot();
				 String[] ReportExcelArr={Username,Login_Role,Main_Manu_Item,Main_SubMainu_Item,Sub_Manu_Item,Page_Load_time,PageTitle,ActualText,Status, snapshotPath};
				 return ReportExcelArr;
			 }else{
				 String[] ReportExcelArr={Username,Login_Role,Main_Manu_Item,Main_SubMainu_Item,Sub_Manu_Item,Page_Load_time,PageTitle,ActualText,Status};	 
				 return ReportExcelArr;
			 }
	 }
			 public static void fn_CreateAndFormatExcel() throws IOException{
		     		XSSFWorkbook WbookObj=new XSSFWorkbook();
		     		XSSFSheet WsheetObj=WbookObj.createSheet("Result_Sheet");
		     		XSSFRow FstRowObj=WsheetObj.createRow(0);
		     		String[] ColmnArr={"Username","Login_Role", "Main_Menu_Item","Main_SubMainu_Item","Sub_Manu_Item","Page_Load_time","PageTitle","Actual_URL", "Status", "SnapshotLink" };
		     		for(int i=0; i<=ColmnArr.length-1; i++){
		     			XSSFCell CellObj=FstRowObj.createCell(i);
		     			CellObj.setCellValue(ColmnArr[i]);
		     			short colorindex=IndexedColors.YELLOW.getIndex();
		     			short fontheight=13;
		     			CellStyle StyleObj=fn_SetCellStyle(WbookObj, colorindex,fontheight);
		     			CellObj.setCellStyle(StyleObj);
		     			WsheetObj.autoSizeColumn(i);
		     		}
		     		String ResultFileName=Login_Role+"_Execution_Results";
		     		  Date DTE=new Date();
		     		 DateFormat DF=DateFormat.getDateTimeInstance();
		     	String DateVal=DF.format(DTE);
		     	DateVal=DateVal.replaceAll(":", "_");
		     	    ResultFolder=ResultFolder+"/"+fn_GetLatestFolderName(ResultFolder);
		     	    ResultSheetPath=ResultFolder+"/"+ResultFileName+".xlsx";
		     		FileOutputStream FOS=new FileOutputStream(ResultSheetPath);
		     		WbookObj.write(FOS);
		     		FOS.close();
		     		
		     	}
			 public static void fn_UpdateExcelResults(String[] ArrValToWrite) throws IOException, InvalidFormatException{
		     		FileInputStream FIS=new FileInputStream(ResultSheetPath);
		     		Workbook WbookObj=WorkbookFactory.create(FIS);
		     		Sheet WSheetObj=WbookObj.getSheet("Result_Sheet");
		     		int lastrownum=WSheetObj.getLastRowNum();
		     		int required_row=lastrownum+1;
		     		Row RowObj=WSheetObj.createRow(required_row);
		     		
		     		for(int i=0; i<=ArrValToWrite.length-1; i++){
		     			Cell CellObj=RowObj.createCell(i);
		     				if(ArrValToWrite[8].equalsIgnoreCase("Failed")){
		     						CellStyle FailStyleObj=fn_SetCellStyle(WbookObj, IndexedColors.RED.getIndex(), (short)11);
		     					    CellObj.setCellStyle(FailStyleObj);
		     				}
		     				if(i<9){
		     					CellObj.setCellValue(ArrValToWrite[i]);		
		     				}else{
		     					CellObj.setCellFormula("HYPERLINK("+'"'+ArrValToWrite[8]+'"'+", "+'"'+"Snapshot"+'"'+")");
		     				}
		     				
		     		}
		     		FileOutputStream FOS=new FileOutputStream(ResultSheetPath);
		     		WbookObj.write(FOS);
		     		FOS.close();
		     	}
		

	 public  static void verifyUrl(String ExpColumnName, int rowNumber) throws IOException, InvalidFormatException{
         String ActualURL=DriverObj.getCurrentUrl();
         String ExpectedValue=(String) testData_HM.get(ExpColumnName);
     
         if(ActualURL.contains(ExpectedValue)){
       	  Reporter.log("URL Verification Passed. Expected URL="+ExpectedValue+" Actual URL-"+ActualURL);
       		String[] ResultArr=fn_CreateArray(ActualURL,"Working");
           fn_WriteResultToExcel(ResultArr);
       		//System.out.println(ResultArr);
         }else{
       		String[] ResultArr=fn_CreateArray(ActualURL,"Failed");
           	fn_WriteResultToExcel(ResultArr);
       		System.out.println(ResultArr);
             Assert.assertTrue(ResultAr, false);
         }

	 }
	 public static void fn_javaScriptClick(WebElement Element){
			JavascriptExecutor executor = (JavascriptExecutor)DriverObj;
			executor.executeScript("arguments[0].click();", Element);
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			
		}
	 }
	 public  static void fn_OpenURL(String URL){
			DriverObj.get(URL);
		        
			}
	 public  static void verifyText(WebElement WebObj,String ObjName,String ExpColumnName, int rowNumber) throws IOException, InvalidFormatException{
			
		    String ActualText="";
		    try{
		    	ActualText=WebObj.getText();
			}catch(Exception e){	
			} 
		    String ExpectedText=(String) testData_HM.get(ExpColumnName);
		    if(ActualText.equalsIgnoreCase(ExpectedText)){
		    	Reporter.log("Text Validation Passed. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
		    	String[] ResultArr=fn_CreateArray(ActualText,"Passed");
		    	fn_WriteResultToExcel(ResultArr);
		    	System.out.println(ResultArr);
		    }else{
		    	@SuppressWarnings("unused")
				String msg="Text Validation Failed. Expected Text="+ExpectedText+" Actual Text-"+ActualText;
		    	String[] ResultArr=fn_CreateArray(ActualText,"Failed");
		    	//fn_WriteResultToExcel(ResultArr);
		    	System.out.println(ResultArr);
		    	 Assert.assertTrue(false);
			}
		}
	 public  static String fn_GetText(WebElement WebObj) throws IOException, InvalidFormatException{
		    String ActualText="";
			try{
			    ActualText=WebObj.getText();
			}catch(Exception e){	
			}  if(ActualText==null){
				//String[] textresult=fn_CreateArray("Text Not Found","Pass");
				//fn_WriteResultToExcel(textresult);
			}else{
		//String[] textresult=fn_CreateArray(ActualText,"Working");
		//fn_WriteResultToExcel(textresult);
			}
		return ActualText;
	 }
	 public static String fn_TakeSnapshot() throws IOException{
 		TakesScreenshot TSS=(TakesScreenshot)DriverObj;
 		File srcfileObj=TSS.getScreenshotAs(OutputType.FILE);
 		//ResultFolder=ResultFolder+"/"+",;"
 		//ResultSnapshotPath=ResultSnapshotPath+"/"+fn_GetLatestFolderName(ResultSnapshotPath);
 		String snapshotpath=ResultFolder+"/snapshots/"+"Image_"+fn_GetTimeStamp()+".jpg";
 		String snapshotForXL="snapshots/"+"Image_"+fn_GetTimeStamp()+".jpg";
 		File destfileObj=new File(snapshotpath);
 		FileUtils.copyFile(srcfileObj, destfileObj);
 		return snapshotForXL;
 	}
	 public static String fn_GetTimeStamp(){
			SimpleDateFormat SDF=new SimpleDateFormat("dd-mm-yyyy hh_ss_mm");
			String TS=SDF.format(new Date());
			return TS;
}
	 
	 public static Font fn_SetFontStyle(Workbook WbookObj,short fontheight ){
  		
  		Font FontObj=WbookObj.createFont();
  		FontObj.setFontHeightInPoints(fontheight);
  		FontObj.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
  		return FontObj;
  		
  	}
	 
	 @SuppressWarnings("static-access")
		public static CellStyle fn_SetCellStyle(Workbook WbookObj,short cell_color_index, short FontHeight){
  		
  		CellStyle CellStyleObj=WbookObj.createCellStyle();
  		CellStyleObj.setFillForegroundColor(cell_color_index);
  		short fillPatern_index=CellStyleObj.SOLID_FOREGROUND;
  		CellStyleObj.setFillPattern(fillPatern_index);
  		Font FontObj=fn_SetFontStyle(WbookObj, FontHeight);
  		CellStyleObj.setFont(FontObj);
  		return CellStyleObj;
  	}
	 
	 public static String fn_GetLatestFolderName(String ParentDirectory){
  		File fileobj=new File(ParentDirectory);
  		File[] files = fileobj.listFiles();
  		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
  		String fileName=files[0].getName();
  		return fileName;
  	}
	 
	 public  static void verifyTextExistance(WebElement WebObj,String ObjName,String ExpectedText) throws IOException, InvalidFormatException{
			
			String ActualText="";
			 try{
				ActualText=WebObj.getText().trim().toUpperCase();
				}catch(Exception e){	
				} 
		    if(ActualText.indexOf(ExpectedText.trim().toUpperCase())>-1){
		    	Reporter.log("Passed. Expected Text Exist in Actual Text. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
		    	String[] ResultArr=fn_CreateArray(ActualText,"Passed");
				fn_WriteResultToExcel(ResultArr);
		    }else{

		    	String msg="Failed. Expected Text doesn't Exist in Actual Text. Expected Text="+ExpectedText+" Actual Text-"+ActualText;
		    	String[] ResultArr=fn_CreateArray(ActualText,"Failed");
				fn_WriteResultToExcel(ResultArr);
		    	Assert.assertTrue(msg,false);
			}
	 
	 }
	 public  static void verifyTextExistance(String ActualText,String ExpectedText) throws IOException, InvalidFormatException{
		    if(ActualText.indexOf(ExpectedText)>-1){
		    	Reporter.log("Passed. Expected Text Exist in Actual Text. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
		    	String[] ResultArr=fn_CreateArray(ActualText,"Passed");
				fn_WriteResultToExcel(ResultArr);
		    }else{
		    	String msg="Failed. Expected Text doesn't Exist in Actual Text. Expected Text="+ExpectedText+" Actual Text-"+ActualText;
		    	String[] ResultArr=fn_CreateArray(ActualText,"Failed");
				fn_WriteResultToExcel(ResultArr);
		    	Assert.assertTrue(msg,false);
			}
		    
		}
	 
	 public static Workbook fn_GetWorkbook(String FilePath) throws FileNotFoundException, IOException{
  	   String extension=FilePath.split("\\.")[1].trim();
  	   Workbook wBookObj=null;
  	   if(extension.equalsIgnoreCase("xls")==true){
  		    wBookObj= new HSSFWorkbook(new FileInputStream(FilePath)); 
  	   }else if(extension.equalsIgnoreCase("xlsx")==true){
  		   wBookObj= new XSSFWorkbook(new FileInputStream(FilePath));
  	   }
  	   return wBookObj;
     }
	 
	  @SuppressWarnings("unused")
		public static ArrayList<String> fn_FetchExcelData(String FilePath,String ColumnName) throws IOException{
      	   String WbookPath=FilePath;
      	      Workbook WBookObj=fn_GetWorkbook(FilePath);
      	      Sheet SheetObj=WBookObj.getSheetAt(0);
      	      Row FstRowObj=SheetObj.getRow(0);
      	      int cellCount=FstRowObj.getLastCellNum();
      	      int columnNumber=0;
      	      ArrayList<String> AL=new ArrayList<String>();
      	      for(int j=0; j<cellCount;j++){
      	    	  if(FstRowObj.getCell(j, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim().equalsIgnoreCase(ColumnName)){
      	    		  columnNumber=j;
      	    		  break;
      	    	  }
      	      }
      	      int rowcnt=SheetObj.getLastRowNum();
      	         for(int i=1;i<=rowcnt;i++){
      	    	  Cell fstcellObj=SheetObj.getRow(i).getCell(columnNumber, Row.CREATE_NULL_AS_BLANK);
      	    	  String ColumnVal=fstcellObj.getStringCellValue();
      	    	  AL.add(ColumnVal);
      	           
      	         }
      	   return AL;   
      	  }
	  @SuppressWarnings({ "unchecked", "static-access" })
		public static void fn_FetchExcelData(int row_num) throws IOException{
      	   String WbookPath=TestDataPath;
      	   String SheetName=TestDataSheetName; 
      	   File FileObj=new File(WbookPath);
      	      FileInputStream FIS=new FileInputStream(FileObj);
      	      @SuppressWarnings("resource")
			Workbook WBookObj=new XSSFWorkbook(FIS);
      	      Sheet SheetObj=WBookObj.getSheet(SheetName);
      	      Row FstRowObj=SheetObj.getRow(0);
      	      int cellCount=FstRowObj.getLastCellNum();
      	      Row RowObj=SheetObj.getRow(row_num);
      	      for(int i=0;i<=cellCount-1;i++){
      	    	  Cell fstcellObj=FstRowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
      	    	  String ColumnName=fstcellObj.getStringCellValue();
      	    	  Cell reqCellObj=RowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
      	    	  String reqRowCellValue=null;
      	    	  if(reqCellObj.getCellType()==Cell.CELL_TYPE_STRING){
      	    	   reqRowCellValue=reqCellObj.getStringCellValue();
      	       }else if(reqCellObj.getCellType()==Cell.CELL_TYPE_NUMERIC){
      	    	   Double dblColumnName=reqCellObj.getNumericCellValue();
      	    	  Integer intColumnName =dblColumnName.intValue();
      	    	  reqRowCellValue=intColumnName.toString(intColumnName);
      	       }
      	      
      	          if(ColumnName.trim().equalsIgnoreCase("")==false && ColumnName!=null){
      	           testData_HM.put(ColumnName,reqRowCellValue); 
      	          }
      	           
      	      }
      	  }
	  @SuppressWarnings("unused")
		public static void fn_FetchExcelData1(String FilePath,String ColumnName) throws IOException{
    	   String WbookPath=FilePath;
    	      Workbook WBookObj=fn_GetWorkbook(FilePath);
    	      Sheet SheetObj=WBookObj.getSheetAt(0);
    	      Row FstRowObj=SheetObj.getRow(0);
    	      int cellCount=FstRowObj.getLastCellNum();
    	      int columnNumber=0;
    	      //ArrayList<String> AL=new ArrayList<String>();
    	      for(int j=0; j<cellCount;j++){
    	    	  if(FstRowObj.getCell(j, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim().equalsIgnoreCase(ColumnName)){
    	    		  columnNumber=j;
    	    		  break;
    	    	  }
    	      }
    	      int rowcnt=SheetObj.getLastRowNum();
    	         for(int i=1;i<=rowcnt;i++){
    	    	  Cell fstcellObj=SheetObj.getRow(i).getCell(columnNumber, Row.CREATE_NULL_AS_BLANK);
    	    	  String ColumnVal=fstcellObj.getStringCellValue();
    	    	  AL.add(ColumnVal);
    	           
    	         }
    	   //return AL;   
    	  }
	  public  static void fn_Upload_HandleAutoIT(String fileName) throws Exception{
			if(Login_Role.equalsIgnoreCase("FF")){
				File ExeFilePath= new File("autoit\\FF_FileAutoIT\\Upload_Dialog_FF.exe");
				String ExePath=ExeFilePath.getAbsolutePath();
				File file = new File("Files\\Upload\\"+fileName);
				String filePath=file.getAbsolutePath();
			    String[] DialagText={ExePath,filePath};
				Process process = Runtime.getRuntime().exec(DialagText);
				process.waitFor();
			}else if(Login_Role.equalsIgnoreCase("CH")){
				File ExeFilePath= new File("autoit\\CH_FileAutoIT\\Upload_Dialog_CH.exe");
				String ExePath=ExeFilePath.getAbsolutePath();
				File file = new File("Files\\Upload\\"+fileName);
				String filePath=file.getAbsolutePath();
			    String[] DialagText={ExePath,filePath};
				Process process = Runtime.getRuntime().exec(DialagText);
				process.waitFor();
			}else if(Login_Role.equalsIgnoreCase("IE")){
				File ExeFilePath= new File("autoit\\IE_FileAutoIT\\Upload_Dialog_IE.exe");
				String ExePath=ExeFilePath.getAbsolutePath();
				File file = new File("Files\\Upload\\"+fileName);
				String filePath=file.getAbsolutePath();
			    String[] DialagText={ExePath,"Choose File to Upload", "Open", filePath};
				Process process = Runtime.getRuntime().exec(DialagText);
				process.waitFor();
		  }
		}
	  
	  public  static void fn_Export_HandleAutoIT(String fileName) throws Exception{ ///Method for autoIT
			if(Login_Role.equalsIgnoreCase("FF")){
				File file = new File("Files\\Download\\"+fileName);
				String filePath=file.getAbsolutePath();
				File ExeFilePath= new File("autoit\\FF_FileAutoIT\\Save_Dialog_FF.exe");
				String ExePath=ExeFilePath.getAbsolutePath();
			    String[] DialagText={ExePath,"Opening", "OK", filePath};
			    Thread.sleep(2000);
				Process process = Runtime.getRuntime().exec(DialagText);
				process.waitFor();
			}else if(Login_Role.equalsIgnoreCase("CH")){
//				File file = new File("Files\\Download\\"+fileName);
//				String filePath=file.getAbsolutePath();
//				File ExeFilePath= new File("autoit\\CH_FileAutoIT\\Save_Dialog_CH.exe");
//				String ExePath=ExeFilePath.getAbsolutePath();
//			    String[] DialagText={ExePath,"Opening DemodOnDemand", "OK", filePath};
//				Process process = Runtime.getRuntime().exec(DialagText);
//				process.waitFor();
			}else if(Login_Role.equalsIgnoreCase("IE")){
				File file = new File("Files\\Download\\"+fileName);
				String filePath=file.getAbsolutePath();
				File ExeFilePath= new File("autoit\\IE_FileAutoIT\\Save_Dialog_IE.exe");
				String ExePath=ExeFilePath.getAbsolutePath();
			    String[] DialagText={ExePath,filePath};
			    Thread.sleep(2000);
				Process process = Runtime.getRuntime().exec(DialagText);
				process.waitFor();
			}
			
		}		
	 public static void fn_GetPageLoadTime(WebElement elementtocheck){
		 long startTime = System.currentTimeMillis(); 
		 while(((System.currentTimeMillis())-startTime)<60){  
	         if(elementtocheck.isDisplayed()){  
	  long endTime = System.currentTimeMillis();  
	 // System.out.println("Start time is " +startTime+ " The end Time is " +endTime);
	  long loadTimemilisecond = endTime - startTime;  
	  Page_Load_time=("Totaltime: " +loadTimemilisecond+ " MS");
	//System.out.println("Totaltime: " +loadTimemilisecond+ " MS");   
	break;  
	  }    
	   }       
	     }  
	 }

