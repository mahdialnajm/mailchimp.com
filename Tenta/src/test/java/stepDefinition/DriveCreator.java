package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriveCreator {

	public WebDriver createBrowser(String browser) {
		WebDriver driver;

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else  {
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		return driver;

	}

}
