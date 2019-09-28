package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ClinicalSummary {

	private WebDriver driver;

	public ClinicalSummary(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToClinicalSummaryPage() {
		try {
			MyHealth myHealth = new MyHealth(driver);
			myHealth.navigateToMyHealthPage();
			myHealth.selectSubLinksInsideMyHealthTab("clinical");
			Keywords.verifyPageLoaded("clinical-summary");
		} catch (Exception e) {}
	}

	public void addNeedCareFromClinical() {
		WebElement element;
		try {
			navigateToClinicalSummaryPage();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addCareNeeds(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Need Care Button </b>click successfully", "PASS",
						"<b>Add Need Care Button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Need Care Button not </b>click successfully", "FAIL",
						"<b>Add Need Care Button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the<b>Add Need Care Button </b>", "FAIL",
					"<b>Add Need Care Button should be clicked</b>");
		}
	}

	public void clickOnAddAllergy() {
		WebElement element;
		try {
			element = Locators.getInstance().addAllergies(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergies page open successfully</b>", "PASS", "<b>Allergies page should be open</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergies page not open successfully</b>", "FAIL", "<b>Allergies page should be open</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the add Allergies button</b>", "FAIL",
					"<b>Allergies page should be open</b>");
		}
	}

	public void navigateToAddAllergyFromClinical() {
		try {
			/*MyHealth myhealth = new MyHealth(DriverSession.getLastExecutionDriver());
			myhealth.navigateToMyHealthPage();
			myhealth.selectSubLinksInsideMyHealthTab("clinical");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAllergies(driver);
			Keywords.click(element);*/
			navigateToClinicalSummaryPage();
			clickOnAddAllergy();
		} catch (Exception e) {}
	}

	public void navigateToAddFamilyHistoryFromClinical() {
		WebElement element;
		try {
			MyHealth myHealth = new MyHealth(driver);
			myHealth.navigateToMyHealthPage();
			myHealth.selectSubLinksInsideMyHealthTab("clinical");

			Keywords.waitForPage(driver);
			element = Locators.getInstance().addFamilyHealthHistory(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family History page open successfully</b>", "PASS",
						"<b>Family History page should be open</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family History page not open successfully</b>", "FAIL",
						"<b>Family History page should be open</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the add Family History button</b>", "FAIL",
					"<b>Family History page should be open</b>");
		}
	}
}
