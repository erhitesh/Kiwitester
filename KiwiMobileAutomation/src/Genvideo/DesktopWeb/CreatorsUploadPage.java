package Genvideo.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class CreatorsUploadPage {
	
	private WebDriver driver;

	public CreatorsUploadPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickUploadButton() throws Exception {
		WebElement element = null;
		try {
			Locators.getInstance().waitForUploadButton(driver);
			element = Locators.getInstance().creatorsUploadButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Upload Button</b> clicked successfully", "PASS",
						"<b>Creators Upload Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Upload Button</b>", "FAIL",
						"<b>Creators DashBoard Tab</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Upload </b> button", "FAIL",
					"<b>Creators DashBoard Tab</b> button should be clicked");
			throw e;
		}
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>> choose campaign >>>>>>>>>.
		public String chooseCampaign() {
			String chooseCam = "";
			WebElement element;
			try {
				Keywords.waitForPage(driver);
				element = Locators.getInstance().chooseNotUploadingForCampaign(driver);
				if (Keywords.isElementPresent(element))
					Keywords.click(element);

				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>I am not uploading for a campaign</b> select successfully", "PASS",
							"<b>I am not uploading for a campaign</b> should be selected");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>I am not uploading for a campaign</b> not select successfully", "FAIL",
							"<b>I am not uploading for a campaign</b> should be selected");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Exception occurred while clicking on the <b>I am not uploading for a campaign</b>", "FAIL",
						"<b>I am not uploading for a campaign</b> should be selected");
			}

			return chooseCam;
		}
	
	public void uploadVideoFile() throws Exception {
		RemoteWebElement element = null;
		String videoName = "SampleVideo.mp4";
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().creatorsVideoButton(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "GenvideoFiles" + GlobalParam.slash + videoName;
			 element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(2000L);
			Locators.getInstance().waitForVideoUpload(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Video Select File</b> clicked successfully", "PASS",
						"<b>Creators Video Select File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Video Select File</b>", "FAIL",
						"<b>Creators Video Select File</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Video Select File</b> button", "FAIL",
					"<b>Creators Video Select File</b> button should be clicked");
			throw e;
		}
	}
	
	
	public void uploadThumbNailFile() throws Exception {
		RemoteWebElement element = null;
		String fileName = "test.jpg";
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().creatorsThumbNailButton(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "GenvideoFiles" + GlobalParam.slash + fileName;
			 element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(2000L);
			Locators.getInstance().waitForThumbnailUpload(driver);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators ThumbNail Select File</b> clicked successfully", "PASS",
						"<b>Creators ThumbNail Select File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators ThumbNail Select File</b>", "FAIL",
						"<b>Creators ThumbNail Select File</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators ThumbNail Select File</b> button", "FAIL",
					"<b>Creators ThumbNail Select File</b> button should be clicked");
			throw e;
		}
	}
	
	public String enterVideoDescription() {
		WebElement element = null;
		String videoDesc = null;
		try {
			element = Locators.getInstance().creatorsDescriptionTextArea(driver);
			videoDesc = "Test  Sample Video on Creators";
			Keywords.typeText(element, videoDesc);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Video Description : <b>" + videoDesc + "</b> typed successfully", "PASS",
						"Video description should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type description",
						"FAIL", "Video description should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Video description", "FAIL",
					"Video description should be entered");
		}
		return videoDesc;
	}
	
	public  boolean verifyProductAppear() throws Exception {
		boolean check = false;
		try {
			  if(Locators.getInstance().creatorsProductItem(driver) != null)
			  {
				  check=true;
			  }
			  else
			  {
				  check = false;
			  } 
         } catch (Exception e) {
	         e.printStackTrace(); 
            }
		return check;
	  }
	
	public String enterProduct() throws Exception {
		WebElement element = null;
		String product = "mit";
		try {
			 element = Locators.getInstance().creatorsProductTextBox(driver);
			 Keywords.typeText(element, product);
			for(int i=1 ; i<=6; i++ )
			{
				 boolean check = verifyProductAppear();
			  if(check != true)
			   {
				  element = Locators.getInstance().creatorsProductTextBox(driver);
				  Keywords.typeText(element, product);
				  Thread.sleep(2000L);
			   }
			  else
			  {
				  Locators.getInstance().waitForCreatorsProductItem(driver);
			      element = Locators.getInstance().creatorsProductItem(driver);
			      Keywords.click(element);
			      break;
			  }
			}
			Thread.sleep(2000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Product : <b>" + product + "</b> typed successfully", "PASS",
						"Product should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type Product",
						"FAIL", "Product should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while typing Product", "FAIL",
					"Product should be entered");
			throw e;
		}
		return product;
	}
	
	
	public void clickProductRating() {
		WebElement element = null;
		try {
			element = Locators.getInstance().creatorsProductRating(driver);
			Keywords.click(element);
			Thread.sleep(1000L);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Product Rating</b> clicked successfully", "PASS",
						"<b>Creators Product Rating File</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators Product Rating</b>", "FAIL",
						"<b>Creators Product Rating</b> button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Product Rating</b> button", "FAIL",
					"<b>Creators Product Rating</b> button should be clicked");
		}
	}
	
	public void clickFinishButton() throws Exception{
		WebElement element = null;
		try {  
			element = Locators.getInstance().creatorsFinishButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Creators Finish Button</b> clicked successfully", "PASS",
						"<b>Creators Finish Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click <b>Creators  Finish Button</b>", "FAIL",
						"<b>Creators Finish Button</b> button should be clicked");
		}catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking <b>Creators Finish Button</b> button", "FAIL",
					"<b>Creators Finish Button</b> button should be clicked");
			throw e;
		}
	}
	
	
	public void uploadVideo() throws Exception {
		try {
			clickUploadButton();
			uploadVideoFile();
			uploadThumbNailFile();
			enterVideoDescription();
			enterProduct();
			clickProductRating();
			clickFinishButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured....while Uploading Video", "FAIL", "Video should be Uploaded");
			throw e;
		}
	}
	

}
