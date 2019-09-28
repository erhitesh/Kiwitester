package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class CreatorsDashBoardPage {
	
	private WebDriver driver;
	String campaignTitle = null;
	String videoPath = "/Document/workspace/KiwiMobileAutomation/src/sampleVideo/Sample Test.mp4";
	String thumbnailPath = "/Document/workspace/KiwiMobileAutomation/src/sampleThumbnail/thumb.jpg";

	public CreatorsDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickDashBoardTab() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsDashBoardTab(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators DashBoard Tab</b> clicked successfully", "PASS",
						"<b>Creators DashBoard Tab</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators DashBoard Tab</b>", "FAIL",
						"<b>Creators DashBoard Tab</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators DashBoard Tab</b> button", "FAIL",
					"<b>Creators DashBoard Tab</b> button should be clicked");
		}
	}
	
	public void clickDashBoardCampaignByTitle(String title) {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsDashBoardCampaignTitle(driver, title);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators DashBoard Campaign Title</b> clicked successfully", "PASS",
						"<b>Creators DashBoard Campaign Title</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators DashBoard Campaign Title</b>", "FAIL",
						"<b>Creators DashBoard Campaign Title</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators DashBoard Campaign Title</b> button", "FAIL",
					"<b>Creators DashBoard Campaign Title</b> button should be Clicked");
		}
	}
	
	public void clickUploadVideoButton() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsUploadVideoButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Upload Video Button</b> clicked successfully", "PASS",
						"<b>Creators Upload Video Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Upload Video Button</b>", "FAIL",
						"<b>Creators Upload Video Button</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Upload Video Button</b> button", "FAIL",
					"<b>Creators Upload Video Button</b> button should be clicked");
		}
	}
	
	public void clickVideoSelectFile() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsVideoButton(driver);
			Keywords.typeText(element, videoPath);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Video Select File</b> clicked successfully", "PASS",
						"<b>Creators Video Select File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Video Select File</b>", "FAIL",
						"<b>Creators Video Select File</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Video Select File</b> button", "FAIL",
					"<b>Creators Video Select File</b> button should be clicked");
		}
	}
	
	
	public void clickThumbNailSelectFile() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsThumbNailButton(driver);
			Keywords.typeText(element, thumbnailPath);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators ThumbNail Select File</b> clicked successfully", "PASS",
						"<b>Creators ThumbNail Select File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators ThumbNail Select File</b>", "FAIL",
						"<b>Creators ThumbNail Select File</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators ThumbNail Select File</b> button", "FAIL",
					"<b>Creators ThumbNail Select File</b> button should be clicked");
		}
	}
	
	public String enterVideoDescription() {
		WebElement element = null;
		String videoDesc = null;
		try {
			element = Locators.getInstance().creatorsDescriptionTextArea(driver);
			videoDesc = "Test Sample Video on Creators";
			Keywords.typeText(element, videoDesc);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Video Description : <b>" + videoDesc + "</b> typed successfully", "PASS",
						"Video description should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type description",
						"FAIL", "Video description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video description", "FAIL",
					"Video description should be entered");
		}
		return videoDesc;
	}
	
	
	public void clickProductRating() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsProductRating(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Product Rating</b> clicked successfully", "PASS",
						"<b>Creators Product Rating File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Product Rating</b>", "FAIL",
						"<b>Creators Product Rating</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Product Rating</b> button", "FAIL",
					"<b>Creators Product Rating</b> button should be clicked");
		}
	}
	
	public void clickFinishButton() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsFinishButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Finish Button</b> clicked successfully", "PASS",
						"<b>Creators Finish Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators  Finish Button</b>", "FAIL",
						"<b>Creators Finish Button</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Finish Button</b> button", "FAIL",
					"<b>Creators Finish Button</b> button should be clicked");
		}
	}
	

}
