package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class Profile {

	private WebDriver driver;

	public Profile(WebDriver driver) {
		this.driver = driver;
	}

	public void enableProfileHideContent() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getProfileType(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hide profile content click successfully", "PASS", "Hide profile content should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hide profile content not click successfully", "FAIL", "Hide profile content should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on the Hide profile content", "FAIL",
					"Hide profile content should be click");
		}
	}

	public void clickOnLogoutButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().logoutButton(driver);
			if (!Keywords.isElementPresent(element)) {
				enableProfileHideContent();
				Thread.sleep(1000);
			}
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Logout button click successfully",
						"PASS", "Logout button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Logout button not click successfully", "FAIL", "Logout button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on the Logout button", "FAIL", "Logout button should be click");
		}
	}

	public void verifyProfileHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileHeader(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>My Profile text verify successfully</b>", "PASS",
						"<b>My Profile text Should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>My Profile text not verify successfully</b>", "FAIL",
					"<b>My Profile text Should be present</b>");
		}
	}

	public void verifyProfileEditPageHeaderText() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileEditHeader(driver);
			if (Keywords.getText(element).contains("Edit"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Edit text verify successfully</b>", "PASS",
						"<b>Profile Edit text Should be present</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Profile Edit text not verify successfully</b>", "FAIL",
					"<b>Profile Edit text Should be present</b>");
		}
	}

	public String getProfileType() {
		WebElement element;
		String profile = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getProfileType(driver);
			profile = Keywords.getText(element);
		} catch (Exception e) {
		}

		return profile;
	}

	public String selectMyProfile() {
		String profile = "";
		WebElement element;
		try {
			enableProfileHideContent();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileLinkedTxt(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("My Profile click successfully",
						"PASS", "My Profile should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("My Profile click successfully",
						"FAIL", "My Profile should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on the my profile", "FAIL", "My Profile should be click");
		}

		return profile;
	}

	public String selectProfileType(String profileType) {
		WebElement element;
		String currentUrl = "";
		String profile = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getProfileType(driver);
			Keywords.click(element);
			currentUrl = Keywords.getCurrentUrl(driver);
			if (!currentUrl.contains(profileType)) {
			}
		} catch (Exception e) {
		}

		return profile;
	}

	public List<String> getProfileUpdationList() {
		List<String> profileList = new ArrayList<String>();
		try {
			profileList.add("signup");
			profileList.add("aboutme");
			profileList.add("clearaboutme");
			// profileList.add("coverphoto");
			// profileList.add("removecoverphoto");
			profileList.add("follow");
			profileList.add("unfollow");
			profileList.add("addplants");
			profileList.add("deleteplants");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profileList;
	}

	public boolean profileLastNameStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().errorMessageForBlankProfileField(driver);
			if (Keywords.isElementPresent(element))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public void enterLastName() {
		WebElement element;
		String lastName = "test";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileLastName(driver);
			Keywords.typeText(element, lastName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Last name enter successfully",
						"PASS", "Last Name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Last name not enter successfully",
						"FAIL", "Last Name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Last name", "FAIL", "Last Name should be enter");
		}
	}

	public void enterAboutMe() {
		WebElement element;
		String aboutMeTxt = "plantsmap description!!!!";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().aboutMe(driver);
			Keywords.enterTextByJS(element, aboutMeTxt, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("About Me enter successfully",
						"PASS", "About Me should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("About Me not enter successfully",
						"FAIL", "About Me should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering About Me", "FAIL", "About Me should be enter");
		}
	}

	public void clearAboutMe() {
		WebElement element;
		String aboutMeTxt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().aboutMe(driver);
			Keywords.enterTextByJS(element, aboutMeTxt, "arguments[0].textContent= arguments[1];");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>About Me Clear</b> successfully", "PASS", "<b>About Me</b> should be clear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>About Me not clear</b> successfully", "FAIL", "<b>About Me</b> should be clear");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clearing About Me text box", "FAIL", "<b>About Me</b> should be clear");
		}
	}

	public void addProfileCover() {
		RemoteWebElement element;
		String imageName = "cover.jpg";
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().profileCoverPhoto(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			Thread.sleep(5000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Cover photo upload successfully", "PASS", "Profile Cover photo should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Cover photo not upload successfully", "FAIL", "Profile Cover photo should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading Profile Cover photo", "FAIL",
					"Profile Cover photo should be upload");
		}
	}

	public void removeProfileCover() {
		RemoteWebElement element;
		String imagePath = null;
		String imageName = "";
		try {
			element = (RemoteWebElement) Locators.getInstance().profileCoverPhoto(driver);
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "PlantsmapFiles" + GlobalParam.slash + imageName;
			element.setFileDetector(new LocalFileDetector());
			Keywords.clearEditField(element);
			Keywords.typeText(element, imagePath);
			Thread.sleep(5000);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Cover photo removed successfully", "PASS", "Profile Cover photo should be removed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Cover photo not removed successfully", "FAIL",
						"Profile Cover photo should be removed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while removing Profile Cover photo", "FAIL",
					"Profile Cover photo should be removed");
		}
	}

	public String addAddress() {
		WebElement element;
		String address = "Noida";
		Collections collection = new Collections(driver);
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addAddress(driver);
			Keywords.typeText(element, address);
			collection.makeYourLocation("public");
			collection.selectSuggestedAddress();
			element = Locators.getInstance().addAddress(driver);
			address = Keywords.getText(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Address enter successfully",
						"PASS", "Address should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Address enter not successfully",
						"FAIL", "Address should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Address", "FAIL", "Address should be enter");

		}

		return address;
	}

	public void clickOnContinueToMyProfilePageLink() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().continueMyProfileLinkedText(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Continue To My Profile Page Link click successfully</b>", "PASS",
						"<b>Continue To My Profile Page Link should be click</b>");
			}
		} catch (Exception e) {
		}
	}

	public int getProfileGrowth() {
		int profilePercentage = 0;
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			clickOnEditButton();
			elementList = Locators.getInstance().myProfilePercentage(driver);
			for (WebElement ele : elementList) {
				if (Keywords.getText(ele).length() > 0) {
					profilePercentage = Integer.parseInt(
							Keywords.getText(ele).substring(0, Keywords.getText(ele).indexOf("\nComplete") - 1));
					break;
				}
			}
			clickOnMyProfileSaveButton();
			myProfileSuccessfullyUpdated();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return profilePercentage;
	}

	public void clickOnEditButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileEditLinkedTxt(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Profile edit button click successfully", "PASS", "My Profile Edit button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Profile edit button not click successfully", "FAIL",
						"My Profile Edit button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the My Profile edit button", "FAIL",
					"My Profile Edit button should be click");
		}
	}

	public void verifyMyProfileEditHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileEditLinkedTxt(driver);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile edit header text visible successfully", "PASS",
						"Profile Edit header text should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile edit header text not visible successfully", "FAIL",
						"Profile Edit header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Profile edit header text", "FAIL",
					"Profile Edit header text should be present");
		}
	}

	public void clickOnMyProfileSaveButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().myProfileSaveBtn(driver);
			Keywords.click(element);
			Thread.sleep(2000);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Save button click successfully", "PASS", "Profile Save button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Save button not click successfully", "FAIL", "Profile Save button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the Profile Save button", "FAIL",
					"Profile Save button should be click");
		}
	}

	public void myProfileSuccessfullyUpdated() {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 3);
			element = Locators.getInstance().myProfileAlertMessage(driver);
			Keywords.verifyTextOnPage(element.getText());
			element = Locators.getInstance().submitMyProfileAlert(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("My Profile Updated successfully",
						"PASS", "My Profile should be updated");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Profile not updated successfully", "FAIL", "My Profile should be updated");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating the My Profile", "FAIL", "My Profile should be updated");
		}
	}

	public int getProfilePercentage(String updationType) {
		int percentage = 0;
		try {
			// percentage = Integer.parseInt(getProfileGrowth());
			if (updationType.equalsIgnoreCase("signup"))
				percentage = 0;
			else if (updationType.equalsIgnoreCase("aboutme"))
				percentage = 30;
			else if (updationType.equalsIgnoreCase("clearaboutme"))
				percentage = -30;
			else if (updationType.equalsIgnoreCase("coverphoto"))
				percentage = 30;
			else if (updationType.equalsIgnoreCase("removecoverphoto"))
				percentage = -30;
			else if (updationType.equalsIgnoreCase("post"))
				percentage = 10;
			else if (updationType.equalsIgnoreCase("follow"))
				percentage = 10;
			else if (updationType.equalsIgnoreCase("unfollow"))
				percentage = -10;
			else if (updationType.equalsIgnoreCase("addplants"))
				percentage = 20;
			else if (updationType.equalsIgnoreCase("deleteplants"))
				percentage = -20;

		} catch (Exception e) {

		}

		return percentage;
	}

	public boolean checkFollowBtnVisibility() {
		return Keywords.isElementEnable(Locators.getInstance().profileFollowBtn(driver));
	}

	public boolean clickFollowBtn() {
		boolean followBtnStatus = false;
		try {
			followBtnStatus = checkFollowBtnVisibility();
			if (followBtnStatus) {
				Keywords.click(Locators.getInstance().profileFollowBtn(driver));
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Follow button</b> successfully click", "PASS", "<b>Follow button</b> should be click");
			} else if (!followBtnStatus)
				followBtnStatus = false;
			/*
			 * else DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting( "<b>Follow button</b> successfully not click",
			 * "FAIL", "<b>Follow button</b> should be click");
			 */
		} catch (Exception e) {
			/*
			 * DriverSession.getLastExecutionReportingInstance().
			 * teststepreporting(
			 * "!!!Exception occurred while click on the <b>Follow button</b>",
			 * "FAIL", "<b>Follow button</b> should be click");
			 */
		}

		return followBtnStatus;
	}

	public void clickUnFollowBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver, 2);
			element = Locators.getInstance().unfollowUserProfileBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Following button</b> successfully click", "PASS",
						"<b>Following button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Following button</b> successfully not click", "FAIL",
						"<b>Following button</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the <b>Following button</b>", "FAIL",
					"<b>Following button</b> should be click");
		}
	}

	public void navigateToCommunities() {
		try {
			HomePage home = new HomePage(driver);
			home.selectExploreInnerTab("Community");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToTheNextPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().nextPageArrow(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Next Arrow Button</b> click successsfully", "PASS",
						"<b>Next Arrow Button</b> should be click");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Next Arrow Button</b>", "FAIL",
					"<b>Next Arrow Button</b> should be click");
		}
	}

	public List<String> followProfile() {
		List<WebElement> communitiesList;
		List<String> followProfilesList = new ArrayList<String>();
		int randomNumber = 0;
		String userProfile = "";
		boolean flag;
		try {
			Keywords.waitForPage(driver);
			communitiesList = Locators.getInstance().communitiesProfileList(driver);
			if (communitiesList.size() <= 5) {
				navigateToTheNextPage();
				Keywords.waitForPageLoad(driver);
			}
			for (int i = 0; i <= 4; i++) {
				communitiesList = Locators.getInstance().communitiesProfileList(driver);
				randomNumber = Keywords.getRandomInteger(communitiesList.size());
				userProfile = Keywords.getTextByIndex(communitiesList, randomNumber);
				Keywords.clickByIndex(communitiesList, randomNumber);
				Keywords.waitForPage(driver, 2);
				flag = clickFollowBtn();
				if (flag) {
					followProfilesList.add(userProfile);
				} else if (!flag)
					i--;
				Keywords.backPage();
				Thread.sleep(2000);
				// if (i >= 4)
				// break;
			}
		} catch (Exception e) {
			// DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception
			// occurred while click on the <b>Follow button</b>",
			// "FAIL", "<b>Follow button</b> should be click");
		}
		return followProfilesList;
	}

	public void unFollowProfile(String profileName) {
		List<WebElement> communitiesList;
		try {
			Keywords.waitForPage(driver);
			communitiesList = Locators.getInstance().communitiesProfileList(driver);
			for (WebElement ele : communitiesList) {
				if (Keywords.getText(ele).equalsIgnoreCase(profileName)) {
					ele.click();
					Keywords.waitForPage(driver, 2);
					clickUnFollowBtn();
					Keywords.backPage();
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while click on the <b>Following button</b>", "FAIL",
					"<b>Following button</b> should be click ");
		}
	}

	public String postMessage() {
		WebElement element;
		String randomMessage = "";
		try {
			randomMessage = Keywords.getRandomString();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().postMsg(driver);
			Keywords.click(element);
			Keywords.typeText(element, randomMessage);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Message</b> enter successfully", "PASS", "<b>Post Message</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Message</b> not enter successfully", "FAIL", "<b>Post Message</b> should be entered");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while writing the <b>Post Message</b>", "FAIL",
					"<b>Post Message</b> should be enter");
		}

		return randomMessage;
	}

	public void submitPost() {
		WebElement element;
		try {
			element = Locators.getInstance().postButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Button</b> click successfully", "PASS", "<b>Post Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Button</b> not click successfully", "FAIL", "<b>Post Button</b> should be click");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + "<b>Post Button</b>", "FAIL",
					"<b>Post Button</b> should be click");
		}
	}

	public String getPostUserName() {
		return Keywords.getText(Locators.getInstance().getPostUserName(driver));
	}

	public String getPostMessage() {
		return Keywords.getText(Locators.getInstance().getPostMsg(driver));
	}

	public String getCommentUserName() {
		return Keywords.getText(Locators.getInstance().getCommentUserName(driver));
	}

	public String getCommentMessage() {
		return Keywords.getText(Locators.getInstance().getCommentMessage(driver));
	}

	public String doCommentOnUserPost() {
		String commentMessage = "";
		WebElement element;
		String randomComment = "";
		try {
			randomComment = Keywords.getRandomString();
			Keywords.waitForPage(driver);
			element = Locators.getInstance().writeCommentOnPost(driver);
			Keywords.typeText(element, randomComment);
			commentMessage = randomComment;

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment On User Post</b> done successfully", "PASS",
						"<b>Comment On User Post</b> should be done");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Comment On User Post</b> not done successfully", "FAIL",
						"<b>Comment On User Post</b> should be done");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while writing comment on user post", "FAIL",
					"<b>Comment On User Post</b> should be done");
		}
		return commentMessage;
	}

	public void submitComment() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitCommentFromNews(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Button</b> click successfully", "PASS", "<b>Post Button</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Post Button</b> not click successfully", "FAIL", "<b>Post Button</b> should be click");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + "<b>Post Button</b>", "FAIL",
					"<b>Post Button</b> should be click");
		}
	}

	public int getNotificationCount() {
		int count = 0;
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getNotificationCount(driver);
			count = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
		}

		return count;
	}

	public void clickOnNotificationBell() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().notificationBell(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Bell</b> click Successfully", "PASS",
						"<b>Notification Bell</b> should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Notification Bell</b> click Successfully", "FAIL",
						"<b>Notification Bell</b> should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Notification Bell</b>", "FAIL",
					"<b>Notification Bell</b> should be click");
		}
	}

	public void SelectCommentMessageFromList(String postMessage, String commentUserName, String commentMessage) {
		List<WebElement> userList;
		WebElement element;
		String commentUName = "";
		String commentMsg = "";
		try {
			clickOnNotificationBell();
			Keywords.waitForPage(driver);
			userList = Locators.getInstance().getUserListThoseCommentOnPostFromNotification(driver, commentUserName,
					postMessage);
			for (int i = 0; i < userList.size(); i++) {
				element = Locators.getInstance().clickOnPostMessageFromNotificationView(driver, commentUserName,
						postMessage);
				System.out.println("User Post Message From notificatin view..." + Keywords.getText(element));
				if (Keywords.getText(element).trim().equalsIgnoreCase(postMessage)) {
					Thread.sleep(2000l);
					Keywords.click(element);
					Thread.sleep(2000l);
					commentUName = getCommentUserName();
					commentMsg = getCommentMessage();
				}
				if (commentUName.equalsIgnoreCase(commentUserName) && commentMsg.equalsIgnoreCase(commentMessage)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Comment Message On Post</b> view successfully", "PASS",
							"<b>Comment Message On Post</b> should be view");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the comment message from notification list", "FAIL",
					"<b>Comment Message On Post</b> should be view");
		}
	}

	public int getUserPlantCount() {
		int count = 0;
		WebElement element;
		String txt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getUserPlantCountFromWeb(driver);
			txt = Keywords.getText(element);
			count = Integer.parseInt(txt.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getUserNetworkCount() {
		int count = 0;
		WebElement element;
		String txt = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getUserNetworkCountFromWeb(driver);
			txt = Keywords.getText(element);
			count = Integer.parseInt(txt.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void clickOnNewsLikeButton() {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().newsLikeButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>News Like click successfully</b>", "PASS", "<b>News Like button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>News Like not click successfully</b>", "FAIL", "<b>News Like button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the News Like</b>", "FAIL",
					"<b>News Like button should be clicked</b>");
		}
	}
	
	public void submitWriteCommentMessage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitComment(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit button click successfully</b>", "PASS", "<b>Submit button should be clicked</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Submit button not click successfully</b>", "FAIL", "<b>Submit button should be clicked</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while clicking on the Submit button</b>", "FAIL",
					"<b>Submit button should be clicked</b>");
		}
	}
}
