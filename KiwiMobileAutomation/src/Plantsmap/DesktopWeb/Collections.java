package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class Collections {

	private WebDriver driver;

	public Collections(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getAddressList() {
		List<String> addressList = new ArrayList<>();
		try {
			addressList.add("Noida");
			addressList.add("Delhi");
			addressList.add("Gurgaon");
			addressList.add("New York");
			addressList.add("Los Angeles");
			addressList.add("Hell");
		} catch (Exception e) {
		}

		return addressList;
	}

	public List<String> getLocationTypeList() {
		List<String> locationList = new ArrayList<>();
		try {
			locationList.add("public");
			locationList.add("private");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationList;
	}

	public List<String> selectionOfMainHeaderSubTab() {
		List<String> tabList = new ArrayList<>();
		try {
			tabList.add("mainpage");
			tabList.add("homesubtab");
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return tabList;
	}

	public void verifyAddNewCollectionHeader() {
		WebElement element;
		String collectionHeaderTxt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewPlantCollectionOrganizationProfileHeader(driver);
			collectionHeaderTxt = element.getText();
			Keywords.verifyTextOnPage(collectionHeaderTxt);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Add New Collection Header present",
						"PASS", "Add New Collection Header text should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add New Collection Header not present", "FAIL",
						"Add New Collection Header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while check the visibility of Add New Collection Header Text", "FAIL",
					"Add New Collection Header text should be present");
		}
	}

	public String addCollectionTitle() {
		WebElement element;
		String collectionName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addCollectionName(driver);
			collectionName = "PlantsmapCollection" + Keywords.getRandomNumber(8);
			Keywords.typeText(element, collectionName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Name entered successfully", "PASS", "Collection Name should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Name not entered successfully", "FAIL", "Collection Name should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the collection title", "FAIL",
					"Collection Name should be entered");
		}
		return collectionName;
	}

	public void addCollectionImage() {
		RemoteWebElement element;
		String imageName = "collection.jpg";
		String imagePath = null;
		try {
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addCollectionImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Image uploaded successfully", "PASS", "Collection Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Image uploaded successfully", "FAIL", "Collection Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploade the Collection Image", "FAIL",
					"Collection Image should be uploaded");
		}
	}

	public String addCollectionDescription() {
		WebElement element;
		String collectionDescription = "This is plantsmap collection description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantCollectionOrganizationDescription(driver);
			Keywords.enterTextByJS(element, collectionDescription, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection description entered successfully", "PASS",
						"Collection description should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection description not entered successfully", "FAIL",
						"Collection description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the collection description", "FAIL",
					"Collection description should be entered");
		}
		return collectionDescription;
	}

	public String selectSuggestedAddress() {
		WebElement element;
		String suggestedAddress = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().suggestedAddress(driver);
			if (Keywords.isElementPresent(element))
				suggestedAddress = Keywords.getText(element);
			Keywords.click(element);
		} catch (Exception e) {
		}

		return suggestedAddress;
	}

	public void clickOnPublicLoc() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().makeLocationPublic(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Make your location public click successfully", "PASS", "Public location should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Make your location public not click successfully", "FAIL", "Public location should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on make your location public", "FAIL",
					"Public location should be click");
		}
	}

	public void clickOnPrivateLoc() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().makeLocationPrivate(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Make your location private click successfully", "PASS", "Private location should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Make your location private not click successfully", "FAIL",
						"Private location should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on make your location private", "FAIL",
					"Private location should be click");
		}
	}

	public String makeYourLocation(String locationType) {
		WebElement element;
		String location = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().makeYourLocationTxt(driver);
			Keywords.waitForObject(element);

			if (locationType.contains("public"))
				Keywords.click(Locators.getInstance().makeLocationPublic(driver));
			else
				Keywords.click(Locators.getInstance().makeLocationPrivate(driver));
			location = locationType;
		} catch (Exception e) {
		}

		return location;
	}

	public String addAddress(String locationType) {
		WebElement element;
		String address = "";
		List<String> addressList = getAddressList();
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.typeText(element, address);
			address = selectSuggestedAddress();
			makeYourLocation(locationType);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection/SubCollection address enter successfully", "PASS",
						"Collection/SubCollection address should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection/SubCollection address not enter successfully", "FAIL",
						"Collection/SubCollection address should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Collection/SubCollection address", "FAIL",
					"Collection/SubCollection address should be enter");
		}

		return address;
	}

	public String addSubCollectionAddress(String locationtype) {
		WebElement element;
		String address = "";
		List<String> addressList = getAddressList();
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.typeText(element, address);
			address = selectSuggestedAddress();
			makeYourLocation(locationtype);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection address enter successfully", "PASS", "Sub Collection address should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection address not enter successfully", "FAIL",
						"Sub Collection address should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Sub Collection address", "FAIL",
					"Sub Collection address should be enter");
		}

		return address;
	}

	public void clickOnSaveButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().savePlantCollectionOrganizationPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Save button click successfully",
						"PASS", "Save button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Save button not click successfully", "FAIL", "Save button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Save button", "FAIL", "Save button should be click");
		}
	}

	public void collectionSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyCollectionSubCollectionSuccessfullyAddedAlertMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().doneCollectionSubCollectionAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection Added successfully",
						"PASS", "Collection should be added");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection not Added successfully",
						"FAIL", "Collection should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding Collection", "FAIL", "Collection should be added");
		}
	}

	public void subCollectionSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyCollectionSubCollectionSuccessfullyAddedAlertMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().doneCollectionSubCollectionAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("SubCollection Added successfully",
						"PASS", "SubCollection should be added");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SubCollection not Added successfully", "FAIL", "SubCollection should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while addding the SubCollection", "FAIL", "SubCollection should be added");
		}
	}

	public void collectionSuccessfullyDeleted() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Thread.sleep(2000);
			element = Locators.getInstance().updateSuccessfullyPlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitDonePlantAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Are you sure you want to delete Collection message visible", "PASS",
						"Collection delete message should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Are you sure you want to delete Collection message not visible", "FAIL",
						"Collection delete message should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Collection delete alert message", "FAIL",
					"Collection delete message should be visible");
		}
	}

	public void subCollectionSuccessfullyDeleted() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			Thread.sleep(2000);
			element = Locators.getInstance().updateSuccessfullyPlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitDonePlantAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Are you sure you want to delete Sub Collection message visible", "PASS",
						"Sub Collection delete message should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Are you sure you want to delete Sub Collection message not visible", "FAIL",
						"Sub Collection delete message should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Sub Collection delete message present", "FAIL",
					"Sub Collection delete message should be visible");
		}
	}

	// collection detail page
	public void clickOnEditButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().editCollectionSubCollectionButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Edit Button click successfully",
						"PASS", "Edit Button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Edit Button not click successfully", "FAIL", "Edit Button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Edit Button", "FAIL", "Edit Button should be click");
		}
	}

	public void clickOnDeleteButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().deleteCollection(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Delete Button click successfully",
						"PASS", "Delete Button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Delete Button not click successfully", "FAIL", "Delete Button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Delete Button", "FAIL", "Delete Button should be click");
		}
	}

	public void collectionDeletedSuccessfully() {
		List<WebElement> elementsList;
		try {
			Keywords.waitForPage(driver);
			Thread.sleep(5000);
			elementsList = Locators.getInstance().verifyCollectionSubCollectionDeleteAlertMessage(driver);
			Keywords.verifyTextOnPage(elementsList.get(1).getText());
			Keywords.waitForPage(driver);
			elementsList = Locators.getInstance().submitDoneButtonForSuccessfullyDeletedCollectionSubCollection(driver);
			Keywords.click(elementsList.get(1));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection deleted successfully",
						"PASS", "Collection should be deleted");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection not deleted successfully", "FAIL", "Collection should be deleted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting Collection", "FAIL", "Collection should be deleted");
		}
	}

	public void verifyAndSubmitSubCollectionDeletedSuccessfullyAlert() {
		List<WebElement> elementsList;
		try {
			Keywords.waitForPage(driver);
			Thread.sleep(5000);
			elementsList = Locators.getInstance().verifyCollectionSubCollectionDeleteAlertMessage(driver);
			Keywords.verifyTextOnPage(elementsList.get(1).getText());

			elementsList = Locators.getInstance().submitDoneButtonForSuccessfullyDeletedCollectionSubCollection(driver);
			Keywords.click(elementsList.get(1));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection not deleted successfully", "PASS", "Sub Collection should be deleted");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection not deleted successfully", "FAIL", "Sub Collection should be deleted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting Sub Collection", "FAIL", "Sub Collection should be deleted");
		}
	}

	public String getCollectionTitle() {
		WebElement element;
		String collectionName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionTitle(driver);
			collectionName = element.getText();
		} catch (Exception e) {
		}

		return collectionName;
	}

	public String getCollectionDescription() {
		WebElement element;
		String collectionDescription = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionDescription(driver);
			collectionDescription = element.getText();
		} catch (Exception e) {
		}

		return collectionDescription;
	}

	public String getCollectionCreatorName() {
		WebElement element;
		String collectionCreatorName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().collectionCreatedBy(driver);
			collectionCreatorName = element.getText();
		} catch (Exception e) {
		}

		return collectionCreatorName;
	}

	public String getCollectionPhysicallAddress() {
		WebElement element;
		String collectionPhysicallAddress = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionPhysicallAddress(driver);
			collectionPhysicallAddress = element.getText();
		} catch (Exception e) {
		}

		return collectionPhysicallAddress;
	}

	public void selectCollectionFromCollectionList(String collectionTitleName) {
		List<WebElement> collectionList = new ArrayList<WebElement>();
		try {
			Keywords.waitForPage(driver);
			collectionList = Locators.getInstance().selectCollection(driver);
			for (int i = 0; i < collectionList.size(); i++) {
				if (Keywords.getText(collectionList.get(i)).contains(collectionTitleName)) {
					Keywords.clickByIndex(collectionList, i);
					Keywords.waitForPage(driver);
					break;
				}
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionTitleName + " selected from collection list", "PASS",
						collectionTitleName + " should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionTitleName + " not selected from collection list", "FAIL",
						collectionTitleName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting collection from collection list", "FAIL",
					collectionTitleName + " should be selected");
		}
	}

	public void selectSubCollectionFromCollectionList(String subCollectionTitleName) {
		List<WebElement> subCollectionList = new ArrayList<WebElement>();
		try {
			Keywords.waitForPage(driver);
			subCollectionList = Locators.getInstance().selectSubCollection(driver);
			for (int i = 0; i < subCollectionList.size(); i++) {
				if (Keywords.getText(subCollectionList.get(i)).contains(subCollectionTitleName)) {
					Keywords.clickByIndex(subCollectionList, i);
					Keywords.waitForPage(driver);
					break;
				}
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection selected from sub collection list", "PASS", "Sub Collection should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection not select from Sub collection list", "FAIL",
						"Sub Collection should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting Sub collection from Subcollection list", "FAIL",
					"Sub Collection should be clicked");
		}
	}

	public void selectCollectionSubCollectionTabs(String tabName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectCollectionSubCollectionSubTabs(driver, tabName);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(tabName + " selected successfully",
						"PASS", tabName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						tabName + " not selected successfully", "FAIL", tabName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + tabName, "FAIL", tabName + " should be selected");
		}
	}
	
	public void selectSubCollectionInsideSubcollectionTab(String subCollectionName) {
		List<WebElement> subCollectionList;
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().selectSubCollectionFromSubCollectionList(driver);
			subCollectionList = Locators.getInstance().getSubCollectionListInsideSubCollectionTab(driver);
			for (int i = 0; i < subCollectionList.size(); i++) {
				if (Keywords.getText(subCollectionList.get(i)).equalsIgnoreCase(subCollectionName)) {
					Keywords.click(list.get(i));
					break;
				}
			}
		}catch(Exception e) {}
	}

	public void clickOnAddRemovePlants() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().collectionAddRemovePlants(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add/Remove Plants</b> click successfully", "PASS",
						"<b>Add/Remove Plants</b> Link should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add/Remove Plants</b> not click successfully", "FAIL",
						"<b>Add/Remove Plants</b> Link should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add/Remove Plants</b>", "FAIL",
					"<b>Add/Remove Plants</b> Link should be click");
		}
	}

	public void navigateToAddRemovePlantPage(String tabName) {
		selectCollectionSubCollectionTabs(tabName);
		clickOnAddRemovePlants();
	}

	public void verifyAddRemoveHeaderText() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyAddRemovePlantsPopUp(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddPlantButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnAddPlant(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Plant</b> button click successfully", "PASS",
						"<b>Add Plant</b> button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Plant</b> button not click successfully", "FAIL",
						"<b>Add Plant</b> button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occurred while clicking on <b>Add Plant</b> button", "FAIL",
					"<b>Add Plant</b> button should be click");
		}
	}

	public String selectPlantFromAddRemovePlantPopUpList() {
		String plantTitleName = "";
		List<WebElement> plantsList;
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			plantsList = Locators.getInstance().getPlantsList(driver);
			randomNumber = Keywords.getRandomInteger(plantsList.size() - 1);
			plantTitleName = Keywords.getText(plantsList.get(randomNumber)).trim();
			Keywords.click(plantsList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant selected successfully",
						"PASS", "Plant should be select from plants list");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant not selected successfully",
						"FAIL", "Plant should be select from plants list");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the Plant", "FAIL", "Plant should be select from plants list");
		}

		return plantTitleName;
	}

	public void clickOnUpdateButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnUpdate(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Update button click successfully",
						"PASS", "Update button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Update button not click successfully", "FAIL", "Update button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the update button", "FAIL", "Update button should be click");
		}
	}

	public String createNewPlantToSubCollection() {
		String plantTitle = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			plant.verifyAddNewPlantHeader();
			plantTitle = plant.addPlantTitle();
			plant.addPlantStory();
			plant.verifyImageDimensionFormat();
			plant.addPlantImage();
			plant.addAddress("public");
			plant.clickOnNextButton();
			plant.clickOnSaveButton();
			plant.plantSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitle;
	}
	
	public boolean getPlantsVisibililty() {
		WebElement element;
		boolean status = false;
		try {
		Keywords.waitForPage(driver);
		element = Locators.getInstance().verifyPlantsExistance(driver);
		if (Keywords.isElementPresent(element))
			status = true;
		}catch(Exception e) {
		}
		return status;
	}

	public String addPlant(String collectionName, String subCollectionName) {
		String plantName = "";
		try {
			if (getPlantsVisibililty()) {
				clickOnAddPlantButton();
				plantName = createNewPlantToSubCollection();
				HomePage home = new HomePage(driver);
				home.selectHeaderTab("My Plants Map");
				home.selectHeaderSubTab("My Collections");
				selectCollectionFromCollectionTab(collectionName);
				selectCollectionSubCollectionTabs("subcol");
				selectSubCollectionInsideSubcollectionTab(subCollectionName);
				//selectCollectionSubCollectionTabs("plant");
				navigateToAddRemovePlantPage("plant");
				verifyAddRemoveHeaderText();
				plantName = selectPlantFromAddRemovePlantPopUpList();
				clickOnUpdateButton();
			} else {
				plantName = selectPlantFromAddRemovePlantPopUpList();
				clickOnUpdateButton();
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plants Added successfully to the SubCollection", "PASS", "Plant should be added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plants not Added successfully to the SubCollection", "FAIL", "Plant should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding plants to the SubCollection", "FAIL", "Plant should be added");
		}

		return plantName;
	}

	public void verifyPlantInSubCollection(String plantName) {
		List<WebElement> plantsList;
		try {
			selectCollectionSubCollectionTabs("plant");
			plantsList = Locators.getInstance().getPlantListInsidePlantTabUnderSubCollectionDetailPage(driver);
			for (int i = 0; i < plantsList.size(); i++) {
				if (plantName.equalsIgnoreCase(Keywords.getText(plantsList.get(i)))) {
					Keywords.verifyTextOnPage(Keywords.getText(plantsList.get(i)));
					if (DriverSession.getStepResult()) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " found under subcollection successfully", "PASS",
								plantName + " should be present in plants list");
					} else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " not found under subcollection successfully", "FAIL",
								plantName + " should be present in plants list");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the plant " + plantName + "from plant list", "FAIL",
					plantName + " should be present in plants list");
		}
	}

	public void verifyPlantInCollection(String plantName) {
		List<WebElement> plantsList;
		try {
			selectCollectionSubCollectionTabs("plant");
			plantsList = Locators.getInstance().getPlantListUnderPlantFromCollectionPage(driver);//getPlantsList(driver);
			for (int i = 0; i < plantsList.size(); i++) {
				if (plantName.equalsIgnoreCase(Keywords.getText(plantsList.get(i)))) {
					Keywords.verifyTextOnPage(Keywords.getText(plantsList.get(i)));
					if (DriverSession.getStepResult()) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " found under collection successfully", "PASS",
								plantName + " should be present under collection plant list");
					} else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " not found under collection successfully", "FAIL",
								plantName + " should be present under collection plant list");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the plant " + plantName + "from plant list", "FAIL",
					plantName + " should be present under collection plant list");
		}
	}

	public void deletePlantFromSubCollection(String plantName) {
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getPlantsList(driver);
			for (int i = 0; i < list.size(); i++) {
				if (plantName.equalsIgnoreCase(Keywords.getText(list.get(i)))) {
					Keywords.click(list.get(i));
					if (DriverSession.getStepResult())
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " plant delete successfully from subcollection", "PASS",
								plantName + " plant should be deleted from subcollection.");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " plant not delete successfully from subcollection", "FAIL",
								plantName + " plant should be deleted from subcollection.");
					break;
				}
			}
			clickOnUpdateButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting "+plantName + " plant from subcollection", "FAIL",
					plantName + " plant should be deleted from subcollection.");
		}
	}
	
	public void verifyPlantDelete() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyNoPlantText(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>There are no plants added yet</b> text found successfully", "PASS",
						"<b>There are no plants added yet</b> text should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>There are no plants added yet</b> text not found successfully", "FAIL",
						"<b>There are no plants added yet</b> text should be found");
		}catch(Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occurred while verifing the text <b>There are no plants added yet</b>", "FAIL",
					"<b>There are no plants added yet</b> text should be found");
		}
	}

	public void deletePlantFromCollection(String plantName) {
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getPlantsList(driver);
			for (int i = 0; i < list.size(); i++) {
				if (plantName.equalsIgnoreCase(Keywords.getText(list.get(i)))) {
					Keywords.click(list.get(i));
					if (DriverSession.getStepResult())
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " plant delete successfully from collection", "PASS",
								plantName + " plant should be deleted from collection.");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								plantName + " plant not delete successfully from collection", "FAIL",
								plantName + " plant should be deleted from collection.");
					break;
				}
			}
			clickOnUpdateButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting "+plantName + " plant from collection", "FAIL",
					plantName + " plant should be deleted from collection.");
		}
	}

	public void clickOnCreateSubCollection() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().createSubCollection(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Create subcollection</b> click successfully", "PASS",
						"<b>Create subcollection</b> should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Create subcollection</b> not click successfully", "FAIL",
						"<b>Create subcollection</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the <b>Create subcollection</b>", "FAIL",
					"<b>Create subcollection</b> should be click");
		}
	}

	public String addSubCollectionTitle() {
		WebElement element;
		String subCollectionName = "";
		try {
			Keywords.waitForPage(driver, 10);
			element = Locators.getInstance().addCollectionName(driver);
			subCollectionName = "PlantsmapSubCollection" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, subCollectionName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection Title entered successfully", "PASS", "Sub Collection Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection Title not entered successfully", "FAIL",
						"Sub Collection Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the Sub collection Title", "FAIL",
					"Sub Collection Title should be entered");
		}

		return subCollectionName;
	}

	// Sub collection detail page
	public void addSubCollectionImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "cover.jpg";
		try {
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addCollectionImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection Image uploaded successfully", "PASS",
						"Sub Collection Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection Image uploaded successfully", "FAIL",
						"Sub Collection Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the Sub Collection Image", "FAIL",
					"Sub Collection Image should be uploaded");
		}
	}

	public String addSubCollectionDescription() {
		WebElement element;
		String collectionDescription = "This is plantsmap subcollection description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantCollectionOrganizationDescription(driver);
			Keywords.enterTextByJS(element, collectionDescription, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection description entered successfully", "PASS",
						"Sub Collection description should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sub Collection description not entered successfully", "FAIL",
						"Sub Collection description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Sub collection description", "FAIL",
					"Sub Collection description should be entered");
		}
		return collectionDescription;
	}

	public String getSubCollectionTitle() {
		WebElement element;
		String collectionName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getSubCollectionTitle(driver);
			collectionName = element.getText();
		} catch (Exception e) {
		}

		return collectionName;
	}

	public String getSubCollectionDescription() {
		WebElement element;
		String collectionDescription = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionDescription(driver);
			collectionDescription = element.getText();
		} catch (Exception e) {
		}

		return collectionDescription;
	}

	public String getSubCollectionCreatorName() {
		WebElement element;
		String collectionCreatorName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().collectionCreatedBy(driver);
			collectionCreatorName = element.getText();
		} catch (Exception e) {
		}

		return collectionCreatorName;
	}

	public String getSubCollectionPhysicallAddress() {
		WebElement element;
		String collectionPhysicallAddress = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionPhysicallAddress(driver);
			collectionPhysicallAddress = element.getText();
		} catch (Exception e) {
		}

		return collectionPhysicallAddress;
	}

	public String getCollectionFromSubCollectionDetailPage() {
		WebElement element;
		String collectionName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionNameFromSubCollectionDetailPage(driver);
			collectionName = element.getText();
		} catch (Exception e) {
		}

		return collectionName;
	}

	public void clickCollectionFromSubCollectionDetailPage(String collectionName) {
		WebElement element;
		String collectionNameFromSubCollection = getCollectionFromSubCollectionDetailPage();
		try {
			Keywords.waitForPage(driver);
			if (collectionName.equalsIgnoreCase(collectionNameFromSubCollection)) {
				element = Locators.getInstance().getCollectionNameFromSubCollectionDetailPage(driver);
				Keywords.click(element);
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionName + " click successfully", "PASS",
						collectionName + " should be click from subcollection detail page");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionName + " not click successfully", "FAIL",
						collectionName + " should be click from subcollection detail page");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on " + collectionName, "FAIL",
					collectionName + " should be click from subcollection detail page");
		}
	}

	public void selectCollectionFromCollectionTab(String collectionTitleName) {
		List<WebElement> collectionList;
		try {
			Keywords.waitForPage(driver);
			collectionList = Locators.getInstance().selectCollectionUnderCollectionTab(driver);
			for (WebElement ele : collectionList) {
				if (Keywords.getText(ele).equalsIgnoreCase(collectionTitleName)) {
					Keywords.click(ele);
					Keywords.waitForPage(driver);
					break;
				}
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionTitleName + " selected from collection list", "PASS",
						collectionTitleName + " should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						collectionTitleName + " not selected from collection list", "FAIL",
						collectionTitleName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + collectionTitleName + " from collection list", "FAIL",
					collectionTitleName + " should be selected");
		}
	}
	
	public String getPlantName() {
		String collectionName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionNameFromPlantDetailPage(driver);
			collectionName = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionName;
	}

	public void verifyPlantOnCollectionDetailPage(String plantName) {
		if (getPlantName().equalsIgnoreCase(plantName))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Added Plant found successfully on Plant detail page", "PASS",
					"Added Plant should be found on Collection detail page");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Added Plant not found successfully on Plant detail page", "FAIL",
					"Added Plant should be found on Plant detail page");
	}
}
