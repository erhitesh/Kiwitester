package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class TabManager {

	private WebDriver driver;

	public TabManager(WebDriver driver) {
		this.driver = driver;
	}

	public String enterTabName() {
		WebElement element;
		String tabName = "Tester" + Keywords.getRandomData();
		try {
			System.out.println("Tester Tab Name"+tabName);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterTabName(driver);
			Keywords.typeText(element, tabName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tab Name enter successfully",
						"PASS", "Tab Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tab Name not enter successfully",
						"FAIL", "Tab Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Tab Name", "FAIL", "Tab Name should be entered");
		}

		return tabName;
	}

	public String enterTabDescription() {
		WebElement element;
		String tabDescription = "Test Tab for Tester";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().EnterTabDescription(driver);
			Keywords.typeText(element, tabDescription);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Tab Description enter successfully", "PASS", "Tab Description should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Tab Description not enter successfully", "FAIL", "Tab Description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Tab Description", "FAIL", "Tab Description should be entered");
		}

		return tabDescription;
	}

	public String getAddedTabManagerName() {
		String tabName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getTabManagerName(driver);
			tabName = Keywords.getText(element);
		} catch (Exception e) {
		}
		return tabName;
	}

	public String getAddedTabManagerDescription() {
		String tabDescription = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getTabDescription(driver);
			tabDescription = Keywords.getText(element);
		} catch (Exception e) {
		}
		return tabDescription;
	}

	public void clickOnCreateFieldForTab(String addType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().createFieldForTab(driver, addType);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(addType + " click successfully",
						"PASS", addType + " should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(addType + " not click successfully",
						"FAIL", addType + " should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + addType + " click", "FAIL",
					addType + " should be click");
		}
	}

	public void selectExistingFieldsCheckboxList(String tabType) {
		int randomNumber = 0;
		// int lastRandomNumber = 0;
		WebElement element;
		List<WebElement> checkboxList;
		List<Integer> randomGeneratedData = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().waitCreateFieldTabHeader(driver, tabType);
			Keywords.waitForObject(element);
			checkboxList = Locators.getInstance().getExistingFieldCheckBoxList(driver);
			for (int i = 0; i < 4; i++) {
				randomNumber = Keywords.getRandomInteger(checkboxList.size() - 1);
				// if (randomNumber == lastRandomNumber)
				// randomNumber++;
				if (i > 0) {
					for (int j = 0; j < randomGeneratedData.size(); j++) {
						if (randomGeneratedData.get(j) == randomNumber) {
							randomNumber++;
							break;
						}
					}
				}
				randomGeneratedData.add(randomNumber);
				Keywords.clickByIndex(checkboxList, randomNumber);
				// lastRandomNumber = randomNumber;
			}
		} catch (Exception e) {

		}
	}

	public void submitFieldSuccessfullySavedAlert() {
		try {
			Keywords.acceptAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getAddedExistingFieldsName() {
		List<WebElement> fieldsList;
		List<String> addedFieldName = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			fieldsList = Locators.getInstance().getAddedExistingFieldsName(driver);
			for (int i = 0; i < fieldsList.size(); i++) {
				addedFieldName.add(Keywords.getTextByIndex(fieldsList, i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addedFieldName;
	}

	public void createFieldNameForTab(String addType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().waitCreateFieldTabHeader(driver, addType);
			Keywords.waitForObject(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b.Add Field</b> click successfully", "PASS", "<b.Add Field</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b.Add Field</b> not click successfully", "FAIL", "<b.Add Field</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b.Add Field</b> click", "FAIL",
					"<b.Add Field</b> should be click");
		}
	}

	public void submitSlugId() {
		WebElement element;
		try {
			//Keywords.waitForPage(driver);
			element = Locators.getInstance().submitSlugId(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Add button click successfully",
						"PASS", "Add button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Add button not click successfully",
						"FAIL", "Add button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the Add button", "FAIL", "Add button should be click");
		}
	}

	public void verifyWrongSlugId() {
		try {
			Keywords.acceptAlert();
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b alert visible successfully", "PASS",
						"Slug Id Display Name should not be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Entity is not found alert not visible successfully", "FAIL",
						"Slug Id Display Name should not be present");
		} catch (Exception f) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Slug Id Display Name alert error message", "FAIL",
					"Slug Id Display Name should not be present");
		}
	}

	public String verifySlugId() {
		WebElement element;
		String slugIdDisplayName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getUserSlugId(driver);
			slugIdDisplayName = Keywords.getText(element);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Slug Id Display Name found successfully", "PASS", "Slug Id Display Name should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Slug Id Display Name not found successfully", "FAIL",
						"Slug Id Display Name should be present");
		} catch (Exception f) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Slug Id Display Name", "FAIL",
					"Slug Id Display Name should be present");
		}

		return slugIdDisplayName;
	}

	public void enterWrongSlugIdForTabManager() {
		WebElement element;
		String ownerIdOrSlug = DriverSession.getTestCaseData().get("WrongOwnerId");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterSlugIdForTabManager(driver);
			Keywords.typeText(element, ownerIdOrSlug);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Wrong Owner Id/Slug enter successfully", "PASS", "Wrong Owner Id/Slug should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Owner Id/Slug not enter successfully", "FAIL", "Wrong Owner Id/Slug should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Wrong Owner Id/Slug", "FAIL",
					"Wrong Owner Id/Slug should be enter");
		}
	}

	public void enterSlugIdForTabManager() {
		WebElement element;
		String ownerIdOrSlug = DriverSession.getTestCaseData().get("OwnerId");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterSlugIdForTabManager(driver);
			Keywords.typeText(element, ownerIdOrSlug);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Owner Id/Slug enter successfully",
						"PASS", "Owner Id/Slug should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Owner Id/Slug not enter successfully", "FAIL", "Owner Id/Slug should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Owner Id/Slug", "FAIL", "Owner Id/Slug should be enter");
		}
	}
}
