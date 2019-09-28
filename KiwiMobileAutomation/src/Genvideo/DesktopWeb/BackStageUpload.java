package Genvideo.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class BackStageUpload {

	private WebDriver driver;
	private String videoTitle = null;
	private final String actualArrovalMessage = "Approved";
	private final String actualUploadImagesMessage = "The image was uploaded successfully!";

	public BackStageUpload(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnUploadVideoLink() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().uploadVideoLink(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Upload Video Link</b> click successfully", "PASS",
						"<b>Upload Video Link</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Upload Video Link</b> not click successfully", "FAIL",
						"<b>Upload Video Link</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Upload Video Link</b>", "FAIL",
					"<b>Upload Video Link</b> should be clicked");
		}
	}

	public void clickAddButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().addButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Button</b> clicked successfully", "PASS", "<b>Add Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click <b>Add Button</b>",
						"FAIL", "<b>Add Button</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Add</b> Button", "FAIL",
					"<b>Add</b> Button should be clicked");
			throw e;
		}
	}

	public void clickVideoLink() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().videoLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Video Link</b> clicked successfully", "PASS", "<b>Video Link</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click <b>Video Link</b>",
						"FAIL", "<b>Video Link</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Video</b> Link", "FAIL",
					"<b>Video</b> Link should be clicked");
			throw e;
		}
	}

	public Select selectClientReviewType() throws Exception {
		Select sel = null;
		try {
			sel = Locators.getInstance().clientType(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Client Review Type</b> Selected successfully", "PASS",
						"<b>Client Review Type</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to select <b>Client Review Type</b>", "FAIL",
						"<b>Client Review Type</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while selecting <b>Client Review Type</b>", "FAIL",
					"<b>Client Review Type</b> should be selected");
			throw e;
		}
		return sel;
	}

	public Select selectReelReviewType() throws Exception {
		Select sel = null;
		try {
			sel = Locators.getInstance().reelType(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reel Review Type</b> Selected successfully", "PASS",
						"<b>Reel Review Type</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to select <b>Reel Review Type</b>", "FAIL",
						"<b>Reel Review Type</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while selecting <b>Reel Review Type</b>", "FAIL",
					"<b>Reel Review Type</b> should be selected");
			throw e;
		}
		return sel;
	}

	public void clickFinalApprovalButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForFinalApprovalButton(driver);
			element = Locators.getInstance().finalApprovalButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Final Approval Button</b> clicked successfully", "PASS",
						"<b>Final Approval Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Final Approval Button</b>", "FAIL",
						"<b>Final Approval Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Final Approval </b> Button", "FAIL",
					"<b>Final Approval </b> Button should be clicked");
			throw e;
		}
	}

	public void verifyReelOrClientTextOnFinalPage(String reelOrclientName) {
		WebElement element;
		try {
			element = Locators.getInstance().ReelOrClientText(driver, reelOrclientName);
			if (Keywords.getText(element).equalsIgnoreCase(reelOrclientName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reel/Client Name match successfully</b>", "PASS",
						"<b>Reel/Client Name should be matched</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reel/Client Name not match successfully</b>", "FAIL",
						"<b>Reel/Client Name should be matched</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Reel/Client Name</b>", "FAIL",
					"<b>Reel/Client Name should be matched</b>");
			throw e;
		}
	}

	public void uploadVideo() throws Exception {
		RemoteWebElement element = null;
		String videoName = "SampleVideo.mp4";
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().videoUpload(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "GenvideoFiles" + GlobalParam.slash + videoName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(2000L);
			// Locators.getInstance().waitForBackVideoUpload(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Video Uploaded</b> successfully", "PASS", "<b>Video Uploaded</b> should be Uploaded");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to upload <b>Video Uploaded</b>", "FAIL", "<b>Video Uploaded</b> should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while Uploading <b>Video</b>", "FAIL",
					"<b>Video Uploaded</b> should be uploaded");
			throw e;
		}
	}

	private String enterClientVideoTitle() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().titleTextBox(driver);
			videoTitle = "Client" + Keywords.getRandomData();
			Keywords.typeText(element, videoTitle);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Title : <b>" + videoTitle + "</b> typed successfully", "PASS",
						"Video Title should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Video title",
						"FAIL", "Video title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video title", "FAIL", "Video title should be entered");
			throw e;
		}
		return videoTitle;
	}

	private String enterReelVideoTitle() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().titleTextBox(driver);
			videoTitle = "Reel" + Keywords.getRandomData();
			Keywords.typeText(element, videoTitle);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Title : <b>" + videoTitle + "</b> typed successfully", "PASS",
						"Video Title should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Video title",
						"FAIL", "Video title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video title", "FAIL", "Video title should be entered");
			throw e;
		}
		return videoTitle;
	}

	private String enterDescription() throws Exception {
		WebElement element = null;
		String desc = null;
		try {
			element = Locators.getInstance().descriptionTextArea(driver);
			desc = "This is BackStage Description";
			Keywords.typeText(element, desc);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Video : <b> " + desc + "</b> typed successfully", "PASS",
						"Video Description should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Video Description",
						"FAIL", "Video Description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video Description", "FAIL",
					"Video Description should be entered");
			throw e;
		}
		return desc;
	}

	private String enterKeyWords() throws Exception {
		WebElement element = null;
		String keywords = null;
		try {
			element = Locators.getInstance().keywordsTextBox(driver);
			keywords = "technology";
			Keywords.typeText(element, keywords);
			Thread.sleep(1000L);
			element.sendKeys(Keys.ENTER);
			Locators.getInstance().waitForKeywordsValue(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Video : <b> " + keywords + "</b> typed successfully", "PASS",
						"Video Keywords should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Video Keywords",
						"FAIL", "Video Keywords should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video Keywords", "FAIL", "Video Keywords should be entered");
			throw e;
		}
		return keywords;
	}

