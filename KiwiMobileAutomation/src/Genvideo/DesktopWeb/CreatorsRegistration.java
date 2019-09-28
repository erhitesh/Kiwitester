package Genvideo.DesktopWeb;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class CreatorsRegistration {

	private WebDriver driver;
	private String linkText = "kiwi GenVideo";

	public CreatorsRegistration(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyRegistrationPageLoaded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyRegistrationPage(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Registration")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Page</b> loaded successfully", "PASS",
						"<b>Registration Page</b> should be loaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Page</b> not loaded successfully", "FAIL",
						"<b>Registration Page</b> should be loaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Registration Page</b> loaded successfully", "FAIL",
					"<b>Registration Page</b> should be loaded");
		}
	}

	public boolean verifyGetStartedStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyGetStartedStatus(driver);
			if (Keywords.getAttributeVal(element, "class").contains("active")) {
				status = true;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Get Started Page</b> Load successfully", "PASS", "<b>Get Started Page</b> should be Load");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Get Started Page</b> not Load successfully", "FAIL", "<b>Get Started Page</b> should be Load");
		}
		System.out.println("Status..." + status);
		return status;
	}

	public boolean verifySocialConnectionStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(2);
			Keywords.waitForObject(Locators.getInstance().verifySocialConnectionStatus(driver), 30);
			element = Locators.getInstance().verifySocialConnectionStatus(driver);
			if (Keywords.getAttributeVal(element, "class").contains("active")) {
				status = true;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Social Connection Page</b> Load successfully", "PASS", "<b>Social Connection Page</b> should be Load");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Social Connection Page</b> not Load successfully", "FAIL",
					"<b>Social Connection Page</b> should be Load");
		}

		return status;
	}

	public boolean verifyProfileInformationStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyProfileInformationStatus(driver);
			if (Keywords.getAttributeVal(element, "class").contains("active")) {
				status = true;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Information Page</b> Load Successfully", "PASS",
						"<b>Profile Information Page</b> should be Load");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Profile Information Page</b> Not Load Successfully", "FAIL",
					"<b>Profile Information Page</b> should be Load");
		}
		return status;
	}

	public boolean verifyAudienceAndTargetingStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(10);
			Keywords.waitForObject(Locators.getInstance().verifyAudienceAndTargetingStatus(driver), 90);
			element = Locators.getInstance().verifyAudienceAndTargetingStatus(driver);
			if (Keywords.getAttributeVal(element, "class").contains("active")) {
				status = true;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Audience & Targeting Page</b> Load Successfully", "PASS",
						"<b>Audience & Targeting Page</b> should be Load");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Audience & Targeting Page</b> Not Load Successfully", "FAIL",
					"<b>Audience & Targeting Page</b> should be Load");
		}
		return status;
	}

	public boolean verifySocialConnectionsStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(5);
			element = Locators.getInstance().verifySocialConnectionsStatus(driver);
			if (Keywords.getAttributeVal(element, "class").contains("active")) {
				status = true;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Social Connections Page</b> Load Successfully", "PASS",
						"<b>Social Connections Page</b> should be Load");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Social Connections Page</b> Not Load Successfully", "FAIL",
					"<b>Social Connections Page</b> should be Load");
		}

		return status;
	}

	public String enterCreatorFirstName() {
		String fName = "";
		WebElement element;
		try {
			fName = DriverSession.getTestCaseData().get("CreatorFirstName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterCreatorFirstName(driver);
			Keywords.typeText(element,fName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator First Name</b> enter successfully", "PASS",
						"<b>Creator First Name should be enter</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Creator First Name</b>", "FAIL",
					"<b>Creator First Name should be enter</b>");
		}
		
		return fName;
	}

	public String enterCreatorLastName() {
		String lName = "";
		WebElement element;
		try {
			lName = DriverSession.getTestCaseData().get("CreatorLastName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterCreatorLastName(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Last Name</b> enter successfully", "PASS",
						"<b>Creator Last Name should be enter</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Creator Last Name</b>", "FAIL",
					"<b>Creator Last Name should be enter</b>");
		}
		return lName;
	}

	public void enterCreatorEmailAddress() {
		WebElement element;
		int randomNumber = 0;
		String creatorEmailAdd = "kiwiautomationgen";
		try {
			randomNumber = Keywords.getRandomIntegerBtRange(999999, 99999999);
//			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterCreatorEmailAddress(driver);
			/*
			 * randomNumber =
			 * Integer.parseInt(DriverSession.getTestCaseData().get(
			 * "RandomNumber"));
			 */
			creatorEmailAdd = creatorEmailAdd + randomNumber + "@gmail.com";
			Keywords.typeText(element, creatorEmailAdd);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Email Address</b> enter successfully", "PASS",
						"<b>Creator Email Address should be enter</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Creator Email Address</b>", "FAIL",
					"<b>Creator Email Address should be enter</b>");
		}
	}

	public void updateSheetData(int randomValue) {
		DriverSession.addTestCaseData("RandomNumber", randomValue + "");
	}

	public void enterCreatorPassword() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterCreatorPassword(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Password"));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Password</b> enter successfully", "PASS",
						"<b>Creator Password should be enter</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Creator Password</b>", "FAIL",
					"<b>Creator Password should be enter</b>");
		}
	}

	public void enterCreatorConfirmPassword() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterCreatorConfirmPassword(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Password"));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Confirm Password</b> enter successfully", "PASS",
						"<b>Creator Confirm Password should be enter</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Creator Confirm Password</b>", "FAIL",
					"<b>Creator Confirm Password should be enter</b>");
		}
	}

	public void submitGetStartedPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getStartedContinueButton(driver);
			if (Keywords.isElementEnable(element)) {
				Keywords.click(element);
				//Keywords.explicitWait(4);
				//Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Get Started Continue Button</b> click successfully", "PASS",
						"<b>Get Started Continue Button should be click</b>");
			}
			Keywords.waitForObjectToInvisible(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"), 30);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Get Started Continue Button</b>", "FAIL",
					"<b>Get Started Continue Button should be click</b>");
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>> Social Connection >>>>>>>>>>>>>
	public void addGmailAccount() throws Exception {
		WebElement element = null;
		try {
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			clickOnConnectYouTube();
			String subWindowHandler = null;
			Thread.sleep(3000L);
			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			// perform operations on popup
			if (Locators.getInstance().gmailEmailAddress(driver) != null) {
				element = Locators.getInstance().gmailEmailAddress(driver);
				Keywords.typeText(element, DriverSession.getTestCaseData().get("Username"));
				element = Locators.getInstance().gmailNext(driver);
				Keywords.click(element);
				Thread.sleep(2000L);
				element = Locators.getInstance().gmailPassword(driver);
				Keywords.typeText(element, DriverSession.getTestCaseData().get("Password"));
				element = Locators.getInstance().gmailNext(driver);//element = Locators.getInstance().signIn(driver);//
				Keywords.click(element);
				Thread.sleep(5000L);
				Keywords.waitForPage(driver);
				element = Locators.getInstance().allow(driver);
				Keywords.click(element);
				Thread.sleep(5000L);
/*				while (Keywords.isElementPresent(Locators.getInstance().allow(driver)))
					Keywords.click(element);*/
			} else {
				Thread.sleep(5000L);
				element = Locators.getInstance().allow(driver);
				Keywords.click(element);
			}
			driver.switchTo().window(parentWindowHandler);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Gmail Account</b> has been added successfully", "PASS",
						"<b>Gmail Account</b> has been added successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to Add <b>Gmail Account</b> ", "FAIL", "<b>Gmail Account</b> should be Added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while Adding <b>Gmail Account</b> ", "FAIL",
					"<b>Gmail Account </b> should be Added");
			throw e;
		}
	}

	public void clickOnConnectYouTube() {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver, 30);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().connectYouTube(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Connect YouTube Button</b> click successfully", "PASS",
						"<b>Connect YouTube Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Connect YouTube Button</b> not click successfully", "FAIL",
						"<b>Connect YouTube Button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Connect YouTube Button</b>", "FAIL",
					"<b>Connect YouTube Button</b> should be click");
		}
	}

	public void verifyGmailAccountLinkToYouTube(String userName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyGmailAccountAddedToTheYoutube(driver, userName);
			if (Keywords.getText(element).equalsIgnoreCase(linkText) && Keywords.isElementPresent(element)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>kiwi tester</b> text visible successfully", "PASS",
						"<b>kiwi tester</b> text should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>kiwi tester</b> text not visible successfully", "FAIL",
						"<b>kiwi tester</b> text should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the text <b>kiwi tester</b>", "FAIL",
					"<b>kiwi tester</b> text should be visible");
		}
	}

	public void submitSocialConnectionPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForObject(Locators.getInstance().getStartedContinueButton(driver), 30);
			element = Locators.getInstance().getStartedContinueButton(driver);
			if (Keywords.isElementEnable(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Social Connection Continue Button</b> click successfully", "PASS",
						"<b>Social Connection Continue Button should be click</b>");
			}
			Keywords.waitForObjectToInvisible(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"), 30);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Social Connection Continue Button</b>", "FAIL",
					"<b>Social Connection Continue Button should be click</b>");
		}
	}

	// >>>>>>>>>>>>>>>>. Profile Information >>>>>>>>>>>>>>>>>
	public boolean selectCreatorGender(String gender) {
		boolean status = false;
		WebElement element = null;
		try {
			if (gender.equalsIgnoreCase("male")) {
				element = Locators.getInstance().CreatorGenderMale(driver);
				Keywords.click(element);
				element = Locators.getInstance().CreatorGenderMale(driver);
			} else if (gender.equalsIgnoreCase("female")) {
				element = Locators.getInstance().CreatorGenderFemale(driver);
				Keywords.click(element);
				element = Locators.getInstance().CreatorGenderFemale(driver);
			}
			status = element.getAttribute("class").contains("active");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						gender + " <b>gender clicked successfully</b>", "PASS",
						gender + " <b>gender should be clicked for Creator</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click click on gender",
						"FAIL", gender + " <b>gender should be clicked for Creator</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking gender", "FAIL",
					gender + " <b>gender should be clicked for Creator</b>");
		}
		return status;
	}

	public void verifyGender() {
		try {
			selectCreatorGender("male");
			selectCreatorGender("female");
			if (selectCreatorGender("male"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Male gender select successfully</b>", "PASS",
						"<b>Male gender button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Male gender is in the active state", "FAIL", "Male gender should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Creator Gender", "FAIL", "Verifying Creator Gender section");
		}
	}

	public void enterCreatorDate() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().creatorDate(driver);
			Keywords.typeText(element, "01/01/1990");// DriverSession.getTestCaseData().get("Date"));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>How Old are you date</b> enter successfully", "PASS",
						"<b>How Old are you date should be enter</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>How Old are you date</b> not enter successfully", "FAIL",
					"<b>How Old are you date should be enter</b>");
		}
	}

	public void selectYourHouseHoldIncome() {
		WebElement element;
		List<WebElement> houseHoldOptions;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnEnableHouseHoldIncomeList(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>House HoldIncome</b> click successfully", "PASS",
						"<b>House HoldIncome</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>House HoldIncome</b> not click successfully", "FAIL",
						"<b>House HoldIncome</b> should be click");
			houseHoldOptions = Locators.getInstance().selectHouseHoldIncome(driver);
			for (int i = 0; i < houseHoldOptions.size(); i++) {
				if (Keywords.getText(houseHoldOptions.get(i))
						.equalsIgnoreCase(DriverSession.getTestCaseData().get("HouseHoldIncome"))) {
					Keywords.click(houseHoldOptions.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>House HoldIncome Option select</b>" + Keywords.getText(houseHoldOptions.get(i))
									+ " successfully",
							"PASS", "<b>HouseHold Income Option select</b>" + Keywords.getText(houseHoldOptions.get(i))
									+ " should be selected");
					Thread.sleep(3000l);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>HouseHold Income Option</b> not successfully", "FAIL",
					"<b>HouseHold Income Option select should be selected</b>");
		}
	}

	public void selectYourEthnicity() {
		WebElement element;
		List<WebElement> ethnicityOptions;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnEnableEthnicityList(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Ethnicity</b> click successfully", "PASS", "<b>Ethnicity</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Ethnicity</b> not click successfully", "FAIL", "<b>Ethnicity</b> should be click");
			ethnicityOptions = Locators.getInstance().selectEthnicity(driver);
			for (int i = 0; i < ethnicityOptions.size(); i++) {
				if (Keywords.getText(ethnicityOptions.get(i))
						.equalsIgnoreCase(DriverSession.getTestCaseData().get("Ethnicity"))) {
					Keywords.click(ethnicityOptions.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Ethnicity Option select</b>" + Keywords.getText(ethnicityOptions.get(i))
									+ " successfully",
							"PASS", "<b>Ethnicity Option select</b>" + Keywords.getText(ethnicityOptions.get(i))
									+ " should be selected");
					Thread.sleep(3000l);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Ethnicity Option</b> not successfully", "FAIL",
					"<b>Ethnicity Option select should be selected</b>");
		}
	}

	public void enterShippingAddress1() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterShippingAddress1(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("ShippingAddress"));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping address</b> enter successfully", "PASS",
						"<b>Shipping address should be enter</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping address</b> not enter successfully", "FAIL",
						"<b>Shipping address should be enter</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Shipping address</b>", "FAIL",
					"<b>Shipping address should be enter</b>");
		}
	}

	public void enterShippingAddress2() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterShippingAddress2(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("ShippingCountry"));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping address Country</b> enter successfully", "PASS",
						"<b>Shipping address Country should be enter</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping address Country</b> not enter successfully", "FAIL",
						"<b>Shipping address Country should be enter</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Shipping address Country</b>", "FAIL",
					"<b>Shipping address Country should be enter</b>");
		}
	}

	public void enterShippingCity() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterShippingCity(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("ShippingCity"));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping City</b> enter successfully", "PASS", "<b>Shipping City should be enter</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Shipping City</b> not enter successfully", "FAIL", "<b>Shipping City should be enter</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Shipping City</b>", "FAIL",
					"<b>Shipping City should be enter</b>");
		}
	}

	public void selectCreatorCountry() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCreatorCountry(driver);
			Keywords.selectByValue(element, DriverSession.getTestCaseData().get("Country"));
			//Keywords.selectByVisibleText(element, DriverSession.getTestCaseData().get("Country"));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country Name</b> select successfully", "PASS",
					"<b>Creator Country Name</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country Name </b> not select successfully", "FAIL",
					"<b>Creator Country Name</b> should be selected");
		}
	}

	public void selectCreatorCountryState() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCreatorState(driver);
			Keywords.selectByValue(element, DriverSession.getTestCaseData().get("State"));
			//Keywords.selectByVisibleText(element, DriverSession.getTestCaseData().get("State"));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country State </b> select successfully", "PASS",
					"<b>Creator Country State</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country State </b> not select successfully", "FAIL",
					"<b>Creator Country State</b> should be selected");
		}
	}

	public void selectCreatorCountryStateCode() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCreatorStateCode(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Code"));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country State Code</b> select successfully", "PASS",
					"<b>Creator Country State Code</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Country State Code</b> not select successfully", "FAIL",
					"<b>Creator Country State Code</b> should be selected");
		}
	}

	public void submitProfileInformationPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver, 5);
			Keywords.waitForObject(Locators.getInstance().getStartedContinueButton(driver), 30);
			element = Locators.getInstance().getStartedContinueButton(driver);
			if (Keywords.isElementEnable(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Information Continue Button</b> click successfully", "PASS",
						"<b>Profile Information Continue Button should be click</b>");
			}
			Keywords.waitForObjectToInvisible(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"), 30);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Profile Information Continue Button</b>", "FAIL",
					"<b>Profile Information Continue Button should be click</b>");
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>> Audience & Targeting

	public void enterVideoOnlyRate() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().videoOnlyRate(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("VideoOnlyRate"));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Video Only Rate</b> select successfully", "PASS", "<b>Video Only Rate Should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Video Only Rate</b> not select successfully", "FAIL",
					"<b>Video Only Rate Should be selected</b>");
		}
	}

	public void enterYouTubeRate() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().youTubeRate(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("YouTubeRate"));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>YouTube Rate</b> select successfully", "PASS", "<b>YouTube Rate Should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>YouTube Rate</b> not select successfully", "FAIL", "<b>YouTube Rate Should be selected</b>");
		}
	}

	public void insertTag() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignTags(driver);
			Keywords.typeText(element, "te");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tags Name entered successfully",
						"PASS", "Tag Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to enter Tag Name", "FAIL",
						"Tag Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while entering tag name", "FAIL", "Tag Name should be entered");
		}
	}

	public void selectTags() {
		WebElement element = null;
		try {
			for (int i = 0; i < 3; ++i) {
				element = Locators.getInstance().CreatorTagResult(driver);
				Keywords.click(element);
				Thread.sleep(2000l);
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tags selected successfully",
						"PASS", "Tags should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select Tags", "FAIL",
						"Tags should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured...while selecting tags", "FAIL", "Tags should be selected");
		}
	}

	public void removeTag() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignRemoveTag(driver);
			Keywords.click(element);
			Thread.sleep(1500L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tag removed successfully", "PASS",
						"Tag should be removed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to remove Tags", "FAIL",
						"Tag should be removed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured...while removing tag", "FAIL", "Tag should be removed");
		}
	}

	public void whatKindOfVideo() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignVideoType(driver, 2);
			Keywords.click(element);
			element = Locators.getInstance().campaignVideoType(driver, 2);
			Thread.sleep(2000l);
			if (DriverSession.getStepResult() && element.getAttribute("class").contains("active"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Video Type verified successfully</b>", "PASS", "<b>Video Type should be verified</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Video Type is not verified",
						"FAIL", "Video Type should be verified");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking on video type", "FAIL", "Video Type should be clicked");
		}
	}

	public void submitAudienceAndTargetingPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getStartedContinueButton(driver);
			if (Keywords.isElementEnable(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Audience & Targeting Continue Button</b> click successfully", "PASS",
						"<b>Audience & Targeting Continue Button should be click</b>");
			}
			Keywords.waitForObjectToInvisible(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"), 30);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Audience & Targeting Continue Button</b>", "FAIL",
					"<b>Audience & Targeting Continue Button should be click</b>");
		}
	}

	// >>>>>>>>>>>>>>>>. Social Connections >>>>>>>>>>>>>>>>>>

	public void selectSocialConnections() {
		WebElement element;
		try {
			element = Locators.getInstance().socialConnectionsOptions(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook Social Connection</b> select successfully", "PASS",
						"<b>Facebook Social Connection should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Facebook Social Connection</b> select successfully", "FAIL",
					"<b>Facebook Social Connection should be selected</b>");
		}
	}

	public void enterFBUserName() {
		WebElement element;
		try {
			element = Locators.getInstance().enterFBName(driver);
			Keywords.typeText(element, "");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook User Name </b> enter successfully", "PASS",
						"<b>Facebook User Name should be enter</b>");
		} catch (Exception e) {
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook User Name </b> not enter successfully", "FAIL",
						"<b>Facebook User Name should be enter</b>");
		}
	}
	
	public void enterFBUserPass() {
		WebElement element;
		try {
			element = Locators.getInstance().enterFBPass(driver);
			Keywords.typeText(element, "");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook User Password </b> enter successfully", "PASS",
						"<b>Facebook User Password should be enter</b>");
		} catch (Exception e) {
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook User Password </b> not enter successfully", "FAIL",
						"<b>Facebook User Password should be enter</b>");
		}
	}

	public void submitFBPage() {
		WebElement element;
		try {
			element = Locators.getInstance().enterFBPass(driver);
			Keywords.typeText(element, "");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook Login Button</b> click successfully", "PASS",
						"<b>Facebook Login Button should be click</b>");
		} catch (Exception e) {
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Facebook Login Button</b> not click successfully", "FAIL",
						"<b>Facebook Login Button should be click</b>");
		}
	}

	
	public void submitCreatorRegistration() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnFinishButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Registartion Page submit successfully</b>", "PASS",
						"<b>Creator Registartion Page should be submit</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Registartion Page submit successfully</b>", "FAIL",
						"<b>Creator Registartion Page should be submit</b>");
			Keywords.waitForObjectToInvisible(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"), 20);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Finish Button</b>", "FAIL",
					"<b>Creator Registartion Page should be submit</b>");
		}
	}

	public void verifyCreatorRegistrationDoneSuccessfully() {
		WebElement element;
		try {
			Keywords.explicitWait(3);
			Keywords.waitForObject(Locators.getInstance().verifyCreatorRegistrationDone(driver), 30);
			element = Locators.getInstance().verifyCreatorRegistrationDone(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creator Registration</b> done successfully", "PASS",
						"<b>Creator Registration should be done</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Creator Registration</b> not done successfully", "FAIL",
					"<b>Creator Registration should be done</b>");
		}
	}
}
