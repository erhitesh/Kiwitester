package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Dashboard {

	private WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToDashboard() {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().bwellLogoHeader(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>BWell Dashboard visible successfully</b>", "PASS",
						"<b>BWell Dashboard should be visible</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>BWell Dashboard not visible successfully</b>", "FAIL",
						"<b>BWell Dashboard should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while navigating to the <b>BWell Dashboard</b>", "FAIL",
					"<b>BWell Dashboard should be visible</b>");
		}
	}

	public void selectDashboardLeftMenu(String menuName) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().selectDashboardLeftMenu(driver, menuName), 10);
			element = Locators.getInstance().selectDashboardLeftMenu(driver, menuName);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><u>" + menuName + "</u></b>" + " <b>select successfully</b>", "PASS",
						"<b><u>" + menuName + "</u></b>"+" <b>should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><u>" + menuName + "</u></b>" + " <b>not select successfully</b>", "PASS",
						"<b><u>" + menuName + "</u></b>"+" <b>should be clicked</b>");
			Keywords.explicitWait(10);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b></u>" + menuName+"</u></b>", "FAIL",
					"<b><i>" + menuName + " should be clicked</i></b>");
		}
	}

}
