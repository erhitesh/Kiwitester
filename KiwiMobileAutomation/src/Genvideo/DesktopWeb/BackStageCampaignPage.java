package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BackStageCampaignPage {
	

	private WebDriver driver;
	static String stausLive = "LIVE";
	static String statusCompleted = "Completed";

	public BackStageCampaignPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void clickCampaignTab() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().backstageCampaignTab(DriverSession.getLastExecutionDriver());
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
	
	

}
