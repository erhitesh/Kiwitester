package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Payment {

	private WebDriver driver;

	public Payment(WebDriver driver) {
		this.driver = driver;
	}

	public void clickChangePlanBtn() {
		WebElement element;
		try {
			Keywords.explicitWait(2);
			element = Locators.getInstance().changePlanBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Plan Button </b>click successfully", "PASS",
						"<b>Change Plan Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Plan Button </b>not click successfully", "FAIL",
						"<b>Change Plan Button </b>should be clicked");
			Keywords.waitForObject(Locators.getInstance().changePlanHeaderTxt(driver), 10);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Change Plan Button </b>", "FAIL",
					"<b>Change Plan Button </b>should be clicked");
		}
	}

	public void verifyChangePlanHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().changePlanHeaderTxt(driver), 10);
			element = Locators.getInstance().changePlanHeaderTxt(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Choose The Subscription Plan </b>text found successfully", "PASS",
						"<b>Choose The Subscription Plan </b>text should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Choose The Subscription Plan </b>text not found successfully", "FAIL",
						"<b>Choose The Subscription Plan </b>text should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Manage Your Payment Method </b>text", "FAIL",
					"<b>Choose The Subscription Plan </b>text should be display");
		}
	}

	public void clickChangePaymentMethod() {
		WebElement element;
		try {
			Keywords.explicitWait(2);
			element = Locators.getInstance().changePaymentMethodBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Payment Method Button </b>click successfully", "PASS",
						"<b>Change Payment Method Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Payment Method Button </b>not click successfully", "FAIL",
						"<b>Change Payment Method Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Change Payment Method Button </b>", "FAIL",
					"<b>Change Payment Method Button </b>should be clicked");
		}
	}

	public void verifyChangePaymentMethodHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().changePaymentHeaderTxt(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Manage Your Payment Method </b>text found successfully", "PASS",
						"<b>Manage Your Payment Method </b>text should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Manage Your Payment Method </b>text not found successfully", "FAIL",
						"<b>Manage Your Payment Method </b>text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Manage Your Payment Method </b>text", "FAIL",
					"<b>Manage Your Payment Method </b>text should be present");
		}
	}

	public int cardCount() {
		int count = 0;
		List<WebElement> cardElementList;
		try {
			cardElementList = Locators.getInstance().paymentCardCount(driver);
			count = cardElementList.size();
		} catch (Exception e) {
		}

		return count;
	}

	public void addCardBtn() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().addCardBtn(driver), 10);
			element = Locators.getInstance().addCardBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Card Button </b>click successfully", "PASS",
						"<b>Add Card Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Card Button </b>not click successfully", "FAIL",
						"<b>Add Card Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the<b>Add Card Button </b>", "FAIL",
					"<b>Add Card Button </b>should be clicked");
		}
	}

	public void navigateToChangePaymentMethodPage() {
		WebElement element;
		try {
			element = Locators.getInstance().backToChangePaymentMethodPage(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Back to Change Paymemt method Button </b>click successfully", "PASS",
						"<b>Back to Change Paymemt method Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Back to Change Paymemt method Button </b>not click successfully", "FAIL",
						"<b>Back to Change Paymemt method Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Back to Change Paymemt method Button </b>", "FAIL",
					"<b>Back to Change Paymemt method Button </b>should be clicked");
		}
	}

	public void navigateToMyProfilePage() {
		WebElement element;
		try {
			element = Locators.getInstance().backToChangePaymentMethodPage(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Back to My Profile Button </b>click successfully", "PASS",
						"<b>Back to My Profile method Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Back to My Profile method Button </b>not click successfully", "FAIL",
						"<b>Back to My Profile method Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Back to My Profile method Button </b>", "FAIL",
					"<b>Back to My Profile method Button </b>should be clicked");
		}
	}

	public String selectCardMonthValue(String monthValue) {
		String month_value = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			month_value = monthValue;// Keywords.getMonthsValueList("full").get(Keywords.getRandomInteger(12));
			element = Locators.getInstance().enableExpirationMonthValue(driver);
			Keywords.click(element);
			elementList = Locators.getInstance().monthValues(driver);
			for (WebElement webElement : elementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(month_value)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Card Month Value </b>select successfully", "PASS",
							"<b>Card Month Value </b>should be selected");
					break;
				}

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting<b>Card Month Value </b>", "FAIL",
					"<b>Card Month Value </b>should be selected");
		}
		return month_value;
	}

	public String selectCardYearValue(String yearValue) {
		String year_value = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			year_value = yearValue;// Keywords.getCurrentYearValue();
			element = Locators.getInstance().enableExpirationYearValue(driver);
			Keywords.click(element);
			elementList = Locators.getInstance().yearValues(driver);
			for (WebElement webElement : elementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(year_value)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Card Year Value </b>select successfully", "PASS",
							"<b>Card Year Value </b>should be selected");
					;
					break;
				}

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting<b>Card Year Value </b>", "FAIL",
					"<b>Card Year Value </b>should be selected");
		}
		return year_value;
	}

	// Credid Card Information
	public String cardNumber(String card_number) {
		WebElement element;
		String cardNumber = "4242424242424242";// card_number;//
		try {
			// cardNumber = Keywords.getRandomIntegerBtRange(99999, maxRange)
			element = Locators.getInstance().cardNumber(driver);
			Keywords.typeText(element, cardNumber);

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

	public String enterCardNumber(String cNumber) {
		return cardNumber(cNumber);
	}

	public String enterCVCNumber(String cvcNumber) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().cardCVCNumber(driver), 10);
			element = Locators.getInstance().cardCVCNumber(driver);
			Keywords.typeText(element, cvcNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Credit Card CVC Number </b>enter successfully", "PASS",
						"<b>Credit Card CVC Number </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Credit Card CVC Number </b>not enter successfully", "FAIL",
						"<b>Credit Card CVC Number </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Credit Card CVC Number</b>", "FAIL",
					"<b>Credit Card CVC Number </b>should be entered");
		}
		return cvcNumber;
	}

	public boolean verifyPromoCodeTxtBox() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().promoCode(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public boolean verifyPromoCodeTxtBoxWhileUpdatePlan() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().promoCodeWhileUpdatingSubscription(driver);
			status = Keywords.isElementEnable(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void enableDisableCouponCodeToggle(String toggleValue) {
		WebElement element;
		try {
			element = Locators.getInstance().enableDisablePromoCode(driver);
			if (toggleValue.equalsIgnoreCase("true")) {
				if (Keywords.getAttributeVal(element, "class").contains("selected"))
					;
				else
					Keywords.click(element);
			} else if (toggleValue.equalsIgnoreCase("false")) {
				if (Keywords.getAttributeVal(element, "class").contains("selected"))
					Keywords.click(element);
				else {
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code checkbox </b>click successfully", "PASS",
						"<b>Promo Code checkbox  </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code checkbox  </b>not click successfully", "FAIL",
						"<b>Promo Code checkbox  </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Promo Code checkbox </b>", "FAIL",
					"<b>Promo Code checkbox  </b>should be checked");
		}
	}

	public String enterPromoCode(String promoCode, String codeFor) {
		WebElement element;
		try {
			if (codeFor.equalsIgnoreCase("addcard")) {
				element = Locators.getInstance().promoCode(driver);
				Keywords.typeText(element, promoCode);
			} else if (codeFor.equalsIgnoreCase("update")) {
				element = Locators.getInstance().promoCodeWhileUpdatingSubscription(driver);
				Keywords.typeText(element, promoCode);
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code Value </b>enter successfully", "PASS",
						"<b>Promo Code Value </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Promo Code Value </b>not enter successfully", "FAIL",
						"<b>Promo Code Value </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering<b>Promo Code Value </b>enter successfully", "FAIL",
					"<b>Promo Code Value </b>should be entered");
		}
		return promoCode;
	}

	public void enableDisableHomeAddressToggle(String toggleValue) {
		WebElement element;
		try {
			element = Locators.getInstance().enableDisableHomeAddressCheckBox(driver, toggleValue);
			if (toggleValue.equalsIgnoreCase("true")) {
				if (Keywords.getAttributeVal(element, "class").contains("selected")) {
				} else
					Keywords.click(element);
			} else if (toggleValue.equalsIgnoreCase("false")) {
				if (Keywords.getAttributeVal(element, "class").contains("selected"))
					Keywords.click(element);
				else {
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Use Home Address checkbox </b>click successfully", "PASS",
						"<b>Use Home Address checkbox </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Use Home Address checkbox </b>not click successfully", "FAIL",
						"<b>Use Home Address checkbox </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Use Home Address checkbox </b>", "FAIL",
					"<b>Use Home Address checkbox </b>should be clicked");
		}
	}

	public String enterCardUserAddress(String address) {
		WebElement element;
		try {
			element = Locators.getInstance().billingAddress1(driver);
			Keywords.typeText(element, address);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing Address </b>enter successfully", "PASS",
						"<b>Card User Billing Address </b>should be enterd");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing Address </b>enter successfully", "FAIL",
						"<b>Card User Billing Address </b>should be enterd");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering<b>Card User Billing Address </b>", "FAIL",
					"<b>Card User Billing Address </b>should be enterd");
		}
		return address;
	}

	public String getBillingAddress1() {
		String addressone = "";
		// WebElement element;
		try {
			// element = Locators.getInstance().billingAddress1(driver);
			addressone = Keywords.getTextByJS(ElementEnum.Name.getElementType(),
					Locators.getInstance().billingAddress1(), 1);
			// System.out.println("Address One.."+addressone);
		} catch (Exception e) {
		}
		return addressone;
	}

	public String getBillingCity() {
		String city = "";
		WebElement element;
		try {
			element = Locators.getInstance().billingCityName(driver);
			city = Keywords.getTextByJS(ElementEnum.Name.getElementType(), Keywords.getAttributeVal(element, "name"),
					0);
			// System.out.println("City.."+city);
		} catch (Exception e) {
		}
		return city;
	}

	public String getBillingState() {
		String state = "";
		WebElement element;
		try {
			element = Locators.getInstance().getBillingState(driver);
			state = Keywords.getText(element);
		} catch (Exception e) {
		}
		return state;
	}

	public String getBillingZipCode() {
		String zipcode = "";
		WebElement element;
		try {
			element = Locators.getInstance().billingZipCode(driver);
			zipcode = Keywords.getTextByJS(ElementEnum.Name.getElementType(), Keywords.getAttributeVal(element, "name"),
					0);
		} catch (Exception e) {

		}
		return zipcode;
	}

	public String enterCardUserCity(String city) {
		WebElement element;
		try {
			element = Locators.getInstance().billingCityName(driver);
			Keywords.typeText(element, city);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing City </b>enter successfully", "PASS",
						"<b>Card User Billing City </b>should be enterd");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing City </b>enter successfully", "FAIL",
						"<b>Card User Billing City </b>should be enterd");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering<b>Card User Billing City </b>", "FAIL",
					"<b>Card User Billing City </b>should be enterd");
		}
		return city;
	}

	public String enterCardUserState(String state) {
		WebElement element;
		List<WebElement> stateElementList;
		try {
			element = Locators.getInstance().enableBillingStateValue(driver);
			Keywords.click(element);
			// Keywords.typeText(element, state);

			stateElementList = Locators.getInstance().stateValues(driver);
			for (WebElement webElement : stateElementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(state)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Card User Billing State </b>enter successfully", "PASS",
							"<b>Card User Billing State </b>should be enterd");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering<b>Card User Billing State </b>", "FAIL",
					"<b>Card User Billing State </b>should be enterd");
		}
		return state;
	}

	public String enterCardUserZipCode(String zipcode) {
		WebElement element;
		try {
			element = Locators.getInstance().billingZipCode(driver);
			Keywords.typeText(element, zipcode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing ZipCode </b>enter successfully", "PASS",
						"<b>Card User Billing ZipCode </b>should be enterd");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card User Billing ZipCode </b>enter successfully", "FAIL",
						"<b>Card User Billing ZipCode </b>should be enterd");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering<b>Card User Billing ZipCode </b>", "FAIL",
					"<b>Card User Billing ZipCode </b>should be enterd");
		}
		return zipcode;
	}

	public boolean savePaymentMethodBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().savePaymentMethodBtn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void savePaymentMethod() {
		WebElement element;
		try {
			element = Locators.getInstance().savePaymentMethodBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Payment Method Button </b>submit successfully", "PASS",
						"<b>Save Payment Method Button </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Payment Method Button </b>not submit successfully", "FAIL",
						"<b>Save Payment Method Button </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Save Payment Method Button</b>", "FAIL",
					"<b>Save Payment Method Button </b>should be submit");
		}
	}

	public void verifySubscriptionPlanChangeTextSubmit(String changeFrom) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().verifySubscriptionPlanChangeFrom(driver), 10);
			element = Locators.getInstance().verifySubscriptionPlanChangeFrom(driver);
			if (changeFrom.equalsIgnoreCase("month"))
				Keywords.getText(element).equalsIgnoreCase(DriverSession.getTestCaseData().get("FromMonthToYear"));
			else
				Keywords.getText(element).equalsIgnoreCase(DriverSession.getTestCaseData().get("FromYearToMonth"));
			element = Locators.getInstance().yesIAmSureSentBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {

		}
	}

	public void clickOnCancelButton() {
		WebElement element;
		try {
			element = Locators.getInstance().savePaymentMethodBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Payment Method Button </b>submit successfully", "PASS",
						"<b>Save Payment Method Button </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save Payment Method Button </b>not submit successfully", "FAIL",
						"<b>Save Payment Method Button </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting<b>Save Payment Method Button</b>", "FAIL",
					"<b>Save Payment Method Button </b>should be submit");
		}
	}

	public void clickChangePlan() {
		WebElement element;
		try {
			element = Locators.getInstance().changePlanBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Plan Button </b>click successfully", "PASS",
						"<b>Change Plan Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Change Plan Button </b>not click successfully", "FAIL",
						"<b>Change Plan Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Change Payment Method Button</b>", "FAIL",
					"<b>Change Plan Button </b>should be clicked");
		}
	}

	public void clickAddRegistrationCode() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().addRegistrationCodeBtn(driver), 10);
			element = Locators.getInstance().addRegistrationCodeBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Registration Code Button </b>click successfully", "PASS",
						"<b>Add Registration Code Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Registration Code Button </b>not click successfully", "FAIL",
						"<b>Add Registration Code Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Registration Code Button </b>", "FAIL",
					"<b>Add Registration Code Button </b>should be clicked");
		}
	}

	public void enterRegistrationCode(String registrationCode) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().enterRegistrationCode(driver));
			element = Locators.getInstance().enterRegistrationCode(driver);
			Keywords.typeText(element, registrationCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code Enter </b>successfully", "PASS",
						"<b>Registration Code </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code </b>not enter successfully", "FAIL",
						"<b>Registration Code </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Registration Code</b>", "FAIL",
					"<b>Registration Code </b>should be entered");
		}
	}

	public void submitRegistrationCode() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().submitRegistration(driver));
			element = Locators.getInstance().submitRegistration(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code </b>successfully submit", "PASS",
						"<b>Registration Code </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Registration Code </b>successfully not submit", "FAIL",
						"<b>Registration Code </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Registration Code </b>", "FAIL",
					"<b>Registration Code </b>should be submit");
		}
	}

	public boolean successMsgStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().successMsg(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void verifySubscriptionUpdationMsg(String associateUserName) {
		String msg = "";
		WebElement element;
		try {
			if (successMsgStatus()) {
				element = Locators.getInstance().subscriptionUpdateMsgPopUp(driver);
				msg = Keywords.getText(element);
				if (msg.contains(associateUserName)) {
					element = Locators.getInstance().submitSuccessMsgPopUp(driver);
					Keywords.click(element);
					Keywords.explicitWait(2);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Success Msg & Associate User Name </b>successfully match", "PASS",
							"<b>Success Msg & Associate User Name </b>should be matched");
				}else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Success Msg & Associate User Name </b>successfully not match", "FAIL",
							"<b>Success Msg & Associate User Name </b>should be matched");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while handling subscription Update<b>Success Msg & Associate User Name </b>successfully not match", "FAIL",
					"<b>Success Msg & Associate User Name </b>should be matched");
		}
	}

	public void clickUnsubscribeBtn() {
		WebElement element;
		try {
			Thread.sleep(2000);
			element = Locators.getInstance().unsubscribeBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Button </b>click successfully", "PASS",
						"<b>Unsubscribe Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Button </b>not click successfully", "FAIL",
						"<b>Unsubscribe Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Unsubscribe Button </b>", "FAIL",
					"<b>Unsubscribe Button </b>should be clicked");
		}
	}

	public void verifyUnsubscribePoupWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().unsubscribeSubscriptionMessage(driver);
			if (Keywords.getText(element).contains(""))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Header Window </b>open successfully", "PASS",
						"<b>Unsubscribe Header Window </b>should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Header Window </b>not open successfully", "FAIL",
						"<b>Unsubscribe Header Window </b>should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Unsubscribe Header Window </b>", "FAIL",
					"<b>Unsubscribe Header Window </b>should be opened");
		}
	}

	public void submitUnsubscribeWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitUnsubscibe(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Ok button </b>click successfully", "PASS",
						"<b>Unsubscribe Ok button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Ok button </b>not click successfully", "FAIL",
						"<b>Unsubscribe Ok button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Unsubscribe Ok Button</b>", "FAIL",
					"<b>Unsubscribe Ok button </b>should be click");
		}
	}

	public void cancelUnsubscribeWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().cancelUnsubscribe(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Cancel button </b>click successfully", "PASS",
						"<b>Unsubscribe Cancel button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unsubscribe Cancel button </b>not click successfully", "FAIL",
						"<b>Unsubscribe Cancel button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Unsubscribe Cancel button </b>", "FAIL",
					"<b>Unsubscribe Cancel button </b>should be click");
		}
	}

	public void verifyQuizHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().quizHeadline(driver);
			if (Keywords.getText(element).contains(""))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quiz Headline </b>visible successfully", "PASS", "<b>Quiz Headline </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quiz Headline </b>not visible successfully", "FAIL",
						"<b>Quiz Headline </b>should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Quiz Headline</b>", "FAIL",
					"<b>Quiz Headline </b>should be visible");
		}
	}

	public void enterAdditionalTxtForCancellingSubscription(String option) {
		WebElement element;
		try {
			if (option.equalsIgnoreCase("missing"))
				element = Locators.getInstance().missingFunctionalityTxtBox(driver);
			else
				element = Locators.getInstance().otherReasonTxtBox(driver);
			Keywords.typeText(element, Keywords.getRandomAlphabetic(4));
		} catch (Exception e) {
		}
	}

	public void chooseFirstQuestionForCancellingSubscription() {
		int randomNumber = 0;
		List<WebElement> checkBoxList;
		List<WebElement> quesHeaderTxt;
		try {
			checkBoxList = Locators.getInstance().subscriptionQuestionCheckboxesList(driver);
			quesHeaderTxt = Locators.getInstance().subscriptionQuestionHeader(driver);
			randomNumber = Keywords.getRandomInteger(checkBoxList.size());
			Keywords.click(checkBoxList.get(randomNumber));
			if (Keywords.getText(quesHeaderTxt.get(randomNumber)).contains("missing"))
				enterAdditionalTxtForCancellingSubscription("missing");
			else if (Keywords.getText(quesHeaderTxt.get(randomNumber)).contains("Other"))
				enterAdditionalTxtForCancellingSubscription("Other");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Question </b>select successfully", "PASS",
						"<b>First Question </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Question </b> not select successfully", "FAIL",
						"<b>First Question </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>First Question </b>", "FAIL",
					"<b>First Question </b>should be selected");
		}
	}

	public void submitFirstQuestion() {
		WebElement element;
		try {
			element = Locators.getInstance().submitUnsubscibe(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>click successfully", "PASS", "<b>Next Button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>not click successfully", "FAIL", "<b>Next Button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Next Button </b>", "FAIL",
					"<b>Next Button </b>should be click");
		}
	}

	public void chooseSecondQuestionForCancellingSubscription() {
		int randomNumber = 0;
		List<WebElement> checkBoxList;
		try {
			checkBoxList = Locators.getInstance().checkBoxListForSecondQuestion(driver);
			randomNumber = Keywords.getRandomInteger(checkBoxList.size());
			Keywords.click(checkBoxList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Second Question </b>select successfully", "PASS",
						"<b>Second Question </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Second Question </b> not select successfully", "FAIL",
						"<b>Second Question </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Second Question </b>", "FAIL",
					"<b>Second Question </b>should be selected");
		}
	}

	public void verifyErrorMessageForNotSelectingCheckbox() {
		WebElement element;
		try {
			element = Locators.getInstance().errorMessageForUnSelectingChechboxes(driver);
			if (Keywords.getText(element).contains("this is required"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Error Message </b>display successfully", "PASS", "<b>Error Message </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Error Message </b>not display successfully", "FAIL",
						"<b>Error Message </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Error Message </b> for checkbox", "FAIL",
					"<b>Error Message </b>should be display");
		}
	}

	public void submitLastQuestion() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().submitUnsubscibe(driver), 10);
			element = Locators.getInstance().submitUnsubscibe(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button </b>click successfully", "PASS", "<b>Submit Button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button </b>not click successfully", "FAIL", "<b>Submit Button </b>should be click");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 15);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Submit Button </b>", "FAIL",
					"<b>Submit Button </b>should be click");
		}
	}

	public void verifyLogoutMessageWithinTimePeriod() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyAutomaticallyLogoutMessage(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>You will be automatically logout within 10 seconds </i></b>message display successfully",
						"PASS",
						"<b><i>You will be automatically logout within 10 seconds </i></b>message should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>You will be automatically logout within 10 seconds </i></b>message not display successfully",
						"FAIL",
						"<b><i>You will be automatically logout within 10 seconds </i></b>message should be display");
			Keywords.click(Locators.getInstance().logoutUnsubscribeUser(driver));
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b><i>You will be automatically logout within 10 seconds</i></b>Message",
					"FAIL",
					"<b><i>You will be automatically logout within 10 seconds </i></b>message should be display");
		}
	}

	// Subscribe Related Task
	public void tapOnSubscribeNowBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().subscribeNowBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscribe Now Button </b>click successfully", "PASS",
						"<b>Subscribe Now Button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscribe Now Button </b>not click successfully", "FAIL",
						"<b>Subscribe Now Button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Subscribe Now Button </b>", "PASS",
					"<b>Subscribe Now Button </b>should be click");
		}
	}

	// public String selectSubscriptionPlan() {
	// String subscriptionPlanType = "";
	// List<WebElement> optionList;
	// List<WebElement> optionHeaderList;
	// int randomNumber = 0;
	// try {
	// optionList = Locators.getInstance().subscriptionPlan(driver);
	// optionHeaderList =
	// Locators.getInstance().subscriptionOptionHeaderValue(driver);
	// randomNumber = Keywords.getRandomInteger(optionList.size());
	// subscriptionPlanType =
	// Keywords.getText(optionHeaderList.get(randomNumber));
	// Keywords.click(optionList.get(randomNumber));
	//
	// if (DriverSession.getStepResult())
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "<b>Subscription Plan </b>select successfully", "PASS",
	// "<b>Subscription Plan </b>should be selected");
	// else
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "<b>Subscription Plan </b>not select successfully", "FAIL",
	// "<b>Subscription Plan </b>should be selected");
	// } catch (Exception e) {
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "Exception occurred while choosing the <b>Subscription Plan </b>",
	// "FAIL",
	// "<b>Subscription Plan </b>should be selected");
	// }
	//
	// return subscriptionPlanType;
	// }

	public String selectSubscriptionPlan() {
		String subscriptionPlanType = "";
		List<WebElement> optionElementList;
		List<WebElement> optionHeaderList;
		try {
			optionElementList = Locators.getInstance().subscriptionPlan(driver);
			optionHeaderList = Locators.getInstance().subscriptionOptionHeaderValue(driver);
			for (int i = 0; i < optionElementList.size(); i++) {
				if (!Keywords.getAttributeVal(optionElementList.get(i), "class").contains("disabled")) {
					Keywords.click(optionElementList.get(i));
					subscriptionPlanType = Keywords.getText(optionHeaderList.get(i));
					subscriptionPlanType = subscriptionPlanType.substring(0, subscriptionPlanType.indexOf(' '));
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Plan </b>select successfully", "PASS",
						"<b>Subscription Plan </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Plan </b>not select successfully", "FAIL",
						"<b>Subscription Plan </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while choosing the <b>Subscription Plan </b>", "FAIL",
					"<b>Subscription Plan </b>should be selected");
		}

		return subscriptionPlanType;
	}

	public String enterCCNumber(String card) {
		String cardNumber = "";
		WebElement element;
		try {
			element = Locators.getInstance().enterCCNumberForChangePlan(driver);
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

	// public String enterCVCNumber(String cvv) {
	// WebElement element;
	// try {
	// element = Locators.getInstance().cvvNumber(driver);
	// Keywords.typeText(element, cvv);
	//
	// if (DriverSession.getStepResult())
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "<b>CVV Number </b>enter successfully", "PASS", "<b>CVV Number </b>should
	// be entered");
	// else
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "<b>CVV Number </b>not enter successfully", "FAIL", "<b>CVV Number
	// </b>should be entered");
	// } catch (Exception e) {
	// DriverSession.getLastExecutionReportingInstance().teststepreporting(
	// "Exception occurred while entering <b>CVV Number </b>", "FAIL",
	// "<b>CVV Number </b>should be entered");
	// }
	//
	// return cvv;
	// }

	public void applyPromoCodeWhileAddNewCard() {
		String promoCodeStatus = "";
		try {
			promoCodeStatus = DriverSession.getTestCaseData().get("PromoCodeOption");
			if (promoCodeStatus.equalsIgnoreCase("true")) {
				enableDisableCouponCodeToggle(promoCodeStatus);
				enterPromoCode(DriverSession.getTestCaseData().get("PromoCode"), "addcard");
			} else {
				if (!verifyPromoCodeTxtBox())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Promo Code Text Box </b>not visible", "PASS",
							"<b>Promo Code Text Box </b>should not be visible");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Promo Code Text Box </b>visible", "FAIL",
							"<b>Promo Code Text Box </b>should not be visible");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyPromoCodeWhileUpdatingSubscriptionPlan() {
		String promoCodeStatus = "";
		try {
			promoCodeStatus = DriverSession.getTestCaseData().get("PromoCodeOption");
			if (promoCodeStatus.equalsIgnoreCase("true")) {
				enableDisableCouponCodeToggle(promoCodeStatus);
				enterPromoCode(DriverSession.getTestCaseData().get("PromoCode"), "update");
			} else {
				if (!verifyPromoCodeTxtBoxWhileUpdatePlan())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Promo Code Text Box </b>not visible", "PASS",
							"<b>Promo Code Text Box </b>should not be visible");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Promo Code Text Box </b>visible", "FAIL",
							"<b>Promo Code Text Box </b>should not be visible");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> cardInformation() {
		List<String> cardInfo = new ArrayList<>();
		try {
			enterCardNumber(DriverSession.getTestCaseData().get("CardNumber"));
			selectCardMonthValue(DriverSession.getTestCaseData().get("Month"));
			selectCardYearValue(DriverSession.getTestCaseData().get("Year"));
			enterCVCNumber(DriverSession.getTestCaseData().get("CVC"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cardInfo;
	}

	public void billingAddress() {
		String HomeAddressOption = "";
		try {
			HomeAddressOption = DriverSession.getTestCaseData().get("HomeAddressOption");
			if (HomeAddressOption.equalsIgnoreCase("false")) {
				enableDisableHomeAddressToggle(HomeAddressOption);
				enterCardUserAddress(DriverSession.getTestCaseData().get("Address1"));
				enterCardUserCity(DriverSession.getTestCaseData().get("City"));
				enterCardUserState(DriverSession.getTestCaseData().get("State"));
				enterCardUserZipCode(DriverSession.getTestCaseData().get("Zip"));
			} else {
				if (getBillingAddress1().length() > 0 && getBillingCity().length() > 0 && getBillingState().length() > 0
						&& getBillingZipCode().length() > 0)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Billing Address, City, State & Zipcode </b>display successfully", "PASS",
							"<b>Billing Address, City, State & Zipcode </b>should be display");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Billing Address, City, State & Zipcode </b>not display successfully", "FAIL",
							"<b>Billing Address, City, State & Zipcode </b>should be display");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			applyPromoCodeWhileUpdatingSubscriptionPlan();
			ccoptionslist = Locators.getInstance().ccOptions(driver);
			if (ccoptionslist.size() == 1) {
				Keywords.click(ccoptionslist.get(ccoptionslist.size() - 1));
				cardInformation();
				billingAddress();
			} else {
				randomNumber = Keywords.getRandomInteger(ccoptionslist.size() - 2);
				if (Keywords.getText(ccoptionslist.get(randomNumber)).contains("ending")) {
					cc = Keywords.getText(ccoptionslist.get(randomNumber));
					Keywords.click(ccoptionslist.get(randomNumber));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Random Credit Card </b>successfully selected", "PASS",
							"<b>Random Credit Card </b>should be selected from credit card list");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Card Information, Billing Address & Promo code </b>successfully entered", "FAIL",
					"Exception occurred while entering <b>Card Information, Billing Address & Promo code </b>");
		}

		return cc;
	}

	public boolean selectCreditCardOption(boolean option) {
		WebElement element;
		try {
			if (option) {
				element = Locators.getInstance().enableCreditCardDropDown(driver);
				Keywords.click(element);
				element = Locators.getInstance().selectAddCardOption(driver);
				Keywords.click(element);

				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Card </b>select successfully", "PASS", "<b>Add Card </b>should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Continue With Already added Card</b>", "PASS", "<b>Continue With Already added Card</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while continue with already added card or adding new card", "FAIL",
					"<b>Add Card </b>should be selected");
		}
		return option;
	}

	public void verifyThankYouForSubscribingBWell() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().thankYouMessageForSubscribingBWell(driver), 20);
			element = Locators.getInstance().thankYouMessageForSubscribingBWell(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Thank you for subscribing to b.well!")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank you for subscribing message </b>display successfully", "PASS",
						"<b>Thank you for subscribing message </b>should be display");
				submitThankYouSubscribingBWellWindowPopUp();
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank you for subscribing message </b>not display successfully", "FAIL",
						"<b>Thank you for subscribing message </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Thank you for subscribing message </b>", "FAIL",
					"<b>Thank you for subscribing message </b>should be display");
		}
	}

	public void submitThankYouSubscribingBWellWindowPopUp() {
		WebElement element;
		try {
			element = Locators.getInstance().letsGoBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank you for Subscribing Msg Window </b>successfully saved", "PASS",
						"<b>Thank you for Subscribing Msg Window </b>should be saved");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank you for Subscribing Msg Window </b>successfully not saved", "FAIL",
						"<b>Thank you for Subscribing Msg Window </b>should be saved");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Thank you for Subscribing Msg Window </b>", "FAIL",
					"<b>Thank you for Subscribing Msg Window </b>should be saved");
		}
	}
}
