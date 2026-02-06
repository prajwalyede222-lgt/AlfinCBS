package POM;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class CustomerCreation {

    private WebDriver driver;
    private WebDriverWait wait;

    // Static elements (unlikely to change)
    @FindBy(xpath = "(//*[name()='svg'][contains(@stroke,'currentColor')])[1]")
    WebElement menuIcon;

    @FindBy(xpath = "(//span[normalize-space()='Member'])[1]")
    WebElement memberMenu;

    @FindBy(xpath = "//a[normalize-space()='Customer List']")
    WebElement customerList;

    @FindBy(xpath = "(//button[normalize-space()='CREATE NEW CUSTOMER'])[1]")
    WebElement createCustomerBtn;

    // Fields
    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "firstName") WebElement firstNameField;
    @FindBy(id = "middleName") WebElement middleNameField;
    @FindBy(id = "lastName") WebElement lastNameField;
    @FindBy(id = "fatherHusbandName") WebElement fatherNameField;
    @FindBy(id = "formSixtyAckgNo") WebElement ackNoField;
    @FindBy(id = "panNumber") WebElement panField;
    @FindBy(id = "aadharNumber") WebElement aadharField;
    @FindBy(id = "mobileNumber") WebElement mobileField;
    @FindBy(id = "guardianName") WebElement guardianNameField;
    @FindBy(xpath = "(//input[@class='customInput'])[1]") WebElement Agent;
    @FindBy(xpath = "//td[normalize-space()='RAJESH']") WebElement SelectAgent;
    @FindBy(xpath = "(//button[normalize-space()='PROCEED'])[1]") WebElement PROCEED;
    @FindBy(id = "isAgent") WebElement agentCheckbox;
    @FindBy(xpath = "(//button[@type='submit'])[1]") WebElement saveBtn;

    // Address
    @FindBy(xpath = "(//input[@placeholder='Enter Address'])[1]") WebElement addressLineField;
    @FindBy(xpath = "(//input[@name='houseNumber'])[1]") WebElement houseNoField;
    @FindBy(xpath = "(//input[@placeholder='Enter Name'])[1]") WebElement areaBuildingNameField;
    @FindBy(xpath = "(//input[@placeholder='Enter City'])[1]") WebElement cityField;
    @FindBy(xpath = "(//input[@placeholder='Enter Zip Code'])[1]") WebElement pinCodeField;
    @FindBy(xpath = "(//select[@name='countryToAddress'])[1]") WebElement countryDropdown;
    @FindBy(xpath = "//select[@name='stateToAddress']") WebElement stateDropdown;
    @FindBy(xpath = "(//select[@name='districtToAddress'])[1]") WebElement districtDropdown;
    @FindBy(xpath = "(//select[@name='talukaToAddress'])[1]") WebElement talukaDropdown;
    @FindBy(xpath = "(//button[@type='submit'])[2]") WebElement saveBtn2;

    // Nominee
    @FindBy(xpath = "//li[contains(text(), 'NOMINEE DETAILS')]") WebElement NomineeTab;
    @FindBy(xpath = "//input[@placeholder='Enter Name']") WebElement NomineeName;
    @FindBy(xpath = "(//select[@name='relationMasterId'])[1]") WebElement NomineeRelation;
    @FindBy(xpath = "(//select[@name='gender'])[1]") WebElement Gender;
    @FindBy(xpath = "(//input[@placeholder='Enter Guardian Name'])[1]") WebElement guardianName;
    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]") WebElement NomineeSaved;

    // KYC
    @FindBy(xpath = "//li[text()='KYC DETAILS']") WebElement KYCTab;
    @FindBy(xpath = "(//input[@name='kycProfileRequest'])[1]") WebElement profileImageUpload;
    @FindBy(xpath = "(//input[@type='file'])[2]") WebElement signatureUpload;
    @FindBy(xpath = "(//input[@placeholder='Enter ID Proof Number'])[1]") WebElement idProofNumber;
    @FindBy(xpath = "//input[@placeholder='Enter Place of Issue']") WebElement placeOfIssue;
    @FindBy(xpath = "//input[@placeholder='Enter Address Proof Number']") WebElement addressProofNumber;
    @FindBy(xpath = "(//input[@name='kycIdProofRequest'])[1]") WebElement uploadIDProof;
    @FindBy(xpath = "(//input[@name='kycAddressProofRequest'])[1]") WebElement uploadAddressProof;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Upload'])[1]") WebElement upload1;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Upload'])[2]") WebElement upload2;
    @FindBy(xpath = "//div[8]//button[1]") WebElement upload3;
    @FindBy(xpath = "//div[9]//button[1]") WebElement upload4;
    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]") WebElement KYCSaveButton;
    @FindBy(xpath = "//input[@placeholder='Enter Remarks']") WebElement remarks;
    
     // payments
    
    @FindBy(xpath = "//li[contains(text(), 'PENDING')]") WebElement PendingTab;
    @FindBy(xpath = "//select[@id='paymentType']") WebElement paymentMode;
   
    @FindBy(xpath = "//select[@id='status']") WebElement TransactionStatus;
    @FindBy(xpath = "//select[@id='category']") WebElement PaymentStatus;

    

    public CustomerCreation(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openMenu() { menuIcon.click(); }
    
    public void clickMember() { memberMenu.click(); }
    public void openCustomerList() { customerList.click(); }
    public void clickCreateNewCustomer() { createCustomerBtn.click(); }
    //String firstName

    public void fillCustomerDetails(String email, String middleName,
                                    String lastName, String fatherName, String ackNo,
                                     String mobile,
                                    String guardian, String AgentSearch) {
        emailField.sendKeys(email);
      //  firstNameField.sendKeys(firstName);
        middleNameField.sendKeys(middleName);
        lastNameField.sendKeys(lastName);
        fatherNameField.sendKeys(fatherName);
        ackNoField.sendKeys(ackNo);
        
        mobileField.sendKeys(mobile);
        guardianNameField.sendKeys(guardian);
        Agent.sendKeys(AgentSearch);
    }
    public void SelectAgent() {
        SelectAgent.click();
    }
    
    public void selectAgentCheckbox() {
        if (!agentCheckbox.isSelected()) {
            agentCheckbox.click();
        }
    }

    public void clickSave() {
        try {
            saveBtn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
        }
    }

    public void Confirm() { PROCEED.click(); }

    public void fillAddressSection(String addressLine, String houseNo, String areaName, String city,
                                   String pinCode, String country, String state, String district, String taluka) {
        addressLineField.sendKeys(addressLine);
        houseNoField.sendKeys(houseNo);
        areaBuildingNameField.sendKeys(areaName);
        cityField.sendKeys(city);
        pinCodeField.sendKeys(pinCode);

        new Select(countryDropdown).selectByVisibleText(country);
        wait.until(ExpectedConditions.textToBePresentInElement(stateDropdown, state));
        new Select(stateDropdown).selectByVisibleText(state);

        wait.until(ExpectedConditions.textToBePresentInElement(districtDropdown, district));
        new Select(districtDropdown).selectByVisibleText(district);

        wait.until(ExpectedConditions.textToBePresentInElement(talukaDropdown, taluka));
        new Select(talukaDropdown).selectByVisibleText(taluka);
    }

    public void ClickSave() { saveBtn2.click(); }

    public void NomineeTab() throws InterruptedException {
        NomineeTab.click();
        NomineeName.sendKeys("Prajwal");
        new Select(NomineeRelation).selectByVisibleText("SON");

        WebElement dateInput = driver.findElement(By.xpath("(//input[@name='nomineeBirthDate'])[1]"));

        // Optional: Remove 'readonly' if present
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dateInput);

        // Clear and send the date in proper format
        dateInput.clear();
        dateInput.sendKeys("04-03-1997");

        Thread.sleep(2000); // or use explicit wait if needed

        new Select(Gender).selectByVisibleText("Male");

        NomineeSaved.click();
    }

    public void KYCDetails() throws InterruptedException {
        KYCTab.click();
        profileImageUpload.sendKeys("C:\\Users\\admin\\Desktop\\PRAJWAL\\image (5).png");
        upload1.click();
        
        signatureUpload.sendKeys("C:\\Users\\admin\\Desktop\\PRAJWAL\\image (5).png");      
         upload2.click();
         
        idProofNumber.sendKeys("789098765432");
        placeOfIssue.sendKeys("New india");
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        addressProofNumber.sendKeys("456789876545");
        
        uploadIDProof.sendKeys("C:\\Users\\admin\\Desktop\\PRAJWAL\\image (5).png");
        upload3.click();
        
        
        uploadAddressProof.sendKeys("C:\\Users\\admin\\Desktop\\PRAJWAL\\image (5).png");               
        upload4.click();
        
        Thread.sleep(5000);
        
        KYCSaveButton.click();
      
        
    }
    private void uploadFile(WebElement element, String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            element.sendKeys(file.getAbsolutePath());
        } else {
            throw new RuntimeException("❌ File not found: " + file.getAbsolutePath());
        }
    }


    public void PaymentTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate the tab
        WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//li[text()='PAYMENT DETAILS']")));

        // Scroll it into view to avoid overlap
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", tab);

        // Wait to allow any overlapping element (e.g., animation/header) to disappear
        Thread.sleep(1000); // Optional, can be removed once stable

        // Click using JS to avoid ElementClickInterceptedException
        js.executeScript("arguments[0].click();", tab);

        // Fill remarks
      
       /* WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='2025-08-06']")));
        dateInput.clear(); // Clear the existing value
        dateInput.sendKeys("09-08-2025"); // Send new date   */
        Select dropdown = new Select(paymentMode);
        dropdown.selectByValue("CASH"); // select by value attribute
        
        remarks.sendKeys("reason");

        // Submit
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[normalize-space()='SUBMIT']")));
        submit.click();
        
        Thread.sleep(3000);
        
     
    }
    public void PendingTab() throws InterruptedException {
        try {
        	
            	PendingTab.click(); 
            // Click the eye icon (view button)
            WebElement eye = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[@class='cursor-pointer view-btn'])[1]")));
            eye.click();
            
       

            // Click on the 'PAYMENT DETAILS' tab
            WebElement pendingTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='PAYMENT DETAILS']")));
            pendingTab.click();
            
           

            // Scroll to Transaction Status dropdown
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", TransactionStatus);

            // Enable Transaction Status dropdown if disabled
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('disabled');", TransactionStatus);

            // Small wait for dropdown to become usable
           

            // Select 'CLEARED'
            new Select(TransactionStatus).selectByVisibleText("CLEARED");

           // Enable Payment Status dropdown if disabled
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('disabled');", PaymentStatus);

            // Small wait for dropdown to become usable
            Thread.sleep(2000);

            // Select 'COMPLETED'
            new Select(PaymentStatus).selectByVisibleText("COMPLETED");

            // Small wait to allow UI to react
            Thread.sleep(3000);
            
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

            // Wait for Approve button to appear
            WebElement approvedButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[normalize-space()='APPROVE']")));

            // Scroll to the Approve button
            Thread.sleep(3000);

            // Enable Approve button if disabled
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('disabled');", approvedButton);

            // Wait for it to be clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(approvedButton)).click();

        } catch (StaleElementReferenceException e) {
            System.out.println("Retrying due to stale element...");
            PendingTab(); // retry
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   



} 
