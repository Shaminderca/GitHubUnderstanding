package com.qa.Automation.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.Automation.base.TestBase;



public class ExcelUtility extends TestBase {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String xSheet) {
		int rowCount;
		try {
			fi = new FileInputStream(xFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ws = wb.getSheet(xSheet);

		rowCount = ws.getLastRowNum();

		return rowCount;

	}

	public static int getCellCount(String xFile, String xSheet, int rowCount) {
		int colCount;
		try {
			fi = new FileInputStream(xFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rowCount);
		
		colCount = row.getLastCellNum();

		return colCount;

	}

	public static String getCellData(String xFile, String xSheet, int rowCount, int colCount) {
		String data;
		try {
			fi = new FileInputStream(xFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rowCount);
		cell = row.getCell(colCount);
		data = cell.getStringCellValue();

		return data;

	}
	

}
