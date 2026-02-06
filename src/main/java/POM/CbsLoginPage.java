package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CbsLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- WebElements ----------

    @FindBy(xpath = "//input[@id='email']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'p-3.5') and contains(@class, 'bg-gray-200')]")
    private WebElement userIcon;

    @FindBy(xpath = "//div[contains(@class, 'group-hover:flex')]//span[contains(text(),'Log off')]")
    private WebElement logOffOption;
    
    // Error message element (login failure)
    @FindBy(xpath = "//div[contains(@class,'bg-red-500') and contains(.,'INVALID USERNAME OR PASSWORD')]")
    private WebElement loginErrorMsg;
    
   
    @FindBy(xpath = "(//button[normalize-space()='LOG OUT'])[1]")
    private WebElement logOut;
    
    

    // ---------- Constructor ----------

    public CbsLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ---------- Actions ----------

    public void enterUsername(String user) {
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickUserIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
    }

    public void clickLogOff() {
        wait.until(ExpectedConditions.visibilityOf(logOffOption));
        wait.until(ExpectedConditions.elementToBeClickable(logOffOption)).click();
    }

    //Get error message text
    public String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMsg));
        return loginErrorMsg.getText();
    }
    
    public void clickLogOutButton() {
    	logOut.click();
    }
}
