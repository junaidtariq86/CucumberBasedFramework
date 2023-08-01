package org.smallworld.automation.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

public class ExcelDriven_XLSX {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;

//Get Cell data in String from Excel File
	public static String getCelldata( String excelFileName,String Sheet_name ,int rownum,int col) throws IOException
	{
		String File_Path= "src/" + excelFileName + ".xlsx";
	fis =new FileInputStream(File_Path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(Sheet_name);
	row=sheet.getRow(rownum);
	cell=row.getCell(col);
	fis.close();
	return cell.getStringCellValue();
	}
//Get Cell Date in String from Excel File
	public static Date getCelldata_date( String excelFileName,String Sheet_name ,int rownum,int col) throws IOException
	{
		String File_Path= "data/" + excelFileName + ".xlsx";
	fis =new FileInputStream(File_Path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(Sheet_name);
	row=sheet.getRow(rownum);
	cell=row.getCell(col);
	fis.close();
	return cell.getDateCellValue();
	}


//Get Cell "Number" in String from Excel File
	public static double getCelldata_num( String File_Path,String Sheet_name ,int rownum,int col) throws IOException
	{
	fis =new FileInputStream(File_Path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(Sheet_name);
	row=sheet.getRow(rownum);
	cell=row.getCell(col);
	fis.close();
	return cell.getNumericCellValue();
	}
//Set Cell data in from Excel File
	public static String setCelldata(String File_Path,String Sheet_name ,String result,int rownum,int col) throws IOException
	{

	fis =new FileInputStream(File_Path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(Sheet_name);
	row=sheet.getRow(rownum);
	cell=row.getCell(col);
	cell.setCellValue(result);
	fis.close();
	FileOutputStream outputStream = new FileOutputStream(File_Path);
	wb.write(outputStream);
	outputStream.close();

	return cell.getStringCellValue();

	}
//Get size of rows in sheet form Excel File
	public static int sheet_size(String excelFileName,String Sheet_name) throws IOException
	{
		//InputStream excelFileTestdata = new FileInputStream("src/" + excelFileName + ".xlsx");
		String File_Path= "data/" + excelFileName + ".xlsx";
		fis =new FileInputStream(File_Path);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(Sheet_name);
		int last = ExcelDriven_XLSX.sheet.getLastRowNum();
		int first = ExcelDriven_XLSX.sheet.getFirstRowNum();
	    int rowCount = last - first;
	    return (rowCount);
	}
	//Get size of col in sheet form Excel File
	public static int sheet_col(String excelFileName,String Sheet_name) throws IOException
	{
		//InputStream excelFileTestdata = new FileInputStream("src/" + excelFileName + ".xlsx");
		String File_Path= "data/" + excelFileName + ".xlsx";
		fis =new FileInputStream(File_Path);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(Sheet_name);
		XSSFRow row = null;
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("Column Count :- " + colCount);
		return (colCount-1);
	}
//Get The Data against specific Row	
	public static HashMap<String, String> readExcelData(String excelFileName, String sheetName, String rowToMatch)
			throws IOException {


		InputStream excelFileTestdata = new FileInputStream("src/test/resources/testdata/" + excelFileName + ".xlsx");

		// Create the XSSF workbook and sheet object
		XSSFWorkbook workbook = new XSSFWorkbook(excelFileTestdata);
		XSSFSheet currentSheet = workbook.getSheet(sheetName);

		// Get the Last ROW and Column number
		XSSFRow titleRow = currentSheet.getRow(0);
		int lastCol = titleRow.getLastCellNum();
		int lastRow = currentSheet.getLastRowNum();

		Object[][] Testdata2DArray = new Object[1][2];
		HashMap<String, String> rowTestdataHashMap = new HashMap<String, String>();

		int rowTestdata = 0;
		for (int row = 1; row <= lastRow; row++) {
			if (currentSheet.getRow(row).getCell(0) == null) {
				rowTestdata = 10000;
			} else if (currentSheet.getRow(row).getCell(0).toString().equals(rowToMatch)) {
				rowTestdata = row;
			}
		}

		XSSFRow currentRow = currentSheet.getRow(rowTestdata);
		Cell firstCell = currentRow.getCell(0);

		for (int col = 0; col < lastCol - 1; col++) {

			if (currentRow.getCell(col + 1) == null) {
				rowTestdataHashMap.put(titleRow.getCell(col + 1).getStringCellValue(), "null");
			} else {
				rowTestdataHashMap.put(titleRow.getCell(col + 1).getStringCellValue(),
						currentRow.getCell(col + 1).getStringCellValue());
			}
		}

		Testdata2DArray[0][0] = firstCell.getStringCellValue();
		Testdata2DArray[0][1] = rowTestdataHashMap.clone();

		workbook.close();
		excelFileTestdata.close();
		return rowTestdataHashMap;
	}
	}



