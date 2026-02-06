package Utility;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class FirstName {

    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    private static final String[] FIRST_NAMES = {
        "Aarav", "Rohan", "Vijay", "Rahul", "Amit",
        "Neha", "Pooja", "Kiran", "Sneha", "Anita"
    };

    private static final Random random = new Random();

    public FirstName(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String generateFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    public void enterRandomFirstName() {
        String firstName = generateFirstName();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        System.out.println("Entered First Name: " + firstName);
    }
}
