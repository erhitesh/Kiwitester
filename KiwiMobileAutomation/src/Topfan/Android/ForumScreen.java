package Topfan.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class ForumScreen extends CommonFeatures {
	WebDriver driver;
	WebElement element;
	private final String expectedFollowingNoPost = "No current posts to view";
	private boolean likeFlag = true;

	public ForumScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickPlusButton() throws Exception {
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element = AndroidAppLocators.getInstance().getPlusButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plus Button successfully clicked",
						"PASS", "Plus Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Plus Button found but not clicked",
						"FAIL", "Plus Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...as Plus Button not found", "FAIL", "Plus Button should be clicked");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public String enterText() throws Exception {
		Keywords.waitForPage(driver, 20);
		String randomText = null;
		try {
			WebElement element = AndroidAppLocators.getInstance().getEditTextOnPostScreen(driver);
			randomText = Keywords.getRandomString();
			Keywords.typeText(element, randomText);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Random text successfully entered",
						"PASS", "Random Text should be entered");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Random text not successfully entered", "FAIL", "Random Text should be entered");
			}
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...as Edit Text not found", "FAIL", "Random Text should be entered");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return randomText;
	}

	public void clickPostButton() throws Exception {
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element = AndroidAppLocators.getInstance().getPostButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Post Button successfully clicked",
						"PASS", "Post Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Post Button found but not clicked",
						"FAIL", "Post Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...as Post Button not found", "FAIL", "Post Button should be clicked");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyNewPostComesFirstAfterTrendingPosts(String username, String postMessage, boolean withImage)
			throws Exception {
		Keywords.waitForPage(driver, 20);
		try {
			waitForProgressBarToBeInvisible(AndroidAppLocators.getInstance().getLocatorOfProgressBar());
			// waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForAForumCard());
			boolean found = false;
			int attempts = 0;
			int index = 0;
			while (!found && attempts < 3) {
				attempts++;
				List<WebElement> forumCards = AndroidAppLocators.getInstance().getAllCardsOnForumScreen(driver);
				index = 0;
				for (WebElement element : forumCards) {
					index++;
					if (!isForumCardTrending(index)) {
						found = true;
						break;
					}
				}
				if (!found) {
					scrollDownFrame(driver);
				}
			}
			;
			element = AndroidAppLocators.getInstance().getUserNameOfFirstCardAfterTrendingCards(driver, index);
			String actualUserName = element.getText();
			if (actualUserName.toLowerCase().trim().equals(username.toLowerCase().trim())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Username appearing on the first card after trending cards matched", "PASS",
						"First Post after trending cards should belong to the user that just posted");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Username appearing on the first card after trending cards not matched", "FAIL",
						"First Post after trending cards should belong to the user that just posted");
			}

			element = AndroidAppLocators.getInstance().getStatusLevelOfFirstCardAfterTrendingCards(driver, index);
			String statusLevel = element.getText();
			if (statusLevel.toLowerCase().trim().equals("bronze")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Status Level appearing on the first card after trending cards matched", "PASS",
						"First Post after trending cards should belong to the user that just posted");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Status Level appearing on the first card after trending cards not matched", "FAIL",
						"First Post after trending cards should belong to the user that just posted");
			}

			element = AndroidAppLocators.getInstance().getPostMessageOfFirstCardAfterTrendingCards(driver, index);
			String message = element.getText();
			if (message.trim().equals(postMessage.trim())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Message appearing on the first card after trending cards matched", "PASS",
						"First Post after trending cards should belong to the user that just posted");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Message appearing on the first card after trending cards not matched", "FAIL",
						"First Post after trending cards should belong to the user that just posted");
			}

			if (withImage) {
				try {
					element = AndroidAppLocators.getInstance().getMainImageOfFirstCardAfterTrendingCards(driver, index);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Image present on the First Post after trending cards", "PASS",
							"First Post after trending cards should belong to the user that just posted");
				} catch (Exception e) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Image not present on the First Post after trending cards", "FAIL",
							"First Post after trending cards should belong to the user that just posted");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying the First Post after trending cards", "FAIL",
					"First Post after trending cards should belong to the user that just posted");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isForumCardTrending(int index) {
		try {
			AndroidAppLocators.getInstance().getTrendingTextOnForumCard(driver, index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void captureImage() throws Exception {
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getUpArrowIcon(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getTakeFromCameraOption(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getCameraView(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getApproveImageButton(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getSkipButtonForImageCaptured(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getSaveCapturedImageButton(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getDoneButton(driver);
			element.click();
			Thread.sleep(2000);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Image clicked successfully from camera", "INFO",
					"Verifying Post Message with Image on Forum Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured... while clicking an image from camera", "FAIL",
					"Verifying Post Message with Image on Forum Screen");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyCharacterLimit() throws Exception {
		Keywords.waitForPage(driver, 20);
		try {
			try {
				element = AndroidAppLocators.getInstance().getPostButton(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Post Button found for no characters", "FAIL",
						"Verifying Post Button not appears for 0 characters");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Post Button not found for no characters", "PASS",
						"Verifying Post Button not appears for 0 characters");
			}
			element = AndroidAppLocators.getInstance().getEditTextOnPostScreen(driver);
			element.sendKeys("A");
			try {
				element = AndroidAppLocators.getInstance().getPostButton(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Post Button found for 1 character",
						"PASS", "Verifying Post Button appears for 1 character");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Post Button not found for 1 characters", "FAIL",
						"Verifying Post Button appears for 1 character");
			}
			int characters = 0;
			StringBuilder sb = new StringBuilder();
			for (characters = 0; characters <= 200; characters++) {
				sb.append("A");
			}
			element = AndroidAppLocators.getInstance().getEditTextOnPostScreen(driver);
			element.clear();
			element.sendKeys(sb);
			if (isAlertForUpperCharacterLimitFound()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"AlertBox appeared and Character Limit is " + (characters - 1), "PASS",
						"Verifying Upper Character Limit is 200 characters");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"AlertBox did not appear even after typing on " + characters + " characters", "FAIL",
						"Verifying Upper Character Limit is 200 characters");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying lower and upper character limit ", "FAIL",
					"Verifying Lower and Upper Character Limit on a Post Message on Forum Screen");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isAlertForUpperCharacterLimitFound() {
		Keywords.waitForPage(driver, 1);
		try {
			element = AndroidAppLocators.getInstance().getUpperCharacterLimitAlert(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 20);
		}
	}

	/*
	 * public void checkPostsShuffleOnRefresh() { try { int cardsCount = 0; do {
	 * List<WebElement> elements =
	 * AndroidAppLocators.getInstance().getAllCardsOnForumScreen(driver); }
	 * while (cardsCount < 10); } catch (Exception e) {
	 * 
	 * } }
	 */

	public void clickOnFirstLikeButton() {
		try {
			element = AndroidAppLocators.getInstance().getFirstLikeButtonForum(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Like button clicked successfully",
						"PASS", "Like Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click like button",
						"FAIL", "Like Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking like button", "FAIL", "Like Button should be clicked");
		}
	}

	public void clickOnFirstCommentButton() {
		try {
			element = AndroidAppLocators.getInstance().getFirstCommentButtonForum(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button clicked successfully", "PASS", "Comment Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click comment button",
						"FAIL", "Commment Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking comment button", "FAIL", "Comment Button should be clicked");
			throw e;
		}
	}

	public int getLikeCountForFirstForum() {
		int count = 0;
		try {
			element = AndroidAppLocators.getInstance().getFirstForumCommentText(driver);
			if (element != null) {
				String text = Keywords.getText(element);
				if (text.contains("Comment"))
					text = text.split(" Comment")[0];
				if (text.contains("Like"))
					count = Integer.parseInt(text.split(" Like")[0]);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while getting count of Likes", "FAIL", "Getting the count of Likes");
		}
		return count;
	}

	public int getLikeCountForPostWithIndex(int index) {
		int count = 0;
		try {
			element = AndroidAppLocators.getInstance().getForumCommentTextOnPostWithIndex(driver, index);
			if (element != null) {
				String text = Keywords.getText(element);
				count = Integer.parseInt(text.split(" Like")[0].split(" Comment")[0]);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while getting count of Likes", "FAIL", "Getting the count of Likes");
		}
		return count;
	}

	public int getCommentCountForFirstForum() {
		int count = 0;
		try {
			element = AndroidAppLocators.getInstance().getFirstForumCommentText(driver);
			if (element != null) {
				String text = Keywords.getText(element);
				if (text.contains("Comment")) {
					if (text.contains("Like"))
						text = text.split(" Like")[1].split(" Comment")[0].replace("s", "").replace(" ", "");
					else
						text = text.split(" Comment")[0].replace("s", "").replace(" ", "");
					if (!text.isEmpty())
						count = Integer.parseInt(text);
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while getting count of Comments", "FAIL", "Getting the count of Comments");
		}
		return count;
	}

	public void addCommentInCommentBox() {
		try {
			element = AndroidAppLocators.getInstance().getForumCommentTextBox(driver);
			String comment = "Test Comment : " + Keywords.getRandomData();
			Keywords.typeText(element, comment);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment: " + comment + " successfully entered in the comment box", "PASS",
						"Commment should be entered in the comment box");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add comment", "FAIL",
						"Commment should be entered in the comment box");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while entering comment", "FAIL",
					"Commment should be entered in the comment box");
		}
	}

	public void clickOnCommentPostButton() {
		try {
			element = AndroidAppLocators.getInstance().getForumCommentPostButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment Post button clicked successfully", "PASS", "Comment Post Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click comment post button", "FAIL", "Commment Post Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking comment post button", "FAIL",
					"Comment Post Button should be clicked");
			throw e;
		}
	}

	public void clickOnAddNewPost() {
		try {
			element = AndroidAppLocators.getInstance().getForumAddNewPostButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Add New Post button clicked successfully", "PASS", "Add New Post Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click add new post button", "FAIL", "Add New Post Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking add new post button", "FAIL",
					"Add New Post Button should be clicked");
			throw e;
		}
	}

	public String enterPostText() {
		String postText;
		try {
			element = AndroidAppLocators.getInstance().getForumPostTextBox(driver);
			postText = "Post" + Keywords.getRandomData();
			Keywords.typeText(element, postText);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Text: " + postText + " successfully entered in the post text box", "PASS",
						"Text should be entered in the post text box");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add text in post",
						"FAIL", "Text should be entered in the post text box");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while entering text for post", "FAIL",
					"Text should be entered in the post text box");
			throw e;
		}
		return postText;
	}

	public void clickOnPostButtonForNewPost() {
		try {
			element = AndroidAppLocators.getInstance().getForumPostButtonForNewPost(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Post button clicked successfully",
						"PASS", "Post Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click post button",
						"FAIL", "Post Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking post button", "FAIL", "Post Button should be clicked");
			throw e;
		}
	}

	public String addNewPost() {
		clickOnAddNewPost();
		String postText = enterPostText();
		clickOnPostButtonForNewPost();
		return postText;
	}

	public int clickLikeOnPost(String postText) {
		int index = 0;
		try {
			element = AndroidAppLocators.getInstance().getForumPostUsingText(driver, postText);
			List<WebElement> posts = AndroidAppLocators.getInstance().getAllVisiblePostInForum(driver);
			for (int i = 1; i <= posts.size(); ++i) {
				try {
					element = AndroidAppLocators.getInstance().getTextFromPost(driver, i);
					if (Keywords.getText(element).equalsIgnoreCase(postText)) {
						index = i;
						break;
					}
				} catch (Exception e) {
				}
			}
			element = AndroidAppLocators.getInstance().getLikeButton(driver, index);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Like button clicked successfully",
						"PASS", "Like Button should be clicked on the post with text: " + postText);
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click like button",
						"FAIL", "Like Button should be clicked on the post with text: " + postText);
		} catch (Exception e) {
			if (likeFlag)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Exception occured while clicking like button", "FAIL",
						"Like Button should be clicked on the post with text: " + postText);
			throw e;
		}
		return index;
	}

	public int clickCommentOnPost(String postText) {
		int index = 0;
		try {
			element = AndroidAppLocators.getInstance().getForumPostUsingText(driver, postText);
			List<WebElement> posts = AndroidAppLocators.getInstance().getAllVisiblePostInForum(driver);
			for (int i = 1; i <= posts.size(); ++i) {
				element = AndroidAppLocators.getInstance().getTextFromPost(driver, i);
				if (Keywords.getText(element).equalsIgnoreCase(postText)) {
					index = i;
					break;
				}
			}
			element = AndroidAppLocators.getInstance().getCommentButton(driver, index);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button clicked successfully", "PASS",
						"Comment Button should be clicked on the post with text: " + postText);
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click comment button",
						"FAIL", "Comment Button should be clicked on the post with text: " + postText);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking comment button", "FAIL",
					"Comment Button should be clicked on the post with text: " + postText);
			throw e;
		}
		return index;
	}

	public void clickTabInForumUsingText(String tabText) {
		try {
			element = AndroidAppLocators.getInstance().getFollowingButtonForum(driver, tabText);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						tabText + " Tab clicked successfully", "PASS", tabText + " Tab should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click " + tabText + " tab", "FAIL", tabText + " Tab should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking " + tabText + " Tab", "FAIL", tabText + " Tab should be clicked");
		}
	}

	public void verifyNoPostInFollowing() {
		try {
			element = AndroidAppLocators.getInstance().getFollowingNoPost(driver);
			String actualText = Keywords.getText(element);
			if (actualText.trim().equals(expectedFollowingNoPost))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("No Post Present in Following Tab",
						"PASS", "No Current Post should be present in Foloowing Tab");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Current Post available in Following", "FAIL",
						"No Current Post should be present in Foloowing Tab");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying following tab", "FAIL",
					"No Current Post should be present in Foloowing Tab");
		}
	}

	public String followAnyUser() {
		String user = null;
		try {
			user = navigateToFirstUserProfile();
			ProfileScreen ps = new ProfileScreen(driver);
			ps.clickFollowButton();
			Thread.sleep(5000L);
			ps.clickBackButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while following user", "FAIL", "Following a user");
		}
		return user;
	}

	public String navigateToFirstUserProfile() {
		String user = null;
		try {
			element = AndroidAppLocators.getInstance().getFirstUserOfForum(driver);
			user = Keywords.getText(element).trim();
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Navigated to User Profile", "PASS",
						"Navigating to User Profile");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to move on user profile",
						"FAIL", "Navigating to User Profile");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while navigating top user profile", "FAIL", "Navigating to User Profile");
		}
		return user;
	}

	private boolean verifyPostUser(String expected, int index) {
		element = AndroidAppLocators.getInstance().getPostUserName(driver, index);
		String postUser = Keywords.getText(element).trim();
		if (!postUser.equalsIgnoreCase(expected)) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Post from other user are also appearing", "FAIL",
					"Verifying posts from the Following user are appearing only");
			return false;
		} else
			return true;
	}

	public void verifyFollowingPost(String user) {
		int postSize = 0;
		boolean isEndOfPage = false;
		try {
			List<WebElement> posts = AndroidAppLocators.getInstance().getAllVisiblePosts(driver);
			postSize = posts.size();
			for (int i = 1; i <= posts.size(); ++i) {
				if (!verifyPostUser(user, i))
					return;
			}

			while (!isEndOfPage) {
				try {
					Keywords.waitForPage(driver, 5);
					AndroidAppLocators.getInstance().scrollToNextPost(driver, user, postSize);
					if (!verifyPostUser(user, postSize))
						return;
					postSize++;
				} catch (Exception e) {
					isEndOfPage = true;
					break;
				} finally {
					Keywords.waitForPage(driver, 60);
				}
			}
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Post only from following user are appearing", "PASS",
					"Verifying posts from the Following user are appearing only");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying post from following user", "FAIL",
					"Verifying posts from the Following user are appearing only");
		}
	}

	private boolean isSearchPresentOnFanWall() {
		Keywords.waitForPage(driver, 5);
		try {
			element = AndroidAppLocators.getInstance().getSearchButtonForum(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifySearchOnFanWall() {
		try {
			if (!isSearchPresentOnFanWall())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search  button not available",
						"PASS", "Search button should not available on FanWall Screen");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search buttton available on FanWall", "FAIL",
						"Search button should not available on FanWall Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while checking search button", "FAIL",
					"Search button should not available on FanWall Screen");
		}
	}

	public void clickBuyHourButton() {
		try {
			element = AndroidAppLocators.getInstance().getBuyHoursDropDown(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getBuyTwoHoursDropDown(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Click on Buy 2 Hours clicked successfully", "PASS", "Buy 2 hours buton should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click on Buy two hours button", "FAIL", "Buy 2 hours buton should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking buy two hour button", "FAIL",
					"Buy 2 hours buton should be clicked");
		}
	}

	public void clickCoinsButtonOnFanWall() {
		try {
			element = AndroidAppLocators.getInstance().getCoinsButtonOnFanWall(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Coins Button clicked successfully",
						"PASS", "Clicking Coins Button on Fan Wall Screen");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Coins Button not clicked successfully", "FAIL", "Clicking Coins Button on Fan Wall Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking coins button on fan wall", "FAIL",
					"Clicking Coins Button on Fan Wall Screen");
		}
	}

	public void coinDeductionOnFanWall() {
		try {
			element = AndroidAppLocators.getInstance().getBackButton(driver);
			Keywords.click(element);
			clickProfileButton();
			ProfileScreen ps = new ProfileScreen(driver);
			String profileScore = ps.getUserScore();
			int actual = Integer.valueOf(profileScore);
			int expectedScore = 900;

			if (actual == expectedScore) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Two Hundred coin deducted successfully", "PASS", "Two Hundred coin should deducted");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Two hundred coin deduction is not correct", "FAIL", "Two Hundred coin should deducted");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while calculating profie score", "FAIL", "Two Hundred coin should deducted");
		}
	}

	private boolean checkTabPresent(String tabName) throws InterruptedException {
		Thread.sleep(8000L);
		List<WebElement> tabs = AndroidAppLocators.getInstance().getAllTabFromForum(driver);
		boolean isTabPresent = false;
		for (WebElement tab : tabs) {
			String tabText = Keywords.getText(tab).trim();
			if (tabText.equalsIgnoreCase(tabName)) {
				isTabPresent = true;
				break;
			}
		}
		return isTabPresent;
	}

	public void verifyFanWallPresence(boolean b, String fanWallText) {
		try {
			boolean tabPresent = checkTabPresent(fanWallText);

			if (tabPresent) {
				if (b)
					DriverSession.setStepResult(true);
				else
					DriverSession.setStepResult(false);
			} else {
				if (b)
					DriverSession.setStepResult(false);
				else
					DriverSession.setStepResult(true);
			}

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fan Wall presence is as expected. Present : " + tabPresent, "PASS",
						"Verifying Presence of Fan Wall from CMS");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fan Wall presence is not as expected. Present : " + tabPresent, "FAIL",
						"Verifying Presence of Fan Wall from CMS");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying presence of Fan Wall", "FAIL",
					"Verifying Presence of Fan Wall from CMS");
		}
	}

	public void verifyTextOfFanWallTab(String newFanWallText) {
		try {
			if (checkTabPresent(newFanWallText))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fan Wall text is appearing as expected", "PASS",
						"Verifying dynamic text for Fan Wall through CMS");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fan Wall text is not appearing as expected", "FAIL",
						"Verifying dynamic text for Fan Wall through CMS");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying dynamic text for Fan Wall", "FAIL",
					"Verifying dynamic text for Fan Wall through CMS");
		}
	}

	public void commentOnPost(String post) {
		clickCommentOnPost(post);
		addCommentInCommentBox();
		clickOnCommentPostButton();
		clickBackButton();
	}

	public void clickLikeOnPostWithScroll(String postText) {
		int scrolls = 0;
		likeFlag = false;
		while (scrolls < 5) {
			try {
				Keywords.waitForPage(driver, 5);
				clickLikeOnPost(postText);
				break;
			} catch (Exception e) {
				scrollDownForumScreen(driver);
				scrolls++;
			}
		}
		Keywords.waitForPage(driver, 60);
		if (scrolls == 5) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Unable to get the post in max attempts", "FAIL",
					"Like Button should be clicked on the post with text: " + postText);
		}
	}

	public void postOnFanWall() {
		try {
			element = AndroidAppLocators.getInstance().getTextBoxFanWallForum(driver);
			String comment = "Test Comment : " + Keywords.getRandomData();
			Keywords.typeText(element, comment);
			element = AndroidAppLocators.getInstance().getPostFanWallForum(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("FanWall post done successfully",
						"PASS", "User should able to post on FanWall");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to post on FanWall", "FAIL",
						"User should able to post on FanWall");
			By by = AndroidAppLocators.getInstance().getLocatorOfProgressBar();
			waitForProgressBarToBeInvisible(by);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while posting on FanWall", "FAIL", "User should able to post on FanWall");
		}
	}

	public void verifyPostOnFanWall() {
		Keywords.waitForPage(driver, 5);
		try {
			element = AndroidAppLocators.getInstance().getPostFanWall(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User's post on FanWall verified successfully", "PASS", "User should able to see post on FanWall");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User's post on FanWall not verified successfully", "FAIL",
					"User should able to see post on FanWall");
		}
	}
	
	public void captureImageAndCropWidth() throws Exception{
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getUpArrowIcon(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getTakeFromCameraOption(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getCameraView(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getApproveImageButton(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int halfStatusBarWidth = element.getSize().getWidth()/2;
			element = AndroidAppLocators.getInstance().getImageFrame(driver);
			int imageHeight = element.getSize().getHeight();
			element = AndroidAppLocators.getInstance().getSkipButtonForImageCaptured(driver);
			element.click();
			Thread.sleep(4000);
			int imageTopLine = getImageTopLine(imageHeight);
			TouchAction t = new TouchAction((MobileDriver) driver);
			t.longPress(10, imageTopLine+imageHeight/2).moveTo(halfStatusBarWidth, imageTopLine+imageHeight/2).release().perform();
			Thread.sleep(2000L);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Successfully captured image and cropped its width", "PASS",
					"Verifying that there is a Minimum Width required for posting an Image");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while capturing image and cropping its width", "FAIL", "Verifying that there is a Minimum Width required for posting an Image");
			throw e;
		}
	}
	
	public void captureImageAndCropHeight() throws Exception{
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getUpArrowIcon(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getTakeFromCameraOption(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getCameraView(driver);
			element.click();
			Thread.sleep(4000);
			element = AndroidAppLocators.getInstance().getApproveImageButton(driver);
			element.click();
			Thread.sleep(2000);
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int halfStatusBarWidth = element.getSize().getWidth()/2;
			element = AndroidAppLocators.getInstance().getImageFrame(driver);
			int imageHeight = element.getSize().getHeight();
			element = AndroidAppLocators.getInstance().getSkipButtonForImageCaptured(driver);
			element.click();
			Thread.sleep(4000);
			int imageTopLine = getImageTopLine(imageHeight);
			TouchAction t = new TouchAction((MobileDriver) driver);
			t.longPress(halfStatusBarWidth, imageTopLine).moveTo(halfStatusBarWidth, imageTopLine+imageHeight/2).release().perform();
			Thread.sleep(2000L);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Successfully captured image and cropped its height", "PASS",
					"Verifying that there is no Minimum Height required for posting an Image");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while capturing image and cropping its height", "FAIL", "Verifying that there is no Minimum Height required for posting an Image");
			throw e;
		}
	}
	
	private int getImageTopLine(int imageHeight){
		try{
			element = AndroidAppLocators.getInstance().getActionBarOnSaveImage(driver);
			int actionBarHeight = element.getSize().getHeight();
			element = AndroidAppLocators.getInstance().getFrameOnSaveImage(driver);
			int frameHeight = element.getSize().getHeight();
			int gapHeight = (frameHeight-actionBarHeight-imageHeight)/2;
			return actionBarHeight+gapHeight;
		}catch(Exception e){
			throw e;
		}
	}
	
	public void saveCroppedImage() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().getSaveCapturedImageButton(driver);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Cropped image successfully saved", "PASS", "Saving the cropped image");
			Thread.sleep(4000L);
			try{
				element = AndroidAppLocators.getInstance().getDoneButton(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Done button found", "INFO", "Saving the cropped image");
				Keywords.click(element);
				Thread.sleep(4000L);
			}catch(Exception e){
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Done button not found", "INFO", "Saving the cropped image");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while saving the cropped image", "FAIL", "Saving the cropped image");
			throw e;
		}
	}
	
	public boolean isCroppedImagePresent() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().getPostedImage(driver);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
