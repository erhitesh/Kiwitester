package Legably.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.session.DriverSession;
import com.utilities.Keywords;

public class SignUp {

	private WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
	}

	public String FirstName() {
		String name = "";
		WebElement element;
		try {
			element = Locators.getInstance().sFName(driver);
			name = "QA" + Keywords.getRandomAlphabetic(8);
			Keywords.typeText(element, name);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Name</b> enter successfully", "PASS", "<b>First Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Name</b> not enter successfully", "FAIL", "<b>First Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>First Name</b>", "FAIL",
					"<b>First Name</b> should be entered");
		}

		return name;
	}

	public String LastName() {
		String name = "";
		WebElement element;
		try {
			element = Locators.getInstance().sLName(driver);
			name = "Tester";// + Keywords.getRandomAlphabetic(8);
			Keywords.typeText(element, name);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Last Name</b> enter successfully", "PASS", "<b>Last Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Last Name</b> not enter successfully", "FAIL", "<b>Last Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Last Name</b>", "FAIL",
					"<b>Last Name</b> should be entered");
		}

		return name;
	}

	public String emailAddress() {
		String email = "";
		WebElement element;
		try {
			element = Locators.getInstance().sEmail(driver);
			email = "qa.tester" + Keywords.getRandomIntegerBtRange(9999, 999999) + "@gmail.com";
			Keywords.typeText(element, email);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Address</b> enter successfully", "PASS", "<b>Email Address</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Address</b> not enter successfully", "FAIL",
						"<b>Email Address</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Email Address</b>", "FAIL",
					"<b>Email Address</b> should be entered");
		}

		return email;
	}

	public String password() {
		String password = "";
		WebElement element;
		try {
			element = Locators.getInstance().sPassword(driver);
			password = "RaMtEsT*#44012";
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Password</b> enter successfully", "PASS", "<b>Password</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Password</b> not enter successfully", "FAIL", "<b>Password</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Password</b>", "FAIL",
					"<b>Password</b> should be entered");
		}

		return password;
	}

	public String ConfirmPassword(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().sConfirmPassword(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirm Password</b> enter successfully", "PASS",
						"<b>Confirm Password</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirm Password</b> not enter successfully", "FAIL",
						"<b>Confirm Password</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Confirm Password</b>", "FAIL",
					"<b>Confirm Password</b> should be entered");
		}

		return password;
	}

	public void checkCaptchaCheckBox() {
		WebElement element;
		try {
			element = Locators.getInstance().switchToIframe(driver);
			driver.switchTo().frame(element);
			Thread.sleep(1000l);
			element = Locators.getInstance().sCaptchaCheckBox(driver);
			System.out.println("Status..."+element.isDisplayed());
			Keywords.click(element);
			driver.switchTo().defaultContent();
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Captcha checkbox </b> check successfully", "PASS",
						"<b>Captcha checkbox</b> should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Captcha checkbox </b> not check successfully", "FAIL",
						"<b>Captcha checkbox</b> should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the <b>Captcha checkbox</b>", "FAIL",
					"<b>Captcha checkbox</b> should be checked");
		}
	}

	public void checkTermAndConditionCheckBox() {
		WebElement element;
		try {
			element = Locators.getInstance().sTAndC(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Conditions checkbox </b> check successfully", "PASS",
						"<b>Term & Conditions checkbox</b> should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Conditions checkbox </b> not check successfully", "FAIL",
						"<b>Term & Conditions checkbox</b> should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the <b>Term & Conditions checkbox</b>", "FAIL",
					"<b>Term & Conditions checkbox</b> should be checked");
		}
	}

	public void submitSignUpForm() {
		WebElement element;
		try {
			element = Locators.getInstance().sSignUpBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Button</b> click successfully", "PASS", "<b>SignUp Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Button</b> not click successfully", "FAIL",
						"<b>SignUp Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>SignUp Button</b>", "FAIL",
					"<b>SignUp Button</b> should be clicked");
		}
	}

	public void clickOnStartBuildingYourProfile() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().startBuildingYourProfile(driver), 20);
			element = Locators.getInstance().startBuildingYourProfile(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Start Building Your Profile Button</b> click successfully", "PASS",
						"<b>Start Building Your Profile Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Start Building Your Profile Button</b> not click successfully", "FAIL",
						"<b>Start Building Your Profile Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Start Building Your Profile Button</b>", "FAIL",
					"<b>Start Building Your Profile Button</b> should be clicked");
		}
	}
}
