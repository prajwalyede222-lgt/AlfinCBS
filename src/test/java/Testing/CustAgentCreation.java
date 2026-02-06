package Testing;

import org.testng.annotations.*;
import POJO.Browser;
import POM.CbsLoginPage;
import POM.CustomerCreation;
import Utility.CustomerAadhaar;
import Utility.CustomerPAN;
import Utility.DatePicker;
import Utility.FirstName;
import Utility.Parametrization;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CustAgentCreation  {
	WebDriver driver;

	@BeforeTest
	public void setupBrowser() {
		driver = Browser.openBrowser();
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		CbsLoginPage loginPage = new CbsLoginPage(driver);
		String username = Parametrization.getData(0, 1);
		String password = Parametrization.getData(1, 1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		Thread.sleep(1000); // Replace with wait if needed
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void MainIformation() throws InterruptedException {
		CustomerCreation customerPage = new CustomerCreation(driver);
		DatePicker datePicker = new DatePicker(driver);
		CustomerPAN customerPAN = new CustomerPAN(driver);
		CustomerAadhaar customerAadhaar = new CustomerAadhaar(driver);
		
		customerPage.openMenu();
		customerPage.clickMember();
		customerPage.openCustomerList();
		customerPage.clickCreateNewCustomer();

		String email = Parametrization.getData(2, 1);
		
		FirstName firstName = new FirstName(driver);
		firstName.enterRandomFirstName();
	//	String firstName = Parametrization.getData(3, 1);
		String middleName = Parametrization.getData(4, 1);
		String lastName = Parametrization.getData(5, 1);
		String fatherName = Parametrization.getData(6, 1);
		String ackNo = Parametrization.getData(7, 1);	
	
		String mobile = Parametrization.getData(10, 1);
		String guardian = Parametrization.getData(11, 1);
		String AgentSearch = Parametrization.getData(12, 1);
		
		

		customerPage.fillCustomerDetails(email,  middleName, lastName, fatherName, ackNo,
                mobile,guardian, AgentSearch);


		
		customerPAN.enterUniquePAN();
		customerAadhaar.enterUniqueAadhaar();

		customerPage.SelectAgent();
		
		datePicker.selectDateMainInfo();
        customerPage.selectAgentCheckbox();

		customerPage.clickSave();
		customerPage.Confirm();
		System.out.println("Main info saved");
	}

	
	@Test(priority = 3, dependsOnMethods = "MainIformation")
	public void Addressdetails() {
		CustomerCreation customerPage = new CustomerCreation(driver);

		for (int i = 1; i <= 3; i++) {
			customerPage.fillAddressSection("123 Main Street", "21", "Blue Apartments", "Pune", "411001", "INDIA",
					"MAHARASHTRA", "THANE", "VASAI");
			customerPage.ClickSave();
			System.out.println("address details saved" + i);
		}

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}
	
	

	@Test(priority = 4, dependsOnMethods = "MainIformation")
	public void Nominee() throws InterruptedException {
		CustomerCreation customerPage = new CustomerCreation(driver);
		customerPage.NomineeTab();
		System.out.println("Nominee details saved");
	}
/*
	@Test(priority = 5, dependsOnMethods = "Nominee")
	public void KYCDetail() throws InterruptedException {
		CustomerCreation customerPage = new CustomerCreation(driver);
		customerPage.KYCDetails();
		System.out.println("KYC details saved3");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		
	}
*/
	@Test(priority = 6)
	public void Payment() throws InterruptedException {
		CustomerCreation customerPage = new CustomerCreation(driver);
		customerPage.PaymentTab();
		System.out.println("Payment tab completed");
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);	
	}
	

	@Test(priority = 7, dependsOnMethods = "Payment")
	public void Approved() throws InterruptedException {
		CustomerCreation customerPage = new CustomerCreation(driver);
		customerPage.PendingTab();
		System.out.println("Approved successfully");

		
		Thread.sleep(5000);
		driver.quit();
	}
	

}
