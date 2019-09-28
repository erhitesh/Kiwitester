package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ShippingAddressInfo {

	private WebDriver driver;

	public ShippingAddressInfo(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterContactName(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("ContactName"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User Name enter successfully",
						"PASS", "User name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User Name not enter successfully",
						"FAIL", "User name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering User Name", "FAIL", "User name should be entered");
		}
	}

	public void enterStreet() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().streetAddress(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("StreetAddress"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Street Name enter successfully",
						"PASS", "Street Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Street Name not enter successfully", "FAIL", "Street Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Street Name", "FAIL", "Street Name should be entered");
		}
	}

	public void enterCity() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().city(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("City"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("City Name enter successfully",
						"PASS", "City Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("City Name not enter successfully",
						"FAIL", "City Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering City Name", "FAIL", "Street Name should be entered");
		}
	}

	public void enterState() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().state(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("State"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("State name enter successfully",
						"PASS", "State name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("State name not enter successfully",
						"FAIL", "State name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering State name", "FAIL", "State name should be entered");
		}
	}

	public void enterZipCode() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().zipCode(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("ZipCode"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Zipcode enter successfully",
						"PASS", "Zipcode should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Zipcode not enter successfully",
						"FAIL", "Zipcode should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Zipcode", "FAIL", "Zipcode should be entered");
		}
	}

	public void shippingAddressAsBillingAddress() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().shippingAsBilling(driver);
			Keywords.selectByVisibleText(element, "Yes");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Shipping Address as Billing Address select successfully", "PASS",
						"Shipping Address as Billing Address should be select");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Shipping Address as Billing Address not select successfully", "FAIL",
						"Shipping Address as Billing Address should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while seelcting Shipping Address as Billing Address", "FAIL",
					"Shipping Address as Billing Address should be select");
		}
	}

	public void enterEmailAddress() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterEmailAddress(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Username"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Addrees enter successfully",
						"PASS", "Email Addrees should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email Addrees not enter successfully", "FAIL", "Email Addrees should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Email Addrees", "FAIL", "Email Addrees should be entered");
		}
	}

	public void enterPhoneNumber() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterPhoneNumber(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("PhoneNumber"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Phone Number enter successfully",
						"PASS", "Phone Number should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Phone Number not enter successfully", "FAIL", "Phone Number should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Phone Number", "FAIL", "Phone Number should be entered");
		}
	}

	public float selectCustomLogoType() {
		WebElement element;
		String customLogoValue = "";
		float customLogoPrice = 0.00f;
		int randomIndex = 0;
		try {
			randomIndex = Keywords.getRandomInteger(3);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCustomLogo(driver);
			customLogoValue = Keywords.selectByIndex(element, randomIndex);
			if (randomIndex == 0) 
				customLogoPrice = 0;
			else if (randomIndex == 1)
				customLogoPrice = 500;
			else if (randomIndex == 2)
				customLogoPrice = 0;
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						customLogoValue + " click successfully", "PASS", customLogoValue + " should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						customLogoValue + " not click successfully", "FAIL", customLogoValue + " should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + customLogoValue, "FAIL",
					customLogoValue + " should be click");
		}

		return customLogoPrice;
	}

	public List<String> getAdditionalTagList() {
		List<String> tagList = new ArrayList<String>();
		try {
			tagList.add("Black Aluminum Stack");
			tagList.add("Stack");
			tagList.add("Tree Hardware");
		} catch (Exception e) {

		}

		return tagList;
	}

	public static Map<String, Float> getAdditionalTagWithPrice() {
		HashMap<String, Float> list = new HashMap<>();
		try {
			list.put("Black Aluminum Stack", 6.25f);
			list.put("Stack", 4.50f);
			list.put("Tree Hardware", 1.50f);
		} catch (Exception e) {

		}

		return list;
	}

	public float getAdditionalTagPrice(String tagName) {
		Map<String, Float> tagList = getAdditionalTagWithPrice();
		Float tagvalue = 0.00f;
		try {
			tagvalue = tagList.get(tagName);
		} catch (Exception e) {

		}

		return tagvalue;
	}

	public int enterAdditionalTagQuantity(String tagName) {
		int tagQuantity = 0;
		List<WebElement> additionalTagQuantity;
		int randomQuantity = 0;
		try {
			additionalTagQuantity = Locators.getInstance().getAdditionalTagQuantityList(driver);// getAdditionalTagPriceList(driver);
			randomQuantity = Keywords.getRandomInteger(100); //
			if (randomQuantity == 0)
				randomQuantity = randomQuantity + 1;
			if (tagName.equalsIgnoreCase("Black Aluminum Stack")) {
				Keywords.typeText(additionalTagQuantity.get(0), String.valueOf(randomQuantity));
			} else if (tagName.equalsIgnoreCase("Stack")) {
				Keywords.typeText(additionalTagQuantity.get(1), String.valueOf(randomQuantity));
			} else if (tagName.equalsIgnoreCase("tree hardware")) {
				Keywords.typeText(additionalTagQuantity.get(2), String.valueOf(randomQuantity));
			}
			tagQuantity = randomQuantity;
		} catch (Exception e) {

		}

		return tagQuantity;
	}

	public float verifyBlackAluminumStakePrice(String tagName) {
		WebElement element;
		float tagPrice = getAdditionalTagPrice(tagName);
		int tagQuantity = enterAdditionalTagQuantity(tagName);
		float actualTagPrice = (tagPrice * tagQuantity);
		float expectedtagPrice = 0.00f;
		try {
			element = Locators.getInstance().getAluminumStackSum(driver);
			expectedtagPrice = Float.parseFloat(Keywords.getText(element).replace("$", ""));
			if (actualTagPrice == expectedtagPrice) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Actual & Expected " + tagName + " price match", "PASS",
							"Actual & Expected tag price should be matched");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Actual & Expected  " + tagName + "  tag price not match", "FAIL",
						"Actual & Expected tag price should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing actual & expected tag price", "FAIL",
					"Actual & Expected tag price should be matched");
		}

		return actualTagPrice;
	}

	public float verifyTreeHardwarePrice(String tagName) {
		WebElement element;
		float tagPrice = getAdditionalTagPrice(tagName);
		int tagQuantity = enterAdditionalTagQuantity(tagName);
		float actualTagPrice = (tagPrice * tagQuantity);
		float expectedtagPrice = 0.00f;
		try {
			element = Locators.getInstance().getTreeHardwareSum(driver);
			expectedtagPrice = Float.parseFloat(Keywords.getText(element).replace("$", ""));
			if (actualTagPrice == expectedtagPrice) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Actual & Expected tag price match", "PASS",
							"Actual & Expected tag price should be matched");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Actual & Expected tag price not match", "FAIL",
						"Actual & Expected tag price should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing actual & expected tag price", "FAIL",
					"Actual & Expected tag price should be matched");
		}

		return actualTagPrice;
	}

	public float verifyStakePrice(String tagName) {
		WebElement element;
		float tagPrice = getAdditionalTagPrice(tagName);
		int tagQuantity = enterAdditionalTagQuantity(tagName);
		float actualTagPrice = (tagPrice * tagQuantity);
		float expectedtagPrice = 0.00f;
		try {
			element = Locators.getInstance().getStackSum(driver);
			expectedtagPrice = Float.parseFloat(Keywords.getText(element).replace("$", ""));
			if (actualTagPrice == expectedtagPrice) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Actual & Expected tag price match", "PASS",
							"Actual & Expected tag price should be matched");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Actual & Expected tag price not match", "FAIL",
						"Actual & Expected tag price should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing actual & expected tag price", "FAIL",
					"Actual & Expected tag price should be matched");
		}

		return actualTagPrice;
	}

	public float getPlantQuantityAndSignTotalCost() {
		List<WebElement> plantsTagPriceList;
		float totalCost = 0.00f;
		String txt = "";
		try {
			plantsTagPriceList = Locators.getInstance().getPlantsQuantityAndTagCost(driver);
			for (int i = 0; i < plantsTagPriceList.size(); i++) {
				txt = Keywords.getText(plantsTagPriceList.get(i));
				totalCost = totalCost + Float.parseFloat(txt.substring(txt.indexOf('=') + 3, txt.length()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Plant Tag total cost.."+totalCost);
		return totalCost;
	}

	public void submitUserBillingPage() {
		WebElement element;
		try {
			element = Locators.getInstance().clickOnProceed(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Proceed button click successfully",
						"PASS", "Proceed button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Proceed button not click successfully", "FAIL", "Proceed button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking Proceed button", "FAIL", "Proceed button should be click");
		}
	}
}
