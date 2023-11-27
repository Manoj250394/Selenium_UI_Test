package usingtestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestOne {
	RemoteWebDriver driver;
	public static final String USERNAME="oauth-manoj.gs2534-477f8";
	public static final String ACCESS_KEY="dad2ca02-ec68-4045-99c5-902dae9c93bd";
	public static final String URL="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	@BeforeSuite
	public void setUP() throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-manoj.gs2534-477f8");
		sauceOptions.put("accessKey", "dad2ca02-ec68-4045-99c5-902dae9c93bd");
		sauceOptions.put("build", "selenium-build-LFUAY");
		sauceOptions.put("name", "trial1");
		browserOptions.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new RemoteWebDriver(url, browserOptions);
	}
	
	@BeforeMethod
	public void lauchBrowser() {
		driver.get("https://leafground.com/");
	}
	
	@Test
	public void verifyHomePage() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Dashboard");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}
