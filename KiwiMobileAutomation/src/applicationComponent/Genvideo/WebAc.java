package applicationComponent.Genvideo;

import org.testng.annotations.Test;

import com.session.DriverSession;
import com.utilities.GlobalParam;

import action.Genvideo.WebAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;

@Test
public class WebAc extends AppComponent implements ApplicationComponent {
	private WebAction action = new WebAction(
			DriverSession.getLastExecutionDriver());

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
		// TODO Auto-generated method stub

	}
	
	public void verifyCreatorVideo() throws Exception {
		try{
			action.login();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyBackStageCampaign() throws Exception {
		try{
			action.login();
			action.selectWorkSpace();
			action.createNewCampaign();
			action.inviteCreatorsAndPublish();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyBackStageContent() throws Exception {
		try{
			action.login();
			action.selectWorkSpace();
			action.verifyQALists();
			action.verifyUploadVideoWithReel();
			action.verifyReelApprovedTextWithPublishButton();
			action.verifyUploadVideoWithClient();
			action.verifyClientApprovedTextWithPublishButtonDisabled();
			action.verifyManageImagesLink();
			action.verifyDownloadResolution();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyBackStageDistribution() throws Exception {
		try{
			action.login();
			action.selectWorkSpace();
		    action.backStageDistribution();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyUploadVideoWithSetNowCheckBox() throws Exception {
		try{
			action.creatorsLogin();
			action.uploadVideo();
			action.publishVideoNowCheckBox();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyUploadVideoWithSetDateAndTimeCheckBox() throws Exception {
		try{
			action.uploadVideo();
			action.publishVideoWithTimeSetCheckBox();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyCreatorsEmbedCodeButton() throws Exception {
		try{
			action.verifyEmbedCodeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyCreatorsAffiliateLinkButton() throws Exception {
		try{
			action.verifyAffiliateLinkButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void verifyCreatorsManageImagesButton() throws Exception {
		try{
			action.verifyManageImagesButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyCreatorsTestCases() throws Exception {
		try{
			verifyUploadVideoWithSetNowCheckBox();
			verifyCreatorsEmbedCodeButton();
			verifyCreatorsAffiliateLinkButton();
			verifyCreatorsManageImagesButton();
			verifyUploadVideoWithSetDateAndTimeCheckBox();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void creatorRegistration() throws Exception {
		try {
			action.verifyCreatorRegistration();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
