package POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavingAccount {

    WebDriver driver;
    WebDriverWait wait;

    public SavingAccount(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // 🔹 First Customer ID (stable locator)
    @FindBy(xpath = "(//td[contains(@class,'table-details')])[1]")
    private WebElement firstCustomerId;

    // 🔹 Savings Account menu
    @FindBy(xpath = "//span[normalize-space()='Savings Account']")
    private WebElement savingsAccountMenu;

    // 🔹 Account Transaction option
    @FindBy(xpath = "//li//a[contains(text(),'Account Transaction')]")
    private WebElement accountTransaction;

    // 🔹 Search Customer ID input (case-safe)
    @FindBy(xpath = "//input[contains(@placeholder,'Search Customer')]")
    private WebElement searchCustomerIdInput;

    // ✅ Get first customer ID
    public String getFirstCustomerId() {

        wait.until(ExpectedConditions.visibilityOf(firstCustomerId));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", firstCustomerId);

        String id = firstCustomerId.getText().trim();
        System.out.println("DEBUG → Customer ID from table: " + id);

        if (id.toLowerCase().contains("no data")) {
            throw new RuntimeException("❌ No customer data found in table");
        }
        return id;
    }

  

    // ✅ Click Savings Account (safe click)
    public void clickSavingsAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(savingsAccountMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", savingsAccountMenu);

        savingsAccountMenu.click();
    }

    // ✅ Click Account Transaction (safe click)
    public void clickAccountTransaction() {

        wait.until(ExpectedConditions.elementToBeClickable(accountTransaction));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", accountTransaction);

        accountTransaction.click();
    }
    
  /*  public void SearchCustID() {

        accountTransaction.click();
    }*/
    
    // ✅ Search using customer ID
    public void searchByCustomerId(String customerId) {

        wait.until(ExpectedConditions.visibilityOf(searchCustomerIdInput));
        searchCustomerIdInput.clear();
        searchCustomerIdInput.sendKeys(customerId);
    }
    
}
