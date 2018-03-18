package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Filter {

	private WebDriver driver;

	public Filter(WebDriver driver) {
		this.driver = driver;
	}

	public void enableFilterType() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterByTypeValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Type</b> Value visible successfully", "PASS",
						"<b>Filter By Type should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Type</b> Value not visible successfully", "FAIL",
						"<b>Filter By Type should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Type</b> Value", "FAIL",
					"<b>Filter By Type should be visible</b>");
		}
	}

	public List<String> getTypeListFromFilterDropDown() {
		List<String> typeList = new ArrayList<String>();
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterTypeValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				typeList.add(Keywords.getText(elementList.get(i)));
			}

		} catch (Exception e) {

		}
		return typeList;
	}

	public void selectFilterTypeValues(String typeValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterTypeValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(typeValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(2000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Type Values selected successfully</b>", "PASS",
						"<b>Filter Type Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Type Values not selected successfully</b>", "FAIL",
						"<b>Filter Type Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Type Values</b>", "FAIL",
					"<b>Filter Type Values should be selected</b>");
		}

		// return filterType;
	}

	public void enableFilterStatus() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterByStatusValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Status</b> Value visible successfully", "PASS",
						"<b>Filter By Status should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Status</b> Value not visible successfully", "FAIL",
						"<b>Filter By Status should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Status</b> Value", "FAIL",
					"<b>Filter By Status should be visible</b>");
		}
	}

	public List<String> getStatusListFromFilterDropDown() {
		List<String> statusList = new ArrayList<String>();
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterStatusValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				statusList.add(Keywords.getText(elementList.get(i)));
			}

		} catch (Exception e) {

		}
		return statusList;
	}

	public void selectFilterStatusValues(String statusValue) {
		List<WebElement> elementList;
		// LinkedHashSet<String> statusList;
		// String filterStatus = "";
		// int randomNumber = 0;
		int indexValue = 0;
		try {
			// Allergy allergy = new
			// Allergy(DriverSession.getLastExecutionDriver());
			// statusList = allergy.getAllergiesUniqueStatusList();
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterStatusValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(statusValue)) {
					Keywords.click(elementList.get(i));
					break;
				}
			}
			// if (elementList.contains(statusValue)) {
			// indexValue = elementList.indexOf(statusValue);
			// Keywords.click(elementList.get(indexValue));
			// }
			// randomNumber = Keywords.getRandomInteger(elementList.size() - 1);
			// filterStatus = Keywords.getText(elementList.get(randomNumber));
			// if (!statusList.contains(filterStatus)) {
			// if (randomNumber == elementList.size()-1)
			// randomNumber--;
			// else
			// randomNumber++;
			// filterStatus = Keywords.getText(elementList.get(randomNumber));
			// }
			// else{
			// Keywords.click(elementList.get(randomNumber));
			// }

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Status Values selected successfully</b>", "PASS",
						"<b>Filter Status Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Status Values not selected successfully</b>", "FAIL",
						"<b>Filter Status Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Status Values</b>", "FAIL",
					"<b>Filter Status Values should be selected</b>");
		}

		// return filterStatus;
	}

	public void enableFilterSeverity() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterBySeverityValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Severity</b> Value visible successfully", "PASS",
						"<b>Filter By Severity should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Severity</b> Value not visible successfully", "FAIL",
						"<b>Filter By Severity should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Severity</b> Value", "FAIL",
					"<b>Filter By Severity should be visible</b>");
		}
	}

	public List<String> getSeverityListFromFilterDropDown() {
		List<String> severityList = new ArrayList<String>();
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterSeverityValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				severityList.add(Keywords.getText(elementList.get(i)));
			}

		} catch (Exception e) {

		}
		return severityList;
	}

	public void selectFilterSeverityValues(String severityValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterSeverityValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(severityValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(3000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Severity Values selected successfully</b>", "PASS",
						"<b>Filter Severity Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Severity Values not selected successfully</b>", "FAIL",
						"<b>Filter Severity Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Severity Values</b>", "FAIL",
					"<b>Filter Severity Values should be selected</b>");
		}
	}

	// >>>>>>>>>>>>> Filter For View Authorization >>>>>>>>>>
	public void enableFilterSpeciality() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterByTypeValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Type</b> Value visible successfully", "PASS",
						"<b>Filter By Type should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Type</b> Value not visible successfully", "FAIL",
						"<b>Filter By Type should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Type</b> Value", "FAIL",
					"<b>Filter By Type should be visible</b>");
		}
	}

	public void selectFilterSpecialityValues(String specialityValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterSpecialityValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(specialityValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(2000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Speciality Values selected successfully</b>", "PASS",
						"<b>Filter Speciality Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Speciality Values not selected successfully</b>", "FAIL",
						"<b>Filter Speciality Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Speciality Values</b>", "FAIL",
					"<b>Filter Speciality Values should be selected</b>");
		}
	}

	public List<String> getSpecialityListFromFilterDropDown() {
		List<String> typeList = new ArrayList<String>();
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterTypeValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				typeList.add(Keywords.getText(elementList.get(i)));
			}

		} catch (Exception e) {

		}
		return typeList;
	}

	public void enableFilterMedicalRecord() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterByStatusValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Medical Records</b> Value visible successfully", "PASS",
						"<b>Filter By Medical Records should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Medical Records</b> Value not visible successfully", "FAIL",
						"<b>Filter By Medical Records should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Status</b> Value", "FAIL",
					"<b>Filter By Status should be visible</b>");
		}
	}

	public void selectFilterMedicalRecorddValues(String medicalRecordValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterMedicalRecordsValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(medicalRecordValue)) {
					Keywords.click(elementList.get(i));
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Medical Records Values selected successfully</b>", "PASS",
						"<b>Filter Medical Records Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Medical Records Values not selected successfully</b>", "FAIL",
						"<b>Filter Medical Records Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Medical Records Values</b>", "FAIL",
					"<b>Filter Medical Records Values should be selected</b>");
		}

		// return filterStatus;
	}

	public void enableFilterAuthorizationStatus() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableFilterBySeverityValues(driver);
			Keywords.click(element);
			Thread.sleep(2000);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Authorization</b> Value visible successfully", "PASS",
						"<b>Filter By Authorization should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter By Authorization</b> Value not visible successfully", "FAIL",
						"<b>Filter By Authorization should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling the Filter By Authorization</b> Value", "FAIL",
					"<b>Filter By Authorization should be visible</b>");
		}
	}

	public void selectFilterAuthorizationStatusValues(String authorizationValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectFilterAuthorizationStatusValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(authorizationValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(3000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Authorization Values selected successfully</b>", "PASS",
						"<b>Filter Authorization Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Filter Authorization Values not selected successfully</b>", "FAIL",
						"<b>Filter Authorization Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Filter Authorization Values</b>", "FAIL",
					"<b>Filter Authorization Values should be selected</b>");
		}
	}
	
	
	// >>>>>>>>>. Rewards Filter >>>>>>>>>>>>>>>>>
	public void enableRewardsType() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableRewardsFilterByType(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter By Type</b> Value visible successfully", "PASS",
						"<b>Rewards Filter By Type should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter By Type</b> Value not visible successfully", "FAIL",
						"<b>Rewards Filter By Type should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling Rewards Filter By Type</b> Value", "FAIL",
					"<b>Rewards Filter By Type should be visible</b>");
		}
	}

	public void selectRewardsFilterTypeValues(String typeValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectRewardsTypeValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(typeValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(2000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter Type Values selected successfully</b>", "PASS",
						"<b>Rewards Filter Type Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter Type Values not selected successfully</b>", "FAIL",
						"<b>Rewards Filter Type Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting Rewards Filter Type Values</b>", "FAIL",
					"<b>Rewards Filter Type Values should be selected</b>");
		}
	}
	
	public void enableRewardsBrand() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().enableRewardsFilterByBrand(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter By Brand</b> Value visible successfully", "PASS",
						"<b>Rewards Filter By Brand should be visible</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter By Brand</b> Value not visible successfully", "FAIL",
						"<b>Rewards Filter By Brand should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enabling Rewards Filter By Brand</b> Value", "FAIL",
					"<b>Rewards Filter By Brand should be visible</b>");
		}
	}

	public void selectRewardsFilterBrandValues(String brandValue) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectRewardsBrandValue(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(brandValue)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(2000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter Brand Values selected successfully</b>", "PASS",
						"<b>Rewards Filter Brand Values should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Rewards Filter Brand Values not selected successfully</b>", "FAIL",
						"<b>Rewards Filter Brand Values should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting Rewards Filter Brand Values</b>", "FAIL",
					"<b>Rewards Filter Brand Values should be selected</b>");
		}
	}

	
}
