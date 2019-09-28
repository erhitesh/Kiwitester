package Plantsmap.DesktopWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class AdminUser {

	private WebDriver driver;

	public AdminUser(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddUserPlantCollectionOrgEvent() {
		WebElement element;
		String addBtnName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().addUserPlantOrgCollEventBtn(driver);
			addBtnName = Keywords.getText(element);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						addBtnName+" button click successfully", "PASS", addBtnName+" button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						addBtnName+" button not click successfully", "FAIL", addBtnName+" button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the "+addBtnName+" button", "FAIL", addBtnName+" button should be click");
		}
	}
	
	
	public String enterDisplanyName() {
		String displayName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			displayName = "plantsmapadmin"+ Keywords.getRandomNumber(5);
			element = Locators.getInstance().enterAdminUserDisPlayName(driver);
			Keywords.typeText(element, displayName);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Display Name enter successfully", "PASS", "Display Name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Display Name enter not successfully", "FAIL", "Display Name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering user display name", "FAIL", "Display Name should be enter");
		}
		
		return displayName;
	}
	
	public String enterFirstName() {
		String firstName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			firstName = Keywords.getRandomString();
			element = Locators.getInstance().enterAdminUserFirstName(driver);
			Keywords.typeText(element, firstName);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Name enter successfully", "PASS", "First Name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Name enter not successfully", "FAIL", "First Name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering user First name", "FAIL", "First Name should be enter");
		}
		
		return firstName;
	}
	
	public String enterLastName() {
		String lastName = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			lastName = "plantsmapadmin"+ Keywords.getRandomNumber(5);
			element = Locators.getInstance().enterAdminUserLastName(driver);
			Keywords.typeText(element, lastName);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Last Name enter successfully", "PASS", "Last Name should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Last Name enter not successfully", "FAIL", "Last Name should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering user last name", "FAIL", "Last Name should be enter");
		}
		
		return lastName;
	}
	
	public String enterEmailId() {
		String emailId = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			emailId = "plantsmapadmin"+ Keywords.getRandomNumber(5) + "@yopmail.com";
			element = Locators.getInstance().userEmailId(driver);
			Keywords.typeText(element, emailId);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email ID enter successfully", "PASS", "Email ID should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Email ID enter not successfully", "FAIL", "Email ID should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering user Email ID", "FAIL", "Email ID should be enter");
		}
		
		return emailId;
	}
	
	public String enterPassword() {
		String password = "";
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			password = "Test@123";
			element = Locators.getInstance().userPassword(driver);
			Keywords.typeText(element, password);
			
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Password enter successfully", "PASS", "Password should be enter");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Password enter not successfully", "FAIL", "Password should be enter");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering user display name", "FAIL", "Password should be enter");
		}
		
		return password;
	}
	
	public void submitUserInfoPage() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().adminSubmitBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Submit button click successfully", "PASS", "Submit button should be click");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Submit button not click successfully", "FAIL", "Submit button should be click");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the Submit button", "FAIL", "Submit button should be click");
		}
	}
	
	public void waitForLoaderInvisible() {
		try {
			By by = By.xpath("//div[@class='show-loader']");
			Keywords.waitForObjectToInvisible(by, 30);
		}catch(Exception e) {}
	}
	
	
	
	public int getUserProfilePlantCount() {
		int plantCount = 0;
		WebElement element;
		try {
			element = Locators.getInstance().userPlantsCountFromAdmin(driver);
			plantCount = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return plantCount;
	}
	
	public int getUserNetworkCount() {
		int networkCount = 0;
		WebElement element;
		try {
			element = Locators.getInstance().userNetworkCountFromAdmin(driver);
			networkCount = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return networkCount;
	}
	
	public int getOrganizationPlantCount() {
		int orgPlantCount = 0;
		WebElement element;
		try {
			element = Locators.getInstance().orgPlantsCountFromAdmin(driver);
			orgPlantCount = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return orgPlantCount;
	}
	
	public int getOrganizationCollectionCount() {
		int orgCollectionCount = 0;
		WebElement element;
		try {
			element = Locators.getInstance().orgCollectionCountFromAdmin(driver);
			orgCollectionCount = Integer.parseInt(Keywords.getText(element));
		}catch(Exception e) {}
		
		return orgCollectionCount;
	}
	
}
