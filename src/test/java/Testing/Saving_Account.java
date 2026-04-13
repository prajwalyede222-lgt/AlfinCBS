package Testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.CbsLoginPage;
import POM.CustomerCreation;
import POM.SavingAccount;
import Utility.Parametrization;

public class Saving_Account {

    WebDriver driver;
    String customerId;

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
    public void mainInformation() {

        CustomerCreation customerPage = new CustomerCreation(driver);
        SavingAccount savingAccount = new SavingAccount(driver);

        customerPage.openMenu();
        customerPage.clickMember();
        customerPage.openCustomerList();

        customerId = savingAccount.getFirstCustomerId();
        System.out.println("Captured Customer ID: " + customerId);

        savingAccount.searchByCustomerId(customerId);
    }

    @Test(priority = 3, dependsOnMethods = "mainInformation")
    public void accountTransaction() {

        SavingAccount savingAccount = new SavingAccount(driver);

        savingAccount.clickSavingsAccount();
        savingAccount.clickAccountTransaction();
        savingAccount.searchByCustomerId(customerId);
    }
    
   
    @Test
    public void newtest() {
    	System.out.println("Hello words");;
    	
    }
}
