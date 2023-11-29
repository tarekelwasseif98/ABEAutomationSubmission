package utils;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebdriverFactory {
	public static WebDriver initiateWebDriver() throws MalformedURLException {
		EdgeOptions options = new EdgeOptions();
		System.setProperty("webdriver.edge.driver","msedgedriver.exe");
		WebDriver driver = new RemoteWebDriver(new URL(Properties.HUBURL), options);
		List<String> args = Arrays.asList("--proxy-server='direct://'", "--proxy-bypass-list=*","--disable-gpu");
		Map<String, Object> map = new HashMap<>();
		map.put("args", args);
		options.setCapability("ms:edgeOptions", map);
		driver.manage().window().maximize();
		return driver;
		}
	}