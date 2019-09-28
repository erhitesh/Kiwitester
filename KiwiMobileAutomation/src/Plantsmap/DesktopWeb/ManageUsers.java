package Plantsmap.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ManageUsers {

	private WebDriver driver;

	public ManageUsers(WebDriver driver) {
		this.driver = driver;
	}

	public String selectSubTabUnderManageUser(String tabName) {
		String menubar = "";
		List<WebElement> sidemenubarList;
		try {
			Thread.sleep(3000);
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			sidemenubarList = Locators.getInstance().menuListUnderManageUser(driver);
			for (WebElement ele : sidemenubarList) {
				if (Keywords.getText(ele).equalsIgnoreCase(tabName)) {
					menubar = ele.getText();
					Keywords.click(ele);
					Thread.sleep(2000);
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(tabName + " tab click successfully", "PASS", tabName + " tab should be click");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while click on the " + tabName + " tab", "FAIL", tabName + " tab should be click");
		}

		return menubar;
	}

	public void searchForAdmin(String orgName) {
		WebElement element;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().adminSearch(driver);
			Keywords.typeText(element, orgName);
			Thread.sleep(3000l);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(orgName + " type successfully",
						"PASS", orgName + " should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(orgName + " not type successfully",
						"FAIL", orgName + " should be entered");
			verifySearchTitle(orgName);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the " + orgName, "FAIL", orgName + " should be entered");
		}
	}

	public void verifySearchTitle(String orgTitle) {
		List<WebElement> searchTitleList;
		WebElement element;
		String waitTxt = "Showing 1 to 1 of 1 entries";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().getAdminSearchResultStatus(driver);
			Keywords.waitForText(driver, element, waitTxt);

			if (Keywords.getText(element).trim().equalsIgnoreCase(waitTxt)) {
				searchTitleList = Locators.getInstance().adminSearchResult(driver);
				if (Keywords.getText(searchTitleList.get(0)).equalsIgnoreCase(orgTitle)) {
					if (DriverSession.getStepResult())
						DriverSession.getLastExecutionReportingInstance().teststepreporting(orgTitle + " find successfully",
								"PASS", orgTitle + " should be present");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(orgTitle + " not find successfully",
							"FAIL", orgTitle + " should be present");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing search " + orgTitle + " Name", "FAIL",
					orgTitle + " should be present");
		}
	}

	public void deleteUserFromAdmin(String userName) {
		List<WebElement> searchTitleList;
		WebElement deleteBtn;
		try {
			Keywords.waitForPage(driver, 10);
			searchTitleList = Locators.getInstance().adminSearchResult(driver);
			deleteBtn = Locators.getInstance().deleteBtn(driver);
			for (int i = 0; i < searchTitleList.size(); i++) {
				if (Keywords.getText(searchTitleList.get(i)).equalsIgnoreCase(userName)) {
					Keywords.click(deleteBtn);
					Keywords.acceptAlert();
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							userName + " delete successfully", "PASS", userName + " should be deleted");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting the " + userName, "FAIL", userName + " should be deleted");
		}
	}
	
	public void deleteOrgFromAdmin(String orgName) {
		List<WebElement> searchTitleList;
		WebElement deleteBtn;
		try {
			Keywords.waitForPage(driver, 10);
			searchTitleList = Locators.getInstance().adminSearchResult(driver);
			deleteBtn = Locators.getInstance().deleteBtn(driver);
			for (int i = 0; i < searchTitleList.size(); i++) {
				if (Keywords.getText(searchTitleList.get(i)).equalsIgnoreCase(orgName)) {
					Keywords.click(deleteBtn);
					Keywords.acceptAlert();
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							orgName + " delete successfully", "PASS", orgName + " should be deleted");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting the " + orgName, "FAIL", orgName + " should be deleted");
		}
	}
}
