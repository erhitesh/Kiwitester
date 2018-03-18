package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class HealthTribe {

	private WebDriver driver;

	public HealthTribe(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToHealthTribePage() {
		try {
			Dashboard dashboard = new Dashboard(driver);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			dashboard.selectDashboardLeftMenu("Health Tribe");
		} catch (Exception e) {
		}
	}

	public void clickOnAddTribeMemberFromRightSide() {
		WebElement element;
		try {
			element = Locators.getInstance().addHealthTribeMemberFromRightSide(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Tribe Member </b>button click successfully", "PASS",
						"<b>Add Tribe Member </b>button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Tribe Member </b>button not click successfully", "FAIL",
						"<b>Add Tribe Member </b>button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Tribe Member </b>button", "FAIL",
					"<b>Add Tribe Member </b>button should be clicked");
		}
	}

	public void verifyHealthTribePageLoaded() {
		try {
			Keywords.verifyPageLoaded(driver, "health-tribe");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Page </b>open successfully", "PASS",
						"<b>Health Tribe Page </b> should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Page </b>not open successfully", "FAIL",
						"<b>Health Tribe Page </b> should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Health Tribe Page </b>open successfully or not", "FAIL",
					"<b>Health Tribe Page </b> should be opened");
		}
	}

	public void verifyAddTribeMemberHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().addHealthTribeMemberHeaderTxt(driver), 30);
			element = Locators.getInstance().addHealthTribeMemberHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Add tribe Member"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Tribe Member </b>header text verify successfully", "PASS",
						"<b>Add Tribe Member </b>header text should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Tribe Member </b>header text not found", "FAIL",
						"<b>Add Tribe Member </b>header text should be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Add Tribe Member </b>header text", "FAIL",
					"<b>Add Tribe Member </b>header text should be present");
		}
	}

	public String getRandomImage() {
		List<String> druglist = new ArrayList<>();
		druglist.add("Doctor1.jpg");
		druglist.add("Doctor2.jpg");
		druglist.add("Doctor3.jpg");
		druglist.add("Doctor4.jpg");

		return druglist.get(Keywords.getRandomInteger(druglist.size()));
	}

	public void addHealthTribeMemberPhoto() {
		RemoteWebElement element;
		String imageName = getRandomImage();
		String imagePath = null;
		try {
			element = (RemoteWebElement) Locators.getInstance().addTribeMemberPic(driver);
			element.setFileDetector(new LocalFileDetector());
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "BWellFiles" + GlobalParam.slash + imageName;
			Keywords.typeText(element, imagePath);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Member </b>added successfully", "PASS",
						"<b>Health Tribe Member Image </b>should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Member </b>not added successfully", "FAIL",
						"<b>Health Tribe Member Image </b>should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading <b>Health Tribe Member </b>", "FAIL",
					"<b>Health Tribe Member Image </b>should be upload");
		}
	}

	public String enterFname() {
		WebElement element;
		String fName = "";
		try {
			fName = DriverSession.getTestCaseData().get("FirstName") + Keywords.getRandomIntegerBtRange(999, 9999);
			// fName = "Tribe" + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().healthTribeFname(driver);
			Keywords.typeText(element, fName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe First Name </b>enter successfully", "PASS",
						"<b>Health Tribe First Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe First Name </b>not enter successfully", "FAIL",
						"<b>Health Tribe First Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Health Tribe First Name </b>", "FAIL",
					"<b>Health Tribe First Name </b>should be entered");
		}

		return fName;
	}

	public String enterLname() {
		WebElement element;
		String lName = "";
		try {
			lName = DriverSession.getTestCaseData().get("LastName") + Keywords.getRandomIntegerBtRange(999, 9999);
			// lName = "Member" + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().healthTribeLname(driver);
			Keywords.typeText(element, lName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Last Name </b>enter successfully", "PASS",
						"<b>Health Tribe Last Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Last Name </b>not enter successfully", "FAIL",
						"<b>Health Tribe Last Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Health Tribe Last Name </b>", "FAIL",
					"<b>Health Tribe Last Name </b>should be entered");
		}

		return lName;
	}

	public String getRandomRelationshipName() {
		List<String> info = new ArrayList<>();
		info.add("Son");
		info.add("Daughter");
		info.add("Mother");
		info.add("Father");
		info.add("Sister");
		info.add("Brother");
		info.add("Spouse");
		info.add("Other");

		return info.get(Keywords.getRandomInteger(info.size()));

	}

	public String enterRelationship() {
		String relationship = "";
		WebElement element;
		List<String> relationList;
		try {
			// relationship = getRandomRelationshipName();
			relationship = DriverSession.getTestCaseData().get("Relationship");
			relationList = Arrays.asList(relationship.split(","));
			relationship = relationList.get(Keywords.getRandomInteger(relationList.size()));
			element = Locators.getInstance().healthTribeRelationship(driver);
			Keywords.selectByVisibleText(element, relationship);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Relationship </b>enter successfully", "PASS",
						"<b>Health Tribe Relationship </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Relationship </b>not enter successfully", "FAIL",
						"<b>Health Tribe Relationship </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Health Tribe Relationship </b>", "FAIL",
					"<b>Health Tribe Relationship </b>should be entered");
		}

		return relationship;
	}

	public String enterEmailAddress() {
		WebElement element;
		String email = "";
		try {
			email = DriverSession.getTestCaseData().get("SharedMail");
			email = email + Keywords.getRandomIntegerBtRange(1000, 99999) + "@yopmail.com";
			element = Locators.getInstance().healthTribeEmailAddress(driver);
			Keywords.typeText(element, email);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Email Address </b>enter successfully", "PASS",
						"<b>Health Tribe Email Address </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Email Address </b>not enter successfully", "FAIL",
						"<b>Health Tribe Email Address </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Health Tribe Email Address </b>", "FAIL",
					"<b>Health Tribe Email Address </b>should be entered");
		}

		return email;
	}

	public String enterEmailAddress(String inviteMemberAddress) {
		WebElement element;
		try {
			element = Locators.getInstance().healthTribeEmailAddress(driver);
			Keywords.typeText(element, inviteMemberAddress);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Email Address </b>enter successfully", "PASS",
						"<b>Health Tribe Email Address </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Email Address </b>not enter successfully", "FAIL",
						"<b>Health Tribe Email Address </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Health Tribe Email Address </b>", "FAIL",
					"<b>Health Tribe Email Address </b>should be entered");
		}

		return inviteMemberAddress;
	}

	public boolean permissionToHTMMWindow() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().editPermissionToHTMMsg(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

//	public void selectLikeToShareOptions() {
//		String viewSlashEditRights = "";
//		WebElement element;
//		List<WebElement> shareOptionElementList;
//		int choiseRandomNumberSelection = Keywords.getRandomInteger(2);
//		int randomNumber = Keywords.getRandomInteger(2);
//		try {
//			if (choiseRandomNumberSelection == 0) {
//				element = Locators.getInstance().selectLikeToShareViewOptions(driver);
//				shareOptionElementList = Locators.getInstance().viewOptList(driver);
//			} else {
//				element = Locators.getInstance().selectLikeToShareEditOptions(driver);
//				shareOptionElementList = Locators.getInstance().viewOptList(driver);
//			}
//			randomNumber = Keywords.getRandomInteger(shareOptionElementList.size());
//			viewSlashEditRights = Keywords.getText(shareOptionElementList.get(randomNumber));
//			System.out.println("Random Number..."+randomNumber+"\n"+"viewSlashEditRights.."+viewSlashEditRights);
//			Keywords.click(shareOptionElementList.get(randomNumber));
//			Keywords.explicitWait(2);
//			if (choiseRandomNumberSelection == 1) {
//				if (permissionToHTMMWindow()) {
//					element = Locators.getInstance().givePermissionToHTM(driver);
//					Keywords.click(element);
//					Keywords.explicitWait(2);
//					DriverSession.getLastExecutionReportingInstance().teststepreporting(
//							"<b>Rights Provide to the Invite Health Tribe Member</b>", "PASS",
//							"<b>Edit Rights should be provides to the Invite Health Tribe Member</b>");
//				}
//			}
//
//			if (DriverSession.getStepResult())
//				DriverSession.getLastExecutionReportingInstance().teststepreporting(
//						"<b>Information Like To Share View/Edit Option </b>check successfully", "PASS",
//						"<b>Information Like To Share View/Edit Option </b>should be checked");
//			else
//				DriverSession.getLastExecutionReportingInstance().teststepreporting(
//						"<b>Information Like To Share View/Edit Option </b>not check successfully", "FAIL",
//						"<b>Information Like To Share View/Edit Option </b>should be checked");
//		} catch (Exception e) {
//			DriverSession.getLastExecutionReportingInstance().teststepreporting(
//					"Exception occurred while clicking on the <b>Information Like To Share View/Edit Option </b>",
//					"FAIL", "<b>Information Like To Share View/Edit Option </b>should be checked");
//		}
//	}
	
	public void selectLikeToShareOptions() {
		WebElement element;
		int randomNumber = Keywords.getRandomInteger(2);
		try {
			if (randomNumber == 0)
				element = Locators.getInstance().selectLikeToShareViewOptions(driver);
			else
				element = Locators.getInstance().selectLikeToShareEditOptions(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);
			if (randomNumber == 1) {
				if (permissionToHTMMWindow()) {
					element = Locators.getInstance().givePermissionToHTM(driver);
					Keywords.click(element);
					Keywords.explicitWait(2);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Rights Provide to the Invite Health Tribe Member</b>", "PASS",
							"<b>Edit Rights should be provides to the Invite Health Tribe Member</b>");
				}
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Information Like To Share View/Edit Option </b>check successfully", "PASS",
						"<b>Information Like To Share View/Edit Option </b>should be checked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Information Like To Share View/Edit Option </b>not check successfully", "FAIL",
						"<b>Information Like To Share View/Edit Option </b>should be checked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Information Like To Share View/Edit Option </b>",
					"FAIL", "<b>Information Like To Share View/Edit Option </b>should be checked");
		}
	}

	public void submitHealthTribeInfo() {
		WebElement element;
		try {
			element = Locators.getInstance().healthTribeInviteBtn(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Invite </b>button submit successfully", "PASS",
						"<b>Health Tribe Invite </b>button should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Invite </b>button not submit successfully", "FAIL",
						"<b>Health Tribe Invite </b>button should be submitted");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Health Tribe Invite </b>button", "FAIL",
					"<b>Health Tribe Invite </b>button should be submitted");
		}
	}

	public void verifyHealthTribeInviteSent() {
		WebElement element;
		try {
			element = Locators.getInstance().verifyHealthTribeInviteMessage(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Health Tribe Invite Sent"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Invite Message </b>sent successfully", "PASS",
						"<b>Health Tribe Invite Message </b>should be sent");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Invite Message </b>not sent successfully", "FAIL",
						"<b>Health Tribe Invite Message </b>should be sent");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Health Tribe Invite Message </b>", "FAIL",
					"<b>Health Tribe Invite Message </b>should be sent");
		}
	}

	public void submitGotItBtnWindow() {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().healthTribeGotItBtn(driver), 30);
			element = Locators.getInstance().healthTribeGotItBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Got It Button </b>click successfully", "PASS",
						"<b>Health Tribe Got It Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Got It Button </b>not click successfully", "FAIL",
						"<b>Health Tribe Got It Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Health Tribe Got It Button </b>", "FAIL",
					"<b>Health Tribe Got It Button </b>should be clicked");
		}
	}

	public void searchTribeMember(String tribeMemberName) {
		WebElement element;
		try {
			element = Locators.getInstance().searchTribeMember(driver);
			Keywords.typeText(element, tribeMemberName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tribe Member Name </b>enter successfully", "PASS",
						"<b>Tribe Member Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tribe Member Name </b>not enter successfully", "FAIL",
						"<b>Tribe Member Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Tribe Member Name </b>", "FAIL",
					"<b>Tribe Member Name </b>should be entered");
		}
	}

	public void clearSearchOperation() {
		WebElement element;
		try {
			element = Locators.getInstance().searchTribeMember(driver);
			Keywords.clearEditField(element);
		} catch (Exception e) {

		}
	}

	public void verifyTribeMemberFromSearchInInvitation(List<String> tribeMemberInfo) {
		List<WebElement> elementList;
		try {
			searchTribeMember(tribeMemberInfo.get(0));
			elementList = Locators.getInstance().sentInvitationList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i))
						.equalsIgnoreCase(tribeMemberInfo.get(0) + " " + tribeMemberInfo.get(1))) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>find successfully inside Invitation List", "PASS",
							"<b>Tribe Member </b>should be found inside Invitation List.");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>not find successfully inside Invitation List", "FAIL",
							"<b>Tribe Member </b>should be found inside Invitation List.");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>inside Invitation List", "FAIL",
					"<b>Tribe Member </b>should be found inside Invitation List.");
		}
	}

	public void verifyTribeMemberFromSearchInMemberList(
			/* List<String> tribeMemberInfo, */String accName) {
		String searchTerm = "";
		List<WebElement> elementList;
		try {
			searchTerm = accName.substring(0, accName.indexOf(" "));
			searchTribeMember(searchTerm);
			elementList = Locators.getInstance().HealthTribeMemberList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(accName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>find successfully inside Member List", "PASS",
							"<b>Tribe Member </b>should be found inside Member List");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>not find successfully inside Member List", "FAIL",
							"<b>Tribe Member </b>should be found inside Member List");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>inside Member List", "FAIL",
					"<b>Tribe Member </b>should be found inside Member List.");
		}
	}

	public void verifyTribeMemberInMemberList(
			/* List<String> tribeMemberInfo, */String accName) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().HealthTribeMemberList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(accName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>successfully move to Member List", "PASS",
							"<b>Tribe Member </b>should be move to Member List");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>successfully not move to Member List", "FAIL",
							"<b>Tribe Member </b>should be move to Member List");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>Move from sent to Member List", "FAIL",
					"<b>Tribe Member </b>should be move to Member List");
		}
	}

	public void selectMemberNameFromMemberList(/* List<String> memberInfo */String accountName) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().HealthTribeMemberList(driver);
			for (WebElement webElement : elementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(accountName)) {
					Keywords.click(webElement);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Member Name from List </b>select successfully", "PASS",
							"<b>Member Name from List </b>should be selected");
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Member Name from List </b>", "FAIL",
					"<b>Member Name from List </b>should be selected");
		}
	}

	public void clickOnHealthTribeCode() {
		WebElement element;
		try {
			element = Locators.getInstance().healthTribeCodeBtn(driver);
			Keywords.click(element);
			element = Locators.getInstance().healthTribeCodeHeaderTxt(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Enter Code"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Button </b>click successfully", "PASS",
						"<b>Health Tribe Code Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Button </b>not click successfully", "FAIL",
						"<b>Health Tribe Code Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Health Tribe Code Button </b>", "PASS",
					"<b>Health Tribe Code Button </b>should be clicked");
		}
	}

	public boolean codeAppliedSuccessfully() {
		boolean status = false;
		WebElement element;
		try {
			Thread.sleep(2000);
			element = Locators.getInstance().codeAppliedSuccessfully(driver);
			if (Keywords.isElementPresent(element))
				status = true;
			else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void verifyHealthTribeMemberAdded() {
		WebElement element;
		try {
			element = Locators.getInstance().memberAddedSuccessfullyMsgWindow(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS You just joined the health tribe Msg </b>display successfully", "PASS",
						"<b>CONGRATULATIONS You just joined the health tribe Msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>CONGRATULATIONS You just joined the health tribe Msg not </b>display successfully", "FAIL",
						"<b>CONGRATULATIONS You just joined the health tribe Msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>CONGRATULATIONS You just joined the health tribe Msg</b>",
					"FAIL", "<b>CONGRATULATIONS You just joined the health tribe Msg </b>should be display");
		}
	}

	public String invalidCodeApplied() {
		String errorMessage = "";
		try {
			if (Keywords.isElementPresent(Locators.getInstance().wrongHealthTribeAppliedErrorMsg(driver)))
				errorMessage = Keywords.getText(Locators.getInstance().wrongHealthTribeAppliedErrorMsg(driver));
			else
				errorMessage = Keywords.getText(Locators.getInstance().healthTribeInvalidCodeLength(driver));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return errorMessage;
	}

	public void navigateToHealthTribeCode() {
		WebElement element;
		try {
			element = Locators.getInstance().healthTribeCodeBtn(driver);
			Keywords.click(element);
			element = Locators.getInstance().healthTribeCodeHeaderTxt(driver);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Button </b>click successfully", "PASS",
						"<b>Health Tribe Code Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Button </b>successfully not click", "FAIL",
						"<b>Health Tribe Code Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Health Tribe Code Button </b>", "FAIL",
					"<b>Health Tribe Code Button </b>should be clicked");
		}
	}

	public void applyCode(String codeValue) {
		String invalidCodeErrorMessage = "";
		String invalidCodeLengthErrorMessage = "";
		WebElement element;
		try {
			invalidCodeErrorMessage = DriverSession.getTestCaseData().get("UsedCode");
			invalidCodeLengthErrorMessage = DriverSession.getTestCaseData().get("InvalidFormat");
			element = Locators.getInstance().healthTribeCodeTxtBox(driver);
			Keywords.typeText(element, codeValue);
			element = Locators.getInstance().submithealthTribeCodeWindow(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			if (codeAppliedSuccessfully()) {
				element = Locators.getInstance().submitAppliedCodeSuccessfullWindow(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code </b>apply successfully", "PASS",
						"<b>Health Tribe Code </b>should be applied");

			} else if (invalidCodeApplied().equalsIgnoreCase(invalidCodeErrorMessage)
					|| invalidCodeApplied().equalsIgnoreCase(invalidCodeLengthErrorMessage)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code </b>not apply successfully", "FAIL",
						"<b>Health Tribe Code </b>should be applied");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while applying the <b><i>Health Tribe Code </i>/b>", "FAIL",
					"<b>Health Tribe Code </b>should be Applied");
		}
	}

	public void applyHealthTribeCode(String healthTribeCode) {
		try {
			navigateToHealthTribeCode();
			applyCode(healthTribeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void applyHealthTribeInValidCode(String healthTribeCode) {
		try {
			navigateToHealthTribeCode();
			applyInvalidCode(healthTribeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeHealthTribeCodeWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().closeHealthTribeCodeWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Window </b>closed successfully", "PASS",
						"<b>Health Tribe Code Window </b>should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Health Tribe Code Window </b>successfully not closed", "FAIL",
						"<b>Health Tribe Code Window </b>should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while closing the <b>Health Tribe Code Window </b>", "FAIL",
					"<b>Health Tribe Code Window </b>should be closed");
		}
	}

	public void applyInvalidCode(String codeValue) {
		String invalidCodeErrorMessage = "";
		String invalidCodeLengthErrorMessage = "";
		WebElement element;
		try {
			invalidCodeErrorMessage = DriverSession.getTestCaseData().get("UsedCode");
			invalidCodeLengthErrorMessage = DriverSession.getTestCaseData().get("InvalidFormat");
			element = Locators.getInstance().healthTribeCodeTxtBox(driver);
			Keywords.typeText(element, codeValue);
			element = Locators.getInstance().submithealthTribeCodeWindow(driver);
			Keywords.click(element);
			if (invalidCodeApplied().equalsIgnoreCase(invalidCodeErrorMessage)
					|| invalidCodeApplied().equalsIgnoreCase(invalidCodeLengthErrorMessage)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Entered Health Tribe Code </b>not valid", "PASS",
						"<b>Entered Health Tribe Code </b>should not be applied");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Entered Health Tribe Code </b> valid", "BUG",
						"<b>Entered Health Tribe Code </b>should not be applied");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b><i>Health Tribe Code</i>/b>", "FAIL",
					"<b>Health Tribe Code </b>should not be Applied");
		}
	}

	public void deleteHealthTribeMember(String accName) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().removeTribeMemberBtn(driver), 10);
			element = Locators.getInstance().removeTribeMemberBtn(driver);
			Keywords.click(element);
			element = Locators.getInstance().verifyTribeMemberMessageBeforeDelete(driver, accName);
			if (Keywords.isElementPresent(element)) {
				element = Locators.getInstance().submitTribeMemberDeleteWindow(driver);
				Keywords.click(element);
				Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Tribe Member Button </b>click successfully", "PASS",
						"<b>Remove Tribe Member Button </b>should be clicked");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Tribe Member Button </b>not click successfully", "FAIL",
						"<b>Remove Tribe Member Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member</b>", "FAIL",
					"<b>Tribe Member </b>should be found");
		}
	}

	public void deleteHealthTribeMembersFromHTML(List<String> healthTribeMemberList) {
		WebElement element;
		List<WebElement> healthTribeMemberElementList;
		try {
			healthTribeMemberElementList = Locators.getInstance().HealthTribeMemberList(driver);
			for (int i = healthTribeMemberList.size() - 1; i >= 0; i--) {
				Keywords.clickByIndex(healthTribeMemberElementList, i);
				Keywords.explicitWait(2);
				element = Locators.getInstance().removeTribeMemberBtn(driver);
				Keywords.click(element);
				Keywords.explicitWait(2);
				element = Locators.getInstance().verifyTribeMemberMessageBeforeDelete(driver,
						healthTribeMemberList.get(i));
				// element =
				// Locators.getInstance().msgBeforeDeleteInvitation(driver);
				if (Keywords.isElementPresent(element)) {
					element = Locators.getInstance().submitTribeMemberDeleteWindow(driver);
					Keywords.click(element);
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Health Tribe Member </b>successfully deleted", "PASS",
							"<b>Health Tribe Member </b>should be deleted");
					healthTribeMemberElementList = Locators.getInstance().HealthTribeMemberList(driver);
					healthTribeMemberList = getHealthTribeMemberList();
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Health Tribe Member </b>successfully not deleted", "FAIL",
							"<b>Health Tribe Member </b>should be deleted");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting <b>Health Tribe Member from HTM</b>", "FAIL",
					"<b>Health Tribe Member </b>should be deleted");
		}
	}

	public List<String> getSentInvitationList() {
		List<String> invitationList = new ArrayList<>();
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().sentInvitationList(driver);
			for (int i = 0; i < elementList.size(); i++)
				invitationList.add(Keywords.getTextByIndex(elementList, i));
		} catch (Exception e) {
		}

		return invitationList;
	}

	public List<String> getHealthTribeMemberList() {
		List<String> memberList = new ArrayList<>();
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().HealthTribeMemberList(driver);
			for (int i = 0; i < elementList.size(); i++)
				memberList.add(Keywords.getTextByIndex(elementList, i));
		} catch (Exception e) {
		}

		return memberList;
	}

	public void verifyTribeMemberInSentInvitationList(String accName) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().sentInvitationList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(accName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>find successfully inside Sent Invitation List", "PASS",
							"<b>Tribe Member should be found inside Sent Invitation List</b>");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>not find successfully inside Sent Invitation List", "FAIL",
							"<b>Tribe Member should be found inside Sent Invitation List</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>inside Sent Invitation List", "FAIL",
					"<b>Tribe Member should be found inside Sent Invitation List</b>");
		}
	}

	public void deleteSentRequestFromInvitationList(List<String> invitationList) {
		WebElement element;
		List<WebElement> invitationDeleteBtnList;
		try {
			invitationDeleteBtnList = Locators.getInstance().invitationBtnList(driver);
			for (int i = invitationList.size() - 1; i >= 0; i--) {
				Keywords.clickByIndex(invitationDeleteBtnList, i);
				Keywords.explicitWait(2);
				element = Locators.getInstance().msgBeforeDeleteInvitation(driver);
				if (Keywords.isElementPresent(element)) {
					element = Locators.getInstance().yesIAmSureSentBtn(driver);
					Keywords.click(element);
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 3);
					Keywords.explicitWait(4);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Invitation Delete successfully from Sent invitation List</b>", "PASS",
							"<b>Invitation </b>should be deleted from Sent invitation List");
					invitationDeleteBtnList = Locators.getInstance().invitationBtnList(driver);
					invitationList = getSentInvitationList();
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Invitation not Delete successfully from Sent invitation List</b>", "FAIL",
							"<b>Invitation </b>should be deleted from Sent invitation List");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting Invitation from <b>Sent Invitation List</b>", "FAIL",
					"<b>Invitation </b>should be deleted from Sent invitation List");
		}
	}

	public void verifyTribeMemberDeleteSuccessfully(String tribeMemberName) {
		WebElement element;
		try {
			searchTribeMember(tribeMemberName);
			element = Locators.getInstance().noResultFound(driver);
			if (Keywords.getText(element).contains("No Results Found"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tribe Member </b>deleted successfully", "PASS", "<b>Tribe Member </b>should not be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Tribe Member </b>not deleted successfully", "FAIL",
						"<b>Tribe Member </b>should not be present");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>existence", "FAIL",
					"<b>Tribe Member </b>should not be present");
		}
	}

	// Accept Or Reject Health Tribe Member Invites
	public boolean checkInvitesWindowMsg() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.explicitWait(3);
			element = Locators.getInstance().invitationRecievedWindowMsg(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void viewInvites() {
		WebElement element;
		try {
			if (checkInvitesWindowMsg()) {
				element = Locators.getInstance().viewInvites(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>View Invites Message </b>display successfully", "PASS",
						"<b>View Invites Message </b>should be displayed");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>View Invites Message </b>display or not", "FAIL",
					"<b>View Invites Message </b>should be displayed");
		}
	}

	public void notViewInvites() {
		WebElement element;
		try {
			if (checkInvitesWindowMsg()) {
				element = Locators.getInstance().notViewInvites(driver);
				Keywords.click(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Not Now Btn </b>successfully click", "PASS", "<b>Not Now Btn </b>should be click");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Not Now Btn</b>", "FAIL",
					"<b>Not Now Btn </b>should be click");
		}
	}

	public void verifyTribeMemberInReceivedInvitationList(String userName) {
		List<WebElement> elementList;
		try {
			elementList = Locators.getInstance().receivedInvitationList(driver);
			for (int i = 0; i < elementList.size(); i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(userName)) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>find successfully inside Received Invitation List", "PASS",
							"<b>Tribe Member should be found inside Received Invitation List</b>");
					break;
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Tribe Member </b>not find successfully inside Received Invitation List", "FAIL",
							"<b>Tribe Member should be found inside Received Invitation List</b>");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Tribe Member </b>inside Received Invitation List", "FAIL",
					"<b>Tribe Member should be found inside Received Invitation List</b>");
		}
	}

	public void acceptInvites(String sendInvitesUserInfo) {
		List<WebElement> invitesElementList;
		List<WebElement> acceptElementList;
		try {
			acceptElementList = Locators.getInstance().receivedInvitationAcceptBtnList(driver);
			invitesElementList = Locators.getInstance().receivedInvitationList(driver);
			for (int i = 0; i < invitesElementList.size(); i++) {
				if (Keywords.getText(invitesElementList.get(i)).equalsIgnoreCase(sendInvitesUserInfo)) {
					Keywords.click(acceptElementList.get(i));
					Keywords.explicitWait(2);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Invites </b>successfully accepted", "PASS", "<b>Invites </b>should be accepted");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while accepting the <b>Invites </b>", "FAIL",
					"<b>Invites </b>should be accepted");
		}
	}

	public void verifyCongratulationMsgForJustJoinTribe(String sendInvitesUserInfo) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().congratulationMessage(driver), 30);
			element = Locators.getInstance().congratulationMessage(driver);
			if (Keywords.isElementPresent(element)) {
				element = Locators.getInstance().joinHealthTribeOfUser(driver, sendInvitesUserInfo);
				if (Keywords.getText(element).contains("You just joined the health tribe of " + sendInvitesUserInfo))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Congratulation Message Window </b>successfully display for just join Health Tribe"
									+ sendInvitesUserInfo,
							"PASS", "<b>Congratulation Message Window </b>should be display");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Congratulation Message window Message</b>", "FAIL",
					"<b>Congratulation Message Window </b>should be display");
		}
	}

	public void congratulationMsgWhileSwitchToHisAcc(String receiverInvitesUser) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().congratulationMessage(driver), 30);
			element = Locators.getInstance().congratulationMessage(driver);
			if (Keywords.isElementPresent(element)) {
				element = Locators.getInstance().receiverInvitesAcceptSuccessfully(driver);
				if (Keywords.getText(element).equalsIgnoreCase(receiverInvitesUser))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Invites </b>successfully accept", "PASS", "<b>Invites </b>should be accepted");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Invites </b>successfully not accept", "FAIL", "<b>Invites </b>should be accepted");
		}
	}

	public void closeSwitchInvitesWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().closeSwitchToHisAccWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Switch Window </b>successfully closed", "PASS", "<b>Switch Window </b>should be closed");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Switch Window </b>successfully not closed", "FAIL",
						"<b>Switch Window </b>should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurrred while closing the <b>Switch Window </b>", "FAIL",
					"<b>Switch Window </b>should be closed");
		}
	}

	public String switchToUser() {
		String usrName = "";
		WebElement element;
		try {
			element = Locators.getInstance().switchToReceiverAcc(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>User </b>successfully switch",
						"PASS", "<b>User </b>should be switch to invites user.");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>User </b>successfully switch",
						"PASS", "<b>User </b>should be switch to invites user.");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>User </b>successfully switch",
					"PASS", "<b>User </b>should be switch to invites user.");
		}

		return usrName;
	}

	public void sendInvitesBackToSender() {
		WebElement element;
		try {
			element = Locators.getInstance().sendInvitesFromReciverToSender(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Send Invites </b>successfully send back to sender", "PASS",
						"<b>Send Invites </b>should be send to sender back");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Send Invites </b>successfully not send back to sender", "FAIL",
						"<b>Send Invites </b>should be send to sender back");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while <b>Sending Invites </b>back to sender", "FAIL",
					"<b>Send Invites </b>should be send to sender back");
		}
	}

	public String getinvitesSenderName() {
		String senderName = "";
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().getSendInvitesFromReciverToSender(driver), 20);
			element = Locators.getInstance().getSendInvitesFromReciverToSender(driver);
			senderName = Keywords.getText(element);
		} catch (Exception e) {
		}

		return senderName;
	}

	public void rejectSendInvitesBackToSender() {
		WebElement element;
		try {
			element = Locators.getInstance().cancelInvitesToSender(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invites </b>successfully Cancel", "PASS",
						"<b>Invites </b>should not be send to sender back");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Invites </b>successfully send back to sender", "FAIL",
						"<b>Invites </b>should not be send to sender back");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while <b>Rejecting Invites </b>back to sender", "FAIL",
					"<b>Invites </b>should not be send to sender back");
		}
	}
}
