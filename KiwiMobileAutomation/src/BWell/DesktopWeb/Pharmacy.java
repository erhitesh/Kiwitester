package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Pharmacy {

	private WebDriver driver;

	public Pharmacy(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToPharmacyPage() {
		try {
			MedicationsAndPharmacies medications = new MedicationsAndPharmacies(driver);
			medications.navigateToMedicationsAndPharmaciesPage();
			medications.selectSubLinksInsideMedicationsAndPharmaciesTab("pharmacy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitSearchTerm() {
		try {
			Keywords.clickByJS(ElementEnum.ClassName.getElementType(), Locators.getInstance().searchButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String searchTerm(String pharmacyName) {
		WebElement element;
		try {
			element = Locators.getInstance().pharmacySearchBox(driver);
			Keywords.typeText(element, pharmacyName);
			submitSearchTerm();
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pharmacyName;
	}

	public String searchPharmacy(String pharmacyName) {
		List<WebElement> searchList;
		try {
			Keywords.waitForPage(driver);
			searchTerm(pharmacyName);
			searchList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
			for (WebElement webElement : searchList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(pharmacyName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy </b>" + pharmacyName + " find successfully", "PASS",
							"<b>Pharmacy </b>" + pharmacyName + " should be found");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Pharmacy " + pharmacyName + " not find successfully", "FAIL",
					"<b>Pharmacy </b>" + pharmacyName + " should be found successfully");
		}

		return pharmacyName;
	}

	public String searchAndSelectPharmacy(String pharmacyName) {
		List<WebElement> searchElementList;
		WebElement element;
		try {
			searchTerm(pharmacyName);
			searchElementList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
			for (WebElement webElement : searchElementList) {
				if (webElement.getText().equalsIgnoreCase(pharmacyName)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Name </b>" + pharmacyName + " click successfully", "PASS",
							"<b>Pharmacy Name </b>" + pharmacyName + " should be clicked");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Name </b>" + pharmacyName + " not click successfully", "FAIL",
							"<b>Pharmacy Name </b>" + pharmacyName + " should be clicked");
			}
			element = Locators.getInstance().verifyPharmacyNameOnPharmacyDetailPage(driver, pharmacyName);
			if (Keywords.getText(element).equalsIgnoreCase(pharmacyName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Detail Page </b> open successfully", "PASS",
						"<b>Pharmacy Detail Page </b>" + "should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Detail Page not open succuessfully</b>", "FAIL",
						"<b>Pharmacy Detail Page </b>" + "should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Pharmacy Name </b>" + pharmacyName
							+ " & verify it on the detail page",
					"FAIL", "<b>Pharmacy Name </b>" + pharmacyName + " should be clicked");
		}

		return pharmacyName;
	}

	public boolean checkHeartIconStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().heartIconWithoutChecked(driver);
			if (Keywords.getAttributeVal(element, "class").contains("favorite-heart-outline"))
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void clickOnAddToFavoriteBtn() {
		WebElement element;
		WebElement heartElement;
		try {
			if (checkHeartIconStatus()) {
				element = Locators.getInstance().addToFavouritePharmacyBtn(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				element = Locators.getInstance().removeFromFavouriteBtnOnPharmacyDetailPage(driver);
				heartElement = Locators.getInstance().heartIcon(driver);
				if (Keywords.isElementPresent(element) && !Keywords.getText(heartElement).contains("heart-icon"))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Heart Icon & Favorite Button </b>status change successfully", "PASS",
							"<b>Heart Icon & Favorite Button </b>status should be changed");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Heart Icon & Favorite Button </b>status not change successfully", "FAIL",
						"<b>Heart Icon & Favorite Button </b>status should be changed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Heart Icon & Favorite Button </b>status", "FAIL",
					"<b>Heart Icon & Favorite Button </b>status should be changed");
		}
	}

	public void addPharmacyToFavoriteForTTDr(String pharmacyName) {
		WebElement element;
		try {
			if (checkHeartIconStatus()) {
				element = Locators.getInstance().heartIconBasedOnPharmacy(driver, pharmacyName);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				element = Locators.getInstance().heartIconBasedOnPharmacy(driver, pharmacyName);
				if (!Keywords.getText(element).contains("favorite-heart-outline"))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Added </b>successfully", "PASS", "<b>Pharmacy </b>should be add");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Added </b>status not change successfully", "FAIL",
						"<b>Pharmacy </b>should be add");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Pharmacy status</b>status", "FAIL",
					"<b>Pharmacy </b>should be add");
		}
	}

	public String randomPharmacyName() {
		String pharmacyName = "";
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
			pharmacyName = Keywords.getText(elementList.get(Keywords.getRandomInteger(elementList.size())));
		} catch (Exception e) {
		}
		return pharmacyName;
	}

	// Filter
	public List<String> getPharmaciesList() {
		List<String> list = new ArrayList<>();
		List<WebElement> pharmaciesList;
		try {
			pharmaciesList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
			for (WebElement webElement : pharmaciesList)
				list.add(Keywords.getText(webElement));
		} catch (Exception e) {
		}
		return list;
	}

	public List<String> getAddedZipCodeList() {
		List<String> zipCodeList = new ArrayList<>();
		List<WebElement> zipCodeElementList;
		try {
			zipCodeElementList = Locators.getInstance().getZipCodeList(driver);
			for (int i = 0; i < zipCodeElementList.size(); i++) {
				zipCodeList.add(Keywords.getText(zipCodeElementList.get(i)));
			}
		} catch (Exception e) {
		}

		return zipCodeList;
	}

	public HashMap<String, String> getPharmacyWithZipCode() {
		HashMap<String, String> info = new LinkedHashMap<>();
		try {
			for (int i = 0; i < getPharmaciesList().size(); i++)
				info.put(getPharmaciesList().get(i), getAddedZipCodeList().get(i));
		} catch (Exception e) {
		}
		System.out.println("PharWithZip.."+info);
		return info;
	}

	public void clickOnNextBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().nextBtnOnPharmacyPage(driver);
			if (Keywords.isElementEnable(element))
				Keywords.click(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnPreviousBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().previousBtnOnPharmacyPage(driver);
			if (Keywords.isElementEnable(element))
				Keywords.click(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPharmacyNameInFavoriteList(String pharmacyName) {
		List<WebElement> pharmaciesList;
		int i = 0;
		int count = 0;
		try {
			pharmaciesList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
			for (i = 0; i < pharmaciesList.size(); i++) {
				count++;
				if (!Keywords.getText(pharmaciesList.get(i)).equalsIgnoreCase(pharmacyName)) {
					if (i == pharmaciesList.size() - 1) {
						clickOnNextBtn();
						i = 0;
						Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
						pharmaciesList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
					}
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Pharmacy Name visible successfully in favorite List</b>", "PASS",
							"<b>Pharmacy Name should be visible in favorite List</b>");
					break;
				}
			}
			// System.out.println("Pharmacy Value found at Page
			// number..."+count);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Pharmacy Name visible successfully in favorite List</b>", "PASS",
					"<b>Pharmacy Name should be visible in favorite List</b>");
		}
	}

	public boolean noPharmaciesInYourAccountStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().noPharmaciesInYourAccount(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void noPharmaciesInYourAccount() {
		WebElement element;
		try {
			if (noPharmaciesInYourAccountStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Pharmacies In Your Account </b>display successfully", "PASS",
						"<b>No Pharmacies In Your Account </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Pharmacies In Your Account </b>not display successfully", "PASS",
						"<b>No Pharmacies In Your Account </b>should be display");
		} catch (Exception e) {

		}
	}

	public void clickOnAddPharmacyBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPharmacyBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(5);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			element = Locators.getInstance().pharmacyHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add a pharmacy"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Add Pharmacy Header text found successfully</b>", "PASS",
						"<b> Add Pharmacy Header text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Add Pharmacy Header text not found successfully</b>", "FAIL",
						"<b> Add Pharmacy Header text </b>should be found");
			//Keywords.acceptAlert(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Add Pharmacy Header text</b>", "FAIL",
					"<b> Add Pharmacy Header text </b>should be found");
		}
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

	public String getStateName(String cityName) {
		HashMap<String, String> stateInfo = new HashMap<>();
		stateInfo.put("New York", "NY");
		stateInfo.put("Denver", "DV");
		stateInfo.put("Los Angeles", "LO");
		stateInfo.put("Boston", "MA");
		stateInfo.put("Austin", "TX");

		return stateInfo.get(cityName);
	}

	public String getZipCode(String cityName) {
		HashMap<String, String> mapList = new LinkedHashMap<>();
		mapList.put("New York", "21108");
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

	public String enterPharmacyName() {
		String pharmacy = "";
		WebElement element;
		try {
			pharmacy = DriverSession.getTestCaseData().get("PharmacyName");
			pharmacy = pharmacy + Keywords.getRandomIntegerBtRange(999, 9999);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyName(driver);
			Keywords.typeText(element, pharmacy);

			if (Keywords.getText(element).equalsIgnoreCase(""))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Pharmacy Name enter successfully</b>", "PASS", "<b> Pharmacy Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Pharmacy Name not enter successfully</b>", "FAIL",
						"<b> Pharmacy Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy Name</b>", "FAIL",
					"<b> Pharmacy Name </b>should be entered");
		}

		return pharmacy;
	}

	public String enterAddressLine1(String cityName) {
		String pharmacyAddress1 = "";
		WebElement element;
		try {
			pharmacyAddress1 = getCountryAddressLine1().get(cityName);// DriverSession.getTestCaseData().get("AddressLine1");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyAddress1(driver);
			Keywords.typeText(element, pharmacyAddress1);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Address Line 1 </b>enter successfully", "PASS",
						"<b>Pharmacy Address Line 1 </b>should be enter successfully");
			else if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Address Line 1 </b>not enter successfully", "FAIL",
						"<b>Pharmacy Address Line 1 </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy Address Line 1 </b>enter successfully", "FAIL",
					"<b>Pharmacy Address Line 1 </b>should be enter successfully");
		}

		return pharmacyAddress1;
	}

	public String enterAddressLine2(String cityName) {
		String pharmacyAddress2 = "";
		WebElement element;
		try {
			pharmacyAddress2 = getCountryAddressLine2().get(cityName);// DriverSession.getTestCaseData().get("PharmacyName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyAddress2(driver);
			Keywords.typeText(element, pharmacyAddress2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Address Line 2 </b>enter successfully", "PASS",
						"<b>Pharmacy Address Line 2 </b>should be enter successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Address Line 2 </b>not enter successfully", "FAIL",
						"<b>Pharmacy Address Line 2 </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy Address Line 2 </b>enter successfully", "FAIL",
					"<b>Pharmacy Address Line 2 </b>should be enter successfully");
		}

		return pharmacyAddress2;
	}

	public String enterCityName(String cityName) {
		WebElement element;
		try {
			// DriverSession.getTestCaseData().get("PharmacyName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyCityName(driver);
			Keywords.typeText(element, cityName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy City </b>enter successfully", "PASS",
						"<b>Pharmacy City </b>should be enter successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy City </b>not enter successfully", "FAIL",
						"<b>Pharmacy City </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy City </b>", "FAIL",
					"<b>Pharmacy City </b>should be enter successfully");
		}

		return cityName;
	}

	public String enterState(String cityName) {
		String pharmacyState = "";
		WebElement element;
		try {
			pharmacyState = getStateName(cityName);// DriverSession.getTestCaseData().get("PharmacyName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyStateName(driver);
			Keywords.typeText(element, pharmacyState);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy State </b>enter successfully", "PASS",
						"<b>Pharmacy state </b>should be enter successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy State </b>not enter successfully", "FAIL",
						"<b>Pharmacy state </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering Pharmacy State </b>", "FAIL",
					"<b>Pharmacy state </b>should be enter successfully");
		}

		return pharmacyState;
	}

	public String enterZipCode(String cityName) {
		String pharmacyZipCode = "";
		WebElement element;
		try {
			pharmacyZipCode = getZipCode(cityName);// DriverSession.getTestCaseData().get("PharmacyName");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyZip(driver);
			Keywords.typeText(element, pharmacyZipCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Zip Code </b>enter successfully", "PASS",
						"<b>Pharmacy Zip Code </b>should be enter successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Zip Code </b>not enter successfully", "FAIL",
						"<b>Pharmacy Zip Code </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy Zip Code </b>", "FAIL",
					"<b>Pharmacy Zip Code </b>should be enter successfully");
		}

		return pharmacyZipCode;
	}

	public String enterPhoneNumber() {
		String pharmacyPhoneNumber = "";
		WebElement element;
		try {
			pharmacyPhoneNumber = DriverSession.getTestCaseData().get("PhoneNumber");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().pharmacyPhoneNumber(driver);
			Keywords.typeText(element, pharmacyPhoneNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Phone Number </b>enter successfully", "PASS",
						"<b>Pharmacy Phone Number </b>should be enter successfully");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Phone Number </b>not enter successfully", "FAIL",
						"<b>Pharmacy Phone Number </b>should be enter successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while entering the Pharmacy Phone Number </b>", "FAIL",
					"<b>Pharmacy Phone Number </b>should be enter successfully");
		}

		return pharmacyPhoneNumber;
	}

	public void submitAddPharmacyPage() {
		WebElement element;
		try {
			element = Locators.getInstance().submitPharmacy(driver);
			if (Keywords.isElementEnable(element)) {
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Page </b>submit successfully", "PASS",
						"<b>Pharmacy Page </b>should be submit successfully");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Page not </b>submit successfully", "FAIL",
						"<b>Pharmacy Page </b>should be submit successfully");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while submitting the Pharmacy Page </b>", "FAIL",
					"<b>Pharmacy Page </b>should be submit successfully");
		}
	}

	public void verifyAddedPharmacyNameOnHeader(String pharmacyName) {
		WebElement element;
		try {
			element = Locators.getInstance().verifyAddedPharmacyAfterSubmitPharmacyInfo(driver, pharmacyName);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy.. " + pharmacyName + "added successfully", "PASS",
						"<b>Pharmacy.. " + pharmacyName + " </b>should be added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy.. " + pharmacyName + "not added successfully", "FAIL",
						"<b>Pharmacy.. " + pharmacyName + " </b>should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Pharmacy.. " + pharmacyName + "added or Not", "FAIL",
					"<b>Pharmacy.. " + pharmacyName + " </b>should be added");
		}
	}

	public void applyFilterOnZipcode(String zipcode) {
		WebElement element;
		try {
			element = Locators.getInstance().pharmacyFilterZipcode(driver);
			Keywords.typeText(element, zipcode);
			Keywords.explicitWait(2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>ZipCode Enter </b>successfully",
						"PASS", "<b>ZipCode Enter </b>should be entered");
			Keywords.explicitWait(2);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occurred while entering <b>ZipCode Enter</b>",
					"FAIL", "<b>ZipCode Enter </b>should be entered");
		}
	}
}
