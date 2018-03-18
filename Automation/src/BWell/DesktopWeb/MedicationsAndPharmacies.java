package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class MedicationsAndPharmacies {

	private WebDriver driver;

	public MedicationsAndPharmacies(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToMedicationsAndPharmaciesPage() {
		try {
			Keywords.waitForPage(driver);
			Dashboard dashboard = new Dashboard(driver);
			dashboard.selectDashboardLeftMenu("Medications & Pharmacies");
		} catch (Exception e) {}
	}

	public void selectSubLinksInsideMedicationsAndPharmaciesTab(String subLinkName) {
		WebElement element;
		try {
			element = Locators.getInstance().selectMedicationsAndPharmaciesSubLinks(driver, subLinkName);
			Keywords.click(element);
			Keywords.explicitWait(5);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medications & Pharmacies sub link.</b> " + subLinkName + " select successfully", "PASS",
						"<b>Medications & Pharmacies sub link.</b> " + subLinkName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medications & Pharmacies sub link.</b> " + subLinkName + " not select successfully",
						"FAIL", "<b>Medications & Pharmacies sub link.</b> " + subLinkName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while selecting the Medications & Pharmacies sub link.</b> " + subLinkName,
					"FAIL", "<b>Medications & Pharmacies sub link.</b> " + subLinkName + " should be selected");
		}
	}
}
