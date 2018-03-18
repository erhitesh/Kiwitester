package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ClaimsAndFinancials {

	private WebDriver driver;

	public ClaimsAndFinancials(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToClaimAndFinancialPage() {
		try {
			Dashboard dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
			dashboard.selectDashboardLeftMenu("Claims & Financials");
			Keywords.verifyPageLoaded(driver, "claims-financials");
		} catch (Exception e) {}
	}

	public void selectSubLinksInsideClaimAndFinancialTab(String subLinkName) {
		WebElement element;
		try {
			Keywords.explicitWait(2);
			element = Locators.getInstance().selectClaimsAndFinancialsSubLinks(driver, subLinkName);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Claims & Financials sub link.</b> " + "<br><u>" + subLinkName + "</u></br>"
								+ " select successfully",
						"PASS",
						"<b>Claims & Financials sub link</b> " + subLinkName + "</u></br>" + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Claims & Financials sub link</b> " + "<br><u>" + subLinkName + " not select successfully",
						"FAIL",
						"<b>Claims & Financials sub link</b> " + subLinkName + "</u></br>" + " should be selected");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 15);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while selecting the Claims & Financials sub link</b> " + "<br><u>"
							+ subLinkName,
					"FAIL", "<b>Claims & Financials sub link</b> " + subLinkName + "</u></br>" + " should be selected");
		}
	}
}
