package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BackStageRegPage {
	
	private WebDriver driver;

	public BackStageRegPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegistrationLink() throws Exception {
		WebElement element = null;
		try {
			element = Locators.getInstance().backstageRegistrationLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Registration link clicked successfully", "PASS", "Registration link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on Registration link", "FAIL",
						"Distribution link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while clicking on Registration link", "FAIL",
					"Registration link should be clicked");
			throw e;
		}
	}
	
	
	private String enterFirstName() {
		WebElement element = null;
		String firstName = null;
		try {
			element = Locators.getInstance().backstageRegistrationFirstName(driver);
			firstName = "Srikanta";
			Keywords.typeText(element, firstName);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Name : <b>" + firstName + "</b> typed successfully", "PASS",
						"First Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type First Name",
						"FAIL", "First Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing First Name", "FAIL",
					"First Name should be entered");
		}
		return firstName;
	}
	
	private String enterLastName() {
		WebElement element = null;
		String lastName = null;
		try {
			element = Locators.getInstance().backstageRegistrationLastName(driver);
			lastName = "Sahoo";
			Keywords.typeText(element, lastName);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Last Name : <b>" + lastName + "</b> typed successfully", "PASS",
						"Last Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Last Name",
						"FAIL", "Last Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Last Name", "FAIL",
					"Last Name should be entered");
		}
		return lastName;
	}
	
	
	private String enterCompanyName() {
		WebElement element = null;
		String companyName = null;
		try {
			element = Locators.getInstance().backstageRegistrationCompanyName(driver);
			companyName = "KiwiTech" + Keywords.getRandomData();   
			Keywords.typeText(element, companyName);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Company Name : <b>" + companyName + "</b> typed successfully", "PASS",
						"Company Name should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Company Name",
						"FAIL", "Company Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Company Name", "FAIL",
					"Company Name should be entered");
		}
		return companyName;
	}
	
	
	private String enterEmail() {
		WebElement element = null;
		String email = null;
		try {
			element = Locators.getInstance().backstageRegistrationEmail(driver);
			email = "sriakntagenvideo" + Keywords.getRandomData() + "@gmail.com" ;   
			Keywords.typeText(element, email);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email : <b>" + email + "</b> typed successfully", "PASS",
						"Email should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Email",
						"FAIL", "Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Email", "FAIL",
					"Email should be entered");
		}
		return email;
	}
	
	private String enterPassword() {
		WebElement element = null;
		String password = null;
		try {
			element = Locators.getInstance().backstageRegistrationPassword(driver);
			password = "123sri45";   
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Password : <b>" + password + "</b> typed successfully", "PASS",
						"Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Password",
						"FAIL", "Password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Password", "FAIL",
					"Password should be entered");
		}
		return password;
	}
	
	
	private String enterConfirmPassword() {
		WebElement element = null;
		String confirmPassword = null;
		try {
			element = Locators.getInstance().backstageRegistrationConfirmPassword(driver);
			confirmPassword = "123sri45";   
			Keywords.typeText(element, confirmPassword);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Confirm Password : <b>" + confirmPassword + "</b> typed successfully", "PASS",
						"Confirm Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Confirm Password",
						"FAIL", "Confirm Password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Confirm Password", "FAIL",
					"Confirm Password should be entered");
		}
		return confirmPassword;
	}
	
	

}
