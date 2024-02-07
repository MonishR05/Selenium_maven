package org.automation.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility 
{	
	//Generic Method
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(frameWorkConstants.properties_path);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(frameWorkConstants.excel_Path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(cellNum).toString();
		
	}
	
	public static Object[][] fetchingMultipledata(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		
		
		int lastRowNum = sh.getPhysicalNumberOfRows();
		int lastCellNum = sh.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr = new Object[lastRowNum - 1][lastCellNum];
		
		for(int i =1;i<lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				arr[i-1][j]=sh.getRow(i).getCell(j).toString();
			}
		}
		return arr;
	}
}

