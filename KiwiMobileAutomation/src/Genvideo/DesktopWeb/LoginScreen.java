package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class LoginScreen {

	private WebDriver driver;

	public LoginScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String username) throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().loginEmail(driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, username);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Email ID typed succefully. :: <b><i>"
										+ username + "</i></b>", "PASS",
								"Email ID name should be entered.");
			} else
				throw new Exception("Email ID not typed.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....Unable to enter email id .",
							"FAIL", "Should be able to enter email id.");
			throw e;
		}
	}

	public void enterUserName() throws Exception {
		enterUserName(DriverSession.getTestCaseData().get("Username"));
	}

	public void enterPassword(String password) throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().loginPassword(driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Password typed succefully", "PASS",
								"Password name should be entered.");
			} else
				throw new Exception("Password not typed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....Unable to enter Password",
							"FAIL", "Should be able to enter Password.");
			throw e;
		}
	}

	public void enterPassword() throws Exception {
		enterPassword(DriverSession.getTestCaseData().get("Password"));
	}

	public void loginUser() throws Exception { 
		WebElement element = null;
		try {
			element = Locators.getInstance().loginButton(driver);
			Keywords.click(element);
			//Keywords.waitForObjectToInvisible(element, 10);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Login button clicked successfully",
								"PASS", "Should click on Login button");
			} else
				throw new Exception("Click on Login button failed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured..", "FAIL",
							"Should click on Login button");
			throw e;
		}
	}

}
