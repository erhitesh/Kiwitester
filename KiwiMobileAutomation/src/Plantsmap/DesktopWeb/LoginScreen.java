package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class LoginScreen {

	private WebDriver driver;

	public LoginScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignInLink() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signInLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sing In Link</b> click successfully", "PASS", "<b>Sing In Link</b> should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sing In Link</b> successfully not click", "FAIL", "<b>Sing In Link</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred. While clicking on the <b>Sing In Link</b>", "FAIL",
					"<b>Sing In Link</b> should be click");
		}
	}
	
	public void clickOnSignUpLink() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signUpLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sing Up Link</b> click successfully", "PASS", "<b>Sing Up Link</b> should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sing Up Link</b> successfully not click", "FAIL", "<b>Sing Up Link</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred. While clicking on the <b>Sing Up Link</b>", "FAIL",
					"<b>Sing Up Link</b> should be click");
		}
	}

	public boolean loginStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signInLink(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean hideProfileContentStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getProfileType(driver);
			status = Keywords.isElementPresent(element);
			Thread.sleep(2000);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occurred while Login",
					"FAIL", "Login should be done");
		}

		return status;
	}

	public void enterEmailId(String userName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signInEmail(driver);
			Keywords.typeText(element, userName);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Id entered Successfully",
						"PASS", "EmailId should be entered.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Id not entered Successfully",
						"FAIl", "EmailId should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the email id.", "FAIL", "EmailId should be entered.");
		}
	}

	public void enterEmailId() {
		enterEmailId(DriverSession.getTestCaseData().get("Username"));
	}

	public void verifyErrorMessageForLoginWithoutPassword() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignIn(driver, "password");
			Keywords.verifyTextOnPage(element.getText());
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for password must be provided display successfully", "PASS",
						"Password Required message should be Display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for password must be provided not display successfully", "FAIl",
						"Password Required message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while display error message for password must be provided", "FAIl",
					"Password Required message should be Display");
		}
	}

	public void verifyErrorMessageForLoginWithoutEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSignIn(driver, "email");
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for Email must be provided display successfully", "PASS",
						"Email must be provided message should be Display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message for Email must be provided not display successfully", "FAIl",
						"Email must be provided message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while display error message for Email must be provided", "FAIl",
					"Email must be provided message should be Display");
		}
	}

	public void verifyErrorMessageForInvalidEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForInvalidEmailId(driver);
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email is not valid error message display successfully", "PASS",
						"Email is not valid error message should be display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email is not valid error message not display successfully", "FAIL",
						"Email is not valid message should display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify message email id is not valid address", "FAIL",
					"Email is not valid message should display");
		}
	}

	public void enterPassword(String password) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signInPassword(driver);
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password entered successfully",
						"PASS", "Password should be entered.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password not entered successfully",
						"FAIL", "Password should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Password", "FAIL", "Password should be entered.");
		}
	}

	public void enterPassword() {
		enterPassword(DriverSession.getTestCaseData().get("Password"));
	}

	public void submitSingIn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitSignIn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign In button clicked successfully", "PASS", "Sign In button should be click.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign In button not clicked successfully", "FAIL", "Sign In button should be click.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occurred..", "FAIL",
					"Sign In button should be click.");
		}
	}

	public void clickForgotPasswordLink() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().forgotPassword(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot password link clicked successfully", "PASS", "Forgot Password Link should be clicked");
			}
		} catch (Exception e) {

		}
	}

	public void verifyForgotPasswordHeader() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().forgotPasswordHeader(driver);
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password header text visible successfully", "PASS",
						"Forgot Password header text should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password header text not visible successfully", "FAIL",
						"Forgot Password header text should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify the Forgot Password Text", "FAIL",
					"Forgot Password header text should be visible");
		}
	}

	public void enterForgotPasswordEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().forgotPasswordEmailId(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Username"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password email id entered successfully", "PASS",
						"Forgot Password emailId should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password email id not entered successfully", "FAIL",
						"Forgot Password emailId should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify the Forgot Password Text", "FAIL",
					"Forgot Password emailId should be entered");
		}
	}

	public void submitPasswordResetEmailAlert() {
		try {
			// Keywords.waitForPage(driver);
			Keywords.acceptAlert();

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Alert ok button click successfully", "PASS", "Alert OK button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Alert Ok button not click successfully", "FAIL", "Alert OK button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Alert Ok button", "FAIL", "Alert OK button should be click");
		}
	}

	public void submitForgotPasswordPopUp() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().sendForgotPassword(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot password <b>send</b> button click successfully", "PASS",
						"Forgot password <b>send</b> button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot password <b>send</b> button not click successfully", "FAIL",
						"Forgot password <b>send</b> button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Forgot password <b>send</b> button", "FAIL",
					"Forgot password <b>send</b> button should be click");
		}
	}

	public void gmailSingIn(String userId, String userPass) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterGmailId(driver);
			Keywords.typeText(element, userId);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(userId + " entered successfully",
						"PASS", "UserId should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(userId + " not entered successfully", "FAIL", "UserId should be entered");
			element = Locators.getInstance().clickNextBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Next button click successfully",
						"PASS", "Next button should be click");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Next button not click successfully", "FAIL", "Next button should be click");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterGmailPassword(driver);
			Keywords.typeText(element, userPass);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("UserPass entered successfully",
						"PASS", "UserPass should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("UserPass not entered successfully",
						"FAIL", "UserPass should be entered");
			element = Locators.getInstance().clickNextBtn(driver);
			Keywords.click(element);
			/*
			 * element = Locators.getInstance().gmailSignInBtn(driver);
			 * Keywords.click(element);
			 */

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Sing In button click successfully",
						"PASS", "SingIn button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sing In button not click successfully", "FAIL", "SingIn button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while signin gmail account", "FAIL", "SignIn should be done");
		}
	}

	public void emailSignIn(String url, String userId, String userPass) {
		try {
			Keywords.waitForPage(driver, 4);
			Keywords.navigateTo(url);
			gmailSingIn(userId, userPass);

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while <b>SignIn Gmail</b>", "FAIL", "<b>SignIn</b> should be done");
		}
	}

	public void openNewTabAndSingInGmail(String url, String userId, String userPass) {
		try {
			Keywords.waitForPage(driver, 4);
			/*
			 * element = Locators.getInstance().opentab(driver);
			 * Keywords.openNewTab(element);
			 */
			Keywords.navigateTo(url);
			gmailSingIn(userId, userPass);

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while <b>SignIn Gmail</b>", "FAIL", "<b>SignIn</b> should be done");
		}
	}

	public void closeTab() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().opentab(driver);
			Keywords.closeNewTab(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openResetPasswordMail() {
		List<WebElement> mailList;
		try {
			Keywords.waitForPage(driver);
			mailList = Locators.getInstance().resetMailLinkList(driver);
			Thread.sleep(10000);
			Keywords.click(mailList.get(0));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Reset password mail click successfully", "PASS", "Reset password mail should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Reset password mail not click successfully", "FAIL", "Reset password mail should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the reset password mail", "FAIL",
					"Reset password mail should be click");
		}
	}

	public void verifyPlaceOrderAndReceivedMailPrice(Float expectedPrice) {
		WebElement element;
		String txt = "";
		float actualPrice = 0.00f;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getSubTotalPrice(driver);
			txt = Keywords.getText(element).trim();
			actualPrice = Float.parseFloat(txt.substring(txt.indexOf('$') + 1, txt.length()));
			if (actualPrice == expectedPrice) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Received Mail & Place Order</b> price same", "PASS",
						"<b>Received Mail & Place Order</b> price should be same");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing </b>Received Mail & Place Order</b> price", "PASS",
					"</b>Received Mail & Place Order</b> price should be same");
		}
	}

	public void visibleChangePasswordLink() {
		List<WebElement> list;
		try {
			Keywords.waitForPageLoad(driver);
			list = Locators.getInstance().visibleHideChangePasswordLink(driver);
			if (list.size() >= 1)
				Keywords.click(list.get(list.size() - 1));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hide Expanded Content click successfully", "PASS", "Hide Expanded Content should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hide Expanded Content not click successfully", "FAIL",
						"Hide Expanded Content should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Hide Expanded Content", "FAIL",
					"Hide Expanded Content should be click");
		}
	}

	public void selectChangePasswordLink() {
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().changePasswordLink(driver);
			if (list.size() > 1)
				Keywords.click(list.get(list.size() - 1));
			else
				Keywords.click(list.get(0));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Change my password link click successfully", "PASS",
						"Change my password link should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Change my password link not click successfully", "FAIL",
						"Change my password link should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the change my password link", "FAIL",
					"Change my password link should be click");
		}
	}

	public void verifyResetPasswordHeader() {
		WebElement element;
		try {
			Thread.sleep(1000);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().headerTitle(driver);
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Reset Password header text visible successfully", "PASS",
						"Reset Password header text should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Reset Password header text not visible successfully", "FAIL",
						"Reset Password header text should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the change my password link", "FAIL",
					"Reset Password header text should be visible");
		}
	}

	public String enterNewPassword(String newPassword) {
		WebElement element;
		String updatedPass = newPassword;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterNewPassword(driver);
			Keywords.typeText(element, newPassword);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("New Password entered successfully",
						"PASS", "New Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"New Password not entered successfully", "FAIL", "New Password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the New Password Text", "FAIL",
					"New Password should be entered");
		}

		return updatedPass;
	}

	public void enterConfirmPassword(String confirmPass) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterConfirmPassword(driver);
			Keywords.typeText(element, confirmPass);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Confirm Password entered successfully", "PASS", "Confirm Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Confirm Password not entered successfully", "FAIL", "Confirm Password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Confirm Password Text", "FAIL",
					"Confirm Password should be entered");
		}
	}

	public void clickOnResetButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickonResetButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<bReset Button</b> click successfully", "PASS", "<bReset Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<bReset Button</b> not click successfully", "FAIL", "<bReset Button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the <bReset Button</b>", "FAIL",
					"<bReset Button</b> should be click");
		}
	}

	public void verifyPasswordResetMessage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyPasswordResetMessage(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Password Reset message visible successfully", "PASS",
						"Password Reset message should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Password Reset message not visible successfully", "FAIL",
						"Password Reset message should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the password reset message", "FAIL",
					"Password Reset message should be visible");
		}
	}

	public void submitResetPasswordPopUp() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitPasswordResetPopUp(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.clickByJS(element);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Password Reset</b> popup submit successfully", "PASS",
							"<b>Password Reset</b> popup should be submit");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Password Reset</b> popup not submit successfully", "FAIL",
						"<b>Password Reset</b> popup should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the <b>Password Reset</b>", "FAIL",
					"<b>Password Reset</b> popup should be submit");
		}
	}

	// *********************** admin *************************

	public void openNewTab() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().opentab(driver);
			Keywords.openNewTab(element);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySignInAndSignUpMessage() {
		WebElement element;
		String message = "You need to sign in or sign up!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().signInOrSignUpMessage(driver);
			if (Keywords.getText(element).equalsIgnoreCase(message)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>You need to sign in or sign up! visible successfully</b>", "PASS",
						"<b>You need to sign in or sign up! should be visible</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>You need to sign in or sign up! not visible successfully</b>", "FAIL",
					"<b>You need to sign in or sign up! should be visible</b>");
		}
	}
}
