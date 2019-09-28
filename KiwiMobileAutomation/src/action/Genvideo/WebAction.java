package action.Genvideo;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.session.DriverSession;

import Genvideo.DesktopWeb.BackStageContent;
import Genvideo.DesktopWeb.BackStageDistribution;
import Genvideo.DesktopWeb.BackStageHomePage;
import Genvideo.DesktopWeb.BackStageUpload;
import Genvideo.DesktopWeb.CampaignPage;
import Genvideo.DesktopWeb.CreatorsLoginScreen;
import Genvideo.DesktopWeb.CreatorsRegistration;
import Genvideo.DesktopWeb.CreatorsUploadPage;
import Genvideo.DesktopWeb.CreatorsVideosPage;
import Genvideo.DesktopWeb.GeneratePage;
import Genvideo.DesktopWeb.LoginScreen;
import action.CommonAll;

public class WebAction extends CommonAll {
	HashMap<String, String> testData = new HashMap<String, String>();
	String campaignTitle = null;
	String clientVideoTitle = null;
	String reelVideoTitle = null;
	String firstQAList = null;
	String firstVideoTitle = null;
	String fileName = null;

	public WebAction(WebDriver driver) {
		super(driver);
		this.testData = DriverSession.getTestCaseData();
	}

	public void login() throws Exception {
		try {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.enterUserName();
			login.enterPassword();
			login.loginUser();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectWorkSpace() throws Exception {
		try {
			BackStageHomePage home = new BackStageHomePage(DriverSession.getLastExecutionDriver());
			home.navigateToSelectWS();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void createNewCampaign() throws Exception {
		try {
			BackStageHomePage backStage = new BackStageHomePage(DriverSession.getLastExecutionDriver());
			backStage.clickCampaign();
			CampaignPage campaign = new CampaignPage(DriverSession.getLastExecutionDriver());
			campaignTitle = campaign.createNewCampaign();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void inviteCreatorsAndPublish() throws Exception {
		try {
			GeneratePage generate = new GeneratePage(DriverSession.getLastExecutionDriver());
			//generate.clickSkip();
			generate.selectCampaign(campaignTitle);
//			generate.inviteCreators();
			generate.returnToCM();
			generate.publishCampaign(campaignTitle);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyUploadVideoWithClient() throws Exception {
		try {
			BackStageUpload upload = new BackStageUpload(DriverSession.getLastExecutionDriver());
			/*upload.clickAddButton();
			upload.clickVideoLink();*/
			upload.clickOnUploadVideoLink();
			upload.selectClientReviewType();
			upload.uploadVideo();
			clientVideoTitle = upload.enterClientVideoForm();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyClientApprovedTextWithPublishButtonDisabled() throws Exception {
		try {
			BackStageUpload approved = new BackStageUpload(DriverSession.getLastExecutionDriver());
			approved.clickContentTab();
			approved.clickVideoTitle(clientVideoTitle);
			approved.verifyReelOrClientTextOnFinalPage(clientVideoTitle);
			approved.verifyPublishButtonDisabled();
			approved.verifyApprovedText();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyManageImagesLink() throws Exception {
	try {
		BackStageUpload manage = new BackStageUpload(DriverSession.getLastExecutionDriver());
		manage.clickManageImages();
//		manage.clickManageImagesChooseFileButton();
//		manage.clickManageImagesUploadButton();
//		manage.verifyUploadImagesSucessMessage();
		manage.clickShowMoreImagesButton();
		manage.verifyShowMoreImagesValues();
		manage.clickManageImagesCloseButton();
	}catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
}
	
	public void verifyDownloadResolution() throws Exception {
		try {
			BackStageUpload download = new BackStageUpload(DriverSession.getLastExecutionDriver());
			download.clickDownloadVideo();
			download.clickDownloadVideo360Resolution();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyUploadVideoWithReel() throws Exception {
		try {
			BackStageUpload upload = new BackStageUpload(DriverSession.getLastExecutionDriver());
			/*upload.clickAddButton();
			upload.clickVideoLink();*/
			
			upload.clickOnUploadVideoLink();
			upload.selectReelReviewType();
			upload.uploadVideo();
			reelVideoTitle = upload.enterReelVideoForm();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyReelApprovedTextWithPublishButton() throws Exception {
		try {
			BackStageUpload approved = new BackStageUpload(DriverSession.getLastExecutionDriver());
			approved.clickContentTab();
			approved.clickVideoTitle(reelVideoTitle);
			approved.verifyReelOrClientTextOnFinalPage(reelVideoTitle);
			approved.clickFinalApprovalButton();
			approved.verifyApprovedText();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyQALists() throws Exception {
		try {
			BackStageContent content = new BackStageContent(DriverSession.getLastExecutionDriver());
			content.clickContent();
			firstVideoTitle = content.verifyFirstVideoTitle();
			content.verifyEmailToAFriend();
			content.verifyAddToAList();
			firstQAList = content.verifyFirstQAListName();
			content.clickSaveButton();
			content.clickListsTab();
			content.clickQALists(firstQAList);
			content.verifyVideoTitleOnQAList(firstVideoTitle);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void backStageDistribution() throws Exception {
		try {
			BackStageDistribution distribute = new BackStageDistribution(DriverSession.getLastExecutionDriver());
			distribute.clickDistribution();
			distribute.clickYouTube();
			distribute.clickManageChannels();
			distribute.clickAddChannel();
			distribute.addGmailAccount();
			distribute.clickDistribution();
			distribute.clickYouTube();
			distribute.selectCheckBox();
			distribute.clickScheduleVideos();
			distribute.selectButton();
			distribute.clickChooseContentNext();
			distribute.clickOptimizeMetadataNext();
			distribute.clickSetDestinationNext();
			distribute.selectDaysOfWeek();
			distribute.enterDate();
			distribute.enterTime();
			distribute.clickCreateAScheduleNext();
			distribute.clickReviewFinish();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
       
	public void creatorsLogin() throws Exception {
		try {
			CreatorsLoginScreen login = new CreatorsLoginScreen(DriverSession.getLastExecutionDriver());
			login.enterUserName();
			login.enterPassword();
			login.loginUser();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// CreatorsVideosPage
	public void uploadVideo() throws Exception {
		try {
			CreatorsUploadPage upload = new CreatorsUploadPage(DriverSession.getLastExecutionDriver());
			upload.clickUploadButton();
			//upload.chooseCampaign();
			upload.uploadVideoFile();
			upload.uploadThumbNailFile();
			upload.enterVideoDescription();
			upload.enterProduct();
			upload.clickProductRating();
			upload.clickFinishButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Uploading Video", "FAIL", "Video should be Uploaded");
			throw e;
		}
	}

	public void publishVideoNowCheckBox() throws Exception {
		try {
			CreatorsVideosPage videoNow = new CreatorsVideosPage(DriverSession.getLastExecutionDriver());
			videoNow.clickPublishButton();
			videoNow.verifyPublishSucessMessage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Publishing Video with Now Selected CheckBox", "FAIL",
					"while Publishing Video Now");
			throw e;
		}
	}

	public void publishVideoWithTimeSetCheckBox() throws Exception {
		try {
			CreatorsVideosPage videoSetTime = new CreatorsVideosPage(DriverSession.getLastExecutionDriver());
			videoSetTime.clickSetDateTimeCheckBox();
			videoSetTime.enterTime();
			videoSetTime.verifyStatusDisabled();
			videoSetTime.clickPublishButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while Publishing Video with Set Date and Time Selected CheckBox", "FAIL",
					"while Publishing Video with Set Date and Time");
			throw e;
		}
	}

	public void verifyEmbedCodeButton() throws Exception {
		try {
			CreatorsVideosPage embedCode = new CreatorsVideosPage(DriverSession.getLastExecutionDriver());
			embedCode.clickEmbedCodeButton();
			embedCode.closeEmbedCodePopUp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Verifying Embed Code Button", "FAIL",
					"while Verifying Embed Code Button");
			throw e;
		}
	}

	public void verifyAffiliateLinkButton() throws Exception {
		try {
			CreatorsVideosPage affiliateLink = new CreatorsVideosPage(DriverSession.getLastExecutionDriver());
			affiliateLink.clickAffiliateLinkButton();
			affiliateLink.closeAffiliateLinksPopUp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Verifying Affiliate Link Button", "FAIL",
					"while Verifying Affiliate Link Button");
			throw e;
		}
	}

	public void verifyManageImagesButton() throws Exception {
		try {
			CreatorsVideosPage manageImages = new CreatorsVideosPage(DriverSession.getLastExecutionDriver());
			manageImages.clickManageImagesButton();
			manageImages.clickManageImagesChooseFileButton();
			manageImages.clickManageImagesUploadButton();
			manageImages.verifyUploadImagesSucessMessage();
			manageImages.clickManageImagesCameraButton();
			manageImages.verifyCameraImagesSucessMessage();
			manageImages.clickManageImagesCloseButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Verifying Affiliate Link Button", "FAIL",
					"while Verifying Affiliate Link Button");
			throw e;
		}
	}

	
	//>>>>>>>>>>>>>. Creator Registration >>>>>>>>>>>>>>>>
	
	public String creatorGetStarted() {
		boolean Status;
		String fandLName = "";
		try {
			CreatorsRegistration registration = new CreatorsRegistration(DriverSession.getLastExecutionDriver());
			registration.verifyRegistrationPageLoaded();
			fandLName = registration.enterCreatorFirstName();
			fandLName = fandLName+" "+registration.enterCreatorLastName();
			registration.enterCreatorPassword();
			registration.enterCreatorConfirmPassword();
			registration.enterCreatorEmailAddress();
			registration.submitGetStartedPage();
			Status = registration.verifySocialConnectionStatus();
			while (!Status) {
				DriverSession.setReporting(false);
				registration.enterCreatorEmailAddress();
				registration.submitGetStartedPage();
				Status = registration.verifySocialConnectionStatus();
				DriverSession.setReporting(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fandLName;
	}

	public void socialConnection(String userName) {
		boolean status;
		try {
			CreatorsRegistration registration = new CreatorsRegistration(DriverSession.getLastExecutionDriver());
			status = registration.verifySocialConnectionStatus();
			if (status) {
				registration.addGmailAccount();
				registration.verifyGmailAccountLinkToYouTube(userName);
				registration.submitSocialConnectionPage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileInformation() {
		boolean status;
		try {
			CreatorsRegistration registration = new CreatorsRegistration(DriverSession.getLastExecutionDriver());
			status = registration.verifyProfileInformationStatus();	
			if (status) {
				registration.verifyGender();
				registration.enterCreatorDate();
				registration.selectYourHouseHoldIncome();
				registration.selectYourEthnicity();
				registration.enterShippingAddress1();
				registration.enterShippingAddress2();
				registration.enterShippingCity();
				registration.selectCreatorCountry();
				registration.selectCreatorCountryState();
				registration.selectCreatorCountryStateCode();
				registration.submitProfileInformationPage();
				if (registration.verifyProfileInformationStatus())
					registration.submitProfileInformationPage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void audienceAndTargeting() {
		boolean status = false;
		try {
			CreatorsRegistration registration = new CreatorsRegistration(DriverSession.getLastExecutionDriver());
			status = registration.verifyAudienceAndTargetingStatus();
			if (status) {
				registration.enterVideoOnlyRate();
				registration.enterYouTubeRate();
				registration.insertTag();
				registration.selectTags();
				registration.whatKindOfVideo();
				registration.removeTag();
				registration.submitAudienceAndTargetingPage();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void socialConnections() {
		//List<String> windowHandle;
		boolean status = false;
		try {
			CreatorsRegistration registration = new CreatorsRegistration(DriverSession.getLastExecutionDriver());
			/*registration.selectSocialConnections();
			windowHandle = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver());
			Keywords.switchToWindowHandle(driver, windowHandle.size()-1);
			registration.enterFBUserName();
			registration.enterFBUserPass();
			registration.submitFBPage();
			windowHandle = Keywords.getWindowHandles(DriverSession.getLastExecutionDriver());
			Keywords.switchToWindowHandle(driver, windowHandle.size()-1);*/
			status = registration.verifySocialConnectionsStatus();
			if (status) {
				registration.submitCreatorRegistration();
				registration.verifyCreatorRegistrationDoneSuccessfully();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyCreatorRegistration() {
		String userName = "";
		try {
			userName = creatorGetStarted();
			socialConnection(userName);
			profileInformation();
			audienceAndTargeting();
			socialConnections();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
