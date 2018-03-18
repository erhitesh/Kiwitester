package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.python.antlr.ast.keyword;
import org.sikuli.script.Screen;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class MyDoctors {

	static Screen screen = new Screen();

	private WebDriver driver;

	public MyDoctors(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToMyDoctorPage() {
		try {
			Dashboard dashboard = new Dashboard(driver);
			dashboard.selectDashboardLeftMenu("My Doctors");
		} catch (Exception e) {
		}
	}

	public void clickViewMyDoctorLinkedTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().viewMyDoctorLinkedText(driver);
			Keywords.fluentWaitWithPolling(driver, element);
			Keywords.click(element);
			Keywords.waitForPageFullyLoaded(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View My Doctor click successfully</b>", "PASS", "<b>View My Doctor should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View My Doctor not click successfully</b>", "FAIL",
						"<b>View My Doctor should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>View My Doctor linked text</b>", "FAIL",
					"<b>View My Doctor should be clicked</b>");
		}
	}

	public String getDoctorMiddleName(String doctorName) {
		String middleName = "";
		try {
			if (doctorName.contains(" ")) {
				middleName = doctorName.substring(doctorName.indexOf(" ") + 1, doctorName.length());
				if (middleName.contains(" "))
					middleName = middleName.substring(0, middleName.indexOf(" "));
			}
		} catch (Exception e) {
		}
		return middleName;
	}

	public void clickFindADoctorLinkedTxt() {
		WebElement element;
		try {
			Thread.sleep(3000);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().findADoctorLinkedText(driver);
			Keywords.click(element);
			Thread.sleep(3000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Find A Doctor click successfully</b>", "PASS", "<b>Find A Doctor should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Find A Doctor not click successfully</b>", "FAIL",
						"<b>Find A Doctor should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Find A Doctor linked text</b>", "FAIL",
					"<b>Find A Doctor should be clicked</b>");
		}
	}

	// >>>>>> Doctor registration >>>>>>>>>.
	public boolean verifyAddDoctorPopHeader() {
		WebElement element;
		boolean status = false;
		try {
			// Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().addADoctorPopUpHeader(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void clickOnAddDoctorHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().addADoctorPopUpHeader(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public boolean addDoctorBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().addDoctorBtn(driver);
			status = Keywords.isElementPresent(element);
			if (!status) {
				Thread.sleep(3000);
				element = Locators.getInstance().addDoctorBtn(driver);
				status = Keywords.isElementPresent(element);
			}
		} catch (Exception e) {
		}
		return status;
	}

	public void clickOnAddDoctorBtn() {
		WebElement element;
		try {
			Keywords.explicitWait(7);
			element = Locators.getInstance().addDoctorBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			element = Locators.getInstance().addADoctorPopUpHeader(driver);
			if (verifyAddDoctorPopHeader())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor button click successfully</b>", "PASS",
						"<b>Add Doctor button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor button not click successfully</b>", "FAIL",
						"<b>Add Doctor button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Doctor button</b>", "FAIL",
					"<b>Add Doctor button should be clicked</b>");
		}
	}

	public String enterDoctorFirstName() {
		WebElement element;
		String doctorFirstName = DriverSession.getTestCaseData().get("DoctorFirstName");
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForObject(Locators.getInstance().doctorFirstName(driver), 10);
			element = Locators.getInstance().doctorFirstName(driver);
			doctorFirstName = doctorFirstName + Keywords.getRandomString() + "tester";// Keywords.getRandomNumber(10);
			Keywords.typeText(element, doctorFirstName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor First Name enter successfully</b>", "PASS",
						"<b>Doctor First Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor First Name not enter successfully</b>", "FAIL",
						"<b>Doctor First Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor First Name</b>", "FAIL",
					"<b>Doctor First Name should be entered</b>");
		}

		return doctorFirstName;
	}

	public void enterDoctorFirstName(String doctorFName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorFirstName(driver);
			Keywords.click(element);
			Keywords.typeText(element, doctorFName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor First Name enter successfully</b>", "PASS",
						"<b>Doctor First Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor First Name not enter successfully</b>", "FAIL",
						"<b>Doctor First Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor First Name</b>", "FAIL",
					"<b>Doctor First Name should be entered</b>");
		}
	}

	public void enterDoctorLastName(String doctorLastLName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorLastName(driver);
			Keywords.click(element);
			Keywords.typeText(element, doctorLastLName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Last Name enter successfully</b>", "PASS",
						"<b>Doctor Last Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Last Name not enter successfully</b>", "FAIL",
						"<b>Doctor Last Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Last Name</b>", "FAIL",
					"<b>Doctor Last Name should be entered</b>");
		}
	}

	public String enterDoctorPhoneNumber(String doctorPhoneNumber) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorPhoneNumber(driver);
			// Keywords.typeText(element, doctorPhoneNumber);
			new Actions(driver).moveToElement(element).doubleClick().perform();
			Keywords.typeText(element, doctorPhoneNumber);
			Keywords.click(element);
			element = Locators.getInstance().doctorAddressLine1(driver);
			element.sendKeys(Keys.TAB);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Phone Number enter successfully</b>", "PASS",
						"<b>Doctor Phone Number should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Phone Number not enter successfully</b>", "FAIL",
						"<b>Doctor Phone Number should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Phone Number</b>", "FAIL",
					"<b>Doctor Phone Number should be entered</b>");
		}

		return doctorPhoneNumber;
	}

	public String enterDoctorZipCode(String doctorZipCode) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorZipCode(driver);
			Keywords.typeText(element, doctorZipCode);
			Keywords.typeTextWithoutClear(element, Keys.TAB);
			// new
			// Actions(driver).moveToElement(element).doubleClick().perform();
			// Keywords.typeText(element, doctorZipCode);
			// Keywords.click(element);
			// element = Locators.getInstance().doctorAddressLine1(driver);
			// element.sendKeys(Keys.TAB);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor ZipCode enter successfully</b>", "PASS", "<b>Doctor ZipCode should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor ZipCode not enter successfully</b>", "FAIL",
						"<b>Doctor ZipCode should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor ZipCode</b>", "FAIL",
					"<b>Doctor ZipCode should be entered</b>");
		}

		return doctorZipCode;
	}

	public String enterDoctorCityName(String cityName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorCityName(driver);
			Keywords.typeText(element, cityName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor City Name enter successfully</b>", "PASS",
						"<b>Doctor City Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor City Name not enter successfully</b>", "FAIL",
						"<b>Doctor City Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor City Name</b>", "FAIL",
					"<b>Doctor City Name should be entered</b>");
		}

		return cityName;
	}

	public String enterDoctorLastName() {
		WebElement element;
		String doctorLastName = DriverSession.getTestCaseData().get("DoctorLastName");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorLastName(driver);
			Keywords.typeText(element, doctorLastName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Last Name enter successfully</b>", "PASS",
						"<b>Doctor Last Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Last Name not enter successfully</b>", "FAIL",
						"<b>Doctor Last Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Last Name</b>", "FAIL",
					"<b>Doctor Last Name should be entered</b>");
		}

		return doctorLastName;
	}

	public String selectDoctorSpeciality() {
		WebElement element;
		List<WebElement> specialtyList;
		int randomNumber = 0;
		String doctorSpecialtyList = "";
		try {
			Keywords.waitForObject(Locators.getInstance().enableDoctorSpeciality(driver), 3);
			element = Locators.getInstance().enableDoctorSpeciality(driver);
			Keywords.click(element);
			specialtyList = Locators.getInstance().selectDoctorSpecialty(driver, "Popular");
			randomNumber = Keywords.getRandomInteger(specialtyList.size() - 1);
			doctorSpecialtyList = specialtyList.get(randomNumber).getText();
			Keywords.clickByIndex(specialtyList, randomNumber);
			// specialtyList =
			// Locators.getInstance().selectDoctorSpecialty(driver, "All");
			// randomNumber = Keywords.getRandomInteger(specialtyList.size()
			// -1);
			// doctorSpecialtyList = doctorSpecialtyList +
			// specialtyList.get(randomNumber).getText();
			// Keywords.clickByIndex(specialtyList, randomNumber);
			// element = Locators.getInstance().addADoctorPopUpHeader(driver);
			element = Locators.getInstance().closeDoctorSpecialityDropdown(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor speciality select successfully</b>", "PASS",
						"<b>Doctor speciality should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctorspeciality not selected successfully</b>", "FAIL",
						"<b>Doctor speciality should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Doctor speciality</b>", "FAIL",
					"<b>Doctor speciality should be selected</b>");
		}
		return doctorSpecialtyList;
	}

	public String enterPracticeName() {
		WebElement element;
		String doctorPracticeName = DriverSession.getTestCaseData().get("PracticeName");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorPracticeName(driver);
			Keywords.typeText(element, doctorPracticeName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Practice Name enter successfully</b>", "PASS",
						"<b>Doctor Practice Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Practice Name not enter successfully</b>", "FAIL",
						"<b>Doctor Practice Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Practice Name</b>", "FAIL",
					"<b>Doctor Practice Name should be entered</b>");
		}

		return doctorPracticeName;
	}

	public String enterDoctorPhoneNumber() {
		WebElement element;
		String doctorPhoneNumber = DriverSession.getTestCaseData().get("PhoneNumber");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorPhoneNumber(driver);
			Keywords.typeText(element, doctorPhoneNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Phone Number enter successfully</b>", "PASS",
						"<b>Doctor Phone Number should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Phone Number not enter successfully</b>", "FAIL",
						"<b>Doctor Phone Number should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Phone Number</b>", "FAIL",
					"<b>Doctor Phone Number should be entered</b>");
		}

		return doctorPhoneNumber;
	}

	public String randomCityName() {
		List<String> list = new ArrayList<>();
		list.add("New York");
		list.add("Denver");
		list.add("Los Angeles");
		list.add("Boston");
		list.add("Austin");

		return list.get(Keywords.getRandomInteger(list.size() - 1));
	}

	public String getZipCode(String cityName) {
		HashMap<String, String> mapList = new LinkedHashMap<>();
		mapList.put("New York", "10017");
		mapList.put("Denver", "80014");
		mapList.put("Los Angeles", "90001");
		mapList.put("Boston", "01841");
		mapList.put("Austin", "73301");

		return mapList.get(cityName);
	}

	public HashMap<String, String> getCountryAddressLine1() {
		HashMap<String, String> mapCountry = new HashMap<>();
		mapCountry.put("New York", "170 William St");
		mapCountry.put("Denver", "412 Mustang Dr");
		mapCountry.put("Los Angeles", "4650 Sunset Blvd");
		mapCountry.put("Boston", "818 Harrison Ave");
		mapCountry.put("Austin", "601 E 15th St");

		return mapCountry;
	}

	public HashMap<String, String> getCountryAddressLine2() {
		HashMap<String, String> mapCountry = new HashMap<>();
		mapCountry.put("New York", "New York USA");
		mapCountry.put("Denver", "Denver USA");
		mapCountry.put("Los Angeles", "Los Angeles USA");
		mapCountry.put("Boston", "Boston USA");
		mapCountry.put("Austin", "Austin USA");

		return mapCountry;
	}

	public String enterDoctorAddressLine1(String addressLine1) {
		WebElement element;
		String doctorAddressLine1 = getCountryAddressLine1().get(addressLine1);// DriverSession.getTestCaseData().get("AddressLine1");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorAddressLine1(driver);
			Keywords.typeText(element, doctorAddressLine1);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Address Line 1 enter successfully</b>", "PASS",
						"<b>Doctor Address Line 1 should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Address Line 1 not enter successfully</b>", "FAIL",
						"<b>Doctor Address Line 1 should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Address Line 1</b>", "FAIL",
					"<b>Doctor Address Line 1 should be entered</b>");
		}

		return doctorAddressLine1;
	}

	public String enterDoctorAddressLine2(String addressLine2) {
		WebElement element;
		String doctorAddressLine2 = getCountryAddressLine2().get(addressLine2);// DriverSession.getTestCaseData().get("AddressLine2");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorAddressLine2(driver);
			Keywords.typeText(element, doctorAddressLine2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Address Line 2 enter successfully</b>", "PASS",
						"<b>Doctor Address Line 2 should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Address Line 2 not enter successfully</b>", "FAIL",
						"<b>Doctor Address Line 2 should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Address Line 2</b>", "FAIL",
					"<b>Doctor Address Line 2 should be entered</b>");
		}

		return doctorAddressLine2;
	}

	public String enterDoctorCityName() {
		WebElement element;
		String doctorCityName = "";
		try {
			Keywords.waitForPage(driver);
			doctorCityName = "New York";// randomCityName();
			element = Locators.getInstance().doctorCityName(driver);
			Keywords.typeText(element, doctorCityName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor City Name enter successfully</b>", "PASS",
						"<b>Doctor City Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor City Name not enter successfully</b>", "FAIL",
						"<b>Doctor City Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor City Name</b>", "FAIL",
					"<b>Doctor City Name should be entered</b>");
		}

		return doctorCityName;
	}

	public String enterDoctorState() {
		WebElement element;
		List<WebElement> statesList;
		String doctorStateName = "";
		// int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableStateDropdownList(driver);
			Keywords.click(element);
			Keywords.waitForPageFullyLoaded(driver);
			statesList = Locators.getInstance().doctorStateName(driver);
			/*
			 * randomNumber = Keywords.getRandomInteger(statesList.size() - 1);
			 * doctorStateName = Keywords.getTextByIndex(statesList,
			 * randomNumber); Keywords.clickByIndex(statesList, randomNumber);
			 */
			for (int i = 0; i < statesList.size(); i++) {
				if (Keywords.getText(statesList.get(i)).trim().equalsIgnoreCase("New York")) {
					Keywords.click(statesList.get(i));
					break;
				}
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor State Name enter successfully</b>", "PASS",
						"<b>Doctor State Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor State Name not enter successfully</b>", "FAIL",
						"<b>Doctor State Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor State Name</b>", "FAIL",
					"<b>Doctor State Name should be entered</b>");
		}

		return doctorStateName;
	}

	public String updateDoctorState() {
		WebElement element;
		List<WebElement> statesList;
		String doctorStateName = "";
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().reOpenDoctorState(driver);
			Keywords.click(element);
			statesList = Locators.getInstance().doctorStateName(driver);
			randomNumber = Keywords.getRandomInteger(statesList.size() - 1);
			doctorStateName = Keywords.getTextByIndex(statesList, randomNumber);
			Keywords.clickByIndex(statesList, randomNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor State Name enter successfully</b>", "PASS",
						"<b>Doctor State Name should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor State Name not enter successfully</b>", "FAIL",
						"<b>Doctor State Name should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor State Name</b>", "FAIL",
					"<b>Doctor State Name should be entered</b>");
		}

		return doctorStateName;
	}

	public String enterZipCode(String cityName) {
		WebElement element;
		String doctorZipCode = "";
		try {
			doctorZipCode = getZipCode(cityName);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorZipCode(driver);
			Keywords.typeText(element, doctorZipCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Zip Code enter successfully</b>", "PASS",
						"<b>Doctor Zip Code should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Zip Code not enter successfully</b>", "FAIL",
						"<b>Doctor Zip Code should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Zip Code</b>", "FAIL",
					"<b>Doctor Zip Code should be entered</b>");
		}

		return doctorZipCode;
	}

	public String enterZipCodeForSearchDoctor(String zipCode) {
		WebElement element;
		String doctorZipCode = zipCode;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorZipCode(driver);
			Keywords.typeText(element, doctorZipCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Zip Code enter successfully</b>", "PASS",
						"<b>Doctor Zip Code should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Zip Code not enter successfully</b>", "FAIL",
						"<b>Doctor Zip Code should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Doctor Zip Code</b>", "FAIL",
					"<b>Doctor Zip Code should be entered</b>");
		}

		return doctorZipCode;
	}

	public boolean isThisAHospitalCheckBoxStatus() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().isThisAHospital(driver);
			status = Keywords.getAttributeVal(element, "class").contains("ng-empty");
		} catch (Exception e) {
		}

		return status;
	}

	public boolean isThisPrimaryLocationCheckBoxStatus() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().isThisPrimaryLocation(driver);
			status = Keywords.getAttributeVal(element, "class").contains("ng-empty");
		} catch (Exception e) {
		}

		return status;
	}

	public void checkIsThisAHospitalCheckBox(boolean checkUncheck) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().hospitalCheckBox(driver);
			if (checkUncheck == true) {
				if (isThisAHospitalCheckBoxStatus()) {
					Keywords.click(element);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Is This A Hospital Checkbox check successfully</b>", "PASS",
							"<b>Is This A Hospital Checkbox should be checked</b>");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Is This A Hospital Checkbox already check</b>", "PASS",
							"<b>Is This A Hospital Checkbox should be checked</b>");
				}
			} else {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Is This A Hospital Checkbox uncheck successfully</b>", "PASS",
						"<b>Is This A Hospital Checkbox should be uncheck</b>");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the checkbox value <b>Is This A Hospital</b>", "FAIL",
					"<b>Is This A Hospital Checkbox should be checked/Unchecked</b>");
		}
	}

	public void checkIsThisPrimaryLocationCheckBox(boolean checkUncheck) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().primaryLocationCheckBox(driver);
			if (checkUncheck == true) {
				if (isThisPrimaryLocationCheckBoxStatus()) {
					Keywords.click(element);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Is This Primary Location Checkbox checked successfully</b>", "PASS",
							"<b>Is This A Primary Location Checkbox should be checked</b>");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Is This A Primary Location Checkbox already checked</b>", "PASS",
							"<b>Is This A Primary Location Checkbox should be checked</b>");
				}
			} else {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Is This A Primary Location Checkbox uncheck successfully</b>", "FAIL",
						"<b>Is This A Primary Location Checkbox should be uncheck</b>");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the checkbox value <b>Is This Primary Location</b>", "FAIL",
					"<b>Is This A Primary Location Checkbox should be checked/Unchecked</b>");
		}
	}

	public boolean ErrorMessageForInvalidAddress() {
		WebElement element;
		boolean status = false;
		try {
			element = Locators.getInstance().errorMessageForInvalidAddress(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean submitDoctorFormButtonStatus() {
		WebElement element;
		boolean status = false;
		try {
			element = Locators.getInstance().submitDoctorForm(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void submitRegistrationForm() {
		WebElement element;
		try {
			element = Locators.getInstance().submitDoctorForm(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor Form submit successfully</b>", "PASS",
						"<b>Add Doctor Form should be submit</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor Form not submit successfully</b>", "FAIL",
						"<b>Add Doctor Form should be submit</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Add Doctor Form</b>", "FAIL",
					"<b>Add Doctor Form should be submit</b>");
		}
	}

	public void submitDoctorRegistrationForValidation() {
		WebElement element;
		try {
			element = Locators.getInstance().submitDoctorForm(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor submit btn click successfully</b>", "PASS",
						"<b>Add Doctor Btn should be click</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor submit btn click successfully</b>", "FAIL",
						"<b>Add Doctor Btn should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Add Doctor Btn</b>", "FAIL",
					"<b>Add Doctor Btn should be click</b>");
		}
	}

	public void submitDoctorRegistrationForm() {
		WebElement element;
		try {
			element = Locators.getInstance().submitDoctorForm(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 15);
			// if (submitDoctorFormButtonStatus()) {
			// element = Locators.getInstance().submitDoctorForm(driver);
			// Keywords.click(element);
			// }
			// if (submitDoctorFormButtonStatus()) {
			// Keywords.doubleClick(driver, element);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			// }
			// errElement =
			// Locators.getInstance().errorMessageForInvalidAddress(driver);
			// while (Keywords.isElementPresent(errElement)) {
			// Keywords.waitForPageFullyLoaded(driver);
			// updateDoctorState();
			// Keywords.click(element);}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor Form submit successfully</b>", "PASS",
						"<b>Add Doctor Form should be submit</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Doctor Form not submit successfully</b>", "FAIL",
						"<b>Add Doctor Form should be submit</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Add Doctor Form</b>", "FAIL",
					"<b>Add Doctor Form should be submit</b>");
		}
	}

	public void closeDoctorRegistrationForm() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().closeDoctorRegistrationFormPopUp(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Registration Form close successfully</b>", "PASS",
						"<b>Doctor Registration Form should be closed</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Registration Form not close successfully</b>", "FAIL",
						"<b>Doctor Registration Form should be closed</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Doctor Registration Form</b>", "FAIL",
					"<b>Doctor Registration Form should be closed</b>");
		}
	}

	public void verifyErrorMessageForBlankFirstName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForFirstName(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for doctor first name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for doctor first name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for doctor first name</b>");
		}
	}

	public void verifyErrorMessageForBlankLastName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForLastName(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for doctor Last Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for doctor Last Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for doctor Last Name</b>");
		}
	}

	public void verifyErrorMessageForBlankSpeciality() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForSpecialityName(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor Speciality</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor Speciality</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor Speciality</b>");
		}
	}

	public void verifyErrorMessageForBlankPracticeName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForPracticeName(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor Practice Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor Practice Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor Practice Name</b>");
		}
	}

	public void verifyErrorMessageForBlankPhoneNumber() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForPhoneNumber(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor Phone Number</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor Phone Number</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor Phone Number</b>");
		}
	}

	public void verifyErrorMessageForBlankAddressLine1() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForAddress1(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor Address Line1</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor Address Line1</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor Address Line1</b>");
		}
	}

	public void verifyErrorMessageForBlankCityName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForCity(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor City Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor City Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor City Name</b>");
		}
	}

	public void verifyErrorMessageForBlankState() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForState(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor State Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor State Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor State Name</b>");
		}
	}

	public void verifyErrorMessageForBlankZipCode() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForZipCode(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("ErrorMessageForBlankField")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor ZipCode</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> This is required.</b> text not visible successfully.", "FAIL",
						"<b>Error Message should be visible for Doctor ZipCode</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> This is required.</b>", "FAIL",
					"<b>Error Message should be visible for Doctor ZipCode</b>");
		}
	}

	public void verifyErrorMessageForInvalidDataForFirstName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().invalidDataForDoctorFNameErrorMessage(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForFName")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> First Name can only be letters, dash and spaces.</b> text visible successfully.",
						"PASS", "<b>Error Message should be visible for Doctor First Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> First Name can only be letters, dash and spaces.</b> text not visible successfully.",
						"FAIL", "<b>Error Message should be visible for Doctor First Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> First Name can only be letters, dash and spaces.</b>",
					"FAIL", "<b>Error Message should be visible for Doctor First Name</b>");
		}
	}

	public void verifyErrorMessageForInvalidDataForLastName() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().invalidDataForDoctorLNameErrorMessage(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForLName")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Last Name can only be letters, dash and spaces.</b> text visible successfully.",
						"PASS", "<b>Error Message should be visible for Doctor Last Name</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Last Name can only be letters, dash and spaces.</b> text not visible successfully.",
						"FAIL", "<b>Error Message should be visible for Doctor Last Name</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> Last Name can only be letters, dash and spaces.</b>",
					"FAIL", "<b>Error Message should be visible for Doctor Last Name</b>");
		}
	}

	public void verifyErrorMessageForInvalidDataForPhoneNumber() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().invalidPhoneNumberErrorMessage(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForPhoneNumber")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Phone number should contain exactly 10 digits.</b> text visible successfully.",
						"PASS", "<b>Error Message should be visible for Doctor Phone Number</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Phone number should contain exactly 10 digits.</b> text not visible successfully.",
						"BUG", "<b>Error Message should be visible for Doctor Phone Number</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> Phone number should contain exactly 10 digits.</b>",
					"FAIL", "<b>Error Message should be visible for Doctor Phone Number</b>");
		}
	}

	public void verifyErrorMessageForInvalidDataForCity() {
		WebElement element;
		String message = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().invalidCityErrorMessage(driver);
			message = Keywords.getText(element);
			if (message.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForCity")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> City should accept only characters.</b> text visible successfully.", "PASS",
						"<b>Error Message should be visible for Doctor City</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> City should accept only characters.</b> text not visible successfully.",
						"FAIL", "<b>Error Message should be visible for Doctor City</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> City should accept only characters.</b>",
					"FAIL", "<b>Error Message should be visible for Doctor City</b>");
		}
	}

	public String getZipCodeErrorMessageForDigit() {
		String msg = "";
		WebElement element;
		try {
			element = Locators.getInstance().invalidZipCodeErrorMessageForOnlyForDigit(driver);
			msg = Keywords.getText(element);
		} catch (Exception e) {
		}

		return msg;
	}

	public String getZipCodeErrorMessageForExactFiveDigit() {
		String msg = "";
		WebElement element;
		try {
			element = Locators.getInstance().invalidZipCodeErrorMessageForExactFiveDigit(driver);
			msg = Keywords.getText(element);
		} catch (Exception e) {
		}

		return msg;
	}

	public void verifyErrorMessageForInvalidDataForZipCode() {
		try {
			Keywords.waitForPage(driver);
			if (getZipCodeErrorMessageForExactFiveDigit()
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForDoctorZipCodeForExactDigit"))
					|| getZipCodeErrorMessageForDigit()
							.equalsIgnoreCase(DriverSession.getTestCaseData().get("InvalidDataForDoctorZipCode")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Zip must be of exactly 5 digits./Only Digits</b> text visible successfully.",
						"PASS", "<b>Error Message should be visible for Doctor Zip Code</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Error Message<b> Zip must be of exactly 5 digits./Only Digits</b> text not visible successfully.",
						"FAIL", "<b>Error Message should be visible for Doctor Zip Code</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Error Message<b> Zip must be of exactly 5 digits.</b>",
					"FAIL", "<b>Error Message should be visible for Doctor Phone Number</b>");
		}
	}

	public List<String> getDoctorList() {
		List<WebElement> list;
		List<String> doctorList = new ArrayList<>();
		try {
			list = Locators.getInstance().doctorList(driver);
			for (int i = 0; i < list.size(); i++)
				doctorList.add(Keywords.getText(list.get(i)));
		} catch (Exception e) {}

		return doctorList;
	}

	public List<String> getDoctorListWithMiddleName() {
		List<WebElement> list;
		List<String> doctorList = new ArrayList<>();
		try {
			list = Locators.getInstance().doctorList(driver);
			for (int i = 0; i < list.size(); i++)
				doctorList.add(getDoctorMiddleName(Keywords.getText(list.get(i))));
		} catch (Exception e) {}

		return doctorList;
	}

	public List<String> getDoctorSpecialityList() {
		List<String> doctorSpecialityList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().doctorSpecialityList(driver);
			for (int i = 0; i < list.size(); i++) {
				Thread.sleep(2000);
				doctorSpecialityList.add(Keywords.getText(list.get(i)));
			}
		} catch (Exception e) {
		}

		return doctorSpecialityList;
	}

	public List<String> getDoctorMilesList() {
		List<String> doctorMilesList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().doctorMilesList(driver);
			for (int i = 0; i < list.size(); i++) {
				Thread.sleep(2000);
				doctorMilesList.add(Keywords.getText(list.get(i)));
			}
		} catch (Exception e) {
		}

		return doctorMilesList;
	}

	// >>>>>>>> Find doctor based on the searching input values >>>>
	public HashMap<String, String> parameterDataForFindDoctor() {
		HashMap<String, String> info = new HashMap<>();
		info.put("Speciality", getSpecialityListFromFindADoctor().get(Keywords.getRandomInteger(getSpecialityListFromFindADoctor().size()-1)));
		info.put("Miles", "20 Miles");
		info.put("ZipCode", "10017");
		return info;
	}
	
	public List<String> getSpecialityListFromFindADoctor() {
		List<String> speciality = new ArrayList<>();
		WebElement element;
		List<WebElement> specialityElementList;
		try {
			element = Locators.getInstance().enableFindDoctorSpeciality(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
			specialityElementList  = Locators.getInstance().selectDoctorSpecialityFromList(driver);
			for (WebElement webElement : specialityElementList)
				speciality.add(Keywords.getText(webElement));
			hideDoctorSpecialityList();
		}catch(Exception e) {}
		return speciality;
	}
	
	public void hideDoctorSpecialityList() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().hideSpecialityListFromFindDoctor(driver), 10);
			element = Locators.getInstance().hideSpecialityListFromFindDoctor(driver);
			Keywords.click(element);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectSpeciality(String specialityName) {
		WebElement element;
		List<WebElement> specialityList;
		String doctorSpecialityName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableFindDoctorSpeciality(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			specialityList = Locators.getInstance().selectDoctorSpecialityFromList(driver);
			for (WebElement ele : specialityList) {
				if (Keywords.getText(ele).equalsIgnoreCase(specialityName)) {
					Keywords.click(ele);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Doctor Speciality select successfully</b>", "PASS",
							"<b>Doctor Speciality should be selected</b>");
					hideDoctorSpecialityList();
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Doctor Speciality</b>", "FAIL",
					"<b>Doctor Speciality should be selected</b>");
		}

		return doctorSpecialityName;
	}

	public String selectMiles(String milesType) {
		WebElement element;
		List<WebElement> milesList;
		String milesValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableSelectMiles(driver);
			Keywords.click(element);
			milesList = Locators.getInstance().selectMiles(driver);
			for (int i = 0; i < milesList.size(); i++) {
				if (Keywords.getText(milesList.get(i)).contains(milesType)) {
					Keywords.click(milesList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Miles value select successfully</b>", "PASS", "<b>Miles value should be selected</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting Miles value</b>", "FAIL",
					"<b>Miles value should be selected</b>");
		}
		return milesValue;
	}

	public String updateSelectMiles(String milesType) {
		WebElement element;
		List<WebElement> milesList;
		String milesValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().reOpenSelectMiles(driver);
			Keywords.click(element);
			milesList = Locators.getInstance().selectMiles(driver);
			for (int i = 0; i < milesList.size(); i++) {
				if (Keywords.getText(milesList.get(i)).contains(milesType)) {
					Keywords.click(milesList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Miles value select successfully</b>", "PASS", "<b>Miles value should be selected</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting Miles value</b>", "FAIL",
					"<b>Miles value should be selected</b>");
		}
		return milesValue;
	}

	public void clickOnSearchButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().searchButton(driver);
			Keywords.click(element);
			Keywords.explicitWait(3);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search button click sucessfully</b>", "PASS", "<b>Search button should be click</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search button not click sucessfully</b>", "FAIL", "<b>Search button should be click</b>");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Search button</b>", "FAIL",
					"<b>Search button should be click</b>");
		}
	}

	public boolean verifySearchDoctorErrorResult() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().searchResultWithErrorMessage(driver);
			if (Keywords.getText(element).trim().equalsIgnoreCase(
					"Sorry, your search did not return any results. Try to broaden your search for more results."))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public void selectDoctorAndAddToFavoriteVerifyGetMedicalRecordPopup() {
		List<WebElement> unfavoriteDoctorList;
		try {
			unfavoriteDoctorList = Locators.getInstance().unFavoriteDoctorList(driver);
			for (int i = 0; i < unfavoriteDoctorList.size(); i++) {
				Keywords.click(unfavoriteDoctorList.get(i));
				Keywords.explicitWait(1);
				addToFavoriteViaFavBtn();
				if (wantYourMedicalRecordsStatus()) {
					verifyWantYourMedicalRecords();
					hideWantYourMedicalRecordsWindow();
					feedbackSurvey();
					break;
				}else {
					Keywords.backPage();
					Keywords.explicitWait(3);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void navigateBackToSearchPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().navigateToSearchDoctorPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Seach page reopen successfully</b>", "PASS", "<b>Seach page should be again opened</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while reopening the Seach page</b>", "FAIL",
					"<b>Seach page should be again opened</b>");
		}
	}

	public boolean checkUserProfileHeaderStatus(String headerColour) {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().getDoctorProfileHeaderStatus(driver);
			status = (Keywords.getAttributeVal(element, "class").contains(headerColour)) ? true : false;
			if (status)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Profile Header Text Colour View </b>display successfully", "PASS",
						"<b>User Profile Header Text Colour View </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the View <b>Doctor Profile Header status </b>", "FAIL",
					"<b>User Profile Header Text Colour View </b>should be display");
		}

		return status;
	}

	public void selectDrFromFindBySearchResult(String doctorName) {
		int index = 0;
		List<WebElement> doctorElementList;
		try {
			Keywords.explicitWait(2);
			doctorElementList = Locators.getInstance().doctorList(driver);
			index = getDoctorListWithMiddleName().indexOf(getDoctorMiddleName(doctorName));
			Keywords.click(doctorElementList.get(index));
			Keywords.explicitWait(2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> Doctor </b>select successfully from find by search result", "PASS",
						doctorName + "<b> Doctor </b>should be selected from find by search result");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> Doctor </b>not select successfully from find by search result", "FAIL",
						doctorName + "<b> Doctor </b>should be selected from find by search result");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + doctorName + "<b> Doctor </b>from find by search result",
					"FAIL", doctorName + "<b> Doctor </b>should be selected from find by search result");
		}
	}

	public String selectRandomDoctorFromDrList() {
		int randomNumber = 0;
		String doctorName = "";
		String doctorMiddleName = "";
		WebElement element;
		List<WebElement> doctorElementList;
		try {
			doctorElementList = Locators.getInstance().doctorList(driver);
			randomNumber = Keywords.getRandomInteger(doctorElementList.size());
			doctorName = Keywords.getText(doctorElementList.get(randomNumber));
			doctorMiddleName = getDoctorMiddleName(doctorName);
			element = Locators.getInstance().selectProfileBasedOnDoctor(driver, doctorMiddleName);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> Doctor </b>select successfully", "PASS",
						doctorName + "<b> Random Doctor </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> Doctor </b>not select successfully", "FAIL",
						doctorName + "<b> Random Doctor </b>should be selected");
			Keywords.explicitWait(5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the " + doctorName, "FAIL",
					doctorName + "<b> Random Doctor </b>should be selected");
		}

		return doctorMiddleName;
	}

