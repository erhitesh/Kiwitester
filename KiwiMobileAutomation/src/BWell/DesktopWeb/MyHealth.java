package BWell.DesktopWeb;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;


public class MyHealth {

	private WebDriver driver;

	public MyHealth(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToMyHealthPage() {
		try {
			Dashboard dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
			dashboard.selectDashboardLeftMenu("My Health");
		} catch (Exception e) {}
	}

	public void selectSubLinksInsideMyHealthTab(String subLinkName) {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().selectMyHealthSubLinks(driver, subLinkName);
			Keywords.click(element);
			Keywords.explicitWait(3);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>My Health sub link.</b> " + subLinkName + " select successfully", "PASS",
						"<b>My Health sub link.</b> " + subLinkName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>My Health sub link.</b> " + subLinkName + " not select successfully", "FAIL",
						"<b>My Health sub link.</b> " + subLinkName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while selecting the My Health sub link.</b> " + subLinkName, "FAIL",
					"<b>My Health sub link.</b> " + subLinkName + " should be selected");
		}
	}
}