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


public class AdminPlant {

	private WebDriver driver;

	public AdminPlant(WebDriver driver) {
		this.driver = driver;
	}

	public String selectOwnerType(String ownerType) {
		String ownerinfo = ownerType;
		try {
			Keywords.waitForPage(driver);
			if (ownerinfo.equalsIgnoreCase("user"))
				Keywords.clickOnDisableElement("plant_owner_type_User");
			else
				Keywords.clickOnDisableElement("plant_owner_type_Organization");
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
			element = Locators.getInstance().addPlantOwnerIdOrSlug(driver);
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

	public String addPlantTitle() {
		WebElement element;
		String plantTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminPlantTitle(driver);
			plantTitle = "AdminPlant" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, plantTitle);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Title entered successfully",
						"PASS", "Plant Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant Title not entered successfully", "FAIL", "Plant Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the plant title", "FAIL", "Plant Title should be entered");
		}

		return plantTitle;
	}

	public void addPlantImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "adminPlant.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().addAdminPlantImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Image uploaded successfully",
						"PASS", "Plant Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Image not uploaded successfully",
						"FAIL", "Plant Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploade the plant Image", "FAIL", "Plant Image should be uploaded");
		}
	}

	public String addPlantStory() {
		WebElement element;
		String plantStory = "This is admin plant description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminPlantStory(driver);
			Keywords.enterTextByJS(element, plantStory, "arguments[0].textContent= arguments[1];");
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Story entered successfully",
						"PASS", "Plant Story should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant Story not entered successfully", "FAIL", "Plant Story should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the plant story", "FAIL", "Plant Story should be entered");
		}
		return plantStory;
	}

	public String makeYourLocation(String locationType) {
		String location = "";
		try {
			Keywords.waitForPage(driver);
			if (locationType.contains("public")) 
				Keywords.clickOnDisableElement("plant_location_private_false");
			else
				Keywords.clickOnDisableElement("plant_location_private_true");
			location = locationType;
		} catch (Exception e) {}

		return location;
	}

	public String addAddress(String locationType) {
		WebElement element;
		Plants plant = new Plants(driver);
		List<String> addressList = plant.getAddressList();
		String address = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminPlantAddress(driver);
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.typeText(element, address);
			address = plant.selectSuggestedAddress();
			makeYourLocation(locationType);
		} catch (Exception e) {}

		return address;
	}

	public List<String> getCreatePlantInfo() {
		List<WebElement> plantHeadervalue;
		List<String> plantInfo = new ArrayList<>();
		try {
			plantHeadervalue = Locators.getInstance().getAdminPlantHeaderInfo(driver);
			for (int i = 0; i < plantHeadervalue.size()-1; i++) 
				plantInfo.add(Keywords.getText(plantHeadervalue.get(i)));
		}catch(Exception e) {}

		return plantInfo;
	}
}
