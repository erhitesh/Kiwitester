package Topfan.Android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.Keywords;

import Topfan.CMS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen extends CommonFeatures{
	private WebDriver driver;
	private WebElement element;

	public HomeScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifyHomePageOpened() {
		Boolean b = false;
		try {
			element = AndroidAppLocators.getInstance().getHomePageCheckElement(driver);
			b = Keywords.isElementPresent(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage successfully opened",
						"PASS", "HomePage should open");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage not successfully opened",
						"FAIL", "HomePage should open");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while opening HomePage", "FAIL", "HomePage should open");
		}
		return b;
	}

	public boolean checkLoggedInState() {
		By by = AndroidAppLocators.getInstance().getLocatorOfProgressBar();
		waitForProgressBarToBeInvisible(by);
		Keywords.waitForPage(driver, 5);
		try {
			AndroidAppLocators.getInstance().getLoginButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User is not logged in", "INFO",
					"Checking Logged In state");
			return false;
		} catch (Exception e) {
			try{
				AndroidAppLocators.getInstance().getGuestLoginButton(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User is not logged in", "INFO",
						"Checking Logged In state");
				return false;
			}catch(Exception e2)
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User is logged in", "INFO",
						"Checking Logged In state");
				return true;
			}
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyFeedSection(String feed) {
		try {
			Keywords.waitForPage(driver, 120);
			element = AndroidAppLocators.getInstance().getFirstFeedSection(driver);
			String feedTitle = element.getText().trim();
			if (feedTitle.equals(feed))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feed verified successfully",
						"PASS", "Verifying created feed in the feed section");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Created Feed did not appear",
						"FAIL", "Verifying created feed in the feed section");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while verifying feed", "FAIL", "Verifying created feed in the feed section");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public Set<String> getTitleOfCurrentCard(int count) throws Exception{
		waitForLoaderToStop();
		Set<String> titles = new LinkedHashSet<String>();
		try {
			for (int i = 0; i < count; i++) {
				titles.add(AndroidAppLocators.getInstance().getCardsTitleFromHomeScreen(driver));
				swipe();
				// Thread.sleep(1000L);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return titles;
	}

	private void waitForLoaderToStop() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.topfan.TopFan.TestApp:id/lay")));
	}

	public void swipe() {
		try {
			@SuppressWarnings("unchecked")
			AppiumDriver<MobileElement> Driver = (AppiumDriver<MobileElement>) DriverSession.getLastExecutionDriver();
			AndroidElement element = (AndroidElement) Driver.findElement(By.id("com.topfan.TopFan.TestApp:id/lay"));
//			Driver.swipe(element.getLocation().getX(), element.getLocation().getY(),
//					element.getLocation().getX() + element.getSize().getWidth(), element.getLocation().getY(), 1000);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public void verifyStatusBarFor(boolean expected) {
		try {
			Keywords.waitForPage(driver, 20);
			element = AndroidAppLocators.getInstance().getStatusBar(driver);
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is appearing",
						"PASS", "Status Logo bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is appearing",
						"FAIL", "Status Logo bar should not appear");
		} catch (Exception e) {
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is not appearing",
						"FAIL", "Status Logo bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is not appearing",
						"PASS", "Status Logo bar should not appear");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickProfileMenu() {
		try {
			element = AndroidAppLocators.getInstance().getProfileButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Menu button successfully clicked", "PASS", "Profile Menu button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile Menu button not successfully clicked", "FAIL",
						"Profile Menu button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Profile Menu button", "FAIL",
					"Profile Menu button should be clicked");
		}
	}

	public void verifyFeedsSequence(int feedCount, CMS cms) {
		try {
			String[] feedTitlesOnCms = cms.getFeedTitles();
			String[] feedTitlesOnApp = new String[feedCount];
			List<WebElement> elements = new ArrayList<WebElement>();
			int j = -1;
			for (int i = 0; i < feedCount; i++) {
				j++;
				if (j == 3) {
					element = AndroidAppLocators.getInstance().getFeedSectionNextButton(driver);
					Keywords.click(element);
					j = 0;
				}
				if (j == 0) {
					elements = AndroidAppLocators.getInstance().getFeedSectionTitles(driver);
				}
				feedTitlesOnApp[i] = elements.get(j).getText();
			}
			ArrayUtils.reverse(feedTitlesOnCms);
			if (Arrays.equals(feedTitlesOnCms, feedTitlesOnApp)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Feed Sequence on CMS matched with that on App", "PASS",
						"Verifying sequence of feeds on CMS with that on App");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Feed Sequence on CMS did not match with that on App", "FAIL",
						"Verifying sequence of feeds on CMS with that on App");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCTASection(int row, List<String> titles) {
		try {
			boolean flag = true;
			int scrollCount = 0;
			do {
				scrollCount++;
				Keywords.scrollDown();
			} while (!isLastCTACardVisible(row) && scrollCount < 10);
			List<WebElement> cardsCTA = AndroidAppLocators.getInstance().getALLCTACard(driver);
			if (cardsCTA.size() == (row * 3)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Count : <b>" + cardsCTA.size() + "</b> verified successfully", "PASS",
						"Verify count of CTA Card");
				for (int i = 1; i <= (row * 3); ++i) {
					element = AndroidAppLocators.getInstance().getCTAFromIndex(driver, i);
					String CTATitle = element.getText().trim();
					if (!titles.get(i - 1).equals(CTATitle)) {
						flag = false;
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Card : <b>" + titles.get(i - 1) + "</b> does not appear", "FAIL", "Verify CTA Cards");
					}
				}
				if (flag) {
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("All CTA Cards verified successfully", "PASS", "Verify CTA Cards");
				}
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Card Count <b>"+row*3+"</b> does not match", "FAIL",
						"Verify count of CTA Card");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured while verifying CTA Cards", "FAIL", "Verify CTA Cards");
		}
	}

	public boolean isLastCTACardVisible(int row) {
		try {
			Keywords.waitForPage(driver, 10);
			WebElement lastCTACard = AndroidAppLocators.getInstance().getCTAFromIndex(driver, row * 3);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}
	
	public void clickLoginButton(){
		try {
			element = AndroidAppLocators.getInstance().getGuestLoginButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Guest Login button successfully clicked", "PASS", "Guest Login button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Guest Login button not successfully clicked", "FAIL",
						"Guest Login button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Guest Login button", "FAIL",
					"Guest Login button should be clicked");
		}
	}
	
	public boolean isGuestUser(){
		Keywords.waitForPage(driver, 10);
		try{
			element = AndroidAppLocators.getInstance().getGuestLoginButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User is Guest User", "INFO", "Checking if User is a Guest User");
			return true;
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User is not Guest User", "INFO", "Checking if User is a Guest User");
			return false;
		}finally {
			Keywords.waitForPage(driver, 60);
		}
	}
	
	public void isGuestUserLoginButtonPresent() throws Exception {
		try{
			element = AndroidAppLocators.getInstance().getGuestLoginButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Guest User Login Button present on Home Screen", "PASS", "Checking if Guest User Login Button is present");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Guest User Login Button not present on Home Screen", "FAIL", "Checking if Guest User Login Button is present");
		}
	}
	
	public void isGuestUserRegisterNowButtonPresent() throws Exception {
		try{
			element = AndroidAppLocators.getInstance().getGuestRegisterNowButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Guest User Register Now Button present on Home Screen", "PASS", "Checking if Guest User Register Now Button is present");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Guest User Register Now Button not present on Home Screen", "FAIL", "Checking if Guest User Register Now Button is present");
		}
	}
	
	public void clickRegisterNowButton(){
		try {
			element = AndroidAppLocators.getInstance().getGuestRegisterNowButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Guest Register Now button successfully clicked", "PASS", "Guest Register Now button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Guest Register Now button not successfully clicked", "FAIL",
						"Guest Register Now button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Guest Register Now button", "FAIL",
					"Guest Register Now button should be clicked");
		}
	}
	
	public void verifyProgressBarFor(boolean expected){
		try {
			Keywords.waitForPage(driver, 20);
			element = AndroidAppLocators.getInstance().getProgressBar(driver);
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress bar is appearing",
						"PASS", "Progress bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress bar is appearing",
						"FAIL", "Progress bar should not appear");
		} catch (Exception e) {
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress bar is not appearing",
						"FAIL", "Progress bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress bar is not appearing",
						"PASS", "Progress bar should not appear");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}
	
	public void isUserScorePresent(){
		try{
			element = AndroidAppLocators.getInstance().getUserScore(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User score is present",
					"PASS", "Verifying the presence of User Score");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User score is not present",
					"FAIL", "Verifying the presence of User Score");
		}
	}
	
	public void clickProgressBar() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().getProgressBar(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress Bar successfully clicked",
						"PASS", "Progress Bar should be clicked");
			}else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Progress Bar not successfully clicked",
						"FAIL", "Progress Bar should be clicked");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...as Progress Bar was not found",
					"FAIL", "Progress Bar should be clicked");
		}
	}
	
	public int getScoreFromUserStatusBar() throws Exception{
		int scoreValue = 0;
		try {
			try {
				element = AndroidAppLocators.getInstance().getUserScore(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fetching score from user status bar successful", "PASS", "Fetching score from user status bar");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fetching score from user status bar not successful", "FAIL",
						"Fetching score from user status bar");
			}
			String score = element.getText();
			String scoreTemp;
			float sv;
			if (score.endsWith("K")) {
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000;
				scoreValue = (int) sv;
			} else if (score.endsWith("M")) {
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000000;
				scoreValue = (int) sv;
			} else if(score.endsWith("G")){
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000000000;
				scoreValue = (int) sv;
			}else {
				scoreTemp = score.replaceAll(",", "");
				scoreValue = Integer.valueOf(scoreTemp);
			}
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Score is "+scoreValue, "INFO", "Fetching score from user status bar");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while fetching score from user status bar", "FAIL", "Fetching score from user status bar");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return scoreValue;
	}

}
