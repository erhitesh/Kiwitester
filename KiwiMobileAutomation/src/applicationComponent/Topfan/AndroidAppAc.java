package applicationComponent.Topfan;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.session.DriverSession;

import action.Topfan.AndroidAppAction;
import action.Topfan.CommonAppAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@Test
public class AndroidAppAc extends AppComponent implements ApplicationComponent {
	AndroidDriver<MobileElement> driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	AndroidAppAction action;
	String email;

	@SuppressWarnings("unchecked")
	@Override
	public void openApplication() throws Exception {
		driver = (AndroidDriver<MobileElement>) DriverSession.getLastExecutionDriver();
		action = new AndroidAppAction((AndroidDriver<MobileElement>) DriverSession.getLastExecutionDriver());
		action.launchApp(driver);
		CommonAppAction.loadMasterProperties("TopfanAppConfig");
	}

	@Override
	public void closeApplication() {
		action.closeApp();
	}

	@Override
	public void validateHomePage() throws Exception {
		action.verifyFeedSection();
		action.verifyCTASection();
		action.verifyStatusBar();
		action.killApp();
	}

	public void verifyCardsInCarousel() throws Exception {
		action.launchCMS();
		action.verifyCarousel();
		action.killApp();
	}

	public void verifyCarouselSequence() throws Exception {
		action.verifyCarouselSequence();
		action.killApp();
	}

	public void verifyFeedSequence() throws Exception {
		action.launchCMS();
		action.verifyFeedCardSequence(4);
		action.killApp();
	}

	public void verifyAppRegistration() throws Exception {
		//action.verifyMandatoryFields();
//		action.registerWithLowerAge();
//		action.registerUserWithAllowedAge();
//		action.registerUserWithAllMandatoryFields();
		action.verifyForgotPasswordFeature();
		action.killApp();
	}

	public void verifyAllCardTypesUnderAllTab() throws Exception {
		action.verifyAllCardTypesUnderAllTab(false);
		action.killApp();
	}

	public void verifyCTAButtonOnArticleCard() throws Exception {
		action.verifyCTAButtonOnArticleCard();
		action.killApp();
	}

	public void verifyLikeButtonOnCard() throws Exception {
		action.verifyLikeButtonOnCard();
	}

	public void verifyCommentButtonOnCard() throws Exception {
		action.verifyCommentButtonOnCard(false);
		action.verifyCommentButtonOnCard(true);
		action.killApp();
	}

	public void verifyHamburgerIcon() throws Exception {
		action.verifyHamburgerIcon();
		action.killApp();
	}

