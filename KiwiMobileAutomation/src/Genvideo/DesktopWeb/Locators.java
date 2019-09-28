package Genvideo.DesktopWeb;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	private WebDriver driver;

	public static Locators getInstance() {
		Locators mHeader = null;
		try {
			mHeader = new Locators();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mHeader;
	}

	public WebElement loginEmail(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='username']"));
		return element;
	}

	public WebElement loginPassword(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='password']"));
		return element;
	}

	public WebElement loginButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@value='Login']"));
		return element;
	}

	public WebElement backStageHeaderCaret(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//i[@class='fa fa-caret-down fa-2x ml-10']"));
		return element;
	}

	public WebElement backStageHomeWSLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='Workspace']"));
		return element;
	}

	public WebElement workSpaceConglomorate(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//div[@selected-model='congo']/select"));
		return element;
	}

	public WebElement workSpaceBrand(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//div[@selected-model='brand']/select"));
		return element;
	}

	public WebElement workSpaceGroup(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//div[@selected-model='group']/select"));
		return element;
	}

	public WebElement workSpaceGoButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[@ng-click='login()']"));
		return element;
	}

	public WebElement campaignLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='CAMPAIGNS']"));
		return element;
	}

	public WebElement contentLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='CONTENT']"));
		return element;
	}

	public WebElement distributionLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='DISTRIBUTION']"));
		return element;
	}

	public void waitForDistributionLink(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[text()='DISTRIBUTION']")));
	}
	
	public WebElement imageLoader(WebDriver driver) {
		return driver.findElement(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x"));
	}
	
	public void waitImageLoaderToBeInvisible(WebDriver driver, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fa.fa-spinner.fa-spin.fa-5x")));
	}

	public WebElement newCampaignLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(text(),'Create New Campaign')]"));
		return element;
	}

	public WebElement campaignTitle(WebDriver driver) {
		WebElement element = driver.findElement(By.id("outreachTitle"));
		return element;
	}

	public WebElement dueDate(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//div[@class='input-group']/input"));
		return element;
	}

	public WebElement campaignDesc(WebDriver driver) {
		WebElement element = driver.findElement(By.id("offerDescription"));
		return element;
	}

	public WebElement campaignImage(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@type='file']"));
		return element;
	}

//	public WebElement campaignContinueButton(WebDriver driver) {
//		WebElement element = driver.findElement(By
//				.xpath("//button[contains(text(),'Continue')]"));
//		return element;
//	}
	
	public WebElement campaignNextBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
	}

	public WebElement imageRemoveFile(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[@class='removeFile small details']"));
		return element;
	}

	public WebElement imageUploadPixelError(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("(//span[@class='alert alert-danger'])[2]"));
		return element;
	}

	public WebElement campaignMinBudget(WebDriver driver) {
		WebElement element = driver.findElement(By.id("budgetMin"));
		return element;
	}

	public WebElement campaignMaxBudget(WebDriver driver) {
		WebElement element = driver.findElement(By.id("budgetMax"));
		return element;
	}

	public WebElement campaignBudgetError(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//span[@class='alert alert-danger']"));
		return element;
	}

	public WebElement campaignVideoCount(WebDriver driver) {
		WebElement element = driver.findElement(By.id("videoNum"));
		return element;
	}

	public WebElement campaignGenderMale(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@id='gender-male']/parent::label"));
		return element;
	}

	public WebElement campaignGenderFemale(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@id='gender-female']/parent::label"));
		return element;
	}

	public WebElement campaignTags(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@ng-model='tagsFound.term']"));
		return element;
	}

	public WebElement campaignTagResult(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//li[@class='tag ng-scope ng-binding']"));
		return element;
	}
	
	public WebElement CreatorTagResult(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//li[@class='tag ng-binding ng-scope']"));
		return element;
	}

	public WebElement campaignRemoveTag(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//i[@class='fa fa-times fa-15x']"));
		return element;
	}

	public WebElement campaignVideoType(WebDriver driver, int index) {
		WebElement element = driver.findElement(By
				.xpath("(//input[@name='videoType']/parent::label)[" + index
						+ "]"));
		return element;
	}

	public WebElement campaignAgeGroup(WebDriver driver, int ageGroup) {
		WebElement element = driver
				.findElement(By.xpath("//input[@id='age-" + ageGroup+ "']/parent::label"));//("//input[@id='age-group" + ageGroup+ "']/parent::label"));
		return element;
	}
	
	public WebElement unableCTAUrl(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='text-danger link']"));//("//span[text()='Add your own CTA URL']"));
	}

	public WebElement campaignCTAurl(WebDriver driver) {
		WebElement element = driver.findElement(By.id("cta"));
		return element;
	}

	public WebElement campaignCTAUrlError(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//span[@class='alert alert-danger']"));
		return element;
	}

	public WebElement unableCampaignTalkingPoint(WebDriver driver) {
		return driver.findElement(By.xpath("//h4[@class='panel-title']//span"));
	}
	
	public WebElement campaignTalkingPoints(WebDriver driver) {
		WebElement element = driver.findElement(By.id("talkingPoints"));
		return element;
	}

	public WebElement campaignKeywords(WebDriver driver) {
		WebElement element = driver.findElement(By.id("keywords"));
		return element;
	}

	public WebElement campaignProductsSwitch(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//div[@class='box-check switch']/label"));
		return element;
	}

	public WebElement campaignProductName(WebDriver driver) {
		WebElement element = driver.findElement(By.id("searchInput"));
		return element;
	}

	public WebElement campaignProductList(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//li[@class='ui-menu-item']"));
		return element;
	}

	public void waitForShortSpinner(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='spinner-container short ng-hide']")));
	}

	public void waitForImageSpinner(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='spinner-container']//div")));//("//div[@class='progress progress-top ng-hide']")));
	}

	public WebElement campaignWalmartDistributionList(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//h4[@class='ng-binding' and contains(text(),'Walmart')]//ancestor::label"));
		return element;
	}

	public List<WebElement> campaignGetAllDistributionList(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By
						.xpath("//label[@class='btn btn-default col1 extra-tall distribution partial ng-scope']"));
		return elements;
	}

	public WebElement campaignFinishButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//button[contains(text(),'Finish')]"));
		return element;
	}

	public WebElement generateSkipLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(text(),'Skip')]"));
		return element;
	}

