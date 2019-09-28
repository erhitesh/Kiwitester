package Plantsmap.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class PlaceOrder {

	private WebDriver driver;

	public PlaceOrder(WebDriver driver) {
		this.driver = driver;
	}

	public float getSubTotal() {
		WebElement element;
		float totalPrice = 0.00f;
		String txt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlaceOrderPrice(driver);
			txt = Keywords.getText(element).trim();
			totalPrice = Float.parseFloat(txt.substring(txt.indexOf('$') + 1, txt.length()));
		} catch (Exception e) {

		}
		return totalPrice;
	}

	public void verifySubTotal(float expectedTotalPrice) {
		float actualTotalPrice = 0.00f;
		try {
			actualTotalPrice = getSubTotal();
			if (actualTotalPrice == expectedTotalPrice)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Actual & Expected SubTotal match successfully", "PASS",
						"Actual & Expected SubTotal should be match");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Actual & Expected SubTotal match not successfully", "FAIL",
						"Actual & Expected SubTotal should be match");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Expection occurred while verifing Actual & Expected SubTotal", "PASS",
					"Actual & Expected SubTotal should be match");
		}
	}

	public void verifyOrderPlaceSuccessfully() {
		WebElement element;
		String popTxtMsg = "";
		try {
			element = Locators.getInstance().updateSuccessfullyPlaceOrderPopUpMessage(driver);
			popTxtMsg = Keywords.getText(element);

			if (popTxtMsg.equalsIgnoreCase("Order has not been placed.")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Order not place successfully because of email id not registered", "PASS",
						"Order should be placed");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Order Place successfully", "PASS",
						"Order should be placed");
			}
			element = Locators.getInstance().submitDonePlaceOrderAlert(driver);
			Keywords.click(element);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while placing an order", "FAIL", "Order should be placed");
		}
	}

	public float getCustomLogoCharges(/*String logoType*/) {
		WebElement element;
		float charges = 0.0f;
		try {
			element = Locators.getInstance().customLogoAmount(driver);
			if (Keywords.isElementPresent(element))
				charges = Float.parseFloat(Keywords.getText(element).replace("$", "").trim());
		}catch(Exception e) {}
		
		return charges;
	}
 	
	public float getShippingCharges() {
		float charges = 0.00f;
		WebElement element;
		try {
			element = Locators.getInstance().shippingCharges(driver);
			if (Keywords.isElementPresent(element))
				charges = Float.parseFloat(Keywords.getText(element).replace("$", ""));
		} catch (Exception e) {
		}

		return charges;
	}

	public int getDiscountPercentage() {
		WebElement element;
		int percentage = 0;
		try {
			element = Locators.getInstance().discountPercentage(driver);
			if (Keywords.isElementPresent(element))
				percentage = Integer.parseInt(Keywords.getText(element).replace("Discount (", "").replace("%)", "").trim());
		} catch (Exception e) {}
		
		return percentage;
	}

	public float getDiscountAmount() {
		float charges = 0.00f;
		WebElement element;
		try {
			element = Locators.getInstance().discountAmount(driver);
			if (Keywords.isElementPresent(element))
				charges = Float.parseFloat(Keywords.getText(element).replace("$", ""));
		} catch (Exception e) {
		}

		return charges;
	}

	public void clickOnPlaceOrderBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().placeOrder(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Place Order button</b> click successfully", "PASS",
						"<b>Place Order button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Place Order button</b> not click successfully", "FAIL",
						"<b>Place Order button</b> should be click");
			verifyOrderPlaceSuccessfully();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Place Order button</b>", "PASS",
					"<b>Place Order button</b> should be click");
		}
	}

}
