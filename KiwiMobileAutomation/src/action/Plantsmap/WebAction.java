package action.Plantsmap;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.ExcelUtility;
import com.utilities.Keywords;

import Plantsmap.DesktopWeb.Admin;
import Plantsmap.DesktopWeb.AdminCollection;
import Plantsmap.DesktopWeb.AdminOrganization;
import Plantsmap.DesktopWeb.AdminPlant;
import Plantsmap.DesktopWeb.AdminUser;
import Plantsmap.DesktopWeb.CartPage;
import Plantsmap.DesktopWeb.Collections;
import Plantsmap.DesktopWeb.HomePage;
import Plantsmap.DesktopWeb.Locators;
import Plantsmap.DesktopWeb.LoginScreen;
import Plantsmap.DesktopWeb.ManageUsers;
import Plantsmap.DesktopWeb.Organization;
import Plantsmap.DesktopWeb.PlaceOrder;
import Plantsmap.DesktopWeb.Plants;
import Plantsmap.DesktopWeb.Profile;
import Plantsmap.DesktopWeb.Registration;
import Plantsmap.DesktopWeb.Search;
import Plantsmap.DesktopWeb.Sharing;
import Plantsmap.DesktopWeb.ShippingAddressInfo;
import Plantsmap.DesktopWeb.TabManager;
import Plantsmap.DesktopWeb.Tags;
import Plantsmap.DesktopWeb.TagsAndImagesLink;
import action.CommonAll;

public class WebAction extends CommonAll {
	HashMap<String, String> testData = new HashMap<String, String>();

	public WebAction(WebDriver driver) {
		super(DriverSession.getLastExecutionDriver());
		this.testData = DriverSession.getTestCaseData();
	}

