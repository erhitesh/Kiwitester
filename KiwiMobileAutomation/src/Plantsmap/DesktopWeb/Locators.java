package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	public static Locators getInstance() {
		Locators mHeader = null;
		try {
			mHeader = new Locators();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mHeader;
	}

	public WebElement opentab(WebDriver driver) {
		return driver.findElement(By.cssSelector("body"));
	}

	public WebElement enterGmailPassword(WebDriver driver) {
		return driver.findElement(By.name("password"));//(By.id("Passwd"));
	}

	public WebElement clickNextBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Next']"));//(By.id("next"));
	}

	public WebElement enterGmailId(WebDriver driver) {
		return driver.findElement(By.id("identifierId"));//id("Email"));
	}

	public WebElement gmailSignInBtn(WebDriver driver) {
		return driver.findElement(By.id("signIn"));
	}

	public List<WebElement> resetMailLinkList(WebDriver driver) {
		return driver.findElements(By.xpath("//td//div[@role='link']//span/b"));
	}

	public WebElement getSubTotalPrice(WebDriver driver) {
		return driver.findElement(By.xpath("(//h3)[4]"));//(//h3)[5]"));
	}

	public List<WebElement> visibleHideChangePasswordLink(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='ajR' or @aria-label='Show trimmed content']"));
	}

	public List<WebElement> changePasswordLink(WebDriver driver) {
		return driver.findElements(By.linkText("Change my password"));
	}

	public WebElement websiteLogo(WebDriver driver) {
		return driver.findElement(By.className("sprite logoIcon"));
	}

	// search related
	public WebElement searchBox(WebDriver driver) {
		return driver.findElement(By.id("autocompleteBox"));
	}

	public WebElement submitSearchBox(WebDriver driver) {
		return driver.findElement(By.className("searchButton"));
	}

	public WebElement selectSearchSubModule(WebDriver driver, String searchResultType) {
		return driver.findElement(
				By.xpath("//div[@class='defaultSearch']//li[starts-with(@ng-if,'" + searchResultType + "')]"));
	}

	public WebElement searchResult(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='fixedLayout']/h1"));
	}

	public List<WebElement> searchModuleList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='defaultSearch']//li//h1"));
	}

	public WebElement selectIndividualFromSearchResult(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@ng-if='profile']//a"));
	}

	public WebElement selectOrganizationFromSearchResult(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@ng-if='organization']//a"));
	}
	
	public WebElement selectPlantCollectionOrgIndividualFromSearchResult(WebDriver driver, String searchType) {
		if (searchType.equalsIgnoreCase("plant"))
			return driver.findElement(By.xpath("//li[@ng-if='plant']//a"));
		else if (searchType.equalsIgnoreCase("collection"))
			return driver.findElement(By.xpath("//li[@ng-if='collection']//a"));
		else if (searchType.equalsIgnoreCase("organization"))
			return driver.findElement(By.xpath("//li[@ng-if='organization']//a"));
		else
			return driver.findElement(By.xpath("//li[@ng-if='profile']//a"));
	}

	public List<WebElement> selectUserProfileFromGivenList(WebDriver driver, String userName) {
		return driver.findElements(By.xpath("//a[@class='ng-binding' and contains(text(),'" + userName + "')]"));
	}
	
	public List<WebElement> getPlantsListOnSearch(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.plantIcon.ng-binding"));
	}
	
	public List<WebElement> getCollectionListOnSearch(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.collectionIcon.ng-binding"));
	}
	
	public List<WebElement> getOrgListOnSearch(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.organizationIcon.ng-binding"));
	}

	/*public WebElement verifySelectUserProfile(WebDriver driver, String userName) {
		return driver.findElement(
				By.xpath("//h1[@class='title ng-binding' and contains(text(),'Profile : " + userName + "')]"));
	}*/
	
	public WebElement verifySelectUserProfile(WebDriver driver, String userName) {
		return driver.findElement(
				By.xpath("//h1[@class='title to-check-h1-tag ng-binding' and contains(text(),'Profile : "+userName+"')]"));
	}

	public WebElement verifyProfileOrOrgPageLoaded(WebDriver driver, String selectedType) {
		if (selectedType.equalsIgnoreCase("plant") && selectedType.equalsIgnoreCase("collection")) 
			return driver.findElement(By.xpath("//div[@class='headingBox ng-scope']//h2"));
		else if (selectedType.equalsIgnoreCase("organization"))
			return driver.findElement(By.xpath("//div[@class='resources-heading ng-scope']//h1"));
		else if (selectedType.equalsIgnoreCase("profile"))
			return driver.findElement(By.xpath("//div[@class='headingBox']//h1"));
		else
			return null;
	}
	
	public WebElement verifyNotAddedAnyPhotoCollectionOrgEventMessage(WebDriver driver, String verifyType) {
		return driver.findElement(By.xpath("//div[contains(text(),'There are no " + verifyType + " added yet.')]"));
	}

	public WebElement selectUserOrgFromOrgList(WebDriver driver, String orgName) {
		return driver.findElement(By.xpath("//a[@class='ng-binding' and contains(text(),'" + orgName + "')]"));
	}

	public WebElement verifySelectUserOrg(WebDriver driver, String orgName) {
		return driver.findElement(By.xpath("//h1[@class='ng-binding' and contains(text(),'" + orgName + "')]"));
	}

	public WebElement clickOnOrgFollowButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Follow']"));
	}

	public WebElement searchResultModulesCount(WebDriver driver, String searchResultType) {
		return driver.findElement(
				By.xpath("//div[@class='defaultSearch']//li[starts-with(@ng-if,'" + searchResultType + "')]//h3"));
	}

	// header related
	public WebElement headerLinkOption(WebDriver driver, String linkType) {
		return driver.findElement(By.xpath("//nav[@class='floatLeft']//a[@title='" + linkType + "']"));
	}

	public WebElement selectHeaderHelpTab(WebDriver driver) {
		return driver.findElement(By.xpath("(//nav[@class='floatLeft']//a[@title='Help'])[2]"));
	}
	
	public List<WebElement> innerTabListOfExplore(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@id='explore-dropdown-div']//ul//a"));
	}

	public WebElement innerTabsOfExploreLink(WebDriver driver, String innerTabType) {
		return driver
				.findElement(By.xpath("//div[@id='explore-dropdown-div']//a[contains(@title,'" + innerTabType + "')]"));
	}

	public WebElement innerTabOfAboutLink(WebDriver driver, String aboutType) {
		return driver.findElement(By.xpath("//li[@class='active']//a[@title='" + aboutType + "']"));
	}

	public WebElement plants(WebDriver driver, String tagTypesName) {
		return driver
				.findElement(By.xpath("//div[@class='headingTabs ng-scope']//a[@href='/" + tagTypesName + "/plants']"));
	}

	public WebElement subTabsOfHomeHeader(WebDriver driver, String subTabName) {
		return driver.findElement(
				By.xpath("//div[@class='headingTabs ng-scope']//li//a[contains(@href,'/home/" + subTabName + "')]"));
	}

	public List<WebElement> getMainHeaderSubTabList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//div[contains(@class,'headingTabs')]//li//a[contains(@class,'disable-rightclk')]"));
	}

	public List<WebElement> plantsListUnderHomeSubTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}
	
	public List<WebElement> plantsListUnderMyPlantsMapSubTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}
	
	public List<WebElement>collectionListUnderMyPlantsMapSubTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}

	public WebElement tagLinkedTxt(WebDriver driver) {
		return driver.findElement(By.cssSelector(".boxBtn.requestBtn.plant-tag-btn"));
	}

	public WebElement tagAddedPopUpMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitTagAlertAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement getPlantQuantityFromCart(WebDriver driver) {
		return driver.findElement(By.cssSelector(".header-badges.ng-binding"));
	}

	public WebElement navigateToCart(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bucket-icon"));
	}
	
	
	//>>>>>>>>>>>>
	
	public List<WebElement> removePlantsFromCart(WebDriver driver) {
		return driver.findElements(By.xpath("//form[@name='tagsForm']//table//tbody//tr//td[5]//span[1]"));
	}
	
	public WebElement addButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Add']"));	
	}
	
	public WebElement submitTagPopupWindow(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Add'])[2]"));
	}
	
	public WebElement selectSearchCriteria(WebDriver driver) {
		return driver.findElement(By.id("search_criteria"));
	}
	
	public WebElement selectCollectionSearchCriteria(WebDriver driver) {
		return driver.findElement(By.id("search_collection_criteria"));
	}
	
	public WebElement verifySearchResult(WebDriver driver) {
		return driver.findElement(By.xpath("//tr[@class='ng-scope']//td[1]"));
	}
	
	public WebElement verifyNoPlantsFoundText(WebDriver driver) {
		return driver.findElement(By.xpath("//div[text()='No plants found for above search criteria.']"));
	}
	
	public WebElement selectTagStatus(WebDriver driver) {
		return driver.findElement(By.id("tag_status"));
	}
	
	public WebElement searchPlantName(WebDriver driver) {
		return driver.findElement(By.id("search_tag_plant"));
	}
	
	public WebElement clickOnFindBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Find']"));
	}
	
	public List<WebElement> getPlantsTitleList(WebDriver driver) {
		return driver.findElements(By.xpath("//tr[@class='ng-scope']//td[1]"));
	}

	public List<WebElement> getPlantsCheckBoxList(WebDriver driver) {
		return driver.findElements(By.xpath("//tr[@class='ng-scope']//b"));
	}
	
	
	public WebElement hideTagWindowView(WebDriver driver) {
		return driver.findElement(By.xpath("//b[@class='sprite crossIcon']"));
	}
	
	
	
	public List<WebElement> getTaggedPlantsTitleList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='titlename']//a"));
	}
	
	public WebElement updatePlantTitle(WebDriver driver, String plantTitle) {
		return driver.findElement(By.xpath("(//input[starts-with(@id,'input_') and @placeholder='Title' and @value='"+plantTitle+"'])[1]"));
	}

	public List<WebElement> getTaggedPlantQuantityList(WebDriver driver) {
		return driver.findElements(By.xpath("//input[@placeholder='Quantity']"));
	}

	public WebElement unableProductTagForAllPlants(WebDriver driver) {
		return driver.findElement(By.xpath("//select[@ng-model='productSelected']"));
	}

	public List<WebElement> getTaggedPlantSignValue(WebDriver driver) {
		return driver.findElements(By.xpath("//td[@class='table-border']//select[starts-with(@id,'tag_plant_')]"));
	}
	
	public List<WebElement> getTaggedPlantTemplate(WebDriver driver) {
		return driver.findElements(By.xpath("//select[starts-with(@id,'tag_plant') and contains(@id,'_template')]"));
	}
	
	public List<WebElement> getLineData(WebDriver driver, int indexing) {
		return driver.findElements(By.xpath("//input[starts-with(@id,'input_') and contains(@id,'line_"+indexing+"')]"));
	}
	
	public WebElement downloadExcel(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()=' Download Excel ']"));
	}
	
