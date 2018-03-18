package BWell.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Allergy {

	private WebDriver driver;

	public Allergy(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyAllergyPageLoaded() {
		WebElement element;
		try {
			Keywords.verifyPageLoaded("/allergies/");
			element = Locators.getInstance().addAllergyFromAllergyPage(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Page</b> loaded successfully", "PASS", "<b>Allergy Page</b> should be Loaded");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Page</b> not loaded successfully", "FAIL", "<b>Allergy Page</b> should be Loaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Allergy Page</b> loaded", "FAIL",
					"<b>Allergy Page</b> should be Loaded");
		}
	}

	public void clickOnAddAllergyBtn() {// navigateToAddAllergyFromAllergyDetailPage
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAllergyFromAllergyPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Allergy Button </b> click successfully", "PASS",
						"<b>Add Allergy Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Allergy Button </b> not click successfully", "FAIL",
						"<b>Add Allergy Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Allergy Button </b>", "FAIL",
					"<b>Add Allergy Button</b> should be clicked");
		}
	}

	/**
	 * This method is used to get added allergy name.
	 * 
	 * @return : allergy name of type String
	 */
	public String addedAllergyName(List<String> allergiesList) {
		String allergyName = "";
		List<WebElement> allergiesListUnderDropdown;
		// List<String> remainingAllergiesList;
		WebElement element;
		int randomIndexValue = 0;
		try {
			element = Locators.getInstance().enableAllergiesNameDropDown(driver);
			Keywords.click(element);
			Keywords.explicitWait(3);
			//Keywords.waitForPageFullyLoaded(driver);
			allergiesListUnderDropdown = Locators.getInstance().allergiesListInsideDropdown(driver);
			randomIndexValue = Keywords.getRandomInteger(allergiesListUnderDropdown.size() - 1);
			allergyName = Keywords.getText(allergiesListUnderDropdown.get(randomIndexValue));
			while (allergiesList.contains(allergyName)) {
				allergiesListUnderDropdown = Locators.getInstance().allergiesListInsideDropdown(driver);
				randomIndexValue = Keywords.getRandomInteger(allergiesListUnderDropdown.size() - 1);
				allergyName = Keywords.getText(allergiesListUnderDropdown.get(randomIndexValue));
			}
			Keywords.click(allergiesListUnderDropdown.get(randomIndexValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " <b> select successfully</b>", "PASS",
						"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " <b> not select successfully</b>", "FAIL",
						"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Allergy Name </b>" + allergyName, "FAIL",
					"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
		}

		return allergyName;
	}

	public String reAddAllergyName() {
		String allergyName = "";
		List<WebElement> alleriesList;
		WebElement element;
		int randomIndexValue = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().reEnableAllergyDropDown(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			Keywords.waitForPageFullyLoaded(driver);
			alleriesList = Locators.getInstance().allergiesListInsideDropdown(driver);
			randomIndexValue = Keywords.getRandomInteger(alleriesList.size() - 1);
			allergyName = Keywords.getText(alleriesList.get(randomIndexValue));
			Keywords.click(alleriesList.get(randomIndexValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " <b> select successfully</b>", "PASS",
						"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " <b> not select successfully</b>", "FAIL",
						"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Allergy Name </b>" + allergyName, "FAIL",
					"<b>Allergy Name </b>" + allergyName + " <b> should be selected</b>");
		}

		return allergyName;
	}

	public String addAllergyStatus() {
		WebElement element;
		String allergyStatus = "";
		List<WebElement> allergiesStatusList;
		int randomIndexValue = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableAllergyStatusDropDown(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			Keywords.waitForPageFullyLoaded(driver);
			allergiesStatusList = Locators.getInstance().selectAllergyStatus(driver);
			randomIndexValue = Keywords.getRandomInteger(allergiesStatusList.size() - 1);
			allergyStatus = Keywords.getText(allergiesStatusList.get(randomIndexValue));
			Keywords.click(allergiesStatusList.get(randomIndexValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Status </b>" + allergyStatus + " <b> select successfully</b>", "PASS",
						"<b>Allergy Status </b>" + allergyStatus + " <b> should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Status </b>" + allergyStatus + " <b> not select successfully</b>", "FAIL",
						"<b>Allergy Status </b>" + allergyStatus + " <b> should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Allergy Status </b>" + allergyStatus, "FAIL",
					"<b>Allergy Status </b>" + allergyStatus + " <b> should be selected</b>");
		}

		return allergyStatus;
	}

	public String addAllergySeverity() {
		WebElement element;
		String allergySeverity = "";
		List<WebElement> allergiesSeverityList;
		int randomIndexValue = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableAllergySeverityDropDown(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			Keywords.waitForPageFullyLoaded(driver);
			allergiesSeverityList = Locators.getInstance().selectAllergySeverity(driver);
			randomIndexValue = Keywords.getRandomInteger(allergiesSeverityList.size() - 1);
			allergySeverity = Keywords.getText(allergiesSeverityList.get(randomIndexValue));
			Keywords.click(allergiesSeverityList.get(randomIndexValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Severity </b>" + allergySeverity + " <b> select successfully</b>", "PASS",
						"<b>Allergy Severity </b>" + allergySeverity + " <b> should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Severity </b>" + allergySeverity + " <b> not select successfully</b>", "FAIL",
						"<b>Allergy Severity </b>" + allergySeverity + " <b> should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Allergy Severity </b>" + allergySeverity, "FAIL",
					"<b>Allergy Severity </b>" + allergySeverity + " <b> should be selected</b>");
		}

		return allergySeverity;
	}

	public String enterAllergyReaction() {
		WebElement element;
		String allergyReaction = "reactions";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyReaction(driver);
			Keywords.typeText(element, allergyReaction);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Reactions enter successfully</b>", "PASS",
						"<b>Allergy Reactions should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Reactions not enter successfully</b>", "FAIL",
						"<b>Allergy Reactions should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Allergy Reactions</b>", "FAIL",
					"<b>Allergy Reactions should be entered</b>");
		}
		return allergyReaction;
	}

	public String setEpisodeDate(String dateFor) {
		WebElement element;
		String dob = "";
//		 List<WebElement> elementList;
//		 int year = 0;
//		 String dayValue = "";
//		 String monthValue = "";
//		 int monthIndex = 0;
//		 int day = 0;
//		 String dob = "";
//		 try {
//		 FamilyHistory family = new FamilyHistory(driver);
//		 Keywords.waitForPage(driver);
//		 element = Locators.getInstance().enableEpisodeDateWindow(driver,
//		 dateFor);
//		 Keywords.click(element);
//		 while (!family.verifyYearMonthViewVisible("year"))
//		 family.changeYearMonthDayView();
//		 year = family.selectYearValue();
//		 family.verifySelectedYearValue(year);
//		 while (!family.verifyYearMonthViewVisible("month"))
//		 family.changeYearMonthDayView();
//		 if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
//		 Thread.sleep(2000);
//		 elementList = Locators.getInstance().monthsList(driver);
//		 for (int i = 0; i < elementList.size(); i++) {
//		 if
//		 (Keywords.getText(elementList.get(i)).equalsIgnoreCase(Keywords.getCurrentYMDValue("month")))
//		 {
//		 monthValue = Keywords.getText(elementList.get(i));
//		 elementList.get(i).click();
//		 break;
//		 }
//		 }
//		 } else
//		 monthValue = family.selectMonthValue();
//		 family.verifySelectedMonthValue(monthValue);
//		 while (!family.verifyDayViewVisible("weeks"))
//		 family.changeYearMonthDayView();
//		 if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
//		 element = Locators.getInstance().selectCurrentDayValue(driver);
//		 if
//		 (Keywords.getText(element).equalsIgnoreCase(Keywords.getCurrentYMDValue("day")))
//		 dayValue = Keywords.getText(element);
//		 Keywords.click(element);
//		 } else
//		 dayValue = family.selectDayValue();
//		 dayValue = new DecimalFormat("00").format(dayValue);
//		 System.out.println("dayValue"+dayValue);
//		 monthIndex = Keywords.monthValueInDecimalFormat(monthValue);
//		 System.out.println("monthIndex"+monthIndex);
//		 dob = monthIndex + "/" + dayValue + "/" + year;
//		 System.out.println(dob);
//		 element = Locators.getInstance().enableEpisodeDateWindow(driver,
//		 dateFor);
//		 if (dob.contains(Keywords.getText(element)))
//		 DriverSession.getLastExecutionReportingInstance().teststepreporting(
//		 dateFor.toUpperCase() + "<b> Date selection from date view visible
//		 successfully</b>", "PASS",
//		 dateFor.toUpperCase() + "<b> Date selection from view should be
//		 present in dob textbox</b>");
//		 else
//		 DriverSession.getLastExecutionReportingInstance().teststepreporting(
//		 dateFor.toUpperCase() + "<b> Date selection from view not visible in
//		 dob text box</b>", "FAIL",
//		 dateFor.toUpperCase() + "<b> Date selection from view should be
//		 present in dob textbox</b>");
//		 } catch (Exception e) {
//		 DriverSession.getLastExecutionReportingInstance().teststepreporting(
//		 "Excetion occurred while entering the " + dateFor.toUpperCase() +
//		 "<b> Family Member DOB</b>",
//		 "FAIL",
//		 dateFor.toUpperCase() + "<b> Date selection from view should be
//		 present in dob textbox</b>");
//		 }
		element = Locators.getInstance().enableEpisodeDateWindow(driver, dateFor);
		Keywords.click(element);
		element = Locators.getInstance().selectCurrentDayValue(driver);
		Keywords.click(element);
		dob = Keywords.getCurrentDate("MM/dd/yyyy");

		return dob;
	}

/*	public String enterLastEpisodeDate() {
		WebElement element;
		String dateValue = "";
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForObject(Locators.getInstance().enableLastEpicodeDatePopup(driver), 20);
			element = Locators.getInstance().enableOnSetDatePopup(driver);
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 0);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			dateValue = format.format(newDate);
			Keywords.enterTextByJS("document.getElementsByName('lastEpisode')[0].value='" + dateValue + "';");
			// Keywords.typeText(element, dateValue);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy OnSet Date enter successfully</b>", "PASS",
						"<b>Allergy OnSet Date should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy OnSet Date enter successfully</b>", "FAIL",
						"<b>Allergy OnSet Date should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering Allergy OnSet Date</b>", "FAIL",
					"<b>Allergy OnSet Date should be entered</b>");
		}

		return dateValue;
	}*/

	public String enterAllergyTreatment() {
		WebElement element;
		String allergyTreatment = "treatment";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyTreatment(driver);
			Keywords.typeText(element, allergyTreatment);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Treatment enter successfully</b>", "PASS",
						"<b>Allergy Treatment should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Treatment not enter successfully</b>", "FAIL",
						"<b>Allergy Treatment should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Allergy Treatment</b>", "FAIL",
					"<b>Allergy Treatment should be entered</b>");
		}
		return allergyTreatment;
	}

	public boolean allergySaveBtnStatus() {
		WebElement element;
		boolean status = false;
		try {
			element = Locators.getInstance().submitAllergyDetails(driver);
			status = Keywords.isElementEnable(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void submitAddAllergyPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForObject(Locators.getInstance().submitAllergyDetails(driver), 20);
			element = Locators.getInstance().submitAllergyDetails(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Page submit successfully</b>", "PASS", "<b>Allergy Page should be submit</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Page not submit successfully</b>", "FAIL", "<b>Allergy Page should be submit</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while submitting the Allergy Detail Page</b>", "FAIL",
					"<b>Allergy Page should be submit</b>");
		}
	}

	public void verifyAllergySuccessfullyAddedMessage(String allergyName) {
		WebElement element;
		String message = "Your allergy for '" + allergyName + "' has been saved.";
		try {
			//Keywords.waitForObject(Locators.getInstance().allergySuccessfullyAddedMessage(driver), 30);
			element = Locators.getInstance().allergySuccessfullyAddedMessage(driver);
			if (Keywords.getText(element).contains(message))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Successfully Added</b> message visible successfully", "PASS",
						"<b>Allergy Successfully Added message should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Successfully Added</b> message not visible successfully", "FAIL",
						"<b>Allergy Successfully Added message should be visible</b>");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Allergy Successfully Added</b> message", "FAIL",
					"<b>Allergy Successfully Added message should be visible</b>");
		}
	}

	public void clickOnAllergyRemoveBtn() {
		WebElement element;
		try {
			Thread.sleep(2000);
			Keywords.waitForObject(Locators.getInstance().editAllergyHeaderText(driver));
			element = Locators.getInstance().removeAllergyBtn(driver);
			if (Keywords.isElementEnable(element))
				Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Button </b> click successfully", "PASS", "<b>Remove Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Button </b> not click successfully", "FAIL",
						"<b>Remove Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Remove Button </b>", "FAIL",
					"<b>Remove Button </b>should be clicked");
		}
	}

	public void verifyAllergyNameAfterRemove(String allergyName) {
		List<String> allergiesList;
		try {
			Keywords.waitForPage(driver);
			Thread.sleep(5000);
			allergiesList = getAllergiesList();
			if (allergiesList.contains(allergyName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " still present.", "FAIL",
						"<b>Allergy Name </b>" + allergyName + " should not be found.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergy Name </b>" + allergyName + " remove successfully", "PASS",
						"<b>Allergy Name </b>" + allergyName + " should not be found.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Allergy Name </b>" + allergyName, "FAIL",
					"<b>Allergy Name </b>" + allergyName + " should not be found.");
		}
	}

	public boolean errorMessage() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().alreadyAddedAllergyErrorMessage(driver);
			if (Keywords.isElementPresent(element))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	// >>>>>>>>> Allergy Detail Page >>>>>>>>>>>>
	/**
	 * This method is used to navigate to allergy page.
	 */
	public void navigateToAllergiesPage() {
		try {
			MyHealth myhealth = new MyHealth(DriverSession.getLastExecutionDriver());
			myhealth.navigateToMyHealthPage();
			myhealth.selectSubLinksInsideMyHealthTab("allergy");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergies page open successfully</b>", "PASS", "<b>Allergies page should be open</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Allergies page not open successfully</b>", "FAIL", "<b>Allergies page should be open</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the add Allergies button</b>", "FAIL",
					"<b>Allergies page should be open</b>");
		}
	}

	public void addAllergyFromAllergyPage() {
		WebElement element;
		try {
			navigateToAllergiesPage();
			element = Locators.getInstance().addAllergyFromAllergyPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Allergy Button</b> click successfully", "PASS",
						"<b> Add Allergy Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Allergy Button</b> not click successfully", "FAIL",
						"<b> Add Allergy Button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Allergy Button</b>", "FAIL",
					"<b> Add Allergy Button</b> should be click");
		}
	}

	public String addedAllergyName(String allergyName) {
		List<WebElement> allergyList;
		String addedAllergy = "";
		try {
			allergyList = Locators.getInstance().allergyList(driver);
			for (WebElement element : allergyList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyName)) {
					addedAllergy = allergyName;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergy;
	}

	public String addedAllergyType(String allergyType) {
		List<WebElement> allergyTypeList;
		String addedAllergyType = "";
		try {
			Keywords.waitForPage(driver);
			allergyTypeList = Locators.getInstance().allergyTypeList(driver);
			for (WebElement element : allergyTypeList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyType)) {
					addedAllergyType = allergyType;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyType;
	}

	public String addedAllergyStatus(String allergyStatus) {
		List<WebElement> allergyStatusList;
		String addedAllergyStatus = "";
		try {
			Keywords.waitForPage(driver);
			allergyStatusList = Locators.getInstance().allergyStatusList(driver);
			for (WebElement element : allergyStatusList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyStatus)) {
					addedAllergyStatus = allergyStatus;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyStatus;
	}

	public String addedAllergySeverity(String allergySeverity) {
		List<WebElement> allergySeverityList;
		String addedAllergySeverity = "";
		try {
			Keywords.waitForPage(driver);
			allergySeverityList = Locators.getInstance().allergySeverityList(driver);
			for (WebElement element : allergySeverityList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergySeverity)) {
					addedAllergySeverity = allergySeverity;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergySeverity;
	}

	public String addedAllergyReaction(String allergyReaction) {
		List<WebElement> allergyReactionList;
		String addedAllergyReaction = "";
		try {
			Keywords.waitForPage(driver);
			allergyReactionList = Locators.getInstance().allergyReactionList(driver);
			for (WebElement element : allergyReactionList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyReaction)) {
					addedAllergyReaction = allergyReaction;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyReaction;
	}

	public String addedAllergyOnSetDate(String allergyOnSetDate) {
		List<WebElement> allergyOnSetDateList;
		String addedAllergyOnSetDate = "";
		try {
			Keywords.waitForPage(driver);
			allergyOnSetDateList = Locators.getInstance().allergyList(driver);
			for (WebElement element : allergyOnSetDateList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyOnSetDate)) {
					addedAllergyOnSetDate = allergyOnSetDate;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyOnSetDate;
	}

	public String addedAllergyLastEpisodeDate(String allergyLastEpisode) {
		List<WebElement> allergyList;
		String addedAllergyLastEpisode = "";
		try {
			Keywords.waitForPage(driver);
			allergyList = Locators.getInstance().allergyList(driver);
			for (WebElement element : allergyList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyLastEpisode)) {
					addedAllergyLastEpisode = allergyLastEpisode;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyLastEpisode;
	}

	public String addedAllergyTreatment(String allergyTreatment) {
		List<WebElement> allergyTreatmentList;
		String addedAllergyTreatment = "";
		try {
			Keywords.waitForPage(driver);
			allergyTreatmentList = Locators.getInstance().allergyList(driver);
			for (WebElement element : allergyTreatmentList) {
				if (Keywords.getText(element).equalsIgnoreCase(allergyTreatment)) {
					addedAllergyTreatment = allergyTreatment;
					break;
				}
			}
		} catch (Exception e) {
		}

		return addedAllergyTreatment;
	}

	public List<String> getAllergiesList() {
		List<WebElement> allergyElement;
		List<String> allergiesList = new ArrayList<>();
		try {
			if (Locators.getInstance().allergyList(driver).size() >= 1) {
				allergyElement = Locators.getInstance().allergyList(driver);
				for (WebElement element : allergyElement)
					allergiesList.add(Keywords.getText(element));
			} else
				allergiesList.add("Based on your filters, data is not available.");
		} catch (Exception e) {
		}

		return allergiesList;
	}

	public boolean noAllergyFound() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().noAllergyBasedOnFilter(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public String selectAllergyFromList(String allergyName) {
		String selectedAllergyName = "";
		List<WebElement> allergyElement;
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergyList(driver);
			for (WebElement element : allergyElement)
				if (Keywords.getText(element).equalsIgnoreCase(allergyName)) {
					Keywords.click(element);
					break;
				}
		} catch (Exception e) {
		}

		return selectedAllergyName;
	}

	public String getAllergyTypeBasedOnAllergy(String allergyName) {
		String allergyname = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyTypeBasedOnAllergy(driver, allergyName);
			allergyname = Keywords.getText(element).trim();
		} catch (Exception e) {
		}
		return allergyname;
	}

	public String getAllergyName(String allergyName) {
		String allergyname = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getAllergyName(allergyname, driver);
			allergyname = Keywords.getText(element).trim();
		} catch (Exception e) {
		}
		return allergyname;
	}

	public List<String> getAllergiesTypeList() {
		List<WebElement> allergyElement;
		List<String> allergiesTypeList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergyTypeList(driver);
			for (WebElement element : allergyElement)
				allergiesTypeList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesTypeList;
	}

	public LinkedHashSet<String> getAllergiesUniqueTypeList() {
		List<WebElement> allergyElement;
		LinkedHashSet<String> allergiesTypeList = new LinkedHashSet<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergyTypeList(driver);
			for (WebElement element : allergyElement)
				allergiesTypeList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesTypeList;
	}

	public List<String> getAllergiesStatusList() {
		List<WebElement> allergyElement;
		List<String> allergiesStatusList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergyStatusList(driver);
			for (WebElement element : allergyElement)
				allergiesStatusList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesStatusList;
	}

	public String getAllergyStatusBasedOnAllergy(String allergyName) {
		String allergyStatus = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyStatusBasedOnAllergy(driver, allergyName);
			allergyStatus = Keywords.getText(element).trim();
		} catch (Exception e) {
		}
		return allergyStatus;
	}

	public LinkedHashSet<String> getAllergiesUniqueStatusList() {
		List<WebElement> allergyElement;
		LinkedHashSet<String> allergiesStatusList = new LinkedHashSet<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergyStatusList(driver);
			for (WebElement element : allergyElement)
				allergiesStatusList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesStatusList;
	}

	public List<String> getAllergiesSeverityList() {
		List<WebElement> allergyElement;
		List<String> allergiesSeverityList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergySeverityList(driver);
			for (WebElement element : allergyElement)
				allergiesSeverityList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesSeverityList;
	}

	public String getAllergySeverityBasedOnAllergy(String allergyName) {
		String allergyname = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergySeverityBasedOnAllergy(driver, allergyName);
			allergyname = Keywords.getText(element).trim();
		} catch (Exception e) {
		}
		return allergyname;
	}

	public LinkedHashSet<String> getAllergiesUniqueSeverityList() {
		List<WebElement> allergyElement;
		LinkedHashSet<String> allergiesSeverityList = new LinkedHashSet<>();
		try {
			Keywords.waitForPage(driver);
			allergyElement = Locators.getInstance().allergySeverityList(driver);
			for (WebElement element : allergyElement)
				allergiesSeverityList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return allergiesSeverityList;
	}

	public String getAllergyReactionBasedOnAllergy(String allergyName) {
		String allergyReaction = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyReactionBasedOnAllergy(driver, allergyName);
			allergyReaction = Keywords.getText(element).trim();
		} catch (Exception e) {
		}

		return allergyReaction;
	}

	public String getAllergyOnSetBasedOnAllergy(String allergyName) {
		String allergyOnSetDate = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyOnSetDateBasedOnAllergy(driver, allergyName);
			allergyOnSetDate = Keywords.getText(element).trim();
		} catch (Exception e) {
		}

		return allergyOnSetDate;
	}

	public String getAllergyLastEpisodeBasedOnAllergy(String allergyName) {
		String allergyLastEpisode = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyLastEpisodeDateBasedOnAllergy(driver, allergyName);
			allergyLastEpisode = Keywords.getText(element).trim();
		} catch (Exception e) {
		}

		return allergyLastEpisode;
	}

	public String getAllergyTreatmentBasedOnAllergy(String allergyName) {
		String allergyTreatment = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().allergyTreatmentBasedOnAllergy(driver, allergyName);
			allergyTreatment = Keywords.getText(element).trim();
		} catch (Exception e) {
		}

		return allergyTreatment;
	}
}