	public void clickOnSignInLink() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.clickOnSignInLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			if (login.loginStatus()) {
				login.clickOnSignInLink();
				login.enterEmailId();
				login.enterPassword();
				login.submitSingIn();
				login.hideProfileContentStatus();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(String userEmail, String password) {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			if (login.loginStatus()) {
				login.clickOnSignInLink();
				login.enterEmailId(userEmail);
				login.enterPassword(password);
				login.submitSingIn();
				login.hideProfileContentStatus();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			if (!login.loginStatus()) {
				profile.enableProfileHideContent();
				profile.clickOnLogoutButton();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginAsAdmin() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			if (!admin.loginStatus()) {
				admin.enterAdminEmailId();
				admin.enterAdminPassword();
				admin.submitAdminSingIn();
				admin.verifyAdminLoginSuccessfully();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logoutFromAdmin() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			if (admin.verifyAdminLoginSuccessfully())
				admin.clickOnSignOut();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void footerLinkText() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify Footer links</b>");
			login();
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.verifyFooterLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMainHeaderAndSubHeaderTab() {
		List<String> headerTabList;
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			headerTabList = home.headerLinksText();
			home.checkSubTabsOfMainHeaderTabFunctionality(headerTabList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void innerTabOfAboutLink() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify Inner Tabs of About Link</b>");
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.verifyAboutInnerTab("About");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void homeLink() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify Inner Tabs of About Link</b>");
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab("Home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void innerTabOfExploreLink() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify inner tabs of explore link</b>");
			selectHeaderTab("Explore");
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.verifySubTabOfExploreLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLoginFunctionalityWithRequiredField() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - LOGIN WITHOUT EMAIL ID FIELD</b>");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.clickOnSignInLink();
			login.enterPassword();
			login.submitSingIn();
			login.verifyErrorMessageForLoginWithoutEmailId();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - LOGIN WITHOUT PASSWORD FIELD</b>");
			login.enterEmailId();
			login.submitSingIn();
			login.verifyErrorMessageForLoginWithoutPassword();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - LOGIN WITHOUT MANDATORY FIELDS</b>");
			login.submitSingIn();
			login.verifyErrorMessageForLoginWithoutEmailId();
			login.verifyErrorMessageForLoginWithoutPassword();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b> TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 LOGIN WITH INVALID CREDENTIALS</b>");
			login.enterEmailId("plantsmaptest");
			login.submitSingIn();
			login.verifyErrorMessageForInvalidEmailId();
			Keywords.refreshPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySignUpFunctionality() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - SIGNUP WITHOUT EMAIL ID FIELD</b>");
			Registration registration = new Registration(DriverSession.getLastExecutionDriver());
			registration.enterUserPassword();
			registration.submitSignUpButton();
			registration.verifyErrorMessageForSignUpWithoutEmailId();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - SIGNUP WITHOUT PASSWORD FIELD</b>");
			registration.enterUserEmailId();
			registration.submitSignUpButton();
			registration.verifyErrorMessageForSignUpWithoutPassword();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - SIGNUP INAVLID EMAIL ID FORMAT</b>");
			registration.enterUserInavlidEmailId(DriverSession.getTestCaseData().get("InvalidEmailId"));
			registration.enterUserPassword();
			registration.submitSignUpButton();
			registration.verifyErrorMessageForSignUpInvalidEmailId();
			Keywords.refreshPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - SIGNUP INAVLID PASSWORD LENGTH FORMAT</b>");
			registration.enterUserEmailId();
			registration.enterUserInvalidPasswordLength();
			registration.submitSignUpButton();
			registration.verifyErrorMessageForSignUpPasswordInvalidLength();
			Keywords.refreshPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> signUp() {
		List<String> credentialInfo = new ArrayList<>();
		try {
			Registration registration = new Registration(DriverSession.getLastExecutionDriver());
			credentialInfo.add(registration.enterUserEmailId());
			credentialInfo.add(registration.enterUserPassword());
			registration.submitSignUpButton();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return credentialInfo;
	}

	public List<String> signUpFromMainPage() {
		List<String> credentialInfo = new ArrayList<>();
		try {
			Registration registration = new Registration(DriverSession.getLastExecutionDriver());
			Thread.sleep(2000);
			credentialInfo.add(registration.enterUserEmailId());
			Thread.sleep(2000);
			credentialInfo.add(registration.enterUserPassword());
			Thread.sleep(2000);
			registration.clickOnSignUpBtnFomHomeOrMainPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credentialInfo;
	}

	public void signUpWithAlreadyUsedData(List<String> info) {
		List<String> credentialInfo = info;
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - SIGNUP WITH ALREADY USED DATA</b>");
			Registration registration = new Registration(DriverSession.getLastExecutionDriver());
			registration.enterUserEmailId(credentialInfo.get(0));
			registration.enterUserPassword(credentialInfo.get(1));
			registration.submitSignUpButton();
			registration.verifyErrorMessageForAlreadyUsedEmailId();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectHeaderTab(String headerTabName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab(headerTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectHeaderSubTabs(String headerTabName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHeaderSubTab(headerTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectExploreInnerTab(String tabName) {
		String selectedTab = "";
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectExploreInnerTab(tabName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return selectedTab;
	}

	public String selectExploreSubTabs(String headerSubTabName) {
		String selectedTab = "";
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			selectHeaderTab("Explore");
			home.selectHeaderSubTab(headerSubTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return selectedTab;
	}

	public void verifyPlantPrivateLocation(String plantTitleName, String plantPrivateAddress) {
		String privateLocation = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			selectExploreInnerTab("Plants");
			selectPlantFromPlantTab(plantTitleName);
			privateLocation = plant.getPlantPrivateLocation();
			if (!privateLocation.equalsIgnoreCase(plantPrivateAddress)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>UnAuthorized User unable to see others plants private location</b> ", "PASS",
						"<b>UnAuthorized User Should not be able to see Other Users Plant Private Address</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>UnAuthorized User able to see others plants private location</b> ", "FAIL",
						"<b>UnAuthorized User Should not be able to see Other Users Plant Private Address</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAddType(String optionTagName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.clickOnAddNewTag();
			home.selectAddOptionTag(optionTagName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> createNewPlant(String location) {
		List<String> plantData = new ArrayList<String>();
		// String plantTitle = "";
		// String plantStory = "";
		// String plantLocation = "";
		List<String> storyInfo;
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - CREATE NEW PLANT</b>");
			selectAddType("plants");
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			plant.verifyAddNewPlantHeader();
			plantData.add(plant.addPlantTitle());

			storyInfo = plant.addPlantStory();
			plantData.add(storyInfo.get(0));

			plant.verifyImageDimensionFormat();
			plant.addPlantImage();

			plantData.add(plant.addAddress(location));

			submitPlantDetailPage();
			plant.verifyViewMoreLessBtnFunctionality(storyInfo.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantData;
	}

	public void addPlantPhotoAndCaptain() {
		String photoCaption = "";
		String updatePhotoCaption = "";
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			plants.selectPlantSubTab("photos");
			plants.addPhotos();
			photoCaption = plants.addPhotoCaption();
			plants.uploadPhoto();
			updatePhotoCaption = plants.verifyAddedPhotoCaptionAndUpdateCaption(photoCaption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addPlantNotesAndDescription() {
		List<String> notesData = new ArrayList<>();
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			plants.selectPlantSubTab("notes");
			plants.clickOnAddNotes();
			plants.submitNotes();
			plants.verifyNotesTitleRequired();
			plants.verifyNotesDescriptionRequired();
			notesData.add(plants.addNotesTitle());
			plants.submitNotes();
			plants.verifyNotesDescriptionRequired();
			notesData.add(plants.addNotesDescription());
			plants.makeNotesVisibility("public");
			plants.submitNotes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notesData;
	}

	public List<String> addComments() {
		List<String> comment = new ArrayList<>();
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			plants.selectPlantSubTab("comment");
			comment.add(plants.writeComment());
			plants.submitComment();
			// comment.add(plants.getPlantsComments());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comment;
	}

	public List<String> selectTabAndFillFormData() {
		String tabName = "TesterTab";
		List<String> tabManagerFormData = new ArrayList<>();
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			plants.selectAddedTabName(tabName);
			plants.navigateToTabManagerOnPlantsPage(tabName);
			tabManagerFormData = plants.fillTabManagerTextFields();// plants.fillAddedTabNameList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tabManagerFormData;
	}

	public List<String> fillPlantInformation() {
		List<String> plantInfo = new ArrayList<>();
		/*
		 * List<String> plantCategory = new ArrayList<>(); List<String>
		 * plantOwnerInfo = new ArrayList<>(); List<String> plantScientific =
		 * new ArrayList<>(); List<String> allData = new ArrayList<>();
		 */
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantInfo.add(plant.enterBotanicalName());
			plantInfo.add(plant.enterCommanName());
			plantInfo.add(plant.enterSynonymName());
			plantInfo.add(plant.enterTradeName());
			plantInfo.add(plant.enterClassOrTypeName());
			/*
			 * // plantCategory = plant.selectCategoryCheckBoxes(); //
			 * plantOwnerInfo.add(plant.fillAccessionCode());
			 * plantOwnerInfo.add(plant.fillDateAcquired());
			 * plantOwnerInfo.add(plant.fillAcquiredFromSource());
			 * plantOwnerInfo.add(plant.fillDatePlanted());
			 * plantOwnerInfo.add(plant.fillQuantity());
			 * plantOwnerInfo.add(plant.fillStatus());
			 * plantOwnerInfo.add(plant.fillStatusNote());
			 * plantOwnerInfo.add(plant.getCurrentPlantSizeWithAllParameter());
			 * plantOwnerInfo.add(plant.fillRefrenceLinkTitle());
			 * plantOwnerInfo.add(plant.fillRefrenceLinkUrl()); //
			 * plantScientific = plant.fillPlantScientificInfo();
			 * 
			 * // add allData.addAll(plantInfo); allData.addAll(plantCategory);
			 * allData.addAll(plantOwnerInfo); allData.addAll(plantScientific);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantInfo;
	}

	public List<String> fillPlantsCategoryInfo() {
		List<String> categoryInfoList = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			categoryInfoList = plant.selectCategoryCheckBoxes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryInfoList;
	}

	public List<String> fillPlantOwnerInformation() {
		List<String> ownerInfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			ownerInfo.add(plant.fillAccessionCode());
			ownerInfo.add(plant.fillDateAcquired());
			ownerInfo.add(plant.fillAcquiredFromSource());
			ownerInfo.add(plant.fillDatePlanted());
			ownerInfo.add(plant.fillQuantity());
			ownerInfo.add(plant.fillStatus());
			ownerInfo.add(plant.fillStatusNote());
			ownerInfo.add(plant.getCurrentPlantSizeWithAllParameter());
			ownerInfo.add(plant.fillRefrenceLinkTitle());
			plant.fillRefrenceLinkUrl();
			// ownerInfo.add(plant.fillRefrenceLinkUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ownerInfo;
	}

	public List<String> fillScientificInformation() {
		List<String> scientificInfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			scientificInfo = plant.fillPlantScientificInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scientificInfo;
	}

	public List<String> fillPlantDetailTabInformation() {
		List<String> plantDetailTabInfo = new ArrayList<>();
		try {
			plantDetailTabInfo.addAll(fillPlantInformation());
			plantDetailTabInfo.addAll(fillPlantsCategoryInfo());
			plantDetailTabInfo.addAll(fillPlantOwnerInformation());
			plantDetailTabInfo.addAll(fillScientificInformation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantDetailTabInfo;
	}

	public List<String> fillPlantGrowingPreferences() {
		List<String> growingPreference = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			growingPreference.add(plant.addSunPreference());
			growingPreference.add(plant.addInteriorLight());
			growingPreference.add(plant.addSoilPreference());
			growingPreference.add(plant.addPhPreference());
			growingPreference.add(plant.addWaterRequirement());
			growingPreference.add(plant.addUsdaHardinessZone());
			growingPreference.add(plant.addNativeRange());
			growingPreference.add(plant.addNativeHabitat());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return growingPreference;
	}

	public List<String> fillPlantGrowingInformation() {
		List<String> growingInformation = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			growingInformation.add(plant.fillDayToHarvest());
			growingInformation.add(plant.fillSeedGemination());
			plant.verifyTextFieldRequiredData();
			growingInformation.add(plant.fillAverageHeight());
			growingInformation.add(plant.fillAverageWidth());
			growingInformation.add(plant.fillSpacingHeight());
			growingInformation.add(plant.fillSpacingWidth());
			growingInformation.add(plant.flowerColor());
			growingInformation.add(plant.floweringPeriod());

			growingInformation.add(plant.foliageColor());
			growingInformation.add(plant.plantAttribute());
			growingInformation.add(plant.tolerates());
			growingInformation.add(plant.attracts());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return growingInformation;
	}

	public List<String> fillPlantGrowingDetailTabInformation() {
		List<String> growingTabInfo = new ArrayList<>();
		try {
			growingTabInfo.addAll(fillPlantGrowingPreferences());
			growingTabInfo.addAll(fillPlantGrowingInformation());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return growingTabInfo;
	}

	public List<String> getPlantInformation() {
		List<String> plantInfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantInfo = plant.getPlantInformation();
			// System.out.println("Plant info.." + plantInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantInfo;
	}

	public List<String> getPlantCategoryList() {
		List<String> categoryList = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			categoryList = plant.getCategoryList();
			// System.out.println("Plant Category Values.." + categoryList);
		} catch (Exception e) {
		}
		return categoryList;
	}

	public List<String> getPlantOwnerInformation() {
		List<String> plantOwnerInfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantOwnerInfo = plant.getPlantOwnerInformation();
			// System.out.println("Plant Owner info.." + plantOwnerInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantOwnerInfo;
	}

	public List<String> getPlantScienticInformation() {
		List<String> plantScientificInfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantScientificInfo = plant.getPlantScientificInformation();
			// System.out.println("Plant Scientific info.." +
			// plantScientificInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantScientificInfo;
	}

	public List<String> getPlantDetailTabInformation() {
		List<String> info = new ArrayList<>();
		try {
			info.addAll(getPlantInformation());
			info.addAll(getPlantCategoryList());
			info.addAll(getPlantOwnerInformation());
			info.addAll(getPlantScienticInformation());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public List<String> getPlantGrowingPreference() {
		List<String> plantgrowingPreference = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantgrowingPreference = plant.getPlantGrowingPreferenceInformation();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantgrowingPreference;
	}

	public List<String> getPlantGrowingInformation() {
		List<String> plantgrowinginfo = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantgrowinginfo = plant.getPlantGrowingInformation();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantgrowinginfo;
	}

	public List<String> getPlantGrowingTabInformation() {
		List<String> info = new ArrayList<>();
		try {
			info.addAll(getPlantGrowingPreference());
			info.addAll(getPlantGrowingInformation());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	/* Tab Manager data */
	public List<String> getTabManagerInfo() {
		List<String> plantTabManager = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantTabManager = plant.getPlantGrowingInformation();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTabManager;
	}

	public ArrayList<Object> createPlantWithAllFields() {
		ArrayList<Object> info = new ArrayList<>();
		List<String> mainViewData = new ArrayList<String>();
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - CREATE NEW PLANT WITH ALL FIELDS</b>");
			selectAddType("plants");
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			plant.verifyAddNewPlantHeader();
			mainViewData.add(plant.plantTitleWithValidAndInvalid());
			mainViewData.add(plant.addPlantStory().get(0));
			plant.verifyImageDimensionFormat();
			plant.addPlantImage();
			mainViewData.add(plant.addAddress("public"));
			plant.clickOnNextButton();
			info.add(mainViewData);

			/* Photo & captain Tab */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - ADD PHOTO AND CAPTAIN</b>");
			addPlantPhotoAndCaptain();

			/* Plants Details Tab */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - ADD PLANTS DETAILS</b>");
			plant.selectPlantSubTab("plant detail");
			info.add(fillPlantDetailTabInformation());

			/* Growing Details */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - ADD PLANT GROWING DETAILS</b>");
			plant.selectPlantSubTab("growing detail");
			info.add(fillPlantGrowingDetailTabInformation());

			/* Tab Manager */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - FILL DATA FOR TAB MANAGER DETAILS</b>");
			info.add(selectTabAndFillFormData());

			/* Notes Tab */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - ADD PLANTS NOTES</b>");
			info.add(addPlantNotesAndDescription());

			/* Comment Tab */
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
					"<b>TESTCASE 7 - ADD COMMENTS</b>");
			info.addAll(addComments());

			/* submit details */
			plant.clickOnSaveButton();
			plant.plantSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	public List<Object> getPlantCompleteDetail(String getTabDetails) {
		List<Object> obj = new ArrayList<>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			if (getTabDetails.equalsIgnoreCase("main view"))
				obj.add(getPlantDetails());
			/* Plant details */
			else if (getTabDetails.equalsIgnoreCase("plant detail")) {
				plant.selectPlantSubTab("plant detail");
				obj.add(getPlantDetailTabInformation());
			} else if (getTabDetails.equalsIgnoreCase("growing detail")) {
				/* growing details */
				plant.selectPlantSubTab("growing detail");
				obj.add(getPlantGrowingTabInformation());
			} else if (getTabDetails.equalsIgnoreCase("tab")) {
				/* Tab Manager */
				plant.selectPlantSubTab("tab");
				obj.add(plant.getPlantTabManagerInformation());
			} else if (getTabDetails.equalsIgnoreCase("notes")) {
				/* Plant Notes Data */
				plant.selectPlantSubTab("notes");
				obj.add(plant.getNotesData());
			} else if (getTabDetails.equalsIgnoreCase("comment")) {
				/* Plant Comments */
				plant.selectPlantSubTab("comment");
				obj.add(plant.getPlantsCommentData());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	public List<String> tabList() {
		List<String> list = new ArrayList<>();
		try {
			list.add("main view");
			list.add("plant detail");
			list.add("growing detail");
			list.add("tab");
			list.add("notes");
			list.add("comment");
		} catch (Exception e) {
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public void verifyPlantDetailsFromUnAuthorizeUser(List<Object> expectedData, List<String> tabInfo) {
		List<String> dataWhenCreated;
		List<String> dataFromView;
		String plantTitle = ((List<String>) expectedData.get(0)).get(0);
		try {
			selectAddedPlant("mainpage", plantTitle);
			for (int i = 0; i < expectedData.size(); i++) {
				dataWhenCreated = (List<String>) expectedData.get(i);
				// System.out.println("Data when created..." + dataWhenCreated);
				dataFromView = (List<String>) getPlantCompleteDetail(tabInfo.get(i)).get(0);
				// System.out.println("Data From View..." + dataFromView);
				for (int j = 0; j < dataWhenCreated.size(); j++) {
					if (dataWhenCreated.get(j).equalsIgnoreCase(dataFromView.get(j))) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Actual & Expected</b> data match successfully", "PASS",
								"<b>Actual & Expected</b> Data should be match");
					}
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Actual & Expected</b> data not match successfully", "FAIL",
					"<b>Actual & Expected</b> Data should be match");
		}
	}

	public List<String> createNewPlantWithoutAddress() {
		List<String> plantData = new ArrayList<String>();
		String plantTitle = "";
		String plantStory = "";
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - CREATE NEW PLANT WITHOUT ADDRESS</b>");
			selectAddType("plants");
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			plant.verifyAddNewPlantHeader();
			plantTitle = plant.addPlantTitle();
			plantData.add(plantTitle);
			plantStory = plant.addPlantStory().get(0);
			plantData.add(plantStory);
			plant.addPlantImage();
			/*
			 * plantLocation = plant.addAddress(); plantData.add(plantLocation);
			 */
			submitPlantDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantData;
	}

	public List<String> createNewCollection(String locationtype) {
		List<String> collectionInfo = new ArrayList<String>();
		String collectionTitle = "";
		String collectionDescription = "";
		String collectionPhysicalAddress = "";
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			selectAddType("collection");
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			collection.verifyAddNewCollectionHeader();

			collectionTitle = collection.addCollectionTitle();
			collectionInfo.add(collectionTitle);

			collectionDescription = collection.addCollectionDescription();
			collectionInfo.add(collectionDescription);

			collection.addCollectionImage();

			collectionPhysicalAddress = collection.addAddress(locationtype);
			collectionInfo.add(collectionPhysicalAddress);

			submitCollectionDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectionInfo;
	}

	public void addPlantToCollection() {
		try {

		} catch (Exception e) {

		}
	}

	public List<String> createEvent(boolean withOrWithoutReccurringEvent) {
		/*
		 * String eventTitle = ""; String eventPrice = ""; String eventAddress =
		 * ""; String eventCategory = "";
		 */
		String startTime = "";
		String endTime = "";
		String time = "";
		List<String> eventDetails = new ArrayList<String>();
		try {
			selectAddType("event");
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.verifyAddNewEventHeader();
			eventDetails.add(org.addEventTitle());

			org.addEventStartDate();
			startTime = org.addEventStartTime("start time");// "Time:
															// "+org.addEventStartTime("start
															// time");
			if (startTime.length() == 7)
				startTime = "0" + startTime;
			startTime = "Time: " + startTime;
			org.addEventEndDate();
			endTime = org.getEventEndTime().toUpperCase();
			if (endTime.length() == 7)
				endTime = "0" + endTime;
			time = startTime + " - " + endTime;
			eventDetails.add(time);
			eventDetails.add(org.addEventPrice());
			org.addEventDescription();
			eventDetails.add(org.addAddress());
			org.addEventImage();

			/* add event category */
			eventDetails.add(org.getSelectedEventCategory());
			org.clickOnPromoteToExplore();
			if (withOrWithoutReccurringEvent) {
				org.clickOnRecurringEvent();
				List<Object> list = org.selectEventRepeats();
				String eventMessage = (String) list.get(1);
				eventDetails.add(eventMessage);
				int occurrence = (int) list.get(0);
				eventDetails.add(String.valueOf(occurrence));
			}
			submitEventDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventDetails;
	}

	public List<String> createSubCollection(String locationtype) {
		List<String> subCollectionInfo = new ArrayList<String>();
		String subCollectionTitle = "";
		String subCollectionDescription = "";
		String subCollectionPhysicalAddress = "";
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 CREATE SUB COLLECTION</b>");
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.selectCollectionSubCollectionTabs("subcollection");
			collection.clickOnCreateSubCollection();
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			collection.verifyAddNewCollectionHeader();

			subCollectionTitle = collection.addSubCollectionTitle();
			subCollectionInfo.add(subCollectionTitle);

			subCollectionDescription = collection.addSubCollectionDescription();
			subCollectionInfo.add(subCollectionDescription);

			collection.addSubCollectionImage();

			subCollectionPhysicalAddress = collection.addSubCollectionAddress(locationtype);
			subCollectionInfo.add(subCollectionPhysicalAddress);

			submitSubCollectionDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subCollectionInfo;
	}

	public String addPlantToSubCollection(String collectionName, String subCollectionName) {
		String plantName = "";
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.navigateToAddRemovePlantPage("plant");
			collection.verifyAddRemoveHeaderText();
			plantName = collection.addPlant(collectionName, subCollectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantName;
	}

	public void navigateToCollectionFromSubCollection(String collectionName) {
		Collections collection = new Collections(DriverSession.getLastExecutionDriver());
		collection.clickCollectionFromSubCollectionDetailPage(collectionName);
	}

	public void verifyPlantInCollection(String collectionName, String plantName) {
		try {
			navigateToCollectionFromSubCollection(collectionName);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			// collection.selectCollectionSubCollectionTabs("plant");
			collection.verifyPlantInCollection(plantName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPlantInSubCollection(String plantName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			// collection.selectCollectionSubCollectionTabs("plant");
			collection.verifyPlantInSubCollection(plantName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToSubCollectionTab(String subCollectionName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.selectCollectionSubCollectionTabs("subcol");
			collection.selectSubCollectionInsideSubcollectionTab(subCollectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlantFromSubCollection(String plantName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.navigateToAddRemovePlantPage("plant");
			collection.verifyAddRemoveHeaderText();
			collection.deletePlantFromSubCollection(plantName);
			collection.verifyPlantDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCollectionFromPlant(String collectionName) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			navigateToAddRemoveCollectionPage();
			plant.deleteCollectionFromPlant(collectionName);
			plant.verifyCollectionAfterDeleteFromPlant();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlantFromCollection(String plantName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.navigateToAddRemovePlantPage("plant");
			collection.verifyAddRemoveHeaderText();
			collection.deletePlantFromCollection(plantName);
			collection.verifyPlantDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitPlantDetailPage() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnNextButton();
			plant.clickOnSaveButton();
			plant.plantSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitPlantUpdatedInformation() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnSaveButton();
			plant.plantSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitCollectionDetailPage() {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickOnSaveButton();
			collection.collectionSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitSubCollectionDetailPage() {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickOnSaveButton();
			collection.subCollectionSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlantFromPlantDetailPage() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnDeleteButton();
			plant.plantDeletedSuccessfully();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlant() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - DELETE ADDED PLANT</b>");
			plant.clickOnEditButton();
			deletePlantFromPlantDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCollectionFromCollectionDetailPage() {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickOnDeleteButton();
			collection.collectionSuccessfullyDeleted();
			collection.collectionDeletedSuccessfully();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubCollectionFromSubCollectionDetailPage() {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickOnDeleteButton();
			collection.subCollectionSuccessfullyDeleted();
			collection.verifyAndSubmitSubCollectionDeletedSuccessfullyAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCollection() {
		Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
		Collections collection = new Collections(DriverSession.getLastExecutionDriver());
		collection.clickOnEditButton();
		deleteCollectionFromCollectionDetailPage();
	}

	public void backToSubCollection() {
		try {
			Thread.sleep(2000);
			Keywords.backPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubCollection() {
		try {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickOnEditButton();
			deleteSubCollectionFromSubCollectionDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String deleteEvent() {
		String eventName = "";
		try {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			eventName = org.getEventName();
			org.clickOnEventDelete();
			org.eventSuccessfullyDeleted();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventName;
	}

	public String deleteRecurringEvent(String applyOn) {
		String eventName = "";
		try {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			eventName = org.getEventName();
			org.clickOnEventDelete();
			org.recurringEventSuccessfullyDeleted(applyOn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventName;
	}

	public List<String> getPlantDetails() {
		List<String> plantDetail = new ArrayList<String>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantDetail.add(plant.getPlantTitle());
			plantDetail.add(plant.getPlantStory());
			plantDetail.add(plant.getPlantLocation());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantDetail;
	}

	public String addInvalidAddress() {
		String invalidAddress = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			invalidAddress = plant.addInvalidAddress();
		} catch (Exception e) {
		}

		return invalidAddress;
	}

	public void verifyPlantBlankLocation() {
		String txt = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			txt = plant.getPlantBlankLocation().trim();
			if (txt.equalsIgnoreCase(DriverSession.getTestCaseData().get("BlankLocationMessage"))) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Location is not added</b> visible successfully", "PASS",
							"<b>Location is not added</b> should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Location is not added</b> not visible successfully", "FALSE",
						"<b>Location is not added</b> should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Location is not added</b> text", "FAIL",
					"<b>Location is not added</b> should be visible");
		}
		verifyMapView();
	}

	public void verifyPlantPhysicalLocation(String location) {
		String txt = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			txt = plant.getPlantsPhysicalAddress();
			// Keywords.verifyTextOnPage(txt);
			if (txt.equalsIgnoreCase(location)) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plant Physical Address</b> visible successfully", "PASS",
							"<b>Plant Physical Address should be visible</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plant Physical Address is not visible successfully</b>", "FALSE",
						"<b>Plant Physical Address should be visible</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Plant physical address</b> text", "FAIL",
					"<b>Plant Physical Address should be visible</b>");
		}
		// verifyMapView();
	}

	public void verifyMapView() {
		boolean status = true;
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			status = plant.getMapViewVisibility();
			if (!status) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Map view</b> not visible successfully", "PASS", "<b>Map view</b> should not be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Map view</b> visible successfully", "FAIL", "<b>Map view</b> should not be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the visibility of <b>Map view</b>", "FAIL",
					"<b>Map view</b> should not be present");
		}
	}

	public void verifyPlantLikeCounts() {
		int count = 0;
		try {
			Keywords.waitForPage(driver);
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnLikeButton();
			count = plant.getLikeCount();
			if (count >= 1) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Like</b> count match successfully", "PASS", "<b>Like</b> count should be matched");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Like</b> count not match successfully", "FALSE", "<b>Like</b> count should be matched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Location is not added</b> text", "FAIL",
					"<b>Like</b> count should be matched");
		}
	}

	public void clickOnPlantEditBtn() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnEditButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getCollectionDetails() {
		List<String> collectionDetail = new ArrayList<String>();
		try {
			Thread.sleep(2000);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collectionDetail.add(collection.getCollectionTitle());
			collectionDetail.add(collection.getCollectionDescription());
			// collectionDetail.add(collection.getCollectionCreatorName());
			collectionDetail.add(collection.getCollectionPhysicallAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionDetail;
	}

	public List<String> getSubCollectionDetails() {
		List<String> subCollectionInfo = new ArrayList<String>();
		try {
			Thread.sleep(2000);
			Keywords.waitForPage(driver);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			subCollectionInfo.add(collection.getSubCollectionTitle());
			subCollectionInfo.add(collection.getSubCollectionDescription());
			// subCollectionInfo.add(collection.getSubCollectionCreatorName());
			subCollectionInfo.add(collection.getSubCollectionPhysicallAddress());
			subCollectionInfo.add(collection.getCollectionFromSubCollectionDetailPage());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subCollectionInfo;
	}

	public void clickOnCollectionFromSubCollectionPage(String collectionName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.clickCollectionFromSubCollectionDetailPage(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCollectionNameFromSubCollectionPage() {
		WebElement element;
		String collectionName = "";
		try {
			element = Locators.getInstance()
					.getCollectionNameFromSubCollectionDetailPage(DriverSession.getLastExecutionDriver());
			collectionName = Keywords.getText(element);
		} catch (Exception e) {

		}

		return collectionName;
	}

	public void selectPlantFromPlantList(String plantTitle) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.selectPlantFromPlantList(plantTitle);
			// Keywords.verifyTextMessage(plant.getPlantTitle(),
			// expectedplantTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectPlantFromPlantTab(String expectedplantTitle) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.selectPlantFromPlantTab(expectedplantTitle);
			Keywords.verifyTextMessage(plant.getPlantTitle(), expectedplantTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAddedPlant(String selectFrom, String plantTitle) {
		try {
			if (selectFrom.equalsIgnoreCase("mainpage")) {
				selectHeaderTab("Explore");
				selectPlantFromPlantList(plantTitle.toLowerCase());
			} else {
				selectHomeSubHeaderTab("plants");
				selectPlantFromPlantTab(plantTitle);
			}
			/*
			 * selectHomeSubHeaderTab("plants");
			 * selectPlantFromPlantTab(plantTitle);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectCollection(String collectionTitleName) {
		try {
			Thread.sleep(2000);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			collection.selectCollectionFromCollectionList(collectionTitleName);
			/*
			 * String actualCollectionTitleName =
			 * collection.getCollectionTitle();
			 * Keywords.verifyTextMessage(actualCollectionTitleName,
			 * collectionTitleName);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectFromData() {
		String randomSelectFromValue = "";
		List<String> list;
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			list = collection.selectionOfMainHeaderSubTab();
			randomSelectFromValue = list.get(Keywords.getRandomInteger(list.size()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomSelectFromValue;
	}

	public void selectCollectionFromCollectionTab(String collectionTitleName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.selectCollectionFromCollectionTab(collectionTitleName);
			Keywords.verifyTextMessage(collection.getCollectionTitle(), collectionTitleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAddedCollection(String selectFrom, String collectionTitleName) {
		selectFrom = selectFromData();
		try {
			if (selectFrom.equalsIgnoreCase("mainpage")) {
				selectHeaderTab("Explore");
				selectCollection(collectionTitleName);
			} else {
				selectHomeSubHeaderTab("collection");
				selectCollectionFromCollectionTab(collectionTitleName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubCollection(String subCollectionTitleName) {
		try {
			Thread.sleep(2000);
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			collection.selectSubCollectionFromCollectionList(subCollectionTitleName);
			/*
			 * String actualSubCollectionTitleName =
			 * collection.getSubCollectionTitle();
			 * Keywords.verifyTextMessage(actualSubCollectionTitleName,
			 * subCollectionTitleName);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubCollectionFromCollectionTab(String subCollectionTitleName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.selectCollectionFromCollectionTab(subCollectionTitleName);
			Keywords.verifyTextMessage(collection.getSubCollectionTitle(), subCollectionTitleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAddedSubCollection(String selectFrom, String subCollectionTitleName) {
		try {
			if (selectFrom.equalsIgnoreCase("mainpage")) {
				selectHeaderTab("Explore");
				selectSubCollection(subCollectionTitleName);
			} else {
				selectHomeSubHeaderTab("collection");
				selectSubCollectionFromCollectionTab(subCollectionTitleName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAndVerifyPlantDetail(String operationtype, String expectedplantTitle) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.selectPlantFromPlantList(expectedplantTitle);
			Thread.sleep(2000);
			plant.selectOperationOnEditViewLinkedText(operationtype);
			Keywords.verifyTextMessage(plant.getPlantTitle(), expectedplantTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPlantInfoOnPlantDetailPage(List<String> plantInfo) {
		List<String> plantDetails;
		try {
			plantDetails = getPlantDetails();
			for (int i = 0; i < plantDetails.size(); i++) {
				Keywords.verifyTextMessage(plantDetails.get(i), plantInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCollectionDetailOnCollectionDetailpage(List<String> collectionDetail) {
		List<String> collectionInfo;
		try {
			collectionInfo = getCollectionDetails();
			for (int i = 0; i < collectionInfo.size(); i++) {
				Keywords.verifyTextMessage(collectionInfo.get(i), collectionDetail.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubCollectionDetailOnSubCollectionDetailpage(List<String> subCollectionInfo) {
		List<String> subCollectionDetail;
		try {
			subCollectionDetail = getSubCollectionDetails();
			for (int i = 0; i < subCollectionDetail.size() - 1; i++) {
				Keywords.verifyTextMessage(subCollectionDetail.get(i), subCollectionInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEventDetailOnEventPage(List<String> eventInfo) {
		List<String> eventDetail;
		try {
			eventDetail = getEventDetails();
			for (int i = 0; i < eventDetail.size(); i++) {
				Keywords.verifyTextMessage(eventDetail.get(i), eventInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCurrentMonthValue(String currentMonthValue) {
		Organization org = new Organization(DriverSession.getLastExecutionDriver());
		try {
			if (org.getMonthValueFromEventPage().equalsIgnoreCase(currentMonthValue) && DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Event Current Month & Actual Date Month value match successfully</b>", "PASS",
						"<b>Event Current Month & Actual Date Month value should be same</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Event Current Month & Actual Date Month value not match successfully</b>", "FAIL",
						"<b>Event Current Month & Actual Date Month value should be same</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Event Current Month & Actual Date Month value</b>",
					"FAIL", "<b>Event Current Month & Actual Date Month value should be same</b>");
		}
	}

	public void verifyCurrentYearValue(String currentYearValue) {
		Organization org = new Organization(DriverSession.getLastExecutionDriver());
		try {
			// Keywords.verifyTextMessage(org.getYearValueFromEventPage(),
			// currentYearValue);
			if (org.getYearValueFromEventPage().equalsIgnoreCase(currentYearValue) && DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Event Current Year & Actual Date Year value match successfully</b>", "PASS",
						"<b>Event Current Year & Actual Date Year value should be same</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Event Current Year & Actual Date Year value not match successfully</b>", "FAIL",
						"<b>Event Current Year & Actual Date Year value should be same</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Event Current Year & Actual Date Year value</b>", "FAIL",
					"<b>Event Current Year & Actual Date Year value should be same</b>");
		}
	}

	public String moveToNextMonth() {
		String monthValue = "";
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			monthValue = org.clickOnMonthNextArrow();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return monthValue;
	}

	public void verifyEventListContainsCurrentMonth(String monthValue) {
		List<WebElement> list;
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			list = org.getEventMonthCount();
			for (int i = 0; i < list.size(); i++) {
				if (Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value </b>" + list.get(i).getText() + "<b> found successfully", "PASS",
							"<b>Month value should be found in Event List</b>");
				} else if (!Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value  </b>" + list.get(i).getText() + "<b> not found successfully", "FAIL",
							"<b>Month value should be found in Event List</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Month value from event list</b>", "FAIL",
					"<b>Month value should be found in Event List</b>");
		}
	}

	public void verifyEventContainsCurrentYear(String monthValue, String currentYear) {
		List<WebElement> list;
		String dateValue = "";
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			list = org.getEventList();
			if (list.size() > 0) {
				Keywords.click(list.get(Keywords.getRandomInteger(list.size())));
				Keywords.waitForPageFullyLoaded(driver);
				Thread.sleep(3000);
				dateValue = org.getDateValueFromDEventDetailPage().toLowerCase();
				if (dateValue.contains(monthValue.toLowerCase()) && dateValue.contains(currentYear))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Year value </b>" + currentYear + "<b> found successfully", "PASS",
							"<b>Year value should be found in Event List</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Year value  </b>" + currentYear + "<b> not found successfully", "FAIL",
							"<b>Year value should be found in Event List</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Year value from event list</b>", "FAIL",
					"<b>Year value should be found in Event List</b>");
		}
	}

	public void verifyEventListContainsMonth(String monthValue) {
		List<WebElement> list;
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			list = org.getEventMonthCount();
			for (int i = 0; i < list.size(); i++) {
				if (Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value </b>" + list.get(i).getText() + "<b> found successfully", "PASS",
							"<b>Month value should be found in Event List</b>");
				} else if (!Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value  </b>" + list.get(i).getText() + "<b> not found successfully", "FAIL",
							"<b>Month value should be found in Event List</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Month value from event list</b>", "FAIL",
					"<b>Month value should be found in Event List</b>");
		}
	}

	public void verifyEventListNotContainsMonth(String monthValue) {
		List<WebElement> list;
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			list = org.getEventList();
			for (int i = 0; i < list.size(); i++) {
				if (!Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value </b>" + list.get(i).getText() + "<b> not found successfully", "PASS",
							"<b>Month value should not be found in Event List</b>");
				} else if (Keywords.getText(list.get(i)).contains(monthValue)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month value  </b>" + list.get(i).getText() + "<b> found successfully", "FAIL",
							"<b>Month value should not be found in Event List</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the Month value from event list</b>", "FAIL",
					"<b>Month value should not be found in Event List</b>");
		}
	}

	public void verifyDisableEventPreviousMonth() {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.verifyPreviousArrowForOneLessToCurrentMonth();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDisableEventPreviousYear() {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.verifyPreviousArrowForOneLessToCurrentYear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEventListByDateCriteria() {
		String monthValue = "";
		try {
			selectExploreSubTabs("Events");
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			monthValue = Keywords.getCurrentMonthValue();
			verifyCurrentMonthValue(monthValue);
			verifyDisableEventPreviousMonth();
			verifyEventListContainsCurrentMonth(monthValue);
			monthValue = org.clickOnMonthNextArrow();
			org.selectPaging();
			verifyEventListContainsMonth(monthValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEventListByYearCriteria() {
		String yearValue = "";
		String monthValue = "";
		String previousMonthValue = "";
		try {
			selectExploreSubTabs("Events");
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			yearValue = Keywords.getCurrentYearValue();
			verifyCurrentYearValue(yearValue);
			verifyDisableEventPreviousYear();
			previousMonthValue = org.getMonthFullValueFromEventPage();
			verifyEventContainsCurrentYear(monthValue, yearValue);
			selectExploreSubTabs("Events");
			yearValue = org.clickOnYearNextArrow();
			org.selectPaging();
			monthValue = org.clickOnMonthNextArrow();
			System.out.println("monthValue..."+monthValue);
			verifyEventListNotContainsMonth(previousMonthValue);
			verifyEventContainsCurrentYear(monthValue, yearValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String navigateToCollectionFromSubCollectionDetailPage() {
		WebElement element;
		String collectionName = "";
		try {
			element = Locators.getInstance()
					.getCollectionNameFromSubCollectionDetailPage(DriverSession.getLastExecutionDriver());
			Keywords.click(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionName;
	}

	public void verifyCollectionNameOnSubCollectionAsWellAsOnCollectionPage(String expectedCollectionName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			String actualCollectionName = collection.getCollectionTitle();
			Keywords.verifyTextMessage(actualCollectionName, expectedCollectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. Sharing related method.

	public void verifySharingLink() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b> Testcase 1 started </b>", "INFO",
					"<b>Testcase 1 Verify Sharing Link</b>");
			Sharing sharing = new Sharing(DriverSession.getLastExecutionDriver());
			sharing.verifySharingOptionUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSharingOption(String sharingOption, String shareFrom) {
		try {
			Sharing sharing = new Sharing(DriverSession.getLastExecutionDriver());
			sharing.selectSharingOption(sharingOption, shareFrom);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean facebookLoginStatus() {
		boolean status = false;
		try {
			Sharing sharing = new Sharing(DriverSession.getLastExecutionDriver());
			status = sharing.getFacebookLoginStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public void fbLogin() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 LOGIN INTO FACEBOOK</b>");
			Sharing sharing = new Sharing(DriverSession.getLastExecutionDriver());
			selectSharingOption("Facebook", "header");
			if (!facebookLoginStatus()) {
				sharing.handleFacebookAlertMessageForSignInAndSignUp();
				sharing.enterFacebookUser();
				sharing.enterFacebookPassword();
				sharing.submitFacebook();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickForgotPasswordLinkEnterEmailAndSubmit() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.clickForgotPasswordLink();
			login.verifyForgotPasswordHeader();
			login.enterForgotPasswordEmailId();
			login.submitForgotPasswordPopUp();
			login.submitPasswordResetEmailAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openMailAndSelectChangePasswordLink() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.openResetPasswordMail();
			login.visibleChangePasswordLink();
			login.selectChangePasswordLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openMailAndVerifyPlaceOrderSubTotal(float expectedPrice) {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.emailSignIn(DriverSession.getTestCaseData().get("GmailUrl"),
					DriverSession.getTestCaseData().get("Username"),
					DriverSession.getTestCaseData().get("EmailPassword"));
			login.openResetPasswordMail();
			login.verifyPlaceOrderAndReceivedMailPrice(expectedPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterNewAndConfirmPasswordAndSubmit() {
		String updatedPassword = "";
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			updatedPassword = login.enterNewPassword(DriverSession.getTestCaseData().get("Password"));
			login.enterConfirmPassword(DriverSession.getTestCaseData().get("Password"));
			login.clickOnResetButton();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updatedPassword;
	}

	public void verifyAndSubmitResetPasswordMessage() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.verifyPasswordResetMessage();
			login.submitResetPasswordPopUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWindow() {
		try {
			Keywords.closeWindow(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {

		}
	}

	public void switchToWindow(int handleNumber) {
		try {
			Thread.sleep(3000);
			Keywords.switchToWindowHandle(DriverSession.getLastExecutionDriver(), handleNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// forgot password related
	public void verifyForgotPassword() {
		LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
		try {
			login.clickOnSignInLink();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 CHANGE PASSWORD</b>");
			clickForgotPasswordLinkEnterEmailAndSubmit();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 LOGIN INTO GMAIL</b>");
			login.openNewTabAndSingInGmail(DriverSession.getTestCaseData().get("GmailUrl"),
					DriverSession.getTestCaseData().get("Username"),
					DriverSession.getTestCaseData().get("EmailPassword"));
			openMailAndSelectChangePasswordLink();
			login.verifyResetPasswordHeader();
			enterNewAndConfirmPasswordAndSubmit();
			verifyAndSubmitResetPasswordMessage();
			closeWindow();
			switchToWindow(Keywords.getWindowHandles(DriverSession.getLastExecutionDriver()).size() - 1);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 SING IN AFTER RESET PASSWORD</b>");
			loginAsNormalUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitOrganizationDetailPage() {
		try {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver());
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.clickOnSaveButton();
			org.organizationSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitEventDetailPage() {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.clickOnEventSaveButton();
			org.eventSuccessfullyAdded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddedOrg(String orgName) {
		Organization org = new Organization(DriverSession.getLastExecutionDriver());
		try {
			org.verifyAddedOrganization(orgName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> createNewOrganization(String makeLocation) {
		List<String> orgDetails = new ArrayList<String>();
		Organization org = new Organization(DriverSession.getLastExecutionDriver());
		String orgName = "";
		String orgDescription = "";
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 CREATE NEW ORGANIZATION</b>");
			org.clickOnAddNewOrganization();
			org.verifyOrganizationEditHeaderTxt();
			orgName = org.addOrganizationTitle();
			orgDetails.add(orgName);

			orgDescription = org.addOrganizationDescription();
			orgDetails.add(orgDescription);

			org.addAddress(makeLocation);

			org.addOrgainzationProfileImage();
			org.addOrgainzationCoverImage();

			org.verifyImageDimensionFormatForCoverPhoto();
			org.verifyImageDimensionFormatForProfile();

			submitOrganizationDetailPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orgDetails;
	}

	public void selectOrg(String expOrgTitleName, boolean status) {
		String orgTitleName = "";
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 5);
			if (status) {
				org.selectOrganizationFromProfile(expOrgTitleName);
			} else {
				selectHeaderTab("Explore");
				org.selectOrgFromCommunityList(expOrgTitleName);
			}
			orgTitleName = org.getAddedOrgName();
			Keywords.verifyTextMessage(orgTitleName, expOrgTitleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String activeReceivedRequestForNetwork(String titleRequestForNw) {
		String titleName = "";
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.clickOnManageNetwork();
			titleName = org.requestFromUser(titleRequestForNw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return titleName;
	}

	public void verifyOrganizationConnectToTheNetwork(String organizationName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHomeSubHeaderTab("networks");
			home.verifyOrganizationConnectToTheNetwork(organizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String deleteOrg() {
		String orgName = "";
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			orgName = org.getAddedOrgName();
			org.clickOnEditBtn();
			org.verifyOrganizationEditHeaderTxt();
			org.clickOnDeleteOrg();
			org.submitDeleteOrganizationPopUp();
			org.verifyDeleteOrganizationClickSuccessfully();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orgName;
	}

	public String switchToProfile() {
		String profileName = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			profile.selectMyProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profileName;
	}

	public void verifyOrgNameAfterDeletion(String orgName) {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.verifyOrgAfterDelete(orgName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginAsNormalUser() {
		try {
			Keywords.navigateTo(DriverSession.getTestCaseData().get("URL"));
			login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginAsNormalUser(String userMail, String password) {
		try {
			Keywords.navigateTo(DriverSession.getTestCaseData().get("BaseUrl"));
			login(userMail, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginAsAdminUser() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			admin.navigateToAdminSite(DriverSession.getTestCaseData().get("AdminUrl"));
			loginAsAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToDeleteOrgInAdmin() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			admin.selectAdminHeaderTab("manage users");
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			user.selectSubTabUnderManageUser("deleted organization");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToOrgInAdmin() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			admin.selectAdminHeaderTab("manage users");
			user.selectSubTabUnderManageUser("organizations");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchResultForAdmin(String searchTitle) {
		try {
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			user.searchForAdmin(searchTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteResultFromAdmin(String deleteText) {
		try {
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			user.deleteOrgFromAdmin(deleteText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAndDeleteItemFromAdmin(String searchTitle) {
		try {
			searchResultForAdmin(searchTitle);
			deleteResultFromAdmin(searchTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchEvent(String searchType, String eventName) {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.searchEvent(searchType, eventName);
			org.selectEventFromEventSearchList(eventName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchEventForReccurring(String searchType, String eventName, int occurrence) {
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			org.searchEvent(searchType, eventName);
			org.verifyReccuringEventCount(occurrence);
			org.selectEventFromEventSearchList(eventName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEventDeleteSuccessfully(String eventName) {
		String searchType = "Title";
		try {
			searchEvent(searchType, eventName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRecurringEventDeleteSuccessfully(String recurringEventName, int recurringEventOccurence) {
		String searchType = "Title";
		try {
			searchEventForReccurring(searchType, recurringEventName, recurringEventOccurence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getEventDetails() {
		List<String> eventDetail = new ArrayList<String>();
		try {
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			eventDetail.add(org.getEventName());
			eventDetail.add(org.getEventTime());
			eventDetail.add(org.getEventPrice());
			// eventDetail.add(org.getEventCategory());
			eventDetail.add(org.getEventAddress());
			eventDetail.add(org.getEventCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventDetail;
	}

	public void submitProfile() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			profile.clickOnMyProfileSaveButton();
			profile.myProfileSuccessfullyUpdated();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLastNameAndSubmitprofile() {
		boolean flag = false;
		WebElement element;
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileSaveBtn(driver);
			Keywords.click(element);
			flag = profile.profileLastNameStatus();
			if (flag) {
				profile.enterLastName();
				element = Locators.getInstance().myProfileSaveBtn(driver);
				Keywords.click(element);
			}
			Keywords.waitForPage(driver);
			element = Locators.getInstance().windowPopUpForAddPlantOrgOnProfileSubmit(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.waitForPageFullyLoaded(driver);
				profile.clickOnContinueToMyProfilePageLink();
				// Keywords.backPage();
				Keywords.waitForPageFullyLoaded(driver);
			}
			switchToProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getProfilePercentage() {
		int profilePercentage = 0;
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			switchToProfile();
			profilePercentage = profile.getProfileGrowth();
			// System.out.println("Profile Percentage..." + profilePercentage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profilePercentage;
	}

	public void updateAboutMe() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 Enter About Me</b>");
			profile.clickOnEditButton();
			profile.enterAboutMe();
			submitProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAboutMe() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 Delete About Me</b>");
			profile.clickOnEditButton();
			profile.clearAboutMe();
			submitProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProfileCoverPhoto() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 Add Cover Photo</b>");
			profile.clickOnEditButton();
			profile.addProfileCover();
			submitProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProfileCoverPhoto() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			profile.clickOnEditButton();
			profile.removeProfileCover();
			submitProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String followUsersProfiles() {
		String followProfileName = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 Follow User Profile</b>");
			profile.navigateToCommunities();
			followProfileName = profile.followProfile().get(0);
			switchToProfile();
		} catch (Exception e) {

		}

		return followProfileName;
	}

	public void unFollowUserProfile(String profileName) {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 Unfollow User Profile</b>");
			profile.navigateToCommunities();
			profile.unFollowProfile(profileName);
			switchToProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addPlant() {
		String plantName = "";
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 Add Plants</b>");
			DriverSession.setReporting(false);
			for (int i = 0; i <= 3; i++) {
				selectHeaderTab("Explore");
				plantName = createNewPlant("public").get(0);
			}
			DriverSession.setReporting(true);
			switchToProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantName;
	}

	public void selectHomeSubHeaderTab(String subHeaderName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHomeSubHeaderTab(subHeaderName);// ("plants");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<WebElement> getPlantsListUnderPlantTab() {
		List<WebElement> list = null;
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			list = plants.getPlantsListUnderPlantTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<WebElement> getPlantsListUnderMyPlantsMapMyPlantTab() {
		List<WebElement> list = null;
		try {
			selectHeaderSubTabs("My Plants");
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			list = plants.getPlantsListUnderMyPlantsMapTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<WebElement> getCollectionListUnderMyPlantsMapMyCollectionTab() {
		List<WebElement> list = null;
		try {
			selectHeaderSubTabs("My Plants");
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			list = plants.getCollectionListUnderMyPlantsMapMyCollectionTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String selectRandomPlantsUnderPlantTab() {
		List<WebElement> list = null;
		String plantTitle = "";
		int randomNumber = 0;
		try {
			selectHomeSubHeaderTab("plants");
			list = getPlantsListUnderPlantTab();
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			plantTitle = Keywords.getText(list.get(randomNumber));
			System.out.println("Plant title...."+plantTitle);
			Keywords.clickByIndex(list, randomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantTitle;
	}
	
	public String selectRandomPlantsUnderPlantTabUsingPagination() {
		List<WebElement> list = null;
		String plantTitle = "";
		int randomNumber = 0;
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			selectExploreSubTabs("Plants");
			plants.selectRandomIndex();
			list = getPlantsListUnderPlantTab();
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			plantTitle = Keywords.getText(list.get(randomNumber));
			Keywords.clickByIndex(list, randomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantTitle;
	}

	public String selectRandomPlantsUnderMyPlantsMapTab() {
		List<WebElement> list = null;
		String plantTitle = "";
		int randomNumber = 0;
		try {
			selectHeaderTab("My Plants Map");
			list = getPlantsListUnderMyPlantsMapMyPlantTab();
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			plantTitle = Keywords.getText(list.get(randomNumber));
			Keywords.clickByIndex(list, randomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantTitle;
	}

	public String selectRandomPlantsUnderMyPlantsMapTabForPlantCreation(String sortTypeOption) {
		List<WebElement> list = null;
		String plantTitle = "";
		int randomNumber = 0;
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			selectHeaderTab("My Plants Map");
			plant.sortPlantBy(sortTypeOption);
			list = getPlantsListUnderMyPlantsMapMyPlantTab();
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			plantTitle = Keywords.getText(list.get(randomNumber));
			Keywords.clickByIndex(list, randomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantTitle;
	}

	public String selectRandomCollectionUnderMyPlantsMapTab() {
		List<WebElement> list = null;
		String collectionTitle = "";
		int randomNumber = 0;
		try {
			selectHeaderTab("My Plants Map");
			list = getCollectionListUnderMyPlantsMapMyCollectionTab();
			randomNumber = Keywords.getRandomInteger(list.size() - 1);
			collectionTitle = Keywords.getText(list.get(randomNumber));
			Keywords.clickByIndex(list, randomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectionTitle;
	}

	public void verifyAddedTabManagerFieldOnPlantsPage(String tabName, List<String> addedTabFieldsList) {
		List<String> tabFieldsNameList;
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			plants.clickOnEditButton();
			plants.selectAddedTabName(tabName);
			plants.navigateToTabManagerOnPlantsPage(tabName);
			tabFieldsNameList = plants.getAddedTabNameList();
			for (int i = 0; i < tabFieldsNameList.size(); i++) {
				Keywords.verifyTextMessage(tabFieldsNameList.get(i), addedTabFieldsList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProfilePlant(String plantTitleName, String subHeaderTab) {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
					"<b>TESTCASE 7 Delete Plants</b>");
			selectHomeSubHeaderTab(subHeaderTab);
			selectPlantFromPlantTab(plantTitleName);
			DriverSession.setReporting(false);
			deletePlant();
			DriverSession.setReporting(true);
			switchToProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkProfilePercentageAfterUpdate() {
		int actualPercentage = 0;
		int updatedPercentage = 0;
		int beforeUpdation = 0;
		String followProfileName = "";
		String plantsTitleName = "";
		List<String> list;
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			list = profile.getProfileUpdationList();
			for (String str : list) {
				beforeUpdation = profile.getProfileGrowth();
				actualPercentage = profile.getProfilePercentage(str);
				if (str.equalsIgnoreCase("signup")) {
				} else if (str.equalsIgnoreCase("aboutme"))
					updateAboutMe();
				else if (str.equalsIgnoreCase("clearaboutme"))
					deleteAboutMe();
				else if (str.equalsIgnoreCase("coverphoto"))
					addProfileCoverPhoto();
				else if (str.equalsIgnoreCase("removecoverphoto"))
					deleteProfileCoverPhoto();
				else if (str.equalsIgnoreCase("follow"))
					followProfileName = followUsersProfiles();
				else if (str.equalsIgnoreCase("unfollow"))
					unFollowUserProfile(followProfileName);
				else if (str.equalsIgnoreCase("addplants"))
					plantsTitleName = addPlant();
				else if (str.equalsIgnoreCase("deleteplants"))
					deleteProfilePlant(plantsTitleName, "plants");
				updatedPercentage = profile.getProfileGrowth();
				if (updatedPercentage == (beforeUpdation + actualPercentage))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							str + " profile percentage updated successfully", "PASS",
							"Profile Percentage should be updated");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							str + " profile percentage not updated successfully", "FAIL",
							"Profile Percentage should be updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantToTagList1() {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			home.navigateToHomePlant();
			plant.addPlantToTagList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantToTagList() {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab("My Plants Map");
			home.selectHeaderSubTab("My Plants");
			// home.navigateToHomePlant();
			plant.addPlantToTagList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantToTagListForOrderChecking() {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab("My Plants Map");
			home.selectHeaderSubTab("My Plants");
			plant.addPlantToTagListForOrderChecking();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToCart() {
		try {
			CartPage cart = new CartPage(DriverSession.getLastExecutionDriver());
			cart.navigateToCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeAllPlantsFromCart() {
		try {
			CartPage cart = new CartPage(DriverSession.getLastExecutionDriver());
			cart.removePlantsFromCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String removePlantsFromCart(int index) {
		String plantTitle = "";
		try {
			CartPage cart = new CartPage(DriverSession.getLastExecutionDriver());
			plantTitle = cart.removePlantFromCart(index);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitle;
	}

	public void navigateToAddPlantPageView() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.clickOnAddButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantsFromTagViewWithPlantTitle(String plantTitleName) {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.searchType("plant title");
			tag.selectTagStatus("all");
			tag.searchPlantWithTitle(plantTitleName);
			tag.clickOnFindButton();
			tag.addPlantFromSearchResult();
			tag.submitTagPopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantsFromTagView() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.searchType("plant title");
			tag.selectTagStatus("all");
			tag.clickOnFindButton();
			tag.addPlantFromSearchResult();
			tag.submitTagPopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantsFromTagViewForOrdering() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.searchType("plant title");
			tag.selectTagStatus("all");
			tag.clickOnFindButton();
			tag.addPlantFromTagSearchResult();
			tag.submitTagPopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hideTagPopupView() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.hideTagPopupWindowView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlantsFromTagViewWithCollection() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.searchType("collection name");
			tag.selectTagStatus("all");
			tag.selectCollectionTitleFromCollectionList();
			tag.addPlantFromSearchResult();
			tag.submitTagPopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addType() {
		List<String> list = new ArrayList<>();
		list.add("planttitle");
		list.add("plantBysearchName");
		list.add("collectionname");

		return list.get(Keywords.getRandomInteger(3));
	}

	public String addPlantFromTagPopup(String addType) {
		String plantTitleName = "";
		try {
			if (addType.equalsIgnoreCase("planttitle"))
				addPlantsFromTagView();
			else if (addType.equalsIgnoreCase("plantBysearchName")) {
				hideTagPopupView();
				plantTitleName = getRandomPlantTitle();
				navigateToCart();
				navigateToAddPlantPageView();
				addPlantsFromTagViewWithPlantTitle(plantTitleName);
			} else if (addType.equalsIgnoreCase("collectionname"))
				addPlantsFromTagViewWithCollection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitleName;
	}

	public String addPlantFromTagPopupForOrderingVerify(String addType) {
		String plantTitleName = "";
		try {
			if (addType.equalsIgnoreCase("planttitle"))
				addPlantsFromTagViewForOrdering();
			else if (addType.equalsIgnoreCase("plantBysearchName")) {
				hideTagPopupView();
				plantTitleName = getRandomPlantTitle();
				navigateToCart();
				navigateToAddPlantPageView();
				addPlantsFromTagViewWithPlantTitle(plantTitleName);
			} else if (addType.equalsIgnoreCase("collectionname"))
				addPlantsFromTagViewWithCollection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitleName;
	}

	public String getRandomPlantTitle() {
		String plantTitleName = "";
		List<WebElement> elementList;
		try {
			selectHeaderTab("My Plants Map");
			Keywords.waitForPage(driver);
			elementList = Locators.getInstance().getPlantsTitleListForTag(driver);
			plantTitleName = Keywords.getText(elementList.get(elementList.size() - 1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitleName;
	}

	public List<Object> updatePlantQuantityAndSign() {
		List<Object> list = null;
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			list = tags.getPlantsTitleQuantityAndSign();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/*
	 * public HashMap<String, Integer> getPlantsUpdatedQuantity() {
	 * HashMap<String, Integer> quantityList = null; try { Tags tags = new
	 * Tags(DriverSession.getLastExecutionDriver()); quantityList =
	 * tags.updatePlantQuantity(); } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * return quantityList; }
	 */

	public void verifyPlantQuantityWithInvalidSize() {
		String tagSignType = "";
		List<String> plantTitle;
		HashMap<String, Integer> plantsTitleWithQuantity;
		Tags tags = new Tags(DriverSession.getLastExecutionDriver());
		try {
			plantTitle = tags.getPlantsTitleFromTagsPage();
			plantsTitleWithQuantity = tags.updatePlantQuantity("invalid");
			for (int i = 0; i < plantTitle.size(); i++) {
				plantsTitleWithQuantity.get(plantTitle.get(i));
				tags.getPlantsTagPrice(WordUtils.capitalize(tagSignType));
			}
			submitPlantQuantityAndSignPage();
			tags.verifyPlantInavlidQuantityAlertMessage();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getPlantTitleListFromTagsPage() {
		List<String> plantTitleList = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			plantTitleList = tags.getPlantsTitleFromTagsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantTitleList;
	}

	public void updatePlantsTagsAndSign() {
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			tags.selectTaggedPlantSign();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getPlantQuantityList() {
		List<String> plantQuantityList = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			plantQuantityList = tags.getPlantQuantityList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantQuantityList;
	}

	public List<String> getTagList() {
		List<String> tagList = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			tagList = tags.getPlantsTagList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
	}

	public List<String> getTemplateList() {
		List<String> templateList = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			templateList = tags.getPlantsTagTemplateList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return templateList;
	}

	public List<String> getPlantsLineDataList(int indexing) {
		List<String> lineDataList = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			lineDataList = tags.getPlantsLinesDataList(indexing);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lineDataList;
	}

	public List<String> updatePlantTitle(List<String> plantName) {
		List<String> plantUpdatedName = new ArrayList<>();
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			// plantUpdatedName.add(tags.updatePlantTitle(plantName));
			plantUpdatedName = tags.updatePlantTitle(plantName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantUpdatedName;
	}

	public float verifyPlantsTagWithPrice() {
		String tagSignType = "";
		float tagsTotalCost = 0.00f;
		int plantsQuantity = 0;
		float plantsTagPrice = 0.00f;
		List<String> plantTitle;
		HashMap<String, Integer> plantsTitleWithQuantity;
		HashMap<String, String> plantTitleWithTag;
		Tags tags = new Tags(DriverSession.getLastExecutionDriver());
		try {
			plantTitle = tags.getPlantsTitleFromTagsPage();
			plantsTitleWithQuantity = tags.updatePlantQuantity("valid");
			plantTitleWithTag = tags.selectTaggedPlantSign();
			for (int i = 0; i < plantTitle.size(); i++) {
				plantsQuantity = plantsTitleWithQuantity.get(plantTitle.get(i));
				tagSignType = plantTitleWithTag.get(plantTitle.get(i)).toLowerCase();
				plantsTagPrice = tags.getPlantsTagPrice(WordUtils.capitalize(tagSignType));
				tagsTotalCost = tagsTotalCost + (plantsQuantity * plantsTagPrice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagsTotalCost;
	}

	public void submitPlantQuantityAndSignPage() {
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			tags.submitPlantQuantityAndSignPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveChangesOnTagsPage() {
		try {
			Tags tags = new Tags(DriverSession.getLastExecutionDriver());
			tags.saveChangesOnTagsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserInfoForBilling() {
		try {
			ShippingAddressInfo info = new ShippingAddressInfo(DriverSession.getLastExecutionDriver());
			info.enterUserName();
			info.enterStreet();
			info.enterCity();
			info.enterState();
			info.enterZipCode();
			info.shippingAddressAsBillingAddress();
			info.enterEmailAddress();
			info.enterPhoneNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public float selectCustomLogo() {
		float customlogoValue = 0;
		try {
			ShippingAddressInfo info = new ShippingAddressInfo(DriverSession.getLastExecutionDriver());
			customlogoValue = info.selectCustomLogoType();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customlogoValue;
	}

	public float verifyAdditionalTagWithPrice() {
		List<String> taglist;
		float price = 0.00f;
		try {
			ShippingAddressInfo info = new ShippingAddressInfo(DriverSession.getLastExecutionDriver());
			taglist = info.getAdditionalTagList();
			price = price + info.verifyBlackAluminumStakePrice(taglist.get(0));
			price = price + info.verifyStakePrice(taglist.get(1));
			price = price + info.verifyTreeHardwarePrice(taglist.get(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;
	}

	public float VerifyPlantsPriceOnTagsAndBillingPage(float expectedPrice) {
		float actualPlantstagPrice = 0.00f;
		try {
			ShippingAddressInfo info = new ShippingAddressInfo(DriverSession.getLastExecutionDriver());
			actualPlantstagPrice = info.getPlantQuantityAndSignTotalCost();
			if (actualPlantstagPrice == expectedPrice)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Actual & Expected price same",
						"PASS", "Price should be same on Tags and billing page.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Actual & Expected price not match",
						"FAIL", "Price should be same on Tags and billing page.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Plant Tag Actual Price.."+actualPrice);
		return actualPlantstagPrice;
	}

	public void submitUserBillingPage() {
		try {
			ShippingAddressInfo info = new ShippingAddressInfo(DriverSession.getLastExecutionDriver());
			info.submitUserBillingPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubTotalOnPlaceOrderPage(float expectedTotalPrice) {
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			order.verifySubTotal(expectedTotalPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public float shippingCharges() {
		float shippingcharge = 0.00f;
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			shippingcharge = order.getShippingCharges();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shippingcharge;
	}

	public float customLogoPrice(/* String logoType */) {
		float customlogoPrice = 0.00f;
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			customlogoPrice = order.getCustomLogoCharges(/* logoType */);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customlogoPrice;
	}

	public void verifyDiscountPercentage(float totalAmount) {
		int dicountPercentage = 0;
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			dicountPercentage = order.getDiscountPercentage();
			if (totalAmount > 399 && totalAmount <= 1199) {
				if (dicountPercentage == 10) {
				}
			} else {
				dicountPercentage = 15;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public float getDiscount() {
		float discount = 0.00f;
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			discount = order.getDiscountAmount();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return discount;
	}

	public void placeOrder() {
		try {
			PlaceOrder order = new PlaceOrder(DriverSession.getLastExecutionDriver());
			order.clickOnPlaceOrderBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Admin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public void navigateToManageUser() {
		try {
			Admin admin = new Admin(DriverSession.getLastExecutionDriver());
			admin.selectAdminHeaderTab("Manage Users");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToSubTabs(String subTabName) {
		try {
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			user.selectSubTabUnderManageUser(subTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToManageUserSubTab(String subTabName) {
		try {
			navigateToManageUser();
			navigateToSubTabs(subTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddThingsPage() {
		// this may add user,plant,collection, organization,event, tab manager
		// and other things.
		try {
			AdminUser user = new AdminUser(DriverSession.getLastExecutionDriver());
			user.clickOnAddUserPlantCollectionOrgEvent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> fillUserInfo() {
		List<String> userInfo = new ArrayList<>();
		try {
			AdminUser user = new AdminUser(DriverSession.getLastExecutionDriver());
			userInfo.add(user.enterDisplanyName());
			userInfo.add(user.enterFirstName());
			userInfo.add(user.enterLastName());
			userInfo.add(user.enterEmailId());
			userInfo.add(user.enterPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

	public void submitAdminPage() {
		try {
			AdminUser user = new AdminUser(DriverSession.getLastExecutionDriver());
			user.submitUserInfoPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForLoaderInvisible() {
		try {
			AdminUser user = new AdminUser(DriverSession.getLastExecutionDriver());
			user.waitForLoaderInvisible();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> userCreateFromAdmin() {
		List<String> userInfo = null;
		try {
			DriverSession.setReporting(false);
			loginAsAdmin();
			DriverSession.setReporting(true);
			navigateToManageUserSubTab("users");
			navigateToAddThingsPage();
			userInfo = fillUserInfo();
			submitAdminPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

	public List<Integer> getUserInfoFromAdmin(String userName) {
		List<Integer> obj = new ArrayList<>();
		try {
			AdminUser admin = new AdminUser(DriverSession.getLastExecutionDriver());
			navigateToManageUserSubTab("users");
			searchUser(userName);
			obj.add(admin.getUserProfilePlantCount());
			obj.add(admin.getUserNetworkCount());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	public List<Integer> getOrgInfoFromAdmin(String orgName) {
		// List<Object> obj = new ArrayList<>();
		// Map<String, Integer> info = null;
		List<Integer> list = new ArrayList<>();
		try {
			AdminUser admin = new AdminUser(DriverSession.getLastExecutionDriver());
			/*
			 * DriverSession.setReporting(false); loginAsAdmin();
			 * DriverSession.setReporting(true);
			 */
			navigateToManageUserSubTab("organizations");
			searchUser(orgName);
			/*
			 * info.put("plant", admin.getOrganizationPlantCount());
			 * info.put("collection", admin.getOrganizationCollectionCount());
			 */
			list.add(admin.getOrganizationPlantCount());
			list.add(admin.getOrganizationCollectionCount());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Integer> getUserInfoFromWebsite() {
		List<Integer> list = new ArrayList<>();
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			list.add(profile.getUserPlantCount());
			list.add(profile.getUserNetworkCount());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Integer> getOrgInfoFromWebsite() {
		List<Integer> list = new ArrayList<>();
		try {
			selectOrg(DriverSession.getTestCaseData().get("Org_Name"), true);
			Organization org = new Organization(DriverSession.getLastExecutionDriver());
			list.add(org.getOrgPlantCount());
			list.add(org.getOrgCollectionCount());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void verifyUserPlantAndNetworkCount(List<Integer> admin, List<Integer> website) {
		try {
			for (int i = 0; i < admin.size(); i++) {
				if (admin.get(i) == website.get(i)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>User Plant/Network Count match successfully</b>", "PASS",
							"<b>User Plant/Network count should be match</b>");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the actual & expected User Plant/Network Count</b>", "FAIL",
					"<b>User Plant/Network count should be match</b>");
		}
	}

	public void verifyOrgPlantAndCollectionCount(List<Integer> admin, List<Integer> website) {
		try {
			for (int i = 0; i < admin.size(); i++) {
				if (admin.get(i) == website.get(i)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Organization Plant/Collection Count match successfully</b>", "PASS",
							"<b>Organization Plant/Collection count should be match</b>");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the actual & expected Organization Plant/Collection Count</b>",
					"FAIL", "<b>Organization Plant/Collection count should be match</b>");
		}
	}

	public void deleteUserFromAdmin(String userName) {
		try {
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			navigateToManageUserSubTab("users");
			searchUser(userName);
			user.deleteOrgFromAdmin(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAdminAddPlantPage() {
		try {
			navigateToManageUserSubTab("plants");
			navigateToAddThingsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> ownerType() {
		ArrayList<String> list = new ArrayList<>();
		try {
			list.add("user");
			list.add("organization");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public String selectPlantOwnerType(String ownerType) {
		String ownertype = "";
		try {
			AdminPlant plant = new AdminPlant(DriverSession.getLastExecutionDriver());
			ownertype = plant.selectOwnerType(ownerType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ownertype;
	}

	public List<String> createPlantFromAdmin(String locationType, String ownertype) {
		List<String> plantInfo = new ArrayList<>();
		String ownerType = ownertype;// "";
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Add Plants FROM ADMIN</b>");
			DriverSession.setReporting(false);
			loginAsAdmin();
			DriverSession.setReporting(true);
			AdminPlant plant = new AdminPlant(DriverSession.getLastExecutionDriver());
			navigateToAdminAddPlantPage();
			ownerType = selectPlantOwnerType(ownerType);// ("user");
			plant.enterOwnerIdOrSlug(ownertype);
			plantInfo.add(plant.addPlantTitle());
			plant.addPlantImage();
			plantInfo.add(plant.addPlantStory());
			plantInfo.add(plant.addAddress(locationType));
			plantInfo.add(ownerType);
			submitAdminPage();
			waitForLoaderInvisible();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantInfo;
	}

	public List<String> getPlantInfoFromAdminPlantPage() {
		List<String> plantInfo = null;
		AdminPlant plant = new AdminPlant(DriverSession.getLastExecutionDriver());
		try {
			plantInfo = plant.getCreatePlantInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantInfo;
	}

	public void verifyPlantInfoOnAdminPlantPage(List<String> plantInfo) {
		List<String> plantDetails;
		try {
			plantDetails = getPlantInfoFromAdminPlantPage();
			for (int i = 0; i < plantDetails.size(); i++) {
				Keywords.verifyTextMessage(plantDetails.get(i), plantInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectCollectionOwnerType(String ownerType) {
		String ownertype = "";
		try {
			AdminCollection collection = new AdminCollection(DriverSession.getLastExecutionDriver());
			ownertype = collection.selectOwnerType(ownerType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ownertype;
	}

	public void navigateToAddCollectionPage() {
		try {
			navigateToManageUserSubTab("collections");
			navigateToAddThingsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for admin collection
	public List<String> createCollectionFromAdmin(String locationType, String ownertype) {
		List<String> collectionInfo = new ArrayList<>();
		String ownerType = ownertype;
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Add COLLECTION FROM ADMIN</b>");
			DriverSession.setReporting(false);
			loginAsAdmin();
			DriverSession.setReporting(true);
			navigateToAddCollectionPage();
			AdminCollection collection = new AdminCollection(DriverSession.getLastExecutionDriver());
			selectCollectionOwnerType(ownerType);
			collection.enterOwnerIdOrSlug(ownerType);
			collectionInfo.add(collection.addCollectionTitle());
			collection.addCollectionImage();
			collectionInfo.add(collection.addCollectionStory());
			collectionInfo.add(collection.addAddress(locationType));
			collectionInfo.add(ownerType);
			submitAdminPage();
			waitForLoaderInvisible();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionInfo;
	}

	public List<String> getCollectionInfoFromAdminCollectionPage() {
		List<String> collectionInfo = null;
		AdminCollection collection = new AdminCollection(DriverSession.getLastExecutionDriver());
		try {
			collectionInfo = collection.getCreateCollectionInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectionInfo;
	}

	public void verifyCollectionInfoOnAdminCollectionPage(List<String> plantInfo) {
		List<String> collectionDetails;
		try {
			collectionDetails = getCollectionInfoFromAdminCollectionPage();
			for (int i = 0; i < collectionDetails.size(); i++) {
				Keywords.verifyTextMessage(collectionDetails.get(i), plantInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddOrganizationPage() {
		try {
			navigateToManageUserSubTab("organizations");
			navigateToAddThingsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addOrgFromAdmin(String locationType, String subTabName) {
		List<String> orgInfo = new ArrayList<>();
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - ADD ORGANIZATION FROM ADMIN</b>");
			DriverSession.setReporting(false);
			loginAsAdmin();
			DriverSession.setReporting(true);
			navigateToAddOrganizationPage();
			AdminOrganization org = new AdminOrganization(DriverSession.getLastExecutionDriver());
			org.addOrgImage();
			org.addOrgCoverImage();
			org.enterOwnerIdOrSlug();
			orgInfo.add(org.addAdminOrgTitle());
			orgInfo.add(org.addAdminOrgStory());
			orgInfo.add(org.addAddress(locationType));
			submitAdminPage();
			waitForLoaderInvisible();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orgInfo;
	}

	public List<String> getAdminOrgInfo() {
		List<String> orgInfo = new ArrayList<>();
		try {
			AdminOrganization org = new AdminOrganization(DriverSession.getLastExecutionDriver());
			orgInfo.add(org.getAdminOrgTitle());
			orgInfo.add(org.getAdminOrgDescription());
			orgInfo.add(org.getAdminOrgLocationPrivacy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgInfo;
	}

	public void verifyOrgInfoOnAdminOrgPage(List<String> orgInfo) {
		List<String> orgDetails;
		try {
			orgDetails = getAdminOrgInfo();
			for (int i = 0; i < orgDetails.size(); i++) {
				Keywords.verifyTextMessage(orgDetails.get(i), orgInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOrgInfoOrganizationPage(String orgTitle) {
		try {
			selectOrg(orgTitle, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddPostPage() {
		try {
			navigateToManageUserSubTab("posts");
			navigateToAddThingsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddTabManagerPage() {
		try {
			navigateToManageUserSubTab("Tab Manager");
			navigateToAddThingsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addTabManager() {
		List<String> list = new ArrayList<>();
		try {
			DriverSession.setReporting(false);
			loginAsAdmin();
			DriverSession.setReporting(true);
			TabManager tabManager = new TabManager(DriverSession.getLastExecutionDriver());
			navigateToAddTabManagerPage();
			list.add(tabManager.enterTabName());
			list.add(tabManager.enterTabDescription());
			submitAdminPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getTabManagerAndDescriptionInfo() {
		List<String> tabManagerInfo = new ArrayList<String>();
		try {
			TabManager tabManager = new TabManager(DriverSession.getLastExecutionDriver());
			tabManagerInfo.add(tabManager.getAddedTabManagerName());
			tabManagerInfo.add(tabManager.getAddedTabManagerDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabManagerInfo;
	}

	public void verifyTabManagerInfoOnTabManagerPage(List<String> tabInfo) {
		List<String> tabManagerDetails;
		try {
			tabManagerDetails = getTabManagerAndDescriptionInfo();
			for (int i = 0; i < tabManagerDetails.size(); i++) {
				Keywords.verifyTextMessage(tabManagerDetails.get(i), tabInfo.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addFieldsForTabManager() {
		List<String> tabInfo = new ArrayList<>();
		try {
			// TabManager tabManager = new
			// TabManager(DriverSession.getLastExecutionDriver());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabInfo;
	}

	public List<String> addExistingFieldsForTabManager(String addType) {
		List<String> tabInfo = new ArrayList<>();
		try {
			TabManager tabManager = new TabManager(DriverSession.getLastExecutionDriver());
			tabManager.clickOnCreateFieldForTab(addType);
			tabManager.selectExistingFieldsCheckboxList(addType);
			submitAdminPage();
			tabManager.submitFieldSuccessfullySavedAlert();
			tabInfo = tabManager.getAddedExistingFieldsName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabInfo;
	}

	public String verifySlugIdDisplayName() {
		String slugIdDisplayName = "";
		try {
			TabManager tabManager = new TabManager(DriverSession.getLastExecutionDriver());
			/*
			 * tabManager.enterWrongSlugIdForTabManager();
			 * tabManager.submitSlugId(); tabManager.verifyWrongSlugId();
			 */
			tabManager.enterSlugIdForTabManager();
			tabManager.submitSlugId();
			slugIdDisplayName = tabManager.verifySlugId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slugIdDisplayName;
	}

	public void selectAddedTabOnPlantsDetailPage(String tabMangerName) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnEditButton();
			plant.selectAddedTabName(tabMangerName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void navigateToAddEventsPage() {
	// try {
	// navigateToManageUserSubTab("events");
	// navigateToAddThingsPage();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public void verifyAddedUser(String userName) {
		try {
			navigateToSubTabs("users");
			searchUser(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchUser(String userName) {
		try {
			ManageUsers user = new ManageUsers(DriverSession.getLastExecutionDriver());
			user.searchForAdmin(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectOwnerPlant(String ownerType, String manageUserSubtab, String plantTitle, List<String> plantsInfo,
			boolean status) {
		try {
			if (ownerType.equalsIgnoreCase("user")) {
			} else {
				selectOrg("Hitesh_Org", status);
			}
			selectHomeSubHeaderTab(manageUserSubtab);
			selectPlantFromPlantTab(plantTitle);
			verifyPlantInfoOnPlantDetailPage(plantsInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectOwnerCollection(String ownerType, String manageUserSubtab, String collectionTitle,
			List<String> collectionInfo, boolean status) {
		try {
			if (ownerType.equalsIgnoreCase("user")) {
			} else {
				selectOrg("Hitesh_Org", status);
			}
			selectHomeSubHeaderTab(manageUserSubtab);
			selectCollectionFromCollectionTab(collectionTitle);
			verifyCollectionDetailOnCollectionDetailpage(collectionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectConnectOrFollow(String type) {
		WebElement element;
		try {
			Search search = new Search(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(driver);
			if (type.equalsIgnoreCase("follow"))
				search.clickOnProfileFollowButton();
			else if (type.equalsIgnoreCase("connect"))
				search.clickOnOrgConnectButton();
		} catch (Exception e) {

		}
	}

	public void searchSelectAndVerifyUserProfileOrOrg(String type, String userNameOrOrg) {
		try {
			Search search = new Search(DriverSession.getLastExecutionDriver());
			search.search(userNameOrOrg);
			search.selectProfileOrOrgFromSearchResult(type);
			search.selectUserProfile(userNameOrOrg);
			search.verifyUserProfilePageLoad(userNameOrOrg);
			search.clickOnProfileFollowButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchSelectAndVerifyUserProfilesPlantsCollectionOrg(String type, String userNameOrOrg) {
		int indexNumber = 0;
		int plantCount = 0;
		Map<String, Integer> userOrOrgInfo;
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			Search search = new Search(DriverSession.getLastExecutionDriver());
			search.search(userNameOrOrg);
			search.selectProfileOrOrgFromSearchResult(type);
			indexNumber = search.getPlantsCountFromSearchResult();
			userOrOrgInfo = search.getUserOrOrgInfo(indexNumber);
			search.selectUserProfileBasedOnIndex(userNameOrOrg, indexNumber);
			search.verifyUserProfilePageLoad(userNameOrOrg);
			plants.selectViewMoreBtn("plants");
			plantCount = plants.totalPlants();
			if (plantCount == userOrOrgInfo.get("plant"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plants count matched successfully</b>", "PASS",
						"<b>Plants count should be matched on user profile page</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Plants count not matched successfully</b>", "FAIL",
						"<b>Plants count should be matched on user profile page</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectIndividualTypeFromSearchResult(String searchType, String userNameOrOrg, String followOrConnect) {
		try {
			Search search = new Search(DriverSession.getLastExecutionDriver());
			search.search(userNameOrOrg);
			search.selectPlantCollectionOrgIndividualFromSearch(searchType);
			search.selectUserProfile(userNameOrOrg);
			search.verifySelectProfileOrOrgPageLoaded(searchType);
			selectConnectOrFollow(followOrConnect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNotYetAddedAnyPlantCollectionAfterUserFollow(String subTabName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHomeSubHeaderTab(subTabName);
			Search search = new Search(DriverSession.getLastExecutionDriver());
			search.verifyPlantsListAfterFollowUser(subTabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAfterFollowUserAddingPlantsCollection(String subTabName, String plantTitleName) {
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHomeSubHeaderTab(subTabName);
			Search search = new Search(DriverSession.getLastExecutionDriver());
			search.verifyPlantsListAfterFollowUserProfileAddingPlants(subTabName, plantTitleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String postSomeMessage() {
		String postmsg = "";
		try {
			switchToProfile();
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postmsg = profile.postMessage();
			profile.submitPost();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return postmsg;
	}

	public String postSomeMessageForOrg() {
		String postmsg = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postmsg = profile.postMessage();
			profile.submitPost();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return postmsg;
	}

	public String getPostUserName() {
		String postUName = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postUName = profile.getPostUserName();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return postUName;
	}

	public String getCommentUserName() {
		String commentUserName = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			commentUserName = profile.getCommentUserName();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentUserName;
	}

	public String getPostMessage() {
		String postMessage = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postMessage = profile.getPostMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return postMessage;
	}

	public String getCommentMessage() {
		String commentMessage = "";
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			commentMessage = profile.getCommentMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentMessage;
	}

	public int getNotificationCount() {
		int count = 0;
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			count = profile.getNotificationCount();
		} catch (Exception e) {
		}

		return count;
	}

	public void viewNotification() {

	}

	public void verifyNotificationCountAfterView(String postMessage, String commentUserName, String commentMessage,
			int expectedCount) {
		int count = 0;
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			profile.SelectCommentMessageFromList(postMessage, commentUserName, commentMessage);
			count = getNotificationCount();
			if (expectedCount - 1 == count) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification count one less than</b> expected notification count", "PASS",
						"<b>Notification count should be less than one from expected notification Count</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification count one not less than</b> expected notification count", "FAIL",
						"<b>Notification count should be less than one from expected notification Count</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String doCommentOnPostMessage(String userPostName) {
		String commentmsg = "";
		String postUser = "";
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab("Explore");
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postUser = getPostUserName();
			System.out.println("Post UserName---" + postUser);
			if (postUser.equalsIgnoreCase(userPostName)) {
				commentmsg = profile.doCommentOnUserPost();
				profile.submitComment();
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Comment On User Post</b> done successfully", "PASS",
							"<b>Comment On User Post</b> should be done");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Comment On User Post</b> not done successfully", "FAIL",
							"<b>Comment On User Post</b> should be done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentmsg;
	}

	public String doCommentOnPostMessageForOrg(String userPostName) {
		String commentmsg = "";
		String postUser = "";
		try {
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			home.selectHeaderTab("Explore");
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			postUser = getPostUserName();
			if (postUser.equalsIgnoreCase(userPostName)) {
				commentmsg = profile.doCommentOnUserPost();
				profile.submitComment();
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Comment On User Post</b> done successfully", "PASS",
							"<b>Comment On User Post</b> should be done");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Comment On User Post</b> not done successfully", "FAIL",
							"<b>Comment On User Post</b> should be done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentmsg;
	}

	public List<String> getPlantCreationDate(String sortTypeOption) {
		List<String> plantInfo = new ArrayList<String>();
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			// selectRandomPlantsUnderMyPlantsMapTab();
			selectRandomPlantsUnderMyPlantsMapTabForPlantCreation(sortTypeOption);
			plantInfo.add(plant.getPlantCreatedDate());
			plantInfo.add(plant.getPlantUpdationDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantInfo;
	}

	public List<String> getPlantDateAfterUpdation() {
		List<String> plantInfo = new ArrayList<>();
		try {
			clickOnPlantEditBtn();
			submitPlantUpdatedInformation();
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plantInfo.add(plant.getPlantCreatedDate());
			plantInfo.add(plant.getPlantUpdationDate());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return plantInfo;
	}

	public void verifyPlantCreationAndUpdationDate(String sortTypeOption) {
		List<String> beforeUpdation = getPlantCreationDate(sortTypeOption);
		List<String> afterUpdation = getPlantDateAfterUpdation();
		try {
			if (!beforeUpdation.get(1).equalsIgnoreCase(afterUpdation.get(1)))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Update Date before and After not match successfully</b>", "PASS",
						"<b>Update Date before and After should not match</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Update Date before and After not match successfully</b>", "FAIL",
						"<b>Update Date before and After should not match</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddCollectionWithoutSignInOrUp() {
		try {
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify Add Collection without SignIn</b>");
			selectAddType("collection");
			login.verifySignInAndSignUpMessage();
			login.clickOnSignInLink();
			login.enterEmailId();
			login.enterPassword();
			login.submitSingIn();
			profile.verifyProfileHeaderTxt();
			logout();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - Verify Add Collection without SignUp</b>");
			selectAddType("collection");
			login.verifySignInAndSignUpMessage();
			login.clickOnSignUpLink();
			signUpFromMainPage();
			profile.verifyProfileEditPageHeaderText();
			profile.enterLastName();
			profile.clickOnMyProfileSaveButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddRemoveCollectionPage() {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.clickOnAddRemoveToCollectionButton();
			plant.verifyAddRemoveToCollectionHeaderTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addCollectionToPlant(String plantName) {
		String collectionName = "";
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			navigateToAddRemoveCollectionPage();
			collectionName = plant.addCollectionToPlant(plantName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collectionName;
	}

	public void verifyCollectionInsidePlantDetailPage(String collectionName) {
		try {
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			plant.verifyCollectionOnPlantDetailPage(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPlantInsideCollectionSubCollectionDetailPage(String plantTitleName) {
		try {
			Collections collection = new Collections(DriverSession.getLastExecutionDriver());
			collection.verifyPlantOnCollectionDetailPage(plantTitleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAnchorAndImagesLinks() {
		List<WebElement> list;
		String url = "";
		String attributeValue = "";
		try {
			TagsAndImagesLink links = new TagsAndImagesLink(DriverSession.getLastExecutionDriver());
			list = links.getLinksAndImagesList();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getAttribute("href") != null) {
					attributeValue = "href";
					url = list.get(i).getAttribute("href");
				} else {
					attributeValue = "src";
					url = list.get(i).getAttribute("src");
				}
				links.isLinkBroken(url);
				// System.out.println("Url...>"+url+"
				// Return...>"+links.isLinkBroken(list.get(i).getAttribute(attributeValue)));
			}
		} catch (Exception e) {
			System.out.println("Anchor Tag & Image not having href data..");
			// System.out.println("At " + ele.getAttribute("innerHTML") + "
			// Exception occured -&gt; " + e.getMessage());
		}
	}

	public void verifyPlantOrderInsideCartPage(List<String> actualList, List<String> expectedList) {
		try {
			for (int i = 0; i < expectedList.size(); i++) {
				if (actualList.get(i).equalsIgnoreCase(expectedList.get(i))) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants ordering correct after plant deletion/Updation</b>", "PASS",
							"<b>Plants order should be same after plant deletion/Updation</b>");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants ordering incorrect after plant deletion/Updation</b>", "FAIL",
							"<b>Plants order should be same after plant deletion/Updation</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Plants ordering Incorrect after plant deletion/Updation</b>", "FAIL",
					"<b>Plants order should be same after plant deletion/Updation</b>");
		}
	}

	public void verifyPlantDetailsWithExcelData(List<String> actualList, List<String> expectedList) {
		try {
			for (int i = 0; i < expectedList.size(); i++) {
				if (actualList.get(i).equalsIgnoreCase(expectedList.get(i))) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants detail correctly matches with excel data</b>", "PASS",
							"<b>Plants details should be matched with excel sheet data</b>");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Plants detail correctly matches with excel data</b>", "FAIL",
							"<b>Plants details should be matched with excel sheet data</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while matching the Plants detail with excel data</b>", "FAIL",
					"<b>Plants details should be matched with excel sheet data</b>");
		}
	}

	public List<String> updatePlantListAfterDeletion(List<String> allPlants, List<String> deletedPlants) {
		try {
			for (int i = 0; i < deletedPlants.size(); i++) {
				for (int j = 0; j < allPlants.size(); j++) {
					if (allPlants.get(j).equalsIgnoreCase(deletedPlants.get(i))) {
						allPlants.remove(j);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allPlants;
	}

	public List<String> updatePlantListAfterUpdation(List<String> allPlants, List<String> plantsListBeforeUpdation,
			List<String> plantsListAfterUpdation) {
		try {
			for (int i = 0; i < plantsListBeforeUpdation.size(); i++) {
				for (int j = 0; j < allPlants.size(); j++) {
					if (allPlants.contains(plantsListBeforeUpdation.get(i))) {
						int indexValue = allPlants.indexOf(plantsListBeforeUpdation.get(i));
						allPlants.remove(indexValue);
						allPlants.add(indexValue, plantsListAfterUpdation.get(i));
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allPlants;
	}

	public List<String> plantTagPageData(String cellValue) {
		List<String> data = new ArrayList<>();
		String fileLocation = "";
		try {
			if (System.getProperty("os.name").contains("Mac"))
				fileLocation = "/Users/kiwitech/Downloads/order_excel.xls";
			else
				fileLocation = "C:\\Users\\kiwitech\\Downloads\\order_excel.xls";
			ExcelUtility utility = new ExcelUtility();
			data = utility.getLineData(fileLocation, cellValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void downloadExcelFile() {
		try {
			Tags tag = new Tags(DriverSession.getLastExecutionDriver());
			tag.clickOnDownLoadExcel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeFile() {
		String fileLocation = ""; // working with mac as well as mac os
		try {
			if (System.getProperty("os.name").contains("Mac"))
				fileLocation = "/Users/kiwitech/Downloads/order_excel.xls";
			else
				fileLocation = "C:\\Users\\kiwitech\\Downloads\\order_excel.xls";
			File file = new File(fileLocation);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNewTabOpen(int beforeClickSize, int afterClickSize) {
		try {
			if (beforeClickSize < afterClickSize) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Both Handle Size not same </b>",
						"PASS", "<b>Both Handle Size should not be same</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Both Handle Size same </b>",
						"FAIL", "<b>Both Handle Size should not be same</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLoginScreenAfterSomeOperation(String type, String userNameOrOrg) {
		try {
			Keywords.waitForPage(driver);
			HomePage home = new HomePage(DriverSession.getLastExecutionDriver());
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			Profile profile = new Profile(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - Verify Login Screen Page For News Like Button</b>");
			profile.clickOnNewsLikeButton();
			login.verifySignInAndSignUpMessage();
			Keywords.backPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - Verify Login Screen Page While submitting Submit comment</b>");
			profile.submitWriteCommentMessage();
			login.verifySignInAndSignUpMessage();
			Keywords.backPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - Verify Login Screen Page While Adding Plant From Explore Tab</b>");
			home.selectHeaderTab("Explore");
			selectAddType("plants");
			login.verifySignInAndSignUpMessage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - Verify Login Screen Page While Adding Collection From Explore Tab</b>");
			home.selectHeaderTab("Explore");
			selectAddType("collection");
			login.verifySignInAndSignUpMessage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - Verify Login Screen Page While Adding Plant From Map Tab</b>");
			home.selectHeaderTab("Map");
			selectAddType("plants");
			login.verifySignInAndSignUpMessage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - Verify Login Screen Page While Adding Collection From Map Tab</b>");
			home.selectHeaderTab("Map");
			selectAddType("collection");
			login.verifySignInAndSignUpMessage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
					"<b>TESTCASE 7 - Verify New Tab opens while Clickin on the Help Tab</b>");
			int mainHandleSize = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver()).size();
			System.out.println("Size.." + mainHandleSize);
			home.selectHeaderHelpTab();
			Thread.sleep(2000);
			int subHandleSize = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver()).size();
			verifyNewTabOpen(mainHandleSize, subHandleSize);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 8 STARTED</b>", "INFO",
					"<b>TESTCASE 8 - Verify New Tab opens while Clickin on the My Plants Map Tab</b>");
			int mainHandleSize1 = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver()).size();
			home.selectHeaderTab("My Plants Map");
			Thread.sleep(2000);
			int subHandleSize1 = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver()).size();
			verifyNewTabOpen(mainHandleSize1, subHandleSize1);

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 9 STARTED</b>", "INFO",
					"<b>TESTCASE 9 - Verify Login Screen Page While Follow User Profile</b>");
			home.selectHeaderTab("Explore");
			searchSelectAndVerifyUserProfileOrOrg(type, userNameOrOrg);
			login.verifySignInAndSignUpMessage();

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 10 STARTED</b>", "INFO",
					"<b>TESTCASE 10 - Verify Login Screen Page While Follow Organization</b>");
			home.selectHeaderTab("Explore");
			selectIndividualTypeFromSearchResult(type, userNameOrOrg, "follow");
			login.verifySignInAndSignUpMessage();

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 11 STARTED</b>", "INFO",
					"<b>TESTCASE 11 - Verify Login Screen Page While Connect Organization</b>");
			home.selectHeaderTab("Explore");
			selectIndividualTypeFromSearchResult(type, userNameOrOrg, "connect");
			login.verifySignInAndSignUpMessage();

			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 12 STARTED</b>", "INFO",
					"<b>TESTCASE 12 - Verify Search User Plant, Collection & Organization</b>");
			home.selectHeaderTab("Explore");
			searchSelectAndVerifyUserProfilesPlantsCollectionOrg(type, userNameOrOrg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPaginationToSeePlantDetails() {
		try {
			Plants plants = new Plants(DriverSession.getLastExecutionDriver());
			selectRandomPlantsUnderPlantTabUsingPagination();
			plants.verifyAddNewPlantHeader();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}