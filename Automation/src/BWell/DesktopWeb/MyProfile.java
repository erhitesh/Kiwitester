package BWell.DesktopWeb;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class MyProfile {

	private WebDriver driver;

	public MyProfile(WebDriver driver) {
		this.driver = driver;
	}

	public int getPointCount() {
		int points = 0;
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().getPointCounts(driver), 20);
			element = Locators.getInstance().getPointCounts(driver);
			points = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return points;
	}

	public void backToProfilePage() {
		WebElement element;
		try {
			element = Locators.getInstance().backToProfilePageBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMyProfilePage() {
		WebElement element;
		try {
			SettingPanel setting = new SettingPanel(driver);
			setting.enableSettingPanelView();
			element = Locators.getInstance().myProfileBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			setting.disableSettingPanelView();
			Keywords.waitForObject(Locators.getInstance().profileEditBtn(driver), 10);

			if (Keywords.getCurrentUrl(driver).contains("profile")) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>My Profile Page</b> open successfully", "PASS", "<b>My Profile Page</b> should be opened");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>My Profile Page</b> not open successfully", "FAIL",
						"<b>My Profile Page</b> should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>My Profile Page</b> page open", "FAIL",
					"<b>My Profile Page</b> should be opened");
		}
	}

	public String switchAccountUser() {
		String switchuserName = "";
		WebElement element;
		List<WebElement> accountUserList;
		try {
			element = Locators.getInstance().enableUserAccountDropdown(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			accountUserList = Locators.getInstance().getAccountUserList(driver);
			if (accountUserList.size() > 1) {
				Keywords.click(accountUserList.get(1));
				switchuserName = Keywords.getText(accountUserList.get(1));
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Account </b>switch successfully", "PASS", "<b>User Account </b>should be switched");
			} else if (accountUserList.size() == 1)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Only One User Account Add More </b>", "PASS", "<b>User Account </b>should not be switched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Account </b>not switch successfully", "FAIL",
						"<b>User Account </b>should be switched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while switching the <b>User Account </b>", "FAIL",
					"<b>User Account </b>should be switched");
		}
		return switchuserName;
	}

	public String getSelectedAccountName() {
		String accountName = "";
		WebElement element;
		try {
			// SettingPanel setting = new SettingPanel(driver);
			// setting.enableSettingPanelView();
			element = Locators.getInstance().getSelectedAccountName(driver);
			accountName = Keywords.getText(element);
			// setting.disableSettingPanelView();
		} catch (Exception e) {
		}

		return accountName;
	}

	public void verifyUserNameInSelectAcc(String accName) {
		List<WebElement> userElementList;
		try {
			userElementList = Locators.getInstance().getAccountUserList(driver);
			for (WebElement webElement : userElementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(accName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Added User Name </b>successfully display", "PASS",
							"<b>Added User Name </b>should be displayed inside Select Account list.");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Added User Name </b>In Account List", "FAIL",
					"<b>Added User Name </b>should be displayed inside Select Account list.");
		}
	}

	// about me
	public int getUserAge() {
		int age = 0;
		WebElement element;
		try {
			element = Locators.getInstance().getUserAge(driver);
			age = Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
		}

		return age;
	}

	public String getUserPhoneNumber() {
		String number = "";
		WebElement element;
		try {
			clickOnEditBtn();
			Keywords.explicitWait(5);
			element = Locators.getInstance().profileUserPhoneNumber(driver);
			number = Keywords.getTextByJS(ElementEnum.Name.getElementType(),
					Keywords.getAttributeVal(element, ElementEnum.Name.getElementType()));
		} catch (Exception e) {
		}

		return number;
	}

	public void enterUserHeight() {
		int height = 0;
		int feet = 0;
		WebElement element;
		try {
			height = Keywords.getRandomIntegerBtRange(1, 8);
			feet = Keywords.getRandomIntegerBtRange(1, 11);
			element = Locators.getInstance().enterUserHeightInFeets(driver);
			Keywords.typeText(element, height + "");
			element = Locators.getInstance().enterUserHeightInInches(driver);
			Keywords.typeText(element, feet + "");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height </b>enter successfully", "PASS", "<b>User Height </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Height not </b>enter successfully", "FAIL", "<b>User Height </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>User Height </b>", "PASS",
					"<b>User Height </b>should be entered");
		}
	}

	public int enterUserWeight(int weightInLBS) {
		int weight = weightInLBS;
		WebElement element;
		try {
			element = Locators.getInstance().getUserWeight(driver);
			Keywords.typeText(element, weightInLBS + "");

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight Enter </b>successfully", "PASS", "<b>User Weight </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Weight not Enter </b>successfully", "FAIL", "<b>User Weight </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>User Weight not Enter </b>successfully", "FAIL", "<b>User Weight </b>should be entered");
		}

		return weight;
	}

	public void verifyErrorMsgForProfileRequiredFields() {
		try {
			if (Locators.getInstance().errorMsgForWeightStatus(driver)
					&& Locators.getInstance().errorMsgForHeightStatus(driver))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Both Error Message Display Successfully</b>", "PASS",
						"<b>Both Error Message Should be Display</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Both Error Message not Display Successfully</b>", "BUG",
						"<b>Both Error Message Should be Display</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while verifing the Error Msg <b>for weight & height</b>", "BUG",
					"<b>Both Error Message Should be Display</b>");
		}
	}

	public void enterWrongUserWeight() {
		// WebElement element;
		try {
			// element = Locators.getInstance().getUserWeight(driver);
			Keywords.enterTextByJS("document.getElementsByName('weight')[0].value=2-5;");
			Keywords.click(Locators.getInstance().editProfileDoneBtn(driver));
			Keywords.explicitWait(5);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invalid Weight Enter </b>successfully", "FAIL",
						"<b>Invalid Weight </b>should not be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invalid Weight not Enter </b>successfully", "PASS",
						"<b>Invalid Weight </b>should not be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Invalid Weight not Enter </b>successfully", "PASS",
					"<b>Invalid Weight </b>should not be entered");
		}
	}

	public void clickOnEditBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().profileEditBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Button</b> click successfully", "PASS", "<b>Edit Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Button</b> not click successfully", "FAIL", "<b>Edit Button</b> should be clicked");
			Keywords.explicitWait(8);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Edit Button</b>", "FAIL",
					"<b>Edit Button</b> should be clicked");
		}
	}

	public void verifyEditProfileHeaderTxt(WebDriver driver) {
		WebElement element;
		try {
			Keywords.explicitWait(3);
			element = Locators.getInstance().editProfileHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("edit profile"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Profile</b> Header text found successfully", "PASS",
						"<b>Edit Profile</b> Header text should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Profile</b> Header text not found successfully", "FAIL",
						"<b>Edit Profile</b> Header text should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Edit Profile</b> Header text", "FAIL",
					"<b>Edit Profile</b> Header text should be found");
		}
	}

	public String getProfileUserFName() {
		String fName = "";
		WebElement element;
		try {
			element = Locators.getInstance().profileUserFName(driver);
			fName = Keywords.getText(element);
		} catch (Exception e) {
		}
		return fName;
	}

	public String updateUserLastName(String name) {
		WebElement element;
		try {
			element = Locators.getInstance().profileUserLName(driver);
			Keywords.typeText(element, name);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Profile Last Name </b>" + name + " updated successfully", "PASS",
						"<b>User Profile Last Name </b>" + name + " should be updated");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Profile Last Name </b>" + name + " not updated successfully", "FAIL",
						"<b>User Profile Last Name </b>" + name + " should be updated");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating <b>User Profile Last Name </b>" + name, "FAIL",
					"<b>User Profile Last Name </b>" + name + " should be updated");
		}

		return name;
	}

	public String getProfileUserName() {
		String userName = "";
		WebElement element;
		try {
			Thread.sleep(2000);
			element = Locators.getInstance().getProfielUserName(driver);
			userName = Keywords.getText(element);
		} catch (Exception e) {
		}

		return userName;
	}

	public boolean profileDoneBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().editProfileDoneBtn(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void closeMyProfileEditWindow() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().closeEditMyProfile(driver), 20);
			element = Locators.getInstance().closeEditMyProfile(driver);
			Keywords.click(element);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 20);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Profile Window </b> submit successfully", "PASS",
						"<b>Edit Profile Window </b> should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Edit Profile Window </b> not submit successfully", "FAIL",
						"<b>Edit Profile Window </b> should be submitted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Edit Profile Window</b>", "FAIL",
					"<b>Edit Profile Window </b> should be submitted");
		}
	}

	public void submitProfileChanges() {
		WebElement element;
		try {
			element = Locators.getInstance().editProfileDoneBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 20);
			Thread.sleep(2000);
			// if (profileDoneBtnStatus())
			// Keywords.click(element);
			// else {
			// }
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Changes </b> submit successfully", "PASS",
						"<b>Profile Changes </b> should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Profile Changes </b> not submit successfully", "FAIL",
						"<b>Profile Changes </b> should be submitted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Done Button</b>", "FAIL",
					"<b>Profile Changes </b> should be submitted");
		}
	}

	// Manage Subscription
	public void selectProfileSubTask(String taskName) {
		List<WebElement> element;
		try {
			Keywords.explicitWait(3);
			element = Locators.getInstance().profileTabList(driver);
			Keywords.waitForObject(element.get(0), 20);
			for (WebElement webElement : element) {
				if (Keywords.getText(webElement).equalsIgnoreCase(taskName)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							taskName + " <b> successfully click</b>", "PASS", taskName + " <b> should be clicked</b>");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					taskName + " <b> successfully not click</b>", "FAIL", taskName + " <b> should be clicked</b>");
		}
	}

	public void verifyMemberUnderSubscription(List<String> memberInfo) {
		WebElement element;
		List<WebElement> relationElementList;
		List<WebElement> memberElementList;
		try {
			element = Locators.getInstance().manageYourSubscriptionHeagerTxt(driver);
			if (Keywords.isElementPresent(element)) {
				relationElementList = Locators.getInstance().relationListUnderSubscription(driver);
				memberElementList = Locators.getInstance().memberListUnderSubscription(driver);
				for (int i = 0; i < relationElementList.size(); i++) {
					if (Keywords.getText(memberElementList.get(i)).equalsIgnoreCase(memberInfo.get(0))
							&& Keywords.getText(relationElementList.get(i)).equalsIgnoreCase(memberInfo.get(2))) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<b>Member Name & Relation </b>successfully find under manage subscription", "PASS",
								"<b>Member Name & Relation </b>should be found under Manage Subscription List.");
						break;
					}
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Member Name & Relation </b>successfully not find under manage subscription", "FAIL",
					"<b>Member Name & Relation </b>should be found under Manage Subscription List.");
		}
	}

	public boolean addFamilyMemberBtnVisiblityStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().addFamilyMember(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}
		return status;
	}

	public void clickOnAddFamilyMember() {
		WebElement element;
		try {
			element = Locators.getInstance().addFamilyMember(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().addMemberSubscriptionHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add Subscription Member"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Member Button</b> click successfully", "PASS",
						"<b>Add Family Member Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Family Member Button</b> not click successfully", "FAIL",
						"<b>Add Family Member Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Add Family Member Button</b>", "FAIL",
					"<b>Add Family Member Button</b> should be clicked");
		}
	}

	public void closeAddSubscriptionWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().hideAddMemberSubscriptionWindow(driver);
			if (Keywords.isElementPresent(element))
				Keywords.click(element);
		} catch (Exception e) {
			element = Locators.getInstance().hideAddMemberSubscriptionWindow(driver);
			Keywords.click(element);
		}
	}

	public String enterMemberFirstName() {
		WebElement element;
		String fName = "";
		try {
			fName = Keywords.getRandomAlphabetic(6);
			element = Locators.getInstance().memberFname(driver);
			Keywords.typeText(element, fName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member First Name</b> enter successfully", "PASS",
						"<b>Subscription Member First Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member First Name</b> not enter successfully", "FAIL",
						"<b>Subscription Member First Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Subscription Member First Name</b>", "FAIL",
					"<b>Subscription Member First Name</b> should be entered");
		}
		return fName;
	}

	public String enterMemberFirstName(String memberFName) {
		WebElement element;
		String fName = "";
		try {
			fName = memberFName + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().memberFname(driver);
			Keywords.typeText(element, fName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member First Name</b> enter successfully", "PASS",
						"<b>Subscription Member First Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member First Name</b> not enter successfully", "FAIL",
						"<b>Subscription Member First Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Subscription Member First Name</b>", "FAIL",
					"<b>Subscription Member First Name</b> should be entered");
		}
		return fName;
	}

	public String updateFAndLName() {
		String userName = "";
		String fName = "";
		String lName = "";
		WebElement element;
		try {
			fName = DriverSession.getTestCaseData().get("Fname") + Keywords.getRandomAlphabetic(6);
			element = Locators.getInstance().memberFname(driver);
			Keywords.typeText(element, fName);
			lName = DriverSession.getTestCaseData().get("Lname") + Keywords.getRandomAlphabetic(6);
			;
			element = Locators.getInstance().memberLname(driver);
			Keywords.typeText(element, lName);
			userName = fName + " " + lName;

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Member User Name</b> enter successfully", "PASS",
						"<b>Member User Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Member User Name</b> not enter successfully", "FAIL",
						"<b>Member User Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Member User Name</b>", "FAIL",
					"<b>Member User Name</b> should be entered");
		}
		return userName;
	}

	public String enterMemberLastName() {
		WebElement element;
		String lName = "";
		try {
			lName = Keywords.getRandomAlphabetic(6);
			element = Locators.getInstance().memberLname(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Last Name</b> enter successfully", "PASS",
						"<b>Subscription Member Last Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Last Name</b> not enter successfully", "FAIL",
						"<b>Subscription Member Last Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Subscription Member Last Name</b>", "FAIL",
					"<b>Subscription Member Last Name</b> should be entered");
		}
		return lName;
	}

	public String enterMemberLastName(String memberLName) {
		WebElement element;
		String lName = "";
		try {
			lName = memberLName + Keywords.getRandomIntegerBtRange(100, 999);
			element = Locators.getInstance().memberLname(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Last Name</b> enter successfully", "PASS",
						"<b>Subscription Member Last Name</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Last Name</b> not enter successfully", "FAIL",
						"<b>Subscription Member Last Name</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Subscription Member Last Name</b>", "FAIL",
					"<b>Subscription Member Last Name</b> should be entered");
		}
		return lName;
	}

	public String getRandomRelationValue() {
		List<String> relationList = new ArrayList<>();
		relationList.add("Son");
		relationList.add("Daughter");
		relationList.add("Husband");
		relationList.add("Wife");

		return relationList.get(Keywords.getRandomInteger(relationList.size()));
	}

	public boolean haveOnlyOneSpouseStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().haveOnlyOneSpouse(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public String getAlreadySelectedRelationValue() {
		String selectRelationName = "";
		WebElement element;
		try {
			element = Locators.getInstance().getSelectMemberRelation(driver);
			selectRelationName = Keywords.getText(element);
		} catch (Exception e) {
		}
		return selectRelationName;
	}

	public String selectMemberRelation() {
		WebElement element;
		String relation = "";
		try {
			relation = getRandomRelationValue();
			element = Locators.getInstance().enableMemberRelationDropDown(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
			element = Locators.getInstance().selectMemberRelationDropDownValue(driver, relation);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Relation</b> select successfully", "PASS",
						"<b>Subscription Member Relation</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Relation</b> not select successfully", "FAIL",
						"<b>Subscription Member Relation</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Subscription Member Relation</b>", "FAIL",
					"<b>Subscription Member Relation</b> should be selected");
		}
		return relation;
	}

	public String selectMemberRelation(String relationValue) {
		WebElement element;
		try {
			element = Locators.getInstance().enableMemberRelationDropDown(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
			element = Locators.getInstance().selectMemberRelationDropDownValue(driver, relationValue);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Relation</b> select successfully", "PASS",
						"<b>Subscription Member Relation</b> should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Relation</b> not select successfully", "FAIL",
						"<b>Subscription Member Relation</b> should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Subscription Member Relation</b>", "FAIL",
					"<b>Subscription Member Relation</b> should be selected");
		}
		return relationValue;
	}

	public String updateMemberRelation() {
		WebElement element;
		String relation = "";
		List<WebElement> elementList;
		try {
			element = Locators.getInstance().getSelectMemberRelation(driver);
			relation = Keywords.getText(element);
			element = Locators.getInstance().enableMemberRelationDropDown(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
			elementList = Locators.getInstance().memberRelationDropDownValues(driver);
			for (WebElement webElement : elementList) {
				if (!webElement.getText().equalsIgnoreCase(relation)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Subscription Member Relation</b> Updated successfully", "PASS",
							"<b>Subscription Member Relation</b> should be Updated");
					break;
				}

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while updating <b>Subscription Member Relation</b>", "FAIL",
					"<b>Subscription Member Relation</b> should be Updated");
		}
		return relation;
	}

	public void submitFamilyMemberForEmailValidation() {
		WebElement element;
		try {
			element = Locators.getInstance().submitSubscriptonAddFamilyMember(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String errorMessageForReAndSelfInviteId() {
		String msg = "";
		WebElement element;
		try {
			element = Locators.getInstance().errorMsgForReAndSelfInvitesId(driver);
			msg = Keywords.getText(element);
		} catch (Exception e) {
		}
		return msg;
	}

	public String enterMemberEmailAddress(String mailId) {
		WebElement element;
		try {
			element = Locators.getInstance().memberEmailAddress(driver);
			Keywords.typeText(element, mailId);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Email</b> enter successfully", "PASS",
						"<b>Subscription Member Email</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Email</b> not enter successfully", "FAIL",
						"<b>Subscription Member Email</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Exception occurred while enteriing Subscription Member Email</b>", "FAIL",
					"<b>Subscription Member Email</b> should be entered");
		}
		return mailId;
	}

	public String enterMemberEmailAddress() {
		int randomNumber = 0;
		WebElement element;
		String email = "";
		String selectedRelation = "";
		try {
			element = Locators.getInstance().memberEmailAddress(driver);
			Keywords.typeText(element, DriverSession.getTestCaseData().get("Username"));
			submitFamilyMemberForEmailValidation();

			if (errorMessageForReAndSelfInviteId().equalsIgnoreCase(DriverSession.getTestCaseData().get("InvitesSelf"))
					|| errorMessageForReAndSelfInviteId()
							.equalsIgnoreCase(DriverSession.getTestCaseData().get("ReInvitesError")))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>You cannot invite yourself/Already msg </b>successfully display", "PASS",
						"<b>You cannot invite yourself/Already msg </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>You cannot invite yourself/Already msg </b>not successfully display", "BUG",
						"<b>You cannot invite yourself/Already msg </b>should be displayed");
			Keywords.explicitWait(5);
			if (haveOnlyOneSpouseStatus()) {
				selectedRelation = getAlreadySelectedRelationValue();
				selectedRelation = (getRandomRelationValue().equalsIgnoreCase(selectedRelation)) ? "Son" : "Daughter";
				selectMemberRelation(getRandomRelationValue());
			}
			randomNumber = Keywords.getRandomIntegerBtRange(100000000, 999999999);
			email = DriverSession.getTestCaseData().get("MailStarts") + randomNumber + "qatest@yopmail.com";
			element = Locators.getInstance().memberEmailAddress(driver);
			Keywords.typeText(element, email);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Email</b> enter successfully", "PASS",
						"<b>Subscription Member Email</b> should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Email</b> not enter successfully", "FAIL",
						"<b>Subscription Member Email</b> should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Subscription Member Email</b>", "FAIL",
					"<b>Subscription Member Email</b> should be entered");
		}
		return email;
	}

	public void enableDateView() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().enableDateView(driver), 10);
			element = Locators.getInstance().enableDateView(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Date Popup Display successfully</b>", "PASS", "<b>Date Popup should be Displayed</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Date Popup not Display successfully</b>", "FAIL", "<b>Date Popup should be Displayed</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while enabling <b>Date Popup</b>", "FAIL",
					"<b>Date Popup should be Displayed</b>");
		}
	}

	public void clickOnPreviousBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().previousBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void clickOnNextBtn() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().nextBtn(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public void changeYearMonthDayView() {
		WebElement element;
		try {
			element = Locators.getInstance().changeYearMonthViewValue(driver);
			Keywords.click(element);
		} catch (Exception e) {
		}
	}

	public boolean verifyYearMonthViewVisible(String viewType) {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyYearMonthViewVisible(driver);
			if (Keywords.getAttributeVal(element, "class").contains(viewType))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public boolean verifyDayViewVisible(String viewType) {
		WebElement element;
		boolean status = false;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().verifyDayViewVisible(driver);
			if (Keywords.getAttributeVal(element, "class").contains(viewType))
				status = true;
		} catch (Exception e) {
		}

		return status;
	}

	public String dateHeaderValue() {
		WebElement element;
		String headerValue = "";
		try {
			element = Locators.getInstance().dateHeadervalue(driver);
			headerValue = Keywords.getText(element);
		} catch (Exception e) {
		}

		return headerValue;
	}

	public String selectYearValue(int yearValue) {
		List<WebElement> yearList;
		int randomYear = 0;
		try {
			Keywords.waitForPage(driver);
			randomYear = Keywords.getRandomIntegerBtRange(1900, 2017);
			if (yearValue > 0)
				randomYear = yearValue;
			yearList = Locators.getInstance().yearsList(driver);
			while (Integer.parseInt(Keywords.getText(yearList.get(0))) > randomYear) {
				clickOnPreviousBtn();
				yearList = Locators.getInstance().yearsList(driver);
			}
			for (int i = 0; i < yearList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(yearList.get(i))) == randomYear) {
					Keywords.click(yearList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Year Value </b>" + randomYear + " selected successfully", "PASS",
							"<b>Year Value </b>" + randomYear + " should be selected");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Year Value </b>" + randomYear + "", "FAIL",
					"<b>Year Value </b>" + randomYear + " should be selected");
		}

		return randomYear + "";
	}

	public String selectMonthValue() {
		List<WebElement> monthList;
		String randomMonthValue = "";
		int randomNumber = 0;
		int updatedNumber = 0;
		String monthValue = "";
		try {
			Keywords.waitForPage(driver);
			randomNumber = Keywords.getRandomIntegerBtRange(0, 12);
			randomMonthValue = Keywords.getMonthsValueList("short").get(randomNumber);
			monthList = Locators.getInstance().monthsList(driver);
			for (int i = 0; i < monthList.size(); i++) {
				if (Keywords.getText(monthList.get(i)).equalsIgnoreCase(randomMonthValue)) {
					Keywords.click(monthList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month </b>" + randomMonthValue + " selected successfully", "PASS",
							"<b>Month </b>" + randomMonthValue + " should be selected");
					break;
				}
			}
			updatedNumber = Keywords.numberDigitCount(randomNumber);
			if (updatedNumber == 1)
				monthValue = new DecimalFormat("00").format(updatedNumber);

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Month </b>" + randomMonthValue, "FAIL",
					"<b>Month </b>" + randomMonthValue + " should be selected");
		}

		return monthValue;
	}

	public int selectDayValue() {
		List<WebElement> dayList;
		int randomDayValue = 0;
		try {
			Keywords.waitForPage(driver);
			dayList = Locators.getInstance().daysList(driver);
			randomDayValue = Keywords.getDayOfTheMonth();
			for (int i = 0; i < dayList.size(); i++) {
				if (Integer.parseInt(Keywords.getText(dayList.get(i))) == randomDayValue) {
					Keywords.click(dayList.get(i));
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Month Of The Day </b>" + randomDayValue + " selected successfully", "PASS",
							"<b>Month Of The Day </b>" + randomDayValue + " should be selected");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting <b>Month Of The Day</b>" + randomDayValue + "", "FAIL",
					"<b>Month Of The Day</b>" + randomDayValue + " should be selected");
		}

		return randomDayValue;
	}

	public String selectDate(int yearValue) {
		String date = "";
		String year = "";
		String month;
		String day;
		try {
			enableDateView();
			while (!dateHeaderValue().contains("-"))
				changeYearMonthDayView();
			year = selectYearValue(yearValue);
			month = selectMonthValue();
			day = String.valueOf(selectDayValue());
			date = month + "/" + day + "/" + year;
		} catch (Exception e) {
		}

		return date;
	}

	public void verifyErrorMessageForBlankDate() {
		WebElement element;
		try {
			element = Locators.getInstance().errorMsgForDateField(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>This is required msg </b>successfully displayed", "PASS",
						"<b>This is required msg </b>should be displayed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>This is required msg </b>successfully not displayed", "FAIL",
						"<b>This is required msg </b>should be displayed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>This is required msg </b>", "FAIL",
					"<b>This is required msg </b>should be displayed");
		}
	}

	public String selectCurrentAge() {
		String age = "";
		WebElement element;
		try {
			enableDateView();
			element = Locators.getInstance().selectCurrentDate(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Date </b>successfully selected", "PASS", "<b>Current Date </b>should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Current Date </b>successfully selected", "PASS", "<b>Current Date </b>should be selected");
		} catch (Exception e) {
		}

		return age;
	}

	public boolean isEmailMandatory() {
		boolean emailVisility = false;
		WebElement element;
		try {
			element = Locators.getInstance().emailLabelStatus(driver);
			emailVisility = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return emailVisility;
	}

	public boolean verifyAgeRelatedCheckForMemberSubscription(List<String> ageList) {
		boolean status = false;
		String diffType = "year";
		float yearDiff = 0;
		WebElement element;
		String selectedDate = "";
		try {
			selectedDate = selectDate(Integer.parseInt(ageList.get(0)));
			yearDiff = Keywords.getYearMonthDayDiff(Keywords.convertDateIntoLocalDate(selectedDate, "MM/dd/yyyy"),
					LocalDate.now(), diffType);
			if (yearDiff >= 13 && isEmailMandatory())// if
														// (Integer.parseInt(ageList.get(0))
														// >= 13 &&
														// isEmailMandatory())
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Fields </b>successfully Display", "PASS", "<b>Email Fields </b>should be mandatory");
				status = true;
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Fields </b> not Mandatory", "BUG", "<b>Email Fields </b>should be mandatory");
			Keywords.click(Locators.getInstance().submitSubscriptonAddFamilyMember(driver));
			element = Locators.getInstance().emailErrorMsg(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Field </b>Error Message Display successfully", "PASS",
						"<b>Email Field Error Message </b>should be displaye");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Email Field </b>Error Message not Display successfully", "BUG",
						"<b>Email Field Error Message </b>should be displaye");
			selectedDate = selectDate(Integer.parseInt(ageList.get(1)));
			yearDiff = Keywords.getYearMonthDayDiff(Keywords.convertDateIntoLocalDate(selectedDate, "MM/dd/yyyy"),
					LocalDate.now(), diffType);
			if (Integer.parseInt(ageList.get(1)) < 13 && !isEmailMandatory())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Email Fields </b>Mandatory",
						"PASS", "<b>Email Fields </b>should not be mandatory");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Email Fields </b>Error Message",
						"BUG", "<b>Email Fields </b>should not be mandatory");
		} catch (Exception e) {

		}

		return status;
	}

	public void subscriptionSaveBtn() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().submitSubscriptonAddFamilyMember(driver), 5);
			element = Locators.getInstance().submitSubscriptonAddFamilyMember(driver);
			Keywords.click(element);

			Keywords.explicitWait(5);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Save Button </b>click successfully", "PASS",
						"<b>Subscription Member Save Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Save Button </b>click successfully", "FAIL",
						"<b>Subscription Member Save Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Subscription Member Save Button </b>", "FAIL",
					"<b>Subscription Member Save Button </b>should be clicked");
		}
	}

	public void submitSubscriptionMember() {
		String selectedRelation = "";
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().submitSubscriptonAddFamilyMember(driver), 5);
			element = Locators.getInstance().submitSubscriptonAddFamilyMember(driver);
			Keywords.click(element);
			if (Keywords.isElementPresent(element))
				Keywords.click(element);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			Keywords.explicitWait(5);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Save Button </b>click successfully", "PASS",
						"<b>Subscription Member Save Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Save Button </b>click successfully", "FAIL",
						"<b>Subscription Member Save Button </b>should be clicked");
			if (haveOnlyOneSpouseStatus()) {
				selectedRelation = getAlreadySelectedRelationValue();
				selectedRelation = (getRandomRelationValue().equalsIgnoreCase(selectedRelation)) ? "Son" : "Daughter";
				selectMemberRelation(getRandomRelationValue());
				element = Locators.getInstance().submitSubscriptonAddFamilyMember(driver);
				Keywords.click(element);
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Subscription Member Save Button </b>", "FAIL",
					"<b>Subscription Member Save Button </b>should be clicked");
		}
	}

	public void verifyFamilyMemberSuccessfullyAddedMessage() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().familyMemberSuccessfullyAddedMessage(driver), 20);
			element = Locators.getInstance().familyMemberSuccessfullyAddedMessage(driver);
			if (Keywords.getText(element)
					.equalsIgnoreCase(DriverSession.getTestCaseData().get("MemberSuccessfullyAddedMsg"))) {
				element = Locators.getInstance().submitFamilyMemberAddedWindowPopup(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member Added Message </b>successfully display", "PASS",
						"<b>Family Member Added Message </b>should be display");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while checking the visiblity <b>Family Member Added </b>message", "FAIL",
					"<b>Family Member Added </b>message should be visible");
		}
	}

	public void viewFamilyMember() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().viewFamilyMemberBtn(driver), 5);
			element = Locators.getInstance().viewFamilyMemberBtn(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Family Button </b>click successfully", "PASS",
						"<b>View Family Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Family Button </b>click successfully", "FAIL",
						"<b>View Family Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>View Family Button </b>", "FAIL",
					"<b>View Family Button </b>message should be clicked");
		}
	}

	public void verifyAddedMemberUserName(String memberName) {
		WebElement element;
		try {
			element = Locators.getInstance().addedFamilyMember(driver, memberName);
			if (Keywords.getText(element).equalsIgnoreCase(memberName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Added Member </b>" + memberName + " find successfully", "PASS",
						"<b>Added Member </b>" + memberName + " should be found.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Added Member </b>" + memberName + " not find successfully", "FAIL",
						"<b>Added Member </b>" + memberName + " should be found.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Added Member </b>" + memberName, "FAIL",
					"<b>Added Member </b>" + memberName + " should be found.");
		}
	}

	public void clickOnAddMember() {
		WebElement element;
		try {
			element = Locators.getInstance().addMember(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			element = Locators.getInstance().addMemberSubscriptionHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add Subscription Member"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Member Button</b> click successfully", "PASS",
						"<b>Add Member Button</b> should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Member Button</b> not click successfully", "FAIL",
						"<b>Add Member Button</b> should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Add Member Button</b>", "FAIL",
					"<b>Add Member Button</b> should be clicked");
		}
	}

	public List<String> updateAddedMemberInfo(String memberName) {
		List<String> updatedInfo = new ArrayList<>();
		WebElement element;
		try {
			element = Locators.getInstance().editAddedMemberSubscriptionBtn(driver, memberName);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Edit Button </b>click successfully",
					"PASS", "<b>Edit Button</b>should be clicked");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			updatedInfo.add(updateFAndLName());
			updatedInfo.add(updateMemberRelation());
			submitSubscriptionMember();
			verifyAndSubmitMemberInfoUpdatePopup();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Edit Button </b>", "FAIL",
					"<b>Edit Button </b>message should be clicked");
		}

		return updatedInfo;
	}

	public List<String> getAddedFamilyMemberList() {
		List<String> memberList = new ArrayList<>();
		List<WebElement> memberElementList;
		try {
			memberElementList = Locators.getInstance().addedMemberList(driver);
			for (int i = 0; i < memberElementList.size(); i++)
				memberList.add(Keywords.getText(memberElementList.get(i)));
		} catch (Exception e) {
		}

		return memberList;
	}

	public void deleteSubscriptionMember(String familyMemberName) {
		WebElement element;
		try {
			if (getAddedFamilyMemberList().size() > 0) {
				element = Locators.getInstance().deleteBtnForSubscriptionMember(driver, familyMemberName);
				Keywords.click(element);
				element = Locators.getInstance().memberSubscriptionMessageBeforeDelete(driver);
				if (Keywords.getText(element).contains("to remove this member from your subscription plan")) {
					element = Locators.getInstance().yesIAmSureBtn(driver);// submitSubscriptionMemberDeleteMessagePopup(driver);
					Keywords.click(element);
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Family Member from Subscription deleted successfully</b>", "PASS",
							"<b>Family Member from Subscription</b>should be deleted");
				}
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Family Member In Subscription</b>", "INFO",
						"<b>Please Add First Family Member In Subscription</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting <b>Family Member from Subscription</b>", "FAIL",
					"<b>Family Member from Subscription</b>should be deleted");
		}
	}

	public void deleteSubscriptionMember() {
		List<WebElement> elementList;
		WebElement element;
		try {
			if (getAddedFamilyMemberList().size() > 0) {
				elementList = Locators.getInstance().deleteMemberSubscriptionBtnList(driver);
				for (int i = elementList.size() - 1; i >= 0; i--) {
					Keywords.click(elementList.get(i));
					element = Locators.getInstance().memberSubscriptionMessageBeforeDelete(driver);
					if (Keywords.getText(element).contains("to remove this member from your subscription plan")) {
						element = Locators.getInstance().yesIAmSureBtn(driver);
						Keywords.click(element);
						Locators.getInstance().waitImageLoaderToBeInvisible(driver, 4);
						Keywords.explicitWait(1);
						elementList = Locators.getInstance().deleteMemberSubscriptionBtnList(driver);
					}
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Family Member from Subscription successfully deleted</b>", "PASS",
						"<b>Family Member from Subscription</b>should be deleted");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>No Family Member In Subscription</b>", "INFO",
						"<b>Please Add First Family Member In Subscription</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting <b>Family Member from Subscription</b>", "FAIL",
					"<b>Family Member from Subscription</b>should be deleted");
		}
	}

	public void verifyAndSubmitMemberInfoUpdatePopup() {
		WebElement element;
		String expectedMessage = DriverSession.getTestCaseData().get("UpdateMsg");
		try {
			element = Locators.getInstance().memberSubscriptionInfoUpdatedMessage(driver);
			if (Keywords.getText(element).equalsIgnoreCase(expectedMessage)) {
				element = Locators.getInstance().submitUpdatedMemberInfoMessagePopup(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Info </b>updation message visible successfully", "PASS",
						"<b>Subscription Member Info </b>updation message should be visible");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Subscription Member Info </b>updation message not  visible successfully", "FAIL",
						"<b>Subscription Member Info </b>updation message should be visible");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing & submit the <b>Subscription Member Info </b>updation message",
					"FAIL", "<b>Subscription Member Info </b>updation message should be visible");
		}
	}
}
