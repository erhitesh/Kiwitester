package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;


public class Notification {

	private WebDriver driver;

	public Notification(WebDriver driver) {
		this.driver = driver;
	}

	public int getNotificationCountFromIcon() {
		int count = 0;
		WebElement element;
		try {
			Keywords.refreshPage(driver);
			element = Locators.getInstance().notificationCount(driver);
			count = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
		}

		return count;
	}

	public void navigateToNotificationPage() {
		WebElement element;
		try {
			element = Locators.getInstance().notificationIcon(driver);
			Keywords.click(element);
			Keywords.verifyPageLoaded("notification");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Icon </b>click successfully", "PASS",
						"<b>Notification Icon </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Icon </b>not click successfully", "FAIL",
						"<b>Notification Icon </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Notification Icon </b>", "FAIL",
					"<b>Notification Icon </b>should be clicked");
		}
	}

	public void clearAllNotification() {
		WebElement element;
		try {
			element = Locators.getInstance().clearAllNotification(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>All Notification </b>click successfully", "PASS",
						"<b>Notification Icon </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Icon </b>not click successfully", "FAIL",
						"<b>Notification Icon </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Notification Icon </b>", "FAIL",
					"<b>Notification Icon </b>should be clicked");
		}
	}

	public void verifyNumberOfNotification(int notificationCount) {
		List<WebElement> notificationElement;
		try {
			notificationElement = Locators.getInstance().noOfNotification(driver);
			if (notificationCount == notificationElement.size())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Bar Count & Notification Count on page </b>equal", "PASS",
						"<b>Notification Bar Count & Notification Count on page </b>Should be same");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Bar Count & Notification Count on page </b>not equal", "FAIL",
						"<b>Notification Bar Count & Notification Count on page </b>Should be same");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Notification Bar Count & Notification Count on page </b>",
					"FAIL", "<b>Notification Bar Count & Notification Count on page </b>Should be same");
		}
	}

}