//	public List<WebElement> getLineSecondData(WebDriver driver) {
//		return driver.findElements(By.xpath("//input[starts-with(@id,'input_') and contains(@id,'line_2')]"));
//	}
//	
//	public List<WebElement> getLineThirdData(WebDriver driver) {
//		return driver.findElements(By.xpath("//input[starts-with(@id,'input_') and contains(@id,'line_3')]"));
//	}
//	
//	public List<WebElement> getLineFourthData(WebDriver driver) {
//		return driver.findElements(By.xpath("//input[starts-with(@id,'input_') and contains(@id,'line_4')]"));
//	}

	public WebElement saveAndProceedBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Save & Proceed']"));
	}

	public WebElement saveTagPage(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}
	
	public WebElement submitAlertForSaveBtn(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='simpleBtnWrap']//a)[1]"));
	}
	
	public WebElement enterContactName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.org_name']"));
	}

	public WebElement streetAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.street']"));
	}

	public WebElement city(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.city']"));
	}

	public WebElement state(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.state']"));
	}

	public WebElement zipCode(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.zip_code']"));
	}

	public WebElement shippingAsBilling(WebDriver driver) {
		return driver.findElement(By.id("copy_address"));
	}

	public WebElement enterEmailAddress(WebDriver driver) {
		return driver.findElement(By.id("order_email"));
	}

	public WebElement enterPhoneNumber(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='orderFormData.phone']"));
	}

	public WebElement selectCustomLogo(WebDriver driver) {
		return driver.findElement(By.id("custom_txt_select"));
	}

	public List<WebElement> getAdditionalTagPriceList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='numeric-numtext']"));
	}

	public List<WebElement> getAdditionalTagQuantityList(WebDriver driver) {
		return driver.findElements(By.xpath("//input[@placeholder='Quantity']"));
	}

	public WebElement getAluminumStackSum(WebDriver driver) {
		return driver.findElement(By.id("stake_sum"));
	}

	public WebElement getStackSum(WebDriver driver) {
		return driver.findElement(By.id("product_sum"));
	}

	public WebElement getTreeHardwareSum(WebDriver driver) {
		return driver.findElement(By.id("hardware_sum"));
	}

	public List<WebElement> getPlantsQuantityAndTagCost(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@class,'multiple-numtext ng-binding')]"));
	}

	public WebElement clickOnProceed(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Proceed']"));
	}

	public WebElement getPlaceOrderPrice(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='total']//following::span)[1]"));// (By.className("total-amt-text
																								// ng-binding"));
	}

	public WebElement shippingCharges(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Shipping']//following::span)[1]"));
	}

	public WebElement discountPercentage(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'Discount')]"));
	}

	public WebElement discountAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[contains(text(),'Discount')]//following::span)[1]"));
	}

	public WebElement customLogoAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[contains(text(),'Custom Logo')]//following::span)[1]"));
	}

	public WebElement placeOrder(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Place Order']"));
	}

	public WebElement updateSuccessfullyPlaceOrderPopUpMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitDonePlaceOrderAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement collections(WebDriver driver, String tagTypesName) {
		return driver.findElement(
				By.xpath("//div[@class='headingTabs ng-scope']//a[@href='/" + tagTypesName + "/collections']"));
	}

	public WebElement resources(WebDriver driver, String tagTypesName) {
		return driver.findElement(
				By.xpath("//div[@class='headingTabs ng-scope']//a[@href='/" + tagTypesName + "/resources']"));
	}

	public WebElement events(WebDriver driver, String tagTypesName) {
		return driver
				.findElement(By.xpath("//div[@class='headingTabs ng-scope']//a[@href='/" + tagTypesName + "/events']"));
	}

	public WebElement addNewTag(WebDriver driver) {
		return driver.findElement(By.xpath("//b[@class='sprite plusCrlIcon']"));// (By.linkText("
																				// Add
																				// New
																				// "));
	}

	public WebElement addOptionTag(WebDriver driver, String addOption) {
		if (addOption.contains("plant"))
			return driver.findElement(By.xpath("//div[@class='moveBoxHover']//a[contains(@title,'Plant')]")); //// div[@class='moveBoxHover']//a[@title='Plant']
		else if (addOption.contains("collection"))
			return driver.findElement(By.xpath("//div[@class='moveBoxHover']//a[contains(@title,'Collection')]"));
		else
			return driver.findElement(By.xpath("//div[@class='moveBoxHover']//a[@title='Event']"));
	}

	// Footer related
	public WebElement footerLinkOption(WebDriver driver, String footerOption) {
		return driver.findElement(By.xpath("//footer//a[@title='" + footerOption + "']"));
	}

	public WebElement headerTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='fixedLayout']/h1"));
	}

	public WebElement footerNewTabHeaderTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@itemprop='headline']"));
	}

	public WebElement footerSharingOption(WebDriver driver, String shareType) {
		return driver.findElement(
				By.xpath("//div[@class='socialLinks floatRight']//a[contains(@href,'" + shareType + "')]"));
	}

	public WebElement headerSharingOption(WebDriver driver, String sharingOpt) {
		return driver.findElement(By.xpath("//div[@class='floatLeft pos-relative']//a[@title='" + sharingOpt + "']"));
	}

	public WebElement facebookSignInAndSignUpRelatedAlertPop(WebDriver driver) {
		return driver.findElement(By.id("expanding_cta_login_button_large"));
	}

	public WebElement facebookEmailId(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}

	public WebElement facebookPass(WebDriver driver) {
		return driver.findElement(By.id("pass"));
	}

	public WebElement fbLogin(WebDriver driver) {
		return driver.findElement(By.id("loginbutton"));
	}

	public WebElement facebookLoginStatus(WebDriver driver) {
		return driver.findElement(By.id("fbRequestsJewel"));
	}

	public WebElement getPlantTitleOnFb(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='u_0_1g']//a[2]"));
	}

	public WebElement getPlantStoryOnFb(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='u_0_1g']//a[2]"));
	}

	public WebElement submitFacebookPost(WebDriver driver) {
		return driver.findElement(By.id("u_0_k"));
	}

	// *********************SignIn ****************************************

	public WebElement signInLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@title='Sign In']"));
	}
	
	public WebElement signInOrSignUpMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[text()='You need to sign in or sign up!']"));
	}

	public WebElement signInEmail(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//input[@id='emailBanner']"));
	}

	public WebElement signInPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//input[@name='password']"));
	}

	public WebElement errorMessageForSignIn(WebDriver driver, String errorFieldName) {
		if (errorFieldName.contains("email"))
			return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//div[@ng-show='emailRequired']"));
		else
			return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//div[@ng-show='passRequired']"));
	}

	public WebElement errorMessageForInvalidEmailId(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//div[@ng-show='emailFormat']"));
	}

	public WebElement submitSignIn(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='newSignin ng-scope']//input[@value='Sign In']"));
	}

	public WebElement signUpLink(WebDriver driver) {
		return driver.findElement(By.id("mobile_register"));
	}
	
	public WebElement signUpEmail(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@name='email'])[1]"));//(By.xpath("//div[@class='innerLogin-form']//input[@name='email']"));
	}

	public WebElement signUpPassword(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@name='password'])[1]"));//(By.xpath("//div[@class='innerLogin-form']//input[@name='password']"));
	}

	public WebElement errorMessageForSignUpReguiredField(WebDriver driver, String errorFieldName) {
		if (errorFieldName.contains("email"))
			return driver.findElement(By.xpath("//span[@class='validationBox' and @ng-show='emailRequired']"));
		else
			return driver.findElement(By.xpath("//span[@class='validationBox' and @ng-show='passRequired']"));
	}

	public WebElement errorMessageForSignUpRequiredFieldFormat(WebDriver driver, String errorFieldName) {
		if (errorFieldName.contains("email"))
			return driver.findElement(By.xpath("//span[@class='validationBox' and @ng-show='emailFormat']"));
		else
			return driver.findElement(By.xpath("//span[@class='validationBox' and @ng-show='passLenght']"));
	}

	public WebElement errorMessageForEmailAlreadyTaken(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@ng-show='serverErrors']"));
	}

	public WebElement submitExplorePageSignUpBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='innerLogin-form']//a[@ng-click='register()']"));
	}
	
	public WebElement submitHomeOrMainPageSignUpBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Sign Up']"));
	}

	public WebElement forgotPassword(WebDriver driver) {
		return driver.findElement(By.linkText("Forgot Password?"));
	}

	public WebElement forgotPasswordHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='head' and contains(text(),'Forgot Password')]"));
	}

	public WebElement forgotPasswordEmailId(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='forgotPopup']//input[@name='email']"));
	}

	public WebElement sendForgotPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='forgotPopup']//input[@value='Send']"));
	}

	public WebElement enterNewPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='change_password_data.user.password']"));
	}

	public WebElement enterConfirmPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='change_password_data.user.password_confirmation']"));
	}

	public WebElement clickonResetButton(WebDriver driver) {
		return driver.findElement(By.linkText("Reset"));
	}

	public WebElement verifyPasswordResetMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='simpleTextWrap']//p"));
	}

	public WebElement submitPasswordResetPopUp(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='simpleTextWrap']//a"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Add
	// New Plant
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement addNewPlantCollectionOrganizationProfileHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='fixedLayout']//h2[starts-with(@class,'title')]"));// div[@class='fixedLayout']//h2[@class='title']
	}

	public WebElement editButton(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='floatRight']//a[@ng-click='gotoEdit()']"));
	}

	public WebElement addRemoveToCollectionBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Add/Remove to Collection']"));
	}
	
	public WebElement addRemoveCollectionHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[text()='Add/Remove to']"));
	}
	
	public List<WebElement> getCollectionList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='setParentWrap ng-scope']/label[1]//span[@class='labelText ng-binding']"));
	}
	
	public WebElement clickOnUpdateCollectionButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Update']"));
	}
	
	public WebElement getPlantCreatedDate(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='subdate-txt ng-binding']"));
	}
	
	
	public WebElement clickOnSortBy(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='sortBoxWrap']//a//p"));
	}
	
	public List<WebElement> getSortTypeList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBoxHover sortByTitleDate']//li//a"));
	}
	
	public WebElement addPlantTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='title']"));
	}

	public WebElement errorMessageForTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@ng-if='titleRequire']"));
	}

	public WebElement addPlantCollectionOrganizationDescription(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));
	}

	public WebElement boldButton(WebDriver driver) {
		return driver.findElement(By.className("jqte_tool jqte_tool_4 unselectable"));
	}

	public WebElement italicButton(WebDriver driver) {
		return driver.findElement(By.className("jqte_tool jqte_tool_5 unselectable"));
	}

	public WebElement clearFormattingButton(WebDriver driver) {
		return driver.findElement(By.linkText("Clear Formatting"));
	}

	public WebElement verifyImageDimensionFormat(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Recommended photo size: 900 px x 900 px')]"));
	}

	public WebElement addPlantCollectionOrganizationImage(WebDriver driver) {
		return driver.findElement(By.id("file"));
	}

	public WebElement addPlantsPhotos(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='customUploadBtn']//input[@name='file']"));
	}

	public WebElement addPhotoCaption(WebDriver driver) {
		return driver.findElement(By.name("photo_caption"));
	}

	public WebElement uploadPhoto(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Upload']"));
	}

	public List<WebElement> photosList(WebDriver driver) {
		return driver.findElements(By.xpath("//ul[@id='edit-images-ul']//li//a"));
	}

	public WebElement updatePhotoCaption(WebDriver driver) {
		return driver.findElement(By.xpath("//textarea[@placeholder='Enter Photo Caption']"));
	}

	public WebElement clickOnUpdateCaption(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Update']"));
	}

	public WebElement hideEditPhotoPopUp(WebDriver driver) {
		return driver.findElement(By.cssSelector(".sprite.crossIcon"));
	}

	// notes related >>>>>>>>>>>..
	public WebElement clickOnAddNotesButton(WebDriver driver) {
		return driver.findElement(By.cssSelector(".addNoteClickBtn.boxBtn.greenColor.ng-scope"));
	}

	public WebElement notesVisibility(WebDriver driver, String visibilityType) {
		if (visibilityType.equalsIgnoreCase("public"))
			return driver.findElement(By.xpath("(//label[@id='publicToggle'])[2]"));
		else
			return driver.findElement(By.xpath("(//label[@id='privateToggle'])[2]"));
	}
	
	public WebElement savePlantsNotes(WebDriver driver) {
		return driver.findElement(By.cssSelector(".saveNoteClickBtn.boxBtn.boxOrg"));
	}

	public WebElement verifyNotesTitleRequired(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@ng-if='noteTitleRequire']"));
	}

	public WebElement verifyNotesDescriptionRequired(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@ng-if='noteDescriptionRequire']"));
	}

	public WebElement addNotesTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@name='plantNoteForm']//input[@name='title']"));
	}

	public WebElement addNotesDescription(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='notesAddTemplete']//div[@class='jqte_editor']"));
	}

	public WebElement getNotesTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//h4[@class='notesTemplete-head ng-binding']"));
	}

	public WebElement getNotesDescription(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='notesTemplete-text ng-binding']"));
	}

	public WebElement writeComment(WebDriver driver) {
		return driver.findElement(By.xpath("//textarea[@placeholder='Write a comment...']"));
	}

	public WebElement submitPlantsComment(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Send'])[1]"));
	}

	public WebElement getPlantCommentMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='viewComments-content']//p"));
	}

	// Plants Details Tab
	public WebElement botanicalName(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Botanical Name']//following::input)[1]"));
	}

	public WebElement commanName(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Common Name(s)']//following::input)[1]"));
	}

	public WebElement synonymsName(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Synonym(s)']//following::input)[1]"));
	}

	public WebElement tradeName(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Trade Name(s)']//following::input)[1]"));
	}

	public WebElement classOrTypeName(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Class or Type']//following::input)[1]"));
	}

	// Category
	public List<WebElement> categoryList(WebDriver driver) {
		return driver.findElements(By.xpath("(//li[@class='categoryListWrap'])[1]//label//span"));
	}

	public List<WebElement> categoryCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("(//li[@class='categoryListWrap'])[1]//label//b"));
	}

	// Owner Information
	public WebElement accessionCode(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Accession Code']//following::input)[1]"));
	}

	public WebElement dateAcquired(WebDriver driver) {
		return driver.findElement(By.id("owner_dateacquired"));
	}

	public WebElement acquiredFromSource(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Acquired From Source']//following::textarea)[1]"));
	}

	public WebElement datePlanted(WebDriver driver) {
		return driver.findElement(By.id("owner_dateplanted"));
	}

	public WebElement quantity(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='quantity']"));
	}
	
	public WebElement verifyQuantityErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[text()='It must be numeric.']"));
	}

	public WebElement statusNote(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[text()='Status Note']//following::textarea)[1]"));
	}

	public WebElement status(WebDriver driver, String statusValue) {
		List<WebElement> list = driver.findElements(By.xpath("(//input[@value='Alive']//following::b)"));
		if (statusValue.equalsIgnoreCase("Alive"))
			return  list.get(0);
		else if (statusValue.equalsIgnoreCase("Dead"))
			return list.get(1);
		else
			return list.get(2);
	}

	public WebElement plantHeight(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@placeholder='height'])[1]"));
	}

	public WebElement plantWidth(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@placeholder='width'])[1]"));
	}

	public WebElement plantDiameter(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@placeholder='diameter'])[1]"));
	}

	public WebElement plantSizUnit(WebDriver driver) {
		return driver.findElement(By.xpath("//select[@ng-model='owner_information.unit']"));
	}

	public WebElement refrenceLinkTitle(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@placeholder='Title'])[1]"));
	}

	public WebElement refrenceLinkUrl(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@placeholder='URL'])[1]"));
	}
	
	public List<WebElement> plantsScientificTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='formAllArea activeScientificToggle']//label"));
	}
	
	public List<WebElement> fillPlantScientificValue(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='formAllArea activeScientificToggle']//input"));
	}
	
	// Plant Growing Details
	// Sun Preferences
	public List<WebElement> chooseSunPreferencesValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='sun in suns']//span"));
	}
	
	public List<WebElement> chooseSunPreferencesCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='sun in suns']//b"));
	}
	
	// Interior Light
	public List<WebElement> chooseInteriorValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='light in lights']//span"));
	}
	
	public List<WebElement> chooseInteriorCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='light in lights']//b"));
	}
	
	// Soil Preferences
	public List<WebElement> chooseSoilPreferencesValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='soil in soils']//span"));
	}
	
	public List<WebElement> chooseSoilPreferencesCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='soil in soils']//b"));
	}
	
	// Ph Preferences
	public List<WebElement> choosePhPreferencesValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='ph in phs']//span"));
	}
	
	public List<WebElement> choosePhPreferencesCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='ph in phs']//b"));
	}
	
	// Water Requirement
	public List<WebElement> chooseWaterRequirementValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='water in waters']//span"));
	}
	
	public List<WebElement> chooseWaterRequirementCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='water in waters']//b"));
	}
	
	// USDA Hardiness Zone
	public WebElement selectUsdaHardinessZone(WebDriver driver, String zoneValue) {
		if (zoneValue.contains("start")) 
			return driver.findElement(By.xpath("//select[@ng-model='growing_information.us_range_start']"));
		else
			return driver.findElement(By.xpath("//select[@ng-model='growing_information.us_range_end']"));
	}
	
	// Native Range
	public WebElement nativeRange(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='growing_information.native_range']"));
	}
	
	// Native Habitat
	public List<WebElement> chooseNativeHabitatValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='habitat in habitats']//span"));
	}
	
	public List<WebElement> chooseNativeHabitatCheckboxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='habitat in habitats']//b"));
	}
	
	// *********************** Growing Information *****************************************
	public WebElement dayToHarvest(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@id='dateplanted'])[1]"));
	}
	
	public WebElement seedGermination(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@id='dateplanted'])[2]"));
	}
	
	public WebElement avgMinHeight(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='average_height']"));
	}
	
	public WebElement avgMaxHeight(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='max_average_height']"));
	}
	
	public WebElement selectHeightUnit(WebDriver driver) {
		return driver.findElement(By.xpath("(//select[@ng-model='growing_information.size_unit'])[1]"));
	}
	
	public WebElement avgMinWidth(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='average_width']"));
	}
	
	public WebElement avgMaxWidth(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='max_average_width']"));
	}
	
	public WebElement selectAvgWidth(WebDriver driver) {
		return driver.findElement(By.xpath("(//select[@ng-model='growing_information.size_unit'])[2]"));
	}
	
	public WebElement spacingHeight(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='spacing_height']"));
	}
	
	public WebElement spacingWidth(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='spacing_width']"));
	}
	
	public WebElement selectAvgSpacing(WebDriver driver) {
		return driver.findElement(By.xpath("//select[@ng-model='growing_information.spacing_unit']"));
	}
	
	public List<WebElement> errorMessagesListForHeightWidthValidation(WebDriver driver) {
		return driver.findElements(By.xpath("//div[contains(text(),'must be numeric.')]"));
	}
	
	public WebElement flowerColor(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='growing_information.flower_color']"));
	}
	
	public List<WebElement> floweringValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='name in month_names']//span"));
	}
	
	public List<WebElement> floweringCheckBoxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='name in month_names']//b"));
	}
	
	public WebElement foliageColor(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-model='growing_information.foliage_color']"));
	}
	
	public List<WebElement> plantAttributeValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='feature in plant_features']//span"));
	}
	
	public List<WebElement> plantAttributeCheckBoxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='feature in plant_features']//b"));
	}
	
	public List<WebElement> toleratesValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='tolerate in tolerates']//span"));
	}
	
	public List<WebElement> toleratesCheckBoxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='tolerate in tolerates']//b"));
	}
	
	public List<WebElement> attractsValue(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='attract in attracts']//span"));
	}
	
	public List<WebElement> attractsCheckBoxes(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@ng-repeat='attract in attracts']//b"));
	}
	
	public List<WebElement> getPlantInformationTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info plant-info-tab floatLeft']//li//p[1]"));
	}
	
	public List<WebElement> getPlantInformationValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info plant-info-tab floatLeft']//li//p[2]"));
	}
	
	public List<WebElement> getPlantOwnerInformationTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info owner-info-tab floatLeft activeToggleClick']//li//p[1]"));
	}
	
	public List<WebElement> getPlantOwnerInformationValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info owner-info-tab floatLeft activeToggleClick']//li//p[2]"));
	}
	
	public List<WebElement> getPlantScientificClassificationTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info taxonomic-tab floatLeft activeScientificToggle']//li//p[1]"));
	}
	
	public List<WebElement> getPlantScientificClassificationValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info taxonomic-tab floatLeft activeScientificToggle']//li//p[2]"));
	}
	
	public List<WebElement> getPlantGrowingPreferenceTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info preference-tab floatLeft']//li//p[1]"));
	}
	
	public List<WebElement> getPlantGrowingPreferenceValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info preference-tab floatLeft']//li//p[2]"));
	}
	
	public List<WebElement> getPlantGrowingInformationTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info growing-info-tab floatLeft']//li//p[1]"));
	}
	
	public List<WebElement> getPlantGrowingInformationValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info growing-info-tab floatLeft']//li//p[2]"));
	}
	
	public List<WebElement> getPlantTabManagerTextLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info floatLeft']//p[1]"));
	}
	
	public List<WebElement> getPlantTabManagerValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='viewDetailBox-info floatLeft']//p[2]"));
	}
	
	public WebElement getCatgeoryList(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[text()='Category']//following::p)[1]"));
	}

	public WebElement addCoverPhoto(WebDriver driver) {
		return driver.findElement(By.id("resourceFile"));
	}

	public WebElement addAddress(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//input[@placeholder='Enter address then choose from list. Click Pin Location to fine tune location']"));
	}

	public WebElement suggestedAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//li[starts-with(@id,'ui-id-')]"));
	}

	public WebElement pinYourLocation(WebDriver driver) {
		return driver.findElement(By.id("addToMarkerBtn"));
	}

	public WebElement submitYourPinPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//a[.='Add']"));
	}

	public WebElement makeYourLocationTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='plant-privacy-text']"));
	}

	public WebElement makeLocationPublic(WebDriver driver) {
		return driver.findElement(By.id("publicToggle"));
	}

	public WebElement makeLocationPrivate(WebDriver driver) {
		return driver.findElement(By.id("privateToggle"));
	}

	public WebElement cancelButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@ng-plantsmap-back='' and @value='Cancel']"));
	}

	public WebElement nextButton(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@class='formBtn']//input[@value='Next']"));
	}

	public WebElement savePlantCollectionOrganizationPage(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@class='defaultBtn greenColor' and @value='Save']"));
	}

	public WebElement deleteButton(WebDriver driver) {
		return driver.findElement(By.xpath("//li[contains(@class,'formBtn')]//input[@value='Delete']"));// (By.xpath("//li[@class='formBtn']//input[@value='Delete']"));
	}

	public WebElement deletePlantDetailPopUpMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitPlantDeleteAlertPopUpBox(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement updateSuccessfullyPlantDetailPopUpMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitDonePlantAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement addMoreDetial(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='modalPopLite-wrapper11']//a[2]"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Sorting
	// type>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement plantViewType(WebDriver driver, String sortType) {
		if (sortType.contains("grid"))
			return driver.findElement(By.xpath("//a[@title='Grid view']"));
		else
			return driver.findElement(By.xpath("//a[@title='List view']"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Plant Detail
	// Page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement getPlantTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@class='ng-binding']"));
	}

	public WebElement plantCreatedBy(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='ng-binding']"));
	}

	public WebElement getPlantCreationDate(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='subdate-txt ng-binding']"));
	}

	public WebElement getPlantsStory(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-bind-html='plant.story']"));
	}
	
	public WebElement viewMoreBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='viewMoreLink ng-scope' and contains(text(),'View More')]"));
	}
	
	public WebElement viewMorePlants(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='plants.length > 0']/a"));
	}
	public WebElement viewMoreCollections(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='collections.length > 0']/a"));
	}
	public WebElement viewMoreOrganization(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='organizations.length > 0' or @ng-if='communities.length > 0']/a"));
	}
	public WebElement viewMoreNews(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='feeds.length != 0']/a"));
	}
	
	public WebElement viewLessBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='viewMoreLink ng-scope' and contains(text(),'View Less')]"));
	}
	
	public WebElement getPlantPhysicalAddess(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='plant.location']//div[contains(@ng-if,'myPlant')]"));
	}

	public WebElement getPlantsLocation(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-if='plant.location']//div[contains(@ng-if,'myPlant')]"));
	}
	
	public WebElement getPlantPrivateLocation(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='ng-scope' and contains(text(),'Location is private ')]"));
	}

	public WebElement getPlantBlankAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Location is not added')]"));
	}

	public WebElement getMapViewStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='mapWrap']"));
	}

	public WebElement getLikeCount(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='gradientBg']//span"));
	}

	public WebElement getPlantDetailTabs(WebDriver driver, String tabType) {
		return driver.findElement(By.xpath("//ul[@class='plantsDetailTab']//a[@title='" + tabType + "']"));
	}

	public WebElement selectPlant(WebDriver driver, String plantTitleName) {
		return driver
				.findElement(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'" + plantTitleName + "')]"));
	}

	public WebElement selectPlantUnderPlantTab(WebDriver driver, String plantTitleName) {
		return driver.findElement(By.xpath("//p[@title='" + plantTitleName + "']//a"));
	}

	public List<WebElement> getPlantListFromUserProfilePage(WebDriver driver) {
		return driver.findElements(By.cssSelector("div#myPlantCarousel a.ng-binding"));
	}
	
	public List<WebElement> getCollectionsListFromUserProfilePage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'/collections/')]"));
	}
	
	public List<WebElement> getOrgListFromUserProfilePage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'/organizations/')]"));
	}
	
	public WebElement selectPlantFromGridView(WebDriver driver, String plantTitleName) {
		return driver.findElement(By.xpath("//p[@title='" + plantTitleName + "']//a"));
	}
	
	public List<WebElement> getPlantsTitleListForTag(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p"));
	}

	public List<WebElement> getCommunityList(WebDriver driver, String orgName) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a[contains(text(),'"+orgName+"')]"));
	}
	
	public WebElement verifyOrganizationPageLoaded(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='resources-heading ng-scope']//h1"));
	}
	
	public WebElement selectPlantFromListView(WebDriver driver, String plantTitleName) {
		return driver.findElement(
				By.xpath("//tr[@class='ng-scope']//td[2]//a[contains(@href,'" + plantTitleName.toLowerCase() + "')]"));
	}

	public WebElement editAndViewOption(WebDriver driver, String plantTitleName) {
		return driver.findElement(
				By.xpath("//div[@class='moveBox-title']//a[contains(@href,'" + plantTitleName + "')]/following::a[1]"));
	}

	public WebElement viewLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@title='View']"));
	}

	public WebElement editLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@title='Edit']"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// plants sub
	// tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement selectPlantSubTab(WebDriver driver, String tabName) {
		if (tabName.contains("photos"))
			return driver.findElement(By.xpath("(//a[@title='Photo'])[1]"));
		else if (tabName.contains("plant detail"))
			return driver.findElement(By.xpath("(//a[@title='Plant Detail'])[1]"));
		else if (tabName.contains("growing detail"))
			return driver.findElement(By.xpath("(//a[@title='Growing Detail'])[1]"));
		else if (tabName.contains("notes"))
			return driver.findElement(By.xpath("(//a[@title='Note'])[1]"));
		else if (tabName.contains("comment"))
			return driver.findElement(By.xpath("(//a[@title='Comments'])[1]"));
		else if (tabName.contains("tab"))
			return driver.findElement(By.xpath("(//a[@title='Tab'])[1]"));
		else
			return null;
	}

	public WebElement selectTabFromPlantsSubTabList(WebDriver driver, String tabName) {
		return driver.findElement(By.xpath("(//a[@title='" + tabName + "'])[1]"));
	}

	public List<WebElement> getAddedTabFieldsName(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@class='fillInfobox-label ng-binding']"));
	}

	public List<WebElement> fillAddedTabFieldsName(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='categoryListWrap custom-tabs-panel ng-scope']//input"));
	}
	
	public WebElement fillTabManagerTextAreaFields(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@class='ng-scope']//textarea"));//(By.xpath("//textarea[@class='fillInfobox-feild ng-pristine ng-valid ng-scope ng-touched']"));
	}

	public WebElement addPostPhoto(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Add Photos']"));
	}