	public void verifyCardAccessRestriction() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyCardAccessRestriction("audio");
		action.killApp();
	}

	public void verifyLikeRestrictionForGuestUser() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyLikeRestrictionForGuestUser();
		action.killApp();
	}

	public void verifyCommentRestrictionForGuestUser() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyCommentRestrictionForGuestUser();
		action.killApp();
	}

	public void verifySearchIconPlaceholderOnFeedScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifySearchIconPlaceholderOnFeedScreen();
		action.killApp();
	}

	public void verifyAlertMessageOnVotingWithoutSelectingOption() throws Exception {
		action.verifyAlertMessageOnVotingWithoutSelectingOption();
		action.killApp();
	}

	public void verifySelectionOptionBeforeVote() throws Exception {
		action.verifySelectionOptionBeforeVote();
		action.killApp();
	}

	public void verifyQuizRestrictionForGuestUser() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyQuizRestrictionForGuestUser();
		action.killApp();
	}

	public void verifyQuestionScreenOnStartQuizClick() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyQuestionScreenOnStartQuizClick();
		action.killApp();
	}

	public void verifyOneAnswerForOneQuestion() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyOneAnswerForOneQuestion();
		action.killApp();
	}

	public void verifyCompletedQuizText() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyCompletedQuizText();
		action.killApp();
	}

	public void verifyCompletedQuizAlertMessage() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyCompletedQuizAlertMessage();
		action.killApp();
	}

	public void verifyTakeAnotherQuizScreenAction() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyTakeAnotherQuizScreenAction();
		action.killApp();
	}

	public void verifyQuizFinalScoreBoard() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyQuizFinalScoreBoard();
		action.killApp();
	}

	public void verifyTotalScoreOnProfileScreenAndUserStatusBar() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyTotalScoreOnProfileScreenAndUserStatusBar();
		action.killApp();
	}

	public void verifyPollRestrictionForGuestUser() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyPollRestrictionForGuestUser();
		action.killApp();
	}

	public void verifyPostMessagesOnForumScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyPostWithoutImage();
		action.verifyPostWithCameraImage();
		action.verifyCharacterLimit();
		action.killApp();
	}

	public void verifyForumCommunitySocialFeeds() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyLikeFromForumCommunity();
		action.verifyCommentFromForumCommunity();
		action.verifyLikeOnUserSelfCreatedPost();
		action.killApp();
	}

	public void verifyForumFollowingUserPosts() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyFollowingUserPost();
		action.killApp();
	}

	public void verifyNoSearchIconOnFanWall() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyNoSearchIconOnFanWall();
		action.killApp();
	}

	public void verifyCoinDeductionOnFanWall() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyCoinDeductionOnFanWall();
		action.killApp();
	}

	public void verifyFanWallFromCMS() throws Exception {
		action.launchCMS();
		action.logIn();
		String currentText = action.cms.changeFanWallText("FAN WALL");
		boolean state = action.verifyPresenceOfFanWall(false, "FAN WALL");
		action.verifyPresenceOfFanWall(true, "FAN WALL");
		action.cms.changeFanWallText(currentText);
		action.verifyDynamicTextForFanWall();
		action.setFanWallStateFromCMS(state);
		action.cms.closeCMS();
	}

	public void verifyForumFollowingUserProfile() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.logIn();
		action.verifyForumOtherUserProfile();
	}

	public void verifyGuestUserOnActivity() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyGuestUserOnActivity();
	}

	public void verifyActivityInLoggedInState() throws Exception {
		action.logIn();
		action.verifyActivityInLogInMode();
	}

	public void verifyActivityDiscussionNotification() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyActivityNotification();
	}

	public void verifyLeaveDiscussionFromActivity() throws Exception {
		DriverSession.setReporting(false);
		action.logIn();
		DriverSession.setReporting(true);
		action.verifyLeavingDiscussion();
	}

	public void verifyMessageTabInActivity() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyMessageTab();
	}

	public void verifyBadgeCountInActivity() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyBadgeCountNewReg();
		action.verifyBadgeCountOnPost();
	}

	public void verifyCompleteStatusBar() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyLoggedOutStatusBar();
		action.verifyLoggedInStatusBar();
	}

	public void verifyEditProfileButtonOnProfileScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyEditProfileButtonOnProfileScreen();
	}

	public void verifyFollowingAndFollowersSectionOnProfileScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyMessageForNoFollowingUsers();
		action.verifyMessageForNoFollowers();
		action.verifyNonEmptyFollowingAndFollowersSection();
	}

	public void verifyProfileAndAvatarImageOnProfileScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyProfileAndAvatarImageOnProfileScreen();
	}

	public void verifyGiveGiftFeatureOnProfileScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyGiveGiftFeatureOnProfileScreen();
	}

	public void verifyOrderOfContentInActivity() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		String postMessageFirst = action.verifyOrderOfDiscussions();
		action.verifyOrderOfMessagesAndNotifications(postMessageFirst);
	}

	public void verifyReferralRewardAndNotification() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		DriverSession.setReporting(true);
		action.verifyReferralRewardAndNotification(1000);
	}

	public void verifyFeedImageStates() throws Exception {
		action.logIn();
		action.launchCMS();
		boolean photosLockedState = action.setCMSPhotosLockedState(false);
		action.verifyFeedImageState(false);
		action.killApp();
		action.relaunchApp();
		action.setCMSPhotosLockedState(true);
		action.verifyFeedImageState(true);
		action.setCMSPhotosLockedState(photosLockedState);
		action.cms.closeCMS();
	}

	public void verifyVoteButtonIsClickable() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyVoteButtonIsClickable();
	}

	public void verifyAdditionOfCoinsOnVoting() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyAdditionOfCoinsOnVoting();
	}

	public void verifyConversationScreenOnDiscussions() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.logIn();
		DriverSession.setReporting(true);
		action.verifyConversationScreenOnDiscussions();
	}

	public void verifyPostOnFanWallScreen() throws Exception {
		DriverSession.setReporting(false);
		action.logOut();
		action.registerUserWithAllowedAge();
		DriverSession.setReporting(true);
		action.verifyPostOnFanWallScreen();
	}

	public void verifyFeedTopic() throws Exception {
		action.launchCMS();
		action.verifyFeedTopic();
		action.killApp();
	}

	public void verifyDimensionsOfImageBeingPostedOnCommunityTab() throws Exception {
		action.verifyImageMinWidth();
		action.verifyNoImageMinHeight();
	}
}