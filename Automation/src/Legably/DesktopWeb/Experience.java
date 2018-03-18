package Legably.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Experience {

	private WebDriver driver;

	public Experience(WebDriver driver) {
		this.driver = driver;
	}

	public String companyName(String cName) {
		WebElement element;
		try {
			element = Locators.getInstance().companyName(driver);
			Keywords.typeText(element, cName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Company Name </b>" + cName + " enter successfully", "PASS",
						"<b>Company Name </b>" + cName + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Company Name </b>" + cName + " not enter successfully", "FAIL",
						"<b>Company Name </b>" + cName + " should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Company Name </b>", "FAIL",
					"<b>Company Name </b>" + cName + " should be entered");
		}

		return cName;
	}
	
	public String enterStartDate(String startDate) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().startDate(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (startDate.contains(Keywords.getText(elementList.get(i)))) {
					Keywords.click(elementList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Start Date </b>" + startDate + " enter successfully", "PASS",
							"<b>Start Date </b>" + startDate + " should be entered");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Company Name </b>", "FAIL",
					"<b>Start Date </b>" + startDate + " should be entered");
		}

		return startDate;
	}
	
	public String enterEndDate(String enddate) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().endDate(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (enddate.contains(Keywords.getText(elementList.get(i)))) {
					Keywords.click(elementList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>End Date </b>" + enddate + " enter successfully", "PASS",
							"<b>End Date </b>" + enddate + " should be entered");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>End Date </b>", "FAIL",
					"<b>End Date </b>" + enddate + " should be entered");
		}

		return enddate;
	}
	
	public String enterDesignation(String designation) {
		WebElement element;
		try {
			element = Locators.getInstance().designation(driver);
			Keywords.typeText(element, designation);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Designation Name </b>" + designation + " enter successfully", "PASS",
						"<b>Designation Name </b>" + designation + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Designation Name </b>" + designation + " not enter successfully", "FAIL",
						"<b>Designation Name </b>" + designation + " should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Designation Name </b>", "FAIL",
					"<b>Designation Name </b>" + designation + " should be entered");
		}

		return designation;
	}
	
	public String employmentType(String eType) {
		WebElement element;
		try {
			element = Locators.getInstance().employemnetType(driver);
			Keywords.selectByVisibleText(element, eType);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Employment Type </b>" + eType + " enter successfully", "PASS",
						"<b>Employment Type </b>" + eType + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Employment Type </b>" + eType + " not enter successfully", "FAIL",
						"<b>Employment Type </b>" + eType + " should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Employment Type </b>", "FAIL",
					"<b>Employment Type </b>" + eType + " should be entered");
		}

		return eType;
	}
	
	public String skilledused(String skills) {
		WebElement element;
		try {
			element = Locators.getInstance().skilled(driver);
			Keywords.typeText(element, skills);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Skilled </b>" + skills + " enter successfully", "PASS",
						"<b>Skilled </b>" + skills + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Skilled </b>" + skills + " not enter successfully", "FAIL",
						"<b>Skilled </b>" + skills + " should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Skilled </b>", "FAIL",
					"<b>Skilled </b>" + skills + " should be entered");
		}

		return skills;
	}
	
	public String additionalyInfo(String info) {
		WebElement element;
		try {
			element = Locators.getInstance().experienceAdditionalInfo(driver);
			Keywords.typeText(element, info);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Additional Information </b>" + info + " enter successfully", "PASS",
						"<b>Additional Information </b>" + info + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Additional Information </b>" + info + " not enter successfully", "FAIL",
						"<b>Additional Information </b>" + info + " should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Additional Information </b>", "FAIL",
					"<b>Additional Information </b>" + info + " should be entered");
		}

		return info;
	}
}
