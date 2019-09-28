package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.session.DriverSession;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtility1 {

	Utility comnUtil = new Utility();

	public static ExcelUtility1 getInstance() {
		return new ExcelUtility1();
	}

	public void fetchTestCaseData(int rowNumber) throws Exception {
		HashMap<String, String> rowData = new HashMap<String, String>();
		String Server = GlobalParam.SERVER_NAME;
		Server = Server.toUpperCase() + "_TestData";
		System.out.println("Server" + Server);
		System.out.println("excel" + DriverSession.getTestExcelPath());
		rowData = Utility.getXlsxSheetData(DriverSession.getTestExcelPath(), Server, rowNumber);
		DriverSession.setTestCaseData(rowData);
	}

	public List<String> getLineData(String sheetLocation, String cellValue) {
		List<String> data = new ArrayList<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			int cellCount = 0;
			if (cellValue.equalsIgnoreCase("Quantity"))
				cellCount = 0;
			else if (cellValue.equalsIgnoreCase("Product"))
				cellCount = 1;
			else if (cellValue.equalsIgnoreCase("Template"))
				cellCount = 2;
			else if (cellValue.equalsIgnoreCase("Line1"))
				cellCount = 3;
			else if (cellValue.equalsIgnoreCase("Line2"))
				cellCount = 4;
			else if (cellValue.equalsIgnoreCase("Line3"))
				cellCount = 5;
			else if (cellValue.equalsIgnoreCase("Line4"))
				cellCount = 6;

			for (int i = 1; i < sheet.getRows(); i++) {
				data.add(sheet.getCell(cellCount, i).getContents());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public List<String> getSheetData(String sheetLocation, String cellValue) {
		List<String> sheetData = new ArrayList<>();
		Workbook workBook;
		Sheet sheet;
		int cellCount = 0;
		try {
			workBook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workBook.getSheet(0);
			if (cellValue.equalsIgnoreCase("DoctorFirstName"))
				cellCount = 0;
			else if (cellValue.equalsIgnoreCase("DoctorLastName"))
				cellCount = 1;
			else if (cellValue.equalsIgnoreCase("PracticeName"))
				cellCount = 2;
			else if (cellValue.equalsIgnoreCase("PhoneNumber"))
				cellCount = 3;
			else if (cellValue.equalsIgnoreCase("AddressLine1"))
				cellCount = 4;
			else if (cellValue.equalsIgnoreCase("AddressLine2"))
				cellCount = 5;
			else if (cellValue.equalsIgnoreCase("DoctorCity"))
				cellCount = 6;
			else if (cellValue.equalsIgnoreCase("DoctorZipCode"))
				cellCount = 7;
			for (int j = 1; j < sheet.getRows(); j++) {
				sheetData.add(sheet.getCell(cellCount, j).getContents());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sheetData;
	}

	public Workbook openWorkbook(String xlFilePath) throws Exception {
		return Workbook.getWorkbook(new File(xlFilePath));
	}

	public Sheet getSheetHandel(Workbook workbook, String sheetName) throws Exception {
		return workbook.getSheet(sheetName);
	}

	public Sheet getSheetHandel(Workbook workbook, int sheetIndex) throws Exception {
		return workbook.getSheet(sheetIndex);
	}

	public HashMap<String, String> fetchRowData(Sheet sheet, int rowNumber) {
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 0; i < sheet.getColumns(); i++) {
			rowData.put(sheet.getCell(i, 0).getContents().trim(), sheet.getCell(i, rowNumber).getContents().trim());
		}
		return rowData;
	}

	public HashMap<String, String> fetchRow_TestData(Sheet sheet, int rowNumber) {
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 2; i < sheet.getColumns(); i++) {
			rowData.put(sheet.getCell(i, 0).getContents(), sheet.getCell(i, rowNumber).getContents());
		}
		return rowData;
	}

	public void closeWorkbook(Workbook workbook) throws Exception {
		workbook.close();
	}

	public HashMap<String, String> getStockDataFromExcel(String excelPath) throws Exception {
		HashMap<String, String> rowData = new HashMap<String, String>();
		Workbook workbook = openWorkbook(excelPath);
		Sheet sheet = getSheetHandel(workbook, 1);
		for (int i = 0; i < sheet.getColumns(); i++) {
			for (int j = 0; j < sheet.getRows(); j++) {
				rowData.put(sheet.getCell(i, j).getContents().trim(), sheet.getCell(i, j).getContents().trim());
			}
		}
		closeWorkbook(workbook);
		return rowData;
	}

	public void fetchTransactionData(int rowNumber) throws Exception {
		HashMap<String, String> rowData = new HashMap<String, String>();
		Workbook workbook = openWorkbook(DriverSession.getTestExcelPath());
		Sheet sheet = getSheetHandel(workbook, 2);
		rowData = fetchRowData(sheet, rowNumber);
		closeWorkbook(workbook);
		GlobalParam.TransactionData = rowData;
	}

	public int returnColumnPosition(String headerName, Sheet sheet) {
		int columnCount = -1;
		int totalColumn = 0;
		String header = "";

		totalColumn = sheet.getColumns();
		// System.out.println(totalColumn + " " + sheet.getRows());
		for (int i = 0; i < totalColumn; i++) {
			Cell cell = sheet.getCell(i, 0);
			header = cell.getContents().trim();
			if (header.equalsIgnoreCase(headerName)) {
				columnCount = i;
				break;
			}
		}
		return columnCount;
	}

	public int returnRowPosition(String rowHeaderName, Sheet sheet) {

		int rowCount = -1;
		int totalRows = 0;
		String header = "";

		totalRows = sheet.getRows();
		for (int i = 0; i < totalRows; i++) {
			Cell cell = sheet.getCell(0, i);
			header = cell.getContents().trim();

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
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			workbook = openWorkbook(DriverSession.getTestExcelPath());
			sheet = getSheetHandel(workbook, sheetNumber);
			colNumber = returnColumnPosition(colHeader, sheet);
			Cell cell = sheet.getCell(colNumber, rowNum);
			value = cell.getContents().trim();
		}

		catch (Exception E) {

		}

		finally {
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
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			workbook = openWorkbook(DriverSession.getTestExcelPath());
			sheet = getSheetHandel(workbook, sheetNumber);
			colNumber = returnColumnPosition(colHeader, sheet);
			rowNumber = returnRowPosition(rowHeader, sheet);
			Cell cell = sheet.getCell(colNumber, rowNumber);
			value = cell.getContents().trim();
		}

		catch (Exception E) {

		}

		finally {
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

	public HashMap<Integer, List<String>> familyMemberData(
			/* String cellValue, */String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				List<String> info = new ArrayList<>();
				Cell[] cell = sheet.getRow(i);
				for (int j = 0; j < cell.length; j++) {
					info.add(cell[j].getContents());
				}
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap<Integer, List<String>> basicInfoPlusEducation(
			/* String cellValue, */String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				List<String> info = new ArrayList<>();
				Cell[] cell = sheet.getRow(i);
				for (int j = 3; j < cell.length; j++) {
					info.add(cell[j].getContents());
				}
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap<Integer, List<String>> testCaseDataSheet(String sheetLocation, int columnIndex) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				List<String> info = new ArrayList<>();
				Cell[] cell = sheet.getRow(i);
				for (int j = columnIndex; j < cell.length; j++) {
					info.add(cell[j].getContents());
				}
				map.put(i - 1, info);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	public void insertValueIntoSheet(int rowIndex, int columnIndex, String sheetLocation, String Status) {
		WritableWorkbook workbook;
		WritableSheet sheet;
		try {
			workbook = Workbook.createWorkbook(new File(sheetLocation));
			sheet = workbook.createSheet("Sheet 1", 0);
			Label label = new Label(columnIndex, rowIndex, Status);
			sheet.addCell(label);
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, List<String>> experience(/* String cellValue, */String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				List<String> info = new ArrayList<>();
				Cell[] cell = sheet.getRow(i);
				for (int j = 1; j < cell.length; j++) {
					info.add(cell[j].getContents());
				}
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap<Integer, List<String>> network(/* String cellValue, */String sheetLocation) {
		HashMap<Integer, List<String>> map = new LinkedHashMap<>();
		Workbook workbook;
		Sheet sheet;
		try {
			workbook = Workbook.getWorkbook(new FileInputStream(new File(sheetLocation)));
			sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				List<String> info = new ArrayList<>();
				Cell[] cell = sheet.getRow(i);
				for (int j = 1; j < cell.length; j++) {
					info.add(cell[j].getContents());
				}
				map.put(i - 1, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String args[]) throws Exception {
		ExcelUtility1 eu = new ExcelUtility1();
		HashMap<Integer, List<String>> data = eu.testCaseDataSheet("/Users/kiwitech/Documents/KiwiMobileAutomation/TestRepository/BWellFiles/TestDataForAddCard.ods", 1);
		for (Map.Entry<Integer, List<String>> map : data.entrySet()) {
			List<String> list = map.getValue();
			System.out.println("List size.."+list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println("\n");
		}
	}
}
