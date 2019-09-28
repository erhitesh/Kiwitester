package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.session.DriverSession;
import com.utilities.Keywords;

public class Encounter {

	private WebDriver driver;

	public Encounter(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToAddRecentEncounterPage() {
		try {
			ClinicalSummary clinical = new ClinicalSummary(driver);
			clinical.navigateToClinicalSummaryPage();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnRecentEncounterAddBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().addRecentEncounters(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Recent Encounter Plus Icon Button </b>click successfully", "PASS",
						"<b>Add Recent Encounter Plus Icon Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Recent Encounter Plus Icon Button </b>not click successfully", "FAIL",
						"<b>Add Recent Encounter Plus Icon Button </b>should be clicked");
			verifyAddRecentEncounterHeaderTxt();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Recent Encounter Plus Icon Button </b>", "FAIL",
					"<b>Add Recent Encounter Plus Icon Button </b>should be clicked");
		}
	}

	public void verifyAddRecentEncounterHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().recentEncounterHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add a Recent Medical Encounter"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Recent Encounter Header Text </b>found successfully", "PASS",
						"<b>Recent Encounter Header Text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Recent Encounter Header Text </b>not found successfully", "FAIL",
						"<b>Recent Encounter Header Text </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Recent Encounter Header Text </b>", "FAIL",
					"<b>Recent Encounter Header Text </b>should be found");
		}
	}

	public String selectRecentEncounterDate() {
		String date = "";
		WebElement element;
		try {
			element = Locators.getInstance().enableRecentEncounterDateView(driver);
			Keywords.click(element);
			date = Keywords.getCurrentDate("MM/dd/yyyy");
			element = Locators.getInstance().selectCurrentEncounterDate(driver);
			Keywords.click(element);
			element = Locators.getInstance().enableRecentEncounterDateView(driver);
			if (Keywords.getAttributeVal(element, "value").equalsIgnoreCase(date))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Recent Encounter Date </b>" + date + " selected successfully", "PASS",
						"<b>Recent Encounter Date </b>" + date + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Recent Encounter Date </b>" + date + " selected successfully", "FAIL",
						"<b>Recent Encounter Date </b>" + date + " should be selected");
		}catch(Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Recent Encounter Date </b>" + date + " selected successfully", "FAIL",
					"<b>Recent Encounter Date </b>" + date + " should be selected");
		}
		
		return date;
	}
	
	public String selectPhysician() {
		int randomNumber = 0;
		String physicianName = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			element = Locators.getInstance().enablePhysicianDropDown(driver);
			Keywords.click(element);
			elementList = Locators.getInstance().physicianList(driver);
			randomNumber = Keywords.getRandomInteger(elementList.size());
			physicianName = Keywords.getText(elementList.get(randomNumber));
			Keywords.click(elementList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Physician Name </b>select successfully", "PASS",
						"<b>Physician Name </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Physician Name </b>not select successfully", "FAIL",
						"<b>Physician Name </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Physician Name </b>", "FAIL",
					"<b>Physician Name </b>should be selected");
		}

		return physicianName;
	}

	public String selectVisitType() {
		int randomNumber = 0;
		String visitTypeName = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			element = Locators.getInstance().enableVisitDropDown(driver);
			Keywords.click(element);
			elementList = Locators.getInstance().visitList(driver);
			randomNumber = Keywords.getRandomInteger(elementList.size());
			visitTypeName = Keywords.getText(elementList.get(randomNumber));
			Keywords.click(elementList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Visit Type Name </b>select successfully", "PASS",
						"<b>Visit Type Name </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Visit Type Name </b>not select successfully", "FAIL",
						"<b>Visit Type Name </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Visit Type Name </b>", "FAIL",
					"<b>Visit Type Name </b>should be selected");
		}

		return visitTypeName;
	}

	public String enterInstructions() {
		WebElement element;
		String randomInstructionTxt = "";
		try {
			randomInstructionTxt = Keywords.getRandomString();
			element = Locators.getInstance().instructionsTxtBox(driver);
			Keywords.typeText(element, randomInstructionTxt);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Instruction Text </b>enter successfully", "PASS",
						"<b>Instruction Text </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Instruction Text </b>not enter successfully", "FAIL",
						"<b>Instruction Text </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Instruction Text </b>", "FAIL",
					"<b>Instruction Text </b>should be entered");
		}

		return randomInstructionTxt;
	}

	public String followUpPlan() {
		WebElement element;
		String randomFollowUpPlanTxt = "";
		try {
			randomFollowUpPlanTxt = Keywords.getRandomString();
			element = Locators.getInstance().followUpPlanTxtBox(driver);
			Keywords.typeText(element, randomFollowUpPlanTxt);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Follow Up Plan Text </b>enter successfully", "PASS",
						"<b>Follow Up Plan Text </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Follow Up Plan Text </b>not enter successfully", "FAIL",
						"<b>Follow Up Plan Text </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Follow Up Plan Text </b>", "FAIL",
					"<b>Follow Up Plan Text </b>should be entered");
		}

		return randomFollowUpPlanTxt;
	}

	public void submitRecentEncounterPage() {
		WebElement element;
		try {
			element = Locators.getInstance().submitRecentEncounterPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Button </b>click successfully", "PASS", "<b>Save Button </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Button </b>not click successfully", "FAIL", "<b>Save Button </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Save Button </b>", "FAIL",
					"<b>Save Button </b>should be submit");
		}
	}
}