//	public WebElement addComment(WebDriver driver) {
//		return driver.findElement(By.xpath("//textarea[@placeholder='Write a comment...']"));
//	}

//	public WebElement submitComment(WebDriver driver) {
//		return driver.findElement(By.xpath(".//*[@id='edit_plant_col_tab']//input"));
//	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Collection
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement addNewCollectionHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='fixedLayout']//h2[@class='title']"));
	}

	public WebElement editCollectionSubCollectionButton(WebDriver driver) {
		return driver.findElement(By.xpath("//b[@class='sprite editPencilIcon']"));
	}

	public WebElement deleteCollection(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[contains(@id,'collection-edit')]//a[@class='boxBtn boxRed callDeleteMsg disable-rightclk']"));
	}

	public WebElement addCollectionName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='name']"));
	}

	public WebElement errorMessageForCollectionName(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@ng-if='collectionNameRequire']"));
	}

	public WebElement addCollectionDescription(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));// (By.xpath("//div[@class='jqte_editor'][1]"));
	}

	public WebElement addCollectionImage(WebDriver driver) {
		return driver.findElement(By.id("file"));
	}

	public WebElement collectionNextButton(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@class='formBtn']//input[@value='Next']"));
	}

	public List<WebElement> selectCollection(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'collection')]"));
	}

	public List<WebElement> selectCollectionUnderCollectionTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']/p/a"));
	}

	public List<WebElement> selectSubCollection(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'collection')]"));
	}

	// Get Added Collection details
	public WebElement getCollectionTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@class='ng-binding']"));//("//h1[@class='hideon-mobile ng-binding']"));
	}

	public WebElement collectionCreatedBy(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='noteLayout']//u"));
	}

	public WebElement getCollectionDescription(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(@ng-bind-html,'collection.description')]"));
	}

	public WebElement getCollectionPhysicallAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='selectProduct-Detils']//div[contains(@class,'ng-binding')]"));
	}

	public WebElement selectCollectionSubCollectionSubTabs(WebDriver driver, String tabName) {
		if (tabName.contains("subcol"))
			return driver.findElement(By.xpath("//ul[contains(@class,'plantsDetailTab')]//a[@title='Subcollections']"));
		else if (tabName.contains("photo"))
			return driver.findElement(By.xpath("//ul[contains(@class,'plantsDetailTab')]//a[@title='Photos']"));
		else if (tabName.contains("plant"))
			return driver.findElement(By.xpath("//ul[contains(@class,'plantsDetailTab')]//a[@title='Plants']"));
		else if (tabName.contains("note"))
			return driver.findElement(By.xpath("//ul[contains(@class,'plantsDetailTab')]//a[@title='Note']"));
		else
			return driver.findElement(By.xpath("//ul[contains(@class,'plantsDetailTab')]//a[@title='Map']"));
	}

	public List<WebElement> getSubCollectionListInsideSubCollectionTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate']//p[@class='ng-binding']"));
	}
	
	public List<WebElement> selectSubCollectionFromSubCollectionList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate']"));
	}
	
	public List<WebElement> getPlantListInsidePlantTabUnderSubCollectionDetailPage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}
	
	public List<WebElement> getPlantListUnderPlantFromCollectionPage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Collection Plants
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement collectionAddRemovePlants(WebDriver driver) {
		return driver.findElement(By.cssSelector(".addToPlant.boxBtn.boxYellow.disable-rightclk.ng-scope"));
	}

	public WebElement verifyAddRemovePlantsPopUp(WebDriver driver) {
		return driver.findElement(By.cssSelector(".modalPopup-title>h2"));
	}

	public WebElement verifyPlantsExistance(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='emptyBox-info ng-scope']//p"));//(By.cssSelector(".emptyBox-info ng-scope>p"));
	}

	public WebElement clickOnAddPlant(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='defaultBtn greenColor']"));
	}
	
	public WebElement clickOnAddCollection(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='defaultBtn greenColor']"));
	}


	public List<WebElement> getPlantsList(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@class='ng-scope']//span[@class='labelText ng-binding']"));
	}
	
