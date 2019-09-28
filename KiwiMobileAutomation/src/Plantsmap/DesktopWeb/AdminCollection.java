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

public class AdminCollection {
	
	private WebDriver driver;

	public AdminCollection(WebDriver driver) {
		this.driver = driver;
	}
	
	public String selectOwnerType(String ownerType) {
		String ownerinfo = ownerType;
		try {
			Keywords.waitForPage(driver);
			if (ownerinfo.equalsIgnoreCase("user"))
				Keywords.clickOnDisableElement("owner_type_User");
			else
				Keywords.clickOnDisableElement("owner_type_Organization");
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						ownerType + " radio button click select successfully", "PASS", ownerType + " radio button should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						ownerType + " radio button click not select successfully", "FAIL", ownerType + " radio button should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking " + ownerType+" radio button", "FAIL", ownerType + " radio button should be selected");
		}

		return ownerinfo;
	}
	
	public String enterOwnerIdOrSlug(String ownerType) {
		WebElement element;
		String ownerIdOrSlug = "";
		try {
			if (ownerType.equalsIgnoreCase("user"))
				ownerIdOrSlug = DriverSession.getTestCaseData().get("UserOwnerId");
			else 
				ownerIdOrSlug = DriverSession.getTestCaseData().get("OrgOwnerId");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addCollectionOwnerIdOrSlug(driver);
			Keywords.typeText(element, ownerIdOrSlug);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Owner Id/Slug</b> enter successfully", "PASS", "<b>Owner Id/Slug</b> should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Owner Id/Slug</b> not enter successfully", "FAIL", "<b>Owner Id/Slug</b> should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Owner Id/Slug</b>", "FAIL", "<b>Owner Id/Slug</b> should be enter");
		}

		return ownerIdOrSlug;
	}

	public String addCollectionTitle() {
		WebElement element;
		String collectionTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminCollectionTitle(driver);
			collectionTitle = "AdminCollection" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, collectionTitle);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection Title entered successfully",
						"PASS", "Collection Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Title not entered successfully", "FAIL", "Collection Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Collection title", "FAIL", "Collection Title should be entered");
		}

		return collectionTitle;
	}

	public void addCollectionImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "admincollection.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().addAdminCollectionImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection Image uploaded successfully",
						"PASS", "Collection Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection Image not uploaded successfully",
						"FAIL", "Collection Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the Collection Image", "FAIL", "Collection Image should be uploaded");
		}
	}

	public String addCollectionStory() {
		WebElement element;
		String collectionStory = "This is admin Collection description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminCollectionStory(driver);
			Keywords.enterTextByJS(element, collectionStory, "arguments[0].textContent= arguments[1];");
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection Story entered successfully",
						"PASS", "Collection Story should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Story not entered successfully", "FAIL", "Collection Story should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Collection story", "FAIL", "Collection Story should be entered");
		}
		return collectionStory;
	}

	public String makeYourLocation(String locationType) {
		String location = "";
		try {
			Keywords.waitForPage(driver);
			if (locationType.contains("public")) 
				Keywords.clickOnDisableElement("collection_location_private_false");
			else
				Keywords.clickOnDisableElement("collection_location_private_true");
			location = locationType;
		} catch (Exception e) {}

		return location;
	}

	public String addAddress(String locationType) {
		WebElement element;
		Collections collection = new Collections(driver);
		List<String> addressList = collection.getAddressList();
		String address = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminCollectionAddress(driver);
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.typeText(element, address);
			address = collection.selectSuggestedAddress();
			makeYourLocation(locationType);
		} catch (Exception e) {}

		return address;
	}

	public List<String> getCreateCollectionInfo() {
		List<WebElement> collectionHeadervalue;
		List<String> collectionInfo = new ArrayList<>();
		try {
			collectionHeadervalue = Locators.getInstance().getAdminPlantHeaderInfo(driver);
			for (int i = 0; i < collectionHeadervalue.size()-1; i++) 
				collectionInfo.add(Keywords.getText(collectionHeadervalue.get(i)));
		}catch(Exception e) {}

		return collectionInfo;
	}
}
