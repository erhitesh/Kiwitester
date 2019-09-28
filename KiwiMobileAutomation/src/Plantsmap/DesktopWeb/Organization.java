package Plantsmap.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class Organization {

	private WebDriver driver;

	public Organization(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getWeekDays() {
		List<String> days = new ArrayList<>();
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");

		return days;
	}

	public String selectOrganizationFromProfile(String organizationName) {
		List<WebElement> elementList;
		String organization = "";
		try {
			Profile profile = new Profile(driver);
			organization = profile.getProfileType();
			profile.enableProfileHideContent();
			elementList = Locators.getInstance().getOrganizationList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (elementList.get(i).getText().contains(organizationName)) {
					organization = Keywords.getText(elementList.get(i));
					Keywords.click(elementList.get(i));
					Thread.sleep(2000);
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						organizationName + " selected successfully", "PASS", organizationName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						organizationName + " not selected successfully", "FAIL",
						organizationName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the " + organizationName, "FAIL",
					organizationName + " should be selected");
		}

		return organization;
	}

	public void selectOrgFromCommunityList(String orgTitleName) {
		List<WebElement> orgList = new ArrayList<WebElement>();
		try {
			Keywords.waitForPage(driver, 3);
			orgList = Locators.getInstance().selectOrgFromCommunity(driver);
			for (int i = 0; i < orgList.size(); i++) {
				if (Keywords.getText(orgList.get(i)).contains(orgTitleName)) {
					Keywords.clickByIndex(orgList, i);
					Keywords.waitForPage(driver, 2);
					break;
				}
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						orgTitleName + " selected from community list", "PASS", orgTitleName + " should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						orgTitleName + " not selected from community list", "FAIL",
						orgTitleName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + orgTitleName + " from community list", "FAIL",
					orgTitleName + " should be selected");
		}
	}

	public void clickOnAddNewOrganization() {
		WebElement element;
		String currentUrl = "";
		try {
			currentUrl = Keywords.getCurrentUrl(driver);
			Profile profile = new Profile(driver);
			profile.enableProfileHideContent();
			if (!currentUrl.contains("organization")) {
				element = Locators.getInstance().addOrganizationLinkedText(driver);
				Keywords.click(element);
			}
		} catch (Exception e) {

		}
	}

	public void verifyAddNewOrganizationHeader() {
		WebElement element;
		String text = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewPlantCollectionOrganizationProfileHeader(driver);
			text = Keywords.getText(element);
			Keywords.verifyTextOnPage(text);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add New Organization Header present", "PASS",
						"Add New Organization Header text should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add New Organization Header not present", "FAIL",
						"Add New Organization Header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while check the visibility of Add New Organization Header Text", "FAIL",
					"Add New Organization Header text should be present");
		}
	}

	public String addOrganizationTitle() {
		WebElement element;
		String organizationTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantTitle(driver);
			organizationTitle = "OrganizationTitle" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, organizationTitle);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Title entered successfully", "PASS", "Organization Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization title not entered successfully", "FAIL", "Organization Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the Organization title", "FAIL",
					"Organization Title should be entered");
		}
		return organizationTitle;
	}

	public String addOrganizationDescription() {
		WebElement element;
		String organizationDescription = "This is Organization description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantCollectionOrganizationDescription(driver);
			Keywords.enterTextByJS(element, organizationDescription, "arguments[0].textContent= arguments[1];");
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Description entered successfully", "PASS",
						"Organization Description should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Description not entered successfully", "FAIL",
						"Organization Description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the Organization Description", "FAIL",
					"Organization Description should be entered");
		}
		return organizationDescription;
	}

	/*
	 * public String addAddress(String location) { WebElement element; String
	 * address = "Noida"; try { Keywords.waitForPage(driver); element =
	 * Locators.getInstance().addAddress(driver); Keywords.typeText(element,
	 * address); makeYourLocation(location); selectSuggestedAddress(); element =
	 * Locators.getInstance().addAddress(driver); address =
	 * Keywords.getText(element); } catch (Exception e) { }
	 * 
	 * return address; }
	 */

	public String addAddress(String location) {
		WebElement element;
		Plants plant = new Plants(driver);
		List<String> addressList = plant.getAddressList();
		String address = "";
		try {
			address = addressList.get(Keywords.getRandomInteger(addressList.size()));
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			Keywords.typeText(element, address);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Address entered successfully",
						"PASS", "Address should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Address not entered successfully",
						"FAIL", "Address should be entered");
			address = selectSuggestedAddress();
			makeYourLocation(location);
		} catch (Exception e) {
		}

		return address;
	}

	public String selectSuggestedAddress() {
		String suggestedAddress = "";
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().suggestedAddress(driver);
			if (Keywords.isElementPresent(element)) {
				suggestedAddress = Keywords.getText(element);
				Keywords.click(element);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							suggestedAddress + " address selected successfully", "PASS",
							suggestedAddress + " address should be selected");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							suggestedAddress + " address not selected successfully", "FAIl",
							suggestedAddress + " address should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the suggested addrss from suggested address list"
							+ suggestedAddress,
					"FAIL", suggestedAddress + " address should be selected");
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
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting make your location " + locationType, "FAIL",
					"Make your location " + locationType + " should be click");
		}

		return location;
	}

	public void verifyImageDimensionFormatForCoverPhoto() {
		WebElement element;
		try {
			element = Locators.getInstance().imageDimensionFormatForCoverPhotoOrg(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format verify successfully for org cover photo", "PASS",
						"Image Dimension format should be verified for org cover photo");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format not verify successfully for org cover photo", "FAIL",
						"Image Dimension format should be verified for org cover photo");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Image Dimension format for org cover photo", "FAIL",
					"Image Dimension format should be verified for org cover photo");
		}
	}

	public void verifyImageDimensionFormatForProfile() {
		WebElement element;
		try {
			element = Locators.getInstance().imageDimensionFormatForProfileOrg(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format verify successfully for org profile photo", "PASS",
						"Image Dimension format should be verified for org profile photo");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format not verify successfully for org profile photo", "FAIL",
						"Image Dimension format should be verified");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Image Dimension format for org profile photo", "FAIL",
					"Image Dimension format should be verified for org profile photo");
		}
	}

	public void addOrgainzationProfileImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "cover.jpg";
		try {
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addPlantCollectionOrganizationImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Image upload successfully", "PASS", "Organization Image should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Image not upload successfully", "FAIL", "Organization Image should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading Organization Image", "FAIL",
					"Organization Image should be upload");
		}
	}

	public void addOrgainzationCoverImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "profile.jpg";
		try {
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addCoverPhoto(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Image upload successfully", "PASS", "Organization Image should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization Image not upload successfully", "FAIL", "Organization Image should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading Organization Image", "FAIL",
					"Organization Image should be upload");
		}
	}

	public void clickOnSaveButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().savePlantCollectionOrganizationPage(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Save button click successfully</b>",
						"PASS", "<b>Save button should be click</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Save button not click successfully</b>", "FAIL", "<b>Save button should be click</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Save button", "FAIL", "<b>Save button should be click</b>");
		}
	}

	public void organizationSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().updateSuccessfullyPlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitDonePlantAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Organization</b> added successfully", "PASS", "<b>Organization</b> should be added");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Organization</b> not added successfully", "FAIL", "<b>Organization</b> should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding <b>Organization</b>", "FAIL",
					"<b>Organization</b> should be added");
		}
	}

	public void clickOnEventSaveButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().savePlantCollectionOrganizationPage(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Save button click successfully", "PASS", "Event Save button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Save button not click successfully", "FAIL", "Event Save button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Event Save button", "FAIL",
					"Event Save button should be click");
		}
	}

	public void eventSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 3);
			element = Locators.getInstance().updateSuccessfullyPlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitDonePlantAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event added successfully", "PASS",
						"Event should be added");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event not added successfully",
						"FAIL", "Event should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the Event", "FAIL", "Event should be added");
		}
	}

	public String getAddedOrgName() {
		String orgName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getOrganizationName(driver);
			orgName = Keywords.getText(element);
		} catch (Exception e) {
		}

		return orgName;
	}

	public void verifyAddedOrganization(String expectedOrgName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getOrganizationName(driver);
			Keywords.verifyTextMessage(Keywords.getText(element), expectedOrgName);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Added Organization visible successfully", "PASS", "Added Organization should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Added Organization not visible successfully", "FAIL", "Added Organization should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Added Organization present", "FAIL",
					"Added Organization should be present");
		}
	}

	public void clickOnEditBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().editOrganization(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver, 3);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Edit Button click successfully",
						"PASS", "Edit button should be click");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Edit Button not click successfully", "FAIL", "Edit button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Edit Button", "FAIL", "Edit button should be click");
		}
	}

	public void clickOnManageNetwork() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().manageNetwork(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver, 3);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Edit Button click successfully",
						"PASS", "Edit button should be click");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Edit Button not click successfully", "FAIL", "Edit button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Edit Button", "FAIL", "Edit button should be click");
		}
	}

	public String requestFromUser(String orgTitle) {
		List<WebElement> userList;
		List<WebElement> requestList;
		try {
			userList = Locators.getInstance().getUserListForNetworkRequest(driver);
			requestList = Locators.getInstance().userRequestLabel(driver);
			for (int i = 0; i < userList.size(); i++) {
				if (Keywords.getText(userList.get(i)).equalsIgnoreCase(orgTitle)) {
					Keywords.click(requestList.get(i));
					Thread.sleep(2000l);
				}
			}
		} catch (Exception e) {

		}

		return orgTitle;
	}

	public void verifyOrganizationEditHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewPlantCollectionOrganizationProfileHeader(driver);
			Keywords.verifyTextOnPage(element.getText());

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization edit page header text visible successfully", "PASS",
						"Organization edit header text should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Organization edit page header text not visible successfully", "FAIL",
						"Organization edit header text should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Organization edit page header text", "FAIL",
					"Organization edit header text should be visible");
		}
	}
	
	public boolean orgDeleteBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().deleteOrg(driver);
			status = Keywords.isElementPresent(element);
		}catch(Exception e) {
			
		}
		return status;
	}
	

	public void clickOnDeleteOrg() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().deleteOrg(driver);
			/*// Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().deleteOrg(driver);
			while (Keywords.isElementPresent(element)) {
				Keywords.click(element);
				Keywords.acceptAlert();
			}*/
			while (orgDeleteBtnStatus()) {
				Keywords.click(element);
				Thread.sleep(5000l);
				Keywords.acceptAlert();
				if (Keywords.isElementPresent(Locators.getInstance().submitDeleteOrgPopUp(driver))) {
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Delete Button</b> click successfully", "PASS", "<b>Delete Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Delete Button</b> not click successfully", "FAIL", "<b>Delete Button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the <b>Delete Button</b>", "FAIL",
					"<b>Delete Button</b> should be click");
		}
	}

	public void submitDeleteOrganizationPopUp() {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().submitDeleteOrgPopUp(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Delete popup submit successfully",
						"PASS", "Delete popup should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Delete popup not submit successfully", "FAIL", "Delete popup should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submit delete org popup", "FAIL", "Delete popup should be submit");
		}
	}

	public void verifyDeleteOrganizationClickSuccessfully() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().requestDeletedLinkedText(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Requested Delete button</b> verify successfully", "PASS",
						"<b>Requested Delete button</b> should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Requested Delete button</b> not verify successfully", "FAIL",
						"<b>Requested Delete button</b> should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verify the <b>Requested Delete button</b>", "FAIL",
					"<b>Requested Delete button</b> should be present");
		}
	}

	public void verifyOrgAfterDelete(String orgName) {
		List<WebElement> orgList;
		try {
			Profile profile = new Profile(driver);
			profile.enableProfileHideContent();
			Keywords.waitForPage(driver);
			orgList = Locators.getInstance().getOrganizationList(driver);
			for (WebElement ele : orgList) {
				if (ele.getText().equalsIgnoreCase(orgName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							orgName + " not removed successfully", "FAIL", orgName + " should be removed");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing " + orgName, "FAIL", orgName + " should be removed");
		}
	}

	// ************************************** Event
	// *****************************
	public void verifyAddNewEventHeader() {
		WebElement element;
		String text = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewPlantCollectionOrganizationProfileHeader(driver);
			text = element.getText();
			Keywords.verifyTextOnPage(text);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("AddNewEvent Header present",
						"PASS", "AddNewEvent Header text should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("AddNewEvent Header not present",
						"FAIL", "AddNewEvent Header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while check the visibility of AddNewEvent Header Text", "FAIL",
					"AddNewEvent Header text should be present");
		}
	}

	public String addEventTitle() {
		WebElement element;
		String eventTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().eventTitle(driver);
			eventTitle = "PlantsmapEvent" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, eventTitle);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event Title entered successfully",
						"PASS", "Event Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Title not entered successfully", "FAIL", "Event Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the Event title", "FAIL", "Event Title should be entered");
		}

		return eventTitle;
	}

	public void enableMonthCalendar(String event) {
		WebElement element = null;
		try {
			Keywords.waitForPageLoad(driver);
			if (event.equalsIgnoreCase("start month"))
				element = Locators.getInstance().enterEventEndDate(driver);
			else if (event.equalsIgnoreCase("end month"))
				element = Locators.getInstance().enterEventEndDate(driver);
			element.click();
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void enableTimeList(String time) {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			if (time.equalsIgnoreCase("start time"))
				element = Locators.getInstance().enableEventStartTime(driver);
			else if (time.equalsIgnoreCase("end time"))
				element = Locators.getInstance().enableEventEndTime(driver);
			element.click();

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start time textbox click successfully", "PASS",
						"Event start time textbox should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start time textbox not click successfully", "FAIL",
						"Event start time textbox should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking Event start time textbox", "FAIL",
					"Event start time textbox should be clicked");
		}
	}

	public void addEventStartDate(/* String event */) {
		WebElement element;
		String dateValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterEventStartDate(driver);
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 1);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateValue = format.format(newDate);
			Keywords.makeTextBoxReadable("document.getElementById('eventStartDate').removeAttribute('readonly');");
			Keywords.typeText(element, dateValue);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start date enter successfully", "PASS", "Event start date should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start date not enter successfully", "FAIL", "Event start date should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Event start date", "FAIL", "Event start date should be enter");
		}
	}

	public void addEventEndDate() {
		WebElement element;
		String eventEndDate = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterEventEndDate(driver);
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 2);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			eventEndDate = format.format(newDate);
			Keywords.enterTextByJS(element, eventEndDate,
					"document.getElementById('eventEndDate').value = '" + eventEndDate + "';");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event End date enter successfully",
						"PASS", "Event End date should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event End date not enter successfully", "FAIL", "Event End date should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Event End date", "FAIL", "Event End date should be enter");
		}
	}

	public String getEventEndTime() {
		String endTime = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enableEventEndTime(driver);
			endTime = Keywords.getTextFromTextBox("eventEndTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return endTime;
	}

	public String addEventStartTime(String time) {
		List<WebElement> timeList;
		int randomValue = 0;
		String startTime = "";
		try {
			enableTimeList(time);
			Keywords.waitForPage(driver);
			timeList = Locators.getInstance().selectRandomTimeValue(driver);
			randomValue = Keywords.getRandomInteger(timeList.size() - 1);
			startTime = Keywords.getText(timeList.get(randomValue));
			Keywords.click(timeList.get(randomValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start time enter successfully", "PASS", "Event start time should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event start time not enter successfully", "FAIL", "Event start time should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Event start time", "FAIL", "Event start time should be enter");
		}

		return startTime;
	}

	public void addEventImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "plant.jpg";
		try {
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addPlantCollectionOrganizationImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event Image uploaded successfully",
						"PASS", "Event Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event Image uploaded successfully",
						"FAIL", "Event Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploade the Event Image", "FAIL", "Event Image should be uploaded");
		}
	}

	public String addEventPrice() {
		WebElement element;
		int maxRange = Integer.parseInt(DriverSession.getTestCaseData().get("MaxRange"));
		int minRange = Integer.parseInt(DriverSession.getTestCaseData().get("MinRange"));
		String price = Keywords.getRandomIntegerBtRange(minRange, maxRange) + "";// Keywords.getRandomIntegerBtRange(1000,
																					// 5000)
																					// +
																					// "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().eventPrice(driver);
			Keywords.typeText(element, price);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event Price enter successfully",
						"PASS", "Event Price should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Price not enter successfully", "FAIL", "Event Price should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Event Price", "FAIL", "Event Price should be entered");
		}

		return price;
	}

	public String addEventDescription() {
		WebElement element;
		String eventDescription = DriverSession.getTestCaseData().get("EventDescriptionMessage");// "This
																									// is
																									// plantsmap
																									// Event
																									// description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantCollectionOrganizationDescription(driver);
			Keywords.enterTextByJS(element, eventDescription, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Description entered successfully", "PASS", "Event Description should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Event Description not entered successfully", "FAIL", "Event Description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entered the Event Description", "FAIL",
					"Event Description should be entered");
		}
		return eventDescription;
	}

	public String addAddress() {
		WebElement element;
		String address = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			address = plant.getAddressList().get(Keywords.getRandomInteger(plant.getAddressList().size()));
			// System.out.println("Address..."+address);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			Keywords.typeText(element, address);
			address = selectSuggestedAddress();

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						address + " Address enter successfully", "PASS", address + " Address should be enetered.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						address + " Address not enter successfully", "FAIL", address + " Address should be enetered.");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the " + address + " Address", "FAIL",
					address + " Address should be enetered.");
		}

		return address;
	}

	public void visileEventCategoryList() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().visibleEventCategoryList(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Select Event Category</b> click successfully", "PASS",
						"<b>Select Event Category</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Select Event Category</b> not click successfully", "FAIL",
						"<b>Select Event Category</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Select Event Category</b>", "FAIL",
					"<b>Select Event Category</b> should be click");
		}
	}

	public String getSelectedEventCategory() {
		List<WebElement> list;
		String randomEventCategory = "";
		int randomNumber = 0;
		String finalEventCategoryNames = "";
		try {
			visileEventCategoryList();
			list = Locators.getInstance().eventCategoryList(driver);
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			randomEventCategory = Keywords.getText(list.get(randomNumber));
			finalEventCategoryNames = randomEventCategory;
			Keywords.click(list.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						randomEventCategory + " select successfully", "PASS",
						randomEventCategory + " should be select");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						randomEventCategory + " not select successfully", "FAIL",
						randomEventCategory + " should be select");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + randomEventCategory, "FAIL",
					randomEventCategory + " should be select");
		}

		return finalEventCategoryNames;
	}

	public void clickOnPromoteToExplore() {
		WebElement element;
		// boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().promoteToExplore(driver);
			if (!element.isSelected())
				Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Promote To Explore Checkbox click successfully", "PASS",
						"Promote To Explore Checkbox Should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Promote To Explore Checkbox not click successfully", "FAIL",
						"Promote To Explore Checkbox Should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Promote To Explore checkbox", "FAIL",
					"Promote To Explore Checkbox Should be click");
		}
	}

	public void clickOnRecurringEvent() {
		WebElement element;
		WebElement checkBoxElement;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().recurringEvent(driver);
			if (!element.isSelected()) {
				checkBoxElement = Locators.getInstance().reccurringEventCheckBox(driver);
				Keywords.click(checkBoxElement);
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Recurring Events Checkbox click successfully", "PASS",
						"Recurring Events Checkbox Should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Recurring Events Checkbox not click successfully", "FAIL",
						"Recurring Events Checkbox Should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Recurring Events checkbox", "FAIL",
					"Recurring Events Checkbox Should be click");
		}
	}

	public int selectEventOccurrenceType() {
		int numberOfOccurrence = 0;
		WebElement element;
		WebElement checkBox;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().endsWithOccureanceOrDate(driver, "occurrence");
			if (!element.isSelected()) {
				checkBox = Locators.getInstance().endsWithOccurenceCheckBox(driver);
				Keywords.click(checkBox);
			}
			element = Locators.getInstance().eneterOccurrenceValue(driver);
			numberOfOccurrence = Keywords.getRandomInteger(10);
			if (numberOfOccurrence == 0)
				numberOfOccurrence++;
			Keywords.typeText(element, numberOfOccurrence + "");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Repeats Recurring Events enter successfully", "PASS",
						"Repeats Recurring Events Should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Repeats Recurring Events not enter successfully", "FAIL",
						"Repeats Recurring Events Should be enter");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enter event occurrence value", "FAIL",
					"Repeats Recurring Events Should be enter");
		}
		return numberOfOccurrence;
	}

	public String selectWeekDays(int occurrence) {
		List<Integer> indexList = new ArrayList<>();
		List<String> selectedWeekDaysValue = new ArrayList<>();
		List<WebElement> weekDaysList;
		String eventOccurrenceWithWeekDaysValue = "";
		int j = 0;
		int r = 0;
		try {
			weekDaysList = Locators.getInstance().selectWeekdays(driver);
			for (int i = 0; i < weekDaysList.size() / 2; i++) {
				if (i == 0) {
					j = Keywords.getRandomInteger(weekDaysList.size());
					Keywords.clickByIndex(weekDaysList, j);
				} else {
					if (r == j) {
						j = Keywords.getRandomInteger(weekDaysList.size());
						Keywords.clickByIndex(weekDaysList, j);
					} else {
						Keywords.clickByIndex(weekDaysList, j);
					}
				}
				indexList.add(j);
				r = j;
				j = Keywords.getRandomInteger(weekDaysList.size());

				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"WeekDays value selected successfully", "PASS", "WeekDays value should be selected");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"WeekDays value selected successfully", "FAIL", "WeekDays value should be selected");
			}
			/*
			 * selectedWeekDaysValue =
			 * Keywords.getWeekDaysValueByIndex(Keywords.sortNumberArray(
			 * indexList)); for (int k = 0; k < selectedWeekDaysValue.size();
			 * k++) { eventOccurrenceWithWeekDaysValue =
			 * eventOccurrenceWithWeekDaysValue+selectedWeekDaysValue.get(k)+
			 * ","; } System.out.println(selectedWeekDaysValue);
			 * eventOccurrenceWithWeekDaysValue =
			 * selectedWeekDaysValue.toString();
			 * System.out.println(eventOccurrenceWithWeekDaysValue);
			 */
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting weekdays value", "FAIL", "WeekDays value should be selected");
		}

		return eventOccurrenceWithWeekDaysValue;
	}

	public String selectMonthDays() {
		List<String> days = getWeekDays();
		List<WebElement> list;
		String monthDays = "";
		HashMap<String, String> daysList = new HashMap<>();
		int randomNuber = 0;
		String randomNumberAppendStr = "";
		try {
			for (int i = 0; i < days.size(); i++) {
				list = Locators.getInstance().selectMonthDays(driver, days.get(i).toLowerCase());
				for (int j = 0; j < list.size();) {
					randomNuber = Keywords.getRandomInteger(list.size());
					if (randomNuber == 0)
						randomNumberAppendStr = "1st";
					else if (randomNuber == 1)
						randomNumberAppendStr = "2nd";
					else if (randomNuber == 2)
						randomNumberAppendStr = "3rd";
					else if (randomNuber == 3)
						randomNumberAppendStr = "4th";
					else if (randomNuber == 4)
						randomNumberAppendStr = "last";
					list.get(randomNuber).click();
					daysList.put(randomNumberAppendStr, days.get(i).toString());

					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Month week days value</b> selected successfully", "PASS",
						"Month week days value should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Month week days value</b> not selected successfully", "FAIL",
						"Month week days value should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Month week days value</b>", "FAIL",
					"Month week days value should be selected");
		}

		return monthDays;
	}

	public List<String> selectRandomReccurringEvent() {
		List<String> list = new ArrayList<>();
		// list.add("Singular");
		// list.add("Daily");
		// list.add("Weekly");
		list.add("Monthly");

		return list;
	}

	public List<Object> selectEventRepeats(/* String visibleText */) {
		List<Object> obj = new ArrayList<>();
		int repeatsNumber = 0;
		String eventMessage = "";
		WebElement element;
		String visibleText;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectRepeatEventDropDown(driver);
			visibleText = selectRandomReccurringEvent()
					.get(Keywords.getRandomInteger(selectRandomReccurringEvent().size()));
			Keywords.selectByVisibleText(element, visibleText);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Repeats Dropdown value " + visibleText + " selected successfully", "PASS",
						"Repeats Dropdown value should be selected.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Repeats Dropdown value " + visibleText + " not selected successfully", "FAIL",
						"Repeats Dropdown value should be selected.");

			if (visibleText.equalsIgnoreCase("singular")) {
				repeatsNumber = 1;
			} else if (visibleText.equalsIgnoreCase("daily")) {
				repeatsNumber = selectEventOccurrenceType();
				eventMessage = visibleText + " " + repeatsNumber + " times";
			} else if (visibleText.equalsIgnoreCase("weekly")) {
				repeatsNumber = selectEventOccurrenceType();
				selectWeekDays(repeatsNumber);
				// eventMessage = selectWeekDays(repeatsNumber);
				eventMessage = visibleText + " " + repeatsNumber + " times on ";// +eventMessage;
			} else if (visibleText.equalsIgnoreCase("monthly")) {
				repeatsNumber = selectEventOccurrenceType();
				selectMonthDays();
			}

			obj.add(0, repeatsNumber);
			obj.add(1, eventMessage);

		} catch (Exception e) {
		}

		return obj;// repeatsNumber;
	}

	public String getEventName() {
		WebElement element;
		String eventName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getEventName(driver);
			eventName = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventName;
	}

	public String getEventPrice() {
		WebElement element;
		String eventPrice = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getEventPrice(driver);
			eventPrice = Keywords.getText(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventPrice;
	}

	public String getEventCategory() {
		WebElement element;
		String eventPrice = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getEventCategory(driver);
			eventPrice = Keywords.getText(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventPrice;
	}

	public String getEventAddress() {
		WebElement element;
		String eventAddress = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getEventAddress(driver);
			eventAddress = Keywords.getText(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventAddress;
	}

	public String getEventTime() {
		WebElement element;
		String time = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getEventTime(driver);
			time = Keywords.getText(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return time;
	}

	public void submitSearch() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitEventSearchButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Button click successfully",
						"PASS", "Search Button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search Button not click successfully", "FAIL", "Search Button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the Search Button", "FAIL", "Search Button should be click");
		}
	}

	public void searchEvent(String searchType, String searchEventName) {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			if (searchType.equalsIgnoreCase("title"))
				element = Locators.getInstance().searchEventByTitle(driver);
			else if (searchType.equalsIgnoreCase("location"))
				element = Locators.getInstance().searchEventByLocation(driver);
			else if (searchType.equalsIgnoreCase("state"))
				element = Locators.getInstance().searchEventByState(driver);

			Keywords.typeText(element, searchEventName);
			Keywords.waitForPageFullyLoaded(driver);
			submitSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetSearch() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickResetSearch(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search Reset link click successfully", "PASS", "Search Reset link should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search Reset link not click successfully", "FAIL", "Search Reset link should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the Search Reset link", "FAIL",
					"Search Reset link should be click");
		}
	}

	public void verifyReccuringEventCount(int eventCount) {
		List<WebElement> eventList;
		WebElement element;
		try {
			Thread.sleep(2000);
			Keywords.waitForPageFullyLoaded(driver);
			eventList = Locators.getInstance().getEventList(driver);
			if (eventList.size() == eventCount) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Reccuring Event count match with search one result", "PASS",
							"Reccuring event count should be matched with search result");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Reccuring Event count not match with search one result", "FAIL",
							"Reccuring event count should be matched with search result");
			} else if (eventList.size() <= 0) {
				element = Locators.getInstance().noEventTxt(driver);
				Keywords.verifyTextOnPage(Keywords.getText(element));
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>There are no events</b> message not found successfully", "PASS",
							"<b>There are no events</b> should be present");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>There are no events</b> message found", "FAIL",
							"<b>There are no events</b> should be present");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing reccurring event count and search result count", "FAIL",
					"Reccuring event count should be matched with search result");
		}
	}

	public String selectEventFromEventSearchList(String eventName) {
		String eventname = "";
		List<WebElement> eventList;
		WebElement element;
		try {
			Thread.sleep(2000);
			Keywords.waitForPageFullyLoaded(driver);
			eventList = Locators.getInstance().getEventList(driver);
			if (eventList.size() >= 1) {
				for (WebElement ele : eventList) {
					eventname = Keywords.getText(ele).trim();
					// System.out.println("Event Name..."+eventname);
					if (eventname.equalsIgnoreCase(eventName)) {
						Keywords.click(ele);
						Keywords.waitForPage(driver);
						break;
					}
				}
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Event successfully selected from search result", "PASS",
							"Event from search result should be selected");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Event not selected from search result", "FAIL",
							"Event from search result should be selected");

			} else if (eventList.size() <= 0) {
				element = Locators.getInstance().noEventTxt(driver);
				Keywords.verifyTextOnPage(Keywords.getText(element));
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>There are no events</b> message not found successfully", "PASS",
							"<b>There are no events</b> should be present");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>There are no events</b> message found", "FAIL",
							"<b>There are no events</b> should be present");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting event from search result", "FAIL",
					"Event from search result should be selected");
		}

		return eventname;
	}

	public List<String> getEventNameListFromEventSearchPage() {
		List<WebElement> elementList;
		List<String> eventList = new ArrayList<>();
		try {
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().getEventList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				eventList.add(Keywords.getText(elementList.get(i)).trim());
			}
		} catch (Exception e) {
		}

		return eventList;
	}

	public void verifyEventNameAfterSelectingIndex(List<String> eventNameBeforeChanges,
			List<String> eventNameAfterChanges) {
		int randomNumber = 0;
		if (eventNameBeforeChanges.size() == eventNameAfterChanges.size()) {
			randomNumber = Keywords.getRandomInteger(eventNameAfterChanges.size());
			if (!eventNameBeforeChanges.get(randomNumber).equalsIgnoreCase(eventNameAfterChanges.get(randomNumber))) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Event Name different</b>",
						"PASS", "<b>Event Name should be different</b>");
			} else if (eventNameBeforeChanges.get(randomNumber)
					.equalsIgnoreCase(eventNameAfterChanges.get(randomNumber))) {

			}
		}
	}

	public void clickOnEventDelete() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().eventDeleteBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Delete button click successfully",
						"PASS", "Event Delete button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Delete button not click successfully", "FAIL", "Event Delete button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the event delete button", "FAIL",
					"Event Delete button should be click");
		}
	}

	public void eventSuccessfullyDeleted() {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 2);
			element = Locators.getInstance().eventDeleteAlertMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitEventDeleteAlert(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver, 2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event deleted successfully",
						"PASS", "Event should be deleted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Event not deleted successfully",
						"FAIL", "Event should be deleted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while deleting Event", "FAIL", "Event should be deleted");
		}
	}

	public void recurringEventSuccessfullyDeleted(String applyOn) {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 2);
			element = Locators.getInstance().eventDeleteAlertMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitRecurringApplyEvent(driver, applyOn);
			Keywords.click(element);
			Keywords.waitForPage(driver, 2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Recurring Event deleted successfully", "PASS", "Recurring Event should be deleted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Recurring Event not deleted successfully", "FAIL", "Recurring Event should be deleted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting Recurring Event", "FAIL", "Recurring Event should be deleted");
		}
	}

	public String getMonthValueFromEventPage() {
		WebElement element;
		String monthValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getMonthValue(driver);
			monthValue = Keywords.getText(element);
			if (monthValue.length() > 3) {
				monthValue = monthValue.substring(0, 3);
			}
			System.out.println("Month Value..." + monthValue);
		} catch (Exception e) {
		}

		return monthValue;
	}

	public String getMonthFullValueFromEventPage() {
		WebElement element;
		String monthValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getMonthValue(driver);
			monthValue = Keywords.getText(element);
			System.out.println("Month Value..." + monthValue);
		} catch (Exception e) {
		}

		return monthValue;
	}

	public String getYearValueFromEventPage() {
		WebElement element;
		String yearValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getYearValue(driver);
			yearValue = Keywords.getText(element);
			// System.out.println("Year Value..." + yearValue);
		} catch (Exception e) {
		}

		return yearValue;
	}

	public String clickOnMonthNextArrow() {
		WebElement element;
		String selectedValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnMonthNextArrow(driver);
			Keywords.click(element);
			Keywords.waitForPageFullyLoaded(driver);
			Thread.sleep(5000);
			element = Locators.getInstance().getMonthValue(driver);
			selectedValue = Keywords.getText(element);
			if (selectedValue.length() > 3) {
				selectedValue = selectedValue.substring(0, 3);
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Arrow click successfully</b>", "PASS", "<b>Next Arrow should be clicked</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Next Arrow</b>", "FAIL",
					"<b>Next Arrow should be clicked</b>");
		}

		return selectedValue;
	}

	public String clickOnYearNextArrow() {
		WebElement element;
		String selectedValue = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnYearNextArrow(driver);
			Keywords.click(element);
			Keywords.waitForPageFullyLoaded(driver);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getYearValue(driver);
			selectedValue = Keywords.getText(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Arrow click successfully</b>", "PASS", "<b>Next Arrow should be clicked</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Next Arrow</b>", "FAIL",
					"<b>Next Arrow should be clicked</b>");
		}

		return selectedValue;
	}

	public String verifyPreviousArrowForOneLessToCurrentMonth() {
		WebElement element;
		String selectedValue = "";
		try {
			Thread.sleep(2000l);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnMonthPreviousArrow(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnMonthPreviousArrow(driver);
			selectedValue = Keywords.getAttributeVal(element, "disabled");
			// System.out.println("Element Attribute value..."+selectedValue);
			if (selectedValue.equalsIgnoreCase("true"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Month Arrow Button disabled</b>", "PASS",
						"<b>Previous Month Arrow Button should be disabled</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Month Arrow Button enable</b>", "FAIL",
						"<b>Previous Month Arrow Button should be disabled</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing Previous Month Arrow Button Property</b>", "FAIL",
					"<b>Previous Month Arrow Button should be disabled</b>");
		}

		return selectedValue;
	}

	public String verifyPreviousArrowForOneLessToCurrentYear() {
		WebElement element;
		String selectedValue = "";
		try {
			Thread.sleep(2000l);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnYearPreviousArrow(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnYearPreviousArrow(driver);
			selectedValue = Keywords.getAttributeVal(element, "disabled");
			// System.out.println("Element Attribute value..." + selectedValue);
			if (selectedValue.equalsIgnoreCase("true"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Year Arrow Button disabled</b>", "PASS",
						"<b>Previous Year Arrow Button should be disabled</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Previous Year Arrow Button enable</b>", "FAIL",
						"<b>Previous Year Arrow Button should be disabled</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing Previous Year Arrow Button Property</b>", "FAIL",
					"<b>Previous Year Arrow Button should be disabled</b>");
		}

		return selectedValue;
	}

	public String getDateValueFromDEventDetailPage() {
		String dateValue = "";
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getDateValueFromEventDetailPage(driver);
			dateValue = Keywords.getText(element).trim();
			// System.out.println("Date Value..."+dateValue);
		} catch (Exception e) {
		}

		return dateValue;
	}

	public List<WebElement> getEventList() {
		return Locators.getInstance().getEventList(driver);
	}

	public List<WebElement> getEventMonthCount() {
		List<WebElement> eventList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			eventList = Locators.getInstance().getEventMonthValues(driver);
		} catch (Exception e) {
		}

		return eventList;
	}

	public void selectPaging() {
		List<WebElement> list;
		int randomIndexValue = 0;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getPagingList(driver);
			randomIndexValue = Keywords.getRandomInteger(list.size());
			if (list.size() > 0) {
				Keywords.click(list.get(randomIndexValue));
				Keywords.waitForPageFullyLoaded(driver);
				Thread.sleep(3000);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Paging index value </b>" + (randomIndexValue+1) + "<b> select successfully</b>", "PASS",
						"<b>Paging index value </b>" + (randomIndexValue+1) + "<b> Should be selected</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while selecting the paging index value</b>", "FAIL",
					"<b>Paging index value </b>" + (randomIndexValue+1) + "<b> Should be selected</b>");
		}
	}

	public int getOrgPlantCount() {
		int count = 0;
		WebElement element;
		String txt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getOrgPlantCountFromWeb(driver);
			txt = Keywords.getText(element).trim();
			count = Integer.parseInt(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getOrgCollectionCount() {
		int count = 0;
		String txt = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getOrgCollectionCountFromWeb(driver);
			txt = Keywords.getText(element).trim();
			count = Integer.parseInt(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
