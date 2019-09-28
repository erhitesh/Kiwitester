package applicationComponent.BWell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.session.DriverSession;
import com.utilities.GlobalParam;

import action.BWell.WebAction;
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

	public void signUp() {
		action.signUpSlashRegistration();
	}

	public void verifyLoginFunctionality() {
		action.verifyLoginFunctionalityWithRequiredField();
		action.login();
		action.logout();
	}

	public void updatePassword() {
		DriverSession.setReporting(false);
		action.login();
		action.navigateToSecuritySettingsPage();
		DriverSession.setReporting(true);
		action.updatePasswordWithInvalidData();
		action.updatePasswordWithValidData();
		action.verifyUserLogoutAfterFiveSeconds();
	}

	public void verifyForgotPassword() {
		action.sendForgotPasswordLink();
		action.forgotPassword();// action.testYopmail();
		action.login();
	}

	public void verifyAppDownloadLink() {
		action.verifyAppStoreLink();
		action.verifyGooglePlayLink();
	}

	/*
	 * public HashMap<String, String> addADoctor(boolean wantYourMedicalRecords)
	 * { DriverSession.setReporting(false); action.login();
	 * DriverSession.setReporting(true); return
	 * action.doctorRegistrationForm(wantYourMedicalRecords); }
	 */

	public void doctorRegistrationWithNegativeScenario() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.doctorRegistrationWithNegativeData();
	}

	public void addDoctor() {
		boolean medicalRecords = false;
		HashMap<String, String> info = action.addADoctor(medicalRecords);
		action.selectDoctorFromSearchResultList(info.get("DoctorName"));
		action.verifyDoctorDetailOnProfilePage(info);
	}

	public void verifyDiffViewStatusOnDoctorProfile() {
		boolean medicalRecordsWhileRegis = false;
		boolean accessMedicalRecords = true;
		HashMap<String, String> info;
		info = action.addADoctor(medicalRecordsWhileRegis);
		action.diffViewStatusOnDoctorProfilePage(accessMedicalRecords, info.get("DoctorName"));
	}

	public void findADoctorBySpeciality() {
		boolean medicalRecords = false;
		HashMap<String, String> doctorInfo = action.addADoctor(medicalRecords);
		action.selectDoctorFromSearchResultList(doctorInfo.get("DoctorName"));
		action.addToFavourite(doctorInfo);
		action.findADoctorBySpeciality(doctorInfo, action.getMilesValues(2));
	}

	public void verifyMedicalRecordPopupWhileAddToFavorite() {
		DriverSession.setReporting(false);
		action.login();
		action.navigateToFindADoctor();
		DriverSession.setReporting(true);
		action.verifyMedicalRecordPopupWhileAddingToFavorite(action.parameterDataForFindDoctor());
	}

	public void addDoctorToFavouriteAndPCP() {
		boolean medicalRecords = false;
		HashMap<String, String> doctorInfo = action.addADoctor(medicalRecords);
		action.selectDoctorFromSearchResultList(doctorInfo.get("DoctorName"));
		action.addToFavourite(doctorInfo);
		action.addToPCP(doctorInfo);
		action.verifyDoctorAddedToFavouriteAndPCP(doctorInfo.get("DoctorName"));
	}

	public void verifyAuthorizedDoctorMedicalRecordsOperation() {
		boolean medicalRecords = true;
		String operationValue = "download";
		String operationType = action.valueForAuthorizedOperation(operationValue).get(0);
		String subOpType = action.valueForAuthorizedOperation(operationValue).get(1);
		HashMap<String, String> info = action.addADoctor(medicalRecords);
		action.medicalRecordsAuthorizationOperation(info.get("DoctorName"), operationType, subOpType);
	}

	public void removeDoctorFromList() {
		boolean medicalRecords = false;
		String doctorName = "";
		HashMap<String, String> doctorInfo = action.addADoctor(medicalRecords);
		doctorName = action.removeDoctorFromProfilePage(doctorInfo);
		action.verifyDoctorNameAfterDeletion(doctorName);
	}

	public void viewAuthorization() {
		boolean medicalRecords = true;
		HashMap<String, String> info = action.addADoctor(medicalRecords);
		action.verifyViewAuthorizationBtnOnProfilePage(info.get("DoctorName"));
	}

	public void talkToADoctorNow() {
		List<String> signUpInfo;
		HashMap<String, String> info;
		// String str = "qabhardwajtest@yopmail.com Hitesh@123 male";
		// signUpInfo = Keywords.convertStringAsList(str);
		// action.login(signUpInfo.get(0), signUpInfo.get(1));
		signUpInfo = action.signUpSlashRegistration();
		info = action.getAccountUserInfo();
		action.telemedicinConsult(signUpInfo.get(2), info.get("user"), Integer.parseInt(info.get("age")),
				info.get("phone"));
	}

	public void addAllergyWithNegativeData() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
	}

	/*
	 * public HashMap<String, String> addAllergy() {
	 * DriverSession.setReporting(false); action.login();
	 * DriverSession.setReporting(true); HashMap<String, String> allergyDetail =
	 * action.addAllergies(); return allergyDetail }
	 */

	public void addAllergyAndVerifyOnAllergyPage() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		HashMap<String, String> allergyDetail = action.addAllergy();
		action.verifyAddedAllergyOnAllergyPage(allergyDetail);
	}

	public void deleteAddedAllergy() {
		HashMap<String, String> info;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		info = action.addAllergy();
		action.removeAddedAllergy(info.get("allergyName"));
	}

	public void applyFilterOnAllergy() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.applyFilterOnAllergies();
	}

	public void applyFilterOnViewAuthorization() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.applyFilterOnViewAuthorizationMedicalRecords();
	}

	/*
	 * public List<String> addFamilyMember() { List<String> info;
	 * DriverSession.setReporting(false); action.login();
	 * DriverSession.setReporting(true); info = action.addFamilyMember(); return
	 * info; }
	 */

	public void addFamilyMemberDetail() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.addFamilyMember();
	}

	public void fillFamilyMemberDetailItself() {
		List<String> info;
		// String name = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		info = action.addFamilyMemberInfo();
		info.get(0);
		// name = info.get(0);
	}

	public void verifyAddFamilyMemberWithInvalidData() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.addFamilyMemberWithInvalidData();
	}

	// public List<String> addMedications(String medicationType) {
	// List<String> medicationInfo;
	// DriverSession.setReporting(false);
	// action.login();
	// DriverSession.setReporting(true);
	// medicationInfo = action.addMedication(medicationType);
	// return medicationInfo;
	// }

	public void addMedicationAndVerifyItOnDetailPage() {
		String medicationType = action.randomMedicationType();
		List<String> medicationInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		medicationInfo = action.addMedication(medicationType);
		action.navigateToAddMedicationPage();
		action.searchDrugAndNavigateToDetailPage(medicationInfo.get(0));
		List<String> info = action.getAddedMedicationDetail(medicationType);
		action.verifyAddMedicationDetail(medicationInfo, info);
	}

	public void addMedicationAndDeleteIt() {
		String medicationType = action.randomMedicationType();
		List<String> medicationInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		medicationInfo = action.addMedication(medicationType);
		action.navigateToAddMedicationPage();
		action.deleteDrugName(medicationInfo.get(0));
	}

	public void applyFilterOnMedication() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.applyFilterOnMedication();
	}

	public void verifyTermOnMedicationDetail() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyMedicationTypeTermName();
	}

	public void verifyAddPharmacy() {
		List<String> pharmacyInfo;
		pharmacyInfo = action.addPharmacy();
		action.verifyAddedPharmacyViaSearch(pharmacyInfo.get(0));
	}

	public void addAndVerifyPharmacyInFavoriteList() {
		String pharmacyName = "";
		pharmacyName = action.addPharmacy().get(0);
		action.addPharmacyToFavorite(pharmacyName);
		action.verifyAddedPharmacyNameInFavoriteList(pharmacyName);
	}

	public void applyFilterOnPharmacies() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.applyFilterOnPharmacies();
	}

	public void verifyDrugPriceComparision() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyMedicinePriceComparision();
	}

	public void addDiagnosisFromClinical() {
		boolean status = true;
		int userAge = 0;
		List<String> diseaseList;
		// HashMap<String, List<String>> complInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		userAge = action.getUserAge();
		action.navigateToDiagnosisPage();
		diseaseList = action.selectDiseaseType();
		action.navigateToNextPage();
		action.verifyDiseaseList(diseaseList);
		action.selectSubDiseaseAndAge(diseaseList);
		;// complInfo = action.selectSubDiseaseAndAge(diseaseList);
		action.navigateToNextPage();
		action.selectSurgeryOption(status);
		action.selectTellUsMoreInfo(status, userAge);
		action.submitDiagnosisDetails();
	}

	public void addProcedureFromClinical() {
		List<String> physicianList;
		List<String> info;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToClinicalPage();
		physicianList = action.procedurePhysicianList();
		action.navigateToProcedurePage();
		info = action.addProcedure(physicianList);
		action.verifyProcedureInfo(info);
	}

	public void addSurgeriesFromClinical() {
		boolean status = true;
		List<String> diseaseList;
		// HashMap<String, List<String>> complInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToSurgeriesPage();
		diseaseList = action.selectDiseaseType();
		action.navigateToNextPage();
		action.verifyDiseaseList(diseaseList);
		action.selectSubDiseaseAndAge(diseaseList);// complInfo =
													// action.selectSubDiseaseAndAge(diseaseList);
		action.navigateToNextPage();
		action.selectSurgeryOption(status);
		action.submitDiagnosisDetails();
	}

	public void verifyNotifications() {
		int notificationBarCount = 0;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.clearAllNotification();
		action.addMedicationFromClinical("pre");
		notificationBarCount = action.getNotificationCountFromIconBar();
		action.verifyNotificationsFromIconAndPage(notificationBarCount);
	}

	public void updateUserProfile() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.updateUserProfileName();
		action.userProfileWeight();
	}

	public void addInsuranceCardInDigitalWallet() {
		String insuranceCName = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		insuranceCName = action.addInsuranceCardInDigitalWallet();
		action.verifyInsuranceInDigitalWallet(insuranceCName);
	}

	public void shareInsuranceFromDigitalWallet() {
		String insuranceCName = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		insuranceCName = action.addInsuranceCardInDigitalWallet();
		action.shareInsuranceCard(insuranceCName);
		action.verifyShareInsuranceCardDetailOnMail(insuranceCName);
	}

	public void printInsuranceCardFromDigitalWallet() {
		String insuranceCName = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		insuranceCName = action.addInsuranceCardInDigitalWallet();
		action.printInsuranceCard(insuranceCName);
	}

	public void removeInsuranceCardFromDigitalWallet() {
		String insuranceCName = "";
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		insuranceCName = action.addInsuranceCardInDigitalWallet();
		action.removeInsuranceCard(insuranceCName);
	}

	public void removeAllInsuranceCardFromDigitalWallet() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.removeAllInsuranceCard();
	}

	public void addAndVerifySubscriptionMember() {
		List<String> memberInfo = action.addSubscriptionMember();
		action.viewAddedFamilyMember(memberInfo);
		action.verifyAddedFamilyMemberUnderSubscription(memberInfo);
	}

	public void addRegistrationCodeInsideSubscription() {
		String registrationCode = "";
		List<String> subsciptionMemberInfo = action.addSubscriptionMember();
		List<String> userInfo;
		action.viewAddedFamilyMember(subsciptionMemberInfo);
		action.verifyAddedFamilyMemberUnderSubscription(subsciptionMemberInfo);
		registrationCode = action.getRegistrationCodeFromSubscriptionMail(subsciptionMemberInfo);
		action.closeYopMailWindow();
		action.logout();
		userInfo = action.signUpSlashRegistrationWithoutProfileUpdate();
		action.addRegistrationCode(registrationCode);
		action.verifySubscriptionAssociateUpdateMsg(userInfo.get(0));
	}

	public void signUpAddedMemberFromSubscription() {
		String registrationCode = "";
		List<String> createdUserInfo = new ArrayList<>();
		List<String> memberInfo = action.addSubscriptionMember();
		action.viewAddedFamilyMember(memberInfo);
		action.verifyAddedFamilyMemberUnderSubscription(memberInfo);
		registrationCode = action.getRegistrationCodeFromSubscriptionMail(memberInfo);
		action.closeYopMailWindow();
		action.logout();
		createdUserInfo = action.signUpWithRegistrationCode(memberInfo, registrationCode);
		action.verifySelectedAccountName(createdUserInfo.get(1));
	}

	public void addAndUpdateSubscriptionInfo() {
		List<String> info;
		info = action.addSubscriptionMember();
		action.viewAddedFamilyMember(info);
		action.updateAddedFamilyMemberInfo(info);
	}

	public void deleteAddedFamilyMemberFromSubscription() {
		action.removeAllMemberFromSubscription();
	}

	public void conditionalCheckForEmailWithDate() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.addSubscriptionWithConditionalCheck();
	}

	public void addMemberFromSubscriptionVerifyInSelectAccount() {
		boolean ageType = true;
		String userName = "";
//		userName = action.addSubscriptionMember(ageType).get(0);
//		action.verifyUserNameInsideAccList(userName);
		action.addMemberFromSubscriptionRelatedTask();
	}

	public void verifyRecentEncounter() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verfiyRecentEncounter();
	}

	public void addHealthTribeMember() {
		List<String> helathTribeMemberInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		helathTribeMemberInfo = action.addHealthTribe();
		action.verifyHealthTribeMemberViaSearchInInvitationList(helathTribeMemberInfo);
	}

	public void deleteAddedHealthTribeMember() {
		String userAccName = "";
		String healthTribeCode = "";
		List<String> helathTribeMemberInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		userAccName = action.getSelectedAccountName();
		helathTribeMemberInfo = action.addHealthTribe();
		healthTribeCode = action.testYopMailForHealthTribeMember(helathTribeMemberInfo);
		action.applyHealthTribeCodes(healthTribeCode);
		action.deleteTribeMember(userAccName);
		action.verifyTribeMemberDeleteSuccessfully(helathTribeMemberInfo.get(0));
	}

	public void deleteAllSentInvitationRequest() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToHealthTribePage();
		action.deleteInvitationFromSentInvitations(action.sentInvitationList());
	}

	public void acceptRejectHealthTribeInvites() {
		String receiverUser = "";
		String sendInvitesUser = "";
		List<String> signUpInfo;
		DriverSession.setReporting(false);
		signUpInfo = action.signUpSlashRegistration();
		DriverSession.setReporting(true);
		sendInvitesUser = action.getSelectedAccountName();
		action.sendInvites(DriverSession.getTestCaseData().get("Username"));
		action.login();
		action.acceptInvites(sendInvitesUser);
		action.sendInvitesBackToSender(false);
		action.login(signUpInfo.get(0), signUpInfo.get(1));
		action.navigateToHealthTribePage();
		action.verifyHealthTribeMemberInMemberList(receiverUser);
		action.deleteHealthTribeMembers(action.healthTribeMembersList());
	}

	public void switchToInvitesHealthTribeUser() {
		String sendInviesToUser = DriverSession.getTestCaseData().get("Username");
		String receiverUser = "";
		String fromInvitesUser = "";
		List<String> signUpInfo;
		DriverSession.setReporting(false);
		signUpInfo = action.signUpSlashRegistration();
		// action.login("qabhardwajtest@yopmail.com", "Hitesh@123");
		DriverSession.setReporting(true);
		fromInvitesUser = action.getSelectedAccountName();
		action.sendInvites(sendInviesToUser);
		action.login();
		receiverUser = action.acceptInvites(fromInvitesUser);
		action.sendInvitesBackToSender(true);
		// action.login("qabhardwajtest@yopmail.com", "Hitesh@123");
		action.login(signUpInfo.get(0), signUpInfo.get(1));
		action.acceptInvitesWhileReceiverSendInvitation(receiverUser);
		action.switchToInvitesUser(true, receiverUser);
		action.verifyUserNameInsideAccList(sendInviesToUser);
		/*
		 * action.verifyHealthTribeMemberInMemberList(receiverUser);
		 * action.deleteHealthTribeMembers(action.healthTribeMembersList());
		 * action.logout(); action.login(); action.navigateToHealthTribePage();
		 * action.deleteHealthTribeMembers(action.healthTribeMembersList());
		 */
	}

	public void addPaymentCard() {
		int cardCountInitial;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToSubscriptionPage();
		cardCountInitial = action.navigateToAddCardPage();
		action.addCard();
		action.verifyCardCountAfterAddition(cardCountInitial);
	}

	public void addPaymentCardWithDifferentDataSet() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToSubscriptionPage();
		action.navigateToCardDetailPage();
		action.tapOnAddCardButton();
		action.addCardWithSheetData();
	}

	public void changeCurrentSubscriptionPlan() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToSubscriptionPage();
		action.changeCurrentSubscriptionPlan();
	}

	public void unsubscribeUserPlan() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.navigateToUnSubscribePage();
		action.unsubscribeUserPlan();
	}

	public void subscribeUserPlan() {
		String signingUp = "no";
		unsubscribeUserPlan();
		DriverSession.setReporting(false);
		action.loginForSubscribeUserPlan();
		DriverSession.setReporting(true);
		action.signingUpAsCompanyOrFamilyForSubscribe(signingUp);
		// action.subscribePlan(option);
	}

	public void verifyChatModelWindow() {
		action.verifyChatModelFromDifferentLocation();
	}

	public void scheduleACall() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.scheduleACall();
	}

	public void deleteAllAppointment() {
		action.navigateToScheduleACall();
		action.deleteScheduledAppoinment();
	}

	public void addMedicalDocument() {
		List<String> info;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		info = action.addMedicalDocument();
		action.searchAddedMedicalDocument(info.get(0));
	}

	public void applyFilterOnMedicalDocument() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
	}

	public void verifyShareMedicalDocument() {
		List<String> medicalDocumentInfo;
		List<String> sharedMedicalDocumentInfo;
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		medicalDocumentInfo = action.addMedicalDocument();
		action.searchAddedMedicalDocument(medicalDocumentInfo.get(0));
		sharedMedicalDocumentInfo = action.shareMedicalDocument();
		action.testYopMailForShareDocument(medicalDocumentInfo, sharedMedicalDocumentInfo);
	}
	
	// Rewards
	public void applyFilterOnRewards() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.applyFilterRewards();
	}
	
	public void verifyRewardsListWithInUserEarnPrice() {
		DriverSession.setReporting(false);
		action.login();
		DriverSession.setReporting(true);
		action.verifyRewardsWithInEarnPriceAfterCheckCheckbox();
	}
}
