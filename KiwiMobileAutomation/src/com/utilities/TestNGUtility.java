package com.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestNGUtility {
	private File suiteFile;

	public TestNGUtility() {
		String suitExc = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash
				+ "TestRepository" + GlobalParam.slash + "TestSuite"
				+ GlobalParam.slash + GlobalParam.APP_NAME + GlobalParam.slash
				+ GlobalParam.APP_NAME + GlobalParam.CURRENT_EXECUTION_MODE
				+ "Suite.xlsx";
		File file = new File(suitExc);
		this.suiteFile = file;
	}

	public Map<String, ArrayList<String>> getTrueTestCases(String executionMode) {
		Map<String, ArrayList<String>> testCases = new LinkedHashMap<String, ArrayList<String>>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(suiteFile);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			for (int colNum = 0; colNum < columnCount; ++colNum) {
				String colName = sheet.getRow(0).getCell(colNum).getStringCellValue();
				if (colName.trim().isEmpty()) {
					break;
				}
				if (colName.trim().equalsIgnoreCase(executionMode)) {
					for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); ++rowNum) {
						String cellValue = sheet.getRow(rowNum).getCell(colNum).toString();
						if (cellValue.trim().isEmpty()) {
							break;
						}
						if (Boolean.parseBoolean(cellValue)) {
							String testCase = sheet.getRow(rowNum).getCell(1).toString();
							String browser = sheet.getRow(rowNum).getCell(2).toString();
							ArrayList<String> browsers = new ArrayList<String>();
							if (testCases.containsKey(testCase)) {
								browsers = testCases.get(testCase);
							}
							browsers.add(browser);
							testCases.put(testCase, new ArrayList<String>(browsers));
						}
					}
					break;
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCases;
	}

	public Map<String, ArrayList<String>> getActionComponent(
			Map<String, ArrayList<String>> testCases) {
		HashMap<String, ArrayList<String>> actionComponent = new HashMap<String, ArrayList<String>>();
		for (String testCaseName : testCases.keySet()) {
			try {
				String testCaseOds = GlobalParam.CURRENT_PROJECT_PATH
						+ GlobalParam.slash + "TestRepository"
						+ GlobalParam.slash + "TestCases" + GlobalParam.slash
						+ GlobalParam.APP_NAME + GlobalParam.slash
						+ testCaseName + ".xlsx";
				File file = new File(testCaseOds);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					String action = sheet.getRow(i).getCell(0).getStringCellValue();
					if (action.trim().isEmpty()) {
						break;
					}
					ArrayList<String> actions = new ArrayList<String>();
					if (actionComponent.containsKey(testCaseName) ) {
						actions = actionComponent.get(testCaseName);
					}
					actions.add(action);
					actionComponent.put(testCaseName, new ArrayList<String>(actions));
				}
				workbook.close();
			} catch (Exception e) {
				System.out.println("Xlsx file for the " + testCaseName
						+ " TestCase do not exist. Please Check");
			}
		}
		return actionComponent;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}