//	public String selectDoctorFromList(String doctorName) {
//		int indexValue = 0;
//		String trimDoctorName = "";
//		String doctorNameFromSearch = "";
//		WebElement element;
//		List<WebElement> profileList;
//		List<WebElement> doctorList;
//		List<String> doctorsList = new ArrayList<>();
//		List<WebElement> doctorHelpList;
//		HashMap<Integer, String> info = new LinkedHashMap<>();
//		try {
//			// First Ways
//			trimDoctorName = doctorName.substring(doctorName.indexOf(" ") + 1, doctorName.indexOf("Doctor") - 1);
//			Keywords.waitForObject(Locators.getInstance().findDoctorSearchBox(driver), 10);
//			element = Locators.getInstance().findDoctorSearchBox(driver);
//			Keywords.typeText(element, trimDoctorName);
//			doctorList = Locators.getInstance().doctorList(driver);
//			profileList = Locators.getInstance().viewDoctorProfileList(driver);
//			for (int i = 0; i < doctorList.size(); i++) {
//				if (Keywords.getText(doctorList.get(i)).equalsIgnoreCase(doctorName)) {
//					Keywords.click(profileList.get(i));
//					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
//					break;
//				}
//			}
//			// Second Ways
//			/*
//			 * Keywords.waitForObject(Locators.getInstance().findDoctorSearchBox
//			 * (driver), 10); element =
//			 * Locators.getInstance().findDoctorSearchBox(driver);
//			 * Keywords.typeText(element, doctorName); Keywords.explicitWait(6);
//			 * doctorHelpList =
//			 * Locators.getInstance().helpSearchResultList(driver); for (int i =
//			 * 0; i < doctorHelpList.size(); i++) {
//			 * System.out.println("Doctor Name.."+Keywords.getText(
//			 * doctorHelpList.get(i))); if
//			 * (Keywords.getText(doctorHelpList.get(i)).contains(
//			 * getDoctorMiddleName(doctorName))) { Keywords.explicitWait(3);
//			 * Keywords.click(doctorHelpList.get(i)); Keywords.explicitWait(3);
//			 * break; } } for (int i = 0; i < doctorHelpList.size(); i++) {
//			 * doctorNameFromSearch = Keywords.getTextByJS(
//			 * "return document.getElementsByClassName('dropdown-menu dropdown-menu-list show')[0].getElementsByClassName('ng-binding')["
//			 * + i + "].innerText;") .trim(); info.put(i, doctorNameFromSearch);
//			 * } doctorsList.addAll(info.values()); for (int i = 0; i <
//			 * doctorsList.size(); i++) { if
//			 * (doctorsList.get(i).contains(getDoctorMiddleName(doctorName))) {
//			 * int j = doctorsList.indexOf(getDoctorMiddleName(doctorName));
//			 * Keywords.explicitWait(2); Keywords.clickByJS(
//			 * "document.getElementsByClassName('dropdown-menu dropdown-menu-list show')[0].getElementsByClassName('ng-binding')["
//			 * + j + "].click();"); }
//			 * 
//			 * }
//			 */
//		} catch (Exception e) {
//			DriverSession.getLastExecutionReportingInstance().teststepreporting(
//					"<b>Exception occurred while selecting Doctor Name</b>", "FAIL",
//					"<b>Doctor Name should be selected</b>");
//		}
//		return doctorName;
//	}

	public String selectDoctorFromList(String doctorName) {
		WebElement element;
		List<WebElement> doctorHelpList;
		try {
			Keywords.waitForObject(Locators.getInstance().findDoctorSearchBox(driver), 10);
			element = Locators.getInstance().findDoctorSearchBox(driver);
			Keywords.typeText(element, doctorName);
			Keywords.explicitWait(6);
			doctorHelpList = Locators.getInstance().helpSearchResultList(driver);
			for (int i = 0; i < doctorHelpList.size(); i++) {
				if (Keywords.getText(doctorHelpList.get(i)).contains(getDoctorMiddleName(doctorName))) {
					Keywords.explicitWait(3);
					Keywords.click(doctorHelpList.get(i));
					Keywords.explicitWait(3);
					break;
				}
			}
			Locators.getInstance().waitForVisibleContactOfficeOnProfile(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name select successfully</b>", "PASS", "<b>Doctor Name should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name not select successfully</b>", "FAIL", "<b>Doctor Name should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting Doctor Name</b>", "FAIL",
					"<b>Doctor Name should be selected</b>");
		}
		return doctorName;
	}

	public String verifyDoctorAddedToFavourite(String doctorName) {
		String doctorname = "";
		List<WebElement> doctorList;
		WebElement elementFavourite;
		WebElement elementPcp;
		int indexValue = 0;
		try {
			Locators.getInstance().waitForDoctorSearchBox(driver);
			doctorList = Locators.getInstance().doctorList(driver);
			for (int i = 0; i < doctorList.size(); i++) {
				if (Keywords.getText(doctorList.get(i)).contains(getDoctorMiddleName(doctorName))) {
					indexValue = i;//doctorList.indexOf(doctorList.get(i));
					doctorname = Keywords.getText(doctorList.get(indexValue));
					elementFavourite = Locators.getInstance().favouriteListOnViewDoctorPage(driver, indexValue);
					elementPcp = Locators.getInstance().PcpListOnViewDoctorPage(driver, indexValue);
					if (Keywords.getAttributeVal(elementFavourite, "class").equalsIgnoreCase("icon-heart")
							&& Keywords.getAttributeVal(elementPcp, "class").equalsIgnoreCase("ng-scope pcp-active"))
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Doctor successfully added to Favourite & PCP</b>", "PASS",
								"<b>Doctor should be added to favourite & pcp</b>");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Doctor successfully not added to Favourite & PCP</b>", "FAIL",
								"<b>Doctor should be added to favourite & pcp</b>");
				}
			}
			Keywords.explicitWait(3);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Doctor added to favourite</b>", "FAIL",
					"<b>Doctor should be added to favourite & pcp</b>");
		}
		return doctorname;
	}

	public String verifyDoctorNameAfterDeletion(String doctorName) {
		String doctorNameFromSearch = "";
		WebElement element;
		List<WebElement> doctorHelpList;
		HashMap<Integer, String> info = new LinkedHashMap<>();
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().findDoctorSearchBox(driver);
			Keywords.typeText(element, doctorName);
			doctorHelpList = Locators.getInstance().helpSearchResultList(driver);
			Keywords.explicitWait(2);
			for (int i = 0; i < doctorHelpList.size(); i++) {
				doctorNameFromSearch = Keywords.getTextByJS(
						"return document.getElementsByClassName('dropdown-menu dropdown-menu-list show')[0].getElementsByClassName('ng-binding')["
								+ i + "].innerText;")
						.trim();
				info.put(i, doctorNameFromSearch);
			}
			if (!info.containsValue(getDoctorMiddleName(doctorName)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name </b>" + doctorName + " Remove successfully", "PASS",
						"<b>Doctor Name should be remove</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name not</b>" + doctorName + " Remove successfully", "FAIL",
						"<b>Doctor Name should be remove</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Doctor Name </b>visibility", "FAIL",
					"<b>Doctor Name should be remove</b>");
		}
		return doctorName;
	}

	public void verifyDoctorNameOnProfilePage(String doctorName) {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().doctorNameOnProfilePage(driver);
			if (Keywords.getText(element).equalsIgnoreCase(doctorName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name same on profile page</b>", "PASS",
						"<b>Doctor Name should be same on profile page</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Doctor Name not match on profile page</b>", "FAIL",
					"<b>Doctor Name should be same on profile page</b>");
		}
	}

	public void verifyDoctorSpecialityOnProfilePage(String doctorSpeciality) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorSpecialityOnProfilePage(driver);
			if (Keywords.getText(element).toLowerCase().contains(doctorSpeciality.toLowerCase()))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Speciality same on profile page</b>", "PASS",
						"<b>Doctor Speciality should be same on profile page</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Speciality not same on profile page</b>", "FAIL",
						"<b>Doctor Speciality should be same on profile page</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verify Doctor Speciality on profile page</b>", "FAIL",
					"<b>Doctor Speciality should be same on profile page</b>");
		}
	}

	public void verifyDoctorNumberOnProfilePage(String doctorNumber) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().doctorContactNumberOnProfilePage(driver);
			if (Keywords.getText(element).contains(doctorNumber))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Contact Number same on profile page</b>", "PASS",
						"<b>Doctor Contact Number should be same on profile page</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Contact Number not same on profile page</b>", "FAIL",
						"<b>Doctor Contact Number should be same on profile page</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verify Doctor Contact Number on profile page</b>", "FAIL",
					"<b>Doctor Contact Number should be same on profile page</b>");
		}
	}

	public void verifyViewAuthorizationBtnOnProfilePage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().viewAuthorizatinBtnOnProfilePage(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Authorization Btn successfully display on profile page</b>", "PASS",
						"<b>View Authorization Btn </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><u>View Authorization Btn</u> successfully not display on profile page</b>", "FAIL",
						"<b>View Authorization Btn </b>should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verify View Authorization Btn on profile Page</b>", "FAIL",
					"<b>View Authorization Btn </b>should be displayed");
		}
	}

	public String removeDoctor(String doctorName) {
		String removedDoctorName = "";
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().doctorNameOnProfilePage(driver), 10);
			element = Locators.getInstance().doctorNameOnProfilePage(driver);
			removedDoctorName = Keywords.getText(element);
			if (removedDoctorName.contains(getDoctorMiddleName(doctorName))) {
				element = Locators.getInstance().removeDoctorBtn(driver);
				Keywords.click(element);
				Keywords.explicitWait(3);
				yesIAmSure();
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> remove successfully", "PASS", doctorName + "<b> should be removed</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						doctorName + "<b> not remove successfully", "FAIL", doctorName + "<b> should be removed</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while deleting the </b>" + doctorName, "FAIL",
					doctorName + "<b> should be removed</b>");
		}

		return removedDoctorName;
	}

	public boolean checkFavouriteButtonStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().favoriteIcon(driver);
			status = Keywords.getAttributeVal(element, "class").equalsIgnoreCase("icon-favorite-heart-outline");
		} catch (Exception e) {
		}

		return status;
	}

	public void addToFavouriteFromProfile() {
		WebElement element;
		try {
			if (checkFavouriteButtonStatus()) {
				element = Locators.getInstance().favoriteIcon(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor added successfully to the favourite</b>", "PASS",
						"<b>Doctor should be added to the favourite</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor already added successfully to the favourite</b>", "PASS",
						"<b>Doctor should be added to the favourite</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while adding doctor to the favourite</b>", "FAIL",
					"<b>Doctor should be added to the favourite</b>");
		}
	}
	
	public void addToFavoriteViaFavBtn() {
		WebElement element;
		try {
			if (checkFavouriteButtonStatus()) {
				element = Locators.getInstance().addToFavoriteBtn(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor added successfully to the Favorite</b>", "PASS",
						"<b>Doctor should be added to the Favorite</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor already added successfully to the Favorite</b>", "PASS",
						"<b>Doctor should be added to the Favorite</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while adding doctor to the Favorite</b>", "FAIL",
					"<b>Doctor should be added to the Favorite</b>");
		}
	}

	public boolean checkPCPButtonStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(6);
			Keywords.waitForObject(Locators.getInstance().addPCP(driver), 5);
			element = Locators.getInstance().addPCP(driver);
			status = Keywords.getAttributeVal(element, "class").contains("pcp-deactivated");
			//System.out.println("Pcp status..." + status);
		} catch (Exception e) {
		}

		return status;
	}

	public void addPCPFromProfile() {
		WebElement element;
		try {
			if (checkPCPButtonStatus()) {
				element = Locators.getInstance().addPCP(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>PCP added successfully to the doctor</b>", "PASS",
						"<b>PCP should be added to the Doctor</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>PCP already added successfully to the doctor</b>", "PASS",
						"<b>PCP should be added to the Doctor</b>");
			// Locators.getInstance().waitForVisibleContactOfficeOnProfile(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while adding PCP to the doctor</b>", "FAIL",
					"<b>PCP should be Added to the Doctor</b>");
		}
	}

	public boolean obtainingYourMedicalRecordsBanner() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().obtainingYourMedicalRecordBanner(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void backToDoctorListPage() {
		WebElement element;
		try {
			element = Locators.getInstance().backToProfilePageBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public boolean wantYourMedicalRecordsStatus() {
		boolean status = false;
		try {
			Keywords.explicitWait(2);
			status = Keywords.isElementPresent(Locators.getInstance().medicalRecordWindowHeaderTxt(driver));
		} catch (Exception e) {
		}

		return status;
	}

	// Medical Records
	public void navigateToWantYourMedicalRecordsWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().medicalRecordBtn(driver);//getMedicalRecordsOnProfilePage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Window </b>successfully display", "PASS",
						"<b>Want Your Medical Records Window </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Window </b>successfully not display", "FAIL",
						"<b>Want Your Medical Records Window </b>should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Get Medical Records Link</b>", "FAIL",
					"<b>Want Your Medical Records Window </b>should be displayed");
		}
	}

	public void verifyWantYourMedicalRecords() {
		WebElement element;
		try {
			// if (wantYourMedicalRecordsStatus()) {
			// element =
			// Locators.getInstance().medicalRecordWindowHeaderTxt(driver);
			// if (Keywords.getText(element).equalsIgnoreCase("Want your medical
			// records?"))
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Want Your Medical Records Msg </b>display successfully",
			// "PASS",
			// "<b>Want Your Medical Records Msg </b>should be display");
			// } else
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Want Your Medical Records Msg </b>not display successfully",
			// "FAIL",
			// "<b>Want Your Medical Records Msg </b>should be display");
			if (wantYourMedicalRecordsStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Msg </b>display successfully", "PASS",
						"<b>Want Your Medical Records Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Msg </b>not display successfully", "FAIL",
						"<b>Want Your Medical Records Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the Msg <b>Want Your Medical Records Msg </b>", "FAIL",
					"<b>Want Your Medical Records Msg </b>should be display");
		}
	}

	public void hideWantYourMedicalRecords() {
		WebElement element;
		try {
			element = Locators.getInstance().hideWantYourMedicalRecords(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Popup </b>close successfully", "PASS",
						"<b>Want Your Medical Records Popup </b>should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Popup </b>not close successfully", "FAIL",
						"<b>Want Your Medical Records Popup </b>should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Want Your Medical Records Popup </b>", "PASS",
					"<b>Want Your Medical Records Popup </b>should be closed");
		}
	}

	public void hideWantYourMedicalRecordsWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().hideWantYourMedicalRecords(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Window </b>close successfully", "PASS",
						"<b>Want Your Medical Records Window </b>should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Want Your Medical Records Window </b>not close successfully", "FAIL",
						"<b>Want Your Medical Records Window </b>should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Want Your Medical Records Window </b>", "FAIL",
					"<b>Want Your Medical Records Window </b>should be closed");
		}
	}

	public boolean feedbackSurveyFormStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().feedbackSurveyHeaderTxt(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void feedbackSurvey() {
		int randomNumber = 0;
		WebElement element;
		List<WebElement> feedbackOptions;
		try {
			if (feedbackSurveyFormStatus()) {
				feedbackOptions = Locators.getInstance().feedbackSurveyOptionsList(driver);
				randomNumber = Keywords.getRandomInteger(feedbackOptions.size());
				Keywords.clickByJS(ElementEnum.ClassName.getElementType(),
						Keywords.getAttributeVal(feedbackOptions.get(randomNumber), "class"), randomNumber);
				Keywords.explicitWait(3);
				boolean checkBoxStatus = Keywords.getCheckBoxStatus(
						"return document.getElementsByClassName('terms-checkbox quiz-radio-wrap ng-scope')["
								+ randomNumber + "].getElementsByTagName('input')[0].checked;");
				if (checkBoxStatus && randomNumber == feedbackOptions.size() - 1) {
					Keywords.typeText(Locators.getInstance().enterCheckboxInputValue(driver, randomNumber),
							"Not Required");
					if (DriverSession.getStepResult())
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Feedback input text </b>enter successfully", "PASS",
								"<b>Feedback input text </b>should be entered");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Feedback input text </b>not enter successfully", "FAIL",
								"<b>Feedback input text </b>should be entered");
				}
				element = Locators.getInstance().submitFeedbackSurveyWindow(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Feedback survey option </b>check & Submit successfully", "PASS",
						"<b>Feedback survey option </b>should be checked & Submit");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Feedback survey Window Already Opened One Time</b>", "PASS",
						"<b>Feedback survey Window </b>should be Display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking & Submitting <b>Feedback survey Window</b>", "FAIL",
					"<b>Feedback survey option </b>should be checked & Submit");
		}
	}

	public void proccedFurtherInstructionForMedicalRecords(boolean option, String doctorMiddleName) {
		WebElement element;
		try {
			if (option) {
				element = Locators.getInstance().medicalRecordBtn(driver);
				Keywords.click(element);
				verifyDoctorNameOnMedicalRecordAuthorizationPage(doctorMiddleName);
				acceptTermAndConditionForMedicalRecord();
				DriverSession.setStepResult(false);
				submitMedicalRecordsAuthorizationWindow();
				DriverSession.setStepResult(true);
				drawSignature();
				submitMedicalRecordsAuthorizationWindow();
				authorizedHealthInformationEForm(doctorMiddleName);
				verifyWeAreProcessOfObtainingMedicalRecordsFromDoctorList(doctorMiddleName);
				navigateToMyDoctorPage();
				viewAuthorization(doctorMiddleName);
				Dashboard dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
				dashboard.selectDashboardLeftMenu("My Doctor");
				clickViewMyDoctorLinkedTxt();
			} else {
				hideWantYourMedicalRecordsWindow();
				feedbackSurvey();
			}
		} catch (Exception e) {

		}
	}

	public String clickOnGetMedicalRecordLink() {
		String doctorName = "";
		WebElement element;
		try {
			while (obtainingYourMedicalRecordsBanner()) {
				backToDoctorListPage();
				doctorName = selectRandomDoctorFromDrList();
			}
			element = Locators.getInstance().medicalRecordLink(driver);
			// element =
			// Locators.getInstance().medicalRecordFromParaLink(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().medicalRecordWindowHeaderTxt(driver);

			if (Keywords.getText(element).equalsIgnoreCase("Want your medical records?"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Record Link </b>click successfully", "PASS",
						"<b>Medical Record Link </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Record Link </b>not click successfully", "FAIL",
						"<b>Medical Record Link </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Medical Record Link </b>", "FAIL",
					"<b>Medical Record Link </b>should be click");
		}

		return doctorName;
	}

	public boolean verifyMedicalRecordsAuthorizationHeaderTxt() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().medicalRecordAuthorizationHeaderTxt(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void navigateToGetMedicalRecords() {
		WebElement element;
		try {
			Keywords.explicitWait(2);
			element = Locators.getInstance().medicalRecordBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (verifyMedicalRecordsAuthorizationHeaderTxt())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Get Medical Records Btn  </b>click successfully", "PASS",
						"<b>Get Medical Records Btn </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Get Medical Records Btn  </b>not click successfully", "FAIL",
						"<b>Get Medical Records Btn </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Get Medical Records Btn  </b>click successfully",
					"FAIL", "<b>Get Medical Records Btn </b>should be click");
		}
	}

	public boolean authorizationOnDateVisibility() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().authorizationOn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public boolean expiresOnDateVisibility() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().expiresOn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public boolean verifyDoctorNameOnMedicalRecordAuthorizationPage(String doctorName) {
		boolean status = false;
		try {
			if (Keywords.isElementPresent(
					Locators.getInstance().doctorNameOnMedicalRecordAuthorization(driver, doctorName)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name " + doctorName
								+ " successfully visible On Medical Records Authorization page</b>",
						"PASS", "<b>Doctor Name " + doctorName
								+ " should be visible On Medical Records Authorization Page.</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name " + doctorName + " not visible On Medical Records Authorization page</b>",
						"FAIL", "<b>Doctor Name " + doctorName
								+ " should be visible On Medical Records Authorization Page.</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Doctor Name " + doctorName
							+ " On Medical Records Authorization page</b>",
					"FAIL",
					"<b>Doctor Name " + doctorName + " should be visible On Medical Records Authorization Page.</b>");
		}

		return status;
	}

	public void acceptTermAndConditionForMedicalRecord() {
		WebElement element;
		try {
			element = Locators.getInstance().acceptTAndChk(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (authorizationOnDateVisibility() && expiresOnDateVisibility())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Conditions CHK </b>select successfully", "PASS",
						"<b>Term & Conditions CHK </b>should be select");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Conditions CHK </b>not select successfully", "FAIL",
						"<b>Term & Conditions CHK </b>should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Term & Conditions CHK </b>", "FAIL",
					"<b>Term & Conditions CHK </b>should be select");
		}
	}

	public void drawSignature() {
		WebElement element;
		try {
			Keywords.explicitWait(4);
			element = Locators.getInstance().doSignature(driver);
			Keywords.scrollToElement(driver, element);
			Keywords.highLightElement(driver, element);
			Keywords.drawLine(element, driver);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature </b>draw successfully", "PASS", "<b>Signature </b>should be draw");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature </b>not draw successfully", "FAIL", "<b>Signature </b>should be draw");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while drawing <b>Signature </b>", "FAIL", "<b>Signature </b>should be draw");
		}
	}

	public void clearSignature() {
		WebElement element;
		try {
			Keywords.explicitWait(4);
			element = Locators.getInstance().clearSignature(driver);
			Keywords.highLightElement(driver, element);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature </b>Clear/Edit successfully", "PASS", "<b>Signature </b>should be Clear/Edit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature </b>successfully not Clear/Edit", "FAIL",
						"<b>Signature </b>should be Clear/Edit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while Clearing/Editing <b> draw Signature</b>", "FAIL",
					"<b>Signature </b>should be Clear/Edit");
		}
	}

	public void AddEditOrClearDrawSignature() {
		WebElement element;
		try {
			element = Locators.getInstance().clearSignature(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().doSignature(driver);
			if (!Keywords.isElementEnable(element)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature Clear </b> successfully", "PASS", "<b>Signature </b>should be Cleared");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Signature </b>not clear successfully", "FAIL", "<b>Signature </b>should be Cleared");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clear the draw <b>Signature</b>", "FAIL",
					"<b>Signature </b>should be Cleared");
		}
	}

	public void signatureRelatedOperation(String operationType) {
		try {
			if (operationType.equalsIgnoreCase("draw"))
				drawSignature();
			else
				clearSignature();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while Adding/Clearing/Editing <b> Signature</b>", "FAIL",
					"<b>Signature </b>should be Draw/Clear/Edit");
		}
	}

	public void submitMedicalRecordsAuthorizationWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitMedicalRecordAuthorizationWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization Info </b>saved successfully", "PASS",
						"<b>Medical Records Authorization Info </b>should be saved");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization Info </b>not saved successfully", "FAIL",
						"<b>Medical Records Authorization Info </b>should be saved");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Medical Records Authorization Info </b>", "FAIL",
					"<b>Medical Records Authorization Info </b>should be saved");
		}
	}

	public void verifyWeAreProcessOfObtainingMedicalRecordsFromDoctorList(String doctorName) {
		WebElement element;
		try {
			element = Locators.getInstance().processObtainingMedicalRecordsFromDrList(driver);
			if (Keywords.getText(element).contains(
					"We are in the process of obtaining your medical records from the doctors listed below")) {
				element = Locators.getInstance().getDoctorNameInViewAuthorization(driver, doctorName);
				if (Keywords.isElementPresent(element))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							doctorName
									+ "<b> Name visible successfully in process of obtaining name from doctor List</b>",
							"PASS", doctorName
									+ "<b> Name should be visible in process of obtaining name from doctor List</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							doctorName + "<b> Name not visible in process of obtaining name from doctor List</b>",
							"FAIL", doctorName
									+ "<b> Name should be visible in process of obtaining name from doctor List</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing " + doctorName
							+ "<b> in process of obtaining name from doctor List</b>",
					"FAIL",
					doctorName + "<b> Name should be visible in process of obtaining name from doctor List</b>");
		}
	}

	// Talk To A Doctor
	public void clickOnTalkToADoctor() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().talkToADoctor(driver), 60);
			element = Locators.getInstance().talkToADoctor(driver);
			Keywords.click(element);
			Keywords.explicitWait(5);

			if (Keywords.getCurrentUrl(driver).contains("talk-to-doctor/"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Talk To A Doctor </b>Link click successfully", "PASS",
						"<b>Talk To A Doctor </b>Link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Talk To A Doctor </b>Link not click successfully", "FAIL",
						"<b>Talk To A Doctor </b>Link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Talk To A Doctor </b>Link", "FAIL",
					"<b>Talk To A Doctor </b>Link should be clicked");
		}
	}

	public boolean telemedicineConsultHeaderTxt() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().telemedicineConsultHeaderTxt(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean finishHealthAssessmentLink() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().finishHealthAssessment(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void selectFinishHealthAssessmentLink() {
		WebElement element;
		try {
			element = Locators.getInstance().finishHealthAssessment(driver);
			Keywords.click(element);
			element = Locators.getInstance().waitQuizQuesNumberTxt(driver);

			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 text </b>display successfully", "PASS",
						"<b>Question 1 of 5 text </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 text </b>not display successfully", "FAIL",
						"<b>Question 1 of 5 text </b>should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Question 1 of 5 text </b>", "FAIL",
					"<b>Question 1 of 5 text </b>should be visible");
		}
	}

	public boolean selectYourPharmcyLinkStatus() {
		boolean linkStatus = false;
		WebElement element;
		try {
			Keywords.explicitWait(5);
			element = Locators.getInstance().selectYourPharmacyLink(driver);
			linkStatus = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return linkStatus;
	}

	public void selectYourPharmacyLink() {
		WebElement element;
		try {
			element = Locators.getInstance().selectYourPharmacyLink(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Select Your Pharmacy Link </b>select successfully", "PASS",
					"<b>Select Your Pharmacy Link </b>should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Select Your Pharmacy Link</b>", "FAIL",
					"<b>Select Your Pharmacy Link </b>should be select");
		}
	}

	public boolean finishPreVisitQuestionsLink() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().finishPreVisitQuestion(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void selectFinishPreVisitQuestionsLink() {
		WebElement element;
		try {
			element = Locators.getInstance().finishPreVisitQuestion(driver);
			Keywords.click(element);
			element = Locators.getInstance().waitForQuizHeaderTxt(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 text </b>display successfully", "PASS",
						"<b>Question 1 of 5 text </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 text </b>not display successfully", "FAIL",
						"<b>Question 1 of 5 text </b>should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Question 1 of 5 text </b>", "FAIL",
					"<b>Question 1 of 5 text </b>should be visible");
		}
	}

	public void quizNavigation(String navigationValue) {
		WebElement element;
		try {
			if (navigationValue.equalsIgnoreCase("next"))
				element = Locators.getInstance().quizNextBtn(driver);
			else
				element = Locators.getInstance().quizPreviousBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {

		}
	}

	public List<String> getCheckedCheckBoxValue(List<WebElement> elementList) {
		int index = 0;
		List<String> info = new ArrayList<>();
		try {
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				info.add("0 true");
			else
				info.add("1 false");
		} catch (Exception e) {
		}
		return info;
	}

	// Question One Of Five
	public void selectUserHeightInFeet() {
		WebElement element;
		List<String> feetList;
		try {
			element = Locators.getInstance().questionOneOfOneSelectFeet(driver);
			feetList = Keywords.getSelectOptionList(element);
			Keywords.selectByVisibleText(element,
					feetList.get(Keywords.getRandomIntegerBtRange(2, feetList.size() - 1)));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>enter successfully", "PASS",
						"<b>User Weight in pounds </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>not enter successfully", "FAIL",
						"<b>User Weight in pounds </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>User Weight in pounds </b>", "FAIL",
					"<b>User Weight in pounds </b>should be entered");
		}
	}

	public void selectUserHeightInInches() {
		WebElement element;
		List<String> inchesList;
		try {
			element = Locators.getInstance().questionOneOfOneSelectInches(driver);
			inchesList = Keywords.getSelectOptionList(element);
			Keywords.selectByVisibleText(element,
					inchesList.get(Keywords.getRandomIntegerBtRange(2, inchesList.size() - 1)));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Feet select </b>successfully", "PASS",
						"<b>User Height in Feet select </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Feet not select </b>successfully", "FAIL",
						"<b>User Height in Feet select </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>User Height in Inches</b>", "FAIL",
					"<b>User Height in Inches select </b>should be selected");
		}
	}

	public String enterUserWeight() {
		String weight = "";
		WebElement element;
		try {
			weight = DriverSession.getTestCaseData().get("Weight");
			element = Locators.getInstance().questionOneOfTwoWeight(driver);
			Keywords.typeText(element, weight);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>enter successfully", "PASS",
						"<b>User Weight in pounds </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>not enter successfully", "FAIL",
						"<b>User Weight in pounds </b>should be entered");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>User Weight in pounds </b>", "FAIL",
					"<b>User Weight in pounds </b>should be entered");
		}
		return weight;
	}

	public String smokeTobacco() {
		int index = 0;
		String isSmoke = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionOneOfFourSmokeTobacco(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isSmoke = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 4 answer given </b>successfully", "PASS",
						"<b>Question 1 of 4 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 4 answer not given </b>successfully", "FAIL",
						"<b>Question 1 of 4 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 1 of 4 answer given </b>successfully", "FAIL",
					"<b>Question 1 of 4 answer </b>should be given");
		}

		return isSmoke;
	}

	public String drinkAlcohol() {
		int index = 0;
		String isDrink = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionOneOfFiveDrinkAlcoholWeight(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDrink = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 answer given </b>successfully", "PASS",
						"<b>Question 1 of 5 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 1 of 5 answer not given </b>successfully", "FAIL",
						"<b>Question 1 of 5 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 1 of 5 answer given </b>successfully", "FAIL",
					"<b>Question 1 of 5 answer </b>should be given");
		}

		return isDrink;
	}

	// Question Two Of Five
	public void verifyQuestionHeaderCount(String countTxt) {
		WebElement element;
		try {
			element = Locators.getInstance().healthHistoryStep(driver);
			if (countTxt.equalsIgnoreCase(Keywords.getText(element)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question " + countTxt + " of Five </b>display successfully", "PASS",
						"<b>Question " + countTxt + " of Five </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question " + countTxt + " of Five </b>not display successfully", "FAIL",
						"<b>Question " + countTxt + " of Five </b>should be display");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing page navigate <b>Question " + countTxt + " of Five </b>", "FAIL",
					"<b>Question " + countTxt + " of Five </b>should be display");
		}
	}

	public void twoOfOneSayYourHealthStatus() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfOneHealthStatus(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 1 answer given </b>successfully", "PASS",
						"<b>Question 2 of 1 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 1 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 1 </b>", "FAIL",
					"<b>Question 2 of 1 answer </b>should be given");
		}
	}

	public void twoOfTwoLastCheckup() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfTwoLastCheckup(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 2 answer given </b>successfully", "PASS",
						"<b>Question 2 of 2 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 2 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 2 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 2 </b>", "FAIL",
					"<b>Question 2 of 2 answer </b>should be given");
		}
	}

	public void twoOfThreeTakingMultiVitaminSupplement() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfThreeTakeMultivitamin(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 3 answer given </b>successfully", "PASS",
						"<b>Question 2 of 3 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 3 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 3 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 3 </b>", "FAIL",
					"<b>Question 2 of 3 answer </b>should be given");
		}
	}

	public void twoOfFourChangesToImproveHealth() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfFourLifestyleChangesToImproveHealth(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 4 answer given </b>successfully", "PASS",
						"<b>Question 2 of 4 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 4 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 4 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 4 </b>", "FAIL",
					"<b>Question 2 of 4 answer </b>should be given");
		}
	}

	public void twoOfFiveFluVaccine() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfFiveFluVaccineLastYear(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 5 answer given </b>successfully", "PASS",
						"<b>Question 2 of 5 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 5 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 5 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 5 </b>", "FAIL",
					"<b>Question 2 of 5 answer </b>should be given");
		}
	}

	public void twoOfSixLabWork() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfSixLabWork(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 6 answer given </b>successfully", "PASS",
						"<b>Question 2 of 6 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 6 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 6 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 6 </b>", "FAIL",
					"<b>Question 2 of 6 answer </b>should be given");
		}
	}

	public void twoOfSevenConnectedDevice() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfSevenConnectedDevices(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 7 answer given </b>successfully", "PASS",
						"<b>Question 2 of 7 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 2 of 7 answer not given </b>successfully", "FAIL",
						"<b>Question 2 of 7 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 2 of 7 </b>", "FAIL",
					"<b>Question 2 of 7 answer </b>should be given");
		}
	}

	public void threeOfOneServingsOfFruits() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfOneServingsOfFruits(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 1 answer given </b>successfully", "PASS",
						"<b>Question 3 of 1 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 1 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 1 </b>", "FAIL",
					"<b>Question 3 of 1 answer </b>should be given");
		}
	}

	public void threeOfTwoServingsOfVegetables() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfTwoServingVegetables(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 2 answer given </b>successfully", "PASS",
						"<b>Question 3 of 2 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 2 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 2 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 2 </b>", "FAIL",
					"<b>Question 3 of 2 answer </b>should be given");
		}
	}

	public void threeOfThreeEatWhiteMeat() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfThreeEatWhiteMeat(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 3 answer given </b>successfully", "PASS",
						"<b>Question 3 of 3 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 3 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 3 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 3 </b>", "FAIL",
					"<b>Question 3 of 3 answer </b>should be given");
		}
	}

	public void threeOfFourEatRedMeat() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfFourEatRedMeat(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 4 answer given </b>successfully", "PASS",
						"<b>Question 3 of 4 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 4 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 4 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 4 </b>", "FAIL",
					"<b>Question 3 of 4 answer </b>should be given");
		}
	}

	public void threeOfFiveProcessedMeat() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfFiveEatProcessedMeat(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 5 answer given </b>successfully", "PASS",
						"<b>Question 3 of 5 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 1 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 1 </b>", "FAIL",
					"<b>Question 3 of 1 answer </b>should be given");
		}
	}

	public void threeOfSixEatWholeGrainBreadWildRice() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfSixEatGrainBreadWildRice(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 6 answer given </b>successfully", "PASS",
						"<b>Question 3 of 6 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 1 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 1 </b>", "FAIL",
					"<b>Question 3 of 1 answer </b>should be given");
		}
	}

	public void threeOfSevenServingsMilkAndDairyProduct() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionThreeOfSevenServingDifferntDairyMilk(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 7 answer given </b>successfully", "PASS",
						"<b>Question 3 of 7 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 3 of 1 answer not given </b>successfully", "FAIL",
						"<b>Question 3 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while giving the answer of <b>Question 3 of 1 </b>", "FAIL",
					"<b>Question 3 of 1 answer </b>should be given");
		}
	}

	// four
	public void fourOfOneDifficultyInSleeping() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfOneDifficultyInSleeping(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 1 answer given </b>successfully", "PASS",
						"<b>Question 4 of 1 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 1 answer given </b>successfully", "PASS",
						"<b>Question 4 of 1 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 4 of 1 answer given </b>successfully", "PASS",
					"<b>Question 4 of 1 answer </b>should be given");
		}
	}

	public void fourOfTwoSleepRestless() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfTwoSleepRestless(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 2 answer given </b>successfully", "PASS",
						"<b>Question 4 of 2 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 2 answer given </b>successfully", "PASS",
						"<b>Question 4 of 2 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 4 of 2 answer given </b>successfully", "PASS",
					"<b>Question 4 of 2 answer </b>should be given");
		}
	}

	public void fourOfThreeFeelingrefreshedInMorning() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfThreeFeelingRefreshedInMornings(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 3 answer given </b>successfully", "PASS",
						"<b>Question 4 of 3 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 3 answer not given </b>successfully", "FAIL",
						"<b>Question 4 of 3 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 4 of 3 answer given </b>successfully", "FAIL",
					"<b>Question 4 of 3 answer </b>should be given");
		}
	}

	public boolean howOldYouStartSmokingStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().howOldYouStartSmoking(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public boolean lastSmokedCigaretteStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().lastSmokedCigarette(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void fourOfFourSmokeCigaretteInYourLifeStyle() {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfFourSmokeCigarettesInYourLifeTime(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 4 answer given </b>successfully", "PASS",
						"<b>Question 4 of 4 answer </b>should be given");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Question 4 of 4 answer given </b>successfully", "PASS",
						"<b>Question 4 of 4 answer </b>should be given");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Question 4 of 4 answer given </b>successfully", "PASS",
					"<b>Question 4 of 4 answer </b>should be given");
		}
	}

	public void howOldYouStartSmoking(int userAge) {
		String age = "";
		WebElement element;
		try {
			age = DriverSession.getTestCaseData().get("StartSmoking");
			if (howOldYouStartSmokingStatus()) {
				element = Locators.getInstance().howOldYouStartSmoking(driver);
				Keywords.typeText(element, userAge + 1 + "");
				Keywords.explicitWait(3);
				element = Locators.getInstance().errorMsgForInvalidAge(driver);
				if (Keywords.isElementPresent(element))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>How Old You Start Smoking Value can't exceed your current age.</b>successfully display",
							"PASS",
							"<b>How Old You Start Smoking Value can't exceed your current age.</b>should be display");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>How Old You Start Smoking Value can't exceed your current age.</b>not successfully display",
							"FAIL",
							"<b>How Old You Start Smoking Value can't exceed your current age.</b>should be display");
				element = Locators.getInstance().howOldYouStartSmoking(driver);
				Keywords.typeText(element, age);
				Keywords.explicitWait(4);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>How Old You Start Smoking </b>not enter successfully", "FAIL",
							"<b>How Old You Start Smoking </b>should be entered");
			} else {
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>How Old You Start Smoking Age</b>", "FAIL",
					"<b>How Old You Start Smoking </b>should be entered");
		}
	}

	public void lastSmokedCigarette(int userAge) {
		String age = "";
		WebElement element;
		try {
			age = DriverSession.getTestCaseData().get("StartSmoking");
			if (lastSmokedCigaretteStatus()) {
				element = Locators.getInstance().lastSmokedCigarette(driver);
				Keywords.typeText(element, userAge + 1 + "");
				element = Locators.getInstance().errorMsgForInvalidAge(driver);
				if (Keywords.isElementPresent(element))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Last Smoked Cigarette Value can't exceed your current age.</b>successfully display",
							"PASS",
							"<b>Last Smoked Cigarette Value can't exceed your current age.</b>should be display");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Last Smoked Cigarette Value can't exceed your current age.</b>not successfully display",
							"FAIL",
							"<b>Last Smoked Cigarette Value can't exceed your current age.</b>should be display");
				element = Locators.getInstance().howOldYouStartSmoking(driver);
				Keywords.typeText(element, Integer.parseInt(age) / 2 + "");
				Keywords.explicitWait(5);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Last Smoked Cigarette Value </b>not enter successfully", "FAIL",
							"<b>Last Smoked Cigarette Value </b>should be entered");
			} else {
			}
		} catch (Exception e) {

		}
	}

	public void fourOfFiveLikeBriskWalk() {
		int randomIndex = 0;
		WebElement element;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfFiveLikeBriskWalk(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));
			if (randomIndex != 0) {
				element = Locators.getInstance().questionFourOfFiveModerateToStrenuousHowManyMinuteDoExercise(driver);
				Keywords.typeText(element, Keywords.getRandomIntegerBtRange(30, 60) + "");
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Briks Walk options </b>select successfully", "PASS",
						"<b>Briks Walk options </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Briks Walk options </b>not select successfully", "FAIL",
						"<b>Briks Walk options </b>should be selected");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Briks Walk options ", "FAIL",
					"<b>Briks Walk </b>should be entered");
		}
	}

	// Question Five of Five
	public void fiveOfOneUpsetDueToSomethingUnexpectedly() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfOneUpsetSomethingHappenedUnexpected(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Upset becuase of something happened unexpectedly </b>option check successfully", "PASS",
						"<b>Upset becuase of something happened unexpectedly option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Upset becuase of something happened unexpectedly </b>option not check successfully", "FAIL",
						"<b>Upset becuase of something happened unexpectedly option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Upset becuase of something happened unexpectedly</b>",
					"FAIL", "<b>Upset becuase of something happened unexpectedly option </b>should be checked");
		}
	}

	public void fiveOfTwoUnableToControlImportantThingInYourLife() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfTwoUnableToControlImpThings(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unable to control Important thing in your life </b>option check successfully", "PASS",
						"<b>Unable to control Important thing in your life option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unable to control Important thing in your life </b>option not check successfully", "FAIL",
						"<b>Unable to control Important thing in your life option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Unable to control Important thing in your life</b>",
					"FAIL", "<b>Unable to control Important thing in your life option </b>should be checked");
		}
	}

	public void fiveOfThreeFeltNervousOrStressed() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfThreeFeltNervousOrStressed(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Felt Nervous or Stressed </b>option check successfully", "PASS",
						"<b>Felt Nervous or Stressed option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Felt Nervous or Stressed </b>option not check successfully", "FAIL",
						"<b>Felt Nervous or Stressed option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Felt Nervous or Stressed</b>", "FAIL",
					"<b>Felt Nervous or Stressed option </b>should be checked");
		}
	}

	public void fiveOfFour() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfFour(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>you found that you could not cope with all the things you had to do </b>option check successfully",
						"PASS",
						"<b>you found that you could not cope with all the things you had to do option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>you found that you could not cope with all the things you had to do </b>option not check successfully",
						"FAIL",
						"<b>you found that you could not cope with all the things you had to do option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>you found that you could not cope with all the things you had to do</b>",
					"FAIL",
					"<b>you found that you could not cope with all the things you had to do option </b>should be checked");
		}
	}

	public void fiveOfFiveFeelNotOnTopOfThings() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfFiveYouNotOnTopOfThings(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Feel you were not on top of things </b>option check successfully", "PASS",
						"<b>Feel you were not on top of things option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Feel you were not on top of things </b>option not check successfully", "FAIL",
						"<b>Feel you were not on top of things option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Feel you were not on top of things</b>", "FAIL",
					"<b>Feel you were not on top of things option </b>should be checked");
		}
	}

	public void oneOfSixAtWhatAgeMenstrualCycles(int age) {
		WebElement element;
		try {
			element = Locators.getInstance().questionOneOfSixWhatAgeYourMenstrualCycles(driver);
			Keywords.typeText(element, age + 1 + "");
			element = Locators.getInstance().errorMsgForInvalidAge(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Value can't exceed your current age. </b>successfully display", "PASS",
						"<b>Value can't exceed your current age. </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Value can't exceed your current age.</b>not successfully display", "FAIL",
						"<b>Value can't exceed your current age. </b>should be display");
			element = Locators.getInstance().questionOneOfSixWhatAgeYourMenstrualCycles(driver);
			Keywords.typeText(element, age / 2 + "");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Menstrual cycles begins </b>enter successfully", "PASS",
						"<b>Menstrual cycles begins </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Menstrual cycles begins </b>not enter successfully", "FAIL",
						"<b>Menstrual cycles begins </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Menstrual Cycles Begins", "FAIL",
					"<b>Menstrual cycles begins </b>should be entered");
		}
	}

	public void threeOfSixFirstTimePregnant(int age) {
		WebElement element;
		try {
			element = Locators.getInstance().questionThreeOfSixAtWhatAgeYouFirstGetPregnant(driver);
			Keywords.typeText(element, age + 2 + "");
			element = Locators.getInstance().errorMsgForInvalidAge(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Value can't exceed your current age. </b>successfully display", "PASS",
						"<b>Value can't exceed your current age. </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Value can't exceed your current age.</b>not successfully display", "FAIL",
						"<b>Value can't exceed your current age. </b>should be display");
			element = Locators.getInstance().questionThreeOfSixAtWhatAgeYouFirstGetPregnant(driver);
			Keywords.typeText(element, age / 2 + "");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Time Pregnant </b>enter successfully", "PASS",
						"<b>First Time Pregnant </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>First Time Pregnant </b>not enter successfully", "FAIL",
						"<b>First Time Pregnant </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>First Time Pregnant </b>", "FAIL",
					"<b>First Time Pregnant </b>should be entered");
		}
	}

	public void fourOfSixHadGestationalHypertension() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFourOfSixGestationalHypertension(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You had Gestational Hypertension </b>option check successfully", "PASS",
						"<b>Have You had Gestational Hypertension option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You had Gestational Hypertension </b>option not check successfully", "FAIL",
						"<b>Have You had Gestational Hypertension option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Have You had Gestational Hypertensiont</b>",
					"FAIL", "<b>Have You had Gestational Hypertension option </b>should be checked");
		}
	}

	public void fiveOfSixHaveTumorInYourBreast() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionFiveOfSixTumorInYourBreast(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>You have a benign tumor in your breast </b>option check successfully", "PASS",
						"<b>You have a benign tumor in your breast option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>You have a benign tumor in your breast </b>option not check successfully", "FAIL",
						"<b>You have a benign tumor in your breast option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>You have a benign tumor in your breast</b>",
					"FAIL", "<b>You have a benign tumor in your breast option </b>should be checked");
		}
	}

	public void SixOfSixHaveYouHadMammogram() {
		int randomIndex = 0;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionSixOfSixMammogram(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Had Mammogram </b>option check successfully", "PASS",
						"<b>Have You Had Mammogram option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Had Mammogram </b>option not check successfully", "FAIL",
						"<b>Have You Had Mammogram option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Have You Had Mammogram</b>", "FAIL",
					"<b>Have You Had Mammogram option </b>should be checked");
		}
	}

	public boolean twoOfSixHaveYouEverPregnant() {
		int randomIndex = 0;
		boolean status = false;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionTwoOfSixHaveYouEverPregnant(driver);
			randomIndex = Keywords.getRandomInteger(elementList.size());
			if (randomIndex == 0)
				status = true;
			Keywords.click(elementList.get(randomIndex));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Ever Been Pregnant </b>option check successfully", "PASS",
						"<b>Have You Ever Been Pregnant option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Ever Been Pregnant </b>option not check successfully", "FAIL",
						"<b>Have You Ever Been Pregnant option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the options <b>Have You Ever Been Pregnant</b>", "FAIL",
					"<b>Have You Ever Been Pregnant option </b>should be checked");
		}

		return status;
	}

	public void submitHealthAssessment() {
		WebElement element;
		try {
			element = Locators.getInstance().submitPreVisitQuestion(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Assessment Question Info </b>submit successfully", "PASS",
						"<b>Health Assessment Question Info </b>should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Assessment Question Info </b>submit successfully", "FAIL",
						"<b>Health Assessment Question Info </b>should be submitted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Health Assessment Question Info</b>", "FAIL",
					"<b>Health Assessment Question Info </b>should be submitted");
		}
	}

	public void finalSubmitHealthAssessment() {
		WebElement element;
		try {
			element = Locators.getInstance().thankYouMsgForCompletingHealthAssessment(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Message For Completing Health Assessment </b>display successfully", "PASS",
						"<b>Thank You Message For Completing Health Assessment </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Message For Completing Health Assessment </b>not display successfully", "FAIL",
						"<b>Thank You Message For Completing Health Assessment </b>should be display");
			element = Locators.getInstance().finalSubmitPreVisitQuestion(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button of Health Assessment </b>click successfully", "PASS",
						"<b>Submit Button of Health Assessment </b>should be clicked");
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button of Health Assessment </b>not click successfully", "FAIL",
						"<b>Submit Button of Health Assessment </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Submit Button of Health Assessment</b>", "FAIL",
					"<b>Submit Button of Health Assessment </b>should be clicked");
		}
	}

	// Pre Visit Questions.
	public void selectUserHeightInFeetForPreVisit() {
		WebElement element;
		List<String> feetList;
		try {
			element = Locators.getInstance().questionOneOfOneSelectFeet(driver);
			feetList = Keywords.getSelectOptionList(element);
			Keywords.selectByVisibleText(element,
					feetList.get(Keywords.getRandomIntegerBtRange(2, feetList.size() - 1)));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Feet select </b>successfully", "PASS",
						"<b>User Height in Feet select </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Feet not select </b>successfully", "FAIL",
						"<b>User Height in Feet select </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>User Height in Feet</b>", "FAIL",
					"<b>User Height in Feet select </b>should be selected");
		}
	}

	public void selectUserHeightInInchesForPreVisit() {
		WebElement element;
		List<String> inchesList;
		try {
			element = Locators.getInstance().questionOneOfOneSelectInches(driver);
			inchesList = Keywords.getSelectOptionList(element);
			Keywords.selectByVisibleText(element,
					inchesList.get(Keywords.getRandomIntegerBtRange(2, inchesList.size() - 1)));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Inches select </b>successfully", "PASS",
						"<b>User Height in Inches select </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height in Inches not select </b>successfully", "FAIL",
						"<b>User Height in Inches select </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>User Height in Inches</b>", "FAIL",
					"<b>User Height in Inches select </b>should be selected");
		}
	}

	public String enterUserWeightForPreVisit() {
		String weight = "";
		WebElement element;
		try {
			weight = DriverSession.getTestCaseData().get("Weight");
			element = Locators.getInstance().questionOneOfTwoWeight(driver);
			Keywords.typeText(element, weight);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>enter successfully", "PASS",
						"<b>User Weight in pounds </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight in pounds </b>not enter successfully", "FAIL",
						"<b>User Weight in pounds </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>User Weight in pounds </b>", "FAIL",
					"<b>User Weight in pounds </b>should be entered");
		}

		return weight;
	}

	public String smokeTobaccoForPreVisit() {
		int index = 0;
		String isSmoke = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionOneOfFourSmokeTobacco(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isSmoke = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Smoke Tobacco options </b>check/Uncheck successfully", "PASS",
						"<b>Smoke Tobacco options </b>should be checkOrUncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking <b>Smoke Tobacco options</b>", "FAIL",
					"<b>Smoke Tobacco options </b>should be checkOrUncheck");
		}

		return isSmoke;
	}

	public String drinkAlcoholForPreVisit() {
		int index = 0;
		String isDrink = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().questionOneOfFiveDrinkAlcoholWeight(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDrink = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drink Alcohol options </b>check/Uncheck successfully", "PASS",
						"<b>Drink Alcohol options </b>should be checkOrUncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking <b>Drink Alcohol options</b>", "FAIL",
					"<b>Drink Alcohol options </b>should be checkOrUncheck");
		}

		return isDrink;
	}

	public String haveYouEverDisabled() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().haveYouEverDisabledList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Ever Been Disabled checkbox </b>check successfully", "PASS",
						"<b>Have You Ever Been Disabled checkbox </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Have You Ever Been Disabled checkbox </b>not check successfully", "FAIL",
						"<b>Have You Ever Been Disabled checkbox </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox <b>Have You Ever Been Disabled checkbox </b>",
					"FAIL", "<b>Have You Ever Been Disabled checkbox </b>should be selected");
		}

		return isDisabled;
	}

	public String faceOccupationalAsbestosExposure() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().faceOccupationalAsbestosList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Asbestos Exposure checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Asbestos Exposure checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Asbestos Exposure checkbox</b>", "FAIL",
					"<b>Asbestos Exposure checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String faceOccupationalDieselExhaustExposure() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().faceOccupationalDieselList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diesel Exposure checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Diesel Exposure checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Diesel Exposure checkbox</b>", "FAIL",
					"<b>Diesel Exposure checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String faceRadonExposure() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().faceRadonExposureList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Radon Exposure checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Radon Exposure checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Radon Exposure checkbox</b>", "FAIL",
					"<b>Radon Exposure checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String faceOccupationalTobaccoExposure() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().faceOccupationalTobaccoList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tobacco Exposure checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Tobacco Exposure checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Tobacco Exposure checkbox</b>", "FAIL",
					"<b>Tobacco Exposure checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String chronicCondition() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().chronicConditionList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Chronic Condition checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Chronic Condition checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Chronic Condition</b>", "FAIL",
					"<b>Chronic Condition checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String recreationDrugs() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().recreationalDrugsList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Recreation Drugs checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Recreation Drugs checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Recreation Drugs</b>", "FAIL",
					"<b>Recreation Drugs checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String travelOverseas() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().traveledOverseasList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Traveled Overseas checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Traveled Overseas checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Traveled Overseas</b>", "FAIL",
					"<b>Traveled Overseas checkbox </b>should be check/Uncheck");
		}
		return isDisabled;
	}

	public String bloodInUrine() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().bloodInUrineList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Blood In Urine checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Blood In Urine checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Blood In Urine</b>", "FAIL",
					"<b>Blood In Urine checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String feelBurning() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().feelBuringSlasPainList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Feel Burning checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Feel Burning checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Feel Burning</b>", "FAIL",
					"<b>Feel Burning checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String urinateIn24Hours() {
		String isDisabled = "";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().urinateIn24HoursList(driver);
			Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Urinate In 24 Hours checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Urinate In 24 Hours checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Urinate In 24 Hours</b>", "FAIL",
					"<b>Urinate In 24 Hours checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String bladderSymptomsImpacted() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().bladderSymptomsList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Bladder Symptons Impacted checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Bladder Symptons Impacted checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Bladder Symptons Impacted</b>", "FAIL",
					"<b>Bladder Symptons Impacted checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public void leakedUrineInLastThreeMonthsMost(boolean urineLeakOptions) {
		List<WebElement> elementList;
		try {
			Keywords.explicitWait(2);
			elementList = Locators.getInstance().leakedUrineInLastThreeMonthsList(driver);
			if (urineLeakOptions == true) {
				Keywords.click(elementList.get(Keywords.getRandomInteger(elementList.size())));
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Urine Leaked Most In Last 3 Months select successfully</b>", "PASS",
						"<b>Urine Leaked Most In Last 3 Months </b>option should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while selecting the <b>Urine Leaked Most In Last 3 Months</b>", "FAIL",
					"<b>Urine Leaked Most In Last 3 Months checkbox </b> option should be checked");
		}
	}

	public void leakedUrine() {
		int index = 0;
		boolean isDisplayed = false;
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().leakedUrineList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0) {
				isDisplayed = true;
				Keywords.click(elementList.get(index));
				leakedUrineInLastThreeMonthsMost(isDisplayed);
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Urine Leaked In Last 3 months checkbox </b>successfully checked", "PASS",
						"<b>Urine Leaked In Last 3 months checkbox </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Urine Leaked In Last 3 months checkbox </b>successfully not checked", "FAIL",
						"<b>Urine Leaked In Last 3 months checkbox </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Urine Leaked</b>", "FAIL",
					"<b>Urine Leaked checkbox </b>should be check/Uncheck");
		}
	}

	public String hoursOfSleepInNight() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().hoursOfSleepInNightList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Hours Of Sleep In Night checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Hours Of Sleep In Night checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Hours Of Sleep In Night</b>", "FAIL",
					"<b>Hours Of Sleep In Night checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String yearlyFluShots() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().yearlyFluShots(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Yearly Flu Shot Take checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Yearly Flu Shot Take checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Yearly Flu Shot Take</b>", "FAIL",
					"<b>Yearly Flu Shot Take checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public void lastVisitToDoctor() {
		WebElement element;
		try {
			element = Locators.getInstance().lastVisitToDoctor(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().selectLastVisitDate(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Last Visit to Doctor Date </b>select successfully", "PASS",
						"<b>Last Visit to Doctor Date </b>should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Last Visit to Doctor Date", "FAIL",
					"<b>Last Visit to Doctor Date </b>should be select");
		}
	}

	public String highBloodPressure() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().highBloodPressure(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			else if (index == 2)
				isDisabled = "I don't know";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>High Blood Pressure checkbox </b>check/Uncheck successfully", "PASS",
						"<b>High Blood Pressure checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>High Blood Pressure</b>", "FAIL",
					"<b>High Blood Pressure checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	public String exerciseRegularly() {
		int index = 0;
		String isDisabled = "false";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().exerciseRegularlyList(driver);
			index = Keywords.getRandomInteger(elementList.size());
			if (index == 0)
				isDisabled = "true";
			Keywords.click(elementList.get(index));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Exercise Regularly checkbox </b>check/Uncheck successfully", "PASS",
						"<b>Exercise Regularly checkbox </b>should be check/Uncheck");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the checkbox for <b>Exercise Regularly</b>", "FAIL",
					"<b>Exercise Regularly checkbox </b>should be check/Uncheck");
		}

		return isDisabled;
	}

	/*
	 * public int addNumberOfDiseasesDropdown() { int randomClick = 0;
	 * WebElement element; try { randomClick =
	 * Keywords.getRandomIntegerBtRange(1, 5); element =
	 * Locators.getInstance().addDiseaseDropDown(driver); for (int i = 0; i <
	 * randomClick; i++) { Keywords.click(element); Keywords.explicitWait(2); }
	 * if (DriverSession.getStepResult())
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * randomClick + "<b> Disease Dropdown </b>successfully added", "PASS",
	 * randomClick + "<b> Disease Dropdown shoule be added</b>"); else
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * randomClick + "<b> Disease Dropdown </b>successfully not added", "FAIL",
	 * randomClick + "<b> Disease Dropdown shoule be added</b>"); } catch
	 * (Exception e) {
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "Exception occurred while adding the " + randomClick +
	 * "<b> Disease Dropdown </b>", "FAIL", randomClick +
	 * "<b> Disease Dropdown shoule be added</b>"); }
	 * 
	 * return randomClick; }
	 */
	public boolean errorMessageForValidAge() {
		boolean errorStatus = false;
		WebElement element;
		try {
			element = Locators.getInstance().selectValidAgeErrorMessage(driver);
			errorStatus = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return errorStatus;
	}

	public void addDiseaseDropdown(int howManyDropdown) {
		WebElement element;
		try {
			element = Locators.getInstance().addDiseasesDropdownList(driver);
			for (int i = 0; i < howManyDropdown; i++) {
				Keywords.click(element);
				Keywords.explicitWait(1);
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						howManyDropdown + "<b> Disease Dropdown </br> added successfully", "PASS",
						howManyDropdown + "<b> Disease Dropdown should be added.</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						howManyDropdown + "<b> Disease Dropdown </br> not added successfully", "FAIL",
						howManyDropdown + "<b> Disease Dropdown should be added.</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding " + howManyDropdown + "<b> Disease Dropdown</b>", "FAIL",
					howManyDropdown + "<b> Disease Dropdown should be added.</b>");
		}
	}

	public HashMap<String, String> diseaseTypeAndAgeAtDiagnosis(int age) {
		int randomOption = 0;
		int diseaseDropdownCount = 2;// addNumberOfDiseasesDropdown();
		String aAge = "";
		String diseaseName = "";
		WebElement element;
		List<String> optionList;
		List<String> atAgeList;
		List<WebElement> elementAgeList;
		HashMap<String, String> diseaseInfo = new LinkedHashMap<>();
		try {
			addDiseaseDropdown(diseaseDropdownCount);
			for (int i = 0; i < diseaseDropdownCount; i++) {
				element = Locators.getInstance().selectDiseaseDropdownMenu(driver, i);
				optionList = Keywords.getSelectOptionList(element);
				optionList.remove(0);
				randomOption = Keywords.getRandomInteger(optionList.size());
				diseaseName = optionList.get(randomOption);
				Keywords.selectByVisibleText(element, diseaseName);
				optionList.clear();
				elementAgeList = Locators.getInstance().selectDiseaseAtAge(driver);
				atAgeList = Keywords.getSelectOptionList(elementAgeList.get(i));
				atAgeList.remove(0);
				aAge = atAgeList.get(Keywords.getRandomInteger(atAgeList.size()));
				Keywords.selectByVisibleText(elementAgeList.get(i), aAge);
				while (errorMessageForValidAge()) {
					aAge = atAgeList.get(Keywords.getRandomInteger(atAgeList.size()));
					Keywords.selectByVisibleText(elementAgeList.get(i), aAge);
				}
				diseaseInfo.put(diseaseName, aAge);
				atAgeList.clear();
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Disease & Age at Diagnosis </b>select successfully", "PASS",
						"<b>Disease & Age at Diagnosis </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Disease & Age at Diagnosis </b>not select successfully", "FAIL",
						"<b>Disease & Age at Diagnosis </b>should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Disease & Age at Diagnosis </b>", "FAIL",
					"<b>Disease & Age at Diagnosis </b>should be selected");
		}
		return diseaseInfo;
	}

	public void submitPreVisitQuestions() {
		WebElement element;
		try {
			element = Locators.getInstance().submitPreVisitQuestion(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pre Visit Question </b>submit successfully", "PASS",
						"<b>Pre Visit Question </b>should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pre Visit Question </b>not submit successfully", "FAIL",
						"<b>Pre Visit Question </b>should be submitted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Pre Visit Question </b>", "FAIL",
					"<b>Pre Visit Question </b>should be submitted");
		}
	}

	public void finalSubmitPreVisitQuestions() {
		WebElement element;
		try {
			element = Locators.getInstance().finalSubmitPreVisitQuestion(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pre Visit Question </b>Submit button click successfully", "PASS",
						"<b>Pre Visit Question Submit Button </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pre Visit Question </b>Submit button not click successfully", "FAIL",
						"<b>Pre Visit Question Submit Button </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Pre Visit Question Submit Button</b>", "FAIL",
					"<b>Pre Visit Question Submit Button </b>should be submit");
		}
	}

	// Telemedicine Consult
	public String selectFamilyMemberForConsultation(String memberName) {
		WebElement element;
		List<String> memberList;
		try {
			element = Locators.getInstance().selectFamilyMemberForConsultation(driver);
			memberList = Keywords.getSelectOptionList(element);
			//System.out.println("Member List..." + memberList);
			for (int i = 1; i < memberList.size(); i++) {
				if (memberList.get(i).equalsIgnoreCase(memberName)) {
					Keywords.selectByVisibleText(element, memberName);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b> Member Name </b>" + memberName + " successfully select", "PASS",
							"<b>Member Name  </b>" + memberName + " should be select");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Member Name </b>", "FAIL",
					"<b>Member Name  </b>should be select");
		}
		return memberName;
	}

	public void verifyContactNumberForSelectedMember(String memberPhoneNumber) {
		WebElement element;
		try {
			element = Locators.getInstance().memberContactnumber(driver);
			if (Keywords.getTextByJS(ElementEnum.Name.getElementType(), Keywords.getAttributeVal(element, "name"))
					.equalsIgnoreCase(memberPhoneNumber))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Selected Account Member & Family Member Number </b>match successfully", "PASS",
						"<b>Select Account Member & Family Member Number </b>should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Select Account Member & Family Member Number </b>not match successfully", "FAIL",
						"<b>Select Account Member & Family Member Number </b>should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Select Account Member & Family Member Number</b>", "FAIL",
					"<b>Select Account Member & Family Member Number </b>should be matched");
		}
	}

	public String selectPharmacy(String pharmacyName) {
		WebElement element;
		List<String> memberList;
		try {
			element = Locators.getInstance().selectPharmacy(driver);
			memberList = Keywords.getSelectOptionList(element);
			for (int i = 1; i < memberList.size(); i++) {
				if (memberList.get(i).equalsIgnoreCase(pharmacyName)) {
					Keywords.selectByVisibleText(element, pharmacyName);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Name </b>successfully select", "PASS",
							"<b>Pharmacy Name  </b>should be select");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Pharmacy Name </b>", "FAIL",
					"<b>Pharmacy Name  </b>should be select");
		}
		return pharmacyName;
	}

	public boolean pharmacyNotBelongsToYou() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().pharmacyNotBelongsYourState(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public String randomSelectPharmacy() {
		String pharmacyName = "";
		WebElement element;
		List<String> memberList;
		List<WebElement> pharmaciesList;
		List<WebElement> stateList;
		try {
			element = Locators.getInstance().selectPharmacy(driver);
			memberList = Keywords.getSelectOptionList(element);
			for (int i = 1; i < memberList.size(); i++) {
				pharmacyName = memberList.get(i);
				Keywords.selectByVisibleText(element, memberList.get(i));
				if (!pharmacyNotBelongsToYou()) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Name </b>successfully select", "PASS",
							"<b>Pharmacy Name  </b>should be select");
					break;
				}

				if (i == memberList.size() - 1) {
					Keywords.selectByVisibleText(element, memberList.get(i));
					Keywords.explicitWait(2);
					pharmaciesList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
					stateList = Locators.getInstance().stateListFromPharmacyList(driver);
					for (int j = 0; j < pharmaciesList.size(); j++) {
						if (Keywords.getText(stateList.get(j)).equalsIgnoreCase("NY")) {
							pharmacyName = Keywords.getText(pharmaciesList.get(j));
							Keywords.click(pharmaciesList.get(j));
							if (!pharmacyNotBelongsToYou()) {
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Pharmacy Name </b>", "FAIL",
					"<b>Pharmacy Name  </b>should be selected");
		}
		return pharmacyName;
	}

	public void teleMedicinePrimaryInfoNextBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().consultationNextBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>TeleMedicine Text Button </b>successfully clicked", "PASS",
						"<b>TeleMedicine Text Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>TeleMedicine Text Button </b>successfully not clicked", "FAIL",
						"<b>TeleMedicine Text Button </b>should be clicked");
			Keywords.explicitWait(1);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>TeleMedicine Text Button</b>", "FAIL",
					"<b>TeleMedicine Text Button </b>should be clicked");
		}
	}

	public void verifyTelemedicineMsgAndSubmitIt() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().ageVerificationRelatedMessageWindow(driver), 5);
			element = Locators.getInstance().ageVerificationRelatedMessageWindow(driver);
			if (Keywords.getText(element)
					.contains("users under 18 years of age must be accompanied by a parent or guardian")) {
				element = Locators.getInstance().submitAgeVerificationRelatedMessageWindow(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Verify Telemedicine Consultation Msg & submit </b>successfully", "PASS",
						"<b>Verify Telemedicine Consultation Msg </b>should be display & submit");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Telemedicine Consultation Msg & submit </b>not successfully", "FAIL",
						"<b>Verify Telemedicine Consultation Msg </b>should be display & submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while <b>Verify Telemedicine Consultation Msg & submit </b>It", "FAIL",
					"<b>Verify Telemedicine Consultation Msg </b>should be display & submit");
		}
	}

	// Add Photo
	public void verifyAddPhotoHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().addPhotoHeaderTxt(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Photos Header txt </b>successfully display", "PASS",
						"<b>Add Photos Header txt </b> should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Photos Header txt </b>not successfully display", "FAIL",
						"<b>Add Photos Header txt </b> should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Add Photos Header txt</b>It", "FAIL",
					"<b>Add Photos Header txt </b> should be display");
		}
	}

	public boolean photoSizeUploadErrorMessage() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().maximumPhotoUploadLimitError(driver), 20);
			element = Locators.getInstance().maximumPhotoUploadLimitError(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Maximum Upload files size limit are 10 MB </b>successfully display", "PASS",
						"<b>Maximum Upload files size limit are 10 MB </b>msg should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Maximum Upload files size limit are 10 MB </b>not display", "FAIL",
						"<b>Maximum Upload files size limit are 10 MB </b>msg should be display");
		} catch (Exception e) {
		}
		return status;
	}

	public int addPhotos(int uploadPhotoCount, String imagename) {
		int addedPhotoCount = uploadPhotoCount;
		String imageName = imagename;
		String imagePath = null;
		RemoteWebElement element;
		try {
			HealthTribe tribe = new HealthTribe(driver);
			while (addedPhotoCount > 0) {
				if (imageName.length() == 0)
					imageName = tribe.getRandomImage();
				imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
						+ "BWellFiles" + GlobalParam.slash + imageName;
				element = (RemoteWebElement) Locators.getInstance().addPhotoForConsultation(driver);
				element.setFileDetector(new LocalFileDetector());
				Keywords.typeText(element, imagePath);

				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Photo </b>upload successfully", "PASS", "<b>Photo </b>should be upload.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Photo </b>upload successfully", "FAIL", "<b>Photo </b>should be upload.");
				addedPhotoCount = addedPhotoCount - 1;
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the <b>Photo </b>", "PASS", "<b>Photo </b>should be upload.");
		}

		return addedPhotoCount;
	}

	public void submitAddedPhoto() {
		WebElement element;
		try {
			element = Locators.getInstance().consultationNextBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Name </b>successfully select", "PASS", "<b>Pharmacy Name  </b>should be select");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Name </b>successfully select", "FAIL", "<b>Pharmacy Name  </b>should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Pharmacy Name </b>", "FAIL",
					"<b>Pharmacy Name  </b>should be select");
		}
	}

	// T & C
	public void verifyTAndCHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().TAndC(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Condition Header txt </b>successfully display", "PASS",
						"<b>Term & Condition Header txt </b> should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Condition Header txt </b>not successfully display", "FAIL",
						"<b>Term & Condition Header txt </b> should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Term & Condition Header txt</b>It", "FAIL",
					"<b>Term & Condition Header txt </b> should be display");
		}
	}

	public void acceptTAndCCheckBoxes() {
		List<WebElement> cbList;
		List<WebElement> checkedChkList;
		try {
			cbList = Locators.getInstance().acceptTAndCCheckBoxes(driver);
			for (int i = 0; i < cbList.size(); i++)
				Keywords.clickByJS(ElementEnum.ClassName.getElementType(),
						Keywords.getAttributeVal(cbList.get(i), "class"), i);
			Keywords.explicitWait(5);
			checkedChkList = Locators.getInstance().checkboxAcceptedList(driver);
			if (checkedChkList.size() == 3)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Condition Check boxes </b>successfully check", "PASS",
						"<b>Term & Condition Check boxes </b> should be check");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Term & Condition Check boxes </b>not successfully check", "FAIL",
						"<b>Term & Condition Check boxes </b> should be check");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Term & Condition Check Boxes</b>", "FAIL",
					"<b>Term & Condition Check boxes </b> should be check");
		}
	}

	public void submitRequest() {
		WebElement element;
		try {
			element = Locators.getInstance().submitRequest(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Request Button </b>successfully click", "PASS",
						"<b>Submit Request Button </b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Request Button </b>not successfully click", "FAIL",
						"<b>Submit Request Button </b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Submit Request Button</b>It", "FAIL",
					"<b>Submit Request Button </b> should be clicked");
		}
	}

	public void verifyTeleMedicineThankYouMsg() {
		WebElement element;
		try {
			element = Locators.getInstance().teleMedicineThankYouMsg(driver);
			if (Keywords.getText(element)
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("TeleMedicineThankYouMsg")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Msg </b>successfully Displayed", "PASS",
						"<b>Thank You Msg </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Msg </b>successfully not Displayed", "FAIL",
						"<b>Thank You Msg </b>should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Thank You Msg </b>", "FAIL",
					"<b>Thank You Msg </b>should be displayed");
		}
	}

	public void verifyTelaDocPhysicianContactOnThisNumber(String contactNumber) {
		WebElement element;
		try {
			element = Locators.getInstance().telaDocPhysicianContactOnThisNumber(driver);
			if (Keywords.getText(element).equalsIgnoreCase(contactNumber))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Contact Number match </b>successfully with user number", "PASS",
						"<b>Contact Number </b>should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Contact Number not match </b>successfully with user number", "FAIL",
						"<b>Contact Number </b>should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>TelaDoc Physician contact number & user name while doing registration</b>",
					"FAIL", "<b>Contact Number </b>should be matched");
		}
	}

	public void verifyTeleMedicineConfirmationNumber() {
		WebElement elementTxt;
		try {
			Keywords.waitForObject(Locators.getInstance().confirmationNumber(driver), 20);
			elementTxt = Locators.getInstance().confirmationNumber(driver);
			if (Keywords.isElementPresent(elementTxt))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirmation Number </b>successfully generated", "PASS",
						"<b>Confirmation Number </b>should be generated for every TeleMedicine Consult");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirmation Number </b>successfully not generated", "FAIL",
						"<b>Confirmation Number </b>should be generated for every TeleMedicine Consult");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Confirmation Number for every Tele Medicine Consult</b>",
					"FAIL", "<b>Confirmation Number </b>should be generated for every TeleMedicine Consult");
		}
	}

	public void submitTeleMedicineConfirmationPage() {
		WebElement element;
		try {
			element = Locators.getInstance().submitTeleMedicineThankYouPage(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tele Medicine Thank You Page </b>successfully saved", "PASS",
						"<b>Tele Medicine Thank You Page </b> should be saved");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tele Medicine Thank You Page </b>successfully saved", "FAIL",
						"<b>Tele Medicine Thank You Page </b> should be saved");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Tele Medicine Thank You Page</b>", "FAIL",
					"<b>Tele Medicine Thank You Page </b> should be saved");
		}
	}

	// View Authorization
	public HashMap<Boolean, WebElement> viewAuthorizationBtnStatus() {
		boolean status = false;
		WebElement element;
		HashMap<Boolean, WebElement> info = new LinkedHashMap<>();
		try {
			element = Locators.getInstance().viewAuthorizationBtn(driver);
			status = Keywords.isElementPresent(element);
			info.put(status, element);
		} catch (Exception e) {

		}
		return info;
	}

	public void clickOnViewAuthorization() {
		WebElement element;
		try {
			Keywords.explicitWait(3);
			element = Locators.getInstance().viewAuthorizationBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Authorization Btn </b>click successfully", "PASS",
						"<b>View Authorization Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Authorization Btn not </b>click successfully", "FAIL",
						"<b>View Authorization Btn </b>should be clicked");
			Keywords.explicitWait(10);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>View Authorization Btn </b>", "FAIL",
					"<b>View Authorization Btn </b>should be clicked");
		}
	}

	public boolean noMedicalAuthorizationsOnAuthorizationPage() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().noDataInViewAuthorizationPage(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void verifyDoctorNameInViewAuthorization(String doctorName) {
		WebElement element;
		try {
			Keywords.explicitWait(1);
			Keywords.waitForObject(Locators.getInstance().obtainingMedicalRecordsFormHeaderTxt(driver), 20);
			element = Locators.getInstance().getDoctorNameInViewAuthorization(driver, doctorName);
			System.out.println("Doctor Found in view Authorization List..."+element.isDisplayed());
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name </b>inside authorization list", "PASS",
						"<b>Doctor Name </b>should be inside In View Authorization List");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name </b>not found in authorization list", "FAIL",
						"<b>Doctor Name </b>should be inside In View Authorization List");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Doctor Name Inside View Authorization List</b>", "FAIL",
					"<b>Doctor Name </b>should be inside In View Authorization List");
		}
	}

	// Share Authorization
	public String shareAuthorizationFirstName(String shareFName) {
		WebElement element;
		try {
			element = Locators.getInstance().shareAuthorizationFName(driver);
			Keywords.typeText(element, shareFName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization First Name </b>enter successfully", "PASS",
						"<b>Share Authorization First Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization First Name </b>not enter successfully", "FAIL",
						"<b>Share Authorization First Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Share Authorization First Name </b>", "FAIL",
					"<b>Share Authorization First Name </b>should be entered");
		}

		return shareFName;
	}

	public String shareAuthorizationFirstName() {
		return shareAuthorizationFirstName(DriverSession.getTestCaseData().get("FirstName"));
	}

	public String shareAuthorizationLastName(String shareLName) {
		WebElement element;
		try {
			element = Locators.getInstance().shareAuthorizationLName(driver);
			Keywords.typeText(element, shareLName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Last Name </b>enter successfully", "PASS",
						"<b>Share Authorization Last Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Last Name </b>not enter successfully", "FAIL",
						"<b>Share Authorization Last Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Share Authorization Last Name </b>", "FAIL",
					"<b>Share Authorization Last Name </b>should be entered");
		}

		return shareLName;
	}

	public String shareAuthorizationLastName() {
		return shareAuthorizationLastName(DriverSession.getTestCaseData().get("LastName"));
	}

	public String shareAuthorizationRelation(String shareRelation) {
		String relation = shareRelation;
		WebElement element;
		List<String> relationList;
		try {
			relation = DriverSession.getTestCaseData().get("Relation");
			relationList = Arrays.asList(relation.split(","));
			relation = relationList.get(Keywords.getRandomInteger(relationList.size()));
			element = Locators.getInstance().shareAuthorizationRelation(driver);
			Keywords.typeText(element, relation);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Relation </b>enter successfully", "PASS",
						"<b>Share Authorization Relation </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Relation </b>not enter successfully", "FAIL",
						"<b>Share Authorization Relation </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Share Authorization Relation </b>", "FAIL",
					"<b>Share Authorization Relation </b>should be entered");
		}

		return shareRelation;
	}

	public String shareAuthorizationRelation() {
		return shareAuthorizationRelation(DriverSession.getTestCaseData().get("Relation"));
	}

	public String shareAuthorizationEmail(String shareId) {
		String id = "";
		WebElement element;
		try {
			// id = shareId+Keywords.getRandomIntegerBtRange(10000, 99999);
			// shareId = id + "@yopmail.com";
			element = Locators.getInstance().shareAuthorizationEmail(driver);
			Keywords.typeText(element, shareId);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Email </b>enter successfully", "PASS",
						"<b>Share Authorization Email </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Email </b>not enter successfully", "FAIL",
						"<b>Share Authorization Email </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Share Authorization Email </b>", "FAIL",
					"<b>Share Authorization Email </b>should be entered");
		}

		return id;
	}

	public String shareAuthorizationEmail() {
		return shareAuthorizationEmail(DriverSession.getTestCaseData().get("Email"));
	}

	public void clickOnGotItButton() {
		WebElement element;
		try {
			element = Locators.getInstance().finalShareAuthorization(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Got it Button </b>click successfully", "PASS", "<b>Got it Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Got it Button </b>click successfully", "FAIL", "<b>Got it Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Got it Button </b>", "FAIL",
					"<b>Got it Button </b>should be clicked");
		}
	}

	public void finalShareAuthorization() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyConfirmMessageBeforeFinalShare(driver);
			if (Keywords.isElementPresent(element))
				clickOnGotItButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Got it Button </b>", "FAIL",
					"<b>Got it Button </b>should be clicked");
		}
	}

	public List<String> fillShareAuthorizationForm() {
		WebElement element;
		List<String> info = new ArrayList<>();
		try {
			info.add(shareAuthorizationFirstName());
			info.add(shareAuthorizationLastName());
			info.add(shareAuthorizationRelation());
			info.add(shareAuthorizationEmail(DriverSession.getTestCaseData().get("SharedMail")));
			element = Locators.getInstance().submitShareAuthorizationInfo(driver);
			Keywords.click(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public List<String> shareAuthorization() {
		List<String> info = new ArrayList<>();
		WebElement element;
		try {
			element = Locators.getInstance().shareAuthorizationBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().shareAuthorizationHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Share Authorization"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Btn </b>click successfully", "PASS",
						"<b>Share Authorization Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Authorization Btn </b>not click successfully", "FAIL",
						"<b>Share Authorization Btn </b>should be clicked");
			info = fillShareAuthorizationForm();
			finalShareAuthorization();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while final <b>Share Authorization</b>", "FAIL",
					"<b>Final Share Authorization </b>should be done");
		}

		return info;
	}

	public void yesIAmSure() {
		WebElement element;
		try {
			element = Locators.getInstance().yesIAmSureBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Yes, I'm Sure Button </b>click successfully", "PASS",
						"<b>Yes, I'm Sure Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Yes, I'm Sure Button </b>not click successfully", "FAIL",
						"<b>Yes, I'm Sure Button </b>should be clicked");
			//Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Yes, I'm Sure Button </b>", "FAIL",
					"<b>Yes, I'm Sure Button </b>should be clicked");
		}
	}

	public void clickOnRevokeLink() {
		WebElement element;
		try {
			Keywords.explicitWait(5);
			//Keywords.waitForObject(Locators.getInstance().revokeLink(driver), 10);
			element = Locators.getInstance().revokeLink(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Revoke Link </b>click successfully", "PASS", "<b>Revoke Link</b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Revoke Link </b>not click successfully", "FAIL", "<b>Revoke Link</b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Revoke Link </b>", "FAIL",
					"<b>Revoke Link</b>should be clicked");
		}
	}

	public void revoke() {
		WebElement element;
		try {
			clickOnRevokeLink();
			element = Locators.getInstance().revokeHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Are You Sure?")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Revoke Header text </b>display successfully", "PASS",
						"<b>Revoke Header text </b>should be displayed");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>ReAuthorize Btn </b>not click successfully", "FAIL",
						"<b>ReAuthorize Btn </b>should be clicked");
			yesIAmSure();
		} catch (Exception e) {

		}
	}

	public void verifyDoctorInAuthorizationList(String doctorName) {
		WebElement element;
		try {
			//Keywords.refreshPage(driver);
			Keywords.explicitWait(3);
			element = Locators.getInstance().getDoctorNameInAuthorizationList(driver, getDoctorMiddleName(doctorName));
			System.out.println("Doctor " + " Authorized List..." + Keywords.isElementPresent(element));
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor </b>" + doctorName + "<b> Authorized List</b>", "PASS",
						"<b>Doctor </b>" + doctorName + "<b> should in Authorized List</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor </b>" + doctorName + "<b> Not in Authorized List</b>", "FAIL",
						"<b>Doctor </b>" + doctorName + "<b> should in Authorized List</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Doctor </b>" + doctorName + "<b> in Authorized List</b>",
					"FAIL", "<b>Doctor </b>" + doctorName + "<b> should in Authorized List</b>");
		}
	}

	// Re Authorized
	public boolean reauthorizedBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().reAuthorizedBtn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void clickOnReAuthorizedBtn() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().reAuthorizedBtn(driver), 10);
			element = Locators.getInstance().reAuthorizedBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

