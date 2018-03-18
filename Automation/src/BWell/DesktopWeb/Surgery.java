package BWell.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Surgery {

	private WebDriver driver;

	public Surgery(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddSurgergiesIcon() {
		WebElement element;
		try {
			element = Locators.getInstance().addSurgeries(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Surgeries Plus Icon Button </b>click successfully", "PASS",
						"<b>Add Surgeries Plus Icon Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Surgeries Plus Icon Button </b>not click successfully", "FAIL",
						"<b>Add Surgeries Plus Icon Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Surgeries Plus Icon Button </b>", "FAIL",
					"<b>Add Surgeries Plus Icon Button </b>should be clicked");
		}
	}

	public void verifyAddSurgeriesHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().diagnosisAndSurgeryHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Disease and Surgery Information"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Surgeries Header Text </b>found successfully", "PASS",
						"<b>Add Surgeries Header Text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Surgeries Header Text </b>not found successfully", "FAIL",
						"<b>Add Surgeries Header Text </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Add Surgeries Header Text </b>", "FAIL",
					"<b>Add Surgeries Header Text </b>should be found");
		}
	}
}