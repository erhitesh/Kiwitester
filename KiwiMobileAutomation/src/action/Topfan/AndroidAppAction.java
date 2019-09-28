package action.Topfan;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import Topfan.AccessLevel;
import Topfan.CMS;
import Topfan.Android.ActivityScreen;
import Topfan.Android.AndroidAppLocators;
import Topfan.Android.CommonFeatures;
import Topfan.Android.FeedScreen;
import Topfan.Android.ForumScreen;
import Topfan.Android.HomeScreen;
import Topfan.Android.LoginScreen;
import Topfan.Android.ProfileScreen;
import Topfan.Android.RegistrationScreen;
import Topfan.Android.SignInScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAppAction extends CommonAppAction {

	public WebElement element;
	public AppiumDriver<MobileElement> driver;
	private String email, username;

	public AndroidAppAction(AppiumDriver<MobileElement> lastExecutionDriver) {
		super(lastExecutionDriver);
		driver = lastExecutionDriver;
	}

	public void verifyMandatoryFields() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - REGISTRATION WITHOUT A MANDATORY FILED</b>");
			LoginScreen loginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			RegistrationScreen registrationScreen = new RegistrationScreen(DriverSession.getLastExecutionDriver());
			DriverSession.setReporting(false);
			logOut();
			DriverSession.setReporting(true);
			loginScreen.clickRegisterButton();
			//registrationScreen.enterUsername();
			//registrationScreen.selectBirthdate("2000", "12", "27");
			//registrationScreen.selectGender("Male");
			registrationScreen.enterPassword("kiwitech");
			registrationScreen.enterLocation("Noida");
			registrationScreen.selectSignupRelatedCheckbox();
			registrationScreen.clickGetStartedButton();
			registrationScreen.verifyErrorMessageForRequiredFields();
			//registrationScreen.verifyEmailAlertMessage();
			killApp();
			relaunchApp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying mandatory fields for registration", "FAIL",
					"Verifying mandatory fields for registration");
			throw e;
		}
	}

	public void registerWithLowerAge() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - REGISTRATION WITH A LOWER AGE</b>");
			LoginScreen loginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			RegistrationScreen registerationScreen = new RegistrationScreen(DriverSession.getLastExecutionDriver());
			loginScreen.clickRegisterButton();
			registerationScreen.enterUserFName();
			registerationScreen.enterUserLName();
			registerationScreen.enterUsername();
			registerationScreen.enterPassword("kiwitech");
			registerationScreen.enterEmail();
			registerationScreen.enterLocation("Noida");
			
