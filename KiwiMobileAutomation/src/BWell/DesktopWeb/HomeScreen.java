package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class HomeScreen {

	private WebDriver driver;

	public HomeScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnBWellLogo() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().logoOnLoginPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>BWell Logo </b>click successfully", "PASS", "<b>BWell Logo </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>BWell Logo </b>not click successfully", "FAIL", "<b>BWell Logo </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>BWell Logo </b>", "FAIL",
					"<b>BWell Logo </b>should be clicked");
		}
	}

	public void clickOnAppStore() {
		WebElement element;
		try {
			element = Locators.getInstance().appStoreLink(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Store Link </b>click successfully", "PASS", "<b>App Store Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Store Link </b>not click successfully", "FAIL",
						"<b>App Store Link </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>App Store Link </b>", "FAIL",
					"<b>App Store Link </b>should be clicked");
		}
	}

	public void verifyiTunePreview() {
		WebElement element;
		try {
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			element = Locators.getInstance().itunePreviewHeader(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>iTune Preview Header Txt </b>display", "PASS",
						"<b>iTune Preview Header Txt </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>iTune Preview Header Txt </b>not display", "FAIL",
						"<b>iTune Preview Header Txt </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>iTune Preview Header Txt </b>", "FAIL",
					"<b>iTune Preview Header Txt </b>should be display");
		}
	}

	public void verifyAppNameOnAppStore() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyAppNameOnItune(driver);
			if (Keywords.getText(element).equalsIgnoreCase("b.well - Connected Health"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Name </b>found successfully", "PASS",
						"<b>iTune Preview Header Txt </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Name </b>not found successfully", "FAIL", "<b>App Name </b>should be display");
			Keywords.closeWindow(driver);
			Keywords.explicitWait(1);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>App Name</b>", "FAIL",
					"<b>App Name </b>should be display");
		}
	}

	public void clickOnGooglePlay() {
		WebElement element;
		try {
			element = Locators.getInstance().googlePlayLink(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Goolge Play Link </b>click successfully", "PASS",
						"<b>Goolge Play Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Goolge Play Link </b>not click successfully", "FAIL",
						"<b>Goolge Play Link </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Goolge Play Link </b>", "FAIL",
					"<b>Goolge Play Link </b>should be clicked");
		}
	}

	public void verifyGooglePlayPreview() {
		WebElement element;
		try {
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			Keywords.explicitWait(2);
			element = Locators.getInstance().googlePlayTitle(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Google Play Header Txt </b>display", "PASS",
						"<b>Google Play Header Txt </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Google Play Header Txt </b>not display", "FAIL",
						"<b>Google Play Header Txt </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Google Play Header Txt </b>", "FAIL",
					"<b>Google Play Header Txt </b>should be display");
		}
	}

	public void verifyAppNameOnGooglePaly() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyAppNameOnGooglePlayStore(driver);
			if (Keywords.getText(element).equalsIgnoreCase("b.well - Connected Health"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Name </b>found successfully", "PASS", "<b>App Name </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>App Name </b>not found successfully", "FAIL", "<b>App Name </b>should be display");
			Keywords.closeWindow(driver);
			Keywords.explicitWait(1);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>App Name</b>", "FAIL",
					"<b>App Name </b>should be display");
		}
	}

}
