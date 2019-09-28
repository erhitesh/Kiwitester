package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

public class DigitalWallet {

	private WebDriver driver;

	public DigitalWallet(WebDriver driver) {
		this.driver = driver;
	}

	// Digital Wallet
	public void navigateToDigitalWalletPage() {
		try {
			ClaimsAndFinancials claims = new ClaimsAndFinancials(driver);
			claims.navigateToClaimAndFinancialPage();
			claims.selectSubLinksInsideClaimAndFinancialTab("digital wallet");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing <b>Digital Wallet Page</b> page open", "FAIL",
					"<b>Digital Wallet Page</b> should be opened");
		}
	}

	public void clickOnAddAnotherCard() {
		WebElement element;
		try {
			element = Locators.getInstance().addAnotherCardBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Another Card btn </b>click successfully", "PASS",
						"<b>Add Another Card btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add Another Card btn </b>not click successfully", "FAIL",
						"<b>Add Another Card btn </b>should be clicked");
			Keywords.explicitWait(2);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Add Another Card btn </b>", "FAIL",
					"<b>Add Another Card btn </b>should be clicked");
		}
	}

	public String addDigitalWalletCardName(String cName) {
		WebElement element;
		try {
			cName = cName + Keywords.getRandomIntegerBtRange(999, 9999);
			element = Locators.getInstance().enterCardName(driver);
			Keywords.typeText(element, cName);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Name </b>enter successfully", "PASS", "<b>Card Name </b>should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Name </b>not enter successfully", "FAIL", "<b>Card Name </b>should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while entering <b>Card Name </b>", "FAIL",
					"<b>Card Name </b>should be entered");
		}
		return cName;
	}

	public String addDigitalWalletCardName() {
		return addDigitalWalletCardName(DriverSession.getTestCaseData().get("CardName"));
	}

	public void addCardFrontImage() {
		String imageName = "card_front.jpg";
		String imagePath = "";
		RemoteWebElement element;
		try {
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "BWellFiles" + GlobalParam.slash + imageName;
			element = (RemoteWebElement) Locators.getInstance().addCardFrontImage(driver);
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Front Image </b>upload successfully", "PASS",
						"<b>Card Front Image </b>should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Front Image </b>upload successfully", "FAIL",
						"<b>Card Front Image </b>should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading <b>Card Front Image </b>", "FAIL",
					"<b>Card Front Image </b>should be upload");
		}
	}

	public void addCardBackImage() {
		String imageName = "card_back.jpg";
		String imagePath = "";
		RemoteWebElement element;
		try {
			imagePath = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository" + GlobalParam.slash
					+ "BWellFiles" + GlobalParam.slash + imageName;
			element = (RemoteWebElement) Locators.getInstance().addCardBackImage(driver);
			element.setFileDetector(new LocalFileDetector());
			Keywords.typeText(element, imagePath);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Back Image </b>upload successfully", "PASS",
						"<b>Card Back Image </b>should be upload");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Back Image </b>upload successfully", "FAIL",
						"<b>Card Back Image </b>should be upload");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while uploading <b>Card Back Image </b>", "FAIL",
					"<b>Card Back Image </b>should be upload");
		}
	}

	public void submitCardInDigitalWallet() {
		WebElement element;
		try {
			element = Locators.getInstance().addThisCardBtn(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add This Card Btn </b>click successfully", "PASS",
						"<b>Add This Card Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Add This Card Btn </b>not click successfully", "FAIL",
						"<b>Add This Card Btn </b>should be clicked");
			Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking <b>Add This Card Btn </b>", "FAIL",
					"<b>Add This Card Btn </b>should be clicked");
		}
	}

	public void enableInsuranceCardList() {
		WebElement element;
		try {
			element = Locators.getInstance().enableInsuranceCardMenu(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
		} catch (Exception e) {
		}
	}

	public List<WebElement> getInsuranceCardElementList(String cardNameStartsWith) {
		List<WebElement> cardList = new ArrayList<>();
		try {
			cardList = Locators.getInstance().getInsuranceCardListBasedOnValue(driver, cardNameStartsWith);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cardList;
	}

	public String selectInsuranceCard(String cName) {
		WebElement element;
		List<WebElement> cardElementList;
		try {
			Keywords.waitForObject(Locators.getInstance().enableInsuranceCardMenu(driver), 10);
			element = Locators.getInstance().enableInsuranceCardMenu(driver);
			Keywords.click(element);
			Keywords.explicitWait(1);
			cardElementList = Locators.getInstance().insuranceCardList(driver);
			for (int i = 0; i < cardElementList.size(); i++) {
				if (Keywords.getText(cardElementList.get(i)).equalsIgnoreCase(cName)) {
					Keywords.click(cardElementList.get(i));
					Locators.getInstance().waitImageLoaderToBeInvisible(driver, 10);
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b>Insurance Card </b>successfully select", "PASS",
							"<b>Insurance Card </b>should be selected");
					break;
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + cName + "<b> Insurance Card</b>", "FAIL",
					cName + "<b> Insurance Card </b>should be entered");
		}
		return cName;
	}

	public String selectInsuranceCardOneAfterAnother(String cName) {
		WebElement element;
		try {
			element = Locators.getInstance().selectInsuranceCard(driver, cName);
			Keywords.click(element);
			Keywords.explicitWait(5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						cName + "<b> Insurance Card </b>successfully select", "PASS",
						cName + "<b> Insurance Card </b>should be selected from DropDown Card List");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						cName + "<b> Insurance Card </b>not successfully select", "FAIL",
						cName + "<b> Insurance Card </b>should be selected from DropDown Card List");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while selecting " + cName + "<b> Insurance Card</b>", "FAIL",
					cName + "<b> Insurance Card </b>should be selected from DropDown Card List");
		}
		return cName;
	}

	public void verifyCardInInsuranceList(String insuranceCName) {
		WebElement element;
		try {
			element = Locators.getInstance().enableInsuranceCardMenu(driver);
			Keywords.click(element);
			Keywords.explicitWait(4);
			if (insuranceCardList().contains(insuranceCName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Insurance Card Added Successfully</b>", "PASS", "<b>Insurance Card </b>should be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Insurance Card Not Added Successfully</b>", "FAIL",
						"<b>Insurance Card </b>should be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the visibility of <b>Card In Insurance Card List</b>", "FAIL",
					"<b>Insurance Card </b>should be found");
		}
	}

	public void removeThisCard() {
		// String alertMsg = "are you sure you want to remove this card?";
		WebElement element;
		try {
			element = Locators.getInstance().removeCard(driver);
			Keywords.click(element);
			Keywords.acceptAlert(driver);
			// Locators.getInstance().waitImageLoaderToBeInvisible(driver, 5);
			Keywords.explicitWait(5);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Card Btn </b>click successfully", "PASS",
						"<b>Remove Card Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Remove Card Btn </b>not click successfully", "FAIL",
						"<b>Remove Card Btn </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Remove Card Btn </b>", "FAIL",
					"<b>Remove Card Btn </b>should be clicked");
		}
	}

	public void removeAllInsuranceCardFromDigitalWallet() {
		String cardStartsWith = DriverSession.getTestCaseData().get("CardName");
		List<WebElement> cardList;
		try {
			enableInsuranceCardList();
			cardList = getInsuranceCardElementList(cardStartsWith);
			if (cardList.size() <= 0) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>There are no Insurance card in Digital Wallet</b>", "INFO",
						"<b>First Add Insurance Card In Digital Wallet</b>");
			} else {
				cardList = getInsuranceCardElementList(cardStartsWith);
				for (int i = cardList.size() - 1; i >= 0; i--) {
					selectInsuranceCardOneAfterAnother(Keywords.getText(cardList.get(i)));
					removeThisCard();
					enableInsuranceCardList();
					cardList = getInsuranceCardElementList(cardStartsWith);
				}
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while deleting the <b>Insurance Card from Digital Wallet</b>", "PASS",
					"<b>Insurance Card </b>should be delete from Digital Wallet");
		}
	}

	public List<String> insuranceCardList() {
		List<String> list = new ArrayList<>();
		List<WebElement> cardElementList;
		try {
			cardElementList = Locators.getInstance().insuranceCardList(driver);
			for (WebElement webElement : cardElementList)
				list.add(Keywords.getText(webElement));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void verifyCardAfterRemove(String insuranceCName) {
		WebElement element;
		try {
			element = Locators.getInstance().enableInsuranceCardMenu(driver);
			Keywords.click(element);
			Keywords.explicitWait(4);
			if (insuranceCardList().contains(insuranceCName))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Insurance Card still present</b>", "FAIL", "<b>Insurance Card </b>should not be found");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Insurance Card Delete Successfully</b>", "PASS",
						"<b>Insurance Card </b>should not be found");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the visibility of <b>Insurance Card</b>", "FAIL",
					"<b>Insurance Card </b>should not be found");
		}
	}

	public void shareThisCard() {
		WebElement element;
		try {
			element = Locators.getInstance().shareThisCard(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><i>Share This Card Btn </i></b>click successfully", "PASS",
						"<b>Share This Card Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share This Card Btn </b>not click successfully", "FAIL",
						"<b>Share This Card Btn </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Share This Card Btn </b>", "FAIL",
					"<b>Share This Card Btn </b>should be clicked");
		}
	}

	public void submitShareCardSuccessfullyMsgWindow() {
		WebElement element;
		try {
			element = Locators.getInstance().submitSuccessfullySendMailAddressWindow(driver);
			Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Done Button </b>successfully click", "PASS", "<b>Done Button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Done Button </b>not successfully click", "FAIL", "<b>Done Button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Done Button </b>", "FAIL",
					"<b>Done Button </b>should be clicked");
		}
	}

	public void verifyShareCardSuccessfully(String cName, String emailAddress) {
		WebElement element;
		try {
			element = Locators.getInstance().verifyEmailSuccessfullySendToEmailAddress(driver, cName, emailAddress);
			if (Keywords.isElementPresent(element))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>Card share </b>successfully",
						"PASS", "<b>Card share successfully msg </b>should be display");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Card Not share </b>successfully", "FAIL",
						"<b>Card share successfully msg </b>should be display");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing the <b>Card Share Successfully</b>enter successfully", "FAIL",
					"<b>Card share successfully msg </b>should be display");
		}
	}

	public boolean shareEmailBtnStatus() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().shareBtn(driver);
			status = Keywords.getBtnStatus(ElementEnum.ClassName.getElementType(),
					Keywords.getAttributeVal(element, "class"), 0);
		} catch (Exception e) {
		}

		return status;
	}

	public void submitEnterShareEmailAddress() {
		WebElement element;
		try {
			element = Locators.getInstance().shareBtn(driver);
			Keywords.clickByJS(ElementEnum.ClassName.getElementType(), Keywords.getAttributeVal(element, "class"), 0);
			Keywords.explicitWait(3);
			// Keywords.click(element);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share button </b>successfully click", "PASS", "<b>Share button </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Share button not </b>successfully click", "FAIL", "<b>Share button </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on the <b>Share button </b>", "FAIL",
					"<b>Share button </b>should be clicked");
		}
	}

	public String enterShareEmailAddress(String emailAddress) {
		WebElement element;
		try {
			element = Locators.getInstance().enterEmailIdForShareCard(driver);
			Keywords.typeText(element, emailAddress);
			Keywords.explicitWait(3);

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
					"Exception occurred while entering on <b>Share Email Address </b>", "FAIL",
					"<b>Share Email Address </b>should be entered");
		}

		return emailAddress;
	}

	public String enterShareEmailAddress() {
		return enterShareEmailAddress(DriverSession.getTestCaseData().get("SharedMail"));
	}

	public String enterShareEmailInvalidAddress() {
		return enterShareEmailAddress(DriverSession.getTestCaseData().get("InvalidSharedMail"));
	}

	public void verifyShareBtnModeStatus(String emailAddress) {
		if (!shareEmailBtnStatus() && !Keywords.mailValidator(emailAddress)) {
			Keywords.highLightElement(driver, Locators.getInstance().shareBtn(driver));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"<b><u>Share Button </u></b>not in Disable Mode", "BUG",
					"<b><u>Share Button </u></b> should be in Disable Mode");
		} else {
		}
	}

	public void verifyMailErrorMsg(String emailAddress) {
		WebElement element;
		List<WebElement> errorElementList;
		try {
			enterShareEmailInvalidAddress();
			submitEnterShareEmailAddress();
			element = Locators.getInstance().enterEmailIdForShareCard(driver);
			element.sendKeys(Keys.BACK_SPACE);
			Keywords.explicitWait(2);
			Keywords.click(element);
			errorElementList = Locators.getInstance().errorMsgForInvalidMail(driver);
			if (errorElementList.size() > 1) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b><u>Duplicate Error Message Twice Display</u></b>", "BUG",
						"<b><u>Duplicate Error Message Twice </u></b> should not be Display");
			} else {
			}
		} catch (Exception e) {

		}

	}

	public void printThisCard() {
		WebElement element;
		try {
			element = Locators.getInstance().printThisCard(driver);
			Keywords.click(element);
			Keywords.explicitWait(2);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Print This Card Btn </b>click successfully", "PASS",
						"<b>Print This Card Btn </b>should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"<b>Print This Card Btn </b>not click successfully", "FAIL",
						"<b>Print This Card Btn </b>should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while clicking on <b>Print This Card Btn </b>", "FAIL",
					"<b>Print This Card Btn </b>should be clicked");
		}
	}

}
