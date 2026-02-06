package Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.CbsLoginPage;
import Utility.Parametrization;

public class LoginPageCBS {

	WebDriver driver;

	@BeforeTest
	public void browser() {
		driver = Browser.openBrowser();
	}

	@Test(priority = 3)
	public void EnterValidCredential() throws InterruptedException {
		CbsLoginPage cbsloginpage = new CbsLoginPage(driver);

		String username = Parametrization.getData(0, 1);
		String password = Parametrization.getData(1, 1);

		cbsloginpage.enterUsername(username);
		cbsloginpage.enterPassword(password);
		cbsloginpage.clickLogin();
		cbsloginpage.clickUserIcon();
		cbsloginpage.clickLogOff();
		cbsloginpage.clickLogOutButton();
		Thread.sleep(3000);
	}

	@Test(priority = 0)
	public void EnterInValidCredential() throws InterruptedException {
		CbsLoginPage cbsloginpage = new CbsLoginPage(driver);

		String username = Parametrization.getData(2, 1);
		String password = Parametrization.getData(3, 1);

		cbsloginpage.enterUsername(username);
		cbsloginpage.enterPassword(password);
		cbsloginpage.clickLogin();

		

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void InvalidUsername() throws InterruptedException {
		CbsLoginPage cbsloginpage = new CbsLoginPage(driver);

		String username = Parametrization.getData(4, 1);
		String password = Parametrization.getData(5, 1);

		cbsloginpage.enterUsername(username);
		cbsloginpage.enterPassword(password);
		cbsloginpage.clickLogin();

		

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void InvalidPassword() throws InterruptedException {
		CbsLoginPage cbsloginpage = new CbsLoginPage(driver);

		String username = Parametrization.getData(6, 1);
		String password = Parametrization.getData(7, 1);

		cbsloginpage.enterUsername(username);
		cbsloginpage.enterPassword(password);
		cbsloginpage.clickLogin();
		
		/*WebElement errorMsgElement = driver.findElement(By.xpath("//div[contains(@class,'bg-red-500') and contains(.,'INVALID USERNAME OR PASSWORD')]"));
		String actualMessage = errorMsgElement.getText();

		String expectedMessage = "INVALID USERNAME OR PASSWORD"; // not matching actual

		System.out.println("Actual Message: " + actualMessage);
		System.out.println("Expected Message: " + expectedMessage);

		// Assertion: Will FAIL if messages don't match
		Assert.assertEquals(actualMessage, expectedMessage, "INVALID USERNAME OR PASSWORD");

		*/
		try {
		    Thread.sleep(2000); // Give toast time to load

		    List<WebElement> toasts = driver.findElements(By.xpath("//*[contains(text(),'INVALID USERNAME OR PASSWORD')]"));
		    if (!toasts.isEmpty()) {
		        String actualMessage = toasts.get(0).getText().trim().replace("×", "").trim();
		        String expectedMessage = "INVALID USERNAME OR PASSWORD";

		        System.out.println("Actual Message: " + actualMessage);
		        System.out.println("Expected Message: " + expectedMessage);

		        Assert.assertEquals(actualMessage, expectedMessage, "Toast message does not match!");
		    } else {
		        Assert.fail("Toast message not found.");
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		Thread.sleep(3000);

	}
	
	@AfterMethod
	public void refreshPage() {
		driver.navigate().refresh();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
