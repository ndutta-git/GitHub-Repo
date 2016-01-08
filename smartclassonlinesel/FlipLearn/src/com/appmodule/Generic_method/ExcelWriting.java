package com.appmodule.Generic_method;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWriting {
	public static String ResultFilePath="";


	@SuppressWarnings("resource")
	public static String fn_CreateResultSheet( String[] ArrColumns) throws IOException{
		String TS=fn_GetTimeStamp();
	
		String filePath_TS="DataSheets/ResultWorkbook"+TS+".xlsx";
		FileOutputStream FOS=new FileOutputStream(filePath_TS);

		Workbook wbookObj=new XSSFWorkbook();
		//////////////////////////////////////////////////////////
		CellStyle styleObj=wbookObj.createCellStyle();
		short colornumber=IndexedColors.YELLOW.getIndex();
		short fillnumber=CellStyle.SOLID_FOREGROUND;
		styleObj.setFillForegroundColor(colornumber);
		styleObj.setFillPattern(fillnumber);
		////////////////////////////////////////////////
		Font fontObj=wbookObj.createFont();
		short boldno=Font.BOLDWEIGHT_BOLD;
		fontObj.setBoldweight(boldno);
		fontObj.setItalic(true);
		fontObj.setFontHeightInPoints((short) 14);
		styleObj.setFont(fontObj);
		////////////////////////////////////////
		Sheet sheetObj=wbookObj.createSheet("ResultSheet");
		Row rowObj=sheetObj.createRow(0);
		int count=ArrColumns.length;
		for(int i=0; i<=count-1;i++){
			Cell cellObj=rowObj.createCell(i);
			String ColmName=ArrColumns[i];
			cellObj.setCellValue(ColmName);
			cellObj.setCellStyle(styleObj);
			
			sheetObj.autoSizeColumn(i);
		}
		
		wbookObj.write(FOS);
		
		return filePath_TS;
	}
	

	
	public static void fn_WriteResultToExcel(String[] arrResultToWrite) throws IOException, InvalidFormatException{
		File fileObj=new File(ResultFilePath);
		if(fileObj.exists()==false){
			String[] colmArr={"ModuleName",	"SubModuleName"," TestCaseName","ObjectName","ExpectedValue","ActualValue","Status","Snapshot"};
            ResultFilePath=fn_CreateResultSheet(colmArr);
		}
		
		fn_AppendResult(arrResultToWrite);
		
	}
	
	public static void fn_AppendResult(String[] valTOWrite) throws IOException, InvalidFormatException{
		FileInputStream fis=new FileInputStream(ResultFilePath);
		Workbook wbookObj=WorkbookFactory.create(fis);
		Sheet sheetObj=wbookObj.getSheet("ResultSheet");
		int rowcnt=sheetObj.getLastRowNum();
		rowcnt=rowcnt+1;
		////////////////////////
		CellStyle styleObj=wbookObj.createCellStyle();
		short colornumber=IndexedColors.RED.getIndex();
		short fillnumber=CellStyle.SOLID_FOREGROUND;
		styleObj.setFillForegroundColor(colornumber);
		styleObj.setFillPattern(fillnumber);
		//////////////
		Row rowObj=sheetObj.createRow(rowcnt);
		for(int i=0; i<=valTOWrite.length-1;i++){
			if(valTOWrite[6].equalsIgnoreCase("Failed")){
				 Cell cellObj=rowObj.createCell(i);
				     if(i==7){
				    	    cellObj.setCellFormula("HYPERLINK("+'"'+valTOWrite[7]+'"'+","+'"'+"Snapshot"+'"'+")");                                  //// HYPERLINK("","Snapshot")
				     }else{
							cellObj.setCellValue(valTOWrite[i]); 
				     }
				     cellObj.setCellStyle(styleObj); 	
						
			}else{
				Cell cellObj=rowObj.createCell(i);
				cellObj.setCellValue(valTOWrite[i]);
			}
			
		}
		
		FileOutputStream FOS=new FileOutputStream(ResultFilePath);
		wbookObj.write(FOS);
	}
	
	
	public static String fn_GetTimeStamp(){
		String TS=DateFormat.getDateTimeInstance().format(new Date());
		TS=TS.replaceAll(":", "_");
		return TS;
	}
}
