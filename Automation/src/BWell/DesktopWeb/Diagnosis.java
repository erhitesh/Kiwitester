package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Diagnosis {

	private WebDriver driver;

	public Diagnosis(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddDiagnosisBtn() {
		WebElement element;
		try {
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			element = Locators.getInstance().addDiagnosis(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Diagnosis Plus Icon Button </b>click successfully", "PASS",
						"<b>Add Diagnosis Plus Icon Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Diagnosis Plus Icon Button </b>not click successfully", "FAIL",
						"<b>Add Diagnosis Plus Icon Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Diagnosis Plus Icon Button </b>", "FAIL",
					"<b>Add Diagnosis Plus Icon Button </b>should be clicked");
		}
	}

	public void verifyAddDiagnosisHeaderTxt() {
		WebElement element;
		try {
			element = Locators.getInstance().diagnosisAndSurgeryHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Disease and Surgery Information"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Diagnosis Header Text </b>found successfully", "PASS",
						"<b>Add Diagnosis Header Text </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Diagnosis Header Text </b>not found successfully", "FAIL",
						"<b>Add Diagnosis Header Text </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Add Diagnosis Header Text </b>", "FAIL",
					"<b>Add Diagnosis Header Text </b>should be found");
		}
	}

	public List<String> selectRandomDiseaseListType() {
		List<String> diseaseList = new ArrayList<>();
		List<WebElement> elementList;
		List<Integer> randomNumberList;
		int count = 0;
		try {
			elementList = Locators.getInstance().diseaseList(driver);
			randomNumberList = Keywords.generateRandomUniqueNumber(elementList.size(), 3);
			for (int i = 0; i < elementList.size(); i++) {
				// diseaseList.add(Keywords.getText(elementList.get(randomNumberList.get(i))));
				// Keywords.click(elementList.get(randomNumberList.get(i)));
				// count++;
				// if (count == randomNumberList.size())
				// break;
				Keywords.click(elementList.get(i));
				diseaseList.add(elementList.get(i).getText().trim());
				if (i == 1)
					break;
			}
		} catch (Exception e) {
		}

		return diseaseList;
	}

	public void nextBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().diagnosisNextBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>click successfully", "PASS", "<b>Next Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Button </b>not click successfully", "FAIL", "<b>Next Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Next Button </b>", "FAIL",
					"<b>Next Button </b>should be clicked");
		}
	}

	public void prevBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().diagnosisPreviousBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Button </b>click successfully", "PASS",
						"<b>Previous Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Button </b>not click successfully", "FAIL",
						"<b>Previous Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Previous Button </b>", "FAIL",
					"<b>Previous Button </b>should be clicked");
		}
	}

	public List<String> diseaseList() {
		List<String> list = new ArrayList<>();
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().selectedDiseaseList(driver);
			for (WebElement webElement : elementList)
				list.add(Keywords.getText(webElement));
		} catch (Exception e) {
		}

		return list;
	}

	public boolean errorMessageForInvalidAgeRelatedDisease() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().errorMessageForInvalidAge(driver).get(0);
			if (Keywords.isElementPresent(element))
				status = true;
			else
				status = false;
		} catch (Exception e) {
		}
		return status;
	}

	public HashMap<String, List<String>> selectSubDiaseaseAndAtAge(List<String> diseaseList) {
		WebElement element;
		List<String> subDiseaseList;
		List<String> atAgeList;
		String subDiseaseName = "";
		String age = "";
		List<WebElement> elementAgeList;
		List<String> obj = new ArrayList<>();
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		try {
			for (int i = 0; i < diseaseList.size(); i++) {
				element = Locators.getInstance().selectSubDiseaseOption(driver, diseaseList.get(i));
				subDiseaseList = Keywords.getSelectOptionList(element);
				subDiseaseList.remove(0);
				subDiseaseName = subDiseaseList.get(Keywords.getRandomInteger(subDiseaseList.size()));
				subDiseaseList.clear();
				Keywords.selectByVisibleText(element, subDiseaseName);
//				if (subDiseaseName.equalsIgnoreCase("other")) {
//					element = Locators.getInstance().subDiseaseOtherField(driver);
//					Keywords.typeText(element, Keywords.getRandomAlphabetic(8));
//				}
				elementAgeList = Locators.getInstance().selectDiseaseAtAge(driver);
				atAgeList = Keywords.getSelectOptionList(elementAgeList.get(i));
				atAgeList.remove(0);
				age = atAgeList.get(Keywords.getRandomInteger(atAgeList.size()));
				Keywords.selectByVisibleText(elementAgeList.get(i), age);
				while (errorMessageForInvalidAgeRelatedDisease()) {
					age = atAgeList.get(Keywords.getRandomInteger(atAgeList.size()));
					Keywords.selectByVisibleText(elementAgeList.get(i), age);
				}
				atAgeList.clear();
				obj.add(subDiseaseName);
				obj.add(age);
				info.put(diseaseList().get(i), obj);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sub & Age Of Disease </b>" + subDiseaseName + "," + age + " selected successfully", "PASS",
						"<b>Sub & Age Of Disease </b>should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Sub & Age Of Disease </b>" + subDiseaseName + "," + age + " not selected successfully", "PASS",
					"Exception occurred while selecting the <b> Sub & Age Of Disease </b>" + subDiseaseName + "," + age
							+ " should be selected");
		}

		return info;
	}

	public boolean selecSurgeryOption(boolean status) {
		WebElement element;
		try {
			element = Locators.getInstance().surgeryOption(driver, status);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Surgery option</b> check successfully", "PASS", "<b>Surgery option</b> should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Surgery option</b> not check successfully", "FAIL",
						"<b>Surgery option</b> should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the <b>Surgery option</b>", "FAIL",
					"<b>Surgery option</b> should be checked");
		}

		return status;
	}
	
	public boolean additionalTxtBoxesStatus(int index) {
		boolean status = false;
		List<WebElement> additionalTxtBoxList;
		try {
			additionalTxtBoxList = Locators.getInstance().additionTxtBoxesList(driver);
			status = Keywords.isElementPresent(additionalTxtBoxList.get(index));
		} catch (Exception e) {}
		
		return status;
	}

	public void fillAdditionalTxtBoxes() {
		List<WebElement> additionalTxtBoxList;
		try {
			additionalTxtBoxList = Locators.getInstance().additionTxtBoxesList(driver);
			for (WebElement webElement : additionalTxtBoxList) {
				Keywords.typeText(webElement, Keywords.getRandomAlphabetic(6));
			}
		} catch (Exception e) {}
	}

	public boolean selectValidDate() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().selectValidAge(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void tellUsMoreAboutYourSurgeries(int userAge) {
		int count = 0;
		int validAge = 0;
		String currentYear = "";
		String monthValue = "";
		String yearValue = "";
		List<String> monthValues;
		List<String> yearValues;
		List<WebElement> elementList;
		List<WebElement> monthElementList;
		List<WebElement> yearElementList;
		List<WebElement> additionalTxtBoxList;
		List<Integer> randomNumberList;
		try {
			elementList = Locators.getInstance().diseaseList(driver);
			randomNumberList = Keywords.generateRandomUniqueNumber(elementList.size() - 1, 3);
			for (int i = 0; i < elementList.size(); i++) {
				Keywords.click(elementList.get(randomNumberList.get(i)));
				monthElementList = Locators.getInstance().surgeriesMonthList(driver);
				monthValues = Keywords.getSelectOptionList(monthElementList.get(i));
				monthValues.remove(0);
				monthValue = monthValues.get(Keywords.getRandomInteger(monthValues.size()));
				Keywords.selectByVisibleText(monthElementList.get(i), monthValue);
				monthValues.clear();
				currentYear = Keywords.getCurrentYearValue();
				yearElementList = Locators.getInstance().surgeriesYearList(driver);
				yearValues = Keywords.getSelectOptionList(yearElementList.get(i));
				yearValues.remove(0);
				yearValue = yearValues.get(Keywords.getRandomInteger(yearValues.size()));
				Keywords.selectByVisibleText(yearElementList.get(i), (Integer.parseInt(currentYear)+1)+"");
				validAge = userAge / 2;
				currentYear = (Integer.parseInt(currentYear) - validAge) + "";
				System.out.println("Current Age..."+currentYear);
				if (selectValidDate())
					Keywords.selectByVisibleText(yearElementList.get(i), currentYear);
				yearValues.clear();
				if (additionalTxtBoxesStatus(i)) {
					additionalTxtBoxList = Locators.getInstance().additionTxtBoxesList(driver);
					Keywords.typeText(additionalTxtBoxList.get(i), Keywords.getRandomAlphabetic(5));
				}else {}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tell Us About Your Surgeries </b>check successfully", "PASS",
						"<b>Tell Us About Your Surgeries </b>shoule be checked");
				count++;
				if (count == randomNumberList.size())
					break;
			}
			//fillAdditionalTxtBoxes();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Tell Us About Your Surgeries </b>", "FAIL",
					"<b>Tell Us About Your Surgeries </b>shoule be checked");
		}
	}

	public void submitDiagnosisDetail() {
		WebElement element;
		try {
			element = Locators.getInstance().submitDiagnosisDetail(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis Details Page </b>submit successfully", "PASS",
						"<b>Diagnosis Details Page </b> should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis Details Page </b>not submit successfully", "FAIL",
						"<b>Diagnosis Details Page </b> should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Diagnosis Details Page</b>", "FAIL",
					"<b>Diagnosis Details Page </b> should be submit");
		}
	}

	public void verifyDiagnosisSurveyMessage() {
		WebElement element;
		try {
			element = Locators.getInstance().thankYouSurveyMessage(driver);
			if (Keywords.getText(element).contains("Thank you for completing your health survey."))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis/Surgery Survey Message </b>visible successfully", "PASS",
						"<b>Diagnosis/Surgery Survey Message </b> should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis/Surgery Survey Message </b>not visible successfully", "FAIL",
						"<b>Diagnosis/Surgery Survey Message </b> should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Diagnosis/Surgery Survey Message</b>", "FAIL",
					"<b>Diagnosis/Surgery Survey Message </b> should be present");
		}
	}

	public void hideDiagnosisSurveyPopupWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().hideSurveyThankYouPopup(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis Survey Page </b>hide successfully", "PASS",
						"<b>Diagnosis Survey Page </b> should be hide");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Diagnosis Survey Page </b>not submit successfully", "FAIL",
						"<b>Diagnosis Survey Page </b> should be hide");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while hiding <b>Diagnosis Survey Page</b>", "FAIL",
					"<b>Diagnosis Survey Page </b> should be hide");
		}
	}
}
