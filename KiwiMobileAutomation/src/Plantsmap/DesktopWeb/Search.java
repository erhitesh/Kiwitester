package Plantsmap.DesktopWeb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Search {

	private WebDriver driver;

	public Search(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchText(String searchTxt) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().searchBox(driver);
			Keywords.typeText(element, searchTxt);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						searchTxt + " Text enter successfully", "PASS", searchTxt + " Text should be enter.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						searchTxt + " Text not enter successfully", "FAIL", searchTxt + " Text should be enter.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the Search Text", "FAIL", searchTxt + " Text should be enter.");
		}
	}

	public void submitSearch() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitSearchBox(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Button click successfully",
						"PASS", "Search Button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Search Button not click successfully", "FAIL", "Search Button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the Search button", "FAIL", "Search Button should be click");
		}
	}

	public void search(String searchText) {
		enterSearchText(searchText);
		submitSearch();
	}

	public void selectProfileOrOrgFromSearchResult(String type) {
		WebElement element;
		try {
			Thread.sleep(5000);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectIndividualFromSearchResult(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(type + " click successfully",
						"PASS", type + " imageview should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(type + " not click successfully",
						"FAIL", type + " imageview should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + type, "FAIL", type + " imageview should be click");
		}
	}

	public String selectPlantCollectionOrgIndividualFromSearch(String searchType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectPlantCollectionOrgIndividualFromSearchResult(driver, searchType);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(searchType + " click successfully",
						"PASS", searchType + " imageview should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						searchType + " not click successfully", "FAIL", searchType + " imageview should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + searchType, "FAIL",
					searchType + " imageview should be click");
		}

		return searchType;
	}

	public void selectUserProfile(String userName) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectUserProfileFromGivenList(driver, userName);
			
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(userName))
					Keywords.click(elementList.get(i));
			}

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(userName + " click successfully",
						"PASS", userName + " should be click");
			} else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(userName + " not click successfully", "FAIL", userName + " should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + userName, "FAIL", userName + " should be click");
		}
	}
	
	public void selectUserProfileBasedOnIndex(String userName, int indexNumber) {
		List<WebElement> elementList;
		try {
			Keywords.waitForPage(driver);
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().selectUserProfileFromGivenList(driver, userName);
			
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(userName) && i == indexNumber)
					Keywords.click(elementList.get(i));
			}

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(userName + " click successfully",
						"PASS", userName + " should be click");
			} else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(userName + " not click successfully", "FAIL", userName + " should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + userName, "FAIL", userName + " should be click");
		}
	}
	
	public int getPlantsCountFromSearchResult() {
		List<WebElement> elementList;
		List<Integer> plantsList = new ArrayList<>();
		int maxPlantIndexNumber = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			elementList = Locators.getInstance().getPlantsListOnSearch(driver);
			for (WebElement element : elementList)
				plantsList.add(Integer.parseInt(Keywords.getText(element)));
			maxPlantIndexNumber = plantsList.indexOf(Collections.max(plantsList));
			System.out.println("Max Plant Index Number..."+maxPlantIndexNumber);
		}catch(Exception e) {}
		
		return maxPlantIndexNumber;
	}
	
	public int getPlantcount(int indexNumber) {
		WebElement element;
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().getPlantsListOnSearch(driver).get(indexNumber);
			count = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return count;
	}
	
	public int getCollectioncount(int indexNumber) {
		WebElement element;
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().getCollectionListOnSearch(driver).get(indexNumber);
			count = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return count;
	}
	
	public int getOrgcount(int indexNumber) {
		WebElement element;
		int count = 0;
		try {
			Keywords.waitForPageFullyLoaded(driver);
			element = Locators.getInstance().getOrgListOnSearch(driver).get(indexNumber);
			count = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return count;
	}
	
	public Map<String, Integer> getUserOrOrgInfo(int indexNumber) {
		Map<String, Integer> userProfileOrOrg = new HashMap<>();
		try {
			userProfileOrOrg.put("plant", getPlantcount(indexNumber));
			userProfileOrOrg.put("collection", getCollectioncount(indexNumber));
			userProfileOrOrg.put("org", getCollectioncount(indexNumber));
		}catch(Exception e) {}
		
		return userProfileOrOrg;
	}

	public void verifyUserProfilePageLoad(String userName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifySelectUserProfile(driver, userName);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						userName + " profile present successfully", "PASS", userName + " profile should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						userName + " not profile present successfully", "FAIL",
						userName + " profile should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing " + userName + " Profile", "FAIL",
					userName + " profile should be present");
		}
	}

	public void verifySelectProfileOrOrgPageLoaded(String selectedType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyProfileOrOrgPageLoaded(driver, selectedType);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						selectedType + " profile/Org page loaded successfully", "PASS",
						selectedType + " profile/Org should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						selectedType + " profile/Org page not loaded successfully", "FAIL",
						selectedType + " profile/Org should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					selectedType + " profile/Org page not loaded successfully", "FAIL",
					selectedType + " profile/Org should be present");
		}
	}

	public void clickOnProfileFollowButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().profileFollowBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Follow button click successfully",
						"PASS", "Follow button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follow button not click successfully", "FAIL", "Follow button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the follow button", "FAIL", "Follow button should be click");
		}
	}

	public void clickOnOrgConnectButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().orgConnectBtn(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().submitConnectPopup(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Connect button click successfully",
						"PASS", "Connect button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Connect button not click successfully", "FAIL", "Connect button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the Connect button", "FAIL",
					"Connect button should be click");
		}
	}

	public void verifyPlantsListAfterFollowUser(String verifyType) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyNotAddedAnyPhotoCollectionOrgEventMessage(driver, verifyType);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (Keywords.isElementPresent(element)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"There are no " + verifyType + " added yet. message present successfully", "PASS",
						"There are no " + verifyType + " should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"There are no " + verifyType + " added yet message not present successfully", "FAIL",
						"There are no " + verifyType + " should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing There are no " + verifyType + " added yet.", "FAIL",
					"There are no " + verifyType + " should be present");
		}
	}

	public void verifyPlantsListAfterFollowUserProfileAddingPlants(String verifyType, String plantTitleName) {
		//WebElement element;
		boolean status = false;
		try {
			Thread.sleep(5000);
			Plants plant = new Plants(DriverSession.getLastExecutionDriver());
			Keywords.waitForPage(driver);
			status = plant.plantsVisibility(verifyType);
			if (!status) {
				plant.selectPlantFromPlantTab(plantTitleName);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"User plants visible to the other follow user successfully", "PASS",
						"<b>Follow user information should be visible</b>");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follow User plants not visible successfully", "FAIL",
						"<b>Follow user information should be visible</b>");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the follow user information", "FAIL",
					"<b>Follow user information should be visible</b>");
		}

		/*
		 * element = Locators.getInstance().
		 * verifyNotAddedAnyPhotoCollectionOrgEventMessage(driver, verifyType);
		 * if (!Keywords.isElementPresent(element)) {
		 * plant.selectPlantFromPlantTab(plantTitleName);
		 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
		 * "User plants visible to the other follow user successfully", "PASS",
		 * "<b>Follow user information should be visible</b>"); } else
		 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
		 * "Follow User plants not visible successfully", "FAIL",
		 * "<b>Follow user information should be visible</b>");
		 * 
		 * } catch (Exception e) {
		 * DriverSession.getLastExecutionReportingInstance().teststepreporting(
		 * "Exception occurred while verifing the follow user information",
		 * "FAIL", "<b>Follow user information should be visible</b>"); }
		 */
	}

	public void selectUserOrg(String orgName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectUserOrgFromOrgList(driver, orgName);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(orgName + " click successfully",
						"PASS", orgName + " should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(orgName + " not click successfully",
						"FAIL", orgName + " should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the " + orgName, "FAIL", orgName + " should be click");
		}
	}

	public void verifyUserOrgPageLoad(String orgName) {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifySelectUserOrg(driver, orgName);
			Keywords.verifyTextOnPage(Keywords.getText(element));

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						orgName + " organization present successfully", "PASS",
						orgName + " organization should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						orgName + " not organization present successfully", "FAIL",
						orgName + " organization should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing " + orgName + " organization", "FAIL",
					orgName + " organization should be present");
		}
	}

	public void clickOnOrganizationFollowButton() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().clickOnOrgFollowButton(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Follow button click successfully",
						"PASS", "Follow button should be click");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follow button not click successfully", "FAIL", "Follow button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the follow button", "FAIL", "Follow button should be click");
		}
	}

	public int getSearchResult() {
		WebElement element;
		int searchResult = 0;
		try {
			element = Locators.getInstance().searchResult(driver);
			searchResult = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {

		}
		return searchResult;
	}

	public List<String> getSearchModulesList(String followType) {
		List<String> modulesList = new ArrayList<>();
		List<WebElement> modulesElementList;
		try {
			modulesElementList = Locators.getInstance().searchModuleList(driver);
			for (int i = 0; i < modulesElementList.size(); i++) {
				if (Keywords.getText(modulesElementList.get(i)).equalsIgnoreCase(followType)) {
					Keywords.click(modulesElementList.get(i));
					break;
				}
			}
		} catch (Exception e) {
		}

		return modulesList;
	}
}
