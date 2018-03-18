package Legably.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class BasicInfoPlusEducation {

	private WebDriver driver;

	public BasicInfoPlusEducation(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstName() {
		WebElement element;
		String fName = "";
		try {
			element = Locators.getInstance().sFName(driver);
			fName = Keywords.getText(element);
		} catch (Exception e) {
		}
		return fName;
	}

	public String getLastName() {
		WebElement element;
		String lName = "";
		try {
			element = Locators.getInstance().sLName(driver);
			lName = Keywords.getText(element);
		} catch (Exception e) {
		}
		return lName;
	}

	public String enterStreetAddress1(String address) {
		WebElement element;
		try {
			element = Locators.getInstance().InfoStreetAddress1(driver);
			Keywords.typeText(element, address);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Street Address 1 </b>enter successfully", "PASS",
						"<b>Street Address 1 </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Street Address 1 </b>not enter successfully", "FAIL",
						"<b>Street Address 1 </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Street Address 1 </b>", "FAIl",
					"<b>Street Address 1 </b>should be entered");
		}

		return address;
	}

	public String enterStreetAddress2(String address) {
		WebElement element;
		try {
			element = Locators.getInstance().InfoStreetAddress2(driver);
			Keywords.typeText(element, address);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Street Address 2 </b>enter successfully", "PASS",
						"<b>Street Address 2 </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Street Address 2 </b>not enter successfully", "FAIL",
						"<b>Street Address 2 </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Street Address 2 </b>", "FAIl",
					"<b>Street Address 2 </b>should be entered");
		}

		return address;
	}

	public String enterCity(String city) {
		WebElement element;
		try {
			element = Locators.getInstance().InfoCity(driver);
			Keywords.typeText(element, city);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>City </b>enter successfully",
						"PASS", "<b>City </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>City </b>not enter successfully", "FAIL", "<b>City </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>City </b>", "FAIl", "<b>City </b>should be entered");
		}
		return city;
	}

	public String selectState(String state) {
		WebElement element;
		try {
			element = Locators.getInstance().InfoState(driver);
			Keywords.selectByVisibleText(element, state);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>State </b>enter successfully",
						"PASS", "<b>State </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>State </b>not enter successfully", "FAIL", "<b>State </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>State </b>", "FAIl", "<b>State </b>should be entered");
		}

		return state;
	}

	public String enterZipCode(String zip) {
		WebElement element;
		try {
			element = Locators.getInstance().infoZipCode(driver);
			Keywords.typeText(element, zip);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>ZipCode </b>enter successfully",
						"PASS", "<b>ZipCode </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>ZipCode </b>not enter successfully", "FAIL", "<b>ZipCode </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>ZipCode </b>", "FAIl",
					"<b>ZipCode </b>should be entered");
		}

		return zip;
	}

	public String enterMobileNumber(String mobile) {
		WebElement element;
		try {
			element = Locators.getInstance().infoMobile(driver);
			Keywords.typeText(element, mobile);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Mobile Number </b>enter successfully", "PASS", "<b>Mobile Number </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Mobile Number </b>not enter successfully", "FAIL",
						"<b>Mobile Number </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Mobile Number </b>", "FAIl",
					"<b>Mobile Number </b>should be entered");
		}

		return mobile;
	}

	public String enterSchoolName(String name) {
		WebElement element;
		try {
			element = Locators.getInstance().educationSchool(driver);
			Keywords.typeText(element, name);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>School Name </b>enter successfully", "PASS", "<b>School Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>School Name </b>not enter successfully", "FAIL", "<b>School Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>School Name </b>", "FAIl",
					"<b>School Name </b>should be entered");
		}

		return name;
	}

	public String selectDegree(String degreeName) {
		WebElement element;
		try {
			element = Locators.getInstance().educationDegree(driver);
			Keywords.selectByVisibleText(element, degreeName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Degree </b>enter successfully",
						"PASS", "<b>Degree </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Degree </b>not enter successfully", "FAIL", "<b>Degree </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Degree </b>", "FAIl", "<b>Degree </b>should be entered");
		}

		return degreeName;
	}

	public String enterGraduateYear(String date) {
		WebElement element;
		try {
			element = Locators.getInstance().educationYearGraduate(driver);
			Keywords.typeText(element, date);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Graduate Year </b>enter successfully", "PASS", "<b>Graduate Year </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Graduate Year </b>not enter successfully", "FAIL",
						"<b>Graduate Year </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Graduate Year </b>", "FAIl",
					"<b>Graduate Year </b>should be entered");
		}

		return date;
	}

	public String enterAdditionalInfo(String info) {
		WebElement element;
		try {
			element = Locators.getInstance().educationAdditionInfo(driver);
			Keywords.typeText(element, info);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Additional Information </b>enter successfully", "PASS",
						"<b>Additional Information </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Additional Information </b>not enter successfully", "FAIL",
						"<b>Additional Information </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Additional Information </b>", "FAIl",
					"<b>Additional Information </b>should be entered");
		}

		return info;
	}

	public String selectEducationState(String stateName) {
		WebElement element;
		try {
			element = Locators.getInstance().educationState(driver);
			Keywords.selectByVisibleText(element, stateName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Education State </b>enter successfully", "PASS",
						"<b>Education State </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Education State </b>not enter successfully", "FAIL",
						"<b>Education State </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Education State </b>", "FAIl",
					"<b>Education State </b>should be entered");
		}

		return stateName;
	}

	public String enterBarRegistration(String barNumber) {
		WebElement element;
		try {
			element = Locators.getInstance().educationBarRegistration(driver);
			Keywords.typeText(element, barNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Bar Registration </b>enter successfully", "PASS",
						"<b>Bar Registration </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Bar Registration </b>not enter successfully", "FAIL",
						"<b>Bar Registration </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Bar Registration </b>", "FAIl",
					"<b>Bar Registration </b>should be entered");
		}

		return barNumber;
	}

	public String selectPracticeArea(/* String areaName */) {
		WebElement element;
		List<WebElement> elementList;
		String areaName = "";
		try {
			element = Locators.getInstance().enablePracticeAreaDropDown(driver);
			Keywords.click(element);
			elementList = Locators.getInstance().practiceAreaListValues(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size()-1)));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Practice Area </b>enter successfully", "PASS", "<b>Practice Area </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Practice Area </b>not enter successfully", "FAIL",
						"<b>Practice Area </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Practice Area </b>", "FAIl",
					"<b>Practice Area </b>should be entered");
		}

		return areaName;
	}

	public void selectMalPracticeInsurance() {
		WebElement element;
		try {
			element = Locators.getInstance().insuranceCheckbox(driver);
			Keywords.click(element);
		} catch (Exception e) {}
	}

	public void clickBasicInfoNextBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().infoNextBtn(driver);
			Keywords.doubleClick(driver, element);
			//Keywords.click(element);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>click successfully", "PASS", "<b>Next Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>not click successfully", "FAIL", "<b>Next Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Next Button </b>", "FAIl",
					"<b>Next Button </b>should be clicked");
		}
	}
}
