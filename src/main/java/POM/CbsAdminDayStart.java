package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CbsAdminDayStart {

    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- WebElements ----------

    @FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between p-3.5')])[1]")
    private WebElement dashbord;

    @FindBy(xpath = "//a[@href='/vault']")
    private WebElement vault;

    @FindBy(xpath = "(//button[@class='cursor-pointer view-btn'])[1]")
    private WebElement ActionThane1;
    
    @FindBy(xpath = "(//button[@class='cursor-pointer view-btn'])[2]")
    private WebElement ActionThane2;
    @FindBy(xpath = "(//button[@class='cursor-pointer view-btn'])[3]")
    private WebElement ActionThane3;
    @FindBy(xpath = "(//button[@class='cursor-pointer view-btn'])[4]")
    private WebElement ActionThane4;
    @FindBy(xpath = "(//button[@class='cursor-pointer view-btn'])[5]")
    private WebElement ActionThane5;
    
    @FindBy(xpath = "//button[@class='btn-create text-xl']")
    private WebElement DayStart;
    @FindBy(xpath = "//button[text()='YES']")
    private WebElement Yes;

    // ---------- Constructor ----------

    public CbsAdminDayStart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ---------- Actions ----------

    public void clickDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashbord)).click();
    }

    public void clickVault() {
        wait.until(ExpectedConditions.visibilityOf(vault));
        wait.until(ExpectedConditions.elementToBeClickable(vault)).click();
    }
   
    public void Action1() {
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionThane1);

            // Move mouse away to avoid tooltip hover interference
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).perform();  // move mouse away
            Thread.sleep(300);  // short delay to let tooltip disappear

            // Click using JavaScript to avoid intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActionThane1);

        } catch (Exception e) {
            System.out.println("Failed to click ActionThane: " + e.getMessage());
        }
    }
    public void DayStart1() {
    	DayStart.click();
    }
    
    public void YesButton1() {
    	Yes.click();
    }
    
    
    public void Action2() {
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionThane2);

            // Move mouse away to avoid tooltip hover interference
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).perform();  // move mouse away
            Thread.sleep(300);  // short delay to let tooltip disappear

            // Click using JavaScript to avoid intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActionThane2);

        } catch (Exception e) {
            System.out.println("Failed to click ActionThane: " + e.getMessage());
        }
    }
    public void DayStart2() {
    	DayStart.click();
    }
    
    public void YesButton2() {
    	Yes.click();
    }
    public void Action3() {
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionThane3);

            // Move mouse away to avoid tooltip hover interference
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).perform();  // move mouse away
            Thread.sleep(300);  // short delay to let tooltip disappear

            // Click using JavaScript to avoid intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActionThane3);

        } catch (Exception e) {
            System.out.println("Failed to click ActionThane: " + e.getMessage());
        }
    }
    
    public void DayStart3() {
    	DayStart.click();
    }
    
    public void YesButton3() {
    	Yes.click();
    }
    public void Action4() {
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionThane4);

            // Move mouse away to avoid tooltip hover interference
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).perform();  // move mouse away
            Thread.sleep(300);  // short delay to let tooltip disappear

            // Click using JavaScript to avoid intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActionThane4);

        } catch (Exception e) {
            System.out.println("Failed to click ActionThane: " + e.getMessage());
        }
    }
    public void DayStart4() {
    	DayStart.click();
    }
    
    public void YesButton4() {
    	Yes.click();
    }
    public void Action5() {
        try {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionThane5);

            // Move mouse away to avoid tooltip hover interference
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).perform();  // move mouse away
            Thread.sleep(300);  // short delay to let tooltip disappear

            // Click using JavaScript to avoid intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActionThane5);

        } catch (Exception e) {
            System.out.println("Failed to click ActionThane: " + e.getMessage());
        }
    }
    
    
    public void DayStart5() {
    	DayStart.click();
    }
    
    public void YesButton5() {
    	Yes.click();
    }
}
