package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.antlr.ast.keyword;

import com.session.DriverSession;
import com.utilities.Keywords;

public class HealthJourneyAndRewards {

	private WebDriver driver;

	public HealthJourneyAndRewards(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToHealthJourneyAndRewardsPage() {
		try {
			Keywords.waitForPage(driver);
			Dashboard dashboard = new Dashboard(DriverSession.getLastExecutionDriver());
			dashboard.selectDashboardLeftMenu("Health Journey");
		} catch (Exception e) {
		}
	}

	public boolean selectARewardGoalWindowStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().selectARewardGoalWindowHeaderTxt(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void viewRewardGoal() {
		WebElement element;
		try {
			element = Locators.getInstance().viewGoal(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Goal Button </b>successfully click", "PASS",
						"<b>View Goal Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Goal Button </b>successfully not click", "FAIL",
						"<b>View Goal Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>View Goal Button </b>", "FAIL",
					"<b>View Goal Button </b>should be clicked");
		}
	}

	public void notViewRewardGoal() {
		WebElement element;
		try {
			element = Locators.getInstance().cancelGoal(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Not Now Button </b>successfully click", "PASS", "<b>Not Now Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Not Now Button </b>successfully not click", "FAIL",
						"<b>Not Now Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Not Now Button </b>", "FAIL",
					"<b>Not Now Button </b>should be clicked");
		}
	}

	public void selectRewardsGoalOperation(boolean operationType) {
		WebElement element;
		try {
			if (selectARewardGoalWindowStatus()) {
				if (operationType) {
					viewRewardGoal();
				} else if (!operationType)
					notViewRewardGoal();
			} else if (!operationType)
				selectSubLinksInsideHealthJourneyAndRewardsTab("rewards");
			if (selectARewardGoalWindowStatus()) {
				element = Locators.getInstance().acceptGoalWindow(driver);
				Keywords.click(element);
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Ok Button </b>successfully click", "PASS",
							"<b>Ok Button </b>should be clicked");
				else 
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Ok Button </b>successfully click", "FAIL",
							"<b>Ok Button </b>should be clicked");
			}
		} catch (Exception e) {

		}
	}

	public void selectSubLinksInsideHealthJourneyAndRewardsTab(String subLinkName) {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectHealthJourneyAndRewardsSubLinks(driver, subLinkName);
			Keywords.click(element);
			Keywords.explicitWait(2);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Journey & Rewards sub link.</b> " + subLinkName + " select successfully", "PASS",
						"<b>Health Journey & Rewards sub link.</b> " + subLinkName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Journey & Rewardsh sub link.</b> " + subLinkName + " not select successfully",
						"FAIL", "<b>Health Journey & Rewards sub link.</b> " + subLinkName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurrred while selecting the Health Journey & Rewards sub link.</b> " + subLinkName,
					"FAIL", "<b>Health Journey & Rewards sub link.</b> " + subLinkName + " should be selected");
		}
	}

	public void checkShowOnlyRewardsIQualify() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().selectShowOnlyRewardsIQualify(driver), 10);
			element = Locators.getInstance().selectShowOnlyRewardsIQualify(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Show Only Rewards I Qualify For Checkbox </b>successfully checked", "PASS",
						"<b>Show Only Rewards I Qualify For Checkbox </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Show Only Rewards I Qualify For Checkbox </b>successfully not checked", "FAIL",
						"<b>Show Only Rewards I Qualify For Checkbox </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while selecting the <b>Show Only Rewards I Qualify For Checkbox </b>", "FAIL",
					"<b>Show Only Rewards I Qualify For Checkbox </b>should be checked");
		}
	}

	public void verifyPriceAfterCheckShowOnlyRewards(int totalEarnPoint) {
		List<WebElement> rewardsElementList;
		List<WebElement> priceElementList;
		try {
			rewardsElementList = Locators.getInstance().rewardsList(driver);
			priceElementList = Locators.getInstance().rewardsPriceList(driver);
			for (int i = 0; i < rewardsElementList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(priceElementList.get(i))) <= totalEarnPoint) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Rewards Price </b>Equal/Less Than Earn Point", "PASS",
							"<b>Rewards Price </b>should be Equal/Less than Earn Point");
				}else{
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Rewards Price </b>not Equal/Less Than Earn Point", "BUG",
							"<b>Rewards Price </b>should be Equal/Less than Earn Point");
					break;
				}
			}
		} catch (Exception e) {
		}
	}
	
	//public List
	public List<String> getRewardsTypeList() {
		List<WebElement> rewardsElementList;
		List<String> rewardsTypeList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			rewardsElementList = Locators.getInstance().selectRewardsTypeValue(driver);
			for (WebElement element : rewardsElementList)
				rewardsTypeList.add(Keywords.getText(element));
		} catch (Exception e) {
		}
		System.out.println("rewardsTypeList..."+rewardsTypeList);
		return rewardsTypeList;
	}

	public List<String> getRewardsBrandList() {
		List<WebElement> rewardsElementList;
		List<String> rewardsBrandList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			rewardsElementList = Locators.getInstance().selectRewardsBrandValue(driver);
			for (WebElement element : rewardsElementList)
				rewardsBrandList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return rewardsBrandList;
	}
	
	public List<String> getRewardList() {
		List<String> rewardsNameList = new ArrayList<>();
		List<WebElement> rewardsElementList;
		try {
			rewardsElementList = Locators.getInstance().rewardsNameList(driver);
			for (WebElement webElement : rewardsElementList)
				rewardsNameList.add(Keywords.getText(webElement));
		}catch(Exception e) {}
		
		return rewardsNameList;
	}
	
	public String getRewardName() {
		String rewardName = "";
		WebElement rewardElementName;
		try {
			rewardElementName = Locators.getInstance().rewardsItemDescriptionOnDetailPage(driver);
			rewardName = Keywords.getText(rewardElementName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rewardName;
	} 
	
	public String getRewardBrandName() {
		String rewardBrandName = "";
		WebElement rewardBrandElementName;
		try {
			rewardBrandElementName = Locators.getInstance().itemBrandNameOnDescriptionPage(driver);
			rewardBrandName = Keywords.getText(rewardBrandElementName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rewardBrandName;
	} 
	
	public int getRewardPointValue() {
		int rewardPointValue = 0;
		WebElement rewardPointElement;
		try {
			rewardPointElement = Locators.getInstance().itemPriceOnDescriptionPage(driver);
			rewardPointValue = Integer.parseInt(Keywords.getText(rewardPointElement));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rewardPointValue;
	} 
	
	public HashMap<String, List<String>> getRewardsItemDetailsList() {
		HashMap<String, List<String>> info = new LinkedHashMap<>();
		List<String> rewardsList = new ArrayList<>();
		WebElement rewardElementName;
		WebElement rewardDetailBtnElement;
		try {
			rewardsList = getRewardList();
			for (int i = 0; i < rewardsList.size(); i++) {
				rewardDetailBtnElement = Locators.getInstance().selectDetailBtnBasedOnRewardName(driver, rewardsList.get(i));
				Keywords.click(rewardDetailBtnElement);
				Keywords.explicitWait(2);
				rewardElementName = Locators.getInstance().rewardsItemDescriptionOnDetailPage(driver);
				if (Keywords.getText(rewardElementName).equalsIgnoreCase(rewardsList.get(i))) {
					info.put(getRewardName(), Keywords.convertStringAsList(getRewardBrandName() + " "+getRewardPointValue()));
					Keywords.click(Locators.getInstance().backToRewardsPage(driver));
					Keywords.explicitWait(2);
				}
			}
		}catch(Exception e) {
			
		}
		
		return info;
	}

}
