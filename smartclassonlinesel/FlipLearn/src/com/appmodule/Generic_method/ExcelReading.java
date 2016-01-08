package com.appmodule.Generic_method;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReading extends ExcelWriting{
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static String WorkbookPath;
	public static String WorksheetName;
	public static HashMap<String, String> HMapObj;
	public static ArrayList<String> AL=new ArrayList<String>();
	
	public static int fn_GetRowCount(String workBookPath, String sheetName) throws IOException{
		Workbook wbookObj=fn_GetWorkBook(workBookPath);
		Sheet sheetObj=wbookObj.getSheet(sheetName);
		int rowcnt=sheetObj.getLastRowNum();
         return rowcnt;
	}
	
	public static Workbook fn_GetWorkBook(String filePath) throws IOException{
		String[] arrPath=filePath.split("\\.");
		String extension=arrPath[1];
		FileInputStream fisObj=new FileInputStream(filePath);
		Workbook wbookObj=null;
		if(extension.equalsIgnoreCase("xlsx")){
			 wbookObj=new XSSFWorkbook(fisObj);
		}else if(extension.equalsIgnoreCase("xls")){
			 wbookObj=new HSSFWorkbook(fisObj);
		}
		
		return wbookObj;
	}
	

	

public static int fn_GetColumnNumberByColumnName(Sheet sheetObj, String expColumnName){
	
	Row fstRowObj=sheetObj.getRow(0);
	int columncount=fstRowObj.getLastCellNum();
	int columnNum=0;
	MissingCellPolicy MCP=Row.CREATE_NULL_AS_BLANK;
	for(int i=0; i<=columncount-1;i++){
		Cell cellObj=fstRowObj.getCell(i, MCP);
		String xl_columnname=cellObj.getStringCellValue();
		if(xl_columnname.trim().equalsIgnoreCase(expColumnName)){
			columnNum=i;
			break;
		}
	}
	
	return columnNum;
}




public static void fn_FetchRow(int rownum) throws IOException{
		
	HashMap<String, String> HMObj=new HashMap<String, String>();
		Workbook wbookObj=fn_GetWorkBook(WorkbookPath);
		Sheet sheetObj=wbookObj.getSheet(WorksheetName);
		MissingCellPolicy MCP=Row.CREATE_NULL_AS_BLANK;
		int strnumber=Cell.CELL_TYPE_STRING;
		int intnumber=Cell.CELL_TYPE_NUMERIC;
		int blanknumber=Cell.CELL_TYPE_BLANK;
		
		Row rowObj=sheetObj.getRow(rownum);
		Row fstrowObj=sheetObj.getRow(0);
		
		for(int i=0; i<=rowObj.getLastCellNum()-1;i++){
				Cell cellObj=rowObj.getCell(i, MCP);
				int cellTypeNum=cellObj.getCellType();
				String columnname=fstrowObj.getCell(i, MCP).getStringCellValue();
				String cellval=null;
					   if(cellTypeNum==intnumber){
						  Double cellval1=cellObj.getNumericCellValue(); 
						 Integer cellval2= cellval1.intValue();
						 cellval =cellval2.toString();
					   }else if(cellTypeNum==strnumber){
					      cellval=cellObj.getStringCellValue();
					      
					   }else if(cellTypeNum==blanknumber){
						   cellval="";
					   }
					   HMObj.put(columnname, cellval);	
		}	   
		
		
			 HMapObj=HMObj;
			
	}




public static String fn_FetchData(String workBookPath, String sheetName, int rownum, String ColumnName) throws IOException{
		
		Workbook wbookObj=fn_GetWorkBook(workBookPath);
		Sheet sheetObj=wbookObj.getSheet(sheetName);
		MissingCellPolicy MCP=Row.CREATE_NULL_AS_BLANK;
		int strnumber=Cell.CELL_TYPE_STRING;
		int intnumber=Cell.CELL_TYPE_NUMERIC;
		int blanknumber=Cell.CELL_TYPE_BLANK;
		
		Row rowObj=sheetObj.getRow(rownum);
		int columnNumber=fn_GetColumnNumberByColumnName(sheetObj, ColumnName);
		Cell cellObj=rowObj.getCell(columnNumber, MCP);
		int cellTypeNum=cellObj.getCellType();
		String cellval=null;
			   if(cellTypeNum==intnumber){
				  Double cellval1=cellObj.getNumericCellValue(); 
				 Integer cellval2= cellval1.intValue();
				 cellval =cellval2.toString();
			   }else if(cellTypeNum==strnumber){
			      cellval=cellObj.getStringCellValue();
			      
			   }else if(cellTypeNum==blanknumber){
				   cellval="";
			   }
			   
			   return cellval;
	}
@SuppressWarnings("unused")
public static void fn_FetchExcelData1(String FilePath,String ColumnName) throws IOException{
	   String WbookPath=FilePath;
	      Workbook WBookObj=fn_GetWorkBook(FilePath);
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
         }
     public static void getexceldata(String filepath) throws IOException{
      @SuppressWarnings("unused")
	String workbookpath=filepath;
     Workbook workbookobj=fn_GetWorkBook(filepath);
     Sheet sheetobj= workbookobj.getSheetAt(0);
     Row firtstrowobj=sheetobj.getRow(0);
      int cellcount=firtstrowobj.getLastCellNum();
      int i;
      for(i=0;i<cellcount;i++){
    	 if(firtstrowobj.getCell(i,Row.CREATE_NULL_AS_BLANK).getStringCellValue() != null){
    		 
    	 }
    	  
    	  
      }
     // firtstrowobj.getCell(arg0)
     }


}

