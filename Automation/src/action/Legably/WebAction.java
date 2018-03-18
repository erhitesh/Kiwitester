package action.Legably;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.session.DriverSession;
import com.utilities.ExcelUtility;
import com.utilities.GlobalParam;
import com.utilities.Keywords;
import com.utilities.Logs;

import Legably.DesktopWeb.BasicInfoPlusEducation;
import Legably.DesktopWeb.Experience;
import Legably.DesktopWeb.JobType;
import Legably.DesktopWeb.Login;
import Legably.DesktopWeb.Network;
import Legably.DesktopWeb.SignUp;
import action.CommonAll;

public class WebAction extends CommonAll {
	HashMap<String, String> testData = new HashMap<String, String>();

	public WebAction(WebDriver driver) {
		super(driver);
		this.testData = DriverSession.getTestCaseData();
	}

	public void verifyPageLoaded(String pageName) {
		try {
			Keywords.verifyPageLoaded(pageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login() {
		String name = "QA Tester";
		try {
			Login login = new Login(DriverSession.getLastExecutionDriver());
			login.emailAddress();
			login.userPassword();
			login.signIn();
			if (login.getLoggedInUserName().equalsIgnoreCase(name)) {
				Logs.info("Login Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}

	// fill family member info itself.

	public List<String> signUp() {
		List<String> info = new ArrayList<>();
		String password = "";
		try {
			SignUp signup = new SignUp(DriverSession.getLastExecutionDriver());
			info.add(signup.FirstName());
			info.add(signup.LastName());
			info.add(signup.emailAddress());
			password = signup.password();
			info.add(password);
			info.add(signup.ConfirmPassword(password));
			signup.checkCaptchaCheckBox();
			signup.checkTermAndConditionCheckBox();
			signup.submitSignUpForm();
			signup.clickOnStartBuildingYourProfile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public void verifyFNameOnInfoPage(String actualText) {
		BasicInfoPlusEducation basic = new BasicInfoPlusEducation(DriverSession.getLastExecutionDriver());
		String expectedMsg = basic.getFirstName();
		if (actualText.equalsIgnoreCase(expectedMsg))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>First Name</b> on signup & basic info page matches successfully", "PASS",
					"<b>First Name</b> on signup & basic info page should be same");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>First Name</b> on signup & basic info page not match successfully", "FAIL",
					"<b>First Name</b> on signup & basic info page should be same");
	}

	public void verifyLNameOnInfoPage(String actualText) {
		BasicInfoPlusEducation basic = new BasicInfoPlusEducation(DriverSession.getLastExecutionDriver());
		String expectedMsg = basic.getLastName();
		if (actualText.equalsIgnoreCase(expectedMsg))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Last Name</b> on signup & basic info page matches successfully", "PASS",
					"<b>Last Name</b> on signup & basic info page should be same");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>Last Name</b> on signup & basic info page not match successfully", "FAIL",
					"<b>Last Name</b> on signup & basic info page should be same");
	}

	public void verifyCityNameOnJobTypePage(String actualText) {
		JobType job = new JobType(DriverSession.getLastExecutionDriver());
		String expectedMsg = job.getCityNameFromJob();
		if (actualText.equalsIgnoreCase(expectedMsg))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>City Name</b> on Basic Info & Job Type page matches successfully", "PASS",
					"<b>City Name</b> on Basic Info & Job Type page should be same");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>City Name</b> on Basic Info & Job Type page not match successfully", "FAIL",
					"<b>City Name</b> on Basic Info & Job Type page should be same");
	}

	public void verifyStateNameOnJobTypePage(String actualText) {
		JobType job = new JobType(DriverSession.getLastExecutionDriver());
		String expectedMsg = job.getStateNameFromJob();
		if (actualText.equalsIgnoreCase(expectedMsg))
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>State Name</b> on Basic Info & Job Type page matches successfully", "PASS",
					"<b>State Name</b> on Basic Info & Job Type page should be same");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b>State Name</b> on Basic Info & Job Type page not match successfully", "FAIL",
					"<b>State Name</b> on Basic Info & Job Type page should be same");
	}

	public void clickOnNextBtn() {
		try {
			BasicInfoPlusEducation plus = new BasicInfoPlusEducation(DriverSession.getLastExecutionDriver());
			plus.clickBasicInfoNextBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkStatusAfterNextBtnClick(String urlContains) {
		try {
			if (Keywords.getCurrentUrl(driver).contains(urlContains)) {
				Keywords.backPage();
				Logs.info("Data Successfully added.");
			} else
				Keywords.refreshPage(DriverSession.getLastExecutionDriver());
		} catch (Exception e) {
		}
	}

	public void fillBasicInfoPlusEducation() {
		String sheetLocationPath = "";
		try {
			BasicInfoPlusEducation plus = new BasicInfoPlusEducation(DriverSession.getLastExecutionDriver());
			ExcelUtility eu = new ExcelUtility();
			sheetLocationPath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "LegablyFiles" + GlobalParam.slash + "LegablyBasicInfo.ods";
			HashMap<Integer, List<String>> data = eu.basicInfoPlusEducation(sheetLocationPath);
			for (Map.Entry<Integer, List<String>> map : data.entrySet()) {
				List<String> info = map.getValue();
				plus.enterStreetAddress1(info.get(0));
				plus.enterStreetAddress2(info.get(1));
				plus.enterCity(info.get(2));
				plus.selectState(info.get(3));
				plus.enterZipCode(info.get(4));
				plus.enterMobileNumber(info.get(5));
				plus.enterSchoolName(info.get(6));
				plus.selectDegree(info.get(7));
				plus.enterGraduateYear(info.get(8));
				plus.enterAdditionalInfo(info.get(9));
				plus.selectEducationState(info.get(10));
				plus.enterBarRegistration(info.get(11));
				plus.selectPracticeArea();
				//plus.selectMalPracticeInsurance();
				clickOnNextBtn();
				checkStatusAfterNextBtnClick("experience");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void experienceInfo() {
		String sheetLocationPath = "";
		try {
			Experience exp = new Experience(DriverSession.getLastExecutionDriver());
			ExcelUtility eu = new ExcelUtility();
			sheetLocationPath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "LegablyFiles" + GlobalParam.slash + "LegablyExperience.ods";
			HashMap<Integer, List<String>> data = eu.experience(sheetLocationPath);
			for (Map.Entry<Integer, List<String>> map : data.entrySet()) {
				List<String> info = map.getValue();
				exp.companyName(info.get(0));
				exp.enterStartDate(info.get(1));
				exp.enterEndDate(info.get(2));
				exp.enterDesignation(info.get(3));
				exp.employmentType(info.get(4));
				exp.skilledused(info.get(5));
				exp.additionalyInfo(info.get(6));
				clickOnNextBtn();
				checkStatusAfterNextBtnClick("networkProfile");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void proceedToPayment() {
		try {
			JobType job = new JobType(DriverSession.getLastExecutionDriver());
			job.clickOnProceedToPayment();
			job.waitForProfileSuccessfullyUpdatedMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void networkInfo() {
		String sheetLocationPath = "";
		try {
			Network network = new Network(DriverSession.getLastExecutionDriver());
			ExcelUtility eu = new ExcelUtility();
			sheetLocationPath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "LegablyFiles" + GlobalParam.slash + "LegablyNetwork.ods";
			HashMap<Integer, List<String>> data = eu.network(sheetLocationPath);
			for (Map.Entry<Integer, List<String>> map : data.entrySet()) {
				List<String> info = map.getValue();
				network.lawyerHeadline(info.get(0));
				network.abooutLawyer(info.get(1));
				network.linkedInLink(info.get(2));
				network.clioLink(info.get(3));
				clickOnNextBtn();
				checkStatusAfterNextBtnClick("jobProfile");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jobType() {
		try {
			proceedToPayment();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