//	private String enterProduct() throws Exception {
//		WebElement element = null;
//		String product = null;
//		try {
//			element = Locators.getInstance().productTextBox(driver);
//			product = "iphone";
//			Keywords.typeText(element, product);
//			Thread.sleep(2000L);
//			Locators.getInstance().waitForProductValue(driver);
//			element = Locators.getInstance().productValue(driver);
//			Keywords.click(element);
//			if (DriverSession.getStepResult())
//				DriverSession.getLastExecutionReportingInstance().teststepreporting(
//						"Product : <b>" + product + "</b> typed successfully", "PASS", "Product should be entered");
//			else
//				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Product", "FAIL",
//						"Product should be entered");
//		} catch (Exception e) {
//			DriverSession.getLastExecutionReportingInstance()
//					.teststepreporting("Exception occured...while typing Product", "FAIL", "Product should be entered");
//			throw e;
//		}
//		return product;
//	}

	private String enterExpirationDate() throws Exception {
		WebElement element = null;
		String dueDate = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 2);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			element = Locators.getInstance().expirationDateTextBox(driver);
			dueDate = format.format(newDate);
			Keywords.typeText(element, dueDate);
			Thread.sleep(1000L);
			element.sendKeys(Keys.ESCAPE);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Expiration Date : <b>" + dueDate + "</b> typed successfully", "PASS",
						"Expiration Date should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Expiration date",
						"FAIL", "Expiration Date should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Expiration date", "FAIL", "Expiration Date should be entered");
			throw e;
		}
		return dueDate;
	}

	/*
	 * public void clickDoneButton() throws Exception { WebElement element = null;
	 * try { Thread.sleep(2000L); element =
	 * Locators.getInstance().doneButton(driver); Keywords.click(element);
	 * Locators.getInstance().WaitForNewURL(driver); Thread.sleep(8000L); if
	 * (DriverSession.getStepResult())
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "<b>Done Button</b> clicked successfully", "PASS",
	 * "<b>Done Button</b> should be clicked"); else
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "Unable to click <b>Done Button</b>", "FAIL",
	 * "<b>Done Button</b> should be clicked"); } catch (Exception e) {
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "Exception occured...while clicking <b>Done </b> Button", "FAIL",
	 * "<b>Done </b> Button should be clicked"); throw e; } }
	 */

	public void clickOnUploadVideoButton() throws Exception {
		WebElement element = null;
		try {
			Thread.sleep(2000L);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doneButton(driver);
			Keywords.click(element);
			Locators.getInstance().WaitForNewURL(driver);
			Thread.sleep(8000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Done Button</b> clicked successfully", "PASS", "<b>Done Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Done Button</b>", "FAIL", "<b>Done Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Done </b> Button", "FAIL",
					"<b>Done </b> Button should be clicked");
			throw e;
		}
	}

	public void clickContentTab() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().contentLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Content Tab clicked successfully",
						"PASS", "Content Tab should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Content Tab",
						"FAIL", "Content Tab should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Content Tab", "FAIL", "Content Tab should be clicked");
			throw e;
		}
	}

	public boolean verifyVideoAppear(String title) throws Exception {
		boolean check = false;
		try {
			if (Locators.getInstance().videoTitleText(driver, title) != null) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return check;
	}

	public void clickVideoTitle(String title) throws Exception {
		WebElement element = null;
		try {
			for (int i = 1; i <= 6; i++) {
				boolean check = verifyVideoAppear(title);
				if (check != true) {
					driver.navigate().refresh();
					Locators.getInstance().WaitForWhatNowButton(driver);
				} else {
					element = Locators.getInstance().videoTitleText(driver, title);
					Keywords.click(element);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Video Title clicked successfully",
						"PASS", "Video Title should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Video Title",
						"FAIL", "Video Title should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Video Title", "FAIL", "Video Title should be clicked");
			throw e;
		}
	}

	public void verifyPublishButtonDisabled() throws Exception {
		boolean check;
		try {
			Locators.getInstance().waitForPlayAndPause(driver);
			check = Locators.getInstance().publishButtonDisabled(driver);
			if (check == true)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Publish Button is Disabled and working as expected", "PASS",
						"Verifying Publish Button Disbaled");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Publish Button Disbaled is not working as expected", "FAIL",
						"Verifying Publish Button Disbaled");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while<b>verifying Publish Button Disbaled</b> Button", "FAIL",
					"<b>verifying Publish Button Disbaled");
		}
	}

	public void verifyApprovedText() throws Exception {
		//WebElement element = null;
		String expectedArrovalMessage = null;
		try {
			Locators.getInstance().waitForApprovalMessage(driver);
			expectedArrovalMessage = Locators.getInstance().approvalMessage(driver).getText();
			if (expectedArrovalMessage.trim().equals(actualArrovalMessage.trim()))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Arroval Status is Approved and working as expected", "PASS",
						"Verifying Arroved Message Status");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Arroval Status Approved is not working as expected", "FAIL",
						"Verifying Arroved Message Status");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while<b> Verifying Arroval Status Approved</b> Message", "FAIL",
					"<b>verifying Arroved Message Status");
		}
	}

	public void clickManageImages() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().manageImages(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Manage Images</b> clicked successfully", "PASS", "<b>Manage Images</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b> Manage Images</b>", "FAIL", "<b>Manage Images </b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Manage Images</b>", "FAIL",
					"<b>Manage Images </b>should be clicked");
			throw e;
		}
	}

	public void clickManageImagesChooseFileButton() throws Exception {
		RemoteWebElement element = null;
		String imagePath = null;
		String fileName = "test.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().chooseFileButton(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "GenvideoFiles" + GlobalParam.slash + fileName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Choose File Button</b> clicked successfully", "PASS",
						"<b>Choose File Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Choose File Button</b>", "FAIL",
						"<b>Choose File</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Choose File</b> Button", "FAIL",
					"<b>Choose File Button</b> should be clicked");
			throw e;
		}
	}

	public void clickManageImagesUploadButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().uploadButton(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Upload Button</b> clicked successfully", "PASS", "<b>Upload Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Upload Button</b>", "FAIL", "<b>Upload</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Upload</b> Button", "FAIL",
					"<b>Upload Button</b> should be clicked");
			throw e;
		}
	}

	public void verifyUploadImagesSucessMessage() throws Exception {
		String expectedUploadImagesMessage = null;
		try {
			Locators.getInstance().waitForUploadSucessMessage(driver);
			expectedUploadImagesMessage = Locators.getInstance().uploadSuccessMessage(driver);
			if (expectedUploadImagesMessage.equals(actualUploadImagesMessage))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Upload Images Sucess Message is working as expected", "PASS",
						"Verifying Upload Images Sucess Message");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Upload Images Sucess Message is not working as expected", "FAIL",
						"Verifying Upload Images Sucess Message");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while<b> verifying Upload Images Sucess Message</b>", "FAIL",
					"<b>verifying Upload Images Sucess Message");
			throw e;
		}
	}

	public void clickShowMoreImagesButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().showMoreImagesButton(driver);
			Keywords.click(element);
			Thread.sleep(4000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Show More Images Button</b> clicked successfully", "PASS",
						"<b>Show More Images Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Show More Images Button</b>", "FAIL",
						"<b>Show More Images</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Show More Images</b> Button", "FAIL",
					"<b>Show More Images Button</b> should be clicked");
			throw e;
		}
	}

	public void verifyShowMoreImagesValues() throws Exception {
		int count = 0;
		try {
			Locators.getInstance().waitForshowMoreImagesValues(driver);
			count = Locators.getInstance().showMoreImagesValues(driver);
			if (count > 1)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Show More Images Values is added and working as expected", "PASS",
						"Verifying Show More Images Values");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Upload to add Show More Images Values and is not working as expected", "FAIL",
						"Verifying Show More Images Values");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while<b> verifying Show More Images Values</b>", "FAIL",
					"<b>verifying Show More Images Values");
			throw e;
		}
	}

	public void clickManageImagesCloseButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().manageImagesCloseButton(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Manage Images Close Button</b> clicked successfully", "PASS",
						"<b>Manage Images Close Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Manage Images Close Button</b>", "FAIL",
						"<b>Manage Images Close</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Manage Images Close </b> Button", "FAIL",
					"<b>Manage Images Close Button</b> should be clicked");
			throw e;
		}
	}

	public void clickDownloadVideo() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().downloadVideo(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Download Video Link</b> clicked successfully", "PASS",
						"<b>Download Video Link</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Download Video Link</b>", "FAIL",
						"<b>Download Video</b> Link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Download Video Link </b>", "FAIL",
					"<b>Download Video Link</b> should be clicked");
			throw e;
		}
	}

	public void clickDownloadVideo360Resolution() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().downloadVideo360Resolution(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			element.sendKeys(Keys.ENTER);//element.sendKeys(Keys.ESCAPE);
			Thread.sleep(3000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Download Video 360 Resolution</b> clicked successfully", "PASS",
						"<b>Download Video 360 Resolution</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Download Video 360 Resolution</b>", "FAIL",
						"<b>Download Video</b> 360 Resolution should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Download Video 360 Resolution </b>", "FAIL",
					"<b>Download Video 360 Resolution</b> should be clicked");
			throw e;
		}
	}

	public String enterClientVideoTitle1() throws Exception {
		try {
			videoTitle = enterClientVideoTitle();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Entering Video Title", "FAIL", "while Entering Video Title");
			throw e;
		}
		return videoTitle;
	}

	public String enterClientVideoForm() throws Exception {
		try {
			videoTitle = enterClientVideoTitle();
			enterDescription();
			enterKeyWords();
			enterExpirationDate();
			clickOnUploadVideoButton();// clickDoneButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Entering Video Form", "FAIL", "while Entering Video Form");
			throw e;
		}
		return videoTitle;
	}

	public String enterReelVideoTitle1() throws Exception {
		try {
			videoTitle = enterReelVideoTitle();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Entering Video Title", "FAIL", "while Entering Video Title");
			throw e;
		}
		return videoTitle;
	}

	public String enterReelVideoForm() throws Exception {
		try {
			videoTitle = enterReelVideoTitle();
			enterDescription();
			enterKeyWords();
			enterExpirationDate();
			clickOnUploadVideoButton();// clickDoneButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Entering Video Form", "FAIL", "while Entering Video Form");
			throw e;
		}
		return videoTitle;
	}

	public void verifyApprovedTextWithPublishButton() throws Exception {
		try {
			verifyPublishButtonDisabled();
			verifyApprovedText();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Verifying Approved Text With Publish Button", "FAIL",
					"while Verifying Approved Text With Publish Button");
			throw e;
		}
	}

}
