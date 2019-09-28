package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;
import com.utilities.Logs;

public class SettingPanel {

	private WebDriver driver;

	public SettingPanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean settingPanelStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().rightSideHeader(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	// public void hideSettingPanel() {
	// WebElement element;
	// try {
	// Keywords.explicitWait(5);
	// Keywords.waitForPage(driver);
	// if (settingPanelStatus()) {
	// element = Locators.getInstance().rightSideHeader(driver);
	// Keywords.click(element);
	// Keywords.explicitWait(2);
	// }
	// } catch (Exception e) {}
	// }

	public boolean settingPanelViewStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().settingPanelViewStatus(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void disableSettingPanelView() {
		WebElement element;
		try {
			if (settingPanelViewStatus()) {
				element = Locators.getInstance().rightSideHeader(driver);
				Keywords.click(element);
			} else {
				Logs.info("Setting Panel View Already Closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyUserLogedIn() {
		try {
			Keywords.waitForPage(driver);
			if (settingPanelStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>User login</b> successfully",
						"PASS", "<b>User should be login</b>");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b>User not login</b> successfully", "FAIL", "<b>User should be login</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occurred while <b>login</b>",
					"FAIL", "<b>User should be login</b>");
		}
	}

	public void enableSettingPanelView() {
		WebElement element;
		try {
			Keywords.explicitWait(5);
			Keywords.waitForPage(driver);
			if (settingPanelStatus()) {
				element = Locators.getInstance().rightSideHeader(driver);
				Keywords.click(element);
				Keywords.explicitWait(2);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Setting Panel</b> open successfully", "PASS", "<b>Setting Panel Should be Open</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Setting Panel</b> open not successfully", "FAIL", "<b>Setting Panel Should be Open</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while opening the <b>Setting Panel</b>", "FAIL",
					"<b>Setting Panel Should be Open</b>");
		}
	}

	public void clickOnLogoutBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().logoutBtn(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.click(element);
				element = Locators.getInstance().loginButton(driver);
				if (Keywords.isElementPresent(element))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>User Logout </b> from website successfully", "PASS",
							"<b><b>User </b>Should be Logout from Website");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Still Login </b> in website", "FAIL", "<b>User </b>Should be Logout from Website");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while logout User from website</b>", "FAIL",
					"<b>User </b>Should be Logout from Website");
		}
	}

}
