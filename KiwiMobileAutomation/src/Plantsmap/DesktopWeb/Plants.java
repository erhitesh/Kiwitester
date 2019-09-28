package Plantsmap.DesktopWeb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class Plants {

	static String spacingUnit = "";
	static int height = 0;
	static boolean statusOfViewMore = false;
	private WebDriver driver;

	public Plants(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getAddressList() {
		List<String> list = new ArrayList<>();
		try {
			list.add("Noida");
			list.add("Delhi");
			list.add("Gurgaon");
			list.add("New York");
			list.add("Los Angeles");
			list.add("Hell");
		} catch (Exception e) {
		}

		return list;
	}

	public void verifyAddNewPlantHeader() {
		WebElement element;
		String text = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewPlantCollectionOrganizationProfileHeader(driver);
			text = element.getText();
			Keywords.verifyTextOnPage(text);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"AddNewPlant Header visible successfully", "PASS", "AddNewPlant Header text should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"AddNewPlant Header not visible successfully", "FAIL",
						"AddNewPlant Header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while check the visibility of AddNewPlant Header Text", "FAIL",
					"AddNewPlant Header text should be present");
		}
	}

	public String addPlantTitle() {
		WebElement element;
		String plantTitle = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantTitle(driver);
			plantTitle = "PlantsmapPlant" + Keywords.getRandomNumber(5);
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

	public String plantTitleWithValidAndInvalid() {
		WebElement element;
		String plantTitle = "";
		String errorMessage = DriverSession.getTestCaseData().get("PlantTitleErrorMessage");// "Title
																							// can't
																							// be
																							// empty.";
		try {
			Keywords.waitForPage(driver);
			clickOnNextButton();
			element = Locators.getInstance().errorMessageForTitle(driver);
			if (Keywords.getText(element).equalsIgnoreCase(errorMessage)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Title can't be empty</b> visible successfully", "Pass",
						"<b>Title can't be empty</b> should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Title can't be empty</b> not visible successfully", "FAIL",
						"<b>Title can't be empty</b> should be visible");
			element = Locators.getInstance().addPlantTitle(driver);
			plantTitle = "PlantsmapPlant" + Keywords.getRandomNumber(5);
			Keywords.typeText(element, plantTitle);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Title entered successfully",
						"PASS", "Plant Title should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant Title not entered successfully", "FAIL", "Plant Title should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the plant title", "FAIL", "Plant Title should be entered");
		}

		return plantTitle;
	}

	public void verifyImageDimensionFormat() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyImageDimensionFormat(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format verify successfully", "PASS",
						"Image Dimension format should be verified");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Image Dimension format not verify successfully", "FAIL",
						"Image Dimension format should be verified");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Image Dimension format", "FAIL",
					"Image Dimension format should be verified");
		}
	}

	public void addPlantImage() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "plant.jpg";
		try {
			element = (RemoteWebElement) Locators.getInstance().addPlantCollectionOrganizationImage(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant Image uploaded successfully",
						"PASS", "Plant Image should be uploaded");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant Image not uploaded successfully", "FAIL", "Plant Image should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploade the plant Image", "FAIL", "Plant Image should be uploaded");
		}
	}

	public List<String> addPlantStory() {
		List<String> info = new ArrayList<>();
		boolean status = false;
		WebElement element;
		String plantStory = "The Parable of the Growing Seed (also called the Seed Growing Secretly) is a parable of Jesus which appears only in Mark 4:26-29."
				+ "It is a parable about growth in the Kingdom of God. It follows the Parable of the Sower and the Lamp under a bushel, "
				+ "and precedes the Parable of the Mustard Seed.The first thing we notice about this parable is its similarity to the Parable of the Sower in Mark 4:2-9."
				+ "In some ways, this parable expands on Jesus’ teaching of how the “good soil” (a receptive heart) receives the “seed” (the Word of God)."
				+ "In the Parable of the Growing Seed, Jesus tells of a man who scatters seed on the ground and then allows nature to take its course."
				+ "As the man who sowed the seed goes about his business day by day, the seed begins to have an effect."
				+ "First, the seed sprouts; then it produces a stalk and leaves, then a head of grain, and, finally, fully developed kernels in the head."
				+ "Jesus emphasizes that all of this happens without the man’s help. The man who scattered the seed cannot even fully understand "
				+ "how it happens—it is simply the work of nature. “All by itself the soil produces” (verse 28).The parable ends with a harvest."
				+ "As soon as the grain is ripe, the sickle is employed, and the seed is harvested. This happens at just the right time."
				+ "Jesus did not explain this parable, "
				+ "as He did some others. Instead, He left it to us to understand its meaning.";
		// "This is plantsmap plant description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPlantCollectionOrganizationDescription(driver);
			Keywords.enterTextByJS(element, plantStory, "arguments[0].textContent= arguments[1];");
			info.add(plantStory);
			height = element.getSize().getHeight();
			if (height >= 250) {
				status = true;
			}
			info.add(status + "");
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
		return info;
	}

	public void clickOnPublicLoc() {
		WebElement element;
		try {
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

	public String selectSuggestedAddress() {
		WebElement element;
		String suggestedAddress = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().suggestedAddress(driver);
			if (Keywords.isElementPresent(element))
				suggestedAddress = Keywords.getText(element);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Suggested Address " + suggestedAddress + " entered successfully", "PASS",
						"Suggested Address " + suggestedAddress + " should be entered");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Suggested Address " + suggestedAddress + " not entered successfully", "FAIL",
						"Suggested Address " + suggestedAddress + " should be entered");
		} catch (Exception e) {
		}
		return suggestedAddress;
	}

	public String addAddress(String makeLocation) {
		WebElement element;
		List<String> addressList = getAddressList();
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
			makeYourLocation(makeLocation);
			// makeYourLocation("public");
		} catch (Exception e) {
		}

		return address;
	}

	public String addInvalidAddress() {
		WebElement element;
		String address = "";
		try {
			address = DriverSession.getTestCaseData().get("InvalidAddress");
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			Keywords.typeText(element, address);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Invalid Address</b> enter successfully", "PASS", "<b>Invalid Address should be enter</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Invalid Address</b> not enter successfully", "FAIL", "<b>Invalid Address should be enter</b>");
		}

		return address;
	}

	public void clickOnNextButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().nextButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Next button click successfully",
						"PASS", "Next button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Next button not click successfully", "FAIL", "Next button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Next button", "FAIL", "Next button should be click");
		}
	}

	public void clickOnSaveButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().savePlantCollectionOrganizationPage(driver);
			Keywords.click(element);
			if (Keywords.isElementEnable(element))
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

	public void plantSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().updateSuccessfullyPlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitDonePlantAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant detail updated successfully",
						"PASS", "Plant detail should be updated");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant detail not updated successfully", "FAIL", "Plant detail should be updated");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating the plant detail", "FAIL", "Plant detail should be updated");
		}
	}

	public void plantDeletedSuccessfully() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().deletePlantDetailPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitPlantDeleteAlertPopUpBox(driver);
			Keywords.click(element);
			Thread.sleep(5000);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant deleted successfully",
						"PASS", "Plant should be deleted");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plant not deleted successfully",
						"FAIL", "Plant should be deleted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occurred while deleting plant", "FAIL", "Plant should be deleted");
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>. Plants sub fields tabs
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	/// plant detail page
	public String getPlantTitle() {
		WebElement element;
		String plantName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantTitle(driver);
			plantName = element.getText();
		} catch (Exception e) {

		}
		return plantName;
	}

	public String getPlantStory() {
		WebElement element;
		String plantStory = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantsStory(driver);
			plantStory = element.getText();
		} catch (Exception e) {

		}
		return plantStory;
	}

	public boolean verifyViewMoreBtn() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().viewMoreBtn(driver);
			if (Keywords.isElementPresent(element))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public void verifyViewMoreLessBtnFunctionality(String status) {
		WebElement element;
		try {
			if (status.equalsIgnoreCase("true")) {
				if (verifyViewMoreBtn()) {
					element = Locators.getInstance().viewMoreBtn(driver);
					Keywords.click(element);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>View More Button visible successfully", "PASS",
							"<b>View More Button should be visible</b>");
					Thread.sleep(3000l);
					if (!verifyViewMoreBtn()) {
						element = Locators.getInstance().viewLessBtn(driver);
						Keywords.click(element);
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>View Less Button visible successfully", "PASS",
								"<b>View Less Button should be visible</b>");
					}
				}
			} else
				System.out.println("<Please Enter Text Having height 230");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the View More & Less Button visibillity", "FAIL",
					"<b>View More & Less Button should be visible</b>");
		}
	}

	public String getPlantLocation() {
		WebElement element;
		String plantLocation = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantsLocation(driver);
			plantLocation = element.getText().trim();
		} catch (Exception e) {
		}
		return plantLocation;
	}

	public String getPlantPrivateLocation() {
		WebElement element;
		String plantPrivateLocation = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantPrivateLocation(driver);
			plantPrivateLocation = element.getText().trim();
		} catch (Exception e) {
		}
		return plantPrivateLocation;
	}

	public String getPlantsPhysicalAddress() {
		WebElement element;
		String plantPhysicalAdd = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantPhysicalAddess(driver);
			if (Keywords.isElementPresent(element)) {
				plantPhysicalAdd = Keywords.getText(element);
			}
		} catch (Exception e) {
		}

		return plantPhysicalAdd;
	}

	public String getPlantBlankLocation() {
		WebElement element;
		String plantLocation = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantBlankAddress(driver);
			plantLocation = element.getText().trim();
		} catch (Exception e) {
		}

		return plantLocation;
	}

	public boolean getMapViewVisibility() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getMapViewStatus(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void clickOnLikeButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getLikeCount(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Like</b> button click successfully", "PASS", "<b>Like</b> button should be click ");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Like</b> button not click successfully", "FAIL", "<b>Like</b> button should be click ");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Like</b> button", "FAIL",
					"<b>Like</b> button should be click ");
		}
	}

	public int getLikeCount() {
		int count = 0;
		WebElement element;
		String textMessage = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getLikeCount(driver);
			textMessage = Keywords.getText(element).trim().replace("Like (", "").replace(")", "").trim();
			count = Integer.parseInt(textMessage);
			// System.out.println("Like count..." + count);
		} catch (Exception e) {
		}

		return count;
	}

	public String getPlantCreatorName() {
		WebElement element;
		String plantCreatorName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().plantCreatedBy(driver);
			plantCreatorName = element.getText();
		} catch (Exception e) {

		}
		return plantCreatorName;
	}

	public void selectPlantFromPlantList(String plantTitleName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectPlant(driver, plantTitleName);
			Keywords.click(element);
			Keywords.waitForPage(driver);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						plantTitleName + " selected from plant list", "PASS", plantTitleName + " should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						plantTitleName + " not selected from plant list", "FAIL",
						plantTitleName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + plantTitleName + " from plant list", "FAIL",
					plantTitleName + " should be selected");
		}
	}

	public String plantsViewType() {
		List<String> list = new ArrayList<>();
		list.add("grid");
		list.add("list");

		return list.get(Keywords.getRandomInteger(list.size())); // "list";//
	}

	public String selectPlantViewType() {
		String viewType = plantsViewType();
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().plantViewType(driver, viewType);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("View Type select successfully", "PASS",
					"View Type should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("View Type not select successfully",
					"FAIL", "View Type should be selected");
		}

		return viewType;
	}

	public void selectPlantFromPlantTab(String plantTitleName) {
		WebElement element;
		String viewType = "";
		try {
			viewType = selectPlantViewType();
			Keywords.waitForPage(driver);
			if (viewType.equalsIgnoreCase("grid"))
				element = Locators.getInstance().selectPlantFromGridView(driver, plantTitleName);// Locators.getInstance().selectPlantUnderPlantTab(driver,
																									// plantTitleName);
			else
				element = Locators.getInstance().selectPlantFromListView(driver, plantTitleName);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						plantTitleName + " selected from plant list", "PASS", plantTitleName + " should be selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						plantTitleName + " not selected from plant list", "FAIL",
						plantTitleName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + plantTitleName.toLowerCase() + " from plant list", "FAIL",
					plantTitleName + " should be selected");
		}
	}

	public boolean plantsVisibility(String verifyType) {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyNotAddedAnyPhotoCollectionOrgEventMessage(driver, verifyType);
			if (!Keywords.isElementPresent(element))
				status = true;
		} catch (Exception e) {
		}
		return status;
	}

	public void clickOnMoreLinkOnPlantTitle(String plantTitleName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().editAndViewOption(driver, plantTitleName);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant title view type click successfully", "PASS", "Plant title view type should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Plant title view type not click successfully", "FAIL",
						"Plant title view type should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on plant title view type", "FAIL",
					"Plant title view type not click successfully");
		}
	}

	public void selectOperationOnEditViewLinkedText(String operationType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			if (operationType.contains("view")) {
				element = Locators.getInstance().viewLinkedText(driver);
			} else {
				element = Locators.getInstance().editLinkedText(driver);
			}
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						operationType + " type click successfully", "PASS", operationType + " type should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						operationType + " type not click successfully", "FAIL",
						operationType + " type should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on " + operationType + " type", "FAIL",
					operationType + " type should be clicked");
		}
	}

	public boolean editButtonOnPlantDetailPage() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().editButton(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void clickOnEditButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().editButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Edit button click successfully",
						"PASS", "Edit button should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Edit button not click successfully", "FAIL", "Edit button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on Edit button", "FAIL", "Edit button should be clicked");
		}
	}

	public void clickOnAddRemoveToCollectionButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addRemoveToCollectionBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add/Remove To Collection button click successfully", "PASS",
						"Add/Remove To Collection button should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add/Remove To Collection button not click successfully", "FAIL",
						"Add/Remove To Collection button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on Add/Remove To Collection button", "FAIL",
					"Add/Remove To Collection button should be clicked");
		}
	}

	public void verifyAddRemoveToCollectionHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addRemoveCollectionHeader(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add/Remove To Collection Header text visible successfully</b>", "PASS",
						"<b>Add/Remove To Collection Header text should be present</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add/Remove To Collection Header text not visible successfully</b>", "FAIL",
						"<b>Add/Remove To Collection Header text should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Add/Remove To Collection text</b>", "FAIL",
					"<b>Add/Remove To Collection Header text should be present</b>");
		}
	}

	public String selectCollectionFromAddRemoveCollectionPopUpList() {
		String plantTitleName = "";
		List<WebElement> collectionList;
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			collectionList = Locators.getInstance().getCollectionList(driver);
			randomNumber = Keywords.getRandomInteger(collectionList.size() - 1);
			plantTitleName = Keywords.getText(collectionList.get(randomNumber)).trim();
			Keywords.click(collectionList.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Collection selected successfully",
						"PASS", "Collection should be select from Collection List");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection not selected successfully", "FAIL",
						"Collection should be select from Collection List");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the Collection from collection list", "FAIL",
					"Collection should be select from Collection List");
		}

		return plantTitleName;
	}

	public void deleteCollectionFromPlant(String collectionName) {
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			list = Locators.getInstance().getCollectionList(driver);
			for (int i = 0; i < list.size(); i++) {
				if (collectionName.equalsIgnoreCase(Keywords.getText(list.get(i)))) {
					Keywords.click(list.get(i));
					clickOnUpdateCollectionButton();
					if (DriverSession.getStepResult())
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								collectionName + " Collection delete successfully from Plant", "PASS",
								collectionName + " Collection should be deleted from Plant.");
					else
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								collectionName + " Collection not delete successfully from Plant", "FAIL",
								collectionName + " Collection should be deleted from Plant.");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting " + collectionName + " Collection from Plant", "FAIL",
					collectionName + " Collection should be deleted from Plant.");
		}
	}

	public void verifyCollectionAfterDeleteFromPlant() {
		try {
			Keywords.waitForPage(driver);
			if (!getCollectionVisibillityOnPlantDetailPage())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Collection from plant delete successfully</b>", "PASS",
						"<b>Collection from plant should be deleted</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Collection from plant not delete successfully</b>", "FAIL",
						"<b>Collection from plant should be deleted</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verify remove collection from plant</b>", "FAIL",
					"<b>Collection from plant should be deleted</b>");
		}
	}

	public void clickOnUpdateButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnUpdate(driver);
			Keywords.click(element);
			Keywords.acceptAlert();

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

	public void clickOnUpdateCollectionButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnUpdateCollectionButton(driver);
			Keywords.click(element);
			Keywords.acceptAlert();

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

	public boolean getCollectionVisibillityOnPlantDetailPage() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCollectionNameFromPlantDetailPage(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public String getCollectionName() {
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

	public void verifyCollectionOnPlantDetailPage(String collectionName) {
		if (getCollectionName().equalsIgnoreCase(collectionName))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Added Collection found successfully on plants detail page", "PASS",
					"Added Collection should be found on plants detail page");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Added Collection not found successfully on plants detail page", "FAIL",
					"Added Collection should be found on plants detail page");
	}

	public boolean getCollectionsVisibililty() {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyPlantsExistance(driver);
			if (Keywords.isElementPresent(element))
				status = true;
		} catch (Exception e) {
		}
		return status;
	}

	public void clickOnAddCollectionButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnAddCollection(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Collection</b> button click successfully", "PASS",
						"<b>Add Collection</b> button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Collection</b> button not click successfully", "FAIL",
						"<b>Add Collection</b> button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occurred while clicking on <b>Add Collection</b> button", "FAIL",
					"<b>Add Collection</b> button should be click");
		}
	}

	public String createNewCollectionToPlant() {
		String collectionTitle = "";
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			collection.verifyAddNewCollectionHeader();
			collectionTitle = collection.addCollectionTitle();
			collection.addCollectionDescription();
			collection.addCollectionImage();
			collection.addSubCollectionAddress("public");
			collection.clickOnSaveButton();
			collection.collectionSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionTitle;
	}

	public String addCollectionToPlant(String plantTitle) {
		String collectionTitle = "";
		try {
			if (getCollectionsVisibililty()) {
				clickOnAddCollectionButton();
				collectionTitle = createNewCollectionToPlant();
				HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
				home.selectHeaderTab("My Plants Map");
				home.selectHeaderSubTab("My Plants");
				selectPlantFromPlantTab(plantTitle);
				clickOnAddRemoveToCollectionButton();
				verifyAddRemoveToCollectionHeaderTxt();
				selectCollectionFromAddRemoveCollectionPopUpList();
			} else
				collectionTitle = selectCollectionFromAddRemoveCollectionPopUpList();
			clickOnUpdateCollectionButton();

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection Added successfully to the Plant", "PASS", "Collection should be added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Collection not Added successfully to the Plant", "FAIL", "Collection should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding Collection to the Plant", "FAIL", "Collection should be added");
		}

		return collectionTitle;
	}

	public void selectAddedTabName(String tabManagerName) {
		WebElement element;
		List<WebElement> tabElementList;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectTabManagerNameFromList(driver);
			Keywords.click(element);
			tabElementList = Locators.getInstance().getTabList(driver);
			for (WebElement ele : tabElementList) {
				if (Keywords.getText(ele).trim().equalsIgnoreCase(tabManagerName)) {
					Keywords.click(ele);
					Thread.sleep(2000);
					if (DriverSession.getStepResult()) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Tab Manager Name " + tabManagerName + " selected successfully", "PASS",
								"Tab Manager Name " + tabManagerName + "  should be selected");
						break;
					}
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting on Tab manager name " + tabManagerName, "FAIL",
					"Tab Manager Name should be selected");
		}
	}

	public String selectPlantSubTab(String tabName) {
		String selectedTabName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectPlantSubTab(driver, tabName);
			selectedTabName = Keywords.getText(element);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plants Sub</b> " + tabName.toUpperCase() + " <b>click successfully</b>", "PASS",
						"<b>Plants Sub</b> " + tabName.toUpperCase() + " <b>should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plants Sub Tab </b> " + tabName.toUpperCase() + " <b>not click successfully</b>", "FAIL",
						"<b>Plants Sub</b> " + tabName.toUpperCase() + " <b>should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + "Plants Sub " + tabName.toUpperCase(), "FAIL",
					"<b>Plants Sub</b> " + tabName.toUpperCase() + " <b>should be selected</b>");
		}

		return selectedTabName;
	}

	public void navigateToTabManagerOnPlantsPage(String tabName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectTabFromPlantsSubTabList(driver, tabName);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Tab Manager Name Click successfully", "PASS", "Tab Manager Name should be Click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Tab Manager Name not Click successfully", "FAIL", "Tab Manager Name should be Click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on Tab manager name", "FAIL",
					"Tab Manager Name should be Click");
		}
	}

	public List<String> getAddedTabNameList() {
		List<WebElement> list;
		List<String> fieldsNameList = new ArrayList<>();
		try {
			list = Locators.getInstance().getAddedTabFieldsName(driver);
			for (int i = 0; i < list.size(); i++) {
				fieldsNameList.add(Keywords.getTextByIndex(list, i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldsNameList;
	}

	public List<String> listDataForTabManager() {
		List<String> list = new ArrayList<>();
		list.add("BotanicalName");
		list.add("CommanName");
		list.add("FormName");
		return list;

	}

	public List<String> fillAddedTabNameList() {
		List<WebElement> list;
		List<String> formdata = listDataForTabManager();
		try {
			list = Locators.getInstance().fillAddedTabFieldsName(driver);
			for (int i = 0; i < list.size(); i++) {
				Keywords.typeText(list.get(i), formdata.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formdata;
	}

	public List<String> fillTabManagerTextFields() {
		WebElement element;
		String randomText = "";
		List<String> list = new ArrayList<>();
		try {
			randomText = Keywords.getRandomString();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().fillTabManagerTextAreaFields(driver);
			Keywords.typeText(element, randomText);
			list.add(randomText);
		} catch (Exception e) {
		}
		return list;
	}

	public void clickOnDeleteButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().deleteButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Delete button</b> click successfully", "PASS", "<b>Delete button</b> should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Delete button</b> not click successfully", "FAIL",
						"<b>Delete button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on <b>Delete button</b>", "FAIL",
					"<b>Delete button</b> should be clicked");
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>. plants quantity
	// *****************************
	public int checkPlantQuantity() {
		return Locators.getInstance().plantsListUnderHomeSubTab(driver).size();
	}

	public void clickOnAddTag() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().tagLinkedTxt(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tag button</b> click successfully", "PASS", "<b>Tag button</b> should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tag button</b> not click successfully", "FAIL", "<b>Tag button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on <b>Tag button</b>", "FAIL",
					"<b>Tag button</b> should be clicked");
		}
	}

	public void TagSuccessfullyAdded() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().tagAddedPopUpMessage(driver);
			Keywords.verifyTextOnPage(element.getText());

			element = Locators.getInstance().submitTagAlertAlert(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tag added successfully", "PASS",
						"Plant tag should be updated");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Tag not added successfully",
						"FAIL", "Plant tag should be updated");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while adding plant tag", "FAIL", "Plant tag should be updated");
		}
	}

	public List<WebElement> getPlantsListUnderPlantTab() {
		List<WebElement> plantList = null;
		try {
			Keywords.waitForPage(driver);
			plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantList;
	}

	public List<WebElement> getPlantsListUnderMyPlantsMapTab() {
		List<WebElement> plantList = null;
		try {
			Keywords.waitForPage(driver);
			plantList = Locators.getInstance().plantsListUnderMyPlantsMapSubTab(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantList;
	}

	public List<WebElement> getCollectionListUnderMyPlantsMapMyCollectionTab() {
		List<WebElement> collectionList = null;
		try {
			Keywords.waitForPage(driver);
			collectionList = Locators.getInstance().collectionListUnderMyPlantsMapSubTab(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionList;
	}

	public int addPlantToTagListForOrderChecking() {
		List<WebElement> plantList = null;
		try {
			Keywords.waitForPage(driver);
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
			if (plantList.size() <= 0) {
				for (int i = 0; i <= 5; i++) { // add plants if not present.
					home.clickOnAddNewTag();
					home.selectAddOptionTag("plants");
					verifyAddNewPlantHeader();
					addPlantTitle();
					addPlantStory();
					addPlantImage();
					clickOnNextButton();
					clickOnSaveButton();
					plantSuccessfullyAdded();
				}
				home.selectHomeSubHeaderTab("plants");
				plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
			} else {
				plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
				for (int j = 0; j < 20; j++) { // add plants to tag List from
												// list
					plantList.get(j).click();
					clickOnAddTag();
					TagSuccessfullyAdded();
					Keywords.backPage();
					plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
				}
			}
		} catch (Exception e) {
		}

		return plantList.size();
	}

	public int addPlantToTagList() {
		List<WebElement> plantList = null;
		// int plantsSize = checkPlantQuantity();
		int cartQuantity = 0;
		try {
			Keywords.waitForPage(driver);
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			CartPage cart = new CartPage(DriverSession.getLastExecutionDriver());
			plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
			if (plantList.size() <= 0) {
				for (int i = 0; i <= 3; i++) { // add plants if not present.
					home.clickOnAddNewTag();
					home.selectAddOptionTag("plants");
					verifyAddNewPlantHeader();
					addPlantTitle();
					addPlantStory();
					addPlantImage();
					clickOnNextButton();
					clickOnSaveButton();
					plantSuccessfullyAdded();
				}
				home.selectHomeSubHeaderTab("plants");
				plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
			}
			plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
			cartQuantity = cart.cartQuantity();
			if (cartQuantity >= 4) {
			} else {
				for (int j = 0; j < plantList.size(); j++) { // add plants to
																// cart
					plantList.get(j).click();
					clickOnAddTag();
					TagSuccessfullyAdded();
					Keywords.backPage();
					plantList = Locators.getInstance().plantsListUnderHomeSubTab(driver);
					cartQuantity = cart.cartQuantity();
					if (cartQuantity >= 3)
						break;
				}
			}
		} catch (Exception e) {
		}
		return plantList.size();
	}

	public List<String> getImageList() {
		List<String> list = new ArrayList<>();
		try {
			list.add("admincollection.jpg");
			list.add("adminEvent.jpg");
			list.add("adminPlant.jpg");
			list.add("adminOrg.jpg");
			list.add("cover.jpg");
			list.add("collection.jpg");
			list.add("plantsran.jpg");
			list.add("bamboo.jpg");
		} catch (Exception e) {
		}
		return list;
	}

	// >>>>>>>>>>>>>>>>>>>> add more photos >>>>>>>>>>>>>
	public void addPhotos() {
		RemoteWebElement element;
		List<String> plantsImagesList;
		String imageName = "";
		String imagePath = "";
		try {
			plantsImagesList = getImageList();
			imageName = plantsImagesList.get(Keywords.getRandomInteger(plantsImagesList.size()));
			Keywords.waitForPage(driver);
			element = (RemoteWebElement) Locators.getInstance().addPlantsPhotos(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);

		} catch (Exception e) {
		}
	}

	public String addPhotoCaption() {
		WebElement element;
		String photocaption = "";
		try {
			photocaption = "Test Photo caption";
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addPhotoCaption(driver);// tagAddedPopUpMessage(driver);
			Keywords.typeText(element, photocaption);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Photo caption</b> added successfully", "PASS", "<b>Photo caption</b> should be added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Photo caption</b> not added successfully", "FAIL", "<b>Photo caption</b> should be added");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while " + "<b>Photo caption</b> added successfully", "FAIL",
					"<b>Photo caption</b> should be added");
		}
		return photocaption;
	}

	public void uploadPhoto() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().uploadPhoto(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Photo</b> upload successfully",
						"PASS", "<b>Photo </b> upload should be added");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Photo</b> not upload successfully", "FAIL", "<b>Photo </b> upload should be added");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading the photo", "FAIL", "<b>Photo </b> upload should be added");
		}
	}

	public String updatePhotoCaption(String photoCaption) {
		String updatedPhotoCaption = "This is plantsmap updated caption";
		String actualPhotoCaption = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().updatePhotoCaption(driver);
			actualPhotoCaption = Keywords.getAttributeVal(element, "value");
			if (actualPhotoCaption.equalsIgnoreCase(photoCaption)) {
				Keywords.typeText(element, updatedPhotoCaption);
				updatedPhotoCaption = Keywords.getAttributeVal(element, "value");
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Photo caption update successfully",
						"PASS", "Photo caption should be updated.");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating photo caption", "FAIL", "Photo caption should be updated.");
		}

		return updatedPhotoCaption;
	}

	public void hideEditPhotoWindow() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().hideEditPhotoPopUp(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void verifyUpdatedPhotoCaption(String expectedcaptionName) {
		WebElement element;
		String actualPhotocaption = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().updatePhotoCaption(driver);
			actualPhotocaption = Keywords.getAttributeVal(element, "value");
			if (!actualPhotocaption.equalsIgnoreCase(expectedcaptionName)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Photo caption update successfully",
						"PASS", "Photo caption should be update");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Photo caption not update successfully", "FAIL", "Photo caption should be update");
			element = Locators.getInstance().clickOnUpdateCaption(driver);
			Keywords.click(element);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating Photo caption", "FAIL", "Photo caption should be update");
		}
	}

	public String verifyAddedPhotoCaptionAndUpdateCaption(String photoCaption) {
		List<WebElement> photoList;
		String updatedPhotoCaption = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			photoList = Locators.getInstance().photosList(driver);
			for (WebElement ele : photoList) {
				Keywords.click(ele);
				Thread.sleep(2000l);
				element = Locators.getInstance().updatePhotoCaption(driver);
				if (Keywords.getAttributeVal(element, "value").trim().equalsIgnoreCase(photoCaption)) {
					updatedPhotoCaption = updatePhotoCaption(photoCaption);
					verifyUpdatedPhotoCaption(photoCaption);
					// hideEditPhotoWindow();
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Added caption visible successfully", "PASS", "Added caption should be visible");
					break;
				} else
					hideEditPhotoWindow();
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the visibility of photo caption", "FAIL",
					"Added caption should be visible");
		}

		return updatedPhotoCaption;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>> Add notes >>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void clickOnAddNotes() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnAddNotesButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add New</b> notes button click successsfully", "PASS",
						"<b>Add New</b> notes button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add New</b> notes button not click successsfully", "FAIL",
						"<b>Add New</b> notes button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the " + "<b>Add New</b> notes button", "FAIL",
					"<b>Add New</b> notes button should be click");
		}
	}

	public void verifyNotesTitleRequired() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyNotesTitleRequired(driver);
			if (Keywords.isElementPresent(element) && Keywords.getText(element)
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("NotesTitleErrorMessage")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Title can't be empty</b> visible successfully", "PASS",
						"<b>Title can't be empty</b> should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Title can't be empty</b> not visible successfully", "FAIL",
						"<b>Title can't be empty</b> should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error message <b>Title can't be empty</b>", "FAIL",
					"<b>Title can't be empty</b> should be visible");
		}
	}

	public void verifyNotesDescriptionRequired() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyNotesDescriptionRequired(driver);
			if (Keywords.isElementPresent(element) && Keywords.getText(element)
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("NotesDescriptionErrorMessage")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Description can't be empty</b> visible successfully", "PASS",
						"<b>Description can't be empty</b> should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Description can't be empty</b> not visible successfully", "FAIL",
						"<b>Description can't be empty</b> should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the error message <b>Description can't be empty</b>", "FAIL",
					"<b>Description can't be empty</b> should be visible");
		}
	}

	public String addNotesTitle() {
		String notesTitle = "Plantsmap Notes Title";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNotesTitle(driver);
			Keywords.typeText(element, notesTitle);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Title</b> enter successsfully", "PASS", "<b>Notes Title</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Title</b> not enter successsfully", "FAIL", "<b>Notes Title</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Notes Title</b> ", "FAIL",
					"<b>Notes Title</b> should be entered");
		}

		return notesTitle;
	}

	public String addNotesDescription() {
		WebElement element;
		String notesDescription = "This is Plantsmap Notes Description!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNotesDescription(driver);
			Keywords.enterTextByJS(element, notesDescription, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Description</b> enter successsfully", "PASS",
						"<b>Notes Description</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Description</b> not enter successsfully", "FAIL",
						"<b>Notes Description</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Notes Description</b>", "FAIL",
					"<b>Notes Description</b> should be entered");
		}

		return notesDescription;
	}

	public void makeNotesVisibility(String visibilityType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().notesVisibility(driver, visibilityType);
			Keywords.click(element);

		} catch (Exception e) {
		}
	}

	public void submitNotes() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().savePlantsNotes(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Page</b> submit successsfully", "PASS", "<b>Notes Page</b> should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notes Page</b> not submit successsfully", "FAIL", "<b>Notes Page</b> should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Notes Page</b>", "FAIL",
					"<b>Notes Page</b> should be submit");
		}
	}

	public String getPlantsNotesTitle() {
		String notesTitle = "";
		WebElement element;
		String str = "Plantsmap Notes Title";
		try {
			element = Locators.getInstance().getNotesTitle(driver);
			notesTitle = Keywords.getText(element);
			notesTitle = notesTitle.substring(0, str.length());
		} catch (Exception e) {
		}

		return notesTitle;
	}

	public String getPlantsNotesDescription() {
		String notesDescription = "";
		WebElement element;
		try {
			element = Locators.getInstance().getNotesDescription(driver);
			notesDescription = Keywords.getText(element);
		} catch (Exception e) {
		}

		return notesDescription;
	}

	// comment
	public /* List<String> */ String writeComment() {
		// List<String> commentList = new ArrayList<>();
		String comment = "";
		WebElement element;
		String randomComment = "";
		try {
			randomComment = "Plantsmap Comment Message..." + Keywords.getRandomString();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().writeComment(driver);
			Keywords.typeText(element, randomComment);
			// commentList.add(randomComment);
			comment = randomComment;

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment Message</b> enter successfully", "PASS",
						"<b>Comment Message</b>  should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment Message</b> not enter successfully", "FAIL",
						"<b>Comment Message</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while writing the <b>Comment Message</b> ", "FAIL",
					"<b>Comment Message</b> should be entered");
		}

		return comment;// commentList;
	}

	public void submitComment() {
		WebElement element;
		try {
			element = Locators.getInstance().submitPlantsComment(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment Message</b> submit successfully", "PASS",
						"<b>Comment Message</b> should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment Message</b> not submit successfully", "FAIL",
						"<b>Comment Message</b> should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Comment Message</b>", "FAIL",
					"<b>Comment Message</b> should be submit");
		}
	}

	public String getPlantsComments() {
		String commentMessage = "";
		WebElement element;
		try {
			element = Locators.getInstance().getPlantCommentMessage(driver);
			commentMessage = Keywords.getText(element);
		} catch (Exception e) {
		}

		return commentMessage;
	}

	// Plants Details Tab
	// Plant Information
	public String enterBotanicalName() {
		String botanicalName = "";
		WebElement element;
		try {
			botanicalName = "Botanical.." + Keywords.getRandomString();
			element = Locators.getInstance().botanicalName(driver);
			Keywords.typeText(element, botanicalName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Botanical Name</b> enter successfully", "PASS",
						"<b>Botanical Name</b> name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Botanical Name</b> not enter successfully", "FAIL",
						"<b>Botanical Name</b> name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Botanical Name</b>", "FAIL",
					"<b>Botanical Name</b> name should be enter");
		}

		return botanicalName;
	}

	public String enterCommanName() {
		String commanName = "";
		WebElement element;
		try {
			commanName = "Comman.." + Keywords.getRandomString();
			element = Locators.getInstance().commanName(driver);
			Keywords.typeText(element, commanName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>comman Name</b> enter successfully", "PASS", "<b>comman Name</b> name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>comman Name</b> not enter successfully", "FAIL", "<b>comman Name</b> name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>comman Name</b>", "FAIL",
					"<b>comman Name</b> name should be enter");
		}

		return commanName;
	}

	public String enterSynonymName() {
		String synonymName = "";
		WebElement element;
		try {
			synonymName = "Synonym.." + Keywords.getRandomString();
			element = Locators.getInstance().synonymsName(driver);
			Keywords.typeText(element, synonymName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Synonym Name</b> enter successfully", "PASS", "<b>Synonym Name</b> name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Synonym Name</b> not enter successfully", "FAIL",
						"<b>Synonym Name</b> name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Synonym Name</b>", "FAIL",
					"<b>Synonym Name</b> name should be enter");
		}

		return synonymName;
	}

	public String enterTradeName() {
		String tradeName = "";
		WebElement element;
		try {
			tradeName = "Trade.." + Keywords.getRandomString();
			element = Locators.getInstance().tradeName(driver);
			Keywords.typeText(element, tradeName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Trade Name</b> enter successfully", "PASS", "<b>Trade Name</b> name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Trade Name</b> not enter successfully", "FAIL", "<b>Trade Name</b> name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Trade Name</b>", "FAIL",
					"<b>Trade Name</b> name should be enter");
		}

		return tradeName;
	}

	public String enterClassOrTypeName() {
		String className = "";
		WebElement element;
		try {
			className = "Class.." + Keywords.getRandomString();
			element = Locators.getInstance().classOrTypeName(driver);
			Keywords.typeText(element, className);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Class Name</b> enter successfully", "PASS", "<b>Class Name</b> name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Class Name</b> not enter successfully", "FAIL", "<b>Class Name</b> name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Class Name</b>", "FAIL",
					"<b>Class Name</b> name should be enter");
		}

		return className;
	}

	public List<String> selectCategoryCheckBoxes() {
		List<String> categoryLabelNames = new ArrayList<>();
		List<WebElement> checkboxesList;
		List<WebElement> categoryLabelNameList;
		try {
			checkboxesList = Locators.getInstance().categoryCheckboxes(driver);
			categoryLabelNameList = Locators.getInstance().categoryList(driver);
			for (int i = 0; i < checkboxesList.size(); i++) {
				Keywords.click(checkboxesList.get(i));
				categoryLabelNames.add(Keywords.getText(categoryLabelNameList.get(i)));
			}
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Catgeory Checkboxes</b> check successfully", "PASS",
					"<b>Catgeory Checkboxes</b> should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the <b>Catgeory Checkboxes</b>", "FAIL",
					"<b>Catgeory Checkboxes</b> should be checked");
		}
		return categoryLabelNames;
	}

	// Owner Information
	public String fillAccessionCode() {
		WebElement element;
		String accessionCode = "";
		try {
			accessionCode = "accessioncode" + Keywords.getRandomInteger(5);
			element = Locators.getInstance().accessionCode(driver);
			Keywords.typeText(element, accessionCode);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>AccessionCode</b> enter successfully", "PASS", "<b>AccessionCode</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>AccessionCode</b> not enter successfully", "FAIL",
						"<b>AccessionCode</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>AccessionCode</b>", "FAIL",
					"<b>AccessionCode</b> should be entered");
		}

		return accessionCode;
	}

	public String fillDateAcquired() {
		WebElement element;
		String dateAcquired = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().dateAcquired(driver);
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 1);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateAcquired = format.format(newDate);
			Keywords.makeTextBoxReadable("document.getElementById('owner_dateacquired').removeAttribute('readonly');");
			Keywords.typeText(element, dateAcquired);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Acquired Date enter successfully",
						"PASS", "Acquired Date should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Acquired date not enter successfully", "FAIL", "Acquired date should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Acquired date", "FAIL", "Acquired date should be enter");
		}

		return dateAcquired;
	}

	public String fillDatePlanted() {
		WebElement element;
		String datePlanted = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().datePlanted(driver);
			Calendar calender = new GregorianCalendar();
			Date date = new Date();
			calender.setTime(date);
			calender.add(Calendar.DATE, 2);
			Date newDate = calender.getTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			datePlanted = format.format(newDate);
			Keywords.makeTextBoxReadable("document.getElementById('owner_dateplanted').removeAttribute('readonly');");
			Keywords.typeText(element, datePlanted);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Planted Date enter successfully",
						"PASS", "Planted Date should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Planted date not enter successfully", "FAIL", "Planted date should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering Planted date", "FAIL", "Planted date should be enter");
		}

		return datePlanted;
	}

	public String fillAcquiredFromSource() {
		WebElement element;
		String acquiredFromSource = "";
		try {
			acquiredFromSource = "acquiredfromsource" + Keywords.getRandomInteger(5);
			element = Locators.getInstance().acquiredFromSource(driver);
			Keywords.typeText(element, acquiredFromSource);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Acquired From Source</b> enter successfully", "PASS",
						"<b>Acquired From Source</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Acquired From Source</b> not enter successfully", "FAIL",
						"<b>Acquired From Source</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Acquired From Source</b>", "FAIL",
					"<b>Acquired From Source</b> should be entered");
		}

		return acquiredFromSource;
	}

	public String fillQuantity() {
		WebElement element;
		String quantity = "";
		int randomQuantity = 0;
		try {
			quantity = "quantity" + Keywords.getRandomInteger(5);
			element = Locators.getInstance().quantity(driver);
			Keywords.typeText(element, quantity);
			clickOnSaveButton();
			element = Locators.getInstance().verifyQuantityErrorMessage(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quantity value must be numeric</b> visible successfully", "PASS",
						"<b>Quantity value must be numeric</b> should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quantity value must be numeric</b> not visible successfully", "FAIL",
						"<b>Quantity value must be numeric</b> should be present");
			randomQuantity = Keywords.getRandomInteger(10);
			element = Locators.getInstance().quantity(driver);
			Keywords.typeText(element, "" + randomQuantity);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quantity</b> enter successfully", "PASS", "<b>Quantity</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Quantity</b> not enter successfully", "FAIL", "<b>Quantity</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Quantity</b>", "FAIL",
					"<b>Quantity</b> should be entered");
		}

		return quantity;
	}

	public String getStatusValue() {
		String value = "";
		try {
			List<String> list = new ArrayList<>();
			list.add("Alive");
			list.add("Dead");
			list.add("None");
			value = list.get(Keywords.getRandomInteger(list.size()));
		} catch (Exception e) {
		}

		return value;
	}

	public String fillStatus() {
		WebElement element;
		String status = "";
		try {
			status = getStatusValue();
			element = Locators.getInstance().status(driver, status);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Status</b> select successfully",
						"PASS", "<b>Status</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Status</b> not selected successfully", "FAIL", "<b>Status</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Status</b>", "FAIL", "<b>Status</b> should be selected");
		}

		return status;
	}

	public String fillStatusNote() {
		WebElement element;
		String statusNote = "";
		try {
			statusNote = "statusnote" + Keywords.getRandomInteger(5);
			element = Locators.getInstance().statusNote(driver);
			Keywords.typeText(element, statusNote);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Status Note</b> enter successfully", "PASS", "<b>Status Note</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Status Note</b> not enter successfully", "FAIL", "<b>Status Note</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Status Note</b>", "FAIL",
					"<b>Status Note</b> should be entered");
		}

		return statusNote;
	}

	public String fillRefrenceLinkTitle() {
		WebElement element;
		String title = "";
		try {
			title = "link" + Keywords.getRandomInteger(5);
			element = Locators.getInstance().refrenceLinkTitle(driver);
			Keywords.typeText(element, title);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refrence Link Title</b> enter successfully", "PASS",
						"<b>Refrence Link Title</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refrence Link Title</b> not enter successfully", "FAIL",
						"<b>Refrence Link Titlee</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Refrence Link Title</b>", "FAIL",
					"<b>Refrence Link Title</b> should be entered");
		}

		return title;
	}

	public String fillRefrenceLinkUrl() {
		WebElement element;
		String url = "";
		try {
			url = "www.google.com";
			element = Locators.getInstance().refrenceLinkUrl(driver);
			Keywords.typeText(element, url);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refrence Link Url</b> enter successfully", "PASS",
						"<b>Refrence Link Url</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Refrence Link Url</b> not enter successfully", "FAIL",
						"<b>Refrence Link Url</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Refrence Link Url</b>", "FAIL",
					"<b>Refrence Link Url</b> should be entered");
		}

		return url;
	}

	public String fillCurrentHeight() {
		WebElement element;
		String height = "";
		try {
			height = "" + Keywords.getRandomInteger(30);
			element = Locators.getInstance().plantHeight(driver);
			Keywords.typeText(element, height);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Height</b> enter successfully", "PASS", "<b>Current Height</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Height</b> not enter successfully", "FAIL",
						"<b>Current Height</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Current Height</b>", "FAIL",
					"<b>Current Height</b> should be entered");
		}

		return height;
	}

	public String fillCurrentWidth() {
		WebElement element;
		String width = "";
		try {
			width = "" + Keywords.getRandomInteger(30);
			element = Locators.getInstance().plantWidth(driver);
			Keywords.typeText(element, width);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Width</b> enter successfully", "PASS", "<b>Current Width</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Width</b> not enter successfully", "FAIL",
						"<b>Current Width</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Current Width</b>", "FAIL",
					"<b>Current Width</b> should be entered");
		}

		return width;
	}

	public String fillCurrentDiameter() {
		WebElement element;
		String diameter = "";
		try {
			diameter = "" + Keywords.getRandomInteger(10);
			element = Locators.getInstance().plantDiameter(driver);
			Keywords.typeText(element, diameter);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Diameter</b> enter successfully", "PASS",
						"<b>Current Diameter</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Diameter</b> not enter successfully", "FAIL",
						"<b>Current Diameter</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Current Diameter</b>", "FAIL",
					"<b>Current Diameter</b> should be entered");
		}

		return diameter;
	}

	public String selectSizeUnit() {
		WebElement element;
		String unit = "";
		int randomNumber = 0;
		try {
			randomNumber = Keywords.getRandomInteger(3);
			element = Locators.getInstance().plantSizUnit(driver);
			unit = Keywords.selectByIndex(element, randomNumber);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Unit</b> select successfully",
						"PASS", "<b>Unit</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Unit</b> not select successfully", "FAIL", "<b>Unit</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Unit</b>", "FAIL", "<b>Unit</b> should be entered");
		}

		return unit;
	}

	public String getCurrentPlantSizeWithAllParameter() {
		String allPlantUnit = "";

		allPlantUnit = "H " + fillCurrentHeight();
		allPlantUnit = allPlantUnit + " W " + fillCurrentWidth();
		allPlantUnit = allPlantUnit + " D " + fillCurrentDiameter();
		allPlantUnit = allPlantUnit + " " + selectSizeUnit();

		return allPlantUnit;
	}

	// fill plants Scientific info
	public List<String> fillPlantScientificInfo() {
		List<String> scientificInfo = new ArrayList<>();
		List<WebElement> scientificTextLabel;
		List<WebElement> scientificValue;
		String value = "";
		try {
			scientificTextLabel = Locators.getInstance().plantsScientificTextLabel(driver);
			scientificValue = Locators.getInstance().fillPlantScientificValue(driver);
			for (int i = 0; i < scientificTextLabel.size(); i++) {
				value = Keywords.getText(scientificTextLabel.get(i));
				Keywords.typeText(scientificValue.get(i), value);
				scientificInfo.add(value);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Scientific value</b> " + value + " enter successfully", "PASS",
						"<b>Scientific value</b> " + value + " should be entered");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Scientific value</b> " + value, "FAIL",
					"<b>Scientific value</b> " + value + " should be entered");
		}

		return scientificInfo;
	}

	// ***************************** Growing Preferences details
	// ***********************************
	public List<String> fillGrowingPreferencesDetails() {
		List<String> details = new ArrayList<>();
		try {

		} catch (Exception e) {

		}

		return details;
	}

	// Add Sun Preference
	public String addSunPreference() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().chooseSunPreferencesValue(driver);
			preferenceCheckBoxes = Locators.getInstance().chooseSunPreferencesCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Sun Preference</b> selected successfully", "PASS",
						"<b>Sun Preference</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Sun Preference</b> not selected successfully", "FAIL",
					"<b>Sun Preference</b> should be selected");
		}

		return preferencesList;
	}

	// Interior Light
	public String addInteriorLight() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().chooseInteriorValue(driver);
			preferenceCheckBoxes = Locators.getInstance().chooseInteriorCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Interior Light</b> selected successfully", "PASS",
						"<b>Interior Light</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Interior Light</b> not selected successfully", "FAIL",
					"<b>Interior Light</b> should be selected");
		}

		return preferencesList;
	}

	// Soil Preference
	public String addSoilPreference() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().chooseSoilPreferencesValue(driver);
			preferenceCheckBoxes = Locators.getInstance().chooseSoilPreferencesCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Soil Preference</b> selected successfully", "PASS",
						"<b>Soil Preference</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Soil Preference</b> not selected successfully", "FAIL",
					"<b>Soil Preference</b> should be selected");
		}

		return preferencesList;
	}

	// Ph Preference
	public String addPhPreference() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().choosePhPreferencesValue(driver);
			preferenceCheckBoxes = Locators.getInstance().choosePhPreferencesCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Soil Preference</b> selected successfully", "PASS",
						"<b>Soil Preference</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Soil Preference</b> not selected successfully", "FAIL",
					"<b>Soil Preference</b> should be selected");
		}

		return preferencesList;
	}

	// Water Requirement
	public String addWaterRequirement() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().chooseWaterRequirementValue(driver);
			preferenceCheckBoxes = Locators.getInstance().chooseWaterRequirementCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Water Requirement</b> selected successfully", "PASS",
						"<b>Water Requirement</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Water Requirement</b> not selected successfully", "FAIL",
					"<b>Water Requirement</b> should be selected");
		}

		return preferencesList;
	}

	// USDA Hardiness Zone
	public String addUsdaHardinessZone() {
		String preferencesList = "";
		WebElement selectUsdaHarinessStartZone;
		WebElement selectUsdaHarinessEndZone;
		try {
			Keywords.waitForPage(driver);
			selectUsdaHarinessStartZone = Locators.getInstance().selectUsdaHardinessZone(driver, "start");
			preferencesList = Keywords.selectByIndex(selectUsdaHarinessStartZone, Keywords.getRandomInteger(30));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Usda Hardiness start zone</b> selected successfully", "PASS",
					"<b>Usda Hardiness start zone</b> should be selected");
			selectUsdaHarinessEndZone = Locators.getInstance().selectUsdaHardinessZone(driver, "end");
			preferencesList = preferencesList + " - "
					+ Keywords.selectByIndex(selectUsdaHarinessEndZone, Keywords.getRandomInteger(20));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Usda Hardiness end zone</b> selected successfully", "PASS",
					"<b>Usda Hardiness end zone</b> should be selected");
		} catch (

		Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Usda Hardiness zone</b> not selected successfully", "FAIL",
					"<b>Usda Hardiness zone</b> should be selected");
		}

		return preferencesList;
	}

	// Native Range
	public String addNativeRange() {
		String preferencesList = "";
		WebElement element;
		int randonRange = 0;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().nativeRange(driver);
			randonRange = Keywords.getRandomInteger(20);
			if (randonRange == 0)
				randonRange++;
			preferencesList = randonRange + "";
			Keywords.typeText(element, preferencesList);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Native Range</b> selected successfully", "PASS", "<b>Native Range</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Native Range</b> not selected successfully", "FAIL", "<b>Native Range</b> should be selected");
		}

		return preferencesList;
	}

	// Native Habitat
	public String addNativeHabitat() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().chooseNativeHabitatValue(driver);
			preferenceCheckBoxes = Locators.getInstance().chooseNativeHabitatCheckboxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Native Habitat</b> selected successfully", "PASS",
						"<b>Native Habitat</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Native Habitat</b> not selected successfully", "FAIL",
					"<b>Native Habitat</b> should be selected");
		}

		return preferencesList;
	}

	// **************************** Plant Growing Information
	// ********************************************
	public String fillDayToHarvest() {
		String harvest = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			harvest = "havvest" + Keywords.getRandomInteger(10);
			element = Locators.getInstance().dayToHarvest(driver);
			Keywords.typeText(element, harvest);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Day To Harvest</b> enter successfully", "PASS", "<b>Day To Harvest</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Day To Harvest</b> not enter successfully", "FAIL",
						"<b>Day To Harvest</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Day To Harvest</b> text", "FAIL",
					"<b>Day To Harvest</b> should be entered");
		}
		return harvest;
	}

	public String fillSeedGemination() {
		String harvest = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			harvest = "Seed Germination" + Keywords.getRandomInteger(10);
			element = Locators.getInstance().seedGermination(driver);
			Keywords.typeText(element, harvest);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Seed Germinationt</b> enter successfully", "PASS",
						"<b>Seed Germination</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Seed Germination</b> not enter successfully", "FAIL",
						"<b>Seed Germination</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Seed Germination</b> text", "FAIL",
					"<b>Seed Germination</b> should be entered");
		}
		return harvest;
	}

	public String fillAverageHeight() {
		String avgMinHgt = "";
		String avgMaxHgt = "";
		WebElement element;
		int height = 0;
		String valueWithUnit = "";
		int randomIndex = 0;
		try {
			randomIndex = Keywords.getRandomInteger(3);
			height = Keywords.getRandomInteger(50);
			avgMinHgt = height + "";
			valueWithUnit = avgMinHgt;
			Keywords.waitForPage(driver);
			element = Locators.getInstance().avgMinHeight(driver);
			Keywords.typeText(element, avgMinHgt);
			height = Keywords.getRandomInteger(50);
			avgMaxHgt = height + "";
			valueWithUnit = valueWithUnit + " - " + avgMaxHgt;
			element = Locators.getInstance().avgMaxHeight(driver);
			Keywords.typeText(element, avgMaxHgt);
			element = Locators.getInstance().selectHeightUnit(driver);
			valueWithUnit = valueWithUnit + "   " + Keywords.selectByIndex(element, randomIndex);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Average Height</b> enter successfully", "PASS", "<b>Average Height</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Average Height</b> not enter successfully", "FAIL",
						"<b>Average Height</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Average Height</b> text", "FAIL",
					"<b>Average Height</b> should be entered");
		}

		return valueWithUnit;
	}

	public String fillAverageWidth() {
		String avgMinWidth = "";
		String avgMaxWidth = "";
		WebElement element;
		int width = 0;
		String valueWithUnit = "";
		int randomIndex = 0;
		try {
			randomIndex = Keywords.getRandomInteger(3);
			width = Keywords.getRandomInteger(100);
			avgMinWidth = width + "";
			valueWithUnit = avgMinWidth;
			Keywords.waitForPage(driver);
			element = Locators.getInstance().avgMinWidth(driver);
			Keywords.typeText(element, avgMinWidth);
			width = Keywords.getRandomInteger(200);
			avgMaxWidth = width + "";
			valueWithUnit = valueWithUnit + " - " + avgMaxWidth;
			element = Locators.getInstance().avgMaxWidth(driver);
			Keywords.typeText(element, avgMaxWidth);
			element = Locators.getInstance().selectAvgWidth(driver);
			valueWithUnit = valueWithUnit + "   " + Keywords.selectByIndex(element, randomIndex);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Average Width</b> enter successfully", "PASS", "<b>Average Width</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Average Width</b> not enter successfully", "FAIL",
						"<b>Average Width</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Average Width</b> text", "FAIL",
					"<b>Average Width</b> should be entered");
		}

		return valueWithUnit;
	}

	// Spacing Height
	public String fillSpacingHeight() {
		String avgHeight = "";
		WebElement element;
		int height = 0;
		int randomIndex = 0;
		try {
			randomIndex = Keywords.getRandomInteger(3);
			height = Keywords.getRandomInteger(200);
			avgHeight = height + "";
			Keywords.waitForPage(driver);
			element = Locators.getInstance().spacingHeight(driver);
			Keywords.typeText(element, avgHeight);
			element = Locators.getInstance().selectAvgSpacing(driver);
			spacingUnit = Keywords.selectByIndex(element, randomIndex);
			avgHeight = avgHeight + " " + spacingUnit;
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Spacing Height</b> enter successfully", "PASS", "<b>Spacing Height</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Spacing Height</b> not enter successfully", "FAIL",
						"<b>Spacing Height</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Spacing Height</b> text", "FAIL",
					"<b>Spacing Height</b> should be entered");
		}

		return avgHeight;
	}

	// Spacing Width
	public String fillSpacingWidth() {
		String avgWidth = "";
		WebElement element;
		int width = 0;
		try {
			width = Keywords.getRandomInteger(100);
			avgWidth = width + "";
			Keywords.waitForPage(driver);
			element = Locators.getInstance().spacingWidth(driver);
			Keywords.typeText(element, avgWidth);
			/*
			 * element = Locators.getInstance().selectAvgSpacing(driver);
			 * spacingUnit = Keywords.selectByIndex(element, randomIndex);
			 */
			avgWidth = avgWidth + " " + spacingUnit;
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Spacing Width</b> enter successfully", "PASS", "<b>Spacing Width</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Spacing Width</b> not enter successfully", "FAIL",
						"<b>Spacing Width</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Spacing Width</b> text", "FAIL",
					"<b>Spacing Width</b> should be entered");
		}

		return avgWidth;
	}

	public List<String> errorList() {
		List<String> errors = new ArrayList<>();
		errors.add(DriverSession.getTestCaseData().get("AverageMinHeightErrorMessage"));
		errors.add(DriverSession.getTestCaseData().get("AverageMaxHeightErrorMessage"));
		errors.add(DriverSession.getTestCaseData().get("AverageMinWidthErrorMessage"));
		errors.add(DriverSession.getTestCaseData().get("AverageMaxWidthErrorMessage"));
		errors.add(DriverSession.getTestCaseData().get("HeightNumericErrorMessage"));
		errors.add(DriverSession.getTestCaseData().get("WidthNumericErrorMessage"));

		// errors.add("Average Height must be numeric.");
		// errors.add("Max Average Height must be numeric.");
		// errors.add("Average Width must be numeric.");
		// errors.add("Max Average Width must be numeric.");
		// errors.add("Height must be numeric.");
		// errors.add("Width must be numeric.");

		return errors;
	}

	public void verifyTextFieldRequiredData() {
		List<WebElement> errorMessageList;
		List<String> errorsList;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().avgMinHeight(driver);
			Keywords.typeText(element, "min height");
			element = Locators.getInstance().avgMaxHeight(driver);
			Keywords.typeText(element, "max height");
			element = Locators.getInstance().avgMinWidth(driver);
			Keywords.typeText(element, "min Width");
			element = Locators.getInstance().avgMaxWidth(driver);
			Keywords.typeText(element, "max Width");
			element = Locators.getInstance().spacingHeight(driver);
			Keywords.typeText(element, "Spacing Height");
			element = Locators.getInstance().spacingWidth(driver);
			Keywords.typeText(element, "Spacing Width");
			clickOnSaveButton();
			errorsList = errorList();
			errorMessageList = Locators.getInstance().errorMessagesListForHeightWidthValidation(driver);
			for (int i = 0; i < errorMessageList.size(); i++) {
				if (Keywords.getText(errorMessageList.get(i)).equalsIgnoreCase(errorsList.get(i))) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Error Message</b> " + errorsList.get(i) + " visible successfully", "PASS",
							"<b>Error Message</b> " + errorsList.get(i) + " should be present");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Error Message</b> " + errorsList.get(i) + " not visible successfully", "FAIL",
							"<b>Error Message</b> " + errorsList.get(i) + " should be present");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing error messages", "FAIL", "Error Messages should be present");
		}

	}

	public String colorName() {
		List<String> list = new ArrayList<>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Gray");

		return list.get(Keywords.getRandomInteger(list.size()));
	}

	// FLower color
	public String flowerColor() {
		String flowerCol = "";
		WebElement element;
		try {
			flowerCol = colorName();
			element = Locators.getInstance().flowerColor(driver);
			Keywords.typeText(element, flowerCol);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Flower Color</b> enter successfully", "PASS", "<b>Flower Color</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Flower Color</b> not enter successfully", "FAIL", "<b>Flower Color</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Flower Color</b> text", "FAIL",
					"<b>Flower Color</b> should be entered");
		}

		return flowerCol;
	}

	// Flowering Period
	public String floweringPeriod() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().floweringValue(driver);
			preferenceCheckBoxes = Locators.getInstance().floweringCheckBoxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Flowering Period</b> selected successfully", "PASS",
						"<b>Flowering Period</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Flowering Period</b> not selected successfully", "FAIL",
					"<b>Flowering Period</b> should be selected");
		}

		return preferencesList;
	}

	public String foliageColor() {
		String foliageCol = "";
		WebElement element;
		try {
			foliageCol = colorName();
			element = Locators.getInstance().foliageColor(driver);
			Keywords.typeText(element, foliageCol);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Foliage Color</b> enter successfully", "PASS", "<b>Foliage Color</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Foliage Color</b> not enter successfully", "FAIL",
						"<b>Foliage Color</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Foliage Color</b> text", "FAIL",
					"<b>Foliage Color</b> should be entered");
		}

		return foliageCol;
	}

	public String plantAttribute() {
		String preferencesList = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		int randomNumber = 0;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().plantAttributeValue(driver);
			preferenceCheckBoxes = Locators.getInstance().plantAttributeCheckBoxes(driver);
			randomNumber = Keywords.getRandomInteger(preferenceOptions.size());
			Keywords.click(preferenceCheckBoxes.get(randomNumber));
			preferencesList = Keywords.getText(preferenceOptions.get(randomNumber));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plant Attribute</b> selected successfully", "PASS",
						"<b>Plant Attribute</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plant Attribute</b> not selected successfully", "FAIL",
						"<b>Plant Attribute</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Plant Attribute</b>", "FAIL",
					"<b>Plant Attribute</b> should be selected");
		}

		return preferencesList;
	}

	public String tolerates() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().toleratesValue(driver);
			preferenceCheckBoxes = Locators.getInstance().toleratesCheckBoxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tolerates</b> selected successfully", "PASS", "<b>Tolerates</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Tolerates</b> not selected successfully", "FAIL", "<b>Tolerates</b> should be selected");
		}

		return preferencesList;
	}

	public String attracts() {
		String preferencesList = "";
		String preferenceValue = "";
		List<WebElement> preferenceOptions;
		List<WebElement> preferenceCheckBoxes;
		try {
			Keywords.waitForPage(driver);
			preferenceOptions = Locators.getInstance().attractsValue(driver);
			preferenceCheckBoxes = Locators.getInstance().attractsCheckBoxes(driver);
			for (int i = 0; i < preferenceOptions.size(); i++) {
				preferenceValue = Keywords.getText(preferenceOptions.get(i));
				Keywords.click(preferenceCheckBoxes.get(i));
				if (i < preferenceOptions.size()) {
					preferencesList = preferencesList + preferenceValue;
					if (i != preferenceOptions.size() - 1) {
						preferencesList = preferencesList + ", ";
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Attracts</b> selected successfully", "PASS", "<b>Attracts</b> should be selected");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Attracts</b> not selected successfully", "FAIL", "<b>Attracts</b> should be selected");
		}

		return preferencesList;
	}

	// Get Plant Information value
	public List<String> getPlantInformation() {
		List<String> plantInfo = new ArrayList<>();
		List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			informationText = Locators.getInstance().getPlantInformationTextLabel(driver);
			informationValue = Locators.getInstance().getPlantInformationValues(driver);
			for (int i = 0; i < informationText.size() - 1; i++) {
				plantInfo.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return plantInfo;
	}

	// get plant category
	public List<String> getCategoryList() {
		List<String> categoryInfo = new ArrayList<>();
		WebElement element;
		String text = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getCatgeoryList(driver);
			text = Keywords.getText(element);
			// System.out.println("String text value..." + text);
			categoryInfo = Arrays.asList(text.split(","));
		} catch (Exception e) {
		}

		return categoryInfo;
	}

	// get plant category
	public List<String> getPlantOwnerInformation() {
		List<String> ownerInfo = new ArrayList<>();
		List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			informationText = Locators.getInstance().getPlantOwnerInformationTextLabel(driver);
			informationValue = Locators.getInstance().getPlantOwnerInformationValues(driver);
			for (int i = 0; i < informationText.size(); i++) {
				ownerInfo.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return ownerInfo;
	}

	/* get plant scientific value */
	public List<String> getPlantScientificInformation() {
		List<String> scienctificInfo = new ArrayList<>();
		List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			informationText = Locators.getInstance().getPlantScientificClassificationTextLabel(driver);
			informationValue = Locators.getInstance().getPlantScientificClassificationValues(driver);
			for (int i = 0; i < informationText.size(); i++) {
				scienctificInfo.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return scienctificInfo;
	}

	// get plant Growing Preference Details.
	public List<String> getPlantGrowingPreferenceInformation() {
		List<String> growingPreference = new ArrayList<>();
		// List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			// informationText =
			// Locators.getInstance().getPlantGrowingPreferenceTextLabel(driver);
			informationValue = Locators.getInstance().getPlantGrowingPreferenceValues(driver);
			for (int i = 0; i < informationValue.size(); i++) {
				growingPreference.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return growingPreference;
	}

	// Get Plant Growing information Details.
	public List<String> getPlantGrowingInformation() {
		List<String> growingInfo = new ArrayList<>();
		List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			informationText = Locators.getInstance().getPlantGrowingInformationTextLabel(driver);
			informationValue = Locators.getInstance().getPlantGrowingInformationValues(driver);
			for (int i = 0; i < informationText.size(); i++) {
				growingInfo.add(Keywords.getText(informationValue.get(i)));
				// if
				// (informationText.get(i).getText().equalsIgnoreCase("Average
				// Size") ||
				// informationText.get(i).getText().equalsIgnoreCase("Spacing"))
				// {
				// }
				// else
				// growingInfo.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return growingInfo;
	}

	// Get Plant Tab Manager information Details.
	public List<String> getPlantTabManagerInformation() {
		List<String> plantTabManager = new ArrayList<>();
		List<WebElement> informationText;
		List<WebElement> informationValue;
		try {
			Keywords.waitForPage(driver);
			informationText = Locators.getInstance().getPlantTabManagerTextLabel(driver);
			informationValue = Locators.getInstance().getPlantTabManagerValues(driver);
			for (int i = 0; i < informationText.size(); i++) {
				plantTabManager.add(Keywords.getText(informationValue.get(i)));
			}
		} catch (Exception e) {
		}

		return plantTabManager;
	}

	// Plant Note data
	public List<String> getNotesData() {
		List<String> notesdata = new ArrayList<>();
		try {
			notesdata.add(getPlantsNotesTitle());
			notesdata.add(getPlantsNotesDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notesdata;
	}

	// Plant Note data
	public List<String> getPlantsCommentData() {
		List<String> comment = new ArrayList<>();
		try {
			comment.add(getPlantsComments());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comment;
	}

	public String getPlantCreatedDate() {
		WebElement element;
		String createdDate = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantCreatedDate(driver);
			createdDate = Keywords.getText(element);
			createdDate = createdDate.substring(createdDate.indexOf(':') + 2, createdDate.indexOf(';')).trim();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Plant Createddate visible successfully</b>", "PASS",
					"<b>Plant Created date should be visible</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return createdDate;
	}

	public String getPlantUpdationDate() {
		WebElement element;
		String updationDate = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getPlantCreatedDate(driver);
			updationDate = Keywords.getText(element);
			updationDate = updationDate.substring(updationDate.indexOf("Updated on:"), updationDate.length())
					.replace("Updated on:", "").trim();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Plant Updation date visible successfully</b>", "PASS",
					"<b>Plant Updation date should be visible</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updationDate;
	}

	public void sortPlantBy(String sortType) {
		WebElement element;
		List<WebElement> list;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnSortBy(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			list = Locators.getInstance().getSortTypeList(driver);
			for (int i = 0; i < list.size(); i++) {
				if (Keywords.getText(list.get(i)).equalsIgnoreCase(sortType)) {
					Keywords.click(list.get(i));
					Thread.sleep(2000);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Sort By Option select successfully", "PASS", "Sort By Option should be selected");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Sort By Option not select successfully", "FAIL", "Sort By Option should be selected");
		}
	}

	public int plantCountOnUserPorfilePage() {
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			count = Locators.getInstance().getPlantListFromUserProfilePage(driver).size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int collectionsCountOnUserPorfilePage() {
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			count = Locators.getInstance().getCollectionsListFromUserProfilePage(driver).size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int organizationCountOnUserPorfilePage() {
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			count = Locators.getInstance().getOrgListFromUserProfilePage(driver).size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public void selectViewMoreBtn(String viewType) {
		WebElement element = null;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			if (viewType.equalsIgnoreCase("plants"))
				element = Locators.getInstance().viewMorePlants(driver);
			else if (viewType.equalsIgnoreCase("collections"))
				element = Locators.getInstance().viewMoreCollections(driver);
			else if (viewType.equalsIgnoreCase("organization"))
				element = Locators.getInstance().viewMoreOrganization(driver);
			else if (viewType.equalsIgnoreCase("news"))
				element = Locators.getInstance().viewMoreNews(driver);
			Thread.sleep(2000);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View More Button click successfully</b>", "PASS",
						"<b>View More Button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View More Button not click successfully</b>", "FAIL",
						"<b>View More Button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the View More Button</b>", "FAIL",
					"<b>View More Button should be clicked</b>");
		}
	}

	public void moveToLastIndex() {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().moveToLastIndex(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public int firstIndexValue() {
		WebElement element;
		int firstIndexValue = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().firstIndexValue(driver);
			firstIndexValue = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
		}

		return firstIndexValue;
	}

	public int getLastIndexValue() {
		WebElement element;
		int lastIndexValue = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().getLastIndexValue(driver);
			lastIndexValue = Integer.parseInt(Keywords.getText(element));
			Keywords.click(element);
			Keywords.waitForPageFullyLoaded(driver);
		} catch (Exception e) {
		}

		return lastIndexValue;
	}

	public int getPlantCount() {
		int plantCount = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			plantCount = Locators.getInstance().getCountPlantCollectionsOrgOnPlantDetailPageByViewMore(driver).size();
		} catch (Exception e) {

		}

		return plantCount;
	}

	public int totalPlants() {
		int plants = 0;
		int firstIndexValue = 0;
		int plantCountOnFirstPage = 0;
		int plantCountOnLastPage = 0;
		try {
			firstIndexValue = firstIndexValue();
			plantCountOnFirstPage = getPlantCount();
			moveToLastIndex();
			int lastIndex = getLastIndexValue();
			if (firstIndexValue == lastIndex) {
				plants = plantCountOnFirstPage;
			} else {
				plantCountOnLastPage = getPlantCount();
				plants = plantCountOnFirstPage * (lastIndex - 1) + plantCountOnLastPage;
			}
		} catch (Exception e) {
		}

		return plants;
	}

	public void selectRandomIndex() {
		List<WebElement> elementList;
		int randomIndexValue = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().getIndexList(driver);
			randomIndexValue = Keywords.getRandomInteger(elementList.size() - 1);
			Keywords.click(elementList.get(randomIndexValue));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Randon Index value select successfully</b>", "PASS",
						"<b>Randon Index value should be selected</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Randon Index value not select successfully</b>", "FAIL",
						"<b>Randon Index value should be selected</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Randon Index value</b>", "FAIL",
					"<b>Randon Index value should be selected</b>");
		}
	}
}