//	public WebElement generateSelectCampaign(WebDriver driver,
//			String campaignTitle) {
//		WebElement element = driver.findElement(By.xpath("//h3[text()='"
//				+ campaignTitle + "']"));
//		return element;
//	}
	
	public WebElement generateSelectCampaign(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@class='mt-10 ng-binding']"));
	}
	
	public void waitForCampaignVisible(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='mt-10 ng-binding']")));
	}


	public List<WebElement> generateSelectSelectors(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.xpath("//label[@for='selectedCreator']"));
		return elements;
	}

	public WebElement generateInviteCreators(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(text(),'Invite Selected')]"));
		return element;
	}

	public WebElement generateReturnToCampaignManager(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(text(),'return to campaign')]"));
		return element;
	}

//	public WebElement generateCampaignGear(WebDriver driver,
//			String campaignTitle) {
//		WebElement element = driver.findElement(By.xpath("//h3[text()='"
//				+ campaignTitle + "']//ancestor::div[@class='row']//i"));
//		return element;
//	}
	
	public List<WebElement> generateCampaignGear(WebDriver driver) {
		return driver.findElements(By.xpath("//h3[@class='title mb-15 ng-binding']"));
	}

	public WebElement liveStatus(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='status live']>span"));
	}
	
	public WebElement generateSetOfferStatus(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//select[@name='offerStatus']"));
		return element;
	}

	public WebElement generateSetOutreachStatus(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//select[@name='outreachStatus']"));
		return element;
	}

	public WebElement generateSubmitButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class,'btn') and contains(text(),'Submit')]"));
		return element;
	}

	public WebElement addButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(@class,'nav-dropdown-button')]"));
		return element;
	}

	public WebElement uploadVideoLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'UPLOAD VIDEO')]"));
	}
	
	public WebElement videoLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[contains(text(),'Video')]"));
		return element;
	}

	public Select clientType(WebDriver driver) {
		Select select = new Select(driver.findElement(By
				.xpath("//*[@class='ng-scope ng-pristine ng-valid']/select")));
		select.selectByValue("0");
		return select;
	}

	public Select reelType(WebDriver driver) {
		Select select = new Select(driver.findElement(By
				.xpath("//*[@class='ng-scope ng-pristine ng-valid']/select")));
		select.selectByValue("1");
		return select;
	}

	public WebElement videoUpload(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//input[@type='file'])[1]"));//("(//button[@name='video_file'])[1]/input"));
		return element;
	}

	public WebElement titleTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("title"));
		return element;
	}

	public WebElement descriptionTextArea(WebDriver driver) {
		WebElement element = driver.findElement(By.id("description"));
		return element;
	}

	public WebElement keywordsTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#tags>div>input"));
		return element;
	}

	public void waitForBackVideoUpload(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".fileName.text-center.ng-binding")));
	}

	public void waitForKeywordsValue(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".tag.ng-scope.ng-binding")));
	}

	public void waitForPlayAndPause(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#expoPlayermediaPlayer_expo_display_button_play")));
	}

	public WebElement productTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#searchInput"));
		return element;
	}

	public WebElement productValue(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[starts-with(@id,'ui-id-')]"));
		return element;
	}

	public void waitForProductValue(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[starts-with(@id,'ui-id-')]")));
	}

	public WebElement doneButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[contains(@class,'btn btn-lg btn-primary')]"));
		return element;
	}

	public WebElement videoTitleText(WebDriver driver, String videotitle) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class,'title ng-binding') and contains(text(), '"
								+ videotitle + "')]"));
		return element;
	}

	public WebElement approvalMessage(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".status-message.ng-binding.approved"));
		return element;
	}

	public void waitForApprovalMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".status-message.ng-binding.approved")));
	}
	
	public WebElement ReelOrClientText(WebDriver driver, String reelOrclientName) {
		return driver.findElement(By.xpath("//h2[contains(text(),'"+reelOrclientName+"')]"));
	}

	public void waitForFinalApprovalButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".btn.btn-lg.btn-primary.btn-set-height.ng-scope")));
	}

	public WebElement finalApprovalButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".btn.btn-lg.btn-primary.btn-set-height.ng-scope"));
		return element;
	}

	public boolean publishButtonDisabled(WebDriver driver) {
		boolean check = driver.findElement(
				By.cssSelector(".col-md-6.p-0>button")).isEnabled();
		return check;
	}

	public WebElement manageImages(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//a[@data-target='#videoThumbModal']"));//(By.cssSelector(".mlr-15.manage-thumbnail>span"));
		return element;
	}

	public WebElement chooseFileButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".file.btn-primary-light.btn-sm.mtb-7p.ng-pristine.ng-valid>input"));
		return element;
	}

	public WebElement uploadButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn-primary.btn-md.add.uploadBtnTop"));
		return element;
	}

	public String uploadSuccessMessage(WebDriver driver) {
		String sucessMessage = driver.findElement(
				By.cssSelector(".message.alert.ng-binding.alert-info"))
				.getText();
		return sucessMessage;
	}

	public void waitForUploadSucessMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".message.alert.ng-binding.alert-info")));
	}

	public WebElement manageImagesCloseButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#videoThumbModal .close"));
		return element;
	}

	public WebElement downloadVideo(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector(".linkContainer>button"));
		return element;
	}

	public WebElement downloadVideo360Resolution(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".popover-content>ul>li:nth-of-type(1)>a"));
		return element;
	}

	public WebElement showMoreImagesButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".img.thumb.show-more.text-center"));
		return element;
	}

	public int showMoreImagesValues(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".img.thumb.encoded"));
		int count = elements.size();
		return count;
	}

	public void waitForshowMoreImagesValues(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.cssSelector(".img.thumb.encoded")));
	}

	public WebElement newURL(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".lead.text-center.alert.alert-info.ng-binding>a:nth-of-type(2)"));
		return element;
	}

	public void WaitForNewURL(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".lead.text-center.alert.alert-info>p:nth-of-type(3)>a:nth-of-type(1)")));
	}

	public WebElement expirationDateTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#expiration_date"));
		return element;
	}

	public String firstVideoTitle(WebDriver driver) {
		String first = driver.findElement(
				By.cssSelector(".eachCol:nth-of-type(1) .title.ng-binding"))
				.getText();
		return first;
	}

	public WebElement whatNowButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>button"));
		return element;
	}

	public void WaitForWhatNowButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>button")));
	}

	public WebElement emailToAFriend(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>ul>li:nth-of-type(2)"));
		return element;
	}

	public void WaitForEmailToAFriend(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>ul>li:nth-of-type(2)")));
	}

	public WebElement addToAList(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>ul>li:nth-of-type(3)"));
		return element;
	}

	public void WaitForAddToAList(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.cssSelector(".eachCol:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div>ul>li:nth-of-type(3)")));
	}

	public WebElement emailAddress(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#email"));
		return element;
	}

	public WebElement sendButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#myModal .btn.btn-primary"));
		return element;
	}

	public Select chooseQAList(WebDriver driver) {
		Select select = new Select(driver.findElement(By.name("list")));
		select.selectByVisibleText("Mayank Test 123434567");
		return select;
	}

	public WebElement chooseQAListName(WebDriver driver) {
		WebElement element = chooseQAList(driver).getFirstSelectedOption();
		return element;
	}

	public WebElement saveButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector("#myModal>div>div>form:nth-of-type(1)>div:nth-of-type(2)>button:nth-of-type(1)"));
		return element;
	}

	public WebElement listsTab(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class,'subNavLink') and contains(text(),'Lists')]"));
		return element;
	}

	public WebElement listsTitle(WebDriver driver, String qaTitle) {
		WebElement element = driver
				.findElement(By
						.xpath("//div[contains(@class, 'title pull-left ng-binding') and contains(text(), '"
								+ qaTitle + "')]"));
		return element;
	}

	public void waitForListsTitle(WebDriver driver, String qaTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//div[contains(@class, 'title pull-left ng-binding') and contains(text(), '"
						+ qaTitle + "')]")));
	}

	public WebElement listsVideoTitle(WebDriver driver, String videoTitle) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class, 'title ng-binding') and contains(text(), '"
								+ videoTitle + "')]"));
		return element;
	}

	public void waitForListsVideoTitle(WebDriver driver, String videoTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//a[contains(@class, 'title ng-binding') and contains(text(), '"
						+ videoTitle + "')]")));
	}

	public WebElement youtubePublishing(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='YouTube Publishing']"));
		return element;
	}

	public void waitForYoutubePublishing(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[text()='YouTube Publishing']")));
	}

	public WebElement connectToYoutube(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//button[text()='Connect to YouTube']"));
		return element;
	}

	public void waitForConnectToYoutube(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//button[text()='Connect to YouTube']")));
	}

	public WebElement manageChannels(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-secondary.pull-right"));
		return element;
	}

	public WebElement addChannel(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-primary.pull-right"));
		return element;
	}

	public WebElement addAccount(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#account-chooser-add-account"));
		return element;
	}

	public WebElement gmailEmailAddress(WebDriver driver) {
		WebElement element = driver.findElement(By.id("identifierId"));//driver.findElement(By.cssSelector("#Email"));//
		return element;
	}

	public WebElement gmailNext(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//span[text()='Next']"));//driver.findElement(By.cssSelector("#next"));//
		return element;
	}

	public WebElement gmailPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@type='password']"));//driver.findElement(By.cssSelector("#Passwd"));//
		return element;
	}

	public WebElement signIn(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#signIn"));
		return element;
	}

	public WebElement allow(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#submit_approve_access"));//(By.xpath("//span[text()='ALLOW']"));//
		return element;
	}

	public WebElement selectCheckBox(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".pull-left>input"));
		int count = elements.size();
		Random r = new Random();
		int low = 1;
		int high = count;
		int result = r.nextInt(high - low) + low;
		WebElement element = driver.findElement(By
				.cssSelector(".list-item:nth-of-type(" + result
						+ ") .pull-left>input"));
		return element;
	}

	public void waitForSelectCheckBox(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".list-item:nth-of-type(1) .pull-left>input")));
	}

	public WebElement scheduleVideos(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[text()='Schedule Videos']"));
		return element;
	}

	public WebElement select(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".eachCol .btn.btn-primary-light.mtb-10"));
		int count = elements.size();
		Random r = new Random();
		int low = 1;
		int high = count;
		int result = r.nextInt(high - low) + low;
		WebElement element = driver.findElement(By
				.cssSelector(".eachCol:nth-of-type(" + result
						+ ") .btn.btn-primary-light.mtb-10"));
		return element;
	}

	public WebElement chooseContentNext(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".step:nth-of-type(1)>div>div>div>nav>button:nth-of-type(2)"));
		return element;
	}

	public void waitForChooseContentNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".eachCol:nth-of-type(1) .btn.btn-primary-light.mtb-10")));
	}

	public WebElement optimizeMetadataNext(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".step:nth-of-type(2)>div>div>div>nav>button:nth-of-type(2)"));
		return element;
	}

	public void waitForOptimizeMetadataNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".h5.uppercase")));
	}

	public WebElement setDestinationtNext(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".step:nth-of-type(3)>div>div>div>nav>button:nth-of-type(2)"));
		return element;
	}

	public void waitForSetDestinationtNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#channel")));
	}

	public WebElement mondayCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope.ng-binding:nth-of-type(2)>input"));
		return element;
	}

	public WebElement tuesdayCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope.ng-binding:nth-of-type(3)>input"));
		return element;
	}

	public WebElement wednesdayCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope.ng-binding:nth-of-type(4)>input"));
		return element;
	}

	public WebElement thursdayCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope.ng-binding:nth-of-type(5)>input"));
		return element;
	}

	public WebElement fridayCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope.ng-binding:nth-of-type(6)>input"));
		return element;
	}

	public WebElement startDate(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".col-md-6:nth-of-type(1)>input[type=\"date\"]"));
		return element;
	}

	public WebElement endDate(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".col-md-6:nth-of-type(2)>input[type=\"date\"]"));
		return element;
	}

	public WebElement time(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".col-md-6:nth-of-type(1)>input[type=\"time\"]"));
		return element;
	}

	public WebElement creatorsEmailTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.name("username"));
		return element;
	}

	public WebElement createAScheduleNext(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".step:nth-of-type(4)>div>div>div>nav>button:nth-of-type(2)"));
		return element;
	}

	public void waitForCreateAScheduleNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".col-md-6:nth-of-type(1)>input[type=\"date\"]")));
	}

	public WebElement reviewFinish(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".step:nth-of-type(5)>div>div>div>nav>button:nth-of-type(2)"));
		return element;
	}

	public void waitForReviewFinish(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".col-md-6.ng-binding>img")));
	}

	public WebElement successMessage(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".step:nth-of-type(5)>div>div>div>nav>span"));
		return element;
	}

	public void waitForGrid(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".table.table-striped.mb-0>thead>tr>th:nth-of-type(1)")));
	}

	public WebElement creatorsPasswordTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.name("password"));
		return element;
	}

	public WebElement creatorsLoginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector(".btn.btn-blue.btn-lg.signin"));//(".btn.btn-primary.btn-lg.signin"));
		return element;
	}

	public WebElement creatorsOffersTab(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class,'navOpt navOpt-youtube') and contains(text(),'Offers')]"));
		return element;
	}

	public WebElement creatorsEmbedCodeButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(3)>span>a:nth-of-type(1)"));
						//.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(4)>a:nth-of-type(3)"));
		return element;
	}

	public void waitForEmbedCodeButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(3)>span>a:nth-of-type(1)")));
				//.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(4)>a:nth-of-type(3)")));
	}

	public WebElement creatorsCloseEmbedCodePopUp(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#sharingOptionsModal .close"));
		return element;
	}

	public WebElement creatorsAffiliateLinkButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(3)>span>a:nth-of-type(2)"));//("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(4)>a:nth-of-type(4)"));
		return element;
	}

	public void waitForAffiliateLinkButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(3)>span>a:nth-of-type(2)")));//("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(4)>a:nth-of-type(4)")));
	}

	public String creatorsEmbedCodeCopiedText(WebDriver driver) {
		String codeCopiedText = driver
				.findElement(
						By.xpath("//p[(@class='mtb-10') and contains(text(),'Code copied!')]"))
				.getText();
		return codeCopiedText;
	}

	public WebElement closeAffiliateLinksPopUp(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#affiliateLinksModal .close"));
		return element;
	}

	public String creatorsAffiliateLinkCopiedText(WebDriver driver) {
		String linkCopiedText = driver
				.findElement(
						By.cssSelector("#affiliateLinksModal>div>div>div:nth-of-type(3)>p"))
				.getText();
		return linkCopiedText;
	}

	public WebElement creatorsOffersCampaignTitle(WebDriver driver, String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h5[contains(@class,'camp-name ng-binding') and contains(text(), '+"
								+ title + "+')]"));
		return element;
	}

	public WebElement creatorsOffersApplyButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-lg.btn-danger.btn-50"));
		return element;
	}

	public WebElement creatorsOffersApplyButtonPopUp(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector("#wrap>div>div>div:nth-of-type(3) .btn.btn-lg.btn-danger"));
		return element;
	}

	public WebElement creatorsDashBoardCampaignTitle(WebDriver driver,
			String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h4[contains(@class,'media-heading ng-binding') and contains(text(), '+"
								+ title + "+')]"));
		return element;
	}

	public String creatorsManageImagesSuccessMessage(WebDriver driver) {
		String sucessMessage = driver.findElement(
				By.cssSelector(".message.alert.ng-binding.alert-info"))
				.getText();
		return sucessMessage;
	}

	public String creatorsPublishVideoSuccessMessage(WebDriver driver) {
		String sucessMessage = driver.findElement(
				By.cssSelector(".alert-message")).getText();
		return sucessMessage;
	}

	public void waitForPublishVideoSuccessMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".alert-message")));
	}

	public WebElement creatorsOffersAppliedText(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".row>div:nth-of-type(2)>h2"));
		return element;
	}

	public WebElement creatorsVideosTab(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".navOpt.navOpt-youtube[href=\"https://creators-stg.gen.video/membervideos\"]"));
		return element;
	}

	public WebElement creatorsDashBoardTab(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".navOpt.navOpt-dashboard"));
		return element;
	}

	public List<WebElement> creatorsDashBoardCampaignTextMatch(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By
						.cssSelector("#dashboard-campaigns>a .media>div:nth-of-type(2)>h4"));
		return elements;
	}

	public List<WebElement> creatorsDashBoardVideoDueText(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By
						.cssSelector("#dashboard-campaigns>a>div>div:nth-of-type(2)>span>span:nth-of-type(1)"));
		return elements;
	}

	public WebElement creatorsUploadButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".upload.btn.btn-primary.btn-lg"));
		return element;
	}

	public WebElement chooseRoseGoldLightningForCampaign(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Rose Gold Lightning Cables by LAX Gadgets')]"));
	}
	
	public WebElement chooseNotUploadingForCampaign(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'I am not uploading for a Campaign')]"));
	}
	
	public void waitForUploadButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".upload.btn.btn-primary.btn-lg")));
	}

	public WebElement creatorsUploadVideoButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector("#campaign>div:nth-of-type(1)>div:nth-of-type(2)>a:nth-of-type(1)"));
		return element;
	}

	public WebElement creatorsVideoButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("(//button[@name='video_file'])[1]/input"));
		return element;
	}

	public void waitForVideoUpload(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".fa.fa-check.fa-4x")));
	}

	public void waitForThumbnailUpload(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".img-details .removeFile.small.details")));
	}

	public void waitForCreatorsManageImagesSucessMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".message.alert.ng-binding.alert-info")));
	}

	public WebElement creatorsTitleTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#title"));
		return element;
	}

	public boolean creatorsStatusDisabled(WebDriver driver) {
		boolean statusDisabled = driver.findElement(
				By.cssSelector(".form-group>select")).isEnabled();
		return statusDisabled;
	}

	public WebElement creatorsProductTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#products"));
		return element;
	}

	public WebElement creatorsManageImagesCloseButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector("#videoThumbModal .close"));
		return element;
	}

	public WebElement creatorsProductItem(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//a[starts-with(@id,'ui-id-')]"));
		return element;
	}

	public WebElement creatorsThumbNailButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("(//button[@name='innerImage'])[1]/input"));
		return element;
	}

	public WebElement creatorsDescriptionTextArea(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector("#description"));
		return element;
	}

	public WebElement creatorsFinishButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-lg.btn-blue[value='FINISH']"));
		return element;
	}

	public WebElement creatorsPublishButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//button[contains(text(),'Publish')]"));
		return element;
	}

	public WebElement creatorsVideoSuccessMessage(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//*[@id='alerts-container']/span[2]"));
		return element;
	}

	public WebElement creatorsSetDateTimeCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".ng-scope>div:nth-of-type(3)>label>input"));
		return element;
	}

	public WebElement creatorsTimeTextBox(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".ng-scope>div:nth-of-type(3)>input:nth-of-type(2)"));
		return element;
	}

	public WebElement creatorsPublishToYouTubeButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".ng-scope>div:nth-of-type(4)>div:nth-of-type(2)>:nth-of-type(4)>a:nth-of-type(1)"));
		return element;
	}

	public WebElement creatorsProductRating(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".stars>label:nth-of-type(1)"));
		return element;
	}

	public WebElement creatorsManageImagesButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>button"));
		return element;
	}

	public void waitForManageButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>button")));
	}

	public WebElement creatorsManageImagesCameraButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-sm.btn-primary:nth-of-type(2)"));
		return element;
	}

	public WebElement creatorsManageImagesChooseFileButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@type='file']"));
		return element;
	}

	public WebElement creatorsManageImagesUploadButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".btn.btn-primary.btn-md.add.uploadBtnTop"));
		return element;
	}

	public WebElement creatorsManageImagesShowMoreImages(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".img.thumb.show-more.text-center"));
		return element;
	}

	public WebElement applyNowButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".GI_TW_expander-inner a[id^='camp']"));
		return element;
	}

	public WebElement backstageCampaignTab(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".navOpt.navOpt-generate"));
		return element;
	}

	public WebElement backstageCampaignTitle(WebDriver driver, String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h3[text()='+"
								+ title
								+ "+')]/ancestor::div[@class='row']//div[@class='status live']//span"));
		return element;
	}

	public WebElement backstageCampaignStatus(WebDriver driver, String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h3[text()='+"
								+ title
								+ "+')]/ancestor::div[@class='row']//div[@class='status live']//span"));
		return element;
	}

	public WebElement backstageCampaignGearBox(WebDriver driver, String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h3[text()='+"
								+ title
								+ "+']/ancestor::div[@class='row']//div[@class='pull-right admin-btn']"));
		return element;
	}

	public WebElement backstageCampaignCreatorsApplied(WebDriver driver,
			String title) {
		WebElement element = driver
				.findElement(By
						.xpath("//h3[text()='+"
								+ title
								+ "+']/ancestor::div[@class='row']//div[@class='user pull-left mr-10 mtb-10 ng-scope']"));
		return element;
	}

	public WebElement backstageCalenderTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".input-group>input"));
		return element;
	}

	public WebElement backstageCalenderSubmitButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//button[contains(@class,'btn btn-primary') and contains(text(),'Submit')]"));
		return element;
	}

	public Select backstageNewOfferStatus(WebDriver driver) {
		Select select = new Select(driver.findElement(By.name("offerStatus")));
		select.selectByVisibleText("Ended");
		return select;
	}

	public void waitForGearSpinner(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='selected-container.ptb-10.plr-10']")));
	}

	public Select backstageNewOutreachStatus(WebDriver driver) {
		Select select = new Select(
				driver.findElement(By.name("outreachStatus")));
		select.selectByVisibleText("Completed");
		return select;
	}

	public WebElement backstageModerateDropDownButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".btn.btn-lg.btn-primary.dropdown-toggle.btn-set-height"));
		return element;
	}

	public WebElement backstageModerateReject(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".dropdown-menu.primary-light.text-center>li:nth-of-type(3)>a"));
		return element;
	}

	public WebElement backstageModerateApproveForYoutube(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".dropdown-menu.primary-light.text-center>li:nth-of-type(1)>a"));
		return element;
	}

	public void waitForFinalApprovalButtons(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".ng-isolate-scope>div>div>button:nth-of-type(1)")));
	}

	public WebElement backstageFinalApprovalButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.cssSelector(".ng-isolate-scope>div>div>button:nth-of-type(1)"));
		return element;
	}

	public WebElement backstageRegistrationLink(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".text-center.mt-20>a:nth-of-type(2)"));
		return element;
	}

	public WebElement backstageAcceptButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//button[contains(@class,'btn btn-lg btn-primary ng-scope') and contains(text(),'Accept')]"));
		return element;
	}

	public WebElement backstageConfirmButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By
						.xpath("//a[contains(@class,'btn btn-lg btn-primary ng-scope') and contains(text(),' Confirm')]"));
		return element;
	}

	public WebElement backstageRegistrationFirstName(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='first_name']"));
		return element;
	}

	public WebElement backstageRegistrationLastName(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='last_name']"));
		return element;
	}

	public WebElement backstageRegistrationCompanyName(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='company_name']"));
		return element;
	}

	public WebElement backstageRegistrationEmail(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='email']"));
		return element;
	}

	public WebElement backstageRegistrationPassword(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='password']"));
		return element;
	}

	public WebElement backstageRegistrationConfirmPassword(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@name='password_confirmation']"));
		return element;
	}

	public WebElement backstageRegistrationCaptcha(WebDriver driver) {
		WebElement element = driver.findElement(By
				.cssSelector(".recaptcha-checkbox-checkmark"));
		return element;
	}

	public WebElement backstageRegistrationSubmitButton(WebDriver driver) {
		WebElement element = driver.findElement(By
				.xpath("//input[@type='submit']"));
		return element;
	}

	public void waitForCreatorsProductItem(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[starts-with(@id,'ui-id-')]")));
	}

	public List<WebElement> getAllCampaignSocialChannel(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.xpath("//label[@class='btn btn-default field-25 ng-scope']"));
		return elements;
	}
	
	//>>>>>>>>>>>>>>>>>>>>. Creators Registration >>>>>>>>>>>
		public WebElement verifyRegistrationPage(WebDriver driver) {
			return driver.findElement(By.xpath("//strong[text()='Registration']"));
		}
		
		public WebElement verifyGetStartedStatus(WebDriver driver) {
			return driver.findElement(By.id("step1"));
		}
		
		public WebElement verifySocialConnectionStatus(WebDriver driver) {
			return driver.findElement(By.id("step2"));
		}
		
		public WebElement verifyProfileInformationStatus(WebDriver driver) {
			return driver.findElement(By.id("step3"));
		}
		
		public WebElement verifyAudienceAndTargetingStatus(WebDriver driver) {
			return driver.findElement(By.id("step4"));
		}
		
		public WebElement verifySocialConnectionsStatus(WebDriver driver) {
			return driver.findElement(By.id("step5"));
		}
		
		public WebElement enterCreatorFirstName(WebDriver driver) {
			return driver.findElement(By.id("first_name"));
		}
		
		public WebElement enterCreatorLastName(WebDriver driver) {
			return driver.findElement(By.id("last_name"));
		}
		
		
		public WebElement enterCreatorEmailAddress(WebDriver driver) {
			return driver.findElement(By.id("email"));
		}
		
		
		public WebElement enterCreatorPassword(WebDriver driver) {
			return driver.findElement(By.id("password"));
		}
		
		
		public WebElement enterCreatorConfirmPassword(WebDriver driver) {
			return driver.findElement(By.id("password_confirmation"));
		}
		
		public WebElement getStartedContinueButton(WebDriver driver) {
			return driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		}
		
		// Social connection
		public WebElement connectYouTube(WebDriver driver) {
			return driver.findElement(By.xpath("//a[text()='Connect YouTube']"));
		}
		
		public WebElement verifyGmailAccountAddedToTheYoutube(WebDriver driver, String userName) {
			return driver.findElement(By.xpath("//strong[text()='"+userName+"']"));
		}
		
		public WebElement CreatorGenderMale(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@value='M']/parent::label"));
		}
		
		public WebElement CreatorGenderFemale(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@value='F']/parent::label"));
		}
		
		public WebElement creatorDate(WebDriver driver) {
			return driver.findElement(By.id("exampleInput"));
		}
		
		public WebElement clickOnEnableHouseHoldIncomeList(WebDriver driver) {
			return driver.findElement(By.xpath("(//button[@id='dropdownMenu1'])[1]"));
		}
		
		public List<WebElement> selectHouseHoldIncome(WebDriver driver) {
			return driver.findElements(By.xpath("(//ul[@class='dropdown-menu wide'])[1]//li//a"));
		}
		
		public WebElement clickOnEnableEthnicityList(WebDriver driver) {
			return driver.findElement(By.xpath("(//button[@id='dropdownMenu1'])[2]"));
		}
		
		public List<WebElement> selectEthnicity(WebDriver driver) {
			return driver.findElements(By.xpath("(//ul[@class='dropdown-menu wide'])[2]//li//a"));
		}
		
		public WebElement enterShippingAddress1(WebDriver driver) {
			return driver.findElement(By.id("address"));
		}
		
		public WebElement enterShippingAddress2(WebDriver driver) {
			return driver.findElement(By.id("address2"));
		}
		
		public WebElement enterShippingCity(WebDriver driver) {
			return driver.findElement(By.id("city"));
		}


		public WebElement selectCreatorCountry(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@name='country']"));
		}
		
		public WebElement selectCreatorState(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@name='state']"));
		}
		
		public WebElement selectCreatorStateCode(WebDriver driver) {
			return driver.findElement(By.id("zip"));
		}
		
		//>>>>>>>>>>>. Audience & Targeting 
		public WebElement videoOnlyRate(WebDriver driver) {
			return driver.findElement(By.cssSelector("input[name='videoRate']"));//(By.id("video_only_rate"));
		}
		
		public WebElement youTubeRate(WebDriver driver) {
			return driver.findElement(By.cssSelector("input[name='videoPromoRate']"));//(By.id("youtube_rate"));
		}
		
		// >>>>>>>>>>>>> Social Connections 
		public WebElement socialConnectionsOptions(WebDriver driver) {
			return driver.findElement(By.xpath(".btn.btn-lg.btn-primary-light.ng-scope"));
		}
		
		public WebElement enterFBName(WebDriver driver) {
			return driver.findElement(By.id("email"));
		}
		
		public WebElement enterFBPass(WebDriver driver) {
			return driver.findElement(By.id("pass"));
		}
		
		public WebElement submitFB(WebDriver driver) {
			return driver.findElement(By.id("loginbutton"));
		}
		
		public WebElement clickOnFinishButton(WebDriver driver) {
			return driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.ng-binding.ng-scope"));//".btn.btn-lg.btn-danger2.ng-binding.ng-scope"));
		}
		
		public WebElement verifyCreatorRegistrationDone(WebDriver driver) {
			return driver.findElement(By.xpath("//a[text()='Dashboard']"));
		}
		
}
