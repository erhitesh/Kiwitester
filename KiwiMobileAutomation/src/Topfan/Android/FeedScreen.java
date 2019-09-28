package Topfan.Android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class FeedScreen extends CommonFeatures {
	private WebDriver driver;
	private WebElement element;
	private int methodRuns = 0;
	private int quizIndex = -1;

	public FeedScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ArrayList<String> getCardTypes(int cardTypesCount) throws Exception {
		ArrayList<String> types = new ArrayList<String>();
		int i = 0;
		do {
			i++;
			try {
				Keywords.waitForPage(driver, 5);
				element = AndroidAppLocators.getInstance().getCardType(driver, i);
				types.add(element.getText());
			} catch (Exception e) {
				i--;
				Keywords.scrollRight(getOverlayVerticalCoordinate());
				Thread.sleep(3000);
			} finally {
				Keywords.waitForPage(driver, 60);
			}

		} while (i <= cardTypesCount);
		return types;
	}

	private int getOverlayVerticalCoordinate() {
		element = AndroidAppLocators.getInstance().getActionBar(driver);
		int actionBarHeight = element.getSize().height;
		element = AndroidAppLocators.getInstance().getTabLayout(driver);
		int tabLayoutHeight = element.getSize().height;
		element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
		int statusBarHeight = element.getSize().height;
		int totalHeight = statusBarHeight + actionBarHeight + tabLayoutHeight / 2;
		return totalHeight;
	}

	public ArrayList<String> getFirstCardOfEachType(ArrayList<String> cardTypes, boolean metadata) {
		ArrayList<String> cardTitles = new ArrayList<String>();
		Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 10);
		int vScrollAttempts = 0;
		for (String s : cardTypes) {
			boolean clicked = false;
			int hScrollAttempts = 0;
			do {
				try {
					element = AndroidAppLocators.getInstance().getEachCardType(driver, s);
					Keywords.click(element);
					if (DriverSession.getStepResult()) {
						clicked = true;
					}
				} catch (Exception e) {
					Keywords.scrollRight(getOverlayVerticalCoordinate());
					hScrollAttempts++;
				}
			} while (!clicked && hScrollAttempts < 3);

			boolean found = false;
			waitForProgressBarToBeInvisible(AndroidAppLocators.getInstance().getLocatorOfProgressBar());
			do {
				try {
					switch (s.toLowerCase()) {
					case "videos":
						boolean success = false;
						do {
							if (metadata) {
								try {
									element = AndroidAppLocators.getInstance().getMetadataVideoCardTitle(driver, 1);
									success = true;
								} catch (Exception e) {
									scrollDownFrame(driver);
									vScrollAttempts++;
								}
							} else {
								try {
									element = AndroidAppLocators.getInstance().getVideoCardTitle(driver, 1);
									success = true;
								} catch (Exception e) {
									scrollDownFrame(driver);
									vScrollAttempts++;
								}
							}
						} while (!success && vScrollAttempts < 4);
						break;
					case "audio":
						element = AndroidAppLocators.getInstance().getAudioCardTitle(driver, 1);
						break;
					case "articles":
						element = AndroidAppLocators.getInstance().getArticleCardTitle(driver, 1);
						break;
					case "challenges":
						element = AndroidAppLocators.getInstance().getChallengeCardTitle(driver, 1);
						break;
					case "product":
						element = AndroidAppLocators.getInstance().getProductCardTitle(driver, 1);
						break;
					case "rewards":
						element = AndroidAppLocators.getInstance().getRewardCardTitle(driver, 1);
						break;
					case "social":
						element = AndroidAppLocators.getInstance().getSocialCardTitle(driver, 1);
						break;
					case "discussions":
						element = AndroidAppLocators.getInstance().getDiscussionCardTitle(driver, 1);
						break;
					case "photos":
						element = AndroidAppLocators.getInstance().getPhotoCardTitle(driver, 1);
						break;
					case "comic":
						element = AndroidAppLocators.getInstance().getComicCardTitle(driver, 1);
						break;
					case "polls":
						element = AndroidAppLocators.getInstance().getPollCardTitle(driver, 1);
						break;
					case "quizzes":
						element = AndroidAppLocators.getInstance().getQuizCardTitle(driver, 1);
						break;
					case "gif":
						element = AndroidAppLocators.getInstance().getGifCardTitle(driver, 1);
						break;
					case "vr":
						success = false;
						do {
							if (metadata) {
								try {
									element = AndroidAppLocators.getInstance().getMetadataVRCardTitle(driver, 1);
									success = true;
								} catch (Exception e) {
									scrollDownFrame(driver);
									vScrollAttempts++;
								}
							} else {
								try {
									element = AndroidAppLocators.getInstance().getVRCardTitle(driver, 1);
									success = true;
								} catch (Exception e) {
									scrollDownFrame(driver);
									vScrollAttempts++;
								}
							}
						} while (!success && vScrollAttempts < 4);
						break;
					default:
						element = null;
						break;
					}
					found = true;
					cardTitles.add(element.getText());
				} catch (Exception e) {
					scrollDownFrame(driver);
					vScrollAttempts++;
				}
			} while (!found && vScrollAttempts < 3);
		}
		Keywords.waitForPage(driver, 60);
		return cardTitles;
	}

	public void checkAllCardTypesUnderAllTab(ArrayList<String> cardTitles, ArrayList<String> cardTypes) {
		try {
			Thread.sleep(10000);
			boolean scrollRequired = true;
			ArrayList<String> allTextViewElements = new ArrayList<String>();
			// waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
			waitForProgressBarToBeInvisible(AndroidAppLocators.getInstance().getLocatorOfProgressBar());
			do {
				List<WebElement> elementsBeforeScroll = AndroidAppLocators.getInstance().getAllTextViews(driver);
				for (WebElement element : elementsBeforeScroll) {
					allTextViewElements.add(element.getText());
				}
				scrollDownFrame(driver);
				List<WebElement> elementsAfterScroll = AndroidAppLocators.getInstance().getAllTextViews(driver);
				allTextViewElements.removeAll(Arrays.asList("", " "));
				allTextViewElements = new ArrayList<String>(new LinkedHashSet<String>(allTextViewElements));
				if (elementsBeforeScroll.equals(elementsAfterScroll) || allTextViewElements.contains(cardTitles)
						|| allTextViewElements.size() > 200) {
					scrollRequired = false;
				}
			} while (scrollRequired);

			if (allTextViewElements.contains(cardTitles)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"All card types found under All Tab", "PASS", "Verifying all card types under All tab");
			} else {
				for (String str : cardTitles) {
					if (!allTextViewElements.contains(str)) {
						DriverSession.getLastExecutionReportingInstance()
								.teststepreportingWithoutSnapShot(
										"CardType of " + cardTypes.get(cardTitles.indexOf(str)) + " with title " + str
												+ " not found",
										"FAIL", "All card types should be present under All Tab");
					} else {
						DriverSession.getLastExecutionReportingInstance()
								.teststepreportingWithoutSnapShot("CardType of "
										+ cardTypes.get(cardTitles.indexOf(str)) + " with title " + str + " found",
										"PASS", "All card types should be present under All Tab");
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"All card types not found under All Tab.Cards Scrolled = " + (allTextViewElements.size()) / 2,
						"FAIL", "Verifying all card types under All tab");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying all card types under All tab", "FAIL",
					"Verifying all card types under All tab");

		}
	}

	public void verifyCtaButtonOnArticle() throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		int scrolls = 0;
		boolean success = false;
		Keywords.waitForPage(driver, 10);
		try {
			do {
				while (!isCtaButtonVisible() && scrolls < 8) {
					scrollDownFrame(driver);
					scrolls++;
				}
				List<WebElement> elements = AndroidAppLocators.getInstance().getALLCTACardsUnderArticleTab(driver);
				while (!success && !elements.isEmpty()) {
					element = elements.get(0);
					Keywords.click(element);
					if (newUrlOpened() || inAppArticleDisplayed()) {
						success = true;
					} else {
						driver.switchTo().alert().accept();
					}
					elements.remove(0);
				}
				if (!success) {
					scrollDownFrame(driver);
					scrolls++;
				}
			} while (!success && scrolls < 8);
			if (success) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"CTA button on an article successfully verified", "PASS", "Verifying CTA button on an article");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"CTA button on an article not successfully verified", "FAIL",
						"Verifying CTA button on an article");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying CTA button on an article", "FAIL",
					"Verifying CTA button on an article");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}

	}

	private boolean isCtaButtonVisible() {
		try {
			element = AndroidAppLocators.getInstance().getFirstCTACard(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean newUrlOpened() {
		try {
			element = AndroidAppLocators.getInstance().getChromeUrlBar(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean inAppArticleDisplayed() {
		try {
			List<WebElement> elements = AndroidAppLocators.getInstance().getTextViewsOnActionBar(driver);
			if (elements.size() >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLikeButtonAndVerifyLikeCount() throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		Keywords.waitForPage(driver, 10);
		int newLikeCount = 0;
		boolean success = false;
		try {
			int scrolls = 0;
			
			do {
				List<WebElement> cards = AndroidAppLocators.getInstance().getAllVisibleLikeButtons(driver);
				if(!cards.isEmpty()) {
					success=true;
				}
				if (!success) {
					scrollDownFrame(driver);
					scrolls++;
				}
			} while (scrolls < 5 && !success);
			
			int oldLikeCount = getLikesCount(1);

			if (success) {
				element = AndroidAppLocators.getInstance().getLikeButton(driver, 1);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Like button clicked on the card",
						"INFO", "Verifying Like button on a card");
				newLikeCount = getLikesCount(1);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"New Like count on the card is " + newLikeCount, "INFO", "Verifying Like button on a card");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"No fresh card for testing of Like button found", "INFO", "Verifying Like button on a card");
			}
			if (newLikeCount == (oldLikeCount+1)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button on a card successfully verified", "PASS", "Verifying Like button on a card");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button on a card not successfully verified", "FAIL", "Verifying Like button on a card");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying like button on a card", "FAIL",
					"Verifying Like button on a card");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickLikeButtonAndVerifyLikeCount2() throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		Keywords.waitForPage(driver, 10);
		int likeCount = 0;
		boolean success = false;
		try {
			int scrolls = 0;
			int i;
			do {
				List<WebElement> cards = AndroidAppLocators.getInstance().getAllVisibleLikeButtons(driver);
				i = 0;
				while (!success && !cards.isEmpty()) {
					i++;
					element = cards.get(0);
					if (cardWithNoLikesFound(i)) {
						success = true;
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Fresh card with 0 likes found", "INFO", "Verifying Like button on a card");
					}
					cards.remove(0);
				}
				if (!success) {
					scrollDownFrame(driver);
					scrolls++;
				}
			} while (scrolls < 100 && !success);

			if (success) {
				element = AndroidAppLocators.getInstance().getLikeButton(driver, i);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Like button clicked on the card",
						"INFO", "Verifying Like button on a card");
				likeCount = getLikesCount(i);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"New Like count on the card is " + likeCount, "INFO", "Verifying Like button on a card");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"No fresh card for testing of Like button found", "INFO", "Verifying Like button on a card");
			}
			if (likeCount == 1) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button on a card successfully verified", "PASS", "Verifying Like button on a card");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button on a card not successfully verified", "FAIL", "Verifying Like button on a card");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying like button on a card", "FAIL",
					"Verifying Like button on a card");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean cardWithNoLikesFound(int index) {
		try {
			element = AndroidAppLocators.getInstance().getLikesCount(driver, index);
			String temp = element.getText();
			String[] splitArray = temp.split(" ");
			if (splitArray[1].toLowerCase().trim().contains("like")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
	}

	private int getLikesCount(int index) {
		try {
			element = AndroidAppLocators.getInstance().getLikesCount(driver, index);
			String likeCountText = element.getText();
			String[] splitArray = likeCountText.split(" ");
			if (splitArray[1].toLowerCase().trim().contains("like")) {
				likeCountText = splitArray[0];
				return Integer.valueOf(likeCountText);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public void addCommentAndVerifyCommentsCount(boolean withImage) throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		Keywords.waitForPage(driver, 10);
		int oldCommentCount = 0;
		int newCommentCount = 0;
		boolean success = false;
		try {
			int scrolls = 0;
			int i;
			do {
				i = 0;
				List<WebElement> cards = AndroidAppLocators.getInstance().getAllVisibleCommentButtons(driver);
				while (!success && !cards.isEmpty()) {
					i++;
					element = cards.get(0);
					oldCommentCount = getCommentsCount(i);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Old comment count is " + oldCommentCount, "INFO", "Verifying Comment button on a card");
					Keywords.click(element);
					if (DriverSession.getStepResult()) {
						waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorOfCommentEditText());
						element = AndroidAppLocators.getInstance().getCommentEditText(driver);
						Keywords.typeText(element, Keywords.getRandomString());
						if (withImage) {
							element = AndroidAppLocators.getInstance().getCameraIcon(driver);
							element.click();
							element = AndroidAppLocators.getInstance().getTakeFromCameraOption(driver);
							element.click();
							Thread.sleep(4000);
							element = AndroidAppLocators.getInstance().getCameraView(driver);
							element.click();
							Thread.sleep(4000);
							element = AndroidAppLocators.getInstance().getApproveImageButton(driver);
							element.click();
							element = AndroidAppLocators.getInstance().getDoneButton(driver);
							element.click();
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									"Image clicked successfully from camera", "INFO",
									"Verifying Comment button on a card");
						}
						element = AndroidAppLocators.getInstance().getPostCommentButton(driver);
						Keywords.click(element);
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Comment successfully posted", "PASS", "Verifying Comment button on a card");
						element = AndroidAppLocators.getInstance().getBackButton(driver);
						element.click();
						newCommentCount = getCommentsCount(i);
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"New Comment count is " + newCommentCount, "INFO",
								"Verifying Comment button on a card");
						success = true;
					}
					cards.remove(0);
				}
				if (!success) {
					scrollDownFrame(driver);
					scrolls++;
				}
			} while (!success && scrolls < 5);

			if (success) {
				if (newCommentCount - oldCommentCount == 1) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Comment button on a card successfully verified", "PASS",
							"Verifying Comment button on a card");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Comment button on a card not successfully verified. Old Comments Count = "
									+ oldCommentCount + " and New Comments Count = " + newCommentCount,
							"FAIL", "Verifying Comment button on a card");
				}
			} else {
				if (scrolls == 5) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"No card for testing of comment button found", "INFO",
							"Verifying Comment button on a card");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"New comment could not be added successfully to test Comment button", "FAIL",
							"Verifying Comment button on a card");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying comment button on a card", "FAIL",
					"Verifying Comment button on a card");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private int getCommentsCount(int index) {
		try {
			element = AndroidAppLocators.getInstance().getLikesCount(driver, index);
			String commentCountText = element.getText();
			String[] splitArray = commentCountText.split(" ");
			if (splitArray.length == 4) {
				return Integer.valueOf(splitArray[2]);
			} else {
				if (splitArray[1].trim().toLowerCase().contains("comment")) {
					return Integer.valueOf(splitArray[0]);
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public void checkHamburgerIcon(String feedTitle) throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		Keywords.waitForPage(driver, 10);
		try {
			element = AndroidAppLocators.getInstance().getHamburgerIcon(driver);
			element.click();
			boolean feedsVerified = verifyFeeds(feedTitle);
			if (feedsVerified) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hamburger Icon successfully verified", "PASS", "Verifying Hamburger icon of the app");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Hamburger Icon not successfully verified", "FAIL", "Verifying Hamburger icon of the app");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Hamburger icon of the app. Possible cause is that Hamburger icon is not present in the app.",
					"FAIL", "Verifying Hamburger icon of the app");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean verifyFeeds(String feedTitle) {
		List<WebElement> feedTitlesElements = AndroidAppLocators.getInstance().getHamburgerFeeds(driver);
		if (!feedTitlesElements.isEmpty()) {
			ArrayList<String> feedTitles = getHamburgerFeedTitles(feedTitlesElements);
			if (feedTitles.contains(feedTitle) && feedTitles.contains("All #Feed Topics")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private ArrayList<String> getHamburgerFeedTitles(List<WebElement> feedTitlesElements) {
		ArrayList<String> feedTitles = new ArrayList<String>();
		for (WebElement element : feedTitlesElements) {
			feedTitles.add(element.getText());
		}
		return feedTitles;
	}

	public void clickLikeButton() {
		try {
			waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
			int scrollAttempt = 0;
			while (!isLikeButtonVisible() && scrollAttempt < 20) {
				scrollDownFrame(driver);
				scrollAttempt++;
			}
			element = AndroidAppLocators.getInstance().getSingleLikeButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Like button successfully clicked",
						"PASS", "Like button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button not successfully clicked", "FAIL", "Like button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking like button", "FAIL", "Like button should be clicked");
		}
	}

	private boolean isLikeButtonVisible() {
		try {
			Keywords.waitForPage(driver, 5);
			element = AndroidAppLocators.getInstance().getSingleLikeButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickCommentButton() {
		int scrollAttempt = 0;

		try {
			while (!isCommentButtonVisible() && scrollAttempt < 20) {
				scrollDownFrame(driver);
				scrollAttempt++;
			}
			element = AndroidAppLocators.getInstance().getCommentButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button successfully clicked", "PASS", "Comment button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button not successfully clicked", "FAIL", "Comment button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Comment button", "FAIL", "Comment button should be clicked");
		}
	}

	private boolean isCommentButtonVisible() {
		Keywords.waitForPage(driver, 5);
		try {
			element = AndroidAppLocators.getInstance().getCommentButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifySearchIconPlaceholderOnFeedScreen() {
		String expectedText = "Search Keyword or #Tag";
		try {
			clickSearchIcon();
			element = AndroidAppLocators.getInstance().getSearchButtonPlaceholderOnFeed(driver);
			String placeholder = element.getText();
			if (placeholder.equals(expectedText)) {
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Search placeholder successfully verified", "PASS",
							"Verifying search placeholder on feed screen");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search placeholder not successfully verified", "FAIL",
						"Verifying search placeholder on feed screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying on Search button placeholder", "FAIL",
					"Verifying search placeholder on feed screen");
		}
	}

	private void clickSearchIcon() {
		try {
			element = AndroidAppLocators.getInstance().getSearchIconButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search button found and clicked",
						"PASS", "Search Button should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search button not found", "FAIL",
						"Search Button should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on Search button", "FAIL", "Search Button should be present");
		}
	}

	public void verifyVoteButtonAlertOnNoOptionSelected() {
		int scrollAttempt = 0;
		try {
			while (!isVoteButtonVisible() && scrollAttempt < 20) {
				scrollDownFrame(driver);
				scrollAttempt++;
			}
			element = AndroidAppLocators.getInstance().getVoteButton(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getAlertMessage(driver);
			String actual = element.getText();
			String expectedTextVoteAlert = "please select any one option to vote.";
			if (actual.toLowerCase().trim().equals(expectedTextVoteAlert)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Vote alert successfully verified",
						"PASS", "Verifying alert message on clicking vote button with no option selected");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Vote alert not verified", "FAIL",
						"Verifying alert message on clicking vote button with no option selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying vote button alert", "FAIL",
					"Verifying alert message on clicking vote button with no option selected");
		}
	}

	private boolean isVoteButtonVisible() {
		Keywords.waitForPage(driver, 5);
		try {
			AndroidAppLocators.getInstance().getVoteButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	@SuppressWarnings("unchecked")
	public void checkPollsCard() {
		boolean success = false;
		By by = By.id("com.topfan.TopFan.TestApp:id/cardLayout");
		waitForLoaderToStop(by);
		methodRuns++;
		int attempts = 0;
		while (!isVoteButtonVisible() && attempts < 10) {
			scrollDownFrame(driver);
			attempts++;
		}
		if (isVoteButtonVisible()) {
			List<WebElement> pollsCardsFound = AndroidAppLocators.getInstance().getAllVoteButtons(driver);
			int i = 0;
			do {
				i++;
				int basicHeight = getBasicHeightFromTop();
				WebElement frame = AndroidAppLocators.getInstance().getFrame(driver);
				int frameHeight = frame.getSize().getHeight();
				int margin = 60;
				element = pollsCardsFound.get(0);
				int initialY = element.getLocation().getY();
				int finalY = basicHeight + frameHeight - margin;
//				((AppiumDriver<AndroidElement>) driver).swipe(100, initialY, 100, finalY, 4000);

				List<WebElement> elements = getOptionsOnPollCard(i);
				if (elements.size() > 1) {
					try {
						element = elements.get(0);
						Keywords.click(element);
						DriverSession.getLastExecutionReportingInstance().teststepreporting("First Option clicked",
								"INFO", "Verifying option on a Poll card can be changed before voting");
						element = elements.get(1);
						Keywords.click(element);
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Second Option clicked.Option successfully changed", "PASS",
								"Verifying option on a Poll card can be changed before voting");
						success = true;
					} catch (Exception e) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Options not successfully verified", "Fail",
								"Verifying option on a Poll card can be changed before voting");
						return;
					}
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Minimum two options not present so looking on other card", "INFO",
							"Minimun two options should come on a fresh card");
				}
				element = pollsCardsFound.get(0);
				pollsCardsFound.remove(0);
				if (!pollsCardsFound.isEmpty()) {
					//((AppiumDriver<AndroidElement>) driver).swipe(100, finalY, 100, initialY, 4000);
				} else {
					margin = 60;
					initialY = element.getLocation().getY();
					finalY = basicHeight - margin;
					//((AppiumDriver<AndroidElement>) driver).swipe(100, initialY, 100, finalY, 4000);
				}
			} while (!pollsCardsFound.isEmpty() && !success);
			if (!success) {
				if (methodRuns < 6) {
					checkPollsCard();
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							methodRuns + " trials have been done and no fresh poll card found with minimum two options",
							"INFO", "Finding a fresh poll card with miniumum two options");
				}
			}
		} else {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Enough scrolls have been done and no fresh poll found with a vote button", "INFO",
					"Finding a poll card with a vote button");
		}
	}

	public List<WebElement> getOptionsOnPollCard(int index) {
		Keywords.waitForPage(driver, 5);
		try {
			List<WebElement> elements = AndroidAppLocators.getInstance().getOptionsOnPollCard(driver, index);
			return elements;
		} catch (Exception e) {
			return null;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void findAValidQuizAndClickStartQuizButton() throws Exception {
		boolean success = false;
		int attempts = 0;
		By by = AndroidAppLocators.getInstance().getLocatorForACard();
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 10);
		try {
			do {
				quizIndex = 0;
				int scrollAttempt = 0;
				attempts++;
				while (!isStartQuizVisible() && scrollAttempt < 5) {
					scrollDownFrame(driver);
					scrollAttempt++;
				}
				if (isStartQuizVisible()) {
					List<WebElement> startQuizButtons = AndroidAppLocators.getInstance().getStartQuizButtons(driver);
					if (!startQuizButtons.isEmpty()) {
						do {
							quizIndex++;
							element = startQuizButtons.get(0);
							Keywords.click(element);
							if (!isBlankQuiz()) {
								success = true;
							} else {
								DriverSession.getLastExecutionReportingInstance().teststepreporting(
										"Blank Quiz encountered", "INFO",
										"Finding a valid quiz and clicking Start quiz button");
								driver.navigate().back();
							}
							startQuizButtons.remove(0);
							if (startQuizButtons.isEmpty() && !success) {
								scrollDownFrame(driver);
							}
						} while (!startQuizButtons.isEmpty());
					}
				}
			} while (!success && attempts < 6);

			if (!success) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Enough scrolls have been done but valid quiz not found", "FAIL",
						"Finding a valid quiz and clicking Start quiz button");
				quizIndex = -1;
				throw new Exception();
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Valid quiz has been found and Start Quiz button clicked", "PASS",
						"Finding a valid quiz and clicking Start quiz button");
			}
		} catch (Exception e) {
			if (!(quizIndex == -1)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Exception Occured...while verifying start quiz button alert", "FAIL",
						"Start quiz should click");
				quizIndex = -1;
			} else {
				throw e;
			}

		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isBlankQuiz() {
		Keywords.waitForPage(driver, 10);
		try {
			element = AndroidAppLocators.getInstance().getATextView(driver);
			return false;
		} catch (Exception e) {
			return true;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isStartQuizVisible() {
		Keywords.waitForPage(driver, 5);
		try {
			element = AndroidAppLocators.getInstance().getStartQuizButton(driver, 1);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void isQuestionScreen() {
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getQuestionScreen(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Question screen appear successfully",
					"PASS", "Question screen should appear");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Question screen did not appear ",
					"FAIL", "Question screen should appear");
		}
	}

	public void checkUserUnableToSelectSecondOption() {
		By by = AndroidAppLocators.getInstance().getLocatorOfQuestionScreen();
		waitForLoaderToStop(by);
		try {
			Keywords.waitForPage(driver, 20);
			WebElement firstOption = AndroidAppLocators.getInstance().getFirstOption(driver);
			Keywords.click(firstOption);
			WebElement secondOption = AndroidAppLocators.getInstance().getSecondOption(driver);
			String initialText = secondOption.getText();
			Keywords.click(secondOption);
			String finalText = secondOption.getText();
			if (finalText.equals(initialText)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Second option is not selectable",
						"PASS", "After selecting one option, User should not able to select second option");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Second option has been selected",
						"Fail", "After selecting one option, User should not able to select second option");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while verifying second answer selection", "Fail",
					"After selecting one option, User should not able to select second option");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyQuizResultScreen() throws Exception {
		try {
			Keywords.waitForPage(driver, 10);
			int questions = 0;
			boolean b = true;
			do {
				questions++;
				b = clickOneAnswerForOneQuestion();
				if (b) {
					clickNextButton();
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"On question " + questions + " no options were found", "FAIL",
							"Quiz result screen should appear");
					throw new Exception();
				}
			} while (!isQuizResultScreen() && questions < 6);
			if (!isQuizResultScreen()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						questions + " questions attempted yet quiz result screen not found", "FAIL",
						"Quiz result screen should appear");
			} else {
				element = AndroidAppLocators.getInstance().getQuizResultScreen(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Quiz result screen displayed successfully", "PASS", "Quiz result screen should appear");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while verifying Quiz result screen ", "FAIL",
					"Quiz result screen should appear");
			throw e;
		}
	}

	public boolean clickOneAnswerForOneQuestion() {
		By by = AndroidAppLocators.getInstance().getLocatorOfQuestionScreen();
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element = AndroidAppLocators.getInstance().getFirstOption(driver);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"First option has been selected successfully", "PASS",
					"Selecting the first option of the question");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Question has no options", "INFO",
					"Selecting the first option of the question");
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return true;
	}

	public void clickNextButton() {
		int attempt = 0;
		Keywords.waitForPage(driver, 10);
		try {
			while (!isNextButtonVisible() && attempt < 4) {
				scrollDownQuizScreen(driver);
				attempt++;
			}
			element = AndroidAppLocators.getInstance().getNextButton(driver);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Next Button clicked successfully",
					"PASS", "Next button should be clickable");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Next button not clicked", "FAIL",
					"Next button should be clickable");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isNextButtonVisible() {
		Keywords.waitForPage(driver, 10);
		try {
			element = AndroidAppLocators.getInstance().getNextButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isQuizResultScreen() {
		Keywords.waitForPage(driver, 20);
		try {
			AndroidAppLocators.getInstance().getQuizResultScreen(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickDoneQuizButton() {
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element = AndroidAppLocators.getInstance().getDoneQuizButton(driver);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Done button clicked successfully",
					"PASS", "Done button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking Done button", "INFO", "Done button should be clicked");
		}
	}

	public void checkQuizCompletedText() {
		By by = AndroidAppLocators.getInstance().getLocatorForACard();
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element = AndroidAppLocators.getInstance().getCompleteQuizButton(driver, quizIndex);
			String expectedCompletedText = "completed";
			String actualCompletedText = element.getText();
			if (actualCompletedText.toLowerCase().trim().equals(expectedCompletedText)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Completed text verified successfully", "PASS",
						"Start Quiz text on the button should change to Completed text");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Completed text not verified successfully", "Fail",
						"Start Quiz text on the button should change to Completed text");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured ...while verifying change of Start Quiz text on the button to Completed text on completing the quiz",
					"FAIL", "Start Quiz text on the button should change to Completed text");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void checkQuizCompletedAlertMessageText() {
		By by = AndroidAppLocators.getInstance().getLocatorForACard();
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			WebElement completeQuizButton = AndroidAppLocators.getInstance().getCompleteQuizButton(driver, quizIndex);
			Keywords.click(completeQuizButton);
			WebElement alertTextMessageElement = AndroidAppLocators.getInstance().getCompletedQuizAlertText(driver);
			String actualCompletedAlertText = alertTextMessageElement.getText();
			String expectedCompletedAlertText = "you have already completed this quiz.";
			if (actualCompletedAlertText.toLowerCase().trim().equals(expectedCompletedAlertText)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Completed alert message verified successfully", "PASS", "Alert message should appear");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Completed alert message not verified successfully", "FAIL", "Alert message should appear");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying complete quiz alert message", "FAIL",
					"Alert message should appear");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickTab(String tab) throws Exception {
		waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
		String title = null;
		switch (tab.toLowerCase().trim()) {
		case "videos":
			title = "Videos";
			break;
		case "audio":
			title = "Audio";
			break;
		case "articles":
			title = "Articles";
			break;
		case "challenges":
			title = "Challenges";
			break;
		case "product":
			title = "product";
			break;
		case "rewards":
			title = "Rewards";
			break;
		case "social":
			title = "Social";
			break;
		case "discussions":
			title = "Discussions";
			break;
		case "photos":
			title = "Photos";
			break;
		case "comic":
			title = "Comic";
			break;
		case "polls":
			title = "Polls";
			break;
		case "quizzes":
			title = "Quizzes";
			break;
		case "gif":
			title = "GIF";
			break;
		case "virtual reality":
			title = "Virtual Reality";
			break;
		default:
			break;
		}
		int scrollAttempts = 0;
		while (!isTabVisible(title) && scrollAttempts < 10) {
			Keywords.scrollRight(getOverlayVerticalCoordinate());
			scrollAttempts++;
		}
		try {
			element = AndroidAppLocators.getInstance().getTab(driver, title);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(tab + " tab clicked successfully",
						"PASS", tab + " tab should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						tab + " tab not clicked successfully", "FAIL", tab + " tab should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while clicking " + tab + " tab as it was not found", "FAIL",
					tab + " tab should be clicked");
			throw e;
		}

	}

	private boolean isTabVisible(String title) {
		Keywords.waitForPage(driver, 5);
		try {
			element = AndroidAppLocators.getInstance().getTab(driver, title);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyCardAccess(String cardType, String cardTitleFromCms) {
		Keywords.waitForPage(driver, 10);
		try {
			if (cardType.toLowerCase().trim().equals("videos")
					|| cardType.toLowerCase().trim().equals("virtual reality")) {
				waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForAMetaDataCard());
			} else {
				waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
			}

			boolean found = false;
			int scrollAttempts = 0;
			while (!found && scrollAttempts < 10) {
				List<WebElement> elements = null;
				if (cardType.toLowerCase().trim().equals("videos")
						|| cardType.toLowerCase().trim().equals("virtual reality")) {
					elements = AndroidAppLocators.getInstance().getAllMetaDataCards(driver);
				} else {
					elements = AndroidAppLocators.getInstance().getAllCards(driver);
				}

				int i;
				int size = elements.size();
				for (i = 1; i <= size; i++) {
					element = elements.get(0);
					String cardTitleFromApp;
					try {
						cardTitleFromApp = getCardTitle(cardType, i);
					} catch (Exception e) {
						cardTitleFromApp = null;
					}
					if (cardTitleFromApp != null) {
						if (cardTitleFromApp.toLowerCase().trim().equals(cardTitleFromCms.toLowerCase().trim())) {
							found = true;
							break;
						}
					}

					elements.remove(0);
				}
				if (found) {
					int basicHeight = getBasicHeightFromTop();
					int elementHeight = (element.getSize().getHeight()) / 2;
					int margin = 50;
					int x = (element.getSize().getWidth()) / 2;
					int initialY = element.getLocation().getY();
					int finalY = basicHeight + elementHeight + margin;
					//((AppiumDriver<AndroidElement>) driver).swipe(x, initialY, x, finalY, 1000);
					element = getMainElementOfCard(cardType, i);
					Keywords.click(element);
					try {
						element = AndroidAppLocators.getInstance().getAccessUnavailableMessage(driver);
						if (element.getText().toLowerCase().contains("you have not reached")) {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									"Alert dialog box appeared and access not available message successfully verified ",
									"PASS",
									"Verifying the alert message on clicking a card having a higher access level");
						} else {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									"Alert dialog box appeared but access not available message not successfully verified ",
									"FAIL",
									"Verifying the alert message on clicking a card having a higher access level");

						}
					} catch (Exception e) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Exception occured... as no alert dialog box appeared ", "FAIL",
								"Verifying the alert message on clicking a card having a higher access level");
					}
				} else {
					scrollDownFrame(driver);
					scrollAttempts++;
				}
			}
			if (!found) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						scrollAttempts + " scrolls done but card not found", "FAIL",
						"Verifying the alert message on clicking a card having a higher access level");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while verifying card access for a user", "FAIL",
					"Verifying the alert message on clicking a card having a higher access level");
		} finally {
			Keywords.waitForPage(driver, 60);
		}

	}

	private int getBasicHeightFromTop() {
		int totalHeight;
		element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
		int statusBarHeight = element.getSize().height;
		element = AndroidAppLocators.getInstance().getActionBar(driver);
		int actionBarHeight = element.getSize().height;
		totalHeight = statusBarHeight + actionBarHeight;
		return totalHeight;
	}

	private WebElement getMainElementOfCard(String cardType, int index) {
		switch (cardType.toLowerCase().trim()) {
		case "videos":
			try {
				element = AndroidAppLocators.getInstance().getMainElementOfVideoCard(driver, 1);
				element = AndroidAppLocators.getInstance().getMainElementOfVideoCard(driver, index);
			} catch (Exception e) {
				// element in catch to be updated
				element = AndroidAppLocators.getInstance().getMainElementOfMetadataVideoCard(driver, index);
			}
			break;
		case "audio":
			element = AndroidAppLocators.getInstance().getMainElementOfAudioCard(driver, index);
			break;
		case "articles":
			element = AndroidAppLocators.getInstance().getMainElementOfArticleCard(driver, index);
			break;
		case "challenges":
			element = AndroidAppLocators.getInstance().getMainElementOfChallengeCard(driver, index);
			break;
		case "product":
			element = AndroidAppLocators.getInstance().getMainElementOfProductCard(driver, index);
			break;
		case "rewards":
			element = AndroidAppLocators.getInstance().getMainElementOfRewardCard(driver, index);
			break;
		case "social":
			element = AndroidAppLocators.getInstance().getMainElementOfSocialCard(driver, index);
			break;
		case "discussions":
			element = AndroidAppLocators.getInstance().getMainElementOfDiscussionCard(driver, index);
			break;
		case "photos":
			element = AndroidAppLocators.getInstance().getMainElementOfPhotoCard(driver, index);
			break;
		case "comic":
			element = AndroidAppLocators.getInstance().getMainElementOfComicCard(driver, index);
			break;
		case "polls":
			element = AndroidAppLocators.getInstance().getMainElementOfPollCard(driver, index);
			break;
		case "quizzes":
			element = AndroidAppLocators.getInstance().getMainElementOfQuizCard(driver, index);
			break;
		case "gif":
			element = AndroidAppLocators.getInstance().getMainElementOfGifCard(driver, index);
			break;
		case "virtual reality":
			try {
				element = AndroidAppLocators.getInstance().getMainElementOfMetadataVRCard(driver, 1);
				element = AndroidAppLocators.getInstance().getMainElementOfMetadataVRCard(driver, index);
			} catch (Exception e) {
				element = AndroidAppLocators.getInstance().getMainElementOfVRCard(driver, index);
			}
			break;
		default:
			element = null;
			break;
		}
		return element;
	}

	private String getCardTitle(String cardType, int index) {
		switch (cardType.toLowerCase().trim()) {
		case "videos":
			try {
				element = AndroidAppLocators.getInstance().getMetadataVideoCardTitle(driver, 1);
				element = AndroidAppLocators.getInstance().getMetadataVideoCardTitle(driver, index);
			} catch (Exception e) {
				element = AndroidAppLocators.getInstance().getVideoCardTitle(driver, index);
			}
			break;
		case "audio":
			element = AndroidAppLocators.getInstance().getAudioCardTitle(driver, index);
			break;
		case "articles":
			element = AndroidAppLocators.getInstance().getArticleCardTitle(driver, index);
			break;
		case "challenges":
			element = AndroidAppLocators.getInstance().getChallengeCardTitle(driver, index);
			break;
		case "product":
			element = AndroidAppLocators.getInstance().getProductCardTitle(driver, index);
			break;
		case "rewards":
			element = AndroidAppLocators.getInstance().getRewardCardTitle(driver, index);
			break;
		case "social":
			element = AndroidAppLocators.getInstance().getSocialCardTitle(driver, index);
			break;
		case "discussions":
			element = AndroidAppLocators.getInstance().getDiscussionCardTitle(driver, index);
			break;
		case "photos":
			element = AndroidAppLocators.getInstance().getPhotoCardTitle(driver, index);
			break;
		case "comic":
			element = AndroidAppLocators.getInstance().getComicCardTitle(driver, index);
			break;
		case "polls":
			element = AndroidAppLocators.getInstance().getPollCardTitle(driver, index);
			break;
		case "quizzes":
			element = AndroidAppLocators.getInstance().getQuizCardTitle(driver, index);
			break;
		case "gif":
			element = AndroidAppLocators.getInstance().getGifCardTitle(driver, index);
			break;
		case "virtual reality":
			try {
				element = AndroidAppLocators.getInstance().getMetadataVRCardTitle(driver, 1);
				element = AndroidAppLocators.getInstance().getMetadataVRCardTitle(driver, index);
			} catch (Exception e) {
				element = AndroidAppLocators.getInstance().getVRCardTitle(driver, index);
			}
			break;
		default:
			element = null;
			break;
		}
		return element.getText();
	}

	public void clickTakeAnotherQuizScreenButton() {
		Keywords.waitForPage(driver, 20);
		int scrollCount = 0;
		try {
			while (!isTakeAnotherQuizButtonFound() && scrollCount < 4) {
				scrollDownFrame(driver);
				scrollCount++;
			}
			WebElement element = AndroidAppLocators.getInstance().getTakeAnotherQuizButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Take another quiz screen button successfully clicked", "PASS",
						"Take another quiz screen button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Take another quiz screen button not successfully clicked", "FAIL",
						"Take another quiz screen button should be clicked");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... as Take Another quiz screen button not found ", "FAIL",
					"Take another quiz screen button should be clicked");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isTakeAnotherQuizButtonFound() {
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getTakeAnotherQuizButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void checkQuizScreenOpen() {
		By by = AndroidAppLocators.getInstance().getLocatorForACard();
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getQuizzesButtonSelected(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User redirect to quizzes screen successfully", "PASS", "User should redirect to quizzes screen");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User unable to redirect to quiz screen ", "FAIL", "User should redirect to quizzes screen");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void checkQuizFinalScoreBoard() throws Exception {
		int sum = 0;
		int questions = 0;
		boolean a = true;
		Keywords.waitForPage(driver, 20);
		try {
			do {
				questions++;
				a = clickOneAnswerForOneQuestion();
				if (a) {
					boolean b = isCorrectAnswer();
					if (b) {
						int scrollAttempt = 0;
						while (!isSingleScoreVisible() && scrollAttempt < 6) {
							scrollDownQuizScreen(driver);
							scrollAttempt++;
						}
						WebElement element = AndroidAppLocators.getInstance().getScoreSigleQuestion(driver);
						String singleQuestionScore = element.getText();
						String[] str = singleQuestionScore.split(" ");
						String partA = str[0];
						int temp = Integer.valueOf(partA);
						sum += temp;
					}
					clickNextButton();
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"For Question " + questions + " no options were found", "FAIL",
							"User should be able to see the his correct final score");
					throw new Exception();
				}
			} while (!isQuizResultScreen() && questions < 7);

			if (isQuizResultScreen()) {
				int scrolls = 0;
				while (!isQuizFinalScoreVisible() && scrolls < 4) {
					scrollDownQuizScreen(driver);
					scrolls++;
				}
				WebElement quizResultScore = AndroidAppLocators.getInstance().getFinalScoreQuiz(driver);
				String scoreFinal = quizResultScore.getText();
				String[] str1 = scoreFinal.split(" ");
				String partFirst = str1[0];
				int finalScore = Integer.valueOf(partFirst);
				if (finalScore == sum) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Quiz score calculation is successfuly validated", "PASS",
							"User should be able to see the his correct final score");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Quiz score calculation is not successfuly validated", "FAIL",
							"User should be able to see the correct result as final score");
				}
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						questions + " questions have been attempted yet quiz result screen hasn't come", "INFO",
						"User should be able to see the correct result as final score");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while calculating the final score of quiz", "FAIL",
					"User should able to see the correct result as final score");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isQuizFinalScoreVisible() {
		Keywords.waitForPage(driver, 10);
		try {
			WebElement quizResultScore = AndroidAppLocators.getInstance().getFinalScoreQuiz(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isCorrectAnswer() {
		Keywords.waitForPage(driver, 20);
		try {
			WebElement element1 = AndroidAppLocators.getInstance().getAnswerResult(driver);
			String result = element1.getText();
			String expectedResult = "correct answer!";
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"After clicking an option, text on the option should change", "INFO",
					"After clicking an option, text on the option should change");
			if (result.trim().toLowerCase().equals(expectedResult)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	private boolean isSingleScoreVisible() {
		try {
			element = AndroidAppLocators.getInstance().getScoreSigleQuestion(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int finishQuizAndGetScore() throws Exception {
		Keywords.waitForPage(driver, 20);
		int quizScore = -1;
		try {
			int questions = 0;
			do {
				questions++;
				boolean b = clickOneAnswerForOneQuestion();
				if (b) {
					clickNextButton();
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"On question " + questions + " options were not present", "FAIL",
							"User should able to complete the quiz and get quiz score");
					throw new Exception();
				}
			} while (!isQuizResultScreen() && questions < 7);
			if (isQuizResultScreen()) {
				int scrolls = 0;
				while (!isQuizFinalScoreVisible() && scrolls < 4) {
					scrollDownQuizScreen(driver);
					scrolls++;
				}
				WebElement element1 = AndroidAppLocators.getInstance().getFinalScoreQuiz(driver);
				String scoreFinal = element1.getText();
				String[] str1 = scoreFinal.split(" ");
				String partFirst = str1[0];
				quizScore = Integer.valueOf(partFirst);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Quiz successfully completed and quiz score is " + quizScore, "PASS",
						"User should able to complete the quiz and get quiz score");
				clickDoneQuizButton();
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						questions + " questions have been attempted yet the quiz result screen didn't come", "INFO",
						"User should able to complete the quiz and get quiz score");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while completing the quiz", "FAIL",
					"User should able to complete the quiz and get quiz score");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return quizScore;
	}

	public void clickPollsOption() {
		By by = AndroidAppLocators.getInstance().getLocatorForACard();
		waitForLoaderToStop(by);
		int scrollAttempt = 0;
		try {
			while (!isPollsOptionVisible() && scrollAttempt < 5) {
				scrollDownFrame(driver);
				scrollAttempt++;
			}
			element = AndroidAppLocators.getInstance().getPollsOption(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("polls option found and clicked",
						"PASS", "Polls option Button should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("polls option not found", "FAIL",
						"Polls option Button should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on polls option", "FAIL",
					"Polls option Button should be present");
		}
	}

	private boolean isPollsOptionVisible() {
		Keywords.waitForPage(driver, 5);
		try {
			AndroidAppLocators.getInstance().getPollsOption(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickStartQuizButton() {
		Keywords.waitForPage(driver, 10);
		int scrollAttempt = 0;
		try {
			while (!isStartQuizVisible() && scrollAttempt < 10) {
				scrollDownFrame(driver);
				scrollAttempt++;
			}
			if (isStartQuizVisible()) {
				element = AndroidAppLocators.getInstance().getStartQuizButton(driver, 1);
				Keywords.click(element);
				if (DriverSession.getStepResult()) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Start Quiz button found and clicked", "PASS", "Finding and clicking a Start Quiz button");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Start Quiz button found but could not be clicked", "FAIL",
							"Finding and clicking a Start Quiz button");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while finding and clicking a Start Quiz button", "FAIL",
					"Finding and clicking a Start Quiz button");
		} finally {

		}
	}

	public void clickCommentEditText() {
		try {
			element = AndroidAppLocators.getInstance().getCommentEditText(driver);
			element.click();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Edit Text of Comment screen successfully clicked", "PASS",
					"Clicking on edit text of Comment screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Edit Text of Comment screen not successfully clicked", "FAIL",
					"Clicking on edit text of Comment screen");
		}
	}

	public void verifyPhotoLockedState(boolean lockState) {
		try {
			int attempt = 0;
			do {
				try {
					Keywords.waitForPage(driver, 5);
					AndroidAppLocators.getInstance().getUnlockTextPhotoCard(driver);
					scrollDownFrame(driver);
				} catch (Exception e) {
					element = AndroidAppLocators.getInstance().getPhotoCardFromFeed(driver);
					Keywords.click(element);
					try {
						element = AndroidAppLocators.getInstance().getPhotosCoinAccessPopUp(driver);
						Keywords.click(element);
						scrollDownFrame(driver);
					} catch (Exception e2) {
						break;
					}
					continue;
				}
				attempt++;
			} while (attempt < 10);
			if (lockState) {
				try {
					element = AndroidAppLocators.getInstance().getPhotoCardFromFeed(driver);
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Image appears as before",
							"PASS", "Image should remain as is after click");
				} catch (Exception e) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Image changed after click",
							"FAIL", "Image should remain as is after click");
				}
			} else {
				try {
					element = AndroidAppLocators.getInstance().getZoomedImage(driver);
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Zommed image Opened", "PASS",
							"Zoomed Image should launch");
				} catch (Exception e) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Zommed image isn't launched",
							"FAIL", "Zoomed Image should launch");
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyVoteButtonIsClickable() throws Exception {
		Keywords.waitForPage(driver, 10);
		try {
			int scrollAttempts = 0;
			while (!isVoteButtonVisible() && scrollAttempts < 5) {
				scrollDownFrame(driver);
				scrollAttempts++;
			}
			;
			if (isVoteButtonVisible()) {
				int basicHeight = getBasicHeightFromTop();
				WebElement frame = AndroidAppLocators.getInstance().getFrame(driver);
				int frameHeight = frame.getSize().getHeight();
				int margin = 60;
				element = AndroidAppLocators.getInstance().getVoteButton(driver);
				int initialY = element.getLocation().getY();
				int finalY = basicHeight + frameHeight - margin;
				//((AppiumDriver<AndroidElement>) driver).swipe(100, initialY, 100, finalY, 4000);

				List<WebElement> freshPollsCardsFound = AndroidAppLocators.getInstance().getAllVoteButtons(driver);
				List<WebElement> initialUsedPollsCardsFound = AndroidAppLocators.getInstance()
						.getAllVotedButtons(driver);
				List<WebElement> elements = getOptionsOnPollCard(freshPollsCardsFound.size());
				Keywords.click(elements.get(0));
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Option clicked", "INFO",
						"Verifying vote button is clickable");
				element = freshPollsCardsFound.get(freshPollsCardsFound.size() - 1);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Vote button clicked", "INFO",
						"Verifying vote button is clickable");
				List<WebElement> finalUsedPollsCardsFound = AndroidAppLocators.getInstance().getAllVotedButtons(driver);
				if (finalUsedPollsCardsFound.size() - initialUsedPollsCardsFound.size() == 1) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Vote button text changed to "
									+ finalUsedPollsCardsFound.get(finalUsedPollsCardsFound.size() - 1).getText(),
							"PASS", "Verifying vote button is clickable");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting("Vote button text not changed",
							"FAIL", "Verifying vote button is clickable");
				}
				List<WebElement> progressBarsOfAUsedCard = AndroidAppLocators.getInstance()
						.getProgressBarsOfAUsedPollCard(driver, finalUsedPollsCardsFound.size());
				if (progressBarsOfAUsedCard.size() > 0) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Polls Result does get reflected on the card", "PASS",
							"Verifying vote button is clickable");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Polls Result does not get reflected on the card", "FAIL",
							"Verifying vote button is clickable");
				}
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("No Polls card found", "FAIL",
						"Verifying vote button is clickable");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Vote button is clickable", "FAIL",
					"Verifying vote button is clickable");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	@SuppressWarnings("unchecked")
	public int completePollAndGetReward() throws Exception {
		int rewardEarned = 0;
		Keywords.waitForPage(driver, 10);
		try {
			int scrollAttempts = 0;
			while (!isVoteButtonVisible() && scrollAttempts < 5) {
				scrollDownFrame(driver);
				scrollAttempts++;
			}
			;
			if (isVoteButtonVisible()) {
				int basicHeight = getBasicHeightFromTop();
				WebElement frame = AndroidAppLocators.getInstance().getFrame(driver);
				int frameHeight = frame.getSize().getHeight();
				int margin = 60;
				element = AndroidAppLocators.getInstance().getVoteButton(driver);
				int initialY = element.getLocation().getY();
				int finalY = basicHeight + frameHeight - margin;
				//((AppiumDriver<AndroidElement>) driver).swipe(100, initialY, 100, finalY, 4000);

				List<WebElement> freshPollsCardsFound = AndroidAppLocators.getInstance().getAllVoteButtons(driver);
				List<WebElement> elements = getOptionsOnPollCard(freshPollsCardsFound.size());
				Keywords.click(elements.get(0));
				element = freshPollsCardsFound.get(freshPollsCardsFound.size() - 1);
				Keywords.click(element);
				By by = AndroidAppLocators.getInstance().getLocatorForACard();
				waitForLoaderToStop(by);
				List<WebElement> usedPollsCardsFound = AndroidAppLocators.getInstance().getAllVotedButtons(driver);
				element = AndroidAppLocators.getInstance().getRewardEarnedOnCompletingPoll(driver,
						usedPollsCardsFound.size());
				rewardEarned = getRewardValueOnCompletingPoll(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Reward earned is " + rewardEarned,
						"INFO", "Completing Poll and getting coins earned");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("No Polls card found", "FAIL",
						"Completing Poll and getting coins earned");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while completing poll and getting coins earned", "FAIL",
					"Completing Poll and getting coins earned");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return rewardEarned;
	}

	private int getRewardValueOnCompletingPoll(WebElement element) {
		int coinsEarned = 0;
		try {
			String s = element.getText().trim();
			s = s.split(" ")[2];
			coinsEarned = Integer.valueOf(s);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while getting reward value", "FAIL", "Getting reward value");
		}
		return coinsEarned;
	}

	@SuppressWarnings("unchecked")
	public void findCardAndClickItsAvatar(String cardTitle, String feedTitle) {
		try {
			boolean scrollRequired = true;
			boolean found = false;
			ArrayList<String> allTextViewElements = new ArrayList<String>();
			waitForLoaderToStop(AndroidAppLocators.getInstance().getLocatorForACard());
			while (scrollRequired) {
				List<WebElement> elementsBeforeScroll = AndroidAppLocators.getInstance().getAllTextViews(driver);
				for (WebElement element : elementsBeforeScroll) {
					allTextViewElements.add(element.getText());
				}
				allTextViewElements.removeAll(Arrays.asList("", " "));
				allTextViewElements = new ArrayList<String>(new LinkedHashSet<String>(allTextViewElements));
				if (allTextViewElements.contains(cardTitle) || allTextViewElements.size() > 300) {
					scrollRequired = false;
					if (allTextViewElements.contains(cardTitle)) {
						found = true;
						DriverSession.getLastExecutionReportingInstance().teststepreporting("Card Found", "PASS",
								"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
					} else {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Card not Found.Approximately Cards Scrolled are " + allTextViewElements.size() / 2,
								"FAIL",
								"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
					}
				} else {
					scrollDownFrame(driver);
					List<WebElement> elementsAfterScroll = AndroidAppLocators.getInstance().getAllTextViews(driver);
					if (elementsAfterScroll.equals(elementsBeforeScroll)) {
						scrollRequired = false;
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Card not Found. End of page reached", "FAIL",
								"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
					}
				}

			}
			;

			if (found) {
				int basicHeight = getBasicHeightFromTop();
				WebElement frame = AndroidAppLocators.getInstance().getFrame(driver);
				int frameHeight = frame.getSize().getHeight();
				int margin = 60;
				List<WebElement> elements = AndroidAppLocators.getInstance().getAllChallengeCardTitles(driver);
				for (WebElement element : elements) {
					if (element.getText().trim().equals(cardTitle.trim())) {
						this.element = element;
						break;
					}
				}
				int initialY = element.getLocation().getY();
				int finalY = basicHeight + frameHeight - margin;
				//((AppiumDriver<AndroidElement>) driver).swipe(200, initialY, 200, finalY, 4000);

				List<WebElement> feedTitlesElements = AndroidAppLocators.getInstance().getAllFeedTitles(driver);
				int index = 0;
				for (WebElement element : feedTitlesElements) {
					index++;
					if (element.getText().trim().equals(feedTitle.trim())) {
						break;
					}
				}

				element = AndroidAppLocators.getInstance().getFeedAvatar(driver, index);
				Keywords.click(element);
				if (DriverSession.getStepResult()) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Avatar of the created Challenge Card successfully clicked", "PASS",
							"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Avatar of the created Challenge Card not successfully clicked", "FAIL",
							"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while finding the created challenge card that has been linked to our feed topic and clicking on its Avatar",
					"FAIL",
					"Finding created Challenge card which has been linked to our FeedTopic and clicking on its Avatar");
		}
	}

	public void verifyCreatedFeedTopicOpens(String feedTitle) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getConversationScreen(driver);
			String headingText = element.getText().trim();
			if (headingText.equals(feedTitle.trim())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("The created Feed topic has opened",
						"PASS", "Verifying created feed topic opens");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"The created Feed topic did not open", "FAIL", "Verifying created feed topic opens");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while verifying created feed topic is opened", "FAIL",
					"Verifying created feed topic opens");
			throw e;
		}
	}

	public void verifyCreatedCardIsPresentInFeedTopic(String cardTitle) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getChallengeCardTitle(driver, 1);
			String titleText = element.getText();
			if (titleText.equals(cardTitle)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"The created Card is present in feed topic", "PASS",
						"Verifying created card is present in feed topic");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"The created Card is not present in feed topic", "FAIL",
						"Verifying created card is present in feed topic");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while verifying the created Card is present in feed topic", "FAIL",
					"Verifying created card is present in feed topic");
		}
	}
}
