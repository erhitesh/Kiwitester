package Legably.DesktopWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	public String title = null;

	public static Locators getInstance() {
		Locators mHeader = null;
		try {
			mHeader = new Locators();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mHeader;
	}
	
	// Login
	public WebElement emailAddress(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}
	
	public WebElement password(WebDriver driver) {
		return driver.findElement(By.id("pwd"));
	}
	
	public WebElement signInBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".btn.sign-in-btn"));
	}
	
	public WebElement getLoggedInUserInfo(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.hidden-xs"));
	}
	
	// Sign up Form
	public WebElement sFName(WebDriver driver) {
		return driver.findElement(By.id("fname"));
	}
	
	public WebElement sLName(WebDriver driver) {
		return driver.findElement(By.id("lname"));
	}
	
	public WebElement sEmail(WebDriver driver) {
		return driver.findElement(By.name("email"));
	}
	
	public WebElement sPassword(WebDriver driver) {
		return driver.findElement(By.id("pwd"));
	}
	
	public WebElement sConfirmPassword(WebDriver driver) {
		return driver.findElement(By.id("repwd"));
	}
	
	public WebElement switchToIframe(WebDriver driver) {
		return driver.findElement(By.xpath("(//iframe)[1]"));
	}
	
	public WebElement sCaptchaCheckBox(WebDriver driver) {
		return driver.findElement(By.id("recaptcha-anchor"));
	}
	
	public WebElement sTAndC(WebDriver driver) {
		return driver.findElement(By.cssSelector("span.pmd-checkbox-label"));
	}
	public WebElement sSignUpBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
	}
	
	public WebElement startBuildingYourProfile(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Start Building Your Profile')]"));
	}
	
	// basic Info plus education
	public WebElement InfoStreetAddress1(WebDriver driver) {
		return driver.findElement(By.name("street_address1"));
	}
	
	public WebElement InfoStreetAddress2(WebDriver driver) {
		return driver.findElement(By.name("street_address2"));
	}
	
	public WebElement InfoCity(WebDriver driver) {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement InfoState(WebDriver driver) {
		return driver.findElement(By.name("state_id"));
	}
	
	public WebElement infoZipCode(WebDriver driver) {
		return driver.findElement(By.id("zipcode"));
	}
	
	public WebElement infoMobile(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
	}
	
	public WebElement educationSchool(WebDriver driver) {
		return driver.findElement(By.id("school"));
	}
	
	public WebElement educationDegree(WebDriver driver) {
		return driver.findElement(By.name("degree_id"));
	}
	
	public WebElement educationYearGraduate(WebDriver driver) {
		return driver.findElement(By.id("ygraduated"));
	}
	
	public WebElement educationAdditionInfo(WebDriver driver) {
		return driver.findElement(By.id("add-info"));
	}
	
	public WebElement enablePracticeAreaDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='placeholder']"));
	}
	
	public List<WebElement> practiceAreaListValues(WebDriver driver) {
		return driver.findElements(By.xpath("//li[@class='opt']//span"));
	}
	
	public WebElement educationState(WebDriver driver) {
		return driver.findElement(By.name("bar_state_id"));
	}
	
	public WebElement educationBarRegistration(WebDriver driver) {
		return driver.findElement(By.id("bar-reg-num"));
	}
	
	public WebElement educationPracticeArea(WebDriver driver) {
		return driver.findElement(By.name("practice_area_id"));
	}
	
	public WebElement insuranceCheckbox(WebDriver driver) {
		return driver.findElement(By.id("inlineRadio1"));
	}
	
	public WebElement infoNextBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	//Experience
	public WebElement companyName(WebDriver driver) {
		return driver.findElement(By.id("comp-name"));
	}
	
	public List<WebElement> startDate(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='rdtPicker'])[1]//tr//td[@class='rdtDay' or @class='rdtDay rdtToday']"));
	}
	
	public List<WebElement> endDate(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='rdtPicker'])[2]//tr//td[@class='rdtDay' or @class='rdtDay rdtToday']"));
	}
	
	public WebElement designation(WebDriver driver) {
		return driver.findElement(By.id("designation"));
	}
	
	public WebElement employemnetType(WebDriver driver) {
		return driver.findElement(By.name("employment_type_id"));
	}
	
	public WebElement skilled(WebDriver driver) {
		return driver.findElement(By.id("skills-used"));
	}
	
	public WebElement experienceAdditionalInfo(WebDriver driver) {
		return driver.findElement(By.id("additional-info"));
	}
	
	public WebElement previousBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Previous')]"));
	}
	
	//Network data
	public WebElement uploadPhoto(WebDriver driver) {
		return driver.findElement(By.className("icon-upload-photo"));
	}
	
	public WebElement lawyerHeadline(WebDriver driver) {
		return driver.findElement(By.id("lawyer-head"));
	}
	
	public WebElement aboutLawyer(WebDriver driver) {
		return driver.findElement(By.id("about-lawyer"));
	}
	
	public WebElement linkedInUrl(WebDriver driver) {
		return driver.findElement(By.id("linkedin-link"));
	}
	
	public WebElement clioUrl(WebDriver driver) {
		return driver.findElement(By.id("clio-link"));
	}
	
	public WebElement uploadResume(WebDriver driver) {
		return driver.findElement(By.name("file"));
	}
	
	public WebElement uploadWritingSample(WebDriver driver) {
		return driver.findElement(By.name("pic"));
	}
	
	//Job Profile
	public WebElement cityName(WebDriver driver) {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement state(WebDriver driver) {
		return driver.findElement(By.id("state"));
	}
	
	public List<WebElement> selectCheckBoxes(WebDriver driver) {
		return driver.findElements(By.xpath("//span[@class='pmd-checkbox-label'][1]"));
	}
	
	public WebElement proccedToPayment(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Proceed to Payment')]"));
	}
	
	public WebElement profileUpdatedSuccessfullyMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	}
}
