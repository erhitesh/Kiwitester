package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;


public class Admin {

	private WebDriver driver;

	public Admin(WebDriver driver) {
		this.driver = driver;
	}
	

	public void navigateToAdminSite(String url) {
		try {
			Keywords.navigateTo(url);
			Thread.sleep(2000);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while redirect to the plantsmap admin site", "FAIL",
					"Admin site should be loaded.");
		}
	}
	
	public boolean loginStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminSignOutLink(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {}

		return status;
	}


	public void enterAdminEmailId(String userName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminEmailId(driver);
			Keywords.typeText(element, userName);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Admin Email Successfully entered.",
						"PASS", "Admin Email ID name should be entered.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Admin Email Successfully not entered.", "FAIl", "Admin Email should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred....While entering the Admin email id.", "FAIL",
					"Admin Email should be entered.");
		}
	}

	public void enterAdminEmailId() {
		enterAdminEmailId(DriverSession.getTestCaseData().get("AdminUser"));
	}

	public void enterAdminPassword(String password) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminPassword(driver);
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Admin Password successfully entered", "PASS", "Admin Password name should be entered.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Admin Password successfully not entered", "FAIL", "Admin Password name should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enter the Admin Password", "FAIL",
					"Admin Password name should be entered.");
		}
	}

	public void enterAdminPassword() {
		enterAdminPassword(DriverSession.getTestCaseData().get("AdminPass"));
	}

	public void submitAdminSingIn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminSignInBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Admin Sign In button clicked successfully", "PASS", "Admin Sign In button should be clicked.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Admin Sign In button not clicked successfully", "FAIL",
						"Admin Sign In button should be clicked.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the admin signin button", "FAIL",
					"Admin Sign In button should be clicked.");
		}
	}

	public boolean verifyAdminLoginSuccessfully() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminSignOutLink(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"User logged In as Admin successfully", "PASS", "User should be logged In as Admin");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"User not logged In as Admin successfully", "FAIL", "User should be logged In as Admin");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while user login as admin", "FAIL", "User should be logged In as Admin");
		}

		return status;
	}

	public void clickOnSignOut() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminSignOutLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("SignOut link click successfully",
						"PASS", "Sign out link should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignOut link not click successfully", "FAIL", "Sign out link should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the SignOut link", "FAIL", "Sign out link should be click");
		}
	}

	public void selectAdminHeaderTab(String tabName) {
		List<WebElement> headerTabList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			headerTabList = Locators.getInstance().adminHeaderTab(driver);
			for (int i = 0; i < headerTabList.size(); i++) {
				if (Keywords.getTextByIndex(headerTabList, i).equalsIgnoreCase(tabName)) {
					Keywords.clickByIndex(headerTabList, i);
					Thread.sleep(1000);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(tabName + " click successfully",
							"PASS", tabName + " should be click");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the " + tabName, "FAIL", tabName + " should be click");
		}
	}
}