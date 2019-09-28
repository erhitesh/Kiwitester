package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;


public class AdminOrganization {
	
	private WebDriver driver;
	
	public AdminOrganization(WebDriver driver) {
		this.driver = driver;
	}	

	public void addOrgImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "aminOrg.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().adminOrgImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Image uploaded successfully",
						"PASS", "Organization Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Image not uploaded successfully",
						"FAIL", "Organization Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the Organization Image", "FAIL", "Organization Image should be uploaded");
		}
	}
	
	public void addOrgCoverImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "cover.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().adminOrgCoverImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Cover Image uploaded successfully",
						"PASS", "Organization Cover Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Cover Image not uploaded successfully",
						"FAIL", "Organization Cover Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the Organization Cover Image", "FAIL", "Organization Cover Image should be uploaded");
		}
	}
	
	public String enterOwnerIdOrSlug() {
		WebElement element;
		String ownerIdOrSlug = DriverSession.getTestCaseData().get("UserOwnerId");
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminOrgSlugId(driver);
			Keywords.typeText(element, ownerIdOrSlug);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Id/Slug</b> enter successfully", "PASS", "<b>User Id/Slug</b> should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Id/Slug</b> not enter successfully", "FAIL", "<b>User Id/Slug</b> should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>User Id/Slug</b>", "FAIL", "<b>User Id/Slug</b> should be enter");
		}

		return ownerIdOrSlug;
	}
	
	public String addAdminOrgTitle() {
		WebElement element;
		String orgTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminOrgTitle(driver);
			orgTitle = "AdminOrg" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, orgTitle);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Title entered successfully",
						"PASS", "Organization Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Title not entered successfully", "FAIL", "Organization Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Organization title", "FAIL", "Organization Title should be entered");
		}

		return orgTitle;
	}
	
	public String addAdminOrgStory() {
		WebElement element;
		String orgStory = "This is admin org description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAdminOrgStory(driver);
			Keywords.enterTextByJS(element, orgStory, "arguments[0].textContent= arguments[1];");
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Organization Story entered successfully",
						"PASS", "Organization Story should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Story not entered successfully", "FAIL", "Organization Story should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Organization story", "FAIL", "Organization Story should be entered");
		}
		return orgStory;
	}

	
	public String makeYourLocation(String locationType) {
		String location = "";
		try {
			Keywords.waitForPage(driver);
			if (locationType.contains("public")) 
				Keywords.clickOnDisableElement("organization_location_private_false");
			else
				Keywords.clickOnDisableElement("organization_location_private_true");
			location = locationType;
		} catch (Exception e) {}

		return location;
	}

	public String addAddress(String locationType) {
		WebElement element;
		Plants plant = new Plants(driver);
		List<String> addressList = plant.getAddressList();
		String address = "";
		String locationPrivacy = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminOrgAddress(driver);
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.typeText(element, address);
			address = plant.selectSuggestedAddress();
			locationPrivacy = makeYourLocation(locationType);
		} catch (Exception e) {}

		return locationPrivacy;//address;
	}
	
	public String getAdminOrgTitle() {
		WebElement element;
		String orgName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionTitle(driver);
			orgName = element.getText();
		} catch (Exception e) {}

		return orgName;
	}

	public String getAdminOrgDescription() {
		WebElement element;
		String collectionDescription = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionDescription(driver);
			collectionDescription = element.getText();
		} catch (Exception e) {}

		return collectionDescription;
	}

	public String getAdminOrgLocationPrivacy() {
		WebElement element;
		String locationPrivacy = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getOrgLocationPrivacy(driver);
			locationPrivacy = element.getText();
		} catch (Exception e) {}

		return locationPrivacy;
	}
}
