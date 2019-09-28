package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.session.DriverSession;

import com.utilities.Keywords;

public class Tags {

	private WebDriver driver;

	public Tags(WebDriver driver) {
		this.driver = driver;
	}

	public List<Integer> getPlantQuantity() {
		List<WebElement> taggedPlantQuantity;
		List<Integer> plantsQuantity = new ArrayList<Integer>();
		try {
			taggedPlantQuantity = Locators.getInstance().getTaggedPlantQuantityList(driver);
			for (WebElement element : taggedPlantQuantity) {
				plantsQuantity.add(Integer.parseInt(Keywords.getText(element)));
			}
		} catch (Exception e) {

		}

		return plantsQuantity;
	}

	public List<String> getPlantsTitleFromTagsPage() {
		List<WebElement> taggedPlantTitle;
		List<String> plantsTitle = new ArrayList<String>();
		try {
			taggedPlantTitle = Locators.getInstance().getTaggedPlantsTitleList(driver);
			for (WebElement element : taggedPlantTitle) {
				plantsTitle.add(Keywords.getText(element));
			}
		} catch (Exception e) {
		}

		return plantsTitle;
	}

	/*
	 * public List<Integer> updatePlantQuantity() { //List<String>
	 * plantTitleList = getPlantsTitleFromTagsPage(); List<WebElement>
	 * taggedPlantQuantity; List<Integer> updatedPlantQuantity = new
	 * ArrayList<Integer>(); int size = getPlantQuantity().size(); int
	 * randomQuantity = 0; taggedPlantQuantity =
	 * Locators.getInstance().getTaggedPlantQuantityList(driver); for (int i =
	 * 0; i < taggedPlantQuantity.size(); i++) { randomQuantity =
	 * Keywords.getRandomInteger(10); if (randomQuantity == 0) randomQuantity =
	 * randomQuantity + 1; updatedPlantQuantity.add(randomQuantity);
	 * Keywords.typeText(taggedPlantQuantity.get(i),
	 * String.valueOf(randomQuantity));
	 * //Keywords.typeTextByIndex(taggedPlantQuantity, i,
	 * String.valueOf(randomQuantity)); } return updatedPlantQuantity; }
	 */

	public HashMap<String, Integer> updatePlantQuantity(String quantityType) {
		HashMap<String, Integer> plantTitleWithQuantity = new HashMap<>();
		List<String> plantTitleList = getPlantsTitleFromTagsPage();
		List<WebElement> taggedPlantQuantity;
		int randomQuantity = 0;
		int count = 0;
		taggedPlantQuantity = Locators.getInstance().getTaggedPlantQuantityList(driver);

		if (quantityType.equalsIgnoreCase("valid")) {
			count = Integer.parseInt(DriverSession.getTestCaseData().get("PlantQuantity"));
			for (int i = 0; i < taggedPlantQuantity.size(); i++) {
				randomQuantity = Keywords.getRandomInteger(count);
				if (randomQuantity == 0)
					randomQuantity = randomQuantity + 1;
				plantTitleWithQuantity.put(plantTitleList.get(i), randomQuantity);
				Keywords.typeText(taggedPlantQuantity.get(i), String.valueOf(randomQuantity));
			}
		} else if (quantityType.equalsIgnoreCase("invalid")) {
			count = Integer.parseInt(DriverSession.getTestCaseData().get("PlantQuantityForBoundryValue"));
			for (int i = 0; i < taggedPlantQuantity.size(); i++) {
				randomQuantity = count;// Keywords.getRandomInteger(count);
				if (randomQuantity == 0)
					randomQuantity = randomQuantity + 1;
				plantTitleWithQuantity.put(plantTitleList.get(i), randomQuantity);
				Keywords.typeText(taggedPlantQuantity.get(i), String.valueOf(randomQuantity));
			}
		}

		return plantTitleWithQuantity;
	}