//			registerationScreen.selectGender("Male");
			registerationScreen.selectBirthdate("2014", "Dec", "27");
			registerationScreen.selectSignupRelatedCheckbox();
			registerationScreen.clickGetStartedButton();
			registerationScreen.verifyErrorMessageForRequiredFields();
			killApp();
			relaunchApp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying minimum age for registration", "FAIL",
					"Verifying minimum age for registration");
			throw e;
		}
	}

	public void registerUserWithAllMandatoryFields() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - REGISTRATION WITH ALL MANDATORY FILEDS</b>");
			LoginScreen loginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			RegistrationScreen registrationScreen = new RegistrationScreen(DriverSession.getLastExecutionDriver());
			DriverSession.setReporting(false);
			logOut();
			DriverSession.setReporting(true);
			loginScreen.clickRegisterButton();
			String user = "Topfan" + Keywords.getRandomData();
			email = registrationScreen.fillFormAndSend(user);
			killApp();
			relaunchApp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying successful registration in filling all mandatory fields",
					"FAIL", "Verifying successful registration in filling all mandatory fields");
			throw e;
		}
	}

	public void verifyUserRegisterd() {
		HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
		home.verifyFreshUserLogIn();
	}

	public void registerUserWithAllowedAge() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - REGISTRATION WITH ALLOWED AGE</b>");
			LoginScreen loginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			RegistrationScreen registrationScreen = new RegistrationScreen(DriverSession.getLastExecutionDriver());
			loginScreen.clickRegisterButton();
			username = "Topfan" + Keywords.getRandomData();
			email = registrationScreen.fillFormAndSend(username);
			writeUserData(email);
			killApp();
			relaunchApp();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying successful registration with allowed age", "FAIL",
					"Verifying successful registration in filling all mandatory fields");
			throw e;
		}
	}

	public void verifyForgotPasswordFeature() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - VERIFY FORGOT PASSWORD FEATURE</b>");
			DriverSession.setReporting(false);
			//logOut();
			DriverSession.setReporting(true);
			LoginScreen loginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			SignInScreen signInScreen = new SignInScreen(DriverSession.getLastExecutionDriver());
			loginScreen.clickLoginButton();
			signInScreen.clickForgotPasswordLink();
			Thread.sleep(5000L);
			signInScreen.enterEmailOnWebView(email);

			driver.closeApp();
			String password = topfanChangePassword(email);
			driver.launchApp();

			LoginScreen newLoginScreen = new LoginScreen(DriverSession.getLastExecutionDriver());
			SignInScreen newSignInScreen = new SignInScreen(DriverSession.getLastExecutionDriver(), email, password);
			newLoginScreen.clickLoginButton();
			newSignInScreen.fillDetatilsAndSend();
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifyHomePageOpened();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying forgot password feature", "FAIL",
					"Verifying forgot password feature of app");
		}
	}

	public void verifyFeedSection() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY FEED SECTION ON HOME SCREEN</b>");
			killApp();
			String feedID = launchAndAddFeed();
			relaunchApp();
			verifyAddedFeed();
			deleteAddedFeed(feedID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddedFeed() throws Exception {
		logIn();
		HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
		home.verifyFeedSection(cms.feedTitle);
	}

	public void logOut() throws Exception {
		try {
			CommonFeatures cf = new CommonFeatures(driver);
			HomeScreen hs = new HomeScreen(driver);
			if (hs.isGuestUser() || checkLoggedInState() || cf.checkBackButton(driver)) {
				logoutFromApp();
			}
			killApp();
			relaunchApp();
		} catch (Exception e) {
			throw e;
		}
	}

	public void logIn() throws Exception {
		String userName = DriverSession.getTestCaseData().get("Username");
		String password = DriverSession.getTestCaseData().get("Password");
		logIn(userName, password);
	}

	public void logIn(String localUsername, String password) throws Exception {
		if (!checkLoggedInState()) {
			LoginScreen logIn = new LoginScreen(DriverSession.getLastExecutionDriver());
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			if (hs.isGuestUser()) {
				hs.clickLoginButton();
			} else {
				logIn.clickLoginButton();
			}
			SignInScreen signIn = new SignInScreen(DriverSession.getLastExecutionDriver());
			signIn.enterEmail(localUsername);
			signIn.enterPassword(password);
			signIn.clickLoginButton();
		}
	}

	public boolean checkLoggedInState() throws Exception {
		try {
			HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
			return home.checkLoggedInState();
		} catch (Exception e) {
			return false;
		}
	}

	public void verifyCardsInCarousel(int count) throws Exception {
		try {
			HomeScreen home = new HomeScreen(driver);
			Set<String> titles = home.getTitleOfCurrentCard(count);
			Boolean flag = true;
			for (String cardType : CMS.allCardDetails.keySet()) {
				String cardTitle = CMS.allCardDetails.get(cardType).get("title");
				if (!titles.contains(cardTitle)) {
					flag = false;
					DriverSession.getLastExecutionReportingInstance().teststepreportingWithoutSnapShot(
							cardTitle + " of " + cardType + " does not appear on screen", "FAIL",
							cardTitle + " of " + cardType + " should appear in carousel");
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreportingWithoutSnapShot(
							cardTitle + " of " + cardType + " appears on screen", "PASS",
							cardTitle + " of " + cardType + " should appear in carousel");
				}
			}
			if (flag) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"All types of cards appear inside carousel", "PASS",
						"All types of cards should appear in carousel");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"All types of cards do not appear inside carousel", "FAIL",
						"All types of cards should appear in carousel");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying cards in carousel", "FAIL",
					"All types of cards should appear in carousel");
			throw e;
		}
	}

	public void logoutFromApp() throws Exception {
		try {
			try {
				Keywords.waitForPage(driver, 10);
				element = AndroidAppLocators.getInstance().getEllipsisSettingsIcon(driver);
			} catch (Exception e) {
				element = AndroidAppLocators.getInstance().getBackButton(driver);
				Keywords.click(element);
				element = AndroidAppLocators.getInstance().getEllipsisSettingsIcon(driver);
			} finally {
				Keywords.waitForPage(driver, 60);
			}
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getSettingsLink(driver);
			Keywords.click(element);
//			Keywords.a_Driver.get().scrollToExact("Logout");
			element = AndroidAppLocators.getInstance().getLogoutLink(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getLogoutOKButton(driver);
			Keywords.click(element);
		} catch (Exception e) {
			throw e;
		}
	}

	public void verifyCarousel() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - VERIFY CARDS ON CAROUSEL</b>");
			killApp();
			int cardCount = addCardsInCarousel();
			relaunchApp();
			logIn();
			verifyCardsInCarousel(cardCount);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			destoryAllCardAndClose();
		}
	}

	public void verifyCTASection() throws Exception {
		try {
			killApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY CTA SECTION ON HOME SCREEN</b>");
			for (int row = 1; row <= 4; ++row) {
				addCTACard(row);
				relaunchApp();
				logIn();
				verifyCTACard(row);
				killApp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void verifyCTACard(int row) throws Exception {
		HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
		screen.verifyCTASection(row, cms.CTACards);
	}

	public void verifyStatusBar() throws Exception {
		try {
			cms.navigateToEditHomeScreen();
			cms.activateStatusBar();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFY PRESENCE OF STATUS BAR</b>");
			relaunchApp();
			DriverSession.setReporting(false);
			logOut();
			LoginScreen ls = new LoginScreen(DriverSession.getLastExecutionDriver());
			ls.clickSkipForNow();
			DriverSession.setReporting(true);
			HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
			screen.verifyStatusBarFor(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - VERIFY ABSENCE OF STATUS BAR</b>");
			DriverSession.setReporting(false);
			screen.clickProfileMenu();
			logIn();
			DriverSession.setReporting(true);
			screen.verifyStatusBarFor(false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cms.closeCMS();
		}
	}

	public void verifyCarouselSequence() throws Exception {
		try {
			launchCMS();
			ArrayList<String> sequenceOnCms = new ArrayList<String>();
			int cardsCount = cms.getCarouselCardsCount();
			sequenceOnCms = cms.getCarouselSequence();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - VERIFY SEQUENCE OF CARDS ON CAROUSEL</b>");
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			ArrayList<String> sequenceOnApp = new ArrayList<String>(hs.getTitleOfCurrentCard(cardsCount));
			boolean b = compareTwoSequences(sequenceOnCms, sequenceOnApp);
			if (b) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sequence on App matched Sequence on CMS", "PASS",
						"Sequence on App should match Sequence on CMS");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Sequence on App did not match Sequence on CMS", "FAIL",
						"Sequence on App should match Sequence on CMS");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Sequence of cards on App and CMS", "FAIL",
					"Sequence on App should match Sequence on CMS");
			throw e;
		} finally {
			cms.closeCMS();
		}

	}

	private boolean compareTwoSequences(ArrayList<String> sequenceOnCms, ArrayList<String> sequenceOnApp) {
		try {
			for (int i = 0; i < sequenceOnCms.size(); i++) {
				if (i <= sequenceOnApp.size()) {
					String temp = sequenceOnCms.get(i);
					String[] splitStrings = temp.split(":");
					temp = splitStrings[1];
					for (int j = 2; j < splitStrings.length; j++) {
						temp = temp + ":" + splitStrings[j];
					}
					if (!temp.trim().equals(sequenceOnApp.get(i).trim())) {
						sequenceOnCms.remove(i--);
					} else {
						sequenceOnCms.remove(i);
						sequenceOnCms.add(i, temp.trim());
					}
				} else {
					break;
				}
			}
			if (sequenceOnApp.equals(sequenceOnCms)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void verifyFeedCardSequence(int feedCount) throws Exception {
		String[] feedIDs = null;
		try {
			cms.showMainFeed(false);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
					"<b>TESTCASE 7 - VERIFY SEQUENCE OF FEEDS ON HOME SCREEN</b>");
			feedIDs = cms.addFeedTopics(feedCount);
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.verifyFeedsSequence(feedCount, cms);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Feed sequence on CMS with that on App", "FAIL",
					"Verifying sequence of feeds on CMS with that on App");
			throw e;
		} finally {
			cms.reverseFeedChanges();
			if (feedIDs != null) {
				for (int i = 0; i < feedCount; i++) {
					cms.deleteFeed(feedIDs[i]);
				}
			}
			cms.closeCMS();
		}
	}

	public void verifyAllCardTypesUnderAllTab(boolean metadataEnabled) throws Exception {
		try {
			killApp();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY ALL TYPES OF CARDS UNDER ALL TAB</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			ArrayList<String> cardTypes = fs.getCardTypes(13);
			fs.clickHomeButton();
			hs.clickFeedButton();
			ArrayList<String> cardTitles = fs.getFirstCardOfEachType(cardTypes, metadataEnabled);
			fs.clickHomeButton();
			hs.clickFeedButton();
			fs.checkAllCardTypesUnderAllTab(cardTitles, cardTypes);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Card Types under All Tab", "FAIL",
					"Verifying cards of all types under All Tab");
			throw e;
		}
	}

	public void verifyCTAButtonOnArticleCard() throws Exception {
		try {
			killApp();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY CTA BUTTON ON AN ARTICLE CARD</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			fs.clickTab("articles");
			fs.verifyCtaButtonOnArticle();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying CTA button on an article", "FAIL",
					"Verifying CTA button on an article");
			throw e;
		}
	}

	public void verifyLikeButtonOnCard() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFY LIKE BUTTON ON CARD</b>");
			logOut();
			registerUserWithAllowedAge();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			fs.clickLikeButtonAndVerifyLikeCount();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Like button on a card", "FAIL",
					"Verifying Like button on a card");
			throw e;
		}
	}

	public void verifyCommentButtonOnCard(boolean b) throws Exception {
		try {
			killApp();
			relaunchApp();
			if (b) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
						"<b>TESTCASE 2 - VERIFY COMMENT BUTTON ON A CARD WITH IMAGE</b>");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
						"<b>TESTCASE 1 - VERIFY COMMENT BUTTON ON A CARD</b>");
			}
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			fs.addCommentAndVerifyCommentsCount(b);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Comment button on a card", "FAIL",
					"Verifying Comment button on a card");
			throw e;
		}
	}

	public void verifyHamburgerIcon() throws Exception {
		try {
			launchCMS();
			cms.showMainFeed(true);
			String feedTitle = cms.enableFeedTopic(true);
			cms.showHamburgerIcon(true, false);
			killApp();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
					"<b>TESTCASE 5 - VERIFY HAMBURGER ICON ON FEED SCREEN</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			fs.checkHamburgerIcon(feedTitle);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Hamburger icon", "FAIL",
					"Verifying Hamburger icon on feed screen");
			throw e;
		} finally {
			cms.reverseMainFeedState();
			cms.reverseTempFeedState();
			cms.reverseHamburgerIconState();
			cms.closeCMS();
		}
	}

	public void verifyCardAccessRestriction(String cardType) throws Exception {
		try {
			launchCMS();
			String cardTitle = cms.setCardAccess(cardType, AccessLevel.Gold, false);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 6 STARTED</b>", "INFO",
					"<b>TESTCASE 6 - VERIFY RESTRICTION TO ACCESS OF " + cardType.toUpperCase()
							+ " CARD WITH HIGHER STATUS LEVEL</b>");
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen fs = new FeedScreen(driver);
			fs.clickTab(cardType);
			fs.verifyCardAccess(cardType, cardTitle);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying card access restriction", "FAIL",
					"Verifying card access restriction on feed screen");
			throw e;
		} finally {
			cms.setCardAccess(cardType, AccessLevel.Gold, true);
			cms.closeCMS();
		}
	}

	public void verifyLikeRestrictionForGuestUser() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
				"<b>TESTCASE 7 - VERIFY LIKE BUTTON RESTRICTION FOR GUEST USER</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickLikeButton();
		lgn.isLoginScreen();
	}

	public void verifyCommentRestrictionForGuestUser() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 8 STARTED</b>", "INFO",
				"<b>TESTCASE 8 - VERIFY COMMENT BUTTON RESTRICTION FOR GUEST USER</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickCommentButton();
		lgn.isLoginScreen();
	}

	public void verifySearchIconPlaceholderOnFeedScreen() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 9 STARTED</b>", "INFO",
				"<b>TESTCASE 9 - VERIFY SEARCH ICON PLACEHOLDER ON FEED SCREEN</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.verifySearchIconPlaceholderOnFeedScreen();
	}

	public void verifyAlertMessageOnVotingWithoutSelectingOption() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 10 STARTED</b>", "INFO",
				"<b>TESTCASE 10 - VERIFY ALERT MESSAGE ON VOTING ON A POLL CARD WITHOUT ANY OPTION SELECTED</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("polls");
		fedscrn.verifyVoteButtonAlertOnNoOptionSelected();
	}

	public void verifySelectionOptionBeforeVote() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 11 STARTED</b>", "INFO",
				"<b>TESTCASE 11 - VERIFY SELECTION OPTION ON A POLL CARD</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("polls");
		fedscrn.checkPollsCard();
	}

	public void verifyQuizRestrictionForGuestUser() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 12 STARTED</b>", "INFO",
				"<b>TESTCASE 12 - VERIFY QUIZ RESTRICTION FOR GUEST USER</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.clickStartQuizButton();
		lgn.isLoginScreen();
	}

	public void verifyQuestionScreenOnStartQuizClick() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 13 STARTED</b>", "INFO",
				"<b>TESTCASE 13 - VERIFY QUESTION SCREEN ON CLICKING START QUIZ BUTTON ON A QUIZ</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.isQuestionScreen();
	}

	public void verifyOneAnswerForOneQuestion() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 14 STARTED</b>", "INFO",
				"<b>TESTCASE 14 - VERIFY THAT ONLY ONE OPTION CAN BE SELECTED FOR A QUESTION ON QUIZ</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.checkUserUnableToSelectSecondOption();
	}

	public void verifyCompletedQuizText() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 15 STARTED</b>", "INFO",
				"<b>TESTCASE 15 - VERIFY BUTTON ON QUIZ SHOWS 'COMPLETED' AFTER USER COMPLETES THE QUIZ</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.verifyQuizResultScreen();
		fedscrn.clickDoneQuizButton();
		fedscrn.checkQuizCompletedText();
	}

	public void verifyCompletedQuizAlertMessage() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 16 STARTED</b>", "INFO",
				"<b>TESTCASE 16 - VERIFY THAT APP SHOWS ALERT ON TRYING TO REDO A QUIZ</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.verifyQuizResultScreen();
		fedscrn.clickDoneQuizButton();
		fedscrn.checkQuizCompletedAlertMessageText();
	}

	public void verifyTakeAnotherQuizScreenAction() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 17 STARTED</b>", "INFO",
				"<b>TESTCASE 17 - VERIFY QUIZ SCREEN OPENS ON CLICKING TAKE ANOTHER QUIZ BUTTON ON RESULT SCREEN OF A QUIZ </b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.verifyQuizResultScreen();
		fedscrn.clickTakeAnotherQuizScreenButton();
		fedscrn.checkQuizScreenOpen();
	}

	public void verifyQuizFinalScoreBoard() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 18 STARTED</b>", "INFO",
				"<b>TESTCASE 18 - VERIFY FINAL SCORE ON RESULT SCREEN OF A QUIZ</b>");
		logIn();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fedscrn = new FeedScreen(driver);
		fedscrn.clickTab("quizzes");
		fedscrn.findAValidQuizAndClickStartQuizButton();
		fedscrn.checkQuizFinalScoreBoard();
	}

	public void verifyTotalScoreOnProfileScreenAndUserStatusBar() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 19 STARTED</b>", "INFO",
				"<b>TESTCASE 19 - VERIFY SCORE ON PROFILE SCREEN INCREASES BY THE AMOUNT THAT IS WON ON FINISHING A QUIZ</b>");
		logIn();
		HomeScreen hs = new HomeScreen(driver);
		int initialUserStatusBarScore = hs.getScoreFromUserStatusBar();
		hs.clickProfileButton();
		ProfileScreen ps = new ProfileScreen(driver);
		int initialProfileScore = ps.getUserProfileScore();
		ps.clickBackButton();
		hs.clickFeedButton();
		FeedScreen fs = new FeedScreen(driver);
		fs.clickTab("quizzes");
		fs.findAValidQuizAndClickStartQuizButton();
		int quizScore = fs.finishQuizAndGetScore();
		fs.clickHomeButton();
		int finalUserStatusBarScore = hs.getScoreFromUserStatusBar();
		hs.verifyUserStatusBarScore(initialUserStatusBarScore + quizScore, finalUserStatusBarScore);
		hs.clickProfileButton();
		int finalProfileScore = ps.getUserProfileScore();
		ps.verifyProfileScore(initialProfileScore + quizScore, finalProfileScore);
	}

	public void verifyPollRestrictionForGuestUser() throws Exception {
		killApp();
		relaunchApp();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 20 STARTED</b>", "INFO",
				"<b>TESTCASE 20 - VERIFY POLL RESTRICTION FOR A GUEST USER</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hmscreen = new HomeScreen(driver);
		hmscreen.clickFeedButton();
		FeedScreen fed = new FeedScreen(driver);
		fed.clickTab("polls");
		fed.clickPollsOption();
		lgn.isLoginScreen();
	}

	public void verifyPostWithoutImage() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY POSTING A MESSAGE ON FORUM SCREEN APPEARS AS FIRST POST UNDER COMMUNITY TAB AFTER TRENDING POSTS</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickForumButton();
			ForumScreen fs = new ForumScreen(driver);
			fs.clickPlusButton();
			String textEntered = fs.enterText();
			fs.clickPostButton();
			fs.verifyNewPostComesFirstAfterTrendingPosts(username, textEntered, false);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying a post without camera image", "FAIL",
					"Verifying post without camera image");
		}
	}

	public void verifyPostWithCameraImage() throws Exception {
		try {
			killApp();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY POSTING A MESSAGE WITH IMAGE ON FORUM SCREEN APPEARS AS FIRST POST UNDER COMMUNITY TAB AFTER TRENDING POSTS</b>");
			HomeScreen hs = new HomeScreen(driver);
			hs.clickForumButton();
			ForumScreen fs = new ForumScreen(driver);
			fs.clickPlusButton();
			String textEntered = fs.enterText();
			fs.captureImage();
			fs.clickPostButton();
			fs.verifyNewPostComesFirstAfterTrendingPosts(username, textEntered, true);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying a post with camera image", "FAIL",
					"Verifying post with camera image");
		}
	}

	public void verifyCharacterLimit() throws Exception {
		try {
			killApp();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFY POSTING A MESSAGE ON FORUM SCREEN HAS A CHARACTER LIMIT FROM 1 TO 200</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickForumButton();
			ForumScreen fs = new ForumScreen(driver);
			fs.clickPlusButton();
			fs.verifyCharacterLimit();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying character limit on a post", "FAIL",
					"Verifying character limit on a post");
			throw e;
		}

	}

	/*
	 * public void verifyPostsShuffleOnRefresh() throws Exception { try {
	 * killApp(); relaunchApp();
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "<b>TESTCASE 4 STARTED</b>", "INFO",
	 * "<b>TESTCASE 4 - VERIFY POSTS ON FORUM SCREEN SHUFFLE ON REFRESH</b>");
	 * logIn(); HomeScreen hs = new HomeScreen(driver); hs.clickForumButton();
	 * ForumScreen fs = new ForumScreen(driver);
	 * fs.checkPostsShuffleOnRefresh(); } catch (Exception e) {
	 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
	 * "Exception Occured...while verifying that posts shuffle on refresh",
	 * "FAIL", "Verifying that posts shuffle on refresh"); throw e; } }
	 */

	public void verifyLikeFromForumCommunity() throws Exception {
		try {
			HomeScreen hs = new HomeScreen(driver);
			hs.clickForumButton();
			ForumScreen fs = new ForumScreen(driver);
			Thread.sleep(4000L);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("State of like button before tapping",
					"INFO", "Get the state of Like button");
			int countBeforeLike = fs.getLikeCountForFirstForum();
			fs.clickOnFirstLikeButton();
			int countAfterLike = fs.getLikeCountForFirstForum();
			int expectedCount = countBeforeLike + 1;
			if (expectedCount == countAfterLike) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Like button functionality is working as expected", "PASS",
						"Verifying functionality of Like Button");
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Like button functionality is not working as expected. Expected Count: " + expectedCount
										+ " Actual Count: " + countAfterLike,
								"FAIL", "Verifying functionality of Like Button");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Like Button functionality", "FAIL",
					"Verifying functionality of Like Button");
		}
	}

	public void verifyCommentFromForumCommunity() throws Exception {
		try {
			ForumScreen fs = new ForumScreen(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"State of comment button before tapping", "INFO", "Get the state of Comment button");
			int countBeforeComment = fs.getCommentCountForFirstForum();
			fs.clickOnFirstCommentButton();
			fs.addCommentInCommentBox();
			fs.clickOnCommentPostButton();
			Keywords.scrollUp();
			int countAfterComment = fs.getCommentCountForFirstForum();
			int expectedCount = countBeforeComment + 1;
			if (expectedCount == countAfterComment) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button functionality is working as expected", "PASS",
						"Verifying functionality of Comment Button");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Comment button functionality is not working as expected. Expected Count: " + expectedCount
								+ " Actual Count: " + countAfterComment,
						"FAIL", "Verifying functionality of Comment Button");
			}
			Keywords.backPage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Comment Button functionality", "FAIL",
					"Verifying functionality of Comment Button");
		}
	}

	public void verifyLikeOnUserSelfCreatedPost() {
		try {
			ForumScreen fs = new ForumScreen(driver);
			String postText = fs.addNewPost();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("State of like button before tapping",
					"INFO", "Get the state of like button");
			int index = fs.clickLikeOnPost(postText);
			int count = fs.getLikeCountForPostWithIndex(index);
			if (count > 0) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User is able to like their post",
						"FAIL", "Verifying User should not be able to Like its own Posts");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"User is not able to like their post", "PASS",
						"Verifying User should not be able to Like its own Posts");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying like for user created post", "FAIL",
					"Verifying User should not be able to Like its own Posts");
		}
	}

	public void verifyFollowingUserPost() {
		try {
			HomeScreen hs = new HomeScreen(driver);
			hs.clickForumButton();
			Thread.sleep(5000);
			ForumScreen fs = new ForumScreen(driver);
			fs.clickTabInForumUsingText("Following");
			fs.verifyNoPostInFollowing();
			fs.clickTabInForumUsingText("Community");
			String user = fs.followAnyUser();
			Thread.sleep(2000L);
			fs.clickTabInForumUsingText("Following");
			fs.verifyFollowingPost(user);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying following user post", "FAIL",
					"Verifying that posts from the Following user are appearing only");
		}
	}

	public void verifyNoSearchIconOnFanWall() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 13 STARTED</b>", "INFO",
				"<b>TESTCASE 13 - VERIFY SEARCH ICON IS NOT PRESENT ON FANWALL SCREEN</b>");
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		CommonFeatures cmn = new CommonFeatures(driver);
		cmn.clickForumButton();
		Thread.sleep(5000);
		ForumScreen frs = new ForumScreen(driver);
		frs.clickTabInForumUsingText("Fan Wall");//FAN WALL
		frs.verifySearchOnFanWall();
	}

	public void verifyCoinDeductionOnFanWall() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 15 STARTED</b>", "INFO",
				"<b>TESTCASE 15 - VERIFY COIN DEDUCTION ON FANWALL POST FROM PROFILE SCORE</b>");
		CommonFeatures cmn = new CommonFeatures(driver);
		cmn.clickForumButton();
		Thread.sleep(5000);
		ForumScreen frm = new ForumScreen(driver);
		frm.clickTabInForumUsingText("Fan Wall");//FAN WALL
		frm.clickBuyHourButton();
		frm.clickCoinsButtonOnFanWall();
		frm.postOnFanWall();
		frm.coinDeductionOnFanWall();
	}

	public boolean verifyPresenceOfFanWall(boolean b, String fanWallText) throws Exception {
		killApp();
		boolean currentState = cms.setFanWallStatus(b);
		relaunchApp();
		HomeScreen hs = new HomeScreen(driver);
		hs.clickForumButton();
		ForumScreen fs = new ForumScreen(driver);
		fs.verifyFanWallPresence(b, fanWallText);
		return currentState;
	}

	public void verifyDynamicTextForFanWall() throws Exception {
		killApp();
		String newFanWallText = "AUTOFANWAL";
		String currentText = cms.changeFanWallText(newFanWallText);
		relaunchApp();
		HomeScreen hs = new HomeScreen(driver);
		hs.clickForumButton();
		ForumScreen fs = new ForumScreen(driver);
		fs.verifyTextOfFanWallTab(newFanWallText);
		cms.changeFanWallText(currentText);
	}

	public void verifyForumOtherUserProfile() throws Exception {
		HomeScreen hs = new HomeScreen(driver);
		hs.clickForumButton();
		ForumScreen fs = new ForumScreen(driver);
		fs.clickTabInForumUsingText("Following");
		String user = fs.navigateToFirstUserProfile();
		ProfileScreen ps = new ProfileScreen(driver);
		ps.verifyUserName(user);
		ps.clickUnfollowButton();
		ps.clickFollowButton();
	}

	public void verifyGuestUserOnActivity() {
		LoginScreen lgn = new LoginScreen(driver);
		lgn.clickSkipForNow();
		HomeScreen hs = new HomeScreen(driver);
		hs.clickActivityButton();
		lgn.isLoginScreen();
	}

	public void verifyActivityInLogInMode() {
		HomeScreen hs = new HomeScreen(driver);
		hs.clickActivityButton();
		ActivityScreen act = new ActivityScreen(driver);
		act.verifyMyActivity();
		act.verifyActivityTab("Messages");
		act.verifyActivityTab("Notifications");
		act.verifyActivityTab("Discussions");
	}

	public void verifyActivityNotification() throws Exception {
		readLoginDetails();
		String userName = DriverSession.getUserName();
		String password = DriverSession.getPassword();
		logIn(userName, password);
		HomeScreen hs = new HomeScreen(driver);
		hs.clickProfileButton();
		ProfileScreen prf = new ProfileScreen(driver);
		String user = prf.getUserName();
		prf.clickBackButton();
		hs.clickForumButton();
		ForumScreen fs = new ForumScreen(driver);
		String post = fs.addNewPost();
		fs.commentOnPost(post);
		fs.clickBackButton();
		hs.clickActivityButton();
		ActivityScreen act = new ActivityScreen(driver);
		act.verifyPostedDiscussionNotification(user, post);
	}

	public void verifyLeavingDiscussion() {
		HomeScreen hs = new HomeScreen(driver);
		hs.clickActivityButton();
		ActivityScreen act = new ActivityScreen(driver);
		act.verifyLeaveDiscussion();
	}

	public void verifyMessageTab() {
		HomeScreen hs = new HomeScreen(driver);
		hs.clickForumButton();
		ForumScreen fs = new ForumScreen(driver);
		fs.navigateToFirstUserProfile();
		ProfileScreen ps = new ProfileScreen(driver);
		String user = ps.getUserName();
		String message = "Message" + Keywords.getRandomData();
		ps.messageUser(message);
		ps.clickBackButton();
		fs.clickBackButton();
		hs.clickActivityButton();
		ActivityScreen act = new ActivityScreen(driver);
		act.clickActivityTab("Messages");
		String messageText = act.verifyMessageInActivity(user, message);
		act.verifyClearConversationInMessage(messageText);
	}

	public void verifyBadgeCountNewReg() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY BADGE COUNT ON NEW USER REGISTRATION</b>");
			DriverSession.setReporting(false);
			registerUserWithAllowedAge();
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User acoount created successfully",
					"PASS", "New User should be registered");
			HomeScreen home = new HomeScreen(driver);
			home.verifyBadgeCount(2);
			home.clickActivityButton();
			ActivityScreen act = new ActivityScreen(driver);
			act.clickActivityTab("Notifications");
			act.verifyNewUserRegNotification();
			act.clickBackButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying like for user created post", "FAIL",
					"Verifying Badge count on new Registration");
		}
	}

	public void verifyBadgeCountOnPost() {
		try {
			HomeScreen home = new HomeScreen(driver);
			DriverSession.setReporting(false);
			logOut();
			logIn("automationuser", "123456");
			int count = home.getBadgeCount();
			logOut();
			logIn(DriverSession.getUserName(), DriverSession.getPassword());
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY BADGE COUNT WHEN USER COMMENT ON POST</b>");
			home.clickProfileButton();
			ProfileScreen profile = new ProfileScreen(driver);
			profile.followUser("automationuser");
			profile.clickBackButton();
			home.clickForumButton();
			ForumScreen forum = new ForumScreen(driver);
			forum.clickTabInForumUsingText("Following");
			forum.commentOnPost("TestPost");
			forum.clickBackButton();
			logOut();
			logIn("automationuser", "123456");
			home.verifyBadgeCount(++count);
			ActivityScreen act = new ActivityScreen(driver);
			act.clickActivityButton();
			act.readFirstMessage();
			act.clickBackButton();
			home.verifyBadgeCount(--count);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying like for user created post", "FAIL",
					"Verifying Badge count on new Registration");
		}
	}

	public void verifyLoggedOutStatusBar() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY STATUS BAR FOR LOGGED OUT USER</b>");
			LoginScreen ls = new LoginScreen(driver);
			ls.clickSkipForNow();
			HomeScreen hs = new HomeScreen(driver);
			hs.verifyStatusBarFor(true);
			hs.verifyProgressBarFor(false);
			hs.isGuestUserLoginButtonPresent();
			hs.isGuestUserRegisterNowButtonPresent();
			hs.clickLoginButton();
			SignInScreen ss = new SignInScreen(driver);
			ss.isLoginButtonPresent();
			Keywords.backPage();
			hs.clickRegisterNowButton();
			RegistrationScreen rs = new RegistrationScreen(driver);
			rs.isGetStartedButtonPresent();
			rs.isFacebookButtonPresent();
			Keywords.backPage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Status Bar for User not logged in", "FAIL",
					"Verifying Status Bar for User not logged in");
			throw e;
		}
	}

	public void verifyLoggedInStatusBar() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY STATUS BAR FOR LOGGED IN USER</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.verifyStatusBarFor(false);
			hs.verifyProgressBarFor(true);
			hs.isUserScorePresent();
			hs.clickProgressBar();
			ProfileScreen ps = new ProfileScreen(driver);
			ps.isProfileScreenOpened();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Status Bar for logged in user", "FAIL",
					"Verifying Status Bar for logged in user");
			throw e;
		}
	}

	public void verifyEditProfileButtonOnProfileScreen() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY EDIT PROFILE BUTTON ON PROFILE SCREEN</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			hs.clickProfileButton();
			ProfileScreen ps = new ProfileScreen(driver);
			ps.clickEditProfileButton();
			ps.areAllFieldsPresentInEditProfileSection();
			ps.verifyPreFilledFieldsInEditProfileSection();
			ps.verifyFirstNameInEditProfileSection(DriverSession.getTestCaseData().get("Username"));
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Edit Profile button", "FAIL",
					"Verifying Edit Profile Button on Profile Screen");
		}
	}

	public void verifyMessageForNoFollowingUsers() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFYING MESSAGE FOR NO FOLLOWING USERS IN PROFILE SECTION</b>");
			HomeScreen hs = new HomeScreen(driver);
			hs.clickProfileButton();
			ProfileScreen ps = new ProfileScreen(driver);
			ps.clickFollowingSection();
			ps.verifyNoUsersFoundMessage();
			Keywords.backPage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying message for No Following Users", "FAIL",
					"Verifying Message for No Following Users");
			throw e;
		}

	}

	public void verifyMessageForNoFollowers() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFYING MESSAGE FOR NO FOLLOWERS IN PROFILE SECTION</b>");
			ProfileScreen ps = new ProfileScreen(driver);
			HomeScreen hs = new HomeScreen(driver);
			By by = AndroidAppLocators.getInstance().getLocatorOfProgressBarOnProfileScreen();
			ps.waitForProgressBarToBeInvisible(by);
			Keywords.backPage();
			hs.clickProfileButton();
			ps.clickFollowersSection();
			ps.verifyNoUsersFoundMessage();
			Keywords.backPage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying message for No Followers Users", "FAIL",
					"Verifying Message for No Followers Users");
			throw e;
		}
	}

	public void verifyNonEmptyFollowingAndFollowersSection() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFYING NON EMPTY FOLLOWING AND FOLLOWERS SECTION</b>");
			ProfileScreen ps = new ProfileScreen(driver);
			HomeScreen hs = new HomeScreen(driver);
			By by = AndroidAppLocators.getInstance().getLocatorOfProgressBarOnProfileScreen();
			ps.waitForProgressBarToBeInvisible(by);
			Keywords.backPage();
			hs.clickProfileButton();
			ps.followUser(DriverSession.getTestCaseData().get("Username"));
			ps.waitForProgressBarToBeInvisible(by);
			Keywords.backPage();
			hs.clickProfileButton();
			ps.clickFollowingSection();
			ps.verifyFollowingUserPresent(DriverSession.getTestCaseData().get("Username"));
			killApp();
			relaunchApp();
			DriverSession.setReporting(false);
			logOut();
			DriverSession.setReporting(true);
			logIn();
			hs.clickProfileButton();
			ps.clickFollowersSection();
			ps.verifyFollowerUserPresent(username);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Following and Followers Section", "FAIL",
					"Verifying Following and Followers Section");
			throw e;
		}
	}

	public void verifyProfileAndAvatarImageOnProfileScreen() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFYING PROFILE AND AVATAR IMAGE ON PROFILE SCREEN</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			ProfileScreen ps = new ProfileScreen(driver);
			hs.clickProfileButton();
			ps.isAvatarImagePresent();
			ps.verifyUploadOptionsOnAvatarImage();
			Keywords.backPage();
			ps.isProfileImagePresent();
			ps.verifyUploadOptionsOnProfileImage();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Profile and Avatar Image", "FAIL",
					"Verifying Profile and Avatar Image on Profile Screen");
			throw e;
		}
	}

	public void verifyGiveGiftFeatureOnProfileScreen() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFYING GIVE GIFT FEATURE ON PROFILE SCREEN</b>");
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			ProfileScreen ps = new ProfileScreen(driver);
			hs.clickProfileButton();
			ps.navigateToUser(username);
			ps.clickGiveGiftButton();
			ps.clickFirstGiftOption();
			String giftName = ps.clickSendGiftButton();
			killApp();
			relaunchApp();
			DriverSession.setReporting(false);
			logOut();
			DriverSession.setReporting(true);
			logIn(username, DriverSession.getPassword());
			hs.clickProfileButton();
			ps.clickMyGiftsButton();
			ps.verifyGiftReceived(DriverSession.getTestCaseData().get("Username"), giftName);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Give Gift feature on Profile Screen", "FAIL",
					"Verifying Give Gift feature on Profile Screen");
			throw e;
		}
	}

	public String verifyOrderOfDiscussions() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
				"<b>TESTCASE 1 - VERIFYING ORDER OF DISCUSSIONS, MESSAGES AND NOTIFICATIONS ON ACTIVITY SCREEN</b>");
		HomeScreen hs = new HomeScreen(driver);
		ForumScreen fs = new ForumScreen(driver);
		ActivityScreen as = new ActivityScreen(driver);
		hs.clickForumButton();
		String postMessageFirst = fs.addNewPost();
		String postMessageSecond = fs.addNewPost();
		By by = AndroidAppLocators.getInstance().getLocatorOfProgressBarTextOnForumScreen();
		fs.waitForProgressBarToBeInvisible(by);
		Keywords.backPage();
		hs.clickActivityButton();
		as.verifyOrderOfDiscussions(username, postMessageFirst, postMessageSecond);
		return postMessageFirst;
	}

	public void verifyOrderOfMessagesAndNotifications(String postText) throws Exception {
		killApp();
		relaunchApp();
		HomeScreen hs = new HomeScreen(driver);
		ProfileScreen ps = new ProfileScreen(driver);
		ForumScreen fs = new ForumScreen(driver);
		ActivityScreen as = new ActivityScreen(driver);
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		logIn(DriverSession.getTestCaseData().get("Username"), DriverSession.getTestCaseData().get("Password"));
		hs.clickForumButton();
		fs.clickLikeOnPostWithScroll(postText);
		Keywords.backPage();
		hs.clickProfileButton();
		ps.navigateToUser(username);
		ps.messageUser("abc");
		killApp();
		relaunchApp();
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		logIn("automationuser", "123456");
		hs.clickForumButton();
		fs.clickLikeOnPostWithScroll(postText);
		Keywords.backPage();
		hs.clickProfileButton();
		ps.navigateToUser(username);
		ps.messageUser("xyz");
		killApp();
		relaunchApp();
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		logIn(username, "123456");
		hs.clickActivityButton();
		as.clickActivityTab("Messages");
		as.verifyOrderOfMessages("automationuser", DriverSession.getTestCaseData().get("Username"), "xyz", "abc");
		as.clickActivityTab("Notifications");
		as.verifyOrderOfNotifications("automationuser", DriverSession.getTestCaseData().get("Username"));
	}

	public void verifyReferralRewardAndNotification(int referralRewardPoints) throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
				"<b>TESTCASE 1 - VERIFYING REWARD POINTS AND NOTIFICATION FOR REFERAL OF A NEW USER</b>");
		HomeScreen hs = new HomeScreen(driver);
		LoginScreen ls = new LoginScreen(driver);
		RegistrationScreen rs = new RegistrationScreen(driver);
		ActivityScreen as = new ActivityScreen(driver);
		ProfileScreen ps = new ProfileScreen(driver);
		logIn();
		hs.clickProfileButton();
		int initialScore = ps.getUserProfileScore();
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		ls.clickRegisterButton();
		String userReferred = rs.enterUsername();
		rs.enterEmail();
		rs.selectBirthdate("2000", "7", "27");
		rs.selectGender("Male");
		rs.enterLocation("Gurgaon");
		rs.enterPassword("123456");
		rs.clickGetStartedButton();
		rs.enterReferralUserName(DriverSession.getTestCaseData().get("Username"));
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		logIn();
		hs.clickActivityButton();
		as.clickActivityTab("Notifications");
		as.verifyReferralNotification(userReferred);
		Keywords.backPage();
		hs.clickProfileButton();
		int finalScore = ps.getUserProfileScore();
		ps.verifyProfileScore(initialScore + referralRewardPoints, finalScore);
	}

	public void verifyFeedImageState(boolean lockState) throws Exception {
		try {
			HomeScreen hs = new HomeScreen(driver);
			hs.clickFeedButton();
			FeedScreen feed = new FeedScreen(driver);
			feed.clickTab("Photos");
			feed.verifyPhotoLockedState(lockState);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...while verifying",
					"FAIL", "Verifying Photos locked state");
		}
	}

	public void verifyVoteButtonIsClickable() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
				"<b>TESTCASE 1 - VERIFYING VOTE BUTTON IS CLICKABLE</b>");
		HomeScreen hs = new HomeScreen(driver);
		FeedScreen fs = new FeedScreen(driver);
		hs.clickFeedButton();
		fs.clickTab("Polls");
		fs.verifyVoteButtonIsClickable();
	}

	public void verifyAdditionOfCoinsOnVoting() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
				"<b>TESTCASE 1 - VERIFYING REWARD POINTS EARNED ON COMPLETING A POLL</b>");
		HomeScreen hs = new HomeScreen(driver);
		ProfileScreen ps = new ProfileScreen(driver);
		FeedScreen fs = new FeedScreen(driver);
		int initialUserStatusBarScore = hs.getScoreFromUserStatusBar();
		hs.clickProfileButton();
		int initialProfileScreenScore = ps.getUserProfileScore();
		Keywords.backPage();
		hs.clickFeedButton();
		fs.clickTab("Polls");
		int reward = fs.completePollAndGetReward();
		fs.clickHomeButton();
		int finalUserStatusBarScore = hs.getScoreFromUserStatusBar();
		hs.verifyUserStatusBarScore(initialUserStatusBarScore + reward, finalUserStatusBarScore);
		hs.clickProfileButton();
		int finalProfileScreenScore = ps.getUserProfileScore();
		ps.verifyProfileScore(initialProfileScreenScore + reward, finalProfileScreenScore);
	}

	public void verifyConversationScreenOnDiscussions() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 7 STARTED</b>", "INFO",
				"<b>TESTCASE 7 - VERIFY CONVERSATION SCREEN ON DISCUSSION TAB</b>");
		CommonFeatures cmn = new CommonFeatures(driver);
		cmn.clickActivityButton();
		ActivityScreen act = new ActivityScreen(driver);
		act.clickFirstDiscussion();
		act.isConversationScreenOpened();
	}

	public void verifyPostOnFanWallScreen() throws Exception {
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 14 STARTED</b>", "INFO",
				"<b>TESTCASE 14 - VERIFY POST ON FANWALL SCREEN</b>");
		HomeScreen hs = new HomeScreen(driver);
		hs.clickForumButton();
		Thread.sleep(4000);
		ForumScreen frm = new ForumScreen(driver);
		frm.clickTabInForumUsingText("Fan Wall");//FANWALL replace with new one Fan Wall
		frm.clickCoinsButtonOnFanWall();
		frm.postOnFanWall();
		frm.clickTabInForumUsingText("Fan Wall");//FANWALL replace with new one Fan Wall
		frm.verifyPostOnFanWall();
	}

	public void verifyFeedTopic() throws Exception {
		String feedID = null;
		String editChallengeCardUrl = null;
		String challengeCardTitle = null;
		String feedCreated = null;
		try {
			DriverSession.setReporting(false);
			feedID = cms.addFeedTopic();
			feedCreated = cms.feedTitle;
			cms.createChallengeTypeCard();
			editChallengeCardUrl = cms.allCardDetails.get("Challenges").get("editCardUrl");
			challengeCardTitle = cms.allCardDetails.get("Challenges").get("title");
			cms.linkChallengeCardToFeedTopic(editChallengeCardUrl);
			DriverSession.setReporting(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY FEED TOPIC-AVATAR AND ITS CONTENTS</b>");
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			FeedScreen fs = new FeedScreen(driver);
			hs.clickFeedButton();
			fs.findCardAndClickItsAvatar(challengeCardTitle, feedCreated);
			fs.verifyCreatedFeedTopicOpens(feedCreated);
			fs.verifyCreatedCardIsPresentInFeedTopic(challengeCardTitle);
			Keywords.backPage();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Device Back Button tapped. Main Feed Screen opened.", "INFO", "Verifying Feed Topic");
			fs.clickTab("Challenges");
			fs.findCardAndClickItsAvatar(challengeCardTitle, feedCreated);
			fs.verifyCreatedFeedTopicOpens(feedCreated);
			fs.verifyCreatedCardIsPresentInFeedTopic(challengeCardTitle);
			fs.clickTab("Challenges");
			fs.verifyCreatedCardIsPresentInFeedTopic(challengeCardTitle);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying Feed Topic", "FAIL",
					"Verifying Feed Topic");
			throw e;
		} finally {
			deleteAddedFeed(feedID);
			destoryAllCardAndClose();			
		}
	}
	
	public void verifyImageMinWidth(){
		try{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY THERE IS A MINIMUM WIDTH REQUIRED FOR POSTING AN IMAGE</b>");
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			ForumScreen fs = new ForumScreen(driver);
			hs.clickForumButton();
			fs.clickPlusButton();
			fs.captureImageAndCropWidth();
			fs.saveCroppedImage();
			if(fs.isCroppedImagePresent()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Cropped Image got Posted", "FAIL",
						"Verifying that there is a Minimum Width required for posting an Image");
			}else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Cropped Image did not get Posted", "PASS",
						"Verifying that there is a Minimum Width required for posting an Image");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while verifying the minimum width of posting an image", "FAIL",
					"Verifying that there is a Minimum Width required for posting an Image");
		}
	}
	
	public void verifyNoImageMinHeight(){
		try{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY THERE IS NO MINIMUM HEIGHT REQUIRED FOR POSTING AN IMAGE</b>");
			killApp();
			relaunchApp();
			logIn();
			HomeScreen hs = new HomeScreen(driver);
			ForumScreen fs = new ForumScreen(driver);
			hs.clickForumButton();
			fs.clickPlusButton();
			fs.captureImageAndCropHeight();
			fs.saveCroppedImage();
			if(fs.isCroppedImagePresent()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Cropped Image got Posted", "PASS",
						"Verifying that there is no minimum height required for posting an Image");
			}else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Cropped Image did not get Posted", "FAIL",
						"Verifying that there is no minimum height required for posting an Image");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred...while verifying that there is no minimum height required for posting an image", "FAIL",
					"Verifying that there is no minimum height required for posting an Image");
		}
	}

	public void launchApp(WebDriver driver) throws Exception { 
		try {
			setUp(driver);
			AndroidAppLocators.getInstance().getAppSpecificStatusBar(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("App Launched", "PASS",
						"App should Launch");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...while launching app", "FAIL",
					"App should Launch.");
			throw e;
		}
	}
}
