package BWell.DesktopWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Keywords;

public class TopfanKnowledgeTestForm {

	private WebDriver driver;

	public TopfanKnowledgeTestForm(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnKnowledgeTest() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().knowledgeTextLinkText(driver);
			Keywords.click(element);
			element = Locators.getInstance().knowledgeTestHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Knowledge test")) {
				System.out.println("Ok");
			}
		} catch (Exception e) {

		}
	}

	public void checkAllCheckbox() {
		List<WebElement> checkboxlist;
		try {
			Keywords.waitForPage(driver);
			checkboxlist = Locators.getInstance().checkboxList(driver);
			for (int i = 0; i < checkboxlist.size(); i++) {
				Keywords.click(checkboxlist.get(i));
			}
		} catch (Exception e) {

		}
	}

	public void aboutIndianClassicalMusic() {
		WebElement element = null;
		String randomString = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().aboutIndianClassicalMusic(driver);
			randomString = Keywords.getRandomAlphabetic(50);
			Keywords.typeText(element, randomString);
		} catch (Exception e) {

		}
	}

	public void selectMusician() {
		WebElement element = null;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().selectMusician(driver);
			int randomIndex = 2;//Keywords.getRandomInteger(2);
			if (randomIndex == 0)
				randomIndex++;
			Keywords.selectByIndex(element, randomIndex);
		} catch (Exception e) {
		}
	}

	public void enterDOB() {
		WebElement element;
		int randomDay = 0;
		int randomMonth = 0;
		int randomYear = 0;
		String dateValue = "";
		try {
			randomDay = Keywords.getRandomIntegerBtRange(10, 25);
			randomMonth = Keywords.getRandomIntegerBtRange(1, 12);
			randomYear = Keywords.getRandomIntegerBtRange(1900, 2017);
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterDob(driver);
			dateValue = randomMonth+"-"+randomDay+"-"+randomYear;
			Keywords.makeTextBoxReadable("document.getElementById('custom_form_custom_fields_attributes_3_value').removeAttribute('readonly');");
			Keywords.typeText(element, dateValue);
		}catch(Exception e) {
		}
	}
	
	public void enterUserName() {
		WebElement element = null;
		String randomName = "";
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().enterName(driver);
			randomName = Keywords.getRandomAlphabetic(32);
			Keywords.typeText(element, randomName);
		} catch (Exception e) {
		}
	}

	public void submitKnowledgeTestForm() {
		Keywords.click(Locators.getInstance().submitKnowledgeTestForm(driver));
	}

	public void submitAlertPopup() {
		WebElement element;
		try {
			Keywords.waitForPage(driver);
			element = Locators.getInstance().alertPopupHeaderText(driver);
			if (Keywords.getText(element).equalsIgnoreCase("Thank you")) {
				System.out.println("Alert Visible");
			}
			element = Locators.getInstance().submitAlertPopup(driver);
			Keywords.click(element);
		} catch (Exception e) {

		}
	}
}
