package Testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.CbsAdminDayStart;
import POM.CbsLoginPage;
import Utility.Parametrization;

public class CbsAdminDayStart1 {

	WebDriver driver;
	CbsLoginPage cbsLoginPage;
	CbsAdminDayStart cbsAdminDayStart;

	@BeforeTest
	public void browser() {
		driver = Browser.openBrowser();
		cbsLoginPage = new CbsLoginPage(driver);
		cbsAdminDayStart = new CbsAdminDayStart(driver);
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		String username = Parametrization.getData(0, 1);
		String password = Parametrization.getData(1, 1);

		cbsLoginPage.enterUsername(username);
		cbsLoginPage.enterPassword(password);
		cbsLoginPage.clickLogin();

		// Navigate to Vault after login
		cbsAdminDayStart.clickDashboard();
		cbsAdminDayStart.clickVault();

		// Assert login or vault visible (optional, depends on your app's confirmation)
		// Assert.assertTrue(cbsAdminDayStart.isVaultVisible());
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void testDayStartAction2() throws InterruptedException {
		cbsAdminDayStart.Action2();
		Thread.sleep(2000); // Replace with wait if needed
		cbsAdminDayStart.DayStart2();
		cbsAdminDayStart.YesButton2();
		System.out.println("Action 2 Completed: " + driver.getCurrentUrl());
		driver.navigate().back();
	}

	@Test(priority = 3, dependsOnMethods = "loginTest")
	public void testDayStartAction3() throws InterruptedException {
		cbsAdminDayStart.Action3();
		Thread.sleep(2000);
		cbsAdminDayStart.DayStart3();
		cbsAdminDayStart.YesButton3();
		System.out.println("Action 3 Completed: " + driver.getCurrentUrl());
		driver.navigate().back();
	}

	@Test(priority = 4, dependsOnMethods = "loginTest")
	public void testDayStartAction4() throws InterruptedException {
		cbsAdminDayStart.Action4();
		Thread.sleep(2000);
		cbsAdminDayStart.DayStart4();
		System.out.println("Action 4 Completed: " + driver.getCurrentUrl());
		driver.navigate().back();
	}

	@Test(priority = 5, dependsOnMethods = "loginTest")
	public void testDayStartAction5() throws InterruptedException {
		cbsAdminDayStart.Action5();
		Thread.sleep(2000);
		cbsAdminDayStart.DayStart5();
		System.out.println("Action 5 Completed: " + driver.getCurrentUrl());
		driver.navigate().back();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
