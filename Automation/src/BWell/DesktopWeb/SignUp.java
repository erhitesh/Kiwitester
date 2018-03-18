package BWell.DesktopWeb;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class SignUp {

	private WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignUpLink() {
		WebElement element;
		try {
			element = Locators.getInstance().sigUpLink(driver);
			Keywords.click(element);
			Keywords.explicitWait(10);
			if (Keywords.verifyPageLoaded(driver, "onboarding"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Link </b>click successfully", "PASS", "<b>SignUp Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Link </b>not click successfully", "FAIL", "<b>SignUp Link </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>SignUp Link </b>", "FAIL",
					"<b>SignUp Link </b>should be clicked");
		}
	}

	public void submitInfo() {
		WebElement element;
		try {
			element = Locators.getInstance().submitInfo(driver);
			Keywords.click(element);
			Keywords.explicitWait(5);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 20);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button </b>click successfully", "PASS", "<b>Submit Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button </b>not click successfully", "FAIL",
						"<b>Submit Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Submit Button</b>", "FAIL",
					"<b>Submit Button </b>should be clicked");
		}
	}

	public boolean signUpBtnVisibility() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().sigUpLink(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void submitSignUpInfo() {
		WebElement element;
		try {
			while (signUpBtnVisibility()) {
				element = Locators.getInstance().sigUpLink(driver);
				Keywords.click(element);
				Keywords.explicitWait(2);
			}
			//Locators.getInstance().waitImageLoaderToBeInvisible(driver, 30);
			if (Keywords.verifyPageLoaded(driver, "onboarding"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Link </b>successfully clicked", "PASS", "<b>SignUp Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp Link </b>successfully not clicked", "FAIL", "<b>SignUp Link </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>SignUp Link</b>", "FAIL",
					"<b>SignUp Link </b>should be clicked");
		}
	}

	public boolean oopsSomethingWentWrongStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().errorMsgWhileSubmitSignupInfo(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void verifyErrorMsgWhileSubmitSignupInfo() {
		WebElement element;
		try {
			if (oopsSomethingWentWrongStatus()) {
				element = Locators.getInstance().refreshBtn(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>OOps Something Went Wrong message Msg</b>display successfully", "FAIL",
						"OOps Something Went Wrong message Msg should not be display");
			} else {
			}

		} catch (Exception e) {

		}
	}

	public String enterEmailAddress(String emailAddress) {
		WebElement element;
		try {
			emailAddress = emailAddress + Keywords.getRandomIntegerBtRange(9999, 99999) + "@yopmail.com";
			element = Locators.getInstance().signUpEmailAddress(driver);
			Keywords.typeText(element, emailAddress);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Email Address </b>enter successfully", "PASS",
						"SignUp <b>Email Address </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Email Address </b>not enter successfully", "FAIL",
						"SignUp <b>Email Address </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring the SignUp <b>Email Address </b>", "FAIL",
					"SignUp <b>Email Address </b>should be entered");
		}

		return emailAddress;
	}

	public String email() {
		return enterEmailAddress(DriverSession.getTestCaseData().get("Email"));
	}

	public String enterPassword(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().signUpPassword(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Password </b>enter successfully", "PASS",
						"SignUp <b>Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Password </b>not enter successfully", "FAIL",
						"SignUp <b>Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring the SignUp <b>Password </b>", "FAIL",
					"SignUp <b>Password </b>should be entered");
		}

		return password;
	}

	public String password() {
		return enterPassword(DriverSession.getTestCaseData().get("Password"));
	}

	public String enterConfirmPassword(String confirmPassword) {
		WebElement element;
		try {
			element = Locators.getInstance().signUpConfirmPassword(driver);
			Keywords.typeText(element, confirmPassword);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Confirm Password </b>enter successfully", "PASS",
						"SignUp <b>Confirm Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Confirm Password </b>not enter successfully", "FAIL",
						"SignUp <b>Confirm Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring the SignUp <b>Confirm Password </b>", "FAIL",
					"SignUp <b>Confirm Password </b>should be entered");
		}

		return confirmPassword;
	}

	public String confirmPassword() {
		return enterConfirmPassword(DriverSession.getTestCaseData().get("ConfirmPassword"));
	}

	public String enterSignUpFName(String fName) {
		WebElement element;
		try {
			fName = fName + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().signUpFirstName(driver);
			Keywords.typeText(element, fName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>First Name </b>enter successfully", "PASS",
						"SignUp <b>First Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>First Name </b>not enter successfully", "FAIL",
						"SignUp <b>First Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring the SignUp <b>First Name </b>", "FAIL",
					"SignUp <b>First Name </b>should be entered");
		}

		return fName;
	}

	public String enterFName() {
		return enterSignUpFName(DriverSession.getTestCaseData().get("FirstName"));
	}

	public String enterSignUpLName(String lName) {
		WebElement element;
		try {
			lName = lName + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().signUpLastName(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Last Name </b>enter successfully", "PASS",
						"SignUp <b>Last Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Last Name </b>not enter successfully", "FAIL",
						"SignUp <b>Last Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring the SignUp <b>Last Name </b>", "FAIL",
					"SignUp <b>Last Name </b>should be entered");
		}

		return lName;
	}

	public String enterLName() {
		return enterSignUpLName(DriverSession.getTestCaseData().get("LastName"));
	}

	public String selectGender(/* String gOption */) {
		int randomNumber = 0;
		String gender = "";
		List<WebElement> genderList;
		try {
			Keywords.clickByJS("class", Locators.getInstance().enableDropDown());
			genderList = Locators.getInstance().signUpGenderList(driver);
			randomNumber = Keywords.getRandomInteger(genderList.size());
			gender = Keywords.getText(genderList.get(randomNumber));
			Keywords.click(genderList.get(randomNumber));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Gender </b>selected successfully", "PASS", "<b>Gender </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Gender </b>not selected successfully", "FAIL", "<b>Gender </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Gender </b>", "FAIL", "<b>Gender </b>should be selected");
		}

		return gender;
	}

	public String enterPhoneNumber(String phoneNo) {
		WebElement element;
		try {
			element = Locators.getInstance().signUpPhoneNumber(driver);
			Keywords.typeText(element, phoneNo);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Phone Number </b>enter successfully", "PASS",
						"SignUp <b>Phone Number </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Phone Number </b>not enter successfully", "FAIL",
						"SignUp <b>Phone Number </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the SignUp <b>Phone Number </b>", "FAIL",
					"SignUp <b>Phone Number </b>should be entered");
		}

		return phoneNo;
	}

	public String enterPhoneNumber() {
		return enterPhoneNumber(DriverSession.getTestCaseData().get("PhoneNumber"));
	}

	public void selectSignUpAsPartOfCompanyOrFamily(String option) {
		try {
			Keywords.clickByJS("id", Locators.getInstance().getPartOfCompanyOrFamily(option));
			if (option.equalsIgnoreCase("yes")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp As Part Of Comapany Or Family </b>select successfully", "PASS",
						"<b>SignUp As Part Of Comapany Or Family </b>should be select");
				registrationCode();
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>SignUp As Part Of Comapany Or Family</b>not select successfully", "PASS",
						"<b>SignUp As Part Of Comapany Or Family</b>should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>SignUp As Part Of Comapany Or Family</b>", "FAIL",
					"<b>SignUp As Part Of Comapany Or Family</b>should be select");
		}
	}

	public void signUpWithRegistrationCode(String registrationCode) {
		try {
			enterRegistrationCode(registrationCode);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Registration Code while doing signup</b>", "FAIL",
					"<b>Registration code </b>should be entered");
		}
	}

	public void selectSignUpAsPartOfCompanyOrFamily() {
		selectSignUpAsPartOfCompanyOrFamily(DriverSession.getTestCaseData().get("Option"));
	}

	public String enterRegistrationCode(String registrationCode) {
		WebElement element;
		try {
			element = Locators.getInstance().signUpRegistrationCode(driver);
			Keywords.typeText(element, registrationCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Registration Code </b>enter successfully", "PASS",
						"SignUp <b>Registration Code </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignUp <b>Registration Code </b>not enter successfully", "PASS",
						"SignUp <b>Registration Code </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the SignUp <b>Registration Code </b>", "FAIL",
					"SignUp <b>Registration Code </b>should be entered");
		}

		return registrationCode;
	}

	public String registrationCode() {
		return enterRegistrationCode(DriverSession.getTestCaseData().get("RegistrationCode"));
	}

	public void clickOnNextButton() {
		WebElement element;
		try {
			element = Locators.getInstance().signUpNextBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign Up<b>Next Button </b>click successfully", "PASS",
						"Sign Up<b>Next Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sign Up<b>Next Button </b>not click successfully", "FAIL",
						"Sign Up<b>Next Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting Sign Up <b>Next Button </b>", "FAIL",
					"Sign Up<b>Next Button </b>should be clicked");
		}
	}

	public int selectYearValue(String yearValue) {
		List<WebElement> yearList;
		int randomYear = 0;
		try {
			FamilyHistory family = new FamilyHistory(driver);
			Keywords.waitForPage(driver);
			// randomYear =
			// Keywords.getRandomIntegerBtRange(Integer.parseInt(DriverSession.getTestCaseData().get("MinYearRange")),Integer.parseInt(DriverSession.getTestCaseData().get("MaxYearRange")));
			randomYear = Integer.parseInt(yearValue);// randomYear = 2017;
			yearList = Locators.getInstance().yearsList(driver);
			while (Integer.parseInt(Keywords.getText(yearList.get(0))) > randomYear) {
				family.clickOnPreviousBtn();
				yearList = Locators.getInstance().yearsList(driver);
			}
			for (int i = 0; i < yearList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(yearList.get(i))) == randomYear) {
					Keywords.click(yearList.get(i));
					break;
				}
			}
		} catch (Exception e) {
		}

		return randomYear;
	}

	public String selectMonthValue(String monthValue) {
		List<WebElement> monthList;
		String randomMonthValue = "";
		// int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			// randomMonthValue = Keywords.randomMonthValue();
			randomMonthValue = Keywords.getMonthValueBasedOnIndex("shortform", monthValue);
			monthList = Locators.getInstance().monthsList(driver);
			for (int i = 0; i < monthList.size(); i++) {
				if (Keywords.getText(monthList.get(i)).equalsIgnoreCase(randomMonthValue)) {
					Keywords.click(monthList.get(i));
					Keywords.explicitWait(2);
					break;
				}
			}
		} catch (Exception e) {
		}

		return monthValue;
	}

	public String selectDayValue(String dayValue) {
		String originalDayValue = dayValue.replaceAll("^0*", "");
		List<WebElement> dayList;
		try {
			Keywords.waitForPage(driver);
			// if (dayValue.length() <= 1)
			// dayValue = "0" + dayValue;
			dayList = Locators.getInstance().daysList(driver);
			for (int i = 0; i < dayList.size(); i++) {
				if (Keywords.getText(dayList.get(i)).equalsIgnoreCase(originalDayValue)) {
					// dayValue = Keywords.getText(dayList.get(i));
					Keywords.click(dayList.get(i));
					Keywords.explicitWait(2);
					break;
				}
			}
		} catch (Exception e) {
		}

		return originalDayValue;
	}

	public void verifySelectedMonthValue(String monthValue) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifySelectYearMonthValue(driver);
			if (Keywords.getText(element).contains(Keywords.getMonthValueInDifferentFormat("full").get(monthValue)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Month value visible successfully</b>", "PASS",
						"<b>Selected Month value should be present</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Month value not visible successfully</b>", "FAIL",
						"<b>Selected Month value should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Selected Month value</b>", "FAIL",
					"<b>Selected Month value should be present</b>");
		}
	}

	public String userDOB(String dateFor) {
		int year = 0;
		String dayValue = "";
		String monthValue = "";
		String dob = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			FamilyHistory family = new FamilyHistory(driver);
			Keywords.waitForObject(Locators.getInstance().enableSignUpDOBWindow(driver), 5);
			Keywords.clickByJS("name", Locators.getInstance().getSignUpWindowLocator());
			while (!family.verifyYearMonthViewVisible("year"))
				family.changeYearMonthDayView();
			year = selectYearValue(Keywords.getValueFromDate(dateFor, "year"));
			family.verifySelectedYearValue(year);
			while (!family.verifyYearMonthViewVisible("month"))
				family.changeYearMonthDayView();
			if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
				Keywords.explicitWait(2);
				elementList = Locators.getInstance().monthsList(driver);
				for (int i = 0; i < elementList.size(); i++) {
					if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(Keywords.getCurrentYMDValue("month"))) {
						monthValue = Keywords.getText(elementList.get(i));
						elementList.get(i).click();
						break;
					}
				}
			} else
				monthValue = selectMonthValue(Keywords.getValueFromDate(dateFor, "month"));
			verifySelectedMonthValue(monthValue);
			while (!family.verifyDayViewVisible("weeks"))
				family.changeYearMonthDayView();
			if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
				element = Locators.getInstance().selectCurrentDayValue(driver);
				if (Keywords.getText(element).equalsIgnoreCase(Keywords.getCurrentYMDValue("day")))
					dayValue = Keywords.getText(element);
				Keywords.click(element);
			} else
				dayValue = selectDayValue(Keywords.getValueFromDate(dateFor, "day"));
			dayValue = new DecimalFormat("00").format(Integer.parseInt(dayValue));
			dob = monthValue + "/" + dayValue + "/" + year;
			element = Locators.getInstance().enableSignUpDOBWindow(driver);
			if (dob.contains(Keywords.getText(element)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + " <b>User DOB select successfully</b>", "PASS",
						dateFor.toUpperCase() + " <b>User DOB </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + " <b>User DOB not select successfully</b>", "FAIL",
						dateFor.toUpperCase() + " <b>User DOB </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while selecting the " + dateFor.toUpperCase() + " <b>User DOB</b>", "FAIL",
					dateFor.toUpperCase() + " <b>User DOB </b>should be selected</b>");
		}
		return dob;
	}

	public String userDOB() {
		return userDOB(DriverSession.getTestCaseData().get("DOB"));
	}

	public String selectSubscriptionPlan() {
		int randomNumber = 0;
		String planValue = "";
		List<WebElement> planElementList;
		try {
			Keywords.waitForObject(Locators.getInstance().subscriptionPlanTxt(driver), 10);
			Keywords.clickByJS("class", Locators.getInstance().enableDropDown());
			planElementList = Locators.getInstance().getSubscriptionPlanList(driver);
			randomNumber = Keywords.getRandomInteger(planElementList.size());
			planValue = Keywords.getText(planElementList.get(randomNumber));
			Keywords.click(planElementList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Plan <b/>select successfully", "PASS",
						"<b>Subscription Plan <b/>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Plan <b/>not select successfully", "FAIL",
						"<b>Subscription Plan <b/>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Subscription Plan <b/>", "FAIL",
					"<b>Subscription Plan <b/>should be selected");
		}

		return planValue;
	}

	public void applyPromoCode(String code) {
		WebElement element;
		try {
			element = Locators.getInstance().signUpPromoCode(driver);
			Keywords.typeText(element, code);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code </b>apply successfully", "PASS", "<b>Promo Code </b>should be applied");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code </b>not apply successfully", "FAIL", "<b>Promo Code </b>should be applied");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while appling the <b>Promo Code </b>", "FAIL",
					"<b>Promo Code </b>should be applied");
		}
	}

	public String creditCard(String card) {
		String cardNumber = "";
		WebElement element;
		try {
			element = Locators.getInstance().creditCardNumber(driver);
			Keywords.typeText(element, card);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Credit Card Number </b>enter successfully", "PASS",
						"<b>Credit Card Number </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Credit Card Number </b>not enter successfully", "FAIL",
						"<b>Credit Card Number </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Credit Card Number </b>", "FAIL",
					"<b>Credit Card Number </b>should be entered");
		}

		return cardNumber;
	}

	public String creditCard() {
		return creditCard(DriverSession.getTestCaseData().get("CCN"));
	}

	public String whichCCWantToUse() {
		int randomNumber = 0;
		String cc = "";
		WebElement element;
		List<WebElement> ccoptionslist;
		try {
			Keywords.waitForObject(Locators.getInstance().enableCCDropDown(driver), 10);
			element = Locators.getInstance().enableCCDropDown(driver);
			Keywords.click(element);
			Keywords.explicitWait(3);
			ccoptionslist = Locators.getInstance().ccOptions(driver);
			if (ccoptionslist.size() == 1) {
				Keywords.click(ccoptionslist.get(ccoptionslist.size()-1));
				cc = creditCard(DriverSession.getTestCaseData().get("CardNumber"));
				String date = DriverSession.getTestCaseData().get("CCExpiryDate");
				ccExpirationDate(date);
				cvvNumber();
				selectSameAsNameOnAccountCheckBox(true);
				whichAddressWantToUse();
			}else {
				randomNumber = Keywords.getRandomInteger(ccoptionslist.size()-2);
				if (Keywords.getText(ccoptionslist.get(randomNumber)).contains("ending")) {
					cc = Keywords.getText(ccoptionslist.get(randomNumber));
					Keywords.click(ccoptionslist.get(randomNumber));
				}
			}
		} catch (Exception e) {}

		return cc;
	}

	public String ccExpirationDate(String dateFor) {
		int year = 0;
		//String dayValue = "";
		String monthValue = "";
		String dob = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			FamilyHistory family = new FamilyHistory(driver);
			Keywords.waitForObject(Locators.getInstance().enableSignUpCCExpiryDateWindow(driver), 5);
			Keywords.clickByJS(ElementEnum.Name.getElementType(),
					Locators.getInstance().getSignUpExpiryWindowLocator());
			while (!family.verifyYearMonthViewVisible("year"))
				family.changeYearMonthDayView();
			year = selectYearValue(Keywords.getValueFromDate(dateFor, "year"));
			family.verifySelectedYearValue(year);
			while (!family.verifyYearMonthViewVisible("month"))
				family.changeYearMonthDayView();
			if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
				Keywords.explicitWait(2);
				elementList = Locators.getInstance().monthsList(driver);
				for (int i = 0; i < elementList.size(); i++) {
					if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(Keywords.getCurrentYMDValue("month"))) {
						monthValue = Keywords.getText(elementList.get(i));
						elementList.get(i).click();
						break;
					}
				}
			} else
				monthValue = selectMonthValue(Keywords.getValueFromDate(dateFor, "month"));
			// verifySelectedMonthValue(monthValue);
			// while (!family.verifyDayViewVisible("weeks"))
			// family.changeYearMonthDayView();
			// if (year ==
			// Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
			// element = Locators.getInstance().selectCurrentDayValue(driver);
			// if
			// (Keywords.getText(element).equalsIgnoreCase(Keywords.getCurrentYMDValue("day")))
			// dayValue = Keywords.getText(element);
			// Keywords.click(element);
			// } else
			// dayValue = selectDayValue(Keywords.getValueFromDate(dateFor,
			// "day"));
			// dayValue = new
			// DecimalFormat("00").format(Integer.parseInt(dayValue));
			// dob = monthValue + "/" + dayValue + "/" + year;
			dob = monthValue + "/" + year;
			element = Locators.getInstance().enableSignUpCCExpiryDateWindow(driver);
			if (dob.contains(Keywords.getText(element)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + " <b>CC Expiry Date select successfully</b>", "PASS",
						dateFor.toUpperCase() + " <b>CC Expiry Date </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + " <b>CC Expiry Date not select successfully</b>", "FAIL",
						dateFor.toUpperCase() + " <b>CC Expiry Date </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>CC Expiry Date</b>" + dateFor.toUpperCase(), "FAIL",
					dateFor.toUpperCase() + " <b>CC Expiry Date </b>should be selected");
		}
		return dob;
	}

	public String ccExpirationDate() {
		return ccExpirationDate(DriverSession.getTestCaseData().get("CCExpiryDate"));
	}

	public String cvvNumber(String cvv) {
		WebElement element;
		try {
			element = Locators.getInstance().cvvNumber(driver);
			Keywords.typeText(element, cvv);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CVV Number </b>enter successfully", "PASS", "<b>CVV Number </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CVV Number </b>not enter successfully", "FAIL", "<b>CVV Number </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>CVV Number </b>", "FAIL",
					"<b>CVV Number </b>should be entered");
		}

		return cvv;
	}

	public String cvvNumber() {
		return cvvNumber(DriverSession.getTestCaseData().get("CVV"));
	}

	public String getNameOnCard() {
		String name = "";
		try {
			name = Keywords.getTextByJS(ElementEnum.Name.getElementType(), Locators.getInstance().nameOnCard());
		} catch (Exception e) {
		}

		return name;
	}

	public void selectSameAsNameOnAccountCheckBox(boolean options) {
		WebElement element;
		try {
			element = Locators.getInstance().sameAsNameOnAccount(driver);
			if (!Keywords.getAttributeVal(element, "class").contains("selected") && options)
				Keywords.clickByJS("class", Locators.getInstance().checkSameAsNameOnAccount());
			else if (Keywords.getAttributeVal(element, "class").contains("selected") && !options)
				Keywords.clickByJS("class", Locators.getInstance().unCheckSameAsNameOnAccount());
		} catch (Exception e) {
		}
	}

	public void whichAddressWantToUse() {
		int randomNumber = 0;
		WebElement element;
		List<WebElement> addressList;
		try {
			Keywords.waitForObject(Locators.getInstance().enableAddresDropdown(driver), 10);
			element = Locators.getInstance().enableAddresDropdown(driver);
			Keywords.click(element);
			addressList = Locators.getInstance().getAddressList(driver);
//			randomNumber = Keywords.getRandomInteger(addressList.size());
//			if (Keywords.getText(addressList.get(randomNumber)).contains("Home Address"))
//				Keywords.click(addressList.get(randomNumber));
//			else if (Keywords.getText(addressList.get(addressList.size()-1)).equalsIgnoreCase("Add New")){
//				Keywords.click(addressList.get(addressList.size()-1));
//				addressLine1();
//				addressLine2();
//				zipCode();
//				verifyCityAndStateBasedOnZipCode();
//			}
			Keywords.click(addressList.get(addressList.size()-1));
			addressLine1();
			addressLine2();
			zipCode();
			verifyCityAndStateBasedOnZipCodeForSubscribeUser();
		} catch (Exception e) {

		}
	}

	public String addressLine1(String address) {
		WebElement element;
		try {
			element = Locators.getInstance().addressLine1(driver);
			Keywords.typeText(element, address);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Address Line 1 </b>enter successfully", "PASS", "<b>Address Line 1 </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Address Line 1 </b>not enter successfully", "FAIL",
						"<b>Address Line 1 </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Address Line 1 </b>", "FAIL",
					"<b>Address Line 1 </b>should be entered");
		}

		return address;
	}

	public String addressLine1() {
		return addressLine1(DriverSession.getTestCaseData().get("Address1"));
	}

	public String addressLine2(String address) {
		WebElement element;
		try {
			element = Locators.getInstance().addressLine2(driver);
			Keywords.typeText(element, address);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Address Line 2 </b>enter successfully", "PASS", "<b>Address Line 2 </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Address Line 1 </b>not enter successfully", "FAIL",
						"<b>Address Line 2 </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Address Line 2 </b>", "FAIL",
					"<b>Address Line 2 </b>should be entered");
		}

		return address;
	}

	public String addressLine2() {
		return addressLine2(DriverSession.getTestCaseData().get("Address2"));
	}

	public String zipCode(String zipcode) {
		WebElement element;
		try {
			element = Locators.getInstance().userZipCode(driver);
			Keywords.typeText(element, zipcode);
			Keywords.explicitWait(4);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Zip Code </b>enter successfully", "PASS", "<b>Zip Code </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Zip Code </b>not enter successfully", "FAIL", "<b>Zip Code </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Zip Code </b>", "FAIL", "<b>Zip Code </b>should be entered");
		}

		return zipcode;
	}

	public String invalidZipCode(String zipcode) {
		WebElement element;
		try {
			element = Locators.getInstance().userZipCode(driver);
			Keywords.typeText(element, zipcode);
			Keywords.explicitWait(2);
			Keywords.pressKey(element, "tab");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Zip Code </b>enter successfully", "PASS", "<b>Zip Code </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Zip Code </b>not enter successfully", "FAIL", "<b>Zip Code </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Zip Code </b>", "FAIL", "<b>Zip Code </b>should be entered");
		}

		return zipcode;
	}

	public String zipCode() {
		return zipCode(DriverSession.getTestCaseData().get("ZipCode"));
	}

	public String getState() {
		String state = "";
		WebElement element;
		try {
			element = Locators.getInstance().getSelectedState(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().userCity(driver);
			state = Keywords.getText(element);
		} catch (Exception e) {
		}

		return state;
	}

	public String getCityName() {
		String city = "";
		WebElement element;
		try {
			element = Locators.getInstance().userCity(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().userCity(driver);
			city = Keywords.getText(element);
		} catch (Exception e) {
		}

		return city;
	}

	public void verifyCityAndStateBasedOnZipCode() {
		WebElement element;
		try {
			element = Locators.getInstance().sigUpLink(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (getCityName().length() > 0 && getState().length() > 0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>City & State Value </b>successfully visible", "PASS",
						"<b>City & State Value </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>City & State Value </b>not successfully visible", "FAIL",
						"<b>City & State Value </b>should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>City & State Value </b>", "FAIL",
					"<b>City & State Value </b>should be visible");
		}
	}
	
	public void verifyCityAndStateBasedOnZipCodeForSubscribeUser() {
		WebElement element;
		try {
			element = Locators.getInstance().submitInfo(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (getCityName().length() > 0 && getState().length() > 0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>City & State Value </b>successfully visible", "PASS",
						"<b>City & State Value </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>City & State Value </b>not successfully visible", "FAIL",
						"<b>City & State Value </b>should be visible");
		} catch (Exception e) {
		}
	}

	public void verifyNameOnCardBeforeCheck() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.getNameOnCard().length() == 0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Name </b> visible successfully", "PASS", "<b>No Name </b>should be visible.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Name </b> visible successfully",
						"FAIL", "<b>No Name </b>should be visible.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Name inside Name on Card", "FAIL",
					"<b>No Name </b>should be visible.");
		}
	}

	public void verifyNameOnCardAfterCheck(String FAndLName) {
		try {
			SignUp signup = new SignUp(driver);
			if (signup.getNameOnCard().equalsIgnoreCase(FAndLName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Name </b> visible successfully",
						"PASS", "<b>Name </b>should be visible.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Name </b> not visible successfully", "FAIL", "<b>Name </b>should be visible.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Name Inside Name on Card after selecting the check box", "FAIL",
					"<b>Name </b>should be visible.");
		}
	}

	public void verifyWelcomeBackMessage() {
		WebElement element;
		try {
			element = Locators.getInstance().welcomeBackToBWellMessage(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Welcome to b.well!"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>WelCome To b.well </b>message display successfully", "PASS",
						"<b>WelCome To b.well </b>message should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>WelCome To b.well </b>message not display successfully", "FAIL",
						"<b>WelCome To b.well </b>message should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>WelCome To b.well </b>message", "FAIL",
					"<b>WelCome To b.well </b>message should be displayed");
		}
	}

	public void skipVideoWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().skipBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Skip Btn </b>click successfully", "PASS", "<b>Skip Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Skip Btn </b>not click successfully", "FAIL", "<b>Skip Btn </b>should be clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playVideo() {
		WebElement element;
		try {
			verifyWelcomeBackMessage();
			Keywords.explicitWait(5);
			Keywords.switchToIFrameByElement(driver, Locators.getInstance().switchToIframePlayBtn(driver));
			element = Locators.getInstance().playVideoBtn(driver);
			Keywords.clickByJS(ElementEnum.ClassName.getElementType(), Keywords.getAttributeVal(element, "class"), 0);
			element = Locators.getInstance().pauseVideoBtn(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Play Button </b>click successfully", "PASS", "<b>Play Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Play Button </b>not click successfully", "FAIL", "<b>Play Button </b>should be clicked");
			// while
			// (!driver.findElement(By.xpath("//div[@class='played']")).getAttribute("aria-valuetext").equalsIgnoreCase("1
			// minute, 15 seconds played"))
			// Keywords.explicitWait(5);
			Keywords.explicitWait(90);
			Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Play Button </b>", "FAIL",
					"<b>Play Button </b>should be clicked");
		}
	}

	public boolean congratulationMsgWindow() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().congratulationMessage(driver), 10);
			element = Locators.getInstance().congratulationMessage(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public boolean verifyCongratulationMessage() {
		boolean status = false;
		WebElement element;
		try {
			// Keywords.explicitWait(10);
			if (congratulationMsgWindow()) {
				status = true;
				element = Locators.getInstance().congratulationMessage(driver);
				if (Keywords.getText(element).equalsIgnoreCase("congratulation!"))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Congratulation Message </b>display successfully", "PASS",
							"<b>Congratulation Message </b>should be display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Congratulation Message </b>not display successfully", "FAIL",
						"<b>Congratulation Message </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Congratulation Message </b>", "FAIL",
					"<b>Congratulation Message </b>should be display");
		}
		// System.out.println("Congratulation window message status..."+status);
		return status;
	}

	public void verifyFinishTutorialMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().finishTutorialMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Finish Tutorial Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS Finish Tutorial Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Finish Tutorial Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS Finish Tutorial Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS Finish Tutorial Msg</b>", "FAIL",
					"<b>CONGRATULATIONS Finish Tutorial Msg </b>should be display");
		}
	}

	public void verifyWeightHeightMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().weightHealthMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Height and weight, please! Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS Height and weight, please! Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Height and weight, please! Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS Height and weight, please! Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS Height and weight, please! Msg</b>",
					"FAIL", "<b>CONGRATULATIONS Height and weight, please! Msg </b>should be display");
		}
	}

	public void verifyFamilyMemeberMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().moreTheMerrierMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS More The Merrier Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS More The Merrier Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS More The Merrier Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS More The Merrier Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS More The Merrier Msg</b>", "FAIL",
					"<b>CONGRATULATIONS More The Merrier Msg </b>should be display");
		}
	}

	public void verifyCollectYourMedicalRecordsMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().collectYourMedicalRecordsMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Collect Your Medical Records Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS Collect Your Medical Records Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Collect Your Medical Records Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS More The Merrier Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONSCollect Your Medical Records Msg</b>",
					"FAIL", "<b>CONGRATULATIONS Collect Your Medical Records Msg </b>should be display");
		}
	}

	public void verifyFirstDoctorAddMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().addFirstDoctorMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Add Your Doctors Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS Add Your Doctors Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Add Your Doctors Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS Add Your Doctors Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS Add Your Doctors Msg</b>", "FAIL",
					"<b>CONGRATULATIONS Add Your Doctors Msg </b>should be display");
		}
	}

	public boolean healthAssessmentObjectiveCompleteMsg() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().healthAssessmentObjectiveComplete(driver), 10);
			element = Locators.getInstance().healthAssessmentObjectiveComplete(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void verifyHealthAssessmentCompleteObjective() {
		try {
			if (healthAssessmentObjectiveCompleteMsg())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Assessment Objective Completed Message </b>display successfully", "PASS",
						"<b>Congratulation Message </b>should be display");
			else {
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Health Assessment Objective Completed Message </b>",
					"FAIL", "<b>Health Assessment Objective Completed Message </b>should be display");
		}
	}

	public void verifyAllergyAddedMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().allergyAddedMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Have Allergies Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS Have Allergies Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS Have Allergies Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS Have Allergies Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS Have Allergies Msg</b>", "FAIL",
					"<b>CONGRATULATIONS Have Allergies Msg </b>should be display");
		}
	}

	public int verifyEarnPoint(String type) {
		int earnPoint = 0;
		WebElement element;
		try {
			element = Locators.getInstance().earnPoint(driver);
			earnPoint = Integer.parseInt(Keywords.getText(element));
			if (type.equalsIgnoreCase("signup"))
				if (earnPoint == 100)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 100 </b>for every signup display successfully", "PASS",
							"<b>Earn point 100 </b>for every signup should be display.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 100 </b>for every signup not display successfully", "FAIL",
							"<b>Earn point 100 </b>for every signup should be display");

			else if (type.equalsIgnoreCase("profile"))
				if (earnPoint == 400)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 400 </b>while first time update user weight & height display successfully",
							"PASS", "<b>Earn point 400 </b>for first time user weight & height should be display");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 400 </b>while first time update user weight & height not display successfully",
							"PASS", "<b>Earn point 400 </b>for first time user weight & height should be display");
			else if (type.equalsIgnoreCase("member"))
				if (earnPoint == 300)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 300 </b>while first time adding family member in Subscription display successfully",
							"PASS",
							"<b>Earn point 300 </b>while first time adding family member in Subscription should be display");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 300 </b>while first time adding family member in Subscription not display successfully",
							"PASS",
							"<b>Earn point 300 </b>while first time adding family member in Subscription should be display");
			else if (type.equalsIgnoreCase("doctor"))
				if (earnPoint == 400)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 400 </b>while add the first doctor display successfully", "PASS",
							"<b>Earn point 400 </b>while add the first doctor should be display.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 400 </b>while add the first doctor not display successfully", "FAIL",
							"<b>Earn point 400 </b>while add the first doctor should be display");
			else if (type.equalsIgnoreCase("medical"))
				if (earnPoint == 500)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 500 </b>while first time collect medical document display successfully",
							"PASS",
							"<b>Earn point 500 </b>while first time collect medical document should be display.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 500 </b>while first time collect medical document not display successfully",
							"FAIL",
							"<b>Earn point 500 </b>while first time collect medical document should be display");
			else if (type.equalsIgnoreCase("allergy"))
				if (earnPoint == 200)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 200 </b>while first time add allergy display successfully", "PASS",
							"<b>Earn point 200 </b>while first time add allergy should be display.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Earn point 200 </b>while first time add allergy not display successfully", "FAIL",
							"<b>Earn point 200 </b>while first time add allergy should be display");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Earn point </b>for user creation/update profile/", "FAIL",
					"<b>Earn point </b>for signup/updation should be display");
		}

		return earnPoint;
	}

	public boolean earnPointWindowStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().submitSuccessfullyAccountCreationWindow(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void submitRegistrationProcess() {
		WebElement element;
		try {
			element = Locators.getInstance().submitSuccessfullyAccountCreationWindow(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Done Button </b>click successfully", "PASS", "<b>Done Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Done Button </b>not click successfully", "FAIL", "<b>Done Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Done Button </b>", "FAIL",
					"<b>Done Button </b>should be clicked");
		}
	}

	public void submitEarnPointWindow() {
		WebElement element;
		try {
			if (earnPointWindowStatus()) {
				element = Locators.getInstance().submitSuccessfullyAccountCreationWindow(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Earn Point Window </b>close successfully", "PASS",
						"<b>Earn Point Window </b>should be closed");
			} else {
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Earn Point Window</b>", "FAIL",
					"<b>Earn Point Window  </b>should be closed");
		}
	}

	public void finishTutorial() {
		WebElement element;
		try {
			element = Locators.getInstance().finishTutorialBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Finish Button </b>click successfully", "PASS", "<b>Finish Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Finish Button </b>not click successfully", "FAIL",
						"<b>Finish Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clic<b>Finish Button </b>click successfully", "PASS",
					"<b>Finish Button </b>should be clicked");
		}
	}
}
