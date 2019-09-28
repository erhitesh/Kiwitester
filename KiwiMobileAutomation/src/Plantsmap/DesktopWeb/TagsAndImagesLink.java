package Plantsmap.DesktopWeb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class TagsAndImagesLink {

	private WebDriver driver;

	public TagsAndImagesLink(WebDriver driver) {
		this.driver = driver;
	}

	public String isLinkBroken(String linkUrl) {
		String response = "";
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				//System.out.println("Url..." + connection.getResponseMessage());
				response = connection.getResponseMessage();
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Anchor & Image have valid url",
						"PASS", "<b>Anchor & Image should not have null HREF & SRC</b>");
			} else if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				//System.out.println(linkUrl + " - " + connection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Anchor & Image not have valid url",
						"FAIL", "<b>Anchor & Image should not have null HREF & SRC</b>");
			}
			connection.disconnect();
		} catch (IOException e) {}
		return response;
	}

	public List<WebElement> getLinksAndImagesList() {
		List<WebElement> linkList = new ArrayList<>();
		try {
			Keywords.waitForPage(driver);
			linkList = Locators.getInstance().getAnchorLinkList(driver);
			linkList.addAll(Locators.getInstance().getImagesLinkList(driver));
		} catch (Exception e) {}

		return linkList;
	}

}
