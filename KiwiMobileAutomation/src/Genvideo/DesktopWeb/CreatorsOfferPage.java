package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class CreatorsOfferPage {
	
	private WebDriver driver;
	String campaignTitle = null;

	public CreatorsOfferPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOffersTab() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsOffersTab(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Offers Tab</b> clicked successfully", "PASS",
						"<b>Creators Offers Tab</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Offers Tab</b>", "FAIL",
						"<b>Creators Offers Tab</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Offers Tab</b> button", "FAIL",
					"<b>Creators Offers Tab</b> button should be Clicked");
		}
	}
	
	
	public void clickOffersCampaignByTitle(String title) {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsOffersCampaignTitle(driver, title);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Offers Campaign Title</b> clicked successfully", "PASS",
						"<b>Creators Offers Campaign Title</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Offers Campaign Title</b>", "FAIL",
						"<b>Creators Offers Campaign Title</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Offers Campaign Title</b> button", "FAIL",
					"<b>Creators Offers Campaign Title</b> button should be Clicked");
		}
	}
	
	public void clickCampaignApplyButton() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsOffersApplyButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Campaign Apply Button</b> clicked successfully", "PASS",
						"<b>Campaign Apply Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Campaign Apply Button</b>", "FAIL",
						"<b>Campaign Apply Button</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Campaign Apply Button</b> button", "FAIL",
					"<b>Campaign Apply Button</b> button should be Clicked");
		}
	}
	
	public void clickCampaignApplyButtonPopUp() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsOffersApplyButtonPopUp(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Campaign Apply Button PopUp</b> clicked successfully", "PASS",
						"<b>Campaign Apply Button PopUp</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Campaign Apply Button PopUp</b>", "FAIL",
						"<b>Campaign Apply Button PopUp</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Campaign Apply Button PopUp</b> button", "FAIL",
					"<b>Campaign Apply Button PopUp</b> button should be Clicked");
		}
	}

}
