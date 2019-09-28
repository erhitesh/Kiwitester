package Plantsmap.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Registration {

	private WebDriver driver;

	public Registration(WebDriver driver) {
		this.driver = driver;
	}

	public String enterUserEmailId() {
		String emailId = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signUpEmail(driver);
			emailId = "PlantsMap" + Keywords.getRandomNumber(8) + "@yopmail.com";
			Keywords.typeText(element, emailId);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully entered",
						"PASS", "Email Id should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully not entered",
						"FAIL", "Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while entering Email Id", "FAIL", "Email should be enter");
		}

		return emailId;
	}
	
	public void enterUserInavlidEmailId(String emailAddress) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signUpEmail(driver);
			Keywords.typeText(element, emailAddress/*DriverSession.getTestCaseData().get("InvalidEmailId")*/);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully entered",
						"PASS", "Email Id should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully not entered",
						"FAIL", "Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while entering Email Id", "FAIL", "Email should be enter");
		}
	}
	
	public void enterUserEmailId(String emailAddress) {
		enterUserInavlidEmailId(emailAddress);
	}

	public String enterUserPassword(String password) {
		WebElement element;
		String pass = password;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signUpPassword(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Password successfully entered</b>",
						"PASS", "<b>Password should be entered</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password not entered",
						"FAIL", "<b>Password should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while entering Password", "FAIL", "<b>Password should be entered</b>");
		}
		return pass;
	}

	public String enterUserPassword() {
		return enterUserPassword(DriverSession.getTestCaseData().get("Password"));
	}
	
	public void enterUserInvalidPasswordLength() {
		enterUserPassword(DriverSession.getTestCaseData().get("InvalidPassword"));
	}

	public void submitSignUpButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitExplorePageSignUpBtn(driver);
			Keywords.click(element);
			Thread.sleep(3000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Sign Up button click successfully",
						"PASS", "Sign Up button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign Up button not click successfully", "FAIL", "Sign Up button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while click on the <b>Sign Up</b> button", "FAIL",
					"Sign Up button should be click");
		}
	}
	
	public void clickOnSignUpBtnFomHomeOrMainPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitHomeOrMainPageSignUpBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Sign Up button</b> click successfully",
						"PASS", "<b>Sign Up button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign Up button not click successfully", "FAIL", "<b>Sign Up button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while click on the <b>Sign Up button</b>", "FAIL",
					"<b>Sign Up button</b> should be click");
		}
	}
	
	public void verifyErrorMessageForSignUpWithoutEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignUpReguiredField(driver, "email");
			Keywords.verifyTextOnPage(element.getText());
			
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Email must be provided.</b> display successfully", "PASS",
						"<b>Email must be provided.</b> message should be Display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Email must be provided.</b> not display", "FAIl",
						"<b>Email must be provided.</b> message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing error message for <b>Email must be provided.</b>", "FAIl",
					"<b>Email must be provided.</b> message should be Display");
		}
	}

	public void verifyErrorMessageForSignUpInvalidEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignUpRequiredFieldFormat(driver, "email");
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email is not valid.</b> error message display successfully", "PASS",
						"<b>Email is not valid.</b> error message should be display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email is not valid.</b> error message not display", "FAIL",
						"<b>Email is not valid.</b> message should display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing message <b>Email is not valid.</b>", "FAIL",
					"<b>Email is not valid.</b> message should display");
		}
	}
	
	public void verifyErrorMessageForAlreadyUsedEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForEmailAlreadyTaken(driver);
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email has already been taken.</b> error message display successfully", "PASS",
						"<b>Email has already been taken.</b> error message should be display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email has already been taken.</b> error message not display", "FAIL",
						"<b>Email has already been taken.</b> message should display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing message <b>Email has already been taken.</b>", "FAIL",
					"<b>Email has already been taken.</b> message should display");
		}
	}
	
	
	public void verifyErrorMessageForSignUpWithoutPassword() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignUpReguiredField(driver, "pass");
			Keywords.verifyTextOnPage(element.getText());
			
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Password must be provided</b> display successfully", "PASS",
						"<b>Password must be provided</b> message should be Display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Password must be provided</b> not display", "FAIl",
						"<b>Password must be provided</b> message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing error message for <b>Password must be provided</b>", "FAIl",
					"<b>Password must be provided</b> should be Display");
		}
	}
	
	public void verifyErrorMessageForSignUpPasswordInvalidLength() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignUpRequiredFieldFormat(driver, "pass");
			Keywords.verifyTextOnPage(element.getText());
			
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Password should be atleast 8 characters.</b> display successfully", "PASS",
						"<b>Password should be atleast 8 characters.</b> message should be Display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for <b>Password should be atleast 8 characters.</b> not display", "FAIl",
						"<b>Password should be atleast 8 characters.</b> message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing error message for <b>Password should be atleast 8 characters.</b>", "FAIl",
					"<b>Password should be atleast 8 characters.</b> should be Display");
		}
	}
}
