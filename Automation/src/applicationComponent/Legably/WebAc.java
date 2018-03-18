package applicationComponent.Legably;

import java.util.List;

import org.testng.annotations.Test;

import com.session.DriverSession;
import com.utilities.GlobalParam;

import action.Legably.WebAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;

@Test
public class WebAc extends AppComponent implements ApplicationComponent {
	private WebAction action = new WebAction(DriverSession.getLastExecutionDriver());

	@Override
	public void openApplication() throws Exception {
		GlobalParam.url = DriverSession.getTestCaseData().get("URL");
		action.openBrowser(GlobalParam.url);
	}

	@Override
	public void closeApplication() {
		action.closeBrowser();
	}

	@Override
	public void validateHomePage() {

	}
	
	public List<String> signUp() {
		List<String> info;
		info = action.signUp();
		return info;
	}

	public void signUpTest() {
		List<String> info = signUp();
		action.verifyFNameOnInfoPage(info.get(0));
		action.verifyLNameOnInfoPage(info.get(1));
		action.fillBasicInfoPlusEducation();
	}
	
	public void validateForms() {
		String userName = "";
		userName = action.login();
		String firstName = userName.substring(0, userName.indexOf(" "));
		String lastName = userName.substring(userName.indexOf(" ")+1);
		action.verifyFNameOnInfoPage(firstName);
		action.verifyLNameOnInfoPage(lastName);
		action.fillBasicInfoPlusEducation();
		action.experienceInfo();
		action.networkInfo();
		action.verifyCityNameOnJobTypePage("Noida");
		action.verifyStateNameOnJobTypePage("California");
		action.jobType();
	}
}
