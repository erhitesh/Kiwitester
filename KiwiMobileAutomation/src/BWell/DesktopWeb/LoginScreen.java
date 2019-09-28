package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class LoginScreen {

	private WebDriver driver;

	public LoginScreen(WebDriver driver) {
		this.driver = driver;
	}

	public boolean userEmailAddressStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().loginEmail(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void enterUserName(String username) throws Exception {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().loginEmail(driver);
			Keywords.typeText(element, username);
			// Keywords.focusOnElement(element);
			// Keywords.typeText(element,username);
			// Keywords.click(element); clickOnBWellLogo();
			// Keywords.doubleClick(driver, element);
			// Keywords.typeText(element, username);
			// Keywords.click(element);
			// element = Locators.getInstance().loginPassword(driver);
			// element.sendKeys(Keys.TAB);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email ID typed successfully<b><i>" + username + "</i></b>", "PASS",
						"Email ID name should be entered.");
			} else
				throw new Exception("Email ID not typed.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....Unable to enter email id .", "FAIL", "Should be able to enter email id.");
			throw e;
		}
	}

	public void enterUserName() throws Exception {
		enterUserName(DriverSession.getTestCaseData().get("Username"));
	}

	public void clickOnUserNameField() throws Exception {
		WebElement element;
		element = Locators.getInstance().loginEmail(driver);
		element.sendKeys(Keys.HOME);
	}

	public void enterPassword(String password) throws Exception {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().loginPassword(driver);
			Keywords.doubleClick(driver, element);
			Keywords.typeText(element, password);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password typed successfully",
						"PASS", "Password name should be entered.");
			} else
				throw new Exception("Password not typed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....Unable to enter Password", "FAIL", "Should be able to enter Password.");
			throw e;
		}
	}

	public void enterPassword() throws Exception {
		enterPassword(DriverSession.getTestCaseData().get("Password"));
	}

	public boolean verifyLoginBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().loginButton(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		// System.out.println("Ok Button Status==" + status);
		return status;
	}

	public void clickOnPasswordField() throws Exception {
		WebElement element;
		element = Locators.getInstance().loginPassword(driver);
		element.sendKeys(Keys.END);
	}

	public void loginUser() throws Exception {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().loginButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Login button clicked successfully",
						"PASS", "Should click on Login button");
			} else
				throw new Exception("Click on Login button failed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL",
					"Should click on Login button");
			throw e;
		}
	}

	public void verifyErrorMessageForLoginWithoutPassword() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForUserPassword(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Password is required"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Password is required </b>Error Message display successfully", "PASS",
						"<b>Password is required </b>error messsage should be Display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Password is required </b>Error Message not display successfully", "FAIL",
						"<b>Password is required </b>error messsage should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify error message <b>Password is required </b>", "FAIl",
					"<b>Password is required </b>error messsage should be Display");
		}
	}

	public void verifyErrorMessageForLoginWithoutEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForUserEmail(driver);
			// Keywords.verifyTextOnPage(element.getText());
			if (Keywords.getText(element).equalsIgnoreCase("Email is required"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email is required </b>error message display successfully", "PASS",
						"<b>Email is required </b>error message should be Display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email is required </b>error message not display successfully", "FAIL",
						"<b>Email is required </b>error message should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify error message<b> Email is required </b>", "FAIl",
					"<b>Email is required </b>error message should be Display");
		}
	}

	public void verifyErrorMessageForInvalidEmailId() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForInvalidEmailAddress(driver);
			Keywords.verifyTextOnPage(element.getText());
			if (Keywords.getText(element).equalsIgnoreCase("Enter a valid email address."))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Enter a valid email address. </b>error message display successfully", "PASS",
						"<b>Enter a valid email address. </b>error message should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Enter a valid email address. </b>error message not display successfully", "FAIL",
						"<b>Enter a valid email address. </b>error message should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify error message <b>Enter a valid email address.</b>", "FAIL",
					"<b>Enter a valid email address. </b>error message should be display");
		}
	}

	public void verifyErrorMessageForInvalidCredentialLogin() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().invalidCredentialErrorMessageForLogin(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Username and password do not match"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Username and password</b>error message display successfully", "PASS",
						"<b>Username and password </b>error message should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Username and password </b>error message not display successfully", "FAIL",
						"<b>Username and password </b>error message should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify error message <b>Username and password </b>", "FAIL",
					"<b>Username and password </b>error message should be display");
		}
	}

	public boolean imageLoaderStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().loaderImage(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void submitSingIn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().loginButton(driver);
			Keywords.click(element);
			if (imageLoaderStatus())
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button</b> click successfully", "PASS", "<b>Login Button</b> should be click.");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button</b> not click successfully", "FAIL", "<b>Login Button</b> should be click.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b><i>Exception occurred while submitting the LogIn button</i></b>", "FAIL",
					"<b>Login Button </b>should be click.");
		}
	}

	public void clearTextFields(String fieldName) {
		WebElement element = null;
		try {
			if (fieldName.equalsIgnoreCase("email"))
				element = Locators.getInstance().loginEmail(driver);
			else if (fieldName.equalsIgnoreCase("pass"))
				element = Locators.getInstance().loginPassword(driver);
			Keywords.clearEditField(element);
			Thread.sleep(2000l);
		} catch (Exception e) {
		}
	}

	public void loginBtnOnResetPage() {
		WebElement element;
		try {
			element = Locators.getInstance().loginBtnOnResetPage(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public boolean loginStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().loginButton(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	// Forgot Password
	public void clickOnForgotPasswordLink() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().forgotPasswordLink(driver), 5);
			element = Locators.getInstance().forgotPasswordLink(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver, 2);
			if (verifyForgotPasswordHeaderTxt())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Link </b>click successfully", "PASS",
						"<b>Forgot Password Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Link </b>not click successfully", "FAIL",
						"<b>Forgot Password Link </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Forgot Password Link </b>", "FAIL",
					"<b>Forgot Password Link </b> should be clicked");
		}
	}

	public boolean verifyForgotPasswordHeaderTxt() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().forgotPasswordHeaderTxt(driver);
			status = Keywords.isElementPresent(element);
			if (Keywords.getText(element).equalsIgnoreCase("Password Reset"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Header Text </b>found successfully", "PASS",
						"<b>Forgot Password Header Text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Header Text </b>not found successfully", "FAIL",
						"<b>Forgot Password Header Text </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Forgot Password Header Text </b>", "FAIL",
					"<b>Forgot Password Header Text </b> should be found");
		}

		return status;
	}

	public void enterForgotPasswordEmailAddress() {
		WebElement element;
		String emailAddress = "";
		try {
			emailAddress = DriverSession.getTestCaseData().get("Username");
			// verifyForgotPasswordHeaderTxt();
			element = Locators.getInstance().forgotPasswordEmailTxtBox(driver);
			Keywords.typeText(element, emailAddress);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Address for Forgot Password </b>enter successfully", "PASS",
						"<b>Email Address for Forgot Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Address for Forgot Password </b>not enter successfully", "FAIL",
						"<b>Email Address for Forgot Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Email Address for Forgot Password </b>", "FAIL",
					"<b>Email Address for Forgot Password </b>should be entered");
		}
	}

	public void submitForgotPassword() {
		WebElement element;
		try {
			element = Locators.getInstance().submitForgotPassword(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Submit Button </b>click successfully", "PASS",
						"<b>Forgot Password Submit Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Submit Button </b>not click successfully", "FAIL",
						"<b>Forgot Password Submit Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Forgot Password Submit Button </b>", "FAIL",
					"<b>Forgot Password Submit Button </b>should be clicked");
		}
	}

	public void verifyResetPasswordMailSendMessage() {
		WebElement element;
		try {
			element = Locators.getInstance().forgotPasswordLinkSendSuccessfully(driver);
			if (Keywords.getText(element).equalsIgnoreCase(
					"You should be receiving an email from us shortly with instructions on how to reset your password"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Mail Send Message </b>find successfully", "PASS",
						"<b>Forgot Password Mail Send Message </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Mail Send Message </b>not find successfully", "FAIL",
						"<b>Forgot Password Mail Send Message </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Forgot Password Header Text </b>", "FAIL",
					"<b>Forgot Password Header Text </b>should be found");
		}
	}

	// YopMail
	public void navigateToYopmail() {
		String yopmailUrl = "";
		WebElement element;
		try {
			yopmailUrl = DriverSession.getTestCaseData().get("YopMailUrl");
			element = Locators.getInstance().elementForNewTab(driver);
			Keywords.openNewTabWithJS(driver, yopmailUrl);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			element = Locators.getInstance().yopmailLogo(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>YopMail Logo </b>visible successfully", "PASS", "<b>YopMail Logo </b>should be Visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>YopMail Logo </b>not visible successfully", "FAIL",
						"<b>YopMail Logo </b>should be Visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>YopMail Logo </b> ", "FAIL",
					"<b>YopMail Logo </b>should be Visible");
		}
	}

	public void navigateToYopmail(String userId) {
		WebElement element;
		try {
			element = Locators.getInstance().elementForNewTab(driver);
			Keywords.openNewTabWithJS(driver, userId);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			element = Locators.getInstance().yopmailLogo(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>YopMail Logo </b>visible successfully", "PASS", "<b>YopMail Logo </b>should be Visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>YopMail Logo </b>not visible successfully", "FAIL",
						"<b>YopMail Logo </b>should be Visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>YopMail Logo </b> ", "FAIL",
					"<b>YopMail Logo </b>should be Visible");
		}
	}

	public void navigateToUserEmailInbox(String userName) {
		WebElement element;
		try {
			element = Locators.getInstance().yopmailEmailTextBox(driver);
			Keywords.typeText(element, userName);
			element = Locators.getInstance().checkYopmailInboxBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Inbox </b>visible successfully", "PASS", "<b>User Inbox </b> should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Inbox </b>not visible successfully", "FAIL", "<b>User Inbox </b> should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while navigating to the <b>User Inbox </b> Page", "FAIL",
					"<b>User Inbox </b>should be visible");
		}
	}

	public void selectBWellResetPasswordMail() {
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getResetPasswordMailLink(driver);
			for (WebElement webElement : elementList) {
				if (Keywords.getText(webElement).trim().equalsIgnoreCase("STAGING - Password reset request")) {
					Keywords.click(webElement);
					Keywords.switchBackToDefaultContent(driver);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Reset Password Mail </b>select successfully", "PASS",
							"<b>Reset Password Mail </b>should be selected");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Reset Password Mail </b>not select successfully", "FAIL",
							"<b>Reset Password Mail </b>should be selected");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Reset Password Mail </b>", "FAIL",
					"<b>Reset Password Mail </b>should be selected");
		}
	}

	public void verifyUserName(String userName) {
		WebElement element;
		try {
			Thread.sleep(4000);
			Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			element = Locators.getInstance().checkUserName(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Hello " + userName + ","))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Name </b>found successfully", "PASS", "<b>User Name </b>should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Name </b>not found successfully", "FAIL", "<b>User Name </b>should be present");
			Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>User Name </b>", "FAIL",
					"<b>User Name </b>should be present");
		}
	}

	public String getResetPasswordLinkAndOpenInNewTab(String openType) {
		String link = "";
		WebElement element;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			element = Locators.getInstance().getPasswordResetLink(driver);
			link = Keywords.getText(element);
			/*
			 * Keywords.performContextClick(element, driver, openType);
			 * Thread.sleep(2000); Keywords.switchToWindowHandle(driver,
			 * Keywords.getWindowHandles(driver).size() - 1);
			 * Thread.sleep(2000); Keywords.switchToIFrameByNameOrID(driver,
			 * "ifmail");
			 */
			Keywords.navigateTo(link);
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		return link;
	}

	public String forgotNewPassword() {
		String updatedPassword = "";
		WebElement element;
		try {
			updatedPassword = DriverSession.getTestCaseData().get("Password");
			element = Locators.getInstance().forgotNewPassword(driver);
			Keywords.typeText(element, updatedPassword);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot New Password </b>enter successfully", "PASS",
						"<b>Forgot New Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot New Password </b>successfully not enter", "FAIL",
						"<b>Forgot New Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Forgot New Password </b>", "FAIL",
					"<b>Forgot New Password </b>should be entered");
		}

		return updatedPassword;
	}

	public String forgotConfirmPassword() {
		String confirmPassword = "";
		WebElement element;
		try {
			confirmPassword = forgotNewPassword();
			element = Locators.getInstance().forgotConfirmPasswordt(driver);
			Keywords.typeText(element, confirmPassword);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Confirm Password </b>enter successfully", "PASS",
						"<b>Forgot Confirm Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Confirm Password </b>successfully not enter", "FAIL",
						"<b>Forgot Confirm Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Forgot Confirm Password </b>", "FAIL",
					"<b>Forgot Confirm Password </b>should be entered");
		}

		return confirmPassword;
	}

	public void submitForgotPasswordWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitForgotPasswordWindow(driver);
			if (Keywords.isElementEnable(element))
				Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Window </b>submit successfully", "PASS",
						"<b>Forgot Password Password </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Forgot Password Window </b>not submit successfully", "FAIL",
						"<b>Forgot Password Password </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Forgot Password Window </b>not submit successfully", "FAIL",
					"<b>Forgot Password Password </b>should be submit");
		}
	}

	public void verifyPasswordUpdateSuccessfully() {
		WebElement element;
		try {
			element = Locators.getInstance().passwordUpdateMessage(driver);
			if (Keywords.getText(element).contains("Your password has been successfully reset"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Your password has been successfully reset </b>message visible successfully", "PASS",
						"<b>Your password has been successfully reset </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Your password has been successfully reset </b>message not visible successfully", "FAIL",
						"<b>Your password has been successfully reset </b>should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Your password has been successfully reset </b>message",
					"FAIL", "<b>Your password has been successfully reset </b>should be visible");
		}
	}

	public void forgotPassword() {
		List<String> list;
		try {
			forgotConfirmPassword();
			submitForgotPasswordWindow();
			verifyPasswordUpdateSuccessfully();
			Keywords.closeWindow(driver);
			Thread.sleep(2000);
			list = Keywords.getWindowHandles(driver);
			Keywords.switchToWindowHandle(driver, list.size() - 1);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyUserLogout() {
		try {
			if (verifyLoginBtnStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>User </b>logout successfully",
						"PASS", "<b>User </b>should be logout");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User </b>not logout successfully", "FAIL", "<b>User </b>should be logout");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>User </b>logout or not", "FAIL",
					"<b>User </b>should be logout");
		}
	}

	// Update Password Related
	public void enterCurrrentPassword(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().currentPasswordTxt(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Password </b>enter successfully", "PASS",
						"<b>Current Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Password </b>not enter successfully", "FAIL",
						"<b>Current Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Current Password </b>", "FAIL",
					"<b>Current Password </b>should be entered");
		}
	}

	public void enterNewPassword(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().newPasswordTxt(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>New Password </b>enter successfully", "PASS", "<b>New Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>New Password </b>not enter successfully", "FAIL", "<b>New Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>New Password </b>", "FAIL",
					"<b>New Password </b>should be entered");
		}
	}

	public void enterConfirmPassword(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().confirmPasswordTxt(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirm Password </b>enter successfully", "PASS",
						"<b>Confirm Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirm Password </b>not enter successfully", "FAIL",
						"<b>Confirm Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Confirm Password </b>", "FAIL",
					"<b>Confirm Password </b>should be entered");
		}
	}

	public void clickUpdateButton() {
		try {
			Keywords.waitForPage(driver, 5);
			Keywords.clickByJS(
					"document.getElementsByName('updatePasswordForm')[0].getElementsByClassName('btn bw-btn-primary')[0].click();");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Update Button </b>click successfully", "PASS", "<b>Update Button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Update Button </b>not click successfully", "FAIL", "<b>Update Button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Update Button </b>", "FAIL",
					"<b>Update Button </b>should be click");
		}
	}

	public void verifyRequiredFieldsErrorMessage() {
		String errorMessage = "";
		List<WebElement> messageElementList;
		try {
			errorMessage = DriverSession.getTestCaseData().get("RequiredFieldsErrorMessage");
			messageElementList = Locators.getInstance().requiredFieldsErrorMessage(driver);

			if (messageElementList.size() == 3)
				for (int i = 0; i < messageElementList.size(); i++) {
					if (Keywords.getText(messageElementList.get(i)).equalsIgnoreCase(errorMessage))
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b><i>This is required </i></b>message visible successfully", "PASS",
								"<b>This is required </b>message should be visible.");
				}
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>This is required </i></b>message not visible successfully", "FAIL",
						"<b>This is required </b>message should be visible.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error Message<b><i>This is required </i></b>fields", "FAIL",
					"<b>This is required </b>message should be visible.");
		}
	}

	public void verifyPasswordFormatErrorMessage() {
		String errorMessage = "";
		WebElement element;
		try {
			errorMessage = DriverSession.getTestCaseData().get("PasswordFormatErrorMessage");
			element = Locators.getInstance().passwordFormatError(driver);
			if (Keywords.getText(element).contains(errorMessage))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>New & Confirm Password </i></b>error message match successfully", "PASS",
						"<b>New & Confirm Password </b>message should be matched.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>New & Confirm Password </i></b>error message not match successfully", "FAIL",
						"<b>New & Confirm Password </b>message should be matched.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error Message for <b><i>New & Confirm Password </i></b>",
					"FAIL", "<b>New & Confirm Password </b>message should be matched.");
		}
	}

	public void verifyPasswordNotMatchedErrorMessage() {
		String errorMessage = "";
		WebElement element;
		try {
			errorMessage = DriverSession.getTestCaseData().get("PasswordNotMatched");
			element = Locators.getInstance().passwordNotMatchedErrorMessage(driver);
			if (Keywords.getText(element).equalsIgnoreCase(errorMessage))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>New & Confirm Password </i></b>error message match successfully", "PASS",
						"<b>New & Confirm Password </b>message should be matched.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>New & Confirm Password </i></b>error message not match successfully", "FAIL",
						"<b>New & Confirm Password </b>message should be matched.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error Message for <b><i>New & Confirm Password </i></b>",
					"FAIL", "<b>New & Confirm Password </b>message should be matched.");
		}
	}

	public boolean okBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().okBtn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void verifyUserLogoutAfterFiveSeconds() {
		WebElement element;
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - USER LOGOUT AFTER PASSWORD UPDATE</b>");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			element = Locators.getInstance().verifySuccessfullyPasswordUpdateMessage(driver);
			if (Keywords.isElementPresent(element)) {
				// long before = Keywords.getTimeBasedOnFormat("second");
				Keywords.explicitWait(5);
				if (!okBtnStatus()) {
					verifyUserLogout();
					DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Ok button </b>not visible",
							"PASS", "<b>Ok button </b>should not be visible.");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing visibility of <b>Ok button </b>", "FAIL",
					"<b>Ok button </b>should not ne visible");
		}
	}

	public String updatePasswordWithInvalidData() {
		String currentPassword = "";
		try {
			currentPassword = DriverSession.getTestCaseData().get("Password");
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - UPDATE PASSWORD REQUIRED FIELDS</b>");
			clickUpdateButton();
			verifyRequiredFieldsErrorMessage();
			Keywords.refreshPage(driver);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - INVALID PASSWORD FORMAT</b>");
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(DriverSession.getTestCaseData().get("InvalidPassword"));
			verifyPasswordFormatErrorMessage();
			Keywords.refreshPage(driver);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - INVALID PASSWORD FORMAT WITH SPACES</b>");
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(DriverSession.getTestCaseData().get("PasswordWithSpaces"));
			verifyPasswordFormatErrorMessage();
			Keywords.refreshPage(driver);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - INVALID PASSWORD FORMAT WITH MIN LENGHT</b>");
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(DriverSession.getTestCaseData().get("MinLengthPassword"));
			verifyPasswordFormatErrorMessage();
			Keywords.refreshPage(driver);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - INVALID PASSWORD FORMAT WITH MAX LENGHT</b>");
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(DriverSession.getTestCaseData().get("MaxLengthPassword"));
			verifyPasswordFormatErrorMessage();
			Keywords.refreshPage(driver);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - PASSWORD NOT MATCHED</b>");
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(DriverSession.getTestCaseData().get("NewPassword"));
			enterConfirmPassword(DriverSession.getTestCaseData().get("ConfirmPassword"));
			clickUpdateButton();
			verifyPasswordNotMatchedErrorMessage();
			Keywords.refreshPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentPassword;
	}

	public String updatePasswordWithValidData() {
		String currentPassword = "";
		try {
			currentPassword = DriverSession.getTestCaseData().get("Password");
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
					"<b>TESTCASE 7 - UPDATE PASSWORD WITH VALID DATA</b>");
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.selectProfileSubTask("Security Settings");
			enterCurrrentPassword(currentPassword);
			enterNewPassword(currentPassword);
			enterConfirmPassword(currentPassword);
			clickUpdateButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentPassword;
	}

	public boolean checkRegistartionCodeTxt() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().registrationCodeTxt(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public String getRegistrationCode() {
		String registrationCode = "";
		WebElement element;
		try {
			element = Locators.getInstance().registrationCodeTxt(driver);
			registrationCode = Keywords.getText(element);
			registrationCode = registrationCode.substring(registrationCode.indexOf("code ")+5, registrationCode.indexOf(" on the same screen"));//registrationCode.indexOf("code ") + 5,registrationCode.indexOf(","));//
		} catch (Exception e) {
		}

		return registrationCode;
	}

	public String getRegistrationCodeFromSubscription() {
		String registration_code = "";
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSubscriptionCodeMailLink(driver);
			if (Keywords.getText(elementList.get(0)).contains("STAGING - You've been invited to join")) {
				Keywords.click(elementList.get(0));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				if (checkRegistartionCodeTxt())
					registration_code = getRegistrationCode();
				Keywords.switchBackToDefaultContent(driver);
			}
			// } else {
			// Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			// Keywords.click(elementList.get(1));
			// Keywords.explicitWait(2);
			// Keywords.switchBackToDefaultContent(driver);
			// Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			// if (checkPasswordInMail())
			// password = getPasswordFromMail();
			// }
		} catch (Exception e) {
		}
		return registration_code;
	}

	public void verifyResponseNotSendBackToMail() {
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSubscriptionCodeMailLink(driver);
			if (Keywords.getText(elementList.get(0)).contains("STAGING - You've been invited to join"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code </b> send", "BUF",
						"<b>Registration Code </b>should not be send To User.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code </b> not send", "PASS",
						"<b>Registration Code </b>should not be send To User.");
		} catch (Exception e) {
		}
	}
}
