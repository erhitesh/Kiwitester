package applicationComponent.Plantsmap;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

import action.Plantsmap.WebAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;

@Test
public class WebAc extends AppComponent implements ApplicationComponent {
	private WebAction action = new WebAction(DriverSession.getLastExecutionDriver());

	@Override
	public void openApplication() throws Exception {
		GlobalParam.url = DriverSession.getTestCaseData().get("URL");
		action.openBrowser(GlobalParam.url);
	}

	@Override
	public void closeApplication() {
		action.closeBrowser();
	}

	@Override
	public void validateHomePage() {
	}

	public void loginFunctionality() {
		action.verifyLoginFunctionalityWithRequiredField();
		action.login();
	}

	public void signUpFunctionality() {
		List<String> credentialData;
		action.verifySignUpFunctionality();
		credentialData = action.signUp();
		action.logout();
		action.signUpWithAlreadyUsedData(credentialData);
	}

	public void verifyInnerTabsOfAboutLink() {
		action.innerTabOfAboutLink();
	}

	public void verifySubTabsOfExploreLink() {
		action.innerTabOfExploreLink();
	}

	public void verifyFooterLink() {
		action.footerLinkText();
	}

	public void verifySharingLinkOption() {
		action.verifySharingLink();
	}

	public void verifyMainHeaderAndSubHeaderTab() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyMainHeaderAndSubHeaderTab();
	}

	public String addViewAndVerifyPlant() {
		String selectFrom = action.selectFromData();
		String makeLocation = "public";
		String plantTitle = "";
		List<String> plantsInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		plantsInfo = action.createNewPlant(makeLocation);
		plantTitle = plantsInfo.get(0);
		action.selectAddedPlant(selectFrom, plantTitle);
		action.verifyPlantInfoOnPlantDetailPage(plantsInfo);
		return plantTitle;
	}

	public void addViewAndDeletePlant() {
		addViewAndVerifyPlant();
		action.deletePlant();
	}

	public void verifyPlantUpdationDate() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		String sortTypeOption = "Date Asc";
		action.verifyPlantCreationAndUpdationDate(sortTypeOption);
	}

	public void verifyPlantMapBlankInvalidAddressAndLikeCount() {
		String selectFrom = action.selectFromData();
		String plantTitle = "";
		List<String> plantsInfo;
		String invalidPhysicalAddress = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		plantsInfo = action.createNewPlantWithoutAddress();
		plantTitle = plantsInfo.get(0);
		action.selectAddedPlant(selectFrom, plantTitle);
		action.verifyPlantBlankLocation();
		action.verifyPlantLikeCounts();
		action.clickOnPlantEditBtn();
		invalidPhysicalAddress = action.addInvalidAddress();
		action.submitPlantUpdatedInformation();
		action.verifyPlantPhysicalLocation(invalidPhysicalAddress);
	}

	public void verifyPlantPrivateLocationFromUnAuthorizedUser() {
		List<String> plantsInfo;
		String makeLocation = "private";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		plantsInfo = action.createNewPlant(makeLocation);
		DriverSession.setReporting(false);
		action.logout();
		DriverSession.setReporting(true);
		action.verifyPlantPrivateLocation(plantsInfo.get(0), plantsInfo.get(2));
	}

	public void addPlantWithAllFields() {
		List<Object> whenCreated;
		List<String> tabInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		whenCreated = action.createPlantWithAllFields();
		DriverSession.setReporting(false);
		action.logout();
		DriverSession.setReporting(true);
		tabInfo = action.tabList();
		action.verifyPlantDetailsFromUnAuthorizeUser(whenCreated, tabInfo);
	}

	public void verifyAddCollectionToPlant() {
		String plantTitle = "";
		String collectionName = "";
		plantTitle = addViewAndVerifyPlant();
		collectionName = action.addCollectionToPlant(plantTitle);
		action.verifyCollectionInsidePlantDetailPage(collectionName);
		action.deleteCollectionFromPlant(collectionName);

	}

	public String addViewAndVerifyCollection() {
		String locationType = "public";
		String selectFrom = action.selectFromData();
		String collectionTitleName = "";
		List<String> collectionInfo;
		collectionInfo = action.createNewCollection(locationType);
		collectionTitleName = collectionInfo.get(0);
		action.selectAddedCollection(selectFrom, collectionTitleName);
		action.verifyCollectionDetailOnCollectionDetailpage(collectionInfo);
		return collectionTitleName;
	}

	public void AddViewVerifyAndDeleteCollectionSubCollection() {
		String locationType = "public";
		String selectFrom = action.selectFromData();
		String collectionTitleName = "";
		collectionTitleName = addViewAndVerifyCollection();
		List<String> subCollectionInfo;
		String subCollectionTitleName = "";
		subCollectionInfo = action.createSubCollection(locationType);
		subCollectionTitleName = subCollectionInfo.get(0);
		action.selectAddedSubCollection(selectFrom, subCollectionTitleName);
		action.verifySubCollectionDetailOnSubCollectionDetailpage(subCollectionInfo);
		action.deleteSubCollection();
		action.deleteCollection();
	}

	public List<String> addPlantsToSubCollection() {
		String plantName = "";
		String makeLocation = "public";
		String collectionName = "";
		String subCollectionName = "";
		List<String> info = new ArrayList<>();
		DriverSession.setReporting(false);
		collectionName = addViewAndVerifyCollection();
		subCollectionName = action.createSubCollection(makeLocation).get(0);
		plantName = action.addPlantToSubCollection(collectionName, subCollectionName);
		action.verifyPlantInSubCollection(plantName);
		action.verifyPlantInCollection(collectionName, plantName);
		info.add(plantName);
		info.add(collectionName);
		info.add(subCollectionName);
		return info;
	}

	public void verifyPlantInSubCollectionAfterDeleteFromSubColl() {
		List<String> info;
		info = addPlantsToSubCollection();
		action.selectAddedSubCollection("", info.get(2));
		action.deletePlantFromSubCollection(info.get(0));
		action.verifyPlantInCollection(info.get(1), info.get(0));
	}

	public void verifyPlantInSubCollectionAfterDeleteFromCollection() {
		List<String> info;
		info = addPlantsToSubCollection();
		// action.selectAddedCollection("", info.get(1));
		action.deletePlantFromCollection(info.get(0));
		action.navigateToSubCollectionTab(info.get(2));
		action.verifyPlantInSubCollection(info.get(0));
	}

	public void followUserProfile() {
		String plantTitle = "";
		String subTabName = DriverSession.getTestCaseData().get("SubTab");// "plants";
		List<String> credentialInfo;
		String userNameOrOrg = DriverSession.getTestCaseData().get("UserProfileName");
		String type = DriverSession.getTestCaseData().get("selectionType");// "individual";
		DriverSession.setReporting(false);
		credentialInfo = action.signUp();
		DriverSession.setReporting(true);
		action.searchSelectAndVerifyUserProfileOrOrg(type, userNameOrOrg);
		action.verifyNotYetAddedAnyPlantCollectionAfterUserFollow(subTabName);
		DriverSession.setReporting(false);
		action.logout();
		// action.login();
		plantTitle = addViewAndVerifyPlant();
		action.logout();
		action.login(credentialInfo.get(0), credentialInfo.get(1));
		DriverSession.setReporting(true);
		action.verifyAfterFollowUserAddingPlantsCollection(subTabName, plantTitle);
	}

	public void changePassword() {
		action.verifyForgotPassword();
	}

	public void addPlantToOrg() {
		String makeLocation = "public";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		List<String> plantsInfo;
		String plantTitle = "";
		action.selectOrg("Hitesh_Org", true);
		plantsInfo = action.createNewPlant(makeLocation);
		plantTitle = plantsInfo.get(0).toLowerCase();
		action.selectHeaderTab("Explore");
		action.selectPlantFromPlantList(plantTitle);
		action.verifyPlantInfoOnPlantDetailPage(plantsInfo);
	}

	public void addCollectionToOrg() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		String selectFrom = action.selectFromData();
		String locationType = "public";
		String collectionTitleName = "";
		List<String> collectionInfo;
		action.selectOrg("Hitesh_Org", true);
		collectionInfo = action.createNewCollection(locationType);
		collectionTitleName = collectionInfo.get(0);
		action.selectAddedCollection(selectFrom, collectionTitleName);
		action.verifyCollectionDetailOnCollectionDetailpage(collectionInfo);
	}

	public void createEvent() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.selectOrg("Hitesh_Org", true);
		List<String> eventInfo;
		boolean reccurringEvent = false;
		String eventTitle = "";
		eventInfo = action.createEvent(reccurringEvent);
		eventTitle = eventInfo.get(0);
		action.selectExploreInnerTab("Events");
		action.searchEvent("title", eventTitle);
		action.verifyEventDetailOnEventPage(eventInfo);
	}

	public void addVerifyAndDeleteEvent() {
		String eventName = "";
		createEvent();
		eventName = action.deleteEvent();
		action.verifyEventDeleteSuccessfully(eventName);
	}

	public void verifyEventListByMonthOption() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyEventListByDateCriteria();
	}

	public void verifyEventListByYearOption() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyEventListByYearCriteria();
	}

	public int createRecurringEvent() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.selectOrg("Hitesh_Org", true);
		List<String> eventInfo;
		boolean reccurringEvent = true;
		String eventTitle = "";
		// String eventMessage = "";
		int eventOccurrence = 0;
		eventInfo = action.createEvent(reccurringEvent);
		eventTitle = eventInfo.get(0);
		eventOccurrence = Integer.parseInt(eventInfo.get(eventInfo.size() - 1));
		action.selectExploreInnerTab("Events");
		action.searchEventForReccurring("title", eventTitle, eventOccurrence);
		action.verifyEventDetailOnEventPage(eventInfo);
		return eventOccurrence;
	}

	public void addVerifyAndDeleteRecurringEvent() {
		int recurringEventOccurence = 0;
		String recurringEventName = "";
		String applyOn = DriverSession.getTestCaseData().get("ApplyOn");// "all
																		// events";
		recurringEventOccurence = createRecurringEvent();
		recurringEventName = action.deleteRecurringEvent(applyOn);
		action.verifyRecurringEventDeleteSuccessfully(recurringEventName, recurringEventOccurence);
	}

	public void addAndVerifyEventTimeFromUnauthorizeUser() {
		int recurringEventOccurence = 0;
		String recurringEventName = "";
		String applyOn = DriverSession.getTestCaseData().get("ApplyOn");// "all
																		// events";
		recurringEventOccurence = createRecurringEvent();
		recurringEventName = action.deleteRecurringEvent(applyOn);
		action.verifyRecurringEventDeleteSuccessfully(recurringEventName, recurringEventOccurence);
	}

	public void deleteCollectionFromOrg() {
		addCollectionToOrg();
		action.deleteCollection();
	}

	public void deletePlantFromOrg() {
		addPlantToOrg();
		action.deletePlant();
	}

	public void addAndViewOrganization() {
		String makeLocation = "public";
		List<String> orgDetails;
		orgDetails = action.createNewOrganization(makeLocation);
		action.verifyAddedOrg(orgDetails.get(0));
		action.selectOrg(orgDetails.get(0), true);
	}

	public void addViewAndDeleteOrganization() {
		String orgName = "";
		addAndViewOrganization();
		orgName = action.deleteOrg();
		action.switchToProfile();
		action.loginAsAdminUser();
		action.navigateToDeleteOrgInAdmin();
		action.searchAndDeleteItemFromAdmin(orgName);
		action.loginAsNormalUser();
		action.verifyOrgNameAfterDeletion(orgName);
	}

	public void verifyPostCommentAndNotificationUserProfile() {
		String postMessage = "";
		String commentMessgae = "";
		String postUserName = "";
		String commentUserName = "";
		int count = 0;
		List<String> userCredentials;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		postMessage = action.postSomeMessage();
		// System.out.println("Post Message..."+postMessage);
		postUserName = action.getPostUserName();
		/* action.getPostMessage(); */
		DriverSession.setReporting(false);
		action.logout();
		userCredentials = action.signUp();
		DriverSession.setReporting(true);
		commentMessgae = action.doCommentOnPostMessage(postUserName);
		commentUserName = action.getCommentUserName();
		DriverSession.setReporting(false);
		action.logout();
		DriverSession.setReporting(true);
		action.login();
		count = action.getNotificationCount();
		action.verifyNotificationCountAfterView(postMessage, commentUserName, commentMessgae, count);
	}

	public void verifyPostCommentAndNotificationOrg() {
		String createdOrgName = "";
		String postMessage = "";
		String commentMessgae = "";
		String postUserName = "";
		String commentUserName = "";
		String makeLocation = "public";
		int count = 0;
		List<String> userCredentials;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.selectOrg("Hitesh_Org", true);
		postMessage = action.postSomeMessageForOrg();
		System.out.println("Post Message..." + postMessage);
		postUserName = action.getPostUserName();
		DriverSession.setReporting(false);
		action.logout();
		userCredentials = action.signUp();
		action.selectHeaderTab("Home");
		// createdOrgName = "OrganizationTitle86601"; // for temp testing
		// action.selectOrg(createdOrgName, true);
		createdOrgName = action.createNewOrganization(makeLocation).get(0);
		DriverSession.setReporting(true);
		commentMessgae = action.doCommentOnPostMessage(postUserName);
		commentUserName = action.getCommentUserName();
		DriverSession.setReporting(false);
		action.logout();
		action.login();
		DriverSession.setReporting(true);
		action.selectOrg("Hitesh_Org", true);
		count = action.getNotificationCount();
		action.verifyNotificationCountAfterView(postMessage, commentUserName, commentMessgae, count);
	}

	public void verifyProfilePercentage() {
		action.signUp();
		action.verifyLastNameAndSubmitprofile();
		action.checkProfilePercentageAfterUpdate();
	}

	public void testPlantOrderOnMyTagPage() {
		int firstIndex = 0;
		String addType = "";
		List<String> deletedPlants = new ArrayList<>();
		List<String> plantListBeforeDelete;
		List<String> plantsListBeforeUpdation = new ArrayList<>();
		List<String> plantListAfterDeletetion;
		List<String> plantQuantity;
		List<String> plantTemplateList;
		List<String> tagList;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToCart();
		action.removeAllPlantsFromCart();
		addType = "planttitle";
		action.navigateToAddPlantPageView();
		action.addPlantFromTagPopupForOrderingVerify(addType);
		action.updatePlantsTagsAndSign();
		plantListBeforeDelete = action.getPlantTitleListFromTagsPage();
		deletedPlants.add(action.removePlantsFromCart(firstIndex));
		deletedPlants.add(action.removePlantsFromCart(action.getPlantTitleListFromTagsPage().size() - 1));
		deletedPlants.add(action.removePlantsFromCart(action.getPlantTitleListFromTagsPage().size() / 2));
		plantListAfterDeletetion = action.updatePlantListAfterDeletion(plantListBeforeDelete, deletedPlants);
		plantQuantity = action.getPlantQuantityList();
		tagList = action.getTagList();
		plantTemplateList = action.getTemplateList();
		/* edit information */
		plantsListBeforeUpdation
				.add(plantListAfterDeletetion.get(Keywords.getRandomInteger(plantListAfterDeletetion.size() - 1)));
		action.updatePlantTitle(plantsListBeforeUpdation);
		action.downloadExcelFile();
		action.verifyPlantDetailsWithExcelData(plantQuantity, action.plantTagPageData("Quantity"));
		action.verifyPlantDetailsWithExcelData(tagList, action.plantTagPageData("Product"));
		action.verifyPlantDetailsWithExcelData(plantTemplateList, action.plantTagPageData("Template"));
		action.verifyPlantDetailsWithExcelData(action.getPlantsLineDataList(1), action.plantTagPageData("Line1"));
		action.removeFile();
	}

	public void placeOrder() {
		float expectedPlantTagPrice = 0.00f;
		float actualPlantTagPrice = 0.00f;
		float additionalTagPrice = 0.00f;
		float expectedTotalSubPrice = 0.00f;
		float shippingCharge = 0.00f;
		float customLogoCharge = 0.00f;
		float discount = 0.00f;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.addPlantToTagList();
		action.navigateToCart();
		action.verifyPlantQuantityWithInvalidSize();
		expectedPlantTagPrice = action.verifyPlantsTagWithPrice();
		action.submitPlantQuantityAndSignPage();
		actualPlantTagPrice = action.VerifyPlantsPriceOnTagsAndBillingPage(expectedPlantTagPrice);
		action.enterUserInfoForBilling();
		customLogoCharge = action.selectCustomLogo();
		additionalTagPrice = action.verifyAdditionalTagWithPrice();
		action.submitUserBillingPage();
		shippingCharge = action.shippingCharges();
		discount = action.getDiscount();
		expectedTotalSubPrice = (actualPlantTagPrice + additionalTagPrice + customLogoCharge + shippingCharge);
		expectedTotalSubPrice = (expectedTotalSubPrice - discount);
		action.verifySubTotalOnPlaceOrderPage(expectedTotalSubPrice);
		action.placeOrder();
		action.openMailAndVerifyPlaceOrderSubTotal(expectedTotalSubPrice);
	}

	public void placeOrderFromTag() {
		String addType = "";
		float expectedPlantTagPrice = 0.00f;
		float actualPlantTagPrice = 0.00f;
		float additionalTagPrice = 0.00f;
		float expectedTotalSubPrice = 0.00f;
		float shippingCharge = 0.00f;
		float customLogoCharge = 0.00f;
		float discount = 0.00f;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToCart();
		action.removeAllPlantsFromCart();
		addType = action.addType();
		action.navigateToAddPlantPageView();
		action.addPlantFromTagPopup(addType);
		action.verifyPlantQuantityWithInvalidSize();
		expectedPlantTagPrice = action.verifyPlantsTagWithPrice();
		action.submitPlantQuantityAndSignPage();
		actualPlantTagPrice = action.VerifyPlantsPriceOnTagsAndBillingPage(expectedPlantTagPrice);
		action.enterUserInfoForBilling();
		customLogoCharge = action.selectCustomLogo();
		additionalTagPrice = action.verifyAdditionalTagWithPrice();
		action.submitUserBillingPage();
		shippingCharge = action.shippingCharges();
		discount = action.getDiscount();
		expectedTotalSubPrice = (actualPlantTagPrice + additionalTagPrice + customLogoCharge + shippingCharge);
		expectedTotalSubPrice = (expectedTotalSubPrice - discount);
		action.verifySubTotalOnPlaceOrderPage(expectedTotalSubPrice);
		action.placeOrder();
		action.openMailAndVerifyPlaceOrderSubTotal(expectedTotalSubPrice);
	}

	public void addUserFromAdmin() {
		List<String> userInfo;
		userInfo = action.userCreateFromAdmin();
		action.verifyAddedUser(userInfo.get(0));
		action.loginAsNormalUser(userInfo.get(3), userInfo.get(4));
		action.loginAsAdminUser();
		action.deleteUserFromAdmin(userInfo.get(0));
	}

	public void addTabManagerFromAdmin() {
		String tabMangerName = "";
		String plantTitle = "";
		String manageUserSubtab = "Tab Manager";
		String addtype = "Add Existing Fields";
		List<String> addedFieldsListName;
		List<String> tabManager;
		tabManager = action.addTabManager();
		tabMangerName = tabManager.get(0);
		action.verifyTabManagerInfoOnTabManagerPage(tabManager);
		addedFieldsListName = action.addExistingFieldsForTabManager(addtype);
		action.verifySlugIdDisplayName();
		action.loginAsNormalUser(DriverSession.getTestCaseData().get("Username"),
				DriverSession.getTestCaseData().get("Password"));
		plantTitle = action.selectRandomPlantsUnderPlantTab();
		action.verifyAddedTabManagerFieldOnPlantsPage(tabMangerName, addedFieldsListName);
		DriverSession.setReporting(false);
		action.loginAsAdminUser();
		DriverSession.setReporting(true);
		action.navigateToManageUserSubTab(manageUserSubtab);
		action.searchAndDeleteItemFromAdmin(tabMangerName);
	}

	public void addPlantFromAdmin() {
		String plantTitle;
		String locationType = "public";
		String manageUserSubtab = "Plants";
		String ownerType = action.ownerType().get(Keywords.getRandomInteger(action.ownerType().size()));// "organization";
		List<String> plantsInfo;
		plantsInfo = action.createPlantFromAdmin(locationType, ownerType);
		plantTitle = plantsInfo.get(0);
		ownerType = plantsInfo.get(plantsInfo.size() - 1);
		action.verifyPlantInfoOnAdminPlantPage(plantsInfo);
		action.loginAsNormalUser(DriverSession.getTestCaseData().get("Username"),
				DriverSession.getTestCaseData().get("Password"));
		action.selectOwnerPlant(ownerType, manageUserSubtab, plantTitle, plantsInfo, true);
		DriverSession.setReporting(false);
		action.loginAsAdminUser();
		DriverSession.setReporting(true);
		action.navigateToManageUserSubTab(manageUserSubtab);
		action.searchAndDeleteItemFromAdmin(plantTitle);
	}

	public void addCollectionFromAdmin() {
		String locationType = "public";
		String manageUserSubtab = "Collections";
		String collectionTitle = "";
		String ownerType = action.ownerType().get(Keywords.getRandomInteger(action.ownerType().size()));
		List<String> collectionInfo;
		collectionInfo = action.createCollectionFromAdmin(locationType, ownerType);
		collectionTitle = collectionInfo.get(0);
		ownerType = collectionInfo.get(collectionInfo.size() - 1);
		action.verifyCollectionInfoOnAdminCollectionPage(collectionInfo);
		action.loginAsNormalUser(DriverSession.getTestCaseData().get("Username"),
				DriverSession.getTestCaseData().get("Password"));
		action.selectOwnerCollection(ownerType, manageUserSubtab, collectionTitle, collectionInfo, true);
		DriverSession.setReporting(false);
		action.loginAsAdminUser();
		DriverSession.setReporting(true);
		action.navigateToManageUserSubTab(manageUserSubtab);
		action.searchAndDeleteItemFromAdmin(collectionTitle);
	}

	public void addOrganizationFromAdmin() {
		String locationType = "private";
		String manageUserSubtab = "organizations";
		String orgTitle = "";
		List<String> orgInfo;
		orgInfo = action.addOrgFromAdmin(locationType, manageUserSubtab);
		orgTitle = orgInfo.get(0);
		action.verifyOrgInfoOnAdminOrgPage(orgInfo);
		action.loginAsNormalUser(DriverSession.getTestCaseData().get("Username"),
				DriverSession.getTestCaseData().get("Password"));
		action.verifyOrgInfoOrganizationPage(orgTitle);
		DriverSession.setReporting(false);
		action.loginAsAdminUser();
		DriverSession.setReporting(true);
		action.navigateToManageUserSubTab(manageUserSubtab);
		action.searchAndDeleteItemFromAdmin(orgTitle);
	}

	public void connectToNetwork() {
		String orgName = "";
		String makeLocation = "public";
		String verifyWithOrg = DriverSession.getTestCaseData().get("Org_Name");
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		orgName = action.createNewOrganization(makeLocation).get(0);
		action.selectIndividualTypeFromSearchResult("organization", verifyWithOrg, "connect");
		action.selectHeaderTab("home");
		action.selectOrg(verifyWithOrg, true);
		action.activeReceivedRequestForNetwork(orgName);
		action.verifyOrganizationConnectToTheNetwork(orgName);
	}

	public void verifyProfilPlantAndNetworkCount() {
		List<Integer> adminUserInfo;
		List<Integer> adminOrgInfo;
		List<Integer> webUserInfo;
		List<Integer> webOrgInfo;
		action.loginAsAdminUser();
		adminUserInfo = action.getUserInfoFromAdmin(DriverSession.getTestCaseData().get("UserId"));
		adminOrgInfo = action.getOrgInfoFromAdmin(DriverSession.getTestCaseData().get("Org_Name"));
		action.loginAsNormalUser();
		webUserInfo = action.getUserInfoFromWebsite();
		action.verifyUserPlantAndNetworkCount(adminUserInfo, webUserInfo);
		webOrgInfo = action.getOrgInfoFromWebsite();
		action.verifyOrgPlantAndCollectionCount(adminOrgInfo, webOrgInfo);
	}

	public void addCollectionWithoutSignUpOrIn() {
		action.verifyAddCollectionWithoutSignInOrUp();
	}

	public void testLinksAndImages() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyAnchorAndImagesLinks();
	}

	public void verifyLoginScreenAppearanceForCompletingOperationAsUnAuthroizeUser() {
		String userNameOrOrg = DriverSession.getTestCaseData().get("UserProfileName");
		String type = DriverSession.getTestCaseData().get("selectionType");
		action.verifyLoginScreenAfterSomeOperation(type, userNameOrOrg);
	}
	
	public void verifyUserCanSeePublicPlantCollectionWithoutLogin() {
		action.verifyPaginationToSeePlantDetails();
	}
}