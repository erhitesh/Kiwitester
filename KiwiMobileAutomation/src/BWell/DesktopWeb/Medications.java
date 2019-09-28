package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class Medications {

	private WebDriver driver;

	public Medications(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToMedicationPage() {
		try {
			MedicationsAndPharmacies medications = new MedicationsAndPharmacies(driver);
			medications.navigateToMedicationsAndPharmaciesPage();
			medications.selectSubLinksInsideMedicationsAndPharmaciesTab("medications");
			Keywords.explicitWait(3);
		} catch (Exception e) {
		}
	}

	public void navigateToPriceComparisionPage() {
		try {
			MedicationsAndPharmacies medications = new MedicationsAndPharmacies(driver);
			medications.navigateToMedicationsAndPharmaciesPage();
			medications.selectSubLinksInsideMedicationsAndPharmaciesTab("pricing");
		} catch (Exception e) {
		}
	}

	public void clickOnAddMedicationFromClinical() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addMedicationFromClinical(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medications Button</b> successfully click", "PASS",
						"<b>Add Medications Button</b> should be click.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medications Button</b> successfully not click", "FAIL",
						"<b>Add Medications Button</b> should be click.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Add Medications Button</b>", "FAIL",
					"<b>Add Medications Button</b> should be click.");
		}
	}

	public void clickOnAddMedicationBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addMedicationBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medications Button</b> successfully click", "PASS",
						"<b>Add Medications Button</b> should be click.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medications Button</b> successfully not click", "FAIL",
						"<b>Add Medications Button</b> should be click.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Add Medications Button</b>", "FAIL",
					"<b>Add Medications Button</b> should be click.");
		}
	}

	public void verifyAddMedicationHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			// Keywords.waitForObject(Locators.getInstance().addMedicationHeaderTxt(driver),
			// 20);
			element = Locators.getInstance().addMedicationHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add Medication"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Add Medication</b> Header text match successfully", "PASS",
						"<b> Add Medication</b> Header text should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b> Add Medication</b> Header text not match", "FAIL",
						"<b> Add Medication</b> Header text should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b> Add Medication</b> Header text", "FAIL",
					"<b> Add Medication</b> Header text should be matched");
		}
	}

	public String selectMedicationType(String medicationType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableMedicationTypeOption(driver);
			Keywords.click(element);
			element = Locators.getInstance().selectMedicationTypeValue(driver, medicationType);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medication Type </b>" + medicationType + "select successfully", "PASS",
						"<b>Medication Type </b>" + medicationType + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medication Type </b>" + medicationType + "select successfully", "FAIL",
						"<b>Medication Type </b>" + medicationType + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exce<b>Medication Type </b>" + medicationType + "select successfully", "FAIL",
					"<b>Medication Type </b>" + medicationType + " should be selected");
		}

		return medicationType;
	}

	public String getRandomDrugShortName(String medicationType) {
		List<String> pre = new ArrayList<>();
		// List<String> otc = new ArrayList<>();
		int randomNumber = 0;
		if (medicationType.equalsIgnoreCase("pre")) {
			pre.add("Xan");
			pre.add("Ear");
			pre.add("Darby");
			pre.add("Dextro");
			pre.add("Black");
			pre.add("CitraNatal");
			pre.add("Bacitracin");
			randomNumber = Keywords.getRandomInteger(pre.size());
		} else {
			// otc.add("AmeriDerm");
			// otc.add("Degre");
			// otc.add("Axe");
			// otc.add("Cactus");
			pre.add("AmeriDerm");
			pre.add("Degre");
			pre.add("Axe");
			pre.add("Cactus");

			randomNumber = Keywords.getRandomInteger(pre.size());
		}
		return pre.get(randomNumber);
	}

	public String enterDrugName(String medicationType) {
		List<WebElement> drugList;
		WebElement element;
		String drugName = "";
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableDragNameOption(driver);
			Keywords.click(element);
			// Keywords.waitForObjectToInvisible(element, 20);
			Keywords.waitForObject(Locators.getInstance().searchDragName(driver), 20);
			element = Locators.getInstance().searchDragName(driver);
			drugName = getRandomDrugShortName(medicationType);
			Keywords.typeText(element, drugName);
			drugList = Locators.getInstance().drugList(driver);
			randomNumber = Keywords.getRandomInteger(drugList.size());
			drugName = Keywords.getText(drugList.get(randomNumber));
			Keywords.click(drugList.get(randomNumber));
			element = Locators.getInstance().verifySelectedDrugValue(driver, drugName);
			if (Keywords.getText(element).trim().equalsIgnoreCase(drugName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Name </b>" + drugName + " enter successfully", "PASS",
						"<b>Drug Name </b>" + drugName + " <b> should be entered</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Name </b>" + drugName + " not enter successfully", "FAIL",
						"<b>Drug Name </b>" + drugName + " <b> should be entered</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enetring & verify selecting value from search list <b>Drug Name </b>"
							+ drugName,
					"FAIL", "<b>Drug Name </b>" + drugName + " <b> should be entered</b>");
		}

		return drugName;
	}

	public String enterDrugDosage(String drugName) {
		String drugDosage = "";
		int randomNumber = 0;
		WebElement element;
		List<WebElement> dosageList;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableDosageOption(driver);
			Keywords.click(element);
			Keywords.waitForObjectToInvisible(element, 20);
			Locators.getInstance().verifyDrugDosageWindowOpen(driver, drugName);
			dosageList = Locators.getInstance().drugDosageList(driver);
			randomNumber = Keywords.getRandomInteger(dosageList.size());
			drugDosage = Keywords.getText(dosageList.get(randomNumber));
			Keywords.click(dosageList.get(randomNumber));
			element = Locators.getInstance().verifySelectDrugDosageValue(driver, drugDosage);
			if (Keywords.getText(element).equalsIgnoreCase(drugDosage))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Dosage </b>" + drugDosage + " <b> value selected successfully", "PASS",
						"<b>Drug Dosage </b>" + drugDosage + " <b> value should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Dosage </b>" + drugDosage + " <b> not value selected successfully", "FAIL",
						"<b>Drug Dosage </b>" + drugDosage + " <b> value should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the selected value from search list", "FAIL",
					"<b>Drug Dosage </b>" + drugDosage + " <b> value should be selected</b>");
		}

		return drugDosage;
	}

	public String enterDrugQuantity() {
		WebElement element;
		String quantity = Keywords.getRandomInteger(10) + 1 + "";
		try {
			element = Locators.getInstance().drugQuantity(driver);
			Keywords.typeText(element, quantity);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Quantity</b> " + quantity + " enter successfully", "PASS",
						"<b>Drug Quantity</b> " + quantity + " should be entered.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Quantity</b> " + quantity + " not enter successfully", "FAIL",
						"<b>Drug Quantity</b> " + quantity + " should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Drug Quantity</b> " + quantity, "FAIL",
					"<b>Drug Quantity</b> " + quantity + " should be entered.");
		}

		return quantity;
	}

	public String drugInstruction() {
		WebElement element;
		String instruction = "Testing";
		try {
			element = Locators.getInstance().drugInstructions(driver);
			Keywords.typeText(element, instruction);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Instruction</b> " + instruction + " enter successfully", "PASS",
						"<b>Drug Instruction</b> " + instruction + " should be entered.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Instruction</b> " + instruction + " not enter successfully", "FAIL",
						"<b>Drug Instruction</b> " + instruction + " should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Drug Instruction</b> " + instruction, "FAIL",
					"<b>Drug Instruction</b> " + instruction + " should be entered.");
		}
		return instruction;
	}

	public List<String> selectDrugRelatedCondition() {
		List<String> condition = new ArrayList<>();
		List<WebElement> conditionList;
		WebElement element;
		int randomNumber = 0;
		try {
			element = Locators.getInstance().enableRelatedConditionOption(driver);
			Keywords.click(element);
			conditionList = Locators.getInstance().relatedConditionList(driver);
			randomNumber = Keywords.getRandomInteger(conditionList.size());
			condition.add(Keywords.getText(conditionList.get(randomNumber)));
			Keywords.click(conditionList.get(randomNumber));
			element = Locators.getInstance().enableRelatedConditionOption(driver);
			Keywords.click(element);
			element = Locators.getInstance().verifySelectedRelatedConditions(driver, condition);
			if (Keywords.getText(element).contains(condition.get(0)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Related Condition </b> " + condition + " enter successfully", "PASS",
						"<b>Drug Related Condition </b> " + condition + " should be entered.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Related Condition </b> " + condition + " not enter successfully", "FAIL",
						"<b>Drug Related Condition </b> " + condition + " should be entered.");
			Keywords.explicitWait(3);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Drug Related Condition </b> " + condition
							+ " from condition List",
					"FAIL", "<b>Drug Related Condition </b> " + condition + " should be entered.");
		}

		return condition;
	}

	public String getRandomDoctorShortName() {
		List<String> doctorList = new ArrayList<>();
		doctorList.add("bwell");
		// doctorList.add("kiwi");
		// doctorList.add("tester");
		// doctorList.add("abc");
		// doctorList.add("jonhy");

		return doctorList.get(Keywords.getRandomInteger(doctorList.size()));
	}

	public void searchDoctorWithWrongData(String wrongkeyword) {
		WebElement element;
		List<WebElement> doctorList;
		try {
			element = Locators.getInstance().searchDoctorName(driver);
			Keywords.typeText(element, wrongkeyword);
			doctorList = Locators.getInstance().doctorListOnSearch(driver);
			if (doctorList.size()>0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name List </b>successfully Display", "BUG",
						"<b>Doctor Name List </b>should not be displayed");
			else{}
			Keywords.explicitWait(2);
		} catch (Exception e) {
		}
	}

	public List<String> prescriptionDoctor() {
		String wrongKeyword = "----";// "++++"
		String doctorName = "";
		WebElement element;
		int randomNumber = 0;
		String cityName = "";
		List<String> docInfo = new ArrayList<>();
		List<WebElement> doctorList;
		try {
			MyDoctors myDoctor = new MyDoctors(driver);
			searchDoctorWithWrongData(wrongKeyword);
			element = Locators.getInstance().searchDoctorName(driver);
			doctorName = "Jon";// getRandomDoctorShortName();//
			Keywords.typeText(element, doctorName);
			doctorList = Locators.getInstance().doctorListOnSearch(driver);
			if (doctorList.size() <= 0) {
				element = Locators.getInstance().clickOnAddDoctorFromMedication(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				doctorName = "Dr " + myDoctor.enterDoctorFirstName();
				doctorName = doctorName + " " + myDoctor.enterDoctorLastName();
				docInfo.add(doctorName);
				docInfo.add("yes");
				myDoctor.selectDoctorSpeciality();
				myDoctor.enterPracticeName();
				myDoctor.enterDoctorPhoneNumber();
				cityName = myDoctor.enterDoctorCityName();
				myDoctor.enterDoctorAddressLine1(cityName);
				myDoctor.enterDoctorAddressLine2(cityName);
				myDoctor.enterDoctorState();
				myDoctor.enterZipCode(cityName);
				myDoctor.submitRegistrationForm();
			} else {
				randomNumber = Keywords.getRandomInteger(doctorList.size());
				doctorName = Keywords.getText(doctorList.get(randomNumber));
				docInfo.add(doctorName);
				docInfo.add("no");
				Keywords.click(doctorList.get(randomNumber));
			}
			element = Locators.getInstance().searchDoctorName(driver);
			if (Keywords.getAttributeVal(element, "value").equalsIgnoreCase(doctorName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name </b>" + doctorName + " selected/added successfully", "PASS",
						"<b>Doctor Name </b>" + doctorName + " should be selected/Added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Doctor Name </b>" + doctorName + " not selected/added successfully", "FAIL",
						"<b>Doctor Name </b>" + doctorName + " should be selected/Added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting/adding <b>Doctor Name </b>" + doctorName, "FAIL",
					"<b>Doctor Name </b>" + doctorName + " should be selected/Added");
		}

		return docInfo;
	}

	public String selectPrescribedDate() {
		String date = "";
		int day = 0;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enablePrescribedDate(driver);
			Keywords.click(element);
			element = Locators.getInstance().selectPrescribedDate(driver);
			day = Integer.parseInt(Keywords.getCurrentDate("dd")) - 1;
			date = Keywords.getCurrentDate("MM/" + (day) + "/yyyy");
			Keywords.click(element);
			element = Locators.getInstance().enablePrescribedDate(driver);
			if (Keywords.getAttributeVal(element, "value").equalsIgnoreCase(date))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Prescribed Date </b>" + date + " selected successfully", "PASS",
						"<b>Prescribed Date </b>" + date + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Prescribed Date </b>" + date + " not selected successfully", "FAIL",
						"<b>Prescribed Date </b>" + date + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Prescribed Date </b>" + date, "FAIL",
					"<b>Prescribed Date </b>" + date + " should be selected");
		}
		return date;
	}

	public String selectLastRefillDate() {
		String date = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableLastRefillDate(driver);
			Keywords.click(element);
			element = Locators.getInstance().selectPrescribeAndRefillDate(driver);
			date = Keywords.getCurrentDate("MM/dd/yyyy");
			Keywords.click(element);
			element = Locators.getInstance().enableLastRefillDate(driver);
			if (Keywords.getAttributeVal(element, "value").equalsIgnoreCase(date))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Last Refill Date </b>" + date + " selected successfully", "PASS",
						"<b>Last Refill Date </b>" + date + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Last Refill Date </b>" + date + " selected successfully", "FAIL",
						"<b>Last Refill Date </b>" + date + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Last Refill Date </b>" + date, "FAIL",
					"<b>Last Refill Date </b>" + date + " should be selected");
		}
		return date;
	}

	public String selectRefillRemaining() {
		String refill = "";
		WebElement element;
		int randomNumber = 0;
		List<WebElement> refillList;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableRefillsRemaining(driver);
			Keywords.click(element);
			refillList = Locators.getInstance().refillRemainingList(driver);
			randomNumber = Keywords.getRandomInteger(refillList.size());
			refill = Keywords.getText(refillList.get(randomNumber));
			Keywords.click(refillList.get(randomNumber));
			element = Locators.getInstance().verifySelectRefillRemainingValue(driver, refill);
			if (Keywords.getText(element).equalsIgnoreCase(refill))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refill Remaining </b>" + refill + " selected successfully", "PASS",
						"<b>Refill Remaining </b>" + refill + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refill Remaining </b>" + refill + " not selected successfully", "FAIL",
						"<b>Refill Remaining </b>" + refill + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Refill Remaining </b>" + refill, "FAIL",
					"<b>Refill Remaining </b>" + refill + " should be selected");
		}

		return refill;
	}

	public String rxNumber() {
		WebElement element;
		String rxNum = "";
		try {
			rxNum = Keywords.getRandomRXNumber(8);
			element = Locators.getInstance().enterRxNumber(driver);
			Keywords.typeText(element, rxNum);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug RX Number </b> " + rxNum + " enter successfully", "PASS",
						"<b>Drug RX Number </b> " + rxNum + " should be entered.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug RX Number </b> " + rxNum + " not enter successfully", "FAIL",
						"<b>Drug RX Number </b> " + rxNum + " should be entered.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Drug RX Number </b> " + rxNum, "FAIL",
					"<b>Drug RX Number </b> " + rxNum + " should be entered.");
		}
		return rxNum;
	}

	public String pharmacyChoice() {
		List<String> list = new ArrayList<>();
		list.add("Other");
		list.add("fromlist");

		return list.get(Keywords.getRandomInteger(list.size()));
	}

	public String selectPharmacy(/* String pharmactSelectionChoice */) {
		int pharmacyIndexNumber = 0;
		String pharmacyName = "";
		WebElement element;
		List<WebElement> pharmacyList;
		String pharmacySelectionChoice = pharmacyChoice();
		try {
			element = Locators.getInstance().enablePharmacyOption(driver);
			Keywords.click(element);
			pharmacyList = Locators.getInstance().pharmaciesList(driver);
			if (pharmacySelectionChoice.equalsIgnoreCase("other")) {
				for (WebElement ele : pharmacyList) {
					if (Keywords.getText(ele).equalsIgnoreCase(pharmacySelectionChoice)) {
						Keywords.click(ele);
						break;
					}
				}
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				element = Locators.getInstance().pharmacySearchHeaderTxt(driver);
				pharmacyList = Locators.getInstance().pharmaciesListOnPharmaciesPage(driver);
				pharmacyIndexNumber = Keywords.getRandomInteger(pharmacyList.size());
				pharmacyName = Keywords.getText(pharmacyList.get(pharmacyIndexNumber));
				Keywords.click(pharmacyList.get(pharmacyIndexNumber));

			} else {
				pharmacyIndexNumber = Keywords.getRandomInteger(pharmacyList.size() - 1);
				pharmacyName = Keywords.getText(pharmacyList.get(pharmacyIndexNumber));
				Keywords.click(pharmacyList.get(pharmacyIndexNumber));
			}
			element = Locators.getInstance().verifySelectedPharmacyName(driver, pharmacyName);
			if (Keywords.getText(element).equalsIgnoreCase(pharmacyName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Name </b>" + pharmacyName + " select successfully", "PASS",
						"<b>Pharmacy Name </b>" + pharmacyName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Pharmacy Name </b>" + pharmacyName + " not select successfully", "FAIL",
						"<b>Pharmacy Name </b>" + pharmacyName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting & verifing the <b>Pharmacy Name </b>" + pharmacyName, "FAIL",
					"<b>Pharmacy Name </b>" + pharmacyName + " should be selected");
		}

		return pharmacyName;
	}

	public String getDrugImageRandomName() {
		List<String> druglist = new ArrayList<>();
		druglist.add("DrugImage1.jpg");
		druglist.add("DrugImage2.jpg");
		druglist.add("DrugImage3.jpg");
		druglist.add("DrugImage4.jpg");

		return druglist.get(Keywords.getRandomInteger(druglist.size()));
	}

	public void addPhoto() {
		RemoteWebElement element;
		String imageName = getDrugImageRandomName();
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().addPhoto(driver);
			element.setFileDetector(new LocalFileDetector());
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "BWellFiles" + GlobalParam.slash + imageName;
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Image </b>added successfully", "PASS", "<b>Drug Image </b>should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Drug Image </b>" + "not added successfully", "FAIL",
						"<b>Drug Image </b>" + "should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading <b>Drug Image </b>", "FAIL",
					"<b>Drug Image </b>" + "should be upload");
		}
	}

	public void submitAddMedicationWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitAddMedication(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medication </b>" + "click successfully", "PASS",
						"<b>Add Medication </b>" + "button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Medication </b>" + "not click successfully", "FAIL",
						"<b>Add Medication </b>" + "button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Medication Button</b>", "FAIL",
					"<b>Add Medication </b>" + "button should be clicked");
		}
	}

	// >>>>>>>>>>>>>>. Verify Medication On Medication Detail page.
	public void selectDrugNameBySearch(String drugName) {
		WebElement element;
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().searchBoxOnMedicationPage(driver);
			Keywords.typeText(element, drugName);
			elementList = Locators.getInstance().prescriptionNameList(driver);
			for (WebElement webElement : elementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(drugName)) {
					Keywords.click(webElement);
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Drug Name </b>" + drugName + " find successfully", "PASS",
							"<b>Drug Name </b>" + drugName + " <b> should be found</b>");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Drug Name </b>" + drugName + " not find successfully", "FAIL",
					"<b>Drug Name </b>" + drugName + " <b> should be found</b>");
		}
	}

	public void clickOnMedicationDetailBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().medicationDetailBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			Keywords.waitForObject(Locators.getInstance().editMedicationBtn(driver), 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medication Detail Button </b>click successfully", "PASS",
						"<b>Medication Detail Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medication Detail Button </b> not click successfully", "FAIL",
						"<b>Medication Detail Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Medication Detail Button </b>", "FAIL",
					"<b>Medication Detail Button</b> should be clicked");
		}
	}

	public void enableDisableActiveMedications(boolean value) {
		WebElement element;
		String attributeValue = "";
		try {
			element = Locators.getInstance().activeMedications(driver);
			attributeValue = Keywords.getAttributeVal(element, "class");
			if (attributeValue.contains("down") && value == true) {
				Keywords.click(element);
			} else if (attributeValue.contains("up") && value == false)
				Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void enableDisableHistoricalMedications(boolean value) {
		WebElement element;
		String attributeValue = "";
		try {
			element = Locators.getInstance().historicalMedications(driver);
			attributeValue = Keywords.getAttributeVal(element, "class");
			if (attributeValue.contains("down") && value == true) {
				Keywords.click(element);
			} else if (attributeValue.contains("up") && value == false)
				Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void verifyDrugDeletedSuccessfully(String drugName) {
		WebElement element;
		try {
			element = Locators.getInstance().noResultOnSearch(driver);
			if (Keywords.getText(element).contains("No Results Found."))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Drug Name </b> not present",
						"PASS", "<b>Drug Name </b> should not visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Drug Name </b> present", "FAIL",
						"<b>Drug Name </b> should not visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify drug name by search <b>Drug Name </b>", "FAIL",
					"<b>Drug Name </b> should not visible");
		}
	}

	public void verifyMedicationPerTermAsPre() {
		List<WebElement> elementPreTerm;
		try {
			elementPreTerm = Locators.getInstance().medicationTermNameList(driver);
			for (WebElement webElement : elementPreTerm) {
				if (Keywords.getText(webElement).equalsIgnoreCase("per")) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Medication PER </b>term name found", "FAIL",
							"<b>Medication PER </b>term should not be found");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify <b>Medication PER </b>term name", "FAIL",
					"<b>Medication PER </b>term should not be found");
		}
	}

	public void clickOnRemoveMedicationBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().removeMedicationButtomBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Medication Button </b>click successfully", "PASS",
						"<b>Remove Medication Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Medication Button </b>not click successfully", "FAIL",
						"<b>Remove Medication Button </b> should be clicked");
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			element = Locators.getInstance().confirmMessageBeforeDeleteMedication(driver);
			if (Keywords.getText(element).contains("Are you sure you want to")) {
				element = Locators.getInstance().submitDrugDeleteAlertWindow(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirmation messgae before delete the medication </b>appear successfully", "PASS",
						"<b>Medication drug deletion window should be submit</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Confirmation messgae before delete the medication </b>not appear successfully", "FAIL",
						"<b>Medication drug deletion window should be submit</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b> Medication window for drug deletion</b>", "FAIL",
					"<b>Medication drug deletion window should be submit</b>");
		}
	}

	public String getPrescriptionName() {
		String name = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().prescribeNameOnDetailPage(driver);
			name = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}

	public String getPrescriptionDosage() {
		String drugDosage = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getDrugDosageFromDetailPage(driver);
			drugDosage = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drugDosage;
	}

	public String getPrescriptionQuantity() {
		String drugQuantity = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getDrugQuantityFromDetailPage(driver);
			drugQuantity = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drugQuantity;
	}

	public String getPrescriberName() {
		String prescriberName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPrescriberFromDetailPage(driver);
			prescriberName = Keywords.getText(element);
			prescriberName = prescriberName.substring(prescriberName.indexOf(":") + 2, prescriberName.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prescriberName;
	}

	public String getRXNumber() {
		String rxNumber = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getRxNumber(driver);
			rxNumber = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rxNumber;
	}

	public String getRefillRemaining() {
		String refillRemaining = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getRefillRemaining(driver);
			refillRemaining = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return refillRemaining;
	}

	public void submitSearch() {
		WebElement element;
		try {
			element = Locators.getInstance().searchButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search Button </b>click successfully", "PASS", "<b>Search Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search Button </b>not click successfully", "FAIL",
						"<b>Search Button </b>should be clicked");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 15);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Search Button </b>", "FAIL",
					"<b>Search Button </b>should be clicked");
		}
	}

	public String getRandomMedicine() {
		String medicine = "";
		List<String> list = new ArrayList<>();
		try {
			medicine = "Zaditor,Xanon,Xarelto,Vagifem,Effer-K,Xanax,Fexmid,Cardizem CD,Yondelis vial,Vibisone";
			list = Arrays.asList(medicine.split(","));
			medicine = list.get(Keywords.getRandomInteger(list.size()));
		} catch (Exception e) {
		}

		return medicine;
	}

	// Medication Filter
	public List<String> getAddedDrugList() {
		List<String> drugList = new ArrayList<>();
		List<WebElement> drugElementList;
		try {
			drugElementList = Locators.getInstance().getDrugList(driver);
			for (int i = 0; i < drugElementList.size(); i++) {
				drugList.add(Keywords.getText(drugElementList.get(i)));
			}
		} catch (Exception e) {
		}

		return drugList;
	}

	public void applyFilterOnMedication(String medicineName) {
		WebElement element;
		List<WebElement> selectMedicationElementList;
		try {
			element = Locators.getInstance().enableSelectMedicationDropdownList(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			selectMedicationElementList = Locators.getInstance().getDrugListFromSelectMedicationDropDown(driver);
			for (int i = 0; i < selectMedicationElementList.size(); i++) {
				if (medicineName.equalsIgnoreCase(Keywords.getText(selectMedicationElementList.get(i)))) {
					Keywords.click(selectMedicationElementList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Drug Name from Medication Drop Down </b>select successfully", "PASS",
							"<b>Drug Name from Medication Drop Down</b>should be selected");
					Keywords.explicitWait(2);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Drug Name from Medication Drop Down </b>", "FAIL",
					"<b>Drug Name from Medication Drop Down</b>should be selected");
		}
	}

	// price Comparision
	public void searchMedicine(String medicineName) {
		WebElement element;
		try {
			element = Locators.getInstance().searchTxtBox(driver);
			Keywords.typeText(element, medicineName);
			submitSearch();
		} catch (Exception e) {

		}
	}

	public List<String> getMedicinePharmaciesList() {
		List<String> list = new ArrayList<>();
		List<WebElement> pharmaciesList;
		try {
			pharmaciesList = Locators.getInstance().getMedicinePharmaciesList(driver);
			for (int i = 0; i < pharmaciesList.size(); i++)
				list.add(Keywords.getText(pharmaciesList.get(i)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<String> getMedicinePriceList() {
		List<String> list = new ArrayList<>();
		List<WebElement> priceList;
		try {
			Keywords.waitForObject(Locators.getInstance().warningMessageOnMedicinePricePage(driver), 20);
			priceList = Locators.getInstance().getMedicinePriceList(driver);
			for (int i = 0; i < priceList.size(); i++)
				list.add(Keywords.getText(priceList.get(i)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void verifyMedicinePriceOrder() {
		try {
			List<String> list = getMedicinePriceList();
			if ((Float.parseFloat(list.get(list.size() - list.size())) <= Float
					.parseFloat(list.get(list.size() - (list.size() - 1)))
					&& Float.parseFloat(list.get(list.size() - (list.size() - 1))) <= Float
							.parseFloat(list.get(list.size() - (list.size() - 2)))))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medicine Price Order </b>in Descending order", "PASS",
						"<b>Medicine Price Order </b>Should be in Descending order");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medicine Price Order </b>not in Descending order", "BUG",
						"<b>Medicine Price Order </b>Should be in Descending order");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Medicine Price Order </b>", "FAIL",
					"<b>Medicine Price Order </b>Should be in Descending order");
		}
	}

}
