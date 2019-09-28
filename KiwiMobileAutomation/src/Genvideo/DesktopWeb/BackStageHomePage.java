package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BackStageHomePage {

	private WebDriver driver;

	public BackStageHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private void selectConglomorate() {
		try {
			String text = DriverSession.getTestCaseData().get("Conglomorate");
			selectConglomorate(text);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Conglomorate selected successfully", "PASS", "Conglomorate should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select Conglomorate",
						"FAIL", "Conglomorate should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while selecting Conglomorate", "FAIL", "Conglomorate should be selected");
		}
	}

	private void selectBrand() {
		try {
			String text = DriverSession.getTestCaseData().get("Brand");
			selectBrand(text);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Brand selected successfully",
						"PASS", "Brand should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select Barnd", "FAIL",
						"Brand should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred...while selecting Brand", "FAIL", "Brand should be selected");
		}
	}

	private void selectGroup() {
		
		try {
			String text = DriverSession.getTestCaseData().get("Group");
			selectGroup(text);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Group selected successfully",
						"PASS", "Group should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select Group", "FAIL",
						"Group should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred...while selecting Group", "FAIL", "Group should be selected");
		}
	}

	private void selectConglomorate(String text) {
		WebElement element = Locators.getInstance().workSpaceConglomorate(driver);
		Keywords.selectText(element, text);
	}

	private void selectBrand(String text) {
		WebElement element = Locators.getInstance().workSpaceBrand(driver);
		Keywords.selectText(element, text);
	}

	private void selectGroup(String text) {
		WebElement element = Locators.getInstance().workSpaceGroup(driver);
		Keywords.selectText(element, text);
	}

	private void launchWorkSpaceMenu() {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForObject(Locators.getInstance().backStageHeaderCaret(driver), 60);
			element = Locators.getInstance().backStageHeaderCaret(driver);
			Keywords.click(element);
			element = Locators.getInstance().backStageHomeWSLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Switched to workspace menu",
						"PASS", "Workspace menu should be launched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to launch workspace", "FAIL",
						"Workspace menu should be launched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while switching to Workspace menu", "FAIL",
					"Workspace menu should be launched");
		}
	}

	private void clickGoOnWorkSpace() {
		WebElement element = null;
		try {
			element = Locators.getInstance().workSpaceGoButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Go button clicked successfully",
						"PASS", "Go button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click Go button", "FAIL",
						"Go button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while clicking on Go button", "FAIL", "Go button should be clicked");
		}
	}

	public void navigateToSelectWS() throws Exception {
		try {
			launchWorkSpaceMenu();
			selectConglomorate();
			selectBrand();
			selectGroup();
			clickGoOnWorkSpace();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while selecting Workspace", "FAIL", "Workspace should be selected");
			throw e;
		}
	}

	public void clickCampaign() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignLink(DriverSession.getLastExecutionDriver());
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Campaign link clicked successfully", "PASS", "Campaign link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Campaign link", "FAIL",
						"Campaign link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while clicking on Campaign link", "FAIL", "Campaign link should be clicked");
			throw e;
		}
	}

	public void clickContent() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().contentLink(DriverSession.getLastExecutionDriver());
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Content link clicked successfully",
						"PASS", "Content link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Content link", "FAIL",
						"Content link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while clicking on Content link", "FAIL", "Content link should be clicked");
			throw e;
		}
	}

	public void clickDistribution() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().distributionLink(DriverSession.getLastExecutionDriver());
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Distribution link clicked successfully", "PASS", "Distribution link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Distribution link", "FAIL",
						"Distribution link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....while clicking on Distribution link", "FAIL",
					"Distribution link should be clicked");
			throw e;
		}
	}

}
