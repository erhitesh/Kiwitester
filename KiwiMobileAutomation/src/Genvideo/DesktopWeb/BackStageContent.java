package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BackStageContent {
	
	private WebDriver driver;
	
	public BackStageContent(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void clickContent() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().contentLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Content link clicked successfully",
						"PASS", "Content link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Content link", "FAIL",
						"Content link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Content link", "FAIL", "Content link should be clicked");
			throw e;
		}
	}
	
	public  void clickWhatNowButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().WaitForWhatNowButton(driver);
			element = Locators.getInstance().whatNowButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("What Now Button clicked successfully",
						"PASS", "What Now Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on What Now Button", "FAIL",
						"What Now Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on What Now Button", "FAIL", "What Now Button should be clicked");
			throw e;
		}
	}
	
	
	public  void clickEmailToAFriend() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().WaitForEmailToAFriend(driver);
			element = Locators.getInstance().emailToAFriend(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email to a Friend clicked successfully",
						"PASS", "Email to a Friend should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Email to a Friend", "FAIL",
						"Email to a Friend should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Email to a Friend", "FAIL", "Email to a Friend should be clicked");
			throw e;
		}
	}
	
	
	private String enterEmailAddress() throws Exception {
		WebElement element = null;
		String emailAddress = "mayank.kaushiK@kiwitech.com";
		try {
			element = Locators.getInstance().emailAddress(driver);
			Keywords.typeText(element, emailAddress);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email Address : <b>" + emailAddress + "</b> typed successfully", "PASS",
						"Email Address should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Email Address",
						"FAIL", "Video title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Email Address", "FAIL", "Email Address should be entered");
			throw e;
		}
		return emailAddress;
	}
	
	
	public  void clickSendButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().sendButton(driver);
			Keywords.click(element);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Send Button clicked successfully",
						"PASS", "Send Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Send Button", "FAIL",
						"Send Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Send Button", "FAIL", "Send Button should be clicked");
			throw e;
		}
	}

	
	public  void clickAddToAList() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().WaitForAddToAList(driver);
			element = Locators.getInstance().addToAList(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Add To A List clicked successfully",
						"PASS", "Add To A List should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Add To A List", "FAIL",
						"Add To A List should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Add To A List", "FAIL", "Add To A List should be clicked");
			throw e;
		}
	}
	
	public Select selectQAList() throws Exception {
		Select sel = null;
		try {
		  sel =	Locators.getInstance().chooseQAList(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>QA List Name</b> Selected successfully", "PASS",
						"<b>QA List Name</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to select <b>QA List Name</b>", "FAIL",
						"<b>QA List Name</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while selecting <b>QA List Name</b>", "FAIL",
					"<b>Reel Review Type</b> should be selected");
			throw e;
		}
		return sel;
	}
	
	
	public  String firstVideoTitle() throws Exception {
		String video = null;
		try {
			video = Locators.getInstance().firstVideoTitle(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Video Title clicked selected",
						"PASS", "First Video Title should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select First Video Title", "FAIL",
						"First Video Title should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while selecting First Video Title", "FAIL", "First Video Title should be selected");
			throw e;
		}
		return video;
	}
	
	public  String firstQAListName() throws Exception {
		WebElement element = null;
		String qaListName = null;
		try {
			element = Locators.getInstance().chooseQAListName(driver);
			qaListName = element.getText();
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First QA List Name selected",
						"PASS", "First QA List Name should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select First QA List Name", "FAIL",
						"First QA List Name should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while selecting First QA List Name", "FAIL", "First QA List Name should be selected");
			throw e;
		}
		return qaListName;
	}
	
	
	public  void clickSaveButton() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().saveButton(driver);
			Keywords.click(element);
			Thread.sleep(7000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Save Button clicked successfully",
						"PASS", "Save Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Save Button", "FAIL",
						"Save Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Save Button", "FAIL", "Save Button should be clicked");
			throw e;
		}
	}
	
	
	public  void clickListsTab() throws Exception {
		WebElement element = null;
		try {
			Thread.sleep(2000l);
			element = Locators.getInstance().listsTab(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Lists Tab clicked successfully",
						"PASS", "Lists Tab should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Lists Tab", "FAIL",
						"Lists Tab should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Lists Tab", "FAIL", "Lists Tab should be clicked");
			throw e;
		}
	}
	
	public String verifyFirstQAListName() throws Exception {
		String qaListName = null;
		try {
			qaListName =  firstQAListName();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying First QA List Name",
							"FAIL", "while Verifying First QA List Name");
			throw e;
		}
		return qaListName;
	}
	
	public  void clickQALists(String qaTitle) throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForListsTitle(driver, qaTitle);
			element = Locators.getInstance().listsTitle(driver, qaTitle);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("QA Lists clicked successfully",
						"PASS", "QA Lists should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on QA Lists", "FAIL",
						"QA Lists should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on QA Lists", "FAIL", "QA Lists should be clicked");
			throw e;
		}
	}
	
	
	public  void verifyVideoTitleOnQAList(String videoTitle) throws Exception {
		boolean check ;
		try {
			Thread.sleep(2000L);
			Locators.getInstance().waitForListsVideoTitle(driver, videoTitle);
			check = Locators.getInstance().listsVideoTitle(driver, videoTitle).isDisplayed();
			if(check == true)
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Video Title is Present on QA Lists",
						"PASS", "Verifying Video Title is Present on QA Lists");
				else
		   DriverSession.getLastExecutionReportingInstance()
		  		.teststepreporting(
						"Video Title is not Present on QA Lists",
						"FAIL", "Verifying Video Title is Present on QA Lists");
         } catch (Exception e) {
	       DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured...while<b> verifying Video Title is Present on QA Lists</b>Button",
					"FAIL", "<b>verifying Video Title is Present on QA Lists");
            }
	  }
	
	
	public void verifyEmailToAFriend() throws Exception {
		try {
			clickWhatNowButton();
			clickEmailToAFriend();
		    enterEmailAddress();
		    clickSendButton();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying Email To A Friend",
							"FAIL", "while Verifying Email To A Friend");
			throw e;
		}
	}
	
	
	public String verifyFirstVideoTitle() throws Exception {
		String videoTitle = null;
		try {
			videoTitle = firstVideoTitle();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying First QA List Name",
							"FAIL", "while Verifying First QA List Name");
			throw e;
		}
		return videoTitle;
	}
	
	public void verifyAddToAList() throws Exception {
		try {
			clickWhatNowButton();
			clickAddToAList();
		    selectQAList();
		} catch (Exception e) {
			DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception occured....while Verifying Add To a List",
							"FAIL", "while Verifying Add To a List");
			throw e;
		}
	}
	
	
	
	
	

}
