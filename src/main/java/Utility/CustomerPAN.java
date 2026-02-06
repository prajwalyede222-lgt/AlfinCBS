package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CustomerPAN {

    private WebDriver driver;
    private static final String PAN_PREFIX = "ABCDE"; // First 5 letters
    private static final Random random = new Random();

    @FindBy(id = "panNumber")
    private WebElement panField;

    public CustomerPAN(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to generate PAN
    public String generatePAN() {
        StringBuilder pan = new StringBuilder(PAN_PREFIX);

        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10));
        }

        // Append last letter
        char lastLetter = (char) ('A' + random.nextInt(26));
        pan.append(lastLetter);

        return pan.toString();
    }

    // Method to send PAN directly into the field
    public void enterUniquePAN() {
        String uniquePAN = generatePAN();
        panField.clear();
        panField.sendKeys(uniquePAN);
        System.out.println("Entered PAN: " + uniquePAN);
    }
}