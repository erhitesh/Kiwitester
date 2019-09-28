package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public int cartQuantity() {
		return Integer.parseInt(Keywords.getText(Locators.getInstance().getPlantQuantityFromCart(driver)));
	}

	/**
	 * This method is used to navigate to the cart page.
	 */
	public void navigateToCart() {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 2);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().navigateToCart(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Cart button successfully click",
						"PASS", "Cart button should be click");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Cart button successfully not click", "FAIL", "Cart button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Cart button", "FAIL", "Cart button should be click");
		}
	}

	/**
	 * This method is used to remove plants from the cart.
	 */
	public void removePlantsFromCart() {
		List<WebElement> plantsList;
		int i = 0;
		try {
			Keywords.waitForPage(driver);
			plantsList = Locators.getInstance().removePlantsFromCart(driver);
			if (plantsList.size() > 0) {
				for (i = plantsList.size()-1; i >= 0; i--) {
					plantsList.get(i).click();
					Thread.sleep(4000l);
					plantsList = Locators.getInstance().removePlantsFromCart(driver);
					//i = 0;
				}
//				for (i = 0; i < plantsList.size(); i++) {
//					plantsList.get(i).click();
//					Thread.sleep(4000l);
//					plantsList = Locators.getInstance().removePlantsFromCart(driver);
//					i = 0;
//				}
			}
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Plants remove successfully from cart",
					"PASS", "<b>Plants should be remove from cart</br>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while removing plants from cart", "FAIL", "<b>Plants should be remove from cart</br>");
		}
	}
	
	public String removePlantFromCart(int index) {
		List<WebElement> plantTitleList;
		List<WebElement> plantDeleteBtn;
		String removePlantTitle = "";
		try {
			Keywords.waitForPage(driver);
			plantTitleList = Locators.getInstance().getTaggedPlantsTitleList(driver);
			plantDeleteBtn = Locators.getInstance().removePlantsFromCart(driver);
			removePlantTitle = Keywords.getText(plantTitleList.get(index));
			plantDeleteBtn.get(index).click();
			Thread.sleep(2000);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Plants remove successfully from cart",
					"PASS", "<b>Plants should be remove from cart</br>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while removing plants from cart", "FAIL", "<b>Plants should be remove from cart</br>");
		}
		
		return removePlantTitle;
	}
}
