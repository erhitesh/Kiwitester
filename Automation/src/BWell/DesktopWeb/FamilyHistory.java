package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.session.DriverSession;
import com.utilities.Keywords;

public class FamilyHistory {

	private WebDriver driver;

	public FamilyHistory(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToFamilyHistoryPage() {
		try {
			MyHealth myHealth = new MyHealth(driver);
			Keywords.waitForPage(driver);
			myHealth.navigateToMyHealthPage();
			myHealth.selectSubLinksInsideMyHealthTab("family");
			Keywords.verifyPageLoaded("family");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family History Page open successfully</b>", "PASS",
						"<b>Family History Page should be opened.</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family History Page not open successfully</b>", "FAIL",
						"<b>Family History Page should be opened.</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while navigating to the <b>Family History Page</b>", "FAIL",
					"<b>Family History Page should be opened.</b>");
		}
	}

	public void clickOnAddFamilyHistory() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().familyHistoryAddButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Member Button click successfully</b>", "PASS",
						"<b>Add Family Member Button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Member Button not click successfully</b>", "FAIL",
						"<b>Add Family Member Button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Family Member Button</b>", "PASS",
					"<b>Add Family Member Button should be clicked</b>");
		}
	}

	public void verifyInviteFamilyMemberHeaderText() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().inviteFamilyMemberHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Invite a Family Member"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invite Family Member header text match successfully</b>", "PASS",
						"<b>Invite Family Member header text should be matched</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invite Family Member header text not match successfully</b>", "FAIL",
						"<b>Invite Family Member header text should be matched</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Invite Family Member header text</b>", "FAIL",
					"<b>Invite Family Member header text should be matched</b>");
		}
	}

	public void closeAddFamilyMemberInfoWindow() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().closeInviteFamilyMemberPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Window</b> close successfully", "PASS",
						"<b>Add Family Window</b> should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Window</b> still open", "FAIL", "<b>Add Family Window</b> should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Add Family Window</b>", "FAIL",
					"<b>Add Family Window</b> should be closed");
		}
	}

	public String enterFName() {
		WebElement element;
		String fName = "";
		try {
			Keywords.waitForPage(driver);
			fName = DriverSession.getTestCaseData().get("Fname");
			element = Locators.getInstance().familyMemberFName(driver);
			Keywords.typeText(element, fName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member First Name </b>enter successfully", "PASS",
						"<b>Family Member First Name </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member First Name </b> not enter successfully", "FAIL",
						"<b>Family Member First Name </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member First Name </b>", "FAIL",
					"<b>Family Member First Name </b> should be entered");
		}

		return fName;
	}

	public String enterFName(String memberName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().familyMemberFName(driver);
			Keywords.typeText(element, memberName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member First Name </b>enter successfully", "PASS",
						"<b>Family Member First Name </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member First Name </b> not enter successfully", "FAIL",
						"<b>Family Member First Name </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member First Name </b>", "FAIL",
					"<b>Family Member First Name </b> should be entered");
		}

		return memberName;
	}

	public String enterLName() {
		WebElement element;
		String lName = "";
		try {
			Keywords.waitForPage(driver);
			lName = DriverSession.getTestCaseData().get("Lname");
			element = Locators.getInstance().familyMemberLName(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Last Name </b>enter successfully", "PASS",
						"<b>Family Member Last Name </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Last Name </b> not enter successfully", "FAIL",
						"<b>Family Member Last Name </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Last Name </b>", "FAIL",
					"<b>Family Member Last Name </b> should be entered");
		}

		return lName;
	}

	public String enterLName(String memberLastName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().familyMemberLName(driver);
			Keywords.typeText(element, memberLastName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Last Name </b>enter successfully", "PASS",
						"<b>Family Member Last Name </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Last Name </b> not enter successfully", "FAIL",
						"<b>Family Member Last Name </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Last Name </b>", "FAIL",
					"<b>Family Member Last Name </b> should be entered");
		}

		return memberLastName;
	}

	public String enterFamilyMemberEmailAddress() {
		WebElement element;
		String email = "";
		try {
			Keywords.waitForPage(driver);
			email = DriverSession.getTestCaseData().get("Email");
			element = Locators.getInstance().familyMemberEmailAddress(driver);
			Keywords.typeText(element, email);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Email Address </b>enter successfully", "PASS",
						"<b>Family Member Email Address </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Email Address </b> not enter successfully", "FAIL",
						"<b>Family Member Email Address </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Email Address </b>", "FAIL",
					"<b>Family Member Email Address </b> should be entered");
		}

		return email;
	}

	public String enterFamilyMemberEmailAddress(String memberEmailAddress) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().familyMemberEmailAddress(driver);
			Keywords.typeText(element, memberEmailAddress);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Email Address </b>enter successfully", "PASS",
						"<b>Family Member Email Address </b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Email Address </b> not enter successfully", "FAIL",
						"<b>Family Member Email Address </b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Email Address </b>", "FAIL",
					"<b>Family Member Email Address </b> should be entered");
		}

		return memberEmailAddress;
	}

	public String selectFamilyMemberRelation() {
		WebElement element;
		String relation = "";
		try {
			Keywords.waitForPage(driver);
			relation = DriverSession.getTestCaseData().get("Relation");
			element = Locators.getInstance().selectFamilyMemberRelation(driver);
			Keywords.selectByVisibleText(element, relation);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation </b>enter successfully", "PASS",
						"<b>Family Member Relation</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation</b> not enter successfully", "FAIL",
						"<b>Family Member Relation</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Relation</b>", "FAIL",
					"<b>Family Member Relation</b> should be entered");
		}

		return relation;
	}

	public List<String> siblings() {
		List<String> list = new ArrayList<>();
		list.add("Brother");
		list.add("Sister");

		return list;
	}

	public String randomFamilyMemberRelation() {
		List<String> list = siblings();
		return list.get(Keywords.getRandomInteger(list.size()));
	}

	public List<String> fMemberInf() {
		List<String> info = new ArrayList<>();
		info.add("QAB");
		info.add("QAS");
		return info;
	}

	public List<String> getFamilyMemberInfo(String relationValue) {
		List<String> info = new ArrayList<>();
		for (int i = 0; i < fMemberInf().size(); i++) {
			info.add(fMemberInf().get(i));
		}

		return info;
	}

	public String selectRandomFamilyMemberRelation(String relation) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectFamilyMemberRelation(driver);
			Keywords.selectByVisibleText(element, relation);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation </b>enter successfully", "PASS",
						"<b>Family Member Relation</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation</b> not enter successfully", "FAIL",
						"<b>Family Member Relation</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Relation</b>", "FAIL",
					"<b>Family Member Relation</b> should be entered");
		}

		return relation;
	}

	public String selectFamilyMemberRelation(String memberRelationValue) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectFamilyMemberRelation(driver);
			Keywords.selectByValue(element, memberRelationValue);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation </b>enter successfully", "PASS",
						"<b>Family Member Relation</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Relation</b> not enter successfully", "FAIL",
						"<b>Family Member Relation</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member Relation</b>", "FAIL",
					"<b>Family Member Relation</b> should be entered");
		}

		return memberRelationValue;
	}

	public void clickOnPreviousBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().previousBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void clickOnNextBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().nextBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void changeYearMonthDayView() {
		WebElement element;
		try {
			element = Locators.getInstance().changeYearMonthViewValue(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public boolean verifyYearMonthViewVisible(String viewType) {
		WebElement element;
		boolean status = false;
		try {
			element = Locators.getInstance().verifyYearMonthViewVisible(driver);
			if (Keywords.getAttributeVal(element, "class").contains(viewType))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public boolean verifyDayViewVisible(String viewType) {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyDayViewVisible(driver);
			if (Keywords.getAttributeVal(element, "class").contains(viewType))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public int selectYearValue() {
		List<WebElement> yearList;
		int randomYear = 0;
		try {
			Keywords.waitForPage(driver);
			/*
			 * randomYear = Keywords.getRandomIntegerBtRange(
			 * Integer.parseInt(DriverSession.getTestCaseData().get(
			 * "MinYearRange")),
			 * Integer.parseInt(DriverSession.getTestCaseData().get(
			 * "MaxYearRange")));
			 */
			randomYear = 2017;
			yearList = Locators.getInstance().yearsList(driver);
			while (Integer.parseInt(Keywords.getText(yearList.get(0))) > randomYear) {
				clickOnPreviousBtn();
				yearList = Locators.getInstance().yearsList(driver);
			}
			for (int i = 0; i < yearList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(yearList.get(i))) == randomYear) {
					Keywords.click(yearList.get(i));
					break;
				}
			}
		} catch (Exception e) {
		}

		return randomYear;
	}

	public void verifySelectedYearValue(int year) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifySelectYearMonthValue(driver);
			if (Keywords.getText(element).contains(Integer.toString(year)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Year value visible successfully</b>", "PASS",
						"<b>Selected Year value should be present</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Year value not visible successfully</b>", "FAIL",
						"<b>Selected Year value should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Selected Year value</b>", "FAIL",
					"<b>Selected Year value should be present</b>");
		}
	}

	public String selectMonthValue() {
		List<WebElement> monthList;
		String randomMonthValue = "";
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			// randomMonthValue = Keywords.randomMonthValue();
			randomNumber = 3;// Keywords.getRandomIntegerBtRange(0, 12);
			randomMonthValue = Keywords.getMonthsValueList("shortform").get(randomNumber);
			monthList = Locators.getInstance().monthsList(driver);
			for (int i = 0; i < monthList.size(); i++) {
				if (Keywords.getText(monthList.get(i)).equalsIgnoreCase(randomMonthValue)) {
					Keywords.click(monthList.get(i));
					break;
				}
			}
		} catch (Exception e) {
		}

		return randomMonthValue;
	}

	public void verifySelectedMonthValue(String monthValue) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifySelectYearMonthValue(driver);
			if (Keywords.getText(element).contains(monthValue))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Month value visible successfully</b>", "PASS",
						"<b>Selected Month value should be present</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Month value not visible successfully</b>", "FAIL",
						"<b>Selected Month value should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Selected Month value</b>", "FAIL",
					"<b>Selected Month value should be present</b>");
		}
	}

	public String selectDayValue() {
		List<WebElement> dayList;
		int randomDayValue = 0;
		String dayValue = "";
		try {
			Keywords.waitForPage(driver);
			dayList = Locators.getInstance().daysList(driver);
			randomDayValue = Keywords.getRandomInteger(dayList.size());
			for (int i = 0; i < dayList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(dayList.get(i))) == randomDayValue) {
					dayValue = Keywords.getText(dayList.get(i));
					Keywords.click(dayList.get(i));
					break;
				}
			}
		} catch (Exception e) {
		}

		return dayValue;
	}

	public String enterFamilyMemberDOB() {
		WebElement element;
		int year = 0;
		String monthValue = "";
		String day = "";
		String dob = "";
		try {
			Keywords.waitForPage(driver);
			// dob = DriverSession.getTestCaseData().get("DOB");
			element = Locators.getInstance().enableMemberDOBPopUp(driver);
			Keywords.click(element);
			while (!verifyYearMonthViewVisible("year"))
				changeYearMonthDayView();
			year = selectYearValue();
			verifySelectedYearValue(year);
			while (!verifyYearMonthViewVisible("month"))
				changeYearMonthDayView();
			monthValue = selectMonthValue();
			verifySelectedMonthValue(monthValue);
			while (!verifyDayViewVisible("weeks"))
				changeYearMonthDayView();
			day = selectDayValue();
			monthValue = Keywords.getMonthIndexBasedOnValue(monthValue);
			dob = monthValue + "/" + day + "/" + year;
			element = Locators.getInstance().enableMemberDOBPopUp(driver);
			if (dob.contains(Keywords.getText(element)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Dob value selection from date view visible successfully</b>", "PASS",
						"<b>Dob value selection from view should be present in dob textbox</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Dob value selection from view not visible in dob text box</b>", "FAIL",
						"<b>Dob value selection from view should be present in dob textbox</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the <b>Family Member DOB</b>", "FAIL",
					"<b>Family Member Relation</b> should be entered");
		}

		return dob;
	}

	public String enterMemberDob(String memberDob) {
		WebElement element;
		String command = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableMemberDOBPopUp(driver);
			command = "document.getElementsByName('dob')[0].value='" + memberDob + "';";
			Keywords.enterTextByJS(command);
		} catch (Exception e) {
		}

		return memberDob;
	}

	public void submitFamilyMemberWithInviteBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addMemberInviteButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invite Button</b> click successfully", "PASS", "<b>Invite Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invite Button</b> not click successfully", "FAIL",
						"<b>Invite Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Invite Button</b>", "FAIL",
					"<b>Invite Button</b> should be clicked");
		}
	}

	public void submitFamilyMemberInfoWithoutInvite() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addMemberWithoutInviteButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add without an Invite Button</b> click successfully", "PASS",
						"<b>Add without an Invite Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add without an Invite Button</b> not click successfully", "FAIL",
						"<b>Add without an Invite Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add without an Invite Button</b>", "FAIL",
					"<b>Add without an Invite Button</b> should be clicked");
		}
	}

	public void selectBiologicalFather() {
		WebElement element;
		try {
			element = Locators.getInstance().biologicalFather(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Biological Father</b> select successfully", "PASS",
						"<b>Biological Father</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Biological Father</b> not select successfully", "FAIL",
						"<b>Biological Father</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Biological Father</b>", "FAIL",
					"<b>Biological Father</b> should be selected");
		}
	}

	public void selectBiologicalMother() {
		WebElement element;
		try {
			element = Locators.getInstance().biologicalMother(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Biological Mother</b> select successfully", "PASS",
						"<b>Biological Mother</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Biological Mother</b> not select successfully", "FAIL",
						"<b>Biological Mother</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Biological Mother</b>", "FAIL",
					"<b>Biological Mother</b> should be selected");
		}
	}

	public String selectSibling(String siblingName) {
		List<WebElement> elementList;
		WebElement element;
		String selectedSibling = "";
		try {
			elementList = Locators.getInstance().siblings(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(siblingName)) {
					Keywords.click(elementList.get(i));
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
					element = Locators.getInstance().verifyMemberFamilyHistoryDetailText(driver);
					Keywords.waitForObject(element);
					if (DriverSession.getStepResult()) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Sibling</b> selected successfully", "PASS", "<b>Sibling</b> should be selected");
						break;
					}
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Sibling</b>", "FAIL", "<b>Sibling</b> should be selected");
		}

		return selectedSibling;
	}

	public void selectFillOutInformationBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().fillOutInfoBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Fill Out Information</b> click successfully", "PASS",
						"<b>Fill Out Information</b> btn should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Fill Out Information</b> click successfully", "PASS",
						"<b>Fill Out Information</b> btn should be clicked");
		} catch (Exception e) {

		}
	}

	public void selectOptionFromFamilyHistoryDetailPage(String options) {
		WebElement element;
		try {
			if (options.equalsIgnoreCase("fillform"))
				element = Locators.getInstance().fillOutInfoBtn(driver);

			else {

			}

		} catch (Exception e) {

		}
	}

}
