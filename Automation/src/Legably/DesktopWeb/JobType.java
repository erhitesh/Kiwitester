package Legably.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class JobType {
	
	private WebDriver driver;
	
	public JobType(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCityNameFromJob() {
		WebElement element;
		String cityName = "";
		try {
			element = Locators.getInstance().cityName(driver);
			cityName = Keywords.getText(element);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cityName;
	}
	
	public String getStateNameFromJob() {
		WebElement element;
		String stateName = "";
		try {
			element = Locators.getInstance().state(driver);
			stateName = Keywords.getText(element);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return stateName;
	}
	
	public void clickOnProceedToPayment() {
		WebElement element;
		try {
			element = Locators.getInstance().proccedToPayment(driver);
			Keywords.doubleClick(driver, element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Procced To Payment Button </b>click successfully", "PASS", "<b>Procced To Payment Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Procced To Payment Button </b>not click successfully", "FAIL", "<b>Procced To Payment Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Procced To Payment Button </b>", "FAIL",
					"<b>Procced To Payment Button </b>should be clicked");
		}
	}
	
	public void waitForProfileSuccessfullyUpdatedMessage() {
		WebElement element;
		String stateName = "";
		try {
			element = Locators.getInstance().profileUpdatedSuccessfullyMessage(driver);
			Keywords.waitForObject(element, 60);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
