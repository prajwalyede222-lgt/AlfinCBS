package POJO;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	
	public static WebDriver openBrowser() {
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // ✅ Check path

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	//	options.addArguments("--force-dark-mode");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://alfinnext.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}
}
