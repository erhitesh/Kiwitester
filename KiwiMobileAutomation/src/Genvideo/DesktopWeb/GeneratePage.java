package Genvideo.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class GeneratePage {

	private WebDriver driver;

	public GeneratePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSkip() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().generateSkipLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Skip</b> link clicked successfully", "PASS", "<b>Skip</b> link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click Skip link", "FAIL",
						"<b>Skip</b> link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Finish</b> button", "FAIL",
					"<b>Finish</b> button should be selected");
			throw e;
		}
	}

	public void selectCampaign(String campaignTitle) throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForCampaignVisible(driver);
			Thread.sleep(8000l);
			element = Locators.getInstance().generateSelectCampaign(driver);
			if (Keywords.getText(element).equalsIgnoreCase(campaignTitle)) 
				Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>" + campaignTitle + "</b> clicked successfully", "PASS", "Campaign should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select Campaign", "FAIL",
						"Campaign should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking on the campaign", "FAIL", "Campaign should be selected");
			throw e;
		}
	}

	public void selectCreators() throws Exception {
		List<WebElement> elements = null;
		try {
			elements = Locators.getInstance().generateSelectSelectors(driver);
			Keywords.click(elements.get(0));
			if (elements.size() >= 2) {
				Keywords.click(elements.get(1));
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Creators selected", "PASS",
						"Two invitees to be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Only One creator is available and selected", "INFO", "Two creators to be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while selecting creators", "FAIL", "Two creators to be selected");
			throw e;
		}
	}

	public void clickInviteButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().generateInviteCreators(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invite Selected</b> clicked successfully", "PASS",
						"<b>Invite Selected</b> button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Invite button",
						"FAIL", "<b>Invite Selected</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Invite Selected</b> button", "FAIL",
					"<b>Invite Selected</b> button should be selected");
			throw e;
		}
	}

	public void inviteCreators() throws Exception {
		try {
			selectCreators();
			clickInviteButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while sending invites", "FAIL", "Sending Invites to the Creators");
			throw e;
		}
	}

	public void returnToCM() throws Exception {
		WebElement element = null;
		try {
			Thread.sleep(3000l);
			element = Locators.getInstance().generateReturnToCampaignManager(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Navigated to Campaign Manager",
						"PASS", "Campaign Manager should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to navigate to Campaign Manager", "FAIL", "Campaign Manager should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while switching to Campaign Manager", "FAIL",
					"Campaign Manager should be opened");
			throw e;
		}
	}

	public void publishCampaign(String campaignTitle) throws Exception {
		WebElement element = null;
		List<WebElement> campaignList;
		try {
			/*element = Locators.getInstance().generateCampaignGear(driver, campaignTitle);
			Keywords.click(element);*/
			Thread.sleep(5000l);
			Keywords.waitForPage(driver);
			campaignList = Locators.getInstance().generateCampaignGear(driver);
			for (int i = 0; i < campaignList.size(); i++) {
				if (Keywords.getText(campaignList.get(i)).equalsIgnoreCase(campaignTitle)) {
					Keywords.click(campaignList.get(i));
					Thread.sleep(3000);
					break;
				}
			}
			Keywords.waitForObject(Locators.getInstance().liveStatus(driver), 30);
			element = Locators.getInstance().liveStatus(driver);
			if (Keywords.isElementPresent(element))
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Campaign Offer set to live",
							"PASS", "Setting Offer to live");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to set offer to live",
							"FAIL", "Setting Offer to live");
			/*Locators.getInstance().waitForShortSpinner(driver);
			element = Locators.getInstance().generateSetOfferStatus(driver);
			Keywords.selectText(element, "Published");
			element = Locators.getInstance().generateSubmitButton(driver);
			Keywords.click(element);
			Thread.sleep(1500L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Campaign Offer set to live",
						"PASS", "Setting Offer to live");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to set offer to live",
						"FAIL", "Setting Offer to live");*/
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while setting offer to live", "FAIL", "Setting Offer to live");
			throw e;
		}
	}

}
