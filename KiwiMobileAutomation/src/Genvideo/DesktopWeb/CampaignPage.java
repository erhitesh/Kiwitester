package Genvideo.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class CampaignPage {

	private WebDriver driver;
	private final String imageErrorMsg = "Wrong pixel ratio - images must be square";
	private final String budgetErrorMsg = "Min budget must be lower than Max budget.";
	private final String ctaUrlErrorMsg = "Please enter a correct url starting with http://";
	private int videoCount = 1;
	String campaignTitle = null;

	public CampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCreateCampaign() {
		WebElement element = null;
		try {
			element = Locators.getInstance().newCampaignLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Create New Campaign</b> clicked successfully",
								"PASS",
								"<b>Create New Campaign</b> button should be clicked");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Create New Campaign</b>",
								"FAIL",
								"<b>Create New Campaign</b> button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Create New Campaign</b> button",
							"FAIL",
							"<b>Create New Campaign</b> button should be selected");
		}
	}

	private String entereTitle() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignTitle(driver);
			campaignTitle = "Campaign" + Keywords.getRandomData();
			Keywords.typeText(element, campaignTitle);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Title : <b>" + campaignTitle
										+ "</b> typed successfully", "PASS",
								"Campaign title should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to type campaign title",
								"FAIL", "Campaign title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while typing campaign title",
							"FAIL", "Campaign title should be entered");
		}
		return campaignTitle;
	}

	private String enterDueDate() {
		WebElement element = null;
		String dueDate = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 10);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			element = Locators.getInstance().dueDate(driver);
			dueDate = format.format(newDate);
			Keywords.typeText(element, dueDate);
			Keywords.typeTextWithoutClear(element, Keys.TAB);
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

	private String enterDescription() {
		WebElement element = null;
		String campaignDesc = null;
		try {
			element = Locators.getInstance().campaignDesc(driver);
			campaignDesc = "CampaignDescription" + Keywords.getRandomData();
			Keywords.typeText(element, campaignDesc);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Description : <b>" + campaignDesc
										+ "</b> typed successfully", "PASS",
								"Campaign description should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to type description",
								"FAIL",
								"Campaign description should be entered");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while typing campaign description",
							"FAIL", "Campaign description should be entered");
		}
		return campaignDesc;
	}

	private void uploadImage(String fileName) {
		RemoteWebElement element = null;
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().campaignImage(
					driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash
					+ "TestRepository" + GlobalParam.slash + "GenvideoFiles"
					+ GlobalParam.slash + fileName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			//Locators.getInstance().waitForImageSpinner(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Image uploaded successfully",
								"PASS", "Should upload the image");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to upload image", "FAIL",
								"Should upload the image");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while uploading image",
							"FAIL", "Should upload the image");
		}
	}

	private void clickRemoveFile() {
		WebElement element = null;
		try {
			element = Locators.getInstance().imageRemoveFile(driver);
			Keywords.waitForObject(element, 30);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Remove file</b> link clicked successfully",
								"PASS", "Remove file link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Remove file</b> link",
								"FAIL",
								"<b>Remove file</b> link clicked successfully");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Remove file</b> link",
							"FAIL", "Remove file link should be clicked");
		}
	}

	private void verifyImageUpload() {
		//WebElement element = null;
		try {
			//String incorrectImage = "test1.jpg";
			String correctImage = "test.jpg";
/*			uploadImage(incorrectImage);
			try {
				element = Locators.getInstance().imageUploadPixelError(driver);
				if (element.getText().trim().equals(imageErrorMsg))
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting("Error message verified",
									"PASS",
									"Should verify Error message of incorrect image");
				else
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting("Incorrect error msg appears",
									"FAIL",
									"Should verify Error message of incorrect image");
			} catch (Exception e) {
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting("Incorrect error msg appears",
								"FAIL",
								"Should verify Error message of incorrect image");
			}*/
			uploadImage(correctImage);
			clickRemoveFile();
			uploadImage(correctImage);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying image",
							"FAIL", "Should verify the uploading of image");
		}
	}

	public void clickContinue() throws Exception {
		WebElement element = null;
		try {
			//element = Locators.getInstance().campaignContinueButton(driver);
			element = Locators.getInstance().campaignNextBtn(driver);
			if (Keywords.getAttributeVal(element, "disabled") != null) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Next</b> button is disabled", "INFO",
								"State of Continue button");
				throw new Exception();
			}
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Next</b> clicked successfully", "PASS",
								"<b>Next</b> button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click <b>Next</b> button",
								"FAIL",
								"<b>Next</b> button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Next</b> button",
							"FAIL", "<b>Next</b> button should be selected");
			throw e;
		}
	}

	public void verifyContinue() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignNextBtn(driver);
			if (Keywords.getAttributeVal(element, "disabled") != null)
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Next</b> button is disabled", "INFO",
								"State of Next button");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b>Next</b> button is enabled",
								"INFO", "State of Next button");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while checking state of <b>Next</b> button",
							"FAIL", "State of Next button");
		}
	}

	private void verifyBudgetRange() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignMinBudget(driver);
			Keywords.typeText(element, "1000");
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting("Campaign Min Budget entered",
								"PASS", "Campaign Min Budget should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to enter Campaign Min Budget", "FAIL",
								"Campaign Min Budget should be entered");
			element = Locators.getInstance().campaignMaxBudget(driver);
			Keywords.typeText(element, "500");
			element = Locators.getInstance().campaignBudgetError(driver);
			if (element.getText().trim().equals(budgetErrorMsg))
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Campaign Error message is verified", "PASS",
								"Campaign Budget Error message should be verified");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Campaign Error message is incorrect", "FAIL",
								"Campaign Budget Error message should be verified");
			element = Locators.getInstance().campaignMaxBudget(driver);
			Keywords.typeText(element, "2000");
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting("Campaign Max Budget entered",
								"PASS", "Campaign Max Budget should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to enter Campaign Max Budget", "FAIL",
								"Campaign Max Budget should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying budget range",
							"FAIL", "Verifying Budget Range");
		}
	}

	private void enterVideoCount() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignVideoCount(driver);
			Keywords.typeText(element, String.valueOf(videoCount));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Number of video added successfully", "PASS",
								"Number of videos should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to click number of videos",
								"FAIL", "Number of videos should be entered");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while adding number of videos",
							"FAIL", "Number of videos should be entered");
		}
	}

	private boolean clickGender(String gender) {
		WebElement element = null;
		try {
			if (gender.equalsIgnoreCase("male")) {
				element = Locators.getInstance().campaignGenderMale(driver);
				Keywords.click(element);
				element = Locators.getInstance().campaignGenderMale(driver);
			} else if (gender.equalsIgnoreCase("female")) {
				element = Locators.getInstance().campaignGenderFemale(driver);
				Keywords.click(element);
				element = Locators.getInstance().campaignGenderFemale(driver);
			}
			if (DriverSession.getStepResult())
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								gender + " gender clicked successfully",
								"PASS",
								gender
										+ " gender should be clicked for Campaign");
			else
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to click click on gender",
								"FAIL",
								gender
										+ " gender should be clicked for Campaign");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking gender",
							"FAIL",
							gender + " gender should be clicked for Campaign");
		}
		return element.getAttribute("class").contains("active");
	}

	private void verifyGender() {
		try {
			clickGender("Female");
			clickGender("Male");
			if (!clickGender("Male"))
				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(
								"Male gender button reverts to the orignal state",
								"PASS", "Male gender button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Male gender is in the same state",
								"FAIL", "Male gender should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying Campaign Gender",
							"FAIL", "Verifying Campaign Gender section");
		}
	}

	private boolean clickAgeGroup(int ageGroup) {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignAgeGroup(driver, ageGroup);
			Keywords.click(element);
			element = Locators.getInstance().campaignAgeGroup(driver, ageGroup);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Age group " + element.getText()
										+ " clicked successfully",
								"PASS",
								"Age group " + element.getText()
										+ " should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Unable to select age group",
								"FAIL",
								"Age group " + element.getText()
										+ " should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking on age group",
							"FAIL", "Age group should be clicked");
		}
		return element.getAttribute("class").contains("active");
	}

	private void verifyAgeGroup() {
		try {
			for (int i = 2; i <= 6; ++i) {
				clickAgeGroup(i);
			}
			if (!clickAgeGroup(5))
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Age group is in its orignal state",
								"PASS",
								"Age group should return to its orignal state");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Age group is in the same state",
								"FAIL",
								"Age group should return to its orignal state");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying Campaign Gender",
							"FAIL", "Verifying Campaign Gender section");
		}
	}

	private void insertTag() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignTags(driver);
			Keywords.typeText(element, "te");//Keywords.typeText(element, "tech");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Tags Name entered successfully",
								"PASS", "Tag Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to enter Tag Name", "FAIL",
								"Tag Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while entering tag name",
							"FAIL", "Tag Name should be entered");
		}
	}

	private void selectTags() {
		WebElement element = null;
		try {
			for (int i = 0; i < 3; ++i) {
				element = Locators.getInstance().campaignTagResult(driver);
				Keywords.click(element);
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Tags selected successfully",
								"PASS", "Tags should be selected");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to select Tags", "FAIL",
								"Tags should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while selecting tags", "FAIL",
							"Tags should be selected");
		}
	}

	private void removeTag() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignRemoveTag(driver);
			Keywords.click(element);
			Thread.sleep(1500L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Tag removed successfully", "PASS",
								"Tag should be removed");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to remove Tags", "FAIL",
								"Tag should be removed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while removing tag", "FAIL",
							"Tag should be removed");
		}
	}

	private boolean clickVideoType(int videoType) {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignVideoType(driver,
					videoType);
			Keywords.click(element);
			element = Locators.getInstance().campaignVideoType(driver,
					videoType);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Video Type clicked successfully",
								"PASS", "Video Type should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to click on video type",
								"FAIL", "Video Type should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking on video type",
							"FAIL", "Video Type should be clicked");
		}
		return element.getAttribute("class").contains("active");
	}

	private void verifyVideoType() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignVideoType(driver, 1);
			Keywords.click(element);
			element = Locators.getInstance().campaignVideoType(driver, 6);//element = Locators.getInstance().campaignVideoType(driver, 10);
			Keywords.click(element);
			element = Locators.getInstance().campaignVideoType(driver, 1);
			if (DriverSession.getStepResult()
					&& !element.getAttribute("class").contains("active"))
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Video Type verified successfully",
								"PASS", "Video Type should be verified");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Video Type is not verified",
								"FAIL", "Video Type should be verified");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking on video type",
							"FAIL", "Video Type should be clicked");
		}
	}

	private void verifyCTAUrlField() {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().unableCTAUrl(driver);
			if (Keywords.isElementPresent(element))
				Keywords.click(element);
			element = Locators.getInstance().campaignCTAurl(driver);
			Keywords.typeText(element, "nba.com");
			/*element = Locators.getInstance().campaignCTAUrlError(driver);
			if (Keywords.getText(element).trim().equals(ctaUrlErrorMsg))
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("CTA Url Error message is verified",
								"PASS",
								"CTA Url Error message should be verified");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"CTA Url Error message is incorrect", "FAIL",
								"CTA Url Error message should be verified");
			element = Locators.getInstance().campaignCTAurl(driver);
			Keywords.typeText(element, "http://nba.com");*/
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("CTA Url entered successfully", "PASS",
							"CTA Url should be entered");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying CTA Url field",
							"FAIL", "Verifying the CTA Url field");
		}
	}

	private void insertTalkingPoints() {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().campaignTalkingPoints(driver);
			if (!Keywords.isElementPresent(element)) {
				element = Locators.getInstance().unableCampaignTalkingPoint(driver);
				Keywords.click(element);
			}
			element = Locators.getInstance().campaignTalkingPoints(driver);
			Keywords.typeText(element, "Test Talking Points");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"<b>Test Talking Points</b> entered successfully", "PASS",
								"<b>Test Talking Points</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to enter <b>Test Talking Points</b>",
								"FAIL", "<b>Test Talking Points</b> should be entered");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while entering <b>Test Talking Points</b>",
							"FAIL", "<b>Test Talking Points</b> should be entered");
		}
	}

	private void insertKeywords() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignKeywords(driver);
			Keywords.typeText(element, "Test Keywords");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b>Test Keywords</b> entered successfully",
								"PASS", "<b>Test Keywords</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to enter <b>Test Keywords</b>", "FAIL",
								"<b>Test Keywords</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while entering <b>Test Keywords</b>",
							"FAIL", "<b>Test Keywords</b> should be entered");
		}
	}

	private String clickSwitcher() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignProductsSwitch(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Switch clicked successfully",
								"PASS", "Product Switch should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Unable to click on product switch",
								"FAIL", "Product Switch should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking on switch",
							"FAIL", "Product Switch should be clicked");
		}
		return Keywords.getAttributeVal(element, "class");
	}

	private void verifySwitcher() {
		try {
			String flag = clickSwitcher();
			if (flag != null) {
				if (flag.trim().contains("active"))
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("Switch is in <b>Yes</b> mode",
									"FAIL",
									"Switch should be in <b>No</b> mode");
				else
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("Switch is in <b>No</b> mode",
									"PASS",
									"Switch should be in <b>No</b> mode");
			}
			clickSwitcher();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying switch",
							"FAIL", "Verify the product switch");
		}
	}

	private void selectProduct() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignProductName(driver);
			Keywords.typeText(element, "iPhone");
			Thread.sleep(2000L);
			element = Locators.getInstance().campaignProductList(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Product <b>iPhone 5</b> selected successfully",
								"PASS", "Product <b>iPhone 5</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Product <b>iPhone 5</b> not selected successfully", "FAIL",
								"Product <b>iPhone 5</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while selecting Product <b> iPhone 5</b>",
							"FAIL", "Product <b>iPhone 5</b> should be selected");
		}
	}

	private void verifyWalmartDistribution() {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignWalmartDistributionList(
					driver);
			String attb = Keywords.getAttributeVal(element, "class");
			if (videoCount < 3) {
				if (attb.contains("disabled"))
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting(
									"Walmart Distribution is in disabled state",
									"PASS",
									"Walmart Distribution should be in disabled state");
				else
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting(
									"Walmart Distribution is in selectable state",
									"FAIL",
									"Walmart Distribution should be in disabled state");
			} else {
				if (!attb.contains("disabled"))
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting(
									"Walmart Distribution is in selectable state",
									"PASS",
									"Walmart Distribution should be in selectable state");
				else
					DriverSession
							.getLastExecutionReportingInstance()
							.teststepreporting(
									"Walmart Distribution is in disabled state",
									"FAIL",
									"Walmart Distribution should be in selectable state");
			}
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while verifying walmart distribution",
							"FAIL", "Verifying state of Walmart Distribution");
		}
	}

	private void selectAllDistributionList() {
		List<WebElement> elements = null;
		try {
			elements = Locators.getInstance().campaignGetAllDistributionList(
					driver);
			int i = 1;
			boolean flag = true;
			for (WebElement element : elements) {
				Keywords.click(element);
				if (!element.getAttribute("class").contains("active")) {
					DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Unable to select distribution list field"+i, "FAIL",
							"All available distribution list should be selected");
					flag = false;
				}
				i++;
			}
			if (flag) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"All available distribution list selected. Total : "
								+ elements.size(), "PASS",
						"All available distribution list should be selected");
			}
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while selecting all distribution list",
							"FAIL",
							"All available distribution list should be selected");
		}
	}

	public void fillSetupForm() throws Exception {
		try {
			entereTitle();
			enterDueDate();
			enterDescription();
			verifyImageUpload();
			Thread.sleep(1500L);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while filling Setup form",
							"FAIL", "Setup from should be filled");
			throw e;
		}
	}

	public void fillBudgetingForm() throws Exception {
		try {
			verifyBudgetRange();
			enterVideoCount();
			Thread.sleep(1500L);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while filling Budgeting form",
							"FAIL", "Budgeting from should be filled");
			throw e;
		}
	}

	public void fillCreatorsForm() throws Exception {
		try {
			verifyGender();
			verifyAgeGroup();
			insertTag();
			verifyVideoType();
			verifyContinue();
			selectTags();
			verifyContinue();
			removeTag();
			Thread.sleep(1500L);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while filling Creators form",
							"FAIL", "Creators from should be filled");
			throw e;
		}
	}

	public void fillDetailsForm() throws Exception {
		try {
			verifyCTAUrlField();
			insertTalkingPoints();
			insertKeywords();
			/*verifySwitcher();
			selectProduct();*/
			Thread.sleep(6000L);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while filling Details form",
							"FAIL", "Details from should be filled");
			throw e;
		}
	}

	public void fillDistributionForm() throws Exception {
		try {
			// verifyWalmartDistribution();
			selectAllSocialChannels();
			selectAllDistributionList();
			Thread.sleep(1500L);
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while filling Distribution form",
							"FAIL", "Distribution from should be filled");
			throw e;
		}
	}

	private void selectAllSocialChannels() {
		try {
			List<WebElement> socialChanels = Locators.getInstance()
					.getAllCampaignSocialChannel(driver);
			int i = 1;
			boolean flag = true;
			for (WebElement element : socialChanels) {
				Keywords.click(element);
				if (!element.getAttribute("class").contains("active")) {
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting(
									"Unable to click social channel field number:"
											+ i, "FAIL",
									"Should click on social channel");
					flag = false;
				}
				i++;
			}
			if (flag) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"All social channels clicked successfully",
								"PASS",
								"Should click on all the  social channel");
			}
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking social channels",
							"FAIL", "Should click on all the  social channel");
		}
	}

	public void clickFinish() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().campaignFinishButton(driver);
			Keywords.click(element);
			Thread.sleep(2000l);
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("<b>Finish</b> clicked successfully",
							"PASS", "<b>Finish</b> button should be clicked");
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while clicking <b>Finish</b> button",
							"FAIL", "<b>Finish</b> button should be selected");
			throw e;
		}
	}

	public String createNewCampaign() throws Exception {
		try {
			clickCreateCampaign();
			fillDistributionForm();
			clickContinue();
			fillSetupForm();
			clickContinue();
			fillBudgetingForm();
			clickContinue();
			fillCreatorsForm();
			clickContinue();
			fillDetailsForm();
			clickFinish();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured...while creating campaign",
							"FAIL", "Creating a new Campaign");
			throw e;
		}
		return campaignTitle;
	}

}
