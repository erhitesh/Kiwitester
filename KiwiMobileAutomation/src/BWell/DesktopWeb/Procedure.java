package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Procedure {

	private WebDriver driver;

	public Procedure(WebDriver driver) {
		this.driver = driver;
	}

	public boolean addProcedureBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().addProcedures(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public void clickOnAddProcedureBtn() {
		try {
			Thread.sleep(2000);
			Keywords.clickByJS("document.getElementsByClassName('icon-add-circle')[5].click();");
			/* while (addProcedureBtnStatus()) {
			 element = Locators.getInstance().addProcedures(driver);
			 //Keywords.click(element);
			 Keywords.moveToElementClick(element, driver);
			 }*/
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Procedure Plus Icon Button </b>click successfully", "PASS",
						"<b>Add Procedure Plus Icon Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Procedure Plus Icon Button </b>not click successfully", "FAIL",
						"<b>Add Procedure Plus Icon Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Procedure Plus Icon Button </b>", "FAIL",
					"<b>Add Procedure Plus Icon Button </b>should be clicked");
		}
	}

	public void verifyAddProcedureHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().diagnosisAndSurgeryHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("add a procedure"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add A Procedure Header Text </b>found successfully", "PASS",
						"<b>Add A Procedure Header Text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add A Procedure Header Text </b>not found successfully", "FAIL",
						"<b>Add A Procedure Header Text </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Add A Procedure Header Text </b>", "FAIL",
					"<b>Add A Procedure Header Text </b>should be found");
		}
	}

	public String selectCurrentDate() {
		String cDate = "";
		WebElement element;
		try {
			element = Locators.getInstance().enableDateOfProcedure(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			element = Locators.getInstance().selectCurrentDate(driver);
			Keywords.click(element);
			element = Locators.getInstance().enableDateOfProcedure(driver);
			cDate = Keywords.getAttributeVal(element, "value");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Date </b>selected successfully", "PASS", "<b>Current Date </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Date </b>not selected successfully", "FAIL",
						"<b>Current Date </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Current Date </b>", "FAIL",
					"<b>Current Date </b>should be selected");
		}
		return cDate;
	}

	public String selectPhysician(List<String> physiciansList) {
		int randomNumber = 0;
		String physicianName = "";
		WebElement element;
		List<String> physicianList = new ArrayList<>();
		List<WebElement> physicianElementList;
		try {
			element = Locators.getInstance().enableDisablePhysician(driver);
			Keywords.click(element);
			physicianElementList = Locators.getInstance().physicianList(driver);
			for (WebElement webElement : physicianElementList) {
				physicianList.add(Keywords.getText(webElement));
			}
			physicianList.removeAll(physiciansList);
			randomNumber = Keywords.getRandomInteger(physicianElementList.size());
			physicianName = Keywords.getText(physicianElementList.get(randomNumber));
			Keywords.click(physicianElementList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Physician Name </b>selected successfully", "PASS",
						"<b>Physician Name </b>should be selected from physician List.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Physician Name </b>not selected successfully", "FAIL",
						"<b>Physician Name </b>should be selected from physician List.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Physician Name </b>from physician list", "FAIL",
					"<b>Physician Name </b>should be selected from physician List.");
		}

		return physicianName;
	}

	public String enterProcedureName() {
		String procedureName = "";
		WebElement element;
		try {
			procedureName = "Procedure" + Keywords.getRandomIntegerBtRange(111, 999) + "Test";
			element = Locators.getInstance().procedureValue(driver);
			Keywords.typeText(element, procedureName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Procedure Value </b>enter successfully", "PASS",
						"<b>Procedure Value </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Procedure Value </b>not enter successfully", "FAIL",
						"<b>Procedure Value </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Procedure Value </b>", "FAIL",
					"<b>Procedure Value </b>should be entered");
		}
		return procedureName;
	}

	public void submitProcedureInfo() {
		WebElement element;
		try {
			element = Locators.getInstance().submitProcedureInfo(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Button </b>click successfully", "PASS", "<b>Save Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Button </b>not click successfully", "FAIL", "<b>Save Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Save Button </b>", "FAIL",
					"<b>Save Button </b>should be clicked");
		}
	}

	// Get Added Procedure Info
	public List<String> procedureDateList() {
		List<WebElement> elementList;
		List<String> procedureDate = new ArrayList<>();
		try {
			elementList = Locators.getInstance().getProcedureDates(driver);
			for (int i = 0; i < elementList.size(); i++) {
				procedureDate.add(Keywords.getText(elementList.get(i)));
			}
		} catch (Exception e) {}

		return procedureDate;
	}

	public List<String> procedureTypeList() {
		List<WebElement> elementList;
		List<String> procedureType = new ArrayList<>();
		try {
			elementList = Locators.getInstance().getProcedureValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				procedureType.add(Keywords.getText(elementList.get(i)));
			}
		} catch (Exception e) {}

		return procedureType;
	}

	public List<String> procedurePhysicianList() {
		List<WebElement> elementList;
		List<String> procedurephysician = new ArrayList<>();
		try {
			elementList = Locators.getInstance().getProcedurePhysicians(driver);
			for (int i = 0; i < elementList.size(); i++) {
				procedurephysician.add(Keywords.getText(elementList.get(i)));
			}
		} catch (Exception e) {}

		return procedurephysician;
	}

	public List<String> procedureInfo() {
		String value = "";
		List<String> mainInfo = new ArrayList<>();
		try {
			for (int i = 0; i < procedureDateList().size(); i++) {
				value = procedureDateList().get(i) + "," + procedureTypeList().get(i) + ","
						+ procedurePhysicianList().get(i);
				mainInfo.add(value);
			}
		} catch (Exception e) {}
		return mainInfo;
	}

}
