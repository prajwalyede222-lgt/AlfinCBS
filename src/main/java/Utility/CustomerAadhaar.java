package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CustomerAadhaar {

    private WebDriver driver;
    private static final Random random = new Random();

    @FindBy(id = "aadharNumber") WebElement aadharField;

    public CustomerAadhaar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to generate a unique Aadhaar number (12 digits)
    public String generateAadhaar() {
        StringBuilder aadhaar = new StringBuilder();

        // Aadhaar should not start with 0 or 1, usually starts from 2-9
        aadhaar.append(random.nextInt(8) + 2);

        // Generate remaining 11 digits
        for (int i = 0; i < 11; i++) {
            aadhaar.append(random.nextInt(10));
        }

        return aadhaar.toString();
    }

    // Method to send Aadhaar directly into the field
    public void enterUniqueAadhaar() {
        String uniqueAadhaar = generateAadhaar();
        aadharField.clear();
        aadharField.sendKeys(uniqueAadhaar);
        System.out.println("Entered Aadhaar: " + uniqueAadhaar);
    }
}