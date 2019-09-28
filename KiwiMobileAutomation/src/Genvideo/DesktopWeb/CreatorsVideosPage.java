package Genvideo.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class CreatorsVideosPage {

	private WebDriver driver;
	private final String actualCodeCopiedText = "Code copied!";
	private final String actualLinkCopiedText = "Link Copied!";
	private final String actualCameraImagesSucessMessage = "Image has been extracted successfully!";
	private final String actualCameraImagesSucessMessage1 = "Image extraction has started successfully!";
	private final String actualUploadImagesMessage = "The image was uploaded successfully!";
	private final String actualPublishSuccessMessage = "Your video was successfuly scheduled!";

	public CreatorsVideosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickVideosTab() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsVideosTab(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Videos Tab</b> clicked successfully",
								"PASS",
								"<b>Creators Videos Tab</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Videos Tab</b>",
								"FAIL",
								"<b>Creators Videos Tab</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Videos</b>Tab",
							"FAIL",
							"<b>Creators Videos Tab</b>should be clicked");
			throw e;
		}
	}

	public void clickPublishToYouTube() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsPublishToYouTubeButton(
					driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Publish To YouTube Button</b> clicked successfully",
								"PASS",
								"<b>Creators Publish To YouTube Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Publish To YouTube Button</b>",
								"FAIL",
								"<b>Creators Publish To YouTube Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Publish To YouTube</b>Button",
							"FAIL",
							"<b>Creators Publish To YouTube</b>should be clicked");
			throw e;
		}
	}

	public void verifyPublishSucessMessage()  {
		String expectedPublishSuccessMessage = null;
		try {
			expectedPublishSuccessMessage = Locators.getInstance()
					.creatorsPublishVideoSuccessMessage(driver);
			if (expectedPublishSuccessMessage
					.equals(actualPublishSuccessMessage))
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Creators Publish Success Message is working as expected",
								"PASS", "Verifying Publish Success Message");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Creators Publish Success Message is not working as expected",
								"FAIL", "Verifying Publish Success Message");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b>verifying Publish Success Message</b>Button",
							"FAIL", "<b>verifying Publish Success Message");
		}
	}

	public void clickPublishButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsPublishButton(driver);
			Thread.sleep(7000L);
			Keywords.click(element);
			Thread.sleep(2000L);
			Locators.getInstance().waitForPublishVideoSuccessMessage(driver);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Publish Button</b> clicked successfully",
								"PASS",
								"<b>Creators Publish Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Publish Button</b>",
								"FAIL",
								"<b>Creators Publish Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Publish </b>Button",
							"FAIL", "<b>Creators Publish </b>should be clicked");
			throw e;

		}
	}

	public void clickEmbedCodeButton() throws Exception{
		WebElement element = null;
		try {
			Thread.sleep(2000L);
			Locators.getInstance().waitForEmbedCodeButton(driver);
			element = Locators.getInstance().creatorsEmbedCodeButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Embed Code Button</b> clicked successfully",
								"PASS",
								"<b>Creators Embed Code Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Embed Code Button</b>",
								"FAIL",
								"<b>Creators Embed Code Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Embed Code</b>Button",
							"FAIL",
							"<b>Creators Embed Code Button</b>should be clicked");
			throw e;
		}
	}

	public void closeEmbedCodePopUp() throws Exception{
		WebElement element = null;
		try {
			element = Locators.getInstance()
					.creatorsCloseEmbedCodePopUp(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Embed Code PopUp</b> closed successfully",
								"PASS",
								"<b>Creators Embed Code PopUp</b> should be closed");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to close <b>Creators Embed Code PopUp</b>",
								"FAIL",
								"<b>Creators Embed Code PopUp</b> should be closed");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while closing <b>Creators Embed Code PopUp</b>Button",
							"FAIL",
							"<b>Creators Embed Code PopUp</b>should be closed");
			throw e;
		}
	}

	public void verifyEmbedCopyCodeText() throws Exception {
		String expectedCodeCopiedText = null;
		try {
			expectedCodeCopiedText = Locators.getInstance()
					.creatorsEmbedCodeCopiedText(driver);
			if (expectedCodeCopiedText.equals(actualCodeCopiedText))
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Code Copied Text is working as expected",
								"PASS", "Verifying Code Copied Text");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Code Copied Text is not working as expected",
								"FAIL", "Verifying Code Copied Text");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b>verifying Code Copied Text</b>Button",
							"FAIL", "<b>verifying Code Copied Text");
			throw e;
		}
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
	}

	public void clickAffiliateLinkButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForAffiliateLinkButton(driver);
			element = Locators.getInstance()
					.creatorsAffiliateLinkButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Affiliate Link Button</b> clicked successfully",
								"PASS",
								"<b>Creators Affiliate Link Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Affiliate Link Button</b>",
								"FAIL",
								"<b>Creators Affiliate Link Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Affiliate Link</b>Button",
							"FAIL",
							"<b>Creators Affiliate Link Button</b>should be clicked");
			throw e;
		}
	}
	
   // Close Popup
	public void closeAffiliateLinksPopUp() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().closeAffiliateLinksPopUp(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Affiliate Link PopUp</b> closed successfully",
								"PASS",
								"<b>Creators Affiliate Link PopUp</b> should be closed");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to close <b>Creators Affiliate Link PopUp</b>",
								"FAIL",
								"<b>Creators Affiliate Link PopUp</b> should be closed");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while closing <b>Creators Affiliate Link </b> PopUp",
							"FAIL",
							"<b>Creators Affiliate Link PopUp</b>should be closed");
			throw e;
		}
	}

	public void verifyAffiliateCopyLinkText() {
		String expectedLinkCopiedText = null;
		try {
			expectedLinkCopiedText = Locators.getInstance()
					.creatorsAffiliateLinkCopiedText(driver);
			if (expectedLinkCopiedText.equals(actualLinkCopiedText))
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Link Copied Text is working as expected",
								"PASS", "Verifying Link Copied Text");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Link Copied Text is not working as expected",
								"FAIL", "Verifying Link Copied Text");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b>verifying Link Copied Text</b>Button",
							"FAIL", "<b>verifying Link Copied Text");
		}
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);

	}

	public void clickManageImagesButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForManageButton(driver);
			element = Locators.getInstance().creatorsManageImagesButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Manage Images Button</b> clicked successfully",
								"PASS",
								"<b>Creators Manage Images Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Manage Images Button</b>",
								"FAIL",
								"<b>Creators Manage Images Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Manage Images</b>Button",
							"FAIL",
							"<b>Creators Manage Images Button</b>should be clicked");
			throw e;
		}
	}

	public void clickManageImagesCameraButton() throws Exception{
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsManageImagesCameraButton(
					driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Manage Images Camera Button</b> clicked successfully",
								"PASS",
								"<b>Creators Manage Images Camera Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Manage Images Camera Button</b>",
								"FAIL",
								"<b>Creators Manage Images Camera Button</b>should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Manage Images Camera</b>Button",
							"FAIL",
							"<b>Creators Manage Images Camera Button</b>should be clicked");
			throw e;
		}
	}

	public void verifyCameraImagesSucessMessage()  {
		String expectedCameraImagesSucessMessage = null;
		try {
			Locators.getInstance().waitForCreatorsManageImagesSucessMessage(
					driver);
			Thread.sleep(2000L);
			expectedCameraImagesSucessMessage = Locators.getInstance()
					.creatorsManageImagesSuccessMessage(driver);
			if (expectedCameraImagesSucessMessage
					.equals(actualCameraImagesSucessMessage) ||  (expectedCameraImagesSucessMessage
							.equals(actualCameraImagesSucessMessage1)))
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Camera Images Sucess Message is working as expected",
								"PASS",
								"Verifying Camera Images Sucess Message");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Camera Images Sucess Message is not working as expected",
								"FAIL",
								"Verifying Camera Images Sucess Message");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b> verifying Camera Images Sucess Message</b>",
							"FAIL", "<b>verifying Camera Images Sucess Message");
			
		}
		
	}

	public void clickManageImagesCloseButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsManageImagesCloseButton(
					driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Manage Images Close Button</b> clicked successfully",
								"PASS",
								"<b>Creators Manage Images Close Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Manage Images Close Button</b>",
								"FAIL",
								"<b>Creators Manage Images Close</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Manage Images Close </b> Button",
							"FAIL",
							"<b>Creators Manage Images Close Button</b> should be clicked");
			throw e;
		}
	}

	public void clickManageImagesChooseFileButton() {
		RemoteWebElement element = null;
		String imagePath = null;
		String fileName = "test.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance()
					.creatorsManageImagesChooseFileButton(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash
					+ "TestRepository" + GlobalParam.slash + "GenvideoFiles"
					+ GlobalParam.slash + fileName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Choose File Button</b> clicked successfully",
								"PASS",
								"<b>Creators Choose File Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Choose File Button</b>",
								"FAIL",
								"<b>Creators Choose File</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Choose File</b> Button",
							"FAIL",
							"<b>Creators Choose File Button</b> should be clicked");
		}
	}

	public void clickManageImagesUploadButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsManageImagesUploadButton(
					driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Upload Button</b> clicked successfully",
								"PASS",
								"<b>Creators Upload Button</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Upload Button</b>",
								"FAIL",
								"<b>Creators Upload</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Upload</b> Button",
							"FAIL",
							"<b>Creators Upload Button</b> should be clicked");
			throw e;
		}
	}

	public void verifyUploadImagesSucessMessage() {
		String expectedUploadImagesMessage = null;
		try {
			Locators.getInstance().waitForCreatorsManageImagesSucessMessage(
					driver);
			expectedUploadImagesMessage = Locators.getInstance()
					.creatorsManageImagesSuccessMessage(driver);
			if (expectedUploadImagesMessage.equals(actualUploadImagesMessage))
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Upload Images Sucess Message is working as expected",
								"PASS",
								"Verifying Upload Images Sucess Message");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Upload Images Sucess Message is not working as expected",
								"FAIL",
								"Verifying Upload Images Sucess Message");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b> verifying Upload Images Sucess Message</b>",
							"FAIL", "<b>verifying Upload Images Sucess Message");
		}
	}

	public void clickSetDateTimeCheckBox() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance()
					.creatorsSetDateTimeCheckBox(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Creators Set Date and Time CheckBox</b> clicked successfully",
								"PASS",
								"<b>Creators Set Date and Time CheckBox</b> should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Creators Set Date and Time CheckBox</b>",
								"FAIL",
								"<b>Creators Set Date and Time</b> CheckBox should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Creators Set Date and Time</b> CheckBox",
							"FAIL",
							"<b>Creators Set Date and Time CheckBox</b> should be clicked");
			throw e;
		}
	}

	public String enterTime() {
		WebElement element = null;
		String dueDate = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.MINUTE, 4);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			element = Locators.getInstance().creatorsTimeTextBox(driver);
			dueDate = format.format(newDate);
			Keywords.clearEditField(element);
			Keywords.typeText(element, dueDate);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Due Date : <b>" + dueDate
										+ "</b> typed successfully", "PASS",
								"Due Date should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to type due date", "FAIL",
								"Due Date should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while typing due date",
							"FAIL", "Due Date should be entered");
		}
		return dueDate;
	}

	public void verifyStatusDisabled() {
		boolean statusDisabled;
		try {
			statusDisabled = Locators.getInstance().creatorsStatusDisabled(
					driver);
			if (!statusDisabled)
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Status DropDown is Disabled as expected",
								"PASS", "Verifying Status DropDown is Disabled");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Status DropDown is not Disabled as expected",
								"FAIL",
								"Verifying Upload Images Sucess Message");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while<b>verifying Upload Images Sucess Message</b>",
							"FAIL", "<b>verifying Upload Images Sucess Message");
		}

	}

	public void publishVideoNowCheckBox() throws Exception {
		try {
			clickVideosTab();
			clickPublishToYouTube();
			clickPublishButton();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Publishing Video with Now Selected CheckBox",
							"FAIL", "while Publishing Video Now");
			throw e;
		}
	}

	public void publishVideoWithTimeSetCheckBox() throws Exception {
		try {
			clickVideosTab();
			clickPublishToYouTube();
			clickSetDateTimeCheckBox();
			enterTime();
			verifyStatusDisabled();
			clickPublishButton();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while Publishing Video with Set Date and Time Selected CheckBox",
							"FAIL",
							"while Publishing Video with Set Date and Time");
			throw e;
		}
	}

	public void verifyEmbedCodeButton() throws Exception {
		try {
			clickVideosTab();
			clickEmbedCodeButton();
			closeEmbedCodePopUp();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying Embed Code Button",
							"FAIL", "while Verifying Embed Code Button");
			throw e;
		}
	}

	public void verifyAffiliateLinkButton() throws Exception {
		try {
			clickVideosTab();
			clickAffiliateLinkButton();
			closeAffiliateLinksPopUp();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying Affiliate Link Button",
							"FAIL", "while Verifying Affiliate Link Button");
			throw e;
		}
	}

	public void verifyManageImagesButton() throws Exception {
		try {
			clickVideosTab();
			clickManageImagesButton();
			clickManageImagesChooseFileButton();
			clickManageImagesUploadButton();
			verifyUploadImagesSucessMessage();
			clickManageImagesCameraButton();
			verifyCameraImagesSucessMessage();
			clickManageImagesCloseButton();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying Affiliate Link Button",
							"FAIL", "while Verifying Affiliate Link Button");
			throw e;
		}
	}
}
