package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Support {

	private WebDriver driver;

	public Support(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToSupportPage() {
		try {
			Keywords.waitForPage(driver);
			Dashboard dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
			dashboard.selectDashboardLeftMenu("Support");
		} catch (Exception e) {
		}
	}

	public void selectSubLinksInsideSupportTab(String subLinkName) {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectSupportsSubLinks(driver, subLinkName);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Support sub link.</b> " + subLinkName + " select successfully", "PASS",
						"<b>Support sub link</b> " + subLinkName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Support sub link</b> " + subLinkName + " not select successfully", "FAIL",
						"<b>Support sub link</b> " + subLinkName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while selecting the Support sub link</b> " + subLinkName, "FAIL",
					"<b>Support sub link</b> " + subLinkName + " should be selected");
		}
	}

	public String selectRandomAppointmentDate() {
		int randomNumber = 0;
		String appointmentDate = "";
		List<WebElement> appointmentList;
		try {
			appointmentList = Locators.getInstance().appointmentDateList(driver);
			randomNumber = Keywords.getRandomInteger(appointmentList.size());
			appointmentDate = Keywords.getText(appointmentList.get(randomNumber));
			appointmentDate = appointmentDate.substring(appointmentDate.indexOf(" ") + 1, appointmentDate.length());
			Keywords.clickByJS(ElementEnum.ClassName.getElementType(), Locators.getInstance().selectAppointment(),
					randomNumber);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Date </b>select successfully", "PASS",
						"<b>Appointment Date </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Date </b>select successfully", "FAIL",
						"<b>Appointment Date </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while selecting <b>Appointment Date </b>", "FAIL",
					"<b>Appointment Date </b>should be selected");
		}

		return appointmentDate;
	}

	public String enterNumber(String phoneNumber) {
		WebElement element;
		try {
			element = Locators.getInstance().bestNoForReach(driver);
			Keywords.typeText(element, phoneNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Phone Number </b>enter successfully", "PASS", "<b>Phone Number </b>should be enetered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Phone Number </b>not enter successfully", "FAIL", "<b>Phone Number </b>should be enetered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Phone Number </b>", "FAIL",
					"<b>Phone Number </b>should be enetered");
		}

		return phoneNumber;
	}

	public String enterInvalidNumber() {
		return enterNumber(DriverSession.getTestCaseData().get("InvalidNumber"));
	}

	public void clearEnteredPhoneNumber() {
		WebElement element;
		try {
			element = Locators.getInstance().bestNoForReach(driver);
			Keywords.clearEditField(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Phone Number </b>clear successfully", "PASS", "<b>Phone Number </b>should be cleared");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Phone Number </b>not clear successfully", "FAIL", "<b>Phone Number </b>should be cleared");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clearing the <b>Phone Number </b>", "FAIL",
					"<b>Phone Number </b>should be cleared");
		}
	}

	public void verifyErrorMessageForPhoneNumber(String errorMessage) {
		WebElement element;
		try {
			element = Locators.getInstance().enterBestNoForReachErrorMsg(driver);
			if (Keywords.getText(element).equalsIgnoreCase(errorMessage))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>This is required error message </b>message display successfully", "PASS",
						"<b>This is required error message </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>This is required error message </b>message not display successfully", "FAIL",
						"<b>This is required error message </b>should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error message for <b>Phone number field</b>", "FAIL",
					"<b>This is required error message </b>should be displayed");
		}
	}

	public void verifyPhoneNumberField() {
		try {
			clearEnteredPhoneNumber();
			verifyErrorMessageForPhoneNumber(DriverSession.getTestCaseData().get("ErrorMessageForEmptyPhoneNumber"));
			enterInvalidNumber();
			verifyErrorMessageForPhoneNumber(DriverSession.getTestCaseData().get("ErrorMessageForInvalidPhoneNumber"));
			enterNumber(DriverSession.getTestCaseData().get("PhoneNumber"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectRandomAppointmentTimeSlot() {
		int randomNumber = 0;
		String appointmentTime = "";
		List<WebElement> appointmentList;
		try {
			appointmentList = Locators.getInstance().selectAppointmentTimeList(driver);
			randomNumber = Keywords.getRandomInteger(appointmentList.size());
			appointmentTime = Keywords.getText(appointmentList.get(randomNumber));
			appointmentTime = appointmentTime.substring(0, appointmentTime.indexOf(" "));
			Keywords.clickByJS(ElementEnum.ClassName.getElementType(), Locators.getInstance().selectAppointment(),
					randomNumber);
			Keywords.explicitWait(5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Time Slot </b>select successfully", "PASS",
						"<b>Appointment Time Slot </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Time Slot </b>select successfully", "FAIL",
						"<b>Appointment Time Slot </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Appointment Time Slot</b>", "FAIL",
					"<b>Appointment Time Slot </b>should be select");
		}

		return appointmentTime;
	}

	public void verifyAppointmentScheduleSuccessfullyMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().appointmentScheduleSuccessfully(driver);
			if (Keywords.getText(element)
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("AppointmentSuccessfullyMsg")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Successfully added </b>msg display successfully", "PASS",
						"<b>Appointment Successfully added </b>msg should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Appointment Successfully added </b>msg not display successfully", "FAIL",
						"<b>Appointment Successfully added </b>msg should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while verifing the <b>Appointment Successfully Schedule</b>", "FAIL",
					"<b>Appointment Successfully added </b>msg should be displayed");
		}
	}

	public void viewAppointment() {
		WebElement element;
		try {
			element = Locators.getInstance().viewAppointmentBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Appointment Button </b>click successfully", "PASS",
						"<b>View Appointment Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Appointment Button </b>not click successfully", "FAIL",
						"<b>View Appointment Button </b>should be clicked");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while clicking on the <b>View Appointment Button </b>", "FAIL",
					"<b>View Appointment Button </b>should be clicked");
		}
	}

	public void verifyScheduleAppointment(String appointmentDateAndTime) {
		WebElement element;
		try {
			Keywords.explicitWait(5);
			element = Locators.getInstance().verifyScheduledAppointment(driver, appointmentDateAndTime);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Scheduled Appointment Date & time </b>match successfully", "PASS",
						"<b>Scheduled Appointment Date & time </b>should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Scheduled Appointment Date & time </b>match successfully", "FAIL",
						"<b>Scheduled Appointment Date & time </b>should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while verifing the <b>Scheduled Appointment Date & time </b>", "FAIL",
					"<b>Scheduled Appointment Date & time </b>should be matched");
		}
	}

	public void verifyScheduleAppointmentDeleteSuccessfully(String appointmentDateAndTime) {
		try {
			if (Keywords.isElementPresent(
					Locators.getInstance().verifyScheduledAppointment(driver, appointmentDateAndTime)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Scheduled Appointment </b>visible successfully", "FAIL",
						"<b>Scheduled Appointment </b>should not be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Scheduled Appointment </b>delete successfully", "PASS",
						"<b>Scheduled Appointment </b>should not be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify <b>Scheduled Appointment </b>Existance", "FAIL",
					"<b>Scheduled Appointment </b>should not be display");
		}
	}

	public void selectScheduledAppointmentForDelete(String scheduledAppointment) {
		WebElement element;
		try {
			element = Locators.getInstance().verifyAppointmentBeforeDelete(driver, scheduledAppointment);
			if (Keywords.isElementPresent(element)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Schedule Appointment Window </b>display successfully", "PASS",
						"<b>Schedule Appointment Window </b>should be display");
				element = Locators.getInstance().removeAppointmentBtn(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				verifyScheduleAppointmentDeleteSuccessfully(scheduledAppointment);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Schedule Appointment Still Present </b>display successfully", "FAIL",
					"<b>Schedule Appointment Window </b>should not be Exist");
		}
	}

	public int getAppointmentCount() {
		int count = 0;
		try {
			count = Locators.getInstance().scheduledAppointmentDeleteBtnList(driver).size();
		} catch (Exception e) {
		}

		return count;
	}

	public void deleteAllScheduledAppointment() {
		List<WebElement> appointmentList;
		try {
			if (getAppointmentCount() > 0) {
				appointmentList = Locators.getInstance().scheduledAppointmentDeleteBtnList(driver);
				while (appointmentList.size() > 0) {
					Keywords.clickByJS(ElementEnum.ClassName.getElementType(),
							Locators.getInstance().deleteScheduledAppointmentBtnList(), 0);
					Keywords.explicitWait(2);
					Keywords.clickByJS(ElementEnum.ClassName.getElementType(),
							Locators.getInstance().removeAppointmentBtn());
					Keywords.explicitWait(2);
					appointmentList = Locators.getInstance().scheduledAppointmentDeleteBtnList(driver);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>All Appointment </b>remove successfully", "PASS",
							"<b>All Appointment </b>should be removed");
				}
			} else if (getAppointmentCount() <= 0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>No Appointment Found</b>",
						"INFO", "<b>No Appointment Found Please Add First</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>All Appointment </b>not remove successfully", "FAIL",
						"<b>All Appointment </b>should be removed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting the <b>All Appointment </b>", "FAIL",
					"<b>All Appointment </b>should be removed");
		}
	}
}