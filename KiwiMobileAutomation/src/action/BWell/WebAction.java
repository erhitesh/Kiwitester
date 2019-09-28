package action.BWell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.ExcelUtility;
import com.utilities.GlobalParam;
import com.utilities.Keywords;
import com.utilities.Logs;

import BWell.DesktopWeb.Allergy;
import BWell.DesktopWeb.ChatModel;
import BWell.DesktopWeb.ClaimsAndFinancials;
import BWell.DesktopWeb.ClinicalSummary;
import BWell.DesktopWeb.Dashboard;
import BWell.DesktopWeb.Diagnosis;
import BWell.DesktopWeb.DigitalWallet;
import BWell.DesktopWeb.Encounter;
import BWell.DesktopWeb.FamilyHistory;
import BWell.DesktopWeb.Filter;
import BWell.DesktopWeb.HealthJourneyAndRewards;
import BWell.DesktopWeb.HealthTribe;
import BWell.DesktopWeb.HomeScreen;
import BWell.DesktopWeb.Locators;
import BWell.DesktopWeb.LoginScreen;
import BWell.DesktopWeb.MedicalDocument;
import BWell.DesktopWeb.Medications;
import BWell.DesktopWeb.MedicationsAndPharmacies;
import BWell.DesktopWeb.MyDoctors;
import BWell.DesktopWeb.MyHealth;
import BWell.DesktopWeb.MyProfile;
import BWell.DesktopWeb.Notification;
import BWell.DesktopWeb.Payment;
import BWell.DesktopWeb.Pharmacy;
import BWell.DesktopWeb.Procedure;
import BWell.DesktopWeb.SettingPanel;
import BWell.DesktopWeb.SignUp;
import BWell.DesktopWeb.Support;
import BWell.DesktopWeb.Surgery;
import BWell.DesktopWeb.ViewAuthorization;
import action.CommonAll;

public class WebAction extends CommonAll {
	HashMap<String, String> testData = new HashMap<String, String>();

	public WebAction(WebDriver driver) {
		super(driver);
		this.testData = DriverSession.getTestCaseData();
	}

