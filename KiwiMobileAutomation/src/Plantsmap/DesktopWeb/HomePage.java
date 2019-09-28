package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> exploreInnerTabData() {
		List<String> data = new ArrayList<String>();
		data.add("Explore Plants");
		data.add("Explore Collections");
		data.add("Explore Community");
		data.add("Explore Resources");
		data.add("Explore Events");

		return data;
	}

	public List<String> aboutInnerTabData() {
		List<String> about = new ArrayList<String>();
		about.add("About Us");
		about.add("Help");
		about.add("Tags & Signs");
		about.add("Pricing");
		about.add("Blog");
		about.add("Contact Us");

		return about;
	}

	public List<String> headerLinksText() {
		List<String> headerLinks = new ArrayList<String>();
		headerLinks.add("About");
		headerLinks.add("Home");
		headerLinks.add("Explore");
		headerLinks.add("Map");
		headerLinks.add("My Plants Map");

		return headerLinks;
	}

	public String selectHeaderTab(String headerTabName) {
		WebElement element;
		String headerTab = headerTabName;
		try {
			Thread.sleep(3000);
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().headerLinkOption(driver, headerTabName);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						headerTabName + " Tab successfully click", "PASS", headerTabName + " Tab should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						headerTabName + " Tab not successfully click", "FAIL",
						headerTabName + " Tab should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the " + headerTabName + " Tab", "FAIL",
					headerTabName + " Tab should be click");
		}
		return headerTab;
	}

	public void selectHeaderHelpTab() {
		WebElement element;
		try {
			Thread.sleep(3000);
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().selectHeaderHelpTab(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Help Tab successfully clicked",
						"PASS", "Help Tab should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Help Tab not successfully clicked",
						"FAIL", "Help Tab should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the Help Tab", "FAIL", "Help Tab should be clicked");
		}

	}

	public String selectHeaderSubTab(String headerSubTabName) {
		List<WebElement> elementList;
		try {
			Thread.sleep(3000l);
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().getMainHeaderSubTabList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(headerSubTabName)) {
					Keywords.click(elementList.get(i));
					Thread.sleep(1000l);
					break;
				}
			}
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						headerSubTabName + " Tab successfully click", "PASS",
						headerSubTabName + " Tab should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						headerSubTabName + " Tab not successfully click", "FAIL",
						headerSubTabName + " Tab should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the " + headerSubTabName + " Tab", "FAIL",
					headerSubTabName + " Tab should be click");
		}
		return headerSubTabName;
	}

	public String selectExploreInnerTab(String tabName) {
		List<WebElement> innerTab;
		String selectTabName = "";
		try {
			selectHeaderTab("Explore");
			innerTab = Locators.getInstance().innerTabListOfExplore(driver);
			while (!Keywords.isElementPresent(innerTab.get(innerTab.size() - 1))) {
				selectHeaderTab("Explore");
			}
			for (WebElement ele : innerTab) {
				selectTabName = Keywords.getText(ele);
				if (selectTabName.contains(tabName)) {
					ele.click();
					break;
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Explore Inner Tab " + selectTabName + " click successsfully", "PASS",
						"Explore Inner Tab " + selectTabName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Explore Inner Tab not " + selectTabName + " click successsfully", "FAIL",
						"Explore Inner Tab " + selectTabName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the Explore Inner Tab " + selectTabName, "FAIL",
					"Explore Inner Tab " + selectTabName + " should be selected");
		}

		return selectTabName;
	}

	public void verifyHeaderLink() {
		// List<String> header = headerLinksText();
	}

	public void verifyFooterLink() {
		WebElement element;
		List<String> header = footerLinksText();
		List<String> handles;
		String url = "";
		int i = 0;
		try {
			handles = Keywords.getWindowHandles(driver);
			for (i = 0; i < header.size(); i++) {
				element = Locators.getInstance().footerLinkOption(driver, header.get(i));
				element.click();
				Keywords.waitForPage(driver);
				handles = Keywords.getWindowHandles(driver);
				if (handles.size() == 1) {
					element = Locators.getInstance().headerTitle(driver);
					if (Keywords.isElementPresent(element)) {
						if (DriverSession.getStepResult()) {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									header.get(i) + " Tab click successfully", "PASS",
									header.get(i) + " Tab should be click");
						} else
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									header.get(i) + " Tab not click successfully", "FAIL",
									header.get(i) + " Tab should be click");
					}
				} else if (handles.size() > 1) {
					Keywords.switchToWindowHandle(driver, handles.size() - 1);
					Thread.sleep(2000);
					element = Locators.getInstance().footerNewTabHeaderTitle(driver);
					url = driver.getCurrentUrl();
					if (url.contains("https://") && Keywords.isElementPresent(element)) {
						if (DriverSession.getStepResult()) {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									header.get(i) + " Tab click successfully", "PASS",
									header.get(i) + " Tab should be click");
						} else {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									header.get(i) + " Tab not click successfully", "FAIL",
									header.get(i) + " Tab should be click");
						}
						Keywords.closeWindow(driver);
					}
					handles = Keywords.getWindowHandles(driver);
					Keywords.switchToWindowHandle(driver, handles.size() - handles.size());
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the linked text " + header.get(i), "FAIL",
					header.get(i) + " Tab should be click");
		}
	}

	public List<String> footerLinksText() {
		List<String> footerLinks = new ArrayList<String>();
		footerLinks.add("Home");
		footerLinks.add("Explore");
		footerLinks.add("Maps");
		footerLinks.add("Tags");
		footerLinks.add("Pricing");
		footerLinks.add("Resources");
		footerLinks.add("Blog");
		footerLinks.add("About Us");
		footerLinks.add("Help");
		footerLinks.add("Contact Us");
		footerLinks.add("Terms of Services");
		footerLinks.add("Privacy Policy");
		footerLinks.add("Copyright Policy");
		footerLinks.add("Sitemap");

		return footerLinks;
	}

	public List<String> getHomeSubHeaderTab() {
		List<String> list = new ArrayList<String>();
		list.add("plants");
		list.add("collection");
		list.add("community");
		list.add("resources");
		list.add("events");

		return list;
	}

	public String selectHomeSubHeaderTab(String subTabName) {
		WebElement subHeaderTab;
		String selectedTabName = subTabName;
		try {
			selectHeaderTab("Home");
			Keywords.waitForPage(driver);
			subHeaderTab = Locators.getInstance().subTabsOfHomeHeader(driver, subTabName.toLowerCase());
			Keywords.click(subHeaderTab);
			Thread.sleep(2000);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						subTabName.toUpperCase() + " Tab click successfully", "PASS",
						subTabName.toUpperCase() + " Tab should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						subTabName.toUpperCase() + " Tab not click successfully", "FAIL",
						subTabName.toUpperCase() + " Tab should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the <b>" + subTabName.toUpperCase() + "</b> Tab", "FAIL",
					subTabName.toUpperCase() + " Tab should be click");
		}

		return selectedTabName;
	}

	public void verifyOrganizationConnectToTheNetwork(String organizationName) {
		List<WebElement> list;
		WebElement element;
		try {
			list = Locators.getInstance().getCommunityList(driver, organizationName);
			for (int i = 0; i < list.size(); i++) {
				if (Keywords.getText(list.get(i)).equalsIgnoreCase(organizationName)) {
					Keywords.click(list.get(i));
					Thread.sleep(2000l);
					element = Locators.getInstance().verifyOrganizationPageLoaded(driver);
					Keywords.verifyTextOnPage(Keywords.getText(element));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							organizationName + " page load successfully", "PASS",
							organizationName + " page should be loaded");
					break;
				}
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					organizationName + " page not load successfully", "FAIL",
					organizationName + " page should be loaded");
		}
	}

	public void checkSubTabsOfMainHeaderTabFunctionality(List<String> headerTabList) {
		String mainTabName = "";
		String subTabName = "";
		List<WebElement> subTabList;
		for (int i = 1; i < headerTabList.size(); i++) {
			DriverSession.setReporting(false);
			mainTabName = selectHeaderTab(headerTabList.get(i));
			DriverSession.setReporting(true);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						mainTabName + " Tab click successfully", "PASS", mainTabName + " Tab should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						mainTabName + " Tab not click successfully", "FAIL", mainTabName + " Tab should be click");
			subTabList = Locators.getInstance().getMainHeaderSubTabList(driver);
			for (int j = 0; j < subTabList.size(); j++) {
				subTabName = Keywords.getText(subTabList.get(j));
				Keywords.waitForPage(driver);
				Keywords.click(subTabList.get(j));
				if (DriverSession.getStepResult())
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							subTabName + " Tab click successfully", "PASS", subTabName + " Tab should be click");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							subTabName + " Tab not click successfully", "FAIL", subTabName + " Tab should be click");
				subTabList = Locators.getInstance().getMainHeaderSubTabList(driver);
				Keywords.waitForPage(driver);
			}
		}
	}

	public void navigateToHomePlant() {
		try {
			HomePage home = new HomePage(driver);
			home.selectHomeSubHeaderTab("plants");
		} catch (Exception e) {

		}
	}

	public void verifySubTabOfExploreLink() {
		WebElement element;
		List<String> innerTabData = exploreInnerTabData();
		int i = 0;
		try {
			element = Locators.getInstance().innerTabsOfExploreLink(driver, innerTabData.get(0));
			if (!Keywords.isElementPresent(element)) {
				Thread.sleep(2000);
				selectHeaderTab("Explore");
			}
			for (i = 0; i < innerTabData.size(); i++) {
				element = Locators.getInstance().innerTabsOfExploreLink(driver, innerTabData.get(i));
				Keywords.isElementPresent(element);
				if (DriverSession.getStepResult()) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							innerTabData.get(i) + " Tab of explore link present.", "PASS",
							innerTabData.get(i) + " Tab of Explore link should be present");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							innerTabData.get(i) + " Tab of explore link not present.", "FAIL",
							innerTabData.get(i) + " Tab of Explore link should be present");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the " + innerTabData.get(i) + " Tab", "FAIL",
					innerTabData.get(i) + " Tab of Explore link should be present");
		}
	}

	public void verifyAboutInnerTab(String tabName) {
		WebElement element;
		List<String> innerTabData = aboutInnerTabData();
		List<String> windowHandle;
		List<String> mainWindowHandle;
		String innerTabsUrl = "";
		try {
			mainWindowHandle = Keywords.getWindowHandles(driver);
			selectHeaderTab(tabName);
			element = Locators.getInstance().innerTabOfAboutLink(driver, innerTabData.get(0));
			for (int i = 0; i < innerTabData.size(); i++) {
				if (!Keywords.isElementPresent(element))
					selectHeaderTab(tabName);
				Keywords.waitForPage(driver);
				element = Locators.getInstance().innerTabOfAboutLink(driver, innerTabData.get(i));
				Keywords.click(element);
				windowHandle = Keywords.getWindowHandles(driver);
				Thread.sleep(2000);
				Keywords.switchToWindowHandle(driver, windowHandle.size() - 1);
				Thread.sleep(2000);
				innerTabsUrl = Keywords.getCurrentUrl(driver);
				if (innerTabsUrl.contains("https://") || innerTabsUrl.contains(innerTabData.get(i).toLowerCase())) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Inner Tabs of About Link contains <b>https</b> & " + innerTabData.get(i) + " in the url",
							"PASS", "Inner Tabs of About Link should be contains https & " + innerTabData.get(i)
									+ " in the url");
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"Inner Tabs of About Link not contains <b>https</b> & " + innerTabData.get(i)
									+ " in the url",
							"FAIL", "Inner Tabs of About Link should be contains https & " + innerTabData.get(i)
									+ " in the url");
				Keywords.closeWindow(driver);
				Keywords.switchToWindowHandle(driver, mainWindowHandle.size() - 1);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing Inner Tabs of About", "FAIL", "About inner tab should be open");
		}
	}

	public void clickOnAddNewTag() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addNewTag(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>AddNew Button</b> click successfully", "PASS", "<b>AddNew Button</b> should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>AddNew Button</b> not click successfully", "FAIL",
						"<b>AddNew Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the <b>AddNew Button</b>", "FAIL",
					"<b>AddNew Button</b> should be clicked");
		}
	}

	public void selectAddOptionTag(String optionTagName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addOptionTag(driver, optionTagName);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						optionTagName + " click successfully", "PASS", optionTagName + " should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						optionTagName + " not click successfully", "FAIL", optionTagName + " should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred.. while click on the " + optionTagName, "FAIL",
					optionTagName + " should be clicked");
		}
	}
}
