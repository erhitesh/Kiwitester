package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.session.DriverSession;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtility {

	Utility comnUtil = new Utility();

	public static ExcelUtility getInstance() {
		return new ExcelUtility();
	}

	public void fetchTestCaseData(int rowNumber) throws Exception {
		HashMap<String, String> rowData = new HashMap<String, String>();
		String Server = GlobalParam.SERVER_NAME;
		Server = Server.toUpperCase() + "_TestData";
//		System.out.println("Server " + Server);
//		System.out.println("Excel " + DriverSession.getTestExcelPath());
		rowData = Utility.getXlsxSheetData(DriverSession.getTestExcelPath(), Server, rowNumber);
		DriverSession.setTestCaseData(rowData);
	}

	public List<String> getLineData(String sheetLocation, String cellValue) {
		List<String> sheetData = new ArrayList<>();
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheetAt(0);
			int cellNumber = 0;
			if (cellValue.equalsIgnoreCase("Quantity"))
				cellNumber = 0;
			else if (cellValue.equalsIgnoreCase("Product"))
				cellNumber = 1;
			else if (cellValue.equalsIgnoreCase("Template"))
				cellNumber = 2;
			else if (cellValue.equalsIgnoreCase("Line1"))
				cellNumber = 3;
			else if (cellValue.equalsIgnoreCase("Line2"))
				cellNumber = 4;
			else if (cellValue.equalsIgnoreCase("Line3"))
				cellNumber = 5;
			else if (cellValue.equalsIgnoreCase("Line4"))
				cellNumber = 6;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				sheetData.add(sheet.getRow(i).getCell(cellNumber).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sheetData;
	}

	public List<String> getSheetData(String sheetLocation, String cellValue) {
		List<String> sheetData = new ArrayList<>();
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		int cellNumber = 0;
		try {
			workBook = new XSSFWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workBook.getSheetAt(0);
			if (cellValue.equalsIgnoreCase("DoctorFirstName"))
				cellNumber = 0;
			else if (cellValue.equalsIgnoreCase("DoctorLastName"))
				cellNumber = 1;
			else if (cellValue.equalsIgnoreCase("PracticeName"))
				cellNumber = 2;
			else if (cellValue.equalsIgnoreCase("PhoneNumber"))
				cellNumber = 3;
			else if (cellValue.equalsIgnoreCase("AddressLine1"))
				cellNumber = 4;
			else if (cellValue.equalsIgnoreCase("AddressLine2"))
				cellNumber = 5;
			else if (cellValue.equalsIgnoreCase("DoctorCity"))
				cellNumber = 6;
			else if (cellValue.equalsIgnoreCase("DoctorZipCode"))
				cellNumber = 7;
			for (int j = 1; j < sheet.getLastRowNum(); j++) {
				/*
				 * Cell cell = sheet.getRow(j).getCell(cellNumber); CellType cellType =
				 * sheet.getRow(j).getCell(cellNumber).getCellType(); if (cellType ==
				 * CellType.STRING) {
				 * sheetData.add(sheet.getRow(j).getCell(cellNumber).getStringCellValue()); }
				 * else if (cellType == CellType.BOOLEAN) {
				 * sheetData.add(sheet.getRow(j).getCell(cellNumber).getBooleanCellValue()); }
				 * else if (cellType == CellType.NUMERIC) {
				 * sheetData.add(sheet.getRow(j).getCell(cellNumber).getNumericCellValue()); }
				 */

				sheetData.add(sheet.getRow(j).getCell(cellNumber).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sheetData;
	}

	public XSSFWorkbook openWorkbook(String xlFilePath) throws Exception {
		return new XSSFWorkbook(new File(xlFilePath));
	}

	public XSSFSheet getSheetHandel(XSSFWorkbook workbook, String sheetName) throws Exception {
		return workbook.getSheet(sheetName);
	}

	public XSSFSheet getSheetHandel(XSSFWorkbook workbook, int sheetIndex) throws Exception {
		return workbook.getSheetAt(sheetIndex);
	}

	public HashMap<String, String> fetchRowData(XSSFSheet sheet, int rowNumber) {
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			rowData.put(sheet.getRow(0).getCell(i).toString().trim(),
					sheet.getRow(rowNumber).getCell(i).toString().trim());
		}
		return rowData;
	}

	public HashMap<String, String> fetchRow_TestData(XSSFSheet sheet, int rowNumber) {
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 2; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			rowData.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNumber).getCell(i).toString());
		}
		return rowData;
	}

	public void closeWorkbook(XSSFWorkbook workbook) throws Exception {
		workbook.close();
	}

	public int returnColumnPosition(String headerName, XSSFSheet sheet) {
		int columnCount = -1;
		int totalColumn = 0;
		String header = "";

		totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
//		System.out.println(totalColumn + " " + totalColumn);
		for (int i = 0; i < totalColumn; i++) {
			Cell cell = sheet.getRow(0).getCell(i);
			header = cell.getStringCellValue().trim();
			if (header.equalsIgnoreCase(headerName)) {
				columnCount = i;
				break;
			}
		}
		return columnCount;
	}

	public int returnRowPosition(String rowHeaderName, XSSFSheet sheet) {
		int rowCount = -1;
		int totalRows = 0;
		String header = "";

		totalRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < totalRows; i++) {
			Cell cell = sheet.getRow(i).getCell(0);
			header = cell.getStringCellValue().trim();

			if (header.equalsIgnoreCase(rowHeaderName)) {
				rowCount = i;
				break;
			}
		}

		return rowCount;
	}

	public String getCellValueByCollumHeader(String colHeader, int rowNum, int sheetNumber) throws Exception {
		String value = "";
		int colNumber;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			workbook = openWorkbook(DriverSession.getTestExcelPath());
			sheet = getSheetHandel(workbook, sheetNumber);
			colNumber = returnColumnPosition(colHeader, sheet);
			Cell cell = sheet.getRow(rowNum).getCell(colNumber);
			value = cell.getStringCellValue().trim();
		}

		catch (Exception E) {
		} finally {
			if (workbook != null) {
				closeWorkbook(workbook);
			}
		}
		return value;
	}

	public String getCellValueByCollumAndRowHeader(String colHeader, String rowHeader, int sheetNumber)
			throws Exception {
		String value = "";
		int colNumber;
		int rowNumber;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			workbook = openWorkbook(DriverSession.getTestExcelPath());

			sheet = getSheetHandel(workbook, sheetNumber);
			colNumber = returnColumnPosition(colHeader, sheet);
			rowNumber = returnRowPosition(rowHeader, sheet);
			Cell cell = sheet.getRow(rowNumber).getCell(colNumber);
			value = cell.getStringCellValue().trim();
		} catch (Exception E) {
		} finally {
			if (workbook != null) {
				closeWorkbook(workbook);
			}
		}
		return value;
	}

	public List<String> getInfoRelatedSheet() {
		List<String> info = new ArrayList<>();
		info.add("Fname");
		info.add("Lname");
		info.add("Relation");
		info.add("Dob");
		info.add("Email");

		return info;
	}

	public HashMap<Integer, List<String>> familyMemberData(/* String cellValue, */String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try {
			workbook = openWorkbook(sheetLocation);
			sheet = getSheetHandel(workbook, 0);
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				List<String> info = new ArrayList<>();
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
					info.add(sheet.getRow(i).getCell(j).toString());
				}
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap<Integer, List<String>> familyMemberData(String headerName, String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try {
			workbook = openWorkbook(sheetLocation);
			sheet = getSheetHandel(workbook, 0);
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				List<String> info = new ArrayList<>();
				int cellValueIndex = returnColumnPosition(headerName, sheet);
				info.add(sheet.getRow(i).getCell(cellValueIndex).toString());
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap<Integer, List<String>> testCaseDataSheet(String sheetLocation, int columnIndex) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try {
			workbook = openWorkbook(sheetLocation);
			sheet = getSheetHandel(workbook, 0);
			System.out.println("Sheet Name " + sheet);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				List<String> info = new ArrayList<>();
				info.add(sheet.getRow(i).getCell(columnIndex).toString());
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * public void insertValueIntoSheet(int rowIndex, int columnIndex, String
	 * sheetLocation, String Status) { WritableWorkbook workbook; WritableSheet
	 * sheet; try { workbook = Workbook.createWorkbook(new File(sheetLocation));
	 * sheet = workbook.createSheet("Sheet 1", 0); Label label = new
	 * Label(columnIndex, rowIndex, Status); sheet.addCell(label); workbook.write();
	 * workbook.close(); } catch (Exception e) { e.printStackTrace(); } }
	 */

	public static void main(String args[]) throws Exception {
		ExcelUtility eu = new ExcelUtility();
		String sheetLocation = System.getProperty("user.dir") + File.separator + "TestRepository" + File.separator
				+ "BWellFiles" + File.separator + "TC_AddFamilyMember.xlsx";
//		HashMap<Integer, List<String>> data = eu.testCaseDataSheet(sheetLocation, 4);
//		for (Map.Entry<Integer, List<String>> ll : data.entrySet()) {
//			System.out.println(ll.getValue());
//		}
		
		XSSFSheet sheet = new XSSFWorkbook(sheetLocation).getSheetAt(0);
		String cellValue = "URL";
//		System.out.println(eu.getSheetData(sheetLocation, cellValue));
//		System.out.println(eu.fetchRow_TestData(sheet, 1));
//		System.out.println(eu.returnColumnPosition("URL", sheet));
//		System.out.println(eu.returnRowPosition("https://google.com", sheet));
//		System.out.println(eu.getCellValueByCollumHeader("URL", 2, 0, sheetLocation));
//		System.out.println(eu.getCellValueByCollumAndRowHeader("Relation", "https://google.com", 0));
	}
}