	public List<String> valueForAuthorizedOperation(String operationValue) {
		String str = "";
		List<String> shareInfo = new ArrayList<>();
		try {
			String Share = "share share";
			String downloadfile = "share downlaodfile";
			String revoke = "share revoke";
			String reauthorize = "share reauthorize";
			if (Share.contains(operationValue))
				str = Share;
			else if (revoke.contains(operationValue))
				str = revoke;
			else if (downloadfile.contains(operationValue))
				str = downloadfile;
			else if (reauthorize.contains(operationValue))
				str = reauthorize;
			shareInfo = convertStrIntoList(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shareInfo;
	}

	public List<String> convertStrIntoList(String str) {
		return Keywords.convertStringAsList(str);
	}

	public void navigateToHomePage() {
		try {
			HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
			screen.clickOnBWellLogo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPageLoaded(String pageName) {
		try {
			Keywords.verifyPageLoaded(pageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAppStoreLink() {
		try {
			HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
			screen.clickOnAppStore();
			screen.verifyiTunePreview();
			screen.verifyAppNameOnAppStore();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyGooglePlayLink() {
		try {
			HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
			screen.clickOnGooglePlay();
			screen.verifyGooglePlayPreview();
			screen.verifyAppNameOnGooglePaly();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNameOnCardBeforeCheck() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.verifyNameOnCardBeforeCheck();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNameOnCardAfterCheck(String FAndLName) {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.verifyNameOnCardAfterCheck(FAndLName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enableSettingPanelView() {
		try {
			SettingPanel panel = new SettingPanel(DriverSession.getLastExecutionDriver());
			panel.enableSettingPanelView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disableSettingPanel() {
		try {
			SettingPanel panel = new SettingPanel(DriverSession.getLastExecutionDriver());
			panel.disableSettingPanelView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void signingUpAsCompanyOrFamilyForSubscribe(String option) {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.selectSignUpAsPartOfCompanyOrFamily(option);
			if (option.equalsIgnoreCase("yes"))
				;
			else {
				signup.selectSubscriptionPlan();
				// signup.applyPromoCode(DriverSession.getTestCaseData().get("Promo"));
				signup.whichCCWantToUse();
				signup.submitInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// >>>>>>>>>>>>>>>>>>> Earn Point Windows >>>>>>>>>>>>>>>
	public void verifyFinishTutorialAndEarnPointForSignup() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyFinishTutorialMsg();
				signup.verifyEarnPoint("signup");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationAddingFamilyMemberInSubs() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyFamilyMemeberMsg();
				signup.verifyEarnPoint("family");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationCollectMedicalRecordsMsg() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyCollectYourMedicalRecordsMsg();
				signup.verifyEarnPoint("medical");
				signup.submitRegistrationProcess();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationAddingFirstDoctor() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyFirstDoctorAddMsg();
				signup.verifyEarnPoint("doctor");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationMsgForWeightHeightUpdation() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyWeightHeightMsg();
				signup.verifyEarnPoint("profile");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void verifyCongratulationHealthAssessmentObjectiveDone() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyHealthAssessmentCompleteObjective();
				signup.verifyEarnPoint("health assessment");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationForAllergy() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyAllergyAddedMsg();
				signup.verifyEarnPoint("allergy");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCongratulationForHealthTribeUser() {
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			if (signup.verifyCongratulationMessage()) {
				signup.verifyAllergyAddedMsg();
				signup.verifyEarnPoint("allergy");
				signup.submitRegistrationProcess();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> signUpSlashRegistration() {
		String name = "";
		List<String> signupInfo = new ArrayList<>();
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.clickOnSignUpLink();
			signupInfo.add(signup.email());
			signupInfo.add(signup.password());
			signup.confirmPassword();
			name = signup.enterFName();
			name = name + " " + signup.enterLName();
			signupInfo.add(signup.selectGender());
			signupInfo.add(name);
			signup.userDOB();
			signup.enterPhoneNumber();
			signup.selectSignUpAsPartOfCompanyOrFamily();
			signup.clickOnNextButton();
			signup.selectSubscriptionPlan();
			// signup.applyPromoCode(DriverSession.getTestCaseData().get("Promo"));
			signup.creditCard();
			signup.ccExpirationDate();
			signup.cvvNumber();
			verifyNameOnCardBeforeCheck();
			signup.selectSameAsNameOnAccountCheckBox(true);
			verifyNameOnCardAfterCheck(name);
			signup.addressLine1();
			signup.addressLine2();
			signup.zipCode();
			signup.verifyCityAndStateBasedOnZipCode();
			signup.submitSignUpInfo();
			payment.verifyThankYouForSubscribingBWell();
			signup.skipVideoWindow();
			// signup.playVideo();
			// verifyFinishTutorialAndEarnPointForSignup();
			updateAndVerifyUserRequiredInfoWhileSignup();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return signupInfo;
	}

	public List<String> signUpSlashRegistrationWithoutProfileUpdate() {
		String name = "";
		List<String> signupInfo = new ArrayList<>();
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.clickOnSignUpLink();
			signupInfo.add(signup.email());
			signupInfo.add(signup.password());
			signup.confirmPassword();
			name = signup.enterFName();
			name = name + " " + signup.enterLName();
			signupInfo.add(signup.selectGender());
			signupInfo.add(name);
			signup.userDOB();
			signup.enterPhoneNumber();
			signup.selectSignUpAsPartOfCompanyOrFamily();
			signup.clickOnNextButton();
			signup.selectSubscriptionPlan();
			signup.creditCard();
			signup.ccExpirationDate();
			signup.cvvNumber();
			verifyNameOnCardBeforeCheck();
			signup.selectSameAsNameOnAccountCheckBox(true);
			verifyNameOnCardAfterCheck(name);
			signup.addressLine1();
			signup.addressLine2();
			signup.zipCode();
			signup.verifyCityAndStateBasedOnZipCode();
			signup.submitSignUpInfo();
			payment.verifyThankYouForSubscribingBWell();
			signup.skipVideoWindow();
		} catch (Exception e) {
		}
		return signupInfo;
	}

	public List<String> signUpWithRegistrationCode(List<String> info, String registrationCode) {
		String name = "";
		List<String> signupInfo = new ArrayList<>();
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			signup.clickOnSignUpLink();
			signupInfo.add(signup.email());
			signupInfo.add(signup.password());
			signup.confirmPassword();
			name = signup.enterFName();
			name = name + " " + signup.enterLName();
			signupInfo.add(signup.selectGender());
			signupInfo.add(name);
			signup.userDOB();
			signup.enterPhoneNumber();
			signup.signUpWithRegistrationCode(registrationCode);
			signup.clickOnNextButton();
			signup.addressLine1();
			signup.addressLine2();
			signup.zipCode();
			signup.verifyCityAndStateBasedOnZipCode();
			signup.submitSignUpInfo();
			payment.verifyThankYouForSubscribingBWell();
			signup.skipVideoWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return signupInfo;
	}

	public HashMap<String, List<String>> NoOfUserCreate(int howManyUser) {
		HashMap<String, List<String>> userInfo = new LinkedHashMap<>();
		List<String> createUserInfo = new ArrayList<>();
		try {
			for (int i = 0; i < howManyUser; i++) {
				createUserInfo = signUpSlashRegistration();
				userInfo.put(createUserInfo.get(0), createUserInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

	public void sendForgotPasswordLink() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.clickOnForgotPasswordLink();
			login.enterForgotPasswordEmailAddress();
			login.submitForgotPassword();
			login.verifyResetPasswordMailSendMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testYopmail() {
		String userName = "";
		try {
			userName = DriverSession.getTestCaseData().get("Uname");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail();
			login.navigateToUserEmailInbox(userName);
			login.selectBWellResetPasswordMail();
			login.verifyUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void forgotPassword() {
		// String link = "";
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			testYopmail();
			login.getResetPasswordLinkAndOpenInNewTab("new tab");
			login.forgotPassword();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginFromResetPage() {
		try {
			LoginScreen screen = new LoginScreen(driver);
			screen.loginBtnOnResetPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			SettingPanel panel = new SettingPanel(DriverSession.getLastExecutionDriver());
			if (login.loginStatus() && login.userEmailAddressStatus()) {
				login.enterUserName();
				login.enterPassword();
				login.submitSingIn();
				Keywords.explicitWait(5);
				if (panel.settingPanelStatus())
					Logs.info("User Logged In Successfully");
			} else if (login.loginStatus()) {
				login.loginUser();
				login.enterUserName();
				login.enterPassword();
				login.submitSingIn();
			}
			// else {
			// }
			// if (panel.settingPanelStatus()) {
			// panel.verifyUserLogedIn();
			// Logs.info("User Logged In Successfully");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(String userEmail, String password) {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			if (login.loginStatus()) {
				login.enterUserName(userEmail);
				login.enterPassword(password);
				login.submitSingIn();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginForSubscribeUserPlan() {
		login(DriverSession.getTestCaseData().get("Username"), DriverSession.getTestCaseData().get("Password"));
	}

	public void verifyLoginFunctionalityWithRequiredField() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - LOGIN WITHOUT EMAIL ID FIELD</b>");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			// login.enterUserName();
			// login.clearTextFields("email");
			login.enterPassword();
			// login.verifyErrorMessageForLoginWithoutEmailId();
			if (!login.verifyLoginBtnStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button </b>mark as disable", "PASS", "<b>Login Button </b>status should be disable");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button </b>mark as enable", "FAIL", "<b>Login Button </b>status should be disable");
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - LOGIN WITHOUT PASSWORD FIELD</b>");
			login.enterUserName();
			// login.enterPassword();
			// login.clearTextFields("pass");
			// login.verifyErrorMessageForLoginWithoutPassword();
			if (!login.verifyLoginBtnStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button </b>mark as disable", "PASS", "<b>Login Button </b>status should be disable");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Login Button </b>mark as enable", "FAIL", "<b>Login Button </b>status should be disable");
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - LOGIN WITH INVALID EMAIL ADDRESS</b>");
			login.enterUserName("bwell");
			login.verifyErrorMessageForInvalidEmailId();
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b> TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 LOGIN WITH INVALID CREDENTIALS</b>");
			login.enterUserName("bwell@gmail.com");
			login.enterPassword();
			login.submitSingIn();
			login.verifyErrorMessageForInvalidCredentialLogin();
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			enableSettingPanelView();
			SettingPanel panel = new SettingPanel(DriverSession.getLastExecutionDriver());
			panel.clickOnLogoutBtn();
			Logs.info("User Logged Out Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyUserLogoutSuccessfully() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.verifyUserLogout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToDashboard() {
		try {
			Dashboard board = new Dashboard(DriverSession.getLastExecutionDriver());
			board.navigateToDashboard();
			Logs.info("User navigate to the Dashboard Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDashboardMenuList(String menuName) {
		Dashboard dashboard = null;
		try {
			dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
			dashboard.selectDashboardLeftMenu(menuName);
			Logs.info("Dashboard Menu Select Successfully");
		} catch (Exception e) {
			dashboard.selectDashboardLeftMenu(menuName);
		}
	}

	public void navigateToHealthJourneyAndRewardsPage() {
		try {
			HealthJourneyAndRewards hjAndR = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
			hjAndR.navigateToHealthJourneyAndRewardsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToRewardsPage() {
		try {
			navigateToHealthJourneyAndRewardsPage();
			HealthJourneyAndRewards rewards = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
			rewards.selectSubLinksInsideHealthJourneyAndRewardsTab("rewards");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMyHealthPage() {
		try {
			MyHealth myHealth = new MyHealth(DriverSession.getLastExecutionDriver());
			myHealth.navigateToMyHealthPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMyDoctorPage() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.navigateToMyDoctorPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMedicationsAndPharmaciesPage() {
		try {
			MedicationsAndPharmacies medication = new MedicationsAndPharmacies(DriverSession.getLastExecutionDriver());
			medication.navigateToMedicationsAndPharmaciesPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddPharmacyPage() {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.navigateToPharmacyPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToClaimAndFinancialPage() {
		try {
			ClaimsAndFinancials claims = new ClaimsAndFinancials(DriverSession.getLastExecutionDriver());
			claims.navigateToClaimAndFinancialPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToTakeADoctorNow() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDashboardMenuList("My Doctors");
			myDoctor.clickViewMyDoctorLinkedTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Talk To A Doctor Now
	public void navigateToTalkToADoctor() {
		MyDoctors myDoctor = null;
		try {
			myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDashboardMenuList("My Doctors");
			myDoctor.clickOnTalkToADoctor();
		} catch (Exception e) {
			myDoctor.clickOnTalkToADoctor();
		}
	}

	public void quizNavigation(String quizNavigation) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.quizNavigation(quizNavigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForOneOfFive() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.selectUserHeightInFeet();
			myDoctor.selectUserHeightInInches();
			myDoctor.enterUserWeight();
			myDoctor.smokeTobacco();
			myDoctor.drinkAlcohol();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForTwoOfFive() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyQuestionHeaderCount("2");
			myDoctor.twoOfOneSayYourHealthStatus();
			myDoctor.twoOfTwoLastCheckup();
			myDoctor.twoOfThreeTakingMultiVitaminSupplement();
			myDoctor.twoOfFourChangesToImproveHealth();
			myDoctor.twoOfFiveFluVaccine();
			myDoctor.twoOfSixLabWork();
			myDoctor.twoOfSevenConnectedDevice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForThreeOfFive() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyQuestionHeaderCount("3");
			myDoctor.threeOfOneServingsOfFruits();
			myDoctor.threeOfTwoServingsOfVegetables();
			myDoctor.threeOfThreeEatWhiteMeat();
			myDoctor.threeOfFourEatRedMeat();
			myDoctor.threeOfFiveProcessedMeat();
			myDoctor.threeOfSixEatWholeGrainBreadWildRice();
			myDoctor.threeOfSevenServingsMilkAndDairyProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForFourOfFive(int userAge) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyQuestionHeaderCount("4");
			myDoctor.fourOfOneDifficultyInSleeping();
			myDoctor.fourOfTwoSleepRestless();
			myDoctor.fourOfThreeFeelingrefreshedInMorning();
			myDoctor.fourOfFourSmokeCigaretteInYourLifeStyle();
			myDoctor.howOldYouStartSmoking(userAge);
			myDoctor.lastSmokedCigarette(userAge);
			myDoctor.fourOfFiveLikeBriskWalk();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForFiveOfFive() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyQuestionHeaderCount("5");
			myDoctor.fiveOfOneUpsetDueToSomethingUnexpectedly();
			myDoctor.fiveOfTwoUnableToControlImportantThingInYourLife();
			myDoctor.fiveOfThreeFeltNervousOrStressed();
			myDoctor.fiveOfFour();
			myDoctor.fiveOfFiveFeelNotOnTopOfThings();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void answerForSixOfSix(int age) {
		boolean status = false;
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyQuestionHeaderCount("6");
			myDoctor.oneOfSixAtWhatAgeMenstrualCycles(age);
			status = myDoctor.twoOfSixHaveYouEverPregnant();
			if (status) {
				myDoctor.threeOfSixFirstTimePregnant(age);
				myDoctor.fourOfSixHadGestationalHypertension();
				myDoctor.fiveOfSixHaveTumorInYourBreast();
				myDoctor.SixOfSixHaveYouHadMammogram();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void telemedicinConsult(String gender, String user, int age,
			String contactNumber/* String pharmacyName */) {
		String pharmacyName = "";
		try {
			navigateToTalkToADoctor();
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (!doctor.telemedicineConsultHeaderTxt()) {
				finishHealthAssessment(gender, age);
				pharmacyName = selectYourPharmacy();
				finishPreVisitQuestions(age);
			}
			TelemedicineConsult(user, age, contactNumber, pharmacyName);
			verifyTeleMedicineConsultSuccessfullyDone(contactNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void finishHealthAssessment(String gender, int age) {
		int userAge = age;
		MyDoctors myDoctor;
		try {
			myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (myDoctor.finishHealthAssessmentLink()) {
				myDoctor.selectFinishHealthAssessmentLink();
				answerForOneOfFive();
				quizNavigation("next");
				answerForTwoOfFive();
				quizNavigation("next");
				answerForThreeOfFive();
				quizNavigation("next");
				answerForFourOfFive(userAge);
				quizNavigation("next");
				answerForFiveOfFive();
				if (gender.equalsIgnoreCase("female")) {
					quizNavigation("next");
					answerForSixOfSix(userAge);
				} else {
				}
				myDoctor.submitHealthAssessment();
				myDoctor.finalSubmitHealthAssessment();
				verifyCongratulationHealthAssessmentObjectiveDone();
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Finish Health Assessment Part </b>already done", "INFO",
						"<b>Finish Health Assessment Part </b>should be completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectYourPharmacy() {
		String pharmacyName = "";
		try {
			navigateToTalkToADoctor();
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			if (myDoctor.selectYourPharmcyLinkStatus()) {
				myDoctor.selectYourPharmacyLink();
				if (pharmacy.noPharmaciesInYourAccountStatus()) {
					pharmacyName = fillPharmacyForm().get(0);
					addPharmacyToFavoriteForTalkToDoctor(pharmacyName);
				} else
					pharmacyName = addRandomPharmacyToFavorite();
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Select Your Pharmacy Part </b>already done", "INFO",
						"<b>Select Your Pharmacy Part </b>should be completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pharmacyName;
	}

	public String answerForPreVisitQuestions(int age) {
		String smoke = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.selectUserHeightInFeetForPreVisit();
			myDoctor.selectUserHeightInInchesForPreVisit();
			myDoctor.enterUserWeightForPreVisit();
			smoke = myDoctor.smokeTobaccoForPreVisit();
			myDoctor.drinkAlcoholForPreVisit();
			myDoctor.haveYouEverDisabled();
			myDoctor.faceOccupationalAsbestosExposure();
			myDoctor.faceOccupationalDieselExhaustExposure();
			myDoctor.faceRadonExposure();
			myDoctor.faceOccupationalTobaccoExposure();
			myDoctor.chronicCondition();
			myDoctor.recreationDrugs();
			myDoctor.travelOverseas();
			myDoctor.lastVisitToDoctor();
			myDoctor.yearlyFluShots();
			myDoctor.bloodInUrine();

			myDoctor.feelBurning();

			myDoctor.urinateIn24Hours();

			myDoctor.bladderSymptomsImpacted();

			myDoctor.leakedUrine();

			myDoctor.hoursOfSleepInNight();

			myDoctor.highBloodPressure();

			myDoctor.exerciseRegularly();
			myDoctor.diseaseTypeAndAgeAtDiagnosis(age);
			myDoctor.submitPreVisitQuestions();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return smoke;
	}

	public void finalSubmitPreVisitQuestions() {
		WebElement element;
		try {
			element = Locators.getInstance().thankYouMsgForCompletingPreVisitQuestions(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Message For Completing Pre Visit Questions </b>display successfully", "PASS",
						"<b>Thank You Message For Completing Pre Visit Questions </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Thank You Message For Completing Pre Visit Questions </b>not display successfully", "FAIL",
						"<b>Thank You Message For Completing Pre Visit Questions </b>should be display");
			element = Locators.getInstance().finalSubmitPreVisitQuestion(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button of Pre Visit Questions </b>click successfully", "PASS",
						"<b>Submit Button of Pre Visit Questions </b>should be clicked");
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit Button of Pre Visit Questions </b>not click successfully", "FAIL",
						"<b>Submit Button of Pre Visit Questions </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excepion occurred while clicking on the <b>Submit Button of Pre Visit Questions </b>", "FAIL",
					"<b>Submit Button of Pre Visit Questions </b>should be clicked");
		}
	}

	public void finishPreVisitQuestions(int age) {
		int userAge = age;
		try {
			// age = getUserAge();
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToTalkToADoctor();
			if (myDoctor.finishPreVisitQuestionsLink()) {
				myDoctor.selectFinishPreVisitQuestionsLink();
				answerForPreVisitQuestions(userAge);
				finalSubmitPreVisitQuestions();
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Finish Pre Visit Questions Part </b>already done", "INFO",
						"<b>Finish Pre Visit Questions Part </b>should be completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addImages() {
		int uploadPhotoCount = 2;
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyAddPhotoHeaderTxt();
			myDoctor.addPhotos(uploadPhotoCount, "");
			myDoctor.submitAddedPhoto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addImageWithInvalidSize(String imageName) {
		int uploadPhotoCount = 1;
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyAddPhotoHeaderTxt();
			myDoctor.addPhotos(uploadPhotoCount, imageName);
			myDoctor.photoSizeUploadErrorMessage();
			// myDoctor.submitAddedPhoto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getAccountUserInfo() {
		HashMap<String, String> info = new LinkedHashMap<String, String>();
		try {
			info.put("user", getSelectedAccountName());
			info.put("age", getUserAge() + "");
			info.put("phone", getUserContactNumber());
		} catch (Exception e) {
		}

		return info;
	}

	public void verifyTeleMedicineConsultSuccessfullyDone(String contactNumber) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyTeleMedicineThankYouMsg();
			myDoctor.verifyTelaDocPhysicianContactOnThisNumber(contactNumber);
			myDoctor.verifyTeleMedicineConfirmationNumber();
			myDoctor.submitTeleMedicineConfirmationPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TelemedicineConsult(String user, int age, String contactNumber, String pharmacyName) {
		String imageName = "Image_With_High_Reso.jpg";
		try {
			navigateToTalkToADoctor();
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.selectFamilyMemberForConsultation(user);
			myDoctor.verifyContactNumberForSelectedMember(contactNumber);
			if (pharmacyName.length() <= 0) {
				pharmacyName = myDoctor.randomSelectPharmacy();
			} else
				myDoctor.selectPharmacy(pharmacyName);
			myDoctor.teleMedicinePrimaryInfoNextBtn();
			// myDoctor.verifyTelemedicineMsgAndSubmitIt();
			addImageWithInvalidSize(imageName);
			addImages();
			myDoctor.verifyTAndCHeaderTxt();
			myDoctor.acceptTAndCCheckBoxes();
			myDoctor.submitRequest();

			Keywords.explicitWait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// >>>> Medical Records Related Task >>>>>>>>>>>>>>>>>>>
	public void navigateToGetMedicalRecordPage() {
		try {
			// MyDoctors myDoctor = new
			// MyDoctors(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public String getMedicalRecords(/* String doctorName */) {
	// String doctorName = "";
	// String doctorNameFromList = "";
	// String doctorNameFromLink = "";
	// try {
	// doctorNameFromList = selectDoctorFromFindDoctorList();
	// MyDoctors myDoctor = new
	// MyDoctors(DriverSession.getLastExecutionDriver());
	// doctorNameFromLink = myDoctor.clickOnGetMedicalRecordLink();
	// if (doctorNameFromLink.length() > 0)
	// doctorName = doctorNameFromLink;
	// else
	// doctorName = doctorNameFromList;
	// myDoctor.navigateToGetMedicalRecords();
	// myDoctor.verifyDoctorNameOnMedicalRecordAuthorizationPage(doctorName);
	// myDoctor.acceptTermAndConditionForMedicalRecord();
	// myDoctor.drawSignature();
	// myDoctor.submitMedicalRecordsAuthorizationWindow();
	// myDoctor.verifyWeAreProcessOfObtainingMedicalRecordsFromDoctorList(doctorName);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return doctorName;
	// }

	public void navigateToViewAuthorizationPage() {
		try {
			navigateToMyDoctorPage();
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.clickOnViewAuthorization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAuthorization(String doctorName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.viewAuthorization(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnViewAuthorizationMedicalRecords() {
		boolean wantYourMedicalRecords = false;
		String filterType = "";
		String speciality = "";
		String medicalRecord = "";
		String authorization = "";
		filterType = DriverSession.getTestCaseData().get("FilterData");
		List<String> doctorList;
		HashMap<String, List<String>> infoWithParameter;
		HashMap<String, List<String>> infoWithFilter;
		try {
			navigateToViewAuthorizationPage();
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (doctor.noMedicalAuthorizationsOnAuthorizationPage()) {
				wantYourMedicalRecords = true;
				doctorRegistrationForm(wantYourMedicalRecords);
				navigateToViewAuthorizationPage();
			}
			speciality = getRandomSpecialityType();
			// System.out.println("Random Speciality..." + speciality);
			medicalRecord = "Obtaining";// getRandomMedicalRecordsStatus();
			authorization = ""; // getRandomAuthorizationsStatus();
			doctorList = getDoctorsListBasedOnRandomParameter(speciality, medicalRecord, authorization, filterType);
			// System.out.println("Doctor List by filter speciality.." +
			// doctorList);
			infoWithParameter = getDoctorInfoBasedOnParameter(doctorList);
			// System.out.println("Info with Parameter.." + infoWithParameter);
			applyFilterViewAuthorization(speciality, medicalRecord, authorization, filterType);
			infoWithFilter = getDoctorInfoFromViewAuthorizationPage();
			// System.out.println("Info With Filter.." + infoWithFilter);
			verifyDoctorDetailsAfterApplyFilterOnViewAuthorizationPage(infoWithParameter, infoWithFilter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAuthorizationFromProfile(String doctorName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.viewAuthorizationFromProfile(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyViewAuthorizationBtnOnProfilePage(String doctorName) {
		try {
			navigateToViewMyDoctor();
			selectDoctorFromSearchResultList(doctorName);
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.verifyViewAuthorizationBtnOnProfilePage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDoctorInViewAuthorizationList(String doctorName) {
		try {
			navigateToViewAuthorizationPage();
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.verifyDoctorNameInViewAuthorization(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToWantYourMedicalRecords() {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.navigateToWantYourMedicalRecordsWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMedicalRecordsEFormFromProfile() {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.navigateToWantYourMedicalRecordsWindow();
			navigateToMedicalRecordsEForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMedicalRecordsEForm() {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.navigateToMedicalRecordsEForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void proccedFurtherInstructionForMedicalRecords(boolean accessMedicalRecords, String doctorMiddleName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (accessMedicalRecords) {
				navigateToMedicalRecordsEForm();
				myDoctor.authorizedHealthInformationEForm(doctorMiddleName);
				myDoctor.verifyWeAreProcessOfObtainingMedicalRecordsFromDoctorList(doctorMiddleName);
				verifyDoctorInViewAuthorizationList(doctorMiddleName);
				/*
				 * navigateToMyDoctorPage(); navigateToViewMyDoctorList();
				 * viewAuthorization(doctorMiddleName);
				 */
			} else {
				myDoctor.hideWantYourMedicalRecordsWindow();
				myDoctor.feedbackSurvey();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMedicalRecordsWhenDoingDoctorRegistration(boolean accessMedicalRecords, String doctorMiddleName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyWantYourMedicalRecords();
			proccedFurtherInstructionForMedicalRecords(accessMedicalRecords, doctorMiddleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hideVerifyMedicalRecordsDuringRegistration() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyWantYourMedicalRecords();
			myDoctor.hideWantYourMedicalRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToAuthorizationPage(String doctorName, String operationType) {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.moveToAuthorizationDetailPage(doctorName, operationType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRevokeFunctionality(String doctorName) {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.revoke();
			doctor.verifyDoctorInAuthorizationList(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyReauthorizedFunctionality(String doctorName) {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctor.Reauthorized(doctorName);
			doctor.authorizedHealthInformationEForm(doctorName);
			doctor.verifyWeAreProcessOfObtainingMedicalRecordsFromDoctorList(doctor.getDoctorMiddleName(doctorName));
			verifyDoctorInViewAuthorizationList(doctor.getDoctorMiddleName(doctorName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void medicalRecordsAuthorizationOperation(String doctorName, String opType, String subOpType) {
		List<String> shareInfo = new ArrayList<>();
		try {
			// viewAuthorization(doctorName);
			moveToAuthorizationPage(doctorName, opType);
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (subOpType.equalsIgnoreCase("downloadfile"))
				doctor.downloadMedicalRecordsAuthorizationFile();
			else if (subOpType.equalsIgnoreCase("share")) {
				shareInfo = doctor.shareAuthorization();
				testYopMailForShareAuthorization(shareInfo);
			} else if (subOpType.equalsIgnoreCase("revoke")) {
				verifyRevokeFunctionality(doctorName);
				moveToAuthorizationPage(doctorName, "reauthorize");
			} else if (subOpType.equalsIgnoreCase("reauthorize")) {
				verifyRevokeFunctionality(doctorName);
				moveToAuthorizationPage(doctorName, "reauthorize");
				verifyReauthorizedFunctionality(doctorName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToViewMyDoctor() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDashboardMenuList("My Doctors");
			myDoctor.clickViewMyDoctorLinkedTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToFindADoctor() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDashboardMenuList("My Doctors");
			myDoctor.clickFindADoctorLinkedTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddADoctor() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDashboardMenuList("My Doctors");
			myDoctor.clickOnAddDoctorBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMilesValues(int indexValue) {
		List<String> milesList = new ArrayList<>();
		String milesValue = "";
		try {
			milesList.add("5 Miles");
			milesList.add("10 Miles");
			milesList.add("20 Miles");

			milesValue = milesList.get(indexValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return milesValue;
	}

	public void selectDoctorFromFindBySearchList(String doctorName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.selectDrFromFindBySearchResult(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectDoctorFromSearchResultList(String doctorName) {
		String doctorname = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctorname = myDoctor.selectDoctorFromList(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorname;
	}

	public void checkUserHeaderStatusOnProfilePage(String headerColour) {
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			if (doctor.checkUserProfileHeaderStatus("blue"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Everyone has a right to access their medical records </b> message display successfully",
						"PASS", "<b>Everyone has a right to access their medical records </b>msg should be display");
			else if (doctor.checkUserProfileHeaderStatus("yellow"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Everyone has a right to access their medical records </b> message not display successfully",
						"FAIL", "<b>Everyone has a right to access their medical records </b>msg should be display");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void diffViewStatusOnDoctorProfilePage(boolean accessMedicalRecords, String doctorName) {
		String doctorMiddleName = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDoctorFromSearchResultList(doctorName);
			if (myDoctor.checkUserProfileHeaderStatus("blue"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Everyone has a right to access their medical records </b> message display successfully",
						"PASS", "<b>Everyone has a right to access their medical records </b>msg should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Everyone has a right to access their medical records </b> message not display successfully",
						"FAIL", "<b>Everyone has a right to access their medical records </b>msg should be display");
			navigateToWantYourMedicalRecords();
			doctorMiddleName = myDoctor.getDoctorMiddleName(doctorName);// doctorName.substring(doctorName.indexOf("
																		// ") +
																		// 1,
																		// doctorName.length());
			verifyMedicalRecordsWhenDoingDoctorRegistration(accessMedicalRecords, doctorMiddleName);
			navigateToMyDoctorPage();
			selectDoctorFromSearchResultList(doctorName);
			if (myDoctor.checkUserProfileHeaderStatus("yellow"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Obtaining your medical records! </b> message display successfully", "PASS",
						"<b>Obtaining your medical records! </b>msg should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Obtaining your medical records! </b> message not display successfully", "FAIL",
						"<b>Obtaining your medical records! </b>msg should be display");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectDoctorFromFindDoctorList() {
		String doctorname = "";
		try {
			selectDashboardMenuList("My Doctors");
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			doctorname = myDoctor.selectRandomDoctorFromDrList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorname;
	}

	public void verifyDoctorDetailOnProfilePage(Map<String, String> doctorInfo) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyDoctorNameOnProfilePage(doctorInfo.get("DoctorName"));
			myDoctor.verifyDoctorSpecialityOnProfilePage(doctorInfo.get("Speciality"));
			myDoctor.verifyDoctorNumberOnProfilePage(doctorInfo.get("PhoneNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String removeDoctorFromProfilePage(Map<String, String> doctorInfo) {
		String doctorName = doctorInfo.get("DoctorName");
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			selectDoctorFromSearchResultList(doctorName);
			verifyDoctorDetailOnProfilePage(doctorInfo);
			doctorName = myDoctor.removeDoctor(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorName;
	}

	public String addToFavourite(Map<String, String> doctorInfo) {
		String doctorName = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.addToFavouriteFromProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorName;
	}

	public String addToPCP(Map<String, String> doctorInfo) {
		String doctorName = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.addPCPFromProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorName;
	}

	public void verifyDoctorAddedToFavouriteAndPCP(String doctorName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToMyDoctorPage();
			myDoctor.verifyDoctorAddedToFavourite(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDoctorNameAfterDeletion(String doctorName) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyDoctorNameAfterDeletion(doctorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findADoctorBySpeciality(Map<String, String> doctorInfoDetails, String miles) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToFindADoctor();
			myDoctor.selectSpeciality(doctorInfoDetails.get("Speciality"));
			myDoctor.selectMiles(miles);
			myDoctor.enterZipCodeForSearchDoctor(doctorInfoDetails.get("ZipCode"));
			myDoctor.clickOnSearchButton();
			/*
			 * while (myDoctor.verifySearchDoctorErrorResult()) {
			 * myDoctor.navigateBackToSearchPage(); indexValue++; miles =
			 * getMilesValues(indexValue); myDoctor.updateSelectMiles(miles);
			 * myDoctor.clickOnSearchButton(); if (indexValue > 3) break; }
			 */
			selectDoctorFromFindBySearchList(doctorInfoDetails.get("DoctorName"));
			verifyDoctorDetailOnProfilePage(doctorInfoDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findADoctorBySpeciality(Map<String, String> doctorInfoDetails) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToFindADoctor();
			myDoctor.selectSpeciality(doctorInfoDetails.get("Speciality"));
			myDoctor.selectMiles(doctorInfoDetails.get("Miles"));
			myDoctor.enterZipCodeForSearchDoctor(doctorInfoDetails.get("ZipCode"));
			myDoctor.clickOnSearchButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> parameterDataForFindDoctor() {
		return new MyDoctors(DriverSession.getLastExecutionDriver()).parameterDataForFindDoctor();
	}

	public void verifyMedicalRecordPopupWhileAddingToFavorite(HashMap<String, String> doctorInfoDetails) {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			findADoctorBySpeciality(doctorInfoDetails);
			myDoctor.selectDoctorAndAddToFavoriteVerifyGetMedicalRecordPopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> doctorRegistrationForm(boolean wantYourMedicalRecords) {
		HashMap<String, String> mapData = new HashMap<>();
		String doctorName = "Dr ";
		String cityName = "";
		String fname = "";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToAddADoctor();
			fname = doctorName + myDoctor.enterDoctorFirstName() + " ";
			doctorName = fname + myDoctor.enterDoctorLastName();
			System.out.println("Doctor Name.." + doctorName);
			mapData.put("DoctorName", doctorName);
			mapData.put("Speciality", myDoctor.selectDoctorSpeciality());
			mapData.put("Practice", myDoctor.enterPracticeName());
			mapData.put("PhoneNumber", myDoctor.enterDoctorPhoneNumber());
			cityName = myDoctor.enterDoctorCityName();
			mapData.put("AddressLine1", myDoctor.enterDoctorAddressLine1(cityName));
			mapData.put("City", cityName);
			mapData.put("State", myDoctor.enterDoctorState());
			mapData.put("ZipCode", myDoctor.enterZipCode(cityName));
			myDoctor.submitDoctorRegistrationForm();
			verifyMedicalRecordsWhenDoingDoctorRegistration(wantYourMedicalRecords,
					fname.substring(fname.indexOf("Dr ") + 2, fname.length()).trim());
			/*
			 * mapData.put("AddressLine2",
			 * myDoctor.enterDoctorAddressLine2(cityName));
			 * myDoctor.checkIsThisAHospitalCheckBox(true);
			 * myDoctor.checkIsThisPrimaryLocationCheckBox(true);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapData;
	}

	public void verifyErrorMessageForBlankTextFeildDoctorRegistration() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.verifyErrorMessageForBlankFirstName();
			myDoctor.verifyErrorMessageForBlankLastName();
			myDoctor.verifyErrorMessageForBlankSpeciality();
			myDoctor.verifyErrorMessageForBlankPracticeName();
			myDoctor.verifyErrorMessageForBlankPhoneNumber();
			myDoctor.verifyErrorMessageForBlankAddressLine1();
			myDoctor.verifyErrorMessageForBlankCityName();
			myDoctor.verifyErrorMessageForBlankState();
			myDoctor.verifyErrorMessageForBlankZipCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAddDoctorForm() {
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			myDoctor.closeDoctorRegistrationForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doctorRegistrationWithNegativeData() {
		List<String> list;
		String sheetLocation = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
				+ GlobalParam.slash + "BWellFiles" + GlobalParam.slash + "CheckingDoctorRegistrationForN.ods";
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToAddADoctor();
			myDoctor.submitDoctorRegistrationForValidation();
			verifyErrorMessageForBlankTextFeildDoctorRegistration();
			DriverSession.setReporting(false);
			closeAddDoctorForm();
			navigateToAddADoctor();
			DriverSession.setReporting(true);
			list = ExcelUtility.getInstance().getSheetData(sheetLocation, "Doctorfirstname");
			for (int i = 0; i < list.size(); i++) {
				DriverSession.setReporting(false);
				myDoctor.enterDoctorFirstName(list.get(i));
				DriverSession.setReporting(true);
				myDoctor.verifyErrorMessageForInvalidDataForFirstName();
			}
			DriverSession.setReporting(false);
			closeAddDoctorForm();
			navigateToAddADoctor();
			DriverSession.setReporting(true);
			list = ExcelUtility.getInstance().getSheetData(sheetLocation, "Doctorlastname");
			for (int i = 0; i < list.size(); i++) {
				DriverSession.setReporting(false);
				myDoctor.enterDoctorLastName(list.get(i));
				DriverSession.setReporting(true);
				myDoctor.verifyErrorMessageForInvalidDataForLastName();
			}
			DriverSession.setReporting(false);
			closeAddDoctorForm();
			navigateToAddADoctor();
			DriverSession.setReporting(true);
			list = ExcelUtility.getInstance().getSheetData(sheetLocation, "PhoneNumber");
			for (int i = 0; i < list.size(); i++) {
				DriverSession.setReporting(false);
				myDoctor.enterDoctorPhoneNumber(list.get(i));
				DriverSession.setReporting(true);
				myDoctor.verifyErrorMessageForInvalidDataForPhoneNumber();
			}
			DriverSession.setReporting(false);
			closeAddDoctorForm();
			navigateToAddADoctor();
			DriverSession.setReporting(true);
			list = ExcelUtility.getInstance().getSheetData(sheetLocation, "DoctorCity");
			for (int i = 0; i < list.size(); i++) {
				DriverSession.setReporting(false);
				myDoctor.enterDoctorCityName(list.get(i));
				DriverSession.setReporting(true);
				myDoctor.verifyErrorMessageForInvalidDataForCity();
			}
			DriverSession.setReporting(false);
			closeAddDoctorForm();
			navigateToAddADoctor();
			DriverSession.setReporting(true);
			list = ExcelUtility.getInstance().getSheetData(sheetLocation, "DoctorZipCode");
			for (int i = 0; i < list.size(); i++) {
				DriverSession.setReporting(false);
				myDoctor.enterDoctorZipCode(list.get(i));
				DriverSession.setReporting(true);
				myDoctor.verifyErrorMessageForInvalidDataForZipCode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> addADoctor(boolean wantYourMedicalRecords) {
		DriverSession.setReporting(false);
		login();
		DriverSession.setReporting(true);
		return doctorRegistrationForm(wantYourMedicalRecords);
	}

	public List<String> getDoctorList() {
		List<String> list = new ArrayList<>();
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			list = myDoctor.getDoctorList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<String> getDoctorSpecialityList() {
		List<String> list = new ArrayList<>();
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			list = myDoctor.getDoctorSpecialityList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<String> getDoctorMilesList() {
		List<String> list = new ArrayList<>();
		try {
			MyDoctors myDoctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			list = myDoctor.getDoctorMilesList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// >>>>>>>> Remove Doctor >>>>>>>>>
	public void removeDoctor(String doctorName) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> addAllergiesFromAllergyPage() {
		HashMap<String, String> allergyListDetails = new LinkedHashMap<>();
		List<String> allergiesList;
		try {
			navigateToAllergiesDetailPage();
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergiesList = allergy.getAllergiesList();
			allergyListDetails.put("allergyName", allergy.addedAllergyName(allergiesList));
			allergyListDetails.put("allergyStatus", allergy.addAllergyStatus());
			allergyListDetails.put("allergySeverity", allergy.addAllergySeverity());
			allergyListDetails.put("allergyReaction", allergy.enterAllergyReaction());
			allergyListDetails.put("allergyOnSetDate", allergy.setEpisodeDate("onset date"));
			allergyListDetails.put("allergyLastEpisodeDate", allergy.setEpisodeDate("Lastepisode"));
			allergyListDetails.put("allergyTreatment", allergy.enterAllergyTreatment());
			allergy.submitAddAllergyPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allergyListDetails;
	}

	public void navigateToClinicalPage() {
		try {
			ClinicalSummary clinical = new ClinicalSummary(DriverSession.getLastExecutionDriver());
			clinical.navigateToClinicalSummaryPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAllergyFromClinicalPage() {
		try {
			ClinicalSummary clinical = new ClinicalSummary(DriverSession.getLastExecutionDriver());
			clinical.clickOnAddAllergy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToProcedurePage() {
		try {
			Procedure dia = new Procedure(DriverSession.getLastExecutionDriver());
			dia.clickOnAddProcedureBtn();
			dia.verifyAddProcedureHeaderTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addProcedure(List<String> physicianlist) {
		List<String> procedureInfo = new ArrayList<>();
		try {
			Procedure procedure = new Procedure(DriverSession.getLastExecutionDriver());
			procedureInfo.add(procedure.selectCurrentDate());
			procedureInfo.add(procedure.enterProcedureName());
			procedureInfo.add(procedure.selectPhysician(physicianlist));
			procedure.submitProcedureInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return procedureInfo;
	}

	public List<String> procedurePhysicianList() {
		List<String> procedurephysician = new ArrayList<>();
		try {
			Procedure procedure = new Procedure(DriverSession.getLastExecutionDriver());
			procedure.procedurePhysicianList();
		} catch (Exception e) {
		}

		return procedurephysician;
	}

	public void verifyProcedureInfo(List<String> actualInfo) {
		List<String> procedureExpectedInfo;
		try {
			Procedure procedure = new Procedure(DriverSession.getLastExecutionDriver());
			procedureExpectedInfo = procedure.procedureInfo();
			for (int i = 0; i < procedureExpectedInfo.size(); i++) {
				List<String> tempList = new ArrayList<>(Arrays.asList(procedureExpectedInfo.get(i).split(",")));
				if (actualInfo.get(0).equalsIgnoreCase(tempList.get(0))
						&& actualInfo.get(1).equalsIgnoreCase(tempList.get(1))
						&& actualInfo.get(2).equalsIgnoreCase(tempList.get(2))) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Procedure Actual & Expected Info </b>match successfully", "PASS",
							"<b>Procedure Actual & Expected Info </b>should be matched");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Actual & Expected <b>Procedure Info</b>", "FAIL",
					"<b>Procedure Actual & Expected Info </b>should be matched");
		}
	}

	public void navigateToDiagnosisPage() {
		try {
			navigateToClinicalPage();
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			dia.clickOnAddDiagnosisBtn();
			dia.verifyAddDiagnosisHeaderTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToSurgeriesPage() {
		try {
			navigateToClinicalPage();
			Surgery sur = new Surgery(DriverSession.getLastExecutionDriver());
			sur.clickOnAddSurgergiesIcon();
			sur.verifyAddSurgeriesHeaderTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> selectDiseaseType() {
		List<String> diseaseList = new ArrayList<>();
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			diseaseList = dia.selectRandomDiseaseListType();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return diseaseList;
	}

	public void navigateToNextPage() {
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			dia.nextBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDiseaseList(List<String> actualDiseaseList) {
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			List<String> expectedDiseaseList = dia.diseaseList();
			for (int i = 0; i < actualDiseaseList.size(); i++)
				Keywords.verifyTextMessage(actualDiseaseList.get(i), expectedDiseaseList.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, List<String>> selectSubDiseaseAndAge(List<String> diseaseList) {
		HashMap<String, List<String>> info = new HashMap<>();
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			info = dia.selectSubDiaseaseAndAtAge(diseaseList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public boolean selectSurgeryOption(boolean status) {
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			dia.selecSurgeryOption(status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public void selectTellUsMoreInfo(boolean surgeryOptions, int userAge) {
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			if (surgeryOptions)
				dia.tellUsMoreAboutYourSurgeries(userAge);
			else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitDiagnosisDetails() {
		try {
			Diagnosis dia = new Diagnosis(DriverSession.getLastExecutionDriver());
			dia.submitDiagnosisDetail();
			dia.verifyDiagnosisSurveyMessage();
			dia.hideDiagnosisSurveyPopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>> My Health allergy page
	public HashMap<String, String> addAllergy() {
		HashMap<String, String> allergyListDetails = new LinkedHashMap<>();
		List<String> allergiesList;
		String allergyName = "";
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			navigateToClinicalPage();
			allergiesList = allergy.getAllergiesList();
			// System.out.println("Already Added Allergies List.." +
			// allergiesList.size() + "\n" + allergiesList);
			addAllergyFromClinicalPage();
			allergyName = allergy.addedAllergyName(allergiesList);
			allergyListDetails.put("allergyName", allergyName);
			allergyListDetails.put("allergyStatus", allergy.addAllergyStatus());
			allergyListDetails.put("allergySeverity", allergy.addAllergySeverity());
			allergyListDetails.put("allergyReaction", allergy.enterAllergyReaction());
			allergyListDetails.put("allergyOnSetDate", allergy.setEpisodeDate("onset Date"));
			allergyListDetails.put("allergyLastEpisodeDate", allergy.setEpisodeDate("lastEpisode Date"));
			allergyListDetails.put("allergyTreatment", allergy.enterAllergyTreatment());
			allergy.submitAddAllergyPage();
			// allergy.verifyAllergySuccessfullyAddedMessage(allergyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allergyListDetails;
	}

	public void addAllergyWithNegativeInputs() {
		Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
		allergy.addAllergyFromAllergyPage();

	}

	public void removeAddedAllergy(String allergyName) {
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergy.navigateToAllergiesPage();
			allergyName = allergy.selectAllergyFromList(allergyName);
			allergy.clickOnAllergyRemoveBtn();
			allergy.verifyAllergyNameAfterRemove(allergyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getAddedAllergyInfo(Map<String, String> allergyDetail) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			info.put("allergy", allergy.addedAllergyName(allergyDetail.get("allergyName")));
			info.put("status", allergy.addedAllergyStatus(allergyDetail.get("allergyStatus")));
			info.put("severity", allergy.addedAllergySeverity(allergyDetail.get("allergySeverity")));
			info.put("reaction", allergy.addedAllergyReaction(allergyDetail.get("allergyReaction")));
			info.put("setDate", allergy.addedAllergyOnSetDate(allergyDetail.get("allergyOnSetDate")));
			info.put("lastEpisode", allergy.addedAllergyLastEpisodeDate(allergyDetail.get("allergyLastEpisodeDate")));
			info.put("treatment", allergy.addedAllergyTreatment(allergyDetail.get("allergyTreatment")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void verifyAllergyPageLoaded() {
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergy.verifyAllergyPageLoaded();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<String> getAddedAllergyInfo(String allergyName) {
		List<String> info = new ArrayList<>();
		Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
		info.add(allergy.getAllergyName(allergyName));
		info.add(allergy.getAllergyStatusBasedOnAllergy(allergyName));
		info.add(allergy.getAllergySeverityBasedOnAllergy(allergyName));
		info.add(allergy.getAllergyReactionBasedOnAllergy(allergyName));
		info.add(allergy.getAllergyOnSetBasedOnAllergy(allergyName));
		info.add(allergy.getAllergyLastEpisodeBasedOnAllergy(allergyName));
		info.add(allergy.getAllergyTreatmentBasedOnAllergy(allergyName));

		return info;

	}

	public void verifyAddedAllergyOnAllergyPage(HashMap<String, String> addedAllergy) {
		List<String> addedAllergyInfo = new ArrayList<>(addedAllergy.values());
		List<String> allergiesInfoOnDetailPage;// new
												// ArrayList<>(getAddedAllergyInfo(addedAllergy).values());
		List<String> headerValue = new ArrayList<>(addedAllergy.keySet());
		try {
			navigateToAllergiesDetailPage();
			verifyAllergyPageLoaded();
			allergiesInfoOnDetailPage = getAddedAllergyInfo(addedAllergyInfo.get(0));
			for (int i = 0; i < addedAllergyInfo.size(); i++) {
				if (addedAllergyInfo.get(i).equalsIgnoreCase(allergiesInfoOnDetailPage.get(i)))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							headerValue.get(i) + "<b> value found successfully</b>", "PASS",
							headerValue.get(i) + "<b> value should be match</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							headerValue.get(i) + "<b> value not found successfully</b>", "FAIL",
							headerValue.get(i) + "<b> value should be match</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while verifing the allergy info with added allergy info</b>", "FAIL",
					"<b>Allergy & added allergy value should be match</b>");
		}
	}

	public void navigateToAllergiesDetailPage() {
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergy.navigateToAllergiesPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, List<String>> getAlleryInfoFromAllergyPage() {
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		List<String> allergiesList;
		String listAsString = "";
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			allergiesList = allergy.getAllergiesList();
			if (allergiesList.size() > 0
					&& !allergiesList.get(0).equalsIgnoreCase("Based on your filters, data is not available.")) {
				for (int i = 0; i < allergiesList.size(); i++) {
					listAsString = allergy.getAllergiesTypeList().get(i) + "  "
							+ allergy.getAllergiesStatusList().get(i) + "  "
							+ allergy.getAllergiesSeverityList().get(i);
					info.put(allergiesList.get(i), Arrays.asList(listAsString.split("  ")));
				}
			} else {
				if (allergy.noAllergyFound()) {
					// allergiesList.add("Based on your filters, data is not
					// available.");
					info.put("NoData", allergiesList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}
	
	
	public String getRandomAllergyType() {
		List<String> allergiesTypeList;
		String allergyType = "";
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergiesTypeList = allergy.getAllergiesTypeList();
			allergyType = allergiesTypeList.get(Keywords.getRandomInteger(allergiesTypeList.size() - 1)).trim();
			while (allergyType == null) {
				allergyType = allergiesTypeList.get(Keywords.getRandomInteger(allergiesTypeList.size() - 1)).trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allergyType;
	}

	public String getRandomAllergyStatus() {
		List<String> allergiesStatusList;
		String allergyStatus = "";
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergiesStatusList = allergy.getAllergiesStatusList();
			allergyStatus = allergiesStatusList.get(Keywords.getRandomInteger(allergiesStatusList.size() - 1)).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allergyStatus;
	}

	public String getRandomAllergySeverity() {
		List<String> allergiesSeverityList;
		String allergySeverity = "";
		try {
			Allergy allergy = new Allergy(DriverSession.getLastExecutionDriver());
			allergiesSeverityList = allergy.getAllergiesSeverityList();
			allergySeverity = allergiesSeverityList.get(Keywords.getRandomInteger(allergiesSeverityList.size() - 1))
					.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allergySeverity;
	}

	public List<String> getAllergiesListBasedOnRandomParameter(String byType, String status, String severity,
			String filterType) {
		List<String> allergiesList = new ArrayList<>();
		HashMap<String, List<String>> allergiesInfo = getAlleryInfoFromAllergyPage();

		if (filterType.contains("type") && filterType.contains("status")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(byType) && map.getValue().contains(status)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else if (filterType.contains("type") && filterType.contains("severity")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(byType) && map.getValue().contains(severity)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else if (filterType.contains("status") && filterType.contains("severity")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(status) && map.getValue().contains(severity)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else if (filterType.contains("type")) {
			int i = 0;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(byType)) {
					allergiesList.add(map.getKey());
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else if (filterType.contains("status")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(status)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else if (filterType.contains("severity")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(severity)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		} else {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : allergiesInfo.entrySet()) {
				if (map.getValue().contains(byType) && map.getValue().contains(status)
						&& map.getValue().contains(severity)) {
					check = true;
					allergiesList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (allergiesInfo.size() - 1 == i)
					allergiesList.add("Based on your filters, data is not available.");
				i++;
			}
		}
		return allergiesList;
	}

	public HashMap<String, List<String>> getAllergiesInfoBasedOnParameter(List<String> allergieslist) {
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		HashMap<String, List<String>> allergiesInfo = getAlleryInfoFromAllergyPage();
		List<String> allergiesList = allergieslist;
		try {
			Keywords.waitForPage(driver);
			if (allergiesList.get(0).equalsIgnoreCase("Based on your filters, data is not available.")) {
				info.put("NoData", allergiesList);
			} else {
				for (int i = 0; i < allergiesList.size(); i++) {
					info.put(allergiesList.get(i), allergiesInfo.get(allergiesList.get(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	public void applyFilterOnType(String filterTypeValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterTypeValue.length() > 0) {
				filter.enableFilterType();
				filter.selectFilterTypeValues(filterTypeValue);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnStatus(String filterStatusValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterStatusValue.length() > 0) {
				filter.enableFilterStatus();
				filter.selectFilterStatusValues(filterStatusValue);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnSeverity(String filterSeverityValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterSeverityValue.length() > 0) {
				filter.enableFilterSeverity();
				filter.selectFilterSeverityValues(filterSeverityValue);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilter(String type, String status, String severity, String filterType) {
		try {
			if (filterType.contains("type") && filterType.contains("status")) {
				severity = "";
			} else if (filterType.contains("type") && filterType.contains("severity")) {
				status = "";
			} else if (filterType.contains("status") && filterType.contains("severity")) {
				type = "";
			} else if (filterType.equals("type")) {
				status = "";
				severity = "";
			} else if (filterType.contains("status")) {
				type = "";
				severity = "";
			} else if (filterType.contains("severity")) {
				type = "";
				status = "";
			}
			applyFilterOnType(type);
			applyFilterOnStatus(status);
			applyFilterOnSeverity(severity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnAllergies() {
		String type = "";
		String status = "";
		String severity = "";
		String filterType = DriverSession.getTestCaseData().get("FilterTypeData");
		HashMap<String, List<String>> allergiesWithInfoList;
		HashMap<String, List<String>> allergiesInfoListAfterFilter;
		List<String> allergiesList;
		try {
			navigateToAllergiesDetailPage();
			type = getRandomAllergyType();
			status = getRandomAllergyStatus();
			severity = getRandomAllergySeverity();
			allergiesList = getAllergiesListBasedOnRandomParameter(type, status, severity, filterType);
			allergiesWithInfoList = getAllergiesInfoBasedOnParameter(allergiesList);
			applyFilter(type, status, severity, filterType);
			allergiesInfoListAfterFilter = getAlleryInfoFromAllergyPage();
			verifyAllergyDetailsAfterApplyFilter(allergiesWithInfoList, allergiesInfoListAfterFilter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAllergyDetailsAfterApplyFilter(HashMap<String, List<String>> infoWithParameter,
			HashMap<String, List<String>> infoWithFilter) {
		try {
			Keywords.waitForPage(driver);
			for (Map.Entry<String, List<String>> map : infoWithParameter.entrySet()) {
				if (infoWithFilter.containsKey(map.getKey()) && infoWithFilter.containsValue(map.getValue()))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Allergy Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " match successfully</b>",
							"PASS", "<b>Allergy Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Allergy Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " not match successfully</b>",
							"FAIL", "<b>Allergy Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// MyHealth Family Member
	public List<String> addFamilyMember() {
		List<String> familyMemberInfoList = new ArrayList<>();
		try {
			FamilyHistory family = new FamilyHistory(DriverSession.getLastExecutionDriver());
			family.navigateToFamilyHistoryPage();
			family.clickOnAddFamilyHistory();
			family.verifyInviteFamilyMemberHeaderText();
			familyMemberInfoList.add(family.enterFName());
			familyMemberInfoList.add(family.enterLName());
			familyMemberInfoList.add(family.selectFamilyMemberRelation());
			familyMemberInfoList.add(family.enterFamilyMemberDOB());
			familyMemberInfoList.add(family.enterFamilyMemberEmailAddress());
			family.submitFamilyMemberWithInviteBtn();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return familyMemberInfoList;
	}

	public List<String> addFamilyMemberInfo() {
		List<String> info = new ArrayList<>();
		String completeName = "";
		String fname = "";
		String relation = "";
		try {
			FamilyHistory fHistory = new FamilyHistory(DriverSession.getLastExecutionDriver());
			relation = fHistory.randomFamilyMemberRelation();
			fHistory.navigateToFamilyHistoryPage();
			fHistory.clickOnAddFamilyHistory();
			fHistory.verifyInviteFamilyMemberHeaderText();
			if (relation.equalsIgnoreCase("Brother"))
				fname = "QAB" + Keywords.getRandomIntegerBtRange(5, 8);
			else
				fname = "QAS" + Keywords.getRandomIntegerBtRange(5, 8);
			fHistory.enterFName(fname);
			fHistory.enterLName("Tester");
			completeName = fname + " Tester";
			info.add(completeName);
			info.add(fHistory.selectRandomFamilyMemberRelation(relation));
			info.add(fHistory.enterFamilyMemberDOB());
			fHistory.submitFamilyMemberInfoWithoutInvite();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public List<String> fillMedicalInfoForm() {
		List<String> info = new ArrayList<>();
		try {
			// FamilyHistory fHistory = new
			// FamilyHistory(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	public void addFamilyMemberWithInvalidData() {
		String sheetLocation = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
				+ GlobalParam.slash + "BWellFiles" + GlobalParam.slash + "TestDataForFamilyMember.ods";
		try {
			FamilyHistory family = new FamilyHistory(DriverSession.getLastExecutionDriver());
			HashMap<Integer, List<String>> memberSheetData = ExcelUtility.getInstance().familyMemberData(sheetLocation);
			family.navigateToFamilyHistoryPage();
			for (Map.Entry<Integer, List<String>> map : memberSheetData.entrySet()) {
				List<String> list = map.getValue();
				family.clickOnAddFamilyHistory();
				family.verifyInviteFamilyMemberHeaderText();
				family.enterFName(list.get(0));
				family.enterLName(list.get(1));
				family.selectFamilyMemberRelation(list.get(2));
				family.enterMemberDob(list.get(3));
				family.enterFamilyMemberEmailAddress(list.get(4));
				family.submitFamilyMemberInfoWithoutInvite();
				family.closeAddFamilyMemberInfoWindow();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// fill family member info itself.
	public void navigateToAddMedicationPage() {
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.navigateToMedicationPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToPriceComparisionPage() {
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.navigateToPriceComparisionPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMedicinePriceComparision() {
		try {
			navigateToPriceComparisionPage();
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.searchMedicine(medication.getRandomMedicine());
			medication.verifyMedicinePriceOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addMedicationForPrescription() {
		String drugName = "";
		List<String> prescriptionInfo = new ArrayList<>();
		List<String> drInfo = new ArrayList<>();
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			drugName = medication.enterDrugName("pre");
			prescriptionInfo.add(drugName);
			prescriptionInfo.add(medication.enterDrugDosage(drugName));
			prescriptionInfo.add(medication.enterDrugQuantity());
			medication.drugInstruction();
			medication.selectDrugRelatedCondition().get(0);
			drInfo = medication.prescriptionDoctor();
			prescriptionInfo.add(drInfo.get(0));
			prescriptionInfo.add(drInfo.get(1));
			medication.selectPrescribedDate();
			medication.selectLastRefillDate();
			prescriptionInfo.add(medication.selectRefillRemaining());
			prescriptionInfo.add(medication.rxNumber());
			// medication.selectPharmacy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prescriptionInfo;
	}

	public List<String> addMedicationForOTC() {
		String drugName = "";
		List<String> otcInfo = new ArrayList<>();
		List<String> drInfo = new ArrayList<>();
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			drugName = medication.enterDrugName("otc");
			otcInfo.add(drugName);
			otcInfo.add(medication.enterDrugDosage(drugName));
			otcInfo.add(medication.enterDrugQuantity());
			medication.drugInstruction();
			medication.selectDrugRelatedCondition().get(0);
			drInfo = medication.prescriptionDoctor();
			otcInfo.add(drInfo.get(0));
			otcInfo.add(drInfo.get(1));
			medication.selectPrescribedDate();
			medication.selectLastRefillDate();
			otcInfo.add(medication.selectRefillRemaining());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otcInfo;
	}

	public String randomMedicationType() {
		List<String> info = new ArrayList<>();
		info.add("pre");
		info.add("otc");
		return info.get(Keywords.getRandomInteger(info.size()));
	}

	public List<String> addMedication(String medicationType) {
		List<String> medicationInfo = new ArrayList<>();
		try {
			MyDoctors doctor = new MyDoctors(DriverSession.getLastExecutionDriver());
			navigateToAddMedicationPage();
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.clickOnAddMedicationBtn();
			medication.verifyAddMedicationHeaderTxt();
			medication.selectMedicationType(medicationType);
			if (medicationType.equalsIgnoreCase("pre"))
				medicationInfo = addMedicationForPrescription();
			else
				medicationInfo = addMedicationForOTC();
			medication.addPhoto();
			medication.submitAddMedicationWindow();
			if (medicationInfo.get(4).equalsIgnoreCase("yes")) {
				hideVerifyMedicalRecordsDuringRegistration();
				doctor.feedbackSurvey();
			}
			medicationInfo.remove(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicationInfo;
	}

	public List<String> addMedicationFromClinical(String medicationType) {
		List<String> medicationInfo = new ArrayList<>();
		try {
			navigateToClinicalPage();
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.clickOnAddMedicationFromClinical();
			medication.verifyAddMedicationHeaderTxt();
			medication.selectMedicationType(medicationType);
			if (medicationType.equalsIgnoreCase("pre"))
				medicationInfo = addMedicationForPrescription();
			else
				medicationInfo = addMedicationForOTC();
			medication.addPhoto();
			medication.submitAddMedicationWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicationInfo;
	}

	public void verifyMedicationTypeTermName() {
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			navigateToClinicalPage();
			medication.verifyMedicationPerTermAsPre();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchDrugAndNavigateToDetailPage(String drugName) {
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.selectDrugNameBySearch(drugName);
		} catch (Exception d) {
			d.printStackTrace();
		}
	}

	public List<String> getAddedMedicationDetail(String medicationType) {
		List<String> medicationInfo = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medicationInfo.add(medication.getPrescriptionName());
			medicationInfo.add(medication.getPrescriptionDosage());
			medicationInfo.add(medication.getPrescriptionQuantity());
			medicationInfo.add(medication.getPrescriberName());
			medicationInfo.add(medication.getRefillRemaining());
			if (medicationType.equalsIgnoreCase("pre"))
				medicationInfo.add(medication.getRXNumber());
			else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return medicationInfo;
	}

	public void verifyAddMedicationDetail(List<String> actualDetail, List<String> expectedDetail) {
		try {
			for (int i = 0; i < actualDetail.size(); i++) {
				if (actualDetail.get(i).equalsIgnoreCase(expectedDetail.get(i)))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Medication Detail </b> match successfully", "PASS",
							"<b>Medication Detail </b> should be matched.");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Medication Detail </b> not match successfully", "FAIL",
							"<b>Medication Detail </b> should be matched.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDrugDeletedSuccessfully(String drugName) {
		try {
			DriverSession.setReporting(false);
			searchDrugAndNavigateToDetailPage(drugName);
			DriverSession.setReporting(true);
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.verifyDrugDeletedSuccessfully(drugName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDrugName(String drugName) {
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			searchDrugAndNavigateToDetailPage(drugName);
			medication.clickOnRemoveMedicationBtn();
			verifyDrugDeletedSuccessfully(drugName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyResultAfterApplyingMedicationFilter(String actualResult, String expectedResult) {
		try {
			if (actualResult.equalsIgnoreCase(expectedResult))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><b>Actul & Expected Medication </b>match successfully</b>", "PASS",
						"<b>Actul & Expected Medication </b>should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><b>Actul & Expected Medication </b>not match successfully</b>", "FAIL",
						"<b>Actul & Expected Medication </b>should be matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnMedication() {
		int randomNumber = 0;
		String medicineName = "";
		String expectedMedicineName = "";
		List<String> drugList;
		try {
			Medications medication = new Medications(DriverSession.getLastExecutionDriver());
			medication.navigateToMedicationPage();
			drugList = medication.getAddedDrugList();
			if (drugList.size() <= 0) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Add Medication First</b>",
						"PASS", "<b>NO Medication Found Please Add First.</b>");
			} else {
				randomNumber = Keywords.getRandomInteger(drugList.size());
				medicineName = drugList.get(randomNumber);
				medication.applyFilterOnMedication(medicineName);
				drugList = medication.getAddedDrugList();
				randomNumber = Keywords.getRandomInteger(drugList.size());
				expectedMedicineName = medication.getAddedDrugList().get(randomNumber);
				verifyResultAfterApplyingMedicationFilter(medicineName, expectedMedicineName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToPharmacyPage() {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.navigateToPharmacyPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetFilter() {
		try {
			MedicalDocument medicalDoc = new MedicalDocument(DriverSession.getLastExecutionDriver());
			medicalDoc.resetFilter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getPharmacyAndZipCodeHashMapBasedOnZipCode(String zipCode) {
		HashMap<String, String> info = new LinkedHashMap<>();
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			HashMap<String, String> pharWithZip = pharmacy.getPharmacyWithZipCode();
			for (Map.Entry<String, String> map : pharWithZip.entrySet()) {
				if (map.getValue().equalsIgnoreCase(zipCode))
					info.put(map.getKey(), map.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void verifyResultAfterApplyingPharmaciesZipCodeFilter(HashMap<String, String> actualResult,
			HashMap<String, String> expectedResult) {
		try {
			for (String str : actualResult.keySet())
				if (expectedResult.containsKey(str))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b><b>Actul & Expected Pharmacies Zipcode & Pharmacy Name </b>match successfully</b>",
							"PASS", "<b>Actul & Expected Pharmacies Zipcode & Pharmacy Name </b>should be matched");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b><b>Actul & Expected Pharmacies Zipcode & Pharmacy Name </b>not match successfully</b>",
							"FAIL", "<b>Actul & Expected Pharmacies Zipcode & Pharmacy Name </b>should be matched");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void applyFilterOnPharmacies() {
		int randomNumber = 0;
		String zipcode = "";
		List<String> zipCodeList;
		HashMap<String, String> pharWithZ = new LinkedHashMap<>();
		HashMap<String, String> pharWithZAfterFilter = new LinkedHashMap<>();
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			navigateToPharmacyPage();
			zipCodeList = pharmacy.getAddedZipCodeList();
			if (zipCodeList.size() <= 0)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Add Pharmacy First</b>", "PASS",
						"<b>NO Pharmacy Found Please Add Pharmacy First.</b>");
			else {
				randomNumber = Keywords.getRandomInteger(zipCodeList.size());
				zipcode = zipCodeList.get(randomNumber);
				pharWithZ = getPharmacyAndZipCodeHashMapBasedOnZipCode(zipcode);
				pharmacy.applyFilterOnZipcode(zipcode);
				pharWithZAfterFilter = pharmacy.getPharmacyWithZipCode();
				verifyResultAfterApplyingPharmaciesZipCodeFilter(pharWithZ, pharWithZAfterFilter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> fillPharmacyForm() {
		List<String> pharmacyInfo = new ArrayList<>();
		String cityName = "";
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			cityName = "New York";// pharmacy.randomCityName();
			pharmacy.clickOnAddPharmacyBtn();
			pharmacyInfo.add(pharmacy.enterPharmacyName());
			pharmacyInfo.add(pharmacy.enterAddressLine1(cityName));
			// pharmacyInfo.add(pharmacy.enterAddressLine2(cityName));
			pharmacyInfo.add(pharmacy.enterCityName(cityName));
			pharmacyInfo.add(pharmacy.enterState(cityName));
			pharmacyInfo.add(pharmacy.enterZipCode(cityName));
			pharmacyInfo.add(pharmacy.enterPhoneNumber());
			pharmacy.submitAddPharmacyPage();
			pharmacy.verifyAddedPharmacyNameOnHeader(pharmacyInfo.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pharmacyInfo;
	}

	public List<String> addPharmacy() {
		List<String> pharmacyInfo = new ArrayList<>();
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			navigateToAddPharmacyPage();
			pharmacyInfo = fillPharmacyForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pharmacyInfo;
	}

	public void verifyAddedPharmacyViaSearch(String pharmacyName) {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.searchPharmacy(pharmacyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAndSelectAddedPharmacy(String pharmacyName) {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.searchAndSelectPharmacy(pharmacyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPharmacyToFavorite(String pharmacyName) {
		try {
			searchAndSelectAddedPharmacy(pharmacyName);
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.clickOnAddToFavoriteBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addRandomPharmacyToFavorite() {
		String pharmacyName = "";
		try {
			Pharmacy pharm = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacyName = pharm.randomPharmacyName();
			addPharmacyToFavoriteForTalkToDoctor(pharmacyName);
			// addPharmacyToFavorite(pharmacyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pharmacyName;
	}

	public void addPharmacyToFavoriteForTalkToDoctor(String pharmacyName) {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.addPharmacyToFavoriteForTTDr(pharmacyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddedPharmacyNameInFavoriteList(String pharmacyName) {
		try {
			Pharmacy pharmacy = new Pharmacy(DriverSession.getLastExecutionDriver());
			pharmacy.navigateToPharmacyPage();
			pharmacy.submitSearchTerm();
			pharmacy.verifyPharmacyNameInFavoriteList(pharmacyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyProfileUserNameAfterUpdation(String actualName, String afterUpdation) {
		if (!actualName.equalsIgnoreCase(afterUpdation))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Actual & Expected UserName</b> match successfully", "PASS",
					"<b>Actual & Expected UserName</b> should be matched");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Actual & Expected UserName</b> not match successfully", "FAIL",
					"<b>Actual & Expected UserName</b> should be matched");
	}

	public void navigateToMyProfilePage() {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.navigateToMyProfilePage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToDigitalWalletPage() {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.navigateToDigitalWalletPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectInsuranceCard(String cName) {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.selectInsuranceCard(cName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addInsuranceCardInDigitalWallet() {
		String insuranceCName = "";
		try {
			navigateToDigitalWalletPage();
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.clickOnAddAnotherCard();
			insuranceCName = wallet.addDigitalWalletCardName();
			wallet.addCardFrontImage();
			wallet.addCardBackImage();
			wallet.submitCardInDigitalWallet();
			selectInsuranceCard(insuranceCName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insuranceCName;
	}

	public List<String> howManyCardWantToAddInDigitalWallet(int howManyCard) {
		String insuranceCName = "";
		List<String> addedCardList = new ArrayList<>();
		try {
			navigateToDigitalWalletPage();
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			for (int i = 0; i < howManyCard; i++) {
				wallet.clickOnAddAnotherCard();
				insuranceCName = wallet.addDigitalWalletCardName();
				addedCardList.add(insuranceCName);
				wallet.addCardFrontImage();
				wallet.addCardBackImage();
				wallet.submitCardInDigitalWallet();
				selectInsuranceCard(insuranceCName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return addedCardList;
	}

	public void verifyInsuranceInDigitalWallet(String insuranceCName) {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.verifyCardInInsuranceList(insuranceCName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shareInsuranceCard(String insuranceCName) {
		String emailAddress = "";
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.shareThisCard();
			emailAddress = wallet.enterShareEmailInvalidAddress();
			wallet.verifyShareBtnModeStatus(emailAddress);
			wallet.verifyMailErrorMsg(emailAddress);
			emailAddress = wallet.enterShareEmailAddress();
			wallet.submitEnterShareEmailAddress();
			wallet.verifyShareCardSuccessfully(insuranceCName, emailAddress);
			wallet.submitShareCardSuccessfullyMsgWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printInsuranceCard(String cName) {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.printThisCard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeInsuranceCard(String insuranceCName) {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			wallet.removeThisCard();
			wallet.verifyCardAfterRemove(insuranceCName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeAllInsuranceCard() {
		try {
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			navigateToDigitalWalletPage();
			wallet.removeAllInsuranceCardFromDigitalWallet();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addCardInDigitalWallet() {
		String cName = "";
		try {
			navigateToDigitalWalletPage();
			DigitalWallet wallet = new DigitalWallet(DriverSession.getLastExecutionDriver());
			cName = wallet.addDigitalWalletCardName();
			wallet.addCardFrontImage();
			wallet.addCardBackImage();
			wallet.submitCardInDigitalWallet();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cName;
	}

	public int getUserPoints() {
		int points = 0;
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			points = profile.getPointCount();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return points;
	}

	public int getUserAge() {
		int age = 0;
		try {
			Keywords.explicitWait(2);
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			navigateToMyProfilePage();
			age = profile.getUserAge();
			disableSettingPanel();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return age;
	}

	public String getUserContactNumber() {
		String number = "";
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			navigateToMyProfilePage();
			number = profile.getUserPhoneNumber();
			profile.closeMyProfileEditWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

	public void updateUserProfileName() {
		String userName = "";
		String lastName = "";
		String fullName = "";
		String accountUserName = "";
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("TestCase 1.1 Update User Profile Name",
					"INFO", "<b>Update User Profile Data</b>");
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			navigateToMyProfilePage();
			profile.clickOnEditBtn();
			profile.verifyEditProfileHeaderTxt(driver);
			fullName = profile.getProfileUserFName();
			lastName = Keywords.getRandomAlphabetic(8);
			fullName = fullName + lastName;
			profile.updateUserLastName(lastName);
			profile.submitProfileChanges();
			userName = profile.getProfileUserName();
			verifyProfileUserNameAfterUpdation(fullName, userName);
			accountUserName = getSelectedAccountName();
			verifyProfileUserNameAfterUpdation(accountUserName, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userProfileWeight() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("TestCase 1.2 Test Weight Validation",
					"INFO", "<b>Update User Profile Weight</b>");
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.clickOnEditBtn();
			profile.verifyEditProfileHeaderTxt(driver);
			profile.enterWrongUserWeight();
			profile.submitProfileChanges();
			if (profile.profileDoneBtnStatus())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Not submit successfully</b>", "FAIL",
						"<b>Profile </b>should be Submit Successfully");
			profile.enterUserWeight(Integer.parseInt(DriverSession.getTestCaseData().get("Weightlbs")));
			profile.submitProfileChanges();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAndVerifyUserRequiredInfoWhileSignup() {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			navigateToMyProfilePage();
			profile.clickOnEditBtn();
			profile.verifyEditProfileHeaderTxt(driver);
			profile.submitProfileChanges();
			profile.verifyErrorMsgForProfileRequiredFields();
			profile.enterUserWeight(Integer.parseInt(DriverSession.getTestCaseData().get("Weightlbs")));
			profile.enterUserHeight();
			profile.submitProfileChanges();
			verifyCongratulationMsgForWeightHeightUpdation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSelectedAccountName() {
		String accName = "";
		try {
			enableSettingPanelView();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			accName = profile.getSelectedAccountName();
			disableSettingPanel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accName;
	}

	public void verifySelectedAccountName(String userName) {
		String accName = "";
		try {
			DriverSession.setStepResult(false);
			enableSettingPanelView();
			DriverSession.setStepResult(true);
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			accName = profile.getSelectedAccountName();
			if (userName.equalsIgnoreCase(accName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Both User Name </b>match successfully", "PASS", "<b>Both User Name </b>should be matched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Both User Name </b>not match successfully", "BUG",
						"<b>Both User Name </b>should be matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String verifyUserNameInsideAccList(String userName) {
		try {
			enableSettingPanelView();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.verifyUserNameInSelectAcc(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userName;
	}

	// Subscriptions Related
	public void navigateToSubscriptionPage() {
		try {
			navigateToMyProfilePage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.selectProfileSubTask("Subscriptions");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToSubscriptionAddFamilyMemberPage() {
		try {
			navigateToMyProfilePage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.selectProfileSubTask("Subscriptions");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAddSubscriptionMemberWindow() {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.closeAddSubscriptionWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewFamilyMember() {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.viewFamilyMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeAddedMember(String memberName) {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			viewFamilyMember();
			profile.deleteSubscriptionMember(memberName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeAllMemberFromSubscription() {
		try {
			DriverSession.setReporting(false);
			login();
			DriverSession.setReporting(true);
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			navigateToSubscriptionAddFamilyMemberPage();
			if (!profile.addFamilyMemberBtnVisiblityStatus()) {
				viewFamilyMember();
				// profile.getAddedFamilyMemberList();
				DriverSession.setStepResult(false);
				profile.deleteSubscriptionMember();
				DriverSession.setStepResult(true);
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Family Member In Subscription</b>", "INFO",
						"<b>Please Add First Family Member In Subscription</b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addSubscriptionMemberUser() {
		String status = "false";
		String name = "";
		List<String> list = new ArrayList<>();
		try {
			navigateToSubscriptionAddFamilyMemberPage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			if (!profile.addFamilyMemberBtnVisiblityStatus()) {
				status = "true";
				viewFamilyMember();
				profile.clickOnAddMember();
			} else
				profile.clickOnAddFamilyMember();
			name = profile.enterMemberFirstName(DriverSession.getTestCaseData().get("Fname"));
			name = name + " " + profile.enterMemberLastName(DriverSession.getTestCaseData().get("Lname"));
			list.add(name);
			list.add(profile.selectDate(1995));
			list.add(profile.selectMemberRelation());
			list.add(profile.enterMemberEmailAddress());
			list.add(status);
			profile.submitSubscriptionMember();
			profile.verifyFamilyMemberSuccessfullyAddedMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> addSubscriptionMemberUser(boolean ageType) {
		String status = "false";
		String name = "";
		List<String> list = new ArrayList<>();
		try {
			navigateToSubscriptionAddFamilyMemberPage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			if (!profile.addFamilyMemberBtnVisiblityStatus()) {
				status = "true";
				viewFamilyMember();
				profile.clickOnAddMember();
			} else
				profile.clickOnAddFamilyMember();
			name = profile.enterMemberFirstName(DriverSession.getTestCaseData().get("Fname"));
			name = name + " " + profile.enterMemberLastName(DriverSession.getTestCaseData().get("Lname"));
			list.add(name);
			if (ageType)
				profile.selectCurrentAge();// list.add(profile.selectDate(1995));
			else {
				list.add(profile.selectDate(1995));
				list.add(profile.enterMemberEmailAddress());
			}
			list.add(profile.selectMemberRelation());
			list.add(status);
			profile.submitSubscriptionMember();
			profile.verifyFamilyMemberSuccessfullyAddedMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> addSubscriptionMemberUserWithoutAge() {
		String status = "false";
		String name = "";
		String emailAddress = "qatestkiwi";
		List<String> list = new ArrayList<>();
		try {
			navigateToSubscriptionAddFamilyMemberPage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			if (!profile.addFamilyMemberBtnVisiblityStatus()) {
				status = "true";
				viewFamilyMember();
				profile.clickOnAddMember();
			} else
				profile.clickOnAddFamilyMember();
			name = profile.enterMemberFirstName(DriverSession.getTestCaseData().get("Fname"));
			name = name + " " + profile.enterMemberLastName(DriverSession.getTestCaseData().get("Lname"));
			list.add(name);
			emailAddress = emailAddress + Keywords.getRandomIntegerBtRange(11111111, 999999999) + "@yopmail.com";
			list.add(profile.enterMemberEmailAddress(emailAddress));
			// list.add(profile.enterMemberEmailAddress());
			list.add(profile.selectMemberRelation());
			list.add(status);
			profile.subscriptionSaveBtn();
			// profile.submitSubscriptionMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> addSubscriptionMember() {
		List<String> info;
		DriverSession.setReporting(false);
		login();
		DriverSession.setReporting(true);
		info = addSubscriptionMemberUser();
		return info;
	}

	public void addMemberFromSubscriptionRelatedTask() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>Delete All Added Member Inside Subscription</b>");
			removeAllMemberFromSubscription();
			DriverSession.setReporting(false);
			logout();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>Verify Error Message While Add Member Without Age</b>");
			verifyAddSubscriptionMemberWithoutAgeErrorMsg();
			closeAddSubscriptionMemberWindow();
			DriverSession.setReporting(false);
			logout();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>Add Member With Current Age</b>");
			addSubscriptionMember(true);
			DriverSession.setReporting(false);
			logout();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>Add Member With Invalid/Already Used Mail</b>");
			addSubscriptionMember();
			DriverSession.setReporting(false);
			logout();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>Add Member & Verify It In Account List DropDown</b>");
			addMemberFromSubscriptionVerifyInSelectAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMemberFromSubscriptionVerifyInSelectAccount() {
		String userName = "";
		try {
			userName = addSubscriptionMember(true).get(0);
			verifyUserNameInsideAccList(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addSubscriptionMember(boolean ageType) {
		List<String> info;
		DriverSession.setReporting(false);
		login();
		DriverSession.setReporting(true);
		info = addSubscriptionMemberUser(ageType);
		return info;
	}

	public List<String> verifyAddSubscriptionMemberWithoutAgeErrorMsg() {
		List<String> info;
		MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
		DriverSession.setReporting(false);
		login();
		DriverSession.setReporting(true);
		info = addSubscriptionMemberUserWithoutAge();
		profile.verifyErrorMessageForBlankDate();
		return info;
	}

	public void addSubscriptionWithConditionalCheck() {
		boolean validation = false;
		String name = "";
		List<String> ageList = Keywords.convertStringAsList(DriverSession.getTestCaseData().get("AgeListValue"));
		try {
			navigateToSubscriptionAddFamilyMemberPage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			if (!profile.addFamilyMemberBtnVisiblityStatus()) {
				viewFamilyMember();
				profile.clickOnAddMember();
			} else
				profile.clickOnAddFamilyMember();
			name = profile.enterMemberFirstName(DriverSession.getTestCaseData().get("Fname"));
			name = name + " " + profile.enterMemberLastName(DriverSession.getTestCaseData().get("Lname"));
			profile.selectMemberRelation();
			validation = profile.verifyAgeRelatedCheckForMemberSubscription(ageList);
			if (validation)
				profile.enterMemberEmailAddress();
			profile.submitSubscriptionMember();
			profile.verifyFamilyMemberSuccessfullyAddedMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAddedFamilyMember(List<String> memberInfo) {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			if (memberInfo.get(memberInfo.size() - 1).equalsIgnoreCase("false"))
				profile.viewFamilyMember();
			profile.verifyAddedMemberUserName(memberInfo.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddedFamilyMemberUnderSubscription(List<String> memberInfo) {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.backToProfilePage();
			profile.selectProfileSubTask("Subscriptions");
			profile.verifyMemberUnderSubscription(memberInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAddedFamilyMemberAfterUpdate(List<String> memberInfo) {
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.verifyAddedMemberUserName(memberInfo.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String switchUser() {
		String accountName = "";
		try {
			enableSettingPanelView();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			accountName = profile.switchAccountUser();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accountName;
	}

	public void updateAddedFamilyMemberInfo(List<String> addedMemberInfo) {
		List<String> updatedInfo = new ArrayList<>();
		try {
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			updatedInfo = profile.updateAddedMemberInfo(addedMemberInfo.get(0));
			viewAddedFamilyMemberAfterUpdate(updatedInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getNotificationCountFromIconBar() {
		int count = 0;
		try {
			Notification notification = new Notification(DriverSession.getLastExecutionDriver());
			count = notification.getNotificationCountFromIcon();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public void clearAllNotification() {
		try {
			Notification notification = new Notification(DriverSession.getLastExecutionDriver());
			notification.navigateToNotificationPage();
			notification.clearAllNotification();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNotificationsFromIconAndPage(int notificationCount) {
		try {
			Notification notification = new Notification(DriverSession.getLastExecutionDriver());
			notification.navigateToNotificationPage();
			notification.verifyNumberOfNotification(notificationCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> verfiyRecentEncounter() {
		List<String> info = new ArrayList<>();
		try {
			Encounter encounter = new Encounter(DriverSession.getLastExecutionDriver());
			encounter.navigateToAddRecentEncounterPage();
			encounter.clickOnRecentEncounterAddBtn();
			info.add(encounter.selectRecentEncounterDate());
			info.add(encounter.selectPhysician());
			info.add(encounter.selectVisitType());
			info.add(encounter.enterInstructions());
			info.add(encounter.followUpPlan());
			encounter.submitRecentEncounterPage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void navigateToHealthTribePage() {
		try {
			HealthTribe health = new HealthTribe(DriverSession.getLastExecutionDriver());
			health.navigateToHealthTribePage();
			health.verifyHealthTribePageLoaded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addHealthTribe() {
		List<String> info = new ArrayList<>();
		try {
			navigateToHealthTribePage();
			HealthTribe health = new HealthTribe(DriverSession.getLastExecutionDriver());
			health.clickOnAddTribeMemberFromRightSide();
			health.verifyAddTribeMemberHeaderTxt();
			health.addHealthTribeMemberPhoto();
			info.add(health.enterFname());
			info.add(health.enterLname());
			info.add(health.enterRelationship());
			info.add(health.enterEmailAddress());
			health.selectLikeToShareOptions();
			health.submitHealthTribeInfo();
			health.submitGotItBtnWindow();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return info;
	}

	public List<String> addHealthTribe(String invitesMemberAddress) {
		List<String> info = new ArrayList<>();
		try {
			navigateToHealthTribePage();
			HealthTribe health = new HealthTribe(DriverSession.getLastExecutionDriver());
			health.clickOnAddTribeMemberFromRightSide();
			health.verifyAddTribeMemberHeaderTxt();
			health.addHealthTribeMemberPhoto();
			info.add(health.enterFname());
			info.add(health.enterLname());
			info.add(health.enterRelationship());
			info.add(health.enterEmailAddress(invitesMemberAddress));
			health.selectLikeToShareOptions();
			health.submitHealthTribeInfo();
			health.submitGotItBtnWindow();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return info;
	}

	public void verifyHealthTribeMemberViaSearchInInvitationList(List<String> tribeMemberInfo) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.verifyTribeMemberFromSearchInInvitation(tribeMemberInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyHealthTribeMemberViaSearchInMemberList(
			/* List<String> tribeMemberInfo, */ String accName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.verifyTribeMemberFromSearchInMemberList(/* tribeMemberInfo, */accName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyHealthTribeMemberInMemberList(
			/* List<String> tribeMemberInfo, */ String accName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.verifyTribeMemberInMemberList(/* tribeMemberInfo, */accName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> sentInvitationList() {
		List<String> sentinvitationlist = new ArrayList<>();
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			sentinvitationlist = tribe.getSentInvitationList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sentinvitationlist;
	}

	public List<String> sendInvites(String user) {
		List<String> invitesInfo = new ArrayList<>();
		try {
			invitesInfo = addHealthTribe(user);
			verifyHealthTribeMemberInSentInvitationList(invitesInfo.get(0) + " " + invitesInfo.get(1));
			logout();
		} catch (Exception e) {
		}

		return invitesInfo;
	}

	public List<String> healthTribeMembersList() {
		List<String> healthtribememberist = new ArrayList<>();
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			healthtribememberist = tribe.getHealthTribeMemberList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return healthtribememberist;
	}

	public void verifyHealthTribeMemberInSentInvitationList(String accName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.verifyTribeMemberInSentInvitationList(accName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectUserFromMemberList(String accountName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.selectMemberNameFromMemberList(accountName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Apply Health Tribe Code
	public void applyHealthTribeValidCode(String healthTribeCode) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.applyHealthTribeCode(healthTribeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hideHealthTribeCodeWindow() {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.closeHealthTribeCodeWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyHealthTribeInValidCode(String healthTribeCode) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.applyHealthTribeInValidCode(healthTribeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyHealthTribeCodes(String healthTribeCode) {
		try {
			applyHealthTribeInValidCode(DriverSession.getTestCaseData().get("InvalidCode"));
			hideHealthTribeCodeWindow();
			applyHealthTribeValidCode(healthTribeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTribeMember(String tribeMemberName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			verifyHealthTribeMemberInMemberList(tribeMemberName);
			selectUserFromMemberList(tribeMemberName);
			tribe.deleteHealthTribeMember(tribeMemberName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteHealthTribeMembers(List<String> healthTribeMemberList) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			if (healthTribeMemberList.size() > 0)
				tribe.deleteHealthTribeMembersFromHTML(healthTribeMemberList);
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>There are no Member In <i>Health Tribe Member</i></b>", "INFO",
						"<b>First Sent Invitation </b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteInvitationFromSentInvitations(List<String> sentInvitationList) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			if (sentInvitationList.size() > 0)
				tribe.deleteSentRequestFromInvitationList(sentInvitationList);
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>There are no sent invitation</b>", "INFO", "<b>First Sent Invitation </b>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTribeMemberDeleteSuccessfully(String tribeMemberName) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.verifyTribeMemberDeleteSuccessfully(tribeMemberName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewInvites() {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.viewInvites();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void notViewInvites() {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.notViewInvites();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String acceptInvites(String fromInvitesUser) {
		String receiverUser = "";
		try {
			DriverSession.setStepResult(false);
			notViewInvites();
			receiverUser = getSelectedAccountName();
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
			DriverSession.setStepResult(true);
			viewInvites();
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.acceptInvites(fromInvitesUser);
			tribe.verifyCongratulationMsgForJustJoinTribe(fromInvitesUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return receiverUser;
	}

	public String acceptInvitesWhileReceiverSendInvitation(String receiverInviteUser) {
		String senderInfo = "";
		try {
			notViewInvites();
			senderInfo = getSelectedAccountName();
			Keywords.refreshPage(DriverSession.getLastExecutionDriver());
			viewInvites();
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			tribe.acceptInvites(receiverInviteUser);
			tribe.congratulationMsgWhileSwitchToHisAcc(receiverInviteUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return senderInfo;
	}

	public void switchToInvitesUser(boolean switchCondition, String switchToReceiverUser) {
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			if (switchCondition) {
				tribe.switchToUser();
				if (getSelectedAccountName().equalsIgnoreCase(switchToReceiverUser))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							switchToReceiverUser + "<b> User successfully switch to receiver account</b>", "PASS",
							switchToReceiverUser + "<b> User should be switch to receiver account</b>");
			} else
				tribe.closeSwitchInvitesWindow();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while switch/close switch window", "FAIL",
					switchToReceiverUser + "<b> User should be switch/close to receiver account</b>");
		}
	}

	public void sendInvitesBackToSender(boolean status) {
		String invitesSenderName = "";
		try {
			HealthTribe tribe = new HealthTribe(DriverSession.getLastExecutionDriver());
			if (status) {
				tribe.sendInvitesBackToSender();
				invitesSenderName = tribe.getinvitesSenderName();
				tribe.selectLikeToShareOptions();
				tribe.submitHealthTribeInfo();
				tribe.submitGotItBtnWindow();
				Keywords.refreshPage(DriverSession.getLastExecutionDriver());
				verifyHealthTribeMemberInSentInvitationList(invitesSenderName);
			} else
				tribe.rejectSendInvitesBackToSender();
			logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToChangePlanPage() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.clickChangePlanBtn();
			payment.verifyChangePlanHeaderTxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeCurrentSubscriptionPlan() {
		String plan = "";
		try {
			navigateToChangePlanPage();
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			plan = payment.selectSubscriptionPlan();
			payment.whichCCWantToUse();
			submitPaymentInfoAndVerifyPlanChangeMsg(plan);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int navigateToAddCardPage() {
		int addedCardCount = 0;
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.clickChangePaymentMethod();
			payment.verifyChangePaymentMethodHeaderTxt();
			addedCardCount = payment.cardCount();
			payment.addCardBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return addedCardCount;
	}

	public void tapOnAddCardButton() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.addCardBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int navigateToCardDetailPage() {
		int addedCardCount = 0;
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.clickChangePaymentMethod();
			payment.verifyChangePaymentMethodHeaderTxt();
			addedCardCount = payment.cardCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addedCardCount;
	}

	public void verifyChatModel() {
		try {
			ChatModel chat = new ChatModel(DriverSession.getLastExecutionDriver());
			chat.tapOnHelpIcon();
			chat.verifyChatModelWindow();
			chat.hideChatModelWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Support
	public void navigateToSupportPage() {
		try {
			Support support = new Support(DriverSession.getLastExecutionDriver());
			support.navigateToSupportPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToScheduleACall() {
		try {
			Support support = new Support(DriverSession.getLastExecutionDriver());
			navigateToSupportPage();
			support.selectSubLinksInsideSupportTab("schedule");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scheduleACall() {
		String scheduleDataAndTime = "";
		try {
			navigateToScheduleACall();
			Support support = new Support(DriverSession.getLastExecutionDriver());
			scheduleDataAndTime = support.selectRandomAppointmentDate();
			support.verifyPhoneNumberField();
			scheduleDataAndTime = scheduleDataAndTime + " " + support.selectRandomAppointmentTimeSlot();
			support.verifyAppointmentScheduleSuccessfullyMsg();
			support.viewAppointment();
			support.verifyScheduleAppointment(scheduleDataAndTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteScheduledAppoinment() {
		try {
			Support support = new Support(DriverSession.getLastExecutionDriver());
			support.deleteAllScheduledAppointment();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyChatModelFromDifferentLocation() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			SignUp signUp = new SignUp(DriverSession.getLastExecutionDriver());
			verifyChatModel();
			login.clickOnForgotPasswordLink();
			verifyChatModel();
			navigateToHomePage();
			signUp.clickOnSignUpLink();
			verifyChatModel();
		} catch (Exception e) {

		}
	}

	public void submitPaymentInfo() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.savePaymentMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitPaymentInfoAndVerifyPlanChangeMsg(String changeFrom) {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.savePaymentMethod();
			payment.verifySubscriptionPlanChangeTextSubmit(changeFrom);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyPromoCodeWhileAddingNewCard() {
		String promoCodeStatus = "";
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.applyPromoCodeWhileAddNewCard();
			// promoCodeStatus =
			// DriverSession.getTestCaseData().get("PromoCodeOption");
			// if (promoCodeStatus.equalsIgnoreCase("true")) {
			// payment.enableDisableCouponCodeToggle(promoCodeStatus);
			// payment.enterPromoCode(DriverSession.getTestCaseData().get("PromoCode"));
			// } else {
			// if (!payment.verifyPromoCodeTxtBox())
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Promo Code Text Box </b>not visible", "PASS",
			// "<b>Promo Code Text Box </b>should not be visible");
			// else
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Promo Code Text Box </b>visible", "FAIL",
			// "<b>Promo Code Text Box </b>should not be visible");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> cardInformation() {
		List<String> cardInfo = new ArrayList<>();
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			cardInfo.addAll(payment.cardInformation());
			// cardInfo.add(payment.enterCardNumber(DriverSession.getTestCaseData().get("CardNumber")));
			// payment.selectCardMonthValue(DriverSession.getTestCaseData().get("Month"));
			// payment.selectCardYearValue(DriverSession.getTestCaseData().get("Year"));
			// cardInfo.add(payment.enterCVCNumber(DriverSession.getTestCaseData().get("CVC")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cardInfo;
	}

	public void billingAddress() {
		String HomeAddressOption = "";
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.billingAddress();
			// HomeAddressOption =
			// DriverSession.getTestCaseData().get("HomeAddressOption");
			// if (HomeAddressOption.equalsIgnoreCase("false")) {
			// payment.enableDisableHomeAddressToggle(HomeAddressOption);
			// payment.enterCardUserAddress(DriverSession.getTestCaseData().get("Address1"));
			// payment.enterCardUserCity(DriverSession.getTestCaseData().get("City"));
			// payment.enterCardUserState(DriverSession.getTestCaseData().get("State"));
			// payment.enterCardUserZipCode(DriverSession.getTestCaseData().get("Zip"));
			// } else {
			// if (payment.getBillingAddress1().length() > 0 &&
			// payment.getBillingCity().length() > 0
			// && payment.getBillingState().length() > 0 &&
			// payment.getBillingZipCode().length() > 0)
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Billing Address, City, State & Zipcode </b>display
			// successfully", "PASS",
			// "<b>Billing Address, City, State & Zipcode </b>should be
			// display");
			// else
			// DriverSession.getLastExecutionReportingInstance().teststepreporting(
			// "<b>Billing Address, City, State & Zipcode </b>not display
			// successfully", "FAIL",
			// "<b>Billing Address, City, State & Zipcode </b>should be
			// display");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addCard() {
		List<String> info = new ArrayList<>();
		// String promoCodeStatus = "";
		// String HomeAddressOption = "";
		try {
			/*
			 * Payment payment = new
			 * Payment(DriverSession.getLastExecutionDriver());
			 * info.add(payment.enterCardNumber(DriverSession.getTestCaseData().
			 * get("CardNumber")));
			 * payment.selectCardMonthValue(DriverSession.getTestCaseData().get(
			 * "Month"));
			 * payment.selectCardYearValue(DriverSession.getTestCaseData().get(
			 * "Year"));
			 * info.add(payment.enterCVCNumber(DriverSession.getTestCaseData().
			 * get("CVC"))); promoCodeStatus =
			 * DriverSession.getTestCaseData().get("PromoCodeOption"); if
			 * (promoCodeStatus.equalsIgnoreCase("true")) {
			 * payment.enableDisableCouponCodeToggle(promoCodeStatus);
			 * payment.enterPromoCode(DriverSession.getTestCaseData().get(
			 * "PromoCode")); } else { if (!payment.verifyPromoCodeTxtBox())
			 * DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting( "<b>Promo Code Text Box </b>not visible",
			 * "PASS", "<b>Promo Code Text Box </b>should not be visible"); else
			 * DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting( "<b>Promo Code Text Box </b>visible", "FAIL",
			 * "<b>Promo Code Text Box </b>should not be visible"); }
			 * HomeAddressOption =
			 * DriverSession.getTestCaseData().get("HomeAddressOption"); if
			 * (HomeAddressOption.equalsIgnoreCase("false")) {
			 * payment.enableDisableHomeAddressToggle(HomeAddressOption);
			 * payment.enterCardUserAddress(DriverSession.getTestCaseData().get(
			 * "Address1"));
			 * payment.enterCardUserCity(DriverSession.getTestCaseData().get(
			 * "City"));
			 * payment.enterCardUserState(DriverSession.getTestCaseData().get(
			 * "State"));
			 * payment.enterCardUserZipCode(DriverSession.getTestCaseData().get(
			 * "Zip")); } else { if (payment.getBillingAddress1().length() > 0
			 * && payment.getBillingCity().length() > 0 &&
			 * payment.getBillingState().length() > 0 &&
			 * payment.getBillingZipCode().length() > 0)
			 * DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting(
			 * "<b>Billing Address, City, State & Zipcode </b>display successfully"
			 * , "PASS",
			 * "<b>Billing Address, City, State & Zipcode </b>should be display"
			 * ); else DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting(
			 * "<b>Billing Address, City, State & Zipcode </b>not display successfully"
			 * , "FAIL",
			 * "<b>Billing Address, City, State & Zipcode </b>should be display"
			 * ); }
			 */
			info.addAll(cardInformation());
			applyPromoCodeWhileAddingNewCard();
			billingAddress();
			submitPaymentInfo();
			// payment.savePaymentMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void verifyCardCountAfterAddition(int cardCountInitial) {
		int expectedCardCountAfterAddition = 0;
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			expectedCardCountAfterAddition = payment.cardCount();
			if (cardCountInitial + 1 == expectedCardCountAfterAddition)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Card </b>added successfully",
						"PASS", "<b>Card </b>should be added");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b>Card </b>not added successfully", "FAIL", "<b>Card </b>should be added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addCardWithSheetData() {
		String sheetLocationPath = "";
		List<String> info = new ArrayList<>();
		try {
			ExcelUtility eu = new ExcelUtility();
			sheetLocationPath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "BWellFiles" + GlobalParam.slash + "TestDataForAddCard.ods";
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			HashMap<Integer, List<String>> data = eu.testCaseDataSheet(sheetLocationPath, 1);
			for (Map.Entry<Integer, List<String>> map : data.entrySet()) {
				List<String> infoValues = map.getValue();
				System.out.println("infoValues.." + infoValues);
				payment.enterCardNumber(infoValues.get(0));
				payment.selectCardMonthValue(infoValues.get(1));
				payment.selectCardYearValue(infoValues.get(2));
				payment.enterCVCNumber(infoValues.get(3));
				if (infoValues.get(4).equalsIgnoreCase("true")) {
					payment.enableDisableCouponCodeToggle("true");
					payment.enterPromoCode(infoValues.get(5), "addcard");
				} else {
				}
				if (infoValues.get(6).equalsIgnoreCase("false")) {
					payment.enableDisableHomeAddressToggle(infoValues.get(6));
					payment.enterCardUserAddress(infoValues.get(7));
					payment.enterCardUserCity(infoValues.get(8));
					payment.enterCardUserState(infoValues.get(9));
					payment.enterCardUserZipCode(infoValues.get(10));
				} else {
				}
				payment.savePaymentMethod();
				if (payment.savePaymentMethodBtnStatus())
					Keywords.refreshPage(DriverSession.getLastExecutionDriver());
				else
					tapOnAddCardButton();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void navigateToUnSubscribePage() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			navigateToSubscriptionPage();
			payment.clickUnsubscribeBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void unsubscribeUserPlan() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			// payment.clickUnsubscribeBtn();
			payment.verifyUnsubscribePoupWindow();
			payment.submitUnsubscribeWindow();
			payment.verifyQuizHeaderTxt();
			payment.chooseFirstQuestionForCancellingSubscription();
			payment.submitFirstQuestion();
			payment.chooseSecondQuestionForCancellingSubscription();
			payment.submitLastQuestion();
			payment.verifyLogoutMessageWithinTimePeriod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddRegistrationCode() {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			navigateToSubscriptionPage();
			payment.clickAddRegistrationCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubscriptionAssociateUpdateMsg(String associateUserName) {
		try {
			Keywords.explicitWait(5);
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.verifySubscriptionUpdationMsg(associateUserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRegistrationCode(String registrationCode) {
		try {
			navigateToAddRegistrationCode();
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.enterRegistrationCode(registrationCode);
			payment.submitRegistrationCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void subscribePlan(boolean option) {
		try {
			Payment payment = new Payment(DriverSession.getLastExecutionDriver());
			payment.tapOnSubscribeNowBtn();
			payment.selectSubscriptionPlan();
			if (option) {
				payment.selectCreditCardOption(option);
				addCard();
			} else
				submitPaymentInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Medical Document Related task
	public void navigateToMedicalDocumentPage() {
		try {
			navigateToClinicalPage();
			MedicalDocument medical = new MedicalDocument(DriverSession.getLastExecutionDriver());
			medical.clickOnMedicalDocumentBtn();
			medical.verifyMedicalDocumentPageLoaded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> addMedicalDocument() {
		String actualFileName = "No file selected";
		String fileNameAfterClear = "";
		List<String> docInfo = new ArrayList<String>();
		try {
			navigateToMedicalDocumentPage();
			MedicalDocument medical = new MedicalDocument(DriverSession.getLastExecutionDriver());
			medical.addDocumentBtn();
			docInfo.add(medical.addMedicalDocumentName());
			medical.addMedicalDocumentFile();
			medical.clearMedicalDocumentFile();
			fileNameAfterClear = medical.medicalDocumentFileName();
			docInfo.add(fileNameAfterClear);
			medical.verifyMedicalDocumentFileAfterClear(actualFileName, fileNameAfterClear);
			medical.addMedicalDocumentFile();
			medical.submitMedicalDocumentWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return docInfo;
	}

	public void searchAddedMedicalDocument(String documentName) {
		try {
			MedicalDocument medical = new MedicalDocument(DriverSession.getLastExecutionDriver());
			medical.searchMedicalDocument(documentName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getAddedMedicalDocumentDateList() {
		List<String> dateInfo = null;
		try {
			// MedicalDocument medical = new
			// MedicalDocument(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {

		}
		return dateInfo;
	}

	public List<String> shareMedicalDocument() {
		List<String> shareInfo = new ArrayList<>();
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			document.clickOnShareBtn();
			document.verifySharePageHeaderTxt();
			shareInfo.add(document.enterShareFName());
			shareInfo.add(document.enterShareLName());
			shareInfo.add(document.enterShareRelation());
			shareInfo.add(document.enterShareEmailAddress());
			document.submitSharePageInfo();
			document.verifyAndAcceptShareMedicalDocumentPHI();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shareInfo;
	}

	// public String getSubscriptionCodeFromMail(List<String> shareInfo) {
	// String userName = "";
	// String password = "";
	// try {
	// MedicalDocument document = new
	// MedicalDocument(DriverSession.getLastExecutionDriver());
	// userName = DriverSession.getTestCaseData().get("SharedMail");
	// LoginScreen login = new
	// LoginScreen(DriverSession.getLastExecutionDriver());
	// login.navigateToYopmail();
	// login.navigateToUserEmailInbox(userName);
	// password = document.getPasswordFromSharedMedicalDocumnetMail();
	// document.viewBWellSharedMedicalDocumentMailLink(userName);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return password;
	// }

	public void closeYopMailWindow() {
		try {
			Keywords.switchToWindowHandle(DriverSession.getLastExecutionDriver(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getRegistrationCodeFromSubscriptionMail(List<String> shareInfo) {
		String emailAddress = shareInfo.get(3);
		String registrationcode = "";
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail(DriverSession.getTestCaseData().get("YopMailUrl"));
			login.navigateToUserEmailInbox(emailAddress);
			registrationcode = login.getRegistrationCodeFromSubscription();
			System.out.println("registrationcode....." + registrationcode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return registrationcode;
	}

	public void verifyResponseNotSendToID(List<String> userInfo) {
		String emailAddress = userInfo.get(3);
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail(DriverSession.getTestCaseData().get("YopMailUrl"));
			login.navigateToUserEmailInbox(emailAddress);
			login.verifyResponseNotSendBackToMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAndSubmitClinicalSummaryDocumentPassword(String password, String documentName) {
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			document.enterClinicalSummaryDocumentPassword(password);
			document.submitClinicalOrMedicalRecordsWindow();
			document.verifyClinicalSummaryDocumentImageVisiblity(documentName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAndSubmitMedicalRecordsDocumentPassword(String password) {
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			document.enterMedicalRecordsAuthorizationDocumentPassword(password);
			document.submitClinicalOrMedicalRecordsWindow();
			document.verifyMedicalRecordsAuthorizationEFormDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String testYopMailForShareDocument(List<String> medicalDocumentInfo, List<String> shareInfo) {
		String userName = "";
		String password = "";
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			userName = DriverSession.getTestCaseData().get("SharedMail");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail();
			login.navigateToUserEmailInbox(userName);
			password = document.getPasswordFromSharedMedicalDocumnetMail();
			document.viewBWellSharedMedicalDocumentMailLink(shareInfo.get(0));
			verifyAndSubmitClinicalSummaryDocumentPassword(password, medicalDocumentInfo.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return password;
	}

	public void verifyShareInsuranceCardDetailOnMail(String insuranceCName) {
		String userName = "";
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			userName = DriverSession.getTestCaseData().get("SharedMail");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail();
			login.navigateToUserEmailInbox(userName);
			document.shareInsuranceCardMailLink(insuranceCName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String testYopMailForShareAuthorization(List<String> shareInfo) {
		String userName = "";
		String password = "";
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			userName = DriverSession.getTestCaseData().get("SharedMail");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail();
			login.navigateToUserEmailInbox(userName);
			password = document.getPasswordFromConnectionAuthorizationsMail();
			document.viewConnectionAuthorizationMailLink(shareInfo.get(0));
			verifyAndSubmitMedicalRecordsDocumentPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return password;
	}

	public String testYopMailForHealthTribeMember(List<String> shareInfo) {
		String userName = "";
		String password = "";
		try {
			MedicalDocument document = new MedicalDocument(DriverSession.getLastExecutionDriver());
			userName = shareInfo.get(3);// DriverSession.getTestCaseData().get("SharedMail");
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.navigateToYopmail();
			login.navigateToUserEmailInbox(userName);
			password = document.getPasswordFromHealthTribeMemberMail();
			Keywords.closeWindow(driver);
			Keywords.switchToWindowHandle(driver, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return password;
	}

	public void verifyShareDocumentFromSendMail(List<String> shareInfo) {
		// String password = "";
		try {
			// MedicalDocument document = new
			// MedicalDocument(DriverSession.getLastExecutionDriver());
			// password = testYopMailForShareDocument(shareInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Password Related
	public void navigateToSecuritySettingsPage() {
		try {
			navigateToMyProfilePage();
			MyProfile profile = new MyProfile(DriverSession.getLastExecutionDriver());
			profile.selectProfileSubTask("Security Settings");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String updatePasswordWithInvalidData() {
		String password = "";
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.updatePasswordWithInvalidData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public String updatePasswordWithValidData() {
		String password = "";
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			password = login.updatePasswordWithValidData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public void verifyUserLogoutAfterFiveSeconds() {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.verifyUserLogoutAfterFiveSeconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// >>>>>>>>>>>>> Apply Filter On View Authorization >>>>>>>>>>>>>>>
	public String getRandomSpecialityType() {
		int randomNumber = 0;
		String speciality = "";
		List<String> list;
		try {
			ViewAuthorization view = new ViewAuthorization(DriverSession.getLastExecutionDriver());
			list = view.getSpecialityList();
			randomNumber = Keywords.getRandomInteger(list.size());
			speciality = list.get(randomNumber).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return speciality;
	}

	public String getRandomMedicalRecordsStatus() {
		int randomNumber = 0;
		String medicalRecords = "";
		List<String> list;
		try {
			ViewAuthorization view = new ViewAuthorization(DriverSession.getLastExecutionDriver());
			list = view.getMedicalRecordsStatusList();
			randomNumber = Keywords.getRandomInteger(list.size());
			medicalRecords = list.get(randomNumber).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicalRecords;
	}

	public String getRandomAuthorizationsStatus() {
		int randomNumber = 0;
		String authStatus = "";
		List<String> list;
		try {
			ViewAuthorization view = new ViewAuthorization(DriverSession.getLastExecutionDriver());
			list = view.getAuthorizationList();
			randomNumber = Keywords.getRandomInteger(list.size());
			authStatus = list.get(randomNumber).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authStatus;
	}

	public HashMap<String, List<String>> getDoctorInfoFromViewAuthorizationPage() {
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		List<String> doctorList;
		String listAsString = "";
		try {
			ViewAuthorization view = new ViewAuthorization(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			doctorList = view.getDoctorList();
			// System.out.println("Doctor List Before Parmeter..." +
			// doctorList);
			if (doctorList.size() > 0 && !doctorList.get(0)
					.equalsIgnoreCase("You have no medical authorizations that meet the filter criteria")) {
				for (int i = 0; i < doctorList.size(); i++) {
					listAsString = view.getSpecialityList().get(i) + "  " + view.getMedicalRecordsStatusList().get(0)
							+ " " + view.getAuthorizationList().get(0);
					// listAsString = view.getSpecialityList().get(i) + " " +
					// view.getMedicalRecordsStatusList().get(i) + " " +
					// view.getAuthorizationList().get(i) ;
					// System.out.println(doctorList.get(i) + "<<<>>" +
					// listAsString);
					info.put(doctorList.get(i), Arrays.asList(listAsString.split("  ")));
				}
			} else {
				if (view.noDoctorFound())
					info.put("NoData", doctorList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public List<String> getDoctorsListBasedOnRandomParameter(String bySpeciality, String byMedicalRecords,
			String byAuthorization, String filterType) {
		String infoNotFound = "You have no medical authorizations that meet the filter criteria";
		List<String> doctorList = new ArrayList<>();
		HashMap<String, List<String>> doctorInfo = getDoctorInfoFromViewAuthorizationPage();
		// System.out.println("Doctor Info With Hash Map..." +
		// doctorInfo.size());
		if (filterType.contains("speciality") && filterType.contains("record")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : doctorInfo.entrySet()) {
				if (map.getValue().contains(bySpeciality) && map.getValue().contains(byMedicalRecords)) {
					check = true;
					doctorList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (doctorInfo.size() - 1 == i)
					doctorList.add(infoNotFound);
				i++;
			}
		}
		/*
		 * else if (filterType.contains("speciality") &&
		 * filterType.contains("authorization")) { int i = 0; boolean check =
		 * false; for (Map.Entry<String, List<String>> map :
		 * doctorInfo.entrySet()) { if (map.getValue().contains(bySpeciality) &&
		 * map.getValue().contains(byAuthorization)) { check = true;
		 * doctorList.add(map.getKey()); if (check) { i = 0; } } else if
		 * (doctorInfo.size() - 1 == i) doctorList.add(infoNotFound); i++; } }
		 * else if (filterType.contains("record") &&
		 * filterType.contains("authorization")) { int i = 0; boolean check =
		 * false; for (Map.Entry<String, List<String>> map :
		 * doctorInfo.entrySet()) { if
		 * (map.getValue().contains(byMedicalRecords) &&
		 * map.getValue().contains(byAuthorization)) { check = true;
		 * doctorList.add(map.getKey()); if (check) { i = 0; } } else if
		 * (doctorInfo.size() - 1 == i) doctorList.add(infoNotFound); i++; } }
		 */

		else if (filterType.contains("speciality")) {
			int i = 0;
			for (Map.Entry<String, List<String>> map : doctorInfo.entrySet()) {
				if (map.getValue().contains(bySpeciality)) {
					doctorList.add(map.getKey());
				} else if (doctorInfo.size() - 1 == i)
					doctorList.add(infoNotFound);
				i++;
			}
		} else if (filterType.contains("record")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : doctorInfo.entrySet()) {
				if (map.getValue().contains(byMedicalRecords)) {
					check = true;
					doctorList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (doctorInfo.size() - 1 == i)
					doctorList.add(infoNotFound);
				i++;
			}
		}
		/*
		 * else if (filterType.contains("authorization")) { int i = 0; boolean
		 * check = false; for (Map.Entry<String, List<String>> map :
		 * doctorInfo.entrySet()) { if
		 * (map.getValue().contains(byAuthorization)) { check = true;
		 * doctorList.add(map.getKey()); if (check) { i = 0; } } else if
		 * (doctorInfo.size() - 1 == i) doctorList.add(infoNotFound); i++; } }
		 */
		else {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : doctorInfo.entrySet()) {
				if (map.getValue().contains(bySpeciality) && map.getValue().contains(byMedicalRecords)
				/* && map.getValue().contains(byAuthorization) */) {
					check = true;
					doctorList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (doctorInfo.size() - 1 == i)
					doctorList.add(infoNotFound);
				i++;
			}
		}
		return doctorList;
	}

	public HashMap<String, List<String>> getDoctorInfoBasedOnParameter(List<String> doctorList) {
		String infoNotFound = "You have no medical authorizations that meet the filter criteria";
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		HashMap<String, List<String>> doctorInfo = getDoctorInfoFromViewAuthorizationPage();
		try {
			Keywords.waitForPage(driver);
			if (doctorList.get(0).equalsIgnoreCase(infoNotFound)) {
				info.put("NoData", doctorList);
			} else {
				for (int i = 0; i < doctorList.size(); i++)
					info.put(doctorList.get(i), doctorInfo.get(doctorList.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	public void applyFilterOnSpeciality(String filterSpecialityValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterSpecialityValue.length() > 0) {
				filter.enableFilterType();
				filter.selectFilterSpecialityValues(filterSpecialityValue);
				Keywords.explicitWait(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnMedicalRecord(String filterMedicalRecordValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterMedicalRecordValue.length() > 0) {
				filter.enableFilterStatus();
				filter.selectFilterMedicalRecorddValues(filterMedicalRecordValue);
				Keywords.explicitWait(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterOnAuthorization(String filterAuthorizationValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (filterAuthorizationValue.length() > 0) {
				filter.enableFilterSeverity();
				filter.selectFilterAuthorizationStatusValues(filterAuthorizationValue);
				Keywords.explicitWait(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyFilterViewAuthorization(String speciality, String medicalRecord, String authorization,
			String filterType) {
		try {
			if (filterType.contains("speciality") && filterType.contains("record")) {
				authorization = "";
			} else if (filterType.contains("speciality") && filterType.contains("authorization")) {
				medicalRecord = "";
			} else if (filterType.contains("record") && filterType.contains("authorization")) {
				speciality = "";
			} else if (filterType.equals("speciality")) {
				medicalRecord = "";
				authorization = "";
			} else if (filterType.contains("record")) {
				speciality = "";
				authorization = "";
			} else if (filterType.contains("authorization")) {
				speciality = "";
				medicalRecord = "";
			}
			applyFilterOnSpeciality(speciality);
			applyFilterOnMedicalRecord(medicalRecord);
			applyFilterOnAuthorization(authorization);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Rewards Filter
	public String getRandomRewardsType() {
		List<String> rewardsTypeList;
		String rewardsTypeValue = "";
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			HealthJourneyAndRewards rewards = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
			filter.enableRewardsType();
			rewardsTypeList = rewards.getRewardsTypeList();
			rewardsTypeValue = rewardsTypeList.get(Keywords.getRandomInteger(rewardsTypeList.size()-1)).trim();
			Keywords.explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("rewardsTypeValue"+rewardsTypeValue);
		return rewardsTypeValue;
	}

	public String getRandomRewardsBrand() {
		List<String> rewardsBrandList;
		String rewardsBrandValue = "";
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			HealthJourneyAndRewards rewards = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
			filter.enableRewardsType();
			rewardsBrandList = rewards.getRewardsBrandList();
			rewardsBrandValue = rewardsBrandList.get(Keywords.getRandomInteger(rewardsBrandList.size()-1)).trim();
			Keywords.explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("rewardsBrandValue"+rewardsBrandValue);
		return rewardsBrandValue;
	}
	
	public void applyRewardsFilterOnType(String rewardsFilterTypeValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (rewardsFilterTypeValue.length() > 0) {
				filter.enableRewardsType();
				filter.selectRewardsFilterTypeValues(rewardsFilterTypeValue);
				Keywords.explicitWait(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyRewardsFilterOnBrand(String rewardsFilterBrandValue) {
		try {
			Filter filter = new Filter(DriverSession.getLastExecutionDriver());
			if (rewardsFilterBrandValue.length() > 0) {
				filter.enableRewardsBrand();
				filter.selectRewardsFilterBrandValues(rewardsFilterBrandValue);
				Keywords.explicitWait(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyFilterOnRewards(String rewardsType, String rewardsBrand, String filterType) {
		try {
			if (filterType.contains("type"))
				rewardsBrand = "";
			else if (filterType.contains("brand"))
				rewardsType = "";
			applyRewardsFilterOnType(rewardsType);
			applyRewardsFilterOnBrand(rewardsBrand);
		}catch(Exception e) {
			
		}
	}
	
//	public void applyFilterForRewards(String type, String brand, String filterType) {
//		try {
//			if (filterType.contains("type") )
//				brand = "";
//			else if (filterType.contains("brand"))
//				type = "";
//			applyFilterOnType(type);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public List<String> getRewardsListBasedOnRandomParameter(String byType, String brand, String filterType) {
		HealthJourneyAndRewards health = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
		List<String> rewardsList = new ArrayList<>();
		HashMap<String, List<String>> rewardsInfo = health.getRewardsItemDetailsList();

		if (filterType.contains("type")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : rewardsInfo.entrySet()) {
				if (map.getValue().contains(byType)) {
					check = true;
					rewardsList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (rewardsInfo.size() - 1 == i)
					rewardsList.add("There are no rewards that match your filters.");
				i++;
			}
		} else if (filterType.contains("brand")) {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : rewardsInfo.entrySet()) {
				if (map.getValue().contains(brand)) {
					check = true;
					rewardsList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (rewardsInfo.size() - 1 == i)
					rewardsList.add("There are no rewards that match your filters.");
				i++;
			}
		} else {
			int i = 0;
			boolean check = false;
			for (Map.Entry<String, List<String>> map : rewardsInfo.entrySet()) {
				if (map.getValue().contains(byType) && map.getValue().contains(brand)) {
					check = true;
					rewardsList.add(map.getKey());
					if (check) {
						i = 0;
					}
				} else if (rewardsInfo.size() - 1 == i)
					rewardsList.add("There are no rewards that match your filters.");
				i++;
			}
		}
		return rewardsList;
	}
	
	public void verifyRewardsDetailsAfterApplyFilter(HashMap<String, List<String>> rewardsInfoListBasedOnRandomParameter,
			HashMap<String, List<String>> rewardsInfoListAfterFilter) {
		try {
			Keywords.waitForPage(driver);
			for (Map.Entry<String, List<String>> map : rewardsInfoListBasedOnRandomParameter.entrySet()) {
				if (rewardsInfoListAfterFilter.containsKey(map.getKey()) && rewardsInfoListAfterFilter.containsValue(map.getValue()))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Rewards Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " match successfully</b>",
							"PASS", "<b>Rewards Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Rewards Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " not match successfully</b>",
							"FAIL", "<b>Rewards Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void applyFilterRewards() {
		String rewardsType = "";
		String rewardsBrand = "";
		String filterType = DriverSession.getTestCaseData().get("FilterTypeData");
		HashMap<String, List<String>> rewardsInfoListBasedOnRandomParameter = null;
		HashMap<String, List<String>> rewardsInfoListAfterFilter = null;
		List<String> rewardsList;
		try {
			navigateToRewardsPage();
			rewardsType = getRandomRewardsType();
			rewardsBrand = getRandomRewardsBrand();
//			rewardsList = getRewardsListBasedOnRandomParameter(rewardsType, rewardsBrand, filterType);
//			//applyFilterForRewards(byType, byBrand, filterType);
//			applyFilterOnRewards(rewardsType, rewardsBrand, filterType);
//			verifyRewardsDetailsAfterApplyFilter(rewardsInfoListBasedOnRandomParameter, rewardsInfoListAfterFilter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDoctorDetailsAfterApplyFilterOnViewAuthorizationPage(
			HashMap<String, List<String>> infoWithParameter, HashMap<String, List<String>> infoWithFilter) {
		try {
			Keywords.waitForPage(driver);
			for (Map.Entry<String, List<String>> map : infoWithParameter.entrySet()) {
				if (infoWithFilter.containsKey(map.getKey()) && infoWithFilter.containsValue(map.getValue()))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Doctor Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " match successfully</b>",
							"PASS", "<b>Doctor Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Doctor Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ " not match successfully</b>",
							"FAIL", "<b>Doctor Name and Value </b>" + map.getKey() + " , " + map.getValue()
									+ "<b> should be matched</b>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyRewardsWithInEarnPriceAfterCheckCheckbox() {
		int points = 0;
		try {
			points = getUserPoints();
			navigateToHealthJourneyAndRewardsPage();
			HealthJourneyAndRewards rewards = new HealthJourneyAndRewards(DriverSession.getLastExecutionDriver());
			rewards.selectRewardsGoalOperation(true);
			rewards.checkShowOnlyRewardsIQualify();
			rewards.verifyPriceAfterCheckShowOnlyRewards(points);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
