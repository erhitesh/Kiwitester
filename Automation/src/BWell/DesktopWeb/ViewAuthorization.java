package BWell.DesktopWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Keywords;

public class ViewAuthorization {
	
	private WebDriver driver;
	
	public ViewAuthorization(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getSpecialityList() {
		List<WebElement> specialityElementList;
		List<String> specialityList = new ArrayList<>();
		try {
			specialityElementList = Locators.getInstance().specialityListOnViewAuthorization(driver);
			for (WebElement element : specialityElementList)
				specialityList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return specialityList;
	}
	
	public List<String> getMedicalRecordsStatusList() {
		String str = "Obtained Obtaining Can't Obtain";
		//List<WebElement> recordsElementList;
		List<String> mRecordsList = Keywords.convertStringAsList(str);
		try {
//			recordsElementList = Locators.getInstance().medicalRecordsStatusListOnViewAuthorization(driver);
//			for (WebElement element : recordsElementList)
//				mRecordsList.add(Keywords.getText(element));
		} catch (Exception e) {
		}

		return mRecordsList;
	}
	
	public List<String> getAuthorizationList() {
		String str = "Active Expired Revoked";
		//List<WebElement> authElementList;
		List<String> authorizationList = Keywords.convertStringAsList(str);
		try {
//			authElementList = Locators.getInstance().authorizationStatusListOnViewAuthorization(driver);
//			for (WebElement element : authElementList)
//				authorizationList.add(Keywords.getText(element));
			
			
		} catch (Exception e) {
		}

		return authorizationList;
	}
	
	public boolean noDoctorFound() {
		boolean status = false;
		WebElement element;
		try {
			element = Locators.getInstance().noDoctorFoundBasedOnFilter(driver);
			status = Keywords.isElementPresent(element);
		} catch (Exception e) {
		}

		return status;
	}
	
	public boolean getDrListCount() {
		boolean status = false;
		List<WebElement> list;
		try {
			list = Locators.getInstance().getDoctorListFromViewAuth(driver);
			status = list.size() > 0;
		}catch(Exception e) {}
		
		return status;
	}
	
	public List<String> getDoctorListFromViewAuthorization() {
		List<String> drList = new ArrayList<>();
		List<WebElement> drElementList;
		try {
			drElementList = Locators.getInstance().getDoctorListFromViewAuth(driver);
			for (int i = 0; i < drElementList.size(); i++)
				drList.add(Keywords.getText(drElementList.get(i)));
		}catch(Exception e) {}
		
		return drList;
	}
	
	public List<String> getDoctorList() {
		List<WebElement> doctorElement;
		List<String> doctorList = new ArrayList<>();
		try {
			if (getDrListCount()) {
				doctorList = getDoctorListFromViewAuthorization();
			} else
				doctorList.add("You have no medical authorizations that meet the filter criteria");
		} catch (Exception e) {
		}

		return doctorList;
	}
}
