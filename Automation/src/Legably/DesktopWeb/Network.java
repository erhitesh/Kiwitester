package Legably.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Network {

	private WebDriver driver;

	public Network(WebDriver driver) {
		this.driver = driver;
	}

	public String lawyerHeadline(String headline) {
		WebElement element;
		try {
			element = Locators.getInstance().lawyerHeadline(driver);
			Keywords.typeText(element, headline);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Lawyer Headline</b> enter successfully", "PASS",
						"<b>Lawyer Headline</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Lawyer Headline</b> not enter successfully", "FAIL",
						"<b>Lawyer Headline</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Lawyer Headline</b>", "FAIL",
					"<b>Lawyer Headline</b> should be entered");
		}

		return headline;
	}
	
	public String abooutLawyer(String about) {
		WebElement element;
		try {
			element = Locators.getInstance().aboutLawyer(driver);
			Keywords.typeText(element, about);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>About Lawyer</b> enter successfully", "PASS",
						"<b>About Lawyer</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>About Lawyer</b> not enter successfully", "FAIL",
						"<b>Lawyer Headline</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>About Lawyer</b>", "FAIL",
					"<b>About Lawyer</b> should be entered");
		}

		return about;
	}
	
	public String linkedInLink(String linkedin) {
		WebElement element;
		try {
			element = Locators.getInstance().linkedInUrl(driver);
			Keywords.typeText(element, linkedin);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>LinkedIn Link</b> enter successfully", "PASS",
						"<b>LinkedIn Link</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>LinkedIn Link</b> not enter successfully", "FAIL",
						"<b>LinkedIn Link</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>LinkedIn Link</b>", "FAIL",
					"<b>LinkedIn Link</b> should be entered");
		}

		return linkedin;
	}
	
	
	public String clioLink(String clio) {
		WebElement element;
		try {
			element = Locators.getInstance().clioUrl(driver);
			Keywords.typeText(element, clio);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clio Link</b> enter successfully", "PASS",
						"<b>Clio Link</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clio Link</b> not enter successfully", "FAIL",
						"<b>Clio Link</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Clio Link</b>", "FAIL",
					"<b>Clio Link</b> should be entered");
		}

		return clio;
	}

}
