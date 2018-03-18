package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ChatModel {

	private WebDriver driver;

	public ChatModel(WebDriver driver) {
		this.driver = driver;
	}

	public void tapOnHelpIcon() {
		WebElement element;
		try {
			element = Locators.getInstance().helpIcon(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Help Icon </b>click successfully", "PASS", "<b>Help Icon </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Help Icon </b>not click successfully", "FAIL", "<b>Help Icon </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the<b>Help Icon </b>click successfully", "PASS",
					"<b>Help Icon </b>should be click");
		}
	}

	public void verifyChatModelWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().iframeElement(driver);
			Keywords.switchToIFrameByElement(driver, element);
			element = Locators.getInstance().chatModelWindowMessage(driver);
			if (Keywords.getText(element).contains(DriverSession.getTestCaseData().get("ChatModelWindowMessage")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Chat Model Window </b>Message match successfully", "PASS",
						"<b>Chat Model Window </b>Message should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Chat Model Window </b>Message not match successfully", "FAIL",
						"<b>Chat Model Window </b>Message should be matched");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing on the<b>Chat Model Window </b>Message", "FAIL",
					"<b>Help Icon </b>should be click");
		}
	}

	public void hideChatModelWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().hideChatModelWindow(driver);
			Keywords.doubleClick(driver, element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Chat Model Window </b>close successfully", "PASS",
						"<b>Chat Model Window </b>should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Chat Model Window </b>still open successfully", "FAIL",
						"<b>Chat Model Window </b>should be closed");
			Thread.sleep(2000);
			Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Chat Model Window </b>close successfully", "FAIL",
					"<b>Chat Model Window </b>should be closed");
		}
	}
}