//	public List<WebElement> getPlantsListUnderPlantTabInsideCollectionSubCollectionTab(WebDriver driver) {
//		return driver.findElements(By.xpath("//label[@class='ng-scope']//span[@class='labelText ng-binding']"));
//	}

	public WebElement clickOnUpdate(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='addtoPlantModal']//input[@class='defaultBtn greenColor']"));//(By.xpath("(//input[@value='Update'])[2]"));
	}
	
	public WebElement getCollectionNameFromPlantDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='collectionClick coll-text ng-binding']"));
	}

	public List<WebElement> getPlantListFromPlantTabInCollSubColl(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}

	public WebElement verifyNoPlantText(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'There are no plants added yet.')]"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// SubCollection
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement createSubCollection(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='subcol_tab']//a[@ng-if='isUserCollection']"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// SubCollection detail page
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement getSubCollectionTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@class='ng-binding']"));//("//div[@class='fixedLayout']//h3[@class='sub-coll-heading ng-binding']"));
	}

	public WebElement getCollectionNameFromSubCollectionDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("(//u[@class='ng-binding'])[2]"));//(By.xpath("//div[@class='fixedLayout']//h3//a"));
	}

	public WebElement verifyCollectionSubCollectionSuccessfullyAddedAlertMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement doneCollectionSubCollectionAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public List<WebElement> verifyCollectionSubCollectionDeleteAlertMessage(WebDriver driver) {
		return driver
				.findElements(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public List<WebElement> submitDoneButtonForSuccessfullyDeletedCollectionSubCollection(WebDriver driver) {
		return driver.findElements(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Organization
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement addOrganizationLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@title='Add Organization']"));
	}

	public WebElement getOrganizationName(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='organ-image-heading ng-binding']"));
	}

	public WebElement editOrganization(WebDriver driver) {
		return driver.findElement(By.id("changeBtn"));
	}

	public WebElement manageNetwork(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Manage Network']"));
	}
 	
	public List<WebElement> getUserListForNetworkRequest(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@ng-repeat='member in members']//h2"));
	}
	
	public List<WebElement> userRequestLabel(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='controlBox']//input[@value='Requested']"));
	}
	
	public List<WebElement> selectOrgFromCommunity(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='moveBox-title']//a[contains(@href,'organization')]"));
	}

	public WebElement deleteOrg(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='right-flt ng-scope']/a"));
	}

	public WebElement submitDeleteOrgPopUp(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement requestDeletedLinkedText(WebDriver driver) {
		return driver.findElement(By.linkText("Requested Delete"));
	}

	public WebElement eventTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//fieldset[@id='eventDate']//li[1]/input"));
	}

	public WebElement eventPrice(WebDriver driver) {
		return driver.findElement(By.id("event_price"));
	}

	public WebElement enterEventStartDate(WebDriver driver) {
		return driver.findElement(By.id("eventStartDate"));
	}

	public WebElement datePickerDayPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='datepicker-days']"));
	}

	public WebElement enableEventStartTime(WebDriver driver) {
		return driver.findElement(By.id("eventStartTime"));
	}

	public List<WebElement> selectRandomDayValue(WebDriver driver) {
		return driver.findElements(By.xpath("//td[@class='day']"));
	}

	public WebElement getActiveDayValue(WebDriver driver) {
		return driver.findElement(By.xpath("//td[@class='active day']"));
	}

	public List<WebElement> selectRandomTimeValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='ui-timepicker-am' or @class='ui-timepicker-pm']"));
	}

	public WebElement enableEventEndTime(WebDriver driver) {
		return driver.findElement(By.id("eventEndTime"));
	}

	public WebElement enterEventEndDate(WebDriver driver) {
		return driver.findElement(By.id("eventEndDate"));
	}

	public WebElement visibleEventCategoryList(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Select Event Categories']"));
	}

	public List<WebElement> eventCategoryList(WebDriver driver) {
		return driver.findElements(By.cssSelector(".chosen-results li"));
	}

	public WebElement recurringEvent(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[@class='create-recrr cmFeildWrap fillInfobox-checkWrap create-checkbox-panel']//label//input"));// cssSelector(".create-recrr.cmFeildWrap.fillInfobox-checkWrap.create-checkbox-panel>label>input"));
	}

	public WebElement reccurringEventCheckBox(WebDriver driver) {
		return driver.findElement(
				By.cssSelector(".create-recrr.cmFeildWrap.fillInfobox-checkWrap.create-checkbox-panel>label>b"));
	}

	public WebElement selectRepeatEventDropDown(WebDriver driver) {
		return driver.findElement(By.id("event_schedule_attributes_rule"));
	}

	public WebElement endsWithOccureanceOrDate(WebDriver driver, String endsType) {
		if (endsType.equalsIgnoreCase("occurrence"))
			return driver.findElement(By.xpath("//input[@value='count']"));
		else
			return driver.findElement(By.xpath("//input[@value='until']"));
	}

	public WebElement endsWithOccurenceCheckBox(WebDriver driver) {
		return driver
				.findElement(By.xpath("(//div[@class='fillInfobox-radioWrap cmFeildWrap create-radio-left']//b)[1]"));
	}

	public WebElement eneterOccurrenceValue(WebDriver driver) {
		return driver.findElement(By.id("event_schedule_attributes_count"));
	}

	public List<WebElement> selectWeekdays(WebDriver driver) {
		return driver.findElements(By.cssSelector(".ng-scope>b"));// xpath("//label[@class='ng-scope']//input[starts-with(@id,'event_schedule_attributes_day_')]"));
	}

	public List<WebElement> selectMonthDays(WebDriver driver, String weekday) {
		return driver.findElements(By.xpath("//input[starts-with(@id,'event_schedule_attributes_day_of_week_" + weekday
				+ "_')]//following-sibling::b"));
	}

	public WebElement promoteToExplore(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[@class='cmFeildWrap fillInfobox-checkWrap create-checkbox-panel']//label//input"));
	}

	public WebElement searchEventByTitle(WebDriver driver) {
		return driver.findElement(By.id("search_title"));
	}

	public WebElement searchEventByLocation(WebDriver driver) {
		return driver.findElement(By.id("search_location"));
	}

	public WebElement searchEventByState(WebDriver driver) {
		return driver.findElement(By.id("search_state"));
	}

	public WebElement clickResetSearch(WebDriver driver) {
		return driver.findElement(By.linkText("Reset Search"));
	}

	public WebElement submitEventSearchButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Search']"));
	}

	public WebElement noEventTxt(WebDriver driver) {
		return driver.findElement(By.cssSelector(".empty-event.no-event-line.ng-scope"));
	}

	public List<WebElement> getEventList(WebDriver driver) {
		return driver.findElements(By
				.xpath("//div[@class='postcard-view-panel ng-scope']//div//div[@class='cal-postcard-mainheading']//a"));
	}

	public WebElement getEventName(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='event-details-heading ng-binding']"));
	}

	public WebElement getEventPrice(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//div[@class='details-location-link-panel ng-scope']//span[@class='ng-binding'])[1]"));// (By.xpath("//div[@class='details-location-link-panel
																													// ng-scope']//span[@class='ng-binding']"));
	}

	public WebElement getEventCategory(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//div[@class='details-location-link-panel ng-scope']//span[@class='ng-binding'])[2]"));
	}

	public WebElement getEventAddress(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[@class='details-location-text-panel ng-scope']//span[@class='ng-binding']"));
	}
	
	public WebElement getEventTime(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='event-detail-date ng-binding']"));
	}

	public WebElement eventDeleteBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[.='Delete']"));
	}

	public WebElement eventDeleteAlertMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitRecurringApplyEvent(WebDriver driver, String applyOn) {
		if (applyOn.equalsIgnoreCase("this event"))
			return driver.findElement(By.xpath("(//button[@class='events-apply-event-div'])[1]"));
		else
			return driver.findElement(By.xpath("(//button[@class='events-apply-event-div'])[2]"));
	}

	public WebElement submitEventDeleteAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement clickOnMonthPreviousArrow(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='cal-month-div']//div)[1]"));
	}
	
	public WebElement getMonthValue(WebDriver driver) {
		return driver.findElement(By.id("calendar_name"));
	}
	
	public List<WebElement> getEventMonthValues(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='cal-postmonth ng-binding']"));
	}
	
	public WebElement clickOnMonthNextArrow(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='cal-month-div']//div)[2]"));
	}
	
	public WebElement clickOnYearPreviousArrow(WebDriver driver) {
		return driver.findElement(By.id("cal-left-arrow-year"));
	}
	
	public WebElement getYearValue(WebDriver driver) {
		return driver.findElement(By.id("calendar_year"));
	}
	
	public WebElement getDateValueFromEventDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='detail-day-text ng-binding ng-scope']"));
	}
	
	public WebElement clickOnYearNextArrow(WebDriver driver) {
		return driver.findElement(By.id("cal-right-arrow-year"));
	}
	
	public List<WebElement> getPagingList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@ng-repeat='page in pages track by $index']//a"));
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// profile related identifier
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public WebElement clickOnArrowButton(WebDriver driver) {
		return driver.findElement(By.xpath("//b[@class='sprite downArrow']"));
	}

	public WebElement getProfileType(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='profilePic']//p"));
	}

	public WebElement addOrganization(WebDriver driver) {
		return driver.findElement(By.linkText("Add Organization"));
	}

	public WebElement myProfileLinkedTxt(WebDriver driver) {
		return driver.findElement(By.linkText("My Profile"));
	}

	public WebElement selectDefaultOrganization(WebDriver driver) {
		return driver.findElement(By.linkText("Hitesh_Org"));
	}

	public List<WebElement> getOrganizationList(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@title='Organization']"));
	}

	public WebElement imageDimensionFormatForCoverPhotoOrg(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Recommended size: 1538 px x 535 px']"));
	}
	
	public WebElement imageDimensionFormatForProfileOrg(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Recommended size: 900 px x 900 px')]"));
	}
	
	public WebElement logoutButton(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@ng-click='logout()']"));
	}

	public WebElement myProfileHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='fixedLayout']//h1[starts-with(@class,'title')]"));
	}

	public WebElement myProfileHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@class='title ng-binding' and contains(text(),'My Profile')]"));
	}
	
	public WebElement myProfileEditHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[@class='title ng-binding' and contains(text(),'Edit')]"));
	}
	
	public List<WebElement> myProfilePercentage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='profile-percentage ng-binding']"));
	}
	
	public WebElement getUserPlantCountFromWeb(WebDriver driver) {
		return driver.findElement(By.xpath("((//div[@class='inner-div'])[2]//span[@class='number ng-binding'])[1]"));
	}
	
	public WebElement getUserNetworkCountFromWeb(WebDriver driver) {
		return driver.findElement(By.xpath("((//div[@class='inner-div'])[2]//span[@class='number ng-binding'])[3]"));
	}
	
	public WebElement getOrgPlantCountFromWeb(WebDriver driver) {
		return driver.findElement(By.xpath("((//div[@class='inner-div']//div)[1]//span[@class='number ng-binding'])[1]"));
	}
	
	public WebElement getOrgCollectionCountFromWeb(WebDriver driver) {
		return driver.findElement(By.xpath("((//div[@class='inner-div']//div)[1]//span[@class='number ng-binding'])[2]"));
	}

	public WebElement myProfileEditLinkedTxt(WebDriver driver) {
		return driver.findElement(By.linkText("Edit"));
	}

	public WebElement myProfileLastName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement errorMessageForBlankProfileField(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='validation']"));
	}

	public WebElement aboutMe(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));
	}

	public WebElement profileCoverPhoto(WebDriver driver) {
		return driver.findElement(By.id("file"));// (By.className("profileImg"));
	}

	public WebElement myProfileSaveBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}

	public WebElement myProfileAlertMessage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//p"));
	}

	public WebElement submitMyProfileAlert(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[starts-with(@id,'modalPopLite-wrapper') and contains(@style,'top')]//a[1]"));
	}

	public WebElement windowPopUpForAddPlantOrgOnProfileSubmit(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='saveProfileBox']//div[@class='success-message ng-scope']"));
	}
	
	public WebElement continueMyProfileLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Continue to My Profile page']"));
	}

	public List<WebElement> communitiesProfileList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//div[@class='boxTemplate-title']/p//a[not(contains(@ng-href,'/organization'))]"));
	}

	public WebElement profileFollowBtn(WebDriver driver) {
		return driver.findElement(By.xpath("(//a[@class='followMe ng-scope'])[2]"));
	}
	
	public WebElement orgConnectBtn(WebDriver driver) {
		return driver.findElement(By.xpath("changeBtn"));
	}

	public WebElement submitConnectPopup(WebDriver driver) {
		return driver.findElement(By.xpath("(//a[@class='defaultBtn grayColor cancelOkModal ng-binding'])[1]"));
	}

	public WebElement unfollowUserProfileBtn(WebDriver driver) {
		return driver.findElement(By.xpath("(//a[@class='unfollowMe ng-scope'])[2]"));
	}

	public WebElement nextPageArrow(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='ng-binding' and @ng-click='selectPage(page + 1, $event)']"));
	}

	// >>>>>>>>>> Post & News related >>>>>>>>>>>>>>>>>>>
	public WebElement postMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//textarea[@name='postText']"));
	}

	public WebElement newsLikeButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.ng-binding.post-like-text"));
	}
	
	public WebElement submitComment(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.publicComment > input"));
	}
	
	public WebElement postButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Post']"));
	}

	public WebElement getPostUserName(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='userName ng-binding']"));
	}
	
	public WebElement getCommentUserName(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='publicComment'])[1]//a[@class='ng-binding']"));
	}
	
	public WebElement getPostMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='feedWrap-feedText two-col']//p"));
	}

	public WebElement writeCommentOnPost(WebDriver driver) {
		return driver.findElement(By.xpath("//textarea[@placeholder='Write a comment...']"));
	}

	public WebElement submitCommentFromNews(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Send']"));
	}

	public WebElement getCommentMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='publicComment']//p"));
	}
	
	public WebElement notificationBell(WebDriver driver) {
		return driver.findElement(By.xpath("//b[@class='sprite notificationIcon']"));
	}

	public WebElement getNotificationCount(WebDriver driver) {
		return driver.findElement(By.cssSelector(".notificationNumber.ng-binding.ng-scope"));
	}

	public List<WebElement> notificationCommentMessageList(WebDriver driver) {
		return driver.findElements(By.xpath("//p[@class='ng-binding']//a"));
	}
	
	public List<WebElement> getUserListThoseCommentOnPostFromNotification(WebDriver driver, String commentUserName, String postMessage) {
		return driver.findElements(By.xpath("//div[@class='notificationBox']//p[contains(text(),'"+commentUserName+"') and a[contains(text(),'"+postMessage+"')]]"));
	}
	
	public WebElement clickOnPostMessageFromNotificationView(WebDriver driver, String commentUserName, String postMessage) {
		return driver.findElement(By.xpath("//div[@class='notificationBox']//p[contains(text(),'"+commentUserName+"') and a[contains(text(),'"+postMessage+"')]]//a"));
	}
	

	// ***************************************************** Admin related
	// ***********************************************
	public WebElement adminEmailId(WebDriver driver) {
		return driver.findElement(By.id("admin_email"));
	}

	public WebElement adminPassword(WebDriver driver) {
		return driver.findElement(By.id("admin_password"));
	}

	public WebElement adminSignInBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Sign in']"));
	}

	public WebElement adminSignOutLink(WebDriver driver) {
		return driver.findElement(By.linkText("Sign out"));
	}

	public List<WebElement> adminHeaderTab(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='menuWrap']//a[contains(@href,'/admin')]"));
	}

	public WebElement plantsmapAdminLogo(WebDriver driver) {
		return driver.findElement(By.linkText(" Plantsmap Admin"));
	}

	public List<WebElement> menuListUnderManageUser(WebDriver driver) {
		return driver.findElements(By.xpath("//aside[@class='left-panel']//a//span"));
	}

	public WebElement adminSearch(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='' and @type='search']"));
	}

	// Admin user
	public WebElement addUserPlantOrgCollEventBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='pryBtn pull-right' and starts-with(@href,'/admin')]"));// (By.linkText("Add
																												// User"));
	}

	public WebElement enterAdminUserDisPlayName(WebDriver driver) {
		return driver.findElement(By.id("user_profile_attributes_name"));
	}

	public WebElement enterAdminUserFirstName(WebDriver driver) {
		return driver.findElement(By.id("user_profile_attributes_first_name"));
	}

	public WebElement enterAdminUserLastName(WebDriver driver) {
		return driver.findElement(By.id("user_profile_attributes_last_name"));
	}

	public WebElement userEmailId(WebDriver driver) {
		return driver.findElement(By.id("user_email"));
	}

	public WebElement userPassword(WebDriver driver) {
		return driver.findElement(By.id("user_password"));
	}

	public WebElement userPlantsCountFromAdmin(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr[@role='row']//td[3]"));
	}
	
	public WebElement userNetworkCountFromAdmin(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr[@role='row']//td[4]"));
	}
	
	public WebElement orgPlantsCountFromAdmin(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='org_list_table']//tbody//tr[@role='row']//td[2]"));
	}
	
	public WebElement orgCollectionCountFromAdmin(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='org_list_table']//tbody//tr[@role='row']//td[3]"));
	}
	
	public WebElement adminSubmitBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='commit']"));
	}

	public WebElement loaderImage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='show-loader']"));
	}

	public List<WebElement> adminEditBtn(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@title='Edit']"));
	}

	public List<WebElement> adminViewBtn(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@title='View']"));
	}

	public List<WebElement> adminDeleteBtn(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@title='Delete']"));
	}

	public WebElement getAdminSearchResultStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@id,'_table_info')]"));
	}

	public List<WebElement> adminSearchResult(WebDriver driver) {
		return driver.findElements(By.xpath("//tbody//tr//td[@class='sorting_1']"));
	}

	public List<WebElement> deleteBtnList(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@title='Delete']"));
	}

	public WebElement deleteBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@title='Delete']"));
	}

	// Admin Plant
	public WebElement selectPlantOwnerType(WebDriver driver, String ownerType) {
		if (ownerType.equalsIgnoreCase("user"))
			return driver.findElement(By.id("plant_owner_type_User"));
		else
			return driver.findElement(By.id("plant_owner_type_Organization"));
	}

	public WebElement addPlantOwnerIdOrSlug(WebDriver driver) {
		return driver.findElement(By.id("plant_owner_id"));
	}

	public WebElement addAdminPlantImage(WebDriver driver) {
		return driver.findElement(By.id("plant_plant_image"));
	}

	public WebElement addAdminPlantTitle(WebDriver driver) {
		return driver.findElement(By.id("plant_title"));
	}

	public WebElement addAdminPlantAddress(WebDriver driver) {
		return driver.findElement(By.id("plant_location"));
	}

	public WebElement adminPublicLoc(WebDriver driver) {
		return driver.findElement(By.id("plant_location_private_false"));
	}

	public WebElement adminPrivateLoc(WebDriver driver) {
		return driver.findElement(By.id("plant_location_private_true"));
	}

	public WebElement addAdminPlantSuggestedAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//li[starts-with(@id,'ui-id-')]"));
	}

	public WebElement adminPlantPublicLoc(WebDriver driver) {
		return driver.findElement(By.id("plant_location_private_true"));
	}

	public WebElement adminPlantPrivateLoc(WebDriver driver) {
		return driver.findElement(By.id("plant_location_private_false"));
	}

	public WebElement addAdminPlantStory(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));
	}

	public List<WebElement> getAdminPlantDetailHeader(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='prof-right']//h3"));
	}

	public List<WebElement> getAdminPlantHeaderInfo(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='prof-right']//p"));//// div[@class='prof-right']//h3//following::p"));
	}

	// Admin Collection
	public WebElement selectCollectionOwnerType(WebDriver driver, String ownerType) {
		if (ownerType.equalsIgnoreCase("user"))
			return driver.findElement(By.id("owner_type_User"));
		else
			return driver.findElement(By.id("owner_type_Organization"));
	}

	public WebElement addCollectionOwnerIdOrSlug(WebDriver driver) {
		return driver.findElement(By.id("owner_id"));
	}

	public WebElement addAdminCollectionImage(WebDriver driver) {
		return driver.findElement(By.id("collection_collection_pic"));
	}

	public WebElement addAdminCollectionTitle(WebDriver driver) {
		return driver.findElement(By.id("collection_name"));
	}

	public WebElement addAdminCollectionAddress(WebDriver driver) {
		return driver.findElement(By.id("collection_location"));
	}

	public WebElement adminCollectionPublicLoc(WebDriver driver) {
		return driver.findElement(By.id("collection_location_private_false"));
	}

	public WebElement adminCollectionPrivateLoc(WebDriver driver) {
		return driver.findElement(By.id("collection_location_private_true"));
	}

	public WebElement addAdminCollectionSuggestedAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//li[starts-with(@id,'ui-id-')]"));
	}

	public WebElement addAdminCollectionStory(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));
	}

	// Admin Tab Manager
	public WebElement enterTabName(WebDriver driver) {
		return driver.findElement(By.id("tab_name"));
	}

	public WebElement EnterTabDescription(WebDriver driver) {
		return driver.findElement(By.id("tab_description"));
	}

	public WebElement getTabManagerName(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='tab-details-heading']//span)[1]"));
	}

	public WebElement getTabDescription(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='tab-details-heading']//span)[2]"));
	}

	public WebElement createFieldForTab(WebDriver driver, String addType) {
		if (addType.equalsIgnoreCase("add Field"))
			return driver.findElement(By.linkText("Add Field"));
		else
			return driver.findElement(By.id("addExistingFieldLink"));
	}

	public WebElement waitCreateFieldTabHeader(WebDriver driver, String tabType) {
		if (tabType.equalsIgnoreCase("add field"))
			return driver.findElement(By.xpath("//form[@id='test-form']//h1"));
		else
			return driver.findElement(By.xpath("//div[@id='existing-field-form']//h1"));
	}

	public List<WebElement> getExistingFieldCheckBoxList(WebDriver driver) {
		return driver
				.findElements(By.xpath("(//div[@id='existing-field-form'])[1]//input[@class='normalize-checkbox']"));
	}

	public List<WebElement> getAddedExistingFieldsName(WebDriver driver) {
		return driver.findElements(By.xpath("//tbody[@id='tab-table-exisiting-field-tbody']//td[1]"));
	}

	public WebElement selectTabManagerNameFromList(WebDriver driver) {
		return driver.findElement(By.id("dd"));// xpath("//select[@ng-model='selected_available_tab']"));
	}

	public List<WebElement> getTabList(WebDriver driver) {
		return driver.findElements(By.xpath("//ul[@class='dropdown']//a[contains(@class,'ng-binding')]"));
	}

	public WebElement enterSlugIdForTabManager(WebDriver driver) {
		return driver.findElement(By.id("search-user-org"));
	}

	public WebElement submitSlugId(WebDriver driver) {
		return driver.findElement(By.id("assign-entity"));
	}

	public WebElement getUserSlugId(WebDriver driver) {
		return driver.findElement(By.className("assigned-text"));
	}

	public WebElement fieldNameForTab(WebDriver driver) {
		return driver.findElement(By.id("tab-form-name"));
	}

	public WebElement selectFieldValueForTab(WebDriver driver) {
		return driver.findElement(By.id("type"));
	}

	// admin org
	public WebElement adminOrgImage(WebDriver driver) {
		return driver.findElement(By.id("organization_organization_pic"));
	}

	public WebElement adminOrgCoverImage(WebDriver driver) {
		return driver.findElement(By.id("organization_resource_cover_pic"));
	}

	public WebElement adminOrgSlugId(WebDriver driver) {
		return driver.findElement(By.id("user_slug_id"));
	}

	public WebElement adminOrgTitle(WebDriver driver) {
		return driver.findElement(By.id("organization_title"));
	}

	public WebElement adminOrgAddress(WebDriver driver) {
		return driver.findElement(By.id("organization_location"));
	}

	public WebElement addAdminOrgStory(WebDriver driver) {
		return driver.findElement(By.className("jqte_editor"));
	}

	public WebElement addAdminOrgPublicLoc(WebDriver driver) {
		return driver.findElement(By.id("organization_location_private_false"));
	}

	public WebElement addAdminOrgPrivateLoc(WebDriver driver) {
		return driver.findElement(By.id("organization_location_private_true"));
	}

	public WebElement getAdminTitle(WebDriver driver) {
		return driver.findElement(By.className("organisation-user-icon"));
	}

	public WebElement getAdminDescription(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='organisation-panel-description']/span"));
	}

	public WebElement getOrgLocationPrivacy(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='organisation-main-entry']/span)[3]"));
	}

	public WebElement getOrgOwnerName(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='organisation-main-entry']/span)[1]"));
	}

	public WebElement getOrgOwnerEmail(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='organisation-main-entry']/span)[2]"));
	}
	
	// Links and images related.
	public List<WebElement> getAnchorLinkList(WebDriver driver) {
		return driver.findElements(By.tagName("a"));
	}
	
	public List<WebElement> getImagesLinkList(WebDriver driver) {
		return driver.findElements(By.tagName("img"));
	}
	
	public List<WebElement> getIndexList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='pagination-page ng-scope']"));
	}
	
	//>>>>>>>>>>>>>>> Pagination >>>>>>>>>>>
	public WebElement moveToLastIndex(WebDriver driver) {
		return driver.findElement(By.cssSelector("li.pagination-last.ng-scope"));
	}
	
	public WebElement firstIndexValue(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@class='pagination-page ng-scope active']//a"));
	}
	
	public WebElement getLastIndexValue(WebDriver driver) {
		return driver.findElement(By.cssSelector("li.pagination-page.ng-scope.active>a"));
	}
	
	public List<WebElement> getCountPlantCollectionsOrgOnPlantDetailPageByViewMore(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='boxTemplate-title']//p//a"));
	}
}
