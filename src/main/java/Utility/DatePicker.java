package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class DatePicker {

    private WebDriver driver;

    // Constructor
    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Selects a hardcoded date (2025-06-04) into the birthDate field using sendKeys.
     */
    public void selectDateMainInfo() {
        By dateFieldLocator = By.xpath("(//input[@id='birthDate'])[1]");
        WebElement dateInput = driver.findElement(dateFieldLocator);

        // Scroll into view to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateInput);

        // Optional: Remove 'readonly' if needed
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dateInput);

        // Clear and send date using sendKeys
        String hardcodedDate = "04-03-1997";  // format: yyyy-MM-dd
        dateInput.clear();
        dateInput.sendKeys(hardcodedDate);
        
        // Optional: blur to close calendar popup
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", dateInput);
    }
}
