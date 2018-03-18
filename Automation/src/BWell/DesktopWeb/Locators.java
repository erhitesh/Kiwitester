package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public String title = null;

	public static Locators getInstance() {
		Locators mHeader = null;
		try {
			mHeader = new Locators();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mHeader;
	}

	public WebElement helpIcon(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.help-icon > img"));
	}

	public WebElement iframeElement(WebDriver driver) {
		return driver.findElement(By.xpath("//iframe[@data-test-id='ChatWidgetWindow-iframe']"));
	}

	public WebElement chatModelWindowMessage(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='jx_ui_Widget'])[2]"));
	}

	public WebElement hideChatModelWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@class='table jx_ui_html_table']//div"));
	}

	// app link
	public WebElement appStoreLink(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.bwell-app-images span:nth-of-type(1)>a"));
	}

	public WebElement itunePreviewHeader(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.localnav>h2"));
	}

	public WebElement verifyAppNameOnItune(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'b.well - Connected Health')]"));
	}

	public WebElement googlePlayLink(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.bwell-app-images span:nth-of-type(2)>a"));
	}

	public WebElement googlePlayTitle(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[id='gbq1'] a"));
	}

	public WebElement verifyAppNameOnGooglePlayStore(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'b.well - Connected Health')]"));
	}

	// SignUp
	public WebElement submitInfo(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Submit']"));
	}

	public WebElement sigUpLink(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='sign up']"));
	}

	public WebElement errorMsgWhileSubmitSignupInfo(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Oops. Something went wrong']"));
	}

	public WebElement refreshBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Refresh']"));
	}

	public WebElement signUpEmailAddress(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement signUpPassword(WebDriver driver) {
		return driver.findElement(By.name("password"));
	}

	public WebElement signUpConfirmPassword(WebDriver driver) {
		return driver.findElement(By.name("confirmPassword"));
	}

	public WebElement signUpFirstName(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement signUpLastName(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement enableSignUpDOBWindow(WebDriver driver) {
		return driver.findElement(By.name("dob"));
	}

	public String getSignUpWindowLocator() {
		return "dob";
	}

	public WebElement enableSignUpCCExpiryDateWindow(WebDriver driver) {
		return driver.findElement(By.name("expirationDate"));
	}

	public String getSignUpExpiryWindowLocator() {
		return "expirationDate";
	}

	public WebElement enableSignUpGenderDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='caret']"));
	}

	public String enableDropDown() {
		return "caret";
	}

	public List<WebElement> signUpGenderList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='gender in genderChoices']//a"));
	}

	public WebElement signUpPhoneNumber(WebDriver driver) {
		return driver.findElement(By.name("phone"));
	}

	public WebElement selectSignupAsPartOfCompanyOrFamily(WebDriver driver, String option) {
		return driver.findElement(By.xpath("//input[starts-with(@id,'is-group-" + option + "')]"));
	}

	public String getPartOfCompanyOrFamily(String option) {
		return "is-group-" + option;
	}

	public WebElement signUpRegistrationCode(WebDriver driver) {
		return driver.findElement(By.name("registrationCode"));
	}

	public WebElement checkWhatIsRegistrationCode(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.forgot.custom-toltip"));
	}

	public WebElement signUpNextBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[value='next']"));
	}

	public WebElement subscriptionPlanTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//label//span[contains(text(),'Subscription Plan')]"));
	}

	public List<WebElement> getSubscriptionPlanList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='plan in plans']//a"));
	}

	public WebElement signUpPromoCode(WebDriver driver) {
		return driver.findElement(By.name("promo"));
	}

	public WebElement enableCCDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select Card']//span[@class='caret']"));
	}

	public WebElement creditCardNumber(WebDriver driver) {
		return driver.findElement(By.name("creditCardNumber"));
	}

	public List<WebElement> ccOptions(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='card in credit_cards']//a"));
	}

	public WebElement cvvNumber(WebDriver driver) {
		return driver.findElement(By.name("cvv"));
	}

	public WebElement nameOnCard(WebDriver driver) {
		return driver.findElement(By.name("nameOnCard"));
	}

	public String nameOnCard() {
		return "nameOnCard";
	}

	public WebElement sameAsNameOnAccount(WebDriver driver) {
		return driver.findElement(By.className("onboarding-checkbox-white"));
	}

	public String checkSameAsNameOnAccount() {
		return "onboarding-checkbox-white";
	}

	public String unCheckSameAsNameOnAccount() {
		return "onboarding-checkbox-white selected";
	}

	public WebElement enableAddresDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='addressChoice']//span[@class='caret']"));
	}

	public List<WebElement> getAddressList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='location in locations']//a"));
	}

	public WebElement addressLine1(WebDriver driver) {
		return driver.findElement(By.name("address1"));
	}

	public WebElement addressLine2(WebDriver driver) {
		return driver.findElement(By.name("address2"));
	}

	public WebElement userZipCode(WebDriver driver) {
		return driver.findElement(By.name("zipcode"));
	}

	public WebElement userCity(WebDriver driver) {
		return driver.findElement(By.name("city"));
	}

	public WebElement getSelectedState(WebDriver driver) {
		return driver.findElement(By.xpath("(//ol[@name='state']//span)[1]"));
	}

	public List<WebElement> statesList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='state in stateOptions']//a"));
	}

	public WebElement welcomeBackToBWellMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//h4[contains(text(),'Welcome to b.well!')]"));
	}

	public WebElement switchToIframePlayBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='challenge-media responsive-video']//iframe"));
	}

	public WebElement playVideoBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".play.rounded-box.state-paused"));
	}

	public WebElement pauseVideoBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".play.rounded-box.state-playing"));
	}

	public WebElement skipBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.modal-link"));
	}

	public WebElement congratulationMessage(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.congratulations"));
	}

	public WebElement finishTutorialMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Finish Tutorial']"));
	}

	public WebElement addFirstDoctorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Add Your Doctors']"));
	}

	public WebElement allergyAddedMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Have Allergies?']"));
	}

	public WebElement weightHealthMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Height and weight, please!']"));
	}

	public WebElement moreTheMerrierMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='The more the merrier!']"));
	}

	public WebElement collectYourMedicalRecordsMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Collect your medical records']"));
	}

	public WebElement healthAssessmentObjectiveComplete(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Health Assessment')]"));
	}

	public WebElement finishTutorialBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Finish Tutorial')]"));
	}

	public WebElement earnPoint(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.benefit-received > span"));
	}

	public WebElement startNextChallenge(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Start Next Challenge')]"));
	}

	public WebElement submitSuccessfullyAccountCreationWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.bw-btn.bw-cancel"));
	}

	// Login
	public WebElement loginEmail(WebDriver driver) {
		WebElement element = driver.findElement(By.name("username"));
		return element;
	}

	public WebElement loginPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.name("password"));
		return element;
	}

	public WebElement loginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@value='login']"));
		return element;
	}

	public WebElement loginBtnOnResetPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.login-button"));
	}

	public WebElement errorMessageForUserEmail(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg' and contains(text(),'Email is required')]"));
	}

	public WebElement errorMessageForUserPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg' and contains(text(),' Password is required ')]"));
	}

	public WebElement errorMessageForInvalidEmailAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Enter a valid email address.')]"));
	}

	public WebElement invalidCredentialErrorMessageForLogin(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Username and password do not match')]"));
	}

	public WebElement logoOnLoginPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.bwell-logo>img"));
	}

	// Forgot Password
	public WebElement forgotPasswordLink(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Forgot password?')]"));
	}

	public WebElement forgotPasswordHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='bwell-welcome-text']"));
	}

	public WebElement forgotPasswordEmailTxtBox(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement submitForgotPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}

	public WebElement forgotPasswordLinkSendSuccessfully(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='bwell-reset-pwd thank-text']"));
	}

	public WebElement elementForNewTab(WebDriver driver) {
		return driver.findElement(By.cssSelector("body"));
	}

	public WebElement yopmailLogo(WebDriver driver) {
		return driver.findElement(By.id("logoacc"));
	}

	public WebElement yopmailEmailTextBox(WebDriver driver) {
		return driver.findElement(By.id("login"));
	}

	public WebElement checkYopmailInboxBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Check Inbox']"));
	}

	public List<WebElement> getResetPasswordMailLink(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(text(),'Password reset request')]"));
	}

	public WebElement checkUserName(WebDriver driver) {
		return driver.findElement(By.xpath("//td[contains(text(),'Hello Hitesh')]"));
	}

	public WebElement getPasswordResetLink(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='mailmillieu']//center//tr//td[contains(text(),'link')]"));
	}

	// >>>>>>>>>>>>>> Setting Panel Page Related >>>>>>>>>>
	public WebElement rightSideHeader(WebDriver driver) {
		return driver.findElement(By.id("user-options-dd"));
	}

	public WebElement settingPanelViewStatus(WebDriver driver) {
		return driver.findElement(By.cssSelector(".dropdown-menu.user-options-wrap"));
	}

	public WebElement logoutBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Log out']"));
	}

	public WebElement getPointCounts(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.dashboard-pts.ng-binding"));//(By.cssSelector("p.points-count > span:nth-of-type(1)"));
	}

	// View Digital Wallet
	public WebElement addAnotherCardBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public WebElement enterCardName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Enter Card Name']"));
	}

	public WebElement addCardFrontImage(WebDriver driver) {
		return driver.findElement(By.id("cardFrontImage"));
	}

	public WebElement addCardBackImage(WebDriver driver) {
		return driver.findElement(By.id("cardBackImage"));
	}

	public WebElement addThisCardBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add This Card')]"));
	}

	public WebElement enableInsuranceCardMenu(WebDriver driver) {
		return driver.findElement(By.cssSelector(".card-select-wrapper>ol>button span:nth-child(3)"));
	}

	public WebElement selectInsuranceCard(WebDriver driver, String cardName) {
		return driver.findElement(
				By.xpath("//li[@nya-bs-option='card in cardChoices']//a[contains(text(),'" + cardName + "')]"));
	}

	public List<WebElement> insuranceCardList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='card in cardChoices']//a"));
	}

	public List<WebElement> getInsuranceCardListBasedOnValue(WebDriver driver, String cardNameStartsWith) {
		return driver.findElements(By
				.xpath("//li[@nya-bs-option='card in cardChoices']//a[contains(text(),'" + cardNameStartsWith + "')]"));
	}

	public WebElement removeCard(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Remove Card')]"));
	}

	public WebElement printThisCard(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Print this Card')]"));
	}

	public WebElement shareThisCard(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Share this Card')]"));
	}

	public WebElement shareWindowHeaderTxt(WebDriver driver, String cName) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Share Your " + cName + "')]"));
	}

	public WebElement enterEmailIdForShareCard(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public List<WebElement> errorMsgForInvalidMail(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(@class,'error-msg')]"));
	}

	public WebElement shareBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn' and contains(text(),'Share')]"));
	}

	public WebElement verifyEmailSuccessfullySendToEmailAddress(WebDriver driver, String cName, String emailAddress) {
		return driver.findElement(
				By.xpath("//p[contains(text(),'You have shared your " + cName + " with " + emailAddress + "')]"));
	}

	public WebElement submitSuccessfullySendMailAddressWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='add-card-btn']>button"));
	}

	// My Profile Related
	public WebElement myProfileBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
	}

	public WebElement getSelectedAccountName(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.pull-left.special-title.ng-binding"));
	}

	public WebElement enableUserAccountDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@data-ng-model='currentMember']//span[@class='caret']"));
	}

	public List<WebElement> getAccountUserList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='ng-scope nya-bs-option']//a"));
	}

	public WebElement getProfielUserName(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='user-profile-detail']//p)[1]"));
	}

	public WebElement getUserAge(WebDriver driver) {
		return driver.findElement(By.xpath("(//ul[@class='user-info']//li)[1]//span[2]"));
	}

	public WebElement getUserHeight(WebDriver driver) {
		return driver.findElement(By.xpath("(//ul[@class='user-info']//li)[2]//span[2]"));
	}

	public WebElement enterUserHeightInFeets(WebDriver driver) {
		return driver.findElement(By.name("height_feet"));
	}

	public WebElement enterUserHeightInInches(WebDriver driver) {
		return driver.findElement(By.name("height_inches"));
	}

	public WebElement getUserWeight(WebDriver driver) {
		return driver.findElement(By.name("weight"));
	}

	public WebElement profileEditBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
	}

	public WebElement editProfileHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Edit Profile')]"));
	}

	public WebElement profilePic(WebDriver driver) {
		return driver.findElement(By.id("profile-pic"));
	}

	public WebElement profileUserFName(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement profileUserLName(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement profileUserAddress(WebDriver driver) {
		return driver.findElement(By.name("address1"));
	}

	public WebElement profileUserCity(WebDriver driver) {
		return driver.findElement(By.name("city"));
	}

	public WebElement profileUserZip(WebDriver driver) {
		return driver.findElement(By.name("zip"));
	}

	public WebElement profileUserEmail(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement profileUserPhoneNumber(WebDriver driver) {
		return driver.findElement(By.name("phone"));
	}

	public WebElement closeEditMyProfile(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}

	public WebElement editProfileDoneBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main-blue"));
	}

	public WebElement errorMsgForWeight(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'This is required')]"));
	}

	public boolean errorMsgForWeightStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'This is required')]")).isDisplayed();
	}

	public WebElement errorMsgForHeight(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[contains(text(),'Height must be between 1 inch and 8 feet 4 inches')]"));
	}

	public boolean errorMsgForHeightStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Height must be between 1 inch and 8 feet 4 inches')]"))
				.isDisplayed();
	}

	// Forgot password
	public WebElement forgotNewPassword(WebDriver driver) {
		return driver.findElement(By.name("password"));
	}

	public WebElement forgotConfirmPasswordt(WebDriver driver) {
		return driver.findElement(By.name("confirmPassword"));
	}

	public WebElement submitForgotPasswordWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]"));
	}

	public WebElement passwordUpdateMessage(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(text(),'Your password has been successfully reset. You can login now.')]"));
	}

	// Security Settings
	public WebElement currentPasswordTxt(WebDriver driver) {
		return driver.findElement(By.name("currentPassword"));
	}

	public WebElement newPasswordTxt(WebDriver driver) {
		return driver.findElement(By.name("newPassword"));
	}

	public WebElement confirmPasswordTxt(WebDriver driver) {
		return driver.findElement(By.name("confirmPassword"));
	}

	public WebElement updateBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@name='updatePasswordForm']//button"));
	}

	public WebElement passwordNotMatchedErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[contains(text(),'New password and the confirm password entries do not match. Please ensure that they match prior to proceeding. Your password was not changed.')]"));
	}

	public WebElement passwordFormatError(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg top-margin ng-scope']"));
	}

	public List<WebElement> requiredFieldsErrorMessage(WebDriver driver) {
		return driver.findElements(By.xpath("//p[@class='error-msg top-margin ng-scope']"));
	}

	public WebElement verifySuccessfullyPasswordUpdateMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[@class='modal-form-label']"));
	}

	public WebElement okBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.bw-btn.bw-btn-main.bw-btn-blue"));
	}

	// Manage Subscription
	public List<WebElement> profileTabList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='profile-heading']"));
	}

	public WebElement manageYourSubscriptionHeagerTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[text()='Manage Your  Subscription']"));
	}

	public List<WebElement> relationListUnderSubscription(WebDriver driver) {
		return driver
				.findElements(By.xpath("//p[@class='payment-card-info ng-scope']//span[@class='payment-heading']"));
	}

	public List<WebElement> memberListUnderSubscription(WebDriver driver) {
		return driver.findElements(By.xpath("//p[@class='payment-card-info ng-scope']//span[@class='ng-binding']"));
	}

	public WebElement addFamilyMember(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add Family Member')]"));
	}

	public WebElement addMemberSubscriptionHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Add Subscription Member')]"));
	}

	public WebElement memberFname(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement memberLname(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement enableMemberRelationDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[1]"));
	}

	public WebElement selectMemberRelationDropDownValue(WebDriver driver, String optionValue) {
		return driver.findElement(
				By.xpath("//li[@class='ng-scope nya-bs-option']//a[contains(text(),'" + optionValue + "')]"));
	}

	public WebElement haveOnlyOneSpouse(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@name='memberForm']//p[@class='ng-binding error-msg']"));
	}
	
	public List<WebElement> memberRelationDropDownValues(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='ng-scope nya-bs-option']//a"));
	}

	public WebElement getSelectMemberRelation(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='pull-left filter-option'])[1]"));
	}

	public WebElement emailLabelStatus(WebDriver driver) {
		return driver.findElement(By.cssSelector("em.ng-scope.required"));
	}

	public WebElement emailErrorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@data-ng-if,'memberForm.email.$error')]"));
	}
	
	public WebElement errorMsgForDateField(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@data-ng-if='memberForm.date_of_birth.$error.required']"));
	}

	public WebElement memberEmailAddress(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement errorMsgForReAndSelfInvitesId(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@name='memberForm']//p[@data-ng-bind='emailErrorMessage']"));////form[@name='memberForm']//div[@class='ng-binding error-msg top-margin']"));
	}

	public WebElement enableDateView(WebDriver driver) {
		return driver.findElement(By.name("date_of_birth"));
	}

	public WebElement dateHeadervalue(WebDriver driver) {
		return driver.findElement(By.xpath("//button[starts-with(@id,'datepicker-')]//strong"));
	}

	public WebElement submitSubscriptonAddFamilyMember(WebDriver driver) {
		return driver.findElement(By.xpath("(//button[@class='bw-btn bw-btn-main-blue'])[1]"));
	}

	public WebElement hideAddMemberSubscriptionWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}
	
	public WebElement familyMemberSuccessfullyAddedMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Family Member Successfully Added')]"));
	}

	public WebElement submitFamilyMemberAddedWindowPopup(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn"));
	}

	public WebElement viewFamilyMemberBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'View Family')]"));
	}

	public WebElement addMember(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public List<WebElement> addedMemberList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='doc-detail-wrap']//a[@class='ng-binding']"));
	}

	public WebElement addedMemberName(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='doc-detail']//a)[1]"));
	}

	public WebElement addedFamilyMember(WebDriver driver, String member) {
		return driver.findElement(By.xpath("//div[@class='doc-detail']//a[text()='" + member + "']"));
	}

	public WebElement editAddedMemberSubscriptionBtn(WebDriver driver, String memberName) {
		return driver.findElement(By.xpath("//li[@class='subscriber-item ng-scope']//a[text()='" + memberName
				+ "']/..//span[@class='fa fa-pencil']"));
	}

	public List<WebElement> editFamilyMemberBtnList(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.fa.fa-pencil"));
	}

	public WebElement deleteBtnForSubscriptionMember(WebDriver driver, String memberName) {
		return driver.findElement(By.xpath("//li[@class='subscriber-item ng-scope']//a[text()='" + memberName
				+ "']/..//span[@class='fa fa-trash-o']"));
	}

	public WebElement deleteMemberSubscriptionBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='fa fa-trash-o']"));
	}

	public List<WebElement> deleteMemberSubscriptionBtnList(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.fa.fa-trash-o"));
	}

	public WebElement memberSubscriptionMessageBeforeDelete(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'remove this member from your subscription plan?')]"));
	}

	public WebElement submitSubscriptionMemberDeleteMessagePopup(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='modal-footer-btn']//button"));
	}

	public WebElement memberSubscriptionInfoUpdatedMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Details Successfully Updated')]"));
	}

	public WebElement submitUpdatedMemberInfoMessagePopup(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='add-card-btn']/button"));
	}

	// >>>>>> DashBoard related >>>>>>>>>>>>>>
	public WebElement bwellLogoHeader(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.logo-wrap"));
	}

	public WebElement selectDashboardLeftMenu(WebDriver driver, String menuName) {
		return driver.findElement(By.xpath("//div[@id='menu']//span[contains(text(),'" + menuName + "')]"));
	}

	// Health Journey And Rewards
	public WebElement selectHealthJourneyAndRewardsSubLinks(WebDriver driver, String subLinkName) {
		WebElement element = null;
		if (subLinkName.contains("health"))
			element = driver.findElement(
					By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'My Health Journey')]"));
		else if (subLinkName.contains("rewards"))
			element = driver
					.findElement(By.xpath("(//ul[@class='sub-items-wrap show']//a[contains(text(),'Rewards')])[1]"));
		else
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Rewards History')]"));
		return element;
	}
	
	public WebElement selectARewardGoalWindowHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Select a Reward Goal!')]"));
	}
	
	public WebElement viewGoal(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'View Rewards')]"));
	}
	
	public WebElement acceptGoalWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	}
	
	public WebElement cancelGoal(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Not Now')]"));
	}
	
	public WebElement selectShowOnlyRewardsIQualify(WebDriver driver) {
		return driver.findElement(By.xpath("//label[@class='checkbox-label-text']/span"));
	}
	
	public WebElement enableRewardsFilterByType(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[2]"));
	}

	public List<WebElement> selectRewardsTypeValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='type in rewardTypes track by type.id']//span[@class='ng-binding']"));
	}

	public WebElement enableRewardsFilterByBrand(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[3]"));
	}
	
	public List<WebElement> selectRewardsBrandValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[contains(@nya-bs-option,'brand in rewardBrands track by brand.id')]//a"));
	}
	
	public List<WebElement> rewardsList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@data-ng-repeat='reward in rewardsList']"));
	}
	
	public List<WebElement> rewardsDetailsBtn(WebDriver driver) {
		return driver.findElements(By.xpath("//a[text()='Reward Details']"));
	}
	
	public WebElement backToRewardsPage(WebDriver driver)  {
		return driver.findElement(By.cssSelector("a.back-nav-link"));
	}
	
	public List<WebElement> rewardsNameList(WebDriver driver) {
		return driver.findElements(By.cssSelector("h4.reward-title.ng-binding"));
	}
	
	public WebElement selectDetailBtnBasedOnRewardName(WebDriver driver, String rewardName) {
		return driver.findElement(By.xpath("//h4[contains(text(),\""+rewardName+"\")]/../following-sibling::a"));
	}
	
	public WebElement rewardsItemDescriptionOnDetailPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("h4.item-title.ng-binding"));
	}
	
	public WebElement itemBrandNameOnDescriptionPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.item-action-wrap p:nth-of-type(1)"));
	}
	
	public WebElement itemPriceOnDescriptionPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.item-action-wrap p:nth-of-type(2)"));
	}
	
	public WebElement claimThisReward(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Claim This Reward']"));
	}
	
	public List<WebElement> rewardsPriceList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@data-ng-repeat='reward in rewardsList']//span[@class='reward-target ng-binding']"));
	}
	
	public String getPriceListFromRewards(WebDriver driver) {
		return "reward-target ng-binding";
	}
	
	// >>>>>>>>>>>>>>> My Health Related >>>>>>>>>>>>>
	public WebElement selectMyHealthSubLinks(WebDriver driver, String subLinkName) {
		WebElement element = null;
		if (subLinkName.contains("clinical"))
			element = driver.findElement(
					By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Clinical Summary')]"));
		else if (subLinkName.contains("fitness"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'My Fitness')]"));
		else if (subLinkName.contains("health"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Health Timeline')]"));
		else if (subLinkName.contains("labs"))
			element = driver.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Labs')]"));
		else if (subLinkName.contains("allergy"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Allergies')]"));
		else if (subLinkName.contains("family"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Family History')]"));
		else
			element = driver.findElement(
					By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Health Assessments')]"));
		return element;
	}

	// For Clinical summary
	public WebElement addCareNeeds(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Care Needs')]//span"));
	}

	public WebElement TapOnMedicalDocumentsBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.bw-btn-rightside.filters:nth-of-type(1)"));
	}

	public WebElement addDocumentBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.icon-add-circle"));
	}

	public WebElement addMedicalDocumentHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Add Medical Document')]"));
	}

	public WebElement documentName(WebDriver driver) {
		return driver.findElement(By.name("name"));
	}

	public WebElement addDocumentFile(WebDriver driver) {
		return driver.findElement(By.id("docFile"));
	}

	public WebElement clearBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Clear')]"));
	}

	public WebElement closeMedicalDocumentWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}

	public WebElement submitMedicalDocumentInfo(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.bw-btn.bw-btn-main-blue"));
	}

	public WebElement verifyMedicalDocUploadSuccessfullyMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='alert alert-success ng-binding ng-scope']"));
	}

	public WebElement searchAddedDocument(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[placeholder='Find a document']"));
	}

	public WebElement searchErrorMessage(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.null-document-msg"));
	}

	// Medical Document filter related
	public WebElement resetFilterBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Reset Filters')]"));
	}

	public List<WebElement> docFileList(WebDriver driver) {
		return driver.findElements(By.cssSelector("p.doc-title.ng-binding"));
	}

	public List<WebElement> docAddedDate(WebDriver driver) {
		return driver.findElements(By.cssSelector("p[class='doc-date'] > span.ng-binding"));
	}

	public WebElement enableStartDateWindow(WebDriver driver) {
		return driver.findElement(By.name("startDate"));
	}

	public WebElement enableEndDateWindow(WebDriver driver) {
		return driver.findElement(By.name("endDate"));
	}

	public WebElement medicalDocumentDetailPageHeader(WebDriver driver) {
		return driver.findElement(By.cssSelector("h3.modal-title.ng-binding"));
	}

	public WebElement documentNameOnDetailPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("h3.document-heading.ng-binding"));
	}

	public WebElement documentCreateDateOnDetailPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.document-detail-time.ng-binding"));
	}

	// Share Medical Document Related Object Identification
	public WebElement shareDocumentBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Share')]"));
	}

	public WebElement shareDocumentHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[@class='edit-form-head']//span"));
	}

	public WebElement shareFName(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement shareLName(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement shareRelation(WebDriver driver) {
		return driver.findElement(By.name("relationship"));
	}

	public WebElement shareEmail(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement submitShareWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Send']"));
	}

	public WebElement medicalDocumentConfirmationMsgBeforeShare(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.modal-small-text"));
	}

	public WebElement acceptMedicalDocumentConfirmationMsgPopup(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.bw-btn.bw-btn-main.bw-btn-blue"));
	}

	public List<WebElement> getSharedMedicalDocumentMailLink(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(text(),'STAGING - Shared Medical Documents')]"));
	}

	public List<WebElement> getSubscriptionCodeMailLink(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(text(),'STAGING - You')]"));
	}

	public List<WebElement> getShareInsuranceCardMailLink(WebDriver driver, String insuranceCName) {
		return driver
				.findElements(By.xpath("//span[contains(text(),'has shared his " + insuranceCName + " with you')]"));
	}

	public List<WebElement> getSharedConnectionsAuthorizationsMailLink(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(text(),'STAGING - Shared Connection Authorizations')]"));
	}

	public WebElement verifySharedMedicalUserName(WebDriver driver, String userName) {
		return driver.findElement(By.xpath("//td[contains(text(),'Hello " + userName + "')]"));
	}

	public WebElement verifyShareInsuranceCName(WebDriver driver, String insuranceCName) {
		return driver.findElement(By.xpath("//td[contains(text(),'has shared his " + insuranceCName + "')]"));
	}

	public WebElement clickHereLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Click here']"));
	}

	public WebElement getSharedMedicalDocumentPassword(WebDriver driver) {
		return driver.findElement(By.xpath("//td[contains(text(),'Password:')]"));
	}

	public WebElement registrationCodeTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//td[contains(text(),'registration code')]"));
	}

	public WebElement clinicalSummaryDocument(WebDriver driver) {
		return driver
				.findElement(By.xpath("//label[contains(text(),'Please enter password emailed to you to access')]"));
	}

	public WebElement medicalRecordsAuthorizationDocument(WebDriver driver) {
		return driver
				.findElement(By.xpath("//h4[contains(text(),'Please enter the password emailed to you to access')]"));
	}

	public WebElement medicalRecordsAuthorizationEFormHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Medical Record Authorization']"));
	}

	public WebElement medicalRecordsNextBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-up"));
	}

	public WebElement medicalRecordsPreviousBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-down"));
	}

	public WebElement getPageNumberValue(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[type='number']"));
	}

	public WebElement enterPasswordForClinicalSummaryDocument(WebDriver driver) {
		return driver.findElement(By.name("password"));
	}

	public WebElement submitClinicalOrMedicalRecords(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Submit']"));
	}

	public WebElement clinicalSummaryDocumentImage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='doc-share-img-wrap ng-scope']//img"));
	}

	public WebElement printDocumentBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Print')]"));
	}

	public WebElement addAllergies(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Allergies')]//span"));
	}

	public WebElement addDiagnosis(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Diagnosis')]//span"));
	}

	public WebElement addMedicationFromClinical(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Medications')]//span"));
	}

	public WebElement addSurgeries(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Surgeries')]//span"));
	}

	public WebElement addProcedures(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Procedures')]//span"));
	}

	public WebElement addRecentEncounters(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Recent Encounters')]//span"));
	}

	public WebElement addVitals(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Vitals')]//span"));
	}

	public WebElement addImmunizations(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Immunizations')]//span"));
	}

	public WebElement addFamilyHealthHistory(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Family Health History')]//span"));
	}

	// >>> Add Allergies >>>>>
	public WebElement enableAllergiesNameDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Name of allergy']//span[@class='caret']"));
	}

	public WebElement reEnableAllergyDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='pull-left filter-option']"));
	}

	public List<WebElement> allergiesListInsideDropdown(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='type in allergyChoices']//a[@class='ng-binding']"));
	}

	public WebElement enableAllergyStatusDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Select status')]"));
	}

	public List<WebElement> selectAllergyStatus(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='status in statusChoices']//a[@class='ng-binding']"));
	}

	public WebElement enableAllergySeverityDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Select severity')]"));
	}

	public List<WebElement> selectAllergySeverity(WebDriver driver) {
		return driver
				.findElements(By.xpath("//li[@nya-bs-option='severity in severityChoices']//a[@class='ng-binding']"));
	}

	public WebElement allergyReaction(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='What is your reaction?']"));
	}

	public WebElement enableOnSetDatePopup(WebDriver driver) {
		return driver.findElement(By.name("onsetDate"));
	}

	public WebElement selectOnSetDateValue(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.btn-default.btn-sm.active>span"));
	}

	public WebElement enableLastEpicodeDatePopup(WebDriver driver) {
		return driver.findElement(By.name("lastEpisode"));
	}

	public WebElement selectLastEpicodeValue(WebDriver driver, int indexValue) {
		return driver.findElement(By
				.xpath("//button[@class='btn btn-default btn-sm active']/../following::td[" + indexValue + "]//span"));
	}

	public WebElement enableEpisodeDateWindow(WebDriver driver, String episodeType) {
		WebElement element = null;
		if (episodeType.equalsIgnoreCase("onset date"))
			element = enableOnSetDatePopup(driver);
		else
			element = enableLastEpicodeDatePopup(driver);
		return element;
	}

	public WebElement allergyTreatment(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Do you have any treatments for this allergy?']"));
	}

	public WebElement submitAllergyDetails(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.bw-btn.bw-btn-main-blue"));
	}

	public WebElement allergySuccessfullyAddedMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]"));
	}

	public WebElement removeAllergyBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-red.ng-scope"));
	}

	public WebElement alreadyAddedAllergyErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'is already reported.')]"));
	}

	// Allergy detail
	public WebElement addAllergyFromAllergyPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.bw-btn-rightside.filters > span"));
	}

	public List<WebElement> allergyList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.allergy.name')]"));
	}

	public WebElement noAllergyBasedOnFilter(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Based on your filters, data is not available.')]"));
	}

	public List<WebElement> allergyTypeList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.allergy.type.name')]"));
	}

	public WebElement allergyTypeBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[1]"));
	}

	public List<WebElement> allergyStatusList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.status')]"));
	}

	public WebElement getAllergyName(String allergyName, WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + allergyName + "')]"));
	}

	public WebElement allergyStatusBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[2]"));
	}

	public List<WebElement> allergySeverityList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.severity')]"));
	}

	public WebElement allergySeverityBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[3]"));
	}

	public List<WebElement> allergyReactionList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.reactions')]"));
	}

	public WebElement allergyReactionBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[5]"));
	}

	public List<WebElement> allergyOnSetDateList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.onset_date')]"));
	}

	public WebElement allergyOnSetDateBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[7]"));
	}

	public List<WebElement> allergyLastEpisodeDateList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.last_episode')]"));
	}

	public WebElement allergyLastEpisodeDateBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[9]"));
	}

	public List<WebElement> allergyTreatmentList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'.treatment')]"));
	}

	public WebElement allergyTreatmentBasedOnAllergy(WebDriver driver, String allergyName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'" + allergyName + "')]/following::span)[11]"));
	}

	// >>>>>>>> Edit Allergy Detail Page >>>>>>>>
	public WebElement editAllergyHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Edit Allergy')]"));
	}

	// Filter related >>>>>>>>>>>>>
	public WebElement enableFilterByTypeValues(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[2]"));
	}

	public List<WebElement> selectFilterTypeValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='type in allergyTypeChoices']//a"));
	}

	public List<WebElement> selectFilterSpecialityValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[contains(@nya-bs-option,'speciality in specialities')]//a"));
	}

	public WebElement enableFilterByStatusValues(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[3]"));
	}

	public List<WebElement> selectFilterStatusValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='status in statusChoices']//a"));
	}

	public List<WebElement> selectFilterMedicalRecordsValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[contains(@nya-bs-option,'status in statusChoices')]//a"));
	}

	public WebElement enableFilterBySeverityValues(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='caret'])[4]"));
	}

	public List<WebElement> selectFilterSeverityValue(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='severity in severityChoices']//a"));
	}

	public List<WebElement> selectFilterAuthorizationStatusValue(WebDriver driver) {
		return driver
				.findElements(By.xpath("//li[contains(@nya-bs-option,'status in authorizationStatusChoices')]//a"));
	}

	// Family History Page
	public WebElement familyHistoryAddButton(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public WebElement inviteFamilyMemberHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Invite a Family Member')]"));
	}

	public WebElement closeInviteFamilyMemberPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}

	public WebElement familyMemberFName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='first_name']"));
	}

	public WebElement errorMessageForFNameFamilyMember(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.first_name') and contains(text(),'This is required')]"));
	}

	public WebElement familyMemberLName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='last_name']"));
	}

	public WebElement errorMessageForLNameFamilyMember(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.last_name') and contains(text(),'This is required')]"));
	}

	public WebElement selectFamilyMemberRelation(WebDriver driver) {
		return driver.findElement(By.name("relation"));
	}

	public WebElement errorMessageForRelation(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.relation') and contains(text(),'This is required')]"));
	}

	public WebElement enableMemberDOBPopUp(WebDriver driver) {
		return driver.findElement(By.name("dob"));
	}
	
	public WebElement changeYearMonthViewValue(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.icon-solid-down"));
	}

	public WebElement verifyYearMonthViewVisible(WebDriver driver) {
		return driver.findElement(By.xpath("//th[contains(@class,'controls')]"));
	}

	public WebElement verifyDayViewVisible(WebDriver driver) {
		return driver.findElement(By.cssSelector("tr.weeks-head"));
	}

	public List<WebElement> yearsList(WebDriver driver) {
		return driver.findElements(By.xpath("//td[contains(@class,'uib-year')]//span"));
	}

	public WebElement verifySelectYearMonthValue(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(@id,'datepicker-')]//strong"));
	}

	public List<WebElement> monthsList(WebDriver driver) {
		return driver.findElements(By.xpath("//td[contains(@class,'uib-month')]//span"));
	}

	public WebElement selectCurrentMonthValue(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn btn-default btn-info']//span"));
	}

	public List<WebElement> daysList(WebDriver driver) {
		return driver.findElements(By
				.xpath("//td[contains(@class,'uib-day')]//span[@class='ng-binding' or @class='ng-binding text-info']"));// (By.xpath("//td[contains(@class,'uib-day')]"));
	}

	public WebElement selectCurrentDayValue(WebDriver driver) {
		return driver.findElement(By.cssSelector("button.btn.btn-default.btn-sm.active > span"));
	}

	public List<WebElement> daysListForAllergy(WebDriver driver) {
		return driver.findElements(By.xpath("//td[contains(@class,'uib-day')]"));
	}

	public WebElement previousBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-up"));
	}

	public WebElement selectCurrentDate(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(@class,'uib-current')]"));
	}

	public WebElement nextBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("icon-solid-down"));
	}

	public WebElement errorMessageForDOB(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[contains(@data-ng-if,'.dob') and contains(text(),'This is required')]"));
	}

	public WebElement familyMemberEmailAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='email']"));
	}

	public WebElement addMemberInviteButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.glyphicon.glyphicon-envelope"));
	}

	public WebElement addMemberWithoutInviteButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.glyphicon.glyphicon-plus"));
	}

	public WebElement biologicalFather(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@id='father']//p)[1]"));
	}

	public WebElement biologicalMother(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@id='mother']//p)[1]"));
	}

	public List<WebElement> siblings(WebDriver driver) {
		return driver.findElements(By.xpath("//div[starts-with(@id,'sibling-')]//p[1]"));
	}

	public WebElement verifyMemberFamilyHistoryDetailText(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Family History Details')]"));
	}

	public WebElement sendReminder(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Send Reminder']"));
	}

	public WebElement verifyReminderSendSuccessfully(WebDriver driver) {
		return driver.findElement(By.cssSelector("label.modal-confirm-label.ng-binding"));
	}

	public WebElement submitSentReminderPopUp(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main-blue.bw-btn-rightside.filters"));
	}

	// Procedure
	public WebElement enableDateOfProcedure(WebDriver driver) {
		return driver.findElement(By.name("procedure_timestamp"));
	}

	public WebElement enableDisablePhysician(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.caret"));
	}

	public WebElement procedureValue(WebDriver driver) {
		return driver.findElement(By.name("procedureName"));
	}

	public WebElement submitProcedureInfo(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main-blue"));
	}

	public List<WebElement> getProcedureDates(WebDriver driver) {
		return driver.findElements(By.xpath("//span[contains(@data-ng-bind,'procedure.date')]"));
	}

	public List<WebElement> getProcedurePhysicians(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@data-ng-bind='procedure.physician']"));
	}

	public List<WebElement> getProcedureValue(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@data-ng-bind='procedure.type']"));
	}

	// Diagnosis
	public WebElement diagnosisAndSurgeryHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[@class='modal-title ng-binding']"));
	}

	public WebElement diagnosisNextBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']/.."));
	}

	public WebElement diagnosisPreviousBtn(WebDriver driver) {
		return driver.findElement(By.className("glyphicon glyphicon-chevron-left"));
	}

	public List<WebElement> diseaseList(WebDriver driver) {
		return driver.findElements(By.xpath("//label[contains(@class,'terms-checkbox')]"));
	}

	public List<WebElement> surgeriesMonthList(WebDriver driver) {
		return driver.findElements(By.xpath("//select[starts-with(@name,'month')]"));
	}

	public List<WebElement> surgeriesYearList(WebDriver driver) {
		return driver.findElements(By.xpath("//select[starts-with(@name,'year')]"));
	}

	public WebElement selectValidAge(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Please enter valid Month and Year.')]"));
	}

	public List<WebElement> additionTxtBoxesList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='error-wrapper ng-scope']//input"));
	}

	public List<WebElement> selectedDiseaseList(WebDriver driver) {
		return driver.findElements(By.xpath("//p[@class='quiz-que ng-binding']"));
	}

	public WebElement selectSubDiseaseOption(WebDriver driver, String diseaseName) {
		return driver.findElement(By.xpath("//select[contains(@id,'" + diseaseName + "')]"));
	}

	public WebElement subDiseaseOtherField(WebDriver driver) {
		return driver.findElement(By.name("other"));
	}

	public List<WebElement> selectDiseaseAtAge(WebDriver driver) {
		return driver.findElements(By.xpath("//select[@name='diseaseAge']"));
	}

	public List<WebElement> errorMessageForInvalidAge(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(text(),'Please select valid age group')]"));
	}

	public WebElement surgeryOption(WebDriver driver, boolean status) {
		WebElement element = null;
		if (status)
			element = driver.findElement(By.xpath("(//input[@name='questionThree'])[1]"));
		else
			element = driver.findElement(By.xpath("(//input[@name='questionThree'])[2]"));

		return element;
	}

	public WebElement tellUsMoreAboutSurgeries(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Tell us more about your surgeries')]"));
	}

	public WebElement thankYouSurveyMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='challenge-heading']"));
	}

	public WebElement submitDiagnosisDetail(WebDriver driver) {
		return driver.findElement(By.xpath(".//span[@class='glyphicon glyphicon-floppy-disk']/.."));
	}

	public WebElement hideSurveyThankYouPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='close-modal']"));
	}

	// fill medical form
	public WebElement fillOutInfoBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Fill out information']"));
	}

	public WebElement medicalHistoryQuestionnaireHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'Medical History Questionnaire')]"));
	}

	public WebElement race(WebDriver driver) {
		return driver.findElement(By.name("race"));
	}

	public WebElement ethnicity(WebDriver driver) {
		return driver.findElement(By.name("ethnicity"));
	}

	public WebElement weight(WebDriver driver) {
		return driver.findElement(By.name("weight"));
	}

	public WebElement heightFeet(WebDriver driver) {
		return driver.findElement(By.name("height_feet"));
	}

	public WebElement heightInches(WebDriver driver) {
		return driver.findElement(By.name("height_inches"));
	}

	public WebElement exercise(WebDriver driver) {
		return driver.findElement(By.name("exercise"));
	}

	public WebElement smoker(WebDriver driver) {
		return driver.findElement(By.name("smoker"));
	}

	public WebElement smokeFrequency(WebDriver driver) {
		return driver.findElement(By.name("smokeFrequency"));
	}

	public WebElement alcohol(WebDriver driver) {
		return driver.findElement(By.name("alcohol"));
	}

	public WebElement selectAllergies(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='allergy']//span[@class='caret']"));
	}

	public WebElement submitMedicalHistoryPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.large-btn.bw-btn-primary"));
	}

	public WebElement verifyMedicalnformationPageSubmitSuccessfully(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'successfully added')]"));
	}

	public WebElement submitMedicalInfoConfirmationPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-small.bw-btn-main"));
	}

	public List<WebElement> siblingBrothers(WebDriver driver) {
		return driver.findElements(By.xpath("//div[starts-with(@id,'sibling-')]//p[contains(text(),'Brother')]"));
	}

	public List<WebElement> siblingSisters(WebDriver driver) {
		return driver.findElements(By.xpath("//div[starts-with(@id,'sibling-')]//p[contains(text(),'Sister')]"));
	}

	public WebElement paternalGrandFather(WebDriver driver) {
		return driver.findElement(By.id("pgf-"));
	}

	public WebElement paternalGrandMother(WebDriver driver) {
		return driver.findElement(By.id("pgm"));
	}

	public WebElement maternalGrandFather(WebDriver driver) {
		return driver.findElement(By.id("mgf-1052"));
	}

	public WebElement maternalGrandMother(WebDriver driver) {
		return driver.findElement(By.id("mgm-"));
	}

	// >>>>>>>>>> My Doctor related data >>>>>>>>>>>>>>>>>>>>>
	public WebElement viewMyDoctorLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='View My Doctors']"));
	}

	public WebElement findDoctorSearchBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[contains(@placeholder,'Find a doctor by name or specialty')]"));
	}

	public WebElement doctorNegativeSearchResult(WebDriver driver) {
		return driver.findElement(By.cssSelector(".no-result-msg"));
	}

	public void waitForDoctorSearchBox(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[contains(@placeholder,'Find a doctor by name or specialty')]")));
	}

	public List<WebElement> helpSearchResultList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@data-ng-repeat='list in doctorDataList']//a"));
	}

	public List<WebElement> doctorList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='doc-detail-wrap']/h4"));
	}

	public List<WebElement> unFavoriteDoctorList(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@class='icon-favorite-heart-outline']/../..//h4"));
	}

	public WebElement selectProfileBasedOnDoctorFirstName(WebDriver driver, String doctorFName) {
		return driver.findElement(By.xpath("//div[@class='doc-detail-wrap']//h4//span[contains(text(),'" + doctorFName
				+ "')]/../..//a[@class='bw-btn bw-btn-primary']"));
	}

	public WebElement selectProfileBasedOnDoctor(WebDriver driver, String doctorName) {
		return driver.findElement(By.xpath("//div[@class='doc-detail-wrap']//h4//span[contains(text(),'" + doctorName
				+ "')]/../..//a[@class='bw-btn bw-btn-primary']"));
	}

	public WebElement getDoctorProfileHeaderStatus(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='doc-profile-head']//div)[1]"));
	}

	public List<WebElement> doctorSpecialityList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='doc-detail-wrap']/p[1]"));
	}

	public List<WebElement> doctorMilesList(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(text(),'Miles Away')]/..//h4"));
	}

	public List<WebElement> viewDoctorProfileList(WebDriver driver) {
		return driver.findElements(By.cssSelector("a.bw-btn.bw-btn-primary"));
	}

	public WebElement findADoctorLinkedText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Find a Doctor']"));
	}

	public WebElement addDoctorBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.icon-add-circle"));
	}

	public WebElement addADoctorPopUpHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[text()='Add a Doctor']"));
	}

	// Talk To A Doctor
	public WebElement talkToADoctor(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Talk to a Doctor Now')]"));
	}

	public WebElement finishPreVisitQuestion(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Finish Pre Visit Questions')]"));
	}

	public WebElement waitForQuizHeaderTxt(WebDriver driver) {
		return driver.findElement(By.id("quiz-headline"));
	}

	public WebElement selectYourPharmacyLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Select Your Pharmacy')]"));
	}

	public WebElement telemedicineConsultHeaderTxt(WebDriver driver) {
		return driver.findElement(By.cssSelector("h3.teladoc-text-title"));
	}

	public WebElement finishHealthAssessment(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Finish Health Assessment')]"));
	}

	public WebElement waitQuizQuesNumberTxt(WebDriver driver) {
		return driver.findElement(By.className("quiz-ques-num"));
	}

	public WebElement healthHistoryStep(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='healthHistoryStep']"));
	}

	public WebElement totalHealthHistoryStep(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='totalHealthHistorySteps']"));
	}

	public WebElement quizNextBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-up"));
	}

	public WebElement quizPreviousBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-down"));
	}

	public WebElement questionOneOfOneSelectFeet(WebDriver driver) {
		return driver.findElement(By.xpath("((//p[contains(text(),'What is Your Height?')]/..)[1]//select)[1]"));
	}

	public WebElement questionOneOfOneSelectInches(WebDriver driver) {
		return driver.findElement(By.xpath("((//p[contains(text(),'What is Your Height?')]/..)[1]//select)[2]"));
	}

	public WebElement questionOneOfTwoWeight(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//p[contains(text(),'What is your weight in pounds:')]/..//div[@id='2'])//input"));
	}

	public List<WebElement> questionOneOfFourSmokeTobacco(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'Do you smoke tobacco:')]/..//div[@id='4'])//input"));
	}

	public List<WebElement> questionOneOfFiveDrinkAlcoholWeight(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'Do you drink alcohol:')]/..//div[@id='5'])//input"));
	}

	public List<WebElement> questionTwoOfOneHealthStatus(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'In general, would you say your health is:')]/..)//input"));
	}

	public List<WebElement> questionTwoOfTwoLastCheckup(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'How long has it been since your last checkup?')]/..)//input"));
	}

	public List<WebElement> questionTwoOfThreeTakeMultivitamin(WebDriver driver) {
		return driver.findElements(By.xpath(
				"(//p[contains(text(),'How many years have you been taking multivitamin supplements?')]/..)//input"));
	}

	public List<WebElement> questionTwoOfFourLifestyleChangesToImproveHealth(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'do you want to make some small lifestyle changes')]/..)//input"));
	}

	public List<WebElement> questionTwoOfFiveFluVaccineLastYear(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'Did you receive a flu vaccine in the last year?')]/..)//input"));
	}

	public List<WebElement> questionTwoOfSixLabWork(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'Did you have any lab work done in the past year?')]/..)//input"));
	}

	public List<WebElement> questionTwoOfSevenConnectedDevices(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'Do you have a connected device?')]/..)//input"));
	}

	// Three
	public List<WebElement> questionThreeOfOneServingsOfFruits(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'How many servings of fruits')]/..)//input"));
	}

	public List<WebElement> questionThreeOfTwoServingVegetables(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'How many servings of vegetables')]/..)//input"));
	}

	public List<WebElement> questionThreeOfThreeEatWhiteMeat(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'eat white meat')]/..)//input"));
	}

	public List<WebElement> questionThreeOfFourEatRedMeat(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'eat red meat')]/..)//input"));
	}

	public List<WebElement> questionThreeOfFiveEatProcessedMeat(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'eat processed meat')]/..)//input"));
	}

	public List<WebElement> questionThreeOfSixEatGrainBreadWildRice(WebDriver driver) {
		return driver.findElements(By
				.xpath("(//p[contains(text(),'eat whole grain, whole-wheat cereal/bread, or brown/wild')]/..)//input"));
	}

	public List<WebElement> questionThreeOfSevenServingDifferntDairyMilk(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'servings of milk, dairy products')]/..)//input"));
	}

	// Question Four
	public List<WebElement> questionFourOfOneDifficultyInSleeping(WebDriver driver) {
		return driver
				.findElements(By.xpath("(//p[contains(text(),'Do you experience difficulty sleeping?')]/..)//input"));
	}

	public List<WebElement> questionFourOfTwoSleepRestless(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'sleep restles')]/..)//input"));
	}

	public List<WebElement> questionFourOfThreeFeelingRefreshedInMornings(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'feeling refreshed in the morning?')]/..)//input"));
	}

	public List<WebElement> questionFourOfFourSmokeCigarettesInYourLifeTime(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'at least 100 cigarettes')]/..)//input"));
	}

	public WebElement howOldYouStartSmoking(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'first started to smoke cigarettes')]/..)//input"));
	}

	public WebElement lastSmokedCigarette(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'last smoked cigarettes')]/..)//input"));
	}

	public WebElement errorMsgForInvalidAge(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'t exceed your current age.')]"));
	}

	public List<WebElement> questionFourOfFiveLikeBriskWalk(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),' brisk walk')]/..)//input"));
	}

	public WebElement questionFourOfFiveModerateToStrenuousHowManyMinuteDoExercise(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//p[contains(text(),'how many minutes, on average, do you exercise')]/..)//input"));
	}

	// Question five
	public List<WebElement> questionFiveOfOneUpsetSomethingHappenedUnexpected(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'upset because of something that happened unexpectedly')]/..)//input"));
	}

	public List<WebElement> questionFiveOfTwoUnableToControlImpThings(WebDriver driver) {
		return driver
				.findElements(By.xpath("(//p[contains(text(),'unable to control the important thing')]/..)//input"));
	}

	public List<WebElement> questionFiveOfThreeFeltNervousOrStressed(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'felt nervous or stressed')]/..)//input"));
	}

	public List<WebElement> questionFiveOfFour(WebDriver driver) {
		return driver
				.findElements(By.xpath("(//p[contains(text(),'cope with all the things you had to do')]/..)//input"));
	}

	public List<WebElement> questionFiveOfFiveYouNotOnTopOfThings(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'not on top of things')]/..)//input"));
	}

	// Six Of Six
	public WebElement questionOneOfSixWhatAgeYourMenstrualCycles(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'your menstrual cycles')]/..)//input"));
	}

	public List<WebElement> questionTwoOfSixHaveYouEverPregnant(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'pregnant')]/..)//input"));
	}

	public WebElement questionThreeOfSixAtWhatAgeYouFirstGetPregnant(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'first get pregnant')]/..)//input"));
	}

	public List<WebElement> questionFourOfSixGestationalHypertension(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'gestational hypertension')]/..)//input"));
	}

	public List<WebElement> questionFiveOfSixTumorInYourBreast(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'benign tumor in your breast')]/..)//input"));
	}

	public List<WebElement> questionSixOfSixMammogram(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'mammogram')]/..)//input"));
	}

	public WebElement submitFinishHealthAssessment(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-small.bw-btn-main.ng-scope"));
	}

	// Pre Visit Questions
	public List<WebElement> haveYouEverDisabledList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'disabled:')]/..)//input"));
	}

	public List<WebElement> faceOccupationalAsbestosList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'face occupational asbestos exposure')]/..)//input"));
	}

	public List<WebElement> faceOccupationalDieselList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'face occupational diesel')]/..)//input"));
	}

	public List<WebElement> faceRadonExposureList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'faced radon exposure')]/..)//input"));
	}

	public List<WebElement> faceOccupationalTobaccoList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'face occupational tobacco')]/..)//input"));
	}

	public List<WebElement> chronicConditionList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'chronic condition')]/..)//input"));
	}

	public List<WebElement> recreationalDrugsList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'recreational drugs')]/..)//input"));
	}

	public List<WebElement> traveledOverseasList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'traveled overseas')]/..)//input"));
	}

	public List<WebElement> yearlyFluShots(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'yearly flu shots')]/..)//input"));
	}

	public WebElement lastVisitToDoctor(WebDriver driver) {
		return driver.findElement(By.name("311"));
	}

	public WebElement selectLastVisitDate(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm active']"));
	}

	public List<WebElement> bloodInUrineList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'blood in urine')]/..)//input"));
	}

	public List<WebElement> feelBuringSlasPainList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'feel burning/pain while urinating')]/..)//input"));
	}

	public List<WebElement> urinateIn24HoursList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'urinate in 24 hour')]/..)//input"));
	}

	public List<WebElement> bladderSymptomsList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'bladder symptoms')]/..)//input"));
	}

	public List<WebElement> leakedUrineList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'leaked urine')]/..)//input"));
	}

	public List<WebElement> leakedUrineInLastThreeMonthsList(WebDriver driver) {
		return driver.findElements(
				By.xpath("(//p[contains(text(),'During the last 3 months, did you leak urine')]/..)//input"));
	}

	public List<WebElement> hoursOfSleepInNightList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'8 hours of sleep a night')]/..)//input"));
	}

	public List<WebElement> highBloodPressure(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'high blood pressure')]/..)//input"));
	}

	public List<WebElement> exerciseRegularlyList(WebDriver driver) {
		return driver.findElements(By.xpath("(//p[contains(text(),'exercise regularly')]/..)//input"));
	}

	public WebElement addDiseaseDropDown(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.icon-add-circle.multi-add-field"));
	}

	public WebElement selectDiseaseDropdownMenu(WebDriver driver, int index) {
		return driver.findElement(By.xpath("//select[starts-with(@id,'disease" + index + "')]"));
	}

	public WebElement addDiseasesDropdownList(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-add-circle.multi-add-field"));
	}

	public WebElement selectValidAgeErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Please select valid age group')]"));
	}

	public WebElement submitPreVisitQuestion(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-small.bw-btn-main.ng-scope"));
	}

	public WebElement thankYouMsgForCompletingPreVisitQuestions(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Thank you for completing Pre Visit Questions')]"));
	}

	public WebElement thankYouMsgForCompletingHealthAssessment(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Thank you for completing Health Assessment')]"));
	}

	public WebElement finalSubmitPreVisitQuestion(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	}

	public WebElement modifyPreVisitQuestions(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Modify')]"));
	}

	// TeleMedicine Consult
	public WebElement selectFamilyMemberForConsultation(WebDriver driver) {
		return driver.findElement(By.id("familyMember"));
	}

	public WebElement memberContactnumber(WebDriver driver) {
		return driver.findElement(By.name("phone"));
	}

	public WebElement consultationNextBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
	}

	public WebElement selectPharmacy(WebDriver driver) {
		return driver.findElement(By.name("pharmacy"));
	}

	public WebElement pharmacyNotBelongsYourState(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg top-margin']"));
	}

	public WebElement ageVerificationRelatedMessageWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector(".modal-confirm-label.big-label"));
	}

	public WebElement submitAgeVerificationRelatedMessageWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

	public WebElement addPhotoHeaderTxt(WebDriver driver) {
		return driver.findElement(By.cssSelector("h2.consultancy-heading"));
	}

	public WebElement addPhotoForConsultation(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.add-photo-placeholder>input"));
	}

	public WebElement maximumPhotoUploadLimitError(WebDriver driver) {
		return driver.findElement(
				By.xpath("//span[@class='ng-scope' and contains(text(),'Maximum Upload files size limit are 10 MB')]"));
	}

	public List<WebElement> verifyPhotoAdded(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@data-ng-repeat='photo in photos']"));
	}

	public WebElement TAndC(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Terms & Conditions')]"));
	}

	public List<WebElement> acceptTAndCCheckBoxes(WebDriver driver) {
		return driver.findElements(By.className("terms-checkbox"));
	}

	public List<WebElement> checkboxAcceptedList(WebDriver driver) {
		return driver.findElements(By.cssSelector("label.terms-checkbox.selected"));
	}

	public WebElement submitRequest(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Submit Request')]"));
	}

	// Telemedicine Confirmation Page
	public WebElement teleMedicineThankYouMsg(WebDriver driver) {
		return driver.findElement(By.cssSelector("h2.consultancy-success-heading"));
	}

	public WebElement telaDocPhysicianContactOnThisNumber(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@data-ng-bind='consultancyFormData.phoneNumber']"));
	}

	public WebElement confirmationNumber(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-if='!apiScheduleFailed']"));
	}

	public WebElement submitTeleMedicineThankYouPage(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Done']"));
	}

	// View Authorization
	public WebElement noDoctorFoundBasedOnFilter(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[text()='You have no medical authorizations that meet the filter criteria']"));
	}

	public List<WebElement> getDoctorListFromViewAuth(WebDriver driver) {
		return driver.findElements(By.xpath("//h4[@class='notify-title']//span"));
	}

	public List<WebElement> specialityListOnViewAuthorization(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(@data-ng-bind,'calculateSpeciality')]"));
	}

	public List<WebElement> medicalRecordsStatusListOnViewAuthorization(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(@data-ng-bind,'calculateSpeciality')]"));
	}

	public List<WebElement> authorizationStatusListOnViewAuthorization(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(@data-ng-bind,'calculateSpeciality')]"));
	}

	public WebElement viewAuthorizationBtnOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='View Authorization']"));
	}

	public WebElement viewAuthorizationBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'View Authorizations')]"));
	}

	public WebElement noDataInViewAuthorizationPage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[@class='no-result-msg' and text()='You have no medical authorizations']"));
	}

	public WebElement obtainingMedicalRecordsFormHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Obtaining medical records from:')]"));
	}

	public WebElement getDoctorNameInViewAuthorization(WebDriver driver, String doctorName) {
		return driver.findElement(
				By.xpath("//li[@data-ng-repeat='doctor in records']//h4//span[contains(text(),'" + doctorName + "')]"));
	}

	public WebElement getDoctorNameInAuthorizationList(WebDriver driver, String doctorName) {
		return driver.findElement(By
				.xpath("//li[@data-ng-repeat='doctor in records']//p[contains(text(),'Authorized')]/..//h4//span[contains(text(),'"
						+ doctorName + "')]"));
	}

	// public List<WebElement> getDoctorListWithoutAuthorized(WebDriver driver)
	// {
	// return driver.findElements(By.xpath("//li[@data-ng-repeat='doctor in
	// records']//p[2][not(contains(text(),'Authorized'))]"));
	// }

	public List<WebElement> getAuthorizedDoctorList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//li[@data-ng-repeat='doctor in records']//p[contains(text(),'Authorized')]/..//h4//span"));
	}

	public WebElement authorizedTextInsideDrNameInViewAuthorization(WebDriver driver, String doctorName) {
		return driver.findElement(By
				.xpath("(//li[@data-ng-repeat='doctor in records']//p[contains(text(),'Authorized')]/..//h4//span[contains(text(),'"
						+ doctorName + "')]/../../../..//div[@class='in collapse']//div[text()='Authorization'])[1]"));
	}

	public WebElement dateInsideDoctorViewAuthorization(WebDriver driver, String doctorName) {
		return driver.findElement(By
				.xpath("(//li[@data-ng-repeat='doctor in records']//p[contains(text(),'Authorized')]/..//h4//span[contains(text(),'"
						+ doctorName + "')]/../../../..//div[@class='in collapse']//div//div)[2]"));
	}

	public WebElement authorizedDoctorNextBtn(WebDriver driver, String doctorName) {
		return driver.findElement(By.xpath("//h4[@class='notify-title']//span[contains(text(),'" + doctorName
				+ "')]/../../..//span[contains(@class,'doc-detail-next')]"));
	}

	public WebElement revokeOnElement(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Revoked on')]"));
	}

	public WebElement authroizationOn(WebDriver driver, String doctorName) {
		return driver.findElement(By.xpath("//li[@data-ng-repeat='doctor in records']//h4//span[contains(text(),'"
				+ doctorName + "')]/..//following-sibling::p[contains(text(),'Authorized on')]"));
	}

	public List<WebElement> moveToAuthorizationDetailPage(WebDriver driver) {
		return driver.findElements(By.cssSelector(".doc-detail-next.icon-playback-play.right-arrow"));
	}

	public WebElement navigateToDownloadMedicalRecordsFilePage(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal.icon-file-download"));
	}

	public WebElement navigateToAuthorizationDetailPage(WebDriver driver, String doctorName) {
		return driver.findElement(By.xpath("//h4[@class='notify-title']//span[contains(text(),'" + doctorName
				+ "')]/../../..//span[contains(@class,'doc-detail-next')]"));
	}

	public WebElement downloadFileBtn(WebDriver driver) {
		return driver.findElement(By.id("download"));
	}

	// re authorize
	public WebElement reAuthorizedBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.ng-scope"));// (By.xpath("//button[text()='Reauthorize']"));
	}

	// Share Authorization
	public WebElement shareAuthorizationBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Share Authorization']"));
	}

	public WebElement shareAuthorizationHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[text()='Share Authorization']"));
	}

	public WebElement shareAuthorizationFName(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement shareAuthorizationLName(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement shareAuthorizationRelation(WebDriver driver) {
		return driver.findElement(By.name("relationship"));
	}

	public WebElement shareAuthorizationEmail(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public WebElement submitShareAuthorizationInfo(WebDriver driver) {
		return driver.findElement(By.cssSelector(".modal-footer-btn.text-center>button"));
	}

	public WebElement verifyConfirmMessageBeforeFinalShare(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[@class='onboarding-video-msg' and contains(text(),'Confirm by clicking')]"));
	}

	public WebElement finalShareAuthorization(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Got it, Send']"));
	}

	public WebElement revokeLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Revoke']"));
	}

	public WebElement revokeHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[text()='Are You Sure?']"));
	}

	public WebElement yesIAmSureBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn' and contains(text(),\"Yes, I'm Sure\")]"));
	}

	public WebElement cancelRevokeWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector(".cancel-link"));
	}

	public List<WebElement> getDoctorListInViewAuthorization(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@data-ng-repeat='doctor in records']//h4//span"));
	}

	// Fill Add Doctor Form
	public WebElement loaderImage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@ng-class='preloader']"));
	}

	public void waitImageLoaderToBeInvisible(WebDriver driver, int timeOutInSeconds) {
		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(loaderImage(driver)));
	}

	public void waitForElement(WebDriver driver, WebElement element, int timeOutInSeconds) {
		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement doctorFirstName(WebDriver driver) {
		return driver.findElement(By.name("first_name"));
	}

	public WebElement doctorLastName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='last_name']"));
	}

	public WebElement doctorPracticeName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='practice_name']"));
	}

	public WebElement doctorPhoneNumber(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement doctorAddressLine1(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Enter Address']"));
	}

	public WebElement doctorAddressLine2(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Enter Address 2']"));
	}

	public WebElement doctorCityName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='city']"));
	}

	public WebElement enableStateDropdownList(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Select State']"));
	}

	public WebElement reOpenDoctorState(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='state']//span[@class='caret']"));
	}

	public List<WebElement> doctorStateName(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='state in states']//a"));
	}

	public WebElement enableDoctorSpeciality(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='specialities']//span[@class='caret']"));
	}

	public WebElement closeDoctorSpecialityDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='specialities']//span[@class='caret']"));
	}

	public WebElement enableFindDoctorSpeciality(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select Speciality']//span[@class='caret']"));
	}

	public List<WebElement> selectDoctorSpecialty(WebDriver driver, String specialtyType) {
		return driver.findElements(By.xpath("//span[text()='" + specialtyType + "']/..//a"));
	}

	public List<WebElement> selectDoctorSpecialityFromList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='dropdown-header ng-binding']/..//a"));
	}

	public WebElement hideSpecialityListFromFindDoctor(WebDriver driver) {
		return driver.findElement(By.cssSelector(".search-head-icon"));
	}

	// Error Message Related for adding doctor with invalid data
	public List<WebElement> errorMessageForBlankTextBox(WebDriver driver) {
		return driver.findElements(By.xpath("//p[contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForFirstName(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.first_name') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForLastName(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.last_name') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForSpecialityName(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@data-ng-show,'doctorForm.specialities')]//p"));
	}

	public WebElement errorMessageForPracticeName(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[contains(@data-ng-if,'.phone') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForPhoneNumber(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[contains(@data-ng-if,'phone') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForAddress1(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.address_line_1') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForCity(WebDriver driver) {
		return driver
				.findElement(By.xpath("//p[contains(@data-ng-show,'.city') and contains(text(),'This is required.')]"));
	}

	public WebElement errorMessageForState(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@data-ng-show,'state')]"));
	}

	public WebElement errorMessageForZipCode(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-show,'.zipcode') and contains(text(),'This is required.')]"));
	}

	// For Invalid data
	public WebElement invalidDataForDoctorFNameErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//p[contains(@data-ng-show,'.first_name') and contains(text(),'Name can only be letters, dash and spaces.')]"));
	}

	public WebElement invalidDataForDoctorLNameErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//p[contains(@data-ng-show,'.last_name') and contains(text(),'Name can only be letters, dash and spaces.')]"));
	}

	public WebElement invalidPhoneNumberErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//p[contains(@data-ng-if,'.phone') and contains(text(),'Phone number should contain exactly 10 digits.')]"));
	}

	public WebElement invalidCityErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//p[contains(@data-ng-show,'.city') and contains(text(),'City should accept only characters')]"));
	}

	public WebElement invalidZipCodeErrorMessageForExactFiveDigit(WebDriver driver) {
		return driver.findElement(
				By.xpath("//p[contains(@data-ng-if,'.zip') and contains(text(),'Zip must be of exactly 5 digits.')]"));
	}

	public WebElement invalidZipCodeErrorMessageForOnlyForDigit(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Zip should contain only digits.')]"));
	}

	// Search Doctor
	public WebElement enableSelectMiles(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Select distance')]"));
	}

	public List<WebElement> selectMiles(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='ng-scope nya-bs-option']//a"));
	}

	public WebElement reOpenSelectMiles(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Miles')]"));
	}

	public WebElement doctorZipCode(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']"));
	}

	public WebElement closeDoctorRegistrationFormPopUp(WebDriver driver) {
		return driver.findElement(By.className("close-modal"));
	}

	public WebElement submitDoctorForm(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add Doctor')]"));
	}

	public WebElement isThisAHospital(WebDriver driver) {
		return driver.findElement(By.id("is_hospital"));
	}

	public WebElement hospitalCheckBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='is_hospital']/..//label//span"));
	}

	public WebElement isThisPrimaryLocation(WebDriver driver) {
		return driver.findElement(By.id("is_primary_location"));
	}

	public WebElement primaryLocationCheckBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='is_primary_location']/..//label//span"));
	}

	public WebElement backButtonOnSearchResultPage(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='icon-angle-right']"));
	}

	public WebElement errorMessageForInvalidAddress(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()=' Invalid address']"));
	}

	public WebElement searchButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Search']"));
	}

	public String searchButton() {
		return "bw-btn bw-btn-small bw-btn-main-blue";
	}

	public WebElement searchResultWithErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='no-result-msg']//span"));
	}

	public WebElement navigateToSearchDoctorPage(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Search Doctors']"));
	}

	// Medical Records
	public WebElement getMedicalRecordsOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Get Medical Records']"));
	}

	public WebElement medicalRecordWindowHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Want your medical records?')]"));
	}

	public WebElement hideWantYourMedicalRecords(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'No Thanks')]"));
	}

	// feedback survey form
	public WebElement feedbackSurveyHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[text()='Feedback Survey']"));
	}

	public List<WebElement> feedbackSurveyOptionsList(WebDriver driver) {
		return driver.findElements(By.xpath("(//label[contains(@class,'terms-checkbox quiz-radio-wrap ng-scope')])"));// ("//label[contains(@class,'terms-checkbox
																														// quiz-radio-wrap
																														// ng-scope')]"));
	}

	public WebElement checkCheckboxSelection(WebDriver driver, int index) {
		return driver
				.findElement(By.xpath(
						"(//label[contains(@class,'terms-checkbox quiz-radio-wrap ng-scope')])[" + (index + 1) + "]"))
				.findElement(By.xpath("//input[@type='checkbox']"));
	}

	public WebElement enterCheckboxInputValue(WebDriver driver, int index) {
		return driver
				.findElement(By.xpath(
						"(//label[contains(@class,'terms-checkbox quiz-radio-wrap ng-scope')])[" + (index + 1) + "]"))
				.findElement(By.xpath("//input[contains(@name,'other')]"));
	}

	public WebElement submitFeedbackSurveyWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector(".add-card-btn > button"));
	}

	public WebElement medicalRecordBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Get Medical Records')]"));
	}

	public WebElement medicalRecordAuthorizationHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Medical Record Authorization')]"));
	}

	public WebElement doctorNameOnMedicalRecordAuthorization(WebDriver driver, String doctorName) {
		return driver.findElement(By.xpath("//p[contains(text(),'" + doctorName + "')]"));
	}

	public WebElement acceptTAndChk(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Accept Terms & Conditions')]"));
	}

	public WebElement authorizationOn(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'Authorized On')]/..//p)[2]"));
	}

	public WebElement expiresOn(WebDriver driver) {
		return driver.findElement(By.xpath("(//p[contains(text(),'Expires On')]/..//p)[2]"));
	}

	public WebElement doSignature(WebDriver driver) {
		return driver.findElement(By.id("signature-pad"));
	}

	public WebElement clearSignature(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Clear']"));
	}

	public WebElement submitMedicalRecordAuthorizationWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	}

	public WebElement processObtainingMedicalRecordsFromDrList(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(@class,'bw-label bw-xsmall-label')]"));// ("div.main-content>div>p"));
	}

	// >>>>>>>>>> Doctor Profile Page >>>>>>>>>>>>.
	public WebElement medicalRecordLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Get Medical Records')]"));
	}

	public WebElement obtainingYourMedicalRecordBanner(WebDriver driver) {
		return driver.findElement(By.cssSelector(".notification-banner.yellow.ng-scope>p"));
	}

	public WebElement medicalRecordFromParaLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
	}

	public WebElement medicalRecordFromWhatDoesThisMeanLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'What does this mean?')]"));
	}

	public WebElement contactOfficeOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("(//button[starts-with(@class,'btn bw-btn-rightside filters')])[2]"));
	}

	public void waitForVisibleContactOfficeOnProfile(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(contactOfficeOnProfilePage(driver), "Contact Office"));
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Contact
		// Office')]")));
	}

	public WebElement doctorNameOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='doc-detail-wrap']/h4"));
	}

	public WebElement doctorSpecialityOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='doc-specialty-wrap']"));
	}

	public WebElement removeDoctorBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.icon-cross.icon-remove-doctor"));
	}

	public WebElement doctorContactNumberOnProfilePage(WebDriver driver) {
		return driver.findElement(By.cssSelector("p[class='doc-phone-number-wrap'] > a"));
	}

	public WebElement viewAuthorizatinBtnOnProfilePage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='doctor-detail-commands']//a[text()='View Authorization']"));
	}

	public WebElement favoriteIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='item-text-widget']//a"));
	}

	public WebElement addToFavoriteBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Add to Favorites']"));
	}

	public WebElement removeFromFavoriteBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Remove from Favorites']"));
	}

	public WebElement favouriteListOnViewDoctorPage(WebDriver driver, int indexValue) {
		return driver.findElement(By.xpath("(//div[@class='doc-detail-wrap']//p[2]//a)[" + (indexValue + 1) + "]"));
	}

	public WebElement addPCP(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'PCP')]"));
	}

	public WebElement PcpListOnViewDoctorPage(WebDriver driver, int indexValue) {
		return driver.findElement(By.xpath("(//div[@class='doc-detail-wrap']//p[2]//span)[" + (indexValue + 1) + "]"));
	}

	// Medications & Pharmacies
	public WebElement selectMedicationsAndPharmaciesSubLinks(WebDriver driver, String subLinkName) {
		if (subLinkName.contains("medication"))
			return driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Medications')]"));
		else if (subLinkName.contains("pricing"))
			return driver.findElement(
					By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Pricing Comparision')]"));
		else
			return driver.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Pharmacies')]"));
	}

	// Claims & Financial
	public WebElement selectClaimsAndFinancialsSubLinks(WebDriver driver, String subLinkName) {
		WebElement element = null;
		if (subLinkName.equalsIgnoreCase("overview"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Overview')]"));
		else if (subLinkName.equalsIgnoreCase("claim detail"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Claim Detail')]"));
		else if (subLinkName.equalsIgnoreCase("digital wallet"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Digital Wallet')]"));
		else if (subLinkName.equalsIgnoreCase("insurance plan"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Insurance Plans')]"));
		else if (subLinkName.equalsIgnoreCase("plan benefits"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Plan Benefits')]"));

		return element;
	}

	// Supports
	public WebElement selectSupportsSubLinks(WebDriver driver, String subLinkName) {
		WebElement element = null;
		if (subLinkName.contains("knowledge"))
			element = driver.findElement(
					By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Knowledge Center')]"));
		else if (subLinkName.contains("email"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Email Us')]"));
		else if (subLinkName.contains("live"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Live Chat')]"));
		else if (subLinkName.contains("schedule"))
			element = driver
					.findElement(By.xpath("//ul[@class='sub-items-wrap show']//a[contains(text(),'Schedule a Call')]"));

		return element;
	}

	public WebElement verifyNewAppointmentHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'New Appointment')]"));
	}

	public List<WebElement> appointmentDateList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//li[@data-ng-repeat='calendarDate in calendar']//p[@class='item-title ng-binding']"));
	}

	public List<WebElement> selectAppointment(WebDriver driver) {
		return driver.findElements(
				By.xpath("//li[@data-ng-repeat='calendarDate in calendar']//span[@class='icon icon-playback-play']"));
	}

	public String selectAppointment() {
		return "icon icon-playback-play";
	}

	public List<WebElement> selectRandomAppointment(WebDriver driver) {
		return driver.findElements(By.cssSelector(".list-controls span:nth-child(1)"));
	}

	public List<WebElement> selectAppointmentTimeList(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='list-content']//div[@class='item-title']//span[1])"));
	}

	public List<WebElement> selectAppointmentTimeSlot(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//li[@data-ng-repeat='appointment in availableAppointments']//span[@class='icon icon-playback-play']"));
	}

	public WebElement bestNoForReach(WebDriver driver) {
		return driver.findElement(By.name("phone"));
	}

	public WebElement enterBestNoForReachErrorMsg(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.error-msg.top-margin.ng-scope"));
	}

	public WebElement appointmentScheduleSuccessfully(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[@class='ng-binding alert-success alert' and contains(text(),'You have scheduled your appointment with b.well support!')]"));
	}

	public WebElement viewAppointmentBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='View Appointments']"));
	}

	public WebElement verifyScheduledAppointment(WebDriver driver, String apppointmentTime) {
		return driver
				.findElement(By.xpath("//li[@data-ng-repeat='appointment in myAppointments']//span//p[contains(text(),'"
						+ apppointmentTime + "')]"));
	}

	public List<WebElement> scheduledAppointmentDeleteBtnList(WebDriver driver) {
		return driver.findElements(By.cssSelector("span.icon-android-remove-circle"));
	}

	public String deleteScheduledAppointmentBtnList() {
		return "icon-android-remove-circle";
	}

	public WebElement appointmentHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[text()='Appointments']"));
	}

	public WebElement verifyCancelAppointmentWindowMsg(WebDriver driver, String apppointmentTime) {
		return driver
				.findElement(By.xpath("//li[@data-ng-repeat='appointment in myAppointments']//span//p[contains(text(),'"
						+ apppointmentTime + "')]"));
	}

	public WebElement verifyAppointmentBeforeDelete(WebDriver driver, String scheduledAppointment) {
		return driver.findElement(By.xpath("//h3[contains(text(),'" + scheduledAppointment + "')]"));
	}

	public WebElement removeAppointmentBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

	public String removeAppointmentBtn() {
		return "bw-btn bw-btn-main bw-btn-blue";
	}

	// >>>>>>>>>> Medications & Pharmacies >>>>>>>>>>>>
	public WebElement addMedicationBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public WebElement addMedicationHeaderTxt(WebDriver driver) {
		return driver
				.findElement(By.xpath("//h3[@class='modal-title ng-binding' and contains(text(),'Add Medication')]"));
	}

	public WebElement enableMedicationTypeOption(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@id='prescription-category']//span[@class='caret']"));
	}

	public WebElement selectMedicationTypeValue(WebDriver driver, String type) {
		WebElement element = null;
		if (type.contains("pre"))
			element = driver.findElement(By.xpath("(//li[@data-value='category.id']//a)[1]"));
		else
			element = driver.findElement(By.xpath("(//li[@data-value='category.id']//a)[2]"));
		return element;
	}

	public WebElement enableDragNameOption(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@id='prescription-value']//span[@class='caret']"));
	}

	public WebElement searchDragName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Search for medications']"));
	}

	public List<WebElement> getDrugList(WebDriver driver) {
		return driver.findElements(By.cssSelector("div.drug-basic-details p:nth-child(1)"));
	}

	public List<WebElement> drugList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='ng-binding ng-scope']"));
	}

	public WebElement verifySelectedDrugValue(WebDriver driver, String selectedDrugName) {
		return driver.findElement(
				By.xpath("//ol[@id='prescription-value']//span[contains(text(),'" + selectedDrugName + "')]"));
	}

	public WebElement enableDosageOption(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@id='prescription-dosage']//span[@class='caret']"));
	}

	public WebElement verifyDrugDosageWindowOpen(WebDriver driver, String drugName) {
		return driver.findElement(
				By.xpath("//p[contains(@class,'dosage-medication') and contains(text(),'" + drugName + "')]"));
	}

	public List<WebElement> drugDosageList(WebDriver driver) {
		return driver.findElements(By.xpath("//ul[@class='presc-selection-sub-list']//li"));
	}

	public WebElement verifySelectDrugDosageValue(WebDriver driver, String dosageValue) {
		return driver
				.findElement(By.xpath("//ol[@id='prescription-dosage']//span[contains(text(),'" + dosageValue + "')]"));
	}

	public WebElement drugQuantity(WebDriver driver) {
		return driver.findElement(By.name("quantity"));
	}

	public WebElement drugInstructions(WebDriver driver) {
		return driver.findElement(By.name("instructions"));
	}

	public WebElement enableRelatedConditionOption(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='allergy']//span[@class='caret']"));
	}

	public List<WebElement> relatedConditionList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='condition in conditions.relatedConditions']//a"));
	}

	public WebElement verifySelectedRelatedConditions(WebDriver driver, List<String> relatedConditionsList) {
		return driver.findElement(
				By.xpath("//ol[@name='allergy']//span[contains(text(),'" + relatedConditionsList.get(0) + "')]"));
	}

	public WebElement searchDoctorName(WebDriver driver) {
		return driver.findElement(By.name("doctor"));
	}

	public WebElement clickOnAddDoctorFromMedication(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Add a Doctor']"));
	}

	public List<WebElement> doctorListOnSearch(WebDriver driver) {
		return driver.findElements(By.xpath("//li[starts-with(@id,'typeahead')]//span"));
	}

	public WebElement enablePrescribedDate(WebDriver driver) {
		return driver.findElement(By.name("prescribed_date"));
	}

	public WebElement selectPrescribedDate(WebDriver driver) {
		return driver
				.findElement(By.xpath("//button[@class='btn btn-default btn-sm active']/../preceding-sibling::td[1]"));
	}

	public WebElement selectPrescribeAndRefillDate(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.btn-default.btn-sm.active>span"));
	}

	public WebElement enableLastRefillDate(WebDriver driver) {
		return driver.findElement(By.name("last_fill"));
	}

	public WebElement enableRefillsRemaining(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@name='fills_remain']//span[@class='caret']"));
	}

	public List<WebElement> refillRemainingList(WebDriver driver) {
		return driver.findElements(By.xpath("//ol[@name='fills_remain']//a[not(contains(text(),'0'))]"));
	}

	public WebElement verifySelectRefillRemainingValue(WebDriver driver, String refillValue) {
		return driver.findElement(By.xpath("//ol[@name='fills_remain']//span[contains(text(),'" + refillValue + "')]"));
	}

	public WebElement enterRxNumber(WebDriver driver) {
		return driver.findElement(By.name("rxId"));
	}

	public WebElement enablePharmacyOption(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select Pharmacy']//span[@class='caret']"));
	}

	public List<WebElement> pharmaciesList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='pharmacy in pharmacies']//a"));
	}

	public WebElement filterBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("i.icon-wine-glass"));
	}

	public WebElement pharmacySearchHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Search Results')]"));
	}

	public List<WebElement> pharmaciesListOnPharmaciesPage(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='pharmacy-detail-wrap']//h2"));
	}

	public WebElement heartIconBasedOnPharmacy(WebDriver driver, String pharmacyName) {
		return driver.findElement(By.xpath("//div[@class='pharmacy-detail-wrap']//h2[text()='" + pharmacyName
				+ "']/../..//a[contains(@class,'heart-icon')]"));
	}

	public List<WebElement> stateListFromPharmacyList(WebDriver driver) {
		return driver.findElements(By.xpath("//address//span[@data-ng-bind='pharmacy.state']"));
	}

	public WebElement verifySelectedPharmacyName(WebDriver driver, String pharmacyName) {
		return driver
				.findElement(By.xpath("//ol[@title='Select Pharmacy']//span[contains(text(),'" + pharmacyName + "')]"));
	}

	public WebElement addPhoto(WebDriver driver) {
		return driver.findElement(By.id("profile-pic"));
	}

	public WebElement submitAddMedication(WebDriver driver) {
		return driver.findElement(By.cssSelector("div.bottom-section>button"));
	}

	// >>>>>>>> Medication Detail Page >>>>>>>>>>>>
	public WebElement activeMedications(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[contains(text(),'Active Medications')]//span[contains(@class,'caret')]"));
	}

	public WebElement historicalMedications(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[contains(text(),'Historical Medications')]//span[contains(@class,'caret')]"));
	}

	public List<WebElement> medicationTermNameList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//li[contains(@data-ng-repeat,'medication in clinical')]//span[@class='type-left per ng-scope']"));
	}

	public WebElement searchBoxOnMedicationPage(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='form-group search-form-wrap'] > input"));
	}

	public WebElement noResultOnSearch(WebDriver driver) {
		return driver.findElement(By.cssSelector("p.no-result-msg"));
	}

	public WebElement medicationDetailBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Medication Detail')]"));
	}

	public WebElement removeMedicationButtomBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='meds-btns']//button[contains(text(),'Remove Medication')]"));
	}

	public WebElement removeMedicationBtnRightSide(WebDriver driver) {
		return driver
				.findElement(By.xpath("//div[@class='rightmost-side']//button[contains(text(),'Remove Medication')]"));
	}

	public WebElement confirmMessageBeforeDeleteMedication(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Are you sure you want to remove')]"));
	}

	public WebElement submitDrugDeleteAlertWindow(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[contains(@class,'modal-footer')]//button)[1]"));
	}

	public List<WebElement> prescriptionNameList(WebDriver driver) {
		return driver.findElements(By.xpath("//p[@data-ng-bind='prescription.pharmaceutical.name']"));
	}

	public WebElement selectPrescriptionNameFromList(WebDriver driver, String prescriptionName) {
		return driver.findElement(By.xpath("//p[@data-ng-bind='prescription.pharmaceutical.name' and contains(text(),'"
				+ prescriptionName + "')]"));
	}

	public WebElement prescribeNameOnDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='prescr-name']//h3"));
	}

	public WebElement getDrugDosageFromDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//ul[@class='prescr-list clearfix']//h4[contains(text(),'Dosage')]/..//p"));
	}

	public WebElement getDrugQuantityFromDetailPage(WebDriver driver) {
		return driver
				.findElement(By.xpath("//ul[@class='prescr-list clearfix']//h4[contains(text(),'Quantity')]/..//p"));
	}

	public WebElement isGenericAvailable(WebDriver driver) {
		return driver.findElement(
				By.xpath("//ul[@class='prescr-list clearfix']//h4[contains(text(),'Generic Available')]/..//p"));
	}

	public WebElement getPrescriberFromDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Prescriber:')]/.."));
	}

	public WebElement getRxNumber(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@ng-if='medicationData.rx_id']//span[not(contains(text(),'Rx#:'))]"));
	}

	public WebElement getRefillRemaining(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//p[@data-ng-if='overviewInfo.prescriptionFill.refills_remaining']//span[not(contains(text(),'Refill'))]"));
	}

	public WebElement editMedicationBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Edit Medication')]"));
	}

	// >>>>>>>>>>>>>>>>>. Pharmacy page >>>>>>>>>>>>
	public WebElement noPharmaciesInYourAccount(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'No pharmacies are saved to your account')]"));
	}

	// Pharmacy filter
	public List<WebElement> getZipCodeList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@data-ng-bind='pharmacy.zipcode']"));
	}

	public WebElement pharmacyFilterZipcode(WebDriver driver) {
		return driver.findElement(By.name("zipcode"));
	}

	public WebElement enableSelectRadiusDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select Radius']//span[@class='caret']"));
	}

	public List<WebElement> selectRadiusDropdownValueList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='radius in radiusChoices track by radius.id']//a"));
	}

	public WebElement pharmacySearchBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Search Pharmacies']"));
	}

	public WebElement addPharmacyBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public WebElement pharmacyHeaderTxt(WebDriver driver) {
		return driver.findElement(By.cssSelector("h3.modal-title"));
	}

	public WebElement hideAddPharmacyWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}

	public WebElement pharmacyName(WebDriver driver) {
		return driver.findElement(By.name("name"));
	}

	public WebElement pharmacyAddress1(WebDriver driver) {
		return driver.findElement(By.name("address_1"));
	}

	public WebElement pharmacyAddress2(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@data-ng-model='pharmacy.address_2']"));
	}

	public WebElement pharmacyCityName(WebDriver driver) {
		return driver.findElement(By.name("city"));
	}

	public WebElement pharmacyStateName(WebDriver driver) {
		return driver.findElement(By.name("state"));
	}

	public WebElement pharmacyZip(WebDriver driver) {
		return driver.findElement(By.name("zip"));
	}

	public WebElement pharmacyPhoneNumber(WebDriver driver) {
		return driver.findElement(By.name("phone"));
	}

	public WebElement submitPharmacy(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Add Pharmacy']"));
	}

	public WebElement verifyAddedPharmacyAfterSubmitPharmacyInfo(WebDriver driver, String pharmacyName) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + pharmacyName + "')]"));
	}

	public WebElement verifyPharmacyNameOnPharmacyDetailPage(WebDriver driver, String pharmacyName) {
		return driver.findElement(By.xpath("//h2[contains(text(),'" + pharmacyName + "')]"));
	}

	public WebElement addToFavouritePharmacyBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Add to Favorites']"));
	}

	public WebElement removeFromFavouriteBtnOnPharmacyDetailPage(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Remove from Favorites']"));
	}

	public WebElement heartIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(@class,'heart-icon')]"));
	}

	public WebElement heartIconWithoutChecked(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(@class,'heart-outline')]"));
	}

	public WebElement heartIconWithChecked(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(@class,'icon-heart')]"));
	}

	public WebElement previousBtnOnPharmacyPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-down"));
	}

	public WebElement nextBtnOnPharmacyPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".icon-solid-up"));
	}

	// filter for medication
	public WebElement filterResetLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Reset Filters')]"));
	}

	public WebElement enableSelectMedicationDropdownList(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select Medications']//span[@class='caret']"));
	}

	public List<WebElement> getDrugListFromSelectMedicationDropDown(WebDriver driver) {
		return driver.findElements(
				By.xpath("//li[@nya-bs-option='medication in pharmaceuticalChoices track by medication.id']//a"));
	}

	// Price Comparision
	public WebElement searchTxtBox(WebDriver driver) {
		return driver.findElement(By.name("search"));
	}

	public WebElement getMedicineDosage(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='pricingData.dosage']"));
	}

	public WebElement getMedicineName(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='pricingData.name']"));
	}

	public WebElement getMedicineQuantity(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='pricingData.quantity']"));
	}

	public WebElement getMedicineType(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@data-ng-bind='pricingData.form']"));
	}

	public List<WebElement> getMedicinePharmaciesList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//ul[@class='prescription-pricing-list']//li[@data-ng-bind='priceEntry.pharmacy']"));
	}

	public List<WebElement> getMedicinePriceList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//ul[@class='prescription-pricing-list']//li//span[contains(@class,'pricing-currency')]"));
	}

	public WebElement warningMessageOnMedicinePricePage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".warning-alert.pricing-warning"));
	}

	// Recent Encounter
	public WebElement recentEncounterHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[@class='modal-title ng-binding']"));
	}

	public WebElement enableRecentEncounterDateView(WebDriver driver) {
		return driver.findElement(By.name("encounterDate"));
	}

	public WebElement selectCurrentEncounterDate(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm active']"));
	}

	public WebElement enablePhysicianDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("(//ol[@Data-ng-model='formData.physician']//span)[3]"));
	}

	public List<WebElement> physicianList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='physician in physicians']//a"));
	}

	public WebElement enableVisitDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("(//ol[@Data-ng-model='formData.visitType']//span)[3]"));
	}

	public List<WebElement> visitList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='type in visitTypes']//a"));
	}

	public WebElement instructionsTxtBox(WebDriver driver) {
		return driver.findElement(By.name("instructions"));
	}

	public WebElement followUpPlanTxtBox(WebDriver driver) {
		return driver.findElement(By.name("followUpPlans"));
	}

	public WebElement submitRecentEncounterPage(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='bw-btn bw-btn-main-blue']"));
	}

	// >>>>>>>>> For Topfan >>>>>>>>>>>>>>
	public WebElement knowledgeTextLinkText(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Knowledge Test')]"));
	}

	public WebElement knowledgeTestHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h4[text()='Knowledge Test']"));
	}

	public List<WebElement> checkboxList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='checkbox']//input"));
	}

	public WebElement aboutIndianClassicalMusic(WebDriver driver) {
		return driver.findElement(By.xpath("//textarea[starts-with(@id,'custom_form_custom_fields_')]"));
	}

	public WebElement selectMusician(WebDriver driver) {
		return driver.findElement(By.className("selectpicker"));
	}

	public WebElement enterDob(WebDriver driver) {
		return driver.findElement(By.xpath("//input[starts-with(@id,'custom_form_custom_fields_attributes_3_value')]"));
	}

	public WebElement enterName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[starts-with(@id,'custom_form_custom_fields_attributes_4_value')]"));
	}

	public WebElement submitKnowledgeTestForm(WebDriver driver) {
		return driver.findElement(By.className("red-button"));
	}

	public WebElement alertPopupHeaderText(WebDriver driver) {
		return driver.findElement(By.xpath("//h4[text()='Thank You']"));
	}

	public WebElement submitAlertPopup(WebDriver driver) {
		return driver.findElement(By.className("red-button"));
	}

	// Notification
	public WebElement notificationIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='icon-notification']"));
	}

	public WebElement notificationCount(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(@class,'count-badge')]"));
	}

	public WebElement clearAllNotification(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='remove-notify-link']"));
	}

	public List<WebElement> noOfNotification(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='notification-tile ng-scope']"));
	}

	// Health Tribe
	public WebElement healthTribeAddBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add Tribe Member')]"));
	}

	public WebElement addHealthTribeMemberFromRightSide(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='rightmost-side']//button)[1]"));
	}

	public WebElement addHealthTribeMemberHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Add Tribe Member')]"));
	}

	public WebElement healthTribeRelationship(WebDriver driver) {
		return driver.findElement(By.name("relationship"));
	}

	public WebElement healthTribeLname(WebDriver driver) {
		return driver.findElement(By.name("lastName"));
	}

	public WebElement addTribeMemberPic(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='file']"));
	}

	public WebElement healthTribeFname(WebDriver driver) {
		return driver.findElement(By.name("firstName"));
	}

	public WebElement healthTribeEmailAddress(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}

	public List<WebElement> shareOptList(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@data-ng-repeat='section in healthTribeData.sectionChoices']/span"));// ("//ul[@class='stats-settings
																														// health-tribe-profile-settings
																														// add-tb-form-checks']//li[@data-ng-repeat='section
																														// in
																														// healthTribeData.sectionChoices']/span"));
	}

	public List<WebElement> viewOptList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//li[@data-ng-repeat='section in healthTribeData.sectionChoices']/span/../div[@class='permission-checks']//span[contains(text(),'View')]/..//div[@class='control-indicator']"));
	}

	public List<WebElement> editOptList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//li[@data-ng-repeat='section in healthTribeData.sectionChoices']/span/../div[@class='permission-checks']//span[contains(text(),'Edit')]/..//div[@class='control-indicator']"));
	}

	public WebElement selectLikeToShareViewOptions(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[contains(text(),'View')]/..//div)[1]"));
	}

	public WebElement selectLikeToShareEditOptions(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[contains(text(),'Edit')]/..//div)[1]"));
	}

	public WebElement editPermissionToHTMMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@data-ng-bind='extraWarningMessage']"));
	}

	public WebElement givePermissionToHTM(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Yes']"));
	}

	public WebElement rejectPermissionToHTM(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Yes']"));
	}

	public WebElement healthTribeInviteBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='bw-btn bw-btn-main-blue big-btn']"));
	}

	public WebElement verifyHealthTribeInviteMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Health Tribe Invite Sent')]"));
	}

	public WebElement healthTribeGotItBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

	// Invites Related
	public WebElement invitationRecievedWindowMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[@class='modal-small-text mt-20']"));
	}

	public WebElement viewInvites(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='View Invites']"));
	}

	public WebElement notViewInvites(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Not Now']"));
	}

	// public WebElement rejectInvites(WebDriver driver) {
	// return driver.findElement(By.xpath("//button[text()='Not Now']"));
	// }

	public WebElement healthTribeCodeBtn(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class='rightmost-side']//button)[2]"));
	}

	public WebElement healthTribeCodeHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'Enter Code')]"));
	}

	public WebElement healthTribeCodeTxtBox(WebDriver driver) {
		return driver.findElement(By.name("code"));
	}

	public WebElement closeHealthTribeCodeWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.close-modal"));
	}

	public WebElement submithealthTribeCodeWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	}

	public WebElement wrongHealthTribeAppliedErrorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg top-margin ng-binding']"));
	}

	public WebElement healthTribeInvalidCodeLength(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='error-msg top-margin ng-scope']"));
	}

	public WebElement codeAppliedSuccessfully(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='congratulations']"));
	}

	public WebElement memberAddedSuccessfullyMsgWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='You just joined the health tribe of']"));
	}

	public WebElement submitAppliedCodeSuccessfullWindow(WebDriver driver) {
		return driver.findElement(By.cssSelector("a.bw-btn.bw-cancel"));
	}

	public WebElement searchTribeMember(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Find someone in your tribe']"));
	}

	public WebElement deleteTribeMember(WebDriver driver) {
		return driver.findElement(By.className("icon-cross red-bg"));
	}

	public List<WebElement> addedTribeMemberInfo(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='doc-detail']//a"));
	}

	public List<WebElement> HealthTribeMemberList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//h3[contains(text(),'Health Tribe Members')]/..//div[@class='doc-detail']//a"));
	}

	public WebElement removeTribeMemberBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Remove Tribe Member')]"));
	}

	public WebElement verifyTribeMemberMessageBeforeDelete(WebDriver driver, String accName) {
		return driver.findElement(
				By.xpath("//h3[contains(text(),'Do you want to remove " + accName + " from health tribe?')]"));
	}

	public WebElement submitTribeMemberDeleteWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
	}

	public WebElement updateTribeMemberInfo(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
	}

	public List<WebElement> invitationBtnList(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='icon-cross red-bg']"));
	}

	public WebElement noResultFound(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='no-result-msg']"));
	}

	public List<WebElement> sentInvitationList(WebDriver driver) {
		return driver
				.findElements(By.xpath("//h3[contains(text(),'Sent Invitations')]/..//div[@class='doc-detail']//a"));
	}

	public List<WebElement> sentInvitationDeleteBtnList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//h3[contains(text(),'Sent Invitations')]/..//div[@class='doc-detail']//a/../../..//span[@class='icon-cross red-bg']"));
	}

	public List<WebElement> receivedInvitationList(WebDriver driver) {
		return driver.findElements(
				By.xpath("//h3[contains(text(),'Received Invitations')]/..//div[@class='doc-detail']//a"));
	}

	public List<WebElement> receivedInvitationAcceptBtnList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//h3[contains(text(),'Received Invitations')]/..//div[@class='doc-detail']//a/../../..//span[@class='icon-check blue-bg']"));
	}

	public List<WebElement> receivedInvitationDeleteBtnList(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//h3[contains(text(),'Received Invitations')]/..//div[@class='doc-detail']//a/../../..//span[@class='icon-check red-bg']"));
	}

	public WebElement joinHealthTribeOfUser(WebDriver driver, String sendInvitesUserName) {
		return driver.findElement(
				By.xpath("//p[contains(text(),'You just joined the health tribe of " + sendInvitesUserName + "')]"));
	}

	public WebElement receiverInvitesAcceptSuccessfully(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='objective-msg challenge-title']"));
	}

	public WebElement closeSwitchToHisAccWindow(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Done']"));
	}

	public WebElement switchToReceiverAcc(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='bw-btn bw-btn-small bw-btn-main']"));
	}

	public WebElement getSendInvitesFromReciverToSender(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='name']"));// div[@class='doc-detail
																	// user-profile-detail
																	// profile-description-panel']//a
	}

	public WebElement sendInvitesFromReciverToSender(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Yes']"));
	}

	public WebElement cancelInvitesToSender(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Not Now']"));
	}

	public WebElement msgBeforeDeleteInvitation(WebDriver driver) {
		return driver
				.findElement(By.xpath("//h3[contains(text(),'Are you sure you want to cancel this invitation ?')]"));
	}

	public WebElement yesIAmSureSentBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),\"Yes, I'm Sure\")]"));
	}

	public List<WebElement> getHealthTribeInvitationMailLink(WebDriver driver) {
		return driver.findElements(
				By.xpath("//span[@class='lms' and contains(text(),'Been Invited to Join the Health Tribe')]"));
	}

	public WebElement getHelathTribeMemberPassword(WebDriver driver) {
		return driver.findElement(By
				.xpath("//div[@id='mailmillieu']//center//tr//td[contains(text(),'If you would chose to register')]"));
	}

	// Payment Related
	public WebElement changePaymentMethodBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Change Payment Method')]"));
	}

	public WebElement changePaymentHeaderTxt(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Manage Your Payment Method')]"));
	}

	public List<WebElement> paymentCardCount(WebDriver driver) {
		return driver.findElements(By.cssSelector(".payment-card-wrapper"));
	}

	public WebElement addCardBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.bw-btn-rightside.filters"));
	}

	public WebElement backToProfilePageBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".back-nav-link"));
	}

	public WebElement backToChangePaymentMethodPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".back-nav-link"));
	}

	// Card Information
	public WebElement cardNumber(WebDriver driver) {
		return driver.findElement(By.name("cardNumber"));
	}

	public WebElement enableExpirationMonthValue(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Month']//span[@class='caret']"));
	}

	public List<WebElement> monthValues(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='month in months']//a"));
	}

	public WebElement enableExpirationYearValue(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Year']//span[@class='caret']"));
	}

	public List<WebElement> yearValues(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='year in nextYears']//a"));
	}

	public WebElement cardCVCNumber(WebDriver driver) {
		return driver.findElement(By.name("cvc"));
	}

	public WebElement enablePromoCodeTxtBox(WebDriver driver) {
		return driver.findElement(By.cssSelector(".terms-checkbox.credit-card-checkbox"));
	}

	public WebElement enableDisablePromoCode(WebDriver driver) {
		return driver.findElement(By.xpath("(//label[contains(@class,'terms-checkbox credit-card-checkbox')])[1]"));
	}

	public WebElement promoCode(WebDriver driver) {
		return driver.findElement(By.name("couponCode"));
	}

	public WebElement promoCodeWhileUpdatingSubscription(WebDriver driver) {
		return driver.findElement(By.name("promoCode"));
	}

	// Billing Information
	public WebElement cardHolderName(WebDriver driver) {
		return driver.findElement(By.name("addressOne"));
	}

	public WebElement enableDisableHomeAddressCheckBox(WebDriver driver, String toggleOptions) {
		WebElement element = null;
		element = driver.findElement(By.xpath("(//label[contains(@class,'terms-checkbox credit-card-checkbox')])[2]"));
		// if (toggleOptions.equalsIgnoreCase("true"))
		// element = driver.findElement(By.className("terms-checkbox
		// credit-card-checkbox ng-scope selected"));
		// else
		// element = driver.findElement(By.className("terms-checkbox
		// credit-card-checkbox ng-scope"));

		return element;
	}

	public WebElement billingAddress1(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='form-group']//input[@name='addressOne']"));
	}

	public String billingAddress1() {
		return "addressOne";
	}

	public WebElement billingAddress2(WebDriver driver) {
		return driver.findElement(By.name("addressTwo"));
	}

	public WebElement billingCityName(WebDriver driver) {
		return driver.findElement(By.name("city"));
	}

	public String billingCityName() {
		return "city";
	}

	public WebElement getBillingState(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='State']//span[@class='pull-left filter-option']"));
	}

	public String getBillingState() {
		return "pull-left filter-option";
	}

	public WebElement enableBillingStateValue(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='State']//span[@class='caret']"));
	}

	public List<WebElement> stateValues(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@nya-bs-option='type in stateOptions']//a"));
	}

	public WebElement billingZipCode(WebDriver driver) {
		return driver.findElement(By.name("zipCode"));
	}

	public String billingZipCode() {
		return "zipCode";
	}

	public WebElement savePaymentMethodBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn btn-primary account-btn']"));
	}

	public WebElement verifySubscriptionPlanChangeFrom(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(@class,'modal-confirm-label ng-binding')]"));
	}

	public WebElement changePlanBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Change Plan')]"));
	}

	public WebElement changePlanHeaderTxt(WebDriver driver) {
		return driver
				.findElement(By.xpath("//h2[contains(text(),'Choose the subscription plan that is right for you')]"));
	}

	public List<WebElement> selectSubscriptionOption(WebDriver driver) {
		return driver.findElements(By.className("custom-radio-btn"));
	}

	public WebElement enterCCNumberForChangePlan(WebDriver driver) {
		return driver.findElement(By.name("cardNumber"));
	}

	// Add Registration Code
	public WebElement addRegistrationCodeBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add Registration Code')]"));
	}
	
	public WebElement enterRegistrationCode(WebDriver driver) {
		return driver.findElement(By.name("companyCode"));
	}
	
	public WebElement submitRegistration(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Done']"));
	}

	public WebElement successMsg(WebDriver driver) {
		return driver.findElement(By.cssSelector(".text-center.bold-font"));
	}
	
	public WebElement subscriptionUpdateMsgPopUp(WebDriver driver) {
		return driver.findElement(By.cssSelector(".modal-confirm-label.ng-binding"));
	}
	
	public WebElement submitSuccessMsgPopUp(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}
	
	// Unsubscribe related
	public WebElement unsubscribeBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Unsubscribe')]"));
	}

	public WebElement unsubscribeSubscriptionMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'Your subscription is valid until ')]"));
	}

	public WebElement submitUnsubscibe(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

	public WebElement cancelUnsubscribe(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-cancel"));
	}

	public WebElement quizHeadline(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='quiz-headline']"));
	}

	public List<WebElement> subscriptionQuestionCheckboxesList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@data-ng-repeat='reason in reasons']//label"));
	}

	public List<WebElement> subscriptionQuestionHeader(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@data-ng-repeat='reason in reasons']//label//span"));
	}

	public WebElement missingFunctionalityTxtBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='missing_functionality']"));
	}

	public WebElement otherReasonTxtBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='other_reason']"));
	}

	public WebElement errorMessageForUnSelectingChechboxes(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'This is required')]"));
	}

	public List<WebElement> checkBoxListForSecondQuestion(WebDriver driver) {
		return driver.findElements(By.xpath("//label[@class='quiz-radio-wrap']"));
	}

	public WebElement submitCancellingSubscriptionPage(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

	public WebElement verifyAutomaticallyLogoutMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'You will be automatically')]"));
	}

	public WebElement logoutUnsubscribeUser(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Log Out')]"));
	}

	// Subscribe Again
	public WebElement subscribeNowBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Subscribe Now!')]"));
	}

	public List<WebElement> subscriptionPlan(WebDriver driver) {
		return driver.findElements(By.xpath("//label[contains(@class,'custom-radio-wrap')]"));// (By.xpath("//label[@class='custom-radio-wrap']"));
	}

	public List<WebElement> subscriptionOptionHeaderValue(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='label-text ng-binding']"));
	}

	public WebElement whichCreditCardYouLike(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Which credit card would you like to use ?')]"));
	}

	public WebElement enableCreditCardDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='caret']"));
	}

	public WebElement getSelectedStateValue(WebDriver driver) {
		return driver.findElement(By.xpath("//ol[@title='Select state']//span[@class='pull-left filter-option']"));
	}

	public WebElement getSelectedCityValue(WebDriver driver) {
		return driver.findElement(By.name("city"));
	}

	public WebElement selectAddCardOption(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Add Card')]"));
	}

	public WebElement confirmBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Confirm']"));
	}

	public WebElement thankYouMessageForSubscribingBWell(WebDriver driver) {
		return driver.findElement(By.xpath("//p[text()='Thank you for subscribing to b.well!']"));
	}

	public WebElement letsGoBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".bw-btn.bw-btn-main.bw-btn-blue"));
	}

}
