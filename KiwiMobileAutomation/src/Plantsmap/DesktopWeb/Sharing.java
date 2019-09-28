package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Sharing {

	private WebDriver driver;

	public Sharing(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> sharingOptions() {
		List<String> list = new ArrayList<String>();
		list.add("Facebook");
		list.add("Twitter");
		list.add("Google");
		list.add("LinkedIn");

		return list;
	}

	public void selectSharingOption(String sharingOption, String shareFrom) {
		WebElement element = null;
		try {
			if (shareFrom.contains("header")) {
				element = Locators.getInstance().headerSharingOption(driver, sharingOption);
			} else if (shareFrom.contains("footer")) {
				sharingOption = sharingOption.toLowerCase();
				element = Locators.getInstance().footerSharingOption(driver, sharingOption);
			}
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						sharingOption + " link click successfully", "PASS", sharingOption + " link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						sharingOption + " link not click successfully", "FAIL",
						sharingOption + " link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on " + sharingOption, "FAIl",
					sharingOption + " link should be clicked");
		}
	}

	public void verifySharingOptionUrl() {
		List<String> list = sharingOptions();
		List<String> handle;
		String url = "";
		try {
			for (int i = 0; i < list.size(); i++) {
				selectSharingOption(list.get(i), "footer");
				Thread.sleep(4000);
				handle = Keywords.getWindowHandles(driver);
				Keywords.switchToWindowHandle(driver, handle.size() - 1);
				Thread.sleep(2000);
				url = Keywords.getCurrentUrl(driver);
				if (url.contains(list.get(i).toLowerCase())) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							list.get(i) + " Link url verified", "PASS", list.get(i) + " Link url should be verified");
					Keywords.closeWindow(driver);
					Thread.sleep(1000);
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							list.get(i) + " Link url not verified", "FAIL",
							list.get(i) + " Link url should be verified");
				handle = Keywords.getWindowHandles(driver);
				Keywords.switchToWindowHandle(driver, handle.size() - handle.size());// (driver,
																						// 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleFacebookAlertMessageForSignInAndSignUp() {
		WebElement element;
		try {
			element = Locators.getInstance().facebookSignInAndSignUpRelatedAlertPop(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.click(element);
			}
		} catch (Exception e) {
		}
	}

	public void enterFacebookUser(String fbUName) {
		WebElement element;
		try {
			element = Locators.getInstance().facebookEmailId(driver);
			Keywords.typeText(element, fbUName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Facebook user name enter successfully", "PASS", "Facebook user name should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Facebook user name not enter successfully", "FAIL", "Facebook user name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while entering the facebook user name", "FAIL",
					"Facebook user name should be entered");
		}
	}

	public void enterFacebookUser() {
		enterFacebookUser(DriverSession.getTestCaseData().get("FacebookUserName"));
	}

	public void enterFacebookPassword(String fbUPass) {
		WebElement element;
		try {
			element = Locators.getInstance().facebookPass(driver);
			Keywords.typeText(element, fbUPass);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Facebook user password enter successfully", "PASS",
						"Facebook user password should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Facebook user password not enter successfully", "FAIL",
						"Facebook user password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while entering the facebook user password", "FAIL",
					"Facebook user password should be entered");
		}
	}

	public void enterFacebookPassword() {
		enterFacebookPassword(DriverSession.getTestCaseData().get("FacebookUserPass"));
	}

	public void submitFacebook() {
		WebElement element;
		try {
			element = Locators.getInstance().fbLogin(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Log In button click successfully",
						"PASS", "Log In button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Log In button not click successfully", "FAIL", "Log In button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on the login button", "FAIL", "Log In button should be click");
		}
	}

	public boolean getFacebookLoginStatus() {
		WebElement element;
		boolean status = false;
		try {
			element = Locators.getInstance().facebookLoginStatus(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}
}