	public void verifyPlantInavlidQuantityAlertMessage() {
		try {
			Thread.sleep(2000);
			if (Keywords.getAlert().contains("")) {
				submitPlantQuantityAndSignPage();
			}
			if (Keywords.getAlert().equalsIgnoreCase(DriverSession.getTestCaseData().get("QuantityAlertMessage"))) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plant Quantity cannot be more than 1000</b> display successfully", "PASS",
						"<b>Plant Quantity cannot be more than 1000</b> should be Display");
				Keywords.acceptAlert();
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plant Quantity cannot be more than 1000</b> not display successfully", "FAIL",
						"<b>Plant Quantity cannot be more than 1000</b> should be Display");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the plants quantity", "FAIL",
					"<b>Plant Quantity cannot be more than 1000</b> should be Display");
		}
	}

	public HashMap<String, Float> getPlantTagSignPrice() {
		HashMap<String, Float> signPriceList = new HashMap<String, Float>();
		try {
			signPriceList.put("Sign", 6.0f); // for sign tag
			signPriceList.put("Sign With Hole", 6.0f); // for sign with hole
			signPriceList.put("Tag", 4.0f); // for tag
			signPriceList.put("Tag With Hole", 4.0f); // for tag with hole
		} catch (Exception e) {
		}

		return signPriceList;
	}

	public float getPlantsTagPrice(String tagName) {
		HashMap<String, Float> signWithPrice = getPlantTagSignPrice();
		float plantstagValue = 0.0f;
		try {
			plantstagValue = signWithPrice.get(tagName);
		} catch (Exception e) {

		}
		return plantstagValue;
	}

	/*
	 * public List<String> selectTaggedPlantSign() { List<WebElement>
	 * unablePlantsSignValue; String selectedPlantsSignValue = ""; List<String>
	 * plantsSignValue = new ArrayList<String>(); try { unablePlantsSignValue =
	 * Locators.getInstance().getTaggedPlantSignValue(driver); for (int i = 0; i
	 * < unablePlantsSignValue.size(); i++) { selectedPlantsSignValue =
	 * Keywords.getSelectedIndexValue(unablePlantsSignValue.get(i), i);
	 * //aSystem.out.println("Plants Sign value..." + selectedPlantsSignValue);
	 * plantsSignValue.add(selectedPlantsSignValue); } } catch (Exception e) {
	 * 
	 * }
	 * 
	 * return plantsSignValue; }
	 */

	public HashMap<String, String> selectTaggedPlantSign() {
		HashMap<String, String> planttitleWithsign = new HashMap<>();
		List<String> planttitle = getPlantsTitleFromTagsPage();
		List<WebElement> unablePlantsSignValue;
		String selectedPlantsSignValue = "";
		int randomTagIndex = 0;
		try {
			unablePlantsSignValue = Locators.getInstance().getTaggedPlantSignValue(driver);
			for (int i = 0; i < unablePlantsSignValue.size(); i++) {
				randomTagIndex = Keywords.getRandomInteger(4);
				selectedPlantsSignValue = Keywords.getSelectedIndexValue(unablePlantsSignValue.get(i), randomTagIndex);// Keywords.getSelectedIndexValue(unablePlantsSignValue.get(i),
																														// i);
				planttitleWithsign.put(planttitle.get(i), selectedPlantsSignValue);
			}
		} catch (Exception e) {

		}

		return planttitleWithsign;
	}

	public List<String> getPlantQuantityList() {
		List<String> plantList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getTaggedPlantQuantityList(driver);
			for (WebElement ele : list) {
				plantList.add(Keywords.getAttributeVal(ele, "value"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantList;
	}

	public List<String> getPlantsTagList() {
		List<String> tagList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getTaggedPlantSignValue(driver);
			for (WebElement ele : list) {
				Select select = new Select(ele);
				tagList.add(Keywords.getText(select.getFirstSelectedOption()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tagList;
	}

	public List<String> getPlantsTagTemplateList() {
		List<String> templateList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getTaggedPlantTemplate(driver);
			for (WebElement ele : list) {
				Select select = new Select(ele);
				templateList.add(Keywords.getText(select.getFirstSelectedOption()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return templateList;
	}

	public List<String> getPlantsLinesDataList(int lineIndexing) {
		List<String> lineDataList = new ArrayList<>();
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getLineData(driver, lineIndexing);
			for (WebElement ele : list) {
				lineDataList.add(Keywords.getAttributeVal(ele, "value"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lineDataList;
	}

	public void clickOnDownLoadExcel() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().downloadExcel(driver);
			Keywords.click(element);
			Thread.sleep(3000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Download Excel button click successfully</b>", "PASS",
						"<b>Download Excel button should be click</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Download Excel button not click successfully</b>", "FAIL",
						"<b>Download Excel button should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Download Excel button</b>", "FAIL",
					"<b>Download Excel button should be click</b>");
		}
	}

	public List<String> updatePlantTitle(List<String> plantsList) {
		List<String> updatedPlantTitle = new ArrayList<>();
		String updateTitle = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			for (int i = 0; i < plantsList.size(); i++) {
				element = Locators.getInstance().updatePlantTitle(driver, plantsList.get(i));
				updateTitle = "PlantsmapPlant" + Keywords.getRandomIntegerBtRange(1000000, 9999999);
				updatedPlantTitle.add(updateTitle);
				Keywords.typeText(element, updateTitle);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants Title</b> " + plantsList.get(i) + " updated successfully", "PASS",
							"<b>Plants Title</b>" + plantsList.get(i) + "<b> should be updated</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants Title</b> " + plantsList.get(i) + " not updated successfully", "FAIL",
							"<b>Plants Title</b>" + plantsList.get(i) + "<b> should be updated</b>");
				//System.out.println("PlantName before.." + plantsList + "After Updation..." + updateTitle);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while updating Plants Title", "FAIL",
					"<b>Plants Title should be updated</b>");
		}

		return updatedPlantTitle;
	}

	public List<Object> getPlantsTitleQuantityAndSign() {
		List<Object> obj = new ArrayList<>();
		HashMap<String, Integer> data = new HashMap<>();
		obj.add(data);
		List<String> plantsTitle = getPlantsTitleFromTagsPage();
		// List<Integer> plantsQuantity = updatePlantQuantity();
		// List<String> plantsSign = selectTaggedPlantSign();
		HashMap<String, Integer> plantsQuantity = updatePlantQuantity("valid");
		HashMap<String, String> plantsSign = selectTaggedPlantSign();
		/*
		 * System.out.println("Plants Title.."+plantsTitle); System.out.println(
		 * "Plants Quantity.."+plantsQuantity); System.out.println(
		 * "Plants Sign.."+plantsSign);
		 */
		obj.add(plantsTitle);
		obj.add(plantsQuantity);
		obj.add(plantsSign);

		return obj;
	}

	public void submitPlantQuantityAndSignPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().saveAndProceedBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save And Proceed</b> button click successfully", "PASS",
						"<b>Save And Proceed</b> button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save And Proceed</b> button not click successfully", "FAIL",
						"<b>Save And Proceed</b> button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking <b>Save And Proceed</b> button", "FAIL",
					"<b>Save And Proceed</b> button should be click");
		}
	}

	public void saveChangesOnTagsPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().saveTagPage(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			element = Locators.getInstance().submitAlertForSaveBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save</b> button click successfully", "PASS", "<b>Save</b> button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save</b> button not click successfully", "FAIL", "<b>Save</b> button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking <b>Save</b> button", "FAIL",
					"<b>Save</b> button should be click");
		}
	}

	public void clickOnAddButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Button click successfully</b>", "PASS", "<b>Add Button should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while clicking on the Add Button</b>", "FAIL",
					"<b>Add Button should be click</b>");
		}
	}

	public void submitTagPopupWindow() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitTagPopupWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Button click successfully</b>", "PASS", "<b>Add Button should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while clicking on the Add Button</b>", "FAIL",
					"<b>Add Button should be click</b>");
		}
	}

	public void clickOnFindButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnFindBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Find Button click successfully</b>", "PASS", "<b>Find Button should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while clicking on the Find Button</b>", "FAIL",
					"<b>Find Button should be click</b>");
		}
	}

	public void searchType(String searchType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectSearchCriteria(driver);
			if (searchType.equalsIgnoreCase("plant title")) {
				Keywords.selectByValue(element, "Plant Title");
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search Type Plant Title click successfully</b>", "PASS",
						"<b>Search Type Plant Title should be select</b>");
			} else {
				Keywords.selectByValue(element, "Collection Name");
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Search Type Collection Name select successfully</b>", "PASS",
						"<b>Search Type Collection Name should be select</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the Search Type </b>" + searchType, "FAIL",
					"<b>Search Type <b>" + searchType + " <b> should be select</b>");
		}
	}

	public void selectTagStatus(String tagType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectTagStatus(driver);
			if (tagType.equalsIgnoreCase("all"))
				Keywords.selectByValue(element, "All");
			else if (tagType.equalsIgnoreCase("tagged"))
				Keywords.selectByValue(element, "Tagged");
			else if (tagType.equalsIgnoreCase("untagged"))
				Keywords.selectByValue(element, "Untagged");
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Tag Type </b>" + tagType + "<b> select successfully</b>", "PASS",
					"<b>Tag Type </b>" + tagType + "<b> should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Tag Type </b>" + tagType + "<b> not select successfully</b>", "FAIL",
					"<b>Tag Type </b>" + tagType + "<b> should be selected</b>");
		}
	}

	public void selectCollectionTitleFromCollectionList() {
		List<WebElement> collectionTitleList;
		WebElement element;
		String collectionTitleName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCollectionSearchCriteria(driver);
			Select select = new Select(element);
			Thread.sleep(2000l);
			collectionTitleList = select.getOptions();
			for (int i = 1; i < collectionTitleList.size(); i++) {
				collectionTitleName = Keywords.getText(collectionTitleList.get(i));
				select.selectByVisibleText(collectionTitleName.trim());
				Thread.sleep(1000l);
				clickOnFindButton();
				Thread.sleep(1000l);
				element = Locators.getInstance().verifyNoPlantsFoundText(driver);
				if (Keywords.isElementPresent(element)) {
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public String searchPlantWithTitle(String plantTitleName) {
		WebElement element;
		String plantName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().searchPlantName(driver);
			Keywords.typeText(element, plantTitleName);
		} catch (Exception e) {
		}

		return plantName;
	}

	public boolean plantSearchResultStatus() {
		boolean status = false;
		List<WebElement> element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantsTitleList(driver);
			if (element.size() >= 1)
				status = true;
			else
				status = false;
		} catch (Exception e) {
		}
		return status;
	}

	public void addPlantFromSearchResult() {
		List<WebElement> plantTitleList;
		List<WebElement> checkBoxList;
		try {
			Keywords.waitForPage(driver);
			plantTitleList = Locators.getInstance().getPlantsTitleList(driver);
			checkBoxList = Locators.getInstance().getPlantsCheckBoxList(driver);
			for (int i = 0; i < 5; i++) {
				Keywords.click(checkBoxList.get(Keywords.getRandomInteger(checkBoxList.size())));
			}
		} catch (Exception e) {
		}
	}

	public void addPlantFromTagSearchResult() {
		List<WebElement> checkBoxList;
		int loopCount = 50;
		try {
			Keywords.waitForPage(driver);
			checkBoxList = Locators.getInstance().getPlantsCheckBoxList(driver);
			// if (checkBoxList.size() >= 5)
			// loopCount = 5;
			// else if (checkBoxList.size() >=10)
			// loopCount = 10;
			// else if (checkBoxList.size() >= 15)
			// loopCount = 15;
			// else
			// loopCount = 8;
			for (int i = 0; i < loopCount; i++) {
				Keywords.click(checkBoxList.get(Keywords.getRandomInteger(checkBoxList.size())));
			}
		} catch (Exception e) {
		}
	}

	public List<String> getPlantsSearchResult() {
		List<WebElement> element;
		List<String> plantTitleList = new ArrayList<String>();
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantsTitleList(driver);
			for (int i = 0; i < element.size(); i++) {
				plantTitleList.add(Keywords.getText(element.get(i)));
			}
		} catch (Exception e) {
		}

		return plantTitleList;
	}

	public void hideTagPopupWindowView() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().hideTagWindowView(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}
}
