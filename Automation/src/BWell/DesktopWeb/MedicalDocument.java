package BWell.DesktopWeb;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class MedicalDocument {

	private WebDriver driver;

	public MedicalDocument(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnMedicalDocumentBtn() {
		// WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().TapOnMedicalDocumentsBtn(driver), 15);
			Keywords.clickByJS("document.getElementsByClassName('btn bw-btn-rightside filters')[0].click();");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Documents button </b>click successfully", "PASS",
						"<b>Medical Documents button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Documents button </b>not click successfully", "FAIL",
						"<b>Medical Documents button </b>should be clicked");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 15);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Medical Documents button </b>", "FAIL",
					"<b>Medical Documents button </b>should be clicked");
		}
	}

	public void verifyMedicalDocumentPageLoaded() {
		try {
			Keywords.waitForPageFullyLoaded(driver);
			if (Keywords.verifyPageLoaded("health-id/clinical/medical/"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Documents Page </b>open successfully", "PASS",
						"<b>Medical Documents Page </b>should be opened");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Documents Page </b>not open successfully", "FAIL",
						"<b>Medical Documents Page </b>should be opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Medical Documents Page </b>", "FAIL",
					"<b>Medical Documents Page </b>should be opened");
		}
	}

	public void addDocumentBtn() {
		WebElement element;
		try {
			element = Locators.getInstance().addDocumentBtn(driver);
			if (Keywords.isElementPresent(element)) {
				Keywords.clickByJS("document.getElementsByClassName('icon-add-circle')[0].click();");
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Documents button </b>click successfully", "PASS",
						"<b>Add Documents button </b>should be clicked");
				element = Locators.getInstance().addMedicalDocumentHeaderTxt(driver);
				if (Keywords.isElementPresent(element))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Add Medical Documents Header Text </b>visible successfully", "PASS",
							"<b>Add Medical Documents Header Text </b>should be present");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Add Medical Documents Header Text </b>not visible successfully", "FAIL",
							"<b>Add Medical Documents Header Text </b>should be present");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Documents button </b>not click successfully", "FAIL",
						"<b>Add Documents button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Documents button </b>", "FAIL",
					"<b>Add Documents button </b>should be clicked");
		}
	}

	public String addMedicalDocumentName() {
		String name = "";
		WebElement element;
		try {
			name = "Medical Document Test" + Keywords.getRandomAlphabetic(8);
			element = Locators.getInstance().documentName(driver);
			Keywords.typeText(element, name);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document Name </b>enter successfully", "PASS",
						"<b>Medical Document Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document Name </b>enter successfully", "FAIL",
						"<b>Medical Document Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Medical Document Name </b>", "FAIL",
					"<b>Medical Document Name </b>should be entered");
		}
		return name;
	}

	public String addMedicalDocumentFile() {
		Medications medication = new Medications(driver);
		String fileName = medication.getDrugImageRandomName();
		String fileLocation = "";
		RemoteWebElement element;
		try {
			element = (RemoteWebElement) Locators.getInstance().addDocumentFile(driver);
			element.setFileDetector(new LocalFileDetector());
			fileLocation = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "BWellFiles" + GlobalParam.slash + fileName;
			Keywords.typeText(element, fileLocation);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document File </b>upload successfully", "PASS",
						"<b>Medical Document File </b>should be uploaded");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document File </b>not upload successfully", "FAIL",
						"<b>Medical Document File </b>should be uploaded");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading <b>Medical Document File </b>", "FAIL",
					"<b>Medical Document File </b>should be uploaded");
		}
		return fileName;
	}

	public void clearMedicalDocumentFile() {
		WebElement element;
		try {
			element = Locators.getInstance().clearBtn(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document File </b>clear successfully", "PASS",
						"<b>Medical Document File </b>should be cleared");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document File </b>not clear successfully", "FAIL",
						"<b>Medical Document File </b>should be cleared");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clearing <b>Medical Document File </b>", "FAIL",
					"<b>Medical Document File </b>should be cleared");
		}
	}

	public void submitMedicalDocumentWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitMedicalDocumentInfo(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document Info </b>submit successfully", "PASS",
						"<b>Medical Document Info </b>should be submitted");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Document Info </b>not submit successfully", "FAIL",
						"<b>Medical Document Info </b>should be submitted");
			Keywords.explicitWait(5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Medical Document Info </b>", "FAIL",
					"<b>Medical Document Info </b>should be submitted");
		}
	}

	public String medicalDocumentFileName() {
		String fileName = "";
		try {
			fileName = Keywords.getTextByJS("return document.getElementById('docFile').value;");
		} catch (Exception e) {
		}

		return fileName;
	}

	public void verifyMedicalDocumentFileAfterClear(String actualFileName, String fileNameAfterClear) {
		try {
			if (actualFileName.equalsIgnoreCase(fileNameAfterClear) || fileNameAfterClear == "")
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Added File Clear </b>successfully", "PASS", "<b>Added File </b>should be cleared");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Added File not Clear </b>successfully", "FAIL", "<b>Added File </b>should be cleared");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clearing the <b>Added File </b>", "FAIL",
					"<b>Added File </b>should be cleared");
		}
	}

	public void searchMedicalDocument(String addedDocumentName) {
		WebElement element;
		List<WebElement> searchElementList;
		try {
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			Keywords.explicitWait(5);
			element = Locators.getInstance().searchAddedDocument(driver);
			Keywords.typeText(element, addedDocumentName);
			element.sendKeys(Keys.ENTER);
			Keywords.explicitWait(5);
			searchElementList = Locators.getInstance().docFileList(driver);
			for (WebElement webElement : searchElementList) {
				if (Keywords.getText(webElement).equalsIgnoreCase(addedDocumentName)) {
					Keywords.click(webElement);
					Keywords.explicitWait(1);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"b>Added Document File Name </b>match successfully", "PASS",
							"<b>Added Document File Name </b>should be matched");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"b>Added Document File Name </b>not match successfully", "FAIL",
					"<b>Added Document File Name </b>should be matched");
		}
	}

	public List<String> getDocumentDateList() {
		List<String> info = new ArrayList<>();
		List<WebElement> dateElementList;
		try {
			dateElementList = Locators.getInstance().docAddedDate(driver);
			for (WebElement webElement : dateElementList)
				info.add(Keywords.getText(webElement));
		} catch (Exception e) {
		}
		return info;
	}

	public void resetFilter() {
		WebElement element;
		try {
			element = Locators.getInstance().resetFilterBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reset Filters Button <b/>click successfully", "PASS",
						"<b>Reset Filters Button <b/>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Reset Filters Button <b/>not click successfully", "FAIL",
						"<b>Reset Filters Button <b/>should be click");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 2);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking <b>Reset Filters Button <b/>", "FAIL",
					"<b>Reset Filters Button <b/>should be click");
		}
	}

	public String startDate(String dateFor) {
		String dob = "";
		int year = 0;
		String dayValue = "";
		String monthValue = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			FamilyHistory family = new FamilyHistory(driver);
			element = Locators.getInstance().enableStartDateWindow(driver);
			Keywords.click(element);
			while (!family.verifyYearMonthViewVisible("year"))
				family.changeYearMonthDayView();
			year = family.selectYearValue();
			family.verifySelectedYearValue(year);
			while (!family.verifyYearMonthViewVisible("month"))
				family.changeYearMonthDayView();
			if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
				Thread.sleep(2000);
				elementList = Locators.getInstance().monthsList(driver);
				for (int i = 0; i < elementList.size(); i++) {
					if (Keywords.getText(elementList.get(i)).equalsIgnoreCase(Keywords.getCurrentYMDValue("month"))) {
						monthValue = Keywords.getText(elementList.get(i));
						elementList.get(i).click();
						break;
					}
				}
			} else
				monthValue = family.selectMonthValue();
			family.verifySelectedMonthValue(monthValue);
			while (!family.verifyDayViewVisible("weeks"))
				family.changeYearMonthDayView();
			if (year == Integer.parseInt(Keywords.getCurrentYMDValue("year"))) {
				element = Locators.getInstance().selectCurrentDayValue(driver);
				if (Keywords.getText(element).equalsIgnoreCase(Keywords.getCurrentYMDValue("day")))
					dayValue = Keywords.getText(element);
				Keywords.click(element);
			} else
				dayValue = family.selectDayValue();
			dayValue = new DecimalFormat("00").format(dayValue);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + "<b> Date selection from date view visible successfully</b>", "PASS",
						dateFor.toUpperCase() + "<b> Date selection from view should be present in dob textbox</b>");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						dateFor.toUpperCase() + "<b> Date selection from view not visible indob text box</b>", "FAIL",
						dateFor.toUpperCase() + "<b> Date selection from view should be present in dob textbox</b>");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Excetion occurred while entering the " + dateFor.toUpperCase() + "<b> Family Member DOB</b>",
					"FAIL",
					dateFor.toUpperCase() + "<b> Date selection from view should be present in dob textbox</b>");
		}
		element = Locators.getInstance().enableEpisodeDateWindow(driver, dateFor);
		Keywords.click(element);
		element = Locators.getInstance().selectCurrentDayValue(driver);
		Keywords.click(element);
		dob = Keywords.getCurrentDate("MM/dd/yyyy");

		return dob;
	}

	public void applyFilterOnMedicalDocument() {
		try {

		} catch (Exception e) {

		}
	}

	// Share Medical Document Related Task
	public void clickOnShareBtn() {
		WebElement element;
		try {
			Keywords.explicitWait(8);
			element = Locators.getInstance().shareDocumentBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Button </b>click successfully", "PASS", "<b>Share Button </b>should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Button </b>not click successfully", "FAIL", "<b>Share Button </b>should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Share Button </b>", "FAIL",
					"<b>Share Button </b>should be click");
		}
	}

	public void verifySharePageHeaderTxt() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().shareDocumentHeaderTxt(driver);

			if (Keywords.getText(element).contains("Medical Document"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Page Header Text </b>find successfully", "PASS",
						"<b>Share Page Header Text </b>should be find");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Page Header Text </b>not find successfully", "FAIL",
						"<b>Share Page Header Text </b>should be find");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Share Page Header Text</b>", "FAIL",
					"<b>Share Button </b>should be click");
		}
	}

	public String enterShareFName() {
		String fname = "";
		WebElement element;
		try {
			fname = DriverSession.getTestCaseData().get("Fname") + Keywords.getRandomAlphabetic(10);
			element = Locators.getInstance().shareFName(driver);
			Keywords.typeText(element, fname);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share FName </b>enter successfully", "PASS", "<b>Share FName </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share FName </b>not enter successfully", "FAIL", "<b>Share FName </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Share FName </b>", "FAIL",
					"<b>Share FName </b>should be entered");
		}

		return fname;
	}

	public String enterShareLName() {
		String lname = "";
		WebElement element;
		try {
			lname = DriverSession.getTestCaseData().get("Lname") + Keywords.getRandomAlphabetic(10);
			element = Locators.getInstance().shareLName(driver);
			Keywords.typeText(element, lname);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share LName </b>enter successfully", "PASS", "<b>Share LName </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share LName </b>not enter successfully", "FAIL", "<b>Share LName </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Share LName </b>", "FAIL",
					"<b>Share LName </b>should be entered");
		}

		return lname;
	}

	public String enterShareRelation() {
		String relation = "";
		WebElement element;
		List<String> relationList = new ArrayList<>();
		try {
			relation = DriverSession.getTestCaseData().get("Relation");
			relationList = Arrays.asList(relation.split(","));
			relation = relationList.get(Keywords.getRandomInteger(relationList.size()));
			element = Locators.getInstance().shareRelation(driver);
			Keywords.typeText(element, relation);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Relation </b>enter successfully", "PASS", "<b>Share Relation </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Relation </b>not enter successfully", "FAIL",
						"<b>Share Relation </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Share Relation </b>", "FAIL",
					"<b>Share Relation </b>should be entered");
		}

		return relation;
	}

	public String enterShareEmailAddress() {
		String email = "";
		WebElement element;
		try {
			email = DriverSession.getTestCaseData().get("SharedMail");
			element = Locators.getInstance().shareEmail(driver);
			Keywords.typeText(element, email);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Email Address </b>enter successfully", "PASS",
						"<b>Share Email Address </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Email Address </b>not enter successfully", "FAIL",
						"<b>Share Email Address </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Share Email Address </b>", "FAIL",
					"<b>Share Email Address </b>should be entered");
		}

		return email;
	}

	public void submitSharePageInfo() {
		WebElement element;
		try {
			element = Locators.getInstance().submitShareWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Page Info </b>submit successfully", "PASS",
						"<b>Share Page Info </b>should be submit");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Page Info </b>not submit successfully", "FAIL",
						"<b>Share Page Info </b>should be submit");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting <b>Share Page Info </b>", "FAIL",
					"<b>Share Page Info </b>should be submit");
		}
	}

	public void verifyAndAcceptShareMedicalDocumentPHI() {
		WebElement element;
		try {
			element = Locators.getInstance().medicalDocumentConfirmationMsgBeforeShare(driver);
			if (Keywords.getText(element).contains("Your medical document contains Protected Health Information (PHI)"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>PHI(Protected Health Information) Message </b>verify successfully", "PASS",
						"<b>PHI(Protected Health Information) Message </b>should be visible");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>PHI(Protected Health Information) Message </b>not verify successfully", "FAIL",
						"<b>PHI(Protected Health Information) Message </b>should be visible");
			element = Locators.getInstance().acceptMedicalDocumentConfirmationMsgPopup(driver);
			Keywords.click(element);
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>PHI(Protected Health Information) Message </b>", "FAIL",
					"<b>PHI(Protected Health Information) Message </b>should be visible");
		}
	}

	public boolean clickHereLinkStatus() {
		boolean status = false;
		WebElement element;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			element = Locators.getInstance().clickHereLink(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}

	public void clickHereLink() {
		WebElement element;
		try {
			element = Locators.getInstance().clickHereLink(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Click Here Link </b>click successfully", "PASS",
						"<b>Click Here Link </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Click Here Link </b>not click successfully", "FAIL",
						"<b>Click Here Link </b>should be clicked");
			Keywords.explicitWait(2);
			Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Click Here Link </b>", "FAIL",
					"<b>Click Here Link </b>should be clicked");
		}
	}

	public boolean verifyInsuranceCName(String insuranceCName) {
		boolean status = false;
		WebElement element;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			element = Locators.getInstance().verifyShareInsuranceCName(driver, insuranceCName);
			status = Keywords.isElementPresent(element);
			Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
		}

		return status;
	}

	public void verifyUserName(String userName) {
		WebElement element;
		try {
			// Keywords.switchToIFrameByNameOrID(driver, "ifmail");
			element = Locators.getInstance().verifySharedMedicalUserName(driver, userName);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Name </b>found successfully", "PASS", "<b>User Name </b>should be present");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>User Name </b>not found successfully", "FAIL", "<b>User Name </b>should be present");
			// Keywords.switchBackToDefaultContent(driver);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>User Name </b>", "FAIL",
					"<b>User Name </b>should be present");
		}

	}

	public String getPasswordFromHealthTribeMemberMail() {
		String password = "";
		WebElement element;
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getHealthTribeInvitationMailLink(driver);
			if (Keywords.getText(elementList.get(0)).contains("Invited to Join the Health Tribe")) {
				Keywords.click(elementList.get(0));
				Thread.sleep(2000);
				Keywords.switchBackToDefaultContent(driver);
				Thread.sleep(2000);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				element = Locators.getInstance().getHelathTribeMemberPassword(driver);
				password = Keywords.getText(element);
				password = password.substring(password.indexOf("code ") + 5,
						password.indexOf("in the Health Tribe") - 1);
				Keywords.switchBackToDefaultContent(driver);
			}
		} catch (Exception e) {

		}
		return password;
	}

	public boolean checkPasswordInMail() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().getSharedMedicalDocumentPassword(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}
	
	public String getPasswordFromSharedMedicalDocumnetMail() {
		String password = "";
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSharedMedicalDocumentMailLink(driver);
			if (Keywords.getText(elementList.get(0)).equalsIgnoreCase("STAGING - Shared Medical Documents")) {
				Keywords.click(elementList.get(0));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				if (checkPasswordInMail())
					password = getPasswordFromMail();
				Keywords.switchBackToDefaultContent(driver);
			} else {
				Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
				Keywords.click(elementList.get(1));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				if (checkPasswordInMail())
					password = getPasswordFromMail();
			}
		} catch (Exception e) {
		}
		return password;
	}

	public void viewBWellSharedMedicalDocumentMailLink(String userName) {
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSharedMedicalDocumentMailLink(driver);
			for (int i = 0; i < 2; i++) {
				if (Keywords.getText(elementList.get(i)).equalsIgnoreCase("STAGING - Shared Medical Documents")) {
					Keywords.click(elementList.get(i));
					Keywords.explicitWait(2);
					Keywords.switchBackToDefaultContent(driver);
					if (clickHereLinkStatus()) {
						verifyUserName(userName);
						clickHereLink();
						break;
					} else {
						Keywords.switchBackToDefaultContent(driver);
						Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
						elementList = Locators.getInstance().getSharedMedicalDocumentMailLink(driver);
					}
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Reset Password Mail </b>not select successfully", "FAIL",
							"<b>Reset Password Mail </b>should be selected");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting the <b>Reset Password Mail </b>", "FAIL",
					"<b>Reset Password Mail </b>should be selected");
		}
	}

	public void enterPasswordForClinicalOrMedical(String password) {
		WebElement element;
		try {
			element = Locators.getInstance().enterPasswordForClinicalSummaryDocument(driver);
			Keywords.typeText(element, password);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Sumamry or Medical Records Authorization Document Password </b>enter successfully",
						"PASS",
						"<b>Clinical Sumamry or Medical Records Authorization Document Password </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Sumamry or Medical Records Authorization Document Password </b>not enter successfully",
						"FAIL",
						"<b>Clinical Sumamry or Medical Records Authorization Document Password </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering the <b>Clinical Sumamry or Medical Records Authorization Document Password</b>",
					"FAIL",
					"<b>Clinical Sumamry or Medical Records Authorization Document Password </b>should be entered");
		}
	}

	public void verifyClinicalSummaryDocumentImageVisiblity(String documentName) {
		WebElement element;
		try {
			Keywords.waitForObject(Locators.getInstance().clinicalSummaryDocumentImage(driver), 8);
			element = Locators.getInstance().clinicalSummaryDocumentImage(driver);
			if (Keywords.getAttributeVal(element, "src").contains(documentName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Summary Document Image </b>successfully display", "PASS",
						"<b>Clinical Summary Document Image </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Summary Document Image </b>not successfully display", "FAIL",
						"<b>Clinical Summary Document Image </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Clinical Summary Document Image </b>", "FAIL",
					"<b>Clinical Summary Document Image </b>should be display");
		}
	}

	public void verifyMedicalRecordsAuthorizationEFormDetails() {
		WebElement element;
		try {
			element = Locators.getInstance().medicalRecordsAuthorizationEFormHeaderTxt(driver);
			if (Keywords.isElementPresent(element)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization E Form </b>successfully display", "PASS",
						"<b>Medical Records Authorization E Form </b>should be display");
				element = Locators.getInstance().medicalRecordsNextBtn(driver);
				for (int i = 0; i < 2; i++)
					Keywords.click(element);
				element = Locators.getInstance().getPageNumberValue(driver);
				if (Keywords.integerParser(element) == 3)
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Page Indexing Working corrently on Medical Records Authorization E Form </b>", "PASS",
							"<b>Page Indexing on Medical Records Authorization E Form </b>should be fine");
				else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Page Indexing Working Incorrently on Medical Records Authorization E Form </b>", "FAIL",
							"<b>Page Indexing on Medical Records Authorization E Form </b>should be fine");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Medical Records Authorization E Form </b>not successfully display", "FAIL",
						"<b>Medical Records Authorization E Form </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Medical Records Authorization E Form </b>", "FAIL",
					"<b>Medical Records Authorization E Form </b>should be display");
		}
	}

	public void enterClinicalSummaryDocumentPassword(String password) {
		WebElement element;
		try {
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			element = Locators.getInstance().clinicalSummaryDocument(driver);
			if (Keywords.isElementPresent(element))
				enterPasswordForClinicalOrMedical(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPasswordFromMail() {
		String password = "";
		WebElement element;
		try {
			element = Locators.getInstance().getSharedMedicalDocumentPassword(driver);
			password = Keywords.getText(element);
			password = password.substring(password.indexOf(":") + 2, password.length());
		} catch (Exception e) {
		}

		return password;
	}

	public String getPasswordFromConnectionAuthorizationsMail() {
		String password = "";
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSharedConnectionsAuthorizationsMailLink(driver);
			if (Keywords.getText(elementList.get(0)).equalsIgnoreCase("STAGING - Shared Connection Authorizations")) {
				Keywords.click(elementList.get(0));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				if (checkPasswordInMail())
					password = getPasswordFromMail();
				Keywords.switchBackToDefaultContent(driver);
			} else {
				Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
				Keywords.click(elementList.get(1));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				Keywords.switchToIFrameByNameOrID(driver, "ifmail");
				if (checkPasswordInMail())
					password = getPasswordFromMail();
				Keywords.switchBackToDefaultContent(driver);
			}
		} catch (Exception e) {
		}
		System.out.println("Password..."+password);
		return password;
	}

	public void viewConnectionAuthorizationMailLink(String userName) {
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getSharedConnectionsAuthorizationsMailLink(driver);
			for (int i = 0; i < 2; i++) {
				if (Keywords.getText(elementList.get(i))
						.equalsIgnoreCase("STAGING - Shared Connection Authorizations")) {
					Keywords.click(elementList.get(i));
					Keywords.explicitWait(2);
					Keywords.switchBackToDefaultContent(driver);
					if (clickHereLinkStatus()) {
						verifyUserName(userName);
						clickHereLink();
						break;
					} else {
						Keywords.switchBackToDefaultContent(driver);
						Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
					}
				} else
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Click Here Link </b>not click successfully", "FAIL",
							"<b>Click Here Link </b>should be clicked");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Click Here Link</b>", "FAIL",
					"<b>Click Here Link </b>should be selected");
		}
	}

	// Share Insurance Card
	public void shareInsuranceCardMailLink(String insuranceCName) {
		List<WebElement> elementList;
		try {
			Keywords.switchToIFrameByNameOrID(driver, "ifinbox");
			elementList = Locators.getInstance().getShareInsuranceCardMailLink(driver, insuranceCName);
			if (Keywords.getText(elementList.get(0)).contains("has shared his " + insuranceCName + " with you")) {
				Keywords.click(elementList.get(0));
				Keywords.explicitWait(2);
				Keywords.switchBackToDefaultContent(driver);
				if (verifyInsuranceCName(insuranceCName))
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Share Insurance Card Name </b>successfully display", "PASS",
							"<b>Share Insurance Card Name </b>should be display");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share Insurance Card Name not </b>successfully display", "FAIL",
						"<b>Share Insurance Card Name </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Share Insurance Card Name</b>", "FAIL",
					"<b>Share Insurance Card Name </b>should be display");
		}
	}

	public void enterMedicalRecordsAuthorizationDocumentPassword(String password) {
		WebElement element;
		try {
			Keywords.switchToWindowHandle(driver, Keywords.getWindowHandles(driver).size() - 1);
			element = Locators.getInstance().medicalRecordsAuthorizationDocument(driver);
			if (Keywords.isElementPresent(element))
				enterPasswordForClinicalOrMedical(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitClinicalOrMedicalRecordsWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitClinicalOrMedicalRecords(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Sumamry or Medical Records Authorization Document Window </b>save successfully",
						"PASS",
						"<b>Clinical Sumamry or Medical Records Authorization Document Window </b>should be saved");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Clinical Sumamry or Medical Records Authorization Document Window </b>not save successfully",
						"FAIL",
						"<b>Clinical Sumamry or Medical Records Authorization Document Window </b>should be saved");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while submitting the <b>Clinical Sumamry or Medical Records Authorization Document Window </b>",
					"FAIL", "<b>Clinical Sumamry or Medical Records Authorization Document Window </b>should be saved");
		}
	}
}
