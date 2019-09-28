package Genvideo.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BackStageDistribution {


	private WebDriver driver;
	private String username = "srikantagenvideo@gmail.com";
	private String password = "123sri45";

	public BackStageDistribution(WebDriver driver) {
		this.driver = driver;
	}

	public void clickDistribution() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForDistributionLink(driver);
			element = Locators.getInstance().distributionLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Distribution Tab</b> clicked successfully", "PASS",
						"<b>Distribution Tab</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Distribution Tab</b>", "FAIL",
						"<b>Distribution Tab</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Distribution Tab </b>", "FAIL",
					"<b>Distribution Tab</b> should be clicked");
			throw e;
		}
	}


	public void clickYouTube() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForYoutubePublishing(driver);
			element = Locators.getInstance().youtubePublishing(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Youtube Publishing</b> clicked successfully", "PASS",
						"<b>Youtube Publishing</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Youtube Publishing</b>", "FAIL",
						"<b>Youtube Publishing</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Youtube Publishing </b>", "FAIL",
					"<b>Youtube Publishing</b> should be clicked");
			throw e;
		}
	}


	public void clickManageChannels() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().manageChannels(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Manage Channels</b> Button clicked successfully", "PASS",
						"<b>Manage Channels</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Manage Channels</b> Button", "FAIL",
						"<b>Manage Channels</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Manage Channels </b> Button", "FAIL",
					"<b>Manage Channels </b> Button should be clicked");
			throw e;
		}
	}


	public void clickAddChannel() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().addChannel(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Channels</b> Button clicked successfully", "PASS",
						"<b>Add Channels</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Add Channels</b> Button", "FAIL",
						"<b>Add Channels</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Add Channels </b> Button", "FAIL",
					"<b>Add Channels </b> Button should be clicked");
			throw e;
		}
	}


	public void clickConnectToYoutube() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForConnectToYoutube(driver);
			element = Locators.getInstance().connectToYoutube(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Connect to Youtube</b> Button clicked successfully", "PASS",
						"<b>Connect to Youtube<</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Connect to Youtube</b> Button", "FAIL",
						"<b>Connect to Youtube<</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Connect to Youtube</b> Button", "FAIL",
					"<b>Connect to Youtube </b> Button should be clicked");
			throw e;
		}
	}


	public void addGmailAccount() throws Exception {
		WebElement element = null;
		try {
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			clickConnectToYoutube();
			String subWindowHandler = null;
			Thread.sleep(3000L);
			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			// perform operations on popup 
			if(Locators.getInstance().gmailEmailAddress(driver) != null){
				element = Locators.getInstance().gmailEmailAddress(driver);
				Keywords.typeText(element, username);
				element = Locators.getInstance().gmailNext(driver);
				Keywords.click(element);
				Thread.sleep(2000L);
				element = Locators.getInstance().gmailPassword(driver);
				Keywords.typeText(element, password);
				element = Locators.getInstance().gmailNext(driver);//element = Locators.getInstance().signIn(driver);//
				Keywords.click(element);
				Thread.sleep(5000L);
				element = Locators.getInstance().allow(driver);
				Keywords.click(element);
			}
			else{
				Thread.sleep(5000L);
				element = Locators.getInstance().allow(driver);
				Keywords.click(element);
			}	
			driver.switchTo().window(parentWindowHandler);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Gmail Account</b> has been added successfully", "PASS",
						"<b>Gmail Account<</b> has been added successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to Add <b>Gmail Account</b> ", "FAIL",
						"<b>Gmail Account<</b> should be Added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while Adding <b>Gmail Account</b> ", "FAIL",
					"<b>Gmail Account </b> should be Added");
			throw e;
		}
	}

	public void selectCheckBox() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForSelectCheckBox(driver);
			element = Locators.getInstance().selectCheckBox(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Checkbox</b> has been selected successfully", "PASS",
						"<b>Checkbox</b> Button should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to select <b>Checkbox</b> ", "FAIL",
						"<b>Checkbox<</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while selecting <b>Checkbox</b> ", "FAIL",
					"<b>Checkbox </b> should be selected");
			throw e;
		}
	}


	public void clickScheduleVideos() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().scheduleVideos(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Schedule Videos</b> Button clicked successfully", "PASS",
						"<b>Schedule Videos</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Schedule Videos</b> Button", "FAIL",
						"<b>Schedule Videos</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Schedule Videos</b> Button", "FAIL",
					"<b>Schedule Videos </b> Button should be clicked");
			throw e;
		}
	}

	public void selectButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForChooseContentNext(driver);
			element = Locators.getInstance().select(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Select Button</b> has been clicked successfully", "PASS",
						"<b>Select Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click on <b>Select Button<</b> ", "FAIL",
						"<b>Select Button<</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking on <b>Select</b> Button ", "FAIL",
					"<b>Select Button </b> should be clicked");
			throw e;
		}
	}


	public void clickChooseContentNext() throws Exception {
		WebElement element = null;
		try {
			Thread.sleep(2000L);
			element = Locators.getInstance().chooseContentNext(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Choose Content Next</b> Button clicked successfully", "PASS",
						"<b>Choose Content Next</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Choose Content Next</b> Button", "FAIL",
						"<b>Choose Content Next</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Choose Content Next</b> Button", "FAIL",
					"<b>Choose Content Next </b> Button should be clicked");
			throw e;
		}
	}

	public void clickOptimizeMetadataNext() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForOptimizeMetadataNext(driver);
			element = Locators.getInstance().optimizeMetadataNext(driver);
			Thread.sleep(3000L);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Optimize Metadata Next</b> Button clicked successfully", "PASS",
						"<b>Optimize Metadata Next</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Optimize Metadata Next</b> Button", "FAIL",
						"<b>Optimize Metadata Next</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Optimize Metadata Next</b> Button", "FAIL",
					"<b>Optimize Metadata Next </b> Button should be clicked");
			throw e;
		}
	}


	public void clickSetDestinationNext() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForSetDestinationtNext(driver);
			element = Locators.getInstance().setDestinationtNext(driver);
			Thread.sleep(5000L);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Set Destination Next</b> Button clicked successfully", "PASS",
						"<b>Set Destination Next</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Set Destination Next</b> Button", "FAIL",
						"<b>Set Destination Next</b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Set Destination Next</b> Button", "FAIL",
					"<b>Set Destination Next </b> Button should be clicked");
			throw e;
		}
	}

	public void selectDaysOfWeek() throws Exception {
		WebElement element = null;
		try {
			Calendar calendar = Calendar.getInstance();
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			Locators.getInstance().waitForCreateAScheduleNext(driver);

			switch (day) {
			case Calendar.MONDAY:
				element =  Locators.getInstance().mondayCheckBox(driver);
				Keywords.click(element);
				break;

			case Calendar.TUESDAY:
				element =  Locators.getInstance().tuesdayCheckBox(driver);
				Keywords.click(element);
				break;

			case Calendar.WEDNESDAY:
				element =  Locators.getInstance().wednesdayCheckBox(driver);
				Keywords.click(element);
				break;

			case Calendar.THURSDAY:
				element =  Locators.getInstance().thursdayCheckBox(driver);
				Keywords.click(element);
				break;

			case Calendar.FRIDAY:
				element =  Locators.getInstance().fridayCheckBox(driver);
				Keywords.click(element);
				break;
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Days of Week </b> CheckBox clicked successfully", "PASS",
						"<b>Days of Week</b> CheckBox should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Days of Week</b> CheckBox", "FAIL",
						"<b>Days of Week </b> CheckBox should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Days of Week</b> CheckBox", "FAIL",
					"<b>Days of Week </b> CheckBox should be clicked");
			throw e;
		}
	}

	private String enterStartDate() throws Exception {
		WebElement element = null;
		String startDate = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE , 0);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			element = Locators.getInstance().startDate(driver);
			startDate = format.format(newDate);
			Keywords.typeText(element, startDate);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Start Date : <b>" + startDate + "</b> typed successfully", "PASS", "Start Date should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Start date", "FAIL",
						"Start Date should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Start date", "FAIL", "Start Date should be entered");
			throw e;
		}
		return startDate;
	}


	private String enterEndDate() throws Exception {
		WebElement element = null;
		String endDate = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE , 1);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			element = Locators.getInstance().endDate(driver);
			endDate = format.format(newDate);
			Keywords.typeText(element, endDate);
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"End Date : <b>" + endDate + "</b> typed successfully", "PASS", "End Date should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type End date", "FAIL",
						"End Date should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing End date", "FAIL", "End Date should be entered");
			throw e;
		}
		return endDate;
	}

	public String enterTime() {
		WebElement element = null;
		String dueDate1 = null;
		try {
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.MINUTE, 6);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
			element = Locators.getInstance().time(driver);
			dueDate1 = format.format(newDate);
			Keywords.clearEditField(element);
			Keywords.typeText(element, dueDate1);
			Thread.sleep(1000L);
			String check = dueDate1.toString();
			if(check.contains("AM"))
			{
				element = Locators.getInstance().time(driver);
				Keywords.typeText(element, "AM");
			}
			else
			{
				element = Locators.getInstance().time(driver);
				Keywords.typeText(element, "PM");
			}
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Time : <b>" + dueDate1
						+ "</b> typed successfully", "PASS",
						"Time should be entered");
			else
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Unable to type Time", "FAIL",
						"Time should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured...while typing Time",
					"FAIL", "Time should be entered");
		}
		return dueDate1;
	}

	public void clickCreateAScheduleNext() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForCreateAScheduleNext(driver);
			Thread.sleep(2000L);
			element = Locators.getInstance().createAScheduleNext(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Create A Schedule Next</b> Button clicked successfully", "PASS",
						"<b>Create A Schedule Next</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Create A Schedule</b> Button", "FAIL",
						"<b>Create A Schedule </b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Create A Schedule </b> Button", "FAIL",
					"<b>Create A Schedule </b> Button should be clicked");
			throw e;
		}
	}

	public void clickReviewFinish() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForReviewFinish(driver);
			Thread.sleep(2000L);
			element = Locators.getInstance().reviewFinish(driver);
			Keywords.click(element);
			//Locators.getInstance().waitForGrid(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Review Finish </b> Button clicked successfully", "PASS",
						"<b>Review Finish</b> Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Review Finish</b> Button", "FAIL",
						"<b>Review Finish </b> Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Review Finish </b> Button", "FAIL",
					"<b>Review Finish </b> Button should be clicked");
			throw e;
		}
	}



	public void enterDate() throws Exception {
		try {
			enterStartDate();
			enterEndDate();
		} catch (Exception e) {
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....while Entering Date",
					"FAIL", "while Entering Date");
			throw e;
		}
	}



	public void verifyBackStageDistribution() throws Exception {
		try {
			clickDistribution();
			clickYouTube();
			clickManageChannels();
			clickAddChannel();
			addGmailAccount();
			clickDistribution();
			clickYouTube();
			selectCheckBox();
			clickScheduleVideos();
			selectButton();
			clickChooseContentNext();
			clickOptimizeMetadataNext();
			clickSetDestinationNext();
			selectDaysOfWeek();
			enterStartDate();
			enterEndDate();
			enterTime();
			clickCreateAScheduleNext();
			clickReviewFinish();
		} catch(Exception e) {
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....while Verifying BackStage Distribution",
					"FAIL", "while Verifying BackStage Distribution");
			throw e;
		}
	}



}
