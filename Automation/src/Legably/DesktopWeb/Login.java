package Legably.DesktopWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class Login {
	
	private WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}

	
	public String emailAddress() {
		WebElement element;
		String emailAddress = "";
		try {
			element = Locators.getInstance().emailAddress(driver);
			emailAddress = DriverSession.getTestCaseData().get("Username");
			Keywords.typeText(element, emailAddress);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return emailAddress;
	}
	
	public String userPassword() {
		WebElement element;
		String password = "";
		try {
			element = Locators.getInstance().password(driver);
			password = DriverSession.getTestCaseData().get("Password");
			Keywords.typeText(element, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	public void signIn() {
		WebElement element;
		try {
			element = Locators.getInstance().signInBtn(driver);
			Keywords.doubleClick(driver, element);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getLoggedInUserName() {
		String name = "";
		WebElement element;
		try {
			element = Locators.getInstance().getLoggedInUserInfo(driver);
			name = Keywords.getText(element);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
}