//			if (revokeElementStatus())
//				DriverSession.getLastExecutionReportingInstance().teststepreporting(
//						"<b>ReAuthorize Btn </b> not click successfully", "FAIL",
//						"<b>ReAuthorize Btn </b>should be clicked");
//			else
//				DriverSession.getLastExecutionReportingInstance().teststepreporting(
//						"<b>ReAuthorize Btn </b>click successfully", "FAIL",
//						"<b>ReAuthorize Btn </b>should be clicked");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>ReAuthorize Btn </b> click successfully", "PASS",
						"<b>ReAuthorize Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>ReAuthorize Btn </b> not click successfully", "FAIL",
						"<b>ReAuthorize Btn </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>ReAuthorize Btn </b>not click successfully", "FAIL",
					"<b>ReAuthorize Btn </b>should be clicked");
		}
	}

	public void Reauthorized(String doctorName) {
		try {
			clickOnReAuthorizedBtn();
			if (!revokeElementStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reauthorized Btn </b>not visible", "PASS", "<b>Reauthorized Btn </b>should not be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Reauthorized Btn </b>visible",
						"FAIL", "<b>Reauthorized Btn </b>should not be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the visibility of <b>Reauthorized Btn </b>", "FAIL",
					"<b>Reauthorized Btn </b>should not be visible");
		}
	}

	public void downloadMedicalRecordsAuthorizationFile() {
		WebElement element;
		try {
			element = Locators.getInstance().navigateToDownloadMedicalRecordsFilePage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Open </b>successfully", "PASS",
						"<b>Medical Records Open </b>should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records </b>not Open successfully", "FAIL",
						"<b>Medical Records Open </b>should be opened");
			Keywords.explicitWait(5);
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			Keywords.explicitWait(2);
			element = Locators.getInstance().downloadFileBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element.sendKeys(Keys.ENTER);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records File </b>download successfully", "PASS",
						"<b>Medical Records File </b>should be download");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records File </b>download successfully", "FAIL",
						"<b>Medical Records File </b>should be download");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while Downloading <b>Medical Records File</b>", "FAIL",
					"<b>Medical Records File </b>should be download");
		}
	}

	public void viewAuthorization(String doctorName) {
		try {
			Keywords.explicitWait(5);
			clickOnViewAuthorization();
			verifyDoctorNameInViewAuthorization(doctorName);
		} catch (Exception e) {
		}
	}

	public List<String> getDoctorListFromViewAuthorization() {
		List<WebElement> doctorList;
		List<String> list = new ArrayList<>();
		try {
			doctorList = Locators.getInstance().getDoctorListInViewAuthorization(driver);
			for (int i = 0; i < doctorList.size(); i++)
				list.add(Keywords.getText(doctorList.get(i)));
		} catch (Exception e) {
		}
		return list;
	}

	public List<String> getDoctorMiddleNameListFromViewAuthorization() {
		List<WebElement> doctorList;
		List<String> list = new ArrayList<>();
		try {
			doctorList = Locators.getInstance().getDoctorListInViewAuthorization(driver);
			for (int i = 0; i < doctorList.size(); i++)
				list.add(getDoctorMiddleName(Keywords.getText(doctorList.get(i))));
		} catch (Exception e) {
		}
		return list;
	}

	
	public boolean revokeElementStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(3);
			element = Locators.getInstance().revokeOnElement(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean authorizationTxtInsideDoctorViewAuthStatus(String doctorName) {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().authorizedTextInsideDrNameInViewAuthorization(driver, doctorName);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean dateInsideDoctorViewAuthStatus(String doctorName) {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().dateInsideDoctorViewAuthorization(driver, doctorName);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void verifyAuthorizedTxtAndDateInsideAuthorizedDoctor(String doctorName) {
		WebElement element;
		try {
			element = Locators.getInstance().getDoctorNameInAuthorizationList(driver, doctorName);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (authorizationTxtInsideDoctorViewAuthStatus(doctorName) && dateInsideDoctorViewAuthStatus(doctorName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Authorization Txt & Date </b>successfully display inside Authorized Doctor", "PASS",
						"<b>Authorization Txt & Date </b>should be inside Authorized Doctor");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Authorization Txt & Date </b>successfully not display inside Authorized Doctor", "FAIL",
						"<b>Authorization Txt & Date </b>should be inside Authorized Doctor");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Authorization Txt & Date </b>inside Authorized Doctor",
					"FAIL", "<b>Authorization Txt & Date </b>should be inside Authorized Doctor");
		}
	}

	public void moveToAuthorizationDetailPage(String doctorName, String operationType) {
		int index = 0;
		WebElement element;
		WebElement reAuthorizedElement;
		List<WebElement> nextBtnList;
		try {
			if (operationType.equalsIgnoreCase("share") || operationType.equalsIgnoreCase("revoke")
					|| operationType.equalsIgnoreCase("downloadfile")) {
				// unAuthorizedDoctorList = Locators.getInstance().getDoctorListWithoutAuthorized(driver);
				index = getDoctorMiddleNameListFromViewAuthorization().indexOf(getDoctorMiddleName(doctorName));//getDoctorListFromViewAuthorization().indexOf(doctorName);
				System.out.println("Index Value.."+index);
				nextBtnList = Locators.getInstance().moveToAuthorizationDetailPage(driver);
				Keywords.click(nextBtnList.get(index));
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 2);
			} else if (operationType.equalsIgnoreCase("reauthorize")) {
				if (Locators.getInstance().getAuthorizedDoctorList(driver).size() <= 0 && !Keywords
						.isElementPresent(Locators.getInstance().getDoctorNameInAuthorizationList(driver, getDoctorMiddleName(doctorName))))
					DriverSession.getLastExecutionReportingInstance().teststepreporting("No Doctor in Authorized List",
							"INFO", "<b>First Add Doctor In Authorized List</b>");
				else {
					// authorizedDoctorList = Locators.getInstance().getAuthorizedDoctorList(driver);
					verifyAuthorizedTxtAndDateInsideAuthorizedDoctor(getDoctorMiddleName(doctorName));
					element = Locators.getInstance().authorizedDoctorNextBtn(driver, getDoctorMiddleName(doctorName));
					Keywords.click(element);
					Keywords.explicitWait(3);
					reAuthorizedElement = Locators.getInstance().reAuthorizedBtn(driver);
					if (revokeElementStatus() && Keywords.isElementPresent(reAuthorizedElement))
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>ReAuthorized Page Display successfully</b>", "PASS",
								"<b>ReAuthorized Page should be Display</b>");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>ReAuthorized Page not Display successfully</b>", "FAIL",
								"<b>ReAuthorized Page should be Display</b>");
				}
			}
			//Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {

		}
	}

	public void viewAuthorizationFromProfile(String doctorName) {
		WebElement element;
		try {
			element = Locators.getInstance().viewAuthorizationBtnOnProfilePage(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Authorization Btn </b>click successfully", "PASS",
						"<b>View Authorization Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Authorization Btn not </b>click successfully", "FAIL",
						"<b>View Authorization Btn </b>should be clicked");
			Keywords.explicitWait(2);
		} catch (Exception e) {

		}
	}

	// Authorized form
	public void navigateToMedicalRecordsEForm() {
		WebElement element;
		try {
			element = Locators.getInstance().medicalRecordBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(5);

			if (verifyMedicalRecordsAuthorizationHeaderTxt())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization Page </b>successfully display", "PASS",
						"<b>Medical Records Authorization Page </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization Page </b>successfully display", "FAIL",
						"<b>Medical Records Authorization Page </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while navigating to the <b>Medical Records Authorization Page</b>", "FAIL",
					"<b>Medical Records Authorization Page </b>should be display");
		}
	}

	public void authorizedHealthInformationEForm(String doctorMiddleName) {
		try {
			verifyDoctorNameOnMedicalRecordAuthorizationPage(
					new MyDoctors(driver).getDoctorMiddleName(doctorMiddleName));
			// verifyDoctorNameOnMedicalRecordAuthorizationPage(doctorMiddleName);
			acceptTermAndConditionForMedicalRecord();
			drawSignature();
			submitMedicalRecordsAuthorizationWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
