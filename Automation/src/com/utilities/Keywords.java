package com.utilities;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.session.DriverSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

@SuppressWarnings("rawtypes")
public class Keywords {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<AppiumDriver> a_Driver = new ThreadLocal<AppiumDriver>();
	// private static Logger logger =
	// Logger.getLogger(Keywords.class.getName());
	long strt_time, end_time, totalTime;
	public static int counter = 0;

	static {
		Keywords.driver.set(DriverSession.getLastExecutionDriver());
		try {
			a_Driver.set((AppiumDriver) driver.get());
		} catch (Exception e) {
		}
	}

	public Keywords() {
	}

	public Keywords(AppiumDriver A_driver) { // ##U
		try {
			a_Driver.set(A_driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Keywords(WebDriver Driver) { // ##U
		try {
			driver.set(Driver);
			try {
				a_Driver.set((AppiumDriver) driver.get());
			} catch (Exception e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String generateMobileNumber() { // ##U
		Random rm = new Random();
		String num = String.valueOf(rm.nextInt(9) + 1);
		int i = 0;
		while (i != 9) {
			num = num.concat(String.valueOf((rm.nextInt(9))));
			i++;
		}
		return num;
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"document.getElementById('" + getAttributeVal(element, "id") + "').scrollIntoView(true);");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollDown50PixelsFromTop(WebDriver driver) { // ##U
		scrollDownPixelsFromTop(driver, 50);
	}

	public static void scrollDownPixelsFromTop(WebDriver driver, int number) { // ##U
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + number + ")");
	}

	public static void scrollDownPixels(WebDriver driver, int start, int end) { // ##U
		((JavascriptExecutor) driver).executeScript("window.scrollTo(" + start + "," + end + ")");
	}

	public static void isCouponApplied(WebElement element) {
		String couponText;
		try {
			couponText = element.getText();
			if (couponText.contains("Successfully applied Coupon Code"))
				DriverSession.setStepResult(true);
			else
				DriverSession.setStepResult(false);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void clearEditField(WebElement element) { // ##U
		try {
			element.clear();
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void validateElementExistOrNot(WebElement element) { // ##U
		try {
			DriverSession.setStepResult(element.isDisplayed());
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	public static void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	public static void waitForPage(WebDriver driver) { // ##U
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void waitForPage(WebDriver driver, int time) { // ##U
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void waitForPageFullyLoaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		wait.until(pageLoadCondition);
	}

	public static void fluentWaitWithPolling(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
	}

	public static void waitForText(WebDriver driver, WebElement element, String waitFortext) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return getText(element).trim().equalsIgnoreCase(waitFortext);
			}
		};

		wait.until(pageLoadCondition);
	}

	public static String selectByIndex(WebElement element, int index) { // ##U
		String selectedValue = "";
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			selectedValue = getText(select.getFirstSelectedOption());
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}

		return selectedValue;
	}

	public static boolean mailValidator(String userMailId) {
		boolean mailStatus = false;
		Pattern pattern;
		Matcher matcher;
		String emailPatternRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		try {
			pattern = Pattern.compile(emailPatternRegex);
			matcher = pattern.matcher(userMailId);
			mailStatus = matcher.matches();
		} catch (Exception e) {
		}
		return mailStatus;
	}

	public static String getSelectedIndexValue(WebElement element, int index) { // ##U
		String selectedValue = "";
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			selectedValue = select.getFirstSelectedOption().getText();
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}

		return selectedValue;
	}

	public static void keyBoardEvent(int eventNumber, String Environment) {
		try {
			if (Environment.equalsIgnoreCase("windows")) {
				explicitWait(1);
				Runtime.getRuntime().exec("cmd /C adb shell input keyevent " + eventNumber);
				explicitWait(3);
			} else if (Environment.equalsIgnoreCase("Linux")) {
				Runtime.getRuntime().exec(new String[] { "/usr/bin/adb", "shell input keyevent " + eventNumber });
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static String getRandomData() {
		String result = null;
		DriverSession.setStepResult(false);
		try {
			result = "" + System.currentTimeMillis();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return result;
	}

	public static double addOnePercentInValue(double value) {
		value = value + ((value * 1) / 100);
		return value;
	}

	public static double subtractOnePersentInValue(double value) {

		value = value - ((value * 1) / 100);
		return value;
	}

	public static void explicitWait(int timeInSec) { // ##U
		try {
			Thread.sleep(1000 * timeInSec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
		Keywords.explicitWait(8);
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Page refreshed....", "INFO",
				"Should be able to reload page.");
	}

	// public static void refreshPage() { // ##U
	// driver.get().navigate().refresh();
	// Keywords.explicitWait(8);
	// DriverSession.getLastExecutionReportingInstance().teststepreporting("Page
	// refreshed....", "INFO",
	// "Should be able to reload page.");
	// }

	public static Alert waitForAlert(WebDriver driver, Alert alert) throws InterruptedException { // ##U
		int i = 0;
		while (i++ < 5) {
			try {
				alert = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				explicitWait(1);
				continue;
			}
		}
		return alert;
	}

	public static void clickByText(List<WebElement> elements, String text) { // ##U
		try {
			DriverSession.setStepResult(false);
			for (WebElement elemnt : elements) {
				if (elemnt.getText().equalsIgnoreCase(text)) {
					elemnt.click();
					DriverSession.setStepResult(true);
					break;
				}
			}
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static String getAlert() {
		String alertMessage = "";
		try {
			DriverSession.setStepResult(false);
			Alert a = new WebDriverWait(driver.get(), 5).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				DriverSession.getLastExecutionDriver().switchTo().alert();
				explicitWait(1);
				alertMessage = a.getText();
			}
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}

		return alertMessage;
	}

	public static void acceptAlert(WebDriver driver) {
		try {
			DriverSession.setStepResult(false);
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null)
				DriverSession.getLastExecutionDriver().switchTo().alert().accept();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void clickByPartialText(List<WebElement> elements, String text) {
		try {
			for (WebElement elemnt : elements) {
				if (elemnt.getText().toLowerCase().contains(text)) {
					elemnt.click();
					DriverSession.setStepResult(true);
					break;
				}
			}
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void click(WebElement element) { // ##U
		try {
			element.click();
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void submitPage(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
			DriverSession.setStepResult(false);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void doubleClick(WebDriver driver, WebElement element) { // ##U
		try {
			new Actions(driver).moveToElement(element).doubleClick().perform();
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void typeText(WebElement element, CharSequence... text) { // ##U
		try {
			element.clear();
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
		typeTextWithoutClear(element, text);
	}

	public static void pressKey(WebElement element, String keyName) {
		try {
			if (keyName.equalsIgnoreCase("home"))
				element.sendKeys(Keys.HOME);
			else if (keyName.equalsIgnoreCase("enter"))
				element.sendKeys(Keys.ENTER);
			else if (keyName.equalsIgnoreCase("end"))
				element.sendKeys(Keys.END);
			else if (keyName.equalsIgnoreCase("tab"))
				element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void typeTextWithoutClear(WebElement element, CharSequence... text) { // ##U
		try {
			element.sendKeys(text);
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void typeTextByIndex(List<WebElement> elements, int index, String text) {
		try {
			int i = 0;
			for (WebElement element : elements) {
				if (i == index) {
					element.sendKeys(text);
					DriverSession.setStepResult(true);
					break;
				}
				i++;
			}
		} catch (Exception ee) {
		}
	}

	public static void typeTextUsingCharater(WebElement element, String message) {
		for (int i = 0; i < message.length(); i++) {
			typeText(element, message.charAt(i) + "");
		}
	}

	public static Properties loadPropertiesOfNiftyAndSensex() {
		InputStream input = null;
		Properties prop = null;
		String filePath = "";
		try {
			filePath = GlobalParam.CURRENT_PROJECT_PATH + "\\" + "sensexAndNiftyValues.properties";
			prop = new Properties();
			input = new FileInputStream(new File(filePath));
			prop.load(input);

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return prop;
	}

	public static double getNiftyValueFromSite() {
		Properties p = null;
		double currentNiftyPrice = 0;
		try {
			p = loadPropertiesOfNiftyAndSensex();
			currentNiftyPrice = Double.parseDouble(p.getProperty("currentNiftPrice"));
		} catch (Exception ee) {
		}
		return currentNiftyPrice;
	}

	public static double getSensexValueFromSite() {
		Properties p = null;
		double currentSensexPrice = 0;
		try {
			p = loadPropertiesOfNiftyAndSensex();
			currentSensexPrice = Double.parseDouble(p.getProperty("currentSensexPrice"));
		} catch (Exception ee) {
		}
		return currentSensexPrice;
	}

	public static String getTextByIndex(List<WebElement> elements, int index) { // ##U
		String text = "";
		try {
			int i = 0;
			for (WebElement element : elements) {
				if (i == index) {
					text = element.getText();
					DriverSession.setStepResult(true);
					break;
				}
				i++;
			}
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
		return text;
	}

	public boolean isProcessRunging(String serviceName) {
		try {
			Process p = Runtime.getRuntime().exec("TASKLIST");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(serviceName)) {
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

	// public static void swipeVertically(int ScreenHightValue) {
	// try {
	//
	// Dimension screenSize = DriverSession.getLastExecutionDriver()
	// .manage().window().getSize();
	// Double screenWidth = Double.valueOf(String.valueOf(screenSize
	// .getWidth())) / 2;
	// Double screenHight = Double.valueOf(String.valueOf(screenSize
	// .getHeight())) / 2;
	// JavascriptExecutor js = (JavascriptExecutor) DriverSession
	// .getLastExecutionDriver();
	//
	// HashMap<String, Object> swipeObject = new HashMap<String, Object>();
	//
	// swipeObject.put("startX", screenWidth);
	// swipeObject.put("startY", screenHight + ScreenHightValue);
	// swipeObject.put("endX", screenWidth);
	// swipeObject.put("endY", screenHight);
	// swipeObject.put("duration", 1.8);
	// js.executeScript("mobile: swipe", swipeObject);
	//
	// } catch (Exception ex) {
	//
	// ex.printStackTrace();
	//
	// }
	//
	// }

	public static void swipeVertically(int swipeValue) {
		try {
			Double swipeHight = 0.0;
			swipeHight = (double) swipeValue;
			Dimension screenSize = DriverSession.getLastExecutionDriver().manage().window().getSize();
			Double screenWidth = Double.valueOf(String.valueOf(screenSize.getWidth())) / 2;
			Double screenHight = Double.valueOf(String.valueOf(screenSize.getHeight())) / 2;

			if (screenHight + swipeValue > screenHight * 2 || swipeValue == 0) {
				swipeHight = screenHight / 2;

			}

			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			HashMap<String, Object> swipeObject = new HashMap<String, Object>();
			swipeObject.put("startX", screenWidth);
			swipeObject.put("startY", screenHight + swipeHight);
			swipeObject.put("endX", screenWidth);
			swipeObject.put("endY", screenHight);
			swipeObject.put("duration", 1.8);
			js.executeScript("mobile: swipe", swipeObject);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void swipeMultipleIteration(int iteration) {
		int i = 0;
		try {
			while (i < iteration) {
				// //System.out.println(element.getText());
				// if(element.getText().equals(text))
				// break;
				swipeVertically(300);
				i++;
				// elements=ViewPortFolioPage.getInstance().listCreatedPortFolios(DriverSession.getLastExecutionDriver());
			}
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static String getText(WebElement element) { // ##U
		String textVal = "";
		try {
			textVal = element.getText().trim();
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
		return textVal;
	}

	public static boolean isElementPresent(WebElement element) { // ##U
		boolean flag = false;
		if (GlobalParam.setSafari)
			explicitWait(1);
		try {
			flag = element.isDisplayed();
			DriverSession.setStepResult(flag);
		} catch (Exception ee) {
			DriverSession.setStepResult(flag);
		}
		return flag;
	}

	public static boolean isElementEnable(WebElement element) {
		boolean flag = false;
		try {
			flag = element.isEnabled();
			DriverSession.setStepResult(flag);
		} catch (Exception e) {
			DriverSession.setStepResult(flag);
		}

		return flag;
	}

	public static String getAttributeVal(WebElement element, String text) { // ##U
		String textVal = "";
		try {
			textVal = element.getAttribute(text);
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
		return textVal;
	}

	public static String getAttributeValByJS(WebDriver driver, String elementValue, String elementType) {
		String textVal = "";
		String query = "";
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			if (elementType.equalsIgnoreCase("id"))
				query = "return document.getElementById('" + elementValue + "').innerText;";
			else if (elementType.equalsIgnoreCase("name")) {
				query = "return document.getElementsByName('" + elementValue + "')[0].value;";
			} else if (elementType.equalsIgnoreCase("class")) {
				query = "return document.getElementsByClassName('" + elementValue + "')[0].value;";
			}
			textVal = (String) js.executeScript(query);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
		return textVal;
	}

	public static String getTextByText(List<WebElement> elements, String text) {
		String value = "";
		try {
			for (WebElement element : elements) {

				if (element.getText().equals(text)) {
					value = element.getText();
					DriverSession.setStepResult(true);
					return value;
				}
			}
			DriverSession.setStepResult(false);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
		return text;
	}

	public static void verifyValues(double v1, double v2) {
		try {
			v1 = Math.round(v1);
			v2 = Math.round(v2);
			if (v1 == v2) {
				DriverSession.setStepResult(true);
			} else {
				DriverSession.setStepResult(false);
			}
		}

		catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void selectText(WebElement element, String text) { // ##U
		try {
			new Select(element).selectByVisibleText(text);
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void selectByValue(WebElement element, String value) { // ##U
		try {
			new Select(element).selectByValue(value);
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public void javaScriptExecuter() {
		((JavascriptExecutor) driver).executeScript("document.getElementByClass('ui-datepicker-month').value = '3';");
		((JavascriptExecutor) driver).executeScript("document.getElementByClass('datepicker-year').value = '1998';");
		((JavascriptExecutor) driver)
				.executeScript("document.getElementByClass('ui-datepicker-current-day').value = '1998';");
		((JavascriptExecutor) driver)
				.executeScript("document.getElementsById('transactionDate').removeAttribute('readonly');");

	}

	public static double getTextFromPage(List<WebElement> elements) {
		String text = "";
		double currentAmount = 0;
		try {
			for (WebElement element : elements) {
				text = element.getText();
				// System.out.println("getTextFromPage" + text);
				if (text.equalsIgnoreCase("Current Value") || text.equalsIgnoreCase("Today's Change"))
					continue;

				if (text.contains("K")) {
					text = text.substring(0, text.length() - 1);
				} else {
					// System.out.println("R u mad ?");
				}
				currentAmount += Double.parseDouble(text);
			}
			// System.out.println("currentAmount " + currentAmount);
			DriverSession.setStepResult(true);
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
		return currentAmount;
	}

	public static String changeDateFormate(String oldDate) {
		String newDate = "";
		try {
			final String OLD_FORMAT = "dd/MM/yyyy";
			final String NEW_FORMAT = "dd-MM-yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDate);
			sdf.applyPattern(NEW_FORMAT);
			newDate = sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	public static void isColorRed(WebElement element) {
		String color;
		try {
			color = element.getAttribute("class");
			if (color.contains("red")) {
				DriverSession.setStepResult(true);
			} else {
				DriverSession.setStepResult(false);
			}
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static void waitForObject(WebElement element) { // ##U
		try {
			WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), 120);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}

	public static void waitForObject(WebElement element, long time) { // ##U
		try {
			WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), time);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}

	public static void waitForObjectToInvisible(By element, long tme) { // ##U
		WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), tme);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	public static void waitForObjectToInvisible(WebElement element, long tme) { // ##U
		WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), tme);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void swipeuntilObjectNotFound(int iterator) {
		try {
			for (int i = 0; i < iterator; i++)
				swipeVertically(300);
		} catch (Exception ee) {

		}
	}

	public static void clickByIndex(List<WebElement> elements, int index) { // ##U
		int idx = 0;
		try {
			for (WebElement elem : elements) {
				if (idx == index) {
					elem.click();
					DriverSession.setStepResult(true);
					break;
				}
				idx++;
			}
		} catch (Exception ee) {
			DriverSession.setStepResult(false);
		}
	}

	public static String getCssValue(WebElement element, String attributeName) { // ##U
		String value = "";
		try {
			value = element.getCssValue(attributeName);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
		return value;
	}

	public static List<String> validatCredentials(WebElement ph_No, WebElement city_State, WebElement pin) {
		List<String> al = new ArrayList<String>();
		try {

			al.add(ph_No.getText());
			al.add(city_State.getText());
			al.add(pin.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public static float floatParser(WebElement element) { // ##U
		String elements = "";
		float value = 0.0f;
		DriverSession.setStepResult(false);
		try {
			elements = element.getText();
			elements = elements.replace(",", "");
			value = Float.parseFloat(elements);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return value;
	}

	public static int integerParser(WebElement element) {
		String elements = "";
		int value = 0;
		DriverSession.setStepResult(false);
		try {
			elements = element.getText();
			value = Integer.parseInt(elements);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return value;
	}

	// This method calculates total qty rate inside Shopping cart
	public static float verifyShoppingCartPageDetails(WebElement Quantity, WebElement rate) { // ##U
		int qty = 0;
		float amt = 0.0f;
		float total = 0;
		DriverSession.setStepResult(false);
		try {
			String qty1 = Quantity.getText();
			String amt1 = rate.getText();
			qty = Integer.parseInt(qty1);

			amt1 = amt1.replace(",", "");
			amt = Float.parseFloat(amt1);
			total = qty * amt;
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return total;
	}

	public static int expectedCalculation(String first, String middle) {
		int val1 = 0;
		int val2 = 0;
		int total = 0;
		try {
			val1 = Integer.parseInt(first);
			val2 = Integer.parseInt(middle);
			total = val1 + val2;
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return total;
	}

	public static int getCartValue(WebElement element) {
		int cartValue = 0;
		try {
			String value = element.getText();
			cartValue = Integer.valueOf(value);
			DriverSession.setStepResult(true);

		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return cartValue;
	}

	public static String verifyTextfromDropDown(WebElement element, String textName) { // ##U
		String textDropDownField = "";
		DriverSession.setStepResult(false);
		try {
			textDropDownField = element.getText();
			if (textDropDownField.equalsIgnoreCase(textName)) {
				DriverSession.setStepResult(true);
			}
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
		return textDropDownField;
	}

	public static void verifyTextOnPage(String text) {
		boolean textFound = false;
		try {
			textFound = driver.get().getPageSource().contains(text);

			if (textFound) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text verified.", "PASS",
						"Text should be verified.");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text not verified.",
						"FAIL", "Text should not  be verified.");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text not verified.", "FAIL",
					"Text should not be verified.");
		}
	}

	public static void verifyTextMessage(String actualTxt, String expectedTxt) {
		try {
			if (actualTxt.toLowerCase().trim().equals(expectedTxt.toLowerCase().trim())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						actualTxt + " & " + expectedTxt + " Text matched", "PASS",
						actualTxt + " & " + expectedTxt + " Text should be matched");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						actualTxt + " & " + expectedTxt + " Text not matched", "FAIL",
						actualTxt + " & " + expectedTxt + " Text should be matched");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occurred while verifing " + actualTxt + " & " + expectedTxt, "FAIL",
					actualTxt + " & " + expectedTxt + " text should be matched");
		}
	}

	public static void validateSingleElementWithMultiple(List<WebElement> element, String option) { // ##U
		try {
			DriverSession.setStepResult(false);
			for (WebElement element2 : element) {
				if (element2.getText().equalsIgnoreCase(option)) {
					DriverSession.setStepResult(true);
					break;
				} else {
					DriverSession.setStepResult(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRandomInteger(int maxRange) { // ##U
		int result = 0;
		try {
			Random t = new Random();
			result = t.nextInt(maxRange);
		} catch (Exception e) {
		}
		return result;
	}

	public static int getRandomIntegerBtRange(int minRange, int maxRange) { // ##U
		int result = 0;
		try {
			Random t = new Random();
			result = t.nextInt(maxRange - minRange) + minRange;
		} catch (Exception e) {
		}
		return result;
	}

	public static void setChangePasswordProperties(String randomPassword) {
		try {
			Properties prop = new Properties();
			OutputStream output = null;
			try {
				output = new FileOutputStream(GlobalParam.PROJECT_ROOT_PATH
						+ "Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/ChangePassword.properties");
				prop.setProperty("New_Password", randomPassword);
				prop.store(output, null);

			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getChangePasswordProperties(String value) {
		FileInputStream fileInput = null;
		Properties prop = new Properties();
		try {
			File file = new File(GlobalParam.PROJECT_ROOT_PATH
					+ "Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/ChangePassword.properties");
			fileInput = new FileInputStream(file);

			try {
				prop.load(fileInput);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (prop.getProperty(value));
	}

	public static ArrayList<String> verifyMultipleClickableObjects(List<WebElement> element) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			DriverSession.setStepResult(false);
			for (WebElement elements : element) {
				if (elements.isDisplayed()) {
					DriverSession.setStepResult(true);
					al.add(elements.getText());
				} else {
					DriverSession.setStepResult(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public static String verifyMultipleIsEnabledObjects(List<WebElement> element) {
		String object_Name = null;
		try {
			DriverSession.setStepResult(false);
			// System.out.println(element.size());
			for (WebElement elements : element) {
				if (elements.getAttribute("checked").equalsIgnoreCase("true")) {

					DriverSession.setStepResult(true);
					object_Name = elements.getText();
					break;
				} else {
					DriverSession.setStepResult(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object_Name;
	}

	public static List<String> splitRowDataWithPipeOperator(String dataSheet) { // ##U
		List<String> al = new ArrayList<String>();
		try {
			StringTokenizer split_Data = new StringTokenizer(dataSheet, GlobalParam.tokenType);
			while (split_Data.hasMoreTokens()) {
				al.add(split_Data.nextToken());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public static void validateAndFetchRadioButtonValue(List<WebElement> payment_RaddioButtons,
			String pmtTextFieldValue, String payment_Options) {
		DriverSession.setStepResult(false);
		int count = 0;
		String actual = null;
		List<String> options = new ArrayList<String>();
		List<String> option2 = new ArrayList<String>();
		try {
			DriverSession.setStepResult(true);
			options = Keywords.splitRowDataWithPipeOperator(payment_Options);
			option2 = Keywords.splitRowDataWithPipeOperator(pmtTextFieldValue);

			for (WebElement paymentOption : payment_RaddioButtons) {
				for (int i = count; i < options.size(); i++) {
					if (paymentOption.getText().equalsIgnoreCase(options.get(i))) {
						DriverSession.setStepResult(true);
						paymentOption.click();
						count++;
						try {
							actual = null;
							// actual = PaymentMethod.getInstance()
							// .getStringFromTextField(driver);
							if (actual.equalsIgnoreCase(option2.get(i)))
								;
							{
								DriverSession.setStepResult(true);

								DriverSession.getLastExecutionReportingInstance().teststepreporting(
										"<u>PaymentMethod Page : </u><br> By clicking to <b>" + paymentOption.getText()
												+ "</b> value is  <b><i> " + actual
												+ "</b><br>options is successfully validated ",
										"PASS",
										"<u>PaymentMethod Page : </u><br> clicking to <b>" + paymentOption.getText()
												+ "</b> - <b><i> " + actual
												+ " </b><br>options should be successfully validated Clicked");
							}
							break;
						} catch (Exception oo) {
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									"<u>PaymentMethod Page : </u><br> By clicking to <b> " + paymentOption.getText()
											+ " </b>no option in text field is visible successfully validated ",
									"PASS",
									"<u>PaymentMethod Page : </u><br> By clicking to <b> Cash on Delivery </b>no option in text field should be successfully validated Clicked");
						}
					} else {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"<u>PaymentMethod Page : </u><br> By clicking to <b>" + paymentOption.getText()
										+ " </b>value is <b><i> " + actual
										+ " </b><br>options is not successfully validated ",
								"FAIL",
								"<u>PaymentMethod Page : </u><br> clicking to <b>" + paymentOption.getText()
										+ "</b> - <b><i> " + actual
										+ " </b><br>options should be successfully validated Clicked");
						continue;

					}
				}
			}
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void dynamicwait(WebDriver driver, Integer time, WebElement element) { // ##U
		try {
			(new WebDriverWait(driver, time)).until(ExpectedConditions.elementToBeClickable(element));
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object successfully",
						"PASS", "Should be wait for object");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
						"Should be wait for object");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
					"Should be wait for object");
		}
	}

	public static void dynamicwaitForElementToBeVisible(WebDriver driver, Integer time, WebElement element,
			boolean message) { // ##U
		try {
			(new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));
			if (message)
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Wait for Visibility of object successfully", "PASS",
						"Should be wait for Visibility of object");
		} catch (Exception e) {
			if (message)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
						"Should be wait for Visibility of object");
		}
	}

	public static void hideKeyBoard() { // ##U
		try {
			a_Driver.get().hideKeyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String ltrim(String name) {
		String option = "";
		String split[] = name.split(" ");
		for (int i = 1; i < split.length; i++) {
			option = option + " " + split[i];
		}
		return option;
	}

	public static List<String> convertAlphaNumericToAlphabetical(String name) {
		DriverSession.setStepResult(false);
		char array[] = new char[26];
		List<String> list = new ArrayList<String>();
		int flag = 0, c = 0;
		try {
			char ch[] = name.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				flag = 0;
				for (char j = '0'; j <= '9'; j++) {
					if (ch[i] == j) {
						flag++;
					} else {
						continue;
					}
				}
				if (flag == 0) {
					array[c] = ch[i];
					c++;
				}
			}
			String str = new String(array);
			list.add(str.trim());
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.setStepResult(false);
		}
		return list;
	}

	public static void selectByVisibleText(WebElement element, String name) { // ##U
		DriverSession.setStepResult(false);
		try {
			Select select = new Select(element);
			select.selectByVisibleText(name);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static List<String> getSelectOptionList(WebElement element) { // ##U
		DriverSession.setStepResult(false);
		List<String> optionList = new ArrayList<>();
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement webElement : options) {
				optionList.add(getText(webElement));
			}
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}

		return optionList;
	}

	public static void keyEnter(WebElement element) { // ##U
		DriverSession.setStepResult(false);
		try {
			element.sendKeys(Keys.RETURN);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	public static String getTextFromObject(WebElement element) {
		String message = "";
		DriverSession.setStepResult(false);
		try {
			message = element.getText();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.getMessage();
		}
		return message;
	}

	public static float valueAfterCODCharges(float subTotal, int CODCharges) {
		float total = 0.0f;
		DriverSession.setStepResult(false);
		try {
			total = (subTotal + CODCharges);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.getMessage();
		}
		return total;
	}

	public static String getRoundValue(String value) {
		DriverSession.setStepResult(false);
		String actualResult = "";
		int exp = 0;
		try {
			exp = Math.round(Float.parseFloat(value));
			actualResult = exp + "";
			DriverSession.setStepResult(true);
		} catch (NumberFormatException e) {
			DriverSession.setStepResult(false);
			e.getMessage();
		}
		return actualResult;
	}

	public static void moveToElementClick(WebElement element, WebDriver driver, int value) { // ##U
		try {
			DriverSession.setStepResult(false);
			switch (value) {
			case 1:
				Actions action1 = new Actions(driver);
				action1.moveToElement(element).perform();
				DriverSession.setStepResult(true);
				break;
			case 2:
				Actions action2 = new Actions(driver);
				action2.moveToElement(element).click();
				DriverSession.setStepResult(true);
				break;
			case 3:
				element.click();
				DriverSession.setStepResult(true);
				break;
			case 4:
				Actions action4 = new Actions(driver);
				action4.moveToElement(element).doubleClick().perform();
				DriverSession.setStepResult(true);
				break;
			default:
				DriverSession.setStepResult(false);
				throw new InvalidInputException();
			}
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.getMessage();
		}
	}

	public static void moveToElementClick(WebElement element, WebDriver driver) { // ##U
		try {
			DriverSession.setStepResult(false);
			Actions action2 = new Actions(driver);
			action2.moveToElement(element).click().perform();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void drawLine(WebElement element, WebDriver driver) {
		try {

			DriverSession.setStepResult(false);
			Actions action = new Actions(driver);
			Action actions = action.clickAndHold(element).moveByOffset(50, 10).moveByOffset(-10, -50)
					.moveByOffset(100, 200).release().build();
			actions.perform();
			explicitWait(5);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static List<String> getDropDownValue(WebElement element) { // ##U
		List<String> value = new ArrayList<String>();
		try {
			Select st = new Select(element);
			List<WebElement> al = st.getOptions();
			for (WebElement option : al) {
				value.add(option.getText());
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return value;
	}

	public static void getDefaultDropDownValue(String tabName, WebElement element, WebDriver driver) {
		List<String> value = new ArrayList<String>();
		try {
			Select st = new Select(element);
			List<WebElement> al = st.getAllSelectedOptions();
			for (WebElement all : al) {

				value.add(all.getText());
				if (all.getText() != null) {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b> " + tabName + " </b> with default Value is <br><b><i>" + all.getText()
									+ "</b></i><br> is selected and validated successfully <br>",
							"PASS", "Search Field should be successfully typed and clicked");
					break;
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b> " + tabName + " </b> with default Value is <br><b><i>" + all.getText()
									+ "</b></i><br> is not selected and validated successfully <br>",
							"FAIL", "Search Field should be successfully typed and clicked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickSelectTypetext(WebElement type, String string) { // ##U
		DriverSession.setStepResult(false);
		try {
			Select selectByIndex = new Select(type);
			selectByIndex.selectByVisibleText(string);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	public static void closeAlertpopup(WebDriver driver2) { // ##U
		DriverSession.setStepResult(false);
		try {
			Alert alert = driver2.switchTo().alert();
			explicitWait(1);
			alert.accept();
			DriverSession.setStepResult(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Popup is closed", "INFO",
					"Popup should be closed");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception... " + e.getMessage(),
					"FAIL", "Popup should be closed");
			DriverSession.setStepResult(false);
			e.printStackTrace();
		} finally {
			driver2.switchTo().defaultContent();
		}
	}

	public static void validatePageContents(WebElement elements, List<String> val) {
		DriverSession.setStepResult(false);
		String gotText = elements.getText();
		try {
			for (int i = 0; i < val.size(); i++) {

				if (gotText.contains(val.get(i))) {

					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b><i>" + val.get(i) + "</i></b> is successfully Verified<br>", "PASS",
							"<b><i>" + val.get(i) + "</i></b> should be successfully Verified");
					DriverSession.setStepResult(true);
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							"<b><i>" + val.get(i) + "</i></b> is not Verified", "FAIL",
							"<b><i>Task</i></b> should be successfully Verified");
					DriverSession.setStepResult(false);
					continue;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static boolean isTextPresent(String text) {
		try {
			boolean b = driver.get().getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			return false;
		}
	}

	public static void swiper() { // ##U
		try {
			a_Driver.get().swipe(150, 500, 150, 50, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollingToBottomOfAPage(WebDriver driver) { // ##U
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Munish - The below method is for debug purpose only, Remove the calling
	// of this method when we are running the things on production
	public static void getPageSource1(String pgSource) { // ##U
		try {
			File file = new File(GlobalParam.CURRENT_PROJECT_PATH + "/TestRepository/pageSource1Temp.txt");
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(pgSource);
			bw.close();
		} catch (Exception e) {

		}
	}

	// Munish - The below method is for debug purpose only, Remove the calling
	// of this method when we are running the things on production
	public static void getPageSource2(String pgSource) { // ##U
		try {
			File file = new File(GlobalParam.CURRENT_PROJECT_PATH + "/TestRepository/pageSource2Temp.txt");
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(pgSource);
			bw.close();
		} catch (Exception e) {

		}
	}

	public static void paceActiveCheck_t(WebDriver driver) { // ##U
		try {
			long startTime = System.currentTimeMillis();
			explicitWait(1);
			while ((System.currentTimeMillis() - startTime) < 2.5 * 60 * 1000) {
				try {
					if (driver.getPageSource().contains("pace-inactive"))
						break;
				} catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
		}
		explicitWait(1);
	}

	public static void paceActiveCheck(WebDriver driver) { // ##U
		try {
			Keywords.explicitWait(5);
		} catch (Exception e) {
		}
	}

	public static void scrollingToTopOfAPage(WebDriver driver) { // ##U
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	public By checkElement(WebDriver driver, By web) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		for (int i = 0; i < 6; i++) {
			try {
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(web));
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				return web;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				a_Driver.get().swipe(50, 500, 50, 50, 100);
			}
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return web;
	}

	public static void scrollUntilTextFound() {
		try {
			a_Driver.get().swipe(50, 500, 50, 50, 100);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void scrollDown() { // ##U
		try {
			a_Driver.get().swipe(50, 200, 50, 50, 1000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void scrollUp() { // ##U
		try {
			a_Driver.get().swipe(50, 50, 50, 200, 1000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void scrollVerticalOverElement(WebElement element) {
		try {
			int height = a_Driver.get().manage().window().getSize().height / 2;
			int elementHeight = element.getLocation().getY() + (element.getSize().height / 2);
			int x = element.getLocation().getX() + (element.getSize().width / 2);
			if (elementHeight > height)
				a_Driver.get().swipe(x, elementHeight, x, height, 1000);
			else
				a_Driver.get().swipe(x, height, x, elementHeight, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickCancel(WebDriver driver) { // ##U
		try {
			waitForPage(driver, 1);
			driver.findElement(By.xpath("//div[@class='buttons-container']//a[@class='cm-dialog-closer tool-link']"))
					.click();
		} catch (Exception e) {
		} finally {
			waitForPage(driver, 60);
		}
	}

	public static String getTimeStampValue() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy h:mm:ss.mmm");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static void backPage() {
		try {
			driver.get().navigate().back();
		} catch (Exception e) {
		}
	}

	public static boolean verifyPageLoaded(String pageName) {
		boolean status = false;
		try {
			if (driver.get().getCurrentUrl().contains(pageName))
				status = true;
			else
				status = false;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return status;
	}

	public static boolean verifyPageLoaded(WebDriver driver, String pageName) {
		boolean status = false;
		try {
			waitForPage(driver);
			if (driver.getCurrentUrl().contains(pageName))
				status = true;
			else
				status = false;
		} catch (Exception e) {
		}

		return status;
	}

	public static void swipeVerticallyTillObject(int swipeValue) { // ##U
		try {
			int swipeHight = 0;
			swipeHight = swipeValue;
			Dimension screenSize = a_Driver.get().manage().window().getSize();

			int screenWidth = screenSize.getWidth() / 2;
			int screenHight = screenSize.getHeight() / 2;
			if (screenHight + swipeValue > screenHight * 2 || swipeValue == 0) {
				swipeHight = screenHight / 2;
			}

			a_Driver.get().swipe(screenWidth, screenHight + swipeHight, screenWidth, screenHight, 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void swipeVerticallyOneIteration() { // ##U
		try {
			int swipeHight = 0;
			Dimension screenSize = a_Driver.get().manage().window().getSize();

			int screenWidth = screenSize.getWidth() / 2;
			int screenHight = screenSize.getHeight() / 2;
			swipeHight = screenHight * 3 / 4;

			a_Driver.get().swipe(screenWidth, screenHight + swipeHight, screenWidth, screenHight, 1000);
			Keywords.explicitWait(4);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean swipeTillObjectDisplayedAndClick(WebDriver driver, String objectText) { // ##U
		int size;
		boolean flag = false;
		try {
			List<WebElement> elements = driver.findElements(By.id("com.shopclues:id/name"));
			size = elements.size();
			for (WebElement element : elements) {
				if (element.getText().equals(objectText)) {
					element.click();
					flag = true;
					break;
				}
				size--;
			}
			if (size == 0 && flag == false) {
				swipeVerticallyTillObject(600);
				flag = swipeTillObjectDisplayedAndClick(driver, objectText);
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static boolean swipeTillCategoryDisplayedAndClick(WebDriver driver, String objectText) {
		int size;
		boolean flag = false;
		try {
			List<WebElement> elements = driver.findElements(By.id("com.shopclues:id/text"));
			size = elements.size();
			for (WebElement element : elements) {
				if (element.getText().equals(objectText)) {
					element.click();
					flag = true;
					break;
				}
				size--;
			}
			if (size == 0 && flag == false) {
				swipeVerticallyTillObject(600);
				flag = swipeTillObjectDisplayedAndClick(driver, objectText);
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static boolean swipeTillObjectDisplayedAndClick(WebDriver driver, WebElement ele, int count) {
		boolean flag = false;
		DriverSession.setStepResult(false);
		try {
			if (ele.isDisplayed() && count < 6) {
				ele.click();
				flag = true;
				DriverSession.setStepResult(true);
				return flag;
			} else {
				scrollingToBottomOfAPage(driver);
				swipeTillObjectDisplayedAndClick(driver, ele, count++);
			}
		} catch (Exception e) {
			scrollingToBottomOfAPage(driver);
			// ele =
			// MobileLocators.getInstance().clickToServiceFeeAgreementLink(
			// driver);
			swipeTillObjectDisplayedAndClick(driver, ele, count++);
		}
		DriverSession.setStepResult(false);
		return flag;
	}

	public static void waitUntilPageLoading(WebDriver driver) { // ##U
		WebElement element1 = null;
		Keywords.waitForPage(driver, 2);
		long startTime = System.currentTimeMillis();
		explicitWait(2);
		element1 = driver.findElement(By.id("ajax_loading_box"));
		while ((System.currentTimeMillis() - startTime) < 2.5 * 60 * 1000) {
			try {
				String style = element1.getAttribute("style");
				if (style.contains("display: none"))
					break;
			} catch (Exception e) {
				break;
			} finally {
				Keywords.waitForPage(driver, 60);
			}
		}
	}

	public static void waitUntilPageFullyLoaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait.until(pageLoadCondition);
	}

	public static void dynamicwaitForElementToBeVisible(WebDriver driver, Integer time, WebElement element) { // ##U
		try {
			(new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Wait for Visibility of object successfully", "PASS", "Should be wait for Visibility of object");
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
					"Should be wait for Visibility of object");
		}
	}

	public static void swipeTillButtonObjectAndClick(WebDriver driver, By byText, String objectText) { // ##U
		try {
			counter = 0;
			swipeTillButtonAndClick(driver, byText, objectText);
		} catch (Exception e) {
		}
	}

	private static void swipeTillButtonAndClick(WebDriver driver, By byText, String objectText) { // ##U
		counter++;
		if (counter > 5) {
			counter = 0;
			return;
		}
		int size = 0;
		List<WebElement> elements = driver.findElements(byText);
		try {
			size = elements.size();
			if (size == 0) {
				swipeVerticallyTillObject(600);
				swipeTillButtonObjectAndClick(driver, byText, objectText);
			}
			for (WebElement element : elements) {
				if (element.getText().equals(objectText)) {
					element.click();
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public static void swipeTillButtonObjectDisplayed(WebDriver driver, By byText) { // ##U
		try {
			counter = 0;
			swipeTillObjectDisplayed(driver, byText);
		} catch (Exception e) {
		}
	}

	private static void swipeTillObjectDisplayed(WebDriver driver, By byText) { // ##U
		counter++;
		if (counter > 5) {
			counter = 0;
			return;
		}
		int size = 0;
		List<WebElement> elements = driver.findElements(byText);
		try {
			size = elements.size();
			if (size == 0) {
				swipeVerticallyTillObject(600);
				swipeTillButtonObjectDisplayed(driver, byText);
			} else
				return;
		} catch (Exception e) {
		}
	}

	public static void moveToElement(WebElement element, WebDriver driver) { // ##U
		try {
			DriverSession.setStepResult(false);
			Actions action2 = new Actions(driver);
			action2.moveToElement(element).perform();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void performContextClick(WebElement element, WebDriver driver, String openType) {
		try {
			Actions action = new Actions(driver);
			if (openType.equalsIgnoreCase("new tab"))
				action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			else if (openType.equalsIgnoreCase("new window"))
				action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build().perform();
			else if (openType.equalsIgnoreCase("new private window"))
				action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			;
		} catch (Exception e) {

		}
	}

	public static void swipeUpTillObjectDisplayed(WebDriver driver, By byText) { // ##U
		try {
			counter = 0;
			swipeUpTillObjectVisible(driver, byText);
		} catch (Exception e) {
		}
	}

	private static void swipeUpTillObjectVisible(WebDriver driver, By byText) { // ##U
		counter++;
		if (counter > 5) {
			counter = 0;
			return;
		}
		int size = 0;
		List<WebElement> elements = driver.findElements(byText);
		try {
			size = elements.size();
			if (size == 0) {
				swipeVerticallyUp();
				swipeUpTillObjectDisplayed(driver, byText);
			} else
				return;
		} catch (Exception e) {
		}
	}

	public static void swipeVerticallyUp() { // ##U
		try {
			Dimension screenSize = a_Driver.get().manage().window().getSize();
			int screenWidth = screenSize.getWidth();
			int screenHight = screenSize.getHeight();
			a_Driver.get().swipe(screenWidth / 4, screenHight / 4, screenWidth / 4, screenHight / 2 + 100, 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void handleUploadFilePopup(String targetElement, WebDriver driver, String uploadFilePath) { // ##U
		try {
			DriverSession.setStepResult(false);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('" + targetElement + "').style.display = 'block';");
			driver.findElement(By.id(targetElement)).sendKeys(uploadFilePath);
			js.executeScript("document.getElementById('" + targetElement + "').style.display = 'none';");
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
		}
	}

	public static void swipeUpRecursionCount(WebDriver driver, By byText) { // ##U
		int count = 0;
		if (count < 7) {
			swipeUpTillObjectDisplayed(driver, byText);
			count++;
		}
	}

	public static void dynamicwaitForElementPresence(WebDriver driver, Integer time, By byLocator) { // ##U
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void androidScroll(String scrollToString) { // ##U
		try {
			a_Driver.get().scrollTo(scrollToString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double removeNonNumericFromString(String stringToConvert) {
		double value = 0.0;
		try {
			String[] splitForDecimal = stringToConvert.split("\\.");
			if (splitForDecimal.length == 2) {
				value = Double.valueOf(
						splitForDecimal[0].replaceAll("\\D+", "") + "." + splitForDecimal[1].replaceAll("\\D+", ""));
			} else if (splitForDecimal.length == 3) {
				value = Double.valueOf(
						splitForDecimal[1].replaceAll("\\D+", "") + "." + splitForDecimal[2].replaceAll("\\D+", ""));
			} else {
				value = Double.valueOf(stringToConvert.trim().replaceAll("\\D+", ""));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static void iOSDatePicker(String day, String month, String year) {
		try {
			for (int i = 0; i < 3; ++i) {
				String text = driver.get().findElement(By.xpath("//UIAPickerWheel[" + (i + 1) + "]"))
						.getAttribute("value");
				if (text.matches("^[a-zA-Z]*$"))
					driver.get().findElement(By.xpath("//UIAPickerWheel[" + (i + 1) + "]")).sendKeys(month);
				else if (text.matches("^[0-9]{1,2}$"))
					driver.get().findElement(By.xpath("//UIAPickerWheel[" + (i + 1) + "]")).sendKeys(day);
			}
			driver.get().findElement(By.xpath("//UIAPickerWheel[3]")).sendKeys(year);
			driver.get().findElement(By.xpath("//UIAButton[@label='Done']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getiOSAlertText() {
		String text = null;
		try {
			WebElement element = driver.get().findElement(By.xpath("//UIAAlert//UIAScrollView//UIAStaticText[2]"));
			text = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static Date getChangedDate(int amount) {
		Date date = new Date();
		Calendar calender = new GregorianCalendar();
		calender.setTime(date);
		calender.add(Calendar.DATE, amount);
		date = calender.getTime();
		return date;
	}

	public static String getRandomString() {
		String finalValue = null;
		DriverSession.setStepResult(false);
		try {
			String result = getRandomData();
			char[] ch = result.toCharArray();
			finalValue = "";
			for (char c : ch) {
				int temp = 97 + Character.getNumericValue(c);
				finalValue = finalValue.concat(Character.toString((char) temp));
			}
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
		return finalValue;
	}

	public static String getRandomNumber(int numberLength) {
		String randomNumberAsString = "";
		try {
			randomNumberAsString = RandomStringUtils.randomNumeric(numberLength);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return randomNumberAsString;
	}

	public static List<Integer> generateRandomUniqueNumber(int listSize, int howManyNumbers) {
		int[] number = new int[howManyNumbers];
		List<Integer> sortedArray = new ArrayList<>();
		int count = 0;
		int num;
		Random r = new Random();
		while (count < number.length) {
			num = r.nextInt(listSize);
			boolean repeat = false;
			do {
				for (int i = 0; i < number.length; i++) {
					if (num == number[i]) {
						repeat = true;
						break;
					} else if (i == count) {
						number[count] = num;
						count++;
						repeat = true;
						break;
					}
				}
			} while (!repeat);
		}
		for (int j = 0; j < number.length; j++)
			sortedArray.add(number[j]);
		Collections.sort(sortedArray);

		return sortedArray;
	}

	public static String getRandomAlphabetic(int numberLength) {
		String randomNumberAsString = "";
		try {
			randomNumberAsString = RandomStringUtils.randomAlphabetic(numberLength);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return randomNumberAsString;
	}

	public static String getRandomRXNumber(int length) {
		String rxNumber = "";
		try {
			rxNumber = RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomNumeric(length)
					+ RandomStringUtils.randomAlphabetic(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rxNumber;
	}

	@SuppressWarnings("deprecation")
	public static void androidYearScroll(int scrollToYear) { // ##U
		try {

			for (int i = 2016; i >= scrollToYear; --i) {
				a_Driver.get().scrollTo(String.valueOf(i - 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void androidMonthScroll(WebDriver driver, String month) { // ##U
		try {
			// a_Driver = (AppiumDriver) driver;
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("MM");
			int mon = Integer.parseInt(format.format(date));
			Date setDate = new Date();
			setDate.setMonth(Integer.parseInt(month) - 1);
			int desmon = Integer.parseInt(format.format(setDate));
			if (mon > desmon) {
				for (int i = mon; i > desmon; --i) {
					WebElement element = driver.findElement(By.id("android:id/animator"));
					a_Driver.get().swipe(element.getLocation().getX(), element.getLocation().getY(),
							element.getLocation().getX(), element.getLocation().getY() + element.getSize().getHeight(),
							1000);
				}
			} else if (mon < desmon) {
				for (int i = mon; i < desmon; ++i) {
					WebElement element = driver.findElement(By.id("android:id/animator"));
					int a = element.getLocation().getX();
					int b = element.getLocation().getY() + element.getSize().getHeight();
					int c = element.getLocation().getX();
					int d = element.getLocation().getY();
					a_Driver.get().swipe(a + 50, b - 50, a + 50, d - 10, 1000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void iOSScrollTo(WebElement element, String text) {
		try {
			((IOSElement) element).scrollTo(text);
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void iOSScrollToAndClick(WebElement element, String text) {
		try {
			((IOSElement) element).scrollTo(text).click();
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	public static void scrollRight(int cumulatedHeight) { // ##U
		try {
			a_Driver.get().swipe(300, cumulatedHeight, 50, cumulatedHeight, 1000);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/*
	 * public static void scrollDownFrame() { // ##U try { WebElement element =
	 * driver.findElement(By.id("com.topfan.TopFan.TestApp:id/swipe_container"))
	 * ; int frameHeight = element.getSize().height; element =
	 * driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_bar")); int
	 * actionBarHeight = element.getSize().height; element =
	 * driver.findElement(By.id("android:id/statusBarBackground")); int
	 * statusBarHeight = element.getSize().height; int statusBarWidth =
	 * element.getSize().width; a_Driver.swipe(statusBarWidth/2,
	 * statusBarHeight+actionBarHeight+frameHeight-50, statusBarWidth/2,
	 * statusBarHeight+actionBarHeight+50, 4000); } catch (Exception e) {
	 * e.getMessage(); } }
	 */
	/*
	 * public static void scrollUpFrame() { // ##U try { WebElement element =
	 * driver.findElement(By.id("com.topfan.TopFan.TestApp:id/swipe_container"))
	 * ; int frameHeight = element.getSize().height; element =
	 * driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_bar")); int
	 * actionBarHeight = element.getSize().height; element =
	 * driver.findElement(By.id("android:id/statusBarBackground")); int
	 * statusBarHeight = element.getSize().height; int statusBarWidth =
	 * element.getSize().width; a_Driver.swipe(statusBarWidth/2,
	 * statusBarHeight+actionBarHeight+50, statusBarWidth/2,
	 * statusBarHeight+actionBarHeight+frameHeight-50 , 4000); } catch
	 * (Exception e) { e.getMessage(); } }
	 */

	public static void iOSScrollInTableWithIndex(int tableIndex, int cellIndex) {
		try {
			WebElement tableView = ((IOSDriver<?>) driver.get())
					.findElementByIosUIAutomation(".tableViews()[" + tableIndex + "]");
			((IOSElement) tableView).findElementByIosUIAutomation(".cells()[" + cellIndex + "].scrollToVisible()");
			DriverSession.setStepResult(true);
		} catch (Exception e) {
			DriverSession.setStepResult(false);
			e.printStackTrace();
		}
	}

	/*
	 * public static void scrollDownQuizScreen(){ try{ WebElement element =
	 * AndroidAppLocators.getInstance().getDeviceStatusBar(driver); int
	 * statusBarHeight = element.getSize().height; int halfStatusBarWidth =
	 * (element.getSize().width)/2; element =
	 * AndroidAppLocators.getInstance().getQuestionScreenHeader(driver); int
	 * questionScreenHeaderHeight = element.getSize().height; element =
	 * AndroidAppLocators.getInstance().getFrame(driver); int frameHeight =
	 * element.getSize().height; a_Driver.swipe(halfStatusBarWidth,
	 * statusBarHeight+frameHeight-50, halfStatusBarWidth,
	 * statusBarHeight+questionScreenHeaderHeight+50, 4000); }catch(Exception
	 * e){ e.printStackTrace(); } }
	 */

	public static void switchToIFrameByNameOrID(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
		explicitWait(2);
	}

	public static void switchToIFrameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		explicitWait(2);
	}

	public static void switchBackToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
		explicitWait(2);
	}

	public static List<String> getWindowHandles(WebDriver driver) {
		List<String> handles = null;
		try {
			handles = new ArrayList<>(driver.getWindowHandles());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return handles;
	}

	public static void switchToWindowHandle(WebDriver driver, int handleIndex) {
		try {
			driver.switchTo().window(getWindowHandles(driver).get(handleIndex));
			explicitWait(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeWindow(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterText(WebDriver driver, WebElement element, String attributeName, String value) {
		try {
			WrapsDriver wraps = (WrapsDriver) driver;
			JavascriptExecutor js = (JavascriptExecutor) wraps.getWrappedDriver();
			js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterTextByJS(WebElement element, String value, String command) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript(command, element, value);// executeScript("document.getElementsByClassName('jqte_editor').value='"+value+"';");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterTextByJS(String command) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTextByJS(String command) {
		String text = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			text = (String) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	public static String getTextByJS(String elementtype, String elementValue) {
		String command = "";
		String text = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (elementtype.equalsIgnoreCase("id"))
				command = "return document.getElementById('" + elementValue + "').value;";
			else if (elementtype.equalsIgnoreCase("name"))
				command = "return document.getElementsByName('" + elementValue + "')[0].value;";
			else if (elementtype.equalsIgnoreCase("class"))
				command = "return document.getElementsByClassName('" + elementValue + "')[0].value;";
			else if (elementtype.equalsIgnoreCase("tag"))
				command = "return document.getElementsByTagName('" + elementValue + "')[0].value;";
			text = (String) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	public static String getTextByJS(String elementtype, String elementValue, int index) {
		String command = "";
		String text = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (elementtype.equalsIgnoreCase("id"))
				command = "return document.getElementById('" + elementValue + "').value;";
			else if (elementtype.equalsIgnoreCase("name"))
				command = "return document.getElementsByName('" + elementValue + "')[" + index + "].value;";
			else if (elementtype.equalsIgnoreCase("class"))
				command = "return document.getElementsByClassName('" + elementValue + "')[" + index + "].value;";
			else if (elementtype.equalsIgnoreCase("tag"))
				command = "return document.getElementsByTagName('" + elementValue + "')[" + index + "].value;";
			text = (String) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	public static String getTextByJS(String elementtype, String elementValue, String subElementType,
			String subElementValue, int index, String attributeValue) {
		String command = "";
		String text = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (elementtype.equalsIgnoreCase("id"))
				command = " return document.getElementById('" + elementValue + "').value;";
			else if (elementtype.equalsIgnoreCase("name"))
				command = "document.getElementsByName('" + elementValue + "')[" + index + "]";
			else if (elementtype.equalsIgnoreCase("class"))
				command = "return document.getElementsByClassName('" + elementValue + "')[" + index + "]";
			else if (elementtype.equalsIgnoreCase("tag"))
				command = "document.getElementsByTagName('" + elementValue + "')[" + index + "].value;";

			if (subElementType.equalsIgnoreCase("tag"))
				command = command + "" + ".getElementsByTagName('" + subElementValue + "').getAttribute("
						+ attributeValue + ");";
			text = (String) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	public static boolean getBtnStatus(String elementtype, String elementValue, int index) {
		boolean status = false;
		String command = "";
		try {
			if (elementtype.equalsIgnoreCase("id"))
				command = "return document.getElementBy('" + elementValue + "').disabled;";
			else if (elementtype.equalsIgnoreCase("class"))
				command = "return document.getElementsByClassName('" + elementValue + "')[" + index
						+ "].getAttribute('disabled');";
			else if (elementtype.equalsIgnoreCase("name"))
				command = "return document.getElementsByName('" + elementValue + "')[" + index + "].disabled;";
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			status = (boolean) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static boolean getCheckBoxStatus(String command) {
		boolean status = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			status = (boolean) js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static void clickByJS(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript("arguments[0].click;", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickByJS(String command) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickByJS(String locatorType, String locatorValue) {
		String command = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (locatorType.equalsIgnoreCase("id"))
				command = "document.getElementById('" + locatorValue + "').click();";
			else if (locatorType.equalsIgnoreCase("class"))
				command = "document.getElementsByClassName('" + locatorValue + "')[0].click();";
			else if (locatorType.equalsIgnoreCase("name"))
				command = "document.getElementsByName('" + locatorValue + "')[0].click();";
			else if (locatorType.equalsIgnoreCase("tag"))
				command = "document.getElementsByTagName('" + locatorValue + "')[0].click();";
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickByJS(String locatorType, String locatorValue, int index) {
		String command = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (locatorType.equalsIgnoreCase("id"))
				command = "document.getElementById('" + locatorValue + "').click();";
			else if (locatorType.equalsIgnoreCase("class"))
				command = "document.getElementsByClassName('" + locatorValue + "')[" + index + "].click();";
			else if (locatorType.equalsIgnoreCase("name"))
				command = "document.getElementsByName('" + locatorValue + "')[" + index + "].click();";
			else if (locatorType.equalsIgnoreCase("tag"))
				command = "document.getElementsByTagName('" + locatorValue + "')[" + index + "].click();";
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickByJS(String locatorType, String subLocatorType, String locatorValue,String subLocatorValue, int index) {
		String subCommand = "";
		String command = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			if (locatorType.equalsIgnoreCase("id"))
				command = "document.getElementById('" + locatorValue + "').click();";
			else if (locatorType.equalsIgnoreCase("class")) {
				command = "document.getElementsByClassName('" + locatorValue + "')[" + index + "]";
				if (subLocatorType.equalsIgnoreCase("class"))
					subCommand = ".getElementsByClassName('"+subLocatorValue+"')["+index+"].click();";
				else if (subLocatorType.equalsIgnoreCase("name"))
					subCommand = ".getElementsByName('"+subLocatorValue+"')["+index+"].click();";
				else if (subLocatorType.equalsIgnoreCase("tag"))
					subCommand = ".getElementsByTagName('"+subLocatorValue+"')["+index+"].click();";
			}
			else if (locatorType.equalsIgnoreCase("name"))
				command = "document.getElementsByName('" + locatorValue + "')[" + index + "].click();";
			else if (locatorType.equalsIgnoreCase("tag"))
				command = "document.getElementsByTagName('" + locatorValue + "')[" + index + "].click();";
			command = command + subCommand;
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void makeTextBoxReadable(String command) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enableDisableElement(String id) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript("document.getElementById('" + id + "').disable=true;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickOnDisableElement(String id) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			js.executeScript("document.getElementById('" + id + "').click();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTextFromTextBox(String id) {
		String value = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverSession.getLastExecutionDriver();
			value = (String) js.executeScript("return document.getElementById('" + id + "').value;");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static void openNewTab(WebElement element) {
		try {
			explicitWait(2);
			if (System.getProperty("os.name").contains("window")) {
				element.sendKeys(Keys.CONTROL + "t");
			} else if (System.getProperty("os.name").contains("Mac"))
				element.sendKeys(Keys.COMMAND + "t");
			explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void openNewTabWithJS(WebDriver driver, String url) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('" + url + "');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeNewTab(WebElement element) {
		try {
			if (System.getProperty("os.name").contains("window")) {
				element.sendKeys(Keys.CONTROL + "w");
			} else if (System.getProperty("os.name").contains("Mac"))
				element.sendKeys(Keys.COMMAND + "w");
			explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateTo(String url) {
		try {
			DriverSession.getLastExecutionDriver().navigate().to(url);
			explicitWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Integer> sortNumberArray(List<Integer> numberArray) {
		Collections.sort(numberArray);

		return numberArray;
	}

	public static List<String> getWeekDaysValueByIndex(List<Integer> integerArray) {
		List<String> weekDayValue = new ArrayList<>();

		List<String> list = new ArrayList<>();
		list.add("Sunday");
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		list.add("Thrusday");
		list.add("Friday");
		list.add("Saturday");

		for (int i = 0; i < integerArray.size(); i++) {
			weekDayValue.add(list.get(0));
		}

		return weekDayValue;
	}

	public static String getCurrentMonthValue() {
		String monthValue = "";
		try {
			monthValue = new SimpleDateFormat("MMM").format(new Date());
		} catch (Exception e) {
		}

		return monthValue;
	}

	public static String getCurrentYearValue() {
		String monthValue = "";
		try {
			monthValue = new SimpleDateFormat("YYYY").format(new Date());
		} catch (Exception e) {
		}

		return monthValue;
	}

	public static String getCurrentYMDValue(String dateFormateType) {
		String value = "";
		try {
			if (dateFormateType.equalsIgnoreCase("year"))
				value = new SimpleDateFormat("yyyy").format(new Date());
			else if (dateFormateType.equalsIgnoreCase("month"))
				value = new SimpleDateFormat("MMM").format(new Date());
			else if (dateFormateType.equalsIgnoreCase("day"))
				value = new SimpleDateFormat("dd").format(new Date());
		} catch (Exception e) {
		}

		return value;
	}

	public int yearCalculator(String date) {
		int year = 0;
		try {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(date));
		} catch (Exception e) {

		}

		return year;
	}

	public static long getTimeBasedOnFormat(String format) {
		long l = 0l;
		try {
			LocalTime time = LocalTime.now();
			if (format.equalsIgnoreCase("minute"))
				l = time.getMinute();
			else if (format.equalsIgnoreCase("hour"))
				l = time.getHour();
			else if (format.equalsIgnoreCase("second"))
				l = time.getSecond();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	// public static String randomMonthValue() {
	// String month = "";
	// Random random = new Random();
	// int monthValue = 1 + random.nextInt(12);
	// System.out.println(monthValue);
	// if (monthValue == 1)
	// month = "Jan";
	// else if (monthValue == 2)
	// month = "Feb";
	// else if (monthValue == 3)
	// month = "Mar";
	// else if (monthValue == 4)
	// month = "Apr";
	// else if (monthValue == 5)
	// month = "May";
	// else if (monthValue == 6)
	// month = "Jun";
	// else if (monthValue == 7)
	// month = "Jul";
	// else if (monthValue == 8)
	// month = "Aug";
	// else if (monthValue == 9)
	// month = "Sep";
	// else if (monthValue == 10)
	// month = "Oct";
	// else if (monthValue == 11)
	// month = "Nov";
	// else if (monthValue == 12)
	// month = "Dec";
	//
	// return month;
	// }

	public static int monthValueInDecimalFormat(String monthName) {
		int monthIndexNumber = 00;
		int number = getMonthsValueList("shortform").indexOf(monthName);
		monthIndexNumber = Integer.parseInt(new DecimalFormat("00").format(number));
		return monthIndexNumber;

	}

	public static List<Integer> numberList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		return list;
	}

	public static String dateInDifferentFormats(String pattern) {
		String date = "";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		date = simple.format(new Date());

		return date;
	}

	public static List<String> getMonthsValueList(String monthValueType) {
		List<String> months = new ArrayList<>();
		String month[] = null;
		if (monthValueType.contains("short")) {
			month = new DateFormatSymbols().getShortMonths();
		} else if (monthValueType.contains("full")) {
			month = new DateFormatSymbols().getMonths();
		}
		for (int i = 0; i < month.length - 1; i++) {
			months.add(month[i]);
		}

		return months;
	}

	public static String getRandomMonthValue(String monthValueFormat) {
		String monthValue = "";
		List<String> months = new ArrayList<>();
		try {
			months = getMonthsValueList(monthValueFormat);
			monthValue = months.get(getRandomInteger(months.size()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return monthValue;
	}

	public static String getMonthIndexBasedOnValue(String monthName) {
		String monthIndexValue = "";
		LinkedHashMap<String, String> list = getMonthValueInDifferentFormat("shortform");
		for (Map.Entry<String, String> map : list.entrySet()) {
			if (map.getValue().equalsIgnoreCase(monthName)) {
				monthIndexValue = map.getKey();
				break;
			}
		}

		return monthIndexValue;
	}

	public static List<String> numberListAsTwoDigits() {
		List<String> list = new ArrayList<>();
		NumberFormat format = new DecimalFormat("00");
		for (int i = 0; i < numberList().size(); i++)
			list.add(format.format(numberList().get(i)));
		return list;
	}

	public static LinkedHashMap<String, String> getMonthValueInDifferentFormat(String formatType) {
		LinkedHashMap<String, String> list = new LinkedHashMap<>();
		for (int i = 0; i < numberListAsTwoDigits().size(); i++) {
			list.put(numberListAsTwoDigits().get(i), getMonthsValueList(formatType).get(i));
		}
		return list;
	}

	public static String getMonthValueBasedOnIndex(String formatType, String indexValue) {
		String value = "";
		HashMap<String, String> info = getMonthValueInDifferentFormat(formatType);
		if (indexValue.length() <= 1)
			indexValue = "0" + indexValue;
		value = info.get(indexValue);
		return value;
	}

	public static String getCurrentDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	public static String getDateAsString(String pattern, String dateValue) {
		String date = "";
		Date date1 = null;
		SimpleDateFormat simple = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date1 = simple.parse(dateValue);
			date = new SimpleDateFormat(pattern).format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int getDayOfTheMonth() {
		int dayValue;
		LocalDate date = LocalDate.now();
		dayValue = date.getDayOfMonth();
		return dayValue;
	}

	public static int numberDigitCount(int number) {
		int count = 0;
		while (number != 0) {
			number = number / 10;
			++count;
		}
		return count;
	}

	public static String getBrowserInfo(WebDriver driver) {
		String info = "";
		try {
			info = ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;").toString().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	public static String getValueFromDate(String dateValue, String valueFor) {
		String value = "";
		try {
			if (valueFor.equalsIgnoreCase("day")) {
				value = dateValue.substring(dateValue.indexOf("/") + 1, dateValue.indexOf("/") + 3);
			} else if (valueFor.equalsIgnoreCase("month")) {
				value = dateValue.substring(0, dateValue.indexOf("/"));
			} else if (valueFor.equalsIgnoreCase("year")) {
				value = dateValue.substring(dateValue.indexOf("/") + 4, dateValue.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static void highLightElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red';", element);
			explicitWait(3);
			js.executeScript("arguments[0].style.border=''", element);

			// js.executeScript("arguments[0].setAttribute('style',arguments[1]);",
			// element, "color: Red; border: 2px dotted solid yellow;");
			// js.executeScript("arguments[0].setAttribute('style',
			// arguments[1]);", element, "");

			// or
			// js.executeScript("arguments[0].setAttribute('style','border:
			// solid 2px white');", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getSystemTime() {
		int time = 0;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static Object numberFormatConversion(String type, String textData) {
		Object obj = null;
		try {
			if (type.equalsIgnoreCase("int"))
				obj = Integer.parseInt(textData);
			else if (type.equalsIgnoreCase("float"))
				obj = Float.parseFloat(textData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
	
	public static long getYearMonthDayDiff(LocalDate previousDate, LocalDate currentDate, String diffType) {
		long diff = 0;
		try {
			if (diffType.equalsIgnoreCase("year"))
				diff = ChronoUnit.YEARS.between(previousDate, currentDate);
			else if (diffType.equalsIgnoreCase("month"))
				diff = ChronoUnit.MONTHS.between(previousDate, currentDate);
			else if (diffType.equalsIgnoreCase("day"))
				diff = ChronoUnit.DAYS.between(previousDate, currentDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return diff;
	}
	
	public static LocalDate convertDateIntoLocalDate(String date, String pattern) {
		LocalDate localDate = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			localDate = localDate.parse(date, formatter);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return localDate;
	}

	public static void setScreenResolution(WebDriver driver) {
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			int Width = (int) toolkit.getScreenSize().getWidth();
			int Height = (int) toolkit.getScreenSize().getHeight();
			Dimension screenResolution = new Dimension(Width, Height);
			driver.manage().window().setSize(screenResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> convertStringAsList(String str) {
		return new ArrayList<>(Arrays.asList(str.split(" ")));
	}

	public static void WaitRealtedTask(WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		// With Function
		// Function<WebDriver, WebElement> func = new Function<WebDriver,
		// WebElement>() {
		// public WebElement apply(WebDriver driver) {
		// WebElement ele= driver.findElement(By.id("qw"));
		// if (ele.isDisplayed())
		// return ele;
		// else
		// return null;
		// }
		// };
		//
		// wait.until(func);
		//
		// wait.until(new Function<WebDriver, WebElement>() {
		// public WebElement apply(WebDriver driver) {
		// return driver.findElement(By.id("dsad"));
		// }
		// });
		//
		// // With Predicate
		// Predicate<WebDriver> pre = new Predicate<WebDriver>() {
		//
		// @Override
		// public boolean apply(WebDriver driver) {
		// WebElement ekem = driver.findElement(By.id("ds"));
		// return ekem.isDisplayed();
		// }
		// };
		//
		// //wait.until(pre);
	}
}